// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import android.view.View;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayCollectionViewAdapter, ThisDayViewRouter

class val.position
    implements android.view.ctionViewAdapter._cls2
{

    final ThisDayCollectionViewAdapter this$0;
    final int val$position;
    final int val$year;

    public void onClick(View view)
    {
        ThisDayCollectionViewAdapter.access$000(ThisDayCollectionViewAdapter.this).onPhotoClicked(val$year, val$position);
    }

    ()
    {
        this$0 = final_thisdaycollectionviewadapter;
        val$year = i;
        val$position = I.this;
        super();
    }
}
