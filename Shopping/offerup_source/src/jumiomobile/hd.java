// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.custom.NetverifyCustomSDKInterface;

// Referenced classes of package jumiomobile:
//            ha

class hd
    implements Runnable
{

    final ha a;

    hd(ha ha1)
    {
        a = ha1;
        super();
    }

    public void run()
    {
        ha.c(a).onNetverifyResourcesLoaded();
    }
}
