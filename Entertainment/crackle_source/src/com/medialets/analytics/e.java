// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package com.medialets.analytics:
//            g

class e
{

    long a;
    long b;

    e()
    {
    }

    e(long l)
    {
        a = l;
        b();
    }

    static int a(Context context)
    {
        int i;
        try
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return 1;
        }
        if (context == null)
        {
            return 0;
        }
        i = context.getType();
        switch (i)
        {
        default:
            return 1;

        case 1: // '\001'
            return 3;

        case 0: // '\0'
            return 2;
        }
    }

    public static String a(String s)
    {
        s = (new BigInteger(1, MessageDigest.getInstance("MD5").digest(s.getBytes()))).toString(16);
_L2:
        String s1 = s;
        if (s.length() >= 32)
        {
            break; /* Loop/switch isn't completed */
        }
        s = (new StringBuilder()).append("0").append(s).toString();
        if (true) goto _L2; else goto _L1
        s;
        Log.e("Medialytics", (new StringBuilder()).append("Error while hashing string...").append(s.toString()).toString());
        s1 = null;
_L1:
        return s1;
    }

    public static String a(Date date)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat();
        simpledateformat.applyPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        return simpledateformat.format(date);
    }

    public long a()
    {
        b();
        return a;
    }

    public void b()
    {
        b = System.currentTimeMillis();
    }

    boolean c()
    {
        return System.currentTimeMillis() - b > (long)g.MIN_RUN_GAP_MSEC;
    }
}
