// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMWebView, MMAdView, MMSDK

class a
    implements Runnable
{

    private MMAdView a;
    private MMWebView b;

    public void run()
    {
        synchronized (b)
        {
            a.b();
            if (MMSDK.c() && !MMWebView.a(b))
            {
                android.view.youtParams youtparams = b.getLayoutParams();
                youtparams.width = b.h;
                youtparams.height = b.g;
                b.h = -50;
                b.g = -50;
                b.requestLayout();
            }
            b.j();
            b.d = true;
            b.invalidate();
        }
        return;
        exception;
        mmwebview;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (MMWebView mmwebview, MMAdView mmadview)
    {
        b = mmwebview;
        a = mmadview;
        super();
    }
}
