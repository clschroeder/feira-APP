package dao;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Produto;

/**
 * @author fsens
 */
public class ProdutoDAO implements AcaoDAO<Produto> {

    @Override
    public ArrayList<Produto> retornarTodos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos;";
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            try {
                Statement statement = conexao.createStatement();
                statement.execute(sql);
                ResultSet resultado = statement.getResultSet();
                while (resultado.next()) {
                    Produto produto = new Produto();
                    produto.setCodigo(resultado.getInt("id"));
                    produto.setNome(resultado.getString("nome"));
                    produto.setDisponivel(resultado.getBoolean("disponivel"));
                    produto.setTipo(resultado.getString("tipo"));
                    produto.setPeso(resultado.getFloat("peso"));
                    produto.setValidade(resultado.getDate("validade"));
                    produtos.add(produto);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
        return produtos;

    }

    @Override
    public int inserir(Produto objeto) {
        String sql = "INSERT INTO produtos "
                + "\n(nome, tipo, peso, validade, disponivel)"
                + "\nVALUES(?,?,?,?,?);";
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            try {
                PreparedStatement substituidor = conexao
.preparedStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                substituidor.setString(1, objeto.getNome());
                substituidor.setString(2, objeto.getTipo());
                substituidor.setFloat(3, objeto.getPeso());
                substituidor.setDate(4, objeto.getValidade());
                substituidor.setBoolean(5, objeto.isDisponivel());
                substituidor.execute();
                
                ResultSet resultado = substituidor.getGeneratedKeys();
                if(resultado.next()){
                    return resultado.getInt(1);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
        return 0;
    }

    @Override
    public int alterar(Produto objeto) {
        String sql = "UPDATE produtos SET"
                + "\nnome = ?,"
                + "\ntipo = ?,"
                + "\npeso = ?,"
                + "\nvalidade = ?,"
                + "\ndisponivel = ?"
                + "\nWHERE id = ?";
        
        Connection conexao = Conexao.conectar();
        if(conexao != null){
        try{
            PreparedStatement alterador = conexao.prepareStatement(sql);
            alterador.setString(1, objeto.getNome());
            alterador.setString(2, objeto.getTipo());
            alterador.setFloat(3, objeto.getPeso());
            alterador.setDate(4, objeto.getValidade());
            alterador.setBoolean(5, objeto.isDisponivel());
            alterador.setInt(6, objeto.getCodigo());
            alterador.executeUpdate();
        }catch (SQLException e){e.printStackTrace();
        }finally{Conexao.desconectar();          
        }
            
        }
        
        
        
        
        
        return 0;

    }

    @Override
    public int excluir(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        Connection conexao = Conexao.conectar();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }

        return 0;
    }

    @Override
    public Produto buscarPorId(int id) {
        Produto produto = null;
        String sql = "SELECT *FROM produtos WHERE id= ?";
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            try {
                PreparedStatement colocador = conexao.prepareStatement(sql);
                colocador.setInt(1, id);
                colocador.execute();
                ResultSet resultado = colocador.getResultSet();
                if (resultado.next()) {
                    produto = new Produto();
                    produto.setCodigo(resultado.getInt("id"));
                    produto.setNome(resultado.getString("nome"));
                    produto.setDisponivel(resultado.getBoolean("disponivel"));
                    produto.setTipo(resultado.getString("tipo"));
                    produto.setPeso(resultado.getFloat("peso"));
                    produto.setValidade(resultado.getDate("validade"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }

        }
        return produto;
    }
}
