// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package com.gotv.crackle.fragments:
//            BrowseMoviesFragment

class val.slot
    implements Runnable
{

    final BrowseMoviesFragment this$0;
    final ISlot val$slot;
    final ViewGroup val$vg;

    public void run()
    {
        try
        {
            ((ViewGroup)val$vg.getParent()).removeView(val$vg);
        }
        catch (Exception exception) { }
        BrowseMoviesFragment.access$700(BrowseMoviesFragment.this).setVisibility(0);
        BrowseMoviesFragment.access$700(BrowseMoviesFragment.this).addView(val$vg);
        BrowseMoviesFragment.access$700(BrowseMoviesFragment.this).requestLayout();
        val$slot.play();
    }

    ()
    {
        this$0 = final_browsemoviesfragment;
        val$vg = viewgroup;
        val$slot = ISlot.this;
        super();
    }
}
