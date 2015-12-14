// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.configuration.AccountConfiguration;
import com.amazon.clouddrive.configuration.ClientConfiguration;
import com.amazon.clouddrive.configuration.Endpoints;
import com.amazon.clouddrive.configuration.EndpointsCache;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.GetAccountEndpointRequest;
import com.amazon.clouddrive.model.GetAccountEndpointResponse;
import com.amazon.clouddrive.model.PaginatedCloudDriveRequest;
import com.amazon.clouddrive.model.PostNodeRequest;

// Referenced classes of package com.amazon.clouddrive.internal:
//            OperationFactory, CloudDriveOperation, QueryPathBuilder

class RequestPathGenerator
{
    class RequestPath
    {

        private final int mEndpointKind;
        private final String mOperation;
        private final QueryPathBuilder mQueryBuilder;
        final RequestPathGenerator this$0;

        void addParameter(String s, Boolean boolean1)
        {
            mQueryBuilder.addParameter(s, boolean1);
        }

        void addParameter(String s, String s1)
        {
            mQueryBuilder.addParameter(s, s1);
        }

        void addRequestParameters(PaginatedCloudDriveRequest paginatedclouddriverequest)
        {
            mQueryBuilder.addRequestParameters(paginatedclouddriverequest);
        }

        void addRequestParameters(PostNodeRequest postnoderequest)
        {
            mQueryBuilder.addRequestParameters(postnoderequest);
        }

        void addUTF8Parameter(String s, String s1)
        {
            mQueryBuilder.addUTF8Parameter(s, s1);
        }

        String getPath()
            throws CloudDriveException, InterruptedException
        {
            mEndpointKind;
            JVM INSTR tableswitch 1 3: default 32
        //                       1 72
        //                       2 32
        //                       3 86;
               goto _L1 _L2 _L1 _L3
_L1:
            String s = getInitializedEndpoints().getMetaDataEndpoint();
_L5:
            return mQueryBuilder.addQueryToPath((new StringBuilder()).append(s).append(mOperation).toString());
_L2:
            s = mClientConfiguration.getMasterEndpoint();
            continue; /* Loop/switch isn't completed */
_L3:
            s = getInitializedEndpoints().getContentEndpoint();
            if (true) goto _L5; else goto _L4
_L4:
        }

        private RequestPath(int i, String s)
        {
            this$0 = RequestPathGenerator.this;
            super();
            mEndpointKind = i;
            mOperation = s;
            mQueryBuilder = new QueryPathBuilder();
        }

    }


    private final ClientConfiguration mClientConfiguration;
    private final EndpointsCache mEndpointsCache;
    private final OperationFactory mOperationFactory;

    RequestPathGenerator(ClientConfiguration clientconfiguration, AccountConfiguration accountconfiguration, OperationFactory operationfactory)
    {
        mClientConfiguration = clientconfiguration;
        mEndpointsCache = accountconfiguration.getEndpointsCache();
        mOperationFactory = operationfactory;
    }

    private boolean areEndpointsValid(Endpoints endpoints)
    {
        return endpoints != null && endpoints.getMetaDataEndpoint() != null && endpoints.getContentEndpoint() != null;
    }

    private Endpoints getInitializedEndpoints()
        throws CloudDriveException, InterruptedException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = mEndpointsCache.getEndpoints();
        if (!areEndpointsValid(((Endpoints) (obj))) || mEndpointsCache.cacheHasExpired())
        {
            obj = (GetAccountEndpointResponse)mOperationFactory.newGetAccountEndpointOperation(new GetAccountEndpointRequest()).call();
            obj = new Endpoints(((GetAccountEndpointResponse) (obj)).getMetadataUrl(), ((GetAccountEndpointResponse) (obj)).getContentUrl(), ((GetAccountEndpointResponse) (obj)).getMarketplaceAtSignup());
            mEndpointsCache.setEndpoints(((Endpoints) (obj)));
        }
        this;
        JVM INSTR monitorexit ;
        return ((Endpoints) (obj));
        Exception exception;
        exception;
        throw exception;
    }

    RequestPath createContentEndpointRequestPath(String s)
    {
        return new RequestPath(3, s);
    }

    RequestPath createMasterEndpointRequestPath(String s)
    {
        return new RequestPath(1, s);
    }

    RequestPath createMetaDataEndpointRequestPath(String s)
    {
        return new RequestPath(2, s);
    }

    RequestPath createMetaDataEndpointRequestPath(String s, String s1)
    {
        s = new RequestPath(2, s);
        s.addUTF8Parameter("resourceVersion", s1);
        return s;
    }


}
