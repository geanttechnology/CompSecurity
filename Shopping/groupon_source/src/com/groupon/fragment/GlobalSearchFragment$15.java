// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.Channel;
import com.groupon.abtest.SearchAbTestHelper;
import com.groupon.models.nst.GlobalSearchClickToPerformSearchMetadata;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GlobalSearchUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.SearchInterfaceProvider;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class val.categoryId
    implements android.view.ment._cls15
{

    final GlobalSearchFragment this$0;
    final String val$categoryId;
    final String val$clickTag;
    final String val$suggestion;

    public void onClick(View view)
    {
        if (GlobalSearchFragment.access$2000(GlobalSearchFragment.this).isUniversalSearchChannelSelectorEnabled())
        {
            view = new GlobalSearchClickToPerformSearchMetadata(GlobalSearchFragment.access$2100(GlobalSearchFragment.this).loggingNameForChannelString(GlobalSearchFragment.access$1200(GlobalSearchFragment.this).toString()), val$suggestion);
            GlobalSearchFragment.access$2200(GlobalSearchFragment.this).logClick("", val$clickTag, "global_search", Logger.NULL_NST_FIELD, view);
        } else
        {
            GlobalSearchFragment.access$000(GlobalSearchFragment.this).logClick("", val$clickTag, "global_search", val$suggestion);
        }
        GlobalSearchFragment.access$2300(GlobalSearchFragment.this, val$suggestion, val$categoryId);
        GlobalSearchFragment.access$2400(GlobalSearchFragment.this, val$suggestion, val$categoryId, true);
        GlobalSearchFragment.access$300(GlobalSearchFragment.this).clearFocus();
    }

    formSearchMetadata()
    {
        this$0 = final_globalsearchfragment;
        val$suggestion = s;
        val$clickTag = s1;
        val$categoryId = String.this;
        super();
    }
}
