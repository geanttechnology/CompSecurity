// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;


public final class RefinementParameterName extends Enum
{

    private static final RefinementParameterName $VALUES[];
    public static final RefinementParameterName KEYWORDS;
    public static final RefinementParameterName NODE;
    private final String name;

    private RefinementParameterName(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static RefinementParameterName valueOf(String s)
    {
        return (RefinementParameterName)Enum.valueOf(com/amazon/searchapp/retailsearch/client/RefinementParameterName, s);
    }

    public static RefinementParameterName[] values()
    {
        return (RefinementParameterName[])$VALUES.clone();
    }

    static 
    {
        KEYWORDS = new RefinementParameterName("KEYWORDS", 0, "k");
        NODE = new RefinementParameterName("NODE", 1, "n");
        $VALUES = (new RefinementParameterName[] {
            KEYWORDS, NODE
        });
    }
}
