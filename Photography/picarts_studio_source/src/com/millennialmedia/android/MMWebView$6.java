// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMWebView

class a
    implements Runnable
{

    private String a;
    private MMWebView b;

    public void run()
    {
        b.loadUrl(a);
    }

    (MMWebView mmwebview, String s)
    {
        b = mmwebview;
        a = s;
        super();
    }
}
