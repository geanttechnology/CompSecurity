// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.configuration.AccountConfiguration;
import com.amazon.clouddrive.configuration.SourceInfoCache;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.SourceInfoResponse;

// Referenced classes of package com.amazon.clouddrive.internal:
//            BasicSourceInfo, OperationFactory, CloudDriveOperation

class SourceInfoGenerator
{

    private final AccountConfiguration mAccountConfiguration;
    private final OperationFactory mOperationFactory;

    SourceInfoGenerator(AccountConfiguration accountconfiguration, OperationFactory operationfactory)
    {
        mAccountConfiguration = accountconfiguration;
        mOperationFactory = operationfactory;
    }

    private BasicSourceInfo getInitializedSourceInfo()
        throws CloudDriveException, InterruptedException
    {
        this;
        JVM INSTR monitorenter ;
        SourceInfoCache sourceinfocache = mAccountConfiguration.getSourceInfoCache();
        if (sourceinfocache != null) goto _L2; else goto _L1
_L1:
        BasicSourceInfo basicsourceinfo = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return basicsourceinfo;
_L2:
        if (sourceinfocache.isSourceInfoCached())
        {
            basicsourceinfo = sourceinfocache.getSourceInfo();
            continue; /* Loop/switch isn't completed */
        }
        basicsourceinfo = new BasicSourceInfo((SourceInfoResponse)mOperationFactory.newSetupSourceOperation(sourceinfocache.getSetupSourceRequest()).call());
        sourceinfocache.cacheSourceInfo(basicsourceinfo);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    BasicSourceInfo createSourceInfo()
        throws CloudDriveException, InterruptedException
    {
        return getInitializedSourceInfo();
    }
}
