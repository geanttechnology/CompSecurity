// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.poi;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.pointinside.location.poi:
//            PIPointOfInterestRequestManager, PointOfInterestRequester, PointOfInterestResponse, PointOfInterestURLBuilder

class this._cls0 extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final PIPointOfInterestRequestManager this$0;

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

    protected volatile Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "PIPointOfInterestRequestManager$POILoaderTask#doInBackground", null);
_L1:
        aobj = doInBackground((PointOfInterestURLBuilder[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "PIPointOfInterestRequestManager$POILoaderTask#doInBackground", null);
          goto _L1
    }

    protected transient List doInBackground(PointOfInterestURLBuilder apointofinteresturlbuilder[])
    {
        apointofinteresturlbuilder = new PointOfInterestRequester(apointofinteresturlbuilder[0], new PointOfInterestResponse());
        try
        {
            apointofinteresturlbuilder = apointofinteresturlbuilder.fetchAll();
        }
        // Misplaced declaration of an exception variable
        catch (PointOfInterestURLBuilder apointofinteresturlbuilder[])
        {
            apointofinteresturlbuilder.printStackTrace();
            return null;
        }
        return apointofinteresturlbuilder;
    }

    ()
    {
        this$0 = PIPointOfInterestRequestManager.this;
        super();
    }
}
