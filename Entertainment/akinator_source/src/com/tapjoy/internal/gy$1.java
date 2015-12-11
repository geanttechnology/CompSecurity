// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            bp, gy, bu

static final class 
    implements bp
{

    public final Object a(bu bu1)
    {
        String s = "";
        String s1 = "";
        bu1.i();
        while (bu1.k()) 
        {
            String s2 = bu1.m();
            if ("campaign_id".equals(s2))
            {
                s = bu1.c("");
            } else
            if ("product_id".equals(s2))
            {
                s1 = bu1.c("");
            } else
            {
                bu1.t();
            }
        }
        bu1.j();
        return new gy(s, s1);
    }

    ()
    {
    }
}
