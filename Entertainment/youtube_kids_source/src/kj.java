// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.AudioManager;

final class kj extends im
{

    private ki a;

    kj(ki ki1)
    {
        a = ki1;
        super();
    }

    public final void a(int i)
    {
        ki.a(a).setStreamVolume(3, i, 0);
        ki.b(a);
    }

    public final void b(int i)
    {
        int j = ki.a(a).getStreamVolume(3);
        if (Math.min(ki.a(a).getStreamMaxVolume(3), Math.max(0, j + i)) != j)
        {
            ki.a(a).setStreamVolume(3, j, 0);
        }
        ki.b(a);
    }
}
