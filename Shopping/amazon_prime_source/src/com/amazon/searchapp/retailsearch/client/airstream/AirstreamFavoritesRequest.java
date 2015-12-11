// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.airstream;


public final class AirstreamFavoritesRequest
{
    public static class Builder
    {

        private int count;
        private String refTag;
        private int start;

        public AirstreamFavoritesRequest build()
        {
            return new AirstreamFavoritesRequest(this);
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

        public Builder setCount(int i)
        {
            count = i;
            return this;
        }

        public Builder setRefTag(String s)
        {
            refTag = s;
            return this;
        }

        public Builder setStart(int i)
        {
            start = i;
            return this;
        }




        public Builder()
        {
        }
    }


    private final int count;
    private final String refTag;
    private final int start;

    private AirstreamFavoritesRequest(Builder builder)
    {
        start = builder.start;
        count = builder.count;
        refTag = builder.refTag;
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
}
