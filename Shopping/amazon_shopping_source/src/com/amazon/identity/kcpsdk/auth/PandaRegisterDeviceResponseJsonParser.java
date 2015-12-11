// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            PandaResponseJsonParser, RegisterDeviceResponse, RegisterDeviceError, AuthenticationChallenge, 
//            RegisterDeviceErrorType, PandaError

public class PandaRegisterDeviceResponseJsonParser extends PandaResponseJsonParser
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/PandaRegisterDeviceResponseJsonParser.getName();
    private String mAccessToken;
    private int mAccessTokenExpiresIn;
    private String mAccountPool;
    private String mAdpToken;
    private String mAlias;
    private JSONArray mCookies;
    private String mCountryOfResidence;
    private String mCustomerRegion;
    private String mDdevicePrivateKey;
    private String mDeviceName;
    private String mDeviceType;
    private String mDirectedId;
    private String mDviceSerialNumber;
    private String mGivenName;
    private String mKindleEmailAddress;
    private String mName;
    private String mPreferredMarketplace;
    private String mRefreshToken;
    private String mSourceOfcountryOfResidence;
    private String mStoreAuthenticationCookie;
    private String mUserId;

    public PandaRegisterDeviceResponseJsonParser()
    {
        mCookies = new JSONArray();
    }

    private RegisterDeviceResponse errorTypeToResponse(RegisterDeviceErrorType registerdeviceerrortype)
    {
        return new RegisterDeviceResponse(null, null, null, 0, null, null, new RegisterDeviceError(registerdeviceerrortype));
    }

    protected RegisterDeviceResponse handlePandaChallengeResponse(AuthenticationChallenge authenticationchallenge)
        throws JSONException
    {
        String s = authenticationchallenge.getReason();
        MAPLog.i(TAG, " PandaResponseJsonParser: response received a %s challenge.", new Object[] {
            s
        });
        if ("AuthenticationFailed".equals(s) || "InvalidAuthenticationData".equals(s))
        {
            return errorTypeToResponse(RegisterDeviceErrorType.RegisterDeviceErrorTypeCustomerNotFound);
        } else
        {
            return new RegisterDeviceResponse(authenticationchallenge, new RegisterDeviceError(RegisterDeviceErrorType.RegisterDeviceErrorTypeChallengeResponse));
        }
    }

    protected volatile Object handlePandaChallengeResponse(AuthenticationChallenge authenticationchallenge)
        throws JSONException
    {
        return handlePandaChallengeResponse(authenticationchallenge);
    }

    protected RegisterDeviceResponse handlePandaErrorCode(PandaError pandaerror)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError[];

            static 
            {
                $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError = new int[PandaError.values().length];
                try
                {
                    $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError[PandaError.PandaErrorMissingValue.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError[PandaError.PandaErrorCredentialError.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError[PandaError.PandaErrorInvalidValue.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError[PandaError.PandaErrorServerError.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError[PandaError.PandaErrorServiceUnavailable.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$identity$kcpsdk$auth$PandaError[PandaError.PandaErrorUnknown.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.identity.kcpsdk.auth.PandaError[pandaerror.ordinal()];
        JVM INSTR tableswitch 1 5: default 44
    //                   1 54
    //                   2 61
    //                   3 68
    //                   4 75
    //                   5 82;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        pandaerror = RegisterDeviceErrorType.RegisterDeviceErrorTypeUnrecognizedPanda;
_L8:
        return errorTypeToResponse(pandaerror);
_L2:
        pandaerror = RegisterDeviceErrorType.RegisterDeviceErrorTypeMissingValue;
        continue; /* Loop/switch isn't completed */
_L3:
        pandaerror = RegisterDeviceErrorType.RegisterDeviceErrorTypeCustomerNotFound;
        continue; /* Loop/switch isn't completed */
_L4:
        pandaerror = RegisterDeviceErrorType.RegisterDeviceErrorTypeInvalidValue;
        continue; /* Loop/switch isn't completed */
_L5:
        pandaerror = RegisterDeviceErrorType.RegisterDeviceErrorTypeServerError;
        continue; /* Loop/switch isn't completed */
_L6:
        pandaerror = RegisterDeviceErrorType.RegisterDeviceErrorTypeServerUnavailable;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected volatile Object handlePandaErrorCode(PandaError pandaerror)
    {
        return handlePandaErrorCode(pandaerror);
    }

    protected RegisterDeviceResponse parsePandaSuccessResponse(JSONObject jsonobject)
        throws JSONException
    {
        if (jsonobject.has("tokens"))
        {
            JSONObject jsonobject1 = jsonobject.getJSONObject("tokens");
            if (jsonobject1.has("bearer"))
            {
                JSONObject jsonobject2 = jsonobject1.getJSONObject("bearer");
                mRefreshToken = jsonobject2.getString("refresh_token");
                mAccessToken = jsonobject2.getString("access_token");
                mAccessTokenExpiresIn = StringConversionHelpers.toInt(jsonobject2.getString("expires_in"), 0);
            }
            if (jsonobject1.has("mac_dms"))
            {
                JSONObject jsonobject3 = jsonobject1.getJSONObject("mac_dms");
                mAdpToken = jsonobject3.getString("adp_token");
                mDdevicePrivateKey = jsonobject3.getString("device_private_key");
            }
            if (jsonobject1.has("store_authentication_cookie"))
            {
                mStoreAuthenticationCookie = jsonobject1.getJSONObject("store_authentication_cookie").getString("cookie");
            }
            if (jsonobject1.has("website_cookies"))
            {
                mCookies = jsonobject1.getJSONArray("website_cookies");
            }
        }
        if (jsonobject.has("extensions"))
        {
            RegisterDeviceResponse registerdeviceresponse = errorTypeToResponse(RegisterDeviceErrorType.RegisterDeviceErrorTypeUnrecognizedPanda);
            JSONObject jsonobject4 = jsonobject.getJSONObject("extensions");
            if (jsonobject4.has("customer_info"))
            {
                JSONObject jsonobject5 = jsonobject4.getJSONObject("customer_info");
                if (jsonobject5.has("account_pool"))
                {
                    mAccountPool = jsonobject5.getString("account_pool");
                    if (jsonobject5.has("country_of_residence"))
                    {
                        mCountryOfResidence = jsonobject5.getString("country_of_residence");
                    }
                    if (jsonobject5.has("source_of_country_of_residence"))
                    {
                        mSourceOfcountryOfResidence = jsonobject5.getString("source_of_country_of_residence");
                    }
                    if (jsonobject5.has("home_region"))
                    {
                        mCustomerRegion = jsonobject5.getString("home_region");
                    }
                    if (jsonobject5.has("name"))
                    {
                        mName = jsonobject5.getString("name");
                        if (jsonobject5.has("preferred_marketplace"))
                        {
                            mPreferredMarketplace = jsonobject5.getString("preferred_marketplace");
                        }
                        if (jsonobject5.has("user_id"))
                        {
                            mUserId = jsonobject5.getString("user_id");
                        }
                        if (jsonobject5.has("given_name"))
                        {
                            mGivenName = jsonobject5.getString("given_name");
                            if (jsonobject4.has("device_info"))
                            {
                                jsonobject4 = jsonobject4.getJSONObject("device_info");
                                if (jsonobject4.has("device_name"))
                                {
                                    mDeviceName = jsonobject4.getString("device_name");
                                    if (jsonobject4.has("device_serial_number"))
                                    {
                                        mDviceSerialNumber = jsonobject4.getString("device_serial_number");
                                    }
                                    if (jsonobject4.has("alias"))
                                    {
                                        mAlias = jsonobject4.getString("alias");
                                    }
                                    if (jsonobject4.has("device_type"))
                                    {
                                        mDeviceType = jsonobject4.getString("device_type");
                                    }
                                    if (jsonobject4.has("kindle_email_address"))
                                    {
                                        mKindleEmailAddress = jsonobject4.getString("kindle_email_address");
                                    }
                                    registerdeviceresponse = null;
                                } else
                                {
                                    MAPLog.e(TAG, " PandaResponseJsonParser: device name is missing");
                                }
                            } else
                            {
                                MAPLog.e(TAG, " PandaResponseJsonParser: device info is missing");
                            }
                        } else
                        {
                            MAPLog.e(TAG, " PandaResponseJsonParser: given name is missing");
                        }
                    } else
                    {
                        MAPLog.e(TAG, " PandaResponseJsonParser: name is missing");
                    }
                } else
                {
                    MAPLog.e(TAG, " PandaResponseJsonParser: account pool is missing");
                }
            } else
            {
                MAPLog.e(TAG, " PandaResponseJsonParser: customer info is missing");
            }
            if (registerdeviceresponse != null)
            {
                return registerdeviceresponse;
            }
        }
        mDirectedId = jsonobject.getString("customer_id");
        MAPLog.i(TAG, " PandaResponseJsonParser: success response received");
        jsonobject = new RegisterDeviceResponse(mAdpToken, mRefreshToken, mAccessToken, mAccessTokenExpiresIn, mDdevicePrivateKey, mDirectedId, null);
        jsonobject.setPandaCookies(mCookies);
        jsonobject.setStoreAuthenticationCookie(mStoreAuthenticationCookie);
        jsonobject.setCustomerRegion(mCustomerRegion);
        jsonobject.setAccountPool(mAccountPool);
        jsonobject.setCor(mCountryOfResidence);
        jsonobject.setSourceOfCor(mSourceOfcountryOfResidence);
        jsonobject.setPfm(mPreferredMarketplace);
        jsonobject.setUserName(mName);
        jsonobject.setDeviceName(mDeviceName);
        jsonobject.setEmail(mKindleEmailAddress);
        return jsonobject;
    }

    protected volatile Object parsePandaSuccessResponse(JSONObject jsonobject)
        throws JSONException
    {
        return parsePandaSuccessResponse(jsonobject);
    }

    protected RegisterDeviceResponse parseSpecificPandaErrorResponse(JSONObject jsonobject)
        throws JSONException
    {
        MAPLog.i(TAG, " PandaResponseJsonParser: response received a %s error.", new Object[] {
            jsonobject.toString()
        });
        jsonobject = jsonobject.getString("code");
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        if (!jsonobject.equals("ProtocolError")) goto _L4; else goto _L3
_L3:
        jsonobject = RegisterDeviceErrorType.RegisterDeviceErrorTypeProtocolError;
_L6:
        return errorTypeToResponse(jsonobject);
_L4:
        if (jsonobject.equals("MethodNotAllowed"))
        {
            jsonobject = RegisterDeviceErrorType.RegisterDeviceErrorTypeMethodNotAllowed;
            continue; /* Loop/switch isn't completed */
        }
        if (jsonobject.equals("NotImplemented"))
        {
            jsonobject = RegisterDeviceErrorType.RegisterDeviceErrorTypeNotImplemented;
            continue; /* Loop/switch isn't completed */
        }
        if (jsonobject.equals("InvalidDirectedId"))
        {
            jsonobject = RegisterDeviceErrorType.RegisterDeviceErrorTypeInvalidDirectedId;
            continue; /* Loop/switch isn't completed */
        }
        if (jsonobject.equals("InvalidDevice"))
        {
            jsonobject = RegisterDeviceErrorType.RegisterDeviceErrorTypeInvalidDevice;
            continue; /* Loop/switch isn't completed */
        }
        if (jsonobject.equals("DeviceAlreadyRegistered"))
        {
            jsonobject = RegisterDeviceErrorType.RegisterDeviceErrorTypeDeviceAlreadyRegistered;
            continue; /* Loop/switch isn't completed */
        }
        if (jsonobject.equals("DuplicateDeviceName"))
        {
            jsonobject = RegisterDeviceErrorType.RegisterDeviceErrorTypeDuplicateDeviceName;
            continue; /* Loop/switch isn't completed */
        }
        if (jsonobject.equals("InvalidToken"))
        {
            jsonobject = RegisterDeviceErrorType.RegisterDeviceErrorTypeInvalidTokenPanda;
            continue; /* Loop/switch isn't completed */
        }
        if (jsonobject.equals("DeviceNotRegistered"))
        {
            jsonobject = RegisterDeviceErrorType.RegisterDeviceErrorTypeDeviceNotRegisteredPanda;
            continue; /* Loop/switch isn't completed */
        }
        if (jsonobject.equals("Unauthorized"))
        {
            jsonobject = RegisterDeviceErrorType.RegisterDeviceErrorTypeUnauthorizedPanda;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        jsonobject = RegisterDeviceErrorType.RegisterDeviceErrorTypeUnrecognizedPanda;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected volatile Object parseSpecificPandaErrorResponse(JSONObject jsonobject)
        throws JSONException
    {
        return parseSpecificPandaErrorResponse(jsonobject);
    }

}
