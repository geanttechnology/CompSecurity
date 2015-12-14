// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.colorpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import myobfuscated.bf.a;

// Referenced classes of package com.socialin.android.colorpicker:
//            b, a

public class SaturationValueDiamondView extends View
    implements b
{

    private Paint a;
    private RectF b;
    private com.socialin.android.colorpicker.a c;
    private float d;
    private float e;
    private Paint f;
    private Paint g;
    private Matrix h;
    private Matrix i;
    private float j[];

    public SaturationValueDiamondView(Context context)
    {
        this(context, null);
    }

    public SaturationValueDiamondView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public SaturationValueDiamondView(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        h = new Matrix();
        i = new Matrix();
        j = new float[2];
        setLayerType(1, null);
        context = context.getTheme().obtainStyledAttributes(attributeset, a.SaturationValueDiamondView, 0, 0);
        d = context.getDimensionPixelSize(a.SaturationValueDiamondView_sv_pointer_radius, 20);
        context.recycle();
        a = new Paint(1);
        a.setColor(0xff000000);
        a.setStyle(android.graphics.Paint.Style.FILL);
        f = new Paint(1);
        f.setColor(-1);
        f.setStyle(android.graphics.Paint.Style.STROKE);
        f.setStrokeWidth(2.0F);
        g = new Paint(1);
        g.setColor(0xff000000);
        g.setStyle(android.graphics.Paint.Style.STROKE);
        g.setStrokeWidth(2.0F);
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    private void b()
    {
        j[0] = c.b() * e;
        j[1] = (1.0F - c.c()) * e;
    }

    public final void a()
    {
        setNewShader();
        b();
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.setMatrix(h);
        canvas.drawRect(b, a);
        canvas.drawCircle(j[0], j[1], d, f);
        canvas.drawCircle(j[0], j[1], d - 2.0F, g);
    }

    protected void onSizeChanged(int k, int l, int i1, int j1)
    {
        super.onSizeChanged(k, l, i1, j1);
        e = (float)((double)(k - getPaddingRight() - getPaddingLeft()) / Math.sqrt(2D) - (double)(d * 2.0F));
        b = new RectF(0.0F, 0.0F, e, e);
        h.setRotate(45F, b.centerX(), b.centerY());
        h.postTranslate(((float)getHeight() - e) / 2.0F, ((float)getHeight() - e) / 2.0F);
        h.invert(i);
        setNewShader();
        b();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag1;
        flag1 = false;
        j[0] = motionevent.getX();
        j[1] = motionevent.getY();
        i.mapPoints(j);
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 2: default 64
    //                   0 70
    //                   1 154
    //                   2 154;
           goto _L1 _L2 _L3 _L3
_L1:
        boolean flag = true;
_L5:
        return flag;
_L2:
        flag = flag1;
        if (j[0] > b.right) goto _L5; else goto _L4
_L4:
        flag = flag1;
        if (j[0] < b.left) goto _L5; else goto _L6
_L6:
        flag = flag1;
        if (j[1] > b.bottom) goto _L5; else goto _L7
_L7:
        flag = flag1;
        if (j[1] < b.top) goto _L5; else goto _L3
_L3:
        float f1;
        float f2;
        if (j[0] > b.right)
        {
            j[0] = b.right;
        } else
        if (j[0] < b.left)
        {
            j[0] = b.left + 0.01F;
        }
        if (j[1] <= b.bottom)
        {
            break; /* Loop/switch isn't completed */
        }
        j[1] = b.bottom - 0.01F;
_L10:
        f1 = j[1] / e;
        f2 = j[0] / e;
        c.c(1.0F - f1);
        c.b(f2);
        invalidate();
        if (true) goto _L1; else goto _L8
_L8:
        if (j[1] >= b.top) goto _L10; else goto _L9
_L9:
        j[1] = b.top;
          goto _L10
    }

    public void setColorData(com.socialin.android.colorpicker.a a1)
    {
        c = a1;
        c.a(this);
    }

    public void setNewShader()
    {
        ComposeShader composeshader = new ComposeShader(new LinearGradient(b.left, b.top, b.left, b.bottom, -1, 0xff000000, android.graphics.Shader.TileMode.CLAMP), new LinearGradient(b.left, b.top, b.right, b.top, -1, Color.HSVToColor(new float[] {
            c.a(), 1.0F, 1.0F
        }), android.graphics.Shader.TileMode.CLAMP), android.graphics.PorterDuff.Mode.MULTIPLY);
        a.setShader(composeshader);
    }
}
