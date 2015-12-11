// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

final class ks extends lb
{

    private kr a;

    ks(kr kr1, View view, kn kn1)
    {
        a = kr1;
        super(view);
    }

    public final kx a()
    {
        if (a.a.d == null)
        {
            return null;
        } else
        {
            return ((gw) (a.a.d)).c;
        }
    }

    public final boolean b()
    {
        a.a.b();
        return true;
    }

    public final boolean c()
    {
        if (a.a.f != null)
        {
            return false;
        } else
        {
            a.a.c();
            return true;
        }
    }
}
