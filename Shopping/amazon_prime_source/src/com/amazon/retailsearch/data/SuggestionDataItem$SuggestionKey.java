// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import com.amazon.retailsearch.util.Utils;

// Referenced classes of package com.amazon.retailsearch.data:
//            SuggestionDataItem

public class keywords
{

    private String keywords;
    private String searchAlias;
    final SuggestionDataItem this$0;

    public boolean equals(Object obj)
    {
        if (obj instanceof keywords)
        {
            if (Utils.isEqual(keywords, ((keywords) (obj = (keywords)obj)).getKeywords()) && Utils.isEqual(searchAlias, ((searchAlias) (obj)).getSearchAlias()))
            {
                return true;
            }
        }
        return false;
    }

    public String getKeywords()
    {
        return keywords;
    }

    public String getSearchAlias()
    {
        return searchAlias;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (keywords == null)
        {
            i = 0;
        } else
        {
            i = keywords.hashCode();
        }
        if (searchAlias != null)
        {
            j = searchAlias.hashCode();
        }
        return (i + 29) * 29 + j;
    }

    public (String s, String s1)
    {
        this$0 = SuggestionDataItem.this;
        super();
        searchAlias = s;
        keywords = s1;
    }
}
