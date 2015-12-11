// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.dto.Blocked;
import com.offerup.android.dto.UserRelationshipResponse;
import org.apache.commons.lang3.StringUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            UserDetailActivity

final class is
    implements Callback
{

    private UserDetailActivity a;

    private is(UserDetailActivity userdetailactivity)
    {
        a = userdetailactivity;
        super();
    }

    is(UserDetailActivity userdetailactivity, byte byte0)
    {
        this(userdetailactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
    }

    public final void success(Object obj, Response response)
    {
        obj = (UserRelationshipResponse)obj;
        if (obj != null && ((UserRelationshipResponse) (obj)).getBlocked() != null && StringUtils.isNotEmpty(((UserRelationshipResponse) (obj)).getBlocked().getReportToken()))
        {
            UserDetailActivity.b(a, ((UserRelationshipResponse) (obj)).getBlocked().getReportToken());
        } else
        {
            UserDetailActivity.b(a, null);
        }
        if (obj != null && ((UserRelationshipResponse) (obj)).isFollowing())
        {
            UserDetailActivity.b(a, true);
            return;
        } else
        {
            UserDetailActivity.b(a, false);
            return;
        }
    }
}
