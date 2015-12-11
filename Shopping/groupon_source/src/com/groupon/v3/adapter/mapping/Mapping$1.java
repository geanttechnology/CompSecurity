// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.view.View;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.view.holder.GrouponViewHolder;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

class der extends GrouponViewHolder
{

    final Mapping this$0;

    public void onClick(View view)
    {
        IViewCallback iviewcallback = (IViewCallback)getCallback(com/groupon/v3/adapter/callback/IViewCallback);
        if (iviewcallback != null)
        {
            iviewcallback.onViewClick(view);
        }
    }

    back(View view)
    {
        this$0 = Mapping.this;
        super(view);
    }
}
