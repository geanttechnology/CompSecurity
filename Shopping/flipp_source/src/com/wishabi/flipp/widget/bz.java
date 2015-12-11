// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.wishabi.flipp.widget:
//            eb, bw, bx, cb

final class bz
    implements eb
{

    final bw a;
    private final Context b;

    bz(bw bw1, Context context)
    {
        a = bw1;
        super();
        b = context;
    }

    public final int a()
    {
        return bw.a();
    }

    public final View a(ViewGroup viewgroup, int i)
    {
        return null;
    }

    public final String a(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return b.getString(0x7f0e00b8);

        case 1: // '\001'
            return b.getString(0x7f0e00b7);

        case 2: // '\002'
            return b.getString(0x7f0e00b9);
        }
    }

    public final boolean b()
    {
        return true;
    }

    public final int c()
    {
        switch (bx.a[bw.a(a).ordinal()])
        {
        case 1: // '\001'
        default:
            return 0;

        case 2: // '\002'
            return 1;

        case 3: // '\003'
            return 2;
        }
    }
}
