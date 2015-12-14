// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import com.picsart.shop.a;
import com.socialin.android.brushlib.input.b;
import com.socialin.android.d;
import com.socialin.android.photo.AbstractItem;
import com.socialin.android.photo.svg.Svg;
import com.socialin.android.util.Geom;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.l;
import com.socialin.android.util.w;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ClipArt extends AbstractItem
    implements b
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new ClipArt(parcel);
        }

        public final volatile Object[] newArray(int i1)
        {
            return new ClipArt[i1];
        }

    };
    private static final PorterDuffXfermode F;
    private static final PorterDuffXfermode G;
    private static final String a = com/socialin/android/photo/clipart/ClipArt.getSimpleName();
    private int A;
    private int B;
    private int C;
    private PointF D;
    private PointF E;
    private Rect H;
    private Paint I;
    private Paint J;
    private Bitmap K;
    private List L;
    private float M;
    private float N;
    private RectF O;
    private Canvas P;
    private float Q;
    private float R;
    private PointF S;
    private boolean T;
    private float U;
    private float V;
    private String b;
    private int c;
    private int d;
    private int e;
    private Paint f;
    private Paint g;
    private int h;
    private Bitmap i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private String q;
    private HashMap r;
    private boolean s;
    private String t;
    private Svg u;
    private Bitmap v;
    private Bitmap w;
    private Bitmap x;
    private Paint y;
    private Context z;

    public ClipArt(Parcel parcel)
    {
        Object obj;
        Object obj3;
        Object obj4;
        String s3;
        int i1;
        b = "";
        new Rect();
        c = 0;
        d = 0;
        e = 1;
        h = -1;
        i = null;
        j = -1F;
        k = -1F;
        l = 0.0F;
        m = 0.0F;
        n = -1F;
        new Rect();
        q = null;
        r = null;
        s = false;
        t = null;
        u = null;
        v = null;
        w = null;
        x = null;
        y = new Paint(2);
        z = null;
        B = -1;
        H = new Rect();
        L = new ArrayList();
        new Path();
        new RectF();
        new Rect();
        M = -1F;
        N = 50F;
        O = new RectF();
        new Rect();
        T = false;
        c = parcel.readInt();
        d = parcel.readInt();
        e = parcel.readInt();
        A = parcel.readInt();
        q = parcel.readString();
        r = parcel.readHashMap(getClass().getClassLoader());
        h = parcel.readInt();
        e = parcel.readInt();
        ByteArrayInputStream bytearrayinputstream;
        String s2;
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s = flag;
        t = parcel.readString();
        b = parcel.readString();
        j = parcel.readFloat();
        k = parcel.readFloat();
        o = parcel.readFloat();
        p = parcel.readFloat();
        scaleX = parcel.readFloat();
        scaleY = parcel.readFloat();
        B = parcel.readInt();
        opacity = parcel.readInt();
        rotateDegree = parcel.readFloat();
        C = parcel.readInt();
        if (c != 0)
        {
            break MISSING_BLOCK_LABEL_1142;
        }
        if (b == null)
        {
            parcel = "";
        } else
        {
            parcel = b;
        }
        b = parcel;
        obj4 = z;
        i1 = d;
        s3 = q;
        obj3 = r;
        flag = s;
        s2 = t;
        if (!flag) goto _L2; else goto _L1
_L1:
        obj = null;
        parcel = null;
        bytearrayinputstream = com.picsart.shop.a.a(((Context) (obj4))).a(s3, s2);
        parcel = bytearrayinputstream;
        obj = bytearrayinputstream;
        i = com.socialin.android.util.c.a(bytearrayinputstream);
        bytearrayinputstream.close();
        parcel = "no exceptions";
_L3:
        if (i == null && (obj4 instanceof Activity))
        {
            Utils.c((Activity)obj4, ((Context) (obj4)).getString(0x7f08024e));
            obj = (new StringBuilder("Params (initBitmapProperties): expMsg=")).append(parcel).append(" clipartResId=").append(i1).append(" path=").append(s3);
            IOException ioexception;
            Exception exception;
            String s1;
            if (obj3 != null)
            {
                parcel = (new StringBuilder(" bufferData=")).append(obj3).append(" bufferData.get(path)=").append(((HashMap) (obj3)).get("path")).toString();
            } else
            {
                parcel = " bufferData is null";
            }
            parcel = ((StringBuilder) (obj)).append(parcel).append(" fromPicsinFile=").append(flag).append(" fileName=").append(s2).toString();
            throw new IllegalArgumentException((new StringBuilder("bitmap resource is invalid ")).append(parcel).toString());
        }
        break MISSING_BLOCK_LABEL_1031;
        parcel;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(parcel.getMessage()).toString()
        });
        parcel = "no exceptions";
          goto _L3
        exception;
        obj = parcel;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
        });
        obj = parcel;
        s1 = exception.getMessage();
        if (parcel == null)
        {
            break MISSING_BLOCK_LABEL_780;
        }
        parcel.close();
        parcel = s1;
          goto _L3
        parcel;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(parcel.getMessage()).toString()
        });
        parcel = s1;
          goto _L3
        parcel;
        if (obj != null)
        {
            try
            {
                ((ByteArrayInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
                });
            }
        }
        throw parcel;
_L2:
label0:
        {
            if (obj3 == null)
            {
                break label0;
            }
            i = com.socialin.android.util.w.b(((HashMap) (obj3)), C, C, 0);
            parcel = "no exceptions";
        }
          goto _L3
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_992;
        }
        if (!(new File(s3)).exists())
        {
            break MISSING_BLOCK_LABEL_1142;
        }
        i = com.socialin.android.util.w.b(s3, C, C, 0);
        parcel = "no exceptions";
          goto _L3
        parcel;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(parcel.getMessage()).toString()
        });
        parcel = parcel.getMessage();
          goto _L3
        if (i1 != -1 && obj4 != null)
        {
            i = com.socialin.android.util.c.a(((Context) (obj4)).getResources(), i1);
        }
        parcel = "no exceptions";
          goto _L3
        if (i != null)
        {
            l = i.getWidth();
            m = i.getHeight();
            n = l / m;
            (new StringBuilder()).append(i.getWidth()).append(", ").append(i.getHeight()).append(",   ").append((float)(i.getRowBytes() * i.getHeight()) / 1024F / 1024F);
        }
        if (c != 1) goto _L5; else goto _L4
_L4:
        Object obj1;
        boolean flag1;
        obj1 = z;
        i1 = d;
        obj4 = q;
        flag1 = s;
        obj3 = t;
        if (i1 == -1 || obj1 == null) goto _L7; else goto _L6
_L6:
        u = new Svg(((Context) (obj1)), i1);
_L10:
        if (u != null)
        {
            l = u.a();
            m = u.b();
            n = l / m;
        }
_L5:
        f = new Paint(1);
        f.setColor(-1);
        f.setStyle(android.graphics.Paint.Style.STROKE);
        f.setStrokeWidth(1.0F);
        g = new Paint(1);
        g.setColor(0x99000000);
        g.setStyle(android.graphics.Paint.Style.STROKE);
        g.setStrokeWidth(1.0F);
        I = new Paint();
        I.setXfermode(G);
        J = new Paint();
        parcel = J;
        parcel.setAntiAlias(true);
        parcel.setStyle(android.graphics.Paint.Style.STROKE);
        parcel.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        parcel.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        parcel.setFilterBitmap(true);
        J.setColor(-1);
        O.set(0.0F, 0.0F, l, m);
        new com.socialin.android.brushlib.input.a(this);
        return;
_L7:
        if (!flag1) goto _L9; else goto _L8
_L8:
        ByteArrayInputStream bytearrayinputstream1;
        parcel = null;
        bytearrayinputstream1 = null;
        ioexception = null;
        obj1 = com.picsart.shop.a.a(((Context) (obj1))).a(((String) (obj4)), ((String) (obj3)));
        ioexception = ((IOException) (obj1));
        parcel = ((Parcel) (obj1));
        bytearrayinputstream1 = ((ByteArrayInputStream) (obj1));
        u = new Svg(((java.io.InputStream) (obj1)));
        ioexception = ((IOException) (obj1));
        parcel = ((Parcel) (obj1));
        bytearrayinputstream1 = ((ByteArrayInputStream) (obj1));
        u.a = ((String) (obj3));
        try
        {
            ((ByteArrayInputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(parcel.getMessage()).toString()
            });
        }
          goto _L10
        Object obj2;
        obj2;
_L11:
        parcel = ioexception;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Throwable) (obj2)).getMessage()).toString()
        });
        if (ioexception != null)
        {
            try
            {
                ioexception.close();
            }
            // Misplaced declaration of an exception variable
            catch (Parcel parcel)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(parcel.getMessage()).toString()
                });
            }
        }
          goto _L10
        ioexception;
        if (parcel != null)
        {
            try
            {
                parcel.close();
            }
            // Misplaced declaration of an exception variable
            catch (Parcel parcel)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(parcel.getMessage()).toString()
                });
            }
        }
        throw ioexception;
_L9:
        try
        {
            u = new Svg(new File(((String) (obj4))));
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(parcel.getMessage()).toString()
            });
        }
          goto _L10
        obj2;
        ioexception = bytearrayinputstream1;
          goto _L11
    }

    private BlurMaskFilter a(float f1)
    {
        BlurMaskFilter blurmaskfilter = null;
        if (f1 > 0.0F)
        {
            blurmaskfilter = new BlurMaskFilter((J.getStrokeWidth() * f1) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL);
        }
        return blurmaskfilter;
    }

    private void a()
    {
        int j1 = 1024;
        int k1 = Math.abs((int)Math.ceil(o));
        int i1 = Math.abs((int)Math.ceil(p));
        if (k1 == 0 || i1 == 0)
        {
            return;
        }
        if (k1 > 1024 || i1 > 1024)
        {
            if (k1 > i1)
            {
                i1 = (int)Math.ceil(1024F / n);
            } else
            {
                j1 = (int)Math.ceil(n * 1024F);
                i1 = 1024;
            }
        } else
        {
            j1 = (int)Math.ceil((float)i1 * n);
        }
        if (K == null || K.getWidth() != j1 || K.getHeight() != i1)
        {
            if (K != null)
            {
                com.socialin.android.util.c.a(K);
                K = null;
            }
            K = com.socialin.android.util.c.a(j1, i1, android.graphics.Bitmap.Config.ALPHA_8);
            P = new Canvas(K);
        }
        if (K == null)
        {
            (new StringBuilder("#########    BITMASK IS NUUUUUUL newWidth=")).append(j1).append(" newHeight=").append(i1);
            return;
        }
        K.eraseColor(0);
        for (Iterator iterator = L.iterator(); iterator.hasNext(); P.setMatrix(null))
        {
            iterator.next();
            J.setXfermode(F);
            float f2 = o / (float)K.getWidth();
            float f1 = p / (float)K.getHeight();
            f2 = scaleX / 0.0F / f2;
            f1 = scaleY / 0.0F / f1;
            P.scale(f2, f1);
            J.setStrokeWidth(0.0F);
            J.setMaskFilter(a(0.0F));
            P.drawPath(null, J);
            J.setXfermode(null);
        }

        J.setStrokeWidth(M);
        J.setMaskFilter(a(N));
    }

    private boolean b()
    {
        return K != null && !K.isRecycled();
    }

    public void clearData()
    {
        com.socialin.android.util.c.a(i);
        i = null;
        com.socialin.android.util.c.a(v);
        v = null;
        com.socialin.android.util.c.a(w);
        w = null;
        com.socialin.android.util.c.a(x);
        x = null;
        com.socialin.android.util.c.a(K);
        K = null;
    }

    public int describeContents()
    {
        return 0;
    }

    public float getHeight()
    {
        return p;
    }

    public float getScaleX()
    {
        return scaleX;
    }

    public float getScaleY()
    {
        return scaleY;
    }

    public float getWidth()
    {
        return o;
    }

    public float getX()
    {
        return j - o * 0.5F;
    }

    public float getY()
    {
        return k - p * 0.5F;
    }

    public void initSpecStateObjects(Context context)
    {
        z = context;
        if (context != null)
        {
            if (v == null || v.isRecycled())
            {
                v = com.socialin.android.util.c.a(context.getResources(), 0x7f02024a);
            }
            if (x == null || x.isRecycled())
            {
                x = com.socialin.android.util.c.a(context.getResources(), 0x7f02024b);
            }
            if (w == null || w.isRecycled())
            {
                w = com.socialin.android.util.c.a(context.getResources(), 0x7f02024c);
            }
        }
        int i1 = B;
        B = i1;
        context = com.socialin.android.util.d.a(i1);
        y.setXfermode(context);
    }

    public void onLongPress(PointF pointf)
    {
    }

    public void onPan(PointF pointf)
    {
    }

    public void onPanEnd(PointF pointf)
    {
    }

    public void onPanStart(PointF pointf)
    {
    }

    public void onPinch(PointF pointf, PointF pointf1)
    {
        while (T || D == null || E == null || pointf == null || pointf1 == null || !isActive() || !isDrawHandle()) 
        {
            return;
        }
        rotateDegree = Q + com.socialin.android.util.l.a(D, E, pointf, pointf1);
        float f9 = Geom.a(pointf, pointf1);
        if (f9 != 0.0F && R != 0.0F)
        {
            float f1 = scaleX;
            float f3 = scaleY;
            float f5 = o;
            float f7 = p;
            f9 /= R;
            scaleX = U * f9;
            scaleY = f9 * V;
            o = l * scaleX;
            p = m * scaleY;
            f9 = Utils.a(20F, z);
            if (Math.abs(o) < f9 && Math.abs(p) < f9)
            {
                o = f5;
                p = f7;
                scaleX = f1;
                scaleY = f3;
                return;
            }
        }
        PointF pointf2 = new PointF();
        com.socialin.android.util.l.a(pointf, pointf1, pointf2);
        if (S != null)
        {
            float f2 = pointf2.x;
            float f4 = S.x;
            float f6 = pointf2.y;
            float f8 = S.y;
            j = (f2 - f4) + j;
            k = k + (f6 - f8);
        }
        S = pointf2;
    }

    public void onPinchEnd(PointF pointf, PointF pointf1)
    {
        T = false;
        S = null;
        if (b())
        {
            a();
        }
    }

    public void onPinchStart(PointF pointf, PointF pointf1)
    {
        if (H == null || !com.socialin.android.photo.view.a.a(H, pointf.x, pointf.y, -rotateDegree) && !com.socialin.android.photo.view.a.a(H, pointf1.x, pointf1.y, -rotateDegree))
        {
            T = true;
        } else
        {
            T = false;
            if (isActive() && isDrawHandle())
            {
                D = new PointF(pointf.x, pointf.y);
                E = new PointF(pointf1.x, pointf1.y);
                Q = rotateDegree;
                R = Geom.a(pointf, pointf1);
                U = scaleX;
                V = scaleY;
                PointF pointf2 = new PointF();
                com.socialin.android.util.l.a(pointf, pointf1, pointf2);
                S = pointf2;
                return;
            }
        }
    }

    public void onTap(PointF pointf)
    {
    }

    public void setActive(boolean flag)
    {
        super.setActive(flag);
        if (!flag)
        {
            if (b())
            {
                com.socialin.android.util.c.a(K);
                K = null;
            }
        } else
        if (!L.isEmpty())
        {
            a();
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeInt(c);
        parcel.writeInt(d);
        parcel.writeInt(e);
        parcel.writeInt(A);
        parcel.writeString(q);
        parcel.writeMap(r);
        parcel.writeInt(h);
        parcel.writeInt(e);
        if (s)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        parcel.writeString(t);
        parcel.writeString(b);
        parcel.writeFloat(j);
        parcel.writeFloat(k);
        parcel.writeFloat(o);
        parcel.writeFloat(p);
        parcel.writeFloat(scaleX);
        parcel.writeFloat(scaleY);
        parcel.writeInt(B);
        parcel.writeInt(opacity);
        parcel.writeFloat(rotateDegree);
        parcel.writeInt(C);
    }

    static 
    {
        F = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR);
        G = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT);
    }
}
