// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.b;

import android.content.Context;
import com.tremorvideo.sdk.android.richmedia.ae;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.aw;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
{

    public String a;
    public String b;
    protected int c;
    private File d;
    private String e;
    private String f;
    private long g;
    private int h;
    private List i;
    private File j;

    public c(JSONObject jsonobject, com.tremorvideo.sdk.android.videoad.s.b b1)
        throws Exception
    {
        Object obj;
        String s;
        a = "";
        b = "";
        c = 1;
        e = jsonobject.getString("tms-xml-url");
        if (e.contains("http://data.tmsapi.com/v1/"))
        {
            c = 2;
        }
        if (b1 != null && b1.d != null && b1.d.length() > 0)
        {
            a = b1.d;
        }
        b1 = new Date();
        obj = b1;
        if (!jsonobject.has("movie-date"))
        {
            break MISSING_BLOCK_LABEL_154;
        }
        s = jsonobject.getString("movie-date");
        obj = b1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        obj = b1;
        if (s.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        boolean flag;
        obj = (new SimpleDateFormat("yyyy-MM-dd")).parse(s);
        flag = ((Date) (obj)).after(b1);
        if (flag)
        {
            b1 = ((com.tremorvideo.sdk.android.videoad.s.b) (obj));
        }
        obj = b1;
_L1:
        if (c == 2)
        {
            b = (new SimpleDateFormat("yyyy-MM-dd")).format(((Date) (obj)));
        } else
        {
            b = (new SimpleDateFormat("yyyyMMdd")).format(((Date) (obj)));
        }
        f = jsonobject.getString("template-url");
        if (jsonobject.has("template-crc32"))
        {
            g = jsonobject.getLong("template-crc32");
        } else
        {
            g = 0L;
        }
        if (jsonobject.has("auto-skip-seconds"))
        {
            h = jsonobject.getInt("auto-skip-seconds") * 1000;
        } else
        {
            h = 0;
        }
        if (!jsonobject.has("events"))
        {
            i = new ArrayList();
        } else
        {
            jsonobject = jsonobject.getJSONArray("events");
            i = new ArrayList(jsonobject.length());
            int k = 0;
            while (k < jsonobject.length()) 
            {
                i.add(new aw(jsonobject.getJSONObject(k)));
                k++;
            }
        }
        return;
        obj;
        ad.d((new StringBuilder()).append("Invalid TMS date: ").append(s).toString());
        obj = b1;
          goto _L1
    }

    private void a(String s, String s1)
    {
        s = new File((new StringBuilder()).append(s1).append(s).toString());
        if (!s.isDirectory())
        {
            s.mkdirs();
        }
    }

    public int a()
    {
        return h;
    }

    public aw a(com.tremorvideo.sdk.android.videoad.aw.b b1)
    {
        for (Iterator iterator = i.iterator(); iterator.hasNext();)
        {
            aw aw1 = (aw)iterator.next();
            if (aw1.a() == b1)
            {
                return aw1;
            }
        }

        return null;
    }

    public void a(Context context)
    {
        FileInputStream fileinputstream;
        ZipInputStream zipinputstream;
        fileinputstream = new FileInputStream(j);
        zipinputstream = new ZipInputStream(new BufferedInputStream(fileinputstream));
        d = new File((new StringBuilder()).append(context.getFilesDir()).append("/").append("MovieBoard").toString());
        if (d.exists())
        {
            ae.a(d);
        }
        d.mkdir();
        context = (new StringBuilder()).append(d.getAbsolutePath()).append("/").toString();
_L1:
        Object obj1 = zipinputstream.getNextEntry();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_310;
        }
        Object obj;
label0:
        {
            obj = ((ZipEntry) (obj1)).getName();
            if (!((ZipEntry) (obj1)).isDirectory())
            {
                break label0;
            }
            a(((String) (obj)), ((String) (context)));
        }
          goto _L1
        byte abyte0[];
        obj1 = new ByteArrayOutputStream();
        abyte0 = new byte[1024];
        File file = new File((new StringBuilder()).append(context).append(((String) (obj))).toString());
        if (!file.exists())
        {
            file.createNewFile();
        }
        obj = new FileOutputStream((new StringBuilder()).append(context).append(((String) (obj))).toString());
_L2:
        int k = zipinputstream.read(abyte0);
label1:
        {
            if (k == -1)
            {
                break label1;
            }
            try
            {
                ((ByteArrayOutputStream) (obj1)).write(abyte0, 0, k);
                ((ByteArrayOutputStream) (obj1)).toByteArray();
                ((FileOutputStream) (obj)).write(((ByteArrayOutputStream) (obj1)).toByteArray());
                ((ByteArrayOutputStream) (obj1)).reset();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ad.a(context);
                return;
            }
        }
          goto _L2
        ((FileOutputStream) (obj)).close();
        zipinputstream.closeEntry();
        ((ByteArrayOutputStream) (obj1)).close();
          goto _L1
        zipinputstream.close();
        fileinputstream.close();
        return;
    }

    public void a(File file)
    {
        j = file;
    }

    public String b()
    {
        return e;
    }

    public String c()
    {
        return f;
    }

    public Long d()
    {
        return Long.valueOf(g);
    }

    public void e()
    {
        if ("MovieBoard" != null)
        {
            ae.a(d);
        }
    }

    public File f()
    {
        return d;
    }
}
