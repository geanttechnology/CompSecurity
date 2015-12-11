// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.widget.ProgressBar;
import com.groupon.Channel;
import com.groupon.models.category.Category;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class val.friendlyName
    implements Function1
{

    final GlobalSearchFragment this$0;
    final Channel val$currentSourceChannel;
    final String val$friendlyName;
    final Category val$parent;
    final String val$relevanceContext;

    public void execute(Exception exception)
    {
        if (!GlobalSearchFragment.access$1200(GlobalSearchFragment.this).equals(val$currentSourceChannel))
        {
            return;
        } else
        {
            exception = new Category(val$parent, val$relevanceContext, val$friendlyName, val$friendlyName, -1);
            exception.isAllDeals = true;
            exception.relevanceContext = val$relevanceContext;
            GlobalSearchFragment.access$1400(GlobalSearchFragment.this, val$parent, exception, null);
            categoriesProgress.setVisibility(8);
            GlobalSearchFragment.access$1500(GlobalSearchFragment.this);
            return;
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Exception)obj);
    }

    ()
    {
        this$0 = final_globalsearchfragment;
        val$currentSourceChannel = channel;
        val$parent = category;
        val$relevanceContext = s;
        val$friendlyName = String.this;
        super();
    }
}
