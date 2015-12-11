// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import android.os.Handler;
import com.google.api.a.b.a.a;
import com.google.api.a.d.a.c;
import com.google.api.a.d.b.e;
import com.google.api.a.d.v;

// Referenced classes of package com.rdio.android.core:
//            OAuth2Session

public class AndroidOAuth2Session extends OAuth2Session
{

    private Handler handler;

    public AndroidOAuth2Session(String s, String s1, String s2, String s3, Long long1)
    {
        super(s, s1, s2, s3, long1);
        handler = new Handler();
    }

    protected v createHttpTransport()
    {
        if (a.a(9))
        {
            return new e();
        } else
        {
            return new c();
        }
    }

    protected com.google.api.a.e.c createJsonFactory()
    {
        return new com.google.api.a.b.a.a.a();
    }

    protected void dispatchAsyncResult(Runnable runnable)
    {
        handler.post(runnable);
    }
}
