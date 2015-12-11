// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.identity.auth.device.framework.TrustedPackageManager;
import com.amazon.identity.platform.setting.PlatformSettings;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            ProdUtils, MAPLog, PreProdUtils, DevoUtils

public abstract class EnvironmentUtils
{
    protected static final class Environment extends Enum
    {

        private static final Environment $VALUES[];
        public static final Environment devo;
        public static final Environment pre_prod;
        public static final Environment prod;

        public static Environment fromString(String s)
        {
            Environment aenvironment[] = values();
            int j = aenvironment.length;
            for (int i = 0; i < j; i++)
            {
                Environment environment = aenvironment[i];
                if (environment.toString().equalsIgnoreCase(s))
                {
                    return environment;
                }
            }

            MAPLog.e(EnvironmentUtils.TAG, String.format("Not able to determine environment for value %s. Defaulting to Prod", new Object[] {
                s
            }));
            return prod;
        }

        public static Environment valueOf(String s)
        {
            return (Environment)Enum.valueOf(com/amazon/identity/auth/device/utils/EnvironmentUtils$Environment, s);
        }

        public static Environment[] values()
        {
            return (Environment[])$VALUES.clone();
        }

        static 
        {
            devo = new Environment("devo", 0);
            pre_prod = new Environment("pre_prod", 1);
            prod = new Environment("prod", 2);
            $VALUES = (new Environment[] {
                devo, pre_prod, prod
            });
        }

        private Environment(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/utils/EnvironmentUtils.getName();
    static EnvironmentUtils sInstance = new ProdUtils();

    public EnvironmentUtils()
    {
    }

    private static String getEnvironmentFromSharedPref(Context context)
    {
        if (!(new TrustedPackageManager(context)).isTrustedPackage("com.amazon.map.devoProdSwitch"))
        {
            break MISSING_BLOCK_LABEL_50;
        }
        context = context.createPackageContext("com.amazon.map.devoProdSwitch", 0).getSharedPreferences("map_environment", 1).getString("environment", Environment.prod.name());
        return context;
        context;
        context = TAG;
        return Environment.prod.name();
    }

    public static EnvironmentUtils getInstance()
    {
        return sInstance;
    }

    public static boolean isCurrentEnvironmentDevo()
    {
        return sInstance.getCurrentEnvironment() == Environment.devo;
    }

    public static boolean isCurrentEnvironmentProd()
    {
        return sInstance.getCurrentEnvironment() == Environment.prod;
    }

    public static void toggleEnvironment(Context context)
    {
        String s1 = PlatformSettings.getInstance(context).getSettingString("environment", null);
        String s = TAG;
        (new StringBuilder("got setting string ")).append(s1).toString();
        s = s1;
        if (s1 == null)
        {
            s = getEnvironmentFromSharedPref(context);
        }
        Environment.fromString(s);
    }

    protected static void toggleEnvironmentTo(Environment environment)
    {
        MAPLog.i(TAG, String.format("Toggling environment to %s. This should not happen in release builds", new Object[] {
            environment
        }));
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$identity$auth$device$utils$EnvironmentUtils$Environment[];

            static 
            {
                $SwitchMap$com$amazon$identity$auth$device$utils$EnvironmentUtils$Environment = new int[Environment.values().length];
                try
                {
                    $SwitchMap$com$amazon$identity$auth$device$utils$EnvironmentUtils$Environment[Environment.prod.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$identity$auth$device$utils$EnvironmentUtils$Environment[Environment.pre_prod.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$identity$auth$device$utils$EnvironmentUtils$Environment[Environment.devo.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.identity.auth.device.utils.EnvironmentUtils.Environment[environment.ordinal()])
        {
        default:
            sInstance = new ProdUtils();
            return;

        case 1: // '\001'
            sInstance = new ProdUtils();
            return;

        case 2: // '\002'
            sInstance = new PreProdUtils();
            return;

        case 3: // '\003'
            sInstance = new DevoUtils();
            break;
        }
    }

    public abstract String getAmazonCNDomain();

    public abstract String getAmazonJPDomain();

    public abstract String getAmazonUKDomain();

    public abstract String getAmazonUSDomain();

    public abstract String getCompleteAuthPortalDomain(String s);

    protected abstract Environment getCurrentEnvironment();

    public abstract String getDCAHost();

    public abstract String getDefaultAmazonDomain();

    public abstract String getFIRSHost();

    public abstract String getPandaHost(String s);


}
