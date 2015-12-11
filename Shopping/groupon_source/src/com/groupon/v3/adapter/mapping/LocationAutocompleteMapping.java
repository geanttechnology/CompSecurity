// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.groupon.models.Place;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.view.list_view.PoGLocationWrapper;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class LocationAutocompleteMapping extends Mapping
{

    protected LocationsAutocompleteServiceWrapper locationsAutocompleteServiceWrapper;

    public LocationAutocompleteMapping(LocationsAutocompleteServiceWrapper locationsautocompleteservicewrapper)
    {
        super(com/groupon/v3/view/list_view/PoGLocationWrapper);
        locationsAutocompleteServiceWrapper = locationsautocompleteservicewrapper;
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (PoGLocationWrapper)universallistadapter.getItem(i);
        Place place = ((PoGLocationWrapper) (universallistadapter)).place;
        TextView textview = (TextView)viewholder.itemView.findViewById(0x7f100316);
        TextView textview1 = (TextView)viewholder.itemView.findViewById(0x7f100204);
        if (place.label.equalsIgnoreCase(locationsAutocompleteServiceWrapper.CURRENT_LOCATION))
        {
            textview.setVisibility(0);
            textview1.setVisibility(8);
            textview.setText(locationsAutocompleteServiceWrapper.getLocationDisplayLabel(place));
        } else
        {
            textview.setVisibility(8);
            textview1.setVisibility(0);
            textview1.setText(locationsAutocompleteServiceWrapper.getLocationDisplayLabel(place));
        }
        viewholder.itemView.setTag(0x7f100001, universallistadapter);
        viewholder = (IViewCallback)getCallback(com/groupon/v3/adapter/callback/IViewCallback);
        if (viewholder != null)
        {
            viewholder.onViewBound(i, universallistadapter);
        }
    }

    public View createView(Context context)
    {
        return LayoutInflater.from(context).inflate(0x7f03010a, null);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, UniversalListAdapter universallistadapter)
    {
        return getHolderWithCallback(context, universallistadapter);
    }
}
