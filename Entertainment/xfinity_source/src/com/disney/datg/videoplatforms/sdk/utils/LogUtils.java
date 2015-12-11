// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.utils;

import android.util.Log;

public class LogUtils
{

    private static final int LOG_PREFIX_LENGTH = "androidSDK_".length();

    public static void LOGD(String s, String s1)
    {
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        if (s != null && s2 != null)
        {
            Log.d(s, s2);
        }
    }

    public static void LOGE(String s, String s1)
    {
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        if (s != null && s2 != null)
        {
            Log.e(s, s2);
        }
    }

    public static void LOGV(String s, String s1)
    {
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        if (s != null && s2 != null)
        {
            Log.v(s, s2);
        }
    }

    public static void LOGW(String s, String s1)
    {
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        if (s != null && s2 != null)
        {
            Log.w(s, s2);
        }
    }

    public static void logException(Exception exception)
    {
    }

    public static String makeLogTag(Class class1)
    {
        return makeLogTag(class1.getSimpleName());
    }

    public static String makeLogTag(String s)
    {
        if (s.length() > 35 - LOG_PREFIX_LENGTH)
        {
            return (new StringBuilder()).append("androidSDK_").append(s.substring(0, 35 - LOG_PREFIX_LENGTH - 1)).toString();
        } else
        {
            return (new StringBuilder()).append("androidSDK_").append(s).toString();
        }
    }

}
