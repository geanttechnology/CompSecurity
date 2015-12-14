// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended;

import com.amazon.clouddrive.configuration.AccountConfiguration;
import com.amazon.clouddrive.configuration.ClientConfiguration;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.model.BulkAddRemoveChildRequest;
import com.amazon.clouddrive.extended.model.BulkAddRemoveChildResponse;
import com.amazon.clouddrive.extended.model.BulkTrashRestoreNodesRequest;
import com.amazon.clouddrive.extended.model.BulkTrashRestoreNodesResponse;
import com.amazon.clouddrive.extended.model.CreateNodeExtendedResponse;
import com.amazon.clouddrive.extended.model.GetChangesExtendedResponse;
import com.amazon.clouddrive.extended.model.GetServicePlansRequest;
import com.amazon.clouddrive.extended.model.GetServicePlansResponse;
import com.amazon.clouddrive.extended.model.GetSplashRequest;
import com.amazon.clouddrive.extended.model.GetSplashResponse;
import com.amazon.clouddrive.extended.model.GetSubscriptionsRequest;
import com.amazon.clouddrive.extended.model.GetSubscriptionsResponse;
import com.amazon.clouddrive.extended.model.ListNodesExtendedResponse;
import com.amazon.clouddrive.extended.model.SetupAccountRequest;
import com.amazon.clouddrive.extended.model.UploadFileExtendedResponse;
import com.amazon.clouddrive.extended.model.deserializer.CreateNodeExtendedResponseDeserializer;
import com.amazon.clouddrive.extended.model.deserializer.GetChangesExtendedResponseDeserializer;
import com.amazon.clouddrive.extended.model.deserializer.GetNodeExtendedResponseDeserializer;
import com.amazon.clouddrive.extended.model.deserializer.ListNodesExtendedResponseDeserializer;
import com.amazon.clouddrive.extended.model.deserializer.UploadFileExtendedResponseDeserializer;
import com.amazon.clouddrive.handlers.AsyncHandler;
import com.amazon.clouddrive.handlers.ProgressListener;
import com.amazon.clouddrive.internal.CloudDriveOperation;
import com.amazon.clouddrive.internal.ExtendedOperationFactory;
import com.amazon.clouddrive.model.AddChildToParentRequest;
import com.amazon.clouddrive.model.CloudDriveRequest;
import com.amazon.clouddrive.model.CollectionPropertiesResponse;
import com.amazon.clouddrive.model.CreateNodeRequest;
import com.amazon.clouddrive.model.CreateNodeResponse;
import com.amazon.clouddrive.model.DownloadFileRequest;
import com.amazon.clouddrive.model.GetAccountQuotaRequest;
import com.amazon.clouddrive.model.GetAccountQuotaResponse;
import com.amazon.clouddrive.model.GetChangesRequest;
import com.amazon.clouddrive.model.GetNodeRequest;
import com.amazon.clouddrive.model.ListChildrenRequest;
import com.amazon.clouddrive.model.ListChildrenResponse;
import com.amazon.clouddrive.model.ListNodesRequest;
import com.amazon.clouddrive.model.ListNodesResponse;
import com.amazon.clouddrive.model.RemoveChildFromParentRequest;
import com.amazon.clouddrive.model.UpdateCollectionPropertiesRequest;
import com.amazon.clouddrive.model.UpdateNodeRequest;
import com.amazon.clouddrive.model.UpdateNodeResponse;
import com.amazon.clouddrive.model.UploadFileRequest;
import com.amazon.clouddrive.model.deserializer.CreateNodeResponseDeserializer;
import com.amazon.clouddrive.model.deserializer.ListChildrenResponseDeserializer;
import com.amazon.clouddrive.model.deserializer.ListNodeResponseDeserializer;
import com.amazon.clouddrive.model.deserializer.UpdateNodeResponseDeserializer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

// Referenced classes of package com.amazon.clouddrive.extended:
//            AmazonCloudDriveExtended

public class AmazonCloudDriveExtendedClient
    implements AmazonCloudDriveExtended
{
    private static class CallWithHandler
        implements Callable
    {

        private AsyncHandler mAsyncHandler;
        private CloudDriveOperation mCloudDriveOperation;
        private CloudDriveRequest mRequest;

        public Object call()
            throws Exception
        {
            Object obj;
            try
            {
                obj = mCloudDriveOperation.call();
            }
            catch (InterruptedException interruptedexception)
            {
                if (mAsyncHandler != null)
                {
                    mAsyncHandler.onCanceled(mRequest);
                }
                throw interruptedexception;
            }
            catch (CloudDriveException clouddriveexception)
            {
                if (mAsyncHandler != null)
                {
                    mAsyncHandler.onError(mRequest, clouddriveexception);
                }
                throw clouddriveexception;
            }
            if (mAsyncHandler != null)
            {
                mAsyncHandler.onSuccess(mRequest, obj);
            }
            return obj;
        }

        CallWithHandler(CloudDriveRequest clouddriverequest, CloudDriveOperation clouddriveoperation, AsyncHandler asynchandler)
        {
            mRequest = clouddriverequest;
            mCloudDriveOperation = clouddriveoperation;
            mAsyncHandler = asynchandler;
        }
    }


    private ExecutorService mExecutorService;
    private ExtendedOperationFactory mOperationFactory;

    public AmazonCloudDriveExtendedClient(AccountConfiguration accountconfiguration, ClientConfiguration clientconfiguration, ExecutorService executorservice)
    {
        mOperationFactory = new ExtendedOperationFactory(accountconfiguration, clientconfiguration);
        mExecutorService = executorservice;
    }

    public void addChildToParent(AddChildToParentRequest addchildtoparentrequest)
        throws CloudDriveException, InterruptedException
    {
        mOperationFactory.newAddChildToParentOperation(addchildtoparentrequest).call();
    }

    public Future addChildToParentAsync(AddChildToParentRequest addchildtoparentrequest, AsyncHandler asynchandler)
    {
        return mExecutorService.submit(new CallWithHandler(addchildtoparentrequest, mOperationFactory.newAddChildToParentOperation(addchildtoparentrequest), asynchandler));
    }

    public BulkAddRemoveChildResponse bulkAddRemoveChild(BulkAddRemoveChildRequest bulkaddremovechildrequest)
        throws CloudDriveException, InterruptedException
    {
        return (BulkAddRemoveChildResponse)mOperationFactory.newBulkAddRemoveChildOperation(bulkaddremovechildrequest).call();
    }

    public BulkTrashRestoreNodesResponse bulkTrashRestoreNodes(BulkTrashRestoreNodesRequest bulktrashrestorenodesrequest)
        throws CloudDriveException, InterruptedException
    {
        return (BulkTrashRestoreNodesResponse)mOperationFactory.newBulkTrashOrRestoreNodes(bulktrashrestorenodesrequest).call();
    }

    public CreateNodeResponse createNode(CreateNodeRequest createnoderequest)
        throws CloudDriveException, InterruptedException
    {
        return (CreateNodeResponse)mOperationFactory.newCreateNodeOperation(createnoderequest, CreateNodeResponseDeserializer.INSTANCE).call();
    }

    public CreateNodeExtendedResponse createNodeExtended(CreateNodeRequest createnoderequest)
        throws CloudDriveException, InterruptedException
    {
        return (CreateNodeExtendedResponse)mOperationFactory.newCreateNodeOperation(createnoderequest, CreateNodeExtendedResponseDeserializer.INSTANCE).call();
    }

    public Future createNodeExtendedAsync(CreateNodeRequest createnoderequest, AsyncHandler asynchandler)
    {
        return mExecutorService.submit(new CallWithHandler(createnoderequest, mOperationFactory.newCreateNodeOperation(createnoderequest, CreateNodeExtendedResponseDeserializer.INSTANCE), asynchandler));
    }

    public void downloadFile(DownloadFileRequest downloadfilerequest, ProgressListener progresslistener)
        throws CloudDriveException, InterruptedException
    {
        mOperationFactory.newDownloadFileOperation(downloadfilerequest, progresslistener).call();
    }

    public GetAccountQuotaResponse getAccountQuota(GetAccountQuotaRequest getaccountquotarequest)
        throws CloudDriveException, InterruptedException
    {
        return (GetAccountQuotaResponse)mOperationFactory.newGetAccountQuotaOperation(getaccountquotarequest).call();
    }

    public GetChangesExtendedResponse getChangesExtended(GetChangesRequest getchangesrequest)
        throws CloudDriveException, InterruptedException
    {
        return (GetChangesExtendedResponse)mOperationFactory.newGetChangesOperation(getchangesrequest, GetChangesExtendedResponseDeserializer.INSTANCE).call();
    }

    public Future getNodeExtendedAsync(GetNodeRequest getnoderequest, AsyncHandler asynchandler)
    {
        return mExecutorService.submit(new CallWithHandler(getnoderequest, mOperationFactory.newGetNodeOperation(getnoderequest, GetNodeExtendedResponseDeserializer.INSTANCE), asynchandler));
    }

    public GetServicePlansResponse getServicePlans(GetServicePlansRequest getserviceplansrequest)
        throws CloudDriveException, InterruptedException
    {
        return (GetServicePlansResponse)mOperationFactory.newGetServicePlansOperation(getserviceplansrequest).call();
    }

    public GetSplashResponse getSplash(GetSplashRequest getsplashrequest)
        throws CloudDriveException, InterruptedException
    {
        return (GetSplashResponse)mOperationFactory.newGetSplashOperation(getsplashrequest).call();
    }

    public GetSubscriptionsResponse getSubscriptions(GetSubscriptionsRequest getsubscriptionsrequest)
        throws CloudDriveException, InterruptedException
    {
        return (GetSubscriptionsResponse)mOperationFactory.newGetSubscriptionsOperation(getsubscriptionsrequest).call();
    }

    public ListChildrenResponse listChildren(ListChildrenRequest listchildrenrequest)
        throws CloudDriveException, InterruptedException
    {
        return (ListChildrenResponse)mOperationFactory.newListChildrenOperation(listchildrenrequest, ListChildrenResponseDeserializer.INSTANCE).call();
    }

    public Future listChildrenAsync(ListChildrenRequest listchildrenrequest, AsyncHandler asynchandler)
    {
        return mExecutorService.submit(new CallWithHandler(listchildrenrequest, mOperationFactory.newListChildrenOperation(listchildrenrequest, ListChildrenResponseDeserializer.INSTANCE), asynchandler));
    }

    public ListNodesResponse listNodes(ListNodesRequest listnodesrequest)
        throws CloudDriveException, InterruptedException
    {
        return (ListNodesResponse)mOperationFactory.newListNodesOperation(listnodesrequest, ListNodeResponseDeserializer.INSTANCE).call();
    }

    public ListNodesExtendedResponse listNodesExtended(ListNodesRequest listnodesrequest)
        throws CloudDriveException, InterruptedException
    {
        return (ListNodesExtendedResponse)mOperationFactory.newListNodesOperation(listnodesrequest, ListNodesExtendedResponseDeserializer.INSTANCE).call();
    }

    public Future listNodesExtendedAsync(ListNodesRequest listnodesrequest, AsyncHandler asynchandler)
    {
        return mExecutorService.submit(new CallWithHandler(listnodesrequest, mOperationFactory.newListNodesOperation(listnodesrequest, ListNodesExtendedResponseDeserializer.INSTANCE), asynchandler));
    }

    public void removeChildFromParent(RemoveChildFromParentRequest removechildfromparentrequest)
        throws CloudDriveException, InterruptedException
    {
        mOperationFactory.newRemoveChildFromParentOperation(removechildfromparentrequest).call();
    }

    public void setupAccount(SetupAccountRequest setupaccountrequest)
        throws CloudDriveException, InterruptedException
    {
        mOperationFactory.newSetupAccountOperation(setupaccountrequest).call();
    }

    public CollectionPropertiesResponse updateCollectionProperties(UpdateCollectionPropertiesRequest updatecollectionpropertiesrequest)
        throws CloudDriveException, InterruptedException
    {
        return (CollectionPropertiesResponse)mOperationFactory.newUpdateCollectionPropertiesOperation(updatecollectionpropertiesrequest).call();
    }

    public UpdateNodeResponse updateNode(UpdateNodeRequest updatenoderequest)
        throws CloudDriveException, InterruptedException
    {
        return (UpdateNodeResponse)mOperationFactory.newUpdateNodeOperation(updatenoderequest, UpdateNodeResponseDeserializer.INSTANCE).call();
    }

    public UploadFileExtendedResponse uploadFileExtended(UploadFileRequest uploadfilerequest, ProgressListener progresslistener)
        throws CloudDriveException, InterruptedException
    {
        return (UploadFileExtendedResponse)mOperationFactory.newUploadFileOperation(uploadfilerequest, progresslistener, UploadFileExtendedResponseDeserializer.INSTANCE).call();
    }
}
