// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.metadata.DeviceMetadataCollector;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.HttpVerb;
import com.amazon.identity.kcpsdk.common.RequestValidationHelper;
import com.amazon.identity.kcpsdk.common.SoftwareVersion;
import com.amazon.identity.kcpsdk.common.WebProtocol;
import com.amazon.identity.kcpsdk.common.WebRequest;
import java.security.MessageDigest;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            PandaRequest, AmazonJWTHelper, JwtSigner

public class PandaAuthenticateAccountRequest extends PandaRequest
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/PandaAuthenticateAccountRequest.getName();
    private String mDeviceSerialNumber;
    private SoftwareVersion mDeviceSoftwareVersion;
    private String mDeviceType;
    private String mDirectedId;
    private String mFraudMetadata;
    private JwtSigner mJwtSigner;
    private String mLocale;
    private String mMetadataAppName;
    private String mMetadataAppVersion;
    private String mPassword;
    private String mTrustedDeviceToken;
    private String mUserID;
    private WebRequest mWebRequest;

    public PandaAuthenticateAccountRequest()
    {
    }

    public JSONObject getRequestJSON()
        throws JSONException
    {
        JSONObject jsonobject;
        JSONObject jsonobject2;
        jsonobject = new JSONObject();
        Object obj = new JSONObject();
        jsonobject.put("auth_data", obj);
        ((JSONObject) (obj)).put("use_global_authentication", "true");
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("password", mPassword);
        if (!TextUtils.isEmpty(mUserID) && !TextUtils.isEmpty(mDirectedId))
        {
            throw new IllegalStateException("Invalid parameters. Cannot set both login and directedId.");
        }
        if (!TextUtils.isEmpty(mUserID))
        {
            jsonobject1.put("user_id", mUserID);
            ((JSONObject) (obj)).put("user_id_password", jsonobject1);
        } else
        if (!TextUtils.isEmpty(mDirectedId))
        {
            jsonobject1.put("directedId", mDirectedId);
            ((JSONObject) (obj)).put("directedId_password", jsonobject1);
        } else
        {
            throw new IllegalStateException("Invalid parameters.");
        }
        if (!TextUtils.isEmpty(mTrustedDeviceToken))
        {
            ((JSONObject) (obj)).put("trusted_device_token", mTrustedDeviceToken);
        }
        jsonobject1 = new JSONObject();
        jsonobject.put("signin_data", jsonobject1);
        jsonobject1.put("device_serial", mDeviceSerialNumber);
        jsonobject1.put("device_type", mDeviceType);
        jsonobject1.put("domain", "Device");
        if (mMetadataAppName != null)
        {
            obj = mMetadataAppName;
        } else
        {
            obj = "defaultAppName";
        }
        jsonobject1.put("app_name", obj);
        if (mMetadataAppVersion != null)
        {
            obj = mMetadataAppVersion;
        } else
        {
            obj = "defaultAppVersion";
        }
        jsonobject1.put("app_version", obj);
        jsonobject1.put("device_model", Build.MODEL);
        jsonobject1.put("os_version", Build.FINGERPRINT);
        if (mDeviceSoftwareVersion != null)
        {
            obj = mDeviceSoftwareVersion.getString();
        } else
        {
            obj = "defaultSoftwareVersion";
        }
        jsonobject1.put("software_version", obj);
        DeviceMetadataCollector.applyFraudMetadataIntoReqeustJSON(mFraudMetadata, jsonobject);
        if (mDeviceSoftwareVersion == null)
        {
            MAPLog.e(TAG, " software_version was undefined.");
        }
        if (mJwtSigner == null) goto _L2; else goto _L1
_L1:
        obj = AmazonJWTHelper.deviceInfo(mDeviceType, mDeviceSerialNumber, null);
        jsonobject2 = AmazonJWTHelper.newCustInfo();
        if (TextUtils.isEmpty(mUserID)) goto _L4; else goto _L3
_L3:
        jsonobject2.put("email_hash", Base64.encodeToString(MessageDigest.getInstance("SHA256").digest(mUserID.getBytes("UTF-8")), 2));
_L6:
        obj = AmazonJWTHelper.getRegistrationPayload(((JSONObject) (obj)), jsonobject2, null);
        jsonobject1.put("device_authentication_token", mJwtSigner.signJwt("drvV2", ((JSONObject) (obj))));
_L2:
        return jsonobject;
_L4:
        if (TextUtils.isEmpty(mDirectedId)) goto _L6; else goto _L5
_L5:
        jsonobject2.put("directed_id", mDirectedId);
          goto _L6
        Exception exception;
        exception;
        MAPLog.e(TAG, "Failed to sign JWT", exception);
        return jsonobject;
    }

    public WebRequest getWebRequest()
    {
        if (mWebRequest != null)
        {
            return mWebRequest;
        }
        String s = getPandaEndPoint("/auth/signin");
        if (s == null)
        {
            MAPLog.e(TAG, " CookieDomain not set.");
            return null;
        }
        mWebRequest = new WebRequest();
        mWebRequest.setProtocol(WebProtocol.WebProtocolHttps);
        mWebRequest.setHost(s);
        mWebRequest.setVerb(HttpVerb.HttpVerbPost);
        mWebRequest.setHeader("Content-Type", "application/json");
        if (mLocale != null)
        {
            mWebRequest.setHeader("Accept-Language", mLocale);
        }
        try
        {
            JSONObject jsonobject = getRequestJSON();
            mWebRequest.setBody(jsonobject.toString());
        }
        catch (JSONException jsonexception)
        {
            throw new RuntimeException(jsonexception);
        }
        return mWebRequest;
    }

    public void setDeviceInfo(SSODeviceInfo ssodeviceinfo)
    {
        setDeviceSerialNumber(ssodeviceinfo.getDeviceSerialNumber());
        setDeviceType(ssodeviceinfo.getDeviceType());
        setDeviceSoftwareVersion(ssodeviceinfo.getSoftwareVersion());
    }

    public boolean setDeviceSerialNumber(String s)
    {
        if (!RequestValidationHelper.isValidDeviceSerialNumber(s))
        {
            MAPLog.e(TAG, " setDeviceSerialNumber: device serial number was invalid. Cannot be set.");
            return false;
        } else
        {
            mDeviceSerialNumber = s;
            return true;
        }
    }

    public void setDeviceSoftwareVersion(SoftwareVersion softwareversion)
    {
        if (softwareversion == null || !softwareversion.isValid())
        {
            MAPLog.e(TAG, " setDeviceSoftwareVersion: device software version is invalid. Cannot be set.");
            return;
        } else
        {
            mDeviceSoftwareVersion = softwareversion;
            return;
        }
    }

    public boolean setDeviceType(String s)
    {
        if (!RequestValidationHelper.isValidDeviceType(s))
        {
            MAPLog.e(TAG, " setDeviceType: deviceType was invalid. Cannot be set.");
            return false;
        } else
        {
            mDeviceType = s;
            return true;
        }
    }

    public boolean setDirectedId(String s)
    {
        boolean flag;
        if (RequestValidationHelper.isNullOrEmpty(s))
        {
            MAPLog.i(TAG, " isValidDirectedId: returning false because a null or empty directedId was given.");
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            MAPLog.e(TAG, " setDirectedId: directedId was invalid. Cannot be set.");
            return false;
        } else
        {
            mDirectedId = s;
            return true;
        }
    }

    public void setFraudMetadata(String s)
    {
        String s1;
        if (!TextUtils.isEmpty(s))
        {
            s1 = TAG;
        }
        mFraudMetadata = s;
    }

    public void setJwtSigner(JwtSigner jwtsigner)
    {
        mJwtSigner = jwtsigner;
    }

    public void setLocale(String s)
    {
        String s1 = TAG;
        (new StringBuilder("Setting locale to ")).append(s).toString();
        mLocale = s;
    }

    public void setMetadataAppName(String s)
    {
        mMetadataAppName = s;
    }

    public void setMetadataAppVersion(String s)
    {
        mMetadataAppVersion = s;
    }

    public boolean setPassword(String s)
    {
        boolean flag;
        if (RequestValidationHelper.isNullOrEmpty(s))
        {
            MAPLog.i(TAG, " isValidPassword: returning false because a null or empty password was given.");
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            MAPLog.e(TAG, " setPassword: password was invalid. Cannot be set.");
            return false;
        } else
        {
            mPassword = s;
            return true;
        }
    }

    public void setTrustedDeviceToken(String s)
    {
        mTrustedDeviceToken = s;
    }

    public boolean setUserID(String s)
    {
        boolean flag;
        if (RequestValidationHelper.isNullOrEmpty(s))
        {
            MAPLog.i(TAG, " isValidUserID: returning false because a null or empty user ID was given.");
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            MAPLog.e(TAG, " setUserID: userID was invalid. Cannot be set.");
            return false;
        } else
        {
            mUserID = s;
            return true;
        }
    }

}
