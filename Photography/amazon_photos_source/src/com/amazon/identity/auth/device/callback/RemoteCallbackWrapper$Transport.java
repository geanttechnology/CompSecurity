// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.callback;

import android.os.Bundle;
import android.os.RemoteException;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.utils.ThreadUtils;

// Referenced classes of package com.amazon.identity.auth.device.callback:
//            RemoteCallbackWrapper

private static class mCallback extends mCallback
{

    private final Callback mCallback;

    public void onError(final Bundle result)
        throws RemoteException
    {
        if (mCallback != null)
        {
            ThreadUtils.runOffMainThread(new Runnable() {

                final RemoteCallbackWrapper.Transport this$0;
                final Bundle val$result;

                public void run()
                {
                    mCallback.onError(result);
                }

            
            {
                this$0 = RemoteCallbackWrapper.Transport.this;
                result = bundle;
                super();
            }
            });
        }
    }

    public void onSuccess(final Bundle result)
        throws RemoteException
    {
        if (mCallback != null)
        {
            ThreadUtils.runOffMainThread(new Runnable() {

                final RemoteCallbackWrapper.Transport this$0;
                final Bundle val$result;

                public void run()
                {
                    mCallback.onSuccess(result);
                }

            
            {
                this$0 = RemoteCallbackWrapper.Transport.this;
                result = bundle;
                super();
            }
            });
        }
    }


    public _cls2.val.result(Callback callback)
    {
        mCallback = callback;
    }
}
