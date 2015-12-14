// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities.info;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.inmobi.commons.a.a;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class b
{

    public static Map a()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("d-netType", c());
        hashmap.put("d-localization", b());
        return hashmap;
    }

    private static String b()
    {
        return Locale.getDefault().toString();
    }

    private static String c()
    {
        int i;
        int j;
        Object obj = com.inmobi.commons.a.a.b();
        if (((Context) (obj)).checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        obj = (ConnectivityManager)((Context) (obj)).getSystemService("connectivity");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        i = ((NetworkInfo) (obj)).getType();
        j = ((NetworkInfo) (obj)).getSubtype();
        if (i != 1) goto _L2; else goto _L1
_L1:
        String s = "wifi";
_L4:
        return s;
_L2:
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        s = "carrier";
        if (j == 1)
        {
            return "gprs";
        }
        if (j == 2)
        {
            return "edge";
        }
        if (j == 3)
        {
            return "umts";
        }
        if (j != 0) goto _L4; else goto _L3
_L3:
        return "carrier";
        return "";
    }
}
