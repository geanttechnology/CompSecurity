// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.ebay.mobile.dcs:
//            DcsHelper

class val.activity
    implements android.content.Listener
{

    final val.activity this$0;
    final Activity val$activity;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent("android.intent.action.VIEW");
        dialoginterface.setData(Uri.parse("market://details?id=com.ebay.mobile"));
        dialoginterface.addFlags(0x10800000);
        val$activity.startActivity(dialoginterface);
        val$activity.finish();
    }

    ener()
    {
        this$0 = final_ener;
        val$activity = Activity.this;
        super();
    }
}
