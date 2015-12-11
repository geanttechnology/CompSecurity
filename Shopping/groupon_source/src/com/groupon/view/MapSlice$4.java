// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;

// Referenced classes of package com.groupon.view:
//            MapSlice

class tener
    implements android.view.kListener
{

    final MapSlice this$0;
    final android.view.kListener val$listener;

    public void onClick(View view)
    {
        onMapViewClicked();
        if (val$listener != null)
        {
            val$listener.onClick(MapSlice.this);
        }
    }

    tener()
    {
        this$0 = final_mapslice;
        val$listener = android.view.kListener.this;
        super();
    }
}
