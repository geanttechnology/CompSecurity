// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.livemixtapes:
//            MainActivity, console

class r extends BroadcastReceiver
{

    final MainActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        console.log(new Object[] {
            intent.getExtras().getString("message")
        });
    }

    r()
    {
        this$0 = MainActivity.this;
        super();
    }
}
