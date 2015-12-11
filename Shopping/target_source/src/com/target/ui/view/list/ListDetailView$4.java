// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.animation.Animator;
import com.target.ui.util.al;

// Referenced classes of package com.target.ui.view.list:
//            ListDetailView

class val.end
    implements android.animation.Listener
{

    final ListDetailView this$0;
    final float val$end;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (val$end == 0.0F)
        {
            al.c(ListDetailView.a(ListDetailView.this).itemsMaskView);
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ews()
    {
        this$0 = final_listdetailview;
        val$end = F.this;
        super();
    }
}
