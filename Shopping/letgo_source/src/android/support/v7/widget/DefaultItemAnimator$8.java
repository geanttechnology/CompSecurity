// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ah;
import android.support.v4.view.ay;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            DefaultItemAnimator

class aListenerAdapter extends aListenerAdapter
{

    final DefaultItemAnimator this$0;
    final angeInfo val$changeInfo;
    final View val$newView;
    final ay val$newViewAnimation;

    public void onAnimationEnd(View view)
    {
        val$newViewAnimation.a(null);
        ah.c(val$newView, 1.0F);
        ah.a(val$newView, 0.0F);
        ah.b(val$newView, 0.0F);
        dispatchChangeFinished(val$changeInfo.newHolder, false);
        DefaultItemAnimator.access$1300(DefaultItemAnimator.this).remove(val$changeInfo.newHolder);
        DefaultItemAnimator.access$800(DefaultItemAnimator.this);
    }

    public void onAnimationStart(View view)
    {
        dispatchChangeStarting(val$changeInfo.newHolder, false);
    }

    angeInfo()
    {
        this$0 = final_defaultitemanimator;
        val$changeInfo = angeinfo;
        val$newViewAnimation = ay1;
        val$newView = View.this;
        super(null);
    }
}
