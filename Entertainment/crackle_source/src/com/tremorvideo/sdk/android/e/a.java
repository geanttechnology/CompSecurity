// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import com.tremorvideo.sdk.android.richmedia.ae;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.ax;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class a
{

    public String a;
    private ax b;
    private Context c;
    private boolean d;
    private boolean e;

    public a(Context context)
    {
        d = false;
        e = false;
        c = context;
        if (c.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", c.getApplicationContext().getPackageName()) == 0)
        {
            e = true;
        } else
        {
            e = false;
        }
        context = Environment.getExternalStorageDirectory();
        a = (new StringBuilder()).append(context.getAbsolutePath()).append("/tremor/mraid/").toString();
        context = new File(a);
        if (!context.exists())
        {
            context.mkdirs();
        }
    }

    private void a(File file)
    {
        if (file.isDirectory())
        {
            file = file.listFiles();
            int j = file.length;
            for (int i = 0; i < j; i++)
            {
                a(file[i]);
            }

        } else
        {
            file.delete();
        }
    }

    private void a(String s, String s1)
    {
        s = new File((new StringBuilder()).append(s1).append(s).toString());
        if (!s.isDirectory())
        {
            s.mkdirs();
        }
    }

    private String d(String s)
    {
        String s1;
        FileInputStream fileinputstream;
        ZipInputStream zipinputstream;
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            d = true;
        } else
        {
            d = false;
        }
        if (!d || !e) goto _L2; else goto _L1
_L1:
        ZipEntry zipentry;
        try
        {
            fileinputstream = new FileInputStream(s);
            zipinputstream = new ZipInputStream(new BufferedInputStream(fileinputstream));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ad.a(s);
            d = false;
            return null;
        }
        s = null;
_L8:
        zipentry = zipinputstream.getNextEntry();
        if (zipentry == null)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        s1 = zipentry.getName();
        if (!s1.equals("main.js")) goto _L4; else goto _L3
_L3:
        s = "main.html";
_L6:
        if (!zipentry.isDirectory())
        {
            break MISSING_BLOCK_LABEL_141;
        }
        a(s1, a);
        break MISSING_BLOCK_LABEL_60;
_L4:
        if (s1.equals("main.html"))
        {
            s = "main.html";
        }
        if (true) goto _L6; else goto _L5
_L5:
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        StringBuilder stringbuilder;
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = new byte[1024];
        stringbuilder = (new StringBuilder()).append(a);
        Object obj = s1;
        if (s1.equals("main.js"))
        {
            obj = "main.html";
        }
        obj = new FileOutputStream(stringbuilder.append(((String) (obj))).toString());
_L7:
        int i = zipinputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        bytearrayoutputstream.write(abyte0, 0, i);
        bytearrayoutputstream.toByteArray();
        ((FileOutputStream) (obj)).write(bytearrayoutputstream.toByteArray());
        bytearrayoutputstream.reset();
          goto _L7
        ((FileOutputStream) (obj)).close();
        zipinputstream.closeEntry();
        bytearrayoutputstream.close();
          goto _L8
        zipinputstream.close();
        fileinputstream.close();
_L10:
        return s;
_L2:
        s = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public String a(String s)
    {
        return d(s);
    }

    public void a()
    {
        a(new File(a));
    }

    public void a(ax ax)
    {
        b = ax;
    }

    public String b(String s)
    {
        String s1;
        Object obj;
        Object obj1;
        obj = s.substring(s.lastIndexOf("/") + 1);
        s1 = ((String) (obj));
        if (((String) (obj)).endsWith(".js"))
        {
            s1 = ((String) (obj)).replace(".js", ".html");
        }
        obj1 = new File((new StringBuilder()).append(a).append(s1).toString());
        if (((File) (obj1)).exists())
        {
            ((File) (obj1)).delete();
        }
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        byte abyte0[];
        int i;
        try
        {
            obj = new ByteArrayOutputStream();
            obj1 = new FileOutputStream(((File) (obj1)));
            HttpGet httpget = new HttpGet(s);
            ae.a(httpget, s);
            s = defaulthttpclient.execute(httpget).getEntity();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ad.a(s);
            return s1;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        s = s.getContent();
        abyte0 = new byte[4096];
_L1:
        i = s.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        ((ByteArrayOutputStream) (obj)).write(abyte0, 0, i);
        ((ByteArrayOutputStream) (obj)).toByteArray();
        ((FileOutputStream) (obj1)).write(((ByteArrayOutputStream) (obj)).toByteArray());
        ((ByteArrayOutputStream) (obj)).reset();
          goto _L1
        ((FileOutputStream) (obj1)).close();
        ((ByteArrayOutputStream) (obj)).close();
        return s1;
    }

    public boolean b()
    {
        return d && e;
    }

    public void c()
    {
    }

    public void c(String s)
    {
        d(s);
    }
}
