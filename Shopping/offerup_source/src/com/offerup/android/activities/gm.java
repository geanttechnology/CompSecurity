// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.dto.response.UserResponse;
import com.offerup.android.utils.ba;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            ProfileImageActivity

final class gm
    implements Callback
{

    private ProfileImageActivity a;

    gm(ProfileImageActivity profileimageactivity)
    {
        a = profileimageactivity;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        a.a("Error", "We were unable to process your image. If this continues, please restart app or contact support.");
    }

    public final void success(Object obj, Response response)
    {
        obj = (UserResponse)obj;
        a.i();
        if (obj != null && ((UserResponse) (obj)).isSuccess())
        {
            ba.a(a.getApplicationContext(), ((UserResponse) (obj)).getUser());
        }
        a.finish();
    }
}
