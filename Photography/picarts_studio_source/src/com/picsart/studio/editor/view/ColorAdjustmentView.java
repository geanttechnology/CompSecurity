// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.picsart.studio.editor.Camera;
import com.socialin.android.photo.imgop.a;

// Referenced classes of package com.picsart.studio.editor.view:
//            EditorView

public class ColorAdjustmentView extends EditorView
{

    private ColorMatrix i;
    private ColorMatrix j;
    private ColorMatrix k;
    private ColorMatrix l;
    private ColorMatrix m;
    private Paint n;

    public ColorAdjustmentView(Context context)
    {
        this(context, null);
    }

    public ColorAdjustmentView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ColorAdjustmentView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        i = new ColorMatrix();
        j = new ColorMatrix();
        k = new ColorMatrix();
        l = new ColorMatrix();
        n = new Paint(2);
        m = new ColorMatrix();
    }

    private void e()
    {
        m.set(l);
        m.postConcat(i);
        m.postConcat(j);
        m.postConcat(k);
        n.setColorFilter(new ColorMatrixColorFilter(m));
        invalidate();
    }

    public final void a(Canvas canvas)
    {
        if (e != null && !e.isRecycled())
        {
            c.b(canvas);
            canvas.drawBitmap(e, 0.0F, 0.0F, n);
            canvas.restore();
        }
    }

    public void setBrightness(int i1)
    {
        com.socialin.android.photo.imgop.a.a(1, i1 + 100, i);
        e();
    }

    public void setColorAdjustmentParameters(int i1, int j1, int k1, int l1)
    {
        com.socialin.android.photo.imgop.a.a(1, i1 + 100, i);
        com.socialin.android.photo.imgop.a.a(2, (j1 + 100) / 2, j);
        com.socialin.android.photo.imgop.a.a(0, (k1 + 100) / 2, k);
        com.socialin.android.photo.imgop.a.a(7, l1, l);
        e();
    }

    public void setContrast(int i1)
    {
        com.socialin.android.photo.imgop.a.a(2, (i1 + 100) / 2, j);
        e();
    }

    public void setHue(int i1)
    {
        com.socialin.android.photo.imgop.a.a(7, i1, l);
        e();
    }

    public void setSaturation(int i1)
    {
        com.socialin.android.photo.imgop.a.a(0, (i1 + 100) / 2, k);
        e();
    }
}
