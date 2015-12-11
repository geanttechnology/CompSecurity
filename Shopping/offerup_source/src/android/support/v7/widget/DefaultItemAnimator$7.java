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
    final angeInfo val$changeInfo;
    final cx val$oldViewAnim;

    public void onAnimationEnd(View view)
    {
        val$oldViewAnim.a(null);
        bi.c(view, 1.0F);
        bi.a(view, 0.0F);
        bi.b(view, 0.0F);
        dispatchChangeFinished(val$changeInfo.oldHolder, true);
        DefaultItemAnimator.access$1300(DefaultItemAnimator.this).remove(val$changeInfo.oldHolder);
        DefaultItemAnimator.access$800(DefaultItemAnimator.this);
    }

    public void onAnimationStart(View view)
    {
        dispatchChangeStarting(val$changeInfo.oldHolder, true);
    }

    angeInfo()
    {
        this$0 = final_defaultitemanimator;
        val$changeInfo = angeinfo;
        val$oldViewAnim = cx.this;
        super(null);
    }
}
