// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tremorvideo.sdk.android.richmedia.a.i;
import com.tremorvideo.sdk.android.richmedia.b.a;
import com.tremorvideo.sdk.android.videoad.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipFile;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            h, p, a, c, 
//            q, g, ac, k, 
//            e, aa, m

public class o
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/tremorvideo/sdk/android/richmedia/o$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("None", 0);
            b = new a("Color", 1);
            c = new a("Asset", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int l)
        {
            super(s, l);
        }
    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        public static final b e;
        public static final b f;
        public static final b g;
        public static final b h;
        public static final b i;
        private static final b j[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/tremorvideo/sdk/android/richmedia/o$b, s);
        }

        public static b[] values()
        {
            return (b[])j.clone();
        }

        static 
        {
            a = new b("Normal", 0);
            b = new b("ScrubLeft", 1);
            c = new b("ScrubRight", 2);
            d = new b("ScrubFreeLeft", 3);
            e = new b("ScrubFreeRight", 4);
            f = new b("SwipeLeft", 5);
            g = new b("SwipeRight", 6);
            h = new b("SwipeFreeLeft", 7);
            i = new b("SwipeFreeRight", 8);
            j = (new b[] {
                a, b, c, d, e, f, g, h, i
            });
        }

        private b(String s, int l)
        {
            super(s, l);
        }
    }

    public static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        private static final c d[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/tremorvideo/sdk/android/richmedia/o$c, s);
        }

        public static c[] values()
        {
            return (c[])d.clone();
        }

        static 
        {
            a = new c("Normal", 0);
            b = new c("HTML5", 1);
            c = new c("VideoOnly", 2);
            d = (new c[] {
                a, b, c
            });
        }

        private c(String s, int l)
        {
            super(s, l);
        }
    }


    private int a;
    private long b;
    private h c;
    private List d;
    private com.tremorvideo.sdk.android.richmedia.a e;
    private c f;
    private a g;
    private Object h;
    private int i;
    private b j;

    public o(com.tremorvideo.sdk.android.richmedia.a a1)
    {
        e = a1;
        c = new h();
    }

    private void a(p p1)
    {
        if (g == a.b)
        {
            Paint paint = new Paint();
            paint.setColor(((Integer)h).intValue());
            int l = Math.round(p1.d() / -2F);
            int i1 = Math.round(p1.e() / -2F);
            int j1 = -l;
            int k1 = -i1;
            p1.c().drawRect(l, i1, j1, k1, paint);
        } else
        if (g == a.c)
        {
            Bitmap bitmap = e.r().a(((Integer)h).intValue());
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            Rect rect1 = new Rect(Math.round(p1.d() / -2F), Math.round(p1.e() / -2F), Math.round(p1.d() / 2.0F), Math.round(p1.e() / 2.0F));
            Paint paint1 = new Paint();
            paint1.setFilterBitmap(true);
            p1.c().drawBitmap(bitmap, rect, rect1, paint1);
            return;
        }
    }

    private void a(p p1, q q1, long l, g g1)
    {
        while (!p1.g && q1.f() || !p1.h && q1.g() || !a(q1)) 
        {
            return;
        }
        if (g1 == null)
        {
            q1.a(p1, l);
            return;
        }
        if (q1 == g1.b())
        {
            g1.a(p1);
            return;
        } else
        {
            q1.a(p1, l);
            return;
        }
    }

    public int a()
    {
        boolean flag = false;
        int l = 0;
        do
        {
label0:
            {
                int i1 = ((flag) ? 1 : 0);
                if (l < d.size())
                {
                    if (!(d.get(l) instanceof ac))
                    {
                        break label0;
                    }
                    i1 = l + 1;
                }
                return i1;
            }
            l++;
        } while (true);
    }

    public Rect a(p p1, long l)
    {
        Rect rect = new Rect(0, 0, 0, 0);
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            k k1 = ((q)iterator.next()).c(p1, l);
            rect.left = Math.min(rect.left, Math.round(k1.a));
            rect.top = Math.min(rect.top, Math.round(k1.b));
            rect.right = Math.max(rect.right, Math.round(k1.a + k1.f));
            int i1 = rect.bottom;
            float f1 = k1.b;
            rect.bottom = Math.max(i1, Math.round(k1.g + f1));
        }

        return rect;
    }

    public h.a a(h.c c1)
    {
        return c.a(c1);
    }

    public h.a a(p p1, int l, int i1, long l1)
    {
        int j1;
        byte byte0;
        int i2;
        if (e.g() > 1)
        {
            byte0 = -1;
        } else
        {
            byte0 = 1;
        }
        if (e.g() > 1)
        {
            j1 = d.size() - 1;
        } else
        {
            j1 = 0;
        }
        if (e.g() > 1)
        {
            i2 = -1;
        } else
        {
            i2 = d.size();
        }
        for (; j1 != i2; j1 += byte0)
        {
            q q1 = (q)d.get(j1);
            if (!q1.k() || !a(q1) || !q1.d(q1.k))
            {
                continue;
            }
            k k1 = q1.c(p1, l1);
            if (k1.a >= (float)l || k1.b >= (float)i1 || k1.f + k1.a < (float)l || k1.g + k1.b < (float)i1)
            {
                continue;
            }
            if (q1.a(Math.round((float)l - k1.a), Math.round((float)i1 - k1.b)))
            {
                return null;
            } else
            {
                return q1.m();
            }
        }

        return null;
    }

    public q a(int l)
    {
        if (l == 254)
        {
            return e.n();
        } else
        {
            return (q)d.get(l);
        }
    }

    public void a(e e1, ZipFile zipfile)
    {
        a = e1.a();
        f = c.values()[e1.b()];
        b = e1.a();
        j = b.values()[e1.b()];
        i = e1.b();
        if (i == 255)
        {
            i = -1;
        }
        g = a.values()[e1.b()];
        if (g != a.b) goto _L2; else goto _L1
_L1:
        h = new Integer(e1.a());
_L5:
        int i1;
        c.a(e1, e.g());
        i1 = e1.b();
        d = new ArrayList(i1);
        int l = 0;
_L3:
        if (l >= i1)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        q q1 = com.tremorvideo.sdk.android.richmedia.q.a(this, e1.a());
        q1.a(e1);
        if (q1 instanceof com.tremorvideo.sdk.android.richmedia.b.a)
        {
            ((com.tremorvideo.sdk.android.richmedia.b.a)q1).a(zipfile);
        }
        if (q1 instanceof i)
        {
            ((i)q1).a(zipfile);
        }
        d.add(q1);
        l++;
        if (true) goto _L3; else goto _L2
_L2:
        if (g != a.c) goto _L5; else goto _L4
_L4:
        h = new Integer(e1.b());
          goto _L5
        e1;
        ad.d((new StringBuilder()).append("Scene:load Exception =").append(e1).toString());
    }

    public void a(m m, long l)
    {
        for (Iterator iterator = d.iterator(); iterator.hasNext(); ((q)iterator.next()).a(m, l)) { }
    }

    public void a(p p1, long l, g g1)
    {
        for (Iterator iterator = d.iterator(); iterator.hasNext(); a(p1, (q)iterator.next(), l, g1)) { }
    }

    public boolean a(q q1)
    {
        return e.t() || !(q1 instanceof aa);
    }

    public RectF b(p p1, long l)
    {
        RectF rectf = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            k k1 = ((q)iterator.next()).c(p1, l);
            rectf.left = Math.min(rectf.left, k1.a);
            rectf.top = Math.min(rectf.top, k1.b);
            rectf.right = Math.max(rectf.right, k1.a + k1.f);
            float f1 = rectf.bottom;
            float f2 = k1.b;
            rectf.bottom = Math.max(f1, k1.g + f2);
        }

        return rectf;
    }

    public h.a b(p p1, int l, int i1, long l1)
    {
        Iterator iterator = d.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            q q1 = (q)iterator.next();
            if (q1.l() && q1.d(q1.k))
            {
                boolean flag1 = false;
                k k1 = q1.c(p1, l1);
                boolean flag = flag1;
                if (k1.a < (float)l)
                {
                    flag = flag1;
                    if (k1.b < (float)i1)
                    {
                        flag = flag1;
                        if (k1.f + k1.a >= (float)l)
                        {
                            float f1 = k1.g;
                            flag = flag1;
                            if (k1.b + f1 >= (float)i1)
                            {
                                flag = true;
                            }
                        }
                    }
                }
                q1.b(flag);
            }
        } while (true);
        return null;
    }

    public void b()
    {
        for (Iterator iterator = d.iterator(); iterator.hasNext(); ((q)iterator.next()).b()) { }
    }

    public void b(p p1, long l, g g1)
    {
        a(p1);
        int j1 = a();
        for (int i1 = 0; i1 < j1; i1++)
        {
            a(p1, (q)d.get(i1), l, g1);
        }

    }

    public long c()
    {
        return b;
    }

    public h.a c(p p1, int l, int i1, long l1)
    {
        Iterator iterator = d.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            q q1 = (q)iterator.next();
            if (q1.l() && q1.d(q1.k))
            {
                boolean flag1 = false;
                k k1 = q1.c(p1, l1);
                boolean flag = flag1;
                if (k1.a < (float)l)
                {
                    flag = flag1;
                    if (k1.b < (float)i1)
                    {
                        flag = flag1;
                        if (k1.f + k1.a >= (float)l)
                        {
                            float f1 = k1.g;
                            flag = flag1;
                            if (k1.b + f1 >= (float)i1)
                            {
                                flag = true;
                            }
                        }
                    }
                }
                q1.c(flag);
            }
        } while (true);
        return null;
    }

    public void c(p p1, long l, g g1)
    {
        for (int i1 = a(); i1 < d.size(); i1++)
        {
            a(p1, (q)d.get(i1), l, g1);
        }

    }

    public h.a d(p p1, int l, int i1, long l1)
    {
        int j1;
        byte byte0;
        boolean flag;
        float f1;
        Object obj;
        k k1;
        int i2;
        if (e.g() > 1)
        {
            byte0 = -1;
        } else
        {
            byte0 = 1;
        }
        if (e.g() > 1)
        {
            j1 = d.size() - 1;
        } else
        {
            j1 = 0;
        }
        if (e.g() > 1)
        {
            i2 = -1;
        } else
        {
            i2 = d.size();
        }
        if (j1 == i2) goto _L2; else goto _L1
_L1:
        obj = (q)d.get(j1);
        if (!((q) (obj)).k() || !a(((q) (obj))) || !((q) (obj)).d(((q) (obj)).k))
        {
            continue; /* Loop/switch isn't completed */
        }
        k1 = ((q) (obj)).c(p1, l1);
        if (k1.a >= (float)l || k1.b >= (float)i1 || k1.f + k1.a < (float)l)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        f1 = k1.g;
        if (k1.b + f1 < (float)i1)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        flag = true;
_L4:
        obj = ((q) (obj)).a(flag);
        if (obj != null)
        {
            return ((h.a) (obj));
        }
        j1 += byte0;
        break MISSING_BLOCK_LABEL_52;
_L2:
        return null;
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public List d()
    {
        return d;
    }

    public b e()
    {
        return j;
    }

    public com.tremorvideo.sdk.android.richmedia.a f()
    {
        return e;
    }

    public int g()
    {
        return i;
    }

    public h h()
    {
        return c;
    }

    public com.tremorvideo.sdk.android.richmedia.b.a i()
    {
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            q q1 = (q)iterator.next();
            if (q1 instanceof com.tremorvideo.sdk.android.richmedia.b.a)
            {
                return (com.tremorvideo.sdk.android.richmedia.b.a)q1;
            }
        }

        return null;
    }

    public ArrayList j()
    {
        ArrayList arraylist = new ArrayList(2);
        Iterator iterator = d.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            q q1 = (q)iterator.next();
            if (q1 instanceof i)
            {
                arraylist.add((i)q1);
            }
        } while (true);
        return arraylist;
    }

    public i k()
    {
label0:
        {
            if (d == null)
            {
                break label0;
            }
            Iterator iterator = d.iterator();
            q q1;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                q1 = (q)iterator.next();
            } while (!(q1 instanceof i));
            return (i)q1;
        }
        return null;
    }
}
