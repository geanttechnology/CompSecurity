// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.util.Utils;
import java.util.ArrayList;

// Referenced classes of package com.picsart.studio.editor.view:
//            q, o, p

public class RGBConvertView extends View
{

    public SparseArray a;
    public int b;
    public int c;
    public int d[];
    public int e[];
    public int f[];
    public int g[];
    private float h;
    private float i;
    private float j;
    private SparseArray k;
    private SparseArray l;
    private Path m;
    private Paint n;
    private Path o;
    private Paint p;
    private PointF q;
    private q r;
    private p s;
    private o t;

    public RGBConvertView(Context context)
    {
        this(context, null);
    }

    public RGBConvertView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RGBConvertView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        h = 1.7F;
        j = 0.0F;
        m = new Path();
        o = new Path();
        b = 3;
        c = -1;
        q = new PointF();
        d = new int[256];
        e = new int[256];
        f = new int[256];
        g = new int[256];
        h = Utils.a((int)h, context);
        i = Utils.a(13F, context);
        j = Utils.a((int)j, context);
        context = new Paint();
        a(context);
        context.setColor(0xffff0000);
        attributeset = new Paint();
        a(attributeset);
        attributeset.setColor(0xff00ff00);
        Paint paint = new Paint();
        a(paint);
        paint.setColor(0xff0000ff);
        Paint paint1 = new Paint();
        a(paint1);
        paint1.setColor(-1);
        n = new Paint();
        a(n);
        n.setColor(Color.argb(255, 0, 0, 0));
        n.setStrokeWidth(n.getStrokeWidth() * 1.1F);
        p = new Paint();
        a(p);
        p.setColor(0xff000000);
        p.setStrokeWidth(p.getStrokeWidth() * 0.7F);
        k = new SparseArray();
        k.put(0, context);
        k.put(1, attributeset);
        k.put(2, paint);
        k.put(3, paint1);
        a = new SparseArray();
        a.put(0, new ArrayList());
        a.put(1, new ArrayList());
        a.put(2, new ArrayList());
        a.put(3, new ArrayList());
        l = new SparseArray();
        l.put(0, new Path());
        l.put(1, new Path());
        l.put(2, new Path());
        l.put(3, new Path());
        a(0);
        a(1);
        a(2);
        a(3);
    }

    private static float a(float f1, float f2, float f3, float f4, float f5)
    {
        return (float)((double)f2 * Math.pow(f1, 3D) + (double)f3 * Math.pow(f1, 2D) + (double)(f4 * f1) + (double)f5);
    }

    static SparseArray a(RGBConvertView rgbconvertview)
    {
        return rgbconvertview.a;
    }

    private void a()
    {
        b(0);
        b(1);
        b(2);
        b(3);
    }

    private void a(float f1, float f2, int i1)
    {
        Point point = (Point)((ArrayList)a.get(b)).get(i1);
        float f3 = c();
        point.y = c((int)((f2 - i) / f3));
        q.x = f1;
        q.y = f2;
    }

    private void a(Canvas canvas, int i1)
    {
        Paint paint = (Paint)k.get(i1);
        canvas.drawPath((Path)l.get(i1), paint);
    }

    private void a(Paint paint)
    {
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint.setStrokeWidth(h);
    }

    private static void a(ArrayList arraylist, Path path, float f1, float f2, float f3, float f4)
    {
        path.reset();
        if (arraylist.size() == 2)
        {
            Point point = (Point)arraylist.get(0);
            path.moveTo((float)point.x * f1 + f3, (float)point.y * f2 + f3);
            arraylist = (Point)arraylist.get(1);
            path.lineTo((float)((Point) (arraylist)).x * f1 + f3, (float)((Point) (arraylist)).y * f2 + f3);
        } else
        {
            int i1 = 0;
            while (i1 < arraylist.size() - 1) 
            {
                Point point1 = (Point)arraylist.get(i1);
                float f7 = (float)point1.x * f1 + f3;
                float f8 = (float)point1.y * f2 + f3;
                point1 = (Point)arraylist.get(i1 + 1);
                float f9 = (float)point1.x * f1 + f3;
                float f10 = (float)point1.y * f2 + f3;
                float f5;
                float f6;
                float f11;
                float f12;
                float f13;
                if (i1 == 0)
                {
                    f5 = (f10 - f8) / (f9 - f7);
                } else
                {
                    Point point2 = (Point)arraylist.get(i1 - 1);
                    f5 = point2.x;
                    f5 = (f10 - ((float)point2.y * f2 + f3)) / (f9 - (f5 * f1 + f3));
                }
                if (i1 == arraylist.size() - 2)
                {
                    f6 = (f10 - f8) / (f9 - f7);
                } else
                {
                    Point point3 = (Point)arraylist.get(i1 + 2);
                    f6 = point3.x;
                    f6 = (((float)point3.y * f2 + f3) - f8) / ((f6 * f1 + f3) - f7);
                }
                f10 = (float)((double)((f10 - f8 - ((((f9 + f7) * (f6 - f5)) / 2.0F + (f9 - f7) * f5) - (f6 - f5) * f7)) * 2.0F) / Math.pow(f7 - f9, 3D));
                f11 = (f6 - f5) / (2.0F * (f9 - f7)) - (3F * f10 * (f7 + f9)) / 2.0F;
                f12 = (f5 - ((f6 - f5) * f7) / (f9 - f7)) + 3F * f10 * f7 * f9;
                f13 = (float)((double)f8 - (double)f10 * Math.pow(f7, 3D) - (double)f11 * Math.pow(f7, 2D) - (double)(f12 * f7));
                while (f7 < f9) 
                {
                    float f14 = Math.min(0.5F + f7, f9);
                    f6 = a(f7, f10, f11, f12, f13);
                    f8 = a(f14, f10, f11, f12, f13);
                    if (f6 < f3)
                    {
                        f5 = f3;
                    } else
                    {
                        f5 = f6;
                        if (f6 >= f4 - f3)
                        {
                            f5 = f4 - f3 - 1.0F;
                        }
                    }
                    if (f8 < f3)
                    {
                        f6 = f3;
                    } else
                    {
                        f6 = f8;
                        if (f8 >= f4 - f3)
                        {
                            f6 = f4 - f3 - 1.0F;
                        }
                    }
                    path.moveTo(f7, f5);
                    path.lineTo(f14, f6);
                    f7 = 0.5F + f7;
                }
                i1++;
            }
        }
    }

    public static void a(ArrayList arraylist, int ai[])
    {
        if (arraylist.size() == 2)
        {
            for (int i1 = 0; i1 <= 255; i1++)
            {
                int k1 = ((Point)arraylist.get(0)).y;
                ai[i1] = Math.round(((((Point)arraylist.get(0)).y - ((Point)arraylist.get(1)).y) * i1) / 255) + (255 - k1);
            }

        } else
        {
            int l1 = 0;
            do
            {
                if (l1 >= arraylist.size() - 1)
                {
                    break;
                }
                Point point = (Point)arraylist.get(l1);
                int i2 = point.x;
                int j1 = point.y;
                point = (Point)arraylist.get(l1 + 1);
                int k2 = point.x;
                int j2 = point.y;
                float f1;
                float f2;
                float f3;
                float f4;
                if (l1 == 0)
                {
                    f1 = (j2 - j1) / (k2 - i2);
                } else
                {
                    Point point1 = (Point)arraylist.get(l1 - 1);
                    int l2 = point1.x;
                    f1 = (j2 - point1.y) / (k2 - l2);
                }
                if (l1 == arraylist.size() - 2)
                {
                    f2 = (j2 - j1) / (k2 - i2);
                } else
                {
                    Point point2 = (Point)arraylist.get(l1 + 2);
                    int i3 = point2.x;
                    f2 = (point2.y - j1) / (i3 - i2);
                }
                f3 = (float)((double)(((float)(j2 - j1) - ((((float)(k2 + i2) * (f2 - f1)) / 2.0F + (float)(k2 - i2) * f1) - (float)i2 * (f2 - f1))) * 2.0F) / Math.pow(i2 - k2, 3D));
                f4 = (f2 - f1) / (2.0F * (float)(k2 - i2)) - (3F * f3 * (float)(i2 + k2)) / 2.0F;
                f1 = (f1 - ((f2 - f1) * (float)i2) / (float)(k2 - i2)) + 3F * f3 * (float)i2 * (float)k2;
                f2 = (float)((double)j1 - (double)f3 * Math.pow(i2, 3D) - (double)f4 * Math.pow(i2, 2D) - (double)((float)i2 * f1));
                while (i2 < k2) 
                {
                    j2 = Math.round(a(i2, f3, f4, f1, f2));
                    if (j2 < 0)
                    {
                        j1 = 0;
                    } else
                    {
                        j1 = j2;
                        if (j2 >= 256)
                        {
                            j1 = 255;
                        }
                    }
                    ai[i2] = 255 - j1;
                    i2++;
                }
                l1++;
            } while (true);
            ai[255] = 255 - ((Point)arraylist.get(arraylist.size() - 1)).y;
        }
    }

    private float b()
    {
        return ((float)getWidth() - 2.0F * i) / 255F;
    }

    private float c()
    {
        return ((float)getHeight() - 2.0F * i) / 255F;
    }

    private static int c(int i1)
    {
        int j1;
        if (i1 < 0)
        {
            j1 = 0;
        } else
        {
            j1 = i1;
            if (i1 > 255)
            {
                return 255;
            }
        }
        return j1;
    }

    private void d()
    {
        a((ArrayList)a.get(0), e);
        a((ArrayList)a.get(1), f);
        a((ArrayList)a.get(2), g);
        a((ArrayList)a.get(3), d);
        if (r != null)
        {
            r.a(d, e, f, g);
        }
    }

    public final void a(int i1)
    {
        ArrayList arraylist = (ArrayList)a.get(i1);
        Path path = (Path)l.get(i1);
        arraylist.clear();
        arraylist.add(new Point(0, 255));
        arraylist.add(new Point(255, 0));
        float f1 = getWidth();
        float f2 = getHeight();
        if (f1 > 0.0F && f2 > 0.0F)
        {
            a(arraylist, path, b(), c(), i, getHeight());
        }
    }

    public final void a(int i1, boolean flag)
    {
        ArrayList arraylist = (ArrayList)a.get(b);
        i1;
        JVM INSTR tableswitch 0 2: default 44
    //                   0 99
    //                   1 125
    //                   2 151;
           goto _L1 _L2 _L3 _L4
_L1:
        int ai[];
        if (t != null && flag)
        {
            t.d();
        }
        ai = d;
_L6:
        a(arraylist, ai);
        r.a(d, e, f, g);
        return;
_L2:
        if (t != null && flag)
        {
            t.a();
        }
        ai = e;
        continue; /* Loop/switch isn't completed */
_L3:
        if (t != null && flag)
        {
            t.b();
        }
        ai = f;
        continue; /* Loop/switch isn't completed */
_L4:
        if (t != null && flag)
        {
            t.c();
        }
        ai = g;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void b(int i1)
    {
        Path path = (Path)l.get(i1);
        a((ArrayList)a.get(i1), path, b(), c(), i, getHeight());
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawPath(o, p);
        b;
        JVM INSTR tableswitch 0 3: default 52
    //                   0 265
    //                   1 286
    //                   2 307
    //                   3 244;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        canvas.drawPath(m, n);
        a(canvas, b);
        int i1 = b;
        float f1 = b();
        float f2 = c();
        Paint paint = (Paint)k.get(i1);
        ArrayList arraylist = (ArrayList)a.get(i1);
        float f3 = i;
        float f4 = paint.getStrokeWidth() / 2.0F;
        for (int j1 = 0; j1 < arraylist.size(); j1++)
        {
            Point point = (Point)arraylist.get(j1);
            float f5 = i;
            float f6 = point.x;
            float f7 = i;
            float f8 = point.y;
            if (j1 == c)
            {
                paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            }
            canvas.drawCircle(f5 + f6 * f1, f8 * f2 + f7, f3 - f4, paint);
            paint.setStyle(android.graphics.Paint.Style.STROKE);
        }

        break; /* Loop/switch isn't completed */
_L5:
        a(canvas, 0);
        a(canvas, 1);
        a(canvas, 2);
        continue; /* Loop/switch isn't completed */
_L2:
        a(canvas, 3);
        a(canvas, 1);
        a(canvas, 2);
        continue; /* Loop/switch isn't completed */
_L3:
        a(canvas, 3);
        a(canvas, 0);
        a(canvas, 2);
        continue; /* Loop/switch isn't completed */
_L4:
        a(canvas, 3);
        a(canvas, 0);
        a(canvas, 1);
        if (true) goto _L1; else goto _L6
_L6:
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        a = SavedState.a(parcelable);
        a();
        d();
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), this);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        boolean flag = false;
        super.onSizeChanged(i1, j1, k1, l1);
        a();
        d();
        m.reset();
        m.moveTo(i, (float)getHeight() - i);
        m.lineTo((float)getWidth() - i, i);
        float f4 = i1;
        float f2 = j1;
        o.reset();
        float f3 = (f4 - j * 2.0F - i * 2.0F) / 4F;
        float f5 = (f2 - j * 2.0F - i * 2.0F) / 4F;
        float f1 = j;
        float f10 = i;
        float f6 = j;
        float f7 = i;
        float f8 = j;
        float f9 = i;
        f1 += f10;
        for (i1 = 0; i1 < 5; i1++)
        {
            o.moveTo(f6 + f7, f1);
            o.lineTo(f4 - f8 - f9, f1);
            f1 += f5;
        }

        f1 = j + i;
        f4 = j;
        f5 = i;
        f6 = j;
        f7 = i;
        for (i1 = ((flag) ? 1 : 0); i1 < 5; i1++)
        {
            o.moveTo(f1, f4 + f5);
            o.lineTo(f1, f2 - f6 - f7);
            f1 += f3;
        }

        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        float f7;
        float f8;
        f8 = motionevent.getX();
        f7 = motionevent.getY();
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 48
    //                   0 50
    //                   1 895
    //                   2 493
    //                   3 895;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        return true;
_L2:
        float f1;
        int i1;
        f1 = ((float)getWidth() - 2.0F * i) / 255F;
        motionevent = (ArrayList)a.get(b);
        i1 = 0;
_L9:
        if (i1 >= motionevent.size()) goto _L6; else goto _L5
_L5:
        Point point = (Point)motionevent.get(i1);
        if (f8 < (float)point.x * f1 || f8 > (float)point.x * f1 + 2.0F * i) goto _L8; else goto _L7
_L8:
        i1++;
          goto _L9
_L6:
        i1 = -1;
_L7:
        setTouchPointIndex(i1);
        if (c >= 0)
        {
            a(f8, f7, c);
            b(b);
            invalidate();
            continue; /* Loop/switch isn't completed */
        }
        motionevent = (ArrayList)a.get(b);
        float f3 = b();
        float f4 = c();
        float f5 = getWidth();
        float f2 = getHeight();
        float f6;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        Point point1;
        int j1;
        int k1;
        if (f7 <= i)
        {
            f2 = i;
        } else
        if (f7 > f2 - i)
        {
            f2 -= i;
        } else
        {
            f2 = f7;
        }
        if (f8 < 2.0F * i || f8 > f5 - 2.0F * i) goto _L11; else goto _L10
_L10:
        i1 = 0;
_L16:
        if (i1 >= motionevent.size() - 1) goto _L11; else goto _L12
_L12:
        f5 = ((Point)motionevent.get(i1)).x;
        f6 = i;
        f9 = (float)((Point)motionevent.get(i1 + 1)).x * f3 - 2.2F * i;
        if (f8 < 2.2F * f6 + f5 * f3 || f8 > f9) goto _L14; else goto _L13
_L13:
        motionevent.add(i1 + 1, new Point(c((int)((f8 - i) / f3)), c((int)((f2 - i) / f4))));
        i1++;
_L17:
        setTouchPointIndex(i1);
        if (i1 >= 0)
        {
            a(f8, f7, c);
            b(b);
        }
        invalidate();
        continue; /* Loop/switch isn't completed */
_L14:
        if (f8 < f9) goto _L11; else goto _L15
_L15:
        i1++;
          goto _L16
_L11:
        i1 = -1;
          goto _L17
_L4:
        if (c < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = c;
        f3 = f8 - q.x;
        f9 = f7 - q.y;
        if (f3 * f3 + f9 * f9 >= 5F)
        {
            motionevent = (ArrayList)a.get(b);
            point1 = (Point)motionevent.get(i1);
            f10 = b();
            f11 = c();
            f2 = (float)point1.x * f10 + i;
            f12 = point1.y;
            f13 = i;
            if (i1 != 0 && i1 != motionevent.size() - 1)
            {
                f2 += f3;
            }
            f5 = i;
            f4 = (float)getWidth() - i;
            j1 = i1 - 1;
            k1 = i1 + 1;
            if (j1 >= 0)
            {
                f3 = ((Point)motionevent.get(j1)).x;
                f3 = i + f3 * f10;
                f6 = i;
                f5 = f3;
                f3 = 2.0F * f6 + f3;
            } else
            {
                f3 = f5;
            }
            if (k1 < motionevent.size())
            {
                f6 = (float)((Point)motionevent.get(k1)).x * f10 + i;
                f4 = f6 - 2.0F * i;
            } else
            {
                f6 = f4;
            }
            if (f2 < f3)
            {
                f2 = f3;
            } else
            if (f2 > f4)
            {
                f2 = f4;
            }
            if ((f2 <= f5 || f2 >= f6 || f3 >= f4) && i1 != 0 && i1 != motionevent.size() - 1)
            {
                f2 = (f5 + f6) / 2.0F;
            }
            point1.x = c((int)((f2 - i) / f10));
            point1.y = c((int)(((f12 * f11 + f13 + f9) - i) / f11));
            q.x = f8;
            q.y = f7;
        }
        b(b);
        invalidate();
        continue; /* Loop/switch isn't completed */
          goto _L16
_L3:
        if (c != -1)
        {
            a(b, true);
        }
        if (true) goto _L1; else goto _L18
_L18:
    }

    public void setCurveChangeListenerForAnalytics(o o1)
    {
        t = o1;
    }

    public void setDrawChannel(int i1)
    {
        b = i1;
        setTouchPointIndex(-1);
    }

    public void setOnPointsChangedListener(p p1)
    {
        s = p1;
    }

    public void setOnValuesChangedListener(q q1)
    {
        r = q1;
    }

    public void setTouchPointIndex(int i1)
    {
        c = i1;
        if (s != null)
        {
            boolean flag;
            if (i1 == 0 || i1 == -1 || i1 == ((ArrayList)a.get(b)).size() - 1)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            s.a(flag);
        }
    }

    private class SavedState extends android.view.View.BaseSavedState
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
        private SparseArray a;

        static SparseArray a(SavedState savedstate)
        {
            return savedstate.a;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeTypedList((List)a.get(0));
            parcel.writeTypedList((List)a.get(1));
            parcel.writeTypedList((List)a.get(2));
            parcel.writeTypedList((List)a.get(3));
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            a = new SparseArray(4);
            a.put(0, new ArrayList());
            a.put(1, new ArrayList());
            a.put(2, new ArrayList());
            a.put(3, new ArrayList());
            parcel.readTypedList((List)a.get(0), Point.CREATOR);
            parcel.readTypedList((List)a.get(1), Point.CREATOR);
            parcel.readTypedList((List)a.get(2), Point.CREATOR);
            parcel.readTypedList((List)a.get(3), Point.CREATOR);
        }

        public SavedState(Parcelable parcelable, RGBConvertView rgbconvertview)
        {
            super(parcelable);
            a = RGBConvertView.a(rgbconvertview);
        }
    }

}
