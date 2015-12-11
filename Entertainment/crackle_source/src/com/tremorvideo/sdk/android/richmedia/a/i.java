// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tremorvideo.sdk.android.richmedia.a;
import com.tremorvideo.sdk.android.richmedia.ae;
import com.tremorvideo.sdk.android.richmedia.b;
import com.tremorvideo.sdk.android.richmedia.e;
import com.tremorvideo.sdk.android.richmedia.j;
import com.tremorvideo.sdk.android.richmedia.k;
import com.tremorvideo.sdk.android.richmedia.m;
import com.tremorvideo.sdk.android.richmedia.o;
import com.tremorvideo.sdk.android.richmedia.p;
import com.tremorvideo.sdk.android.richmedia.q;
import com.tremorvideo.sdk.android.videoad.ad;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONObject;

public class i extends q
{
    protected class a extends j
    {

        public float a;
        public int b;
        public float c;
        public int d;
        public float e;
        public int f;
        public float g;
        public int h;
        public float i;
        public int j;
        public boolean k;
        final i l;

        public void a(e e1)
        {
            super.a(e1);
            try
            {
                a = e1.d();
                b = e1.b();
                c = e1.d();
                d = e1.b();
                e = e1.d();
                f = e1.b();
                g = e1.d();
                h = e1.b();
                i = e1.d();
                j = e1.b();
                k = e1.f();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (e e1)
            {
                return;
            }
        }

        protected a()
        {
            l = i.this;
            super();
        }
    }


    private android.widget.RelativeLayout.LayoutParams o;
    private boolean p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;

    public i(o o1)
    {
        super(o1);
        p = true;
        q = "";
        r = "";
        s = "";
        t = "";
        u = "";
    }

    private void a(File file)
    {
        while (file.exists() || file.mkdirs()) 
        {
            return;
        }
        throw new RuntimeException((new StringBuilder()).append("Can not create dir ").append(file).toString());
    }

    private void a(ZipFile zipfile, ZipEntry zipentry, String s1, boolean flag)
        throws IOException
    {
        if (!zipentry.isDirectory()) goto _L2; else goto _L1
_L1:
        a(new File(s1, zipentry.getName()));
_L4:
        return;
_L2:
        s1 = new File(s1, zipentry.getName());
        if (!flag && s1.exists()) goto _L4; else goto _L3
_L3:
        if (!s1.getParentFile().exists())
        {
            a(s1.getParentFile());
        }
        ad.d((new StringBuilder()).append("GenericObjec extracting: ").append(zipentry).toString());
        zipfile = new BufferedInputStream(zipfile.getInputStream(zipentry));
        zipentry = new BufferedOutputStream(new FileOutputStream(s1));
        s1 = new byte[1024];
_L5:
        int j = zipfile.read(s1);
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        zipentry.write(s1, 0, j);
          goto _L5
        s1;
        ad.a(s1);
        zipentry.close();
        zipfile.close();
        return;
        zipentry.close();
        zipfile.close();
        return;
        s1;
        zipentry.close();
        zipfile.close();
        throw s1;
    }

    private void b(File file)
    {
        if (file.exists())
        {
            return;
        }
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int l = afile.length;
            for (int j = 0; j < l; j++)
            {
                b(afile[j]);
            }

        }
        file.delete();
    }

    public void a()
    {
    }

    public void a(e e1)
    {
        super.a(e1);
        try
        {
            e1 = e1.c();
            if (e1.length() > 0)
            {
                e1 = new JSONObject(e1);
                if (e1.has("zip_path") && e1.has("index_file"))
                {
                    q = (new StringBuilder()).append(e1.getString("zip_path")).append(e1.getString("index_file")).toString();
                    r = q.substring(0, q.indexOf("/") + 1);
                    g.f().a(r);
                }
                if (e1.has("params"))
                {
                    u = e1.getString("params");
                }
            }
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            ad.a(e1);
        }
        h = false;
        i = false;
    }

    public void a(m m, long l)
    {
    }

    public void a(p p1, int j)
    {
        Object obj = b(p1, 0L);
        int l = Math.round(p1.d() / 2.0F + ((k) (obj)).a + a);
        int i1 = Math.round(((k) (obj)).b + b + p1.e() / 2.0F);
        p1 = new android.widget.RelativeLayout.LayoutParams(Math.round(((k) (obj)).f), Math.round(((k) (obj)).g));
        p1.leftMargin = l;
        p1.topMargin = i1;
        obj = (new StringBuilder()).append("file://").append(t).append("/").append(q).toString();
        ad.d((new StringBuilder()).append("localWebURL=").append(((String) (obj))).toString());
        ad.d((new StringBuilder()).append("_pageParams=").append(u).toString());
        g.f().a(((String) (obj)), u, j);
        g.f().a(p1, j);
        o = p1;
    }

    public void a(p p1, long l)
    {
        com.tremorvideo.sdk.android.richmedia.q.a a3;
        if (n())
        {
            if ((a3 = a(l)) != null)
            {
                a a1 = (a)a3.a;
                a a2 = (a)a3.b;
                float f = a3.c;
                k = a1.k;
                if (a1.k)
                {
                    k k1 = b(p1, l);
                    int j = Math.round(p1.d() / 2.0F + k1.a + a);
                    int i1 = Math.round(k1.b + b + p1.e() / 2.0F);
                    p1 = new android.widget.RelativeLayout.LayoutParams(Math.round(k1.f), Math.round(k1.g));
                    p1.leftMargin = j;
                    p1.topMargin = i1;
                    p = true;
                    g.f().a(p1, h());
                    o = p1;
                    j = ae.a(a1.i, a2.i, a1.j, a2.j, f);
                    g.f().a(j, h());
                    return;
                }
                if (p)
                {
                    g.f().c(h());
                }
                p = false;
                return;
            }
        }
    }

    public void a(ZipFile zipfile)
    {
        t = zipfile.getName();
        if (t.contains(".zip"))
        {
            t = t.replace(".zip", "");
        }
        try
        {
            Enumeration enumeration = zipfile.entries();
            do
            {
                if (!enumeration.hasMoreElements())
                {
                    break;
                }
                ZipEntry zipentry = (ZipEntry)enumeration.nextElement();
                if (zipentry.getName().startsWith(r))
                {
                    a(zipfile, zipentry, t, true);
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (ZipFile zipfile)
        {
            ad.a(zipfile);
        }
    }

    public k b(p p1, long l)
    {
        Object obj = a(l);
        if (obj != null)
        {
            a a1 = (a)((com.tremorvideo.sdk.android.richmedia.q.a) (obj)).a;
            a a2 = (a)((com.tremorvideo.sdk.android.richmedia.q.a) (obj)).b;
            float f3 = ((com.tremorvideo.sdk.android.richmedia.q.a) (obj)).c;
            float f = ae.b(a1.a, a2.a, a1.b, a2.b, f3);
            float f1 = ae.b(a1.c, a2.c, a1.d, a2.d, f3);
            float f2 = ae.b(a1.e, a2.e, a1.f, a2.f, f3);
            f3 = ae.b(a1.g, a2.g, a1.h, a2.h, f3);
            obj = com.tremorvideo.sdk.android.richmedia.b.a(f2, f3, c.c());
            p1.a(f - ((PointF) (obj)).x, f1 - ((PointF) (obj)).y, f2, f3, this.l, c.c());
            f3 = p1.h();
            f2 = p1.i();
            float f4 = p1.j();
            float f5 = p1.k();
            f1 = f2;
            f = f3;
            if (c.a() != null)
            {
                Object obj1 = c.a().c(p1, l);
                f = ((k) (obj1)).a;
                f1 = ((k) (obj1)).b;
                obj1 = com.tremorvideo.sdk.android.richmedia.b.a(Math.round(((k) (obj1)).f), Math.round(((k) (obj1)).g), c.b());
                f = f3 + f + (float)((Point) (obj1)).x;
                f1 = f2 + f1 + (float)((Point) (obj1)).y;
            }
            p1 = a(p1, l, new RectF(f, f1, f4 + f, f5 + f1));
            return new k(((RectF) (p1)).left, ((RectF) (p1)).top, ((RectF) (p1)).right - ((RectF) (p1)).left, ((RectF) (p1)).bottom - ((RectF) (p1)).top, 1.0F, 1.0F, 0.0F);
        } else
        {
            return k.h;
        }
    }

    public void b()
    {
        super.b();
        p = true;
    }

    protected a c()
    {
        return new a();
    }

    public void d()
    {
        String s1 = r.substring(0, r.indexOf("/"));
        b(new File((new StringBuilder()).append(t).append("/").append(s1).toString()));
    }

    protected j e()
    {
        return c();
    }
}
