// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.navigation.AppNavigator;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemGroup, GNODrawerItemHideable, GNODrawerItemSimple, GNODrawer

public class GNODrawerItemSBD extends GNODrawerItemGroup
{
    public static class Builder extends GNODrawerItemGroup.Builder
    {

        public volatile GNODrawerItemGroup build()
        {
            return build();
        }

        public volatile GNODrawerItemHideable build()
        {
            return build();
        }

        public GNODrawerItemSBD build()
        {
            return (GNODrawerItemSBD)super.build();
        }

        public volatile GNODrawerItemSimple build()
        {
            return build();
        }

        public Builder(Context context, String s)
        {
            super(new GNODrawerItemSBD(context, s));
        }
    }


    public GNODrawerItemSBD(Context context, String s)
    {
        super(context, s);
        mExpandableIconClickListener = new android.view.View.OnClickListener() {

            final GNODrawerItemSBD this$0;

            public void onClick(View view)
            {
                AppNavigator.navigate(AmazonActivity.getTopMostBaseActivity(), com.amazon.mShop.navigation.AppNavigator.Target.shop_by_department, null);
                AmazonActivity.getTopMostBaseActivity().getGNODrawer().close();
            }

            
            {
                this$0 = GNODrawerItemSBD.this;
                super();
            }
        };
    }

    public static Builder builder(Context context, String s)
    {
        return new Builder(context, s);
    }

    public View getView(View view, ViewGroup viewgroup)
    {
        view = super.getView(view, viewgroup);
        viewgroup = (ImageView)view.findViewById(com.amazon.mShop.android.lib.R.id.group_item_expandable_arrow);
        viewgroup.setImageResource(com.amazon.mShop.android.lib.R.drawable.action_bar_arrow_right);
        viewgroup.setOnClickListener(mExpandableIconClickListener);
        view.findViewById(com.amazon.mShop.android.lib.R.id.group_item_vertical_divider).setVisibility(8);
        return view;
    }
}
