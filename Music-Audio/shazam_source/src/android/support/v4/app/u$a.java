// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

// Referenced classes of package android.support.v4.app:
//            u, ab

public static final class f extends f
{

    public static final a d = new x.a.a() {

    };
    public int a;
    public CharSequence b;
    public PendingIntent c;
    private final Bundle e;
    private final ab f[];

    public final int a()
    {
        return a;
    }

    public final CharSequence b()
    {
        return b;
    }

    public final PendingIntent c()
    {
        return c;
    }

    public final Bundle d()
    {
        return e;
    }

    public final volatile [] e()
    {
        return f;
    }


    public _cls1(int i, CharSequence charsequence, PendingIntent pendingintent)
    {
        this(i, charsequence, pendingintent, new Bundle());
    }

    private <init>(int i, CharSequence charsequence, PendingIntent pendingintent, Bundle bundle)
    {
        a = i;
        b = f(charsequence);
        c = pendingintent;
        e = bundle;
        f = null;
    }
}
