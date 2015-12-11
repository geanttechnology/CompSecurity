// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;


public final class SearchMethod extends Enum
{

    private static final SearchMethod $VALUES[];
    public static final SearchMethod FLOW_ASIN;
    public static final SearchMethod FLOW_BARCODE;
    public static final SearchMethod FLOW_IMAGEMATCH;
    public static final SearchMethod FLOW_SUPPBARCODE;
    public static final SearchMethod FLOW_TEXT_NODE;
    public static final SearchMethod LEGACY_IMAGE;
    public static final SearchMethod SCANIT_BARCODE;
    public static final SearchMethod TEXT;
    public static final SearchMethod VOICE;
    private final String name;

    private SearchMethod(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static SearchMethod find(String s)
    {
        if (s != null)
        {
            SearchMethod asearchmethod[] = values();
            int j = asearchmethod.length;
            for (int i = 0; i < j; i++)
            {
                SearchMethod searchmethod = asearchmethod[i];
                if (s.equals(searchmethod.getName()))
                {
                    return searchmethod;
                }
            }

        }
        return null;
    }

    public static SearchMethod valueOf(String s)
    {
        return (SearchMethod)Enum.valueOf(com/amazon/searchapp/retailsearch/client/SearchMethod, s);
    }

    public static SearchMethod[] values()
    {
        return (SearchMethod[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        TEXT = new SearchMethod("TEXT", 0, "text");
        VOICE = new SearchMethod("VOICE", 1, "voice");
        LEGACY_IMAGE = new SearchMethod("LEGACY_IMAGE", 2, "legacy_image");
        SCANIT_BARCODE = new SearchMethod("SCANIT_BARCODE", 3, "scanit_barcode");
        FLOW_BARCODE = new SearchMethod("FLOW_BARCODE", 4, "flow_barcode");
        FLOW_SUPPBARCODE = new SearchMethod("FLOW_SUPPBARCODE", 5, "flow_suppbarcode");
        FLOW_IMAGEMATCH = new SearchMethod("FLOW_IMAGEMATCH", 6, "flow_imagematch");
        FLOW_ASIN = new SearchMethod("FLOW_ASIN", 7, "flow_asin");
        FLOW_TEXT_NODE = new SearchMethod("FLOW_TEXT_NODE", 8, "flow_text_node");
        $VALUES = (new SearchMethod[] {
            TEXT, VOICE, LEGACY_IMAGE, SCANIT_BARCODE, FLOW_BARCODE, FLOW_SUPPBARCODE, FLOW_IMAGEMATCH, FLOW_ASIN, FLOW_TEXT_NODE
        });
    }
}
