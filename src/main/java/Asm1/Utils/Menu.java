package Asm1.Utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    private String name; //Menu Name
    private int nOptions; //Number of option in the menu
    private Map<Integer, Trio> options; //Map with all option. The key is the id (appearance order) of the option
    private List<String> data; //A list of lines to be presented before the options

    public Menu(String newName) {
        this.name = newName;
        this.nOptions = 1;
        this.options = new HashMap<>();
        this.data = new ArrayList<>();
    }


    public void start() {

        String header = "*" + name + "*\n";

        //Body
        StringBuilder body = new StringBuilder();
        //Options
        for (int j = 1; j <= this.options.size(); j++) {
            if (this.options.containsKey(j)) {
                Trio trio = this.options.get(j);
                body.append("  ");
                if (trio.getSettings() != null) {
                    for (String str : trio.getSettings()) {
                        if (!str.equals("exit")) {
                            body.append(str);
                        }
                    }
                }
                body.append(j).append(")     ").append(trio.getName()).append("\u001B[0m\n");
            }
        }

        //Option exit, if exists
        if (this.options.containsKey(0)) {
            Trio trio = this.options.get(0);
            body.append("  ");
            for (String str : trio.getSettings()) {
                if (!str.equals("exit")) {
                    body.append(str);
                }
            }
            body.append("0)     ").append(trio.getName()).append("\u001B[0m\n");
        }

        System.out.print(header + body.toString());

        //Scanner
        Scanner in = new Scanner(System.in);
        int op = -1;

        while (op == -1) {
            System.out.print("$ ");
            try {

                String value = in.nextLine();
                op = Integer.parseInt(value);

                if (!this.options.containsKey(op)) {
                    throw new NumberFormatException();
                }
                this.options.get(op).getCallback().run();
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input");
                continue;
            }
        }
    }

    public void addOption(String name, CallBack callBack) {
        Trio trio = new Trio(name, null, callBack);
        this.options.put(this.nOptions, trio);
        this.nOptions++;
    }

    public void clear() {
        this.nOptions = 1;
        this.options.clear();
        this.data.clear();
    }

    /**
     * Interface that permites to create an Callback to each option of the Menu
     */
    public interface CallBack {
        /**
         * Method that will run when an option is chosen
         */
        void run();
    }

    /**
     * Custom tuple to store an option name, list of settings and callback.
     */
    static class Trio {
        private final String name; //Option name
        private final List<String> settings; //Option appearance settings
        private final CallBack callback; //Option callback

        /**
         * Constructor that create Trio object, representing an option with a name, settings and callback
         *
         * @param newName      Option name
         * @param newSettings  Option appearence settings
         * @param newCallbacks Option callback
         */
        Trio(String newName, List<String> newSettings, CallBack newCallbacks) {
            this.name = newName;
            this.settings = newSettings;
            this.callback = newCallbacks;
        }

        /**
         * Gets the name of the Option
         *
         * @return name of the option
         */
        String getName() {
            return this.name;
        }

        /**
         * Gets the appearance settings of an option
         *
         * @return A list of appearance settings
         */
        List<String> getSettings() {
            return this.settings;
        }

        /**
         * Gets the option callback
         *
         * @return A Callback implemented object with the callback
         */
        CallBack getCallback() {
            return this.callback;
        }
    }
}