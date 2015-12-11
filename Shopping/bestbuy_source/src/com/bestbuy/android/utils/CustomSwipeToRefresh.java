// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bestbuy.android.activities.home.HomeActivity;
import java.lang.reflect.Field;
import nd;
import nf;

public class CustomSwipeToRefresh extends SwipeRefreshLayout
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    private static float b = 0.6F;
    ViewTreeObserver a;
    private int c;
    private nd d;
    private boolean e;
    private boolean f;

    public CustomSwipeToRefresh(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = 300;
        e = false;
        f = false;
        a = getViewTreeObserver();
        a.addOnGlobalLayoutListener(this);
    }

    public boolean canChildScrollUp()
    {
        if (d != null)
        {
            return d.i();
        } else
        {
            return super.canChildScrollUp();
        }
    }

    public void onGlobalLayout()
    {
        Object obj = getResources().getDisplayMetrics();
        float f1 = ((View)getParent()).getHeight();
        float f2 = b;
        float f3 = c;
        f1 = Math.min(f1 * f2, ((DisplayMetrics) (obj)).density * f3);
        try
        {
            obj = android/support/v4/widget/SwipeRefreshLayout.getDeclaredField("mDistanceToTriggerSync");
            ((Field) (obj)).setAccessible(true);
            ((Field) (obj)).setFloat(this, Float.valueOf(f1).floatValue());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((NoSuchFieldException) (obj)).printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IllegalAccessException) (obj)).printStackTrace();
        }
        obj = getViewTreeObserver();
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            ((ViewTreeObserver) (obj)).removeOnGlobalLayoutListener(this);
            return;
        } else
        {
            ((ViewTreeObserver) (obj)).removeGlobalOnLayoutListener(this);
            return;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        flag = false;
        if (!(getContext() instanceof HomeActivity))
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (!f) goto _L2; else goto _L1
_L1:
        if (!e) goto _L4; else goto _L3
_L3:
        flag = super.onInterceptTouchEvent(motionevent);
_L6:
        return flag;
_L4:
        e = false;
        return false;
_L2:
        if (motionevent.getY() >= nf.a(330F, getContext())) goto _L6; else goto _L5
_L5:
        return super.onInterceptTouchEvent(motionevent);
        return super.onInterceptTouchEvent(motionevent);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return super.onTouchEvent(motionevent);
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        super.requestDisallowInterceptTouchEvent(flag);
    }

    public void setCanChildScrollUpCallback(nd nd1)
    {
        d = nd1;
    }

    public void setFromMDotWebFragment(boolean flag)
    {
        f = flag;
    }

    public void setPullDownEvent(boolean flag)
    {
        e = flag;
    }

}
