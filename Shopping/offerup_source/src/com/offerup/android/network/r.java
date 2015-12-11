// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import retrofit.RequestInterceptor;

// Referenced classes of package com.offerup.android.network:
//            b

final class r
    implements RequestInterceptor
{

    private Context a;

    r(Context context)
    {
        a = context;
        super();
    }

    public final void intercept(retrofit.RequestInterceptor.RequestFacade requestfacade)
    {
        java.util.Map.Entry entry;
        for (Iterator iterator = b.a(a).entrySet().iterator(); iterator.hasNext(); requestfacade.addHeader((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

    }
}
