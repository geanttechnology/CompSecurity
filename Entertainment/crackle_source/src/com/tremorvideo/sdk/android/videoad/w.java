// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            u, aw, x, bv, 
//            ad

public class w
{
    class a extends BitmapDrawable
    {

        Bitmap a;
        final w b;

        public void draw(Canvas canvas)
        {
            if (!b.f)
            {
                super.draw(canvas);
                return;
            } else
            {
                Matrix matrix = new Matrix();
                matrix.postScale(1.0F, -1F);
                matrix.postTranslate(0.0F, a.getHeight());
                canvas.drawBitmap(a, matrix, null);
                return;
            }
        }

        public int getIntrinsicHeight()
        {
            return a.getHeight();
        }

        public int getIntrinsicWidth()
        {
            return a.getWidth();
        }

        public a(Bitmap bitmap)
        {
            b = w.this;
            super(bitmap);
            a = bitmap;
        }
    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        private static final b e[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/tremorvideo/sdk/android/videoad/w$b, s);
        }

        public static b[] values()
        {
            return (b[])e.clone();
        }

        static 
        {
            a = new b("Left", 0);
            b = new b("Middle", 1);
            c = new b("Right", 2);
            d = new b("Solo", 3);
            e = (new b[] {
                a, b, c, d
            });
        }

        private b(String s, int i1)
        {
            super(s, i1);
        }
    }

    private class c extends View
    {

        b a;
        Bitmap b;
        boolean c;
        TextPaint d;
        String e;
        boolean f;
        float g;
        Timer h;
        long i;
        final w j;

        private void a(Canvas canvas)
        {
            Bitmap bitmap;
            Bitmap bitmap1;
            Bitmap bitmap2;
            if (c)
            {
                bitmap = j.a[3];
            } else
            {
                bitmap = j.a[1];
            }
            if (c)
            {
                bitmap1 = j.a[6];
            } else
            {
                bitmap1 = j.a[0];
            }
            if (c)
            {
                bitmap2 = j.a[7];
            } else
            {
                bitmap2 = j.a[2];
            }
            if (a == b.b)
            {
                a(canvas, bitmap, new Rect(0, 0, bitmap1.getWidth(), bitmap.getHeight()));
                a(canvas, bitmap, bitmap1.getWidth(), 0);
            } else
            {
                if (a == b.a)
                {
                    a(canvas, bitmap1, 0, 0);
                    a(canvas, bitmap, bitmap1.getWidth(), 0);
                    return;
                }
                if (a == b.c)
                {
                    a(canvas, bitmap, 0, 0);
                    a(canvas, bitmap2, bitmap.getWidth(), 0);
                    return;
                }
                if (a == b.d)
                {
                    a(canvas, bitmap1, 0, 0);
                    a(canvas, bitmap, bitmap1.getWidth(), 0);
                    int i1 = bitmap1.getWidth();
                    a(canvas, bitmap2, bitmap.getWidth() + i1, 0);
                    return;
                }
            }
        }

        private void a(Canvas canvas, Bitmap bitmap, int i1, int j1)
        {
            if (!f)
            {
                canvas.drawBitmap(bitmap, i1, j1, null);
                return;
            } else
            {
                Matrix matrix = new Matrix();
                matrix.postTranslate(0.0F, -bitmap.getHeight());
                matrix.postScale(1.0F, -1F);
                matrix.postTranslate(i1, j1);
                canvas.drawBitmap(bitmap, matrix, null);
                return;
            }
        }

        private void a(Canvas canvas, Bitmap bitmap, Rect rect)
        {
            if (!f)
            {
                canvas.drawBitmap(bitmap, rect, rect, null);
                return;
            }
            canvas.save(2);
            if (canvas.clipRect(rect))
            {
                Matrix matrix = new Matrix();
                matrix.postTranslate(0.0F, -bitmap.getHeight());
                matrix.postScale(1.0F, -1F);
                matrix.postTranslate(rect.left, rect.top);
                canvas.drawBitmap(bitmap, matrix, null);
            }
            canvas.restore();
        }

        private int b()
        {
            int i1 = 0;
            Bitmap bitmap = j.a[1];
            Bitmap bitmap1 = j.a[0];
            Bitmap bitmap2 = j.a[0];
            if (a == b.a)
            {
                i1 = bitmap1.getWidth() + bitmap.getWidth();
            } else
            {
                if (a == b.c)
                {
                    return bitmap2.getWidth() + bitmap.getWidth();
                }
                if (a == b.b)
                {
                    return bitmap1.getWidth() + bitmap.getWidth();
                }
                if (a == b.d)
                {
                    return bitmap1.getWidth() + bitmap2.getWidth() + bitmap.getWidth();
                }
            }
            return i1;
        }

        private int c()
        {
            return j.a[1].getHeight();
        }

        public void a()
        {
            i = GregorianCalendar.getInstance().getTimeInMillis();
            g = 3F;
            h = new Timer();
            h.scheduleAtFixedRate(new TimerTask(this) {

                final c a;

                public void run()
                {
                    long l1 = GregorianCalendar.getInstance().getTimeInMillis();
                    long l2 = a.i;
                    a.i = l1;
                    a.g = Math.max(0.0F, a.g - ((float)(l1 - l2) / 1000F) * 1.5F);
                    try
                    {
                        a.postInvalidate();
                    }
                    catch (Exception exception)
                    {
                        ad.a(exception);
                    }
                    if (a.g == 0.0F)
                    {
                        cancel();
                    }
                }

            
            {
                a = c1;
                super();
            }
            }, 10L, 10L);
        }

        public void a(boolean flag)
        {
            f = flag;
        }

        public void b(boolean flag)
        {
            if (c != flag)
            {
                c = flag;
                invalidate();
            }
        }

        protected void onDraw(Canvas canvas)
        {
            int j1 = b();
            int k1 = c();
            a(canvas);
            float f1 = g;
            float f2 = (int)g;
            float f3 = Math.round(-15F * ad.J());
            f1 = (float)(Math.sin((double)(f1 - f2) * 3.1415926535897931D) * (double)f3);
            if (b == null)
            {
                Rect rect = new Rect();
                d.getTextBounds(e, 0, e.length(), rect);
                f2 = (j1 - rect.width()) / 2;
                f3 = (k1 - rect.height()) / 2;
                canvas.drawText(e, f2, f3 + 10F + f1, d);
                return;
            }
            Rect rect1;
            int i1;
            byte byte0;
            int l1;
            if (f)
            {
                i1 = 0;
            } else
            {
                i1 = -5;
            }
            if (f)
            {
                byte0 = 5;
            } else
            {
                byte0 = 0;
            }
            rect1 = new Rect();
            d.getTextBounds(e, 0, e.length(), rect1);
            l1 = Math.round(d.getTextSize() + (float)d.baselineShift);
            f2 = (float)(j1 - b.getWidth()) / 2.0F;
            f3 = (k1 - (byte0 + l1) - b.getHeight()) / 2;
            canvas.drawBitmap(b, f2, f3 + f1, null);
            f1 = (j1 - rect1.width()) / 2;
            f2 = k1 - l1 - i1;
            canvas.drawText(e, f1, f2, d);
        }

        protected void onMeasure(int i1, int j1)
        {
            Bitmap bitmap = j.a[1];
            setMeasuredDimension(b(), bitmap.getHeight());
        }

        public c(Context context, Bitmap bitmap, String s, b b1)
        {
            j = w.this;
            super(context);
            a = b1;
            b = bitmap;
            e = s;
            g = 0.0F;
            c = false;
            f = false;
            d = new TextPaint();
            d.setTextSize(ad.H());
            d.setColor(w.this.j.a(bv.c.a));
            d.setTypeface(Typeface.create("helvetica", 1));
            d.setShadowLayer(5F, 0.0F, 0.0F, w.this.j.a(bv.c.b));
            d.setAntiAlias(true);
            e = (String)TextUtils.ellipsize(e, d, w.this.a[1].getWidth() - 5, android.text.TextUtils.TruncateAt.END);
            setOnTouchListener(new _cls1(this, w.this));
            setOnFocusChangeListener(new _cls2(this, w.this));
            setOnKeyListener(new _cls3(this, w.this));
        }
    }

    private class d
        implements Runnable
    {

        View a;
        boolean b;
        final w c;

        public void run()
        {
            if (!b)
            {
                b = true;
                TranslateAnimation translateanimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, 1.0F, 1, 0.0F);
                translateanimation.setInterpolator(new DecelerateInterpolator());
                translateanimation.setDuration(1000L);
                a.setVisibility(0);
                a.startAnimation(translateanimation);
                a.getParent().requestLayout();
            }
        }

        d(View view)
        {
            c = w.this;
            super();
            b = false;
            a = view;
            a.setVisibility(4);
        }
    }


    static int l = 20;
    Bitmap a[];
    int b;
    int c;
    View d;
    View e;
    boolean f;
    Context g;
    int h;
    android.view.View.OnClickListener i;
    bv j;
    List k;

    public w(Context context, android.view.View.OnClickListener onclicklistener, u u1, int i1)
    {
        a = new Bitmap[8];
        g = context;
        i = onclicklistener;
        h = i1;
        e = null;
        f = false;
        j = u1.q();
        k = new ArrayList();
        j();
        c = a(u1.Q());
        b = a(a, u1.M(), i1);
        context = new LinearLayout(g);
        b(context, 10);
        onclicklistener = u1.Q().iterator();
        int j1 = 0;
        do
        {
label0:
            {
                if (onclicklistener.hasNext())
                {
                    Object obj = (aw)onclicklistener.next();
                    i1 = j1;
                    if (((aw) (obj)).l())
                    {
                        j1++;
                        if (Math.min(c, b) == 1)
                        {
                            a(context, ((aw) (obj)), b.d);
                        } else
                        if (j1 == 1)
                        {
                            a(context, ((aw) (obj)), b.a);
                        } else
                        if (j1 < c && j1 < b)
                        {
                            a(context, ((aw) (obj)), b.b);
                        } else
                        {
                            a(context, ((aw) (obj)), b.c);
                        }
                        i1 = j1;
                        if (j1 < c)
                        {
                            i1 = j1;
                            if (j1 < b)
                            {
                                a(context, 5);
                                i1 = j1;
                            }
                        }
                    }
                    if (i1 < b)
                    {
                        break label0;
                    }
                }
                if (u1.M())
                {
                    onclicklistener = new View(g);
                    onclicklistener.setVisibility(4);
                    onclicklistener.setFocusable(false);
                    obj = new android.widget.LinearLayout.LayoutParams(0, 0);
                    obj.weight = 1.0F;
                    context.addView(onclicklistener, ((android.view.ViewGroup.LayoutParams) (obj)));
                    a(context, u1);
                    b(context, 10);
                }
                d = context;
                d.setFocusableInTouchMode(false);
                d.setFocusable(false);
                i();
                return;
            }
            j1 = i1;
        } while (true);
    }

    public w(Context context, android.view.View.OnClickListener onclicklistener, u u1, int i1, int j1)
    {
        a = new Bitmap[8];
        g = context;
        i = onclicklistener;
        h = j1;
        e = null;
        f = true;
        j = u1.q();
        k = new ArrayList();
        j();
        int k1 = a(u1.Q());
        c = i1;
        b = a(a, false, j1);
        onclicklistener = new LinearLayout(g);
        b(onclicklistener, 10);
        u1 = u1.Q().iterator();
        j1 = 0;
        k1 -= i1;
        i1 = j1;
        do
        {
label0:
            {
                if (u1.hasNext())
                {
                    context = (aw)u1.next();
                    j1 = i1;
                    if (context.l())
                    {
                        if (k1 > 0)
                        {
                            k1--;
                            continue;
                        }
                        i1++;
                        if (Math.min(c, b) == 1)
                        {
                            context = a(onclicklistener, context, b.d);
                        } else
                        if (i1 == 1)
                        {
                            context = a(onclicklistener, context, b.a);
                        } else
                        if (i1 < c && i1 < b)
                        {
                            context = a(onclicklistener, context, b.b);
                        } else
                        {
                            context = a(onclicklistener, context, b.c);
                        }
                        if (context != null)
                        {
                            context.a(true);
                        }
                        j1 = i1;
                        if (i1 < c)
                        {
                            j1 = i1;
                            if (i1 < b)
                            {
                                a(onclicklistener, 5);
                                j1 = i1;
                            }
                        }
                    }
                    if (j1 < b)
                    {
                        break label0;
                    }
                }
                d = onclicklistener;
                d.setFocusableInTouchMode(false);
                d.setFocusable(true);
                i();
                return;
            }
            i1 = j1;
        } while (true);
    }

    public w(Context context, android.view.View.OnClickListener onclicklistener, List list, bv bv1, boolean flag, String s, int i1)
    {
        a = new Bitmap[8];
        g = context;
        i = onclicklistener;
        h = i1;
        e = null;
        f = false;
        j = bv1;
        k = new ArrayList();
        j();
        c = list.size();
        b = a(a, flag, i1);
        onclicklistener = new LinearLayout(g);
        b(onclicklistener, 10);
        context = list.iterator();
        i1 = 0;
        do
        {
            if (!context.hasNext())
            {
                break;
            }
            list = (x)context.next();
            int j1 = i1 + 1;
            bv1 = j.a(((x) (list)).b);
            if (Math.min(c, b) == 1)
            {
                a(onclicklistener, ((x) (list)).a, bv1, b.d);
            } else
            if (j1 == 1)
            {
                a(onclicklistener, ((x) (list)).a, bv1, b.a);
            } else
            if (j1 < c)
            {
                a(onclicklistener, ((x) (list)).a, bv1, b.b);
            } else
            {
                a(onclicklistener, ((x) (list)).a, bv1, b.c);
            }
            if (j1 < c)
            {
                a(onclicklistener, 5);
            }
            i1 = j1;
        } while (j1 < b);
        if (flag)
        {
            context = new View(g);
            context.setVisibility(4);
            list = new android.widget.LinearLayout.LayoutParams(0, 0);
            list.weight = 1.0F;
            onclicklistener.addView(context, list);
            context = s;
            if (s == null)
            {
                context = aw.b(aw.b.v);
            }
            e = a(onclicklistener, context, j.a(bv.d.i), b.d);
            b(onclicklistener, 10);
        }
        d = onclicklistener;
        d.setFocusableInTouchMode(false);
        d.setFocusable(true);
        i();
    }

    public w(Context context, android.view.View.OnClickListener onclicklistener, aw.b ab[], bv bv1, boolean flag, String s, int i1)
    {
        a = new Bitmap[8];
        g = context;
        i = onclicklistener;
        h = i1;
        e = null;
        f = false;
        j = bv1;
        k = new ArrayList();
        j();
        c = ab.length;
        b = a(a, flag, i1);
        onclicklistener = new LinearLayout(g);
        b(onclicklistener, 10);
        int j1 = 0;
        int k1 = ab.length;
        i1 = 0;
        do
        {
label0:
            {
                if (i1 < k1)
                {
                    bv1 = ab[i1];
                    j1++;
                    context = bv1.c();
                    bv1 = j.a(bv1.b());
                    if (Math.min(c, b) == 1)
                    {
                        a(onclicklistener, context, bv1, b.d);
                    } else
                    if (j1 == 1)
                    {
                        a(onclicklistener, context, bv1, b.a);
                    } else
                    if (j1 < c)
                    {
                        a(onclicklistener, context, bv1, b.b);
                    } else
                    {
                        a(onclicklistener, context, bv1, b.c);
                    }
                    if (j1 < c)
                    {
                        a(onclicklistener, 5);
                    }
                    if (j1 < b)
                    {
                        break label0;
                    }
                }
                if (flag)
                {
                    context = new View(g);
                    context.setVisibility(4);
                    ab = new android.widget.LinearLayout.LayoutParams(0, 0);
                    ab.weight = 1.0F;
                    onclicklistener.addView(context, ab);
                    context = s;
                    if (s == null)
                    {
                        context = aw.b(aw.b.v);
                    }
                    e = a(onclicklistener, context, j.a(bv.d.i), b.d);
                    b(onclicklistener, 10);
                }
                d = onclicklistener;
                d.setFocusableInTouchMode(false);
                d.setFocusable(false);
                i();
                return;
            }
            i1++;
        } while (true);
    }

    private static int a(List list)
    {
        list = list.iterator();
        int i1 = 0;
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            if (((aw)list.next()).l())
            {
                i1++;
            }
        } while (true);
        return i1;
    }

    private static int a(Bitmap abitmap[], boolean flag, int i1)
    {
        int j1 = abitmap[0].getWidth();
        int k1 = abitmap[2].getWidth() + j1;
        j1 = i1 - k1 - 20;
        i1 = j1;
        if (flag)
        {
            i1 = j1 - (k1 + 5) - abitmap[1].getWidth();
        }
        return i1 / (abitmap[0].getWidth() + abitmap[1].getWidth() + abitmap[5].getWidth());
    }

    private c a(LinearLayout linearlayout, aw aw1, b b1)
    {
        Bitmap bitmap1 = j.a(aw1.o());
        Bitmap bitmap = bitmap1;
        if (bitmap1 == null)
        {
            bitmap = j.a(aw1.a().b());
        }
        b1 = new c(g, bitmap, aw1.h(), b1);
        int i1 = l;
        l = i1 + 1;
        b1.setId(i1);
        b1.setTag(aw1);
        b1.setVisibility(0);
        b1.setFocusable(false);
        b1.setFocusableInTouchMode(false);
        b1.setOnClickListener(i);
        linearlayout.addView(b1);
        k.add(b1);
        return b1;
    }

    private c a(LinearLayout linearlayout, String s, Bitmap bitmap, b b1)
    {
        bitmap = new c(g, bitmap, s, b1);
        int i1 = l;
        l = i1 + 1;
        bitmap.setId(i1);
        bitmap.setTag(s);
        bitmap.setVisibility(0);
        bitmap.setFocusable(false);
        bitmap.setFocusableInTouchMode(false);
        bitmap.setOnClickListener(i);
        k.add(bitmap);
        linearlayout.addView(bitmap);
        return bitmap;
    }

    private void a(LinearLayout linearlayout, int i1)
    {
        ImageView imageview = new ImageView(g);
        imageview.setImageDrawable(new a(a[i1]));
        imageview.setLayoutParams(new android.widget.Gallery.LayoutParams(-2, -2));
        linearlayout.addView(imageview);
    }

    private void a(LinearLayout linearlayout, u u1)
    {
label0:
        {
            if (!u1.M())
            {
                break label0;
            }
            u1 = u1.l().iterator();
            aw aw1;
            do
            {
                if (!u1.hasNext())
                {
                    break label0;
                }
                aw1 = (aw)u1.next();
            } while (aw1.a() != aw.b.v);
            e = a(linearlayout, aw1, b.d);
            e.setVisibility(4);
        }
    }

    private void b(LinearLayout linearlayout, int i1)
    {
        linearlayout.addView(new View(g), new android.widget.LinearLayout.LayoutParams(i1, 0));
    }

    private void h()
    {
        if (e != null)
        {
            e.setFocusable(true);
            if (k.size() > 0)
            {
                ((c)k.get(k.size() - 1)).setNextFocusRightId(e.getId());
            }
        }
    }

    private void i()
    {
        d.setFocusable(true);
        for (int i1 = 0; i1 < k.size(); i1++)
        {
            c c1 = (c)k.get(i1);
            c1.setFocusable(true);
            if (i1 > 0)
            {
                c1.setNextFocusLeftId(((c)k.get(i1 - 1)).getId());
            }
            if (i1 < k.size() - 1)
            {
                c1.setNextFocusRightId(((c)k.get(i1 + 1)).getId());
            }
        }

        h();
        if (k.size() > 0)
        {
            ((c)k.get(0)).requestFocus();
        } else
        if (e != null)
        {
            e.requestFocus();
            return;
        }
    }

    private void j()
    {
        a[0] = j.a(bv.d.p);
        a[1] = j.a(bv.d.q);
        a[2] = j.a(bv.d.r);
        a[3] = j.a(bv.d.t);
        a[5] = j.a(bv.d.o);
        a[6] = j.a(bv.d.s);
        a[7] = j.a(bv.d.u);
    }

    public void a(aw aw1)
    {
        Iterator iterator = d.getTouchables().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (View)iterator.next();
            if (obj instanceof c)
            {
                obj = (c)obj;
                if (((c) (obj)).getTag() == aw1)
                {
                    ((c) (obj)).a();
                }
            }
        } while (true);
    }

    public boolean a()
    {
        return c > b;
    }

    public int b()
    {
        return c - b;
    }

    public int c()
    {
        return a[0].getWidth() + a[2].getWidth() + (a[0].getWidth() + a[1].getWidth() + a[5].getWidth()) * c;
    }

    public View d()
    {
        return d;
    }

    public void e()
    {
        if (e != null)
        {
            e.post(new d(e));
            h();
        }
    }

    public void f()
    {
        if (e != null)
        {
            e.setVisibility(0);
            h();
        }
    }

    public void g()
    {
        Iterator iterator = d.getTouchables().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            View view = (View)iterator.next();
            if (view instanceof c)
            {
                ((c)view).b(false);
            }
        } while (true);
    }


    // Unreferenced inner class com/tremorvideo/sdk/android/videoad/w$c$1

/* anonymous class */
    class c._cls1
        implements android.view.View.OnTouchListener
    {

        final w a;
        final c b;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() == 1 || motionevent.getAction() == 3)
            {
                b.c = false;
            } else
            {
                b.c = true;
            }
            view.invalidate();
            return false;
        }

            
            {
                b = c1;
                a = w1;
                super();
            }
    }


    // Unreferenced inner class com/tremorvideo/sdk/android/videoad/w$c$2

/* anonymous class */
    class c._cls2
        implements android.view.View.OnFocusChangeListener
    {

        final w a;
        final c b;

        public void onFocusChange(View view, boolean flag)
        {
            b.c = flag;
            view.invalidate();
        }

            
            {
                b = c1;
                a = w1;
                super();
            }
    }


    // Unreferenced inner class com/tremorvideo/sdk/android/videoad/w$c$3

/* anonymous class */
    class c._cls3
        implements android.view.View.OnKeyListener
    {

        final w a;
        final c b;

        public boolean onKey(View view, int i1, KeyEvent keyevent)
        {
            if (i1 == 23)
            {
                b.c = true;
                view.invalidate();
            }
            return false;
        }

            
            {
                b = c1;
                a = w1;
                super();
            }
    }

}
