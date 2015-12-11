// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.kernel.util.XmlFormatter;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            IHeaders, IHeader

class NetworkLog
{

    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo fwLogNetwork = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("fwLogNetwork", 3, "Log network requests");

    NetworkLog()
    {
    }

    static void logContent(int i, String s, URL url, byte abyte0[], IHeaders iheaders)
    {
        com/ebay/nautilus/kernel/net/NetworkLog;
        JVM INSTR monitorenter ;
        logContent(i, s, url, abyte0, iheaders, false);
        com/ebay/nautilus/kernel/net/NetworkLog;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    private static void logContent(int i, String s, URL url, byte abyte0[], IHeaders iheaders, boolean flag)
    {
        com/ebay/nautilus/kernel/net/NetworkLog;
        JVM INSTR monitorenter ;
        if (url == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        FwLog.println(i, s, url.toString());
        String s1 = iheaders.getFirstHeader("Content-Type");
        if (abyte0 == null || s1 == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        boolean flag1;
        if (url != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        logHeaders(i, s, flag1, iheaders);
        logContent(i, s, abyte0, s1, flag);
        com/ebay/nautilus/kernel/net/NetworkLog;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    private static void logContent(int i, String s, byte abyte0[], String s1, boolean flag)
    {
        Object obj = s1.toLowerCase(Locale.US);
        if (((String) (obj)).contains("json") || ((String) (obj)).contains("xml") || ((String) (obj)).contains("text")) goto _L2; else goto _L1
_L1:
        if (!flag)
        {
            FwLog.println(i, s, (new StringBuilder()).append("Can't log content type \"").append(s1).append('"').toString());
        }
_L9:
        return;
_L2:
        try
        {
            s1 = new String(abyte0, "UTF8");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            s1 = ((Exception) (obj)).getMessage();
            abyte0 = s1;
            if (s1 == null)
            {
                abyte0 = obj.getClass().getName();
            }
            FwLog.println(6, s, abyte0, ((Throwable) (obj)));
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        if (((String) (obj)).contains("json"))
        {
            FwLog.println(i, s, (new JSONObject(s1)).toString(2));
            return;
        }
        if (((String) (obj)).contains("xml"))
        {
            FwLog.println(i, s, XmlFormatter.format(s1));
            return;
        }
        FwLog.println(i, s, s1);
        return;
        abyte0 = s1;
        flag = ((String) (obj)).contains("json");
        if (!flag) goto _L4; else goto _L3
_L3:
        s1 = (new JSONObject(s1)).toString(2);
        abyte0 = s1;
_L7:
        if (abyte0.length() <= 3840)
        {
            FwLog.println(i, s, abyte0);
            return;
        }
          goto _L5
_L4:
        if (!((String) (obj)).contains("xml")) goto _L7; else goto _L6
_L6:
        abyte0 = XmlFormatter.format(s1);
          goto _L7
_L5:
        s1 = new StringBuilder(abyte0);
_L12:
        if (s1.length() <= 0) goto _L9; else goto _L8
_L8:
        if (s1.length() > 3840) goto _L11; else goto _L10
_L10:
        abyte0 = s1.toString();
        s1.delete(0, s1.length());
_L13:
        FwLog.println(i, s, abyte0);
          goto _L12
_L11:
        int j = s1.lastIndexOf("\n", 3840);
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_332;
        }
        abyte0 = s1.substring(0, 3840);
        s1.delete(0, 3840);
          goto _L13
        abyte0 = s1.substring(0, j);
        s1.delete(0, j + 1);
          goto _L13
        s1;
          goto _L7
    }

    static void logContent(URL url, byte abyte0[], IHeaders iheaders)
    {
        com/ebay/nautilus/kernel/net/NetworkLog;
        JVM INSTR monitorenter ;
        logContent(fwLogNetwork.priority, fwLogNetwork.tag, url, abyte0, iheaders, true);
        com/ebay/nautilus/kernel/net/NetworkLog;
        JVM INSTR monitorexit ;
        return;
        url;
        throw url;
    }

    static void logContent(byte abyte0[], String s)
    {
        if (abyte0 != null && s != null)
        {
            logContent(fwLogNetwork.priority, fwLogNetwork.tag, abyte0, s, true);
        }
    }

    static void logHeaders(int i, String s, boolean flag, IHeaders iheaders)
    {
        Iterator iterator = iheaders.iterator();
        while (iterator.hasNext()) 
        {
            IHeader iheader = (IHeader)iterator.next();
            StringBuilder stringbuilder = new StringBuilder();
            if (flag)
            {
                iheaders = ">> ";
            } else
            {
                iheaders = "<< ";
            }
            FwLog.println(i, s, stringbuilder.append(iheaders).append(iheader.getName()).append(": ").append(iheader.getValue()).toString());
        }
    }

}
