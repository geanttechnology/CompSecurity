// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.chat;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.aqo;
import android.support.v7.dh;
import android.support.v7.hq;
import android.support.v7.iv;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.chat.ConversationsEntity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.chat:
//            UserMessagesListActivity

private class <init> extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final UserMessagesListActivity a;
    private final String b;
    private final CountryCurrencyInfo c;
    private final WeakReference d;
    private final String e;

    public void _nr_setTrace(Trace trace)
    {
        try
        {
            _nr_trace = trace;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Trace trace)
        {
            return;
        }
    }

    protected transient List a(Void avoid[])
    {
        if (d == null)
        {
            avoid = null;
        } else
        {
            avoid = (Context)d.get();
        }
        if (avoid != null)
        {
            List list = (new dh(b)).a(1, 100);
            return (new ConversationsEntity(iv.a(avoid, 0x7f080001), c, avoid)).transform(list, e);
        } else
        {
            return null;
        }
    }

    protected void a(List list)
    {
        iv.a(a.n);
        int i;
        if (list == null)
        {
            i = 0;
        } else
        {
            i = list.size();
        }
        aqo.a("conversation size : %d", new Object[] {
            Integer.valueOf(i)
        });
        if (UserMessagesListActivity.a(a) != null)
        {
            UserMessagesListActivity.a(a).clear();
        }
        if (list != null)
        {
            UserMessagesListActivity.a(a).addAll(new ArrayList(list));
        }
        UserMessagesListActivity.a(a).notifyDataSetChanged();
    }

    protected void b(List list)
    {
        super.onCancelled(list);
        iv.a(a.n);
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "UserMessagesListActivity$a#doInBackground", null);
_L1:
        aobj = a((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "UserMessagesListActivity$a#doInBackground", null);
          goto _L1
    }

    protected void onCancelled(Object obj)
    {
        b((List)obj);
    }

    protected void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "UserMessagesListActivity$a#onPostExecute", null);
_L1:
        a((List)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "UserMessagesListActivity$a#onPostExecute", null);
          goto _L1
    }

    protected void onPreExecute()
    {
        Context context;
        if (d == null)
        {
            context = null;
        } else
        {
            context = (Context)d.get();
        }
        if (context != null)
        {
            a.n = new ProgressDialog(context);
            a.n.setTitle(context.getString(0x7f09008c));
            a.n.setMessage(context.getString(0x7f09008b));
            a.n.setIndeterminate(false);
            a.n.show();
        }
    }

    private (UserMessagesListActivity usermessageslistactivity, String s, CountryCurrencyInfo countrycurrencyinfo, Context context, String s1)
    {
        a = usermessageslistactivity;
        super();
        b = s;
        c = countrycurrencyinfo;
        e = s1;
        d = new WeakReference(context);
    }

    d(UserMessagesListActivity usermessageslistactivity, String s, CountryCurrencyInfo countrycurrencyinfo, Context context, String s1, d d1)
    {
        this(usermessageslistactivity, s, countrycurrencyinfo, context, s1);
    }
}
