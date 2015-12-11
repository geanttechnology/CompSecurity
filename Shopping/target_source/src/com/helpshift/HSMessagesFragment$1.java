// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.helpshift:
//            HSMessagesFragment

class init> extends BroadcastReceiver
{

    final HSMessagesFragment a;

    public void onReceive(Context context, Intent intent)
    {
        HSMessagesFragment.a(a);
    }

    (HSMessagesFragment hsmessagesfragment)
    {
        a = hsmessagesfragment;
        super();
    }
}
