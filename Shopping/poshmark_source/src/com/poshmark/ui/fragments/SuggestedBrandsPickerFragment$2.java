// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.ui.PMActivity;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            SuggestedBrandsPickerFragment, FindFriendsFragment

class this._cls0
    implements android.view.erFragment._cls2
{

    final SuggestedBrandsPickerFragment this$0;

    public void onClick(View view)
    {
        List list = GlobalDbController.getGlobalDbController().getAllFollowingBrands();
        int i;
        if (list != null)
        {
            i = list.size();
        } else
        {
            i = 0;
        }
        if (i > 0)
        {
            view = new String();
            for (int j = 0; j < list.size(); j++)
            {
                String s = (new StringBuilder()).append(view).append((String)list.get(j)).toString();
                view = s;
                if (j + 1 < list.size())
                {
                    view = (new StringBuilder()).append(s).append(",").toString();
                }
            }

            Analytics.getInstance().trackEventWithValue(viewNameForAnalytics, "user", "total_onramp_brands_followed", view, i);
        } else
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "onramp_brand_next_nofollowed", null);
        }
        (new Bundle()).putString("NAME", PMApplicationSession.GetPMSession().getUserId());
        ((PMActivity)getActivity()).launchFragment(null, com/poshmark/ui/fragments/FindFriendsFragment, null);
    }

    ()
    {
        this$0 = SuggestedBrandsPickerFragment.this;
        super();
    }
}
