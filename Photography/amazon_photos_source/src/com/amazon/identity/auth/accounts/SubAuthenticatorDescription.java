// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.ComponentName;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class SubAuthenticatorDescription
{

    public final String className;
    public final String deviceType;
    public final boolean isDMS;
    public final boolean isKnownMultipleAccountAware;
    public final String packageName;
    public final List tokenTypes;

    private SubAuthenticatorDescription(String s, String s1, String s2, boolean flag)
    {
label0:
        {
            super();
            if (!TextUtils.isEmpty(s))
            {
                boolean flag1;
                if (s1 != null && s1.length() == 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag1 && !TextUtils.isEmpty(s2))
                {
                    break label0;
                }
            }
            throw new IllegalArgumentException("One or more parameters are null or empty");
        }
        packageName = s;
        className = s1;
        isDMS = true;
        deviceType = s2;
        tokenTypes = Collections.unmodifiableList(Arrays.asList(new String[] {
            getDMSAdpTokenNameFromPackageName(packageName), getDMSPrivateKeyFromPackageName(packageName), getDMSDeviceTypeFromPackageName(packageName), getDMSDeviceSerialNumberFromPackageName(packageName), getDMSDeviceEmailFromPackageName(packageName), getDMSStoreAuthCookieFromPackageName(packageName), getXmainCookieFromPackageName(packageName), getAccountPoolFromPackageName(packageName)
        }));
        isKnownMultipleAccountAware = flag;
    }

    private SubAuthenticatorDescription(String s, String s1, List list)
    {
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) || list == null || list.isEmpty())
        {
            throw new IllegalArgumentException("One or more parameters are null or empty");
        } else
        {
            packageName = s;
            className = s1;
            isDMS = false;
            deviceType = null;
            tokenTypes = Collections.unmodifiableList(new ArrayList(list));
            isKnownMultipleAccountAware = false;
            return;
        }
    }

    public static SubAuthenticatorDescription createDMSSubAuthenticatorDescription(String s, String s1, String s2, boolean flag)
    {
        return new SubAuthenticatorDescription(s, s1, s2, flag);
    }

    public static SubAuthenticatorDescription createNonDMSSubAuthenticatorDescription(String s, String s1, List list)
    {
        return new SubAuthenticatorDescription(s, s1, list);
    }

    public static String getAccountPoolFromPackageName(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(s).append(".tokens.account_pool").toString();
        }
    }

    public static String getDMSAdpTokenNameFromPackageName(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(s).append(".tokens.adp_token").toString();
        }
    }

    public static String getDMSDeviceEmailFromPackageName(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(s).append(".tokens.email").toString();
        }
    }

    public static String getDMSDeviceSerialNumberFromPackageName(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(s).append(".tokens.dsn").toString();
        }
    }

    public static String getDMSDeviceTypeFromPackageName(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(s).append(".tokens.device_type").toString();
        }
    }

    public static String getDMSPrivateKeyFromPackageName(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(s).append(".tokens.private_key").toString();
        }
    }

    public static String getDMSStoreAuthCookieFromPackageName(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(s).append(".tokens.storeAuthCookie").toString();
        }
    }

    public static String getXmainCookieFromPackageName(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(s).append(".tokens.xmain").toString();
        }
    }

    public ComponentName getComponentName()
    {
        if (className == null)
        {
            return null;
        } else
        {
            return new ComponentName(packageName, className);
        }
    }
}
