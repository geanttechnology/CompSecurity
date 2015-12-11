// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.custom.NetverifyCustomScanViewInterface;

// Referenced classes of package jumiomobile:
//            gm

class gr
    implements Runnable
{

    final gm a;

    gr(gm gm1)
    {
        a = gm1;
        super();
    }

    public void run()
    {
        a.p.onNetverifyExtractionStarted();
    }
}
