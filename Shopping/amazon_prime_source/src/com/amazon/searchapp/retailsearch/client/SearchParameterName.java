// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;


public final class SearchParameterName extends Enum
{

    private static final SearchParameterName $VALUES[];
    public static final SearchParameterName ALIAS;
    public static final SearchParameterName API_VERSION;
    public static final SearchParameterName ASINS;
    public static final SearchParameterName CLIENT_ID;
    public static final SearchParameterName CLIENT_REQUEST_ID;
    public static final SearchParameterName DATA_SET;
    public static final SearchParameterName IE;
    public static final SearchParameterName IMAGE_CROP;
    public static final SearchParameterName IMAGE_RESOLUTION;
    public static final SearchParameterName KEYWORDS;
    public static final SearchParameterName MAX_RESULTS;
    public static final SearchParameterName MERCHANT;
    public static final SearchParameterName NODE;
    public static final SearchParameterName PAGE;
    public static final SearchParameterName REFINEMENT_HISTORY;
    public static final SearchParameterName RESPONSE_FORMAT;
    public static final SearchParameterName SEARCH_METHOD;
    public static final SearchParameterName SORT;
    private final String name;

    private SearchParameterName(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static SearchParameterName valueOf(String s)
    {
        return (SearchParameterName)Enum.valueOf(com/amazon/searchapp/retailsearch/client/SearchParameterName, s);
    }

    public static SearchParameterName[] values()
    {
        return (SearchParameterName[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        API_VERSION = new SearchParameterName("API_VERSION", 0, "dataVersion");
        CLIENT_ID = new SearchParameterName("CLIENT_ID", 1, "cid");
        RESPONSE_FORMAT = new SearchParameterName("RESPONSE_FORMAT", 2, "format");
        DATA_SET = new SearchParameterName("DATA_SET", 3, "dataset");
        ALIAS = new SearchParameterName("ALIAS", 4, "i");
        KEYWORDS = new SearchParameterName("KEYWORDS", 5, "k");
        NODE = new SearchParameterName("NODE", 6, "n");
        MERCHANT = new SearchParameterName("MERCHANT", 7, "me");
        REFINEMENT_HISTORY = new SearchParameterName("REFINEMENT_HISTORY", 8, "rh");
        SORT = new SearchParameterName("SORT", 9, "s");
        PAGE = new SearchParameterName("PAGE", 10, "p");
        MAX_RESULTS = new SearchParameterName("MAX_RESULTS", 11, "maxResults");
        IE = new SearchParameterName("IE", 12, "ie");
        IMAGE_RESOLUTION = new SearchParameterName("IMAGE_RESOLUTION", 13, "imgRes");
        IMAGE_CROP = new SearchParameterName("IMAGE_CROP", 14, "imgCrop");
        SEARCH_METHOD = new SearchParameterName("SEARCH_METHOD", 15, "searchMethod");
        CLIENT_REQUEST_ID = new SearchParameterName("CLIENT_REQUEST_ID", 16, "cri");
        ASINS = new SearchParameterName("ASINS", 17, "asins");
        $VALUES = (new SearchParameterName[] {
            API_VERSION, CLIENT_ID, RESPONSE_FORMAT, DATA_SET, ALIAS, KEYWORDS, NODE, MERCHANT, REFINEMENT_HISTORY, SORT, 
            PAGE, MAX_RESULTS, IE, IMAGE_RESOLUTION, IMAGE_CROP, SEARCH_METHOD, CLIENT_REQUEST_ID, ASINS
        });
    }
}
