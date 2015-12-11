// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            bl, cr, bh

public final class bi
{

    private final int a;
    private final CharSequence b;
    private final PendingIntent c;
    private final Bundle d;
    private ArrayList e;

    public bi(int i, CharSequence charsequence, PendingIntent pendingintent)
    {
        this(i, charsequence, pendingintent, new Bundle());
    }

    private bi(int i, CharSequence charsequence, PendingIntent pendingintent, Bundle bundle)
    {
        a = i;
        b = bl.e(charsequence);
        c = pendingintent;
        d = bundle;
    }

    public final bh a()
    {
        cr acr[];
        if (e != null)
        {
            acr = (cr[])e.toArray(new cr[e.size()]);
        } else
        {
            acr = null;
        }
        return new bh(a, b, c, d, acr, (byte)0);
    }

    public final bi a(Bundle bundle)
    {
        if (bundle != null)
        {
            d.putAll(bundle);
        }
        return this;
    }

    public final bi a(cr cr1)
    {
        if (e == null)
        {
            e = new ArrayList();
        }
        e.add(cr1);
        return this;
    }
}
