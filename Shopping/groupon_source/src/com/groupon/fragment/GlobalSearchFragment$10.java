// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.widget.ScrollView;
import com.groupon.models.SearchTermAndCategory;
import com.groupon.models.category.Category;
import com.groupon.util.Function1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class this._cls0
    implements Function1
{

    final GlobalSearchFragment this$0;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((List)obj);
    }

    public void execute(List list)
    {
        if (list.size() > 0)
        {
            GlobalSearchFragment.access$902(GlobalSearchFragment.this, new ArrayList());
            String s;
            Object obj;
            for (list = list.iterator(); list.hasNext(); GlobalSearchFragment.access$900(GlobalSearchFragment.this).add(new SearchTermAndCategory(s, ((String) (obj)))))
            {
                obj = (Category)list.next();
                s = ((Category) (obj)).friendlyName.replaceAll("\"", "");
                obj = ((Category) (obj)).id.replaceAll("\"", "");
            }

            if (tagsSection.getVisibility() == 0 || searchTerm != null || GlobalSearchFragment.access$1000(GlobalSearchFragment.this))
            {
                GlobalSearchFragment.access$1002(GlobalSearchFragment.this, false);
                GlobalSearchFragment.access$1100(GlobalSearchFragment.this, GlobalSearchFragment.access$900(GlobalSearchFragment.this), popularList, popularBox, "popular_category_click");
            }
        }
    }

    ()
    {
        this$0 = GlobalSearchFragment.this;
        super();
    }
}
