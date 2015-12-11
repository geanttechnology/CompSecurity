// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;

// Referenced classes of package com.flurry.sdk:
//            en, ea, r, ap, 
//            cu

public final class em extends en
{

    public em(Context context, r r1)
    {
        super(context, r1);
    }

    private void a(r r1, String s, boolean flag)
    {
        ea ea1 = new ea();
        ea1.a = r1;
        ea1.b = s;
        ea1.c = flag;
        ea1.b();
    }

    public void a()
    {
        r r1 = d();
        if (r1.k().r())
        {
            a(r1, null, true);
            return;
        } else
        {
            cu.a(c(), r1, null, true, false);
            return;
        }
    }
}
