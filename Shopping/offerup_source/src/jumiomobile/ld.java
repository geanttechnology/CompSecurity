// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.DocumentType;

// Referenced classes of package jumiomobile:
//            lc, kt, lm, mf, 
//            nu, hq

class ld
    implements Runnable
{

    final hq a;
    final lc b;

    ld(lc lc1, hq hq)
    {
        b = lc1;
        a = hq;
        super();
    }

    public void run()
    {
        mf.a(b.a.getActivity(), b.a.a.getModel().v.getId(), a, b.a.b);
        kt.a(b.a, null);
        kt.a(b.a).setShowHelpButton(false);
    }
}
