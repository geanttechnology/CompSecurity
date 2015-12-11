// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public final class bnh
{

    public static long a(long l, long l1)
    {
        if (l != 0L)
        {
            return l;
        } else
        {
            return l1;
        }
    }

    public static long a(long l, long l1, long l2)
    {
        if ((double)l2 * 0.10000000000000001D <= (double)l1)
        {
            l1 = l;
        }
        bmo.e((new StringBuilder(44)).append("Exo cache set to: ").append(l1).append(" bytes").toString());
        return l1;
    }

    public static String a(Context context, String s, String s1)
    {
        b.a(context);
        b.a(s);
        s1 = new StringBuilder();
        s1.append(context.getPackageName());
        s1.append('/');
        s1.append(s);
        s1.append("(Linux; U; Android ");
        s1.append(android.os.Build.VERSION.RELEASE);
        s1.append("; ");
        s1.append(Locale.getDefault().toString());
        context = Build.MODEL;
        if (context.length() > 0)
        {
            s1.append("; ");
            s1.append(context);
        }
        context = Build.ID;
        if (context.length() > 0)
        {
            s1.append(" Build/");
            s1.append(context);
        }
        s1.append(')');
        if (!TextUtils.isEmpty(null))
        {
            s1.append(' ');
            s1.append(null);
        }
        if (!TextUtils.isEmpty(null))
        {
            s1.append(" Experiment/");
            s1.append(null);
        }
        return s1.toString();
    }

    public static String a(Uri uri)
    {
        if (uri == null)
        {
            return null;
        }
        for (uri = uri.getPathSegments().iterator(); uri.hasNext();)
        {
            if ("videos".equals((String)uri.next()))
            {
                if (uri.hasNext())
                {
                    return (String)uri.next();
                } else
                {
                    return null;
                }
            }
        }

        return null;
    }

    public static String a(TelephonyManager telephonymanager, Locale locale)
    {
label0:
        {
            String s = null;
            if (telephonymanager != null)
            {
                s = telephonymanager.getNetworkCountryIso();
            }
            telephonymanager = s;
            if (TextUtils.isEmpty(s))
            {
                telephonymanager = "";
            }
            s = b(telephonymanager);
            if (!TextUtils.isEmpty(s))
            {
                telephonymanager = s;
                if (s.length() >= 2)
                {
                    break label0;
                }
            }
            telephonymanager = b(locale.getCountry());
        }
        return telephonymanager;
    }

    public static Throwable a(Throwable throwable)
    {
        for (; throwable.getCause() != null; throwable = throwable.getCause()) { }
        return throwable;
    }

    public static Date a(String s)
    {
        b.a(s);
        Object obj;
        obj = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        ((SimpleDateFormat) (obj)).setTimeZone(TimeZone.getTimeZone("GMT"));
        obj = ((SimpleDateFormat) (obj)).parse(s);
        return ((Date) (obj));
        ParseException parseexception;
        parseexception;
        String s1 = s;
        int i = s.length() - 3;
        parseexception = s;
        if (i < 0) goto _L2; else goto _L1
_L1:
        parseexception = s;
        s1 = s;
        if (s.charAt(i) != ':') goto _L2; else goto _L3
_L3:
        s1 = s;
        parseexception = String.valueOf(s.substring(0, i));
        s1 = s;
        String s2 = String.valueOf(s.substring(i + 1));
        s1 = s;
        if (s2.length() == 0) goto _L5; else goto _L4
_L4:
        s1 = s;
        parseexception = parseexception.concat(s2);
_L2:
        s1 = parseexception;
        try
        {
            return (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ", Locale.US)).parse(parseexception);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = String.valueOf(s1);
        }
        break MISSING_BLOCK_LABEL_151;
_L5:
        s1 = s;
        parseexception = new String(parseexception);
          goto _L2
        if (s.length() != 0)
        {
            s = "Invalid RFC3339 date: ".concat(s);
        } else
        {
            s = new String("Invalid RFC3339 date: ");
        }
        bmo.e(s);
        return null;
    }

    public static void a(SharedPreferences sharedpreferences, String s, String s1, boolean flag)
    {
        b.a(sharedpreferences);
        b.a(s);
        b.a(s1);
        flag = sharedpreferences.getBoolean(s, false);
        sharedpreferences.edit().putBoolean(s1, flag).remove(s).apply();
    }

    public static void a(InputStream inputstream, OutputStream outputstream)
    {
        a.a(inputstream, outputstream);
    }

    public static boolean a(Context context)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        if (context == null)
        {
            return false;
        }
        return Math.min(context.getWidth(), context.getHeight()) <= 359;
    }

    public static byte[] a(byte abyte0[])
    {
        bni;
        JVM INSTR monitorenter ;
        abyte0 = bni.a.digest(abyte0);
        bni;
        JVM INSTR monitorexit ;
        return abyte0;
        abyte0;
        bni;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    private static String b(String s)
    {
        String s1 = s.trim().replace(",", "");
        s = s1;
        if (s1.length() > 2)
        {
            s = s1.substring(0, 2);
        }
        return s.toUpperCase(Locale.US);
    }

    public static boolean b(Context context)
    {
        b.a(context);
        return ((ActivityManager)context.getSystemService("activity")).getLargeMemoryClass() >= 128;
    }

    static 
    {
        a.a(0, 3);
    }
}
