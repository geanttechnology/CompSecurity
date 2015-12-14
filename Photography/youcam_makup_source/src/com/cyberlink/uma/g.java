// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma;

import android.content.Context;
import android.util.Log;
import com.cyberlink.uma.internal.a;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.cyberlink.uma:
//            l, a, k, j, 
//            h, i, UMA

public final class g
{

    private static final int a;
    private static final File b = com.cyberlink.uma.l.a(".uma-id");
    private static String c = "";
    private static String d = "";
    private static final Pattern e;

    static String a()
    {
        return com.cyberlink.uma.a.a(d());
    }

    public static String a(Context context)
    {
        k ak[] = new k[2];
        ak[0] = new j(context);
        ak[1] = new h();
        String s = a(ak);
        context = s;
        if (s.isEmpty())
        {
            context = a();
        }
        a(ak, ((String) (context)));
        return context;
    }

    private static String a(k ak[])
    {
        int i1;
        int j1;
        j1 = ak.length;
        i1 = 0;
_L3:
        if (i1 >= j1) goto _L2; else goto _L1
_L1:
        Object obj = ak[i1];
        boolean flag;
        obj = ((k) (obj)).a();
        flag = a(((String) (obj)));
        if (flag)
        {
            return ((String) (obj));
        }
        continue; /* Loop/switch isn't completed */
        Throwable throwable;
        throwable;
        i1++;
          goto _L3
_L2:
        return "";
    }

    private static void a(k ak[], String s)
    {
        int j1 = ak.length;
        int i1 = 0;
        while (i1 < j1) 
        {
            k k1 = ak[i1];
            try
            {
                k1.a(s);
            }
            catch (Throwable throwable)
            {
                Log.d("UMAUniqueID", "", throwable);
            }
            i1++;
        }
    }

    static boolean a(String s)
    {
        if (s == null || s.length() != a)
        {
            return false;
        } else
        {
            return e.matcher(s).matches();
        }
    }

    static File b()
    {
        return b;
    }

    static String b(Context context)
    {
        if (c.isEmpty())
        {
            c = c(context);
        }
        return c;
    }

    static int c()
    {
        return a;
    }

    static String c(Context context)
    {
        try
        {
            context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "";
        }
        return context;
    }

    static String d(Context context)
    {
        if (d.isEmpty())
        {
            d = e(context);
        }
        return d;
    }

    private static byte[] d()
    {
        byte abyte0[] = new byte[32];
        try
        {
            FileInputStream fileinputstream = new FileInputStream("/dev/urandom");
            fileinputstream.read(abyte0);
            fileinputstream.close();
        }
        catch (Throwable throwable)
        {
            com.cyberlink.uma.i.a().nextBytes(abyte0);
            return abyte0;
        }
        return abyte0;
    }

    static String e(Context context)
    {
        try
        {
            context = AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            if (com.cyberlink.uma.UMA.a)
            {
                com.cyberlink.uma.internal.a.b(context);
            }
            Log.w("UMAUniqueID", "Could not get AdvertisingId.", context);
            return "";
        }
        return context;
    }

    static 
    {
        a = (int)Math.ceil(10.666666666666666D) * 4;
        e = Pattern.compile((new StringBuilder()).append("^[0-9a-zA-Z=_~\\-]{").append(a).append("}$").toString());
    }
}
