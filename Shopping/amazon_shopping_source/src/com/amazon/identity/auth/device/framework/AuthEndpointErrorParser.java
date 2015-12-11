// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.auth.device.utils.JSONHelpers;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthEndpointErrorParser
{
    public static class AuthEndpointError
    {

        private final AuthErrorType mAuthErrorType;
        private final String mDetail;
        private final String mMessage;
        private final String mRequestId;

        public AuthErrorType getAuthTypeError()
        {
            return mAuthErrorType;
        }

        public String getDetail()
        {
            return mDetail;
        }

        public String getMessage()
        {
            return mMessage;
        }

        public com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError getRegistrationError()
        {
            return mAuthErrorType.getRegistrationError();
        }

        public String getRequestId()
        {
            return mRequestId;
        }

        public boolean shouldRetry()
        {
            return mAuthErrorType.getRetry();
        }

        public AuthEndpointError(AuthErrorType autherrortype, String s, String s1, String s2)
        {
            mAuthErrorType = autherrortype;
            mMessage = s;
            mDetail = s1;
            mRequestId = s2;
        }
    }

    public static final class AuthErrorType extends Enum
    {

        private static final AuthErrorType $VALUES[];
        public static final AuthErrorType AuthenticationChallenged;
        public static final AuthErrorType CredentialError;
        public static final AuthErrorType DeviceAlreadyRegistered;
        public static final AuthErrorType DuplicateDeviceName;
        public static final AuthErrorType Forbidden;
        public static final AuthErrorType GenericError;
        public static final AuthErrorType InvalidDirectedId;
        public static final AuthErrorType InvalidToken;
        public static final AuthErrorType InvalidValue;
        public static final AuthErrorType MethodNotAllowed;
        public static final AuthErrorType MissingValue;
        public static final AuthErrorType NetworkFailure;
        public static final AuthErrorType NotImplemented;
        public static final AuthErrorType ParseError;
        public static final AuthErrorType ProtocolError;
        public static final AuthErrorType ServerError;
        public static final AuthErrorType ServiceUnavailable;
        private final String mCode;
        private final com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError mError;
        private final boolean mRetry;

        public static AuthErrorType getAuthErrorTypeFromCode(String s)
        {
            AuthErrorType aautherrortype[] = values();
            int j = aautherrortype.length;
            for (int i = 0; i < j; i++)
            {
                AuthErrorType autherrortype = aautherrortype[i];
                if (autherrortype.getCode().equals(s))
                {
                    return autherrortype;
                }
            }

            return GenericError;
        }

        public static AuthErrorType valueOf(String s)
        {
            return (AuthErrorType)Enum.valueOf(com/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType, s);
        }

        public static AuthErrorType[] values()
        {
            return (AuthErrorType[])$VALUES.clone();
        }

        public String getCode()
        {
            return mCode;
        }

        public com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError getRegistrationError()
        {
            return mError;
        }

        public boolean getRetry()
        {
            return mRetry;
        }

        static 
        {
            MissingValue = new AuthErrorType("MissingValue", 0, "MissingValue", false, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST);
            InvalidValue = new AuthErrorType("InvalidValue", 1, "InvalidValue", false, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST);
            InvalidToken = new AuthErrorType("InvalidToken", 2, "InvalidToken", false, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST);
            ProtocolError = new AuthErrorType("ProtocolError", 3, "ProtocolError", false, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST);
            CredentialError = new AuthErrorType("CredentialError", 4, "CredentialError", false, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.CUSTOMER_NOT_FOUND);
            Forbidden = new AuthErrorType("Forbidden", 5, "Forbidden", false, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST);
            MethodNotAllowed = new AuthErrorType("MethodNotAllowed", 6, "MethodNotAllowed", false, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST);
            ServerError = new AuthErrorType("ServerError", 7, "ServerError", true, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED);
            ServiceUnavailable = new AuthErrorType("ServiceUnavailable", 8, "ServiceUnavailable", true, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED);
            NotImplemented = new AuthErrorType("NotImplemented", 9, "NotImplemented", false, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST);
            InvalidDirectedId = new AuthErrorType("InvalidDirectedId", 10, "InvalidDirectedId", false, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST);
            DeviceAlreadyRegistered = new AuthErrorType("DeviceAlreadyRegistered", 11, "DeviceAlreadyRegistered", false, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.DEVICE_ALREADY_REGISTERED);
            DuplicateDeviceName = new AuthErrorType("DuplicateDeviceName", 12, "DuplicateDeviceName", false, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.DUPLICATE_DEVICE_NAME);
            GenericError = new AuthErrorType("GenericError");
            AuthenticationChallenged = new AuthErrorType("AuthenticationChallenged", 14, "AuthenticationChallenged", false, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.AUTHENTICATION_CHALLENGED);
            ParseError = new AuthErrorType("ParseError", 15, "ParseError", true, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR);
            NetworkFailure = new AuthErrorType("NetworkFailure", 16, "NetworkFailure", true, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE);
            $VALUES = (new AuthErrorType[] {
                MissingValue, InvalidValue, InvalidToken, ProtocolError, CredentialError, Forbidden, MethodNotAllowed, ServerError, ServiceUnavailable, NotImplemented, 
                InvalidDirectedId, DeviceAlreadyRegistered, DuplicateDeviceName, GenericError, AuthenticationChallenged, ParseError, NetworkFailure
            });
        }

        private AuthErrorType(String s)
        {
            this(s, 13, "GenericError", false, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED);
        }

        private AuthErrorType(String s, int i, String s1, boolean flag, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror)
        {
            super(s, i);
            mCode = s1;
            mRetry = flag;
            mError = registrationerror;
        }
    }


    static final String CODE_STRING_KEY = "code";
    static final String DETAIL_STRING_KEY = "detail";
    static final String ERROR_OBEJCT_KEY = "error";
    public static final AuthEndpointError GENERIC_ERROR;
    static final String MESSAGE_STRING_KEY = "message";
    static final String REQUEST_ID_STRING_KEY = "request_id";
    static final String RESPONSE_OBJECT_KEY = "response";
    private static final String TAG = com/amazon/identity/auth/device/framework/AuthEndpointErrorParser.getName();

    public AuthEndpointErrorParser()
    {
    }

    public boolean hasAuthenticationChallenge(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            return false;
        }
        try
        {
            jsonobject = jsonobject.getJSONObject("response");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return false;
        }
        return jsonobject.has("challenge");
    }

    public boolean isFailure(int i)
    {
        return i < 200 || i >= 300;
    }

    public AuthEndpointError parse(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            return null;
        }
        try
        {
            JSONObject jsonobject1 = jsonobject.getJSONObject("response");
            jsonobject = JSONHelpers.getStringOrDefault(jsonobject1, "request_id", null);
            jsonobject1 = jsonobject1.getJSONObject("error");
            jsonobject = new AuthEndpointError(AuthErrorType.getAuthErrorTypeFromCode(jsonobject1.getString("code")), JSONHelpers.getStringOrDefault(jsonobject1, "message", null), JSONHelpers.getStringOrDefault(jsonobject1, "detail", null), jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject = (new StringBuilder("Given JSON is not in Auth Error format. Error: ")).append(jsonobject.getMessage()).toString();
            String s = TAG;
            return new AuthEndpointError(AuthErrorType.ParseError, jsonobject, null, null);
        }
        return jsonobject;
    }

    static 
    {
        GENERIC_ERROR = new AuthEndpointError(AuthErrorType.GenericError, "Generic Error", "Generic Error", "No Request Id");
    }
}
