// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.Filter;
import com.groupon.models.division.Division;
import com.groupon.util.CountryUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            Cities

private class items extends Filter
{

    private List items;
    final anged this$1;

    protected android.widget.ilter performFiltering(CharSequence charsequence)
    {
        charsequence = charsequence.toString().toLowerCase();
        android.widget.ilter ilter = new android.widget.ilter();
        ArrayList arraylist = new ArrayList(items);
        if (Strings.notEmpty(charsequence))
        {
            ListIterator listiterator = arraylist.listIterator();
            do
            {
                if (!listiterator.hasNext())
                {
                    break;
                }
                String s = ((Division)listiterator.next()).name;
                if (!Cities.access$1100(this._cls1.this.items).getDisplayName(s).toLowerCase().contains(charsequence))
                {
                    listiterator.remove();
                }
            } while (true);
        }
        ilter._fld1 = arraylist.size();
        ilter._fld1 = arraylist;
        return ilter;
    }

    protected void publishResults(CharSequence charsequence, android.widget.ilter ilter)
    {
        _mth1();
        for (charsequence = ((List)ilter.ilter).iterator(); charsequence.hasNext(); _mth1(ilter))
        {
            ilter = (Division)charsequence.next();
        }

        anged();
    }

    public (List list)
    {
        this$1 = this._cls1.this;
        super();
        items = list;
    }
}
