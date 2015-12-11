// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


public final class c
{

    public static final AMEX_CVV AMEX_CVV;
    public static final AMEX_CVV EXPIRY;
    public static final AMEX_CVV NAME;
    public static final AMEX_CVV NAME_2NDLINE;
    public static final AMEX_CVV NUMBER;
    public static final AMEX_CVV UK_ACCOUNTNUM;
    public static final AMEX_CVV UK_SORTCODE;
    private static AMEX_CVV a[];
    private static int b = 0;
    private final int c;
    private final String d;

    public static c swigToEnum(int i)
    {
        if (i < a.length && i >= 0 && a[i].c == i)
        {
            return a[i];
        }
        for (int j = 0; j < a.length; j++)
        {
            if (a[j].c == i)
            {
                return a[j];
            }
        }

        throw new IllegalArgumentException((new StringBuilder("No enum ")).append(com/jumio/ocr/impl/smartEngines/swig/ResultAcceptorInterfaceSettings$FieldName).append(" with value ").append(i).toString());
    }

    public final int swigValue()
    {
        return c;
    }

    public final String toString()
    {
        return d;
    }

    static 
    {
        NUMBER = new <init>("NUMBER");
        EXPIRY = new <init>("EXPIRY");
        NAME = new <init>("NAME");
        UK_SORTCODE = new <init>("UK_SORTCODE");
        UK_ACCOUNTNUM = new <init>("UK_ACCOUNTNUM");
        NAME_2NDLINE = new <init>("NAME_2NDLINE");
        AMEX_CVV = new <init>("AMEX_CVV");
        a = (new a[] {
            NUMBER, EXPIRY, NAME, UK_SORTCODE, UK_ACCOUNTNUM, NAME_2NDLINE, AMEX_CVV
        });
    }

    private (String s)
    {
        d = s;
        int i = b;
        b = i + 1;
        c = i;
    }
}
