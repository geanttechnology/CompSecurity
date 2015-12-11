// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.callback;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;

// Referenced classes of package com.amazon.identity.auth.device.callback:
//            IRemoteCallback

public class RemoteCallbackWrapper
    implements Parcelable, Callback
{
    private static class Transport extends IRemoteCallback.Stub
    {

        private final Callback mCallback;

        public void onError(Bundle bundle)
            throws RemoteException
        {
            if (mCallback != null)
            {
                ThreadUtils.runOffMainThread(bundle. new Runnable() {

                    final Transport this$0;
                    final Bundle val$result;

                    public void run()
                    {
                        mCallback.onError(result);
                    }

            
            {
                this$0 = final_transport;
                result = Bundle.this;
                super();
            }
                });
            }
        }

        public void onSuccess(Bundle bundle)
            throws RemoteException
        {
            if (mCallback != null)
            {
                ThreadUtils.runOffMainThread(bundle. new Runnable() {

                    final Transport this$0;
                    final Bundle val$result;

                    public void run()
                    {
                        mCallback.onSuccess(result);
                    }

            
            {
                this$0 = final_transport;
                result = Bundle.this;
                super();
            }
                });
            }
        }


        public Transport(Callback callback)
        {
            mCallback = callback;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RemoteCallbackWrapper createFromParcel(Parcel parcel)
        {
            return new RemoteCallbackWrapper(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public RemoteCallbackWrapper[] newArray(int i)
        {
            return new RemoteCallbackWrapper[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final String TAG = com/amazon/identity/auth/device/callback/RemoteCallbackWrapper.getName();
    private final IRemoteCallback mCallback;

    public RemoteCallbackWrapper(Parcel parcel)
    {
        this(IRemoteCallback.Stub.asInterface(parcel.readStrongBinder()));
    }

    public RemoteCallbackWrapper(Callback callback)
    {
        this(((IRemoteCallback) (new Transport(callback))));
    }

    public RemoteCallbackWrapper(IRemoteCallback iremotecallback)
    {
        mCallback = iremotecallback;
    }

    public static IRemoteCallback toRemoteCallback(Callback callback)
    {
        return new Transport(callback);
    }

    public int describeContents()
    {
        return 0;
    }

    public void onError(Bundle bundle)
    {
        boolean flag;
        int i;
        flag = false;
        i = 0;
_L2:
        if (flag || i > 1)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        i++;
        if (mCallback != null)
        {
            mCallback.onError(bundle);
            break MISSING_BLOCK_LABEL_79;
        }
        try
        {
            MAPLog.e(TAG, "Not calling onError because mCallback is null");
        }
        catch (RemoteException remoteexception)
        {
            MAPLog.e(TAG, "onError callback failed", remoteexception);
            continue; /* Loop/switch isn't completed */
        }
        catch (NullPointerException nullpointerexception)
        {
            MAPLog.e(TAG, "NullPointerException onError", nullpointerexception);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_79;
        return;
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onSuccess(Bundle bundle)
    {
        boolean flag;
        int i;
        flag = false;
        i = 0;
_L2:
        if (flag || i > 1)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        i++;
        if (mCallback != null)
        {
            mCallback.onSuccess(bundle);
            break MISSING_BLOCK_LABEL_79;
        }
        try
        {
            MAPLog.e(TAG, "Not calling onSuccess because mCallback is null");
        }
        catch (RemoteException remoteexception)
        {
            MAPLog.e(TAG, "onSuccess callback failed", remoteexception);
            continue; /* Loop/switch isn't completed */
        }
        catch (NullPointerException nullpointerexception)
        {
            MAPLog.e(TAG, "NullPointerException onSuccess", nullpointerexception);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_79;
        return;
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public IRemoteCallback toRemoteCallback()
    {
        return mCallback;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (mCallback != null)
        {
            parcel.writeStrongBinder(mCallback.asBinder());
        }
    }

}
