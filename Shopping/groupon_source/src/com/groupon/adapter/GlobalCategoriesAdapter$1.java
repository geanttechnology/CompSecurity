// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.view.View;
import com.groupon.models.category.Category;

// Referenced classes of package com.groupon.adapter:
//            GlobalCategoriesAdapter

class this._cls0
    implements android.view.pter._cls1
{

    final GlobalCategoriesAdapter this$0;

    public void onClick(View view)
    {
        addRemoveCategory((Category)view.getTag());
    }

    ()
    {
        this$0 = GlobalCategoriesAdapter.this;
        super();
    }
}
