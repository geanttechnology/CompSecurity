// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            GetFollowsLoadTask, EmptyResponse, BaseFollowInterestRequest

public final class DeleteFollowLoadTask extends AsyncTask
{
    public static class DeleteFollowRequest extends BaseFollowInterestRequest
    {

        private static final String OPERATION_NAME = "deleteFollowByInterest";
        private static final String SERVICE_NAME = "FollowService";
        private final String followTypeString;
        private final String id;

        public String getHttpMethod()
        {
            return "DELETE";
        }

        public URL getRequestUrl()
        {
            URL url;
            try
            {
                url = new URL(ApiSettings.getUrl(EbaySettings.followBaseUrl), (new StringBuilder()).append("relation/").append(followTypeString).append("/").append(id).toString());
            }
            catch (MalformedURLException malformedurlexception)
            {
                throw new RuntimeException(malformedurlexception);
            }
            return url;
        }

        public EmptyResponse getResponse()
        {
            return new EmptyResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected boolean isIdempotent()
        {
            return true;
        }

        public void onAddHeaders(IHeaders iheaders)
        {
            super.onAddHeaders(iheaders);
            maybeDisableGzip(iheaders);
        }

        public DeleteFollowRequest(String s, String s1, String s2)
        {
            super("FollowService", "deleteFollowByInterest", s2, null);
            id = s1;
            followTypeString = s;
        }
    }

    public static interface Observer
    {

        public abstract void handleFollowDeleted(DeleteFollowLoadTask deletefollowloadtask, ResultStatus resultstatus);
    }

    public static class Params
    {

        public FollowType followType;
        public String iafToken;
        public String id;

        public Params()
        {
        }
    }


    private final EbayContext ebayContext;
    private final Observer observer;

    public DeleteFollowLoadTask(EbayContext ebaycontext, Observer observer1)
    {
        ebayContext = ebaycontext;
        observer = observer1;
    }

    protected transient ResultStatus doInBackground(Params aparams[])
    {
        Object obj;
        obj = ResultStatus.CANCELED;
        if (aparams == null || aparams.length != 1)
        {
            cancel(false);
            return ((ResultStatus) (obj));
        }
        obj = aparams[0];
        if (TextUtils.isEmpty(((Params) (obj)).iafToken) || TextUtils.isEmpty(((Params) (obj)).id))
        {
            cancel(false);
            return null;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$common$model$followinterest$FollowType[];

            static 
            {
                $SwitchMap$com$ebay$common$model$followinterest$FollowType = new int[FollowType.values().length];
                try
                {
                    $SwitchMap$com$ebay$common$model$followinterest$FollowType[FollowType.USER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$common$model$followinterest$FollowType[FollowType.INTEREST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$common$model$followinterest$FollowType[FollowType.COLLECTION.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.common.model.followinterest.FollowType[((Params) (obj)).followType.ordinal()];
        JVM INSTR tableswitch 1 1: default 84
    //                   1 176;
           goto _L1 _L2
_L1:
        aparams = ((Params) (obj)).id;
_L3:
        ResultStatus resultstatus;
        obj = new DeleteFollowRequest(((Params) (obj)).followType.toString(), aparams, ((Params) (obj)).iafToken);
        GetFollowsLoadTask.invalidateCache((Context)ebayContext.getExtension(android/content/Context));
        aparams = null;
        resultstatus = ResultStatus.CANCELED;
        obj = (EmptyResponse)ebayContext.getConnector().sendRequest(((com.ebay.nautilus.kernel.net.Request) (obj)));
        aparams = ((Params []) (obj));
        ResultStatus resultstatus1 = ((EmptyResponse) (obj)).getResultStatus();
        aparams = resultstatus1;
_L4:
        if (obj != null && !aparams.hasError())
        {
            aparams = ((EmptyResponse) (obj)).getResultStatus();
        }
        return aparams;
_L2:
        aparams = (new StringBuilder()).append("~").append(((Params) (obj)).id).toString();
          goto _L3
        InterruptedException interruptedexception;
        interruptedexception;
        interruptedexception = aparams;
        aparams = resultstatus;
          goto _L4
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Params[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        if (observer != null)
        {
            observer.handleFollowDeleted(this, ResultStatus.CANCELED);
        }
    }

    protected void onPostExecute(ResultStatus resultstatus)
    {
        super.onPostExecute(resultstatus);
        if (observer != null)
        {
            observer.handleFollowDeleted(this, resultstatus);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }
}
