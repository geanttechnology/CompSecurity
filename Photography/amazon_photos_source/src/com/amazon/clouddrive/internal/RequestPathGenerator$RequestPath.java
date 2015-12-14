// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.configuration.ClientConfiguration;
import com.amazon.clouddrive.configuration.Endpoints;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.PaginatedCloudDriveRequest;
import com.amazon.clouddrive.model.PostNodeRequest;

// Referenced classes of package com.amazon.clouddrive.internal:
//            RequestPathGenerator, QueryPathBuilder

class <init>
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
    //                   1 72
    //                   2 32
    //                   3 86;
           goto _L1 _L2 _L1 _L3
_L1:
        String s = RequestPathGenerator.access$200(RequestPathGenerator.this).getMetaDataEndpoint();
_L5:
        return mQueryBuilder.addQueryToPath((new StringBuilder()).append(s).append(mOperation).toString());
_L2:
        s = RequestPathGenerator.access$100(RequestPathGenerator.this).getMasterEndpoint();
        continue; /* Loop/switch isn't completed */
_L3:
        s = RequestPathGenerator.access$200(RequestPathGenerator.this).getContentEndpoint();
        if (true) goto _L5; else goto _L4
_L4:
    }

    private (int i, String s)
    {
        this$0 = RequestPathGenerator.this;
        super();
        mEndpointKind = i;
        mOperation = s;
        mQueryBuilder = new QueryPathBuilder();
    }

    mQueryBuilder(int i, String s, mQueryBuilder mquerybuilder)
    {
        this(i, s);
    }
}
