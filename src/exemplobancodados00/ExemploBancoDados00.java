
package exemplobancodados00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author 65316 - DARLAN RADAMÉS CONTE POFFO
 */
public class ExemploBancoDados00 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
           Connection conexao = DriverManager
                   .getConnection("jdbc:mysql://localhost:3306/exemplo_01", "root", ""); 
           
           String nome = JOptionPane.showInputDialog("Digite o nome");
           String cpf = JOptionPane.showInputDialog("Digite o CPF");
           
//         inserir registro na tabela de clientes
//         PreparedStatement ps = conexao.prepareStatement(
//                 "INSERT INTO clientes (nome, cpf) VALUES (?, ?)"); 
//         ps.setString(1, nome);
//         ps.setString(2, cpf);
//         ps.execute();
            
//         alterar registro na tabela de cliente
//         PreparedStatement ps = conexao.prepareStatement(
//                 "UPDATE CLIENTES SET nome = ?, cpf = ? WHERE id = ?");
//         ps.setString(1, nome);
//         ps.setString(2, cpf);
//         ps.setInt(3, 2);
//         int quantidadeAlterada = ps.executeUpdate();
//           
//         if (quantidadeAlterada== 1){
//             JOptionPane.showMessageDialog(null, "Alterado com sucesso");
//         } else {
//             JOptionPane.showMessageDialog(null, "Nenhum registro foi alterado");
//         }
           
//         apagar registro na tabela do clliente
//         PreparedStatement ps = conexao.prepareStatement("delete from clientes where id = ?");
//           
//           int id = 2;
//           ps.setInt(1, id);
//           int quantidadeAfetada = ps.executeUpdate();
//           JOptionPane.showMessageDialog(null, quantidadeAfetada == 1 ? "Apagou com sucesso" : "Nao foi possivel apagar");

            Statement st = conexao.createStatement();
            st.execute("SELECT * FROM clientes");
            
            ResultSet tabelaEmMemoria = st.getResultSet();
            while (tabelaEmMemoria.next()){
                String nomeCliente = tabelaEmMemoria.getString("nome");
                System.out.println(nomeCliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
}
