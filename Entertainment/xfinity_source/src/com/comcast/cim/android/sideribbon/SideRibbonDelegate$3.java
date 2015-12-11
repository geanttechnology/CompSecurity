// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.sideribbon;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

// Referenced classes of package com.comcast.cim.android.sideribbon:
//            SideRibbonDelegate

class val.view
    implements android.view.obalLayoutListener
{

    final SideRibbonDelegate this$0;
    final View val$view;

    public void onGlobalLayout()
    {
        SideRibbonDelegate.access$902(SideRibbonDelegate.this, SideRibbonDelegate.access$1000(SideRibbonDelegate.this));
        SideRibbonDelegate.access$1100(SideRibbonDelegate.this, val$view);
        SideRibbonDelegate.access$1200(SideRibbonDelegate.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    ()
    {
        this$0 = final_sideribbondelegate;
        val$view = View.this;
        super();
    }
}
