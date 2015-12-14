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

final class a
    implements Runnable
{

    final ImageView a;
    final CameraMainActivity b;
    private android.hardware.ctivity c;
    private byte d[];

    public final void run()
    {
        float f = Math.min(128F / (float)c.c, 128F / (float)c.c);
        android.graphics.  = new android.graphics.();
        .inSampleSize = (int)(1.0F / f);
        CameraMainActivity.b(b, com.socialin.android.util.c.a(d, 0, d.length, ));
        CameraMainActivity.b(b, w.d(com.socialin.picsin.camera.CameraMainActivity.w(b), CameraMainActivity.s(b)));
        b.runOnUiThread(new Runnable() {

            private CameraMainActivity._cls9 a;

            public final void run()
            {
                if (com.socialin.picsin.camera.CameraMainActivity.w(a.b) != null && !com.socialin.picsin.camera.CameraMainActivity.w(a.b).isRecycled())
                {
                    a.a.setImageBitmap(com.socialin.picsin.camera.CameraMainActivity.w(a.b));
                    return;
                } else
                {
                    CameraMainActivity.b(a.b, null);
                    return;
                }
            }

            
            {
                a = CameraMainActivity._cls9.this;
                super();
            }
        });
    }

    _cls1.a(CameraMainActivity cameramainactivity, android.hardware.ctivity ctivity, byte abyte0[], ImageView imageview)
    {
        b = cameramainactivity;
        c = ctivity;
        d = abyte0;
        a = imageview;
        super();
    }
}
