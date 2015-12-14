// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.callout;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Parcel;
import android.util.TypedValue;
import com.socialin.android.photo.AbstractItem;
import com.socialin.android.photo.svg.Svg;
import com.socialin.android.photo.svg.b;
import com.socialin.android.photo.textart.TextArtStyle;
import com.socialin.android.photo.textart.TypefaceSpec;
import com.socialin.android.util.c;
import com.socialin.android.util.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class Callout extends AbstractItem
{

    private static final String E = com/socialin/android/photo/callout/Callout.getSimpleName();
    Bitmap A;
    String B;
    int C;
    int D;
    private int F;
    private int G;
    private int H;
    private int I;
    private float J;
    private float K;
    private float L;
    private float M;
    private Path N;
    private Path O;
    private Rect P;
    private int Q;
    private float R;
    private float S;
    private int T;
    private int U;
    private int V;
    private Context W;
    private String Z[];
    int a;
    private Svg aa;
    private Svg ab;
    int b;
    int c;
    int d;
    Rect e;
    Rect f;
    Paint g;
    Paint h;
    Paint i;
    Paint j;
    float k;
    float l;
    float m;
    float n;
    int o;
    float p;
    float q;
    float r;
    float s;
    float t;
    float u;
    float v;
    float w;
    float x;
    Path y;
    Bitmap z;

    public Callout(Context context, String as[], HashMap hashmap, String s1, int i1, int j1, int k1, 
            int l1, boolean flag, int i2)
    {
        b b1;
        F = 200;
        G = 100;
        H = 50;
        I = 100;
        J = 0.0F;
        K = 0.0F;
        L = 0.0F;
        M = 0.0F;
        N = null;
        O = null;
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = new Rect();
        P = new Rect();
        f = new Rect();
        g = null;
        h = null;
        i = null;
        j = new Paint(2);
        k = 0.0F;
        l = 0.0F;
        m = 1.0F;
        n = 1.0F;
        o = 0;
        Q = 0;
        R = 0.0F;
        S = 0.0F;
        p = 0.0F;
        q = 0.0F;
        T = 0;
        U = 0;
        r = 1.0F;
        s = 1.0F;
        t = 30F;
        u = 0.0F;
        v = 0.0F;
        w = 0.0F;
        x = 0.0F;
        y = new Path();
        z = null;
        A = null;
        V = 2;
        B = null;
        W = null;
        Z = null;
        C = -1;
        D = 1;
        aa = null;
        ab = null;
        W = context;
        B = s1;
        F = i1;
        G = i1 / 2;
        H = j1;
        I = j1 * 2;
        D = 1;
        k = k1;
        l = l1;
        Z = as;
        c = ((Integer)hashmap.get("border_grad_top_color")).intValue();
        d = ((Integer)hashmap.get("border_grad_bottom_color")).intValue();
        a = ((Integer)hashmap.get("fill_grad_top_color")).intValue();
        b = ((Integer)hashmap.get("fill_grad_bottom_color")).intValue();
        i1 = ((Integer)hashmap.get("fill_color")).intValue();
        j1 = ((Integer)hashmap.get("border_color")).intValue();
        k1 = ((Integer)hashmap.get("text_color")).intValue();
        h = new Paint();
        h.setStyle((android.graphics.Paint.Style)hashmap.get("border_paint_style"));
        h.setStrokeWidth(((Integer)hashmap.get("border_stroke_width")).intValue());
        h.setAntiAlias(true);
        h.setAlpha(opacity);
        if (j1 != -256)
        {
            h.setColor(j1);
        }
        g = new Paint();
        g.setColor(0xffff0000);
        g.setStyle(android.graphics.Paint.Style.FILL);
        g.setAntiAlias(true);
        g.setAlpha(opacity);
        if (i1 != -256)
        {
            g.setColor(i1);
        }
        float f1 = TypedValue.applyDimension(2, ((Integer)hashmap.get("text_size")).intValue(), W.getResources().getDisplayMetrics());
        i = new Paint();
        i.setColor(k1);
        i.setAntiAlias(true);
        i.setTextSize(f1);
        i.setTextAlign(android.graphics.Paint.Align.CENTER);
        as = TextArtStyle.getPreviewStyleObj(false, (String)hashmap.get("text_font_type_path"));
        as = TypefaceSpec.getTypeFace(W, as.getTypefaceSpec());
        i.setTypeface(as);
        g.setAlpha(opacity);
        i1 = C;
        C = i1;
        as = com.socialin.android.util.d.a(i1);
        h.setXfermode(as);
        g.setXfermode(as);
        b1 = new b();
        hashmap = null;
        as = null;
        s1 = context.getAssets().open(Z[0]);
        as = s1;
        hashmap = s1;
        b1.a(s1);
        as = s1;
        hashmap = s1;
        O = b1.a;
        as = s1;
        hashmap = s1;
        if (D != 2) goto _L2; else goto _L1
_L1:
        as = s1;
        hashmap = s1;
        L = aa.a();
        as = s1;
        hashmap = s1;
        M = aa.b();
_L8:
        as = s1;
        hashmap = s1;
        m = (float)F / L;
        as = s1;
        hashmap = s1;
        n = (float)G / M;
        as = s1;
        hashmap = s1;
        o = F;
        as = s1;
        hashmap = s1;
        Q = G;
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                com.socialin.android.d.b(E, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
                });
            }
        }
        s1 = new b();
        hashmap = null;
        as = null;
        context = context.getAssets().open(Z[1]);
        as = context;
        hashmap = context;
        s1.a(context);
        as = context;
        hashmap = context;
        N = ((b) (s1)).a;
        as = context;
        hashmap = context;
        if (D != 2) goto _L4; else goto _L3
_L3:
        as = context;
        hashmap = context;
        J = ab.a();
        as = context;
        hashmap = context;
        K = ab.b();
_L6:
        as = context;
        hashmap = context;
        r = (float)H / J;
        as = context;
        hashmap = context;
        s = (float)I / K;
        as = context;
        hashmap = context;
        T = H;
        as = context;
        hashmap = context;
        U = I;
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                com.socialin.android.d.b(E, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
                });
            }
        }
        isDrawHandle = false;
        b();
        a();
        return;
_L2:
        as = s1;
        hashmap = s1;
        L = b1.b;
        as = s1;
        hashmap = s1;
        try
        {
            M = b1.c;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            hashmap = as;
        }
        finally
        {
            if (hashmap != null)
            {
                try
                {
                    hashmap.close();
                }
                // Misplaced declaration of an exception variable
                catch (String as[])
                {
                    com.socialin.android.d.b(E, new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
                    });
                }
            }
            throw context;
        }
        com.socialin.android.d.b(E, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(s1.getMessage()).toString()
        });
        if (as != null)
        {
            try
            {
                as.close();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                com.socialin.android.d.b(E, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
                });
            }
        }
        break MISSING_BLOCK_LABEL_956;
_L4:
        as = context;
        hashmap = context;
        J = ((b) (s1)).b;
        as = context;
        hashmap = context;
        K = ((b) (s1)).c;
        if (true) goto _L6; else goto _L5
_L5:
        context;
        hashmap = as;
        com.socialin.android.d.b(E, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
        });
        if (as != null)
        {
            try
            {
                as.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                com.socialin.android.d.b(E, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
                });
            }
        }
        break MISSING_BLOCK_LABEL_1116;
        context;
        if (hashmap != null)
        {
            try
            {
                hashmap.close();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                com.socialin.android.d.b(E, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
                });
            }
        }
        throw context;
        if (true) goto _L8; else goto _L7
_L7:
    }

    void a()
    {
        R = k + (float)(o / 2);
        S = l + (float)(Q / 2);
        if (V != 1)
        {
            p = R - (float)(T / 2);
            q = S;
        }
        float f2 = l;
        float f1 = (float)Q + l;
        float f4 = k;
        float f3 = k + (float)o;
        e.set((int)f4, (int)f2, (int)f3, (int)f1);
        if (n < 0.0F)
        {
            f1 = Q;
            f2 = l + f1;
            f1 = l;
        }
        if (m < 0.0F)
        {
            f3 = k;
            f4 = (float)o + f3;
            f3 = k;
        }
        f.set((int)f4, (int)f2, (int)f3, (int)f1);
        P.set((int)p, (int)q, (int)(p + (float)T), (int)(q + (float)U));
        w = P.centerX();
        x = P.bottom;
        if (V != 1)
        {
            u = R;
            v = S;
        }
        y.reset();
        Matrix matrix = new Matrix();
        matrix.postTranslate(k / m, l / n);
        matrix.postScale(m, n);
        y.addPath(O, matrix);
        matrix = new Matrix();
        matrix.postTranslate(p / r, q / s);
        matrix.postScale(r, s);
        matrix.postRotate(t, u, v);
        y.addPath(N, matrix);
        y.addPath(N, matrix);
    }

    void b()
    {
        if (z == null)
        {
            z = BitmapFactory.decodeResource(W.getResources(), 0x7f020248);
        }
        if (A == null)
        {
            A = BitmapFactory.decodeResource(W.getResources(), 0x7f02024d);
        }
    }

    public void clearData()
    {
        com.socialin.android.util.c.a(z);
        com.socialin.android.util.c.a(A);
        z = null;
        A = null;
    }

    public int describeContents()
    {
        return 0;
    }

    public float getHeight()
    {
        return (float)(G + I);
    }

    public float getScaleX()
    {
        return m;
    }

    public float getScaleY()
    {
        return n;
    }

    public float getWidth()
    {
        return (float)(F + H);
    }

    public float getX()
    {
        return k;
    }

    public float getY()
    {
        return l;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
    }

}
