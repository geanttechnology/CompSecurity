// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.fb_tmblr_twitter.ExtServiceUserInfoInterface;
import com.poshmark.fb_tmblr_twitter.GooglePlusHelper;
import com.poshmark.http.api.PMApiError;

// Referenced classes of package com.poshmark.ui.fragments:
//            SignInSignUpWallFragment

class this._cls0
    implements android.view.llFragment._cls3
{

    final SignInSignUpWallFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "gp_connect_click", null);
        GooglePlusHelper.getInstance().link(SignInSignUpWallFragment.this, new ExtServiceUserInfoInterface() {

            final SignInSignUpWallFragment._cls3 this$1;

            public void error(PMApiError pmapierror)
            {
                GooglePlusHelper.showGoogleLinkError(pmapierror, this$0, com.poshmark.ui.model.ActionErrorContext.Severity.HIGH);
            }

            public void success(Bundle bundle)
            {
                googleLoginComplete(bundle);
            }

            
            {
                this$1 = SignInSignUpWallFragment._cls3.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = SignInSignUpWallFragment.this;
        super();
    }
}
