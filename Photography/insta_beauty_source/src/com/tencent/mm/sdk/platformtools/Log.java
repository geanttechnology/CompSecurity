// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.widget.Toast;
import com.tencent.mm.algorithm.MD5;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            LogHelper, MMApplicationContext, Util

public class Log
{

    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static PrintStream ar;
    private static byte as[] = null;
    private static final String at;
    private static int level = 0;

    protected Log()
    {
    }

    public static void d(String s, String s1)
    {
        d(s, s1, null);
    }

    public static transient void d(String s, String s1, Object aobj[])
    {
        if (level <= 1)
        {
            if (aobj != null)
            {
                s1 = String.format(s1, aobj);
            }
            android.util.Log.d(s, s1);
            LogHelper.writeToStream(ar, as, (new StringBuilder("D/")).append(s).toString(), s1);
        }
    }

    public static void e(String s, String s1)
    {
        e(s, s1, null);
    }

    public static transient void e(String s, String s1, Object aobj[])
    {
        if (level <= 4)
        {
            if (aobj != null)
            {
                s1 = String.format(s1, aobj);
            }
            android.util.Log.e(s, s1);
            LogHelper.writeToStream(ar, as, (new StringBuilder("E/")).append(s).toString(), s1);
        }
    }

    public static void f(String s, String s1)
    {
        f(s, s1, null);
    }

    public static transient void f(String s, String s1, Object aobj[])
    {
        if (level <= 5)
        {
            if (aobj != null)
            {
                s1 = String.format(s1, aobj);
            }
            android.util.Log.e(s, s1);
            LogHelper.writeToStream(ar, as, (new StringBuilder("F/")).append(s).toString(), s1);
            Toast.makeText(MMApplicationContext.getContext(), s1, 1).show();
        }
    }

    public static int getLevel()
    {
        return level;
    }

    public static String getSysInfo()
    {
        return at;
    }

    public static void i(String s, String s1)
    {
        i(s, s1, null);
    }

    public static transient void i(String s, String s1, Object aobj[])
    {
        if (level <= 2)
        {
            if (aobj != null)
            {
                s1 = String.format(s1, aobj);
            }
            android.util.Log.i(s, s1);
            LogHelper.writeToStream(ar, as, (new StringBuilder("I/")).append(s).toString(), s1);
        }
    }

    public static void reset()
    {
        ar = null;
        as = null;
    }

    public static void setLevel(int j, boolean flag)
    {
        level = j;
        android.util.Log.w("MicroMsg.SDK.Log", (new StringBuilder("new log level: ")).append(j).toString());
        if (flag)
        {
            android.util.Log.e("MicroMsg.SDK.Log", "no jni log level support");
        }
    }

    public static void setOutputPath(String s, String s1, String s2, int j)
    {
        if (s != null && s.length() != 0 && s2 != null && s2.length() != 0) goto _L2; else goto _L1
_L1:
        Object obj;
        return;
_L2:
        if (!((File) (obj = new File(s))).exists()) goto _L1; else goto _L3
_L3:
        if (((File) (obj)).length() <= 0L) goto _L5; else goto _L4
_L4:
        obj = new FileInputStream(s);
_L6:
        setOutputStream(((InputStream) (obj)), new FileOutputStream(s, true), s1, s2, j);
        ((InputStream) (obj)).close();
        return;
        s;
        s.printStackTrace();
        return;
_L5:
        obj = null;
          goto _L6
    }

    public static void setOutputStream(InputStream inputstream, OutputStream outputstream, String s, String s1, int j)
    {
        long l;
        try
        {
            ar = new PrintStream(new BufferedOutputStream(outputstream));
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            return;
        }
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
        outputstream = inputstream.readLine().substring(2).trim();
        s1 = inputstream.readLine().substring(2).trim();
        l = Util.getLong(inputstream.readLine().trim().substring(2), 0L);
        d("MicroMsg.SDK.Log", "using provided info, type=%s, user=%s, createtime=%d", new Object[] {
            outputstream, s1, Long.valueOf(l)
        });
_L2:
        inputstream = new StringBuffer();
        inputstream.append(s1);
        inputstream.append(l);
        inputstream.append("dfdhgc");
        as = MD5.getMessageDigest(inputstream.toString().getBytes()).substring(7, 21).getBytes();
        android.util.Log.d("MicroMsg.SDK.Log", "set up out put stream");
        return;
        l = System.currentTimeMillis();
        LogHelper.initLogHeader(ar, s, s1, l, j);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void v(String s, String s1)
    {
        v(s, s1, null);
    }

    public static transient void v(String s, String s1, Object aobj[])
    {
        if (level <= 0)
        {
            if (aobj != null)
            {
                s1 = String.format(s1, aobj);
            }
            android.util.Log.v(s, s1);
            LogHelper.writeToStream(ar, as, (new StringBuilder("V/")).append(s).toString(), s1);
        }
    }

    public static void w(String s, String s1)
    {
        w(s, s1, null);
    }

    public static transient void w(String s, String s1, Object aobj[])
    {
        if (level <= 3)
        {
            if (aobj != null)
            {
                s1 = String.format(s1, aobj);
            }
            android.util.Log.w(s, s1);
            LogHelper.writeToStream(ar, as, (new StringBuilder("W/")).append(s).toString(), s1);
        }
    }

    static 
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder("VERSION.RELEASE:[")).append(android.os.Build.VERSION.RELEASE).toString());
        stringbuilder.append((new StringBuilder("] VERSION.CODENAME:[")).append(android.os.Build.VERSION.CODENAME).toString());
        stringbuilder.append((new StringBuilder("] VERSION.INCREMENTAL:[")).append(android.os.Build.VERSION.INCREMENTAL).toString());
        stringbuilder.append((new StringBuilder("] BOARD:[")).append(Build.BOARD).toString());
        stringbuilder.append((new StringBuilder("] DEVICE:[")).append(Build.DEVICE).toString());
        stringbuilder.append((new StringBuilder("] DISPLAY:[")).append(Build.DISPLAY).toString());
        stringbuilder.append((new StringBuilder("] FINGERPRINT:[")).append(Build.FINGERPRINT).toString());
        stringbuilder.append((new StringBuilder("] HOST:[")).append(Build.HOST).toString());
        stringbuilder.append((new StringBuilder("] MANUFACTURER:[")).append(Build.MANUFACTURER).toString());
        stringbuilder.append((new StringBuilder("] MODEL:[")).append(Build.MODEL).toString());
        stringbuilder.append((new StringBuilder("] PRODUCT:[")).append(Build.PRODUCT).toString());
        stringbuilder.append((new StringBuilder("] TAGS:[")).append(Build.TAGS).toString());
        stringbuilder.append((new StringBuilder("] TYPE:[")).append(Build.TYPE).toString());
        stringbuilder.append((new StringBuilder("] USER:[")).append(Build.USER).append("]").toString());
        at = stringbuilder.toString();
    }
}
