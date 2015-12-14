// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            TutorialFragment

class a
    implements Runnable
{

    final ImageView a;
    final TutorialFragment b;

    public void run()
    {
        Matrix matrix = new Matrix();
        matrix.reset();
        float f2 = a.getWidth();
        float f3 = a.getHeight();
        float f = a.getDrawable().getIntrinsicWidth();
        float f1 = a.getDrawable().getIntrinsicHeight();
        if (f / f2 > f1 / f3)
        {
            matrix.setScale(f3 / f1, f3 / f1);
            f1 = (f * f3) / f1;
            f = f3;
        } else
        {
            matrix.setScale(f2 / f, f2 / f);
            f = (f1 * f2) / f;
            f1 = f2;
        }
        matrix.preTranslate((f2 - f1) / 2.0F, (f3 - f) / 2.0F);
        a.setScaleType(android.widget..MATRIX);
        a.setImageMatrix(matrix);
    }

    (TutorialFragment tutorialfragment, ImageView imageview)
    {
        b = tutorialfragment;
        a = imageview;
        super();
    }
}
