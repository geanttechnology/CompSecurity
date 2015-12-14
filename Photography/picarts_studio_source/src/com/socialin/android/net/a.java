// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

// Referenced classes of package com.socialin.android.net:
//            b

public abstract class a
{

    protected Context a;
    protected BroadcastReceiver b;
    protected b c;
    protected boolean d;

    a(Context context)
    {
        b = null;
        d = false;
        a = context;
    }

    public abstract long a(String s, String s1, String s2, String s3, boolean flag);

    public abstract BroadcastReceiver a();

    public final void a(b b1)
    {
        c = b1;
        if (c == null)
        {
            b();
            return;
        }
        if (b == null)
        {
            b = a();
        }
        a.registerReceiver(b, new IntentFilter(c()));
    }

    public void b()
    {
        a.unregisterReceiver(b);
    }

    protected abstract String c();
}
