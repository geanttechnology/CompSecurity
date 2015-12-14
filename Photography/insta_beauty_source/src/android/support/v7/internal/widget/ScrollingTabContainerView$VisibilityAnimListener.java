// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            ScrollingTabContainerView

public class b
    implements ViewPropertyAnimatorListener
{

    final ScrollingTabContainerView a;
    private boolean b;
    private int c;

    public b a(ViewPropertyAnimatorCompat viewpropertyanimatorcompat, int i)
    {
        c = i;
        a.mVisibilityAnim = viewpropertyanimatorcompat;
        return this;
    }

    public void onAnimationCancel(View view)
    {
        b = true;
    }

    public void onAnimationEnd(View view)
    {
        if (b)
        {
            return;
        } else
        {
            a.mVisibilityAnim = null;
            a.setVisibility(c);
            return;
        }
    }

    public void onAnimationStart(View view)
    {
        a.setVisibility(0);
        b = false;
    }

    protected Y(ScrollingTabContainerView scrollingtabcontainerview)
    {
        a = scrollingtabcontainerview;
        super();
        b = false;
    }
}
