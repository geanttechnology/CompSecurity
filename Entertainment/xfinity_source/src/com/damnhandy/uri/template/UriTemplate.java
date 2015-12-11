// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.damnhandy.uri.template;

import com.damnhandy.uri.template.impl.RFC6570UriTemplate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public abstract class UriTemplate
{
    public static final class Encoding extends Enum
    {

        private static final Encoding $VALUES[];
        public static final Encoding U;
        public static final Encoding UF;
        public static final Encoding UR;

        public static Encoding valueOf(String s)
        {
            return (Encoding)Enum.valueOf(com/damnhandy/uri/template/UriTemplate$Encoding, s);
        }

        public static Encoding[] values()
        {
            return (Encoding[])$VALUES.clone();
        }

        static 
        {
            U = new Encoding("U", 0);
            UR = new Encoding("UR", 1);
            UF = new Encoding("UF", 2);
            $VALUES = (new Encoding[] {
                U, UR, UF
            });
        }

        private Encoding(String s, int i)
        {
            super(s, i);
        }
    }


    static final char OPERATORS[] = {
        '+', '#', '.', '/', ';', '?', '&'
    };
    private static final BitSet OPERATOR_BITSET;
    protected DateFormat defaultDateFormat;
    private StringBuilder templateBuffer;
    protected Map values;

    public UriTemplate()
    {
        defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        values = new HashMap();
    }

    public static boolean containsOperator(String s)
    {
        return OPERATOR_BITSET.get(s.toCharArray()[0]);
    }

    public static final UriTemplate fromTemplate(String s)
    {
        return new RFC6570UriTemplate(s);
    }

    public abstract String expand();

    public abstract String expand(Map map);

    public String getTemplate()
    {
        return templateBuffer.toString();
    }

    public UriTemplate set(String s, Object obj)
    {
        values.put(s, obj);
        return this;
    }

    protected void setTemplate(String s)
    {
        templateBuffer = new StringBuilder(s);
    }

    static 
    {
        OPERATOR_BITSET = new BitSet();
        for (int i = 0; i < OPERATORS.length; i++)
        {
            OPERATOR_BITSET.set(OPERATORS[i]);
        }

    }
}
