// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;

// Referenced classes of package com.livemixtapes:
//            Mixtape

class val.pos
    implements Runnable
{

    final Mixtape this$0;
    private final int val$pos;

    public void run()
    {
        View view;
        if (val$pos >= Mixtape.access$32(Mixtape.this).getFirstVisiblePosition())
        {
            if ((view = Mixtape.access$32(Mixtape.this).getChildAt(val$pos - Mixtape.access$32(Mixtape.this).getFirstVisiblePosition())) != null)
            {
                ((ProgressBar)view.findViewById(0x7f080138)).setVisibility(4);
                ((ImageButton)view.findViewById(0x7f0800df)).setVisibility(4);
                return;
            }
        }
    }

    ()
    {
        this$0 = final_mixtape;
        val$pos = I.this;
        super();
    }
}
