// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import com.mixerbox.mixerbox3b.adapters.SortAdapter;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mobeta.android.dslv.i;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SortFragment

class this._cls0
    implements i
{

    final SortFragment this$0;

    public void drop(int j, int k)
    {
        if (j != k)
        {
            SongItem songitem = (SongItem)array.get(j);
            array.remove(j);
            array.add(k, songitem);
            adapter.notifyDataSetChanged();
        }
    }

    ()
    {
        this$0 = SortFragment.this;
        super();
    }
}
