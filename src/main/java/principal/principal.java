package principal;

import conexao.Conexao;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.LoginView;

public class principal {
    
    Conexao objconexao;
    LoginView loginview;

    public principal() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            objconexao = new Conexao();

            loginview = new LoginView();
            loginview.setVisible(true);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException erro) {
            JOptionPane.showMessageDialog(null, "Por motivos inesperados não foi possível abrir o sistema\n"
                    + erro.getMessage(), "Menssagem", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        principal mvc_dao = new principal();
    }
}
