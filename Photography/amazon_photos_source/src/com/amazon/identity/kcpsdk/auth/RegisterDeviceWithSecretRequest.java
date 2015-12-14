// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.text.TextUtils;
import com.amazon.identity.auth.device.env.EnvironmentUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.HttpVerb;
import com.amazon.identity.kcpsdk.common.RequestValidationHelper;
import com.amazon.identity.kcpsdk.common.SoftwareVersion;
import com.amazon.identity.kcpsdk.common.WebProtocol;
import com.amazon.identity.kcpsdk.common.WebRequest;
import com.amazon.identity.kcpsdk.common.XMLDeviceTypeSoftwareVersionMap;
import com.amazon.identity.kcpsdk.common.XMLElement;
import com.amazon.identity.kcpsdk.common.XMLEntity;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            RegisterRequest

public class RegisterDeviceWithSecretRequest extends RegisterRequest
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/RegisterDeviceWithSecretRequest.getName();
    private Map mDeviceTypeSoftwareVersionMap;
    private String mLocale;
    private String mPublicKeyAlgorithm;
    private String mPublicKeyData;
    private String mPublicKeyFormat;
    private String mRadioId;
    private String mReason;
    private String mSecondaryRadioId;
    private String mSoftwareComponentId;
    private SoftwareVersion mVersionNumber;

    public RegisterDeviceWithSecretRequest()
    {
    }

    public WebRequest getWebRequest()
    {
        if (!isValid())
        {
            MAPLog.e(TAG, "getWebRequest: Cannot construct a WebRequest because the RegisterDeviceWithSecretRequest is invalid. (See previous warnings from RegisterDeviceWithSecretRequest::isValid for details.)");
            return null;
        }
        if (mWebRequest != null)
        {
            return mWebRequest;
        }
        mWebRequest = new WebRequest();
        if (mLocale != null)
        {
            mWebRequest.setHeader("Accept-Language", mLocale);
        }
        mWebRequest.setProtocol(WebProtocol.WebProtocolHttps);
        mWebRequest.setHost(EnvironmentUtils.getInstance().getFIRSHost());
        mWebRequest.setPath("/FirsProxy/getNewDeviceCredentials");
        mWebRequest.setVerb(HttpVerb.HttpVerbPost);
        mWebRequest.addQueryParameter("deviceType", mDeviceType);
        mWebRequest.addQueryParameter("deviceSerialNumber", mDeviceSerialNumber);
        mWebRequest.addQueryParameter("secret", mSecret);
        mWebRequest.addQueryParameter("radioId", mRadioId);
        if (mSecondaryRadioId != null)
        {
            mWebRequest.addQueryParameter("secondaryRadioId", mSecondaryRadioId);
        }
        if (mReason != null)
        {
            mWebRequest.addQueryParameter("reason", mReason);
        }
        if (mVersionNumber != null && mVersionNumber.isValid())
        {
            mWebRequest.addQueryParameter("softwareVersion", mVersionNumber.getString());
        }
        if (mSoftwareComponentId != null)
        {
            mWebRequest.addQueryParameter("softwareComponentId", mSoftwareComponentId);
        }
        if (mPublicKeyData != null && mPublicKeyFormat != null && mPublicKeyAlgorithm != null)
        {
            mWebRequest.addQueryParameter("publicKeyData", mPublicKeyData);
            mWebRequest.addQueryParameter("publicKeyFormat", mPublicKeyFormat);
            mWebRequest.addQueryParameter("publicKeyAlgorithm", mPublicKeyAlgorithm);
        }
        Object obj = getJwt();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            mWebRequest.addQueryParameter("deviceRequestVerificationData", ((String) (obj)));
        }
        mWebRequest.setHeader("Content-Type", "text/xml");
        if (mDeviceTypeSoftwareVersionMap != null && mDeviceTypeSoftwareVersionMap.size() > 0)
        {
            obj = new XMLElement("request", new XMLEntity[0]);
            ((XMLElement) (obj)).addNewChild(new XMLDeviceTypeSoftwareVersionMap(mDeviceTypeSoftwareVersionMap));
            mWebRequest.setBody(((XMLElement) (obj)).convertToString());
        }
        mWebRequest.setAuthenticationRequired(false);
        String s2 = TAG;
        String s3 = mDeviceType;
        String s4 = mReason;
        String s;
        String s1;
        if (mVersionNumber != null)
        {
            obj = mVersionNumber.getString();
        } else
        {
            obj = "";
        }
        if (mSoftwareComponentId == null)
        {
            s = "None";
        } else
        {
            s = mSoftwareComponentId;
        }
        if (mLocale == null)
        {
            s1 = "Default";
        } else
        {
            s1 = mLocale;
        }
        MAPLog.formattedInfo(s2, "getWebRequest: constructed a web request with:\nDevice Type: %s\nReason: %s\nVersion Number: %s\nSoftware Component Id: %s\nLocale: %s", new Object[] {
            s3, s4, obj, s, s1
        });
        obj = TAG;
        obj = mDeviceSerialNumber;
        obj = mRadioId;
        obj = mSecondaryRadioId;
        obj = mSecret;
        return mWebRequest;
    }

    public boolean isValid()
    {
        if (mDeviceType == null)
        {
            MAPLog.w(TAG, "isValid: returning false because a valid device type has not been set.");
            return false;
        }
        if (mDeviceSerialNumber == null)
        {
            MAPLog.w(TAG, "isValid: returning false because a valid device serial number has not been set.");
            return false;
        }
        if (mSecret == null)
        {
            MAPLog.w(TAG, "isValid: returning false because a valid secret has not been set.");
            return false;
        }
        if (mRadioId == null)
        {
            MAPLog.w(TAG, "isValid: returning false because a valid radio id has not been set.");
            return false;
        } else
        {
            return true;
        }
    }

    public void setDeviceTypeToSoftwareVersionMapping(Map map)
    {
        mDeviceTypeSoftwareVersionMap = new HashMap(map);
    }

    public boolean setLocale(String s)
    {
        String s1 = mLocale;
        mLocale = s;
        return true;
    }

    public void setPublicKeyAlgorithm(String s)
    {
        mPublicKeyAlgorithm = s;
    }

    public void setPublicKeyData(String s)
    {
        mPublicKeyData = s;
    }

    public void setPublicKeyFormat(String s)
    {
        mPublicKeyFormat = s;
    }

    public boolean setRadioId(String s)
    {
        boolean flag;
        if (RequestValidationHelper.isNullOrEmpty(s))
        {
            MAPLog.i(TAG, "isValidRadioId: returning false because a null or empty radio id was given.");
            flag = false;
        } else
        if (!RequestValidationHelper.isAlphaNumeric(s))
        {
            MAPLog.i(TAG, "isValidRadioId: returning false because a non alpha radio id number was given.");
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            MAPLog.e(TAG, "setRadioId: radio id was invalid. Cannot set.");
            return false;
        } else
        {
            mRadioId = s;
            return true;
        }
    }

    public boolean setReason(String s)
    {
        boolean flag;
        if (RequestValidationHelper.isNullOrEmpty(s))
        {
            MAPLog.i(TAG, "isValidReason: returning false because a null or empty reason was given.");
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            MAPLog.e(TAG, "setReason: reason was invalid. Cannot set.");
            return false;
        } else
        {
            mReason = s;
            return true;
        }
    }

    public void setSoftwareComponentId(String s)
    {
        mSoftwareComponentId = s;
    }

    public boolean setVersionNumber(SoftwareVersion softwareversion)
    {
        if (!softwareversion.isValid())
        {
            MAPLog.e(TAG, "setVersionNumber: version number was invalid. Cannot set.");
            return false;
        } else
        {
            mVersionNumber = softwareversion;
            return true;
        }
    }

}
