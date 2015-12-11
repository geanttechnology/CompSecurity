// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;

// Referenced classes of package com.groupon.view:
//            MapSliceRedesign

class val.listener
    implements android.view.r
{

    final MapSliceRedesign this$0;
    final android.view.r val$listener;

    public void onClick(View view)
    {
        if (val$listener != null)
        {
            val$listener.onClick(MapSliceRedesign.this);
        }
    }

    ()
    {
        this$0 = final_mapsliceredesign;
        val$listener = android.view.r.this;
        super();
    }
}
