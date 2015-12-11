// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.b.a.a.g;
import com.offerup.android.dto.response.UserResponse;
import com.offerup.android.utils.ba;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            MyAccountActivity

final class de
    implements Callback
{

    private MyAccountActivity a;

    de(MyAccountActivity myaccountactivity)
    {
        a = myaccountactivity;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        g.a(com/offerup/android/activities/MyAccountActivity.getSimpleName(), retrofiterror);
    }

    public final void success(Object obj, Response response)
    {
        obj = (UserResponse)obj;
        a.i();
        if (obj != null && ((UserResponse) (obj)).isSuccess())
        {
            MyAccountActivity.a(a, false);
            ba.a(a.getApplicationContext(), ((UserResponse) (obj)).getUser());
            MyAccountActivity.b(a);
        }
    }
}
