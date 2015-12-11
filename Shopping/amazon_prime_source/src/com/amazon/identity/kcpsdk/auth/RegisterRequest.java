// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.RequestValidationHelper;
import com.amazon.identity.kcpsdk.common.WebRequest;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            AmazonJWTHelper, JwtSigner, PIDGenerator, AmazonJwtSigner

public abstract class RegisterRequest
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/RegisterRequest.getName();
    protected String mDeviceSerialNumber;
    protected String mDeviceType;
    protected JwtSigner mJwtSigner;
    protected String mPid;
    protected String mSecret;
    protected String mTimestamp;
    protected WebRequest mWebRequest;

    public RegisterRequest()
    {
    }

    JSONObject getCustInfo()
        throws JSONException
    {
        return AmazonJWTHelper.newCustInfo();
    }

    String getJwt()
    {
        if (mJwtSigner == null)
        {
            return null;
        }
        Object obj;
        try
        {
            obj = AmazonJWTHelper.getRegistrationPayload(AmazonJWTHelper.deviceInfo(mDeviceType, mDeviceSerialNumber, mSecret), getCustInfo(), mTimestamp);
            obj = mJwtSigner.signJwt("drvV1", ((JSONObject) (obj)));
        }
        catch (Exception exception)
        {
            MAPLog.e(TAG, "Failed to sign JWT", exception);
            return null;
        }
        return ((String) (obj));
    }

    public abstract WebRequest getWebRequest();

    public final boolean setDeviceSerialNumber(String s)
    {
        if (!RequestValidationHelper.isValidDeviceSerialNumber(s))
        {
            MAPLog.e(TAG, "setDeviceSerialNumber: device serial number was invalid. Cannot be set.");
            return false;
        } else
        {
            mDeviceSerialNumber = s;
            mPid = PIDGenerator.getPid(mDeviceSerialNumber);
            return true;
        }
    }

    public final boolean setDeviceType(String s)
    {
        if (!RequestValidationHelper.isValidDeviceType(s))
        {
            MAPLog.e(TAG, "setDeviceType: deviceType was invalid. Cannot be set.");
            return false;
        } else
        {
            mDeviceType = s;
            return true;
        }
    }

    public void setJwtSigner(JwtSigner jwtsigner)
    {
        mJwtSigner = jwtsigner;
    }

    public final boolean setSecret(String s)
    {
        if (RequestValidationHelper.isNullOrEmpty(s))
        {
            return false;
        } else
        {
            mSecret = s;
            return true;
        }
    }

    public final void setTimestamp(String s)
    {
        mTimestamp = s;
        mWebRequest = null;
    }

    public void setTrustZone(Tracer tracer)
    {
        setJwtSigner(AmazonJwtSigner.getInstanceIfAvailable(tracer));
    }

}
