// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;


public final class DataSetName extends Enum
{

    private static final DataSetName $VALUES[];
    public static final DataSetName DEFAULT;
    public static final DataSetName REFINEMENTS;
    public static final DataSetName RESULTS;
    private final String name;

    private DataSetName(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static DataSetName valueOf(String s)
    {
        return (DataSetName)Enum.valueOf(com/amazon/searchapp/retailsearch/client/DataSetName, s);
    }

    public static DataSetName[] values()
    {
        return (DataSetName[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        DEFAULT = new DataSetName("DEFAULT", 0, "default");
        RESULTS = new DataSetName("RESULTS", 1, "results");
        REFINEMENTS = new DataSetName("REFINEMENTS", 2, "refinements");
        $VALUES = (new DataSetName[] {
            DEFAULT, RESULTS, REFINEMENTS
        });
    }
}
