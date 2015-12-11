// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import android.app.Activity;
import android.content.DialogInterface;

// Referenced classes of package com.ebay.mobile.dcs:
//            DcsHelper

class val.activity
    implements android.content.Listener
{

    final val.activity this$0;
    final Activity val$activity;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        val$activity.finish();
    }

    ener()
    {
        this$0 = final_ener;
        val$activity = Activity.this;
        super();
    }
}
