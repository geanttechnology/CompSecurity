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
    final ay val$animation;
    final r val$holder;

    public void onAnimationCancel(View view)
    {
        ah.c(view, 1.0F);
    }

    public void onAnimationEnd(View view)
    {
        val$animation.a(null);
        dispatchAddFinished(val$holder);
        DefaultItemAnimator.access$900(DefaultItemAnimator.this).remove(val$holder);
        DefaultItemAnimator.access$800(DefaultItemAnimator.this);
    }

    public void onAnimationStart(View view)
    {
        dispatchAddStarting(val$holder);
    }

    r()
    {
        this$0 = final_defaultitemanimator;
        val$holder = r;
        val$animation = ay.this;
        super(null);
    }
}
