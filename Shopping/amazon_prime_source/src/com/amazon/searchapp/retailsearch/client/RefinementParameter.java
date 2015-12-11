// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;


public class RefinementParameter
{

    private final String name;
    private final String value;

    RefinementParameter(String s, String s1)
    {
        name = s;
        value = s1;
    }

    public final String getName()
    {
        return name;
    }

    public final String getValue()
    {
        return value;
    }
}
