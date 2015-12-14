// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.os.Build;
import android.text.TextUtils;
import com.amazon.identity.auth.device.env.EnvironmentUtils;
import com.amazon.identity.auth.device.metadata.DeviceMetadataCollector;
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
    private String mCBLPreAuthorizedCode;
    private String mCBLPrivateCode;
    private String mCBLPublicCode;
    private String mClientContext;
    private String mCustomerToken;
    private CustomerAccountTokenType mCustomerTokenType;
    private JSONObject mDeviceMetadataJSON;
    private String mDeviceName;
    private SoftwareVersion mDeviceSoftwareVersion;
    private Map mDeviceTypeSoftwareVersionMap;
    private String mFraudMetadata;
    private String mLocale;
    private String mLogin;
    private String mMetadataAppName;
    private String mMetadataAppVersion;
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
        mCBLPublicCode = null;
        mCBLPrivateCode = null;
        mCBLPreAuthorizedCode = null;
        mUseOverrideDSN = false;
        mCustomerTokenType = CustomerAccountTokenType.AT_MAIN;
        mRegisterEndpoint = RegisterEndpointEnum.FIRS;
        mDeviceTypeSoftwareVersionMap = null;
    }

    private WebRequest getWebRequestPanda()
    {
        if (mWebRequest != null && mRegisterEndpoint == RegisterEndpointEnum.Panda)
        {
            return mWebRequest;
        }
        Object obj = new StringBuilder();
        String s = getPandaEndPointDomain();
        obj = ((StringBuilder) (obj)).append(EnvironmentUtils.getInstance().getPandaHost(s)).append("/auth/register").toString();
        if (obj == null)
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
        mWebRequest.setHost(((String) (obj)));
        mWebRequest.setVerb(HttpVerb.HttpVerbPost);
        mWebRequest.setHeader("Content-Type", "application/json");
        if (mLocale != null)
        {
            mWebRequest.setHeader("Accept-Language", mLocale);
        }
        Object obj2;
        obj2 = new JSONObject();
        ((JSONObject) (obj2)).put("use_global_authentication", "true");
        if (mAddAsSecondaryAccount)
        {
            mWebRequest.setHeader("Authorization", (new StringBuilder("Bearer ")).append(mPrimaryAccessToken).toString());
        }
        if (TextUtils.isEmpty(mCBLPreAuthorizedCode)) goto _L2; else goto _L1
_L1:
        ((JSONObject) (obj2)).put("code", mCBLPreAuthorizedCode);
_L8:
        Object obj3;
        obj3 = new JSONObject();
        ((JSONObject) (obj3)).put("domain", "Device");
        ((JSONObject) (obj3)).put("device_type", mDeviceType);
        ((JSONObject) (obj3)).put("device_serial", mDeviceSerialNumber);
        if (mMetadataAppName == null) goto _L4; else goto _L3
_L3:
        Object obj1 = mMetadataAppName;
_L16:
        ((JSONObject) (obj3)).put("app_name", obj1);
        if (mMetadataAppVersion == null) goto _L6; else goto _L5
_L5:
        obj1 = mMetadataAppVersion;
_L17:
        ((JSONObject) (obj3)).put("app_version", obj1);
        ((JSONObject) (obj3)).put("device_model", Build.MODEL);
        ((JSONObject) (obj3)).put("os_version", Build.FINGERPRINT);
        if (mDeviceSoftwareVersion == null)
        {
            break MISSING_BLOCK_LABEL_1205;
        }
        obj1 = mDeviceSoftwareVersion.getString();
_L18:
        Object obj4;
        Object obj5;
        ((JSONObject) (obj3)).put("software_version", obj1);
        if (!TextUtils.isEmpty(mDeviceName))
        {
            ((JSONObject) (obj3)).put("device_name", mDeviceName);
        }
        if (mDeviceSoftwareVersion == null)
        {
            MAPLog.e(TAG, " software_version was undefined.");
        }
        obj1 = new JSONArray();
        ((JSONArray) (obj1)).put("bearer");
        ((JSONArray) (obj1)).put("mac_dms");
        ((JSONArray) (obj1)).put("store_authentication_cookie");
        ((JSONArray) (obj1)).put("website_cookies");
        obj4 = new JSONObject();
        ((JSONObject) (obj4)).put("domain", getPandaCookieDomain());
        obj5 = new JSONArray();
        JSONObject jsonobject1;
        for (Iterator iterator = mNonAuthCookies.iterator(); iterator.hasNext(); ((JSONArray) (obj5)).put(jsonobject1))
        {
            Cookie cookie = (Cookie)iterator.next();
            jsonobject1 = new JSONObject();
            jsonobject1.put("Name", cookie.getName());
            jsonobject1.put("Value", cookie.getValue());
        }

          goto _L7
_L2:
label0:
        {
            if (TextUtils.isEmpty(mCBLPrivateCode) || TextUtils.isEmpty(mCBLPublicCode))
            {
                break label0;
            }
            obj1 = new JSONObject();
            ((JSONObject) (obj1)).put("public_code", mCBLPublicCode);
            ((JSONObject) (obj1)).put("private_code", mCBLPrivateCode);
            ((JSONObject) (obj2)).put("code_pair", obj1);
        }
          goto _L8
label1:
        {
            if (TextUtils.isEmpty(mSecondaryLogin) || TextUtils.isEmpty(mSecondaryPassword))
            {
                break label1;
            }
            obj1 = new JSONObject();
            ((JSONObject) (obj1)).put("user_id", mSecondaryLogin);
            ((JSONObject) (obj1)).put("password", mSecondaryPassword);
            ((JSONObject) (obj2)).put("user_id_password", obj1);
        }
          goto _L8
label2:
        {
            if (TextUtils.isEmpty(mSecondaryDirectedId) || TextUtils.isEmpty(mSecondaryPassword))
            {
                break label2;
            }
            obj1 = new JSONObject();
            ((JSONObject) (obj1)).put("directedId", mSecondaryDirectedId);
            ((JSONObject) (obj1)).put("password", mSecondaryPassword);
            ((JSONObject) (obj2)).put("directedId_password", obj1);
        }
          goto _L8
label3:
        {
            if (!TextUtils.isEmpty(mCustomerToken))
            {
                break label3;
            }
            obj1 = new JSONObject();
            ((JSONObject) (obj1)).put("user_id", mLogin);
            ((JSONObject) (obj1)).put("password", mPassword);
            ((JSONObject) (obj2)).put("user_id_password", obj1);
        }
          goto _L8
        if (mCustomerTokenType != CustomerAccountTokenType.ACCESS_TOKEN) goto _L10; else goto _L9
_L9:
        ((JSONObject) (obj2)).put("access_token", mCustomerToken);
          goto _L8
_L10:
        if (mCustomerTokenType != CustomerAccountTokenType.AUTH_TOKEN) goto _L8; else goto _L11
_L11:
        obj1 = new JSONObject();
        ((JSONObject) (obj1)).put("atmain", mCustomerToken);
        ((JSONObject) (obj1)).put("client_context", mClientContext);
        ((JSONObject) (obj1)).put("max_age", 0x127500);
        ((JSONObject) (obj2)).put("auth_token", obj1);
          goto _L8
_L7:
        JSONObject jsonobject;
        ((JSONObject) (obj4)).put("website_cookies", obj5);
        obj5 = new JSONArray();
        ((JSONArray) (obj5)).put("device_info");
        ((JSONArray) (obj5)).put("customer_info");
        jsonobject = new JSONObject();
        if (!mAddAsSecondaryAccount) goto _L13; else goto _L12
_L12:
        jsonobject.put("secondary_auth_data", obj2);
_L14:
        jsonobject.put("registration_data", obj3);
        jsonobject.put("requested_token_type", obj1);
        jsonobject.put("cookies", obj4);
        DeviceMetadataCollector.applyFraudMetadataIntoReqeustJSON(mFraudMetadata, jsonobject);
        if (mDeviceMetadataJSON != null && mDeviceMetadataJSON.length() > 0)
        {
            jsonobject.put("device_metadata", mDeviceMetadataJSON);
        }
        jsonobject.put("requested_extensions", obj5);
        mWebRequest.setBody(jsonobject.toString());
        obj3 = TAG;
        obj4 = mDeviceType;
        obj5 = Boolean.toString(mAddAsSecondaryAccount);
        if (mDeviceSoftwareVersion == null)
        {
            obj1 = "None";
        } else
        {
            try
            {
                obj1 = mDeviceSoftwareVersion.getString();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                MAPLog.formattedError(TAG, "Error Creating Panda web requst. Error: %s", new Object[] {
                    ((JSONException) (obj1)).getMessage()
                });
                return null;
            }
        }
        if (mLocale != null)
        {
            break MISSING_BLOCK_LABEL_1183;
        }
        obj2 = "Default";
_L15:
        MAPLog.formattedInfo(((String) (obj3)), "getWebRequest: constructed a web request with:\nDevice Type: %s\nIs Secondary Account: %s\nSoftware Version: %s\nLocale: %s", new Object[] {
            obj4, obj5, obj1, obj2
        });
        return mWebRequest;
_L13:
        jsonobject.put("auth_data", obj2);
          goto _L14
        obj2 = mLocale;
          goto _L15
_L4:
        obj1 = "defaultAppName";
          goto _L16
_L6:
        obj1 = "defaultAppVersion";
          goto _L17
        obj1 = "defaultSoftwareVersion";
          goto _L18
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

    public boolean getAddAsSecondaryAccount()
    {
        return mAddAsSecondaryAccount;
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
        return new PandaTokenExchangeRequestBuilder();
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
        if (!TextUtils.isEmpty(mDeviceName))
        {
            ((XMLElement) (obj2)).addNewChildElement("deviceName", mDeviceName);
        }
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
            ((PandaTokenExchangeRequestBuilder) (obj)).setAccessToken(mCustomerToken).setCookieDomain(mPandaCookieDomain).setAppVersion(mMetadataAppVersion).setAppName(mMetadataAppName);
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
        MAPLog.formattedInfo(((String) (obj2)), "getWebRequest: constructed a web request with:\nDevice Type: %s\nIs Secondary Account: %s\nSoftware Version: %s\nSoftware Component Id: %s\nLocale: %s", new Object[] {
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
        }
        if (!TextUtils.isEmpty(mCBLPreAuthorizedCode) || !TextUtils.isEmpty(mCBLPublicCode) && !TextUtils.isEmpty(mCBLPrivateCode))
        {
            return true;
        }
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
        } else
        {
            return true;
        }
    }

    public void setAddAsChildAccount$1385ff()
    {
        mAddAsChildAccount = true;
    }

    public void setAddAsSecondaryAccount(boolean flag)
    {
        mAddAsSecondaryAccount = flag;
    }

    public void setCBLPreAuthorizedCode(String s)
    {
        mCBLPreAuthorizedCode = s;
    }

    public void setCBLPrivateCode(String s)
    {
        mCBLPrivateCode = s;
    }

    public void setCBLPublicCode(String s)
    {
        mCBLPublicCode = s;
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

    public void setDeviceMetadataJSON(JSONObject jsonobject)
    {
        mDeviceMetadataJSON = jsonobject;
    }

    public void setDeviceName(String s)
    {
        mDeviceName = s;
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

    public void setFraudMetadata(String s)
    {
        String s1;
        if (!TextUtils.isEmpty(s))
        {
            s1 = TAG;
        }
        mFraudMetadata = s;
    }

    public boolean setLocale(String s)
    {
        mLocale = s;
        return true;
    }

    public boolean setLogin(String s)
    {
        boolean flag;
        if (RequestValidationHelper.isNullOrEmpty(s))
        {
            MAPLog.i(TAG, "isValidLogin: returning false because a null or empty login was given.");
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
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
        mMetadataAppName = s;
    }

    public void setMetadataAppVersion(String s)
    {
        mMetadataAppVersion = s;
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
            s = TAG;
            return;
        } else
        {
            mPandaEndpointDomain = s;
            return;
        }
    }

    public boolean setPassword(String s)
    {
        boolean flag;
        if (RequestValidationHelper.isNullOrEmpty(s))
        {
            MAPLog.i(TAG, "isValidPassword: returning false because a null or empty password was given.");
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
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

    public void setUseExchangeToken$1385ff()
    {
        mUseExchangeToken = true;
    }

    public void setUseOverrideDSN$1385ff()
    {
        mUseOverrideDSN = true;
    }

}
