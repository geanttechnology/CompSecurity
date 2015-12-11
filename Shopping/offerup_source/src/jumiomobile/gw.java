// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.custom.NetverifyCustomScanViewInterface;

// Referenced classes of package jumiomobile:
//            gs

class gw
    implements Runnable
{

    final gs a;

    gw(gs gs1)
    {
        a = gs1;
        super();
    }

    public void run()
    {
        a.p.onNetverifyNoUSAddressFound();
    }
}
