// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.livemixtapes:
//            LazyAdapterSearch

class val.obj
    implements android.view.
{

    final LazyAdapterSearch this$0;
    private final HashMap val$obj;
    private final int val$position;

    public void onClick(View view)
    {
        Log.d("Nithin", "Clicked");
        openNowPlaying((HashMap)data.get(val$position), val$position, val$obj);
    }

    ()
    {
        this$0 = final_lazyadaptersearch;
        val$position = i;
        val$obj = HashMap.this;
        super();
    }
}
