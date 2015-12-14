// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import com.pipcamera.activity.pip.PipRealTimeCameraActivity;
import ev;
import java.util.ArrayList;
import jp.co.cyberagent.android.gpuimage.camera.PipCameraGLSurfaceView;
import se;
import sf;
import sg;
import so;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipCameraFragment

class d
    implements Runnable
{

    final byte a[];
    final int b;
    final String c;
    final Uri d;
    final PipCameraFragment e;

    public void run()
    {
        Bitmap bitmap = ev.a(a, a, b, b);
        Matrix matrix = new Matrix();
        matrix.postRotate(se.a(PipCameraFragment.d(e), PipCameraFragment.q(e).isFrontFacing()));
        if (PipCameraFragment.q(e).isFrontFacing())
        {
            matrix.postScale(-1F, 1.0F);
        }
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        PipCameraFragment.d(e).a(bitmap);
        sf.a().a(bitmap, c, PipCameraFragment.d(e), new sg() {

            final PipCameraFragment._cls17 a;

            public void a()
            {
                PipCameraFragment.d(a.e).runOnUiThread(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        PipCameraFragment.d(a.a.e).runOnUiThread(new Runnable(this) {

                            final _cls1 a;

                            public void run()
                            {
                                so so1 = new so();
                                ArrayList arraylist = new ArrayList();
                                arraylist.add(a.a.a.d);
                                so1.a(arraylist);
                                PipCameraFragment.e(a.a.a.e, PipCameraFragment.u(a.a.a.e));
                                so1.b(PipCameraFragment.v(a.a.a.e));
                                so1.a(a.a.a.e);
                                so1.a(3000);
                                so1.c(new ArrayList[0]);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            public void b()
            {
            }

            
            {
                a = PipCameraFragment._cls17.this;
                super();
            }
        });
    }

    _cls1.a(PipCameraFragment pipcamerafragment, byte abyte0[], int i, String s, Uri uri)
    {
        e = pipcamerafragment;
        a = abyte0;
        b = i;
        c = s;
        d = uri;
        super();
    }
}
