// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import android.content.Context;
import android.os.AsyncTask;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            GetFollowsLoadTask, EmptyResponse, BaseFollowInterestRequest, BaseFollowInterestResponse

public final class UpdateFollowLoadTask extends AsyncTask
{
    private static class GetSingleFollowRequest extends BaseFollowInterestRequest
    {

        private static final String OPERATION_NAME = "getSingleFollow";
        private static final String SERVICE_NAME = "FollowService";
        private URL url;

        public URL getRequestUrl()
        {
            return url;
        }

        public GetSingleFollowResponse getResponse()
        {
            return new GetSingleFollowResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected boolean isIdempotent()
        {
            return true;
        }

        GetSingleFollowRequest(String s, String s1, FollowType followtype, String s2)
        {
            super("FollowService", "getSingleFollow", s, s1);
            try
            {
                url = new URL((new StringBuilder()).append(ApiSettings.get(EbaySettings.followBaseUrl)).append("relation/").append(followtype).append("/").append(s2).toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new RuntimeException(s);
            }
        }
    }

    private static class GetSingleFollowResponse extends BaseFollowInterestResponse
    {

        FollowDescriptor follow;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            follow = new FollowDescriptor();
            follow = (FollowDescriptor)readJsonStream(inputstream, com/ebay/common/model/followinterest/FollowDescriptor);
        }

        public GetSingleFollowResponse()
        {
            super(true);
        }
    }

    public static interface Observer
    {

        public abstract void handleFollowUpdated(UpdateFollowLoadTask updatefollowloadtask, Content content);
    }

    public static class Params
    {

        public String customTitle;
        public String entityId;
        public FollowType followType;
        public String iafToken;
        public String marketPlaceId;
        public List notifications;
        public FollowDescriptor originalFollow;

        public Params()
        {
        }
    }

    public static class PutFollowRequest extends BaseFollowInterestRequest
    {

        private static final String OPERATION_NAME = "putSingleFollow";
        private static final String SERVICE_NAME = "FollowService";
        final FollowDescriptor followDescriptor;
        private URL requestURL;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return DataMapperFactory.getDefaultMapper().toJson(followDescriptor).getBytes();
        }

        public String getHttpMethod()
        {
            return "PUT";
        }

        public URL getRequestUrl()
        {
            return requestURL;
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

        public PutFollowRequest(String s, String s1, String s2, FollowType followtype, FollowDescriptor followdescriptor)
        {
            super("FollowService", "putSingleFollow", s, s1);
            followDescriptor = followdescriptor;
            followDescriptor.type = null;
            followDescriptor.interestId = null;
            followDescriptor.followDate = null;
            followDescriptor.id = null;
            try
            {
                requestURL = new URL((new StringBuilder()).append(ApiSettings.get(EbaySettings.followBaseUrl)).append("relation/").append(followtype).append("/").append(s2).toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new RuntimeException(s);
            }
        }
    }


    private final EbayContext ebayContext;
    private final Observer observer;

    public UpdateFollowLoadTask(EbayContext ebaycontext, Observer observer1)
    {
        ebayContext = ebaycontext;
        observer = observer1;
    }

    protected transient Content doInBackground(Params aparams[])
    {
        Object obj;
        Params params;
        obj = new Content(ResultStatus.CANCELED);
        if (aparams == null || aparams.length != 1)
        {
            cancel(false);
            return ((Content) (obj));
        }
        params = aparams[0];
        aparams = FollowDescriptor.create(params.originalFollow);
        obj = aparams;
        if (aparams != null) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj = new GetSingleFollowRequest(params.iafToken, params.marketPlaceId, params.followType, params.entityId);
        aparams = null;
        obj1 = ResultStatus.CANCELED;
        obj = (GetSingleFollowResponse)ebayContext.getConnector().sendRequest(((com.ebay.nautilus.kernel.net.Request) (obj)));
        aparams = ((Params []) (obj));
        ResultStatus resultstatus = ((GetSingleFollowResponse) (obj)).getResultStatus();
        obj1 = resultstatus;
        aparams = ((Params []) (obj));
_L6:
        if (aparams == null || ((ResultStatus) (obj1)).hasError())
        {
            return null;
        }
        obj = ((GetSingleFollowResponse) (aparams)).follow;
_L2:
        if (params.notifications != null)
        {
            obj.notifications = params.notifications;
        }
        if (params.customTitle != null)
        {
            obj.customTitle = params.customTitle;
        }
        obj1 = new PutFollowRequest(params.iafToken, params.marketPlaceId, params.entityId, params.followType, ((FollowDescriptor) (obj)));
        GetFollowsLoadTask.invalidateCache((Context)ebayContext.getExtension(android/content/Context));
        resultstatus = ResultStatus.CANCELED;
        aparams = null;
        obj1 = (EmptyResponse)ebayContext.getConnector().sendRequest(((com.ebay.nautilus.kernel.net.Request) (obj1)));
        aparams = ((Params []) (obj1));
        ResultStatus resultstatus1 = ((EmptyResponse) (obj1)).getResultStatus();
        resultstatus = resultstatus1;
        aparams = ((Params []) (obj1));
_L4:
        if (aparams != null && !resultstatus.hasError())
        {
            obj.interestId = params.entityId;
            aparams = new Content(obj, aparams.getResultStatus());
        } else
        {
            aparams = new Content(resultstatus);
        }
        return aparams;
        InterruptedException interruptedexception1;
        interruptedexception1;
        if (true) goto _L4; else goto _L3
_L3:
        InterruptedException interruptedexception;
        interruptedexception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Params[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        observer.handleFollowUpdated(this, new Content(ResultStatus.CANCELED));
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        observer.handleFollowUpdated(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }
}
