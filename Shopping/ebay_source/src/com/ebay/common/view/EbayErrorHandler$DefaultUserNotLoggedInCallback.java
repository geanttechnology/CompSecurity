// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;

import android.app.Activity;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;

// Referenced classes of package com.ebay.common.view:
//            EbayErrorHandler

public static final class activity
    implements activity
{

    private final Activity activity;

    public void onUserNotLoggedIn()
    {
        if (MyApp.getPrefs().isSignedIn())
        {
            MyApp.signOutForIafTokenFailure(activity);
        }
    }

    public (Activity activity1)
    {
        activity = activity1;
    }
}
