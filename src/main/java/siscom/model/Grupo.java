package siscom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Grupo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long    idGrupo;
	private String  descricao;
	
	@Id
	@GeneratedValue
	@Column(name="id_grupo")
	public long getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(long idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idGrupo ^ (idGrupo >>> 32));
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
		Grupo other = (Grupo) obj;
		if (idGrupo != other.idGrupo)
			return false;
		return true;
	}
	
	
}
