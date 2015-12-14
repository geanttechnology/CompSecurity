// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.content.Context;
import com.amazon.clouddrive.configuration.AccountConfiguration;
import com.amazon.clouddrive.configuration.ClientConfiguration;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.AmazonCloudDriveExtendedClient;
import com.amazon.clouddrive.handlers.AsyncHandler;
import com.amazon.clouddrive.model.CreateNodeRequest;
import com.amazon.clouddrive.model.GetNodeRequest;
import com.amazon.clouddrive.model.ListNodesRequest;
import com.amazon.mixtape.account.AccountContextFactory;
import com.amazon.mixtape.account.MetadataStore;
import com.amazon.mixtape.utils.Lazy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

// Referenced classes of package com.amazon.mixtape.service:
//            MixtapePersistResponseFuture, NodeExtractors

public class MixtapeCloudDriveServiceClient extends AmazonCloudDriveExtendedClient
{
    private static class LazyMetadataStore extends Lazy
    {

        private final String accountId;
        private final String cloudNodeProviderAuthority;
        private final Context context;

        protected MetadataStore instantiateItem()
        {
            return AccountContextFactory.getContextForAccountId(context, accountId).createMetadataStore(cloudNodeProviderAuthority);
        }

        protected volatile Object instantiateItem()
        {
            return instantiateItem();
        }

        private LazyMetadataStore(Context context1, String s, String s1)
        {
            context = context1;
            accountId = s;
            cloudNodeProviderAuthority = s1;
        }

    }


    private final Lazy mLazyCloudMetadataStore;

    public MixtapeCloudDriveServiceClient(AccountConfiguration accountconfiguration, ClientConfiguration clientconfiguration, ExecutorService executorservice, Context context, String s, String s1)
    {
        super(accountconfiguration, clientconfiguration, executorservice);
        mLazyCloudMetadataStore = new LazyMetadataStore(context, s, s1);
    }

    public Future createNodePersistAsync(CreateNodeRequest createnoderequest, AsyncHandler asynchandler)
        throws CloudDriveException
    {
        return new MixtapePersistResponseFuture(super.createNodeExtendedAsync(createnoderequest, asynchandler), NodeExtractors.NODE_RESPONSE_EXTRACTOR, mLazyCloudMetadataStore);
    }

    public Future getNodePersistAsync(GetNodeRequest getnoderequest, AsyncHandler asynchandler)
        throws CloudDriveException
    {
        return new MixtapePersistResponseFuture(super.getNodeExtendedAsync(getnoderequest, asynchandler), NodeExtractors.NODE_RESPONSE_EXTRACTOR, mLazyCloudMetadataStore);
    }

    public Future listNodesPersistAsync(ListNodesRequest listnodesrequest, AsyncHandler asynchandler)
        throws CloudDriveException
    {
        return new MixtapePersistResponseFuture(super.listNodesExtendedAsync(listnodesrequest, asynchandler), NodeExtractors.LIST_NODE_RESPONSE_EXTRACTOR, mLazyCloudMetadataStore);
    }
}
