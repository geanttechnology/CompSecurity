// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.google.api.a.a.a.i;
import com.google.api.a.a.a.t;
import java.io.IOException;

// Referenced classes of package com.rdio.android.core:
//            VolleyOAuth2RdioService

class val.credential
    implements Runnable
{

    final VolleyOAuth2RdioService this$0;
    final i val$credential;

    public void run()
    {
        val$credential.e();
        VolleyOAuth2RdioService.access$002(VolleyOAuth2RdioService.this, false);
        return;
        Object obj;
        obj;
        log("TokenResponseException when refreshing token!", ((Throwable) (obj)));
        VolleyOAuth2RdioService.access$002(VolleyOAuth2RdioService.this, false);
        return;
        obj;
        log("IOException when refreshing token!", ((Throwable) (obj)));
        VolleyOAuth2RdioService.access$002(VolleyOAuth2RdioService.this, false);
        return;
        obj;
        VolleyOAuth2RdioService.access$002(VolleyOAuth2RdioService.this, false);
        throw obj;
    }

    ()
    {
        this$0 = final_volleyoauth2rdioservice;
        val$credential = i.this;
        super();
    }
}
