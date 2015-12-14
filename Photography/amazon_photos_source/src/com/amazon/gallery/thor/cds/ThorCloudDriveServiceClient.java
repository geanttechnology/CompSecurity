// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.content.Context;
import com.amazon.clouddrive.configuration.AccountConfiguration;
import com.amazon.clouddrive.configuration.ClientConfiguration;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.exceptions.Forbidden;
import com.amazon.clouddrive.extended.model.GetServicePlansRequest;
import com.amazon.clouddrive.extended.model.GetServicePlansResponse;
import com.amazon.clouddrive.extended.model.GetSubscriptionsRequest;
import com.amazon.clouddrive.extended.model.GetSubscriptionsResponse;
import com.amazon.clouddrive.extended.model.SetupAccountRequest;
import com.amazon.clouddrive.model.GetAccountQuotaRequest;
import com.amazon.clouddrive.model.GetAccountQuotaResponse;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.concurrent.ExecutorService;

public class ThorCloudDriveServiceClient extends MixtapeCloudDriveServiceClient
{

    private static final String TAG = com/amazon/gallery/thor/cds/ThorCloudDriveServiceClient.getSimpleName();

    public ThorCloudDriveServiceClient(AccountConfiguration accountconfiguration, ClientConfiguration clientconfiguration, ExecutorService executorservice, Context context, String s, String s1)
    {
        super(accountconfiguration, clientconfiguration, executorservice, context, s, s1);
    }

    public GetAccountQuotaResponse getAccountQuota(GetAccountQuotaRequest getaccountquotarequest)
        throws CloudDriveException, InterruptedException
    {
        GetAccountQuotaResponse getaccountquotaresponse;
        try
        {
            getaccountquotaresponse = super.getAccountQuota(getaccountquotarequest);
        }
        catch (Forbidden forbidden)
        {
            setupAccount(new SetupAccountRequest());
            super.getAccountQuota(getaccountquotarequest);
            return null;
        }
        return getaccountquotaresponse;
    }

    public GetServicePlansResponse getServicePlans(GetServicePlansRequest getserviceplansrequest)
        throws CloudDriveException, InterruptedException
    {
        GetServicePlansResponse getserviceplansresponse;
        try
        {
            getserviceplansresponse = super.getServicePlans(getserviceplansrequest);
        }
        catch (Forbidden forbidden)
        {
            setupAccount(new SetupAccountRequest());
            super.getServicePlans(getserviceplansrequest);
            return null;
        }
        return getserviceplansresponse;
    }

    public GetSubscriptionsResponse getSubscriptions(GetSubscriptionsRequest getsubscriptionsrequest)
        throws CloudDriveException, InterruptedException
    {
        GetSubscriptionsResponse getsubscriptionsresponse;
        try
        {
            getsubscriptionsresponse = super.getSubscriptions(getsubscriptionsrequest);
        }
        catch (Forbidden forbidden)
        {
            setupAccount(new SetupAccountRequest());
            super.getSubscriptions(getsubscriptionsrequest);
            return null;
        }
        return getsubscriptionsresponse;
    }

    public void setupAccount(SetupAccountRequest setupaccountrequest)
        throws CloudDriveException, InterruptedException
    {
        setupaccountrequest.setTermsOfUse("1.0.0");
        super.setupAccount(setupaccountrequest);
    }

}
