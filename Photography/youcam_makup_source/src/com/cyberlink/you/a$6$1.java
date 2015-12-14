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

class a
    implements Runnable
{

    final s.l.g a;

    public void run()
    {
        l.g();
    }

    tReceiver(tReceiver treceiver)
    {
        a = treceiver;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/a$6

/* anonymous class */
    class a._cls6 extends BroadcastReceiver
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
                    (new Thread(new a._cls6._cls1(this))).start();
                    return;
                }
            }
        }

            
            {
                a = a1;
                super();
            }
    }

}
