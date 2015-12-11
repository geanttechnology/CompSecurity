// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.popup;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.amazon.retailsearch.popup:
//            PopupDialogFragmentV4

class val.runnable
    implements android.view.lLayoutListener
{

    final PopupDialogFragmentV4 this$0;
    final Runnable val$runnable;
    final View val$view;

    public void onGlobalLayout()
    {
        if (android.os.balLayoutListener < 16)
        {
            val$view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else
        {
            val$view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        val$runnable.run();
    }

    ()
    {
        this$0 = final_popupdialogfragmentv4;
        val$view = view1;
        val$runnable = Runnable.this;
        super();
    }
}
