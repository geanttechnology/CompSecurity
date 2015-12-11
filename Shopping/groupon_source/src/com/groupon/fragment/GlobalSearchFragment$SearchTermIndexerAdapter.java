// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import com.groupon.adapter.FilteringAdapter;
import com.groupon.models.SearchTermAndCategory;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

static class  extends FilteringAdapter
{

    protected String getStringRepresentation(SearchTermAndCategory searchtermandcategory)
    {
        return searchtermandcategory.getSearchTerm();
    }

    protected volatile String getStringRepresentation(Object obj)
    {
        return getStringRepresentation((SearchTermAndCategory)obj);
    }

    public (Context context, int i, List list)
    {
        super(context, i, list);
    }
}
