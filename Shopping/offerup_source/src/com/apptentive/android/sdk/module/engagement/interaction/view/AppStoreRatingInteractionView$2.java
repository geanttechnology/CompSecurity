// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.view;

import android.app.Activity;
import android.content.DialogInterface;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.view:
//            AppStoreRatingInteractionView

class val.activity
    implements android.content.r
{

    final AppStoreRatingInteractionView this$0;
    final Activity val$activity;

    public void onDismiss(DialogInterface dialoginterface)
    {
        val$activity.finish();
    }

    ()
    {
        this$0 = final_appstoreratinginteractionview;
        val$activity = Activity.this;
        super();
    }
}
