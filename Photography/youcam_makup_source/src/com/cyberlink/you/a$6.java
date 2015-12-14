// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.utility.ULogUtility;

// Referenced classes of package com.cyberlink.you:
//            a

class astReceiver extends BroadcastReceiver
{

    final a a;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        if (context != null)
        {
            Log.w("ConnectionManager", context);
            ULogUtility.a(context, "Time");
            if (context.equals("android.intent.action.DATE_CHANGED") || context.equals("android.intent.action.TIME_SET") || context.equals("android.intent.action.TIMEZONE_CHANGED"))
            {
                (new Thread(new Runnable() {

                    final a._cls6 a;

                    public void run()
                    {
                        l.g();
                    }

            
            {
                a = a._cls6.this;
                super();
            }
                })).start();
                return;
            }
        }
    }

    >(a a1)
    {
        a = a1;
        super();
    }
}
