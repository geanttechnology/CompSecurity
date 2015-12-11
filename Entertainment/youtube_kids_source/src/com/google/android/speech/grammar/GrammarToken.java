// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.grammar;

import android.util.Base64;
import java.util.Formatter;

class GrammarToken
{

    private static final Formatter sFormatter;
    private static final StringBuilder sSb;
    private final String token;
    private double weight;

    public GrammarToken(String s, double d)
    {
        token = s;
        weight = d;
    }

    private static String encode(String s)
    {
        return Base64.encodeToString(s.getBytes(), 11);
    }

    public static String getEncodeWeight(double d)
    {
        sSb.setLength(0);
        sFormatter.format("%f", new Object[] {
            Double.valueOf(d)
        });
        return sSb.toString();
    }

    public void add(double d)
    {
        weight = weight + d;
    }

    public void append(StringBuilder stringbuilder)
    {
        String s = getEncodeWeight(weight);
        stringbuilder.append("(");
        stringbuilder.append("/");
        stringbuilder.append(s);
        stringbuilder.append("/ ");
        stringbuilder.append(token);
        stringbuilder.append(" {");
        stringbuilder.append("XX_");
        stringbuilder.append(s.replace('.', 'P'));
        stringbuilder.append("_");
        stringbuilder.append(encode(token));
        stringbuilder.append("})");
    }

    static 
    {
        sSb = new StringBuilder();
        sFormatter = new Formatter(sSb);
    }
}
