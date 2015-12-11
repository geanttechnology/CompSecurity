// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.web;

import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class WebSearchFilter
{

    private static final String SEARCH_ALIAS_BIN_ID = "i";
    private static final String SEARCH_FILTER_SEPARATOR = "\n";
    private static final String SEARCH_NODE_BIN_ID = "n";
    private static final String SEARCH_NODE_PREFIX = "n:";
    private String mBinId;
    private String mCombinator;
    private String mFilterValue;

    public WebSearchFilter(String s, String s1, String s2)
    {
        mFilterValue = s2;
        mCombinator = s1;
        mBinId = s;
    }

    public static String convertFiltersToBrowsePath(String s)
    {
        List list = splitFilters(s);
        s = "";
        int j = list.size();
        String s1;
        if (j == 1)
        {
            s1 = ((WebSearchFilter)list.get(0)).mFilterValue;
        } else
        {
            s1 = s;
            if (j > 1)
            {
                int i;
                for (i = 0; i < j - 1; i++)
                {
                    s = (new StringBuilder()).append(s).append(((WebSearchFilter)list.get(i)).mFilterValue).append("::").toString();
                }

                return (new StringBuilder()).append(s).append(((WebSearchFilter)list.get(i)).mFilterValue).toString();
            }
        }
        return s1;
    }

    public static WebSearchFilter parse(String s)
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Malformed filter: ").append(s).toString());
        }
        String as[] = s.trim().split(":", 4);
        if (as.length != 4)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Malformed filter: ").append(s).toString());
        }
        if (!as[0].equals("s"))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Malformed filter: ").append(s).append(". Filter should start with 's'").toString());
        } else
        {
            return new WebSearchFilter(as[1], as[2], Uri.decode(as[3]));
        }
    }

    public static List splitFilters(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        s = new ArrayList();
_L4:
        return s;
_L2:
        ArrayList arraylist = new ArrayList();
        String as[] = s.split("\n");
        int j = as.length;
        int i = 0;
        do
        {
            s = arraylist;
            if (i >= j)
            {
                continue;
            }
            s = as[i];
            if (!TextUtils.isEmpty(s))
            {
                arraylist.add(parse(s));
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getCombinator()
    {
        return mCombinator;
    }

    public String getFilterValue()
    {
        return mFilterValue;
    }

    public boolean isAlias()
    {
        return "i".equals(mBinId);
    }

    public boolean isNode()
    {
        return "n".equals(mBinId);
    }

    public String toString()
    {
        if (isNode())
        {
            return (new StringBuilder()).append("n:").append(mFilterValue).toString();
        } else
        {
            return mFilterValue;
        }
    }
}
