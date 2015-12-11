// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.extraction.templatematcher.TemplateInfoWrapper;

// Referenced classes of package jumiomobile:
//            jk, cs, ps, ao, 
//            q, ay, os

class jm
    implements Runnable
{

    final byte a[];
    final TemplateInfoWrapper b;
    final byte c[];
    final int d;
    final int e;
    final jk f;

    jm(jk jk1, byte abyte0[], TemplateInfoWrapper templateinfowrapper, byte abyte1[], int i, int j)
    {
        f = jk1;
        a = abyte0;
        b = templateinfowrapper;
        c = abyte1;
        d = i;
        e = j;
        super();
    }

    public void run()
    {
        String s = jk.U(f).j;
        if (cs.a())
        {
            os.a(new ps(s, 0L, q.a(a, jk.V(f).f(), b.G()), ay.a(c, d, e), b));
            os.a(cs.a(jk.W(f), (new StringBuilder("TM_")).append(s).toString()), s);
        } else
        {
            os.a(s);
        }
        os.a();
    }
}
