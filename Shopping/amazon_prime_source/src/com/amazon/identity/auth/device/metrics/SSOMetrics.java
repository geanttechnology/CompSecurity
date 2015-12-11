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


    public static final String TAG = com/amazon/identity/auth/device/metrics/SSOMetrics.getName();
    private static PlatformMetricsCollector sCollector;
    private static Context sContext;

    private SSOMetrics()
    {
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

    public static void deregistrationSubAuthFailure(String s)
    {
        doInit();
        incrementMetricCounter("DeregistrationFailure", new String[] {
            s
        });
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

    public static void init(Context context)
    {
        sContext = context.getApplicationContext();
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

    public static void renameDeviceRequestFailure(int i)
    {
        doInit();
        i;
        JVM INSTR tableswitch 1 6: default 44
    //                   1 61
    //                   2 67
    //                   3 73
    //                   4 79
    //                   5 85
    //                   6 91;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        String s = "Unrecognized";
_L9:
        incrementMetricCounter("RenameDeviceRequestFailure", new String[] {
            s
        });
        return;
_L2:
        s = "NetworkFailure";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "AuthenticationFailed";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "InvalidInput";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "ParseError";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "NameAlreadyUsed";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "NoAmazonAccount";
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static void renameDeviceRequestSuccess()
    {
        doInit();
        incrementMetricCounter("RenameDeviceRequestSuccess", new String[0]);
    }

}
