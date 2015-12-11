// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;

// Referenced classes of package com.smule.android.network.core:
//            e, b

public class c
    implements e
{

    public c()
    {
    }

    public HttpResponse a(HttpUriRequest httpurirequest, int i)
    {
        return b.a(i).execute(httpurirequest);
    }
}
