// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tremorvideo.sdk.android.richmedia.a.i;
import com.tremorvideo.sdk.android.richmedia.b.a;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.h;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            ad, p, a, c, 
//            ScriptInterpreter, k, q, h, 
//            o, g

public class m
{
    public static interface a
    {

        public abstract int a();

        public abstract void a(int i1, int j1);

        public abstract void a(h.a a1);

        public abstract void a(String s);

        public abstract int b();

        public abstract boolean c();

        public abstract boolean d();

        public abstract com.tremorvideo.sdk.android.videoad.o.a e();
    }


    com.tremorvideo.sdk.android.richmedia.ad a[];
    public boolean b;
    private long c;
    private o d;
    private a e;
    private p f;
    private o.b g;
    private h h;
    private ScriptInterpreter i;
    private g j;
    private q k;
    private boolean l;

    public m(a a1, com.tremorvideo.sdk.android.richmedia.a a2, Context context, boolean flag)
    {
        a = new com.tremorvideo.sdk.android.richmedia.ad[0];
        l = false;
        b = false;
        l = flag;
        e = a1;
        f = new p();
        f.f = a2.r().a();
        h = null;
        i = new ScriptInterpreter(context);
        i.load(this, a2);
    }

    private float a(k k1, k k2)
    {
        float f5 = k1.a;
        float f6 = k1.f / 2.0F;
        float f1 = k1.b;
        float f2 = k1.g / 2.0F;
        float f7 = k2.a;
        float f8 = k2.f / 2.0F;
        float f3 = k2.b;
        float f4 = k2.g / 2.0F;
        f5 = (f5 + f6) - (f7 + f8);
        f1 = (f1 + f2) - (f3 + f4);
        return (float)Math.sqrt(f5 * f5 + f1 * f1);
    }

    private q a(q q1)
    {
        if (!l)
        {
            return null;
        }
        if (q1 == null)
        {
            return null;
        }
        int i1 = q1.i().a(h.c.d).a();
        for (q1 = d.d().iterator(); q1.hasNext();)
        {
            q q2 = (q)q1.next();
            h.a a1 = q2.i().a(h.c.d);
            if (a1 != null && a1.a() == i1)
            {
                return q2;
            }
        }

        return null;
    }

    private boolean b(k k1, k k2)
    {
        float f1 = k1.a;
        float f2 = k1.f / 2.0F;
        float f3 = k1.b;
        float f4 = k1.g / 2.0F;
        float f5 = k2.a;
        float f6 = k2.f / 2.0F;
        float f7 = k2.b;
        float f8 = k2.g / 2.0F;
        return Math.abs((f1 + f2) - (f5 + f6)) > Math.abs((f3 + f4) - (f7 + f8));
    }

    private q o()
    {
        Object obj;
        Object obj2;
        Iterator iterator;
        obj2 = null;
        if (!l)
        {
            return null;
        }
        iterator = d.d().iterator();
        obj = null;
_L2:
        Object obj1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        q q1 = (q)iterator.next();
        obj1 = q1.i().a(h.c.d);
        if (obj1 == null || ((h.a) (obj1)).c() == h.b.u)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = q1.c(f, 0L);
        if (((k) (obj1)).f == 0.0F || ((k) (obj1)).g == 0.0F)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            obj = obj1;
            obj1 = q1;
        } else
        if (((k) (obj1)).b == ((k) (obj2)).b)
        {
            if (((k) (obj1)).a >= ((k) (obj2)).a)
            {
                break MISSING_BLOCK_LABEL_174;
            }
            obj = obj1;
            obj1 = q1;
        } else
        {
            if (((k) (obj1)).b >= ((k) (obj2)).b)
            {
                break MISSING_BLOCK_LABEL_174;
            }
            obj = obj1;
            obj1 = q1;
        }
_L3:
        obj2 = obj;
        obj = obj1;
        if (true) goto _L2; else goto _L1
_L1:
        return ((q) (obj));
        obj1 = obj;
        obj = obj2;
          goto _L3
    }

    public k a(q q1, long l1)
    {
        q1 = q1.c(f, l1);
        q1.a = ((k) (q1)).a + f.d() / 2.0F;
        q1.b = ((k) (q1)).b + f.e() / 2.0F;
        return q1;
    }

    public void a()
    {
        i.destroy();
    }

    public void a(int i1, int j1)
    {
        e.a(i1, j1);
    }

    public void a(int i1, int j1, int k1)
    {
        d.f().a(new GregorianCalendar(i1, j1, k1));
    }

    public void a(long l1)
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        if (j != null)
        {
            j.a(l1);
        }
        if (g != com.tremorvideo.sdk.android.richmedia.o.b.a || b) goto _L2; else goto _L3
_L3:
        int i1 = 0;
_L8:
        if (i1 >= d.h().a()) goto _L5; else goto _L4
_L4:
        h.a a1 = d.h().a(i1);
        if (a1.b() == h.c.p)
        {
            int j1 = ((Integer)a1.e()).intValue();
            if ((long)(j1 / 100) == c / 100L)
            {
                b = true;
                c = j1;
            }
        }
          goto _L6
_L5:
        d.a(this, l1);
        c = c + l1;
        if (c >= d.c())
        {
            c = 0L;
            a(h.c.g);
        }
_L2:
        return;
        Exception exception;
        exception;
        ad.a(exception);
        return;
_L6:
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void a(Canvas canvas)
    {
        byte byte1 = 2;
        byte byte0 = 0;
        Object obj = e.e();
        if (obj != com.tremorvideo.sdk.android.videoad.o.a.e && obj != com.tremorvideo.sdk.android.videoad.o.a.f)
        {
            Bitmap bitmap = d.f().d();
            int i2 = bitmap.getWidth();
            int j2 = bitmap.getHeight();
            Paint paint;
            int i1;
            int j1;
            int k1;
            int l1;
            if (obj == com.tremorvideo.sdk.android.videoad.o.a.a)
            {
                l1 = canvas.getWidth() / 2 - (i2 + 4);
                i1 = -4;
                k1 = canvas.getHeight() / -2 + 2;
                j1 = -10;
                byte0 = 14;
            } else
            if (obj == com.tremorvideo.sdk.android.videoad.o.a.b)
            {
                l1 = canvas.getWidth() / -2 + 4;
                i1 = -14;
                k1 = canvas.getHeight() / -2 + 2;
                j1 = -10;
                byte0 = 4;
            } else
            if (obj == com.tremorvideo.sdk.android.videoad.o.a.d)
            {
                l1 = canvas.getWidth() / -2 + 4;
                i1 = -14;
                k1 = canvas.getHeight() / 2 - (j2 + 2);
                j1 = -2;
                byte1 = 12;
                byte0 = 4;
            } else
            if (obj == com.tremorvideo.sdk.android.videoad.o.a.c)
            {
                l1 = canvas.getWidth() / 2 - (i2 + 4);
                i1 = -4;
                k1 = canvas.getHeight() / 2 - (j2 + 2);
                j1 = -2;
                byte1 = 12;
                byte0 = 14;
            } else
            {
                byte1 = 0;
                i1 = 0;
                j1 = 0;
                k1 = 0;
                l1 = 0;
            }
            obj = new RectF();
            obj.left = i1 + l1;
            obj.top = k1 + j1;
            obj.right = byte0 + (l1 + i2);
            obj.bottom = byte1 + (k1 + j2);
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.argb(179, 255, 255, 255));
            canvas.drawRoundRect(((RectF) (obj)), 10, 10, paint);
            canvas.drawBitmap(bitmap, l1, k1, null);
        }
    }

    public void a(h.a a1)
    {
        if (a1 != null && a1.d() != null)
        {
            i.callFunction(a1.d());
        }
    }

    public void a(h.c c1)
    {
        c1 = d.a(c1);
        if (c1 != null)
        {
            e.a(c1);
        }
    }

    public void a(o.b b1)
    {
        g = b1;
    }

    public void a(o o1)
    {
        c = 0L;
        b = false;
        if (d != null)
        {
            d.f().w();
        }
        d = o1;
        g = o1.e();
        d.b();
        com.tremorvideo.sdk.android.richmedia.b.a a1;
        if (o1.g() != -1)
        {
            j = new g(d.a(o1.g()));
        } else
        {
            j = null;
        }
        k = a(k);
        a1 = d.i();
        if (a1 != null)
        {
            a1.a(f);
        } else
        {
            d.f().v();
        }
        o1 = o1.j();
        if (o1 != null && !o1.isEmpty())
        {
            i i1;
            for (o1 = o1.iterator(); o1.hasNext(); i1.a(f, i1.h()))
            {
                i1 = (i)o1.next();
            }

        } else
        {
            d.f().w();
        }
        a(h.c.f);
    }

    public void a(h h1)
    {
        h = h1;
    }

    public void a(String s)
    {
        d.f().b(s);
    }

    public void a(JSONObject jsonobject)
    {
        ArrayList arraylist;
        if (jsonobject == null)
        {
            d.f().a(null);
            return;
        }
        arraylist = new ArrayList();
        SimpleDateFormat simpledateformat;
        SimpleDateFormat simpledateformat1;
        JSONArray jsonarray;
        StringBuilder stringbuilder;
        ArrayList arraylist1;
        simpledateformat = new SimpleDateFormat("h:mma");
        simpledateformat1 = new SimpleDateFormat("hh:mm");
        jsonarray = jsonobject.getJSONObject("theatresAndShowtimesByMovie").getJSONArray("theatres");
        stringbuilder = new StringBuilder();
        arraylist1 = new ArrayList();
        int i1;
        i1 = 0;
        jsonobject = null;
_L7:
        if (i1 >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        arraylist1.clear();
        Object obj = jsonobject;
        Object obj1 = jsonarray.getJSONObject(i1);
        obj = jsonobject;
        stringbuilder.setLength(0);
        obj = jsonobject;
        stringbuilder.append(((JSONObject) (obj1)).getString("theatreName"));
        obj = jsonobject;
        stringbuilder.append(":  ");
        obj = jsonobject;
        arraylist1.add(new com.tremorvideo.sdk.android.richmedia.ad(stringbuilder.toString(), ad.a.b));
        obj = jsonobject;
        Object obj2 = ((JSONObject) (obj1)).getJSONArray("theatreDays");
        obj = jsonobject;
        obj1 = ((JSONArray) (obj2)).getJSONObject(0).getJSONArray("movies").getJSONObject(0).getJSONArray("showtimes");
        obj = jsonobject;
        if (jsonobject != null)
        {
            break MISSING_BLOCK_LABEL_337;
        }
        obj = jsonobject;
        String as[] = ((JSONArray) (obj2)).getJSONObject(0).getString("day").split("-");
        obj = jsonobject;
        as = new GregorianCalendar(Integer.valueOf(as[0]).intValue(), Integer.valueOf(as[1]).intValue() - 1, Integer.valueOf(as[2]).intValue());
        obj = jsonobject;
        jsonobject = (new SimpleDateFormat("EEEE, MMMM d")).format(as.getTime());
        obj = jsonobject;
        arraylist1.add(new com.tremorvideo.sdk.android.richmedia.ad((new StringBuilder()).append(jsonobject).append("  ||  ").toString(), com.tremorvideo.sdk.android.richmedia.ad.a.a));
        obj = jsonobject;
        int j1;
        jsonobject = ((JSONObject) (obj));
        j1 = 0;
_L5:
        if (j1 >= ((JSONArray) (obj1)).length()) goto _L4; else goto _L3
_L3:
        as = ((JSONArray) (obj1)).getJSONObject(j1).getString("datetime").split("T")[1];
        obj = simpledateformat1.parse(as);
        stringbuilder.setLength(0);
        stringbuilder.append(simpledateformat.format(((java.util.Date) (obj))));
        if (j1 >= ((JSONArray) (obj1)).length() - 1)
        {
            break MISSING_BLOCK_LABEL_504;
        }
        stringbuilder.append(", ");
_L6:
        obj = null;
        if (((JSONArray) (obj1)).getJSONObject(j1).has("clickURL"))
        {
            obj = (new StringBuilder()).append(((JSONArray) (obj1)).getJSONObject(j1).getString("clickURL")).append("+").append(as).toString();
        }
        arraylist1.add(new com.tremorvideo.sdk.android.richmedia.ad(stringbuilder.toString(), ((String) (obj)), ad.a.c));
        j1++;
          goto _L5
        stringbuilder.append(" ");
          goto _L6
        obj;
_L13:
        ad.a(((Throwable) (obj)));
        obj = jsonobject;
_L9:
        i1++;
        jsonobject = ((JSONObject) (obj));
          goto _L7
_L4:
        if (i1 < jsonarray.length() - 1)
        {
            arraylist1.add(new com.tremorvideo.sdk.android.richmedia.ad("  |  ", com.tremorvideo.sdk.android.richmedia.ad.a.a));
        }
        obj1 = arraylist1.iterator();
_L10:
        obj = jsonobject;
        if (!((Iterator) (obj1)).hasNext()) goto _L9; else goto _L8
_L8:
        arraylist.add((com.tremorvideo.sdk.android.richmedia.ad)((Iterator) (obj1)).next());
          goto _L10
          goto _L9
_L2:
        a = new com.tremorvideo.sdk.android.richmedia.ad[arraylist.size()];
        i1 = 0;
_L12:
        if (i1 >= a.length)
        {
            break; /* Loop/switch isn't completed */
        }
        a[i1] = (com.tremorvideo.sdk.android.richmedia.ad)arraylist.get(i1);
        i1++;
        if (true) goto _L12; else goto _L11
_L11:
        try
        {
            d.f().a(a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            ad.a(jsonobject);
        }
        return;
        Exception exception;
        exception;
        jsonobject = ((JSONObject) (obj));
        obj = exception;
          goto _L13
    }

    public RectF b(int i1, int j1)
    {
        byte byte0 = 2;
        int k1 = 0;
        Object obj = e.e();
        Bitmap bitmap = d.f().d();
        int j2 = bitmap.getWidth();
        int k2 = bitmap.getHeight();
        int l1;
        int i2;
        if (obj == com.tremorvideo.sdk.android.videoad.o.a.a)
        {
            i2 = i1 / 2 - (j2 + 4);
            i1 = -4;
            l1 = j1 / -2 + 2;
            k1 = -10;
            j1 = i1;
            i1 = 14;
        } else
        if (obj == com.tremorvideo.sdk.android.videoad.o.a.b)
        {
            i2 = i1 / -2 + 4;
            i1 = -14;
            l1 = j1 / -2 + 2;
            k1 = -10;
            j1 = i1;
            i1 = 4;
        } else
        if (obj == com.tremorvideo.sdk.android.videoad.o.a.d)
        {
            i2 = i1 / -2 + 4;
            i1 = -14;
            l1 = (j1 / 2 - k2) + 2;
            k1 = -2;
            byte0 = 12;
            j1 = i1;
            i1 = 4;
        } else
        if (obj == com.tremorvideo.sdk.android.videoad.o.a.c)
        {
            i2 = i1 / 2 - (j2 + 4);
            i1 = -4;
            l1 = j1 / 2 - (k2 + 2);
            k1 = -2;
            byte0 = 12;
            j1 = i1;
            i1 = 14;
        } else
        {
            byte0 = 0;
            j1 = 0;
            boolean flag = false;
            l1 = 0;
            i2 = 0;
            i1 = k1;
            k1 = ((flag) ? 1 : 0);
        }
        obj = new RectF();
        obj.left = j1 + i2;
        obj.top = l1 + k1;
        obj.right = i1 + (i2 + j2);
        obj.bottom = byte0 + (l1 + k2);
        obj.left = ((RectF) (obj)).left - 15F;
        obj.right = ((RectF) (obj)).right + 15F;
        obj.top = ((RectF) (obj)).top - 15F;
        obj.bottom = ((RectF) (obj)).bottom + 15F;
        return ((RectF) (obj));
    }

    public o b()
    {
        return d;
    }

    public void b(long l1)
    {
        c = l1;
        if (l1 == 0L && g == com.tremorvideo.sdk.android.richmedia.o.b.a)
        {
            a(h.c.f);
        }
        if (c == d.c())
        {
            a(h.c.g);
        }
    }

    public void b(Canvas canvas)
    {
        if (d != null)
        {
            canvas.save();
            f.a(e, canvas, d.f().l(), d.f().m());
            f.g = e.c();
            f.h = e.d();
            d.c(f, c, j);
            a(canvas);
            if (j != null)
            {
                j.a(f);
            }
            if (k != null)
            {
                Object obj = k.c(f, c);
                RectF rectf = new RectF();
                rectf.left = ((k) (obj)).a - 10F;
                rectf.right = ((k) (obj)).a + ((k) (obj)).f + 10F;
                rectf.top = ((k) (obj)).b - 10F;
                float f1 = ((k) (obj)).b;
                rectf.bottom = ((k) (obj)).g + f1 + 10F;
                obj = new Paint();
                ((Paint) (obj)).setColor(Color.argb(128, 20, 20, 200));
                ((Paint) (obj)).setStrokeWidth(5F);
                ((Paint) (obj)).setStyle(android.graphics.Paint.Style.STROKE);
                canvas.drawRoundRect(rectf, 5F, 5F, ((Paint) (obj)));
                ((Paint) (obj)).setColor(Color.argb(128, 200, 200, 255));
                ((Paint) (obj)).setStrokeWidth(1.0F);
                ((Paint) (obj)).setStyle(android.graphics.Paint.Style.STROKE);
                canvas.drawRoundRect(rectf, 5F, 5F, ((Paint) (obj)));
            }
            canvas.restore();
        }
    }

    public void b(h.a a1)
    {
        if (a1 != null)
        {
            e.a(a1);
        }
    }

    public void b(String s)
    {
        e.a(s);
    }

    public void c()
    {
        Iterator iterator = d.d().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            h.a a1 = ((q)iterator.next()).i().a(h.c.d);
            if (a1 != null && a1.c() == h.b.u)
            {
                e.a(a1);
            }
        } while (true);
    }

    public void c(int i1, int j1)
    {
        boolean flag1 = false;
        com.tremorvideo.sdk.android.videoad.o.a a1 = e.e();
        boolean flag = flag1;
        if (a1 != com.tremorvideo.sdk.android.videoad.o.a.e)
        {
            flag = flag1;
            if (a1 != com.tremorvideo.sdk.android.videoad.o.a.f)
            {
                flag = flag1;
                if (b((int)f.d(), (int)f.e()).contains(i1, j1))
                {
                    e.a("adchoices");
                    flag = true;
                }
            }
        }
        if (!flag)
        {
            h.a a2 = d.a(f, i1, j1, c);
            if (a2 != null)
            {
                e.a(a2);
            }
            if (j != null && j.c(f, i1, j1))
            {
                j.a(f, i1, j1, c);
                j.a = true;
            }
        }
    }

    public void c(Canvas canvas)
    {
        if (d != null)
        {
            canvas.save();
            f.a(e, canvas, d.f().l(), d.f().m());
            f.g = e.c();
            f.h = e.d();
            d.b(f, c, j);
            canvas.restore();
        }
    }

    public void d()
    {
        if (k == null)
        {
            return;
        }
        h.a a1 = k.m();
        if (a1 != null)
        {
            e.a(a1);
            return;
        } else
        {
            h.a a2 = k.a(true);
            e.a(a2);
            return;
        }
    }

    public void d(int i1, int j1)
    {
        if (j != null && j.a)
        {
            j.a(f, i1, j1);
            h.a a1 = d.b(f, i1, j1, c);
            if (a1 != null)
            {
                e.a(a1);
            }
        }
    }

    public void e()
    {
        if (k == null)
        {
            k = o();
        } else
        {
            k k1 = k.c(f, c);
            q q1 = null;
            float f1 = 3.402823E+38F;
            Iterator iterator = d.d().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                q q2 = (q)iterator.next();
                if (q2.k() && q2 != k)
                {
                    k k2 = q2.c(f, 0L);
                    if (k2.f != 0.0F && k2.g != 0.0F && (k2.a < k1.a && b(k2, k1)))
                    {
                        float f2 = a(k1, k2);
                        if (q1 == null)
                        {
                            q1 = q2;
                            f1 = f2;
                        } else
                        if (f2 < f1)
                        {
                            q1 = q2;
                            f1 = f2;
                        }
                    }
                }
            } while (true);
            if (q1 != null)
            {
                k = q1;
                return;
            }
        }
    }

    public void e(int i1, int j1)
    {
        h.a a1 = d.d(f, i1, j1, c);
        if (a1 != null)
        {
            e.a(a1);
        }
        if (j != null && j.a)
        {
            j.b(f, i1, j1);
            j.a = false;
            if (a1 == null)
            {
                h.a a2 = d.c(f, i1, j1, c);
                if (a2 != null)
                {
                    e.a(a2);
                }
            }
        }
    }

    public void f()
    {
        if (k == null)
        {
            k = o();
        } else
        {
            k k1 = k.c(f, c);
            q q1 = null;
            float f1 = 3.402823E+38F;
            Iterator iterator = d.d().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                q q2 = (q)iterator.next();
                if (q2.k() && q2 != k)
                {
                    k k2 = q2.c(f, 0L);
                    if (k2.f != 0.0F && k2.g != 0.0F && (k2.a > k1.a && b(k2, k1)))
                    {
                        float f2 = a(k1, k2);
                        if (q1 == null)
                        {
                            q1 = q2;
                            f1 = f2;
                        } else
                        if (f2 < f1)
                        {
                            q1 = q2;
                            f1 = f2;
                        }
                    }
                }
            } while (true);
            if (q1 != null)
            {
                k = q1;
                return;
            }
        }
    }

    public void g()
    {
        if (k == null)
        {
            k = o();
        } else
        {
            k k1 = k.c(f, c);
            q q1 = null;
            float f1 = 3.402823E+38F;
            Iterator iterator = d.d().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                q q2 = (q)iterator.next();
                if (q2.k() && q2 != k)
                {
                    k k2 = q2.c(f, 0L);
                    if (k2.f != 0.0F && k2.g != 0.0F && (k2.b < k1.b && !b(k2, k1)))
                    {
                        float f2 = a(k1, k2);
                        if (q1 == null)
                        {
                            q1 = q2;
                            f1 = f2;
                        } else
                        if (f2 < f1)
                        {
                            q1 = q2;
                            f1 = f2;
                        }
                    }
                }
            } while (true);
            if (q1 != null)
            {
                k = q1;
                return;
            }
        }
    }

    public void h()
    {
        if (k == null)
        {
            k = o();
        } else
        {
            k k1 = k.c(f, c);
            q q1 = null;
            float f1 = 3.402823E+38F;
            Iterator iterator = d.d().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                q q2 = (q)iterator.next();
                if (q2.k() && q2 != k)
                {
                    k k2 = q2.c(f, 0L);
                    if (k2.f != 0.0F && k2.g != 0.0F && (k2.b > k1.b && !b(k2, k1)))
                    {
                        float f2 = a(k1, k2);
                        if (q1 == null)
                        {
                            q1 = q2;
                            f1 = f2;
                        } else
                        if (f2 < f1)
                        {
                            q1 = q2;
                            f1 = f2;
                        }
                    }
                }
            } while (true);
            if (q1 != null)
            {
                k = q1;
                return;
            }
        }
    }

    public long i()
    {
        return c;
    }

    public void j()
    {
        try
        {
            if (j != null)
            {
                j.a();
            }
            if (d != null)
            {
                for (Iterator iterator = d.d().iterator(); iterator.hasNext(); ((q)iterator.next()).a()) { }
            }
        }
        catch (Exception exception)
        {
            ad.d((new StringBuilder()).append("Exception Player onRotate=").append(exception).toString());
        }
    }

    public void k()
    {
        h.a a1 = d.a(com.tremorvideo.sdk.android.richmedia.h.c.i);
        if (a1 != null)
        {
            e.a(a1);
        }
    }

    public boolean l()
    {
        return i.scriptLoaded;
    }

    public void m()
    {
        if (h != null)
        {
            h.i();
        }
    }

    public boolean n()
    {
        return f != null && f.k;
    }
}
