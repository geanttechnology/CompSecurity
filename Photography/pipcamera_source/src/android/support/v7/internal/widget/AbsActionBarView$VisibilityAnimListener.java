// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.ActionMenuView;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            AbsActionBarView

public class c
    implements ViewPropertyAnimatorListener
{

    int a;
    final AbsActionBarView b;
    private boolean c;

    public c a(ViewPropertyAnimatorCompat viewpropertyanimatorcompat, int i)
    {
        b.mVisibilityAnim = viewpropertyanimatorcompat;
        a = i;
        return this;
    }

    public void onAnimationCancel(View view)
    {
        c = true;
    }

    public void onAnimationEnd(View view)
    {
        if (!c)
        {
            b.mVisibilityAnim = null;
            b.setVisibility(a);
            if (b.mSplitView != null && b.mMenuView != null)
            {
                b.mMenuView.setVisibility(a);
                return;
            }
        }
    }

    public void onAnimationStart(View view)
    {
        b.setVisibility(0);
        c = false;
    }

    protected (AbsActionBarView absactionbarview)
    {
        b = absactionbarview;
        super();
        c = false;
    }
}
