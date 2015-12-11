// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.MessagingResponse;
import com.offerup.android.dto.Person;
import com.offerup.android.utils.n;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            SendMessageActivity, ho

final class hn
    implements Callback
{

    final SendMessageActivity a;

    private hn(SendMessageActivity sendmessageactivity)
    {
        a = sendmessageactivity;
        super();
    }

    hn(SendMessageActivity sendmessageactivity, byte byte0)
    {
        this(sendmessageactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        if (a.a != null && a.a.isShowing())
        {
            a.a.dismiss();
        }
        if (retrofiterror.getResponse() != null && retrofiterror.getResponse().getStatus() == 418)
        {
            n.a(a, a.c.getOwner().getId());
            return;
        } else
        {
            retrofiterror = n.b(a, "Unable to Send Message", a.getString(0x7f09017b));
            retrofiterror.setPositiveButton("Retry", new ho(this));
            n.a(retrofiterror);
            return;
        }
    }

    public final void success(Object obj, Response response)
    {
        obj = (MessagingResponse)obj;
        if (a.a != null && a.a.isShowing())
        {
            a.a.dismiss();
        }
        SendMessageActivity.b(a);
        a.a(((MessagingResponse) (obj)));
    }
}
