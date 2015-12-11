// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

// Referenced classes of package android.support.v4.app:
//            cb, cc, bl, cr, 
//            cw

public final class bh extends cb
{

    public int a;
    private final Bundle b;
    private final cr c[];
    private CharSequence d;
    private PendingIntent e;

    public bh(int i, CharSequence charsequence, PendingIntent pendingintent)
    {
        this(i, charsequence, pendingintent, new Bundle(), null);
    }

    private bh(int i, CharSequence charsequence, PendingIntent pendingintent, Bundle bundle, cr acr[])
    {
        a = i;
        d = bl.e(charsequence);
        e = pendingintent;
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        b = bundle;
        c = acr;
    }

    bh(int i, CharSequence charsequence, PendingIntent pendingintent, Bundle bundle, cr acr[], byte byte0)
    {
        this(i, charsequence, pendingintent, bundle, acr);
    }

    public final int a()
    {
        return a;
    }

    public final CharSequence b()
    {
        return d;
    }

    public final PendingIntent c()
    {
        return e;
    }

    public final Bundle d()
    {
        return b;
    }

    public final volatile cw[] e()
    {
        return c;
    }

    static 
    {
        new cc();
    }
}
