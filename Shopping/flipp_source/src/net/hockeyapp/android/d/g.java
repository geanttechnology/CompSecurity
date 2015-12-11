// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.d;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import net.hockeyapp.android.e.c;
import net.hockeyapp.android.e.d;

public final class g extends AsyncTask
{

    private Context a;
    private String b;
    private Handler c;

    public g(Context context, String s, Handler handler)
    {
        a = context;
        b = s;
        c = handler;
    }

    protected final Object doInBackground(Object aobj[])
    {
        if (a != null && b != null)
        {
            aobj = d.a;
            return net.hockeyapp.android.e.c.a(b);
        } else
        {
            return null;
        }
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (net.hockeyapp.android.c.d)obj;
        if (obj != null && c != null)
        {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putSerializable("parse_feedback_response", ((java.io.Serializable) (obj)));
            message.setData(bundle);
            c.sendMessage(message);
        }
    }
}
