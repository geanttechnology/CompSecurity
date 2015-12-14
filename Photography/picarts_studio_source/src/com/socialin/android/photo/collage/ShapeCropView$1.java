// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import myobfuscated.bq.b;

// Referenced classes of package com.socialin.android.photo.collage:
//            ShapeCropView

final class a
    implements b
{

    private ShapeCropView a;

    public final int a(int i, int j)
    {
        ShapeCropView.c(a).setRectToRect(ShapeCropView.a(a), com.socialin.android.photo.collage.ShapeCropView.b(a), android.graphics.t.CENTER);
        ShapeCropView.d(a)[0] = i;
        ShapeCropView.d(a)[1] = j;
        ShapeCropView.c(a).mapPoints(ShapeCropView.d(a));
        if (ShapeCropView.d(a)[0] < 0.0F || ShapeCropView.d(a)[0] >= (float)ShapeCropView.e(a).getWidth() || ShapeCropView.d(a)[1] < 0.0F || ShapeCropView.d(a)[1] >= (float)ShapeCropView.e(a).getHeight())
        {
            return 0xff000000;
        } else
        {
            return ShapeCropView.e(a).getPixel((int)ShapeCropView.d(a)[0], (int)ShapeCropView.d(a)[1]);
        }
    }

    (ShapeCropView shapecropview)
    {
        a = shapecropview;
        super();
    }
}
