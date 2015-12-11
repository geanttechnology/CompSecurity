// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;

// Referenced classes of package android.support.v4.app:
//            cr

public final class cs
{

    private final String a;
    private CharSequence b;
    private CharSequence c[];
    private boolean d;
    private Bundle e;

    public cs(String s)
    {
        d = true;
        e = new Bundle();
        if (s == null)
        {
            throw new IllegalArgumentException("Result key can't be null");
        } else
        {
            a = s;
            return;
        }
    }

    public final cr a()
    {
        return new cr(a, b, c, d, e);
    }

    public final cs a(Bundle bundle)
    {
        if (bundle != null)
        {
            e.putAll(bundle);
        }
        return this;
    }

    public final cs a(CharSequence charsequence)
    {
        b = charsequence;
        return this;
    }

    public final cs a(CharSequence acharsequence[])
    {
        c = acharsequence;
        return this;
    }
}
