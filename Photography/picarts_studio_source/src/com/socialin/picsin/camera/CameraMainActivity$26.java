// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class a
    implements android.view.balLayoutListener
{

    private ImageView a;
    private CameraMainActivity b;

    public final void onGlobalLayout()
    {
        int i = a.getWidth();
        int j = a.getHeight();
        if (i > 0 && j > 0)
        {
            m.a(a, this);
            CameraMainActivity.E(b).x = i;
            CameraMainActivity.E(b).y = j;
            if (CameraMainActivity.r(b) != null && !CameraMainActivity.r(b).isRecycled())
            {
                CameraMainActivity.a(b, CameraMainActivity.i(b));
            }
        }
    }

    ner(CameraMainActivity cameramainactivity, ImageView imageview)
    {
        b = cameramainactivity;
        a = imageview;
        super();
    }
}
