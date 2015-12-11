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
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            GetFollowsLoadTask, EmptyResponse, InterestDescriptor, BaseFollowInterestRequest

public final class CreateFollowLoadTask extends AsyncTask
{
    public static class CreateFollowRequest extends BaseFollowInterestRequest
    {

        public static final String OPERATION_NAME = "createFollow";
        public static final String SERVICE_NAME = "FollowService";
        final FollowDescriptor followDescriptor = new FollowDescriptor();

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return DataMapperFactory.getDefaultMapper().toJson(followDescriptor).getBytes();
        }

        public URL getRequestUrl()
        {
            URL url;
            try
            {
                url = new URL(ApiSettings.getUrl(EbaySettings.followBaseUrl), "relation");
            }
            catch (MalformedURLException malformedurlexception)
            {
                throw new RuntimeException(malformedurlexception);
            }
            return url;
        }

        public EmptyResponse getResponse()
        {
            EmptyResponse emptyresponse = new EmptyResponse();
            emptyresponse.setSuccessCodes(Arrays.asList(new Integer[] {
                Integer.valueOf(200), Integer.valueOf(201)
            }));
            return emptyresponse;
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

        public CreateFollowRequest(String s, FollowType followtype, String s1, String s2, String s3)
        {
            super("FollowService", "createFollow", s2, s3);
            followDescriptor.customTitle = s1;
            followDescriptor.id = s;
            followDescriptor.type = followtype;
            if (followtype != FollowType.INTEREST)
            {
                followDescriptor.visibility = com.ebay.common.model.followinterest.FollowDescriptor.Visibility.PUBLIC;
            }
        }
    }

    public static interface Observer
    {

        public abstract void handleFollowCreated(CreateFollowLoadTask createfollowloadtask, Content content);
    }

    public static class Params
    {

        public String customTitle;
        public FollowType followType;
        public String iafToken;
        public String id;
        public InterestDescriptor interestDescriptor;
        public String marketPlaceId;

        public Params()
        {
        }
    }


    private final EbayContext ebayContext;
    private final Observer observer;

    public CreateFollowLoadTask(EbayContext ebaycontext, Observer observer1)
    {
        ebayContext = ebaycontext;
        observer = observer1;
    }

    protected transient Content doInBackground(Params aparams[])
    {
        Params params;
        Content content = new Content(ResultStatus.CANCELED);
        if (aparams == null || aparams.length != 1)
        {
            cancel(false);
            return content;
        }
        params = aparams[0];
        if (params.iafToken == null)
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
                    $SwitchMap$com$ebay$common$model$followinterest$FollowType[FollowType.INTEREST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$common$model$followinterest$FollowType[FollowType.USER.ordinal()] = 2;
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

        _cls1..SwitchMap.com.ebay.common.model.followinterest.FollowType[params.followType.ordinal()];
        JVM INSTR tableswitch 1 2: default 84
    //                   1 267
    //                   2 282;
           goto _L1 _L2 _L3
_L1:
        aparams = params.id;
_L10:
        EmptyResponse emptyresponse;
        ResultStatus resultstatus;
        CreateFollowRequest createfollowrequest;
        createfollowrequest = new CreateFollowRequest(aparams, params.followType, params.customTitle, params.iafToken, params.marketPlaceId);
        GetFollowsLoadTask.invalidateCache((Context)ebayContext.getExtension(android/content/Context));
        emptyresponse = null;
        resultstatus = ResultStatus.CANCELED;
        Object obj = (EmptyResponse)ebayContext.getConnector().sendRequest(createfollowrequest);
        emptyresponse = ((EmptyResponse) (obj));
        ResultStatus resultstatus1 = ((EmptyResponse) (obj)).getResultStatus();
        resultstatus = resultstatus1;
        emptyresponse = ((EmptyResponse) (obj));
_L12:
        if (emptyresponse == null || resultstatus.hasError()) goto _L5; else goto _L4
_L4:
        obj = FollowDescriptor.create(createfollowrequest.followDescriptor);
        obj.id = aparams;
        obj.followDate = EbayDateUtils.formatIso8601DateTime(new Date());
        _cls1..SwitchMap.com.ebay.common.model.followinterest.FollowType[params.followType.ordinal()];
        JVM INSTR tableswitch 1 3: default 252
    //                   1 309
    //                   2 326
    //                   3 347;
           goto _L6 _L7 _L8 _L9
_L6:
        aparams = new Content(obj, emptyresponse.getResultStatus());
_L11:
        return aparams;
_L2:
        aparams = Long.toString(params.interestDescriptor.interestId);
          goto _L10
_L3:
        aparams = (new StringBuilder()).append("~").append(params.id).toString();
          goto _L10
_L7:
        obj.interest = params.interestDescriptor;
        obj.interestId = aparams;
          goto _L6
_L8:
        obj.username = params.id;
        obj.id = params.id;
          goto _L6
_L9:
        obj.collectionId = params.id;
          goto _L6
_L5:
        aparams = new Content(resultstatus);
          goto _L11
        InterruptedException interruptedexception;
        interruptedexception;
          goto _L12
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Params[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        observer.handleFollowCreated(this, new Content(ResultStatus.CANCELED));
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        observer.handleFollowCreated(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }
}
