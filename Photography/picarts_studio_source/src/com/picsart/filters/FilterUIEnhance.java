// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.filters;

import com.socialin.android.photo.imgop.ImageOp;
import java.nio.ByteBuffer;
import myobfuscated.az.a;

// Referenced classes of package com.picsart.filters:
//            c

public final class FilterUIEnhance extends c
{

    public FilterUIEnhance(String s, int i, int j)
    {
        super(s, i, j);
        d = 0;
    }

    public final boolean a(ByteBuffer bytebuffer, ByteBuffer bytebuffer1, int i, int j, boolean flag, int k)
    {
        int l = ((Integer)c[0].g).intValue();
        int i1 = ((Integer)c[1].g).intValue();
        int j1 = ((Integer)c[2].g).intValue();
        ImageOp.customenhance4buf(bytebuffer, bytebuffer1, i, j, i, j, (float)l / 100F, (float)i1 / 100F + 1.0F, j1, flag, k);
        return true;
    }

    protected final void b()
    {
        c = new a[3];
        a a1 = new a(0, "Amount", 0x7f0801a2, 0x7f020354, Integer.valueOf(90), Integer.valueOf(90), Integer.valueOf(0), Integer.valueOf(100));
        a1.k = 0x7f100047;
        a(a1, 0, a, b);
        a1 = new a(1, "Saturation", 0x7f0801e8, 0x7f0203e3, Integer.valueOf(20), Integer.valueOf(20), Integer.valueOf(0), Integer.valueOf(100));
        a1.k = 0x7f100048;
        a(a1, 1, a, b);
        a1 = new a(2, "Fade", 0x7f0801bc, 0x7f020369, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(100));
        a1.k = 0x7f100046;
        a(a1, 2, a, b);
    }
}
