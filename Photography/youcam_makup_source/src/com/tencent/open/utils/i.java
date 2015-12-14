// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import com.tencent.open.a.k;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.List;

// Referenced classes of package com.tencent.open.utils:
//            c, m

public class i
{

    public static int a(String s, String s1)
    {
        if (s != null || s1 != null) goto _L2; else goto _L1
_L1:
        return 0;
_L2:
        String as[];
        String as1[];
        int j;
        if (s != null && s1 == null)
        {
            return 1;
        }
        if (s == null && s1 != null)
        {
            return -1;
        }
        as = s.split("\\.");
        as1 = s1.split("\\.");
        j = 0;
_L3:
        int l;
        int i1;
        if (j >= as.length || j >= as1.length)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        l = Integer.parseInt(as[j]);
        i1 = Integer.parseInt(as1[j]);
        if (l < i1)
        {
            return -1;
        }
        break MISSING_BLOCK_LABEL_117;
        if (as.length > j)
        {
            return 1;
        }
        try
        {
            l = as1.length;
        }
        catch (NumberFormatException numberformatexception)
        {
            return s.compareTo(s1);
        }
        if (l > j)
        {
            return -1;
        }
          goto _L1
        if (l > i1)
        {
            return 1;
        }
        j++;
          goto _L3
    }

    private static long a(InputStream inputstream, OutputStream outputstream)
    {
        long l = 0L;
        byte abyte0[] = new byte[8192];
        do
        {
            int j = inputstream.read(abyte0, 0, abyte0.length);
            if (j != -1)
            {
                outputstream.write(abyte0, 0, j);
                l += j;
            } else
            {
                k.c("openSDK_LOG.SysUtils", (new StringBuilder()).append("-->copy, copyed size is: ").append(l).toString());
                return l;
            }
        } while (true);
    }

    public static String a(Context context)
    {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static String a(Context context, String s)
    {
        context = context.getPackageManager();
        try
        {
            context = context.getPackageInfo(s, 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static boolean a(Context context, Intent intent)
    {
        while (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) 
        {
            return false;
        }
        return true;
    }

    public static boolean a(String s, String s1, int j)
    {
        String s2;
        String s3;
        String s4;
        android.content.SharedPreferences.Editor editor;
        Context context;
        s3 = null;
        s2 = null;
        editor = null;
        s4 = null;
        k.c("openSDK_LOG.SysUtils", (new StringBuilder()).append("-->extractSecureLib, libName: ").append(s).toString());
        context = com.tencent.open.utils.c.a();
        if (context != null) goto _L2; else goto _L1
_L1:
        k.c("openSDK_LOG.SysUtils", "-->extractSecureLib, global context is null. ");
_L4:
        return false;
_L2:
        SharedPreferences sharedpreferences = context.getSharedPreferences("secure_lib", 0);
        File file = new File(context.getFilesDir(), s1);
        if (!file.exists())
        {
            File file1 = file.getParentFile();
            if (file1 != null && file1.mkdirs())
            {
                try
                {
                    file.createNewFile();
                }
                catch (IOException ioexception1)
                {
                    ioexception1.printStackTrace();
                }
            }
        } else
        {
            int l = sharedpreferences.getInt("version", 0);
            k.c("openSDK_LOG.SysUtils", (new StringBuilder()).append("-->extractSecureLib, libVersion: ").append(j).append(" | oldVersion: ").append(l).toString());
            if (j == l)
            {
                return true;
            }
        }
        s = context.getAssets().open(s);
        s3 = s;
        s = s2;
        s2 = s3;
        s4 = editor;
        s1 = context.openFileOutput(s1, 0);
        s = s1;
        s2 = s3;
        s4 = s1;
        a(((InputStream) (s3)), ((OutputStream) (s1)));
        s = s1;
        s2 = s3;
        s4 = s1;
        editor = sharedpreferences.edit();
        s = s1;
        s2 = s3;
        s4 = s1;
        editor.putInt("version", j);
        s = s1;
        s2 = s3;
        s4 = s1;
        editor.commit();
        if (s3 != null)
        {
            try
            {
                s3.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        return true;
        s1;
        s3 = null;
_L7:
        s = s4;
        s2 = s3;
        k.b("openSDK_LOG.SysUtils", "-->extractSecureLib, when copy lib execption.", s1);
        if (s3 != null)
        {
            try
            {
                s3.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        if (s4 == null) goto _L4; else goto _L3
_L3:
        try
        {
            s4.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return false;
        s1;
        s2 = null;
        s = s3;
_L6:
        if (s2 != null)
        {
            try
            {
                s2.close();
            }
            catch (IOException ioexception) { }
        }
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        throw s1;
        s1;
        if (true) goto _L6; else goto _L5
_L5:
        s1;
          goto _L7
    }

    public static String b(Context context, String s)
    {
        k.a("openSDK_LOG", "OpenUi, getSignValidString");
        MessageDigest messagedigest;
        String s1 = context.getPackageName();
        context = context.getPackageManager().getPackageInfo(s1, 64).signatures;
        messagedigest = MessageDigest.getInstance("MD5");
        messagedigest.update(context[0].toByteArray());
        context = m.a(messagedigest.digest());
        messagedigest.reset();
        k.b("SystemUtils", (new StringBuilder()).append("-->sign: ").append(context).toString());
        messagedigest.update(m.e((new StringBuilder()).append(s1).append("_").append(context).append("_").append(s).append("").toString()));
        context = m.a(messagedigest.digest());
        messagedigest.reset();
        k.b("SystemUtils", (new StringBuilder()).append("-->signEncryped: ").append(context).toString());
        return context;
        s;
        context = "";
_L2:
        s.printStackTrace();
        k.b("openSDK_LOG", "OpenUi, getSignValidString error", s);
        return context;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static int c(Context context, String s)
    {
        return a(a(context, "com.tencent.mobileqq"), s);
    }
}
