// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.groupon.activity:
//            CategoriesBase

class this._cls0
    implements android.widget.mClickListener
{

    final CategoriesBase this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        onCategoryClick(i);
    }

    Listener()
    {
        this$0 = CategoriesBase.this;
        super();
    }
}
