// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;

public final class cyl extends View
{

    StaticLayout a;
    StaticLayout b;
    private TextPaint c;
    private TextPaint d;
    private TextPaint e;
    private Path f;
    private Editable g;
    private android.text.Layout.Alignment h;
    private int i;
    private int j;
    private float k;

    public cyl(Context context)
    {
        super(context);
        setLayerType(1, null);
        c = new TextPaint();
        c.setAntiAlias(true);
        c.setStyle(android.graphics.Paint.Style.FILL);
        d = new TextPaint();
        d.setAntiAlias(true);
        d.setColor(0);
        d.setStyle(android.graphics.Paint.Style.STROKE);
        e = new TextPaint();
        e.setAntiAlias(true);
        f = new Path();
        g = android.text.Editable.Factory.getInstance().newEditable("");
        h = android.text.Layout.Alignment.ALIGN_CENTER;
        k = c.getTextSize() * 0.0625F;
        setContentDescription(getResources().getString(0x7f0b00b5));
    }

    private int a()
    {
        int l;
        int j1;
        int k1;
        l = 0;
        j1 = getPaddingRight();
        k1 = getPaddingLeft();
        i;
        JVM INSTR tableswitch 0 4: default 52
    //                   0 79
    //                   1 116
    //                   2 79
    //                   3 79
    //                   4 79;
           goto _L1 _L2 _L3 _L2 _L2 _L2
_L1:
        throw new IllegalStateException(String.format("Edge type %d is not supported.", new Object[] {
            Integer.valueOf(i)
        }));
_L2:
        StaticLayout staticlayout = a;
_L5:
        int i1;
        int l1 = staticlayout.getLineCount();
        i1 = 0;
        for (; l < l1; l++)
        {
            i1 = Math.max((int)staticlayout.getLineMax(l), i1);
        }

        break; /* Loop/switch isn't completed */
_L3:
        staticlayout = b;
        if (true) goto _L5; else goto _L4
_L4:
        return i1 + (j1 + k1);
    }

    private int a(CharSequence charsequence, int l)
    {
        int i1;
        int j1;
        i1 = android.view.View.MeasureSpec.getMode(l);
        j1 = android.view.View.MeasureSpec.getSize(l);
        l = getPaddingLeft() + getPaddingRight();
        i;
        JVM INSTR tableswitch 0 4: default 60
    //                   0 87
    //                   1 105
    //                   2 87
    //                   3 87
    //                   4 87;
           goto _L1 _L2 _L3 _L2 _L2 _L2
_L1:
        throw new IllegalStateException(String.format("Edge type %d is not supported.", new Object[] {
            Integer.valueOf(i)
        }));
_L2:
        l += (int)Layout.getDesiredWidth(charsequence, c);
_L5:
        if (i1 == 0)
        {
            return l;
        }
        break; /* Loop/switch isn't completed */
_L3:
        l += (int)Layout.getDesiredWidth(charsequence, d);
        if (true) goto _L5; else goto _L4
_L4:
        if (i1 == 0x80000000)
        {
            return Math.min(l, j1);
        } else
        {
            return j1;
        }
    }

    private int b()
    {
        switch (i)
        {
        default:
            throw new IllegalStateException(String.format("Edge type %d is not supported.", new Object[] {
                Integer.valueOf(i)
            }));

        case 0: // '\0'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            b.a(a);
            return a.getHeight();

        case 1: // '\001'
            b.a(b);
            break;
        }
        return b.getHeight();
    }

    private StaticLayout d(int l)
    {
        StaticLayout staticlayout;
label0:
        {
            StaticLayout staticlayout1 = a;
            l = a(g, l);
            if (staticlayout1 != null)
            {
                staticlayout = staticlayout1;
                if (l == staticlayout1.getWidth())
                {
                    break label0;
                }
            }
            staticlayout = new StaticLayout(g, c, l, h, 1.0F, 0.0F, true);
        }
        return staticlayout;
    }

    private StaticLayout e(int l)
    {
        Object obj;
label0:
        {
            boolean flag = false;
            StaticLayout staticlayout = b;
            int i1 = a(g, l);
            if (staticlayout != null)
            {
                obj = staticlayout;
                if (i1 == staticlayout.getWidth())
                {
                    break label0;
                }
            }
            obj = new SpannableString(g);
            ForegroundColorSpan aforegroundcolorspan[] = (ForegroundColorSpan[])((SpannableString) (obj)).getSpans(0, ((SpannableString) (obj)).length(), android/text/style/ForegroundColorSpan);
            int j1 = aforegroundcolorspan.length;
            for (l = ((flag) ? 1 : 0); l < j1; l++)
            {
                ((SpannableString) (obj)).removeSpan(aforegroundcolorspan[l]);
            }

            obj = new StaticLayout(((CharSequence) (obj)), d, i1, h, 1.0F, 0.0F, true);
        }
        return ((StaticLayout) (obj));
    }

    public final void a(float f1)
    {
        f1 = TypedValue.applyDimension(2, f1, getResources().getDisplayMetrics());
        c.setTextSize(f1);
        k = 0.0625F * f1;
        d.setTextSize(f1);
        d.setStrokeWidth(k);
        c(i);
        b = null;
        a = null;
        requestLayout();
        invalidate();
    }

    public final void a(int l)
    {
        c.setColor(l);
        invalidate();
    }

    public final void a(Typeface typeface)
    {
        c.setTypeface(typeface);
        d.setTypeface(typeface);
        e.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public final void a(CharSequence charsequence)
    {
        g.clear();
        g.append(charsequence);
        a = null;
        b = null;
        requestLayout();
        invalidate();
    }

    public final void b(int l)
    {
        d.setColor(l);
        invalidate();
    }

    public final void c(int l)
    {
        i;
        JVM INSTR tableswitch 0 4: default 40
    //                   0 76
    //                   1 76
    //                   2 136
    //                   3 67
    //                   4 67;
           goto _L1 _L2 _L2 _L3 _L4 _L4
_L2:
        break MISSING_BLOCK_LABEL_76;
_L1:
        throw new IllegalStateException(String.format("Edge type %d is not supported.", new Object[] {
            Integer.valueOf(i)
        }));
_L4:
        c.setMaskFilter(null);
_L10:
        l;
        JVM INSTR tableswitch 0 4: default 112
    //                   0 181
    //                   1 181
    //                   2 233
    //                   3 146
    //                   4 191;
           goto _L5 _L6 _L6 _L7 _L8 _L9
_L5:
        throw new IllegalStateException(String.format("Edge type %d is not supported.", new Object[] {
            Integer.valueOf(l)
        }));
_L3:
        c.clearShadowLayer();
          goto _L10
_L8:
        c.setMaskFilter(new EmbossMaskFilter(new float[] {
            1.0F, 1.0F, 1.0F
        }, 0.0F, 9F, 2.0F));
_L6:
        i = l;
        requestLayout();
        return;
_L9:
        c.setMaskFilter(new EmbossMaskFilter(new float[] {
            -1F, -1F, 1.0F
        }, 0.0F, 9F, 2.0F));
        continue; /* Loop/switch isn't completed */
_L7:
        c.setShadowLayer(k, k, k, d.getColor());
        if (true) goto _L6; else goto _L11
_L11:
    }

    protected final void onDraw(Canvas canvas)
    {
        if (TextUtils.isEmpty(g) || b == null || a == null)
        {
            return;
        }
        if (Color.alpha(j) != 0)
        {
            canvas.drawPath(f, e);
        }
        if (i == 1)
        {
            b.draw(canvas);
        }
        a.draw(canvas);
    }

    protected final void onLayout(boolean flag, int l, int i1, int j1, int k1)
    {
        super.onLayout(flag, l, i1, j1, k1);
        l = android.view.View.MeasureSpec.makeMeasureSpec(j1 - l, 0x40000000);
        a = d(l);
        b = e(l);
        StaticLayout staticlayout = a;
        i1 = staticlayout.getLineCount();
        RectF rectf = new RectF();
        f.reset();
        for (l = 0; l < i1; l++)
        {
            j1 = staticlayout.getLineBottom(l);
            k1 = staticlayout.getLineTop(l);
            float f1 = staticlayout.getLineLeft(l);
            float f2 = staticlayout.getLineRight(l);
            rectf.set(f1 - (float)getPaddingLeft(), k1, f2 + (float)getPaddingRight(), j1);
            f.addRect(rectf, android.graphics.Path.Direction.CCW);
        }

    }

    protected final void onMeasure(int l, int i1)
    {
        int k1 = android.view.View.MeasureSpec.getSize(l);
        int j1 = android.view.View.MeasureSpec.getSize(i1);
        a = d(l);
        b = e(l);
        int l1 = android.view.View.MeasureSpec.getMode(l);
        if (l1 == 0x80000000)
        {
            l = Math.min(k1, a());
        } else
        {
            l = k1;
            if (l1 != 0x40000000)
            {
                l = a();
            }
        }
        k1 = android.view.View.MeasureSpec.getMode(i1);
        if (k1 == 0x80000000)
        {
            i1 = Math.min(j1, b());
        } else
        {
            i1 = j1;
            if (k1 != 0x40000000)
            {
                i1 = b();
            }
        }
        setMeasuredDimension(l, i1);
    }

    public final void setBackgroundColor(int l)
    {
        j = l;
        e.setColor(l);
        invalidate();
    }
}
