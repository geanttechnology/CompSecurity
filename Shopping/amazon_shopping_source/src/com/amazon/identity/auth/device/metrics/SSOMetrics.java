// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.metrics;

import android.content.Context;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.platform.metric.MetricUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsCollector;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.util.HashMap;
import java.util.Map;

public final class SSOMetrics
{
    public static final class AccountManagerFailure extends Enum
    {

        private static final AccountManagerFailure $VALUES[];
        public static final AccountManagerFailure BAD_ARGUMENTS;
        public static final AccountManagerFailure BAD_REQUEST;
        public static final AccountManagerFailure CANCELED;
        public static final AccountManagerFailure INVALID_RESPONSE;
        public static final AccountManagerFailure NETWORK_ERROR;
        public static final AccountManagerFailure REMOTE_EXCEPTION;
        public static final AccountManagerFailure UNRECOGNIZED;
        public static final AccountManagerFailure UNSUPPORTED_OPERATION;
        private final int mErrorCode;
        private final String mName;

        public static AccountManagerFailure getFromAccountManagerErrorCode(int i)
        {
            AccountManagerFailure aaccountmanagerfailure[] = values();
            int k = aaccountmanagerfailure.length;
            for (int j = 0; j < k; j++)
            {
                AccountManagerFailure accountmanagerfailure = aaccountmanagerfailure[j];
                if (accountmanagerfailure.getAccountManagerErrorCode() == i)
                {
                    return accountmanagerfailure;
                }
            }

            return UNRECOGNIZED;
        }

        public static AccountManagerFailure valueOf(String s)
        {
            return (AccountManagerFailure)Enum.valueOf(com/amazon/identity/auth/device/metrics/SSOMetrics$AccountManagerFailure, s);
        }

        public static AccountManagerFailure[] values()
        {
            return (AccountManagerFailure[])$VALUES.clone();
        }

        public int getAccountManagerErrorCode()
        {
            return mErrorCode;
        }

        public String getName()
        {
            return mName;
        }

        static 
        {
            BAD_ARGUMENTS = new AccountManagerFailure("BAD_ARGUMENTS", 0, 7, "BadArguments");
            BAD_REQUEST = new AccountManagerFailure("BAD_REQUEST", 1, 8, "BadRequest");
            CANCELED = new AccountManagerFailure("CANCELED", 2, 4, "Cancelled");
            INVALID_RESPONSE = new AccountManagerFailure("INVALID_RESPONSE", 3, 5, "InvalidResponse");
            NETWORK_ERROR = new AccountManagerFailure("NETWORK_ERROR", 4, 3, "NetworkError");
            REMOTE_EXCEPTION = new AccountManagerFailure("REMOTE_EXCEPTION", 5, 1, "RemoteException");
            UNSUPPORTED_OPERATION = new AccountManagerFailure("UNSUPPORTED_OPERATION", 6, 6, "UnsupportedOperation");
            UNRECOGNIZED = new AccountManagerFailure("UNRECOGNIZED", 7, 9, "UnrecognizedExternalError");
            $VALUES = (new AccountManagerFailure[] {
                BAD_ARGUMENTS, BAD_REQUEST, CANCELED, INVALID_RESPONSE, NETWORK_ERROR, REMOTE_EXCEPTION, UNSUPPORTED_OPERATION, UNRECOGNIZED
            });
        }

        private AccountManagerFailure(String s, int i, int j, String s1)
        {
            super(s, i);
            mErrorCode = j;
            mName = s1;
        }
    }

    public static final class AccountProperties extends Enum
    {

        private static final AccountProperties $VALUES[];
        public static final AccountProperties DeviceEmail;
        public static final AccountProperties DeviceName;
        public static final AccountProperties General;
        private final String mName;

        public static AccountProperties valueOf(String s)
        {
            return (AccountProperties)Enum.valueOf(com/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties, s);
        }

        public static AccountProperties[] values()
        {
            return (AccountProperties[])$VALUES.clone();
        }

        public String getName()
        {
            return mName;
        }

        static 
        {
            DeviceName = new AccountProperties("DeviceName", 0, "DeviceName");
            DeviceEmail = new AccountProperties("DeviceEmail", 1, "DeviceEmail");
            General = new AccountProperties("General", 2, "General");
            $VALUES = (new AccountProperties[] {
                DeviceName, DeviceEmail, General
            });
        }

        private AccountProperties(String s, int i, String s1)
        {
            super(s, i);
            mName = s1;
        }
    }

    public static final class CredentialActionFailureReason extends Enum
    {

        private static final CredentialActionFailureReason $VALUES[];
        public static final CredentialActionFailureReason DidnotReturnAuthToken;
        public static final CredentialActionFailureReason RequestTimeOut;
        public static final CredentialActionFailureReason UnrecognizedFailure;
        private final String mName;

        public static CredentialActionFailureReason valueOf(String s)
        {
            return (CredentialActionFailureReason)Enum.valueOf(com/amazon/identity/auth/device/metrics/SSOMetrics$CredentialActionFailureReason, s);
        }

        public static CredentialActionFailureReason[] values()
        {
            return (CredentialActionFailureReason[])$VALUES.clone();
        }

        public String getName()
        {
            return mName;
        }

        static 
        {
            RequestTimeOut = new CredentialActionFailureReason("RequestTimeOut", 0, "RequestTimeOut");
            DidnotReturnAuthToken = new CredentialActionFailureReason("DidnotReturnAuthToken", 1, "DidnotReturnAuthToken");
            UnrecognizedFailure = new CredentialActionFailureReason("UnrecognizedFailure", 2, "UnrecognizedFailure");
            $VALUES = (new CredentialActionFailureReason[] {
                RequestTimeOut, DidnotReturnAuthToken, UnrecognizedFailure
            });
        }

        private CredentialActionFailureReason(String s, int i, String s1)
        {
            super(s, i);
            mName = s1;
        }
    }

    public static final class SetAccountPropertiesFailureReason extends Enum
    {

        private static final SetAccountPropertiesFailureReason $VALUES[];
        public static final SetAccountPropertiesFailureReason InvalidRequest;
        public static final SetAccountPropertiesFailureReason NoAmazonAccount;
        public static final SetAccountPropertiesFailureReason UnrecognizedFailure;
        private final String mName;

        public static SetAccountPropertiesFailureReason valueOf(String s)
        {
            return (SetAccountPropertiesFailureReason)Enum.valueOf(com/amazon/identity/auth/device/metrics/SSOMetrics$SetAccountPropertiesFailureReason, s);
        }

        public static SetAccountPropertiesFailureReason[] values()
        {
            return (SetAccountPropertiesFailureReason[])$VALUES.clone();
        }

        public String getName()
        {
            return mName;
        }

        static 
        {
            NoAmazonAccount = new SetAccountPropertiesFailureReason("NoAmazonAccount", 0, "NoAmazonAccount");
            InvalidRequest = new SetAccountPropertiesFailureReason("InvalidRequest", 1, "InvalidRequest");
            UnrecognizedFailure = new SetAccountPropertiesFailureReason("UnrecognizedFailure", 2, "UnrecognizedFailure");
            $VALUES = (new SetAccountPropertiesFailureReason[] {
                NoAmazonAccount, InvalidRequest, UnrecognizedFailure
            });
        }

        private SetAccountPropertiesFailureReason(String s, int i, String s1)
        {
            super(s, i);
            mName = s1;
        }
    }


    public static final String NUMBER_AMAZON_ACCOUNTS = "com.amazon.dcp.sso.numAmazonAccounts";
    public static final String TAG = com/amazon/identity/auth/device/metrics/SSOMetrics.getName();
    private static PlatformMetricsCollector sCollector;
    private static Context sContext;

    private SSOMetrics()
    {
    }

    public static void couldnotFindSubAuth()
    {
        doInit();
        incrementMetricCounter("NoSubAuthFound", new String[0]);
    }

    public static void deregistrationRequestFailure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror)
    {
        doInit();
        if (registrationerror != null)
        {
            registrationerror = registrationerror.getName();
        } else
        {
            registrationerror = com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.getName();
        }
        incrementMetricCounter("DeregistrationFailure", new String[] {
            registrationerror
        });
    }

    public static void deregistrationRequestFailure(String s)
    {
        doInit();
        incrementMetricCounter("DeregistrationFailure", new String[] {
            s
        });
    }

    public static void deregistrationSubAuthFailure(String s)
    {
        doInit();
        incrementMetricCounter("DeregistrationFailure", new String[] {
            s
        });
    }

    public static void deregistrationSuccess()
    {
        doInit();
        incrementMetricCounter("DeregistrationSuccess", new String[0]);
    }

    private static void doInit()
    {
        com/amazon/identity/auth/device/metrics/SSOMetrics;
        JVM INSTR monitorenter ;
        if (sContext == null) goto _L2; else goto _L1
_L1:
        PlatformMetricsCollector platformmetricscollector = sCollector;
        if (platformmetricscollector == null) goto _L3; else goto _L2
_L2:
        com/amazon/identity/auth/device/metrics/SSOMetrics;
        JVM INSTR monitorexit ;
        return;
_L3:
        sCollector = MetricsHelper.getMetricsCollectorInstance(sContext);
        if (true) goto _L2; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    private static Map formatExtraDataForMetrics(int i, String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("size", String.valueOf(i));
        hashmap.put("app", s);
        hashmap.put(s, String.valueOf(i));
        return hashmap;
    }

    public static void getAuthTokenFailure(String s, AccountManagerFailure accountmanagerfailure)
    {
        doInit();
        incrementMetricCounter("GetAuthTokenFailure", new String[] {
            s, accountmanagerfailure.getName()
        });
    }

    public static void getAuthTokenFailure(String s, CredentialActionFailureReason credentialactionfailurereason)
    {
        doInit();
        incrementMetricCounter("GetAuthTokenFailure", new String[] {
            s, credentialactionfailurereason.getName()
        });
    }

    public static void getAuthTokenSuccess(String s)
    {
        doInit();
        incrementMetricCounter("GetAuthTokenSuccess", new String[] {
            s
        });
    }

    public static PlatformMetricsTimer getAuthTokenSuccessTimer(String s)
    {
        doInit();
        return PlatformMetricsTimer.getInstance(sCollector, "GetAuthTokenSuccessTime", s);
    }

    public static PlatformMetricsTimer getAuthTokenTimer(String s)
    {
        doInit();
        return PlatformMetricsTimer.getInstance(sCollector, "GetAuthTokenTime", s);
    }

    public static PlatformMetricsTimer getDeregistrationSubAuthTimer(String s)
    {
        doInit();
        return PlatformMetricsTimer.getInstance(sCollector, "DeregistrationSubAuthTime", s);
    }

    public static PlatformMetricsTimer getDeregistrationTimer()
    {
        doInit();
        return PlatformMetricsTimer.getInstance(sCollector, "DeregistrationTime", "TotalDeregistrationTime");
    }

    public static PlatformMetricsTimer getKeyPairSelfGenerationTimer(String s)
    {
        doInit();
        return PlatformMetricsTimer.getInstance(sCollector, "KeyPairSelfGeneration", s);
    }

    private static transient void incrementMetricCounter(String s, String as[])
    {
        if (sCollector == null)
        {
            return;
        } else
        {
            sCollector.incrementMetricCounter("GenericMetrics_SSO", s, as);
            return;
        }
    }

    private static void incrementStateMetricCounter(String s, Map map)
    {
        if (sCollector == null)
        {
            return;
        } else
        {
            sCollector.incrementStateMetricCounter("GenericMetrics_SSO", s, map);
            return;
        }
    }

    public static void init(Context context)
    {
        sContext = context.getApplicationContext();
    }

    public static void recordCorPfmRequestFailure(String s)
    {
        doInit();
        incrementMetricCounter("GetCorPfmRequest", new String[] {
            s
        });
    }

    public static void recordExchangeTokenRequestSize(int i, String s)
    {
        doInit();
        incrementStateMetricCounter("SSOExchangeRequest", formatExtraDataForMetrics(i, s));
    }

    public static void recordExchangeTokenResponseSize(int i, String s)
    {
        doInit();
        incrementStateMetricCounter("SSOExchangeResponse", formatExtraDataForMetrics(i, s));
    }

    public static void recordUpdateCredentialsRequestSize(int i, String s)
    {
        doInit();
        incrementStateMetricCounter("SSOUpdateCredentialsRequest", formatExtraDataForMetrics(i, s));
    }

    public static void recordUpdateCredentialsResponseSize(int i, String s)
    {
        doInit();
        incrementStateMetricCounter("SSOUpdateCredentialsResponse", formatExtraDataForMetrics(i, s));
    }

    public static void recordWebViewLoadFailure(String s, int i)
    {
        doInit();
        incrementMetricCounter("WebViewLoadFailure", new String[] {
            (new StringBuilder("Path:")).append(MetricUtils.getAuthPortalUrlType(s)).toString(), Integer.toString(i)
        });
    }

    public static void recordWebViewLoadFailureSSL(String s, int i)
    {
        doInit();
        incrementMetricCounter("WebViewLoadFailure", new String[] {
            (new StringBuilder("SSLError:")).append(MetricUtils.getAuthPortalUrlType(s)).toString(), (new StringBuilder("SSLError:")).append(i).toString()
        });
    }

    public static void registrationBadSecret(RegistrationType registrationtype)
    {
        doInit();
        incrementMetricCounter("RegistrationFailure", new String[] {
            (new StringBuilder()).append(registrationtype.getName()).append(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_SECRET.getName()).toString()
        });
    }

    private static String renameDeviceErrorCodeToErrorMessage(int i)
    {
        switch (i)
        {
        default:
            return "Unrecognized";

        case 1: // '\001'
            return "NetworkFailure";

        case 2: // '\002'
            return "AuthenticationFailed";

        case 3: // '\003'
            return "InvalidInput";

        case 4: // '\004'
            return "ParseError";

        case 5: // '\005'
            return "NameAlreadyUsed";

        case 6: // '\006'
            return "NoAmazonAccount";
        }
    }

    public static void renameDeviceFailure(int i)
    {
        doInit();
        incrementMetricCounter("SetAccountPropertiesFailure", new String[] {
            AccountProperties.DeviceName.getName(), renameDeviceErrorCodeToErrorMessage(i)
        });
    }

    public static void renameDeviceRequestFailure(int i)
    {
        doInit();
        incrementMetricCounter("RenameDeviceRequestFailure", new String[] {
            renameDeviceErrorCodeToErrorMessage(i)
        });
    }

    public static void renameDeviceRequestSuccess()
    {
        doInit();
        incrementMetricCounter("RenameDeviceRequestSuccess", new String[0]);
    }

    public static void setAccountPropertiesFailure(AccountProperties accountproperties, SetAccountPropertiesFailureReason setaccountpropertiesfailurereason)
    {
        doInit();
        incrementMetricCounter("SetAccountPropertiesFailure", new String[] {
            accountproperties.getName(), setaccountpropertiesfailurereason.getName()
        });
    }

    public static void setAccountPropertiesSuccess(AccountProperties accountproperties)
    {
        doInit();
        incrementMetricCounter("SetAccountPropertiesSuccess", new String[] {
            accountproperties.getName()
        });
    }

    public static PlatformMetricsTimer setAccountPropertiesTimer(AccountProperties accountproperties)
    {
        doInit();
        return PlatformMetricsTimer.getInstance(sCollector, "SetAccountPropertiesTime", accountproperties.getName());
    }

    public static void signatureCheckFailure()
    {
        doInit();
        incrementMetricCounter("SignatureCheckFailure", new String[0]);
    }

    public static void stateChanged(String s, String s1)
    {
        doInit();
        HashMap hashmap = new HashMap();
        hashmap.put("key", s);
        hashmap.put("value", s1);
        incrementStateMetricCounter("StateChange", hashmap);
    }

    public static void updateCredentialsFailure(String s, AccountManagerFailure accountmanagerfailure)
    {
        doInit();
        incrementMetricCounter("UpdateCredentialsFailure", new String[] {
            s, accountmanagerfailure.getName()
        });
    }

    public static void updateCredentialsFailure(String s, CredentialActionFailureReason credentialactionfailurereason)
    {
        doInit();
        incrementMetricCounter("UpdateCredentialsFailure", new String[] {
            s, credentialactionfailurereason.getName()
        });
    }

    public static void updateCredentialsSuccess(String s)
    {
        doInit();
        incrementMetricCounter("UpdateCredentialsSuccess", new String[] {
            s
        });
    }

    public static PlatformMetricsTimer updateCredentialsSuccessTimer(String s)
    {
        doInit();
        return PlatformMetricsTimer.getInstance(sCollector, "UpdateCredentialsSuccessTime", s);
    }

    public static PlatformMetricsTimer updateCredentialsTimer(String s)
    {
        doInit();
        return PlatformMetricsTimer.getInstance(sCollector, "UpdateCredentialsTime", s);
    }

}
