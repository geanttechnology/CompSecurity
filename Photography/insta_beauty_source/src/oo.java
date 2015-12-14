// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.widget.ImageView;

class oo
    implements android.view.View.OnClickListener
{

    final Bitmap a;
    final ImageView b;
    final oj c;

    oo(oj oj1, Bitmap bitmap, ImageView imageview)
    {
        c = oj1;
        a = bitmap;
        b = imageview;
        super();
    }

    public void onClick(View view)
    {
        oj.d(c, (oj.h(c) + 90) % 360);
        oj.h(c);
        JVM INSTR lookupswitch 4: default 72
    //                   0: 170
    //                   90: 182
    //                   180: 219
    //                   270: 233;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        (new Matrix()).setRotate(oj.h(c), (float)a.getWidth() / 2.0F, (float)a.getHeight() / 2.0F);
        view = new Matrix();
        int i = a.getHeight();
        int j = a.getWidth();
        view.postRotate(oj.h(c));
        view = Bitmap.createBitmap(a, 0, 0, j, i, view, true);
        b.setImageBitmap(view);
        return;
_L2:
        oj.e(c, 0);
        continue; /* Loop/switch isn't completed */
_L3:
        if (oj.e(c))
        {
            oj.e(c, 270);
        } else
        {
            oj.e(c, 90);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        oj.e(c, 180);
        continue; /* Loop/switch isn't completed */
_L5:
        if (oj.e(c))
        {
            oj.e(c, 90);
        } else
        {
            oj.e(c, 270);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }
}
