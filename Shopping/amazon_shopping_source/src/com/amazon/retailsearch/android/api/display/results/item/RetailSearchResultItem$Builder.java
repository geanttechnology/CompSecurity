// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display.results.item;

import android.text.TextUtils;

// Referenced classes of package com.amazon.retailsearch.android.api.display.results.item:
//            RetailSearchResultItem

public static class 
{

    public RetailSearchResultItem build(String s, String s1, String s2)
    {
        return build(s, s1, s2, null);
    }

    public RetailSearchResultItem build(String s, String s1, String s2, String s3)
    {
        RetailSearchResultItem retailsearchresultitem = new RetailSearchResultItem();
        retailsearchresultitem.setAsin(s);
        if (!TextUtils.isEmpty(s1))
        {
            RetailSearchResultItem.access$000(retailsearchresultitem, s1.replaceFirst(".*?/dp/", ""));
        }
        retailsearchresultitem.setProductGroup(s2);
        RetailSearchResultItem.access$100(retailsearchresultitem, s3);
        return retailsearchresultitem;
    }

    public ()
    {
    }
}
