// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMCommand, MMWebView, MMJSResponse

class b
    implements Runnable
{

    private MMWebView a;
    private MMJSResponse b;
    private MMCommand c;

    public void run()
    {
        if (MMCommand.a(c).equals("expandWithProperties"))
        {
            a.b = true;
        }
        String s = String.format("javascript:%s(%s);", new Object[] {
            MMCommand.b(c), b.c()
        });
        a.loadUrl(s);
    }

    (MMCommand mmcommand, MMWebView mmwebview, MMJSResponse mmjsresponse)
    {
        c = mmcommand;
        a = mmwebview;
        b = mmjsresponse;
        super();
    }
}
