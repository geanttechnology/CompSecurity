// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.smule.android.c.aa;
import com.smule.android.network.core.r;
import com.smule.pianoandroid.a.w;

// Referenced classes of package com.smule.pianoandroid.e:
//            d

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.b();
    }

    er(er er)
    {
        a = er;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/e/d$1

/* anonymous class */
    class d._cls1 extends BroadcastReceiver
    {

        final d a;

        public void onReceive(Context context, Intent intent)
        {
            aa.c(d.e(), "Network connectivity changed.");
            if (r.a(d.f()))
            {
                aa.c(d.e(), "Network just connected");
                w.a(new d._cls1._cls1(this));
            }
        }

            
            {
                a = d1;
                super();
            }
    }

}
