// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.util;

import junit.framework.Assert;

// Referenced classes of package com.socialin.android.brushlib.util:
//            h

public final class g
{

    private h a;
    private float b;

    public g()
    {
        this(0.5F);
    }

    public g(float f)
    {
        a(f);
        a = new h();
        a(0);
    }

    public final void a(float f)
    {
        boolean flag;
        if (0.0F <= f && f <= 1.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        b = f;
    }

    public final void a(int i)
    {
        a.a(i);
    }

    public final boolean b(int i)
    {
        return a.b(i) < b;
    }
}
