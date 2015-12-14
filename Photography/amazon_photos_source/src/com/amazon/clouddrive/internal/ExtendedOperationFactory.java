// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.configuration.AccountConfiguration;
import com.amazon.clouddrive.configuration.ClientConfiguration;
import com.amazon.clouddrive.extended.model.BulkAddRemoveChildRequest;
import com.amazon.clouddrive.extended.model.BulkTrashRestoreNodesRequest;
import com.amazon.clouddrive.extended.model.GetServicePlansRequest;
import com.amazon.clouddrive.extended.model.GetSplashRequest;
import com.amazon.clouddrive.extended.model.GetSubscriptionsRequest;
import com.amazon.clouddrive.extended.model.SetupAccountRequest;
import com.amazon.clouddrive.extended.model.deserializer.BulkAddRemoveChildResponseDeserializer;
import com.amazon.clouddrive.extended.model.deserializer.BulkTrashRestoreNodesResponseDeserializer;
import com.amazon.clouddrive.extended.model.deserializer.GetServicePlansResponseDeserializer;
import com.amazon.clouddrive.extended.model.deserializer.GetSplashResponseDeserializer;
import com.amazon.clouddrive.extended.model.deserializer.GetSubscriptionsResponseDeserializer;
import com.amazon.clouddrive.extended.model.serializer.BulkAddRemoveChildRequestSerializer;
import com.amazon.clouddrive.extended.model.serializer.BulkTrashRestoreNodesRequestSerializer;
import com.amazon.clouddrive.extended.model.serializer.SetupAccountRequestSerializer;
import com.amazon.clouddrive.metrics.MetricListener;
import com.amazon.clouddrive.utils.AssertUtils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.clouddrive.internal:
//            OperationFactory, RequestPathGenerator, SourceInfoGenerator, SinglePartPostRequestWriter, 
//            CloudDriveBodyOperation, CloudDriveMethodOperation, CloudDriveOperation

public class ExtendedOperationFactory extends OperationFactory
{

    private final AccountConfiguration mAccountConfiguration;
    private final ClientConfiguration mClientConfiguration;
    private final MetricListener mMetricListener;
    private final RequestPathGenerator mRequestPathGenerator;
    private final SourceInfoGenerator mSourceInfoGenerator;

    public ExtendedOperationFactory(AccountConfiguration accountconfiguration, ClientConfiguration clientconfiguration)
    {
        super(accountconfiguration, clientconfiguration);
        mAccountConfiguration = accountconfiguration;
        mClientConfiguration = new ClientConfiguration(clientconfiguration);
        mMetricListener = clientconfiguration.getMetricListener();
        mRequestPathGenerator = new RequestPathGenerator(mClientConfiguration, mAccountConfiguration, this);
        mSourceInfoGenerator = new SourceInfoGenerator(mAccountConfiguration, this);
    }

    public CloudDriveOperation newBulkAddRemoveChildOperation(BulkAddRemoveChildRequest bulkaddremovechildrequest)
    {
        AssertUtils.assertNotNull(bulkaddremovechildrequest, "The request cannot be null.");
        AssertUtils.assertNotNullOrEmpty(bulkaddremovechildrequest.getParentId(), "The parent id must be provided.");
        AssertUtils.assertNotNullOrEmpty(bulkaddremovechildrequest.getOp(), "The operation type must be provided.");
        AssertUtils.assertNotNullOrEmpty(bulkaddremovechildrequest.getNodeIds(), "The list of children must be provided");
        bulkaddremovechildrequest.setResourceVersion("V2");
        Object obj = (new StringBuilder()).append("nodes/").append(bulkaddremovechildrequest.getParentId()).append("/children").toString();
        obj = mRequestPathGenerator.createMetaDataEndpointRequestPath(((String) (obj)));
        SinglePartPostRequestWriter singlepartpostrequestwriter = new SinglePartPostRequestWriter(bulkaddremovechildrequest, BulkAddRemoveChildRequestSerializer.INSTANCE);
        return new CloudDriveBodyOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, singlepartpostrequestwriter, BulkAddRemoveChildResponseDeserializer.INSTANCE, ((RequestPathGenerator.RequestPath) (obj)), "PATCH", "bulkAddRemoveChild", mMetricListener, bulkaddremovechildrequest.getClass());
    }

    public CloudDriveOperation newBulkTrashOrRestoreNodes(BulkTrashRestoreNodesRequest bulktrashrestorenodesrequest)
    {
        AssertUtils.assertNotNull(bulktrashrestorenodesrequest, "The request cannot be null.");
        AssertUtils.assertNotNullOrEmpty(bulktrashrestorenodesrequest.getNodeIds(), "The list of nodes must be provided");
        AssertUtils.assertNotNullOrEmpty(bulktrashrestorenodesrequest.getOp(), "The operation type must be provided.");
        bulktrashrestorenodesrequest.setResourceVersion("V2");
        RequestPathGenerator.RequestPath requestpath = mRequestPathGenerator.createMetaDataEndpointRequestPath("trash");
        requestpath.addParameter("recurse", bulktrashrestorenodesrequest.getRecurse());
        SinglePartPostRequestWriter singlepartpostrequestwriter = new SinglePartPostRequestWriter(bulktrashrestorenodesrequest, BulkTrashRestoreNodesRequestSerializer.INSTANCE);
        return new CloudDriveBodyOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, singlepartpostrequestwriter, BulkTrashRestoreNodesResponseDeserializer.INSTANCE, requestpath, "PATCH", "bulkTrashRestoreRequest", mMetricListener, bulktrashrestorenodesrequest.getClass());
    }

    public CloudDriveOperation newGetServicePlansOperation(GetServicePlansRequest getserviceplansrequest)
    {
        AssertUtils.assertNotNull(getserviceplansrequest, "The request cannot be null.");
        RequestPathGenerator.RequestPath requestpath = mRequestPathGenerator.createMetaDataEndpointRequestPath("account/plans");
        return new CloudDriveMethodOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, "GET", requestpath, GetServicePlansResponseDeserializer.INSTANCE, "getServicePlans", mMetricListener, getserviceplansrequest.getClass());
    }

    public CloudDriveOperation newGetSplashOperation(GetSplashRequest getsplashrequest)
    {
        AssertUtils.assertNotNull(getsplashrequest, "The request cannot be null.");
        RequestPathGenerator.RequestPath requestpath = mRequestPathGenerator.createMetaDataEndpointRequestPath("account/splash");
        String s = getsplashrequest.getDeviceType();
        if (s != null && !s.isEmpty())
        {
            requestpath.addParameter("deviceType", getsplashrequest.getDeviceType());
        }
        return new CloudDriveMethodOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, "GET", requestpath, GetSplashResponseDeserializer.INSTANCE, "getSplash", mMetricListener, getsplashrequest.getClass(), getsplashrequest.getLanguage());
    }

    public CloudDriveOperation newGetSubscriptionsOperation(GetSubscriptionsRequest getsubscriptionsrequest)
    {
        AssertUtils.assertNotNull(getsubscriptionsrequest, "The request cannot be null.");
        RequestPathGenerator.RequestPath requestpath = mRequestPathGenerator.createMetaDataEndpointRequestPath("account/subscriptions");
        if (getsubscriptionsrequest.getInclude() != null)
        {
            for (Iterator iterator = getsubscriptionsrequest.getInclude().iterator(); iterator.hasNext(); requestpath.addParameter("include", (String)iterator.next())) { }
        }
        return new CloudDriveMethodOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, "GET", requestpath, GetSubscriptionsResponseDeserializer.INSTANCE, "getSubscriptions", mMetricListener, getsubscriptionsrequest.getClass());
    }

    public CloudDriveOperation newSetupAccountOperation(SetupAccountRequest setupaccountrequest)
    {
        AssertUtils.assertNotNull(setupaccountrequest, "The request cannot be null.");
        SinglePartPostRequestWriter singlepartpostrequestwriter = new SinglePartPostRequestWriter(setupaccountrequest, SetupAccountRequestSerializer.INSTANCE);
        RequestPathGenerator.RequestPath requestpath = mRequestPathGenerator.createMetaDataEndpointRequestPath("account");
        return new CloudDriveBodyOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, singlepartpostrequestwriter, null, requestpath, "POST", "setupAccount", mMetricListener, setupaccountrequest.getClass());
    }
}
