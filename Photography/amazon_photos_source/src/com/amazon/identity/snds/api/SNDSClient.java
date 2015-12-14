// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.amazon.identity.snds.api:
//            TimeUtil, UnitTestUtils, ThreadUtils, SyncBoundServiceCaller, 
//            SSOIntentFactory, IIsAccountLinked, ReturnValueOrError

public class SNDSClient
{
    private static final class IsAccountLinkedServiceIntentFactory extends SSOIntentFactory
    {

        public static IsAccountLinkedServiceIntentFactory findIsAccountLinkedService(Context context)
        {
            context = findSSOComponent(context, "com.amazon.identity.snds.SNDSLinkStatusService", SERVICE_FINDER);
            if (context == null)
            {
                return null;
            } else
            {
                return new IsAccountLinkedServiceIntentFactory(context);
            }
        }

        public Intent buildIntentForService()
        {
            return buildIntent("com.amazon.dcp.snds.action.SNDS.link_status.get");
        }

        private IsAccountLinkedServiceIntentFactory(ComponentName componentname)
        {
            super(componentname);
        }
    }


    private static final long DEFAULT_CONNECT_TO_SNDS_TIMEOUT;
    private static final String TAG = com/amazon/identity/snds/api/SNDSClient.getName();
    private final AccountManager mAccountManager;

    protected SNDSClient()
    {
        mAccountManager = null;
    }

    public SNDSClient(AccountManager accountmanager)
    {
        mAccountManager = accountmanager;
    }

    public SNDSClient(Context context)
    {
        this(AccountManager.get(context));
    }

    public boolean isSocialNetworkAccountLinked(final Context final_context, String s, SNDSConstants.SocialNetworkType socialnetworktype)
    {
        if (s == null || socialnetworktype == null)
        {
            return false;
        }
        Log.d(TAG, "Initiating isSocialNetworkAccountLinked client call");
        if (!UnitTestUtils.isRunningInUnitTest() && ThreadUtils.isRunningOnMainThread())
        {
            throw new IllegalStateException("Cannot check social network account link on the main thread");
        }
        IsAccountLinkedServiceIntentFactory isaccountlinkedserviceintentfactory = IsAccountLinkedServiceIntentFactory.findIsAccountLinkedService(final_context);
        if (isaccountlinkedserviceintentfactory == null)
        {
            final_context = new IllegalStateException("Cannot find SNDSLinkStatusService");
            Log.e(TAG, final_context.getMessage(), final_context);
            throw final_context;
        }
        AtomicReference atomicreference = new AtomicReference();
        final_context = new SyncBoundServiceCaller(socialnetworktype, s, atomicreference) {

            final SNDSClient this$0;
            final String val$directedId;
            final AtomicReference val$isAccountLinkedResponse;
            final SNDSConstants.SocialNetworkType val$type;

            protected void useService(IBinder ibinder)
            {
                Log.d(SNDSClient.TAG, "IsSocialNetworkAccountLinked  useService called");
                ibinder = IIsAccountLinked.Stub.asInterface(ibinder);
                int i = type.value();
                try
                {
                    ibinder = ibinder.isAccountLinked(directedId, i);
                    isAccountLinkedResponse.set(ibinder.getResponse());
                }
                // Misplaced declaration of an exception variable
                catch (IBinder ibinder)
                {
                    Log.e(SNDSClient.TAG, "Remote exception during isAccountLinked call", ibinder);
                }
                doneUsingService();
            }

            
            {
                this$0 = SNDSClient.this;
                type = socialnetworktype;
                directedId = s;
                isAccountLinkedResponse = atomicreference;
                super(final_context, final_intent, final_i);
            }
        };
        Log.d(TAG, "Running caller");
        final_context.run(Long.valueOf(DEFAULT_CONNECT_TO_SNDS_TIMEOUT), TimeUnit.MILLISECONDS);
        Log.d(TAG, "Returned from caller, returning response");
        final_context = (Bundle)atomicreference.get();
        if (final_context == null)
        {
            Log.e(TAG, "Timeout or exception calling isAccountLinked");
            return false;
        } else
        {
            return final_context.getBoolean("isLinked");
        }
    }

    public void setSocialNetworkAccountLinkStatus(Context context, String s, SNDSConstants.SocialNetworkType socialnetworktype, boolean flag)
    {
        if (socialnetworktype == null)
        {
            return;
        } else
        {
            Intent intent = new Intent("com.amazon.dcp.snds.action.SNDS.link_status.set");
            intent.putExtra("SNDS.account.directedID", s);
            intent.putExtra("SNDS.type", socialnetworktype.value());
            intent.putExtra("SNDS.is.linked", flag);
            context.startService(intent);
            return;
        }
    }

    static 
    {
        DEFAULT_CONNECT_TO_SNDS_TIMEOUT = TimeUtil.fromMinutesTo(2L, TimeUnit.MILLISECONDS);
    }

}
