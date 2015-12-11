// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.aqo;
import android.support.v7.iu;
import android.support.v7.iv;
import android.text.TextUtils;
import android.widget.Toast;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import java.lang.ref.WeakReference;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            ContactActivity

private static class f extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    private final String a;
    private final String b;
    private final ParseUser c;
    private final String d;
    private final String e;
    private final WeakReference f;
    private ProgressDialog g;

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

    protected transient Boolean a(Void avoid[])
    {
        if (iu.c(c) && TextUtils.isEmpty(c.getEmail()))
        {
            c.setEmail(d);
            try
            {
                c.save();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                aqo.b(avoid, "Error saving user email", new Object[0]);
            }
        }
        avoid = new ParseObject("Contacts");
        avoid.put("title", a);
        avoid.put("description", (new StringBuilder()).append(b).append(" ").append(d).append(" ").append(e).toString());
        avoid.put("user", c);
        avoid.put("email", d);
        avoid.put("processed", Boolean.valueOf(false));
        try
        {
            avoid.save();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            aqo.b(avoid, "error saving user contact form", new Object[0]);
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    protected void a(Boolean boolean1)
    {
        Object obj;
label0:
        {
            iv.a(g);
            if (f == null)
            {
                obj = null;
            } else
            {
                obj = (Activity)f.get();
            }
            if (obj != null)
            {
                if (!boolean1.booleanValue())
                {
                    break label0;
                }
                Toast.makeText(((android.content.Context) (obj)), 0x7f090081, 1).show();
                ((Activity) (obj)).finish();
            }
            return;
        }
        Toast.makeText(((android.content.Context) (obj)), 0x7f090080, 1).show();
    }

    protected void b(Boolean boolean1)
    {
        super.onCancelled(boolean1);
        iv.a(g);
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "ContactActivity$a#doInBackground", null);
_L1:
        aobj = a((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "ContactActivity$a#doInBackground", null);
          goto _L1
    }

    protected void onCancelled(Object obj)
    {
        b((Boolean)obj);
    }

    protected void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "ContactActivity$a#onPostExecute", null);
_L1:
        a((Boolean)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "ContactActivity$a#onPostExecute", null);
          goto _L1
    }

    protected void onPreExecute()
    {
        Object obj;
        if (f == null)
        {
            obj = null;
        } else
        {
            obj = (Activity)f.get();
        }
        if (obj != null && !((Activity) (obj)).isFinishing())
        {
            g = new ProgressDialog(((android.content.Context) (obj)));
            g.setMessage(((Activity) (obj)).getString(0x7f0900ba));
            g.setIndeterminate(true);
            g.show();
        }
    }

    public (String s, String s1, ParseUser parseuser, Activity activity, String s2, String s3)
    {
        a = s;
        b = s1;
        c = parseuser;
        d = s2;
        e = s3;
        f = new WeakReference(activity);
    }
}
