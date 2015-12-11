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
//            ImojiBrowserActivity, IntentCreatorService

class val.activity
    implements android.content.Listener
{

    final ImojiBrowserActivity this$0;
    final Activity val$activity;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        analytics.sendEvent(Category.RATING, Action.RATE_NOW, null);
        ImojiBrowserActivity.access$200(ImojiBrowserActivity.this);
        intentCreatorService.goToGooglePlayStore("com.bitstrips.imoji", val$activity);
    }

    ()
    {
        this$0 = final_imojibrowseractivity;
        val$activity = Activity.this;
        super();
    }
}
