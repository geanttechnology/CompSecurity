// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.poshmark.ui.fragments:
//            MetaItemListViewFragment

class this._cls0
    implements android.view.ewFragment._cls1
{

    final MetaItemListViewFragment this$0;

    public void onClick(View view)
    {
        if (!multiSelectList.isEmpty())
        {
            returnData();
        }
    }

    ()
    {
        this$0 = MetaItemListViewFragment.this;
        super();
    }
}
