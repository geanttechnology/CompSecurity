// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.crash;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class WebViewLogger
{

    static final SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
    static final Queue webViewLogger = new LinkedList();

    public WebViewLogger()
    {
    }

    public static String getWebViewHistory()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = webViewLogger.iterator(); iterator.hasNext(); stringbuilder.append((String)iterator.next())) { }
        return stringbuilder.toString();
    }

    public static void logURL(String s)
    {
        if (webViewLogger.size() == 15)
        {
            webViewLogger.remove();
        }
        webViewLogger.add(String.format("\n%s: %s", new Object[] {
            sdf.format(new Date()), s
        }));
    }

}
