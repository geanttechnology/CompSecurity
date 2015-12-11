// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            ViewCompat, AccessibilityDelegateCompat

static class 
    implements 
{

    public boolean canScrollHorizontally(View view, int i)
    {
        return false;
    }

    long getFrameTime()
    {
        return 10L;
    }

    public int getImportantForAccessibility(View view)
    {
        return 0;
    }

    public int getLayerType(View view)
    {
        return 0;
    }

    public int getLayoutDirection(View view)
    {
        return 0;
    }

    public int getOverScrollMode(View view)
    {
        return 2;
    }

    public boolean isOpaque(View view)
    {
        boolean flag1 = false;
        view = view.getBackground();
        boolean flag = flag1;
        if (view != null)
        {
            flag = flag1;
            if (view.getOpacity() == -1)
            {
                flag = true;
            }
        }
        return flag;
    }

    public void postInvalidateOnAnimation(View view)
    {
        view.postInvalidateDelayed(getFrameTime());
    }

    public void postInvalidateOnAnimation(View view, int i, int j, int k, int l)
    {
        view.postInvalidateDelayed(getFrameTime(), i, j, k, l);
    }

    public void postOnAnimation(View view, Runnable runnable)
    {
        view.postDelayed(runnable, getFrameTime());
    }

    public void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilitydelegatecompat)
    {
    }

    public void setImportantForAccessibility(View view, int i)
    {
    }

    public void setLayerPaint(View view, Paint paint)
    {
    }

    public void setLayerType(View view, int i, Paint paint)
    {
    }

    ()
    {
    }
}
