// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.models.nst.SearchSuggestionClickExtraInfo;
import com.groupon.service.gdt.GdtService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LoggingUtils;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class this._cls0
    implements android.view.gment._cls2
{

    final GlobalSearchFragment this$0;

    public void onClick(View view)
    {
        GlobalSearchFragment.access$000(GlobalSearchFragment.this).logClick("", "suggestion_selection_click", Channel.GLOBAL_SEARCH.toString(), Logger.NULL_NST_FIELD, new SearchSuggestionClickExtraInfo("delivery & takeout", "GTG", String.valueOf(0)));
        startActivity(((IntentFactory)intentFactory.get()).newGrouponWebViewIntent(GlobalSearchFragment.access$100(GlobalSearchFragment.this).getGtgEntryUrl(), false, true, true, true, false));
    }

    ExtraInfo()
    {
        this$0 = GlobalSearchFragment.this;
        super();
    }
}
