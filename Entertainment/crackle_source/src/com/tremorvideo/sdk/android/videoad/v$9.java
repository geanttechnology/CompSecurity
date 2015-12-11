// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;


// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            v, ad, s, u, 
//            n, t, au

class a
    implements Runnable
{

    final v a;

    public void run()
    {
        ad.d("ASSET DOWNLOAD TIMEOUT");
        if (a.x != null)
        {
            if ((a.x instanceof s) || (a.x instanceof u) && !a.x.p || (a.x instanceof t) && !a.x.p)
            {
                if (a.v > 1)
                {
                    a.F.b();
                    a.g();
                    return;
                } else
                {
                    a.F.b();
                    a.x = null;
                    a.b();
                    return;
                }
            } else
            {
                a.F.b();
                a.g();
                return;
            }
        } else
        {
            a.F.b();
            a.g();
            return;
        }
    }

    (v v1)
    {
        a = v1;
        super();
    }
}
