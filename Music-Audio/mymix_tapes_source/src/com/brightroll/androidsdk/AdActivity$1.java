// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightroll.androidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.brightroll.androidsdk:
//            AdActivity

class > extends BroadcastReceiver
{

    final AdActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF"))
        {
            finish();
        }
    }

    ()
    {
        this$0 = AdActivity.this;
        super();
    }
}
