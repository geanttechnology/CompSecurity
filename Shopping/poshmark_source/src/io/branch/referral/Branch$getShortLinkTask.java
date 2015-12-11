// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

// Referenced classes of package io.branch.referral:
//            Branch, ServerRequest, BranchRemoteInterface, ServerResponse

private class <init> extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final Branch this$0;

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

    protected transient ServerResponse doInBackground(ServerRequest aserverrequest[])
    {
        return Branch.access$1500(Branch.this).createCustomUrlSync(aserverrequest[0].getPost());
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "Branch$getShortLinkTask#doInBackground", null);
_L1:
        aobj = doInBackground((ServerRequest[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "Branch$getShortLinkTask#doInBackground", null);
          goto _L1
    }

    private hine()
    {
        this$0 = Branch.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
