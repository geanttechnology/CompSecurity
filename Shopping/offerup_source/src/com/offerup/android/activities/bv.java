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
//            ChatActivity, a

final class bv
    implements Callback
{

    private ChatActivity a;

    private bv(ChatActivity chatactivity)
    {
        a = chatactivity;
        super();
    }

    bv(ChatActivity chatactivity, byte byte0)
    {
        this(chatactivity);
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
            a.f.a(((ReportResponse) (obj)).getToken(), a.a);
            return;
        } else
        {
            a.a("Error", "An error has occurred, please try again.");
            return;
        }
    }
}
