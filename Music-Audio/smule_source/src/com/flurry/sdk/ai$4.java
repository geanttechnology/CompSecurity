// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            ai, gl, gd, fp, 
//            al, ao, hp, hq

class <init> extends <init>
{

    final String a;
    final String b;
    final ai c;

    public void a(gl gl1)
    {
        if (c.b())
        {
            return;
        }
        int i = gl1.e();
        gd.a(3, ai.i(), (new StringBuilder()).append("Downloader: Download status code is:").append(i).append(" for url: ").append(ai.f(c)).append(" chunk: ").append(ai.l(c)).toString());
        Object obj = null;
        List list = gl1.b("Content-Range");
        String s = obj;
        if (list != null)
        {
            s = obj;
            if (!list.isEmpty())
            {
                s = (String)list.get(0);
                gd.a(3, ai.i(), (new StringBuilder()).append("Downloader: Content range is:").append(s).append(" for url: ").append(ai.f(c)).append(" chunk: ").append(ai.l(c)).toString());
            }
        }
        if (gl1.c() && i == 206 && s != null && s.startsWith(b.replaceAll("=", " ")))
        {
            ai.m(c);
            fp.a().b(new hq() {

                final ai._cls4 a;

                public void safeRun()
                {
                    ai.n(a.c);
                }

            
            {
                a = ai._cls4.this;
                super();
            }
            });
            return;
        } else
        {
            fp.a().b(new hq() {

                final ai._cls4 a;

                public void safeRun()
                {
                    ai.h(a.c);
                }

            
            {
                a = ai._cls4.this;
                super();
            }
            });
            return;
        }
    }

    public void a(gl gl1, InputStream inputstream)
    {
        Object obj;
        Object obj1;
         ;
        obj = null;
        obj1 = null;
        if (c.b())
        {
            throw new IOException("Downloader: request cancelled");
        }
         = ai.k(c).b(a);
        gl1 = obj1;
        if ( == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        inputstream = new ao(inputstream, ai.e(c));
        hp.a(inputstream, .a());
        hp.a(inputstream);
        hp.a();
        gl1 = obj1;
_L1:
        if (gl1 != null)
        {
            ai.k(c).c(a);
            throw gl1;
        } else
        {
            return;
        }
        gl1;
        inputstream = null;
_L4:
        hp.a(inputstream);
        hp.a();
          goto _L1
        gl1;
        inputstream = obj;
_L3:
        hp.a(inputstream);
        hp.a();
        throw gl1;
        gl1;
        if (true) goto _L3; else goto _L2
_L2:
        gl1;
          goto _L4
    }

    nit>(ai ai1, String s, String s1)
    {
        c = ai1;
        a = s;
        b = s1;
        super();
    }
}
