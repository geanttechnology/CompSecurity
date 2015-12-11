// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.features.FeatureSetCache;
import com.amazon.identity.auth.device.features.FeatureSetProvider;
import com.amazon.identity.auth.device.utils.BundleUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.request.AuthenticatedRequestHelpers;
import com.amazon.identity.auth.request.IRequestAdapter;
import com.amazon.identity.auth.request.NoCredentialsException;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticationType, MAPInit, MAPAccountManager, MAPCallbackErrorException, 
//            MAPFuture, Callback

public abstract class AuthenticationMethod
{
    public static final class GetAuthenticationHeadersForRequestError
    {

        public static final int INVALID_ARGUMENT = 3;
        public static final int IPC_ERROR = 1;
        public static final String KEY_ERROR_CODE = "error_code_key";
        public static final String KEY_ERROR_MESSAGE = "error_message_key";
        public static final int NOT_SUPPORTED = 5;
        public static final int NO_CREDENTIALS = 2;
        public static final int PACKAGE_NOT_WHITE_LIST = 4;
        public static final int UNRECOGNIZED = 6;

        private GetAuthenticationHeadersForRequestError()
        {
        }
    }


    public static final String KEY_AUTH_HEADERS = "auth.headers";
    private static final String TAG = com/amazon/identity/auth/device/api/AuthenticationMethod.getName();
    private final String mAuthTypeString;
    private final Context mContext;
    private final String mDirectedId;
    private final FeatureSetCache mFeatureSet;
    final MAPAccountManager mMapAccountManager;

    AuthenticationMethod(Context context, String s, AuthenticationType authenticationtype)
    {
        this(context, s, authenticationtype.getValue());
    }

    AuthenticationMethod(Context context, String s, String s1)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("Must Specify an Authentication Type");
        } else
        {
            MAPInit.getInstance(context).initialize();
            mDirectedId = s;
            mAuthTypeString = s1;
            mContext = context;
            mMapAccountManager = new MAPAccountManager(mContext);
            mFeatureSet = new FeatureSetCache(new FeatureSetProvider(mContext));
            return;
        }
    }

    static void callbackError(CallbackFuture callbackfuture, int i, String s)
    {
        if (callbackfuture == null)
        {
            return;
        } else
        {
            MAPLog.e(TAG, s);
            Bundle bundle = new Bundle();
            bundle.putInt("error_code_key", i);
            bundle.putString("error_message_key", s);
            callbackfuture.onError(bundle);
            return;
        }
    }

    private boolean checkParameters$1f04e977(Uri uri, String s, CallbackFuture callbackfuture)
    {
        try
        {
            throwIfInvalidAccount();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            callbackError(callbackfuture, 2, "The given directedId does not exist!");
            return false;
        }
        if (uri == null)
        {
            callbackError(callbackfuture, 3, "The serviceUri cannot be null, please check your parameters!");
            return false;
        }
        if (TextUtils.isEmpty(s))
        {
            callbackError(callbackfuture, 3, "The verb of the request cannot be null, please check your parameters!");
            return false;
        }
        if (TextUtils.isEmpty(mAuthTypeString))
        {
            callbackError(callbackfuture, 3, "Please specify an authentication type!");
            return false;
        }
        uri = AuthenticationType.parse(mAuthTypeString);
        if (!AuthenticationType.ADPAuthenticator.equals(uri) && !AuthenticationType.OAuth.equals(uri))
        {
            callbackError(callbackfuture, 5, "Currently MAP just support ADP and OAuh authentication type for this API. Please check your authentication type.");
            return false;
        } else
        {
            return true;
        }
    }

    private void doHeaderAuthentication(Bundle bundle, IRequestAdapter irequestadapter)
    {
        bundle = AuthenticatedRequestHelpers.getHeadersInBundle(bundle);
        if (bundle == null || bundle.size() == 0)
        {
            bundle = TAG;
        } else
        {
            bundle = bundle.entrySet().iterator();
            while (bundle.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)bundle.next();
                if (irequestadapter.getHeader((String)entry.getKey()) != null)
                {
                    String s = TAG;
                    String.format("Overridding header %s because it is needed for authentication", new Object[] {
                        entry.getKey()
                    });
                }
                irequestadapter.setHeader((String)entry.getKey(), (String)entry.getValue());
            }
        }
    }

    private void throwIfInvalidAccount()
        throws NoCredentialsException
    {
label0:
        {
            if (mDirectedId == null)
            {
                if (AuthenticationType.OAuth.getValue().equals(mAuthTypeString))
                {
                    MAPLog.e(TAG, "OAuth does not support anonymous credentials");
                    throw new NoCredentialsException("OAuth does not support anonymous credentials");
                }
            } else
            if (!mMapAccountManager.isAccountRegistered(mDirectedId))
            {
                break label0;
            }
            return;
        }
        MAPLog.e(TAG, "The account that this AuthenticationMethod with is no longer registered");
        MAPLog.accountNotRegisteredError(TAG, mDirectedId, mMapAccountManager.getAccounts());
        throw new NoCredentialsException("The account that this AuthenticationMethod with is no longer registered");
    }

    void authenticateConnection(IRequestAdapter irequestadapter)
        throws IOException
    {
        throwIfInvalidAccount();
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(getClass().getSimpleName(), "getAuthenticationBundle");
        Bundle bundle = getAuthenticationBundle(irequestadapter);
        platformmetricstimer.stop();
        if (bundle == null)
        {
            throw new IOException("Cannot authenticate because we received no token, the getToken call failed");
        } else
        {
            doHeaderAuthentication(bundle, irequestadapter);
            customAuthentication(bundle, irequestadapter);
            return;
        }
    }

    void customAuthentication(Bundle bundle, IRequestAdapter irequestadapter)
    {
    }

    String getAccount()
    {
        return mDirectedId;
    }

    Bundle getAuthenticationBundle(IRequestAdapter irequestadapter)
        throws IOException
    {
        if (irequestadapter == null)
        {
            throw new IOException("The requeset cannot be null!");
        }
        Uri uri = irequestadapter.getUri();
        String s = irequestadapter.getHttpVerb();
        byte abyte0[];
        if (!AuthenticationType.OAuth.getValue().equals(mAuthTypeString))
        {
            Map map = irequestadapter.getHeaders();
            abyte0 = irequestadapter.getBody();
            irequestadapter = map;
        } else
        {
            irequestadapter = Collections.EMPTY_MAP;
            abyte0 = new byte[0];
        }
        irequestadapter = getAuthenticationBundle(uri, s, ((Map) (irequestadapter)), abyte0, new CallbackFuture(null));
        if (irequestadapter == null)
        {
            try
            {
                throw new IOException("The future result is null!");
            }
            // Misplaced declaration of an exception variable
            catch (IRequestAdapter irequestadapter)
            {
                MAPLog.e(TAG, (new StringBuilder("Error happened when try to get authentication bundle, the error message is: ")).append(BundleUtils.toString(irequestadapter.getErrorBundle())).toString());
                throw new IOException("Error happened when try to get authentication bundle");
            }
            // Misplaced declaration of an exception variable
            catch (IRequestAdapter irequestadapter)
            {
                MAPLog.e(TAG, "InterruptedException happend when try to get authentication bundle result");
                throw new IOException("Error happened when try to get authentication bundle");
            }
            // Misplaced declaration of an exception variable
            catch (IRequestAdapter irequestadapter)
            {
                MAPLog.e(TAG, "ExecutionException happend when try to get authentication bundle result");
            }
            break MISSING_BLOCK_LABEL_192;
        }
        irequestadapter = (Bundle)irequestadapter.get();
        return irequestadapter;
        throw new IOException("Error happened when try to get authentication bundle");
    }

    abstract MAPFuture getAuthenticationBundle(Uri uri, String s, Map map, byte abyte0[], CallbackFuture callbackfuture)
        throws IOException;

    public MAPFuture getAuthenticationHeadersForRequest(Uri uri, String s, Map map, byte abyte0[], Callback callback)
    {
        CallbackFuture callbackfuture;
        callbackfuture = new CallbackFuture(callback);
        if (!checkParameters$1f04e977(uri, s, callbackfuture))
        {
            return callbackfuture;
        }
        callback = MetricsHelper.startVerboseTimer(getClass().getSimpleName(), "getAuthenticationBundle");
        getAuthenticationBundle(uri, s, map, abyte0, callbackfuture);
        callback.stop();
        return callbackfuture;
        uri;
        MAPLog.e(TAG, "Error happened when trying to sign the request components and get the http headers back!");
        callback.stop();
        return callbackfuture;
        uri;
        callback.stop();
        throw uri;
    }

    String getAuthenticationType()
    {
        return mAuthTypeString;
    }

    Context getContext()
    {
        return mContext;
    }

    FeatureSetCache getFeatureSet()
    {
        return mFeatureSet;
    }

}
