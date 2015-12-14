// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended;

import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.handlers.AsyncHandler;
import com.amazon.clouddrive.internal.CloudDriveOperation;
import com.amazon.clouddrive.model.CloudDriveRequest;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.clouddrive.extended:
//            AmazonCloudDriveExtendedClient

private static class mAsyncHandler
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

    (CloudDriveRequest clouddriverequest, CloudDriveOperation clouddriveoperation, AsyncHandler asynchandler)
    {
        mRequest = clouddriverequest;
        mCloudDriveOperation = clouddriveoperation;
        mAsyncHandler = asynchandler;
    }
}
