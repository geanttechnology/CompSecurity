// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.inventory;

import android.content.Context;
import android.location.Address;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import com.ebay.nautilus.kernel.util.DelimitedStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.inventory:
//            StorePickerActivity

private class this._cls0 extends ArrayAdapter
{

    private ArrayList resultList;
    final StorePickerActivity this$0;

    private ArrayList getMatchingLocations(String s)
    {
        ArrayList arraylist = new ArrayList();
        try
        {
            StorePickerActivity.access$902(StorePickerActivity.this, StorePickerActivity.access$1000(StorePickerActivity.this, s));
        }
        catch (Exception exception) { }
        if (StorePickerActivity.access$900(StorePickerActivity.this) != null)
        {
            DelimitedStringBuilder delimitedstringbuilder;
            for (Iterator iterator = StorePickerActivity.access$900(StorePickerActivity.this).iterator(); iterator.hasNext(); arraylist.add(delimitedstringbuilder.toString()))
            {
                Address address = (Address)iterator.next();
                if (StorePickerActivity.debugLogger._fld0)
                {
                    StorePickerActivity.debugLogger._mth0(address.toString());
                }
                delimitedstringbuilder = new DelimitedStringBuilder(", ");
                if (!s.equals(address.getAddressLine(0)))
                {
                    int j = address.getMaxAddressLineIndex();
                    for (int i = 0; i <= j; i++)
                    {
                        delimitedstringbuilder.append(address.getAddressLine(i));
                    }

                    continue;
                }
                if (!s.equals(address.getFeatureName()))
                {
                    delimitedstringbuilder.append(address.getFeatureName());
                }
                if (address.getLocality() != null)
                {
                    delimitedstringbuilder.append(address.getLocality());
                }
                if (address.getAdminArea() != null)
                {
                    delimitedstringbuilder.append(address.getAdminArea());
                }
                if (address.getCountryName() != null)
                {
                    delimitedstringbuilder.append(address.getCountryName());
                }
                if (address.getPostalCode() != null)
                {
                    delimitedstringbuilder.append(address.getPostalCode());
                }
            }

        }
        return arraylist;
    }

    public int getCount()
    {
        int i = 0;
        if (resultList != null)
        {
            i = resultList.size();
        }
        return i;
    }

    public Filter getFilter()
    {
        return new Filter() {

            final StorePickerActivity.LocationAutoCompleteAdapter this$1;

            protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
            {
                android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
                if (charsequence != null)
                {
                    resultList = getMatchingLocations(charsequence.toString());
                    filterresults.values = resultList;
                    filterresults.count = resultList.size();
                }
                return filterresults;
            }

            protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
            {
                if (filterresults != null && filterresults.count > 0)
                {
                    notifyDataSetChanged();
                    return;
                } else
                {
                    notifyDataSetInvalidated();
                    return;
                }
            }

            
            {
                this$1 = StorePickerActivity.LocationAutoCompleteAdapter.this;
                super();
            }
        };
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public String getItem(int i)
    {
        String s1 = "";
        String s = s1;
        if (resultList != null)
        {
            s = s1;
            if (resultList.size() > i)
            {
                s = (String)resultList.get(i);
            }
        }
        return s;
    }



/*
    static ArrayList access$702(_cls1 _pcls1, ArrayList arraylist)
    {
        _pcls1.resultList = arraylist;
        return arraylist;
    }

*/


    public _cls1.this._cls1(Context context, int i)
    {
        this$0 = StorePickerActivity.this;
        super(context, i);
    }
}
