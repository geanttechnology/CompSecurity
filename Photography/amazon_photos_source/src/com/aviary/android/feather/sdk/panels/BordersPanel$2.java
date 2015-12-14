// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;


// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            BordersPanel

class val.firstValidIndex
    implements Runnable
{

    final BordersPanel this$0;
    final int val$firstValidIndex;

    public void run()
    {
        if (val$firstValidIndex < 0)
        {
            BordersPanel.access$000(BordersPanel.this, val$firstValidIndex);
        }
    }

    ()
    {
        this$0 = final_borderspanel;
        val$firstValidIndex = I.this;
        super();
    }
}
