// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.view:
//            MapSlice

class val.address
    implements android.view.kListener
{

    final MapSlice this$0;
    final String val$address;
    final boolean val$logGrouponNst;

    public void onClick(View view)
    {
        onAddressContainerClicked();
        if (val$logGrouponNst)
        {
            MapSlice.access$100(MapSlice.this).logClick("", "get_directions_click", "mygroupons", "");
        }
        view = String.format("https://maps.google.com/maps?f=d&daddr=%s", new Object[] {
            Uri.encode(val$address)
        });
        MapSlice.access$200(MapSlice.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse(view)));
    }

    sdk.Logger()
    {
        this$0 = final_mapslice;
        val$logGrouponNst = flag;
        val$address = String.this;
        super();
    }
}
