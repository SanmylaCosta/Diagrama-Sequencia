import java.util.List;
package domain;

public class Pedido{
    private List<LinhaDePedido>itens;

    private Cliente cliente;

    public Double calcularPreco(){
        Double precofinal = 0.0;


        for(LinhaDePedido linha:itens){
            Integer quantidade = linha.obterQuantidade();
            Produto produto = linha.obterProduto();
            Double preco = produto.obterDetalhesPreco();
            Double precoBase = calcularPrecoBase(quantidade,preco);
            Double precoComDesconto = calcularDescontos(precoBase);
            precofinal += precoComDesconto;
        }
        return precofinal;
    }

    private Double calcularDescontos(Double precoBase){
        Double percentualDesconto = cliente.ObterInformacaoDesconto();
        return precoBase - (precoBase * percentualDesconto);
    }

    private Double calcularPrecoBase(Integer quantidade, Double preco){
        return quantidade*preco;
    }
}