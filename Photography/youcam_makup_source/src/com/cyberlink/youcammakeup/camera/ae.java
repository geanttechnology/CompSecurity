// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            m, CameraZoomView, af

public class ae
    implements android.view.View.OnTouchListener
{

    private GestureDetector a;
    private ScaleGestureDetector b;
    private View c;

    public ae(Context context, com.cyberlink.youcammakeup.camera.m m, CameraZoomView camerazoomview, af af)
    {
        a = new GestureDetector(context, new android.view.GestureDetector.SimpleOnGestureListener(m, af) {

            final com.cyberlink.youcammakeup.camera.m a;
            final af b;
            final ae c;

            public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
            {
                if (Math.abs(f) > Math.abs(f1))
                {
                    if (f < 0.0F)
                    {
                        motionevent = com.cyberlink.youcammakeup.widgetpool.ICameraPanel.FlingDirection.a;
                    } else
                    {
                        motionevent = com.cyberlink.youcammakeup.widgetpool.ICameraPanel.FlingDirection.b;
                    }
                } else
                if (f1 < 0.0F)
                {
                    motionevent = com.cyberlink.youcammakeup.widgetpool.ICameraPanel.FlingDirection.c;
                } else
                {
                    motionevent = com.cyberlink.youcammakeup.widgetpool.ICameraPanel.FlingDirection.d;
                }
                if (b != null)
                {
                    b.a(motionevent);
                }
                return true;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionevent)
            {
                com.pf.common.utility.m.c("MotionEventDispatcher", "onSingleTapConfirmed");
                return a.a(ae.a(c), motionevent);
            }

            
            {
                c = ae.this;
                a = m1;
                b = af1;
                super();
            }
        });
        b = new ScaleGestureDetector(context, camerazoomview);
    }

    static View a(ae ae1)
    {
        return ae1.c;
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        c = view;
        a.onTouchEvent(motionevent);
        b.onTouchEvent(motionevent);
        return true;
    }
}
