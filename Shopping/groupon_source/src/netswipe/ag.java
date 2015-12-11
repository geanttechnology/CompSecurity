// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import com.jumio.netswipe.sdk.core.ScanCardActivity;

// Referenced classes of package netswipe:
//            o, ce, cl, ar, 
//            cc

class ag
    implements Runnable
{

    final o a;

    ag(o o1)
    {
        a = o1;
        super();
    }

    public void run()
    {
        o.l(a).a(o.k(a), o.f(a), o.j(a).d(), o.n(a), o.e(a), o.d(a), o.o(a));
        if (o.d(a) || o.e(a))
        {
            o.c(a).topInfoBar.setText(ar.a(o.c(a), "top_info_validation"));
            o.c(a).topInfoBar.setShowLoading(true);
        }
    }
}
