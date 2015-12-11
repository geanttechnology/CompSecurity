// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.view.View;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementMenu, SpinnerHiderRelativeLayout, RefinementsListView, IRefinementsMenuListener

class this._cls0
    implements android.view.ner
{

    final RefinementMenu this$0;

    public void onClick(View view)
    {
        if (RefinementMenu.access$100(RefinementMenu.this) != null)
        {
            RefinementMenu.access$200(RefinementMenu.this).show();
            RefinementMenu.access$300(RefinementMenu.this).clearAll();
            RefinementMenu.access$100(RefinementMenu.this).OnClearAllClick();
        }
    }

    istener()
    {
        this$0 = RefinementMenu.this;
        super();
    }
}
