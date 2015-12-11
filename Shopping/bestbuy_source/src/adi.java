// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import java.util.HashSet;

final class adi
{

    final adh a;
    private final String b;
    private final adj c = new adj(this);
    private final HashSet d = new HashSet();
    private int e;
    private boolean f;
    private IBinder g;
    private ComponentName h;

    public adi(adh adh1, String s)
    {
        a = adh1;
        super();
        b = s;
        e = 2;
    }

    static int a(adi adi1, int i)
    {
        adi1.e = i;
        return i;
    }

    static ComponentName a(adi adi1, ComponentName componentname)
    {
        adi1.h = componentname;
        return componentname;
    }

    static IBinder a(adi adi1, IBinder ibinder)
    {
        adi1.g = ibinder;
        return ibinder;
    }

    static HashSet a(adi adi1)
    {
        return adi1.d;
    }

    public void a()
    {
        Intent intent = (new Intent(b)).setPackage("com.google.android.gms");
        f = adh.b(a).bindService(intent, c, 129);
        if (f)
        {
            e = 3;
            return;
        } else
        {
            adh.b(a).unbindService(c);
            return;
        }
    }

    public void a(adc adc)
    {
        d.add(adc);
    }

    public void b()
    {
        adh.b(a).unbindService(c);
        f = false;
        e = 2;
    }

    public void b(adc adc)
    {
        d.remove(adc);
    }

    public String c()
    {
        return b;
    }

    public boolean c(adc adc)
    {
        return d.contains(adc);
    }

    public boolean d()
    {
        return f;
    }

    public int e()
    {
        return e;
    }

    public boolean f()
    {
        return d.isEmpty();
    }

    public IBinder g()
    {
        return g;
    }

    public ComponentName h()
    {
        return h;
    }
}
