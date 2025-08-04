package com.danielmacedo.supermercado_api.dto;

public class ProdutoDTO {
    private Integer _id;
    private String _nome;
    private Double _preco;
    private Integer _volumeMl;
    private String _validade;
    private Integer _garantiaMeses;
    private String _indicacao;
    private String _tipoProduto;
    private String _tipoProdutoClasse;

    public ProdutoDTO() {}

    public Integer getId() {return _id;}
    public void setId(Integer id) {_id = id;}

    public String getNome() {return _nome;}
    public void setNome(String nome) {_nome = nome;}

    public Double getPreco() {return _preco;}
    public void setPreco(Double preco) {_preco = preco;}

    public Integer getVolumeMl() {return _volumeMl;}
    public void setVolumeMl(Integer volumeMl) {_volumeMl = volumeMl;}

    public String getValidade() {return _validade;}
    public void setValidade(String validade) {_validade = validade;}

    public Integer getGarantiaMeses() {return _garantiaMeses;}
    public void setGarantiaMeses(Integer garantiaMeses) {_garantiaMeses = garantiaMeses;}

    public String getIndicacao() {return _indicacao;}
    public void setIndicacao(String indicacao) {_indicacao = indicacao;}

    public String getTipoProduto() {return _tipoProduto;}
    public void setTipoProduto(String tipoProduto) {_tipoProduto = tipoProduto;}

    public String getTipoProdutoClasse() {return _tipoProdutoClasse;}
    public void setTipoProdutoClasse(String tipoProdutoClasse) {_tipoProdutoClasse = tipoProdutoClasse;}
}
