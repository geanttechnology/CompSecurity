// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            b

class t> extends BroadcastReceiver
{

    final b a;

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction() == "BALANCE_UPDATE_EVENT" || intent.getAction() == "PURCHASE_CANCELLED")
        {
            a.a(false);
            return;
        }
        if (intent.getAction() == "BALANCE_SAME_EVENT")
        {
            a.a(false);
            return;
        }
        if (intent.getAction() == "SUBSCRIPTION_UPDATED")
        {
            b.a(a);
            return;
        } else
        {
            aa.b(b.e(), "Unknown Broadcast received!");
            return;
        }
    }

    (b b1)
    {
        a = b1;
        super();
    }
}
