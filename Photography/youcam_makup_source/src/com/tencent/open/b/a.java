// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.tencent.open.a.k;

public class a
{

    protected static final String a = com/tencent/open/b/a.getName();
    protected static final Uri b = Uri.parse("content://telephony/carriers/preferapn");

    public a()
    {
    }

    public static String a(Context context)
    {
        int i = d(context);
        if (i != 2) goto _L2; else goto _L1
_L1:
        context = "wifi";
_L4:
        return context;
_L2:
        String s;
        if (i == 1)
        {
            return "cmwap";
        }
        if (i == 4)
        {
            return "cmnet";
        }
        if (i == 16)
        {
            return "uniwap";
        }
        if (i == 8)
        {
            return "uninet";
        }
        if (i == 64)
        {
            return "wap";
        }
        if (i == 32)
        {
            return "net";
        }
        if (i == 512)
        {
            return "ctwap";
        }
        if (i == 256)
        {
            return "ctnet";
        }
        if (i == 2048)
        {
            return "3gnet";
        }
        if (i == 1024)
        {
            return "3gwap";
        }
        s = b(context);
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        context = s;
        if (s.length() != 0) goto _L4; else goto _L3
_L3:
        return "none";
    }

    public static String b(Context context)
    {
        Cursor cursor = context.getContentResolver().query(b, null, null, null, null);
        if (cursor == null)
        {
            return null;
        }
        cursor.moveToFirst();
        if (cursor.isAfterLast())
        {
            if (cursor == null)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            String s;
            try
            {
                cursor.close();
                break MISSING_BLOCK_LABEL_113;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                k.e(a, (new StringBuilder()).append("getApn has exception: ").append(context.getMessage()).toString());
                context = "";
            }
            break MISSING_BLOCK_LABEL_111;
        }
        s = cursor.getString(cursor.getColumnIndex("apn"));
        context = s;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        cursor.close();
        return s;
        return context;
        return null;
    }

    public static String c(Context context)
    {
        Cursor cursor = context.getContentResolver().query(b, null, null, null, null);
        if (cursor == null)
        {
            return null;
        }
        cursor.moveToFirst();
        if (cursor.isAfterLast())
        {
            if (cursor == null)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            String s;
            try
            {
                cursor.close();
                break MISSING_BLOCK_LABEL_113;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                k.e(a, (new StringBuilder()).append("getApnProxy has exception: ").append(context.getMessage()).toString());
                context = "";
            }
            break MISSING_BLOCK_LABEL_111;
        }
        s = cursor.getString(cursor.getColumnIndex("proxy"));
        context = s;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        cursor.close();
        return s;
        return context;
        return null;
    }

    public static int d(Context context)
    {
        Object obj = (ConnectivityManager)context.getSystemService("connectivity");
        if (obj == null)
        {
            return 128;
        }
        obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
        if (obj == null)
        {
            return 128;
        }
        if (((NetworkInfo) (obj)).getTypeName().toUpperCase().equals("WIFI"))
        {
            return 2;
        }
        obj = ((NetworkInfo) (obj)).getExtraInfo().toLowerCase();
        if (((String) (obj)).startsWith("cmwap"))
        {
            return 1;
        }
        if (((String) (obj)).startsWith("cmnet") || ((String) (obj)).startsWith("epc.tmobile.com"))
        {
            break MISSING_BLOCK_LABEL_256;
        }
        if (((String) (obj)).startsWith("uniwap"))
        {
            return 16;
        }
        if (((String) (obj)).startsWith("uninet"))
        {
            return 8;
        }
        if (((String) (obj)).startsWith("wap"))
        {
            return 64;
        }
        if (((String) (obj)).startsWith("net"))
        {
            return 32;
        }
        if (((String) (obj)).startsWith("ctwap"))
        {
            return 512;
        }
        if (((String) (obj)).startsWith("ctnet"))
        {
            return 256;
        }
        if (((String) (obj)).startsWith("3gwap"))
        {
            return 1024;
        }
        if (((String) (obj)).startsWith("3gnet"))
        {
            return 2048;
        }
        if (!((String) (obj)).startsWith("#777"))
        {
            break MISSING_BLOCK_LABEL_252;
        }
        context = c(context);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        int i = context.length();
        if (i > 0)
        {
            return 512;
        }
        return 256;
        context;
        k.e(a, (new StringBuilder()).append("getMProxyType has exception: ").append(context.getMessage()).toString());
        return 128;
        return 4;
    }

    public static String e(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null)
        {
            return "MOBILE";
        }
        context = context.getActiveNetworkInfo();
        if (context != null)
        {
            return context.getTypeName();
        } else
        {
            return "MOBILE";
        }
    }

}
