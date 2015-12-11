// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.util.Base64;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.WebRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            ITokenAuthProvider

public class RequestSigner
{
    private class CorpusBuilder
    {

        private byte mBody[];
        private ByteArrayOutputStream mCorpus;
        private boolean mIsValid;
        private String mPath;
        private String mTimestamp;
        private String mToken;
        private String mVerb;
        final RequestSigner this$0;

        public byte[] getCorpus()
        {
            return mCorpus.toByteArray();
        }

        public String getTimestamp()
        {
            return mTimestamp;
        }

        public boolean isValid()
        {
            return mIsValid;
        }

        public boolean validateComponents()
        {
            boolean flag = true;
            if (mVerb == null || mTimestamp == null || mToken == null)
            {
                flag = false;
            }
            return flag;
        }

        public CorpusBuilder(ITokenAuthProvider itokenauthprovider, WebRequest webrequest, String s)
        {
            this$0 = RequestSigner.this;
            super();
            mPath = "";
            mBody = new byte[0];
            mCorpus = new ByteArrayOutputStream();
            mTimestamp = s;
            if (mTimestamp == null)
            {
                mTimestamp = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)).format(new Date());
            }
            if (itokenauthprovider != null)
            {
                itokenauthprovider = itokenauthprovider.getToken();
                if (itokenauthprovider != null)
                {
                    mToken = itokenauthprovider;
                }
            }
            if (webrequest == null) goto _L2; else goto _L1
_L1:
            itokenauthprovider = webrequest.getVerbAsString();
            if (itokenauthprovider != null)
            {
                mVerb = itokenauthprovider;
            }
            if (!mUseBustedIdentityBehavior) goto _L4; else goto _L3
_L3:
            mPath = webrequest.getUrl();
_L9:
            if (!mUseBustedIdentityBehavior) goto _L6; else goto _L5
_L5:
            mBody = new byte[0];
_L2:
            if (!validateComponents())
            {
                break MISSING_BLOCK_LABEL_292;
            }
            mCorpus.write((new StringBuilder()).append(mVerb).append("\n").toString().getBytes("UTF-8"));
            mCorpus.write((new StringBuilder()).append(mPath).append("\n").toString().getBytes("UTF-8"));
            mCorpus.write((new StringBuilder()).append(mTimestamp).append("\n").toString().getBytes("UTF-8"));
            mCorpus.write(mBody);
            mCorpus.write("\n".getBytes("UTF-8"));
            mCorpus.write(mToken.getBytes("UTF-8"));
            mIsValid = true;
            return;
_L4:
            itokenauthprovider = webrequest.getPathAndQueryString();
            if (itokenauthprovider != null)
            {
                mPath = itokenauthprovider;
                if (!mPath.startsWith("/"))
                {
                    mPath = (new StringBuilder()).append(mPath).append("/").append(mPath).toString();
                }
            }
            continue; /* Loop/switch isn't completed */
_L6:
            requestsigner = webrequest.getBodyBytes();
            if (RequestSigner.this != null)
            {
                mBody = RequestSigner.this;
            }
            if (true) goto _L2; else goto _L7
_L7:
            requestsigner;
            MAPLog.e(RequestSigner.TAG, (new StringBuilder("corpusbuilder: UnsupportedEncodingException error: ")).append(getMessage()).toString());
            return;
            requestsigner;
            MAPLog.e(RequestSigner.TAG, (new StringBuilder("corpusbuilder: IOException error: ")).append(getMessage()).toString());
            return;
            if (true) goto _L9; else goto _L8
_L8:
        }
    }


    private static final String TAG = com/amazon/identity/kcpsdk/auth/RequestSigner.getName();
    private String mADPAlgorithm;
    private final ITokenAuthProvider mAuthProvider;
    private String mOverriddenTimestamp;
    private boolean mUseBustedIdentityBehavior;
    private boolean mUseLegacyAuth;

    public RequestSigner(ITokenAuthProvider itokenauthprovider)
    {
        mADPAlgorithm = null;
        mAuthProvider = itokenauthprovider;
        mUseLegacyAuth = false;
        mUseBustedIdentityBehavior = false;
    }

    private void initADPAlgorithm()
    {
        if (mADPAlgorithm == null)
        {
            mADPAlgorithm = mAuthProvider.getSignAlgo();
        }
    }

    public static boolean isValidAlgorithm(String s)
    {
        try
        {
            Signature.getInstance(s);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            MAPLog.w(TAG, String.format("isValidAlgorithm: %s is an invalid algorithm", new Object[] {
                s
            }));
            return false;
        }
        return true;
    }

    private byte[] signWithNewAuth(byte abyte0[], PrivateKey privatekey)
    {
        try
        {
            initADPAlgorithm();
            Signature signature = Signature.getInstance(mADPAlgorithm);
            signature.initSign(privatekey);
            signature.update(abyte0);
            abyte0 = signature.sign();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, (new StringBuilder("signWithNewAuth: failed because of NoSuchAlgorithmException: ")).append(abyte0.getMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, (new StringBuilder("signWithNewAuth: failed because of InvalidKeyException: ")).append(abyte0.getMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, (new StringBuilder("signWithNewAuth: failed because of SignatureException: ")).append(abyte0.getMessage()).toString());
            return null;
        }
        return abyte0;
    }

    private byte[] signWithOldAuth(byte abyte0[], PrivateKey privatekey)
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
            MAPLog.e(TAG, (new StringBuilder("signWithOldAuth: failed because of NoSuchAlgorithmException: ")).append(abyte0.getMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, (new StringBuilder("signWithOldAuth: failed because of NoSuchPaddingException: ")).append(abyte0.getMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, (new StringBuilder("signWithOldAuth: failed because of IllegalBlockSizeException: ")).append(abyte0.getMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, (new StringBuilder("signWithOldAuth: failed because of BadPaddingException: ")).append(abyte0.getMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            MAPLog.e(TAG, (new StringBuilder("signWithOldAuth: failed because of InvalidKeyException: ")).append(abyte0.getMessage()).toString());
            return null;
        }
        return abyte0;
    }

    public String getAdpAlgorithm()
    {
        if (mUseLegacyAuth)
        {
            return null;
        } else
        {
            initADPAlgorithm();
            return (new StringBuilder()).append(mADPAlgorithm).append(":1.0").toString();
        }
    }

    public String getAdpAlgorithmHeaderName()
    {
        if (mUseLegacyAuth)
        {
            return null;
        } else
        {
            return "x-adp-alg";
        }
    }

    public String getAdpSignature(WebRequest webrequest)
    {
        Object obj = new CorpusBuilder(mAuthProvider, webrequest, mOverriddenTimestamp);
        if (!((CorpusBuilder) (obj)).isValid())
        {
            MAPLog.e(TAG, "RequestSigner: signRequest: unable to sign request, confirm that the ITokenAuthProvider implementation is providing correct token.");
        } else
        {
            webrequest = ((CorpusBuilder) (obj)).getCorpus();
            obj = ((CorpusBuilder) (obj)).getTimestamp();
            if (webrequest != null && obj != null)
            {
                webrequest = signBufferAsBase64(webrequest);
                if (webrequest != null)
                {
                    return String.format("%s:%s", new Object[] {
                        webrequest, obj
                    });
                }
            }
        }
        return null;
    }

    public String getAdpSignatureHeaderName()
    {
        if (mUseLegacyAuth)
        {
            return "X-ADP-Request-Digest";
        } else
        {
            return "x-adp-signature";
        }
    }

    public String getAdpToken()
    {
        return mAuthProvider.getToken();
    }

    public String getAdpTokenHeaderName()
    {
        if (mUseLegacyAuth)
        {
            return "X-ADP-Authentication-Token";
        } else
        {
            return "x-adp-token";
        }
    }

    public boolean getUseLegacyAuthentication()
    {
        return mUseLegacyAuth;
    }

    public void setUseBustedIdentityBehavior(boolean flag)
    {
        mUseBustedIdentityBehavior = flag;
    }

    public void setUseLegacyAuthentication(boolean flag)
    {
        mUseLegacyAuth = flag;
        if (mUseLegacyAuth)
        {
            MAPLog.i(TAG, (new StringBuilder("Try to set useLegacyAuthentication to be true when algorithm is: ")).append(mADPAlgorithm).toString());
            if (mAuthProvider != null)
            {
                initADPAlgorithm();
                if (!mADPAlgorithm.equalsIgnoreCase("SHA256WithRSA"))
                {
                    throw new IllegalStateException((new StringBuilder("LegacyAuthentication is not compatible with algorithm:")).append(mADPAlgorithm).toString());
                }
            }
        }
    }

    public String signBufferAsBase64(byte abyte0[])
    {
        String s = null;
        PrivateKey privatekey = mAuthProvider.getParsedPrivateKey();
        if (privatekey == null)
        {
            return null;
        }
        if (mUseLegacyAuth)
        {
            initADPAlgorithm();
            if (!mADPAlgorithm.equals("SHA256WithRSA"))
            {
                MAPLog.e(TAG, (new StringBuilder("Try to use legacy auth when the algorithm is ")).append(mADPAlgorithm).toString());
            }
            abyte0 = signWithOldAuth(abyte0, privatekey);
        } else
        {
            abyte0 = signWithNewAuth(abyte0, privatekey);
        }
        if (abyte0 != null)
        {
            s = Base64.encodeToString(abyte0, 2);
        }
        return s;
    }

    public boolean signRequest(WebRequest webrequest)
    {
        String s = getAdpSignature(webrequest);
        if (s == null)
        {
            return false;
        }
        webrequest.setHeader(getAdpSignatureHeaderName(), s);
        webrequest.setHeader(getAdpTokenHeaderName(), mAuthProvider.getToken());
        if (getAdpAlgorithmHeaderName() != null)
        {
            webrequest.setHeader(getAdpAlgorithmHeaderName(), getAdpAlgorithm());
        }
        return true;
    }

    public void testOverrideTimestamp(String s)
    {
        mOverriddenTimestamp = s;
    }



}
