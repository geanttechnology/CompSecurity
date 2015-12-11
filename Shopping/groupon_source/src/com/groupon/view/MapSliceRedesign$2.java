// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.groupon.view:
//            MapSliceRedesign

class this._cls0
    implements android.view.r
{

    final MapSliceRedesign this$0;

    public void onClick(View view)
    {
        view = String.format("https://maps.google.com/maps?f=d&daddr=%s", new Object[] {
            Uri.encode(MapSliceRedesign.access$100(MapSliceRedesign.this))
        });
        MapSliceRedesign.access$200(MapSliceRedesign.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse(view)));
    }

    ()
    {
        this$0 = MapSliceRedesign.this;
        super();
    }
}
