// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.os.Handler;

// Referenced classes of package android.support.design.widget:
//            bc, Snackbar

final class ar
    implements bc
{

    private Snackbar a;

    ar(Snackbar snackbar)
    {
        a = snackbar;
        super();
    }

    public final void a()
    {
        Snackbar.d().sendMessage(Snackbar.d().obtainMessage(0, a));
    }

    public final void a(int i)
    {
        Snackbar.d().sendMessage(Snackbar.d().obtainMessage(1, i, 0, a));
    }
}
