// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;


// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            StickersPanel

class val.firstValidIndex
    implements Runnable
{

    final StickersPanel this$0;
    final int val$firstValidIndex;

    public void run()
    {
        if (val$firstValidIndex < 0)
        {
            StickersPanel.access$000(StickersPanel.this, val$firstValidIndex);
        }
    }

    ()
    {
        this$0 = final_stickerspanel;
        val$firstValidIndex = I.this;
        super();
    }
}
