// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.adapters;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bitstrips.outfitbuilder.OBCatalogDisplayable;
import com.bitstrips.outfitbuilder.models.OBBrand;
import com.bitstrips.outfitbuilder.models.OBCatalog;
import com.bitstrips.outfitbuilder.models.OBCatalogItem;
import com.bitstrips.outfitbuilder.models.OBOutfit;
import com.bitstrips.outfitbuilder.models.OBShowcaseItems;
import com.bitstrips.outfitbuilder.views.BrandHeaderView;
import com.bitstrips.outfitbuilder.views.ShowcaseView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class OBCatalogArrayAdapter extends android.support.v7.widget.RecyclerView.Adapter
{
    public static class AdapterItem
    {

        OBCatalogDisplayable data;
        int dataViewRepresentation;

        public int getSpanRepresentation(int i)
        {
            switch (dataViewRepresentation)
            {
            default:
                i = 0;
                // fall through

            case 1: // '\001'
            case 2: // '\002'
                return i;

            case 0: // '\0'
                return 1;
            }
        }

        public AdapterItem(int i, OBCatalogDisplayable obcatalogdisplayable)
        {
            dataViewRepresentation = i;
            data = obcatalogdisplayable;
        }
    }

    class BrandHeaderViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        BrandHeaderView brandHeaderView;
        final OBCatalogArrayAdapter this$0;

        public void setBrand(OBBrand obbrand)
        {
            brandHeaderView.setBrandData(obbrand);
        }

        public BrandHeaderViewHolder(View view)
        {
            this$0 = OBCatalogArrayAdapter.this;
            super(view);
            brandHeaderView = (BrandHeaderView)view.findViewById(com.bitstrips.outfitbuilder.R.id.brand_header_view);
        }
    }

    class OutfitItemViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
        implements android.view.View.OnClickListener
    {

        ImageView imageView;
        OBOutfit outfit;
        final OBCatalogArrayAdapter this$0;

        public void onClick(View view)
        {
            if (outfit != null)
            {
                onOutfitClicked(outfit);
            }
        }

        public void setOutfit(OBOutfit oboutfit)
        {
            outfit = oboutfit;
            Picasso.with(itemView.getContext()).load(oboutfit.getImageURL()).placeholder(outfitPlaceholder).fit().centerInside().into(imageView);
        }

        public OutfitItemViewHolder(View view)
        {
            this$0 = OBCatalogArrayAdapter.this;
            super(view);
            imageView = (ImageView)view.findViewById(com.bitstrips.outfitbuilder.R.id.outfit_image);
            view.setOnClickListener(this);
        }
    }

    class ShowcaseViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        final OBCatalogArrayAdapter this$0;

        public void setCarousel(List list)
        {
            ((ShowcaseView)itemView).setCatalog(list);
        }

        public ShowcaseViewHolder(View view)
        {
            this$0 = OBCatalogArrayAdapter.this;
            super(view);
        }
    }


    private static final int BRAND_HEADER_VIEW_TYPE = 1;
    private static final int OUTFIT_VIEW_TYPE = 0;
    private static final int SHOWCASE_VIEW_TYPE = 2;
    AppCompatActivity activity;
    List adapterObjects;
    int outfitPlaceholder;

    public OBCatalogArrayAdapter(AppCompatActivity appcompatactivity, OBCatalog obcatalog)
    {
        outfitPlaceholder = com.bitstrips.outfitbuilder.R.drawable.silhouette_male;
        activity = appcompatactivity;
        adapterObjects = formatObjectsForAdapter(obcatalog);
    }

    private List formatObjectsForAdapter(OBCatalog obcatalog)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new AdapterItem(2, obcatalog.getShowcase()));
        for (obcatalog = obcatalog.getItems().iterator(); obcatalog.hasNext();)
        {
            Object obj = (OBCatalogItem)obcatalog.next();
            arraylist.add(new AdapterItem(1, ((OBCatalogItem) (obj)).getBrand()));
            obj = ((OBCatalogItem) (obj)).getOutfits().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                arraylist.add(new AdapterItem(0, (OBOutfit)((Iterator) (obj)).next()));
            }
        }

        return arraylist;
    }

    public int getItemCount()
    {
        return adapterObjects.size();
    }

    public int getItemViewType(int i)
    {
        return ((AdapterItem)adapterObjects.get(i)).dataViewRepresentation;
    }

    public int getSpanSizeForItem(int i, int j)
    {
        return ((AdapterItem)adapterObjects.get(i)).getSpanRepresentation(j);
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        OBShowcaseItems obshowcaseitems;
        switch (getItemViewType(i))
        {
        default:
            return;

        case 0: // '\0'
            OBOutfit oboutfit = (OBOutfit)((AdapterItem)adapterObjects.get(i)).data;
            ((OutfitItemViewHolder)viewholder).setOutfit(oboutfit);
            return;

        case 1: // '\001'
            OBBrand obbrand = (OBBrand)((AdapterItem)adapterObjects.get(i)).data;
            ((BrandHeaderViewHolder)viewholder).setBrand(obbrand);
            return;

        case 2: // '\002'
            obshowcaseitems = (OBShowcaseItems)((AdapterItem)adapterObjects.get(i)).data;
            break;
        }
        ((ShowcaseViewHolder)viewholder).setCarousel(obshowcaseitems);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return new OutfitItemViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(com.bitstrips.outfitbuilder.R.layout.ob_catalog_image_item, null));

        case 1: // '\001'
            return new BrandHeaderViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(com.bitstrips.outfitbuilder.R.layout.ob_catalog_header_view, null));

        case 2: // '\002'
            return new ShowcaseViewHolder(new ShowcaseView(activity));
        }
    }

    public abstract void onOutfitClicked(OBOutfit oboutfit);

    public void setOutfitPlaceholder(int i)
    {
        outfitPlaceholder = i;
    }
}
