// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.d;

import com.offerup.android.dto.response.UserResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.d:
//            a, c

final class b
    implements Callback
{

    private a a;

    b(a a1)
    {
        a = a1;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        com.offerup.android.d.a.a(a).b();
    }

    public final void success(Object obj, Response response)
    {
        obj = (UserResponse)obj;
        com.offerup.android.d.a.a(a).a(((UserResponse) (obj)));
    }
}
