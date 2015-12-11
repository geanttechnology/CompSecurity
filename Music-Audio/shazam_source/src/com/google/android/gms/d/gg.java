// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Bundle;
import com.google.android.gms.ads.internal.p;

// Referenced classes of package com.google.android.gms.d:
//            gd

public final class gg
{

    public final Object a;
    public int b;
    public int c;
    public final gd d;
    public final String e;

    private gg(gd gd, String s)
    {
        a = new Object();
        d = gd;
        e = s;
    }

    public gg(String s)
    {
        this(p.h(), s);
    }

    public final Bundle a()
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
}
