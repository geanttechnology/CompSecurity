// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


public final class c
{

    public static final NAME_2NDLINE EXPIRY;
    public static final NAME_2NDLINE NAME;
    public static final NAME_2NDLINE NAME_2NDLINE;
    public static final NAME_2NDLINE NUMBER;
    public static final NAME_2NDLINE NUMPREV;
    public static final NAME_2NDLINE UK_ACCOUNTNUM;
    public static final NAME_2NDLINE UK_SORTCODE;
    private static NAME_2NDLINE a[];
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

        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/jumio/ocr/impl/smartEngines/swig/ResultAcceptorInterfaceSettings$FieldName).append(" with value ").append(i).toString());
    }

    public final int swigValue()
    {
        return c;
    }

    public String toString()
    {
        return d;
    }

    static 
    {
        NUMPREV = new <init>("NUMPREV");
        NUMBER = new <init>("NUMBER");
        EXPIRY = new <init>("EXPIRY");
        NAME = new <init>("NAME");
        UK_SORTCODE = new <init>("UK_SORTCODE");
        UK_ACCOUNTNUM = new <init>("UK_ACCOUNTNUM");
        NAME_2NDLINE = new <init>("NAME_2NDLINE");
        a = (new a[] {
            NUMPREV, NUMBER, EXPIRY, NAME, UK_SORTCODE, UK_ACCOUNTNUM, NAME_2NDLINE
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
