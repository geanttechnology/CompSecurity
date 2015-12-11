// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.view.View;
import com.ebay.mobile.Vehicle;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewCompatibilityActivity, ItemViewCompatibilityLeafActivity

class val.pos
    implements android.view.yActivity._cls2
{

    final ItemViewCompatibilityActivity this$0;
    final ArrayList val$matchingVehicles;
    final int val$pos;

    public void onClick(View view)
    {
        view = (Vehicle)val$matchingVehicles.get(val$pos);
        ItemViewCompatibilityLeafActivity.StartActivityForResult(ItemViewCompatibilityActivity.this, 2, viewData, view);
    }

    y()
    {
        this$0 = final_itemviewcompatibilityactivity;
        val$matchingVehicles = arraylist;
        val$pos = I.this;
        super();
    }
}
