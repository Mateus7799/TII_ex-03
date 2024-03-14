package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Produto {
    private int id;
    private String descricao;
    private float preco;
    private int quantidade;
    private LocalDateTime dataFabricacao;
    private LocalDate dataValidade;

    public Produto() {
        id = -1;
        descricao = "";
        preco = 0.00F;
        quantidade = 0;
        dataFabricacao = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        dataValidade = LocalDate.now().plusMonths(6); // O default é uma validade de 6 meses.
    }

    public Produto(int id, String descricao, float preco, int quantidade, LocalDateTime fabricacao, LocalDate validade) {
        setId(id);
        setDescricao(descricao);
        setPreco(preco);
        setQuantidade(quantidade);
        setDataFabricacao(fabricacao);
        setDataValidade(validade);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if (preco >= 0) {
            this.preco = preco;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        }
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public LocalDateTime getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDateTime dataFabricacao) {
        // Garante que a data de fabricação não pode ser futura
        if (!dataFabricacao.isAfter(LocalDateTime.now())) {
            this.dataFabricacao = dataFabricacao.truncatedTo(ChronoUnit.SECONDS);
        }
    }

    public void setDataValidade(LocalDate dataValidade) {
        // A data de validade deve ser posterior à data de fabricação
        if (dataValidade.isAfter(dataFabricacao.toLocalDate())) {
            this.dataValidade = dataValidade;
        }
    }

    public boolean emValidade() {
        return LocalDate.now().isBefore(this.getDataValidade());
    }

    @Override
    public String toString() {
        return "Produto: " + descricao + "   Preço: R$" + preco + "   Quantidade.: " + quantidade + "   Fabricação: "
                + dataFabricacao + "   Data de Validade: " + dataValidade;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.getId() == ((Produto) obj).getId());
    }
}
