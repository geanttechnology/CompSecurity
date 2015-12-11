// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.paypal.android.sdk:
//            ao, ax, v, ap

public class ak extends ao
{

    private static final String a = com/paypal/android/sdk/ak.getSimpleName();
    private Context b;
    private String c;
    private Handler d;

    public ak(Context context, String s, Handler handler)
    {
        b = context;
        c = s;
        d = handler;
    }

    public void run()
    {
        ax.b();
        if (d == null)
        {
            return;
        }
        d.sendMessage(Message.obtain(d, 10, c));
        v v1 = new v(b, c);
        d.sendMessage(Message.obtain(d, 12, v1));
        ap.a().b(this);
_L2:
        ax.b();
        return;
        Object obj;
        obj;
        ax.a();
        d.sendMessage(Message.obtain(d, 11, obj));
        ap.a().b(this);
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        ap.a().b(this);
        throw obj;
    }

}
