// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.utils.UserSavedState;
import com.socialin.android.brushlib.input.gesture.a;
import com.socialin.android.brushlib.input.gesture.d;
import com.socialin.android.brushlib.input.gesture.g;
import com.socialin.android.brushlib.input.gesture.i;
import com.socialin.android.util.Geom;
import com.socialin.android.util.c;

// Referenced classes of package com.picsart.studio.editor.view:
//            EditorView, t

public class TiltShiftEditorView extends EditorView
{

    private final float A[];
    private final Matrix B;
    private float C;
    private boolean D;
    private float E;
    private RectF F;
    private RectF G;
    private RectF H;
    private float I;
    private float J;
    private PointF K;
    private byte L;
    private float M;
    public Bitmap i;
    public boolean j;
    public boolean k;
    public int l;
    private d m;
    private g n;
    private a o;
    private Bitmap p;
    private Bitmap q;
    private Bitmap r;
    private Paint s;
    private Paint t;
    private Paint u;
    private Paint v;
    private Paint w;
    private Paint x;
    private Paint y;
    private com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode z;

    public TiltShiftEditorView(Context context)
    {
        this(context, null);
    }

    public TiltShiftEditorView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public TiltShiftEditorView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        z = com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode.LINEAR;
        A = new float[2];
        B = new Matrix();
        D = false;
        E = 0.0F;
        I = 0.3F;
        J = 0.2F;
        K = new PointF();
        L = 0;
        k = true;
        M = 1.0F;
        l = 0;
        s = new Paint(2);
        s.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
        v = new Paint(3);
        t = new Paint(2);
        t.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
        u = new Paint(-1);
        u.setDither(true);
        w = new Paint();
        w.setAntiAlias(true);
        w.setFilterBitmap(true);
        x = new Paint(-1);
        x.setStyle(android.graphics.Paint.Style.STROKE);
        x.setAntiAlias(true);
        y = new Paint(-1);
        y.setStyle(android.graphics.Paint.Style.STROKE);
        y.setPathEffect(new DashPathEffect(new float[] {
            20F, 15F
        }, 5F));
        y.setAntiAlias(true);
        context = new t(this, (byte)0);
        n = new g(context);
        n.a = 0.0F;
        o = new a(context);
        context = new i(context);
        context.b = 30F;
        context.a = 230L;
        m = new d();
        m.a(n);
        m.a(o);
        m.a(context);
        F = new RectF();
        G = new RectF();
        H = new RectF();
        q = com.socialin.android.util.c.a(getResources(), 0x7f02075c);
        r = com.socialin.android.util.c.a(getResources(), 0x7f02011b);
    }

    static byte a(TiltShiftEditorView tiltshifteditorview, byte byte0)
    {
        tiltshifteditorview.L = byte0;
        return byte0;
    }

    private void a(Canvas canvas, Paint paint, float f1)
    {
        canvas.drawLine(G.width() * -2F, f1, 3F * G.width(), f1 + 1.0F, paint);
    }

    static void a(TiltShiftEditorView tiltshifteditorview, float f1)
    {
        float f2;
        float f3;
        f2 = 1.0F;
        f3 = Math.max(tiltshifteditorview.e.getWidth(), tiltshifteditorview.e.getHeight());
        if (f1 <= 1.0F) goto _L2; else goto _L1
_L1:
        f2 = Math.min(f1, (0.9F * f3 * tiltshifteditorview.c.e) / (tiltshifteditorview.G.height() * tiltshifteditorview.I));
_L4:
        tiltshifteditorview.I = f2 * tiltshifteditorview.I;
        if (tiltshifteditorview.J * 2.0F + tiltshifteditorview.I > 0.9F)
        {
            tiltshifteditorview.J = tiltshifteditorview.J / 2.0F;
            tiltshifteditorview.I = tiltshifteditorview.I / 2.0F;
            Geom.c(tiltshifteditorview.F, tiltshifteditorview.F.centerX(), tiltshifteditorview.F.centerY(), 2.0F);
        }
        tiltshifteditorview.e();
        tiltshifteditorview.invalidate();
        return;
_L2:
        if (f1 < 1.0F)
        {
            f2 = Math.max(f1, 24F / (tiltshifteditorview.G.height() * tiltshifteditorview.I));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void a(TiltShiftEditorView tiltshifteditorview, float f1, float f2)
    {
        if (tiltshifteditorview.L == 0) goto _L2; else goto _L1
_L1:
        float f3;
        f3 = Math.min(tiltshifteditorview.e.getWidth(), tiltshifteditorview.e.getHeight());
        tiltshifteditorview.A[0] = f1;
        tiltshifteditorview.A[1] = f2;
        tiltshifteditorview.B.reset();
        tiltshifteditorview.B.setRotate(-tiltshifteditorview.C);
        tiltshifteditorview.B.mapPoints(tiltshifteditorview.A);
        f2 = tiltshifteditorview.A[1];
        if (tiltshifteditorview.L != 1) goto _L4; else goto _L3
_L3:
        if (f2 <= 0.0F) goto _L6; else goto _L5
_L5:
        f1 = f2 * Math.min(1.0F, (f3 * 0.35F - tiltshifteditorview.F.height() * tiltshifteditorview.J) / f2);
_L7:
        f2 = tiltshifteditorview.J;
        tiltshifteditorview.J = (f1 * (float)tiltshifteditorview.L) / tiltshifteditorview.F.height() + f2;
        if (tiltshifteditorview.I + tiltshifteditorview.J * 2.0F > 0.9F)
        {
            tiltshifteditorview.J = tiltshifteditorview.J / 2.0F;
            tiltshifteditorview.I = tiltshifteditorview.I / 2.0F;
            Geom.c(tiltshifteditorview.F, tiltshifteditorview.F.centerX(), tiltshifteditorview.F.centerY(), 2.0F);
        }
        tiltshifteditorview.e();
        tiltshifteditorview.invalidate();
        return;
_L6:
        f1 = f2;
        if (f2 < 0.0F)
        {
            f1 = f2 * Math.min(1.0F, (-tiltshifteditorview.F.height() * tiltshifteditorview.J) / f2);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        f1 = f2;
        if (tiltshifteditorview.L == -1)
        {
            if (f2 > 0.0F)
            {
                f1 = f2 * Math.min(1.0F, (tiltshifteditorview.F.height() * tiltshifteditorview.J) / f2);
            } else
            {
                f1 = f2;
                if (f2 < 0.0F)
                {
                    f1 = f2 * Math.min(1.0F, (tiltshifteditorview.F.height() * tiltshifteditorview.J - f3 * 0.35F) / f2);
                }
            }
        }
        if (true) goto _L7; else goto _L2
_L2:
        float f5 = f1 * tiltshifteditorview.c.e;
        float f4 = tiltshifteditorview.c.e * f2;
        if (f5 > 0.0F)
        {
            f1 = f5 * Math.min(1.0F, ((float)tiltshifteditorview.e.getWidth() * tiltshifteditorview.c.e - 12F - tiltshifteditorview.G.centerX()) / f5);
        } else
        {
            f1 = f5;
            if (f5 < 0.0F)
            {
                f1 = f5 * Math.min(1.0F, (12F - tiltshifteditorview.G.centerX()) / f5);
            }
        }
        if (f4 > 0.0F)
        {
            f2 = f4 * Math.min(1.0F, ((float)tiltshifteditorview.e.getHeight() * tiltshifteditorview.c.e - 12F - tiltshifteditorview.G.centerY()) / f4);
        } else
        {
            f2 = f4;
            if (f4 < 0.0F)
            {
                f2 = f4 * Math.min(1.0F, (12F - tiltshifteditorview.G.centerY()) / f4);
            }
        }
        tiltshifteditorview.G.offset(f1, f2);
        tiltshifteditorview.F.set(tiltshifteditorview.G.left / tiltshifteditorview.c.e, tiltshifteditorview.G.top / tiltshifteditorview.c.e, tiltshifteditorview.G.right / tiltshifteditorview.c.e, tiltshifteditorview.G.bottom / tiltshifteditorview.c.e);
        tiltshifteditorview.invalidate();
        return;
    }

    static void a(TiltShiftEditorView tiltshifteditorview, float f1, float f2, float f3)
    {
        tiltshifteditorview.A[0] = tiltshifteditorview.F.centerX();
        tiltshifteditorview.A[1] = tiltshifteditorview.F.centerY();
        Geom.a(tiltshifteditorview.A, f1, f2, f3);
        Geom.a(tiltshifteditorview.F, tiltshifteditorview.A[0], tiltshifteditorview.A[1]);
        tiltshifteditorview.E = tiltshifteditorview.E + f1;
        if (Math.abs(tiltshifteditorview.E) > 8F)
        {
            tiltshifteditorview.E = 1000F;
            tiltshifteditorview.C = tiltshifteditorview.C + f1;
        }
        tiltshifteditorview.C = tiltshifteditorview.C % 360F;
        if (Math.abs(tiltshifteditorview.C) > 180F)
        {
            tiltshifteditorview.C = tiltshifteditorview.C - (tiltshifteditorview.C * 360F) / Math.abs(tiltshifteditorview.C);
        }
        f1 = tiltshifteditorview.g();
        if (Math.abs(f1) >= 8F)
        {
            tiltshifteditorview.D = true;
        }
        if (tiltshifteditorview.C != tiltshifteditorview.f())
        {
            tiltshifteditorview.C = tiltshifteditorview.f();
            tiltshifteditorview.D = false;
            tiltshifteditorview.E = (4F * Math.abs(f1)) / f1;
        }
        tiltshifteditorview.invalidate();
    }

    static float[] a(TiltShiftEditorView tiltshifteditorview)
    {
        return tiltshifteditorview.A;
    }

    static float b(TiltShiftEditorView tiltshifteditorview)
    {
        return tiltshifteditorview.C;
    }

    static float b(TiltShiftEditorView tiltshifteditorview, float f1)
    {
        tiltshifteditorview.C = f1;
        return f1;
    }

    static RectF c(TiltShiftEditorView tiltshifteditorview)
    {
        return tiltshifteditorview.F;
    }

    static PointF d(TiltShiftEditorView tiltshifteditorview)
    {
        return tiltshifteditorview.K;
    }

    static float e(TiltShiftEditorView tiltshifteditorview)
    {
        return tiltshifteditorview.I;
    }

    private void e()
    {
        if (i != null && !i.isRecycled())
        {
            Canvas canvas = new Canvas(i);
            canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
            if (z == com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode.LINEAR)
            {
                float f1 = ((float)i.getHeight() * (1.0F - I - J * 2.0F)) / 2.0F;
                float f3 = i.getHeight() / 2;
                float f5 = J / (J + I / 2.0F);
                Object obj = android.graphics.Shader.TileMode.MIRROR;
                obj = new LinearGradient(0.0F, f1, 0.0F, f3, new int[] {
                    0, -1, -1
                }, new float[] {
                    0.0F, f5, 1.0F
                }, ((android.graphics.Shader.TileMode) (obj)));
                u.setShader(((android.graphics.Shader) (obj)));
                canvas.drawRect(0.0F, ((float)i.getHeight() * (1.0F - I - J * 2.0F)) / 2.0F, i.getWidth(), ((float)i.getHeight() * (I + 1.0F + J * 2.0F)) / 2.0F, u);
            } else
            if (z == com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode.RADIAL)
            {
                float f2 = i.getWidth() / 2;
                float f4 = i.getHeight() / 2;
                float f6 = i.getHeight();
                float f7 = I / 2.0F;
                float f8 = J;
                float f9 = I / (I + J * 2.0F);
                Object obj1 = android.graphics.Shader.TileMode.CLAMP;
                obj1 = new RadialGradient(f2, f4, f6 * (f7 + f8), new int[] {
                    -1, -1, 0
                }, new float[] {
                    0.0F, f9, 1.0F
                }, ((android.graphics.Shader.TileMode) (obj1)));
                u.setShader(((android.graphics.Shader) (obj1)));
                canvas.drawCircle(i.getWidth() / 2, i.getHeight() / 2, (float)i.getHeight() * (I / 2.0F + J), u);
                return;
            }
        }
    }

    private float f()
    {
        float f1 = g();
        if (D && Math.abs(f1) < 8F)
        {
            return C - f1;
        } else
        {
            return C;
        }
    }

    static float f(TiltShiftEditorView tiltshifteditorview)
    {
        return tiltshifteditorview.J;
    }

    private float g()
    {
        return C - (float)(Math.round(C / 90F) * 90);
    }

    static Bitmap g(TiltShiftEditorView tiltshifteditorview)
    {
        return tiltshifteditorview.q;
    }

    static byte h(TiltShiftEditorView tiltshifteditorview)
    {
        return tiltshifteditorview.L;
    }

    static com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode i(TiltShiftEditorView tiltshifteditorview)
    {
        return tiltshifteditorview.z;
    }

    static boolean j(TiltShiftEditorView tiltshifteditorview)
    {
        return tiltshifteditorview.k;
    }

    static boolean k(TiltShiftEditorView tiltshifteditorview)
    {
        tiltshifteditorview.D = false;
        return false;
    }

    static float l(TiltShiftEditorView tiltshifteditorview)
    {
        tiltshifteditorview.E = 0.0F;
        return 0.0F;
    }

    static boolean m(TiltShiftEditorView tiltshifteditorview)
    {
        return tiltshifteditorview.D;
    }

    static float n(TiltShiftEditorView tiltshifteditorview)
    {
        return tiltshifteditorview.M;
    }

    static float o(TiltShiftEditorView tiltshifteditorview)
    {
        tiltshifteditorview.M = 1.0F;
        return 1.0F;
    }

    static float p(TiltShiftEditorView tiltshifteditorview)
    {
        return tiltshifteditorview.f();
    }

    static boolean q(TiltShiftEditorView tiltshifteditorview)
    {
        return tiltshifteditorview.j;
    }

    public final Bitmap a(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            Bitmap bitmap2 = com.socialin.android.util.c.a(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            if (bitmap2 == null)
            {
                return null;
            }
            Canvas canvas = new Canvas(bitmap2);
            Geom.c(F, 0.0F, 0.0F, (float)bitmap.getWidth() / (float)f.getWidth());
            canvas.save();
            if (p != null)
            {
                canvas.drawColor(0xff000000);
                Bitmap bitmap1;
                if (j)
                {
                    bitmap1 = bitmap;
                } else
                {
                    bitmap1 = p;
                }
                canvas.drawBitmap(bitmap1, 0.0F, 0.0F, v);
                canvas.save();
                canvas.rotate(C, F.centerX(), F.centerY());
                if (z == com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode.LINEAR)
                {
                    H.set(bitmap.getWidth() * -2, F.top, bitmap.getWidth() * 3, F.bottom);
                } else
                {
                    H.set(F);
                }
                canvas.drawBitmap(i, null, H, t);
                canvas.restore();
                if (j)
                {
                    bitmap = p;
                }
                canvas.drawBitmap(bitmap, 0.0F, 0.0F, s);
            } else
            {
                canvas.drawBitmap(bitmap, 0.0F, 0.0F, v);
            }
            canvas.restore();
            return bitmap2;
        } else
        {
            return null;
        }
    }

    protected final void a(Canvas canvas)
    {
        c.b(canvas);
        if (e != null && !e.isRecycled())
        {
            canvas.save();
            if (p != null)
            {
                canvas.drawColor(0xff000000);
                float f1;
                Bitmap bitmap;
                if (j)
                {
                    bitmap = e;
                } else
                {
                    bitmap = p;
                }
                canvas.drawBitmap(bitmap, 0.0F, 0.0F, v);
                canvas.save();
                canvas.rotate(C, F.centerX(), F.centerY());
                if (z == com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode.LINEAR)
                {
                    H.set(e.getWidth() * -2, F.top, e.getWidth() * 3, F.bottom);
                } else
                {
                    H.set(F);
                }
                canvas.drawBitmap(i, null, H, t);
                canvas.restore();
                if (j)
                {
                    bitmap = p;
                } else
                {
                    bitmap = e;
                }
                canvas.drawBitmap(bitmap, 0.0F, 0.0F, s);
            } else
            {
                canvas.drawBitmap(e, 0.0F, 0.0F, v);
            }
            canvas.restore();
        }
        canvas.restore();
        if (p != null && k)
        {
            canvas.save();
            G.set(F.left * c.e, F.top * c.e, F.right * c.e, F.bottom * c.e);
            canvas.translate(c.a / 2.0F, c.b / 2.0F);
            canvas.translate(-c.c * c.e, -c.d * c.e);
            canvas.clipRect(0.0F, 0.0F, (float)e.getWidth() * c.e, (float)e.getHeight() * c.e);
            canvas.rotate(C, G.centerX(), G.centerY());
            f1 = Math.min(e.getWidth(), e.getHeight());
            if (F.height() * J >= f1 * 0.34F)
            {
                canvas.drawBitmap(q, G.centerX() - (float)(q.getWidth() / 2), G.centerY() + G.height() * (I / 2.0F + J) + 12F, w);
                canvas.save();
                canvas.rotate(180F, G.centerX(), G.centerY());
                canvas.drawBitmap(q, G.centerX() - (float)(q.getWidth() / 2), G.centerY() + G.height() * (I / 2.0F + J) + 12F, w);
                canvas.restore();
            } else
            {
                canvas.drawBitmap(q, G.centerX() - (float)(q.getWidth() / 2), G.centerY() - G.height() * (I / 2.0F + J) - 12F - (float)q.getHeight(), w);
                canvas.save();
                canvas.rotate(180F, G.centerX(), G.centerY());
                canvas.drawBitmap(q, G.centerX() - (float)(q.getWidth() / 2), G.centerY() - G.height() * (I / 2.0F + J) - 12F - (float)q.getHeight(), w);
                canvas.restore();
            }
            if (z == com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode.LINEAR)
            {
                x.setColor(0x66888888);
                x.setStrokeWidth(3F);
                a(canvas, x, G.centerY() - (G.height() * I) / 2.0F);
                a(canvas, x, G.centerY() + (G.height() * I) / 2.0F);
                x.setColor(-1);
                x.setStrokeWidth(1.0F);
                a(canvas, x, G.centerY() - (G.height() * I) / 2.0F);
                a(canvas, x, G.centerY() + (G.height() * I) / 2.0F);
                y.setColor(0x66888888);
                y.setStrokeWidth(3F);
                a(canvas, y, G.centerY() - G.height() * (I / 2.0F + J));
                a(canvas, y, G.centerY() + G.height() * (I / 2.0F + J));
                y.setColor(-1);
                y.setStrokeWidth(1.0F);
                a(canvas, y, G.centerY() - G.height() * (I / 2.0F + J));
                a(canvas, y, G.centerY() + G.height() * (I / 2.0F + J));
            } else
            {
                x.setColor(0x66888888);
                x.setStrokeWidth(3F);
                canvas.drawCircle(G.centerX(), G.centerY(), (G.height() * I) / 2.0F, x);
                x.setColor(-1);
                x.setStrokeWidth(1.0F);
                canvas.drawCircle(G.centerX(), G.centerY(), (G.height() * I) / 2.0F, x);
                y.setStyle(android.graphics.Paint.Style.STROKE);
                y.setColor(0x66888888);
                y.setStrokeWidth(3F);
                canvas.drawCircle(G.centerX(), G.centerY(), G.height() * (I / 2.0F + J), y);
                y.setColor(-1);
                y.setStrokeWidth(1.0F);
                canvas.drawCircle(G.centerX(), G.centerY(), G.height() * (I / 2.0F + J), y);
            }
            canvas.drawBitmap(r, G.centerX() - (float)(r.getWidth() / 2), G.centerY() - (float)(r.getHeight() / 2), w);
            canvas.restore();
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        boolean flag1 = true;
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(((UserSavedState) (parcelable)).a);
        z = com.picsart.studio.editor.view.SavedState.a(parcelable);
        boolean flag;
        if (SavedState.b(parcelable) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = flag;
        if (com.picsart.studio.editor.view.SavedState.c(parcelable) == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        k = flag;
        F = com.picsart.studio.editor.view.SavedState.d(parcelable);
        I = SavedState.e(parcelable);
        J = SavedState.f(parcelable);
        C = com.picsart.studio.editor.view.SavedState.g(parcelable);
        l = SavedState.h(parcelable);
        setMode(z);
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), this);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!k)
        {
            super.onTouchEvent(motionevent);
        }
        m.a(motionevent);
        return true;
    }

    public void setBlurredImage(Bitmap bitmap)
    {
        p = bitmap;
    }

    public void setImage(Bitmap bitmap)
    {
        super.setImage(bitmap);
        if (bitmap != null)
        {
            i = com.socialin.android.util.c.a(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            F.set(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
            G.set(0.0F, 0.0F, (float)bitmap.getWidth() * c.e, (float)bitmap.getHeight() * c.e);
            e();
        }
    }

    public void setInverted(boolean flag)
    {
        j = flag;
        e();
        invalidate();
    }

    public void setMode(com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode tiltshiftmode)
    {
        z = tiltshiftmode;
        e();
        invalidate();
    }

    public void setShowHandlers(boolean flag)
    {
        k = flag;
        n.b = flag;
        o.a = flag;
        invalidate();
    }

    private class SavedState extends UserSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object[] newArray(int i1)
            {
                return new SavedState[i1];
            }

        };
        private com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode b;
        private byte c;
        private byte d;
        private RectF e;
        private float f;
        private float g;
        private float h;
        private int i;

        static com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode a(SavedState savedstate)
        {
            return savedstate.b;
        }

        static byte b(SavedState savedstate)
        {
            return savedstate.c;
        }

        static byte c(SavedState savedstate)
        {
            return savedstate.d;
        }

        static RectF d(SavedState savedstate)
        {
            return savedstate.e;
        }

        static float e(SavedState savedstate)
        {
            return savedstate.f;
        }

        static float f(SavedState savedstate)
        {
            return savedstate.g;
        }

        static float g(SavedState savedstate)
        {
            return savedstate.h;
        }

        static int h(SavedState savedstate)
        {
            return savedstate.i;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeString(b.name());
            parcel.writeByte(c);
            parcel.writeByte(d);
            parcel.writeParcelable(e, i1);
            parcel.writeFloat(f);
            parcel.writeFloat(g);
            parcel.writeFloat(h);
            parcel.writeInt(i);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            b = com.picsart.studio.editor.fragment.TiltShiftFragment.TiltShiftMode.valueOf(parcel.readString());
            c = parcel.readByte();
            d = parcel.readByte();
            e = (RectF)parcel.readParcelable(android/graphics/RectF.getClassLoader());
            f = parcel.readFloat();
            g = parcel.readFloat();
            h = parcel.readFloat();
            i = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, TiltShiftEditorView tiltshifteditorview)
        {
            boolean flag = true;
            super(parcelable);
            b = com.picsart.studio.editor.view.TiltShiftEditorView.i(tiltshifteditorview);
            byte byte0;
            if (TiltShiftEditorView.q(tiltshifteditorview))
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            c = byte0;
            if (TiltShiftEditorView.j(tiltshifteditorview))
            {
                byte0 = flag;
            } else
            {
                byte0 = 0;
            }
            d = byte0;
            e = com.picsart.studio.editor.view.TiltShiftEditorView.c(tiltshifteditorview);
            f = TiltShiftEditorView.e(tiltshifteditorview);
            g = TiltShiftEditorView.f(tiltshifteditorview);
            h = TiltShiftEditorView.b(tiltshifteditorview);
            i = tiltshifteditorview.l;
        }
    }

}
