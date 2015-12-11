// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.actionBar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.mShop.actionBar:
//            ActionBarViewV2

private class <init> extends BroadcastReceiver
{

    final ActionBarViewV2 this$0;

    public void onReceive(Context context, Intent intent)
    {
        if ("com.amazon.mShop.TopMostViewChangedReceiverIntent".equals(intent.getAction()))
        {
            update();
        }
    }

    private ()
    {
        this$0 = ActionBarViewV2.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
