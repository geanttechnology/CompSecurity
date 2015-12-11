// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.gotv.crackle:
//            Application

private class <init> extends BroadcastReceiver
{

    final Application this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF"))
        {
            pauseLocaleCheck();
        } else
        if (intent.getAction().equals("android.intent.action.SCREEN_ON"))
        {
            resumeLocaleCheckWithDelay();
            return;
        }
    }

    private ()
    {
        this$0 = Application.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
