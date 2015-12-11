// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.b;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
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

public class com.tremorvideo.sdk.android.richmedia.b.a extends q
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
        final com.tremorvideo.sdk.android.richmedia.b.a l;

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
            l = com.tremorvideo.sdk.android.richmedia.b.a.this;
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

    public com.tremorvideo.sdk.android.richmedia.b.a(o o1)
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
        ad.d((new StringBuilder()).append("TwitterObjec extracting: ").append(zipentry).toString());
        zipfile = new BufferedInputStream(zipfile.getInputStream(zipentry));
        zipentry = new BufferedOutputStream(new FileOutputStream(s1));
        s1 = new byte[1024];
_L5:
        int i = zipfile.read(s1);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        zipentry.write(s1, 0, i);
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
            int j = afile.length;
            for (int i = 0; i < j; i++)
            {
                b(afile[i]);
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
        e1 = e1.c();
        if (e1.length() <= 0) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        jsonobject = new JSONObject(e1);
        if (jsonobject.has("main_page"))
        {
            q = jsonobject.getString("main_page");
        }
        if (!jsonobject.has("path")) goto _L4; else goto _L3
_L3:
        StringBuilder stringbuilder;
        r = jsonobject.getString("path");
        s = r;
        if (s.endsWith("/"))
        {
            s = s.substring(0, s.length() - 1);
        }
        stringbuilder = new StringBuilder();
        if (!s.contains("/")) goto _L6; else goto _L5
_L5:
        e1 = s.substring(0, s.lastIndexOf("/"));
_L7:
        s = stringbuilder.append(e1).append("/common").toString();
_L4:
        if (jsonobject.has("params"))
        {
            u = jsonobject.getString("params");
        }
_L2:
        h = false;
        i = false;
        return;
_L6:
        e1 = s;
          goto _L7
        e1;
        ad.a(e1);
          goto _L2
    }

    public void a(m m, long l)
    {
    }

    public void a(p p1)
    {
        k k1 = b(p1, 0L);
        int i = Math.round(p1.d() / 2.0F + k1.a + a);
        int j = Math.round(k1.b + b + p1.e() / 2.0F);
        p1 = new android.widget.RelativeLayout.LayoutParams(Math.round(k1.f), Math.round(k1.g));
        p1.leftMargin = i;
        p1.topMargin = j;
        g.f().a(p1);
        o = p1;
        g.f().a((new StringBuilder()).append("file://").append(t).append("/").append(q).toString(), u);
    }

    public void a(p p1, long l)
    {
        if (n()) goto _L2; else goto _L1
_L1:
        com.tremorvideo.sdk.android.richmedia.q.a a3;
        return;
_L2:
        if ((a3 = a(l)) == null) goto _L1; else goto _L3
_L3:
        float f;
        a a1;
        a a2;
        k k1;
        k1 = b(p1, l);
        a1 = (a)a3.a;
        a2 = (a)a3.b;
        k = a1.k;
        f = a3.c;
        if (a1.k) goto _L5; else goto _L4
_L4:
        if (p)
        {
            g.f().u();
        }
        p = false;
_L7:
        int i = ae.a(a1.i, a2.i, a1.j, a2.j, f);
        g.f().a(i);
        return;
_L5:
        int j = Math.round(p1.d() / 2.0F + k1.a + a);
        int i1 = Math.round(k1.b + b + p1.e() / 2.0F);
        p1 = new android.widget.RelativeLayout.LayoutParams(Math.round(k1.f), Math.round(k1.g));
        p1.leftMargin = j;
        p1.topMargin = i1;
        if (o == null || !p || ((android.widget.RelativeLayout.LayoutParams) (p1)).leftMargin != o.leftMargin || ((android.widget.RelativeLayout.LayoutParams) (p1)).topMargin != o.topMargin || ((android.widget.RelativeLayout.LayoutParams) (p1)).width != o.width || ((android.widget.RelativeLayout.LayoutParams) (p1)).height != o.height)
        {
            p = true;
            g.f().a(p1);
            o = p1;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void a(ZipFile zipfile)
    {
        t = zipfile.getName();
        if (t.contains(".zip"))
        {
            t = t.replace(".zip", "");
        }
        Enumeration enumeration = zipfile.entries();
_L5:
        if (!enumeration.hasMoreElements()) goto _L2; else goto _L1
_L1:
        ZipEntry zipentry = (ZipEntry)enumeration.nextElement();
        if (!zipentry.getName().startsWith(s)) goto _L4; else goto _L3
_L3:
        a(zipfile, zipentry, t, false);
          goto _L5
        zipfile;
        ad.a(zipfile);
_L2:
        return;
_L4:
        if (!zipentry.getName().startsWith(r)) goto _L5; else goto _L6
_L6:
        a(zipfile, zipentry, t, true);
          goto _L5
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
