// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets.navigationdrawer;

import android.os.AsyncTask;
import com.abtnprojects.ambatana.models.DrawerMenuItem;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.parse.ParseUser;

// Referenced classes of package com.abtnprojects.ambatana.ui.widgets.navigationdrawer:
//            NavigationDrawerFragment, f

public class a extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final NavigationDrawerFragment a;

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

    protected transient DrawerMenuItem a(Void avoid[])
    {
        return NavigationDrawerFragment.a(a, ParseUser.getCurrentUser());
    }

    protected void a(DrawerMenuItem drawermenuitem)
    {
        if (a.isAdded() && drawermenuitem != null)
        {
            NavigationDrawerFragment.b(a).a(drawermenuitem);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "NavigationDrawerFragment$a#doInBackground", null);
_L1:
        aobj = a((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "NavigationDrawerFragment$a#doInBackground", null);
          goto _L1
    }

    protected void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "NavigationDrawerFragment$a#onPostExecute", null);
_L1:
        a((DrawerMenuItem)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "NavigationDrawerFragment$a#onPostExecute", null);
          goto _L1
    }

    public (NavigationDrawerFragment navigationdrawerfragment)
    {
        a = navigationdrawerfragment;
        super();
    }
}
