// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import com.tremorvideo.sdk.android.richmedia.ae;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bf, ad, n

public class bm extends bf
{

    static String a = "embedPlayer_";
    boolean b;
    Context c;
    n d;
    int e;
    boolean f;
    String g;

    public bm(bf.a a1, Context context, n n1, Map map)
    {
        super(a1);
        b = false;
        e = -1;
        f = false;
        g = "";
        c = context;
        d = n1;
        e = ((Integer)map.get("hashName")).intValue();
    }

    private void a(String s, String s1)
    {
        s = new File((new StringBuilder()).append(s1).append(s).toString());
        if (!s.isDirectory())
        {
            s.mkdirs();
        }
    }

    public String a(String s)
    {
        Object obj;
        obj = new File(s);
        if (!((File) (obj)).exists())
        {
            break MISSING_BLOCK_LABEL_354;
        }
        Object obj1;
        s = new FileInputStream(((File) (obj)));
        obj = new ZipInputStream(new BufferedInputStream(s));
        obj1 = (new StringBuilder()).append(a).append(e).toString();
        obj1 = new File((new StringBuilder()).append(c.getFilesDir()).append("/").append(((String) (obj1))).toString());
        if (((File) (obj1)).exists())
        {
            ae.a(((File) (obj1)));
        }
        ((File) (obj1)).mkdir();
        obj1 = (new StringBuilder()).append(((File) (obj1)).getAbsolutePath()).append("/").toString();
_L5:
        Object obj3 = ((ZipInputStream) (obj)).getNextEntry();
        if (obj3 == null) goto _L2; else goto _L1
_L1:
        Object obj2 = ((ZipEntry) (obj3)).getName();
        if (!((ZipEntry) (obj3)).isDirectory()) goto _L4; else goto _L3
_L3:
        a(((String) (obj2)), ((String) (obj1)));
          goto _L5
        s;
        f = true;
        g = s.toString();
_L7:
        return null;
_L4:
        byte abyte0[];
        obj3 = new ByteArrayOutputStream();
        abyte0 = new byte[1024];
        File file = new File((new StringBuilder()).append(((String) (obj1))).append(((String) (obj2))).toString());
        if (!file.exists())
        {
            file.createNewFile();
        }
        obj2 = new FileOutputStream((new StringBuilder()).append(((String) (obj1))).append(((String) (obj2))).toString());
_L6:
        int i = ((ZipInputStream) (obj)).read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_327;
        }
        ((ByteArrayOutputStream) (obj3)).write(abyte0, 0, i);
        ((ByteArrayOutputStream) (obj3)).toByteArray();
        ((FileOutputStream) (obj2)).write(((ByteArrayOutputStream) (obj3)).toByteArray());
        ((ByteArrayOutputStream) (obj3)).reset();
          goto _L6
        ((FileOutputStream) (obj2)).close();
        ((ZipInputStream) (obj)).closeEntry();
        ((ByteArrayOutputStream) (obj3)).close();
          goto _L5
_L2:
        ((ZipInputStream) (obj)).close();
        s.close();
        return ((String) (obj1));
        ad.d((new StringBuilder()).append("Error Processing Embed player: Unable to find archive: ").append(s).toString());
        a(bf.b.c);
          goto _L7
    }

    protected void e()
    {
        h();
    }

    protected void f()
    {
        a(bf.b.e);
    }

    protected void g()
    {
        h();
    }

    public void h()
    {
        f = false;
        g = "";
        s.a a1 = d.h(e);
        if (a1 != null)
        {
            String s = a1.a();
            if (s != null)
            {
                s = a(s);
                if (s != null)
                {
                    a1.b(s);
                    ad.d((new StringBuilder()).append("Finished unzipping Embed player to ").append(s).toString());
                }
            }
        } else
        {
            f = true;
            g = (new StringBuilder()).append("Error Processing Embed player: Unable to find player info for: ").append(e).toString();
        }
        if (f)
        {
            ad.d(g);
            a(bf.b.c);
            return;
        } else
        {
            a(bf.b.b);
            return;
        }
    }

    public String toString()
    {
        return "JobProcessEmbedPlayer";
    }

}
