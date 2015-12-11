// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.airstream;


public final class AirstreamParameter extends Enum
{

    private static final AirstreamParameter $VALUES[];
    public static final AirstreamParameter CONTEXT;
    public static final AirstreamParameter COUNT;
    public static final AirstreamParameter CURSOR;
    public static final AirstreamParameter FILTER;
    public static final AirstreamParameter START;
    private final String name;

    private AirstreamParameter(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static AirstreamParameter valueOf(String s)
    {
        return (AirstreamParameter)Enum.valueOf(com/amazon/searchapp/retailsearch/client/airstream/AirstreamParameter, s);
    }

    public static AirstreamParameter[] values()
    {
        return (AirstreamParameter[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        CONTEXT = new AirstreamParameter("CONTEXT", 0, "asContext");
        FILTER = new AirstreamParameter("FILTER", 1, "asFilter");
        CURSOR = new AirstreamParameter("CURSOR", 2, "asCursor");
        START = new AirstreamParameter("START", 3, "asStart");
        COUNT = new AirstreamParameter("COUNT", 4, "asCount");
        $VALUES = (new AirstreamParameter[] {
            CONTEXT, FILTER, CURSOR, START, COUNT
        });
    }
}
