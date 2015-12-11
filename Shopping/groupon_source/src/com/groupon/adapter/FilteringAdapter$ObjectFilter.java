// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.widget.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.adapter:
//            FilteringAdapter

protected class items extends Filter
{

    private List items;
    final FilteringAdapter this$0;

    protected android.widget.lter performFiltering(CharSequence charsequence)
    {
        charsequence = charsequence.toString().toLowerCase();
        android.widget.lter lter = new android.widget.lter();
        ArrayList arraylist = new ArrayList(items);
        if (Strings.notEmpty(charsequence))
        {
            for (int i = arraylist.size() - 1; i >= 0; i--)
            {
                if (getStringRepresentation(arraylist.get(i)).toLowerCase().contains(charsequence))
                {
                    arraylist.remove(i);
                }
            }

        }
        lter.gRepresentation = arraylist.size();
        lter.gRepresentation = arraylist;
        return lter;
    }

    protected void publishResults(CharSequence charsequence, android.widget.lter lter)
    {
        clear();
        for (charsequence = ((List)lter.lter).iterator(); charsequence.hasNext(); add(lter))
        {
            lter = ((android.widget.lter) (charsequence.next()));
        }

        notifyDataSetChanged();
    }

    public (List list)
    {
        this$0 = FilteringAdapter.this;
        super();
        items = list;
    }
}
