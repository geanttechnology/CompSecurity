// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package android.support.v7:
//            tg

public class tj
{

    private final Object a;
    private int b;
    private int c;
    private final tg d;
    private final String e;

    tj(tg tg1, String s)
    {
        a = new Object();
        d = tg1;
        e = s;
    }

    public tj(String s)
    {
        this(zzp.zzbA(), s);
    }

    public Bundle a()
    {
        Bundle bundle;
        synchronized (a)
        {
            bundle = new Bundle();
            bundle.putInt("pmnli", b);
            bundle.putInt("pmnll", c);
        }
        return bundle;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(int i, int j)
    {
        synchronized (a)
        {
            b = i;
            c = j;
            d.a(e, this);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
