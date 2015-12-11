// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.target.ui.util.e.a;
import com.target.ui.view.TargetImeEditText;

// Referenced classes of package com.target.ui.view.list:
//            ListItemView

class er extends AnimatorListenerAdapter
{

    final ListItemView this$0;
    final boolean val$editModeCell;

    public void onAnimationEnd(Animator animator)
    {
        mViews.editTitleText.requestFocus();
        (new Handler()).postDelayed(new Runnable() {

            final ListItemView._cls4 this$1;

            public void run()
            {
                a.c(mViews.editTitleText);
            }

            
            {
                this$1 = ListItemView._cls4.this;
                super();
            }
        }, 300L);
        if (val$editModeCell)
        {
            setDisabled(false);
        }
        if (val$editModeCell)
        {
            com.target.ui.view.list.ListItemView.a(ListItemView.this, true);
        }
        com.target.ui.view.list.ListItemView.a(ListItemView.this, null);
    }

    _cls1.this._cls1()
    {
        this$0 = final_listitemview;
        val$editModeCell = Z.this;
        super();
    }
}
