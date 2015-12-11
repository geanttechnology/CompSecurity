// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.HttpAuthHandler;
import com.amazon.android.webkit.AmazonHttpAuthHandler;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebViewClient

class val.handler extends AmazonHttpAuthHandler
{

    final AndroidWebViewClient this$0;
    final HttpAuthHandler val$handler;

    public void cancel()
    {
        val$handler.cancel();
    }

    public void proceed(String s, String s1)
    {
        val$handler.proceed(s, s1);
    }

    public boolean useHttpAuthUsernamePassword()
    {
        return val$handler.useHttpAuthUsernamePassword();
    }

    ()
    {
        this$0 = final_androidwebviewclient;
        val$handler = HttpAuthHandler.this;
        super();
    }
}
