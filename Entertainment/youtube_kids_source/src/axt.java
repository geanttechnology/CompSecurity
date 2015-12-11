// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.os.IBinder;
import java.util.HashSet;

final class axt
{

    final String a;
    final axu b = new axu(this);
    final HashSet c = new HashSet();
    int d;
    boolean e;
    IBinder f;
    ComponentName g;
    final axs h;

    public axt(axs axs, String s)
    {
        h = axs;
        super();
        a = s;
        d = 0;
    }

    public final void a(axn axn)
    {
        c.add(axn);
    }

    public final boolean b(axn axn)
    {
        return c.contains(axn);
    }
}
