// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import com.pipcamera.activity.pip.PipFreeStyleActivity;
import com.pipcamera.activity.pip.view.PaintView;
import com.wantu.piprender.PipFreeStyleImageGLSurfaceView;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipFreeStyleFragment

class a extends Handler
{

    final a a;

    public void handleMessage(Message message)
    {
        if (message != null)
        {
            PipFreeStyleFragment.e(a.a).setVisibility(0);
            PipFreeStyleFragment.f(a.a).setVisibility(0);
            message = (Bitmap)message.obj;
            Bitmap bitmap = PipFreeStyleFragment.a(a.a, message);
            PipFreeStyleFragment.i(a.a).b(bitmap);
            PipFreeStyleFragment.b(a.a).setMaskImage(message);
            PipFreeStyleFragment.b(a.a).setFilterName(PipFreeStyleFragment.k(a.a));
            PipFreeStyleFragment.l(a.a).getProgress();
            PipFreeStyleFragment.b(a.a).setBlurRadius(PipFreeStyleFragment.l(a.a).getProgress() / 5);
        }
        if (PipFreeStyleFragment.i(a.a) != null)
        {
            PipFreeStyleFragment.i(a.a).b();
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/pipcamera/activity/pip/fragment/PipFreeStyleFragment$6

/* anonymous class */
    class PipFreeStyleFragment._cls6
        implements android.view.View.OnClickListener
    {

        final PipFreeStyleFragment a;

        public void onClick(View view)
        {
            if (PipFreeStyleFragment.c(a).hasDrawing())
            {
                PipFreeStyleFragment.i(a).a();
                Bitmap bitmap = PipFreeStyleFragment.c(a).getMaskBitmap();
                PipFreeStyleFragment.c(a).setVisibility(4);
                PipFreeStyleFragment.j(a);
                if (bitmap != null)
                {
                    PipFreeStyleFragment.b(a).processImage(bitmap, "gaussian_12", new PipFreeStyleFragment._cls6._cls1(this));
                    view.setVisibility(4);
                    return;
                }
            }
        }

            
            {
                a = pipfreestylefragment;
                super();
            }
    }

}
