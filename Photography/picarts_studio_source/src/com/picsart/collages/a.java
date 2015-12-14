// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.picsart.studio.PicsartContext;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.collages:
//            SPArrow, CollageCreatorView, CollageImage

public final class a
{

    private float A;
    private float B;
    private float C;
    private RectF D;
    private PorterDuffXfermode E;
    private PorterDuffXfermode F;
    private Paint G;
    private Paint H;
    private Matrix I;
    private float J;
    private Bitmap K;
    private Path L;
    private float M;
    ArrayList a;
    ArrayList b;
    ArrayList c;
    public Bitmap d;
    RectF e;
    Rect f;
    public Paint g;
    float h;
    Matrix i;
    public SPArrow j;
    float k;
    float l;
    int m;
    Path n;
    float o;
    float p;
    float q;
    public boolean r;
    ModernAsyncTask s;
    CollageCreatorView t;
    float u;
    boolean v;
    public int w;
    CollageImage x;
    private Path y;
    private float z;

    public a()
    {
        a = new ArrayList();
        b = new ArrayList();
        c = null;
        y = null;
        z = 0.0F;
        A = 0.0F;
        B = 0.0F;
        C = 0.0F;
        d = null;
        D = new RectF();
        e = new RectF();
        f = new Rect();
        E = null;
        F = null;
        g = new Paint();
        G = new Paint();
        H = new Paint();
        h = 0.0F;
        i = null;
        j = null;
        k = 1.0F;
        l = 1.0F;
        m = 0;
        n = null;
        I = new Matrix();
        o = 1.0F;
        J = 1.0F;
        p = 0.0F;
        K = null;
        q = 0.0F;
        r = true;
        L = null;
        s = null;
        t = null;
        u = 0.0F;
        M = 30F;
        v = false;
        w = 0;
        x = null;
    }

    public a(ArrayList arraylist, float f1, Bitmap bitmap)
    {
        int i1 = 0;
        super();
        a = new ArrayList();
        b = new ArrayList();
        c = null;
        y = null;
        z = 0.0F;
        A = 0.0F;
        B = 0.0F;
        C = 0.0F;
        d = null;
        D = new RectF();
        e = new RectF();
        f = new Rect();
        E = null;
        F = null;
        g = new Paint();
        G = new Paint();
        H = new Paint();
        h = 0.0F;
        i = null;
        j = null;
        k = 1.0F;
        l = 1.0F;
        m = 0;
        n = null;
        I = new Matrix();
        o = 1.0F;
        J = 1.0F;
        p = 0.0F;
        K = null;
        q = 0.0F;
        r = true;
        L = null;
        s = null;
        t = null;
        u = 0.0F;
        M = 30F;
        v = false;
        w = 0;
        x = null;
        i = new Matrix();
        M = M * Resources.getSystem().getDisplayMetrics().density;
        a = (ArrayList)arraylist.clone();
        int j1 = arraylist.size();
        K = bitmap;
        for (; i1 < j1; i1++)
        {
            bitmap = (SPArrow)arraylist.get(i1);
            float f2 = bitmap.getX();
            float f3 = bitmap.getY();
            b.add(SPArrow.getInstance().setXY(f2, f3));
        }

        E = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR);
        F = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER);
        g.setAntiAlias(true);
        g.setColor(0xff000000);
        H.setColor(-1);
        H.setAlpha(115);
        o = f1;
        SPArrow sparrow;
        for (bitmap = a.iterator(); bitmap.hasNext(); sparrow.setXY(sparrow.getX() * f1, sparrow.getY() * f1))
        {
            sparrow = (SPArrow)bitmap.next();
        }

        y = b(arraylist);
        y.computeBounds(e, true);
        e(z);
        d(C);
        j = a(c);
        G.setAntiAlias(true);
        G.setFilterBitmap(true);
        G.setStyle(android.graphics.Paint.Style.FILL);
        g.setAntiAlias(true);
        g.setFilterBitmap(true);
        o = f1;
        u = d();
    }

    private float a(int i1, ArrayList arraylist)
    {
        SPArrow sparrow1 = (SPArrow)arraylist.get(b(i1));
        SPArrow sparrow = (SPArrow)arraylist.get(i1);
        arraylist = (SPArrow)arraylist.get(a(i1));
        sparrow1 = sparrow1.subtractArrow(sparrow);
        return SPArrow.angleBetweenArrows(arraylist.subtractArrow(sparrow), sparrow1);
    }

    private int a(int i1)
    {
        if (i1 != a.size() - 1)
        {
            return i1 + 1;
        } else
        {
            return 0;
        }
    }

    private RectF a(Matrix matrix)
    {
        Matrix matrix1 = new Matrix();
        matrix.invert(matrix1);
        matrix = new RectF();
        n.computeBounds(matrix, true);
        matrix1.mapRect(matrix);
        return matrix;
    }

    private SPArrow a(int i1, float f1)
    {
        return a(i1, f1, c);
    }

    private SPArrow a(int i1, float f1, ArrayList arraylist)
    {
        SPArrow sparrow1 = (SPArrow)arraylist.get(b(i1));
        SPArrow sparrow = (SPArrow)arraylist.get(i1);
        arraylist = (SPArrow)arraylist.get(a(i1));
        sparrow1 = sparrow1.subtractArrow(sparrow);
        float f2 = SPArrow.angleBetweenArrows(sparrow1, arraylist.subtractArrow(sparrow)) / 2.0F;
        f1 = (float)Math.abs((double)f1 / Math.sin(f2));
        return sparrow.addArrow(SPArrow.getInstance().setPolarCoordinates(f1, sparrow1.getAngle()).rotateBy(f2));
    }

    private static SPArrow a(ArrayList arraylist, int i1)
    {
        int j1 = i1;
        if (i1 < 0)
        {
            j1 = arraylist.size() + i1 % arraylist.size();
        }
        return (SPArrow)arraylist.get(j1 % arraylist.size());
    }

    private boolean a(float f1, float f2, Matrix matrix)
    {
        matrix.postTranslate(f1, 0.0F);
        matrix.postTranslate(0.0F, f2);
        boolean flag = b(matrix);
        if (t != null && d != null && !d.isRecycled())
        {
            t.setChanged(true);
        }
        return flag;
    }

    private float b(int i1, ArrayList arraylist)
    {
        int j1 = b(i1);
        SPArrow sparrow = (SPArrow)arraylist.get(i1);
        SPArrow sparrow1 = (SPArrow)arraylist.get(j1);
        float f1 = a(i1, arraylist);
        float f2 = a(j1, arraylist);
        SPArrow sparrow2 = sparrow1.subtractArrow(sparrow);
        arraylist = sparrow2.rotateBy(f1 / 2.0F);
        sparrow2 = sparrow2.invert().rotateBy(-f2 / 2.0F);
        return (float)((double)myobfuscated.f.m.a(sparrow, sparrow.addArrow(arraylist), sparrow1, sparrow1.addArrow(sparrow2)).subtractArrow(sparrow).getLength() * Math.sin(f1 / 2.0F));
    }

    private int b(int i1)
    {
        if (i1 != 0)
        {
            return i1 - 1;
        } else
        {
            return a.size() - 1;
        }
    }

    private Path b(ArrayList arraylist)
    {
        Path path = null;
        if (arraylist.size() > 2)
        {
            path = new Path();
            SPArrow sparrow = (SPArrow)arraylist.get(0);
            path.moveTo(sparrow.getX(), sparrow.getY());
            int j1 = arraylist.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                SPArrow sparrow1 = (SPArrow)arraylist.get(i1);
                path.lineTo(sparrow1.getX(), sparrow1.getY());
            }

            path.lineTo(sparrow.getX(), sparrow.getY());
        }
        path.transform(I);
        return path;
    }

    private boolean b(Matrix matrix)
    {
        float f3 = 0.0F;
        RectF rectf = a(matrix);
        Rect rect = new Rect();
        rectf.round(rect);
        if (f.contains(rect) || f.width() == 0 || f.height() == 0)
        {
            return true;
        }
        float f1 = rectf.width();
        float f2 = rectf.height();
        float f4 = f.width();
        float f5 = f.height();
        f1 = Math.max(f1 / f4, f2 / f5);
        if (f1 > 1.0F)
        {
            matrix.preScale(f1, f1);
            rectf = a(matrix);
            Rect rect1 = new Rect();
            rectf.round(rect1);
            if (f.contains(rect1))
            {
                return true;
            }
        }
        if ((float)f.left > rectf.left)
        {
            f1 = rectf.left - (float)f.left;
        } else
        {
            f1 = 0.0F;
        }
        f2 = f1;
        if ((float)f.right < rectf.right)
        {
            f2 = rectf.right - (float)f.right;
        }
        f1 = f3;
        if ((float)f.top > rectf.top)
        {
            f1 = rectf.top - (float)f.top;
        }
        if ((float)f.bottom < rectf.bottom)
        {
            f1 = rectf.bottom - (float)f.bottom;
        }
        matrix.preTranslate(f2, f1);
        if (t != null && d != null && !d.isRecycled())
        {
            t.setChanged(true);
        }
        return false;
    }

    private SPArrow[] b(int i1, float f1)
    {
        int j1 = b(i1);
        int k1 = a(i1);
        SPArrow sparrow2 = (SPArrow)c.get(j1);
        SPArrow sparrow = (SPArrow)c.get(i1);
        SPArrow sparrow1 = (SPArrow)c.get(k1);
        sparrow2 = sparrow2.subtractArrow(sparrow);
        sparrow1 = sparrow1.subtractArrow(sparrow);
        float f2 = SPArrow.angleBetweenArrows(sparrow2, sparrow1);
        f1 = (float)((double)f1 / Math.tan(f2 / 2.0F));
        sparrow2 = SPArrow.getInstance().setPolarCoordinates(f1, sparrow2.getAngle());
        sparrow1 = SPArrow.getInstance().setPolarCoordinates(f1, sparrow1.getAngle());
        return (new SPArrow[] {
            sparrow.addArrow(sparrow2), sparrow.addArrow(sparrow1)
        });
    }

    private void e(float f1)
    {
        z = f1;
        c = new ArrayList();
        int j1 = a.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            SPArrow sparrow = a(i1, f1, a);
            c.add(sparrow);
        }

    }

    private void f()
    {
        float f1 = k;
        int j1;
        if (J > 1.0F)
        {
            k = o - (z + p) * 2.0F;
            l = (1.0F / J) * o - (z + p) * 2.0F;
        } else
        {
            l = o - (z + p) * 2.0F;
            k = J * o - (z + p) * 2.0F;
        }
        j1 = a.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            SPArrow sparrow = (SPArrow)b.get(i1);
            ((SPArrow)a.get(i1)).setXY(sparrow.getX() * k, sparrow.getY() * l);
        }

        y = b(a);
        y.computeBounds(e, true);
        e(z);
        d(C);
        SPArrow sparrow1 = j;
        float f2 = k / f1;
        j = a(c);
        a(f2, j.getX(), j.getY());
        if (f1 != 1.0F && d != null)
        {
            a(j.getX() - sparrow1.getX(), j.getY() - sparrow1.getY(), i);
        }
        n = g();
        L = h();
        u = d();
    }

    private Path g()
    {
        Path path = new Path();
        SPArrow asparrow[] = b(0, B);
        path.moveTo(asparrow[0].getX(), asparrow[0].getY());
        SPArrow sparrow = a(0, B);
        RectF rectf = new RectF(sparrow.getX() - B, sparrow.getY() - B, sparrow.getX() + B, sparrow.getY() + B);
        path.arcTo(rectf, (float)(57.295779513082323D * (double)asparrow[1].subtractArrow(sparrow).getAngle()), (float)(180D - 57.295779513082323D * (double)a(0, c)), true);
        path.moveTo(asparrow[1].getX(), asparrow[1].getY());
        int j1 = c.size();
        for (int i1 = 1; i1 < j1; i1++)
        {
            SPArrow asparrow1[] = b(i1, B);
            path.lineTo(asparrow1[0].getX(), asparrow1[0].getY());
            path.moveTo(asparrow1[0].getX(), asparrow1[0].getY());
            SPArrow sparrow1 = a(i1, B);
            rectf.set(sparrow1.getX() - B, sparrow1.getY() - B, sparrow1.getX() + B, sparrow1.getY() + B);
            path.arcTo(rectf, (float)((double)asparrow1[1].subtractArrow(sparrow1).getAngle() * 57.295779513082323D), (float)(180D - 57.295779513082323D * (double)a(i1, c)), true);
            path.moveTo(asparrow1[1].getX(), asparrow1[1].getY());
        }

        path.lineTo(asparrow[0].getX(), asparrow[0].getY());
        path.transform(I);
        return path;
    }

    private Path h()
    {
        Path path = new Path();
        path.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        SPArrow asparrow[] = b(0, B);
        path.moveTo(asparrow[0].getX(), asparrow[0].getY());
        SPArrow sparrow = a(0, B);
        RectF rectf = new RectF(sparrow.getX() - B, sparrow.getY() - B, sparrow.getX() + B, sparrow.getY() + B);
        path.arcTo(rectf, (float)(57.295779513082323D * (double)asparrow[1].subtractArrow(sparrow).getAngle()), (float)(180D - 57.295779513082323D * (double)a(0, c)));
        path.moveTo(asparrow[1].getX(), asparrow[1].getY());
        int j1 = c.size();
        for (int i1 = 1; i1 < j1; i1++)
        {
            SPArrow asparrow1[] = b(i1, B);
            path.lineTo(asparrow1[0].getX(), asparrow1[0].getY());
            SPArrow sparrow1 = a(i1, B);
            rectf.set(sparrow1.getX() - B, sparrow1.getY() - B, sparrow1.getX() + B, sparrow1.getY() + B);
            path.arcTo(rectf, (float)((double)asparrow1[1].subtractArrow(sparrow1).getAngle() * 57.295779513082323D), (float)(180D - 57.295779513082323D * (double)a(i1, c)));
            path.lineTo(asparrow1[1].getX(), asparrow1[1].getY());
        }

        path.lineTo(asparrow[0].getX(), asparrow[0].getY());
        path.close();
        path.transform(I);
        path.computeBounds(D, false);
        return path;
    }

    public final PointF a()
    {
        return new PointF(D.centerX(), D.centerY());
    }

    final SPArrow a(ArrayList arraylist)
    {
        SPArrow sparrow1 = (SPArrow)arraylist.get(0);
        SPArrow sparrow = SPArrow.getInstance();
        int j1 = arraylist.size();
        int i1 = 1;
        float f1 = 0.0F;
        for (; i1 < j1; i1++)
        {
            SPArrow sparrow2 = (SPArrow)arraylist.get(i1);
            SPArrow sparrow3 = (SPArrow)arraylist.get(a(i1));
            float f2 = myobfuscated.f.m.a(sparrow1, sparrow2, sparrow3);
            f1 += f2;
            SPArrow sparrow4 = SPArrow.getInstance();
            float f3 = (sparrow1.getX() + sparrow2.getX() + sparrow3.getX()) / 3F;
            float f4 = sparrow1.getY();
            sparrow = sparrow.addArrow(sparrow4.setXY(f3, (sparrow2.getY() + f4 + sparrow3.getY()) / 3F).scaleBy(f2));
        }

        if (f1 > 0.0F)
        {
            return sparrow.scaleBy(1.0F / f1);
        } else
        {
            return SPArrow.getInstance();
        }
    }

    public final void a(float f1)
    {
        float f2 = f1;
        if (m % 180 != 0)
        {
            f2 = 1.0F / f1;
        }
        J = f2;
        RectF rectf;
        if (J > 1.0F)
        {
            f2 = o - (z + p) * 2.0F;
            f1 = (1.0F / J) * o - (z + p) * 2.0F;
        } else
        {
            f1 = o - (z + p) * 2.0F;
            f2 = J * o - (z + p) * 2.0F;
        }
        rectf = new RectF(f);
        i.mapRect(rectf);
        f1 = Math.min(f2 / k, f1 / l);
        j = a(c);
        if (f1 < 1.0F)
        {
            a(f1, j.getX(), j.getY());
        }
        f();
    }

    public final void a(float f1, float f2, float f3)
    {
        if (f1 != 0.0F)
        {
            RectF rectf = new RectF(e);
            i.mapRect(rectf);
            if (rectf.width() / e.width() <= 4F || f1 <= 1.0F)
            {
                Matrix matrix = new Matrix(i);
                matrix.postTranslate(-f2, -f3);
                matrix.postScale(f1, f1);
                matrix.postTranslate(f2, f3);
                b(matrix);
                i.set(matrix);
                if (t != null && d != null && !d.isRecycled())
                {
                    t.setChanged(true);
                    return;
                }
            }
        }
    }

    public final void a(Bitmap bitmap, boolean flag, CollageImage collageimage, boolean flag1)
    {
        Bitmap bitmap1 = null;
        RectF rectf = new RectF(f);
        if (flag)
        {
            bitmap1 = d;
        }
        h = 0.0F;
        int i1;
        if (collageimage == null)
        {
            i1 = 0;
        } else
        {
            i1 = collageimage.getDegree();
        }
        do
        {
            w = i1;
            if (w >= 0)
            {
                break;
            }
            i1 = w + 360;
        } while (true);
        d = bitmap;
        x = collageimage;
        if (bitmap == null)
        {
            if (bitmap1 != null)
            {
                bitmap1.recycle();
            }
        } else
        {
            f.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            if (flag1)
            {
                float f1 = f.width();
                float f2 = f.height();
                float f3 = e.width();
                float f4 = e.height();
                i = new Matrix();
                f3 = Math.max(f4 / f2, f3 / f1);
                i.postScale(f3, f3);
                i.postTranslate(e.left - (f1 * f3 - e.width()) / 2.0F, e.top - (f2 * f3 - e.height()) / 2.0F);
            } else
            if (rectf.width() != 0.0F && rectf.height() != 0.0F)
            {
                (new Matrix()).mapRect(new RectF(f), rectf);
                i.preScale(rectf.width() / (float)f.width(), rectf.height() / (float)f.height());
            }
            if (bitmap1 != null)
            {
                bitmap1.recycle();
            }
            if (t != null && bitmap != null && !bitmap.isRecycled())
            {
                t.setChanged(true);
                return;
            }
        }
    }

    public final void a(Canvas canvas, float f1, float f2)
    {
        int i1 = canvas.save();
        canvas.translate(f1 * 1.0F, f2 * 1.0F);
        canvas.rotate(q, D.centerX() * 1.0F, D.centerY() * 1.0F);
        Matrix matrix = new Matrix();
        matrix.postScale(1.0F, 1.0F);
        Path path = h();
        path.transform(matrix);
        path.computeBounds(new RectF(), true);
        g.setXfermode(E);
        canvas.drawPath(path, g);
        if (d != null)
        {
            Matrix matrix1 = new Matrix(i);
            matrix1.postScale(1.0F, 1.0F);
            g.setXfermode(F);
            canvas.drawBitmap(d, matrix1, g);
        } else
        {
            canvas.drawPath(path, G);
        }
        g.setXfermode(null);
        g.setAlpha(255);
        canvas.restoreToCount(i1);
    }

    public final void a(Canvas canvas, float f1, float f2, boolean flag)
    {
        if (canvas == null || L == null)
        {
            return;
        }
        canvas.save();
        canvas.translate(f1, f2);
        canvas.rotate(q, D.centerX(), D.centerY());
        g.setXfermode(E);
        canvas.drawPath(L, g);
        if (d == null || d.isRecycled()) goto _L2; else goto _L1
_L1:
        g.setXfermode(F);
        canvas.drawBitmap(d, i, g);
_L4:
        g.setXfermode(null);
        if (flag)
        {
            canvas.drawPath(L, H);
        }
        g.setAlpha(255);
        canvas.restore();
        return;
_L2:
        if (r)
        {
            g.setXfermode(null);
            canvas.drawPath(L, G);
            canvas.drawBitmap(K, j.getX() - (float)K.getWidth() / 2.0F, j.getY() - (float)K.getHeight() / 2.0F, g);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(CollageImage collageimage, boolean flag, Matrix matrix, boolean flag1, myobfuscated.ax.a a1)
    {
        if (s != null)
        {
            s.cancel(true);
        }
        x = collageimage;
        if (matrix != null)
        {
            i = matrix;
        }
        s = new ModernAsyncTask(flag1, collageimage, flag, a1) {

            private boolean a;
            private CollageImage b;
            private boolean c;
            private myobfuscated.ax.a d;
            private a e;

            private transient Bitmap a(String as[])
            {
                int i1;
                if (a)
                {
                    i1 = e.t.a();
                } else
                {
                    i1 = PicsartContext.a.getMaxCollageSaveSize() * 2;
                }
                if (b.isFromBuffer())
                {
                    return com.socialin.android.util.w.a(b.getBufferData(), i1, i1, b.getDegree());
                }
                try
                {
                    as = com.socialin.android.util.w.a(as[0], i1, i1, b.getDegree());
                }
                // Misplaced declaration of an exception variable
                catch (String as[])
                {
                    return null;
                }
                return as;
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a((String[])aobj);
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (Bitmap)obj;
                if (!isCancelled())
                {
                    if (obj == null)
                    {
                        Toast.makeText(SocialinV3.getInstance().getContext(), SocialinV3.getInstance().getContext().getString(0x7f080429), 0).show();
                    }
                    if (e.d != null && obj != null && (float)e.d.getWidth() / (float)e.d.getHeight() == (float)((Bitmap) (obj)).getHeight() / (float)((Bitmap) (obj)).getWidth() && (float)e.d.getWidth() / (float)e.d.getHeight() != 1.0F)
                    {
                        e.f.set(e.f.left - (e.f.height() - e.f.width()) / 2, e.f.top + (e.f.height() - e.f.width()) / 2, (e.f.left - (e.f.height() - e.f.width()) / 2) + e.f.height(), e.f.top + (e.f.height() - e.f.width()) / 2 + e.f.width());
                    }
                    a a2 = e;
                    CollageImage collageimage1 = b;
                    boolean flag2;
                    if (!c)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    a2.a(((Bitmap) (obj)), true, collageimage1, flag2);
                    e.c();
                    e.v = false;
                    e.t.invalidate();
                    if (d != null)
                    {
                        d.a(e);
                    }
                }
            }

            
            {
                e = a.this;
                a = flag;
                b = collageimage;
                c = flag1;
                d = a2;
                super();
            }
        };
        if (collageimage != null)
        {
            s.execute(new String[] {
                collageimage.getPath()
            });
            if (t != null && d != null && !d.isRecycled())
            {
                t.setChanged(true);
            }
            return;
        } else
        {
            a(((Bitmap) (null)), true, collageimage, true);
            v = false;
            t.invalidate();
            return;
        }
    }

    public final boolean a(float f1, float f2)
    {
        return a(f1, f2, i);
    }

    public final boolean a(int i1, int j1)
    {
        i1 = (int)((float)i1 - z - p);
        j1 = (int)((float)j1 - z - p);
        RectF rectf = new RectF();
        y.computeBounds(rectf, true);
        Region region = new Region();
        region.setPath(y, new Region((int)rectf.left, (int)rectf.top, (int)rectf.right, (int)rectf.bottom));
        return region.contains(i1, j1);
    }

    public final boolean a(int i1, SPArrow sparrow, boolean flag)
    {
        SPArrow sparrow3;
        SPArrow sparrow4;
        SPArrow sparrow5;
        SPArrow sparrow6;
        SPArrow sparrow7;
        sparrow5 = a(a, i1);
        sparrow3 = a(a, i1 + 1);
        sparrow6 = a(a, i1 - 1);
        sparrow4 = a(a, i1 + 2);
        sparrow7 = sparrow5.subtractArrow(sparrow3);
        if (myobfuscated.f.m.a(sparrow, sparrow7)) goto _L2; else goto _L1
_L1:
        float f1;
        float f2;
        f1 = myobfuscated.f.m.b(sparrow6, sparrow5, sparrow3);
        f2 = myobfuscated.f.m.b(sparrow4, sparrow5, sparrow3);
        if (myobfuscated.f.m.b(sparrow5.addArrow(sparrow), sparrow5, sparrow3) <= Math.min(f1, f2) - M - z * 2.0F) goto _L4; else goto _L3
_L3:
        return false;
_L2:
        SPArrow sparrow1;
        SPArrow sparrow8;
        sparrow8 = myobfuscated.f.m.a(sparrow6, sparrow5, sparrow3, sparrow4);
        sparrow1 = null;
        if (sparrow8 != null)
        {
            sparrow1 = sparrow5.subtractArrow(sparrow8);
        }
        if (sparrow1 != null && !myobfuscated.f.m.a(sparrow1, sparrow7) && myobfuscated.f.m.b(sparrow5.addArrow(sparrow), sparrow5, sparrow3) > myobfuscated.f.m.b(sparrow8, sparrow5, sparrow3) - M - z * 2.0F) goto _L3; else goto _L4
_L4:
        if (flag)
        {
            SPArrow sparrow2 = sparrow5.addArrow(sparrow);
            sparrow = sparrow3.addArrow(sparrow);
            sparrow5 = myobfuscated.f.m.a(sparrow6, sparrow5, sparrow2, sparrow);
            sparrow = myobfuscated.f.m.a(sparrow4, sparrow3, sparrow2, sparrow);
            if (sparrow5 != null && sparrow != null)
            {
                a(a, i1).setXY(sparrow5.getX(), sparrow5.getY());
                a(a, i1 + 1).setXY(sparrow.getX(), sparrow.getY());
                a(b, i1).setXY(sparrow5.getX() / k, sparrow5.getY() / l);
                a(b, i1 + 1).setXY(sparrow.getX() / k, sparrow.getY() / l);
            }
            f();
        }
        return true;
    }

    public final PointF b()
    {
        PointF pointf = new PointF();
        SPArrow sparrow = a(c);
        pointf.x = sparrow.getX();
        pointf.y = sparrow.getY();
        return pointf;
    }

    public final void b(float f1)
    {
        o = f1;
        f();
    }

    public final void b(float f1, float f2, float f3)
    {
        float f4 = h;
        Matrix matrix = new Matrix(i);
        h = h + f1;
        matrix.postRotate(f1, f2, f3);
        b(matrix);
        i.set(matrix);
        h = f4 + f1;
        if (t != null && d != null && !d.isRecycled())
        {
            t.setChanged(true);
        }
    }

    public final void c()
    {
        if (x != null)
        {
            b(i);
        }
    }

    public final void c(float f1)
    {
        z = f1;
        e(f1);
        d(C);
        j = a(c);
        n = g();
        L = h();
        if (t != null && d != null && !d.isRecycled())
        {
            t.setChanged(true);
        }
    }

    public final float d()
    {
        float f1 = 3.402823E+38F;
        for (int i1 = 0; i1 < c.size(); i1++)
        {
            f1 = Math.min(f1, b(i1, b));
        }

        return ((o - (z + p) * 2.0F) * f1) / 2.0F;
    }

    public final void d(float f1)
    {
        float f2 = 3.402823E+38F;
        for (int i1 = 0; i1 < c.size(); i1++)
        {
            f2 = Math.min(f2, b(i1, c));
        }

        A = f2;
        C = f1;
        B = A * (f1 / 100F);
        n = g();
        b(i);
        L = h();
        if (t != null && d != null && !d.isRecycled())
        {
            t.setChanged(true);
        }
    }

    public final int e()
    {
        int j1 = (Math.round(h / 90F) * 90) % 360;
        int i1 = j1;
        if (j1 < 0)
        {
            i1 = j1 + 360;
        }
        return i1;
    }
}
