// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.content.Context;
import android.util.Log;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPLog, TPControlChannelStateMachine, TPEventLog, TPOptionManager

class TwinPrimeSDKPvt
{

    private static String LOG_TAG = "TwinPrimeSDKPvt";
    private static TwinPrimeSDKPvt tpSDK = null;
    private final String ACC_PREFIX = "acc-";
    private final String ACC_SUFIX = ".cust.twinprime.com";
    private final int TP_ACCEL_LISTEN_PORT = 1514;
    private String accBackupName;
    private String accName;
    private Context appContext;
    protected String sdkKey;
    boolean shouldAccelerateApp;
    protected TPControlChannelStateMachine tpccStateMachine;

    TwinPrimeSDKPvt()
    {
        sdkKey = null;
        accName = null;
        accBackupName = null;
        shouldAccelerateApp = true;
    }

    static boolean bypassSDK(String s)
    {
        return s.equals("not-initialized") || s.equals("black-listed") || s.equals("not-white-listed") || s.equals("https-disabled") || s.equals("http-disabled");
    }

    private void createStateMachine()
    {
        if (tpccStateMachine == null)
        {
            if (TPLog.LOG10.isLoggable(LOG_TAG))
            {
                Log.i(LOG_TAG, "Initializing TPControlChannelStateMachine");
            }
            tpccStateMachine = TPControlChannelStateMachine.getInstance();
            tpccStateMachine.initWithKey(appContext, sdkKey, accName, accBackupName, 1514, getCustomerId());
            tpccStateMachine.start();
        }
    }

    static void disableSDK()
    {
        tpSDK = null;
    }

    private int getCustomerId()
    {
        StringTokenizer stringtokenizer = new StringTokenizer(sdkKey, "-");
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (stringtokenizer.countTokens() > 1)
        {
            String s;
            for (s = null; stringtokenizer.hasMoreTokens(); s = stringtokenizer.nextToken()) { }
            try
            {
                i = Integer.parseInt(s, 16);
            }
            catch (Exception exception)
            {
                i = ((flag) ? 1 : 0);
                if (TPLog.LOG10.isLoggable(LOG_TAG))
                {
                    exception.printStackTrace();
                    return 0;
                }
            }
        }
        return i;
    }

    public static TwinPrimeSDKPvt getInstance()
    {
        com/twinprime/TwinPrimeSDK/TwinPrimeSDKPvt;
        JVM INSTR monitorenter ;
        TwinPrimeSDKPvt twinprimesdkpvt;
        if (tpSDK == null)
        {
            tpSDK = new TwinPrimeSDKPvt();
        }
        twinprimesdkpvt = tpSDK;
        com/twinprime/TwinPrimeSDK/TwinPrimeSDKPvt;
        JVM INSTR monitorexit ;
        return twinprimesdkpvt;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean isSDKReady()
    {
        while (tpSDK == null || tpSDK.tpccStateMachine == null) 
        {
            return false;
        }
        if (tpSDK.tpccStateMachine.getStateMachineState() == 3)
        {
            return true;
        } else
        {
            tpSDK.tpccStateMachine.poke();
            return false;
        }
    }

    static boolean shouldAccelerate(URL url, TPEventLog tpeventlog, Boolean boolean1)
    {
        if (isSDKReady()) goto _L2; else goto _L1
_L1:
        if (TPLog.LOG13.isLoggable(LOG_TAG))
        {
            Log.d(LOG_TAG, "TwinPrimeSDK not initialized yet, bypassing.");
        }
        if (tpeventlog != null)
        {
            tpeventlog.bypass_reason = "not-initialized";
        }
_L4:
        return false;
_L2:
        String s;
        Object obj;
label0:
        {
            if (url.toString().equalsIgnoreCase("http://east.t.twinprime.com/touch.html"))
            {
                if (TPLog.LOG13.isLoggable(LOG_TAG))
                {
                    Log.d(LOG_TAG, "Warm connection, accelerating.");
                }
                if (tpeventlog != null)
                {
                    tpeventlog.is_accelerated = 1;
                    tpeventlog.bypass_reason = "warm-connection";
                }
                return true;
            }
            obj = TPOptionManager.getInstance().urlWhiteList;
            Object obj1 = TPOptionManager.getInstance().urlBlackList;
            if (obj1 == null && obj == null)
            {
                break; /* Loop/switch isn't completed */
            }
            s = url.getHost();
            if (obj1 == null || ((List) (obj1)).isEmpty())
            {
                break label0;
            }
            obj1 = ((List) (obj1)).iterator();
            String s2;
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break label0;
                }
                s2 = (String)((Iterator) (obj1)).next();
            } while (!s.endsWith(s2) || s.length() != s2.length() && s.charAt(s.length() - s2.length() - 1) != '.');
            if (TPLog.LOG13.isLoggable(LOG_TAG))
            {
                Log.d(LOG_TAG, (new StringBuilder()).append("Host [").append(s).append("] is black listed [").append(s2).append("], bypassing.").toString());
            }
            if (tpeventlog != null)
            {
                tpeventlog.bypass_reason = "black-listed";
                return false;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (obj == null || ((List) (obj)).isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag = false;
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s1 = (String)((Iterator) (obj)).next();
            if (s.endsWith(s1) && (s.length() == s1.length() || s.charAt(s.length() - s1.length() - 1) == '.'))
            {
                if (TPLog.LOG13.isLoggable(LOG_TAG))
                {
                    Log.d(LOG_TAG, (new StringBuilder()).append("Host [").append(s).append("] is white listed, acceleration is allowed.").toString());
                }
                flag = true;
            }
        } while (true);
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (TPLog.LOG13.isLoggable(LOG_TAG))
        {
            Log.d(LOG_TAG, (new StringBuilder()).append("Host [").append(s).append("] is not white listed, bypassing.").toString());
        }
        if (tpeventlog != null)
        {
            tpeventlog.bypass_reason = "not-white-listed";
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (url.getProtocol().equalsIgnoreCase("https"))
        {
            if (TPOptionManager.getHTTPSAcceleration() != TPOptionManager.TPOptionHTTPSAcceleration.TPOptionHTTPSAcceleration_disable)
            {
                break; /* Loop/switch isn't completed */
            }
            if (TPLog.LOG2.isLoggable(LOG_TAG))
            {
                TPLog.LOG2.i(LOG_TAG, "Acceleration disabled for HTTPS");
            }
            if (TPLog.LOG13.isLoggable(LOG_TAG))
            {
                Log.d(LOG_TAG, "Acceleration disabled for HTTPS");
            }
            if (tpeventlog != null)
            {
                tpeventlog.bypass_reason = "https-disabled";
                return false;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (TPOptionManager.getHTTPAcceleration() != TPOptionManager.TPOptionHTTPAcceleration.TPOptionHTTPAcceleration_disable)
        {
            break; /* Loop/switch isn't completed */
        }
        if (TPLog.LOG2.isLoggable(LOG_TAG))
        {
            TPLog.LOG2.i(LOG_TAG, "Acceleration disabled for HTTP");
        }
        if (TPLog.LOG13.isLoggable(LOG_TAG))
        {
            Log.d(LOG_TAG, "Acceleration disabled for HTTP");
        }
        if (tpeventlog != null)
        {
            tpeventlog.bypass_reason = "http-disabled";
            return false;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (getInstance().shouldAccelerateApp)
        {
            break; /* Loop/switch isn't completed */
        }
        if (TPLog.LOG13.isLoggable(LOG_TAG))
        {
            Log.d(LOG_TAG, "Explicit app setting, bypassing");
        }
        if (tpeventlog != null)
        {
            tpeventlog.bypass_reason = "app-global-setting";
            return false;
        }
        if (true) goto _L4; else goto _L6
_L6:
        if (boolean1 == null || boolean1.booleanValue())
        {
            break; /* Loop/switch isn't completed */
        }
        if (TPLog.LOG13.isLoggable(LOG_TAG))
        {
            Log.d(LOG_TAG, "Not accelerated due to app url setting");
        }
        if (tpeventlog != null)
        {
            tpeventlog.bypass_reason = "app-url-setting";
            return false;
        }
        if (true) goto _L4; else goto _L7
_L7:
        if (!TPControlChannelStateMachine.getInstance().shouldAcceleratePolicy)
        {
            if (TPLog.LOG13.isLoggable(LOG_TAG))
            {
                Log.d(LOG_TAG, "Explicit policy setting, bypassing");
            }
            if (tpeventlog != null)
            {
                tpeventlog.bypass_reason = "policy-setting";
                return false;
            }
        } else
        {
            if (tpeventlog != null)
            {
                tpeventlog.is_accelerated = 1;
            }
            return true;
        }
        if (true) goto _L4; else goto _L8
_L8:
    }

    int getAppGuid()
    {
        boolean flag = false;
        StringTokenizer stringtokenizer = new StringTokenizer(sdkKey, "-");
        int i = ((flag) ? 1 : 0);
        try
        {
            if (stringtokenizer.countTokens() == 7)
            {
                stringtokenizer.nextToken();
                stringtokenizer.nextToken();
                stringtokenizer.nextToken();
                stringtokenizer.nextToken();
                stringtokenizer.nextToken();
                i = Integer.valueOf(stringtokenizer.nextToken(), 16).intValue();
            }
        }
        catch (Exception exception)
        {
            i = ((flag) ? 1 : 0);
            if (TPLog.LOG10.isLoggable(LOG_TAG))
            {
                exception.printStackTrace();
                return 0;
            }
        }
        return i;
    }

    protected void initWithKey(Context context, String s)
    {
        if (sdkKey == null)
        {
            sdkKey = s;
            appContext = context;
            TPLog.initLogLevel(context);
            setAcceleratorNames();
            createStateMachine();
        } else
        if (tpccStateMachine != null)
        {
            if (tpccStateMachine.getStateMachineState() == 3)
            {
                if (TPLog.LOG13.isLoggable(LOG_TAG))
                {
                    Log.d(LOG_TAG, "TwinPrimeSDKPvt has already been initialized");
                    return;
                }
                if (tpccStateMachine.getStateMachineState() != 5)
                {
                    tpccStateMachine.poke();
                    return;
                }
            }
        } else
        {
            createStateMachine();
            return;
        }
    }

    void setAcceleratorNames()
    {
        String s = TPOptionManager.getAcceleratorNameOption();
        if (s != null)
        {
            accBackupName = s;
            accName = s;
            if (TPLog.LOG10.isLoggable(LOG_TAG))
            {
                TPLog.LOG10.d(LOG_TAG, (new StringBuilder()).append("Found an explicit accName [").append(accName).append("]").toString());
            }
            return;
        } else
        {
            String as[] = sdkKey.split("-");
            String s1 = as[as.length - 1];
            accBackupName = accName;
            accName = (new StringBuilder()).append("acc-").append(s1).append(".cust.twinprime.com").toString();
            return;
        }
    }

}
