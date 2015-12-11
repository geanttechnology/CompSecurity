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

class this._cls1
    implements Runnable
{

    final a.editTitleText this$1;

    public void run()
    {
        a.c(mViews.editTitleText);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/target/ui/view/list/ListItemView$4

/* anonymous class */
    class ListItemView._cls4 extends AnimatorListenerAdapter
    {

        final ListItemView this$0;
        final boolean val$editModeCell;

        public void onAnimationEnd(Animator animator)
        {
            mViews.editTitleText.requestFocus();
            (new Handler()).postDelayed(new ListItemView._cls4._cls1(), 300L);
            if (editModeCell)
            {
                setDisabled(false);
            }
            if (editModeCell)
            {
                com.target.ui.view.list.ListItemView.a(ListItemView.this, true);
            }
            com.target.ui.view.list.ListItemView.a(ListItemView.this, null);
        }

            
            {
                this$0 = final_listitemview;
                editModeCell = Z.this;
                super();
            }
    }

}
