// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import android.content.DialogInterface;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;

// Referenced classes of package com.bitstrips.imoji.ui:
//            IntentCreatorService

class val.currentActivity
    implements android.content.Listener
{

    final IntentCreatorService this$0;
    final Activity val$currentActivity;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        analyticsService.sendEvent(Category.DOWNLOAD_FACEBOOK_MESSENGER, Action.YES_MESSENGER, null);
        goToGooglePlayStore("com.facebook.orca", val$currentActivity);
    }

    ()
    {
        this$0 = final_intentcreatorservice;
        val$currentActivity = Activity.this;
        super();
    }
}
