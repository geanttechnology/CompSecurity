// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package jumiomobile:
//            ab, ct

public abstract class cs
{

    protected static StringBuilder a = null;
    protected static File b;
    protected static String c;

    public static File a(Context context, String s)
    {
        context = null;
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            s = new File(Environment.getExternalStorageDirectory(), (new StringBuilder("/Debug/")).append(s).toString());
            context = s;
            if (!s.isDirectory())
            {
                s.mkdirs();
                context = s;
            }
        }
        return context;
    }

    public static void a(Context context, Bitmap bitmap, File file, String s, android.graphics.Bitmap.CompressFormat compressformat, int i)
    {
        context = new ByteArrayOutputStream();
        bitmap.compress(compressformat, i, context);
        a(context.toByteArray(), file, s, false);
    }

    public static void a(File file, String s)
    {
        b = file;
        c = s;
        e();
    }

    public static void a(String s)
    {
label0:
        {
            if (a())
            {
                SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
                if (s.equals("\r\n"))
                {
                    d().append(s);
                } else
                {
                    d().append(simpledateformat.format(new Date())).append(s).append("\r\n");
                }
                Log.d("JumioMobileSdk", s);
                if (b() == null || c() == null)
                {
                    break label0;
                }
                a(d().toString(), b(), c(), true);
                e();
            }
            return;
        }
        Log.w("JumioMobileSdk", "Log file not initialized! call Debug.setFile()!");
    }

    public static void a(String s, File file, String s1)
    {
        a(s.getBytes(), file, s1, false);
    }

    public static void a(String s, File file, String s1, boolean flag)
    {
        a(s.getBytes(), file, s1, flag);
    }

    public static void a(StringBuilder stringbuilder, Exception exception)
    {
        if (stringbuilder == null || exception == null)
        {
            return;
        } else
        {
            StringWriter stringwriter = new StringWriter();
            exception.printStackTrace(new PrintWriter(stringwriter));
            stringbuilder.append(stringwriter.toString()).append("\r\n");
            return;
        }
    }

    public static void a(StringBuilder stringbuilder, String s, long l)
    {
        if (stringbuilder != null)
        {
            stringbuilder.append(s).append(l).append("\r\n");
        }
    }

    public static void a(StringBuilder stringbuilder, String s, String s1)
    {
        if (stringbuilder != null)
        {
            stringbuilder.append(s).append(s1).append("\r\n");
        }
    }

    public static void a(StringBuilder stringbuilder, String s, Date date)
    {
        if (stringbuilder != null)
        {
            stringbuilder.append(s).append(date).append("\r\n");
        }
    }

    public static void a(byte abyte0[], File file, String s)
    {
        a(abyte0, file, s, false);
    }

    public static void a(byte abyte0[], File file, String s, boolean flag)
    {
        if (!a())
        {
            return;
        }
        file = new File(file, s);
        if (!file.exists())
        {
            file.createNewFile();
        }
        file = new FileOutputStream(file, flag);
        file.write(abyte0);
        try
        {
            file.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            ab.a(abyte0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            ab.a(abyte0);
        }
        break MISSING_BLOCK_LABEL_67;
        abyte0;
        file.close();
        throw abyte0;
    }

    public static final boolean a()
    {
        return ct.a();
    }

    protected static File b()
    {
        return b;
    }

    protected static String c()
    {
        return c;
    }

    public static StringBuilder d()
    {
        if (a == null)
        {
            a = new StringBuilder();
        }
        return a;
    }

    public static void e()
    {
        if (a != null)
        {
            a.delete(0, a.length());
            a = null;
        }
    }

}
