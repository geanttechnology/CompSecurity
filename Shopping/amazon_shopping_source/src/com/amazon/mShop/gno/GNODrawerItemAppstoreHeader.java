// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemGroup, GNODrawer, GNOItemAdapter, GNODrawerItemHideable, 
//            GNODrawerItemSimple

public class GNODrawerItemAppstoreHeader extends GNODrawerItemGroup
{
    public static class Builder extends GNODrawerItemGroup.Builder
    {

        public GNODrawerItemAppstoreHeader build()
        {
            return (GNODrawerItemAppstoreHeader)super.build();
        }

        public volatile GNODrawerItemGroup build()
        {
            return build();
        }

        public volatile GNODrawerItemHideable build()
        {
            return build();
        }

        public volatile GNODrawerItemSimple build()
        {
            return build();
        }

        public Builder(Context context, String s)
        {
            super(new GNODrawerItemAppstoreHeader(context, s));
            super.withType(GNODrawerItem.Type.APPSTORE_HEADER);
        }
    }


    public GNODrawerItemAppstoreHeader(Context context, String s)
    {
        super(context, s);
    }

    public static Builder builder(Context context, String s)
    {
        return new Builder(context, s);
    }

    public View getView(View view, ViewGroup viewgroup)
    {
        view = super.getView(view, viewgroup);
        viewgroup = GNODrawer.getGNOItemAdapter().getCoinValue();
        TextView textview = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.drawer_item_coin_text);
        TextView textview1 = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.drawer_item_coin_number);
        if (!"DISABLED".equals(viewgroup))
        {
            textview1.setVisibility(0);
            textview.setVisibility(0);
            textview1.setText(viewgroup);
            byte byte0 = 2;
            if (viewgroup.equals("1"))
            {
                byte0 = 1;
            }
            textview.setText(mContext.getResources().getQuantityText(com.amazon.mShop.android.lib.R.plurals.gno_appstore_coin, byte0));
            return view;
        } else
        {
            textview1.setVisibility(8);
            textview.setVisibility(8);
            return view;
        }
    }
}
