/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.redkale.convert.ext;

import org.redkale.convert.Reader;
import org.redkale.convert.SimpledCoder;
import org.redkale.convert.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author ken
 * @param <R> Reader
 * @param <W> Writer
 */
public final class LocalDateTimeSimpledCoder<R extends Reader, W extends Writer> extends SimpledCoder<R, W, LocalDateTime> {
    
    public static final LocalDateTimeSimpledCoder instance = new LocalDateTimeSimpledCoder();
    
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public void convertTo(W out, LocalDateTime value) {
    	if (value == null) {
    		value = LocalDateTime.MIN;
    	}
        out.writeString(value.format(format));
    }

    /**
     *
     * @param in
     * @return
     */
    @Override
    public LocalDateTime convertFrom(R in) {
        String s = in.readString();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(s, format);
    }
}
