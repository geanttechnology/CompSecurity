// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;


public final class SearchMethod extends Enum
{

    private static final SearchMethod $VALUES[];
    public static final SearchMethod FLOW_BARCODE;
    public static final SearchMethod FLOW_IMAGEMATCH;
    public static final SearchMethod FLOW_SUPPBARCODE;
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
        SCANIT_BARCODE = new SearchMethod("SCANIT_BARCODE", 2, "scanit_barcode");
        FLOW_BARCODE = new SearchMethod("FLOW_BARCODE", 3, "flow_barcode");
        FLOW_SUPPBARCODE = new SearchMethod("FLOW_SUPPBARCODE", 4, "flow_suppbarcode");
        FLOW_IMAGEMATCH = new SearchMethod("FLOW_IMAGEMATCH", 5, "flow_imagematch");
        $VALUES = (new SearchMethod[] {
            TEXT, VOICE, SCANIT_BARCODE, FLOW_BARCODE, FLOW_SUPPBARCODE, FLOW_IMAGEMATCH
        });
    }
}
