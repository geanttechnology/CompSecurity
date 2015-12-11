// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            DetailsHeaderViewHolder

class this._cls0
    implements android.view.ayoutListener
{

    final DetailsHeaderViewHolder this$0;

    public void onGlobalLayout()
    {
        DetailsHeaderViewHolder.access$000(DetailsHeaderViewHolder.this);
        ViewTreeObserver viewtreeobserver = itemView.getViewTreeObserver();
        if (viewtreeobserver.isAlive())
        {
            viewtreeobserver.removeOnGlobalLayoutListener(this);
        }
    }

    ()
    {
        this$0 = DetailsHeaderViewHolder.this;
        super();
    }
}
