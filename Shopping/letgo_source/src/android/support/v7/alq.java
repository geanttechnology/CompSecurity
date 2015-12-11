// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

// Referenced classes of package android.support.v7:
//            ax

public class alq extends MetricAffectingSpan
{

    private static ax a = new ax(5);
    private Typeface b;

    public alq(Context context, String s)
    {
        b = (Typeface)a.a(s);
        if (b == null)
        {
            b = Typeface.createFromAsset(context.getApplicationContext().getAssets(), String.format("%s", new Object[] {
                s
            }));
            a.a(s, b);
        }
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setTypeface(b);
    }

    public void updateMeasureState(TextPaint textpaint)
    {
        textpaint.setTypeface(b);
    }

}
