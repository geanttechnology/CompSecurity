// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.image;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.image:
//            BaseLayout

class InterstitialLayout extends BaseLayout
{

    private Logger logger;
    private ViewGroup superRootFrame;
    private int titleParentVisibility;

    public InterstitialLayout(Activity activity)
    {
        super(activity);
        logger = Logger.getLogger(this);
        this.activity = activity;
        logger.debug("InterstitialLayout");
        setBackgroundColor(Color.argb(255, 0, 0, 0));
        activity = activity.getWindow().getDecorView();
        if (activity != null)
        {
            superRootFrame = (ViewGroup)activity;
            return;
        } else
        {
            logger.error("The DecorView of the activity window is not available, full screen is not supported!");
            return;
        }
    }

    public void addAdView(View view, ViewGroup viewgroup, int i, int j, boolean flag)
    {
        showFullscreenBackground();
        super.addAdView(view, viewgroup, i, j, flag);
    }

    void hideFullscreenBackground()
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

    public void removeAdView(View view)
    {
        hideFullscreenBackground();
        super.removeAdView(view);
    }

    void showFullscreenBackground()
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

    protected void updateBaseSize()
    {
        baseWidthInPixel = activity.getResources().getDisplayMetrics().widthPixels;
        baseHeightInPixel = activity.getResources().getDisplayMetrics().heightPixels;
    }
}
