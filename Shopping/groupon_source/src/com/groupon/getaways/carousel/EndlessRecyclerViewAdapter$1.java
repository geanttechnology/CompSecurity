// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;


// Referenced classes of package com.groupon.getaways.carousel:
//            EndlessRecyclerViewAdapter

class val.visible
    implements Runnable
{

    final EndlessRecyclerViewAdapter this$0;
    final boolean val$visible;

    public void run()
    {
        if (EndlessRecyclerViewAdapter.access$100(EndlessRecyclerViewAdapter.this) == val$visible)
        {
            return;
        }
        EndlessRecyclerViewAdapter.access$102(EndlessRecyclerViewAdapter.this, val$visible);
        if (val$visible)
        {
            notifyItemInserted(EndlessRecyclerViewAdapter.access$200(EndlessRecyclerViewAdapter.this).ount() + 1);
            return;
        } else
        {
            notifyItemRemoved(EndlessRecyclerViewAdapter.access$200(EndlessRecyclerViewAdapter.this).ount() + 1);
            return;
        }
    }

    ()
    {
        this$0 = final_endlessrecyclerviewadapter;
        val$visible = Z.this;
        super();
    }
}
