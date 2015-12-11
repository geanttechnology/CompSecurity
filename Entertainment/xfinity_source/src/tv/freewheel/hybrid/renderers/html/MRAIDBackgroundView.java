// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.html;

import android.app.Activity;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import tv.freewheel.hybrid.utils.Logger;

class MRAIDBackgroundView extends FrameLayout
{

    protected Activity activity;
    private Logger logger;
    private ViewGroup superRootFrame;
    private int titleParentVisibility;

    public MRAIDBackgroundView(Activity activity1)
    {
        super(activity1);
        logger = Logger.getLogger(this);
        activity = activity1;
        logger.debug("MRAIDBackgroundView");
        setBackgroundColor(Color.argb(204, 0, 0, 0));
        activity1 = activity1.getWindow().getDecorView();
        if (activity1 != null)
        {
            superRootFrame = (ViewGroup)activity1;
            return;
        } else
        {
            logger.error("The DecorView of the activity window is not available, full screen is not supported!");
            return;
        }
    }

    void hideFullScreenBackground()
    {
        View view = activity.getWindow().findViewById(0x1020016);
        if (view != null && view.getParent() != null)
        {
            ((ViewGroup)view.getParent()).setVisibility(titleParentVisibility);
        }
        activity.getWindow().clearFlags(1024);
        activity.getWindow().addFlags(2048);
        superRootFrame.removeView(this);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        logger.debug("onTouchEvent");
        return true;
    }

    void showFullScreenBackground()
    {
        logger.debug("showFullScreenBackground");
        if ((activity.getWindow().getAttributes().flags & 0x400) != 1024)
        {
            activity.getWindow().addFlags(1024);
        }
        activity.getWindow().clearFlags(2048);
        Object obj = activity.getWindow().findViewById(0x1020016);
        if (obj != null && ((View) (obj)).getParent() != null)
        {
            obj = (ViewGroup)((View) (obj)).getParent();
            titleParentVisibility = ((ViewGroup) (obj)).getVisibility();
            ((ViewGroup) (obj)).setVisibility(8);
        }
        obj = new android.view.ViewGroup.LayoutParams(-1, -1);
        superRootFrame.addView(this, ((android.view.ViewGroup.LayoutParams) (obj)));
    }
}
