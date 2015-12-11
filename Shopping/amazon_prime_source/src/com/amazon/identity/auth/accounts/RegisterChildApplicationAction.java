// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.amazon.dcp.sso.ISubAuthenticatorResponse;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.callback.PendingRequestCallbackHolder;
import com.amazon.identity.auth.device.framework.MAPApplicationInformationQueryer;
import com.amazon.identity.auth.device.framework.RemoteMAPException;
import com.amazon.identity.auth.device.framework.RemoteMapInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.BundleUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.SoftwareInfo;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            ChildApplicationHelpers, DMSSubAuthenticator, AccountsCallbackHelpers

public class RegisterChildApplicationAction
{
    public static class NotChildApplicationException extends Exception
    {

        private static final long serialVersionUID = 1L;

        public NotChildApplicationException()
        {
        }
    }

    private static class SubAuthenticatorCallbackAdapter
        implements ISubAuthenticatorResponse
    {

        private final Callback mInnerCallback;

        public IBinder asBinder()
        {
            throw new UnsupportedOperationException("asBinder is not supported in SubAuthenticatorCallbackAdapter");
        }

        public void onError(int i, String s)
            throws RemoteException
        {
            AccountsCallbackHelpers.onError(mInnerCallback, i, s, null);
        }

        public void onResult(Bundle bundle)
            throws RemoteException
        {
            AccountsCallbackHelpers.resultToSuccessOrError(mInnerCallback, bundle);
        }

        public SubAuthenticatorCallbackAdapter(Callback callback)
        {
            mInnerCallback = callback;
        }
    }


    private static final String TAG = com/amazon/identity/auth/accounts/RegisterChildApplicationAction.getName();
    private final Context mContext;
    private final PendingRequestCallbackHolder mPendingRegisterRequestCallbackHolder = new PendingRequestCallbackHolder();
    private final PendingRequestCallbackHolder mPendingUpdateRequestCallbackHolder = new PendingRequestCallbackHolder();

    public RegisterChildApplicationAction(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
    }

    private SoftwareInfo getPackageVersionForDeviceType(String s)
    {
        Object obj;
        String s1;
        Iterator iterator;
        Collection collection = MAPApplicationInformationQueryer.getInstance(mContext).getAllMapApplication();
        obj = null;
        s1 = null;
        iterator = collection.iterator();
_L2:
        Object obj1;
        RemoteMapInfo remotemapinfo;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        remotemapinfo = (RemoteMapInfo)iterator.next();
        obj1 = obj;
        if (!TextUtils.equals(remotemapinfo.getDeviceType(), s))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        Object obj2 = remotemapinfo.getPackageVersion();
        if (obj2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        obj1 = obj;
        if (((Integer) (obj)).intValue() >= ((Integer) (obj2)).intValue())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = obj2;
        obj1 = obj;
        obj2 = remotemapinfo.getPackageName();
        s1 = ((String) (obj2));
        continue; /* Loop/switch isn't completed */
        obj;
        MAPLog.w(TAG, (new StringBuilder("Couldn't determine device type for ")).append(remotemapinfo.getPackageName()).toString(), ((Throwable) (obj)));
        obj = obj1;
        if (true) goto _L2; else goto _L1
_L1:
        return new SoftwareInfo(((Integer) (obj)), s1);
    }

    public void registerChildApplication(String s, String s1, Bundle bundle, Callback callback, Tracer tracer)
        throws NotChildApplicationException
    {
        if (!ChildApplicationHelpers.isChildApplication(mContext, s1))
        {
            throw new NotChildApplicationException();
        }
        callback = mPendingRegisterRequestCallbackHolder.waitForInflightRequestOrMakeRequest(s1, callback);
        if (callback == null)
        {
            MAPLog.i(TAG, String.format("Register child app request already in flight for device type %s", new Object[] {
                s1
            }));
            return;
        }
        callback = new SubAuthenticatorCallbackAdapter(callback);
        String s2 = BundleUtils.constructEmptyBundleIfNull(bundle).getString("override_dsn");
        bundle = getPackageVersionForDeviceType(s1);
        Integer integer = bundle.getSoftwareVersion();
        String s3 = bundle.getSoftwareComponentId();
        String s4 = TAG;
        if (integer != null)
        {
            bundle = Integer.toString(integer.intValue());
        } else
        {
            bundle = "None";
        }
        MAPLog.i(s4, String.format("Registering child application with device type %s, version %s, and component id %s", new Object[] {
            s1, bundle, s3
        }));
        DMSSubAuthenticator.constructDMSSubAuthForDeviceType(mContext, s1, s2, integer, s3).registerChildApplication$678855cd(callback, s, tracer);
    }

}
