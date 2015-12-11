// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.smule.android.c.aa;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class n
{

    static final String a = com/smule/android/f/n.getName();
    private static String b = null;

    public n()
    {
    }

    public static File a(Context context, String s)
    {
        for (File file = new File(context.getFilesDir(), s); file.exists() || a(context, s, file);)
        {
            return file;
        }

        aa.b(a, (new StringBuilder()).append("Couldn't extract asset: ").append(s).toString());
        return null;
    }

    public static String a(Context context)
    {
        return context.getFilesDir().getAbsolutePath();
    }

    public static String a(Context context, int i)
    {
        Object obj;
        char ac[];
        context = context.getResources().openRawResource(i);
        obj = new StringWriter();
        ac = new char[1024];
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(context, "UTF-8"));
_L1:
        i = bufferedreader.read(ac);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        ((Writer) (obj)).write(ac, 0, i);
          goto _L1
        obj;
        context.close();
        throw obj;
        context.close();
        return obj.toString();
    }

    public static void a(InputStream inputstream, File file, boolean flag)
    {
        byte abyte0[] = new byte[2048];
        BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream, 2048);
        if (flag || !file.exists())
        {
            file.getParentFile().mkdirs();
            file = new BufferedOutputStream(new FileOutputStream(file), 2048);
            do
            {
                int i = bufferedinputstream.read(abyte0, 0, 2048);
                if (i <= 0)
                {
                    break;
                }
                file.write(abyte0, 0, i);
            } while (true);
            file.flush();
            file.close();
        }
        inputstream.close();
    }

    public static boolean a(Context context, String s, File file)
    {
        context = context.getAssets();
        try
        {
            a(context.open(s), file, true);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    public static String b(Context context)
    {
        if (b != null)
        {
            aa.e(a, (new StringBuilder()).append("Returning external directory for cache: ").append(b).toString());
            return b;
        } else
        {
            return context.getFilesDir().getAbsolutePath();
        }
    }

}
