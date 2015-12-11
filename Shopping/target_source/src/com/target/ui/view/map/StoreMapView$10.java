// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.view.View;

// Referenced classes of package com.target.ui.view.map:
//            StoreMapView, ZoneSelectionView

class this._cls0
    implements android.view.ener
{

    final StoreMapView this$0;

    public void onClick(View view)
    {
        if (StoreMapView.g(StoreMapView.this) != null)
        {
            StoreMapView.g(StoreMapView.this).oneSelector.a();
        }
    }

    w()
    {
        this$0 = StoreMapView.this;
        super();
    }
}
