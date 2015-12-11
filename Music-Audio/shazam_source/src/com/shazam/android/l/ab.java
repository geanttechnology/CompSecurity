// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import com.shazam.android.fragment.home.b;
import com.shazam.android.fragment.home.c;
import com.shazam.b.a.a;
import java.util.List;

public final class ab
    implements a
{

    private final c a;

    public ab(c c1)
    {
        a = c1;
    }

    public final Object a(Object obj)
    {
        obj = (com.shazam.android.k.f.b.a)obj;
        switch (com.shazam.android.l._cls1.a[((com.shazam.android.k.f.b.a) (obj)).ordinal()])
        {
        default:
            obj = b.a;
            if (a.b().contains(b.a))
            {
                obj = b.a;
            }
            return obj;

        case 1: // '\001'
        case 2: // '\002'
            return b.b;

        case 3: // '\003'
            return b.c;
        }
    }

    /* member class not found */
    class _cls1 {}

}
