package br.jonatas.hub.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity(name = "exchange")
public class Exchange implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "from_currency", nullable = false, length = 3)
	private String from;

	@Column(name = "to_currency", nullable = false)
	private String to;
	
	@Column(name = "conversion_factor", nullable = false)
	private BigDecimal conversionFactory;
	
	@Transient
	private String enviroment;

	@Transient
	private BigDecimal convertedValue;

	public Exchange() {
	}

	public Exchange(Long id, String from, String to, String enviroment, BigDecimal conversionFactory,
			BigDecimal convertedValue) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.enviroment = enviroment;
		this.conversionFactory = conversionFactory;
		this.convertedValue = convertedValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getEnviroment() {
		return enviroment;
	}

	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}

	public BigDecimal getConversionFactory() {
		return conversionFactory;
	}

	public void setConversionFactory(BigDecimal conversionFactory) {
		this.conversionFactory = conversionFactory;
	}

	public BigDecimal getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(BigDecimal convertedValue) {
		this.convertedValue = convertedValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conversionFactory, convertedValue, enviroment, from, id, to);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exchange other = (Exchange) obj;
		return Objects.equals(conversionFactory, other.conversionFactory)
				&& Objects.equals(convertedValue, other.convertedValue) && Objects.equals(enviroment, other.enviroment)
				&& Objects.equals(from, other.from) && Objects.equals(id, other.id) && Objects.equals(to, other.to);
	};

}
