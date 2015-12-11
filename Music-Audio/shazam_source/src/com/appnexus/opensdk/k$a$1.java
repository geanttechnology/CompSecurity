// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import com.appnexus.opensdk.b.b;

// Referenced classes of package com.appnexus.opensdk:
//            k, i, r, ae, 
//            f

final class a
    implements Runnable
{

    final i a;
    final b b;

    public final void run()
    {
        b.b.setCreativeWidth(a.c().d());
        b.b.setCreativeHeight(a.c().e());
        if (a.b())
        {
            try
            {
                b.b.a((ae)a.c());
            }
            catch (ClassCastException classcastexception)
            {
                com.appnexus.opensdk.b.b.e(b.b, "The SDK shouldn't fail downcasts to MediatedDisplayable in AdView");
            }
        } else
        {
            b.b.a(a.c());
        }
        if (k.a(b.b) != null)
        {
            k.a(b.b).a(b.b);
        }
    }

    n(n n, i j)
    {
        b = n;
        a = j;
        super();
    }
}
