// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.d;

import com.offerup.android.dto.response.UserResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.d:
//            d, e

public final class f
    implements Callback
{

    private d a;

    protected f(d d1)
    {
        a = d1;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        d.a(a).a(retrofiterror);
    }

    public final void success(Object obj, Response response)
    {
        obj = (UserResponse)obj;
        d.a(a).a(((UserResponse) (obj)));
    }
}
