// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.airstream;


public final class AirstreamRequest
{
    public static class Builder
    {

        private String context;
        private int count;
        private String cursor;
        private String filter;
        private String refTag;
        private int start;

        public AirstreamRequest build()
        {
            return new AirstreamRequest(this);
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

        public Builder setContext(String s)
        {
            context = s;
            return this;
        }

        public Builder setCount(int i)
        {
            count = i;
            return this;
        }

        public Builder setCursor(String s)
        {
            cursor = s;
            return this;
        }

        public Builder setFilter(String s)
        {
            filter = s;
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


    private final String context;
    private final int count;
    private final String cursor;
    private final String filter;
    private final String refTag;
    private final int start;

    private AirstreamRequest(Builder builder)
    {
        context = builder.context;
        filter = builder.filter;
        cursor = builder.cursor;
        start = builder.start;
        count = builder.count;
        refTag = builder.refTag;
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
        return cursor;
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
}
