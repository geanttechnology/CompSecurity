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

    private a a;

    public final void run()
    {
        if (CameraMainActivity.r(a.a) != null && !CameraMainActivity.r(a.a).isRecycled())
        {
            ((ImageView)a.a.findViewById(0x7f10022c)).setImageBitmap(CameraMainActivity.r(a.a));
            CameraMainActivity.v(a.a);
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/picsin/camera/CameraMainActivity$8

/* anonymous class */
    final class CameraMainActivity._cls8
        implements Runnable
    {

        final CameraMainActivity a;
        private android.hardware.Camera.Size b;
        private byte c[];

        public final void run()
        {
            float f;
            android.graphics.BitmapFactory.Options options;
            int i;
            if (b.width > 1024 || b.height > 1024)
            {
                f = Math.min(1024F / (float)b.width, 1024F / (float)b.height);
            } else
            {
                f = 1.0F;
            }
            options = new android.graphics.BitmapFactory.Options();
            options.inSampleSize = (int)(1.0F / f);
            if ((double)f < 0.75D && (double)f > 0.5D)
            {
                options.inSampleSize = 2;
            }
            options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
            CameraMainActivity.a(a, com.socialin.android.util.c.a(c, 0, c.length, options));
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
            a.runOnUiThread(new CameraMainActivity._cls8._cls1(this));
        }

            
            {
                a = cameramainactivity;
                b = size;
                c = abyte0;
                super();
            }
    }

}
