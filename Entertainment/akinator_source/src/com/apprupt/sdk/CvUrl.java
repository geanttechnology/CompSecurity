// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


class CvUrl
{

    static String CV_HOST = "cv.apprupt.com";
    static final String CV_SCRIPT_URL_PATH = "/js/cv.js";
    static final String PAYLOAD_SCRIPT_URL_PATH = "/js/payload.js";
    static final String URL_FORMAT = "http%s://%s%s";
    private static boolean useSecureConnections = false;

    CvUrl()
    {
    }

    public static String build()
    {
        return build("/", useSecureConnections);
    }

    public static String build(String s)
    {
        return build(s, useSecureConnections);
    }

    public static String build(String s, boolean flag)
    {
        String s1;
        if (s == null)
        {
            s1 = "/";
        } else
        {
            s1 = s;
            if (!s.startsWith("/"))
            {
                s1 = String.format("/%s", new Object[] {
                    s
                });
            }
        }
        if (flag)
        {
            s = "s";
        } else
        {
            s = "";
        }
        return String.format("http%s://%s%s", new Object[] {
            s, CV_HOST, s1
        });
    }

    public static String build(boolean flag)
    {
        return build("/", flag);
    }

    public static String getCvScriptUrl()
    {
        return build("/js/cv.js");
    }

    public static String getPayloadScriptUrl()
    {
        return build("/js/payload.js");
    }

    static boolean getUseSecureConnections()
    {
        return useSecureConnections;
    }

    static void setUseSecureConnections(boolean flag)
    {
        useSecureConnections = flag;
    }

}
