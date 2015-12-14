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
        if (com.socialin.picsin.camera.CameraMainActivity.w(a.a) != null && !com.socialin.picsin.camera.CameraMainActivity.w(a.a).isRecycled())
        {
            a.a.setImageBitmap(com.socialin.picsin.camera.CameraMainActivity.w(a.a));
            return;
        } else
        {
            CameraMainActivity.b(a.a, null);
            return;
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/picsin/camera/CameraMainActivity$9

/* anonymous class */
    final class CameraMainActivity._cls9
        implements Runnable
    {

        final ImageView a;
        final CameraMainActivity b;
        private android.hardware.Camera.Size c;
        private byte d[];

        public final void run()
        {
            float f = Math.min(128F / (float)c.width, 128F / (float)c.height);
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inSampleSize = (int)(1.0F / f);
            CameraMainActivity.b(b, com.socialin.android.util.c.a(d, 0, d.length, options));
            CameraMainActivity.b(b, w.d(com.socialin.picsin.camera.CameraMainActivity.w(b), CameraMainActivity.s(b)));
            b.runOnUiThread(new CameraMainActivity._cls9._cls1(this));
        }

            
            {
                b = cameramainactivity;
                c = size;
                d = abyte0;
                a = imageview;
                super();
            }
    }

}
