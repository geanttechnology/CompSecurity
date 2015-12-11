// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.flurry.sdk:
//            hq, ai, gl, gd, 
//            fp, ao, hp

class t> extends hq
{

    final a a;

    public void safeRun()
    {
        if (!ai.g(a.a))
        {
            a.a.h();
        }
        ai.h(a.a);
    }

    nit>(nit> nit>)
    {
        a = nit>;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/ai$2

/* anonymous class */
    class ai._cls2 extends gl.b
    {

        final ai a;

        public void a(gl gl1)
        {
            if (a.b())
            {
                return;
            } else
            {
                int i = gl1.e();
                gd.a(3, ai.i(), (new StringBuilder()).append("Downloader: Download status code is:").append(i).append(" for url: ").append(ai.f(a)).toString());
                ai.a(a, gl1.c());
                fp.a().b(new ai._cls2._cls1(this));
                return;
            }
        }

        public void a(gl gl1, InputStream inputstream)
        {
            if (a.b())
            {
                throw new IOException("Downloader: request cancelled");
            }
            ai.a(a, ai.a(a, gl1));
            if (ai.d(a) > ai.e(a))
            {
                throw new IOException((new StringBuilder()).append("Downloader: content length: ").append(ai.d(a)).append(" exceeds size limit: ").append(ai.e(a)).toString());
            }
            inputstream = new ao(inputstream, ai.e(a));
            hp.a(inputstream, a.f());
            a.g();
            hp.a(inputstream);
            return;
            gl1;
            inputstream = null;
_L2:
            a.g();
            hp.a(inputstream);
            throw gl1;
            gl1;
            if (true) goto _L2; else goto _L1
_L1:
        }

            
            {
                a = ai1;
                super();
            }
    }

}
