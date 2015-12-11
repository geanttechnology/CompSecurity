// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.custom.NetverifyCustomConfirmationView;
import com.jumio.netverify.sdk.custom.NetverifyCustomScanViewInterface;

// Referenced classes of package jumiomobile:
//            gs, mf, bx

class gu
    implements Runnable
{

    final float a;
    final gs b;

    gu(gs gs1, float f)
    {
        b = gs1;
        a = f;
        super();
    }

    public void run()
    {
        bx bx1 = (bx)gs.a(b).findViewById(mf.aq);
        if (bx1 != null && gs.b(b) != null)
        {
            bx1.a(gs.b(b), a);
        }
        b.p.onNetverifyPresentConfirmationView();
    }
}
