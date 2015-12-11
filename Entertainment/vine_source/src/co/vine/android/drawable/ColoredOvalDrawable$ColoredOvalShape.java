// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;

// Referenced classes of package co.vine.android.drawable:
//            ColoredOvalDrawable

public class this._cls0 extends OvalShape
{

    final ColoredOvalDrawable this$0;

    public void draw(Canvas canvas, Paint paint)
    {
        paint.setColor(mColor);
        super.draw(canvas, paint);
    }

    public ()
    {
        this$0 = ColoredOvalDrawable.this;
        super();
    }
}
