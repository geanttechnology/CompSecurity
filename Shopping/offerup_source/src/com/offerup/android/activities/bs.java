// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.offerup.android.a.i;
import com.offerup.android.dto.MessagingResponse;
import com.offerup.android.utils.n;
import java.util.ArrayList;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            ChatActivity, bt

final class bs
    implements Callback
{

    final ChatActivity a;

    private bs(ChatActivity chatactivity)
    {
        a = chatactivity;
        super();
    }

    bs(ChatActivity chatactivity, byte byte0)
    {
        this(chatactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        if (retrofiterror.getResponse() != null && retrofiterror.getResponse().getStatus() == 418)
        {
            n.a(a, a.k);
            return;
        } else
        {
            retrofiterror = n.b(a, "Unable to Send Message", a.getString(0x7f09017b));
            retrofiterror.setPositiveButton("Retry", new bt(this));
            n.a(retrofiterror);
            return;
        }
    }

    public final void success(Object obj, Response response)
    {
        response = (MessagingResponse)obj;
        a.i();
        obj = a;
        if (response != null && response.isSuccess())
        {
            response = response.getMessage();
            ((ChatActivity) (obj)).b.add(response);
            obj.d = new i(((android.content.Context) (obj)), ((ChatActivity) (obj)).b, ((ChatActivity) (obj)).f);
            ((ChatActivity) (obj)).c.setAdapter(((ChatActivity) (obj)).d);
            response = (EditText)((ChatActivity) (obj)).findViewById(0x7f1000c7);
            response.setText("");
            response.clearFocus();
            response = (InputMethodManager)((ChatActivity) (obj)).getSystemService("input_method");
            obj = ((ChatActivity) (obj)).getCurrentFocus();
            if (response != null && obj != null)
            {
                response.hideSoftInputFromWindow(((View) (obj)).getWindowToken(), 0);
            }
            return;
        } else
        {
            Toast.makeText(((android.content.Context) (obj)), "Something went wrong, message not sent. Please try again", 0).show();
            return;
        }
    }
}
