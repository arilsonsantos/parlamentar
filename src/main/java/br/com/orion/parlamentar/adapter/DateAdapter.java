package br.com.orion.parlamentar.adapter;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import br.com.orion.parlamentar.utils.DateUtils;

public class DateAdapter extends XmlAdapter<String, LocalDate> {

	@Override
	public LocalDate unmarshal(String data) throws Exception {
		return DateUtils.parseLocalDate(data, DateUtils.DATE_PATTERN_YYYY_MM_DD);
	}

	@Override
	public String marshal(LocalDate data) throws Exception {
		return DateUtils.format(data, DateUtils.DATE_PATTERN_YYYY_MM_DD);
	}

}
