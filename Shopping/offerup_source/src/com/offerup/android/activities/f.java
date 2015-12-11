// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;
import com.offerup.android.a.a;
import com.offerup.android.dto.Notification;
import com.offerup.android.dto.response.NotificationResponse;
import com.offerup.android.dto.response.NotificationResponseData;
import com.offerup.android.utils.n;
import java.util.List;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            AlertsActivity, a, b, c

final class f
    implements Callback
{

    private AlertsActivity a;

    private f(AlertsActivity alertsactivity)
    {
        a = alertsactivity;
        super();
    }

    f(AlertsActivity alertsactivity, byte byte0)
    {
        this(alertsactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        if (retrofiterror.getResponse() != null && retrofiterror.getResponse().getStatus() == 401)
        {
            a.f.a();
            return;
        } else
        {
            com.offerup.android.activities.AlertsActivity.a(a, true);
            return;
        }
    }

    public final void success(Object obj, Response response)
    {
label0:
        {
            response = (NotificationResponse)obj;
            a.i();
            if (a.c.a())
            {
                a.c.setRefreshing(false);
            }
            if (response.isSuccess())
            {
                obj = a;
                response = response.getData().getNotifications();
                if (response != null && response.size() > 0)
                {
                    for (int i = 0; i < response.size(); i++)
                    {
                        if (((Notification)response.get(i)).getArchived() != 0)
                        {
                            response.remove(i);
                        }
                    }

                }
                int j;
                if (response != null)
                {
                    j = response.size();
                } else
                {
                    j = 0;
                }
                obj.d = j;
                if (((AlertsActivity) (obj)).d != 0)
                {
                    break label0;
                }
                response = n.c(((android.content.Context) (obj)));
                response.setTitle(((AlertsActivity) (obj)).getString(0x7f090182)).setMessage(((AlertsActivity) (obj)).getString(0x7f090181)).setCancelable(false).setNeutralButton(((AlertsActivity) (obj)).getString(0x7f090180), new b(((AlertsActivity) (obj))));
                n.a(response);
            }
            return;
        }
        obj.b = new a(((android.content.Context) (obj)), response);
        ((AlertsActivity) (obj)).a.setAdapter(((AlertsActivity) (obj)).b);
        ((AlertsActivity) (obj)).a.setOnItemClickListener(new c(((AlertsActivity) (obj)), response));
    }
}
