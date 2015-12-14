// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.socialin.android.util.c;
import com.socialin.android.util.w;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class c
    implements Runnable
{

    final CameraMainActivity a;
    private android.hardware.ctivity b;
    private byte c[];

    public final void run()
    {
        float f;
        android.graphics. ;
        int i;
        if (b.b > 1024 || b.b > 1024)
        {
            f = Math.min(1024F / (float)b.b, 1024F / (float)b.b);
        } else
        {
            f = 1.0F;
        }
         = new android.graphics.();
        .inSampleSize = (int)(1.0F / f);
        if ((double)f < 0.75D && (double)f > 0.5D)
        {
            .inSampleSize = 2;
        }
        .inPreferredConfig = android.graphics._fld88;
        CameraMainActivity.a(a, com.socialin.android.util.c.a(c, 0, c.length, ));
        i = com.socialin.picsin.camera.CameraMainActivity.c(a).E();
        if (i == 180)
        {
            CameraMainActivity.a(a, w.d(CameraMainActivity.r(a), i));
        }
        if (com.socialin.picsin.camera.CameraMainActivity.c(a).z() && CameraMainActivity.r(a) != null)
        {
            CameraMainActivity.a(a, w.a(CameraMainActivity.r(a), -1F));
        }
        CameraMainActivity.b(a, false);
        a.runOnUiThread(new Runnable() {

            private CameraMainActivity._cls8 a;

            public final void run()
            {
                if (CameraMainActivity.r(a.a) != null && !CameraMainActivity.r(a.a).isRecycled())
                {
                    ((ImageView)a.a.findViewById(0x7f10022c)).setImageBitmap(CameraMainActivity.r(a.a));
                    CameraMainActivity.v(a.a);
                }
            }

            
            {
                a = CameraMainActivity._cls8.this;
                super();
            }
        });
    }

    _cls1.a(CameraMainActivity cameramainactivity, android.hardware.ctivity ctivity, byte abyte0[])
    {
        a = cameramainactivity;
        b = ctivity;
        c = abyte0;
        super();
    }
}
