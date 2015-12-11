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
//            ABTestListAdapter

protected class items extends Filter
{

    private List items;
    final ABTestListAdapter this$0;

    protected android.widget.lter performFiltering(CharSequence charsequence)
    {
        charsequence = charsequence.toString().toLowerCase();
        android.widget.lter lter = new android.widget.lter();
        ArrayList arraylist = new ArrayList();
        if (Strings.notEmpty(charsequence))
        {
            Iterator iterator = items.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if (s.toLowerCase().contains(charsequence))
                {
                    arraylist.add(s);
                }
            } while (true);
            lter.items = arraylist.size();
            lter.items = arraylist;
            return lter;
        } else
        {
            lter.items = items.size();
            lter.items = items;
            return lter;
        }
    }

    protected void publishResults(CharSequence charsequence, android.widget.lter lter)
    {
        clear();
        addAll((List)lter.lter);
        notifyDataSetChanged();
    }

    public (List list)
    {
        this$0 = ABTestListAdapter.this;
        super();
        items = list;
    }
}
