// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;


// Referenced classes of package com.ebay.nautilus.kernel.content:
//            EbayAppInfo

public final class EbayAppInfoImpl
    implements EbayAppInfo
{

    private final int appBuildNumber;
    private final String appVersionBuild;
    private final String appVersionName;
    private final String appVersionWithoutBuild;
    private final boolean debuggable;
    private final String packageName;

    public EbayAppInfoImpl(String s, String s1, boolean flag)
    {
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("packageName is empty");
        }
        if (s1 == null || s1.length() == 0)
        {
            throw new IllegalArgumentException("versionName is empty");
        }
        packageName = s;
        appVersionName = s1;
        int i = s1.lastIndexOf('.');
        int j;
        if (i == -1)
        {
            s = s1;
        } else
        {
            s = s1.substring(0, i);
        }
        appVersionWithoutBuild = s;
        if (i == -1)
        {
            s = "";
        } else
        {
            s = s1.substring(i + 1, s1.length());
        }
        appVersionBuild = s;
        j = appVersionBuild.length();
        if (j > 0)
        {
            for (i = 0; i < j && (Character.isDigit(appVersionBuild.charAt(i)) || i == 0 && appVersionBuild.charAt(i) == '-'); i++) { }
            if (i == j)
            {
                s = appVersionBuild;
            } else
            {
                s = appVersionBuild.substring(0, i);
            }
            appBuildNumber = Integer.parseInt(s);
        } else
        {
            appBuildNumber = 0;
        }
        debuggable = flag;
    }

    public String getAppVersionBuildNumber()
    {
        return appVersionBuild;
    }

    public int getAppVersionBuildNumberWithoutVariations()
    {
        return appBuildNumber;
    }

    public String getAppVersionName()
    {
        return appVersionName;
    }

    public String getAppVersionWithoutBuildNumber()
    {
        return appVersionWithoutBuild;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public boolean isDebuggable()
    {
        return debuggable;
    }
}
