// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.bitstrips.outfitbuilder.models.OBOutfit;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;

public class OBCatalogItemOutfitsArrayAdapter extends ArrayAdapter
{

    public OBCatalogItemOutfitsArrayAdapter(Context context, List list)
    {
        super(context, 0, list);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        OBOutfit oboutfit = (OBOutfit)getItem(i);
        viewgroup = view;
        if (view == null)
        {
            viewgroup = new ImageView(getContext());
        }
        Picasso.with(getContext()).load(oboutfit.getImageURL()).into((ImageView)viewgroup);
        return viewgroup;
    }
}
