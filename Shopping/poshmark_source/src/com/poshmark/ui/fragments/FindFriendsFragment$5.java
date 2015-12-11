// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.UserReferenceList;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectInterface;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;
import com.poshmark.http.api.PMApiError;
import com.poshmark.ui.model.ActionErrorContext;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            FindFriendsFragment

class this._cls0
    implements android.view.dsFragment._cls5
{

    final FindFriendsFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "load_twitter_friends", null);
        if (PMApplicationSession.GetPMSession().getTwitterToken() != null && twitterList != null && twitterList.getConnectionInfoList().size() > 0)
        {
            FindFriendsFragment.access$000(FindFriendsFragment.this, twitterList, LIST_MODE.TWITTER_FRIENDS_MODE);
            return;
        } else
        {
            showProgressDialogWithMessage(getString(0x7f060190));
            ExtServiceConnectManager.getGlobalConnectManager().twitterLink(FindFriendsFragment.this, new ExtServiceConnectInterface() {

                final FindFriendsFragment._cls5 this$1;

                public void error(PMApiError pmapierror)
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.LINK_TWITTER));
                    }
                }

                public void success(int i, Bundle bundle)
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        FindFriendsFragment.access$100(this$0);
                    }
                }

            
            {
                this$1 = FindFriendsFragment._cls5.this;
                super();
            }
            });
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = FindFriendsFragment.this;
        super();
    }
}
