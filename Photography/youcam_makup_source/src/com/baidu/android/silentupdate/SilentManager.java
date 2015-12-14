// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.silentupdate;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Process;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONObject;

// Referenced classes of package com.baidu.android.silentupdate:
//            b, a

public class SilentManager
{

    private static final String a = com/baidu/android/silentupdate/SilentManager.getSimpleName();
    private static final String b = "push_lib";
    private static final String c = "push_dex";
    private static final String d = "push_update";
    private static String e = null;
    private static boolean f = false;
    private static boolean g = true;

    public SilentManager()
    {
    }

    private static String a(File file)
    {
        byte abyte0[];
        if (!file.isFile() || !file.exists())
        {
            return null;
        }
        abyte0 = new byte[1024];
        MessageDigest messagedigest;
        messagedigest = MessageDigest.getInstance("MD5");
        file = new FileInputStream(file);
_L1:
        int i = file.read(abyte0, 0, 1024);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                messagedigest.update(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return null;
            }
        }
          goto _L1
        file.close();
        return a(messagedigest.digest()).toLowerCase();
    }

    private static String a(String s)
    {
        int i;
        for (i = s.lastIndexOf("."); s.lastIndexOf("/") > i || i <= 0 || i >= s.length();)
        {
            return s;
        }

        return s.substring(0, i);
    }

    private static String a(byte abyte0[])
    {
        String s = "";
        int i = 0;
        while (i < abyte0.length) 
        {
            String s1 = Integer.toHexString(abyte0[i] & 0xff);
            if (s1.length() == 1)
            {
                s = (new StringBuilder()).append(s).append("0").append(s1).toString();
            } else
            {
                s = (new StringBuilder()).append(s).append(s1).toString();
            }
            i++;
        }
        return s;
    }

    private static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    private static void a(InputStream inputstream, OutputStream outputstream)
    {
        Object obj;
        obj = inputstream;
        if (!(inputstream instanceof BufferedInputStream))
        {
            obj = new BufferedInputStream(inputstream);
        }
        inputstream = outputstream;
        if (!(outputstream instanceof BufferedOutputStream))
        {
            inputstream = new BufferedOutputStream(outputstream);
        }
        outputstream = new byte[512];
_L1:
        int i = ((InputStream) (obj)).read(outputstream);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        inputstream.flush();
        a(((Closeable) (obj)));
        a(((Closeable) (inputstream)));
        return;
        inputstream.write(outputstream, 0, i);
          goto _L1
        outputstream;
        a(((Closeable) (obj)));
        a(((Closeable) (inputstream)));
        throw outputstream;
    }

    private static boolean a(Context context, File file, File file1, String s, String s1, String s2)
    {
        if (g) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        Object obj;
        Object obj1;
        String s3;
        s3 = "";
        obj = s3;
        obj1 = s3;
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        file = s3;
_L4:
        obj = file;
        obj1 = file;
        s3 = bufferedreader.readLine();
        obj = file;
        if (s3 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = file;
        obj1 = file;
        try
        {
            file = (new StringBuilder()).append(file).append(s3).append("\r\n").toString();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            obj = obj1;
        }
        // Misplaced declaration of an exception variable
        catch (File file) { }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        file = new JSONObject(decrypt(s, ((String) (obj))));
        s1 = new BufferedReader(new InputStreamReader(context.getAssets().open((new StringBuilder()).append(s1).append("/").append(a(s2)).append(".key").toString())));
        context = "";
_L6:
        s2 = s1.readLine();
        if (s2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        context = (new StringBuilder()).append(context).append(s2).append("\r\n").toString();
        if (true) goto _L6; else goto _L5
_L5:
        context = new JSONObject(decrypt(s, context));
        if (!context.getString("flag").equals(file.getString("flag")))
        {
            if (f)
            {
                Log.d(a, "Flag not equal!");
            }
            break MISSING_BLOCK_LABEL_395;
        }
        if (context.getLong("timestamp") > file.getLong("timestamp"))
        {
            if (f)
            {
                Log.d(a, "APK newer than dex!");
            }
            break MISSING_BLOCK_LABEL_397;
        }
        context = a(file1);
        if (f)
        {
            Log.d(a, (new StringBuilder()).append("Lib MD5 : ").append(context).toString());
        }
        if (!file.getString("md5").equals(context))
        {
            if (f)
            {
                Log.d(a, "RSA check fail");
            }
            break MISSING_BLOCK_LABEL_399;
        }
        if (!f) goto _L1; else goto _L7
_L7:
        Log.d(a, "RSA check ok");
        return true;
        return false;
        return false;
        return false;
    }

    private static boolean a(Context context, String s, String s1, String s2, String s3)
    {
        Date date;
        File file;
        String s4;
        File file1;
        if (e == null)
        {
            throw new RuntimeException("public key must init first!");
        }
        if (s1 == null)
        {
            throw new RuntimeException("Lib Name Must Not Null!");
        }
        date = new Date();
        if (s == null)
        {
            s = "";
        }
        file = new File((new StringBuilder()).append(context.getDir("push_lib", 0).getAbsolutePath()).append("/").append(s1).toString());
        s4 = (new StringBuilder()).append(a(s1)).append(".key").toString();
        file1 = new File((new StringBuilder()).append(context.getDir("push_lib", 0).getAbsolutePath()).append("/").append(s4).toString());
        if (s3 != null)
        {
            File file2 = new File((new StringBuilder()).append(s3).append("/").append(s1).toString());
            s3 = new File((new StringBuilder()).append(s3).append("/").append(s4).toString());
            if (file2.exists() && s3.exists())
            {
                int i = Process.myPid();
                Iterator iterator = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
                    if (runningappprocessinfo.pid == i && runningappprocessinfo.processName.endsWith(context.getPackageName()))
                    {
                        if (f)
                        {
                            Log.d(a, "Found update");
                        }
                        file2.renameTo(file);
                        s3.renameTo(file1);
                    }
                } while (true);
            }
        }
        if (file.exists() && file1.exists() && a(context, file1, file, e, s, s1)) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (f)
        {
            Log.d(a, "Need copy lib from assert");
        }
        try
        {
            a(context.getAssets().open((new StringBuilder()).append(s).append("/").append(s1).toString()), ((OutputStream) (new FileOutputStream(file))));
            a(context.getAssets().open((new StringBuilder()).append(s).append("/").append(s4).toString()), ((OutputStream) (new FileOutputStream(file1))));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            if (f)
            {
                Log.e(a, "Copy from assert fail!");
            }
            return false;
        }
_L9:
        s = com.baidu.android.silentupdate.b.a(file.getAbsolutePath(), context.getDir("push_dex", 0).getAbsolutePath(), s2, context);
        if (s != null) goto _L4; else goto _L3
_L3:
        if (f)
        {
            Log.e(a, "Create classloader fail");
        }
        flag = false;
_L6:
        return flag;
_L2:
        if (f)
        {
            Log.d(a, "Lib file check ok");
        }
        continue; /* Loop/switch isn't completed */
_L4:
        boolean flag1;
        flag1 = com.baidu.android.silentupdate.b.a(s, context.getClassLoader());
        if (!flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (f)
        {
            Log.d(a, (new StringBuilder()).append("Load lib ok, cost ").append((new Date()).getTime() - date.getTime()).append("ms").toString());
            return flag1;
        }
        if (true) goto _L6; else goto _L5
_L5:
        flag = flag1;
        if (!f) goto _L6; else goto _L7
_L7:
        Log.e(a, "Insert classloader fail");
        return flag1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static String decrypt(String s, String s1)
    {
        s = new X509EncodedKeySpec(com.baidu.android.silentupdate.a.a(s.getBytes()));
        s = KeyFactory.getInstance("RSA").generatePublic(s);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, s);
        s = cipher.doFinal(com.baidu.android.silentupdate.a.a(s1.getBytes()));
        s1 = new String(s, "UTF8");
        if (f)
        {
            Log.d(a, (new StringBuilder()).append("RSA decrypt:").append(s1).toString());
        }
        s = new String(s, "UTF8");
        return s;
        s;
_L2:
        if (f)
        {
            Log.d(a, "RSA decrypt fail");
        }
        return null;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        continue; /* Loop/switch isn't completed */
        s;
        continue; /* Loop/switch isn't completed */
        s;
        continue; /* Loop/switch isn't completed */
        s;
        continue; /* Loop/switch isn't completed */
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void enableDebugMode(boolean flag)
    {
        f = flag;
    }

    public static void enableRSA(boolean flag)
    {
        g = flag;
    }

    public static String getKey()
    {
        return e;
    }

    public static boolean loadLib(Context context, String s, String s1)
    {
        return loadLib(context, s, s1, (new StringBuilder()).append("/data/data/").append(context.getPackageName()).append("/lib").toString());
    }

    public static boolean loadLib(Context context, String s, String s1, String s2)
    {
        return a(context, s, s1, s2, context.getDir("push_update", 0).getAbsolutePath());
    }

    public static void setKey(String s)
    {
        e = s;
    }

}
