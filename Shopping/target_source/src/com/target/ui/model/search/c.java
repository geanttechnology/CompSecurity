// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.search;

import java.util.List;

public class c
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a ENTERPRISE_SEARCH_SUGGESTION;
        public static final a PI_SEARCH_SUGGESTION;
        public static final a UNKNOWN;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/model/search/c$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            PI_SEARCH_SUGGESTION = new a("PI_SEARCH_SUGGESTION", 0);
            ENTERPRISE_SEARCH_SUGGESTION = new a("ENTERPRISE_SEARCH_SUGGESTION", 1);
            UNKNOWN = new a("UNKNOWN", 2);
            $VALUES = (new a[] {
                PI_SEARCH_SUGGESTION, ENTERPRISE_SEARCH_SUGGESTION, UNKNOWN
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private a mDisplayMode;
    private List mSearchSuggestion;

    public c(List list, a a1)
    {
        mSearchSuggestion = list;
        mDisplayMode = a1;
    }

    public a a()
    {
        return mDisplayMode;
    }

    public List b()
    {
        return mSearchSuggestion;
    }
}
