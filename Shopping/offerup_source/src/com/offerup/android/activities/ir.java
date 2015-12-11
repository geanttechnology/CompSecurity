// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.tracker.a;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            UserDetailActivity

final class ir
    implements Callback
{

    private UserDetailActivity a;

    private ir(UserDetailActivity userdetailactivity)
    {
        a = userdetailactivity;
        super();
    }

    ir(UserDetailActivity userdetailactivity, byte byte0)
    {
        this(userdetailactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        a.a("Error", "An error has occurred, please try again.");
    }

    public final void success(Object obj, Response response)
    {
        a.i();
        obj = new JSONObject();
        ((JSONObject) (obj)).put("user_id", UserDetailActivity.b(a));
        if (!UserDetailActivity.m(a)) goto _L2; else goto _L1
_L1:
        com.offerup.android.tracker.a.a("UserProfile_Follow-Button_click", ((JSONObject) (obj)));
_L4:
        UserDetailActivity.b(a, UserDetailActivity.m(a));
        return;
_L2:
        try
        {
            com.offerup.android.tracker.a.a("UserProfile_Unfollow-Button_click", ((JSONObject) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((JSONException) (obj)).printStackTrace();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
