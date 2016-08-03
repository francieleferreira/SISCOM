package siscom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class ItensVenda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long     idItensVenda;
	private Venda    venda;
	private Produto  produto;
	private int      quantidade;
	private double   valorUnitario;
	@Id
	@GeneratedValue
	@Column(name="id_itens_venda")
	public long getIdItensVenda() {
		return idItensVenda;
	}
	public void setIdItensVenda(long idItensVenda) {
		this.idItensVenda = idItensVenda;
	}
	@ManyToOne
	@JoinColumn(name="id_venda")
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	@ManyToOne
	@JoinColumn(name="id_produto")
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idItensVenda ^ (idItensVenda >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensVenda other = (ItensVenda) obj;
		if (idItensVenda != other.idItensVenda)
			return false;
		return true;
	}
	
	
}
