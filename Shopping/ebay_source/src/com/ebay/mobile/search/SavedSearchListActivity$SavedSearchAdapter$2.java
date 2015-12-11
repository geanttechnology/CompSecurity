// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.view.View;

// Referenced classes of package com.ebay.mobile.search:
//            SavedSearchListActivity

class this._cls1
    implements android.view.Adapter._cls2
{

    final ClickCheckboxOrLongClick this$1;

    public void onClick(View view)
    {
        int i = ((Integer)view.getTag()).intValue();
        com.ebay.common.model.search.SavedSearch savedsearch = tItem(i);
        ClickCheckboxOrLongClick(view, savedsearch);
    }

    I()
    {
        this$1 = this._cls1.this;
        super();
    }
}
