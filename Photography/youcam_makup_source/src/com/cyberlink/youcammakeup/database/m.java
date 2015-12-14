// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;

import android.content.ContentValues;
import android.graphics.Point;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.jniproxy.UIExifColorSpace;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.setting.PhotoQuality;
import java.text.SimpleDateFormat;

public class m
{

    protected long a;
    protected UIImageOrientation b;
    protected String c;
    protected long d;
    protected int e;
    protected String f;
    protected int g;
    protected int h;
    protected int i;
    protected String j;
    protected long k;
    protected int l;
    protected UIImageOrientation m;
    protected UIExifColorSpace n;
    protected UIImageOrientation o;
    protected long p;

    public m(long l1)
    {
        d = l1;
        a = 0L;
        b = UIImageOrientation.a;
        e = 0;
        f = "";
        g = -1;
        h = -1;
        i = -1;
        j = "";
        k = 0L;
        l = 0;
        m = UIImageOrientation.a;
        n = UIExifColorSpace.a;
        o = UIImageOrientation.a;
        p = -1L;
        c = com.cyberlink.youcammakeup.c.h();
    }

    public m(long l1, UIImageOrientation uiimageorientation, String s1, long l2, int i1, 
            String s2, int j1, int k1, int i2, String s3, long l3, 
            int j2, UIImageOrientation uiimageorientation1, UIExifColorSpace uiexifcolorspace, UIImageOrientation uiimageorientation2, long l4)
    {
        a = l1;
        b = uiimageorientation;
        c = s1;
        d = l2;
        e = i1;
        f = s2;
        g = j1;
        h = k1;
        i = i2;
        j = s3;
        k = l3;
        l = j2;
        m = uiimageorientation1;
        n = uiexifcolorspace;
        o = uiimageorientation2;
        p = l4;
    }

    public m(m m1)
    {
        a = m1.a;
        b = m1.b;
        c = m1.c;
        d = m1.d;
        e = m1.e;
        f = m1.f;
        g = m1.g;
        h = m1.h;
        i = m1.i;
        j = m1.j;
        k = m1.k;
        l = m1.l;
        m = m1.m;
        n = m1.n;
        o = m1.o;
        p = m1.p;
    }

    public static final int a()
    {
        return PhotoQuality.c();
    }

    public static final Point a(int i1, int j1)
    {
        int k1 = a();
        if (Math.max(i1, j1) > k1)
        {
            if (i1 > j1)
            {
                j1 = (int)Math.floor(((double)k1 / (double)i1) * (double)j1);
                i1 = k1;
            } else
            {
                i1 = (int)Math.floor(((double)k1 / (double)j1) * (double)i1);
                j1 = k1;
            }
        }
        return new Point(Math.max(i1, 1), Math.max(j1, 1));
    }

    public static final int b()
    {
        return PhotoQuality.d();
    }

    public static final Point b(int i1, int j1)
    {
        int k1 = b();
        if (Math.max(i1, j1) > k1)
        {
            if (i1 > j1)
            {
                j1 = (int)Math.floor(((double)k1 / (double)i1) * (double)j1);
                i1 = k1;
            } else
            {
                i1 = (int)Math.floor(((double)k1 / (double)j1) * (double)i1);
                j1 = k1;
            }
        }
        return new Point(Math.max(i1, 1), Math.max(j1, 1));
    }

    public long c()
    {
        return a;
    }

    public UIImageOrientation d()
    {
        return b;
    }

    public String e()
    {
        return c;
    }

    public long f()
    {
        return d;
    }

    public int g()
    {
        return e;
    }

    public String h()
    {
        return f;
    }

    public int i()
    {
        return g;
    }

    public int j()
    {
        return h;
    }

    public Point k()
    {
        return a(j(), i());
    }

    public Point l()
    {
        return new Point(j(), i());
    }

    public int m()
    {
        return i;
    }

    public String n()
    {
        return j;
    }

    public long o()
    {
        return k;
    }

    public int p()
    {
        return l;
    }

    public UIImageOrientation q()
    {
        return m;
    }

    public UIExifColorSpace r()
    {
        return n;
    }

    public UIImageOrientation s()
    {
        return o;
    }

    public long t()
    {
        return p;
    }

    public String toString()
    {
        SimpleDateFormat simpledateformat = Globals.a;
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(" FileID: ");
        stringbuilder.append(d);
        stringbuilder.append(", FileType: ");
        stringbuilder.append(f);
        stringbuilder.append(", FileHeight: ");
        stringbuilder.append(g);
        stringbuilder.append(", FileWidth: ");
        stringbuilder.append(h);
        stringbuilder.append(", SourceOrientation: ");
        stringbuilder.append(o);
        stringbuilder.append(", Orientation: ");
        stringbuilder.append(b);
        stringbuilder.append(", ThumbOrientation: ");
        stringbuilder.append(m);
        stringbuilder.append(", CaptureTime: ");
        stringbuilder.append(simpledateformat.format(Long.valueOf(a)));
        return stringbuilder.toString();
    }

    public boolean u()
    {
        return h > 0 && g > 0;
    }

    protected ContentValues v()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("CaptureTime", Long.valueOf(c()));
        contentvalues.put("Orientation", Integer.valueOf(d().a()));
        contentvalues.put("PresetCommand", e());
        contentvalues.put("FileID", Long.valueOf(f()));
        contentvalues.put("Rating", Integer.valueOf(g()));
        contentvalues.put("FileType", h());
        contentvalues.put("FileHeight", Integer.valueOf(i()));
        contentvalues.put("FileWidth", Integer.valueOf(j()));
        contentvalues.put("RawSDKMode", Integer.valueOf(m()));
        contentvalues.put("Temperature", n());
        contentvalues.put("RefreshModifiedTime", Long.valueOf(o()));
        contentvalues.put("ShareTo", Integer.valueOf(p()));
        contentvalues.put("ThumbOrientation", Integer.valueOf(q().a()));
        contentvalues.put("OriginalColorSpace", Integer.valueOf(r().a()));
        contentvalues.put("SourceOrientation", Integer.valueOf(s().a()));
        contentvalues.put("HistorySettingsID", Long.valueOf(t()));
        return contentvalues;
    }
}
