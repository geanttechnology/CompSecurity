// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.decorator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import bkb;
import bnv;

public class TGifEleDecorator extends bkb
{

    public RenderType d;
    public int e;
    public int f;
    public bnv g;

    public int a()
    {
        if (g != null)
        {
            return g.b();
        } else
        {
            return 0;
        }
    }

    public void a(Canvas canvas, int i)
    {
        android.graphics.Bitmap bitmap = g.c(i % a());
        if (d == RenderType.BLEND)
        {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SCREEN));
            if (bitmap != null)
            {
                canvas.drawBitmap(bitmap, b, paint);
            }
        } else
        if (bitmap != null)
        {
            canvas.drawBitmap(bitmap, b, null);
            return;
        }
    }

    private class RenderType extends Enum
    {

        private static final RenderType $VALUES[];
        public static final RenderType BLEND;
        public static final RenderType DRAW;
        public static final RenderType TRANSCOLOR;

        public static RenderType valueOf(String s)
        {
            return (RenderType)Enum.valueOf(com/wantu/imagelib/decorator/TGifEleDecorator$RenderType, s);
        }

        public static RenderType[] values()
        {
            return (RenderType[])$VALUES.clone();
        }

        static 
        {
            TRANSCOLOR = new RenderType("TRANSCOLOR", 0);
            BLEND = new RenderType("BLEND", 1);
            DRAW = new RenderType("DRAW", 2);
            $VALUES = (new RenderType[] {
                TRANSCOLOR, BLEND, DRAW
            });
        }

        private RenderType(String s, int i)
        {
            super(s, i);
        }
    }

}
