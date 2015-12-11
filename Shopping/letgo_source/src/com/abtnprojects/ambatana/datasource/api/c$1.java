// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import retrofit.RequestInterceptor;

// Referenced classes of package com.abtnprojects.ambatana.datasource.api:
//            c

static final class a
    implements RequestInterceptor
{

    final String a;

    public void intercept(retrofit.estInterceptor.RequestFacade requestfacade)
    {
        requestfacade.addHeader("X-Letgo-Parse-User-Token", a);
    }

    (String s)
    {
        a = s;
        super();
    }
}
