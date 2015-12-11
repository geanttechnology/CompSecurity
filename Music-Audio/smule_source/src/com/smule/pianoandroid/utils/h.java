// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.smule.pianoandroid.magicpiano.MagicApplication;

// Referenced classes of package com.smule.pianoandroid.utils:
//            j

public class h extends LayerDrawable
{

    private static final String a = com/smule/pianoandroid/utils/h.getSimpleName();
    private String b;
    private Paint c;
    private Rect d;

    public h(float f, Drawable adrawable[], String s)
    {
        super(adrawable);
        b = "";
        c = new Paint(1);
        c.setTextAlign(android.graphics.Paint.Align.CENTER);
        c.setTextSize(f);
        c.setTypeface(Typeface.DEFAULT_BOLD);
        d = new Rect();
        a(s);
    }

    public void a(String s)
    {
        b = s;
        c.getTextBounds(b, 0, b.length(), d);
        invalidateSelf();
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        float f = j.a(3, MagicApplication.getContext()) * 2;
        float f1 = (float)(getBounds().right - d.width()) - f;
        c.setColor(0xffff0000);
        canvas.drawRoundRect(new RectF(f1, 0.0F, getBounds().right, (float)d.height() + 0.0F + f), 5F, 5F, c);
        c.setColor(-1);
        String s = b;
        float f2 = f / 1.3F;
        float f3 = d.height();
        canvas.drawText(s, f1 + f2, f / 2.0F + (0.0F + f3), c);
    }

}
