// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.UUID;

// Referenced classes of package com.jirbo.adcolony:
//            aj, q, d

final class s
{
    static final class a
    {

        long a;

        public final String toString()
        {
            return s.a((double)(System.currentTimeMillis() - a) / 1000D);
        }

        a()
        {
            a = System.currentTimeMillis();
        }
    }

    static final class b
    {

        double a;

        private double b()
        {
            double d1 = (double)System.currentTimeMillis() / 1000D;
            d1 = a - d1;
            if (d1 <= 0.0D)
            {
                return 0.0D;
            } else
            {
                return d1;
            }
        }

        final void a(double d1)
        {
            a = (double)System.currentTimeMillis() / 1000D + d1;
        }

        final boolean a()
        {
            return b() == 0.0D;
        }

        public final String toString()
        {
            return s.a(b());
        }

        b(double d1)
        {
            a = System.currentTimeMillis();
            a(d1);
        }
    }


    static byte a[] = new byte[1024];
    static StringBuilder b = new StringBuilder();

    static String a()
    {
        return UUID.randomUUID().toString();
    }

    static String a(double d1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        a(d1, stringbuilder);
        return stringbuilder.toString();
    }

    static String a(String s1, String s2)
    {
        if (s1 == null) goto _L2; else goto _L1
_L1:
        FileInputStream fileinputstream;
        aj.a.a("Loading ").b(s1);
        fileinputstream = new FileInputStream(s1);
        byte abyte0[] = a;
        abyte0;
        JVM INSTR monitorenter ;
        int i;
        b.setLength(0);
        b.append(s2);
        i = fileinputstream.read(a, 0, a.length);
          goto _L3
_L7:
        int j;
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        b.append((char)a[j]);
        j++;
        continue; /* Loop/switch isn't completed */
        i = fileinputstream.read(a, 0, a.length);
          goto _L3
_L5:
        fileinputstream.close();
        s2 = b.toString();
        abyte0;
        JVM INSTR monitorexit ;
        return s2;
        s2;
        abyte0;
        JVM INSTR monitorexit ;
        try
        {
            throw s2;
        }
        // Misplaced declaration of an exception variable
        catch (String s2)
        {
            aj.d.a("Unable to load ").b(s1);
        }
        return "";
_L2:
        return "";
_L3:
        if (i == -1) goto _L5; else goto _L4
_L4:
        j = 0;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static void a(double d1, StringBuilder stringbuilder)
    {
        if (!Double.isNaN(d1) && !Double.isInfinite(d1)) goto _L2; else goto _L1
_L1:
        stringbuilder.append(d1);
_L4:
        return;
_L2:
        long l2;
        long l3;
        double d2 = d1;
        if (d1 < 0.0D)
        {
            d2 = -d1;
            stringbuilder.append('-');
        }
        l2 = (long)Math.pow(10D, 2D);
        long l = Math.round((double)l2 * d2);
        stringbuilder.append(l / l2);
        stringbuilder.append('.');
        l3 = l % l2;
        if (l3 != 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        int i = 0;
        while (i < 2) 
        {
            stringbuilder.append('0');
            i++;
        }
        if (true) goto _L4; else goto _L3
_L3:
        for (long l1 = l3 * 10L; l1 < l2; l1 *= 10L)
        {
            stringbuilder.append('0');
        }

        stringbuilder.append(l3);
        return;
    }

    static boolean a(String s1)
    {
        if (q.x == null)
        {
            return false;
        }
        try
        {
            q.b().getApplication().getPackageManager().getApplicationInfo(s1, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return false;
        }
        return true;
    }

    static double b()
    {
        return (double)System.currentTimeMillis() / 1000D;
    }

    static String b(String s1)
    {
        char c1;
        int i;
        int k;
        int l;
        Object obj;
        try
        {
            obj = MessageDigest.getInstance("SHA-1");
            ((MessageDigest) (obj)).update(s1.getBytes("iso-8859-1"), 0, s1.length());
            s1 = ((MessageDigest) (obj)).digest();
            obj = new StringBuilder();
            l = s1.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return null;
        }
        i = 0;
          goto _L1
_L8:
        ((StringBuilder) (obj)).append(c1);
        if (k <= 0) goto _L3; else goto _L2
_L2:
        i++;
          goto _L1
_L6:
        s1 = ((StringBuilder) (obj)).toString();
        return s1;
_L3:
        int j;
        byte byte0;
        k++;
        j = byte0 & 0xf;
          goto _L4
_L1:
        if (i >= l) goto _L6; else goto _L5
_L5:
        byte0 = s1[i];
        j = byte0 >>> 4 & 0xf;
        k = 0;
_L4:
        if (j >= 0 && j <= 9)
        {
            c1 = (char)(j + 48);
        } else
        {
            c1 = (char)((j - 10) + 97);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    static boolean c()
    {
        StringBuilder stringbuilder = new StringBuilder();
        ac ac = q.c;
        return (new File(stringbuilder.append(com.jirbo.adcolony.d.b()).append("/../lib/libImmEndpointWarpJ.so").toString())).exists();
    }

    static boolean d()
    {
        while (q.x == null || q.b().checkCallingOrSelfPermission("android.permission.VIBRATE") != 0) 
        {
            return false;
        }
        return true;
    }

    static String e()
    {
        if (q.x == null)
        {
            return "";
        } else
        {
            return q.b().getPackageName();
        }
    }

}
