// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.text.TextUtils;
import com.amazon.identity.auth.device.utils.EnvironmentUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.auth.register.PandaTokenExchangeRequest;
import com.amazon.identity.kcpsdk.auth.register.PandaTokenExchangeRequestBuilder;
import com.amazon.identity.kcpsdk.common.HttpVerb;
import com.amazon.identity.kcpsdk.common.RequestValidationHelper;
import com.amazon.identity.kcpsdk.common.SoftwareVersion;
import com.amazon.identity.kcpsdk.common.WebProtocol;
import com.amazon.identity.kcpsdk.common.WebRequest;
import com.amazon.identity.kcpsdk.common.XMLAttribute;
import com.amazon.identity.kcpsdk.common.XMLCData;
import com.amazon.identity.kcpsdk.common.XMLDeviceTypeSoftwareVersionMap;
import com.amazon.identity.kcpsdk.common.XMLElement;
import com.amazon.identity.kcpsdk.common.XMLEntity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.cookie.Cookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            RegisterRequest, AmazonJWTHelper

public class RegisterDeviceRequest extends RegisterRequest
{
    public static final class CustomerAccountTokenType extends Enum
    {

        private static final CustomerAccountTokenType $VALUES[];
        public static final CustomerAccountTokenType ACCESS_TOKEN;
        public static final CustomerAccountTokenType AT_MAIN;
        public static final CustomerAccountTokenType AUTH_TOKEN;
        private final String mValue;

        public static CustomerAccountTokenType valueOf(String s)
        {
            return (CustomerAccountTokenType)Enum.valueOf(com/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType, s);
        }

        public static CustomerAccountTokenType[] values()
        {
            return (CustomerAccountTokenType[])$VALUES.clone();
        }

        public String getValue()
        {
            return mValue;
        }

        static 
        {
            AT_MAIN = new CustomerAccountTokenType("AT_MAIN", 0, "ATMain");
            ACCESS_TOKEN = new CustomerAccountTokenType("ACCESS_TOKEN", 1, "AccessToken");
            AUTH_TOKEN = new CustomerAccountTokenType("AUTH_TOKEN", 2, "AuthToken");
            $VALUES = (new CustomerAccountTokenType[] {
                AT_MAIN, ACCESS_TOKEN, AUTH_TOKEN
            });
        }

        private CustomerAccountTokenType(String s, int i, String s1)
        {
            super(s, i);
            mValue = s1;
        }
    }

    public static final class RegisterEndpointEnum extends Enum
    {

        private static final RegisterEndpointEnum $VALUES[];
        public static final RegisterEndpointEnum FIRS;
        public static final RegisterEndpointEnum Panda;

        public static RegisterEndpointEnum valueOf(String s)
        {
            return (RegisterEndpointEnum)Enum.valueOf(com/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum, s);
        }

        public static RegisterEndpointEnum[] values()
        {
            return (RegisterEndpointEnum[])$VALUES.clone();
        }

        static 
        {
            FIRS = new RegisterEndpointEnum("FIRS", 0);
            Panda = new RegisterEndpointEnum("Panda", 1);
            $VALUES = (new RegisterEndpointEnum[] {
                FIRS, Panda
            });
        }

        private RegisterEndpointEnum(String s, int i)
        {
            super(s, i);
        }
    }


    static final String TAG = com/amazon/identity/kcpsdk/auth/RegisterDeviceRequest.getName();
    private boolean mAddAsChildAccount;
    private boolean mAddAsSecondaryAccount;
    private String mClientContext;
    private String mCustomerToken;
    private CustomerAccountTokenType mCustomerTokenType;
    private SoftwareVersion mDeviceSoftwareVersion;
    private Map mDeviceTypeSoftwareVersionMap;
    private String mLocale;
    private String mLogin;
    private String mMetadataAppName;
    private String mMetadataAppVersion;
    private String mMetadataDeviceModel;
    private String mMetadataOsVersion;
    private List mNonAuthCookies;
    private String mPandaCookieDomain;
    private String mPandaEndpointDomain;
    private String mPassword;
    private String mPfmOfDelegatee;
    private String mPrimaryAccessToken;
    private String mPublicKeyAlgorithm;
    private String mPublicKeyData;
    private String mPublicKeyFormat;
    private RegisterEndpointEnum mRegisterEndpoint;
    private String mSecondaryDirectedId;
    private String mSecondaryLogin;
    private String mSecondaryPassword;
    private String mSoftwareComponentId;
    private boolean mUseExchangeToken;
    private boolean mUseOverrideDSN;

    public RegisterDeviceRequest()
    {
        mUseOverrideDSN = false;
        mCustomerTokenType = CustomerAccountTokenType.AT_MAIN;
        mRegisterEndpoint = RegisterEndpointEnum.FIRS;
        mDeviceTypeSoftwareVersionMap = null;
    }

    private String getPandaHost()
    {
        String s = getPandaEndPointDomain();
        return EnvironmentUtils.getInstance().getPandaHost(s);
    }

    private WebRequest getWebRequestPanda()
    {
        if (mWebRequest != null && mRegisterEndpoint == RegisterEndpointEnum.Panda)
        {
            return mWebRequest;
        }
        String s = (new StringBuilder()).append(getPandaHost()).append("/auth/register").toString();
        if (s == null)
        {
            MAPLog.e(TAG, "Can't determine Panda service endpoint because the CookieDomain is not set.");
            return null;
        }
        if (mCustomerTokenType == CustomerAccountTokenType.AUTH_TOKEN && (RequestValidationHelper.isNullOrEmpty(mCustomerToken) || RequestValidationHelper.isNullOrEmpty(mClientContext)))
        {
            MAPLog.e(TAG, "Customer token or ClientContext is not set. Use MAPAccountManager.KEY_AUTH_TOKEN and MAPAccountManager.KEY_AUTH_TOKEN_CONTEXT to pass them in regData.");
            return null;
        }
        mWebRequest = new WebRequest();
        mWebRequest.setProtocol(WebProtocol.WebProtocolHttps);
        mWebRequest.setHost(s);
        mWebRequest.setVerb(HttpVerb.HttpVerbPost);
        mWebRequest.setHeader("Content-Type", "application/json");
        if (EnvironmentUtils.isCurrentEnvironmentDevo())
        {
            mWebRequest.setHeader("x-forwarded-server", getPandaHost());
        }
        Object obj1;
        obj1 = new JSONObject();
        ((JSONObject) (obj1)).put("use_global_authentication", "true");
        if (mAddAsSecondaryAccount)
        {
            mWebRequest.setHeader("Authorization", (new StringBuilder("Bearer ")).append(mPrimaryAccessToken).toString());
        }
        if (TextUtils.isEmpty(mSecondaryLogin) || TextUtils.isEmpty(mSecondaryPassword)) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("user_id", mSecondaryLogin);
        jsonobject.put("password", mSecondaryPassword);
        ((JSONObject) (obj1)).put("user_id_password", jsonobject);
_L12:
        Object obj2;
        obj2 = new JSONObject();
        ((JSONObject) (obj2)).put("domain", "Device");
        ((JSONObject) (obj2)).put("device_type", mDeviceType);
        ((JSONObject) (obj2)).put("device_serial", mDeviceSerialNumber);
        if (mMetadataAppName == null) goto _L4; else goto _L3
_L3:
        Object obj = mMetadataAppName;
_L20:
        ((JSONObject) (obj2)).put("app_name", obj);
        if (mMetadataAppVersion == null) goto _L6; else goto _L5
_L5:
        obj = mMetadataAppVersion;
_L21:
        ((JSONObject) (obj2)).put("app_version", obj);
        if (mMetadataDeviceModel == null) goto _L8; else goto _L7
_L7:
        obj = mMetadataDeviceModel;
_L22:
        ((JSONObject) (obj2)).put("device_model", obj);
        if (mMetadataOsVersion == null) goto _L10; else goto _L9
_L9:
        obj = mMetadataOsVersion;
_L23:
        ((JSONObject) (obj2)).put("os_version", obj);
        if (mDeviceSoftwareVersion == null)
        {
            break MISSING_BLOCK_LABEL_1071;
        }
        obj = mDeviceSoftwareVersion.getString();
_L24:
        Object obj3;
        Object obj4;
        ((JSONObject) (obj2)).put("software_version", obj);
        if (mDeviceSoftwareVersion == null)
        {
            MAPLog.e(TAG, " software_version was undefined.");
        }
        obj = new JSONArray();
        ((JSONArray) (obj)).put("bearer");
        ((JSONArray) (obj)).put("mac_dms");
        ((JSONArray) (obj)).put("store_authentication_cookie");
        ((JSONArray) (obj)).put("website_cookies");
        obj3 = new JSONObject();
        ((JSONObject) (obj3)).put("domain", getPandaCookieDomain());
        obj4 = new JSONArray();
        JSONObject jsonobject2;
        for (Iterator iterator = mNonAuthCookies.iterator(); iterator.hasNext(); ((JSONArray) (obj4)).put(jsonobject2))
        {
            Cookie cookie = (Cookie)iterator.next();
            jsonobject2 = new JSONObject();
            jsonobject2.put("Name", cookie.getName());
            jsonobject2.put("Value", cookie.getValue());
        }

          goto _L11
_L2:
label0:
        {
            if (TextUtils.isEmpty(mSecondaryDirectedId) || TextUtils.isEmpty(mSecondaryPassword))
            {
                break label0;
            }
            obj = new JSONObject();
            ((JSONObject) (obj)).put("directedId", mSecondaryDirectedId);
            ((JSONObject) (obj)).put("password", mSecondaryPassword);
            ((JSONObject) (obj1)).put("directedId_password", obj);
        }
          goto _L12
label1:
        {
            if (!TextUtils.isEmpty(mCustomerToken))
            {
                break label1;
            }
            obj = new JSONObject();
            ((JSONObject) (obj)).put("user_id", mLogin);
            ((JSONObject) (obj)).put("password", mPassword);
            ((JSONObject) (obj1)).put("user_id_password", obj);
        }
          goto _L12
        if (mCustomerTokenType != CustomerAccountTokenType.ACCESS_TOKEN) goto _L14; else goto _L13
_L13:
        ((JSONObject) (obj1)).put("access_token", mCustomerToken);
          goto _L12
_L14:
        if (mCustomerTokenType != CustomerAccountTokenType.AUTH_TOKEN) goto _L12; else goto _L15
_L15:
        obj = new JSONObject();
        ((JSONObject) (obj)).put("atmain", mCustomerToken);
        ((JSONObject) (obj)).put("client_context", mClientContext);
        ((JSONObject) (obj)).put("max_age", 0x127500);
        ((JSONObject) (obj1)).put("auth_token", obj);
          goto _L12
_L11:
        JSONObject jsonobject1;
        ((JSONObject) (obj3)).put("website_cookies", obj4);
        obj4 = new JSONArray();
        ((JSONArray) (obj4)).put("device_info");
        ((JSONArray) (obj4)).put("customer_info");
        jsonobject1 = new JSONObject();
        if (!mAddAsSecondaryAccount) goto _L17; else goto _L16
_L16:
        jsonobject1.put("secondary_auth_data", obj1);
_L18:
        jsonobject1.put("registration_data", obj2);
        jsonobject1.put("requested_token_type", obj);
        jsonobject1.put("cookies", obj3);
        jsonobject1.put("requested_extensions", obj4);
        mWebRequest.setBody(jsonobject1.toString());
        obj2 = TAG;
        obj3 = mDeviceType;
        obj4 = Boolean.toString(mAddAsSecondaryAccount);
        if (mDeviceSoftwareVersion == null)
        {
            obj = "None";
        } else
        {
            try
            {
                obj = mDeviceSoftwareVersion.getString();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                MAPLog.e(TAG, "Error Creating Panda web requst. Error: %s", new Object[] {
                    ((JSONException) (obj)).getMessage()
                });
                return null;
            }
        }
        if (mLocale != null)
        {
            break MISSING_BLOCK_LABEL_1035;
        }
        obj1 = "Default";
_L19:
        MAPLog.i(((String) (obj2)), "getWebRequest: constructed a web request with:\nDevice Type: %s\nIs Secondary Account: %s\nSoftware Version: %s\nLocale: %s", new Object[] {
            obj3, obj4, obj, obj1
        });
        return mWebRequest;
_L17:
        jsonobject1.put("auth_data", obj1);
          goto _L18
        obj1 = mLocale;
          goto _L19
_L4:
        obj = "defaultAppName";
          goto _L20
_L6:
        obj = "defaultAppVersion";
          goto _L21
_L8:
        obj = "defaultDeviceName";
          goto _L22
_L10:
        obj = "defaultOsVersion";
          goto _L23
        obj = "defaultSoftwareVersion";
          goto _L24
    }

    public static boolean isValidCustomerAccountToken(String s)
    {
        if (RequestValidationHelper.isNullOrEmpty(s))
        {
            MAPLog.i(TAG, "isValidCustomerAccountToken: returning false because a null or empty auth token was given");
            return false;
        } else
        {
            return true;
        }
    }

    public static boolean isValidLocale(String s)
    {
        return true;
    }

    public static boolean isValidLogin(String s)
    {
        if (RequestValidationHelper.isNullOrEmpty(s))
        {
            MAPLog.i(TAG, "isValidLogin: returning false because a null or empty login was given.");
            return false;
        } else
        {
            return true;
        }
    }

    public static boolean isValidPassword(String s)
    {
        if (RequestValidationHelper.isNullOrEmpty(s))
        {
            MAPLog.i(TAG, "isValidPassword: returning false because a null or empty password was given.");
            return false;
        } else
        {
            return true;
        }
    }

    public boolean getAddAsSecondaryAccount()
    {
        return mAddAsSecondaryAccount;
    }

    public String getClientContext()
    {
        return mClientContext;
    }

    JSONObject getCustInfo()
        throws JSONException
    {
        JSONObject jsonobject = AmazonJWTHelper.newCustInfo();
        if (!TextUtils.isEmpty(mCustomerToken))
        {
            jsonobject.put("access_token", mCustomerToken);
        }
        return jsonobject;
    }

    public CustomerAccountTokenType getCustomerAccountTokenType()
    {
        return mCustomerTokenType;
    }

    public String getPandaCookieDomain()
    {
        return mPandaCookieDomain;
    }

    public String getPandaEndPointDomain()
    {
        return mPandaEndpointDomain;
    }

    protected PandaTokenExchangeRequestBuilder getPandaTokenExchangeRequestBuilder()
    {
        return PandaTokenExchangeRequest.builder();
    }

    public RegisterEndpointEnum getRegisterEndPoint()
    {
        return mRegisterEndpoint;
    }

    public WebRequest getWebRequest()
    {
        if (!isValid())
        {
            MAPLog.e(TAG, "getWebRequest: Cannot construct a WebRequest because the RegisterDeviceRequest is invalid. (See previous warnings from RegisterDeviceRequest::isValid for details.)");
            return null;
        }
        String s;
        Object obj;
        Object obj1;
        Object obj2;
        boolean flag1;
        if (mRegisterEndpoint == RegisterEndpointEnum.FIRS)
        {
            if (mWebRequest != null && mRegisterEndpoint == RegisterEndpointEnum.FIRS)
            {
                return mWebRequest;
            }
            mWebRequest = new WebRequest();
            mWebRequest.setProtocol(WebProtocol.WebProtocolHttps);
            mWebRequest.setHost(EnvironmentUtils.getInstance().getFIRSHost());
            Iterator iterator;
            Cookie cookie;
            boolean flag;
            if (mUseExchangeToken && mUseOverrideDSN)
            {
                mWebRequest.setPath("/FirsProxy/registerDeviceWithADPToken");
                mWebRequest.setAuthenticationRequired(true);
                s = null;
                flag1 = false;
                flag = false;
            } else
            if (mUseExchangeToken)
            {
                mWebRequest.setPath("/FirsProxy/registerAssociatedDevice");
                mWebRequest.setAuthenticationRequired(true);
                s = null;
                flag1 = false;
                flag = false;
            } else
            if (!TextUtils.isEmpty(mCustomerToken))
            {
                if (mAddAsSecondaryAccount)
                {
                    mWebRequest.setPath("/FirsProxy/registerDeviceToSecondaryCustomer");
                    mWebRequest.setAuthenticationRequired(true);
                    s = null;
                    flag1 = true;
                    flag = true;
                } else
                {
                    mWebRequest.setPath("/FirsProxy/registerDeviceWithToken");
                    s = getJwt();
                    flag1 = true;
                    flag = true;
                }
            } else
            if (mAddAsChildAccount)
            {
                mWebRequest.setPath("/FirsProxy/registerDeviceToSecondaryCustomer");
                mWebRequest.setAuthenticationRequired(true);
                s = null;
                flag1 = true;
                flag = false;
            } else
            {
                mWebRequest.setPath("/FirsProxy/registerDevice");
                s = null;
                flag1 = true;
                flag = false;
            }
        } else
        {
            if (mRegisterEndpoint == RegisterEndpointEnum.Panda)
            {
                return getWebRequestPanda();
            }
            MAPLog.e(TAG, (new StringBuilder("getWebRequest: Cannot construct a WebRequest because the RegisterEndpoint is unknown:")).append(mRegisterEndpoint).toString());
            return null;
        }
        mWebRequest.setVerb(HttpVerb.HttpVerbPost);
        mWebRequest.setHeader("Content-Type", "text/xml");
        mWebRequest.setHeader("Expect", "");
        if (mLocale != null)
        {
            mWebRequest.setHeader("Accept-Language", mLocale);
        }
        obj1 = new XMLElement("request", new XMLEntity[0]);
        obj2 = new XMLElement("parameters", new XMLEntity[] {
            new XMLElement("deviceType", mDeviceType, new XMLAttribute[0]), new XMLElement("deviceSerialNumber", mDeviceSerialNumber, new XMLAttribute[0]), new XMLElement("pid", mPid, new XMLAttribute[0])
        });
        ((XMLElement) (obj1)).addNewChild(((XMLEntity) (obj2)));
        if (mUseExchangeToken)
        {
            if (mAddAsSecondaryAccount)
            {
                obj = "false";
            } else
            {
                obj = "true";
            }
            ((XMLElement) (obj2)).addNewChildElement("deregisterExisting", ((String) (obj)));
        } else
        if (mCustomerToken == null && !mAddAsChildAccount)
        {
            ((XMLElement) (obj2)).addNewChildElement("email", mLogin);
            ((XMLElement) (obj2)).addNewChildElement("password", mPassword);
        } else
        if (mAddAsChildAccount)
        {
            ((XMLElement) (obj2)).addNewChildElement("directedId", mSecondaryDirectedId);
            ((XMLElement) (obj2)).addNewChildElement("customerType", "CHILD");
            if (!TextUtils.isEmpty(mPfmOfDelegatee))
            {
                ((XMLElement) (obj2)).addNewChildElement("pfm", mPfmOfDelegatee);
            }
        } else
        if (mAddAsSecondaryAccount)
        {
            ((XMLElement) (obj2)).addNewChildElement("secondaryAccessToken", mCustomerToken);
            ((XMLElement) (obj2)).addNewChildElement("secondaryAccessTokenType", mCustomerTokenType.getValue());
        } else
        {
            ((XMLElement) (obj2)).addNewChildElement("authToken", mCustomerToken);
            ((XMLElement) (obj2)).addNewChildElement("authTokenType", mCustomerTokenType.getValue());
        }
        if (mSecret != null)
        {
            ((XMLElement) (obj2)).addNewChildElement("secret", mSecret);
        }
        if (mDeviceSoftwareVersion != null && mDeviceSoftwareVersion.isValid())
        {
            ((XMLElement) (obj2)).addNewChildElement("softwareVersion", mDeviceSoftwareVersion.getString());
        } else
        {
            MAPLog.e(TAG, " softwareVersion was undefined.");
        }
        if (mSoftwareComponentId != null)
        {
            ((XMLElement) (obj2)).addNewChildElement("softwareComponentId", mSoftwareComponentId);
        }
        if (mPublicKeyData != null && mPublicKeyFormat != null && mPublicKeyAlgorithm != null)
        {
            ((XMLElement) (obj2)).addNewChildElement("publicKeyData", mPublicKeyData);
            ((XMLElement) (obj2)).addNewChildElement("publicKeyFormat", mPublicKeyFormat);
            ((XMLElement) (obj2)).addNewChildElement("publicKeyAlgorithm", mPublicKeyAlgorithm);
        }
        if (flag)
        {
            obj = getPandaTokenExchangeRequestBuilder();
            ((PandaTokenExchangeRequestBuilder) (obj)).setAccessToken(mCustomerToken).setCookieDomain(mPandaCookieDomain).setAppVersion(mMetadataAppVersion).setAppName(mMetadataAppName).setOsVersion(mMetadataOsVersion).setHwVersion(mMetadataDeviceModel);
            if (mNonAuthCookies != null)
            {
                for (iterator = mNonAuthCookies.iterator(); iterator.hasNext(); ((PandaTokenExchangeRequestBuilder) (obj)).addExistingCookie(cookie.getName(), cookie.getValue()))
                {
                    cookie = (Cookie)iterator.next();
                }

            }
            obj = ((PandaTokenExchangeRequestBuilder) (obj)).build();
            String s1;
            String s3;
            if (obj == null)
            {
                MAPLog.e(TAG, "Could not construct embeded Panda request.");
            } else
            {
                obj = ((PandaTokenExchangeRequest) (obj)).getRequest().toString();
                String s2 = TAG;
                (new StringBuilder("Including embedded panda request: ")).append(((String) (obj))).toString();
                ((XMLElement) (obj2)).addNewChild(new XMLElement("identityTokenRequest", new XMLEntity[] {
                    new XMLCData(((String) (obj)))
                }));
            }
        }
        if (flag1)
        {
            ((XMLElement) (obj1)).addNewChild(new XMLDeviceTypeSoftwareVersionMap(mDeviceTypeSoftwareVersionMap));
        }
        if (!TextUtils.isEmpty(s))
        {
            ((XMLElement) (obj2)).addNewChild(new XMLElement("deviceRequestVerificationData", s, new XMLAttribute[0]));
        }
        mWebRequest.setBody(((XMLElement) (obj1)).convertToString());
        obj2 = TAG;
        s1 = mDeviceType;
        s3 = Boolean.toString(mAddAsSecondaryAccount);
        if (mDeviceSoftwareVersion == null)
        {
            s = "None";
        } else
        {
            s = mDeviceSoftwareVersion.getString();
        }
        if (mSoftwareComponentId == null)
        {
            obj = "None";
        } else
        {
            obj = mSoftwareComponentId;
        }
        if (mLocale == null)
        {
            obj1 = "Default";
        } else
        {
            obj1 = mLocale;
        }
        MAPLog.i(((String) (obj2)), "getWebRequest: constructed a web request with:\nDevice Type: %s\nIs Secondary Account: %s\nSoftware Version: %s\nSoftware Component Id: %s\nLocale: %s", new Object[] {
            s1, s3, s, obj, obj1
        });
        if (TextUtils.isEmpty(mPublicKeyData))
        {
            s = TAG;
        } else
        {
            s = TAG;
            s = mPublicKeyData;
            s = mPublicKeyFormat;
            s = mPublicKeyAlgorithm;
        }
        s = TAG;
        s = mDeviceSerialNumber;
        s = mLogin;
        if (mSecret != null)
        {
            s = mSecret;
        } else
        {
            s = "<No Secret>";
        }
        return mWebRequest;
    }

    public boolean isValid()
    {
        if (mLogin == null && mCustomerToken == null && mSecondaryLogin == null && mSecondaryDirectedId == null && !mUseExchangeToken)
        {
            MAPLog.w(TAG, "isValid: returning false because a valid login has not been set.");
            return false;
        }
        if (mPassword == null && mCustomerToken == null && !mUseExchangeToken && mSecondaryPassword == null && !mAddAsChildAccount)
        {
            MAPLog.w(TAG, "isValid: returning false because a valid password has not been set.");
            return false;
        }
        if (mCustomerToken == null && mLogin == null && mPassword == null && !mUseExchangeToken && mPrimaryAccessToken == null && !mAddAsChildAccount)
        {
            MAPLog.w(TAG, "isValid: returning false because a valid auth token has not been set.");
            return false;
        }
        if (mDeviceType == null)
        {
            MAPLog.w(TAG, "isValid: returning false because a valid device type has not been set.");
            return false;
        }
        if (mDeviceSerialNumber == null)
        {
            MAPLog.w(TAG, "isValid: returning false because a valid serial number has not been set.");
            return false;
        }
        if (mRegisterEndpoint == null)
        {
            MAPLog.w(TAG, "isValid: returning false because a register endpoint has not been set.");
            return false;
        } else
        {
            return true;
        }
    }

    public void setAddAsChildAccount(boolean flag)
    {
        mAddAsChildAccount = flag;
    }

    public void setAddAsSecondaryAccount(boolean flag)
    {
        mAddAsSecondaryAccount = flag;
    }

    public void setClientContext(String s)
    {
        mClientContext = s;
    }

    public boolean setCustomerAccountToken(String s)
    {
        if (!isValidCustomerAccountToken(s))
        {
            MAPLog.e(TAG, "setCustomerAccountToken: password was invalid. Cannot be set.");
            return false;
        }
        if (mLogin != null || mPassword != null)
        {
            MAPLog.e(TAG, "setCustomerAccountToken: cannot specify both an auth token and a login/password. Cannot be set.");
            return false;
        } else
        {
            mCustomerToken = s;
            return true;
        }
    }

    public void setCustomerAccountTokenType(CustomerAccountTokenType customeraccounttokentype)
    {
        mCustomerTokenType = customeraccounttokentype;
    }

    public void setDeviceSoftwareVersion(SoftwareVersion softwareversion)
    {
        if (!softwareversion.isValid())
        {
            MAPLog.e(TAG, "setDeviceSoftwareVersion: device software version is invalid. Cannot be set.");
            return;
        } else
        {
            mDeviceSoftwareVersion = softwareversion;
            return;
        }
    }

    public void setDeviceTypeToSoftwareVersionMapping(Map map)
    {
        mDeviceTypeSoftwareVersionMap = new HashMap(map);
    }

    public boolean setLocale(String s)
    {
        if (!isValidLocale(s))
        {
            MAPLog.e(TAG, "setLocale: locale was invalid. Cannot be set.");
            return false;
        } else
        {
            mLocale = s;
            return true;
        }
    }

    public boolean setLogin(String s)
    {
        if (!isValidLogin(s))
        {
            MAPLog.e(TAG, "setLogin: login was invalid. Cannot be set.");
            return false;
        }
        if (mCustomerToken != null)
        {
            MAPLog.e(TAG, "setLogin: cannot specify both a login and an auth token. Cannot be set.");
            return false;
        } else
        {
            mLogin = s;
            return true;
        }
    }

    public void setMetadataAppName(String s)
    {
        MAPLog.i(TAG, "AppName is only used in Panda and is ignored in Firs.");
        mMetadataAppName = s;
    }

    public void setMetadataAppVersion(String s)
    {
        MAPLog.i(TAG, "AppVersion is only used in Panda and is ignored in Firs.");
        mMetadataAppVersion = s;
    }

    public void setMetadataDeviceModel(String s)
    {
        MAPLog.i(TAG, "DeviceModel is only used in Panda and is ignored in Firs.");
        mMetadataDeviceModel = s;
    }

    public void setMetadataOsVersion(String s)
    {
        MAPLog.i(TAG, "OsVersion is only used in Panda and is ignored in Firs.");
        mMetadataOsVersion = s;
    }

    public void setNonAuthCookies(List list)
    {
        mNonAuthCookies = list;
    }

    public void setPandaCookieDomain(String s)
    {
        mPandaCookieDomain = s;
    }

    public void setPandaEndPointDomain(String s)
    {
        if (RequestValidationHelper.isNullOrEmpty(s))
        {
            MAPLog.e(TAG, "setPandaEndpointDomain: domain was invalid (null, empty)");
            return;
        } else
        {
            mPandaEndpointDomain = s;
            return;
        }
    }

    public boolean setPassword(String s)
    {
        if (!isValidPassword(s))
        {
            MAPLog.e(TAG, "setPassword: login was invalid. Cannot be set.");
            return false;
        }
        if (mCustomerToken != null)
        {
            MAPLog.e(TAG, "setPassword: cannot specify both a password and an auth token. Cannot be set.");
            return false;
        } else
        {
            mPassword = s;
            return true;
        }
    }

    public void setPfmOfDelegatee(String s)
    {
        mPfmOfDelegatee = s;
    }

    public boolean setPrimaryAccessToken(String s)
    {
        if (!isValidCustomerAccountToken(s))
        {
            MAPLog.e(TAG, "setmPrimaryToken: token is invalid. Cannot be set.");
            return false;
        } else
        {
            mPrimaryAccessToken = s;
            return true;
        }
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

    public void setRegisterEndpoint(RegisterEndpointEnum registerendpointenum)
    {
        mRegisterEndpoint = registerendpointenum;
    }

    public void setSecondaryDirectedId(String s)
    {
        mSecondaryDirectedId = s;
    }

    public void setSecondaryLogin(String s)
    {
        mSecondaryLogin = s;
    }

    public void setSecondaryPassword(String s)
    {
        mSecondaryPassword = s;
    }

    public void setSoftwareComponentId(String s)
    {
        mSoftwareComponentId = s;
    }

    public void setUseExchangeToken(boolean flag)
    {
        mUseExchangeToken = flag;
    }

    public void setUseOverrideDSN(boolean flag)
    {
        mUseOverrideDSN = flag;
    }

}
