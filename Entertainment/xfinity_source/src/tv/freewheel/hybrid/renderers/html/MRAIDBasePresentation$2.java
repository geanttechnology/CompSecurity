// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.html;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package tv.freewheel.hybrid.renderers.html:
//            MRAIDBasePresentation, HTMLRenderer

class val.isResized
    implements android.view.lLayoutListener
{

    final MRAIDBasePresentation this$0;
    final boolean val$isResized;
    final View val$view;

    public void onGlobalLayout()
    {
        val$view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        bridge.synchStateToPresentation(val$isResized);
    }

    ()
    {
        this$0 = final_mraidbasepresentation;
        val$view = view1;
        val$isResized = Z.this;
        super();
    }
}
