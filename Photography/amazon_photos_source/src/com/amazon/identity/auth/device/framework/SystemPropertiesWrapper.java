// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ReflectionHelper;

public class SystemPropertiesWrapper
{

    private static final String TAG = com/amazon/identity/auth/device/framework/SystemPropertiesWrapper.getName();
    private final ReflectionHelper mReflectionHelper = new ReflectionHelper();

    public SystemPropertiesWrapper()
    {
    }

    private transient Object invokeHiddenMethod(String s, Class aclass[], Object aobj[])
    {
        try
        {
            s = ((String) (mReflectionHelper.invokeStatic(s, "android.os.SystemProperties", aclass, aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Cannot get SystemProperties");
            return null;
        }
        return s;
    }

    public String get(String s)
    {
        return (String)invokeHiddenMethod("get", new Class[] {
            java/lang/String
        }, new Object[] {
            s
        });
    }

}
