// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

public class lp
    implements android.view.View.OnTouchListener
{

    final ActivityCameraNew a;

    public lp(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (view.getId() == 0x7f0d0065)
        {
            ActivityCameraNew.v(a).onTouchEvent(motionevent);
        }
        if (view.getId() == 0x7f0d006a)
        {
            if (motionevent.getAction() == 1)
            {
                if (System.nanoTime() - ActivityCameraNew.w(a) < 0x1dcd6500L)
                {
                    ActivityCameraNew.x(a);
                    Toast.makeText(a.getApplicationContext(), a.getResources().getString(0x7f0601c5), 0).show();
                    return false;
                }
                ActivityCameraNew.e(a);
            }
            if (motionevent.getAction() == 0)
            {
                ActivityCameraNew.y(a);
            }
        }
        return true;
    }
}
