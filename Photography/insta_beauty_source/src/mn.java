// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import com.fotoable.beautyui.gpuimage.sample.activity.CameraFilterScrollView;
import java.io.PrintStream;

public class mn extends android.view.GestureDetector.SimpleOnGestureListener
{

    final ActivityCameraNew a;

    public mn(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (motionevent.getX() - motionevent1.getX() > 50F && Math.abs(f) > 0.0F)
        {
            ActivityCameraNew.ai(a).setScrollSelected(false);
            pt.a(pt.q, a, true);
        } else
        if (motionevent1.getX() - motionevent.getX() > 50F && Math.abs(f) > 0.0F)
        {
            ActivityCameraNew.ai(a).setScrollSelected(true);
            pt.a(pt.q, a, true);
            return false;
        }
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        new PointF(motionevent.getX(), motionevent.getY());
        if (ActivityCameraNew.ae(a))
        {
            if (ActivityCameraNew.af(a))
            {
                ActivityCameraNew.D(a);
            } else
            {
                ActivityCameraNew.E(a);
            }
        } else
        {
            ActivityCameraNew.V(a).setVisibility(0);
            AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
            alphaanimation.setDuration(200L);
            alphaanimation.setInterpolator(new LinearInterpolator());
            alphaanimation.setRepeatCount(-1);
            alphaanimation.setRepeatMode(2);
            ActivityCameraNew.V(a).startAnimation(alphaanimation);
            ActivityCameraNew.V(a).setX(motionevent.getX() - (float)(ActivityCameraNew.V(a).getHeight() / 2));
            ActivityCameraNew.V(a).setY(motionevent.getY());
            ActivityCameraNew.ag(a);
        }
        System.out.println((new StringBuilder()).append("touchtake:").append(ActivityCameraNew.ah(a)).toString());
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        return super.onSingleTapUp(motionevent);
    }
}
