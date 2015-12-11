// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.custom.NetverifyCustomSDKInterface;

// Referenced classes of package jumiomobile:
//            gm, ht

class go
    implements Runnable
{

    final ht a;
    final gm b;

    go(gm gm1, ht ht1)
    {
        b = gm1;
        a = ht1;
        super();
    }

    public void run()
    {
        b.o.onNetverifyError(a.a(), a.a(b.m.a), a.b(), b.m.j);
    }
}
