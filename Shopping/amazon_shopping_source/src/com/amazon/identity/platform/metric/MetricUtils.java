// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.metric;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazon.identity.auth.device.metrics.SSOMetrics;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.amazon.identity.platform.metric:
//            PlatformMetricsTimer

public final class MetricUtils
{

    private MetricUtils()
    {
    }

    public static boolean checkConnectivity(Context context, PlatformMetricsTimer platformmetricstimer)
    {
        if (!UnitTestUtils.isRunningInUnitTest()) goto _L2; else goto _L1
_L1:
        MAPLog.w(SSOMetrics.TAG, "Running in unit test. Returning false");
_L4:
        return false;
_L2:
        if (isNetworkAvailable(context)) goto _L4; else goto _L3
_L3:
        platformmetricstimer.discard();
        return true;
        context;
        MAPLog.e(SSOMetrics.TAG, "We do not have permission to get the network state. Please make sure the permission android.permission.ACCESS_NETWORK_STATE is included in your manifest", context);
        return false;
    }

    public static String getAuthPortalUrlPathAndDomain(String s)
    {
        try
        {
            String s1 = getAuthPortalUrlType(s);
            s = new URL(s);
            s = (new StringBuilder()).append(s1).append(":").append(s.getHost()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "CannotGetURL";
        }
        return s;
    }

    public static String getAuthPortalUrlType(String s)
    {
        if (s == null)
        {
            return "CannotGetURL";
        }
        if (s.contains("/ap/signin"))
        {
            return "/ap/signin";
        }
        if (s.contains("/ap/forgotpassword"))
        {
            return "/ap/forgotpassword";
        }
        if (s.contains("/ap/register"))
        {
            return "/ap/register";
        }
        if (s.contains("/ap/challenge"))
        {
            return "/ap/challenge";
        } else
        {
            return "NonMAPURL";
        }
    }

    public static String getAvailabilityMetricName(URL url)
    {
        return (new StringBuilder()).append(getUrlPathAndDomain(url)).append(":Availability").toString();
    }

    public static String getIOExceptionMetricName(URL url)
    {
        return (new StringBuilder()).append(url.getPath()).append(":").append(url.getHost()).append(":IOException").toString();
    }

    public static String getIOExceptionWithSubClassMetricName(URL url, IOException ioexception, Context context)
    {
        return (new StringBuilder()).append(getIOExceptionMetricName(url)).append(":").append(ioexception.getClass().getSimpleName()).append(":").append(getNetworkStatus(context)).toString();
    }

    public static String getMAPUrlType(String s)
    {
        if (s == null)
        {
            return "CannotGetURL";
        }
        if (s.contains("getNewDeviceCredentials"))
        {
            return "getNewDeviceCredentials";
        }
        if (s.contains("registerAssociatedDevice"))
        {
            return "registerAssociatedDevice";
        }
        if (s.contains("registerDeviceWithToken"))
        {
            return "registerDeviceWithToken";
        }
        if (s.contains("registerDeviceToSecondaryCustomer"))
        {
            return "registerDeviceToSecondaryCustomer";
        }
        if (s.contains("registerDevice"))
        {
            return "registerDevice";
        }
        if (s.contains("renameFiona"))
        {
            return "renameFiona";
        }
        if (s.contains("disownFiona"))
        {
            return "disownFiona";
        }
        if (s.contains("/auth/register"))
        {
            return "/auth/register";
        }
        if (s.contains("/auth/signin"))
        {
            return "/auth/signin";
        }
        if (s.contains("/ap/exchangetoken"))
        {
            return "/ap/exchangetoken";
        } else
        {
            return "NonMAPURL";
        }
    }

    public static String getNetworkStatus(Context context)
    {
        if (isNetworkAvailable(context))
        {
            return "Connected";
        } else
        {
            return "NotConnected";
        }
        context;
        MAPLog.e(SSOMetrics.TAG, "We do not have permission to get the network state. Please make sure the permission android.permission.ACCESS_NETWORK_STATE is included in your manifest", context);
        return "NetworkStatusUnknown";
    }

    public static String getRetriesFailedMetricName(URL url)
    {
        return (new StringBuilder()).append(getUrlPathAndDomain(url)).append(":AllRetriesFailed").toString();
    }

    public static String getSuccessAfterRetryMetricName(URL url)
    {
        return (new StringBuilder()).append(getUrlPathAndDomain(url)).append(":SuccessAfterRetry").toString();
    }

    public static String getUrlPathAndDomain(URL url)
    {
        return (new StringBuilder()).append(url.getPath()).append(":").append(url.getHost()).toString();
    }

    public static String getUrlPathAndDomain(URL url, int i)
    {
        return (new StringBuilder()).append(getUrlPathAndDomain(url)).append(":").append(i).toString();
    }

    public static String getUrlPathAndDomain(URL url, int i, String s)
    {
        return (new StringBuilder()).append(getUrlPathAndDomain(url, i)).append(":").append(s).toString();
    }

    public static boolean isDeviceConnected(Context context)
    {
        boolean flag;
        try
        {
            flag = isNetworkAvailable(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return flag;
    }

    public static boolean isNetworkAvailable(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }
}
