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

class this._cls1
    implements ExtServiceUserInfoInterface
{

    final leLoginComplete this$1;

    public void error(PMApiError pmapierror)
    {
        GooglePlusHelper.showGoogleLinkError(pmapierror, _fld0, com.poshmark.ui.model.IGH);
    }

    public void success(Bundle bundle)
    {
        googleLoginComplete(bundle);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/SignInSignUpWallFragment$3

/* anonymous class */
    class SignInSignUpWallFragment._cls3
        implements android.view.View.OnClickListener
    {

        final SignInSignUpWallFragment this$0;

        public void onClick(View view)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "gp_connect_click", null);
            GooglePlusHelper.getInstance().link(SignInSignUpWallFragment.this, new SignInSignUpWallFragment._cls3._cls1());
        }

            
            {
                this$0 = SignInSignUpWallFragment.this;
                super();
            }
    }

}
