// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.h;

import android.view.View;
import com.target.ui.model.shop.a;
import com.target.ui.view.shop.PageItemView;

// Referenced classes of package com.target.ui.adapter.h:
//            b

class ItemView
    implements android.view..OnClickListener
{

    final b this$0;
    final a val$element;
    final PageItemView val$pageItemView;

    public void onClick(View view)
    {
        if (b.b(b.this) == null)
        {
            return;
        } else
        {
            b.b(b.this).a(val$element.a(), val$pageItemView);
            return;
        }
    }

    ItemView()
    {
        this$0 = final_b1;
        val$element = a1;
        val$pageItemView = PageItemView.this;
        super();
    }
}
