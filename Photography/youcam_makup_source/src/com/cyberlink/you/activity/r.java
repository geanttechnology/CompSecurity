// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import android.widget.Filter;
import com.cyberlink.you.friends.Friend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.cyberlink.you.activity:
//            q, SelectUsersActivity

class r extends Filter
{

    final q a;

    private r(q q1)
    {
        a = q1;
        super();
    }

    r(q q1, SelectUsersActivity._cls1 _pcls1)
    {
        this(q1);
    }

    protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
    {
        charsequence = charsequence.toString().toLowerCase(Locale.getDefault());
        android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
        ArrayList arraylist = new ArrayList();
        Iterator iterator = q.a(a).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Friend friend = (Friend)iterator.next();
            if (friend.b().toLowerCase(Locale.getDefault()).contains(charsequence))
            {
                arraylist.add(friend);
            }
        } while (true);
        filterresults.values = arraylist;
        filterresults.count = arraylist.size();
        return filterresults;
    }

    protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
    {
        q.a(a, (ArrayList)filterresults.values);
        a.notifyDataSetChanged();
        if (q.b(a).size() > 0)
        {
            SelectUsersActivity.b(a.a).setVisibility(8);
            return;
        } else
        {
            SelectUsersActivity.b(a.a).setVisibility(0);
            return;
        }
    }
}
