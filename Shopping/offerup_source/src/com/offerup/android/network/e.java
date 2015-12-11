// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.b.a.a.g;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

final class e
    implements Callback
{

    private e()
    {
    }

    e(byte byte0)
    {
        this();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        g.a(getClass().getSimpleName(), "Couldn't send payment location");
    }

    public final void success(Object obj, Response response)
    {
        g.a(getClass().getSimpleName(), "Sent payment location");
    }
}
