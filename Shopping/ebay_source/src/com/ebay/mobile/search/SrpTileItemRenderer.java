// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.idealmodel.SrpListItemViewModel;
import com.ebay.common.view.RegularItemViewHolder;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.mobile.search:
//            SrpListItemRenderer

public class SrpTileItemRenderer extends SrpListItemRenderer
{

    public SrpTileItemRenderer(EbayContext ebaycontext, SearchParameters searchparameters)
    {
        super(ebaycontext, searchparameters);
    }

    public void setItem(RegularItemViewHolder regularitemviewholder, SrpListItemViewModel srplistitemviewmodel)
    {
        if (srplistitemviewmodel == null)
        {
            return;
        }
        Context context = regularitemviewholder.image.getContext();
        regularitemviewholder.image.setRemoteImageUrl(srplistitemviewmodel.imageUrl, srplistitemviewmodel.imageZoomGuid, srplistitemviewmodel.imageZoomMd5);
        com.ebay.nautilus.domain.data.ItemCurrency itemcurrency = setPrice(regularitemviewholder, srplistitemviewmodel);
        setUnitPrice(regularitemviewholder, srplistitemviewmodel, itemcurrency);
        TextView textview;
        int i;
        if (srplistitemviewmodel.eekRating != null)
        {
            regularitemviewholder.eekText.setText((new StringBuilder()).append(context.getString(0x7f070087)).append(" ").append(srplistitemviewmodel.eekRating).toString());
            regularitemviewholder.eekText.setVisibility(0);
        } else
        {
            regularitemviewholder.eekText.setVisibility(8);
        }
        if (srplistitemviewmodel.isClassified)
        {
            regularitemviewholder.classifiedLabel.setVisibility(0);
        } else
        {
            regularitemviewholder.classifiedLabel.setVisibility(8);
        }
        if (srplistitemviewmodel.isEbayPlus)
        {
            regularitemviewholder.ebayPlusBadge.setVisibility(0);
        } else
        {
            regularitemviewholder.ebayPlusBadge.setVisibility(8);
        }
        textview = regularitemviewholder.promotedLabel;
        if (srplistitemviewmodel.isPromoted)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
        if (srplistitemviewmodel.isBestOffer)
        {
            regularitemviewholder.oboLabel.setVisibility(0);
        } else
        {
            regularitemviewholder.oboLabel.setVisibility(8);
        }
        if (srplistitemviewmodel.isAbin)
        {
            regularitemviewholder.binLabel.setVisibility(0);
        } else
        {
            regularitemviewholder.binLabel.setVisibility(8);
        }
        if (srplistitemviewmodel.isMap)
        {
            regularitemviewholder.detailsLabel.setVisibility(0);
            regularitemviewholder.strikethroughText.setVisibility(8);
        } else
        {
            regularitemviewholder.detailsLabel.setVisibility(8);
            setStrikethroughPrice(regularitemviewholder, srplistitemviewmodel);
        }
        formatPrices(context, regularitemviewholder, srplistitemviewmodel, itemcurrency);
        markItemAsVisited(regularitemviewholder.rootView, srplistitemviewmodel.id);
    }
}
