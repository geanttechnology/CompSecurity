// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.extraction.templatematcher;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.jumio.clientlib.impl.livenessAndTM.TemplateInfo;
import com.jumio.clientlib.impl.livenessAndTM.TemplatePolygon;
import java.util.ArrayList;
import java.util.List;
import jumiomobile.ac;
import jumiomobile.ad;
import jumiomobile.ae;
import jumiomobile.af;
import jumiomobile.ao;
import jumiomobile.ji;
import jumiomobile.l;
import jumiomobile.n;
import jumiomobile.w;

public class TemplateInfoWrapper
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ji();
    public static double a = 0.59999999999999998D;
    public static double b = 0.75D;
    private float A;
    private float B;
    private int C;
    private int D;
    private l E;
    private boolean F;
    private int G;
    private float H;
    private float I;
    private float J;
    private float K;
    private w L;
    private boolean M;
    private long c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private final float l;
    private final float m;
    private final float n;
    private final float o;
    private final float p;
    private final float q;
    private final float r;
    private final float s;
    private final String t;
    private final String u;
    private final String v;
    private final String w;
    private final int x;
    private final int y;
    private final double z;

    private TemplateInfoWrapper(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        t = parcel.readString();
        v = parcel.readString();
        w = parcel.readString();
        u = parcel.readString();
        x = parcel.readInt();
        y = parcel.readInt();
        float af1[] = new float[8];
        parcel.readFloatArray(af1);
        n = af1[0];
        o = af1[1];
        l = af1[2];
        m = af1[3];
        r = af1[4];
        s = af1[5];
        p = af1[6];
        q = af1[7];
        z = parcel.readFloat();
        A = parcel.readFloat();
        B = parcel.readFloat();
        J = parcel.readFloat();
        K = parcel.readFloat();
        H = parcel.readFloat();
        I = parcel.readFloat();
        L = jumiomobile.w.values()[parcel.readInt()];
        C = parcel.readInt();
        D = parcel.readInt();
        E = (l)parcel.readSerializable();
        boolean flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        M = flag;
        if (parcel.readByte() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        F = flag;
        G = parcel.readInt();
    }

    public TemplateInfoWrapper(Parcel parcel, ji ji1)
    {
        this(parcel);
    }

    public TemplateInfoWrapper(TemplateInfo templateinfo)
    {
        PointF pointf = new PointF(templateinfo.getPolygon().getTLx(), templateinfo.getPolygon().getTLy());
        PointF pointf1 = new PointF(templateinfo.getPolygon().getTRx(), templateinfo.getPolygon().getTRy());
        PointF pointf2 = new PointF(templateinfo.getPolygon().getBRx(), templateinfo.getPolygon().getBRy());
        PointF pointf3 = new PointF(templateinfo.getPolygon().getBLx(), templateinfo.getPolygon().getBLy());
        float f1 = (float)(new af(pointf1.x, pointf1.y, pointf.x, pointf.y)).a();
        float f2 = (float)(new af(pointf2.x, pointf2.y, pointf3.x, pointf3.y)).a();
        float f3 = (float)(new af(pointf1.x, pointf1.y, pointf2.x, pointf2.y)).a();
        float f4 = (float)(new af(pointf.x, pointf.y, pointf3.x, pointf3.y)).a();
        PointF apointf[] = ac.a(pointf, pointf1, pointf2, pointf3, (int)Math.ceil(Math.max(Math.max(f1, f2), Math.max(f3, f4)) * 0.0F));
        n = apointf[0].x;
        o = apointf[0].y;
        l = apointf[1].x;
        m = apointf[1].y;
        p = apointf[2].x;
        q = apointf[2].y;
        r = apointf[3].x;
        s = apointf[3].y;
        t = templateinfo.getCountry();
        u = templateinfo.getState();
        v = templateinfo.getDocumentType();
        w = templateinfo.getRegion();
        x = templateinfo.getFrameIndex();
        y = templateinfo.getMatchesCount();
        z = templateinfo.getTransformError();
        C = templateinfo.getTemplateWidth();
        D = templateinfo.getTemplateHeight();
    }

    private PointF a(PointF pointf, l l1, ao ao1)
    {
        float f1 = (float)l1.a.a / (float)l1.c.a;
        float f2 = (float)l1.a.b / (float)l1.c.b;
        float f4 = (float)(l1.a.a - l1.b.a) / 2.0F;
        float f3 = (float)(l1.a.b - l1.b.b) / 2.0F;
        if (ao1.f())
        {
            if (ao1.i())
            {
                f1 = f1 * pointf.y - f4;
                f2 = (float)l1.b.b - (f2 * pointf.x - f3);
            } else
            {
                f1 = (float)l1.b.a - (f1 * pointf.y - f4);
                f2 = f2 * pointf.x - f3;
            }
        } else
        if (ao1.i())
        {
            f1 = (float)l1.b.a - (f1 * pointf.x - f4);
            f2 = (float)l1.b.b - (f2 * pointf.y - f3);
        } else
        {
            f1 = f1 * pointf.x - f4;
            f2 = f2 * pointf.y - f3;
        }
        pointf.x = f1;
        pointf.y = f2;
        return pointf;
    }

    public double A()
    {
        return (double)(0.5F * Math.abs((d - j) * (g - i) + (f - h) * (g - e)));
    }

    public int B()
    {
        return C;
    }

    public int C()
    {
        return D;
    }

    public w D()
    {
        return L;
    }

    public float E()
    {
        return (float)E.b.a;
    }

    public float F()
    {
        return (float)E.b.b;
    }

    public l G()
    {
        return E;
    }

    public boolean H()
    {
        return F;
    }

    public int I()
    {
        return G;
    }

    public float a()
    {
        return f;
    }

    public void a(float f1)
    {
        B = f1;
    }

    public void a(int i1)
    {
        G = i1;
    }

    public void a(long l1)
    {
        c = l1;
    }

    public void a(l l1, ao ao1)
    {
        E = l1;
        M = ao1.c();
        a(l1.c.b);
        b(l1.c.a);
        H = (float)l1.a.a / (float)l1.c.a;
        I = (float)l1.a.b / (float)l1.c.b;
        J = (float)(l1.a.a - l1.b.a) / 2.0F;
        K = (float)(l1.a.b - l1.b.b) / 2.0F;
        PointF pointf = a(new PointF(l, m), l1, ao1);
        d = pointf.x;
        e = pointf.y;
        pointf = a(new PointF(n, o), l1, ao1);
        f = pointf.x;
        g = pointf.y;
        pointf = a(new PointF(p, q), l1, ao1);
        h = pointf.x;
        i = pointf.y;
        l1 = a(new PointF(r, s), l1, ao1);
        j = ((PointF) (l1)).x;
        k = ((PointF) (l1)).y;
    }

    public void a(w w1)
    {
        L = w1;
    }

    public void a(boolean flag)
    {
        F = flag;
    }

    public float b()
    {
        return g;
    }

    public void b(float f1)
    {
        A = f1;
    }

    public float c()
    {
        return d;
    }

    public float d()
    {
        return e;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean e()
    {
        List list;
        boolean flag;
        int i1;
        int j1;
        list = f();
        flag = false;
        j1 = list.size();
        i1 = 0;
_L2:
        double d1;
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        d1 = ((PointF)list.get((i1 + 2) % j1)).x - ((PointF)list.get((i1 + 1) % j1)).x;
        double d2 = ((PointF)list.get((i1 + 2) % j1)).y - ((PointF)list.get((i1 + 1) % j1)).y;
        double d3 = ((PointF)list.get(i1)).x - ((PointF)list.get((i1 + 1) % j1)).x;
        d1 = d1 * (double)(((PointF)list.get(i1)).y - ((PointF)list.get((i1 + 1) % j1)).y) - d2 * d3;
        if (i1 != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (d1 > 0.0D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L4:
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        boolean flag1;
        if (d1 > 0.0D)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag == flag1) goto _L4; else goto _L3
_L3:
        return false;
        return true;
    }

    public List f()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(w());
        arraylist.add(x());
        arraylist.add(z());
        arraylist.add(y());
        return arraylist;
    }

    public boolean g()
    {
        E.b();
        float f1 = E.b.a;
        float f2 = E.b.b;
        q();
        return f >= 0.0F && j >= 0.0F && d <= f1 && h <= f1 && g >= 0.0F && k <= f2 && e >= 0.0F && i <= f2;
    }

    public boolean h()
    {
        float f2;
        float f1 = q() / r();
        f2 = (float)B() / (float)C();
        double d1;
        double d2;
        boolean flag;
        if (f1 > 1.0F && f2 > 1.0F || f1 < 1.0F && f2 < 1.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f1 = E.b.a;
        f2 = E.b.b;
        if (flag && !M) goto _L2; else goto _L1
_L1:
        d1 = ae.a(new Point(Math.round(d), Math.round(e)), new Point(Math.round(f), Math.round(g)));
        d2 = ae.a(new Point(Math.round(j), Math.round(k)), new Point(Math.round(h), Math.round(i)));
        if ((double)Math.max((int)Math.round(d1), (int)Math.round(d2)) >= (double)f1 * b) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if ((double)s().height() >= (double)f2 * a)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public float[] i()
    {
        return (new float[] {
            n, o, l, m, p, q, r, s
        });
    }

    public String j()
    {
        return v;
    }

    public String k()
    {
        return t;
    }

    public String l()
    {
        return u;
    }

    public String m()
    {
        return w;
    }

    public int n()
    {
        return x;
    }

    public int o()
    {
        return y;
    }

    public double p()
    {
        return z;
    }

    public float q()
    {
        return A;
    }

    public float r()
    {
        return B;
    }

    public Rect s()
    {
        Rect rect = new Rect();
        rect.top = (int)ac.a(new float[] {
            g, e, k, i
        });
        rect.left = (int)ac.a(new float[] {
            f, d, j, h
        });
        rect.bottom = (int)ac.b(new float[] {
            g, e, k, i
        });
        rect.right = (int)ac.b(new float[] {
            f, d, h, j
        });
        return rect;
    }

    public Rect t()
    {
        Rect rect = new Rect();
        rect.top = (int)ac.a(new float[] {
            o, m, s, q
        });
        rect.left = (int)ac.a(new float[] {
            n, l, r, p
        });
        rect.bottom = (int)ac.b(new float[] {
            o, m, s, q
        });
        rect.right = (int)ac.b(new float[] {
            n, l, p, r
        });
        return rect;
    }

    public PointF u()
    {
        PointF pointf = new PointF();
        af af1 = new af(f, g);
        af1 = af1.c((new af(h, i)).d(af1).a(0.5D));
        pointf.x = (float)af1.d();
        pointf.y = (float)af1.e();
        return pointf;
    }

    public double v()
    {
        af af1 = new af(1.0D, 0.0D);
        af af2 = new af(c() - a(), d() - b());
        double d2 = af1.a(af2);
        double d1 = d2;
        if (af2.c() == ad.a)
        {
            d1 = -d2;
        }
        return d1;
    }

    public PointF w()
    {
        return new PointF(f, g);
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        boolean flag = true;
        parcel.writeString(k());
        parcel.writeString(j());
        parcel.writeString(m());
        parcel.writeString(l());
        parcel.writeInt(n());
        parcel.writeInt(o());
        parcel.writeFloatArray(i());
        parcel.writeDouble(p());
        parcel.writeFloat(q());
        parcel.writeFloat(r());
        parcel.writeFloat(J);
        parcel.writeFloat(K);
        parcel.writeFloat(H);
        parcel.writeFloat(I);
        parcel.writeInt(L.a());
        parcel.writeInt(C);
        parcel.writeInt(D);
        parcel.writeSerializable(E);
        if (M)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
        if (F)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        parcel.writeByte((byte)i1);
        parcel.writeInt(G);
    }

    public PointF x()
    {
        return new PointF(d, e);
    }

    public PointF y()
    {
        return new PointF(j, k);
    }

    public PointF z()
    {
        return new PointF(h, i);
    }

}
