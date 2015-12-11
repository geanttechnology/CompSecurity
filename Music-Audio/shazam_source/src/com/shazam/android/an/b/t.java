// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import com.shazam.android.an.p;
import com.shazam.model.authentication.AccessTokenRetrieverListener;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.shazam.android.an.b:
//            v

public final class t
    implements p
{

    private final ExecutorService a;
    private final v b;

    public t(ExecutorService executorservice, v v1)
    {
        a = executorservice;
        b = v1;
    }

    public final void a(String s, AccessTokenRetrieverListener accesstokenretrieverlistener)
    {
        b.a = s;
        b.b = accesstokenretrieverlistener;
        a.execute(b);
    }
}
