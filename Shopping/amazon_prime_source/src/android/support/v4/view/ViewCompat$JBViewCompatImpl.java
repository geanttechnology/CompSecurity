// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

// Referenced classes of package android.support.v4.view:
//            ViewCompat, ViewCompatJB

static class  extends 
{

    public boolean getFitsSystemWindows(View view)
    {
        return ViewCompatJB.getFitsSystemWindows(view);
    }

    public int getImportantForAccessibility(View view)
    {
        return ViewCompatJB.getImportantForAccessibility(view);
    }

    public ViewParent getParentForAccessibility(View view)
    {
        return ViewCompatJB.getParentForAccessibility(view);
    }

    public boolean hasOverlappingRendering(View view)
    {
        return ViewCompatJB.hasOverlappingRendering(view);
    }

    public void postInvalidateOnAnimation(View view)
    {
        ViewCompatJB.postInvalidateOnAnimation(view);
    }

    public void postInvalidateOnAnimation(View view, int i, int j, int k, int l)
    {
        ViewCompatJB.postInvalidateOnAnimation(view, i, j, k, l);
    }

    public void postOnAnimation(View view, Runnable runnable)
    {
        ViewCompatJB.postOnAnimation(view, runnable);
    }

    public void setImportantForAccessibility(View view, int i)
    {
        int j = i;
        if (i == 4)
        {
            j = 2;
        }
        ViewCompatJB.setImportantForAccessibility(view, j);
    }

    ()
    {
    }
}
