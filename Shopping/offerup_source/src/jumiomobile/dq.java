// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netswipe.sdk.NetswipeCustomScanInterface;

// Referenced classes of package jumiomobile:
//            dm

class dq
    implements Runnable
{

    final dm a;

    dq(dm dm1)
    {
        a = dm1;
        super();
    }

    public void run()
    {
        a.B.onNetswipeExtractionStarted();
    }
}
