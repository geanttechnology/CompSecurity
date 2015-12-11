// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.view.View;
import android.widget.AdapterView;
import com.comcast.cim.cmasl.utils.CommonUtils;

// Referenced classes of package com.comcast.cim.android.view.common:
//            FilterableProgramCollectionFragment

class this._cls0
    implements android.widget.CollectionFragment._cls3
{

    final FilterableProgramCollectionFragment this$0;

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = ((AdapterView) (CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i))));
        itemLongClicked(adapterview);
        return true;
    }

    ()
    {
        this$0 = FilterableProgramCollectionFragment.this;
        super();
    }
}
