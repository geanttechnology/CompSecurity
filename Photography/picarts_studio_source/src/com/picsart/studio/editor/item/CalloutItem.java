// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.item;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.util.TypedValue;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.gizmo.CalloutGizmo;
import com.picsart.studio.editor.gizmo.Gizmo;
import com.socialin.android.d;
import com.socialin.android.photo.callout.b;
import com.socialin.android.util.Geom;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.editor.item:
//            Item, a, c

public class CalloutItem extends Item
    implements a
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new CalloutItem(parcel);
        }

        public final volatile Object[] newArray(int k)
        {
            return new CalloutItem[k];
        }

    };
    private static final String j = com/picsart/studio/editor/item/CalloutItem.getSimpleName();
    private static int q = 50;
    private Paint A;
    private Path B;
    private Path C;
    private Path D;
    private int E;
    private int F;
    private int G;
    private int H;
    private Paint I;
    private RectF J;
    public float a;
    public float b;
    public final PointF c;
    public final PointF d;
    public String e;
    public String f[];
    public int g;
    public float h;
    public int i;
    private float r;
    private float s;
    private float t;
    private float u;
    private Rect v;
    private Matrix w;
    private Matrix x;
    private Paint y;
    private Paint z;

    public CalloutItem()
    {
        r = 0.0F;
        s = 0.0F;
        a = 300F;
        b = 150F;
        t = 0.0F;
        u = 0.0F;
        v = new Rect();
        c = new PointF();
        d = new PointF();
        w = new Matrix();
        x = new Matrix();
        e = "PicsArt";
        g = 0;
        y = null;
        z = null;
        A = null;
        B = new Path();
        C = null;
        D = null;
        E = 0;
        F = 0;
        G = 0;
        H = 0;
        h = 1.0F;
        J = new RectF();
        I = new Paint(1);
        I.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.MULTIPLY));
    }

    public CalloutItem(Parcel parcel)
    {
        super(parcel);
        r = 0.0F;
        s = 0.0F;
        a = 300F;
        b = 150F;
        t = 0.0F;
        u = 0.0F;
        v = new Rect();
        c = new PointF();
        d = new PointF();
        w = new Matrix();
        x = new Matrix();
        e = "PicsArt";
        g = 0;
        y = null;
        z = null;
        A = null;
        B = new Path();
        C = null;
        D = null;
        E = 0;
        F = 0;
        G = 0;
        H = 0;
        h = 1.0F;
        J = new RectF();
        I = new Paint(1);
        I.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.MULTIPLY));
        e = parcel.readString();
        String as[] = new String[2];
        f = as;
        parcel.readStringArray(as);
        g = parcel.readInt();
        c.set((PointF)parcel.readParcelable(android/graphics/PointF.getClassLoader()));
        d.set((PointF)parcel.readParcelable(android/graphics/PointF.getClassLoader()));
        a = parcel.readFloat();
        b = parcel.readFloat();
        h = parcel.readFloat();
        i = parcel.readInt();
        a();
    }

    public static void a(int k)
    {
        q = k;
    }

    public final Gizmo a(Resources resources)
    {
        return new CalloutGizmo(resources, this);
    }

    public final void a()
    {
        Object obj;
        Object obj1;
        Object obj3 = null;
        Object obj4 = null;
        obj = (HashMap)b.E.get(g);
        G = ((Integer)((HashMap) (obj)).get("border_grad_top_color")).intValue();
        H = ((Integer)((HashMap) (obj)).get("border_grad_bottom_color")).intValue();
        E = ((Integer)((HashMap) (obj)).get("fill_grad_top_color")).intValue();
        F = ((Integer)((HashMap) (obj)).get("fill_grad_bottom_color")).intValue();
        int k = ((Integer)((HashMap) (obj)).get("fill_color")).intValue();
        int l = ((Integer)((HashMap) (obj)).get("border_color")).intValue();
        int i1 = ((Integer)((HashMap) (obj)).get("text_color")).intValue();
        z = new Paint();
        z.setStyle((android.graphics.Paint.Style)((HashMap) (obj)).get("border_paint_style"));
        z.setStrokeWidth(((Integer)((HashMap) (obj)).get("border_stroke_width")).intValue());
        z.setAntiAlias(true);
        z.setAlpha(255);
        if (l != -256)
        {
            z.setColor(l);
        }
        y = new Paint();
        y.setColor(0xffff0000);
        y.setStyle(android.graphics.Paint.Style.FILL);
        y.setAntiAlias(true);
        y.setAlpha(255);
        if (k != -256)
        {
            y.setColor(k);
        }
        float f1 = TypedValue.applyDimension(2, ((Integer)((HashMap) (obj)).get("text_size")).intValue(), EditorActivity.a().getResources().getDisplayMetrics());
        A = new Paint();
        A.setColor(i1);
        A.setAntiAlias(true);
        A.setTextSize(f1 * h);
        A.setTextAlign(android.graphics.Paint.Align.CENTER);
        obj = (String)((HashMap) (obj)).get("text_font_type_path");
        Object obj2;
        com.socialin.android.photo.svg.b b1;
        if (obj != null)
        {
            obj = Typeface.createFromAsset(EditorActivity.a().getAssets(), ((String) (obj)));
        } else
        {
            obj = Typeface.DEFAULT;
        }
        A.setTypeface(((Typeface) (obj)));
        obj2 = new com.socialin.android.photo.svg.b();
        obj1 = EditorActivity.a().getAssets().open(f[0]);
        obj = obj1;
        ((com.socialin.android.photo.svg.b) (obj2)).a(((InputStream) (obj1)));
        obj = obj1;
        D = ((com.socialin.android.photo.svg.b) (obj2)).a;
        obj = obj1;
        t = ((com.socialin.android.photo.svg.b) (obj2)).b;
        obj = obj1;
        u = ((com.socialin.android.photo.svg.b) (obj2)).c;
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.socialin.android.d.b(j, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
                });
            }
        }
_L1:
        b1 = new com.socialin.android.photo.svg.b();
        obj = obj4;
        obj1 = obj3;
        obj2 = EditorActivity.a().getAssets().open(f[1]);
        obj = obj2;
        obj1 = obj2;
        b1.a(((InputStream) (obj2)));
        obj = obj2;
        obj1 = obj2;
        C = b1.a;
        obj = obj2;
        obj1 = obj2;
        r = b1.b;
        obj = obj2;
        obj1 = obj2;
        s = b1.c;
        IOException ioexception1;
        if (obj2 != null)
        {
            try
            {
                ((InputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.socialin.android.d.b(j, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
                });
            }
        }
_L2:
        b();
        o();
        return;
        ioexception1;
        obj1 = null;
_L4:
        obj = obj1;
        com.socialin.android.d.b(j, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(ioexception1.getMessage()).toString()
        });
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.socialin.android.d.b(j, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
                });
            }
        }
          goto _L1
        obj1;
        obj = null;
_L3:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.socialin.android.d.b(j, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
                });
            }
        }
        throw obj1;
        ioexception1;
        obj1 = obj;
        com.socialin.android.d.b(j, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(ioexception1.getMessage()).toString()
        });
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            catch (IOException ioexception)
            {
                com.socialin.android.d.b(j, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
                });
            }
        }
          goto _L2
        Exception exception;
        exception;
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                com.socialin.android.d.b(j, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj1)).getMessage()).toString()
                });
            }
        }
        throw exception;
        obj1;
          goto _L3
        ioexception1;
          goto _L4
    }

    public final void a(Canvas canvas)
    {
        boolean flag = false;
        A.setAlpha(Color.alpha(m));
        y.setAlpha(Color.alpha(m));
        z.setAlpha(Color.alpha(m));
        float f1;
        Rect rect;
        float af[];
        ArrayList arraylist;
        int k;
        int i1;
        int i2;
        if (this.l != 1)
        {
            y.setXfermode(com.socialin.android.util.d.a(this.l));
            z.setXfermode(com.socialin.android.util.d.a(this.l));
        } else
        {
            canvas.saveLayer(J, I, 31);
            canvas.drawColor(-1);
            y.setXfermode(null);
            z.setXfermode(null);
        }
        if (l() == 255 && this.l == -1)
        {
            canvas.drawPath(B, z);
        }
        canvas.drawPath(B, y);
        if (this.l == 1)
        {
            canvas.restore();
        }
        rect = new Rect();
        A.getTextBounds(e, 0, e.length(), rect);
        i2 = rect.bottom - rect.top;
        af = new float[e.length()];
        A.getTextWidths(e, af);
        arraylist = new ArrayList();
        k = 0;
        i1 = 0;
        f1 = 0.0F;
        while (k < af.length) 
        {
            int j1;
            int l1;
            if (f1 < Math.abs(a) - 30F)
            {
                float f2 = f1 + af[k];
                j1 = k;
                l1 = i1;
                f1 = f2;
                if (k == af.length - 1)
                {
                    arraylist.add(e.substring(i1, k + 1));
                    f1 = f2;
                    l1 = i1;
                    j1 = k;
                }
            } else
            {
                j1 = e.lastIndexOf(" ", k);
                String s1;
                if (j1 != -1 && i1 < j1)
                {
                    s1 = e.substring(i1, j1);
                    k = j1 + 1;
                    i1 = j1;
                } else
                {
                    s1 = e.substring(i1, k);
                    int k1 = k;
                    i1 = k;
                    k = k1;
                }
                arraylist.add(s1);
                f1 = 0.0F;
                j1 = i1;
                l1 = k;
            }
            k = j1 + 1;
            i1 = l1;
        }
        f1 = d.y;
        float f3 = ((arraylist.size() - 1) * i2) / 2;
        for (int l = ((flag) ? 1 : 0); l < arraylist.size(); l++)
        {
            canvas.save();
            canvas.clipPath(B);
            float f4 = d.x;
            float f5 = (i2 + 2) * l;
            float f6 = i2 / 2;
            canvas.drawText((String)arraylist.get(l), f4, f6 + (f5 + (f1 - f3)), A);
            canvas.restore();
        }

    }

    public final boolean a(Camera camera, float f1, float f2)
    {
        return v.contains((int)f1, (int)f2) || Geom.a(f1, f2, c.x, c.y, d.x, d.y) < 50F / camera.e;
    }

    public final void b()
    {
        float f1 = Math.min(Math.abs(a), Math.abs(b));
        float f2 = (float)Math.sqrt((d.x - c.x) * (d.x - c.x) + (d.y - c.y) * (d.y - c.y));
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        if (f2 < f1 / 2.0F)
        {
            f1 = Math.min(q, (int)f1 / 2);
        } else
        {
            f1 = Math.min(Math.min(q, (int)f1), Math.min(f2 / 5F, (int)f1 / 3));
        }
        f3 = f1 / r;
        f4 = f2 / s;
        f5 = a / t;
        f6 = b / u;
        f7 = Math.min(d.x - a / 2.0F, d.x + a / 2.0F);
        f8 = Math.max(d.x - a / 2.0F, d.x + a / 2.0F);
        f9 = Math.min(d.y - b / 2.0F, d.y + b / 2.0F);
        f10 = Math.max(d.y - b / 2.0F, d.y + b / 2.0F);
        v.set((int)f7, (int)f9, (int)f8, (int)f10);
        if (E != -256)
        {
            LinearGradient lineargradient = new LinearGradient(0.0F, f9, 0.0F, f10, E, F, android.graphics.Shader.TileMode.CLAMP);
            y.setShader(lineargradient);
        }
        if (G != -256)
        {
            LinearGradient lineargradient1 = new LinearGradient(0.0F, f9, 0.0F, f10, G, H, android.graphics.Shader.TileMode.CLAMP);
            z.setShader(lineargradient1);
        }
        B.reset();
        w.reset();
        w.postTranslate((c.x - f1 / 2.0F) / f3, (c.y - f2) / f4);
        w.postScale(f3, f4);
        w.postRotate(90F - (float)Math.toDegrees(Math.atan2(c.y - d.y, d.x - c.x)), c.x, c.y);
        B.addPath(C, w);
        B.addPath(C, w);
        x.reset();
        x.postTranslate((d.x - a / 2.0F) / f5, (d.y - b / 2.0F) / f6);
        x.postScale(f5, f6);
        B.addPath(D, x);
        B.computeBounds(J, true);
    }

    public final boolean c()
    {
        return false;
    }

    public final void e()
    {
        if (o != null)
        {
            o.a(this);
        }
    }

    public final List h_()
    {
        return m.h();
    }

    public void writeToParcel(Parcel parcel, int k)
    {
        super.writeToParcel(parcel, k);
        parcel.writeString(e);
        parcel.writeStringArray(f);
        parcel.writeInt(g);
        parcel.writeParcelable(c, k);
        parcel.writeParcelable(d, k);
        parcel.writeFloat(a);
        parcel.writeFloat(b);
        parcel.writeFloat(h);
        parcel.writeInt(i);
    }

}
