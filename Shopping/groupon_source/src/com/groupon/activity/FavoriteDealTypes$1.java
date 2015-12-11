// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.AdapterView;
import com.groupon.view.FavoriteDealTypeItem;

// Referenced classes of package com.groupon.activity:
//            FavoriteDealTypes

class this._cls0
    implements android.widget.ickListener
{

    final FavoriteDealTypes this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (view instanceof FavoriteDealTypeItem)
        {
            ((FavoriteDealTypeItem)view).toggleStateWithApiCall(null);
        }
    }

    tener()
    {
        this$0 = FavoriteDealTypes.this;
        super();
    }
}
