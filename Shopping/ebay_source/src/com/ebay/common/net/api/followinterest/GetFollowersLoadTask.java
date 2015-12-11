// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.Response;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestRequest, BaseFollowInterestResponse

public final class GetFollowersLoadTask extends AsyncTask
{
    public static class FollowerSummary
    {

        public Integer followerCount;

        public FollowerSummary()
        {
        }
    }

    private static class GetFollowersRequest extends BaseFollowInterestRequest
    {

        private static final String OPERATION_NAME = "getFollowersForUser";
        private static final String SERVICE_NAME = "FollowService";
        private URL url;

        public URL getRequestUrl()
        {
            return url;
        }

        public GetFollowersResponse getResponse()
        {
            return new GetFollowersResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected boolean isIdempotent()
        {
            return true;
        }

        GetFollowersRequest(String s, String s1, FollowType followtype, String s2)
        {
            super("FollowService", "getFollowersForUser", s, s1);
            switch (_cls1..SwitchMap.com.ebay.common.model.followinterest.FollowType[followtype.ordinal()])
            {
            default:
                break MISSING_BLOCK_LABEL_124;

            case 1: // '\001'
                break;
            }
              goto _L1
_L2:
            url = new URL((new StringBuilder()).append(ApiSettings.get(EbaySettings.followBaseUrl)).append("followers/").append(followtype).append("/").append(s).append("?limit=0").toString());
            return;
_L1:
            try
            {
                s = (new StringBuilder()).append("~").append(s2).toString();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new RuntimeException(s);
            }
              goto _L2
            s = s2;
              goto _L2
        }
    }

    public static class GetFollowersResponse extends BaseFollowInterestResponse
    {

        FollowerSummary followerSummary;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            followerSummary = new FollowerSummary();
            inputstream = (FollowerResponseDTO)readJsonStream(inputstream, com/ebay/common/net/api/followinterest/GetFollowersLoadTask$GetFollowersResponse$FollowerResponseDTO);
            followerSummary = new FollowerSummary();
            followerSummary.followerCount = ((FollowerResponseDTO) (inputstream)).total;
        }

        public GetFollowersResponse()
        {
            super(true);
        }
    }

    public class GetFollowersResponse.FollowerResponseDTO
    {

        final GetFollowersResponse this$0;
        public Integer total;
        public List users;

        public GetFollowersResponse.FollowerResponseDTO()
        {
            this$0 = GetFollowersResponse.this;
            super();
        }
    }

    public static interface Observer
    {

        public abstract void handleFollowersLoaded(GetFollowersLoadTask getfollowersloadtask, Content content);
    }

    public static class Params
    {

        public FollowType followType;
        public String iafToken;
        public String id;
        public String marketPlaceId;

        public Params()
        {
        }
    }


    private final EbayContext ebayContext;
    private final Observer observer;

    public GetFollowersLoadTask(EbayContext ebaycontext, Observer observer1)
    {
        ebayContext = ebaycontext;
        observer = observer1;
    }

    protected transient Content doInBackground(Params aparams[])
    {
        Object obj;
        ResultStatus resultstatus;
        obj = new Content(ResultStatus.CANCELED);
        if (aparams == null || aparams.length != 1)
        {
            cancel(false);
            return ((Content) (obj));
        }
        aparams = aparams[0];
        if (TextUtils.isEmpty(((Params) (aparams)).iafToken) || TextUtils.isEmpty(((Params) (aparams)).id) || TextUtils.isEmpty(((Params) (aparams)).marketPlaceId))
        {
            cancel(false);
            return null;
        }
        obj = new GetFollowersRequest(((Params) (aparams)).iafToken, ((Params) (aparams)).marketPlaceId, ((Params) (aparams)).followType, ((Params) (aparams)).id);
        resultstatus = ResultStatus.CANCELED;
        aparams = null;
        obj = (GetFollowersResponse)ebayContext.getConnector().sendRequest(((com.ebay.nautilus.kernel.net.Request) (obj)));
        aparams = ((Params []) (obj));
        ResultStatus resultstatus1 = ((GetFollowersResponse) (obj)).getResultStatus();
        resultstatus = resultstatus1;
        aparams = ((Params []) (obj));
_L2:
        if (aparams != null && !resultstatus.hasError() && ((GetFollowersResponse) (aparams)).followerSummary != null)
        {
            aparams = new Content(((GetFollowersResponse) (aparams)).followerSummary, aparams.getResultStatus());
        } else
        {
            aparams = new Content(resultstatus);
        }
        return aparams;
        InterruptedException interruptedexception;
        interruptedexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Params[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        observer.handleFollowersLoaded(this, new Content(ResultStatus.CANCELED));
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        observer.handleFollowersLoaded(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    // Unreferenced inner class com/ebay/common/net/api/followinterest/GetFollowersLoadTask$1

/* anonymous class */
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
            catch (NoSuchFieldError nosuchfielderror) { }
        }
    }

}
