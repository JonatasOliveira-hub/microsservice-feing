package br.jonatas.hub.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class ExchangeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionFactory;
	private String enviroment;
	private Double convertedValue;

	public ExchangeDto() {
	}

	public ExchangeDto(Long id, String from, String to, String enviroment, BigDecimal conversionFactory,
			Double convertedValue) {
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

	public Double getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(Double convertedValue) {
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
		ExchangeDto other = (ExchangeDto) obj;
		return Objects.equals(conversionFactory, other.conversionFactory)
				&& Objects.equals(convertedValue, other.convertedValue) && Objects.equals(enviroment, other.enviroment)
				&& Objects.equals(from, other.from) && Objects.equals(id, other.id) && Objects.equals(to, other.to);
	};

}
