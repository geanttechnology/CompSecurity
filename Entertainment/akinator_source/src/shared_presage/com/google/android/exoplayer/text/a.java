// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.text;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.text:
//            Cue, CaptionStyleCompat

final class a
{

    private final RectF a = new RectF();
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final TextPaint h = new TextPaint();
    private final Paint i = new Paint();
    private CharSequence j;
    private int k;
    private android.text.Layout.Alignment l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private StaticLayout v;
    private int w;
    private int x;
    private int y;

    public a(Context context)
    {
        TypedArray typedarray = context.obtainStyledAttributes(null, new int[] {
            0x1010217, 0x1010218
        }, 0, 0);
        g = typedarray.getDimensionPixelSize(0, 0);
        f = typedarray.getFloat(1, 1.0F);
        typedarray.recycle();
        int i1 = Math.round(((float)context.getResources().getDisplayMetrics().densityDpi * 2.0F) / 160F);
        b = i1;
        c = i1;
        d = i1;
        e = i1;
        h.setAntiAlias(true);
        h.setSubpixelText(true);
        i.setAntiAlias(true);
        i.setStyle(android.graphics.Paint.Style.FILL);
    }

    private void a(Canvas canvas)
    {
        StaticLayout staticlayout;
        int i2;
        staticlayout = v;
        if (staticlayout == null)
        {
            return;
        }
        i2 = canvas.save();
        canvas.translate(w, x);
        if (Color.alpha(o) > 0)
        {
            i.setColor(o);
            canvas.drawRect(-y, 0.0F, staticlayout.getWidth() + y, staticlayout.getHeight(), i);
        }
        if (Color.alpha(n) > 0)
        {
            i.setColor(n);
            float f1 = staticlayout.getLineTop(0);
            int k1 = staticlayout.getLineCount();
            for (int i1 = 0; i1 < k1; i1++)
            {
                a.left = staticlayout.getLineLeft(i1) - (float)y;
                a.right = staticlayout.getLineRight(i1) + (float)y;
                a.top = f1;
                a.bottom = staticlayout.getLineBottom(i1);
                f1 = a.bottom;
                canvas.drawRoundRect(a, b, b, i);
            }

        }
        if (q != 1) goto _L2; else goto _L1
_L1:
        h.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        h.setStrokeWidth(c);
        h.setColor(p);
        h.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        staticlayout.draw(canvas);
_L4:
        h.setColor(m);
        h.setStyle(android.graphics.Paint.Style.FILL);
        staticlayout.draw(canvas);
        h.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        canvas.restoreToCount(i2);
        return;
_L2:
        if (q == 2)
        {
            h.setShadowLayer(d, e, e, p);
        } else
        if (q == 3 || q == 4)
        {
            float f2;
            int j1;
            int l1;
            if (q == 3)
            {
                l1 = 1;
            } else
            {
                l1 = 0;
            }
            if (l1 != 0)
            {
                j1 = -1;
            } else
            {
                j1 = p;
            }
            if (l1 != 0)
            {
                l1 = p;
            } else
            {
                l1 = -1;
            }
            f2 = d / 2.0F;
            h.setColor(m);
            h.setStyle(android.graphics.Paint.Style.FILL);
            h.setShadowLayer(d, -f2, -f2, j1);
            staticlayout.draw(canvas);
            h.setShadowLayer(d, f2, f2, l1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(Cue cue, CaptionStyleCompat captionstylecompat, float f1, Canvas canvas, int i1, int j1, int k1, 
            int l1)
    {
        if (TextUtils.isEmpty(cue.text))
        {
            return;
        }
        if (TextUtils.equals(j, cue.text) && k == cue.position && Util.areEqual(l, cue.alignment) && m == captionstylecompat.foregroundColor && n == captionstylecompat.backgroundColor && o == captionstylecompat.windowColor && q == captionstylecompat.edgeType && p == captionstylecompat.edgeColor && Util.areEqual(h.getTypeface(), captionstylecompat.typeface) && r == i1 && s == j1 && t == k1 && u == l1)
        {
            a(canvas);
            return;
        }
        j = cue.text;
        k = cue.position;
        l = cue.alignment;
        m = captionstylecompat.foregroundColor;
        n = captionstylecompat.backgroundColor;
        o = captionstylecompat.windowColor;
        q = captionstylecompat.edgeType;
        p = captionstylecompat.edgeColor;
        h.setTypeface(captionstylecompat.typeface);
        r = i1;
        s = j1;
        t = k1;
        u = l1;
        int l2 = t - r;
        k1 = u - s;
        f1 = 0.0533F * (float)k1 * f1;
        h.setTextSize(f1);
        int i2 = (int)(f1 * 0.125F + 0.5F);
        i1 = l2 - i2 * 2;
        if (i1 <= 0)
        {
            Log.w("CuePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        int j2;
        if (l == null)
        {
            captionstylecompat = android.text.Layout.Alignment.ALIGN_CENTER;
        } else
        {
            captionstylecompat = l;
        }
        v = new StaticLayout(j, h, i1, captionstylecompat, f, g, true);
        j2 = v.getHeight();
        j1 = 0;
        l1 = v.getLineCount();
        for (i1 = 0; i1 < l1; i1++)
        {
            j1 = Math.max((int)Math.ceil(v.getLineWidth(i1)), j1);
        }

        int i3 = j1 + i2 * 2;
        i1 = (l2 - i3) / 2;
        l1 = u;
        int k2 = (int)((float)k1 * 0.08F);
        if (cue.position != -1)
        {
            if (cue.alignment == android.text.Layout.Alignment.ALIGN_OPPOSITE)
            {
                i1 = (cue.position * l2) / 100;
                i1 = r + i1;
                j1 = Math.max(i1 - i3, r);
            } else
            {
                j1 = (cue.position * l2) / 100 + r;
                i1 = Math.min(j1 + i3, t);
            }
        } else
        {
            j1 = i1;
            i1 += i3;
        }
        if (cue.line != -1)
        {
            l1 = (cue.line * k1) / 100 + s;
            k1 = l1;
            if (l1 + j2 > u)
            {
                k1 = u - j2;
                l1 = u;
            }
        } else
        {
            k1 = l1 - j2 - k2;
        }
        v = new StaticLayout(j, h, i1 - j1, captionstylecompat, f, g, true);
        w = j1;
        x = k1;
        y = i2;
        a(canvas);
    }
}
