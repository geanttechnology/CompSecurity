// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;

public class ky
    implements android.view.View.OnTouchListener
{

    final ActivityCamera a;

    public ky(ActivityCamera activitycamera)
    {
        a = activitycamera;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        int i;
        int j;
        i = (int)motionevent.getX() - ActivityCamera.i(a).getWidth() / 2;
        j = (int)motionevent.getY() - ActivityCamera.i(a).getHeight() / 2;
        motionevent.getAction();
        JVM INSTR tableswitch 0 0: default 60
    //                   0 62;
           goto _L1 _L2
_L1:
        return false;
_L2:
        if (!pt.b(pt.j, a, false) && ActivityCamera.j(a))
        {
            view = (android.widget.FrameLayout.LayoutParams)ActivityCamera.k(a).getLayoutParams();
            view.leftMargin = i;
            view.topMargin = yp.a(a, 45F) + j;
            ActivityCamera.k(a).setLayoutParams(view);
            try
            {
                ActivityCamera.a(a, i, j);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                Crashlytics.logException(view);
                view.printStackTrace();
                return false;
            }
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
