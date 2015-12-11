// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import com.b.a.a.g;
import com.offerup.android.dto.response.MessagesResponse;
import com.offerup.android.network.c;

// Referenced classes of package com.offerup.android.activities:
//            ChatActivity, a

public final class br extends AsyncTask
{

    private ChatActivity a;

    public br(ChatActivity chatactivity, Context context)
    {
        a = chatactivity;
        super();
    }

    private transient MessagesResponse a()
    {
        MessagesResponse messagesresponse;
        try
        {
            messagesresponse = c.b(a.a);
        }
        catch (Exception exception)
        {
            g.a(com.offerup.android.activities.ChatActivity.c(a), exception);
            return null;
        }
        return messagesresponse;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (MessagesResponse)obj;
        a.i();
        if (a.j.a())
        {
            a.j.setRefreshing(false);
        }
        if (obj == null || !((MessagesResponse) (obj)).isSuccess() || ((MessagesResponse) (obj)).getMessages() == null)
        {
            if (obj == null || !((MessagesResponse) (obj)).isAuthenticationError())
            {
                ChatActivity.a(a, true);
                return;
            } else
            {
                a.f.a();
                return;
            }
        } else
        {
            a.a(((MessagesResponse) (obj)));
            return;
        }
    }

    protected final void onPreExecute()
    {
        a.g = ProgressDialog.show(a, "", "Fetching your messages");
    }
}
