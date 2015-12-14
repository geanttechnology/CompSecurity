// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMWebView, MMAdView, DTOResizeParameters

class b
    implements Runnable
{

    private MMAdView a;
    private DTOResizeParameters b;
    private MMWebView c;

    public void run()
    {
        synchronized (c)
        {
            c.d = true;
            a.a(b);
            Object obj = b;
            MMAdView mmadview = a;
            mmadview.getClass();
            obj = new nerBounds(mmadview, ((DTOResizeParameters) (obj)));
            if (MMWebView.a(c))
            {
                android.view.youtParams youtparams = c.getLayoutParams();
                c.h = youtparams.width;
                c.g = youtparams.height;
                if (c.h <= 0)
                {
                    c.h = c.getWidth();
                }
                if (c.g <= 0)
                {
                    c.g = c.getHeight();
                }
            }
            ((nerBounds) (obj)).a(c.getLayoutParams());
            c.loadUrl("javascript:MMJS.sdk.setState('resized');");
            c.c = "resized";
        }
        return;
        exception;
        mmwebview;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ameters(MMWebView mmwebview, MMAdView mmadview, DTOResizeParameters dtoresizeparameters)
    {
        c = mmwebview;
        a = mmadview;
        b = dtoresizeparameters;
        super();
    }
}
