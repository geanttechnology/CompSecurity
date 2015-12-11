// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.favorites;

import java.util.List;

public final class AddFavoritesRequest
{
    public static class Builder
    {

        private String configuration;
        private List items;
        private String refTag;
        private String requestToken;

        public AddFavoritesRequest build()
        {
            return new AddFavoritesRequest(this);
        }

        public String getConfiguration()
        {
            return configuration;
        }

        public List getItems()
        {
            return items;
        }

        public String getRefTag()
        {
            return refTag;
        }

        public String getRequestToken()
        {
            return requestToken;
        }

        public Builder setConfiguration(String s)
        {
            configuration = s;
            return this;
        }

        public Builder setItems(List list)
        {
            items = list;
            return this;
        }

        public Builder setRefTag(String s)
        {
            refTag = s;
            return this;
        }

        public Builder setRequestToken(String s)
        {
            requestToken = s;
            return this;
        }





        public Builder()
        {
        }
    }


    private final String configuration;
    private final List items;
    private final String refTag;
    private final String requestToken;

    private AddFavoritesRequest(Builder builder)
    {
        configuration = builder.configuration;
        items = builder.items;
        requestToken = builder.requestToken;
        refTag = builder.refTag;
    }


    public String getConfiguration()
    {
        return configuration;
    }

    public List getItems()
    {
        return items;
    }

    public String getRefTag()
    {
        return refTag;
    }

    public String getRequestToken()
    {
        return requestToken;
    }
}
