// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.widget.ImageButton;

// Referenced classes of package com.appnexus.opensdk:
//            q

final class b
    implements Runnable
{

    final ImageButton a;
    final ImageButton b;
    final q c;

    public final void run()
    {
        Bitmap bitmap = BitmapFactory.decodeResource(q.a(c).getResources(), 0x1080024);
        a.setImageBitmap(bitmap);
        Matrix matrix = new Matrix();
        b.setScaleType(android.widget.eView.ScaleType.MATRIX);
        matrix.postRotate(180F);
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        b.setScaleType(android.widget.eView.ScaleType.CENTER_INSIDE);
        a.setScaleType(android.widget.eView.ScaleType.CENTER_INSIDE);
        b.setImageBitmap(bitmap);
    }

    n(q q1, ImageButton imagebutton, ImageButton imagebutton1)
    {
        c = q1;
        a = imagebutton;
        b = imagebutton1;
        super();
    }
}
