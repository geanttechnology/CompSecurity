// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.env;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.env:
//            ProdUtils

public abstract class EnvironmentUtils
{
    public static final class Environment extends Enum
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
            return (Environment)Enum.valueOf(com/amazon/identity/auth/device/env/EnvironmentUtils$Environment, s);
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


    static final Map ASSOC_HANDLE_MAP = new HashMap();
    private static final String TAG = com/amazon/identity/auth/device/env/EnvironmentUtils.getName();
    static volatile EnvironmentUtils sInstance = new ProdUtils();

    public EnvironmentUtils()
    {
    }

    public static EnvironmentUtils getInstance()
    {
        return sInstance;
    }

    public static boolean isCurrentEnvironmentProd()
    {
        return sInstance.getCurrentEnvironment() == Environment.prod;
    }

    public abstract String getAmazonCNDomain();

    public abstract String getAmazonJPDomain();

    public abstract String getAmazonUKDomain();

    public abstract String getAmazonUSDomain();

    public abstract String getCompleteAuthPortalDomain(String s);

    protected abstract Environment getCurrentEnvironment();

    public abstract String getDCAHost();

    public abstract String getDefaultAmazonDomain();

    public String getDefaultAssocHandle(String s)
    {
        return (String)ASSOC_HANDLE_MAP.get(getCompleteAuthPortalDomain(s));
    }

    public abstract String getDomainWithoutWWW(String s);

    public abstract String getFIRSHost();

    public abstract String getPVTinyURLPatternString();

    public abstract String getPandaHost(String s);


}
