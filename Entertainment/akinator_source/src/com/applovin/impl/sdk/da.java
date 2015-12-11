// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.applovin.impl.adview.v;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.applovin.impl.sdk:
//            br, AppLovinSdkImpl, bu, AppLovinAdImpl, 
//            bt

public class da extends AppLovinSdkUtils
{

    private static final char a[] = "0123456789abcdef".toCharArray();
    private static final char b[] = "-'".toCharArray();

    public static float a(float f)
    {
        return 1000F * f;
    }

    public static Bitmap a(Context context, int i, int j)
    {
        int k = 1;
        Object obj;
        try
        {
            obj = new android.graphics.BitmapFactory.Options();
            obj.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), i);
            if (((android.graphics.BitmapFactory.Options) (obj)).outHeight > j || ((android.graphics.BitmapFactory.Options) (obj)).outWidth > j)
            {
                k = (int)Math.pow(2D, (int)Math.ceil(Math.log((double)j / (double)Math.max(((android.graphics.BitmapFactory.Options) (obj)).outHeight, ((android.graphics.BitmapFactory.Options) (obj)).outWidth)) / Math.log(0.5D)));
            }
            (new android.graphics.BitmapFactory.Options()).inSampleSize = k;
            obj = BitmapFactory.decodeResource(context.getResources(), i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return null;
            }
        }
        finally { }
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return ((Bitmap) (obj));
        }
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw obj;
        }
    }

    public static Bitmap a(File file, int i)
    {
        Object obj;
        int j;
        j = 1;
        obj = null;
        FileInputStream fileinputstream;
        android.graphics.BitmapFactory.Options options;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        fileinputstream = new FileInputStream(file);
        try
        {
            BitmapFactory.decodeStream(fileinputstream, null, options);
            fileinputstream.close();
            if (options.outHeight > i || options.outWidth > i)
            {
                j = (int)Math.pow(2D, (int)Math.ceil(Math.log((double)i / (double)Math.max(options.outHeight, options.outWidth)) / Math.log(0.5D)));
            }
            options = new android.graphics.BitmapFactory.Options();
            options.inSampleSize = j;
            file = new FileInputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            file = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            continue; /* Loop/switch isn't completed */
        }
_L1:
        obj = BitmapFactory.decodeStream(file, null, options);
        file.close();
        Exception exception;
        Exception exception1;
        try
        {
            fileinputstream.close();
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return ((Bitmap) (obj));
        }
        return ((Bitmap) (obj));
        file;
        file = null;
        fileinputstream = null;
_L4:
        try
        {
            fileinputstream.close();
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file) { }
        return null;
        file;
        fileinputstream = null;
_L2:
        try
        {
            fileinputstream.close();
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception) { }
        throw file;
        exception1;
        obj = file;
        file = exception1;
        if (true) goto _L2; else goto _L1
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static AppLovinAdImpl a()
    {
        return (new AppLovinAdImpl.Builder()).setHtml("").setSize(AppLovinAdSize.BANNER).setType(AppLovinAdType.REGULAR).setVideoFilename("").setTarget(AppLovinAdImpl.AdTarget.DEFAULT).setCloseStyle(v.a).setVideoCloseDelay(0.0F).setPoststitialCloseDelay(0.0F).setCountdownLength(0).setCurrentAdIdNumber(-1L).setClCode("").build();
    }

    public static String a(String s)
    {
        if (s != null && s.length() > 4)
        {
            return s.substring(s.length() - 4);
        } else
        {
            return "NOKEY";
        }
    }

    public static String a(String s, AppLovinSdkImpl applovinsdkimpl)
    {
        return a(s, (Integer)applovinsdkimpl.a(br.s), (String)applovinsdkimpl.a(br.r));
    }

    private static String a(String s, Integer integer, String s1)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("No algorithm specified");
        }
        if (s != null && s.length() >= 1) goto _L2; else goto _L1
_L1:
        Object obj = "";
_L4:
        return ((String) (obj));
_L2:
        obj = s;
        if (s1.length() < 1) goto _L4; else goto _L3
_L3:
        obj = s;
        if ("none".equals(s1)) goto _L4; else goto _L5
_L5:
        try
        {
            obj = MessageDigest.getInstance(s1);
            ((MessageDigest) (obj)).update(s.getBytes("UTF-8"));
            s = a(((MessageDigest) (obj)).digest());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException((new StringBuilder()).append("Unknown algorithm \"").append(s1).append("\"").toString(), s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("Programming error: UTF-8 is not know encoding", s);
        }
        obj = s;
        if (s == null) goto _L4; else goto _L6
_L6:
        obj = s;
        if (integer.intValue() <= 0) goto _L4; else goto _L7
_L7:
        s = s.substring(0, Math.min(integer.intValue(), s.length()));
        return s;
    }

    static String a(Map map)
    {
        if (map == null || map.isEmpty())
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); stringbuilder.append(entry.getKey()).append('=').append(entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
        }

        return stringbuilder.toString();
    }

    public static String a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("No data specified");
        }
        char ac[] = new char[abyte0.length * 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            ac[i * 2] = a[(abyte0[i] & 0xf0) >>> 4];
            ac[i * 2 + 1] = a[abyte0[i] & 0xf];
        }

        return new String(ac);
    }

    public static boolean a(bt bt, AppLovinSdkImpl applovinsdkimpl)
    {
        return a(bt, applovinsdkimpl.getSettingsManager());
    }

    public static boolean a(bt bt, bu bu1)
    {
        long l = System.currentTimeMillis();
        float f = a(((Long)bu1.a(bt)).longValue());
        return (float)l > f;
    }

    public static long b(float f)
    {
        return (long)Math.round(f);
    }

    static String b(String s)
    {
        if (isValidString(s))
        {
            try
            {
                s = URLEncoder.encode(s, "UTF-8");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new UnsupportedOperationException(s);
            }
            return s;
        } else
        {
            return "";
        }
    }

    public static long c(float f)
    {
        return b(a(f));
    }

}
