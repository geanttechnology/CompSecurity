// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.view.View;
import com.groupon.models.Place;

// Referenced classes of package com.groupon.adapter:
//            BaseGlobalSearchLocationIndexerAdapter

class val.suggestion
    implements android.view.pter._cls1
{

    final BaseGlobalSearchLocationIndexerAdapter this$0;
    final Place val$suggestion;

    public void onClick(View view)
    {
        onLocationClick(val$suggestion);
    }

    ()
    {
        this$0 = final_baseglobalsearchlocationindexeradapter;
        val$suggestion = Place.this;
        super();
    }
}
