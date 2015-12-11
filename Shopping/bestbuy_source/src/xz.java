// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public final class xz extends yt
    implements ServiceConnection
{

    private boolean a;
    private Context b;
    private int c;
    private Intent d;
    private xu e;
    private xy f;
    private String g;

    public xz(Context context, String s, boolean flag, int i, Intent intent, xy xy)
    {
        a = false;
        g = s;
        c = i;
        d = intent;
        a = flag;
        b = context;
        f = xy;
    }

    public boolean a()
    {
        return a;
    }

    public String b()
    {
        return g;
    }

    public Intent c()
    {
        return d;
    }

    public int d()
    {
        return c;
    }

    public void e()
    {
        int i = yc.a(d);
        if (c != -1 || i != 0)
        {
            return;
        } else
        {
            e = new xu(b);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            b.bindService(intent, this, 1);
            return;
        }
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        acb.c("In-app billing service connected.");
        e.a(ibinder);
        componentname = yc.b(yc.b(d));
        if (componentname == null)
        {
            return;
        }
        if (e.a(b.getPackageName(), componentname) == 0)
        {
            ya.a(b).a(f);
        }
        b.unbindService(this);
        e.a();
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        acb.c("In-app billing service disconnected.");
        e.a();
    }
}
