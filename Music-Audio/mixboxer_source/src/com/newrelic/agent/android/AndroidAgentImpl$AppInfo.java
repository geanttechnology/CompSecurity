// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.newrelic.agent.android.logging.AgentLog;

// Referenced classes of package com.newrelic.agent.android:
//            AndroidAgentImpl, AgentInitializationException

private static final class packageManager
{

    private final String appName;
    private final String appVersion;
    private final PackageManager packageManager;
    private final String packageName;

    public static packageManager fromContext(Context context)
        throws AgentInitializationException
    {
        String s;
        s = context.getPackageName();
        PackageManager packagemanager = context.getPackageManager();
        String s1;
        try
        {
            context = packagemanager.getPackageInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new AgentInitializationException("Could not determine package version", context);
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        s1 = ((PackageInfo) (context)).versionName;
        context = packagemanager.getApplicationInfo(s, 0);
        if (context != null)
        {
            try
            {
                context = packagemanager.getApplicationLabel(context).toString();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                AndroidAgentImpl.access$200().warning(context.toString());
                context = s;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                AndroidAgentImpl.access$200().warning(context.toString());
                context = s;
            }
        } else
        {
            context = s;
        }
        return new <init>(s, context, s1, packagemanager);
        throw new AgentInitializationException("No package info available for this app");
    }

    public String getAppName()
    {
        return appName;
    }

    public String getAppVersion()
    {
        return appVersion;
    }

    public PackageManager getPackageManager()
    {
        return packageManager;
    }

    public String getPackageName()
    {
        return packageName;
    }

    private ion(String s, String s1, String s2, PackageManager packagemanager)
    {
        packageName = s;
        appName = s1;
        appVersion = s2;
        packageManager = packagemanager;
    }
}
