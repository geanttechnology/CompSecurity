// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netswipe.sdk.NetswipeCustomScanInterface;

// Referenced classes of package jumiomobile:
//            dm, dz, ec

class do
    implements Runnable
{

    final dm a;

    do(dm dm1)
    {
        a = dm1;
        super();
    }

    public void run()
    {
        a.B.onNetswipeError(a.E.a(), ec.a(a.z, a.E.b()), dz.h.d(), a.C);
    }
}
