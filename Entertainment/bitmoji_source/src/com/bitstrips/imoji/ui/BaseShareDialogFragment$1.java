// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.view.View;
import com.bitstrips.imoji.util.PreferenceUtils;

// Referenced classes of package com.bitstrips.imoji.ui:
//            BaseShareDialogFragment

class val.resolveInfo
    implements android.view.ragment._cls1
{

    final BaseShareDialogFragment this$0;
    final ResolveInfo val$resolveInfo;

    public void onClick(View view)
    {
        addToRecents();
        view = val$resolveInfo.activityInfo.packageName;
        preferenceUtils.increaseShareImageAppPriority(view);
        sendAnalyticsEvents(view);
        if (view.equals("com.facebook.orca"))
        {
            shareToFacebookMessenger();
        } else
        if (view.equals("com.facebook.katana"))
        {
            shareToFacebook();
        } else
        {
            commonShareAppMethod(view);
        }
        dismiss();
    }

    ()
    {
        this$0 = final_basesharedialogfragment;
        val$resolveInfo = ResolveInfo.this;
        super();
    }
}
