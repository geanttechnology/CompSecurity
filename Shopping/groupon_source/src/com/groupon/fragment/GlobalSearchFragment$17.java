// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.widget.ScrollView;
import com.groupon.util.Function1;
import com.groupon.util.LoggingUtils;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class val.searchTerm
    implements Function1
{

    final GlobalSearchFragment this$0;
    final String val$searchTerm;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((List)obj);
    }

    public void execute(List list)
    {
        if (getActivity() != null)
        {
            if (list.size() > 0)
            {
                GlobalSearchFragment.access$2502(GlobalSearchFragment.this, new ArrayList(list));
                if (tagsSection.getVisibility() == 8 && GlobalSearchFragment.access$400(GlobalSearchFragment.this).isSearchModeTextSearch())
                {
                    GlobalSearchFragment.access$2600(GlobalSearchFragment.this, val$searchTerm, null);
                    return;
                }
            } else
            {
                GlobalSearchFragment.access$000(GlobalSearchFragment.this).logTextSearch("", val$searchTerm, "", val$searchTerm.length(), null);
                GlobalSearchFragment.access$200(GlobalSearchFragment.this);
                return;
            }
        }
    }

    balSearchState()
    {
        this$0 = final_globalsearchfragment;
        val$searchTerm = String.this;
        super();
    }
}
