// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.bi;
import android.support.v4.view.cx;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            DefaultItemAnimator

class aListenerAdapter extends aListenerAdapter
{

    final DefaultItemAnimator this$0;
    final cx val$animation;
    final int val$deltaX;
    final int val$deltaY;
    final r val$holder;

    public void onAnimationCancel(View view)
    {
        if (val$deltaX != 0)
        {
            bi.a(view, 0.0F);
        }
        if (val$deltaY != 0)
        {
            bi.b(view, 0.0F);
        }
    }

    public void onAnimationEnd(View view)
    {
        val$animation.a(null);
        dispatchMoveFinished(val$holder);
        DefaultItemAnimator.access$1100(DefaultItemAnimator.this).remove(val$holder);
        DefaultItemAnimator.access$800(DefaultItemAnimator.this);
    }

    public void onAnimationStart(View view)
    {
        dispatchMoveStarting(val$holder);
    }

    r()
    {
        this$0 = final_defaultitemanimator;
        val$holder = r;
        val$deltaX = i;
        val$deltaY = j;
        val$animation = cx.this;
        super(null);
    }
}
