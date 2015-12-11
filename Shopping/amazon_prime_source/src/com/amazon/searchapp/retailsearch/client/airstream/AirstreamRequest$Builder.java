// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.airstream;


// Referenced classes of package com.amazon.searchapp.retailsearch.client.airstream:
//            AirstreamRequest

public static class Q
{

    private String context;
    private int count;
    private String cursor;
    private String filter;
    private String refTag;
    private int start;

    public AirstreamRequest build()
    {
        return new AirstreamRequest(this, null);
    }

    public String getContext()
    {
        return context;
    }

    public int getCount()
    {
        return count;
    }

    public String getCursor()
    {
        return filter;
    }

    public String getFilter()
    {
        return filter;
    }

    public String getRefTag()
    {
        return refTag;
    }

    public int getStart()
    {
        return start;
    }

    public start setContext(String s)
    {
        context = s;
        return this;
    }

    public context setCount(int i)
    {
        count = i;
        return this;
    }

    public count setCursor(String s)
    {
        cursor = s;
        return this;
    }

    public cursor setFilter(String s)
    {
        filter = s;
        return this;
    }

    public filter setRefTag(String s)
    {
        refTag = s;
        return this;
    }

    public refTag setStart(int i)
    {
        start = i;
        return this;
    }







    public Q()
    {
    }
}
