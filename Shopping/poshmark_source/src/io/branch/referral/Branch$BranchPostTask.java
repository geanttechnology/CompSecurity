// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.os.AsyncTask;
import android.util.Log;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            Branch, PrefHelper, ServerRequestInitSession, ServerRequestRegisterView, 
//            ServerRequest, BranchRemoteInterface, ServerResponse, ServerRequestQueue, 
//            ServerRequestCreateUrl, ServerRequestIdentifyUserRequest, ServerRequestLogout

private class timeOut_ extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final Branch this$0;
    ServerRequest thisReq_;
    int timeOut_;

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

    protected transient ServerResponse doInBackground(Void avoid[])
    {
        if ((thisReq_ instanceof ServerRequestInitSession) || (thisReq_ instanceof ServerRequestRegisterView))
        {
            thisReq_.updateGAdsParams(Branch.access$300(Branch.this));
        }
        if (thisReq_.isGetRequest())
        {
            return Branch.access$1500(Branch.this).make_restful_get(thisReq_.getRequestUrl(), thisReq_.getRequestPath(), timeOut_);
        } else
        {
            return Branch.access$1500(Branch.this).make_restful_post(thisReq_.getPost(), thisReq_.getRequestUrl(), thisReq_.getRequestPath(), timeOut_);
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "Branch$BranchPostTask#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "Branch$BranchPostTask#doInBackground", null);
          goto _L1
    }

    protected void onPostExecute(ServerResponse serverresponse)
    {
        int j;
        super.onPostExecute(serverresponse);
        if (serverresponse == null)
        {
            break MISSING_BLOCK_LABEL_746;
        }
        try
        {
            j = serverresponse.getStatusCode();
            Branch.access$1602(Branch.this, true);
        }
        // Misplaced declaration of an exception variable
        catch (ServerResponse serverresponse)
        {
            serverresponse.printStackTrace();
            return;
        }
        if (j == 200) goto _L2; else goto _L1
_L1:
        if (thisReq_ instanceof ServerRequestInitSession)
        {
            Branch.access$1702(Branch.this, NINITIALISED);
        }
        if (j != 409) goto _L4; else goto _L3
_L3:
        Branch.access$1800(Branch.this).remove(thisReq_);
        if (!(thisReq_ instanceof ServerRequestCreateUrl)) goto _L6; else goto _L5
_L5:
        ((ServerRequestCreateUrl)thisReq_).handleDuplicateURLError();
_L7:
        Branch.access$2002(Branch.this, 0);
        if (Branch.access$1600(Branch.this) && Branch.access$1700(Branch.this) != NINITIALISED)
        {
            Branch.access$2600(Branch.this);
            return;
        }
        break MISSING_BLOCK_LABEL_746;
_L6:
        Log.i("BranchSDK", "Branch API Error: Conflicting resource error code from API");
        Branch.access$1900(Branch.this, 0, j);
          goto _L7
_L4:
        Object obj;
        Branch.access$1602(Branch.this, false);
        obj = new ArrayList();
        int i = 0;
_L9:
        if (i >= Branch.access$1800(Branch.this).getSize())
        {
            break; /* Loop/switch isn't completed */
        }
        ((ArrayList) (obj)).add(Branch.access$1800(Branch.this).peekAt(i));
        i++;
        if (true) goto _L9; else goto _L8
_L8:
        Object obj1 = ((ArrayList) (obj)).iterator();
_L12:
        ServerRequest serverrequest;
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_278;
        }
        serverrequest = (ServerRequest)((Iterator) (obj1)).next();
        if (serverrequest == null) goto _L11; else goto _L10
_L10:
        if (serverrequest.shouldRetryOnFail()) goto _L12; else goto _L11
_L11:
        Branch.access$1800(Branch.this).remove(serverrequest);
          goto _L12
        Branch.access$2002(Branch.this, 0);
        obj = ((ArrayList) (obj)).iterator();
_L15:
        if (!((Iterator) (obj)).hasNext()) goto _L7; else goto _L13
_L13:
        obj1 = (ServerRequest)((Iterator) (obj)).next();
        if (obj1 == null) goto _L15; else goto _L14
_L14:
        ((ServerRequest) (obj1)).handleFailure(j, serverresponse.getFailReason());
        if (((ServerRequest) (obj1)).shouldRetryOnFail())
        {
            ((ServerRequest) (obj1)).clearCallbacks();
        }
          goto _L15
_L2:
        Branch.access$1602(Branch.this, true);
        if (!(thisReq_ instanceof ServerRequestCreateUrl)) goto _L17; else goto _L16
_L16:
        if (serverresponse.getObject() != null)
        {
            obj = serverresponse.getObject().getString("url");
            Branch.access$2100(Branch.this).put(serverresponse.getLinkData(), obj);
        }
_L20:
        Branch.access$1800(Branch.this).dequeue();
        if (!(thisReq_ instanceof ServerRequestInitSession) && !(thisReq_ instanceof ServerRequestIdentifyUserRequest))
        {
            break MISSING_BLOCK_LABEL_732;
        }
        if (serverresponse.getObject() == null) goto _L7; else goto _L18
_L18:
        i = 0;
        if (!serverresponse.getObject().has(nID.()))
        {
            break MISSING_BLOCK_LABEL_476;
        }
        Branch.access$100(Branch.this).setSessionID(serverresponse.getObject().getString(nID.()));
        i = 1;
        j = i;
        if (!serverresponse.getObject().has(tyID.()))
        {
            break MISSING_BLOCK_LABEL_569;
        }
        obj = serverresponse.getObject().getString(tyID.());
        j = i;
        if (Branch.access$100(Branch.this).getIdentityID().equals(obj))
        {
            break MISSING_BLOCK_LABEL_569;
        }
        Branch.access$2100(Branch.this).clear();
        Branch.access$100(Branch.this).setIdentityID(serverresponse.getObject().getString(tyID.()));
        j = 1;
        if (!serverresponse.getObject().has(FingerprintID.()))
        {
            break MISSING_BLOCK_LABEL_611;
        }
        Branch.access$100(Branch.this).setDeviceFingerPrintID(serverresponse.getObject().getString(FingerprintID.()));
        j = 1;
        if (!j)
        {
            break MISSING_BLOCK_LABEL_623;
        }
        Branch.access$2200(Branch.this);
        if (!(thisReq_ instanceof ServerRequestInitSession))
        {
            break MISSING_BLOCK_LABEL_718;
        }
        Branch.access$1702(Branch.this, NITIALISED);
        thisReq_.onRequestSucceeded(serverresponse, Branch.access$2300());
        Branch.access$2402(Branch.this, ((ServerRequestInitSession)thisReq_).hasCallBack());
        Branch.access$2500(Branch.this);
          goto _L7
_L17:
        if (!(thisReq_ instanceof ServerRequestLogout)) goto _L20; else goto _L19
_L19:
        Branch.access$2100(Branch.this).clear();
        Branch.access$1800(Branch.this).clear();
          goto _L20
        thisReq_.onRequestSucceeded(serverresponse, Branch.access$2300());
          goto _L7
        thisReq_.onRequestSucceeded(serverresponse, Branch.access$2300());
          goto _L7
    }

    protected volatile void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "Branch$BranchPostTask#onPostExecute", null);
_L1:
        onPostExecute((ServerResponse)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "Branch$BranchPostTask#onPostExecute", null);
          goto _L1
    }

    public serRequest(ServerRequest serverrequest)
    {
        this$0 = Branch.this;
        super();
        timeOut_ = 0;
        thisReq_ = serverrequest;
        timeOut_ = Branch.access$100(Branch.this).getTimeout();
    }
}
