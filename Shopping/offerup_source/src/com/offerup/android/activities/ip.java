// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.dto.ReportResponse;
import org.apache.commons.lang3.StringUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            UserDetailActivity, a

final class ip
    implements Callback
{

    private UserDetailActivity a;

    private ip(UserDetailActivity userdetailactivity)
    {
        a = userdetailactivity;
        super();
    }

    ip(UserDetailActivity userdetailactivity, byte byte0)
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
        obj = (ReportResponse)obj;
        a.i();
        if (obj != null && StringUtils.isNotEmpty(((ReportResponse) (obj)).getToken()))
        {
            a.f.b(((ReportResponse) (obj)).getToken(), UserDetailActivity.b(a));
            return;
        } else
        {
            a.a("Error", "An error has occurred, please try again.");
            return;
        }
    }
}
