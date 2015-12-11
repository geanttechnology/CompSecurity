// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.ebay.mobile.activities:
//            ModalActivity

class val.modalMain
    implements android.view..OnGlobalLayoutListener
{

    final ModalActivity this$0;
    final View val$modalMain;

    public void onGlobalLayout()
    {
        val$modalMain.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ModalActivity.access$002(ModalActivity.this, val$modalMain.getLeft());
        ModalActivity.access$102(ModalActivity.this, val$modalMain.getTop());
        if (ModalActivity.access$200(ModalActivity.this))
        {
            ModalActivity.access$300(ModalActivity.this);
        }
    }

    tListener()
    {
        this$0 = final_modalactivity;
        val$modalMain = View.this;
        super();
    }
}
