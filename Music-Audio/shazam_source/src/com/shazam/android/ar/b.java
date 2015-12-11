// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ar;

import com.rdio.android.core.RdioApiResponse;
import com.shazam.b.a.a;
import com.shazam.model.rdio.RdioCallback;

public final class b
    implements com.rdio.android.core.RdioService_Api.ResponseListener
{

    protected final RdioCallback a;
    private final a b;

    public b(RdioCallback rdiocallback, a a1)
    {
        a = rdiocallback;
        b = a1;
    }

    public final void onResponse(RdioApiResponse rdioapiresponse)
    {
        if (rdioapiresponse.isSuccess())
        {
            a.a(b.a(rdioapiresponse));
            return;
        } else
        {
            rdioapiresponse = rdioapiresponse.getErrorMessage();
            a.getClass();
            a.a(rdioapiresponse);
            return;
        }
    }
}
