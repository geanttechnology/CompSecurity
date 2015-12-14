// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMWebView, HandShake, MMAdImpl, MMLayout

class c
    implements Runnable
{

    private MMAdImpl a;
    private String b;
    private String c;
    private MMWebView d;

    public void run()
    {
        MMAd mmad;
        if (HandShake.a(d.getContext()).d)
        {
            d.c();
        } else
        if (d.f == 0)
        {
            d.b();
        } else
        {
            d.a();
        }
        mmad = a.d();
        if (mmad != null && (mmad instanceof MMLayout))
        {
            ((MMLayout)mmad).g();
        }
        d.d = true;
        d.loadDataWithBaseURL(b, c, "text/html", "UTF-8", null);
    }

    (MMWebView mmwebview, MMAdImpl mmadimpl, String s, String s1)
    {
        d = mmwebview;
        a = mmadimpl;
        b = s;
        c = s1;
        super();
    }
}
