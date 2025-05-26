package principal;

import menu.UsuarioMenu;

public class Main {
    public static void main(String[] args) {
        //Llamamos a la clase donde tiene el menu de usuarios
        UsuarioMenu menu = new UsuarioMenu();
        menu.iniciarMenu();
    }
}