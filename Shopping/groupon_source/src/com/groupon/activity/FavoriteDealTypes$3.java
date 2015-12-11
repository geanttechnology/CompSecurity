// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.ArrayAdapter;
import com.groupon.util.Function1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.groupon.activity:
//            FavoriteDealTypes

class val.adapter
    implements Function1
{

    final FavoriteDealTypes this$0;
    final ArrayAdapter val$adapter;
    final List val$allIds;
    final List val$names;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((HashMap)obj);
    }

    public void execute(HashMap hashmap)
    {
        val$allIds.clear();
        val$names.clear();
        String s;
        for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); val$names.add(hashmap.get(s)))
        {
            s = (String)iterator.next();
            val$allIds.add(s);
        }

        val$adapter.notifyDataSetChanged();
    }

    ()
    {
        this$0 = final_favoritedealtypes;
        val$allIds = list;
        val$names = list1;
        val$adapter = ArrayAdapter.this;
        super();
    }
}
