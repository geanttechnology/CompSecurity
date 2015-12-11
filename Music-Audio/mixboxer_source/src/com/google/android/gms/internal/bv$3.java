// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            bv, cb, cw, cx, 
//            ct, co

class hk
    implements Runnable
{

    final bv hk;

    public void run()
    {
label0:
        {
            synchronized (bv.a(hk))
            {
                if (bv.c(hk).errorCode == -2)
                {
                    break label0;
                }
            }
            return;
        }
        bv.d(hk).aC().a(hk);
        if (bv.c(hk).errorCode != -3)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        ct.u((new StringBuilder()).append("Loading URL in WebView: ").append(bv.c(hk).gL).toString());
        bv.d(hk).loadUrl(bv.c(hk).gL);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        ct.u("Loading HTML in WebView.");
        bv.d(hk).loadDataWithBaseURL(co.o(bv.c(hk).gL), bv.c(hk).hw, "text/html", "UTF-8", null);
          goto _L1
    }

    (bv bv1)
    {
        hk = bv1;
        super();
    }
}
