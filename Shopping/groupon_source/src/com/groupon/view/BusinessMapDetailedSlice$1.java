// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.view.View;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.Business;
import java.util.List;

// Referenced classes of package com.groupon.view:
//            BusinessMapDetailedSlice

class val.closest
    implements android.view.e._cls1
{

    final BusinessMapDetailedSlice this$0;
    final Business val$business;
    final int val$closest;
    final List val$redemptionLocations;

    public void onClick(View view)
    {
        onMapViewClicked();
        Context context = getContext();
        IntentFactory intentfactory = intentFactory;
        List list = val$redemptionLocations;
        if (val$business.name == null)
        {
            view = "";
        } else
        {
            view = val$business.name;
        }
        context.startActivity(intentfactory.newShowOnMapIntent(list, view, val$closest));
    }

    ()
    {
        this$0 = final_businessmapdetailedslice;
        val$redemptionLocations = list;
        val$business = business1;
        val$closest = I.this;
        super();
    }
}
