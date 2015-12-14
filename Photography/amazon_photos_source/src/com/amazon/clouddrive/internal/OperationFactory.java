// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.configuration.AccountConfiguration;
import com.amazon.clouddrive.configuration.ClientConfiguration;
import com.amazon.clouddrive.handlers.ProgressListener;
import com.amazon.clouddrive.metrics.MetricListener;
import com.amazon.clouddrive.model.AddChildToParentRequest;
import com.amazon.clouddrive.model.CreateNodeRequest;
import com.amazon.clouddrive.model.DownloadFileRequest;
import com.amazon.clouddrive.model.GetAccountEndpointRequest;
import com.amazon.clouddrive.model.GetAccountQuotaRequest;
import com.amazon.clouddrive.model.GetChangesRequest;
import com.amazon.clouddrive.model.GetNodeRequest;
import com.amazon.clouddrive.model.ListChildrenRequest;
import com.amazon.clouddrive.model.ListNodesRequest;
import com.amazon.clouddrive.model.RemoveChildFromParentRequest;
import com.amazon.clouddrive.model.SetupSourceRequest;
import com.amazon.clouddrive.model.UpdateCollectionPropertiesRequest;
import com.amazon.clouddrive.model.UpdateNodeRequest;
import com.amazon.clouddrive.model.UploadFileRequest;
import com.amazon.clouddrive.model.deserializer.CollectionPropertiesResponseDeserializer;
import com.amazon.clouddrive.model.deserializer.GetAccountEndpointResponseDeserializer;
import com.amazon.clouddrive.model.deserializer.GetAccountQuotaResponseDeserializer;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.deserializer.SourceInfoResponseDeserializer;
import com.amazon.clouddrive.model.serializer.CreateNodeRequestSerializer;
import com.amazon.clouddrive.model.serializer.GetChangesRequestSerializer;
import com.amazon.clouddrive.model.serializer.SetupSourceRequestSerializer;
import com.amazon.clouddrive.model.serializer.UpdateCollectionPropertiesRequestSerializer;
import com.amazon.clouddrive.model.serializer.UpdateNodeRequestSerializer;
import com.amazon.clouddrive.utils.Optional;
import com.amazon.clouddrive.utils.TransformUtils;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.amazon.clouddrive.internal:
//            RequestPathGenerator, SourceInfoGenerator, RequestAssertUtils, CloudDriveMethodOperation, 
//            SinglePartPostRequestWriter, CloudDriveBodyOperation, DownloadFileOperation, UploadFileOperation, 
//            MultiPartPostBodyWriter, CloudDriveOperation

public class OperationFactory
{

    protected final String RESOURCE_VERSION = "V2";
    private final AccountConfiguration mAccountConfiguration;
    private final ClientConfiguration mClientConfiguration;
    private final AtomicLong mDelay = new AtomicLong(0L);
    private final MetricListener mMetricListener;
    private final RequestPathGenerator mRequestPathGenerator;
    private final SourceInfoGenerator mSourceInfoGenerator;

    public OperationFactory(AccountConfiguration accountconfiguration, ClientConfiguration clientconfiguration)
    {
        mAccountConfiguration = accountconfiguration;
        mClientConfiguration = new ClientConfiguration(clientconfiguration);
        mMetricListener = clientconfiguration.getMetricListener();
        mRequestPathGenerator = new RequestPathGenerator(mClientConfiguration, mAccountConfiguration, this);
        mSourceInfoGenerator = new SourceInfoGenerator(mAccountConfiguration, this);
    }

    private void appendResourceVersion(RequestPathGenerator.RequestPath requestpath)
    {
        requestpath.addParameter("resourceVersion", "V2");
    }

    long getOperationDelay()
    {
        return mDelay.get();
    }

    public CloudDriveOperation newAddChildToParentOperation(AddChildToParentRequest addchildtoparentrequest)
    {
        RequestAssertUtils.assertNotNull(addchildtoparentrequest, "The request cannot be null.");
        RequestAssertUtils.assertNotNullOrEmpty(addchildtoparentrequest.getParentId(), "The parent id must be provided.");
        RequestAssertUtils.assertNotNullOrEmpty(addchildtoparentrequest.getChildId(), "The child id must be provided.");
        Object obj = (new StringBuilder()).append("nodes/").append(addchildtoparentrequest.getParentId()).append("/children/").append(addchildtoparentrequest.getChildId()).toString();
        obj = mRequestPathGenerator.createMetaDataEndpointRequestPath(((String) (obj)));
        appendResourceVersion(((RequestPathGenerator.RequestPath) (obj)));
        return new CloudDriveMethodOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, "PUT", ((RequestPathGenerator.RequestPath) (obj)), null, "addChildToParent", mMetricListener, addchildtoparentrequest.getClass());
    }

    public CloudDriveOperation newCreateNodeOperation(CreateNodeRequest createnoderequest, JsonDeserializer jsondeserializer)
    {
        RequestAssertUtils.assertNotNull(createnoderequest, "The request cannot be null.");
        RequestAssertUtils.assertNotNullOrEmpty(createnoderequest.getName(), "A name must be provided when creating a node.");
        RequestAssertUtils.assertNotNullOrEmpty(createnoderequest.getKind(), "A node kind must be provided when creating a node.");
        RequestPathGenerator.RequestPath requestpath = mRequestPathGenerator.createMetaDataEndpointRequestPath("nodes");
        requestpath.addRequestParameters(createnoderequest);
        appendResourceVersion(requestpath);
        SinglePartPostRequestWriter singlepartpostrequestwriter = new SinglePartPostRequestWriter(createnoderequest, CreateNodeRequestSerializer.INSTANCE);
        return new CloudDriveBodyOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, singlepartpostrequestwriter, jsondeserializer, requestpath, "POST", "createNode", mMetricListener, createnoderequest.getClass());
    }

    public CloudDriveOperation newDownloadFileOperation(DownloadFileRequest downloadfilerequest, ProgressListener progresslistener)
    {
        RequestAssertUtils.assertNotNull(downloadfilerequest, "The request cannot be null.");
        RequestAssertUtils.assertNotNullOrEmpty(downloadfilerequest.getId(), "A node id must be provided when downloading a node's content.");
        Object obj = (new StringBuilder("nodes/")).append(downloadfilerequest.getId());
        if (downloadfilerequest.hasTransform())
        {
            Optional optional = TransformUtils.getTransformPathSuffix(downloadfilerequest.getTransform());
            if (!optional.isPresent())
            {
                throw new UnsupportedOperationException((new StringBuilder()).append("Downloading transform ").append(downloadfilerequest.getTransform()).append(" is no supported.").toString());
            }
            ((StringBuilder) (obj)).append((String)optional.get());
        } else
        {
            ((StringBuilder) (obj)).append("/content");
        }
        obj = mRequestPathGenerator.createContentEndpointRequestPath(((StringBuilder) (obj)).toString());
        if (downloadfilerequest.hasViewBoxSet())
        {
            ((RequestPathGenerator.RequestPath) (obj)).addParameter("viewBox", Integer.toString(downloadfilerequest.getViewBox()));
        }
        if (downloadfilerequest.hasResolution())
        {
            ((RequestPathGenerator.RequestPath) (obj)).addParameter("y", String.valueOf(downloadfilerequest.getResolution()));
        }
        return new DownloadFileOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, ((RequestPathGenerator.RequestPath) (obj)), "downloadFile", mMetricListener, progresslistener, downloadfilerequest.getClass(), downloadfilerequest.getOutputStream(), downloadfilerequest.getBlockSize());
    }

    public CloudDriveOperation newGetAccountEndpointOperation(GetAccountEndpointRequest getaccountendpointrequest)
    {
        RequestAssertUtils.assertNotNull(getaccountendpointrequest, "The request cannot be null.");
        RequestPathGenerator.RequestPath requestpath = mRequestPathGenerator.createMasterEndpointRequestPath("account/endpoint");
        return new CloudDriveMethodOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, "GET", requestpath, GetAccountEndpointResponseDeserializer.INSTANCE, "getAccountEndpoint", mMetricListener, getaccountendpointrequest.getClass());
    }

    public CloudDriveOperation newGetAccountQuotaOperation(GetAccountQuotaRequest getaccountquotarequest)
    {
        RequestAssertUtils.assertNotNull(getaccountquotarequest, "The request cannot be null.");
        RequestPathGenerator.RequestPath requestpath = mRequestPathGenerator.createMetaDataEndpointRequestPath("account/quota");
        return new CloudDriveMethodOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, "GET", requestpath, GetAccountQuotaResponseDeserializer.INSTANCE, "getAccountQuota", mMetricListener, getaccountquotarequest.getClass());
    }

    public CloudDriveOperation newGetChangesOperation(GetChangesRequest getchangesrequest, JsonDeserializer jsondeserializer)
    {
        RequestAssertUtils.assertNotNull(getchangesrequest, "The request cannot be null.");
        SinglePartPostRequestWriter singlepartpostrequestwriter = new SinglePartPostRequestWriter(getchangesrequest, GetChangesRequestSerializer.INSTANCE);
        RequestPathGenerator.RequestPath requestpath = mRequestPathGenerator.createMetaDataEndpointRequestPath("changes", "V2");
        return new CloudDriveBodyOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, singlepartpostrequestwriter, jsondeserializer, requestpath, "POST", "getChanges", mMetricListener, getchangesrequest.getClass());
    }

    public CloudDriveOperation newGetNodeOperation(GetNodeRequest getnoderequest, JsonDeserializer jsondeserializer)
    {
        RequestAssertUtils.assertNotNull(getnoderequest, "The request cannot be null.");
        RequestAssertUtils.assertNotNullOrEmpty(getnoderequest.getId(), "A node id must be provided when requesting a node.");
        Object obj = (new StringBuilder()).append("nodes/").append(getnoderequest.getId()).toString();
        obj = mRequestPathGenerator.createMetaDataEndpointRequestPath(((String) (obj)));
        appendResourceVersion(((RequestPathGenerator.RequestPath) (obj)));
        ((RequestPathGenerator.RequestPath) (obj)).addParameter("fields", getnoderequest.getFields());
        ((RequestPathGenerator.RequestPath) (obj)).addParameter("asset", getnoderequest.getAssetMapping());
        ((RequestPathGenerator.RequestPath) (obj)).addParameter("tempLink", getnoderequest.getTempLink());
        return new CloudDriveMethodOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, "GET", ((RequestPathGenerator.RequestPath) (obj)), jsondeserializer, "getNode", mMetricListener, getnoderequest.getClass());
    }

    public CloudDriveOperation newListChildrenOperation(ListChildrenRequest listchildrenrequest, JsonDeserializer jsondeserializer)
    {
        RequestAssertUtils.assertNotNull(listchildrenrequest, "The request cannot be null.");
        RequestAssertUtils.assertNotNullOrEmpty(listchildrenrequest.getId(), "An id must be provided for a list children request.");
        Object obj = (new StringBuilder()).append("nodes/").append(listchildrenrequest.getId()).append("/children").toString();
        obj = mRequestPathGenerator.createMetaDataEndpointRequestPath(((String) (obj)));
        appendResourceVersion(((RequestPathGenerator.RequestPath) (obj)));
        ((RequestPathGenerator.RequestPath) (obj)).addRequestParameters(listchildrenrequest);
        ((RequestPathGenerator.RequestPath) (obj)).addParameter("assetMapping", listchildrenrequest.getAssetMapping());
        ((RequestPathGenerator.RequestPath) (obj)).addParameter("tempLink", listchildrenrequest.getTempLink());
        return new CloudDriveMethodOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, "GET", ((RequestPathGenerator.RequestPath) (obj)), jsondeserializer, "listChildren", mMetricListener, listchildrenrequest.getClass());
    }

    public CloudDriveOperation newListNodesOperation(ListNodesRequest listnodesrequest, JsonDeserializer jsondeserializer)
    {
        RequestAssertUtils.assertNotNull(listnodesrequest, "The request cannot be null.");
        RequestPathGenerator.RequestPath requestpath = mRequestPathGenerator.createMetaDataEndpointRequestPath("nodes");
        appendResourceVersion(requestpath);
        requestpath.addRequestParameters(listnodesrequest);
        requestpath.addParameter("assetMapping", listnodesrequest.getAssetMapping());
        requestpath.addParameter("tempLink", listnodesrequest.getTempLink());
        return new CloudDriveMethodOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, "GET", requestpath, jsondeserializer, "listNodes", mMetricListener, listnodesrequest.getClass());
    }

    public CloudDriveOperation newRemoveChildFromParentOperation(RemoveChildFromParentRequest removechildfromparentrequest)
    {
        RequestAssertUtils.assertNotNull(removechildfromparentrequest, "The request cannot be null.");
        RequestAssertUtils.assertNotNullOrEmpty(removechildfromparentrequest.getParentId(), "The parent id must be provided.");
        RequestAssertUtils.assertNotNullOrEmpty(removechildfromparentrequest.getChildId(), "The child id must be provided.");
        Object obj = (new StringBuilder()).append("nodes/").append(removechildfromparentrequest.getParentId()).append("/children/").append(removechildfromparentrequest.getChildId()).toString();
        obj = mRequestPathGenerator.createMetaDataEndpointRequestPath(((String) (obj)));
        appendResourceVersion(((RequestPathGenerator.RequestPath) (obj)));
        return new CloudDriveMethodOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, "DELETE", ((RequestPathGenerator.RequestPath) (obj)), null, "removeChildFromParent", mMetricListener, removechildfromparentrequest.getClass());
    }

    public CloudDriveOperation newSetupSourceOperation(SetupSourceRequest setupsourcerequest)
    {
        RequestAssertUtils.assertNotNull(setupsourcerequest, "The request cannot be null.");
        RequestAssertUtils.assertNotNullOrEmpty(setupsourcerequest.getDeviceClass(), "The device class must be provided.");
        RequestAssertUtils.assertNotNullOrEmpty(setupsourcerequest.getDevicePlatform(), "The device platform must be provided.");
        RequestAssertUtils.assertNotNullOrEmpty(setupsourcerequest.getSourceApplicationName(), "The source application name must be provided");
        RequestAssertUtils.assertNotNullOrEmpty(setupsourcerequest.getSourceVersion(), "The source version must be provided");
        RequestPathGenerator.RequestPath requestpath = mRequestPathGenerator.createMetaDataEndpointRequestPath("account/source");
        requestpath.addRequestParameters(setupsourcerequest);
        return new CloudDriveBodyOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, new SinglePartPostRequestWriter(setupsourcerequest, SetupSourceRequestSerializer.INSTANCE), SourceInfoResponseDeserializer.INSTANCE, requestpath, "POST", "setupSource", mMetricListener, setupsourcerequest.getClass());
    }

    public CloudDriveOperation newUpdateCollectionPropertiesOperation(UpdateCollectionPropertiesRequest updatecollectionpropertiesrequest)
    {
        RequestAssertUtils.assertNotNull(updatecollectionpropertiesrequest, "The request cannot be null.");
        RequestAssertUtils.assertNotNullOrEmpty(updatecollectionpropertiesrequest.getId(), "The node id must be provided.");
        RequestAssertUtils.assertNotNull(updatecollectionpropertiesrequest.getOperations(), "The operations must be provided.");
        Object obj = (new StringBuilder()).append("nodes/").append(updatecollectionpropertiesrequest.getId()).append("/collectionProperties").toString();
        obj = mRequestPathGenerator.createMetaDataEndpointRequestPath(((String) (obj)));
        SinglePartPostRequestWriter singlepartpostrequestwriter = new SinglePartPostRequestWriter(updatecollectionpropertiesrequest, UpdateCollectionPropertiesRequestSerializer.INSTANCE);
        appendResourceVersion(((RequestPathGenerator.RequestPath) (obj)));
        return new CloudDriveBodyOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, singlepartpostrequestwriter, CollectionPropertiesResponseDeserializer.INSTANCE, ((RequestPathGenerator.RequestPath) (obj)), "PATCH", "updateCollectionProperties", mMetricListener, updatecollectionpropertiesrequest.getClass());
    }

    public CloudDriveOperation newUpdateNodeOperation(UpdateNodeRequest updatenoderequest, JsonDeserializer jsondeserializer)
    {
        RequestAssertUtils.assertNotNull(updatenoderequest, "The request cannot be null.");
        RequestAssertUtils.assertNotNullOrEmpty(updatenoderequest.getId(), "The node id must be provided.");
        Object obj = (new StringBuilder()).append("nodes/").append(updatenoderequest.getId()).toString();
        obj = mRequestPathGenerator.createMetaDataEndpointRequestPath(((String) (obj)));
        appendResourceVersion(((RequestPathGenerator.RequestPath) (obj)));
        return new CloudDriveBodyOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, new SinglePartPostRequestWriter(updatenoderequest, UpdateNodeRequestSerializer.INSTANCE), jsondeserializer, ((RequestPathGenerator.RequestPath) (obj)), "PATCH", "updateNode", mMetricListener, updatenoderequest.getClass());
    }

    public CloudDriveOperation newUploadFileOperation(UploadFileRequest uploadfilerequest, ProgressListener progresslistener, JsonDeserializer jsondeserializer)
    {
        RequestAssertUtils.assertNotNull(uploadfilerequest, "The request cannot be null.");
        RequestAssertUtils.assertNotNullOrEmpty(uploadfilerequest.getName(), "A name must be provided when creating a node.");
        RequestAssertUtils.assertNotNullOrEmpty(uploadfilerequest.getKind(), "A node kind must be provided when creating a node.");
        RequestAssertUtils.assertNotNull(uploadfilerequest.getInputStream(), "An InputStream must be provided when creating a file node.");
        if (uploadfilerequest.getContentLength() <= 0L)
        {
            throw new IllegalArgumentException("The content length must be set to the size of the file.");
        } else
        {
            RequestPathGenerator.RequestPath requestpath = mRequestPathGenerator.createContentEndpointRequestPath("nodes");
            appendResourceVersion(requestpath);
            requestpath.addRequestParameters(uploadfilerequest);
            requestpath.addParameter("suppress", uploadfilerequest.getSuppress());
            return new UploadFileOperation(this, mClientConfiguration, mAccountConfiguration, mSourceInfoGenerator, new MultiPartPostBodyWriter(uploadfilerequest, progresslistener), jsondeserializer, requestpath, "uploadFile", mMetricListener, uploadfilerequest.getClass(), "POST");
        }
    }
}
