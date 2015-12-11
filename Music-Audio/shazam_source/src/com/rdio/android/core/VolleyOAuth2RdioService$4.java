// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.a.a.m;
import com.a.a.n;
import com.google.a.g.a.h;
import com.google.api.a.a.a.i;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.rdio.android.core:
//            VolleyOAuth2RdioService

class val.credential
    implements h
{

    final VolleyOAuth2RdioService this$0;
    final i val$credential;

    public void onFailure(Throwable throwable)
    {
        log("Failed to refresh token!", throwable);
    }

    public void onSuccess(Object obj)
    {
        if (val$credential.a() == null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        log(4, "Token refresh successful");
        obj = VolleyOAuth2RdioService.access$100(VolleyOAuth2RdioService.this);
        obj;
        JVM INSTR monitorenter ;
        if (VolleyOAuth2RdioService.access$200(VolleyOAuth2RdioService.this) == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        m m1;
        for (Iterator iterator = VolleyOAuth2RdioService.access$200(VolleyOAuth2RdioService.this).iterator(); iterator.hasNext(); VolleyOAuth2RdioService.access$300(VolleyOAuth2RdioService.this).a(m1))
        {
            m1 = (m)iterator.next();
            if (m1 instanceof uth2JsonObjectRequest)
            {
                ((uth2JsonObjectRequest)m1).updateAccessToken(val$credential.a());
            }
            log(4, (new StringBuilder("Adding held request: ")).append(m1.getCacheKey()).append(" to volley queue").toString());
        }

        break MISSING_BLOCK_LABEL_145;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        VolleyOAuth2RdioService.access$200(VolleyOAuth2RdioService.this).clear();
        obj;
        JVM INSTR monitorexit ;
        return;
        log(6, "Token refresh failed!");
        return;
    }

    uth2JsonObjectRequest()
    {
        this$0 = final_volleyoauth2rdioservice;
        val$credential = i.this;
        super();
    }
}
