// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import com.offerup.android.dto.response.UserResponse;
import com.offerup.android.utils.n;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.g.b:
//            k, x

final class t
    implements Callback
{

    private k a;

    t(k k1)
    {
        a = k1;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        n.a(k.e(a));
        k.f(a);
        n.a(a.getActivity(), "", a.getString(0x7f090112));
    }

    public final void success(Object obj, Response response)
    {
        obj = (UserResponse)obj;
        n.a(k.e(a));
        k.a(a, ((UserResponse) (obj)));
        a.dismiss();
        if (k.c(a) != null)
        {
            k.c(a).c();
        }
    }
}
