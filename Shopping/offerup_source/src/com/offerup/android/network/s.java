// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import android.content.Context;
import com.b.a.a.g;
import com.offerup.android.dto.response.UserResponse;
import com.offerup.android.utils.ba;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

final class s
    implements Callback
{

    private Context a;
    private Object b;

    s(Context context, Object obj)
    {
        a = context;
        b = obj;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
label0:
        {
            if (retrofiterror.getResponse() != null)
            {
                if (retrofiterror.getResponse().getStatus() != 401 && retrofiterror.getResponse().getStatus() != 404)
                {
                    break label0;
                }
                ba.a(a);
            }
            return;
        }
        g.a(b, retrofiterror);
    }

    public final void success(Object obj, Response response)
    {
        obj = (UserResponse)obj;
        ba.a(a, ((UserResponse) (obj)).getUser());
    }
}
