// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netswipe.sdk.NetswipeCustomScanInterface;
import com.jumio.netswipe.sdk.core.InternalCardInformation;
import java.util.ArrayList;

// Referenced classes of package jumiomobile:
//            dm, fx, cs

class dp
    implements Runnable
{

    final dm a;

    dp(dm dm1)
    {
        a = dm1;
        super();
    }

    public void run()
    {
        a.D.a(a.l);
        if (fx.a())
        {
            java.io.File file = fx.a(a.z, a.k);
            String s = a.D.getEncryptedAdyenString();
            if (s != null && s.length() != 0)
            {
                cs.a(s, file, "adyen.txt");
            }
        }
        a.B.onNetswipeExtractionFinished(a.D.b(), a.C);
        a.C.clear();
    }
}
