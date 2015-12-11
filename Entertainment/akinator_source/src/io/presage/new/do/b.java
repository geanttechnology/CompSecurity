// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.new.do;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import io.presage.new.a;

// Referenced classes of package io.presage.new.do:
//            a, c, d, e

public class b extends a
{

    private BroadcastReceiver b;
    private io.presage.new.do.a c;
    private Application d;

    public b(Application application, io.presage.new.b b1)
    {
        super(b1);
        d = application;
    }

    static io.presage.new.b a(b b1)
    {
        return b1.a;
    }

    static io.presage.new.b b(b b1)
    {
        return b1.a;
    }

    static io.presage.new.b c(b b1)
    {
        return b1.a;
    }

    static io.presage.new.do.a d(b b1)
    {
        return b1.c;
    }

    static io.presage.new.b e(b b1)
    {
        return b1.a;
    }

    public final void a()
    {
        c = new io.presage.new.do.a();
        c.a(new c(this));
        c.a(new d(this));
        b = new e(this);
        d.registerActivityLifecycleCallbacks(c);
        d.registerReceiver(b, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    }
}
