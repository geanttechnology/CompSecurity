// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import android.content.DialogInterface;
import com.bitstrips.imoji.services.PackageService;

// Referenced classes of package com.bitstrips.imoji.ui:
//            IntentCreatorService

class val.activity
    implements android.content.Listener
{

    final IntentCreatorService this$0;
    final Activity val$activity;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (packageService.isAppInstalled("com.bitstrips.imoji"))
        {
            packageService.launchApp("com.bitstrips.imoji");
            return;
        } else
        {
            goToGooglePlayStore("com.bitstrips.imoji", val$activity);
            return;
        }
    }

    r()
    {
        this$0 = final_intentcreatorservice;
        val$activity = Activity.this;
        super();
    }
}
