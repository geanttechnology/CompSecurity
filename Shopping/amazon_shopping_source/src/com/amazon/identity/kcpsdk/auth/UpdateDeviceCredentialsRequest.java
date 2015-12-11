// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.EnvironmentUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.HttpVerb;
import com.amazon.identity.kcpsdk.common.RequestValidationHelper;
import com.amazon.identity.kcpsdk.common.SoftwareVersion;
import com.amazon.identity.kcpsdk.common.WebRequest;
import com.amazon.identity.kcpsdk.common.XMLDeviceTypeSoftwareVersionMap;
import com.amazon.identity.kcpsdk.common.XMLElement;
import com.amazon.identity.kcpsdk.common.XMLEntity;
import java.util.HashMap;
import java.util.Map;

public class UpdateDeviceCredentialsRequest
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/UpdateDeviceCredentialsRequest.getName();
    private Map mDeviceTypeSoftwareVersionMap;
    private String mReason;
    private String mSoftwareComponentId;
    private SoftwareVersion mSoftwareVersion;
    private String mUrl;
    private WebRequest mWebRequest;

    public UpdateDeviceCredentialsRequest()
    {
        mUrl = getDefaultUrl();
    }

    public static String getDefaultUrl()
    {
        return (new StringBuilder("https://")).append(EnvironmentUtils.getInstance().getFIRSHost()).append("/FirsProxy/getDeviceCredentials").toString();
    }

    public static boolean isValidReason(String s)
    {
        if (RequestValidationHelper.isNullOrEmpty(s))
        {
            MAPLog.i(TAG, "isValidReason: returning false because a null or empty reason was given.");
            return false;
        } else
        {
            return true;
        }
    }

    public static boolean isValidSoftwareVersion(SoftwareVersion softwareversion)
    {
        return true;
    }

    public static boolean isValidURL(String s)
    {
        return WebRequest.isValidUrl(s);
    }

    public WebRequest getWebRequest()
    {
        if (!isValid())
        {
            MAPLog.e(TAG, "getWebRequest: Cannot construct a WebRequest because the UpdateDeviceCredentialsRequest is invalid. (See previous warnings from UpdateDeviceCredentialsRequest::isValid for details.)");
            return null;
        }
        if (mWebRequest != null)
        {
            return mWebRequest;
        }
        mWebRequest = new WebRequest();
        mWebRequest.setUrl(mUrl);
        mWebRequest.setVerb(HttpVerb.HttpVerbGet);
        if (mReason != null)
        {
            mWebRequest.addQueryParameter("reason", mReason);
        }
        if (mSoftwareVersion != null)
        {
            mWebRequest.addQueryParameter("softwareVersion", mSoftwareVersion.getString());
        }
        if (mSoftwareComponentId != null)
        {
            mWebRequest.addQueryParameter("softwareComponentId", mSoftwareComponentId);
        }
        mWebRequest.setHeader("Content-Type", "text/xml");
        if (mDeviceTypeSoftwareVersionMap != null && mDeviceTypeSoftwareVersionMap.size() > 0)
        {
            XMLElement xmlelement = new XMLElement("request", new XMLEntity[0]);
            xmlelement.addNewChild(new XMLDeviceTypeSoftwareVersionMap(mDeviceTypeSoftwareVersionMap));
            mWebRequest.setBody(xmlelement.convertToString());
            mWebRequest.setVerb(HttpVerb.HttpVerbPost);
        }
        mWebRequest.setAuthenticationRequired(true);
        MAPLog.i(TAG, "getWebRequest: constructed a web request with:\nReason: %s", new Object[] {
            mReason
        });
        return mWebRequest;
    }

    public boolean isValid()
    {
        if (RequestValidationHelper.isNullOrEmpty(mUrl))
        {
            MAPLog.w(TAG, "isValid: returning false because a valid url has not been set.");
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

    public boolean setReason(String s)
    {
        if (!isValidReason(s))
        {
            MAPLog.e(TAG, "setReason: reason was invalid. Cannot be set.");
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

    public boolean setSoftwareVersion(SoftwareVersion softwareversion)
    {
        if (!isValidSoftwareVersion(softwareversion))
        {
            MAPLog.e(TAG, "setSoftwareVersion: software version was invalid. Cannot be set.");
            return false;
        } else
        {
            mSoftwareVersion = softwareversion;
            return true;
        }
    }

    public boolean setURL(String s)
    {
        if (!isValidURL(s))
        {
            MAPLog.e(TAG, "setURL: url is invalid. Cannot be set. Invalidating default URL to prevent it from being used.");
            mUrl = null;
            return false;
        } else
        {
            mUrl = s;
            return true;
        }
    }

}
