// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.Iterator;
import java.util.List;
import org.altbeacon.beacon.d;

// Referenced classes of package org.altbeacon.beacon.service:
//            BeaconService, b

private class <init> extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    b a;
    final BeaconService b;

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

    protected transient Void a(_nr_trace a_pnr_trace[])
    {
        _nr_trace _lnr_trace = a_pnr_trace[0];
        Iterator iterator = BeaconService.e(b).iterator();
        a_pnr_trace = null;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            org.altbeacon.beacon.Beacon beacon = ((d)iterator.next()).a(_lnr_trace.c, _lnr_trace.a, _lnr_trace.b);
            a_pnr_trace = beacon;
            if (beacon == null)
            {
                continue;
            }
            a_pnr_trace = beacon;
            break;
        } while (true);
        if (a_pnr_trace != null)
        {
            a.c();
            BeaconService.a(b, a_pnr_trace);
        }
        return null;
    }

    protected void a(Void void1)
    {
    }

    protected transient void a(Void avoid[])
    {
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "BeaconService$c#doInBackground", null);
_L1:
        aobj = a((a[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "BeaconService$c#doInBackground", null);
          goto _L1
    }

    protected void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "BeaconService$c#onPostExecute", null);
_L1:
        a((Void)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "BeaconService$c#onPostExecute", null);
          goto _L1
    }

    protected void onPreExecute()
    {
    }

    protected void onProgressUpdate(Object aobj[])
    {
        a((Void[])aobj);
    }

    private ne(BeaconService beaconservice)
    {
        b = beaconservice;
        super();
        a = org.altbeacon.beacon.service.b.a();
    }

    a(BeaconService beaconservice, a a1)
    {
        this(beaconservice);
    }
}
