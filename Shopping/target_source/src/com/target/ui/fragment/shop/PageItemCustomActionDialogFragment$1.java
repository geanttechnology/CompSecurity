// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import android.view.View;
import com.target.mothership.model.page_item.interfaces.Action;

// Referenced classes of package com.target.ui.fragment.shop:
//            PageItemCustomActionDialogFragment

class val.primaryAction
    implements android.view.alogFragment._cls1
{

    final PageItemCustomActionDialogFragment this$0;
    final Action val$primaryAction;

    public void onClick(View view)
    {
        PageItemCustomActionDialogFragment.a(PageItemCustomActionDialogFragment.this).a(val$primaryAction);
        dismiss();
    }

    ()
    {
        this$0 = final_pageitemcustomactiondialogfragment;
        val$primaryAction = Action.this;
        super();
    }
}
