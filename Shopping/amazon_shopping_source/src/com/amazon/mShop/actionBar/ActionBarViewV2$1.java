// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.actionBar;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.fastBrowse.FastBrowseActivity;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.net.RefMarkerObserver;

// Referenced classes of package com.amazon.mShop.actionBar:
//            ActionBarViewV2

class this._cls0
    implements android.view.er
{

    final ActionBarViewV2 this$0;

    public void onClick(View view)
    {
        if (ActionBarViewV2.access$100(ActionBarViewV2.this) instanceof FastBrowseActivity)
        {
            ActionBarViewV2.access$100(ActionBarViewV2.this).getGNODrawer().unlock();
        }
        ActionBarViewV2.access$100(ActionBarViewV2.this).getGNODrawer().toggle();
        RefMarkerObserver.logRefMarker("gno_buger");
    }

    y()
    {
        this$0 = ActionBarViewV2.this;
        super();
    }
}
