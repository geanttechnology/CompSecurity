// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.airstream;


// Referenced classes of package com.amazon.searchapp.retailsearch.client.airstream:
//            AirstreamFavoritesRequest

public static class 
{

    private int count;
    private String refTag;
    private int start;

    public AirstreamFavoritesRequest build()
    {
        return new AirstreamFavoritesRequest(this, null);
    }

    public int getCount()
    {
        return count;
    }

    public String getRefTag()
    {
        return refTag;
    }

    public int getStart()
    {
        return start;
    }

    public start setCount(int i)
    {
        count = i;
        return this;
    }

    public count setRefTag(String s)
    {
        refTag = s;
        return this;
    }

    public refTag setStart(int i)
    {
        start = i;
        return this;
    }




    public ()
    {
    }
}
