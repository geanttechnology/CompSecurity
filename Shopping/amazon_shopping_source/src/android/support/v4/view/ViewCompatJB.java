// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class ViewCompatJB
{

    ViewCompatJB()
    {
    }

    public static int getImportantForAccessibility(View view)
    {
        return view.getImportantForAccessibility();
    }

    public static ViewParent getParentForAccessibility(View view)
    {
        return view.getParentForAccessibility();
    }

    public static void postInvalidateOnAnimation(View view)
    {
        view.postInvalidateOnAnimation();
    }

    public static void postInvalidateOnAnimation(View view, int i, int j, int k, int l)
    {
        view.postInvalidate(i, j, k, l);
    }

    public static void postOnAnimation(View view, Runnable runnable)
    {
        view.postOnAnimation(runnable);
    }

    public static void setImportantForAccessibility(View view, int i)
    {
        view.setImportantForAccessibility(i);
    }
}
