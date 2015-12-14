// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.eyereplacer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.View;
import android.widget.SlidingDrawer;
import com.socialin.android.util.Utils;
import java.util.ArrayList;

// Referenced classes of package com.picsart.effects.eyereplacer:
//            EyeReplacerActivity, a, c, EyeReplaceImageView, 
//            d, b

final class a
    implements android.view.ReplacerActivity._cls1
{

    private EyeReplacerActivity a;

    public final void onClick(View view)
    {
        if (EyeReplacerActivity.a(a).j)
        {
            Utils.b(a, 0x7f080405);
        } else
        {
            Object obj = EyeReplacerActivity.b(a).a();
            RectF rectf = EyeReplacerActivity.c(a).a;
            view = EyeReplacerActivity.c(a).b;
            if (view != null && !view.isRecycled())
            {
                float f = rectf.width() / (float)view.getWidth();
                view = EyeReplacerActivity.a(a);
                float f1 = ((PointF) (obj)).x;
                float f2 = ((PointF) (obj)).y;
                float f3 = EyeReplacerActivity.b(a).b.b;
                float f4 = rectf.left;
                float f5 = rectf.top;
                view.j = true;
                int i = (int)((f1 - f4) / f);
                int j = (int)((f2 - f5) / f);
                int k = (int)(f3 / f);
                obj = new PorterDuffXfermode(android.graphics.it>);
                ((a) (view)).e.setXfermode(((android.graphics.Xfermode) (obj)));
                ((a) (view)).f.drawCircle(i, j, k, ((a) (view)).e);
                obj = new PorterDuffXfermode(android.graphics.ER);
                ((a) (view)).e.setXfermode(((android.graphics.Xfermode) (obj)));
                ((a) (view)).f.drawBitmap(((a) (view)).c, 0.0F, 0.0F, ((a) (view)).e);
                obj = new b();
                obj.a = i;
                obj.b = j;
                obj.c = k;
                ((a) (view)).g.add(obj);
                view.j = false;
                EyeReplacerActivity.c(a).invalidate();
                a.findViewById(0x7f1004d3).setEnabled(true);
                a.findViewById(0x7f1004d4).setEnabled(true);
                a.findViewById(0x7f1004d2).setEnabled(true);
                if (EyeReplacerActivity.d(a))
                {
                    view = (SlidingDrawer)a.findViewById(0x7f10057c);
                    if (!view.isOpened())
                    {
                        view.open();
                    }
                    EyeReplacerActivity.e(a);
                    return;
                }
            }
        }
    }

    (EyeReplacerActivity eyereplaceractivity)
    {
        a = eyereplaceractivity;
        super();
    }
}
