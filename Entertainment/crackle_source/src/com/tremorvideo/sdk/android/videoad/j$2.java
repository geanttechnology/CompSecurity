// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;


// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            j, ad, s, u, 
//            n, t, au

class a
    implements Runnable
{

    final j a;

    public void run()
    {
        ad.d("ASSET DOWNLOAD TIMEOUT");
        if (a.f != null)
        {
            if ((a.f instanceof s) || (a.f instanceof u) && !a.f.p || (a.f instanceof t) && !a.f.p)
            {
                if (a.c > 1)
                {
                    a.j.b();
                    a.i();
                    return;
                } else
                {
                    a.j.b();
                    a.f = null;
                    a.g();
                    return;
                }
            } else
            {
                a.j.b();
                a.i();
                return;
            }
        } else
        {
            a.j.b();
            a.i();
            return;
        }
    }

    (j j1)
    {
        a = j1;
        super();
    }
}
