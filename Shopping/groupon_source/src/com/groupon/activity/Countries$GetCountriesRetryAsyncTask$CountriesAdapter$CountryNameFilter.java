// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.Filter;
import com.groupon.models.country.Country;
import com.groupon.util.CountryUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            Countries

class items extends Filter
{

    private List items;
    final ed this$2;

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
                String s = ((Country)listiterator.next()).shortName;
                if (!items(this._cls2.this.items).getDisplayName(s).toLowerCase().contains(charsequence))
                {
                    listiterator.remove();
                }
            } while (true);
        }
        ilter._fld2 = arraylist.size();
        ilter._fld2 = arraylist;
        return ilter;
    }

    protected void publishResults(CharSequence charsequence, android.widget.ilter ilter)
    {
        _mth2();
        _mth2((List)ilter.ilter);
        ed();
    }

    public (List list)
    {
        this$2 = this._cls2.this;
        super();
        items = list;
    }
}
