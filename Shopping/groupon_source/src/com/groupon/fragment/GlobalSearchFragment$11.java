// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.Channel;
import com.groupon.models.category.Category;
import com.groupon.util.CategoriesUtil;
import com.groupon.util.Function1;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class val.friendlyName
    implements Function1
{

    final GlobalSearchFragment this$0;
    final Channel val$currentSourceChannel;
    final String val$facet;
    final String val$friendlyName;
    final Category val$parent;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((List)obj);
    }

    public void execute(List list)
    {
        if (!GlobalSearchFragment.access$1200(GlobalSearchFragment.this).equals(val$currentSourceChannel))
        {
            return;
        } else
        {
            String s = GlobalSearchFragment.access$1300(GlobalSearchFragment.this).getRelevanceContext(val$facet);
            Category category = new Category(val$parent, s, val$friendlyName, val$friendlyName, -1);
            category.isAllDeals = true;
            category.relevanceContext = s;
            GlobalSearchFragment.access$1400(GlobalSearchFragment.this, val$parent, category, list);
            return;
        }
    }

    ()
    {
        this$0 = final_globalsearchfragment;
        val$currentSourceChannel = channel;
        val$facet = s;
        val$parent = category;
        val$friendlyName = String.this;
        super();
    }
}
