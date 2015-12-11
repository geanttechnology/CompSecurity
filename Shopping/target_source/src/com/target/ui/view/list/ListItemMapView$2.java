// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.target.ui.model.list.ListDetailItem;

// Referenced classes of package com.target.ui.view.list:
//            ListItemMapView

class <init> extends AnimatorListenerAdapter
{

    final ListItemMapView this$0;
    final ListDetailItem val$detailListItem;

    public void onAnimationEnd(Animator animator)
    {
        if (ListItemMapView.a(ListItemMapView.this) != null)
        {
            ListItemMapView.a(ListItemMapView.this).b(val$detailListItem);
        }
    }

    ()
    {
        this$0 = final_listitemmapview;
        val$detailListItem = ListDetailItem.this;
        super();
    }
}
