// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.c;

import android.view.View;
import android.widget.Filter;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.cyberlink.you.c:
//            f, e

class g extends Filter
{

    l a;
    final f b;

    public g(f f1, l l1)
    {
        b = f1;
        super();
        a = l1;
    }

    private List a(String s)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = f.a(b).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Friend friend = (Friend)iterator.next();
            if (friend.b().toLowerCase(Locale.getDefault()).contains(s))
            {
                arraylist.add(friend);
            }
        } while (true);
        return arraylist;
    }

    private void a(List list, List list1)
    {
        list1.removeAll(list);
    }

    private List b(String s)
    {
        int i = 0;
        ArrayList arraylist = new ArrayList();
        List list;
        do
        {
            list = f.b(b).a(s, i, 20);
            arraylist.addAll(list);
            i++;
        } while (list.size() == 20);
        return arraylist;
    }

    protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
    {
        Object obj = charsequence.toString().toLowerCase(Locale.getDefault());
        charsequence = new android.widget.Filter.FilterResults();
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(a(((String) (obj))));
        if (!((String) (obj)).isEmpty() && ((String) (obj)).length() >= 2)
        {
            obj = b(((String) (obj)));
            a(arraylist, ((List) (obj)));
            arraylist.addAll(((java.util.Collection) (obj)));
        }
        charsequence.values = arraylist;
        charsequence.count = arraylist.size();
        return charsequence;
    }

    protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
    {
label0:
        {
            if (filterresults.values != null)
            {
                f.a(b, (ArrayList)filterresults.values);
                b.notifyDataSetChanged();
                if (f.c(b).size() <= 0)
                {
                    break label0;
                }
                e.h(b.a).setVisibility(8);
            }
            return;
        }
        e.h(b.a).setVisibility(0);
    }
}
