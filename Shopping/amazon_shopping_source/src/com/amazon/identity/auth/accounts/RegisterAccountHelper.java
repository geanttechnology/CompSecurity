// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.auth.device.callback.AsyncToSyncAdapter;
import com.amazon.identity.auth.device.framework.DeviceInfoHolder;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.AnonymousCredentialsStore;
import com.amazon.identity.auth.device.utils.StringUtil;
import com.amazon.identity.auth.device.utils.TimeUtil;
import com.amazon.identity.platform.util.PlatformUtils;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AmazonAccountManager

public class RegisterAccountHelper
{
    public static interface FetchCredentialsCallback
    {

        public abstract void failure();

        public abstract void success();
    }


    private static final String TAG = com/amazon/identity/auth/accounts/RegisterAccountHelper.getName();
    private final AmazonAccountManager mAmznAcctMan;
    private final Context mContext;
    private final MAPAccountManager mMapAcctMan;

    public RegisterAccountHelper(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mAmznAcctMan = (AmazonAccountManager)mContext.getSystemService("dcp_amazon_account_man");
        mMapAcctMan = new MAPAccountManager(mContext);
    }

    public static boolean canRegisterWithDeviceSecret(Context context)
    {
        String s = DeviceInfoHolder.getInstance(context).getDeviceSecret();
        return PlatformUtils.isAmazonDevice(context) && !StringUtil.isEmptyOrWhitespace(s);
    }

    private boolean haveAnyCredentials(Context context)
    {
        context = new AnonymousCredentialsStore(context);
        return mAmznAcctMan.hasDevicePrimaryAmazonAccount() || context.hasCredentials();
    }

    public void ensureCredentialsPopulated(final Context context, final FetchCredentialsCallback callback)
    {
        if (haveAnyCredentials(context))
        {
            callback.success();
            return;
        }
        if (!canRegisterWithDeviceSecret(context))
        {
            callback.failure();
            return;
        } else
        {
            mMapAcctMan.registerAccount(RegistrationType.WITH_DEVICE_SECRET, null, new Callback() {

                final RegisterAccountHelper this$0;
                final FetchCredentialsCallback val$callback;
                final Context val$context;

                public void onError(Bundle bundle)
                {
                    callback.failure();
                }

                public void onSuccess(Bundle bundle)
                {
                    if (haveAnyCredentials(context))
                    {
                        callback.success();
                        return;
                    } else
                    {
                        callback.failure();
                        return;
                    }
                }

            
            {
                this$0 = RegisterAccountHelper.this;
                context = context1;
                callback = fetchcredentialscallback;
                super();
            }
            });
            return;
        }
    }

    public void ensureCredentialsSynchronouslyPopulated(final Context context, final FetchCredentialsCallback callback)
    {
        (new AsyncToSyncAdapter() {

            final RegisterAccountHelper this$0;
            final FetchCredentialsCallback val$callback;
            final Context val$context;

            protected void startAsyncOperation()
            {
                FetchCredentialsCallback fetchcredentialscallback = new FetchCredentialsCallback() {

                    final _cls1 this$1;

                    public void failure()
                    {
                        callback.failure();
                        asyncOperationComplete();
                    }

                    public void success()
                    {
                        callback.success();
                        asyncOperationComplete();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                };
                ensureCredentialsPopulated(context, fetchcredentialscallback);
            }



            
            {
                this$0 = RegisterAccountHelper.this;
                callback = fetchcredentialscallback;
                context = context1;
                super();
            }
        }).run(Long.valueOf(TimeUtil.fromMinutesTo(3L, TimeUnit.SECONDS)), TimeUnit.SECONDS, "EnsureCredentialsSynchronouslyPopulated");
    }


}
