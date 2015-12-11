// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.damnhandy.uri.template.impl;


// Referenced classes of package com.damnhandy.uri.template.impl:
//            ExpressionParseException

public final class Operator extends Enum
{

    private static final Operator $VALUES[];
    public static final Operator CONTINUATION;
    public static final Operator FRAGMENT;
    public static final Operator MATRIX;
    public static final Operator NAME_LABEL;
    public static final Operator NUL;
    public static final Operator PATH;
    public static final Operator QUERY;
    public static final Operator RESERVED;
    private String empty;
    private com.damnhandy.uri.template.UriTemplate.Encoding encoding;
    private boolean named;
    private String operator;
    private String separator;

    private Operator(String s, int i, String s1, String s2, boolean flag, String s3, com.damnhandy.uri.template.UriTemplate.Encoding encoding1)
    {
        super(s, i);
        encoding = com.damnhandy.uri.template.UriTemplate.Encoding.U;
        empty = "";
        operator = s1;
        separator = s2;
        named = flag;
        encoding = encoding1;
        empty = s3;
    }

    public static Operator fromOpCode(String s)
    {
        Operator aoperator[] = values();
        int j = aoperator.length;
        for (int i = 0; i < j; i++)
        {
            Operator operator1 = aoperator[i];
            if (operator1.getOperator().equalsIgnoreCase(s))
            {
                return operator1;
            }
            if (s.equalsIgnoreCase("!") || s.equalsIgnoreCase("="))
            {
                throw new ExpressionParseException((new StringBuilder()).append(s).append(" is not a valid operator.").toString());
            }
        }

        return null;
    }

    public static Operator valueOf(String s)
    {
        return (Operator)Enum.valueOf(com/damnhandy/uri/template/impl/Operator, s);
    }

    public static Operator[] values()
    {
        return (Operator[])$VALUES.clone();
    }

    public com.damnhandy.uri.template.UriTemplate.Encoding getEncoding()
    {
        return encoding;
    }

    public String getListSeparator()
    {
        return ",";
    }

    public String getOperator()
    {
        return operator;
    }

    public String getPrefix()
    {
        return operator;
    }

    public String getSeparator()
    {
        return separator;
    }

    public boolean isNamed()
    {
        return named;
    }

    public boolean useVarNameWhenExploded()
    {
        return named;
    }

    static 
    {
        NUL = new Operator("NUL", 0, "", ",", false, "", com.damnhandy.uri.template.UriTemplate.Encoding.U);
        RESERVED = new Operator("RESERVED", 1, "+", ",", false, "", com.damnhandy.uri.template.UriTemplate.Encoding.UR);
        NAME_LABEL = new Operator("NAME_LABEL", 2, ".", ".", false, "", com.damnhandy.uri.template.UriTemplate.Encoding.U);
        PATH = new Operator("PATH", 3, "/", "/", false, "", com.damnhandy.uri.template.UriTemplate.Encoding.U);
        MATRIX = new Operator("MATRIX", 4, ";", ";", true, "", com.damnhandy.uri.template.UriTemplate.Encoding.U);
        QUERY = new Operator("QUERY", 5, "?", "&", true, "=", com.damnhandy.uri.template.UriTemplate.Encoding.U);
        CONTINUATION = new Operator("CONTINUATION", 6, "&", "&", true, "=", com.damnhandy.uri.template.UriTemplate.Encoding.U);
        FRAGMENT = new Operator("FRAGMENT", 7, "#", ",", false, "", com.damnhandy.uri.template.UriTemplate.Encoding.UF);
        $VALUES = (new Operator[] {
            NUL, RESERVED, NAME_LABEL, PATH, MATRIX, QUERY, CONTINUATION, FRAGMENT
        });
    }
}
