// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;

public class oe
    implements android.view.View.OnTouchListener
{

    final ActivityCameraNoRealtime a;

    public oe(ActivityCameraNoRealtime activitycameranorealtime)
    {
        a = activitycameranorealtime;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        int i;
        int j;
        i = (int)motionevent.getX() - ActivityCameraNoRealtime.f(a).getWidth() / 2;
        j = (int)motionevent.getY() - ActivityCameraNoRealtime.f(a).getHeight() / 2 - ActivityCameraNoRealtime.g(a).getHeight() / 2;
        motionevent.getAction();
        JVM INSTR tableswitch 0 0: default 76
    //                   0 78;
           goto _L1 _L2
_L1:
        return false;
_L2:
        if (!pt.b(pt.j, a, true))
        {
            view = (android.widget.FrameLayout.LayoutParams)ActivityCameraNoRealtime.g(a).getLayoutParams();
            view.leftMargin = i;
            view.topMargin = j;
            ActivityCameraNoRealtime.g(a).setLayoutParams(view);
            try
            {
                ActivityCameraNoRealtime.a(a, i, j);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                Crashlytics.logException(view);
                view.printStackTrace();
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
