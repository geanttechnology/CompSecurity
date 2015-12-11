// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.Button;
import org.apache.commons.lang3.StringUtils;

public class CenterImageButton extends Button
{

    private Bitmap a;
    private Paint b;
    private Rect c;
    private int d;

    public CenterImageButton(Context context)
    {
        super(context);
    }

    public CenterImageButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context, attributeset);
    }

    public CenterImageButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context, attributeset);
    }

    private void a(Context context, AttributeSet attributeset)
    {
        int i;
        attributeset = context.obtainStyledAttributes(attributeset, com.offerup.R.styleable.CenterImageButton);
        i = 0;
_L2:
        int j;
        if (i >= attributeset.getIndexCount())
        {
            break MISSING_BLOCK_LABEL_155;
        }
        j = attributeset.getIndex(i);
        switch (j)
        {
        default:
            break;

        case 0: // '\0'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
            break;
        }
        break MISSING_BLOCK_LABEL_141;
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Drawable drawable = attributeset.getDrawable(j);
        if (drawable instanceof BitmapDrawable)
        {
            context = ((BitmapDrawable)drawable).getBitmap();
        } else
        {
            context = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(context);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        }
        a = context;
          goto _L3
        d = attributeset.getDimensionPixelSize(j, 0);
          goto _L3
        attributeset.recycle();
        b = getPaint();
        if (a != null)
        {
            c = new Rect(0, 0, a.getWidth(), a.getHeight());
            return;
        } else
        {
            c = null;
            return;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        if (a != null && c != null)
        {
            int i = (a.getWidth() + d) / 2;
            canvas.save();
            canvas.translate(i, 0.0F);
        }
        super.onDraw(canvas);
        if (a != null && StringUtils.isNotEmpty(getText()))
        {
            float f = getPaint().measureText(getText().toString());
            int j = (int)((float)getWidth() / 2.0F - f / 2.0F - (float)a.getWidth() - (float)d);
            int k = getHeight() / 2 - a.getHeight() / 2;
            Rect rect = new Rect(j, k, a.getWidth() + j, a.getHeight() + k);
            canvas.drawBitmap(a, c, rect, b);
        }
        canvas.restore();
    }
}
