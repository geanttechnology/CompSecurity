// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.suggestions;


public final class SearchSuggestionsRequest
{
    public static class Builder
    {

        private String confidence;
        private String method;
        private String queryPrefix;
        private String searchAlias;

        public SearchSuggestionsRequest build()
        {
            return new SearchSuggestionsRequest(method, searchAlias, queryPrefix, confidence);
        }

        public String getConfidence()
        {
            return confidence;
        }

        public String getMethod()
        {
            return method;
        }

        public String getQueryPrefix()
        {
            return queryPrefix;
        }

        public String getSearchAlias()
        {
            return searchAlias;
        }

        public Builder setConfidence(String s)
        {
            confidence = s;
            return this;
        }

        public Builder setMethod(String s)
        {
            method = s;
            return this;
        }

        public Builder setQueryPrefix(String s)
        {
            queryPrefix = s;
            return this;
        }

        public Builder setSearchAlias(String s)
        {
            searchAlias = s;
            return this;
        }

        public Builder(String s)
        {
            method = "complete";
            searchAlias = "aps";
            queryPrefix = s;
            confidence = "1";
        }
    }


    public static final String DEFAULT_ALIAS = "aps";
    public static final String DEFAULT_CONFIDENCE = "1";
    public static final String DEFAULT_METHOD = "complete";
    private final String confidence;
    private final String method;
    private final String queryPrefix;
    private final String searchAlias;

    private SearchSuggestionsRequest(String s, String s1, String s2, String s3)
    {
        method = s;
        searchAlias = s1;
        queryPrefix = s2;
        confidence = s3;
    }


    public String getConfidence()
    {
        return confidence;
    }

    public String getMethod()
    {
        return method;
    }

    public String getQueryPrefix()
    {
        return queryPrefix;
    }

    public String getSearchAlias()
    {
        return searchAlias;
    }
}
