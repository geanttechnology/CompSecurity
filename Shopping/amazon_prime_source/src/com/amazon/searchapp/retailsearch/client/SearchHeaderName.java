// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;


public final class SearchHeaderName extends Enum
{

    private static final SearchHeaderName $VALUES[];
    public static final SearchHeaderName APP_ID;
    public static final SearchHeaderName CLIENT_ID;
    public static final SearchHeaderName PLATFORM;
    private final String name;

    private SearchHeaderName(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static SearchHeaderName valueOf(String s)
    {
        return (SearchHeaderName)Enum.valueOf(com/amazon/searchapp/retailsearch/client/SearchHeaderName, s);
    }

    public static SearchHeaderName[] values()
    {
        return (SearchHeaderName[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        CLIENT_ID = new SearchHeaderName("CLIENT_ID", 0, "x-search-client-id");
        APP_ID = new SearchHeaderName("APP_ID", 1, "x-search-app-id");
        PLATFORM = new SearchHeaderName("PLATFORM", 2, "x-search-platform");
        $VALUES = (new SearchHeaderName[] {
            CLIENT_ID, APP_ID, PLATFORM
        });
    }
}
