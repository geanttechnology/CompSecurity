// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.CharacterStyle;

final class byg extends CharacterStyle
{

    private static final int a = Color.argb(137, 0, 0, 0);
    private static final int b = Color.argb(179, 255, 255, 255);

    byg()
    {
    }

    public final void updateDrawState(TextPaint textpaint)
    {
        int i = textpaint.getColor() | 0xff000000;
        if (i == 0xff000000)
        {
            textpaint.setColor(a);
        } else
        if (i == -1)
        {
            textpaint.setColor(b);
            return;
        }
    }

}
