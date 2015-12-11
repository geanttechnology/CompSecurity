// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Activity;
import android.view.View;
import com.groupon.view.MapSlice;
import java.util.ArrayList;

// Referenced classes of package com.groupon.activity:
//            ConfirmVoucherHelper, IntentFactory

class val.mapSlice
    implements android.view.elper._cls2
{

    final ConfirmVoucherHelper this$0;
    final int val$closest;
    final ArrayList val$locations;
    final MapSlice val$mapSlice;
    final String val$merchantName;

    public void onClick(View view)
    {
        view = (MapSlice)view;
        if (view.isExpanded())
        {
            ConfirmVoucherHelper.access$200(ConfirmVoucherHelper.this).startActivity(ConfirmVoucherHelper.access$100(ConfirmVoucherHelper.this).newShowOnMapIntent(val$locations, val$merchantName, val$closest));
            return;
        }
        MapSlice mapslice = val$mapSlice;
        boolean flag;
        if (view == val$mapSlice)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mapslice.setExpanded(flag);
    }

    ()
    {
        this$0 = final_confirmvoucherhelper;
        val$locations = arraylist;
        val$merchantName = s;
        val$closest = i;
        val$mapSlice = MapSlice.this;
        super();
    }
}
