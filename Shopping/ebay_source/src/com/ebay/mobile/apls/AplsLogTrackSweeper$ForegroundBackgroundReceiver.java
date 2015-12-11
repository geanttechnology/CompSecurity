// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.apls;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.ebay.mobile.apls:
//            AplsLogTrackSweeper

private final class <init> extends BroadcastReceiver
{

    final AplsLogTrackSweeper this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        if ("com.ebay.common.intent.action.EBAY_APPBACKGROUND".equals(context))
        {
            onBackground();
        } else
        if ("com.ebay.common.intent.action.EBAY_APPFOREGROUND".equals(context))
        {
            onForeground();
            return;
        }
    }

    private ()
    {
        this$0 = AplsLogTrackSweeper.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
