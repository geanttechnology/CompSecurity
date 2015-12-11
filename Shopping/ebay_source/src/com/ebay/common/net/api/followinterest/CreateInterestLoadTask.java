// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestRequest, InterestDescriptor, SaasSearchRequest, BaseFollowInterestResponse

public class CreateInterestLoadTask extends AsyncTask
{
    public static class CreateInterestRequest extends BaseFollowInterestRequest
    {

        public static final String OPERATION_NAME = "createInterest";
        public static final String SERVICE_NAME = "InterestService";
        final CreateInterestRootElement interestContainer;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return DataMapperFactory.getDefaultMapper().toJson(interestContainer).getBytes();
        }

        public URL getRequestUrl()
        {
            URL url;
            try
            {
                url = new URL(ApiSettings.getUrl(EbaySettings.interestBaseUrl), "metadata");
            }
            catch (MalformedURLException malformedurlexception)
            {
                throw new RuntimeException(malformedurlexception);
            }
            return url;
        }

        public CreateInterestResponse getResponse()
        {
            return new CreateInterestResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected boolean isIdempotent()
        {
            return true;
        }

        public CreateInterestRequest(SearchParameters searchparameters, String s)
        {
            super("InterestService", "createInterest", s, searchparameters.country.getSiteGlobalId());
            interestContainer = new CreateInterestRootElement(searchparameters);
        }
    }

    public static class CreateInterestResponse extends BaseFollowInterestResponse
    {

        public InterestDescriptor interestDescriptor;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            interestDescriptor = (InterestDescriptor)readJsonStream(inputstream, com/ebay/common/net/api/followinterest/InterestDescriptor);
        }

        public CreateInterestResponse()
        {
            super(true);
            interestDescriptor = new InterestDescriptor();
        }
    }

    private static class CreateInterestRootElement
    {

        public static final String CREATION_TYPE_INTEREST = "interest";
        public final InterestDescriptor interest = new InterestDescriptor();
        public String type;

        public CreateInterestRootElement(SearchParameters searchparameters)
        {
            type = "interest";
            interest.marketplaceId = searchparameters.country.getSiteGlobalId();
            interest.searchUrl = null;
            interest.searchRequest = SaasSearchRequest.fromSearchParameters(searchparameters);
        }
    }

    public static interface Observer
    {

        public abstract void handleInterestCreated(CreateInterestLoadTask createinterestloadtask, Content content);
    }

    public static class Params
    {

        public String iafToken;
        public SearchParameters searchParameters;

        public Params()
        {
        }
    }


    private final EbayContext ebayContext;
    private final Observer observer;

    public CreateInterestLoadTask(EbayContext ebaycontext, Observer observer1)
    {
        ebayContext = ebaycontext;
        observer = observer1;
    }

    protected transient Content doInBackground(Params aparams[])
    {
        Object obj;
        ResultStatus resultstatus;
        if (aparams == null || aparams.length != 1)
        {
            cancel(false);
            return null;
        }
        aparams = aparams[0];
        if (TextUtils.isEmpty(((Params) (aparams)).iafToken) || ((Params) (aparams)).searchParameters == null)
        {
            cancel(false);
            return null;
        }
        obj = new CreateInterestRequest(((Params) (aparams)).searchParameters, ((Params) (aparams)).iafToken);
        aparams = null;
        resultstatus = ResultStatus.CANCELED;
        obj = (CreateInterestResponse)ebayContext.getConnector().sendRequest(((com.ebay.nautilus.kernel.net.Request) (obj)));
        aparams = ((Params []) (obj));
        ResultStatus resultstatus1 = ((CreateInterestResponse) (obj)).getResultStatus();
        resultstatus = resultstatus1;
        aparams = ((Params []) (obj));
_L2:
        if (aparams != null && !resultstatus.hasError() && ((CreateInterestResponse) (aparams)).interestDescriptor != null)
        {
            return new Content(((CreateInterestResponse) (aparams)).interestDescriptor, aparams.getResultStatus());
        } else
        {
            return new Content(resultstatus);
        }
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
        observer.handleInterestCreated(this, new Content(ResultStatus.CANCELED));
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        observer.handleInterestCreated(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }
}
