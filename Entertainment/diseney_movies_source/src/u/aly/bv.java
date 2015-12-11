// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package u.aly:
//            bj

public class bv
{

    public static final String a = System.getProperty("line.separator");
    private static final String b = "helper";

    public bv()
    {
    }

    public static String a()
    {
        return a(new Date());
    }

    public static String a(Context context, long l)
    {
        if (l < 1000L)
        {
            return (new StringBuilder(String.valueOf((int)l))).append("B").toString();
        }
        if (l < 0xf4240L)
        {
            return (new StringBuilder(String.valueOf(Math.round((double)(float)l / 1000D)))).append("K").toString();
        }
        if (l < 0x3b9aca00L)
        {
            return (new StringBuilder(String.valueOf((new DecimalFormat("#0.0")).format((double)(float)l / 1000000D)))).append("M").toString();
        } else
        {
            return (new StringBuilder(String.valueOf((new DecimalFormat("#0.00")).format((double)(float)l / 1000000000D)))).append("G").toString();
        }
    }

    public static String a(File file)
    {
        byte abyte0[] = new byte[1024];
        MessageDigest messagedigest;
        int i;
        boolean flag;
        try
        {
            flag = file.isFile();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            file.printStackTrace();
            return null;
        }
        if (!flag)
        {
            return "";
        }
        messagedigest = MessageDigest.getInstance("MD5");
        file = new FileInputStream(file);
_L1:
        i = file.read(abyte0, 0, 1024);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        file.close();
        return String.format("%1$032x", new Object[] {
            new BigInteger(1, messagedigest.digest())
        });
        messagedigest.update(abyte0, 0, i);
          goto _L1
    }

    public static String a(InputStream inputstream)
        throws IOException
    {
        inputstream = new InputStreamReader(inputstream);
        char ac[] = new char[1024];
        StringWriter stringwriter = new StringWriter();
        do
        {
            int i = inputstream.read(ac);
            if (-1 == i)
            {
                return stringwriter.toString();
            }
            stringwriter.write(ac, 0, i);
        } while (true);
    }

    public static String a(String s)
    {
        int i;
        i = 0;
        if (s == null)
        {
            return null;
        }
        byte abyte0[];
        Object obj;
        abyte0 = s.getBytes();
        obj = MessageDigest.getInstance("MD5");
        ((MessageDigest) (obj)).reset();
        ((MessageDigest) (obj)).update(abyte0);
        abyte0 = ((MessageDigest) (obj)).digest();
        obj = new StringBuffer();
_L1:
        if (i >= abyte0.length)
        {
            return ((StringBuffer) (obj)).toString();
        }
        ((StringBuffer) (obj)).append(String.format("%02X", new Object[] {
            Byte.valueOf(abyte0[i])
        }));
        i++;
          goto _L1
        Exception exception;
        exception;
        return s.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
    }

    public static String a(Date date)
    {
        if (date == null)
        {
            return "";
        } else
        {
            return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)).format(date);
        }
    }

    public static void a(Context context, String s)
    {
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(s));
    }

    public static void a(File file, String s)
        throws IOException
    {
        a(file, s.getBytes());
    }

    public static void a(File file, byte abyte0[])
        throws IOException
    {
        file = new FileOutputStream(file);
        file.write(abyte0);
        file.flush();
        a(((OutputStream) (file)));
        return;
        abyte0;
        a(((OutputStream) (file)));
        throw abyte0;
    }

    public static void a(OutputStream outputstream)
    {
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        outputstream.close();
        return;
        outputstream;
    }

    public static String b(String s)
    {
        Object obj;
        int i;
        try
        {
            obj = MessageDigest.getInstance("MD5");
            ((MessageDigest) (obj)).update(s.getBytes());
            s = ((MessageDigest) (obj)).digest();
            obj = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            bj.a("helper", "getMD5 error", s);
            return "";
        }
        i = 0;
        if (i >= s.length)
        {
            return ((StringBuffer) (obj)).toString();
        }
        ((StringBuffer) (obj)).append(Integer.toHexString(s[i] & 0xff));
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_29;
        }
    }

    public static boolean b(Context context, String s)
    {
        try
        {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return true;
    }

    public static byte[] b(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (-1 == i)
            {
                return bytearrayoutputstream.toByteArray();
            }
            bytearrayoutputstream.write(abyte0, 0, i);
        } while (true);
    }

    public static String c(String s)
    {
        long l;
        try
        {
            l = Long.valueOf(s).longValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            return s;
        }
        if (l < 1024L)
        {
            return (new StringBuilder(String.valueOf((int)l))).append("B").toString();
        }
        if (l < 0x100000L)
        {
            return (new StringBuilder(String.valueOf((new DecimalFormat("#0.00")).format((double)(float)l / 1024D)))).append("K").toString();
        }
        if (l < 0x40000000L)
        {
            return (new StringBuilder(String.valueOf((new DecimalFormat("#0.00")).format((double)(float)l / 1048576D)))).append("M").toString();
        } else
        {
            return (new StringBuilder(String.valueOf((new DecimalFormat("#0.00")).format((double)(float)l / 1073741824D)))).append("G").toString();
        }
    }

    public static void c(InputStream inputstream)
    {
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        inputstream.close();
        return;
        inputstream;
    }

    public static boolean d(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean e(String s)
    {
        if (!d(s))
        {
            if ((s = s.trim().toLowerCase(Locale.US)).startsWith("http://") || s.startsWith("https://"))
            {
                return true;
            }
        }
        return false;
    }

}
