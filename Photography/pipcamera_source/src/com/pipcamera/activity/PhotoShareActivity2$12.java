// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.pipcamera.application.PIPCameraApplication;
import pb;

// Referenced classes of package com.pipcamera.activity:
//            PhotoShareActivity2

class a
    implements android.view.ivity2._cls12
{

    final PhotoShareActivity2 a;

    public void onClick(View view)
    {
        view = (android.widget.rams)PhotoShareActivity2.a(a).getLayoutParams();
        view.setMargins(0, 0, 0, 0);
        view.height = 0;
        PhotoShareActivity2.a(a).invalidate();
        PhotoShareActivity2.a(a).setVisibility(4);
        view = AnimationUtils.loadAnimation(a, 0x7f04001b);
        PhotoShareActivity2.b(a).startAnimation(view);
        PhotoShareActivity2.b(a).setVisibility(4);
        PhotoShareActivity2.e(a).postDelayed(new Runnable() {

            final PhotoShareActivity2._cls12 a;

            public void run()
            {
                android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)PhotoShareActivity2.c(a.a).getLayoutParams();
                if (PIPCameraApplication.b().a(a.a))
                {
                    layoutparams.setMargins(0, pb.a(a.a, 50F), 0, 0);
                } else
                {
                    layoutparams.setMargins(0, pb.a(a.a, 100F), 0, 0);
                }
                PhotoShareActivity2.c(a.a).requestLayout();
                PhotoShareActivity2.d(a.a).setVisibility(0);
            }

            
            {
                a = PhotoShareActivity2._cls12.this;
                super();
            }
        }, 250L);
    }

    _cls1.a(PhotoShareActivity2 photoshareactivity2)
    {
        a = photoshareactivity2;
        super();
    }
}
