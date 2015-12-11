// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.ADPCorpusSigningCallbackHelpers;
import com.amazon.identity.auth.device.utils.BundleUtils;
import com.amazon.identity.auth.device.utils.KeyFactoryUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.TimeUtil;
import com.amazon.identity.auth.request.AuthenticatedRequestHelpers;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticationMethod, ADPCorpusSigningAuthenticationMethod, TokenManagement, MAPCallbackErrorException, 
//            TokenKeys, AuthenticationType, MAPAccountManager, MAPFuture, 
//            Callback

class InProcessAdpAuthenticationMethod extends AuthenticationMethod
    implements ADPCorpusSigningAuthenticationMethod
{

    private static final long GET_CENTRAL_CREDENTIAL_TIME_OUT_MS;
    private static final byte NEW_LINE[] = "\n".getBytes();
    static final String TAG = com/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod.getName();
    private final String mPackageName;
    private final TokenManagement mTokenManagement;

    InProcessAdpAuthenticationMethod(Context context, String s, String s1, AuthenticationType authenticationtype)
    {
        super(context, s, authenticationtype);
        mTokenManagement = (TokenManagement)mContext.getSystemService("dcp_token_mangement");
        mPackageName = s1;
    }

    InProcessAdpAuthenticationMethod(Context context, String s, String s1, String s2)
    {
        super(context, s, s2);
        mTokenManagement = (TokenManagement)mContext.getSystemService("dcp_token_mangement");
        mPackageName = s1;
    }

    private byte[] getCorpus$56a66179(Uri uri, String s, byte abyte0[], String s1, String s2)
    {
        String s3;
        String s4;
        ByteArrayOutputStream bytearrayoutputstream;
        try
        {
            bytearrayoutputstream = new ByteArrayOutputStream();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            MAPLog.e(TAG, "Could not construct a corpus because an IOException occured", uri);
            return null;
        }
        if (s != null) goto _L2; else goto _L1
_L1:
        MAPLog.e(TAG, "No verb specified. Cannot create corpus");
        return null;
_L12:
        if (uri != null) goto _L4; else goto _L3
_L3:
        MAPLog.e(TAG, "No path specified. Cannot create corpus");
        return null;
_L10:
        if ("BustedIdentityADPAuthenticator".equals(mAuthTypeString))
        {
            uri = uri.toString();
            continue; /* Loop/switch isn't completed */
        }
        s3 = uri.getEncodedPath();
        s4 = s3;
        if (s3 == null)
        {
            s4 = "";
        }
        s3 = s4;
        if (!s4.startsWith("/"))
        {
            s3 = (new StringBuilder("/")).append(s4).toString();
        }
        s4 = uri.getEncodedQuery();
        uri = s3;
        if (!TextUtils.isEmpty(s4))
        {
            uri = (new StringBuilder()).append(s3).append("?").append(s4).toString();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!"BustedIdentityADPAuthenticator".equals(mAuthTypeString)) goto _L6; else goto _L5
_L5:
        abyte0 = new byte[0];
_L8:
        if (s2 != null)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        MAPLog.e(TAG, "Unable to retrieve ADP token for given account. Cannot generate corpus.");
        return null;
_L6:
        if (abyte0 != null) goto _L8; else goto _L7
_L7:
        abyte0 = new byte[0];
          goto _L8
        bytearrayoutputstream.write(s.getBytes());
        bytearrayoutputstream.write(NEW_LINE);
        bytearrayoutputstream.write(uri.getBytes());
        bytearrayoutputstream.write(NEW_LINE);
        bytearrayoutputstream.write(s1.getBytes());
        bytearrayoutputstream.write(NEW_LINE);
        bytearrayoutputstream.write(abyte0);
        bytearrayoutputstream.write(NEW_LINE);
        bytearrayoutputstream.write(s2.getBytes());
        uri = bytearrayoutputstream.toByteArray();
        return uri;
_L2:
        if (uri != null) goto _L10; else goto _L9
_L9:
        uri = null;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private Bundle getOptions()
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("ignore.platform.restrictions", true);
        return bundle;
    }

    private PrivateKey getPrivateKey()
    {
        PrivateKey privatekey = KeyFactoryUtils.getPrivateKey(mTokenManagement.getValue(mDirectedId, TokenKeys.getPrivateKeyKeyForPackage(mPackageName), getOptions(), GET_CENTRAL_CREDENTIAL_TIME_OUT_MS));
        return privatekey;
        Object obj;
        obj;
        MAPLog.e(TAG, "Could not sign request because there was an invalid key", ((Throwable) (obj)));
_L2:
        return null;
        obj;
        Bundle bundle = ((MAPCallbackErrorException) (obj)).getErrorBundle();
        MAPLog.e(TAG, (new StringBuilder("Getting private key failed because of callback error. Error Bundle: ")).append(BundleUtils.toString(bundle)).toString());
        continue; /* Loop/switch isn't completed */
        bundle;
        MAPLog.e(TAG, (new StringBuilder("Getting private key failed because of InterruptedException: ")).append(bundle.getMessage()).toString());
        continue; /* Loop/switch isn't completed */
        bundle;
        MAPLog.e(TAG, (new StringBuilder("Getting private key failed because of ExecutionException: ")).append(bundle.getMessage()).toString());
        continue; /* Loop/switch isn't completed */
        bundle;
        MAPLog.e(TAG, (new StringBuilder("Getting private key failed because of TimeoutException: ")).append(bundle.getMessage()).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    private byte[] signWithNewAuth(byte abyte0[], PrivateKey privatekey)
    {
        try
        {
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initSign(privatekey);
            signature.update(abyte0);
            abyte0 = signature.sign();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, "Request signing failed because of No such algorithm found.", abyte0);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, "Request signing failed because it was given an invalid key", abyte0);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, "Request signing failed because there was a problem with the signature", abyte0);
            return null;
        }
        return abyte0;
    }

    private static byte[] signWithOldAuth(byte abyte0[], PrivateKey privatekey)
    {
        try
        {
            Object obj = MessageDigest.getInstance("SHA-256");
            ((MessageDigest) (obj)).update(abyte0);
            abyte0 = ((MessageDigest) (obj)).digest();
            obj = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            ((Cipher) (obj)).init(1, privatekey);
            ((Cipher) (obj)).update(abyte0);
            abyte0 = ((Cipher) (obj)).doFinal();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, (new StringBuilder("Signing request with old auth failed because of NoSuchAlgorithmException: ")).append(abyte0.getMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, (new StringBuilder("Signing request with old auth failed because of NoSuchPaddingException: ")).append(abyte0.getMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, (new StringBuilder("Signing request with old auth failed because of IllegalBlockSizeException: ")).append(abyte0.getMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, (new StringBuilder("Signing request with old auth failed because of BadPaddingException: ")).append(abyte0.getMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, (new StringBuilder("Signing request with old auth failed because of InvalidKeyException: ")).append(abyte0.getMessage()).toString());
            return null;
        }
        return abyte0;
    }

    private boolean useLegacyAuth()
    {
        return AuthenticationType.DeviceAuthenticator.getValue().equals(mAuthTypeString);
    }

    protected MAPFuture getAuthenticationBundle(Uri uri, String s, Map map, byte abyte0[], CallbackFuture callbackfuture)
        throws IOException
    {
        map = mTokenManagement.getValue(mDirectedId, TokenKeys.getAdpTokenKeyForPackage(mPackageName), getOptions(), GET_CENTRAL_CREDENTIAL_TIME_OUT_MS);
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        AuthenticationMethod.callbackError(callbackfuture, 2, "Unable to sign request. Could not retrieve ADP token for account");
        MAPLog.e(TAG, "Unable to sign request. Could not retrieve ADP token for account");
        return callbackfuture;
        String s1;
        s1 = getCurrentTimestamp();
        uri = getCorpus$56a66179(uri, s, abyte0, s1, map);
        if (uri != null && s1 != null) goto _L2; else goto _L1
_L1:
        MAPLog.e(TAG, "Could not sign request because we were unable to create a corpus");
        uri = null;
_L3:
        if (uri != null)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        AuthenticationMethod.callbackError(callbackfuture, 3, "Unable to sign request. Could not generate ADP signature. Please check provided parameters.");
        MAPLog.e(TAG, "Unable to sign request. Could not generate ADP signature.");
        return callbackfuture;
        uri;
        uri = uri.getErrorBundle();
        AuthenticationMethod.callbackError(callbackfuture, 6, (new StringBuilder("Getting ADP Token failed because of callback error. Error Bundle: ")).append(BundleUtils.toString(uri)).toString());
        MAPLog.e(TAG, (new StringBuilder("Getting ADP Token failed because of callback error. Error Bundle: ")).append(BundleUtils.toString(uri)).toString());
        return callbackfuture;
_L2:
        uri = signBufferAsBase64(uri);
label0:
        {
            if (uri != null)
            {
                break label0;
            }
            uri = null;
        }
          goto _L3
        uri = String.format("%s:%s", new Object[] {
            uri, s1
        });
          goto _L3
        abyte0 = new Bundle();
        if (useLegacyAuth())
        {
            s = "X-ADP-Request-Digest";
        } else
        {
            s = "x-adp-signature";
        }
        AuthenticatedRequestHelpers.setHeaderInBundle(abyte0, s, uri);
        if (useLegacyAuth())
        {
            uri = "X-ADP-Authentication-Token";
        } else
        {
            uri = "x-adp-token";
        }
        AuthenticatedRequestHelpers.setHeaderInBundle(abyte0, uri, map);
        if (useLegacyAuth())
        {
            uri = null;
        } else
        {
            uri = "x-adp-alg";
        }
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_288;
        }
        if (useLegacyAuth())
        {
            s = null;
        } else
        {
            s = "SHA256WithRSA:1.0";
        }
        AuthenticatedRequestHelpers.setHeaderInBundle(abyte0, uri, s);
        if (callbackfuture == null)
        {
            break MISSING_BLOCK_LABEL_494;
        }
        callbackfuture.onSuccess(abyte0);
        return callbackfuture;
        uri;
        Thread.currentThread().interrupt();
        AuthenticationMethod.callbackError(callbackfuture, 6, (new StringBuilder("Getting ADP Token failed because of InterruptedException. This can happen if the caller kills the thread or asnc task that is calling MAP's api. Exception message: ")).append(uri.getMessage()).toString());
        MAPLog.e(TAG, (new StringBuilder("Getting ADP Token failed because of InterruptedException. This can happen if the caller kills the thread or asnc task that is calling MAP's api. Exception message: ")).append(uri.getMessage()).toString(), uri);
        return callbackfuture;
        uri;
        AuthenticationMethod.callbackError(callbackfuture, 6, (new StringBuilder("Getting ADP Token failed because of ExecutionException. This can happen when the thread or task was aborted. Exception message: ")).append(uri.getMessage()).toString());
        MAPLog.e(TAG, (new StringBuilder("Getting ADP Token failed because of ExecutionException. This can happen when the thread or task was aborted. Exception message: ")).append(uri.getMessage()).toString(), uri);
        return callbackfuture;
        uri;
        AuthenticationMethod.callbackError(callbackfuture, 6, (new StringBuilder("Getting ADP Token failed because of TimeoutException. This happens when the timeout passed into the future object occurs. Exception message: ")).append(uri.getMessage()).toString());
        MAPLog.e(TAG, (new StringBuilder("Getting ADP Token failed because of TimeoutException. This happens when the timeout passed into the future object occurs. Exception message: ")).append(uri.getMessage()).toString(), uri);
        return callbackfuture;
    }

    protected String getCurrentTimestamp()
    {
        return (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)).format(new Date());
    }

    String signBufferAsBase64(byte abyte0[])
    {
        String s = null;
        PrivateKey privatekey = getPrivateKey();
        if (privatekey == null)
        {
            return null;
        }
        if (useLegacyAuth())
        {
            abyte0 = signWithOldAuth(abyte0, privatekey);
        } else
        {
            abyte0 = signWithNewAuth(abyte0, privatekey);
        }
        if (abyte0 != null)
        {
            s = new String(Base64.encode(abyte0, 2));
        }
        return s;
    }

    public MAPFuture signCorpus(final byte corpus[], final Bundle callbackFuture, Callback callback)
    {
        callbackFuture = new CallbackFuture(callback);
        if (corpus == null)
        {
            ADPCorpusSigningCallbackHelpers.nullCorpusCallbackError(callbackFuture, TAG);
            return callbackFuture;
        }
        if (TextUtils.isEmpty(mDirectedId) || !mMapAccountManager.isAccountRegistered(mDirectedId))
        {
            ADPCorpusSigningCallbackHelpers.callbackError(callbackFuture, 2, "The account is not valid or no longer registered.");
            return callbackFuture;
        } else
        {
            mTokenManagement.getToken(mDirectedId, TokenKeys.getAdpTokenKeyForPackage(mPackageName), getOptions(), new Callback() {

                final InProcessAdpAuthenticationMethod this$0;
                final CallbackFuture val$callbackFuture;
                final byte val$corpus[];

                public void onError(Bundle bundle)
                {
                    MAPLog.e(InProcessAdpAuthenticationMethod.TAG, "Unknown error during signCorpus execution.");
                    ADPCorpusSigningCallbackHelpers.callbackError(callbackFuture, 5, "Unknown error during signCorpus execution.");
                }

                public void onSuccess(Bundle bundle)
                {
                    bundle = bundle.getString("value_key");
                    String s = signBufferAsBase64(corpus);
                    if (bundle == null || s == null)
                    {
                        ADPCorpusSigningCallbackHelpers.callbackError(callbackFuture, 2, "The account is not valid or no longer registered.");
                        return;
                    } else
                    {
                        Bundle bundle1 = new Bundle();
                        bundle1.putString("adp_signature", s);
                        bundle1.putString("adp_token", bundle);
                        callbackFuture.onSuccess(bundle1);
                        return;
                    }
                }

            
            {
                this$0 = InProcessAdpAuthenticationMethod.this;
                corpus = abyte0;
                callbackFuture = callbackfuture;
                super();
            }
            });
            return callbackFuture;
        }
    }

    static 
    {
        GET_CENTRAL_CREDENTIAL_TIME_OUT_MS = TimeUtil.fromMinutesTo(2L, TimeUnit.MILLISECONDS);
    }
}
