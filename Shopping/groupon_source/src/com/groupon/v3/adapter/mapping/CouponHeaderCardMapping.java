// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.view.holder.GrouponViewHolder;
import com.groupon.v3.view.list_view.CouponListItemType;
import com.groupon.view.widgetcards.LimitedListWidgetHeaderCard;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class CouponHeaderCardMapping extends Mapping
{

    public CouponHeaderCardMapping()
    {
        super(com/groupon/v3/view/list_view/CouponListItemType);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        String s1;
        CouponListItemType couponlistitemtype;
        Resources resources;
        boolean flag;
        resources = viewholder.itemView.getResources();
        couponlistitemtype = (CouponListItemType)universallistadapter.getItem(i);
        universallistadapter = "";
        s1 = "";
        flag = false;
        if (!couponlistitemtype.isType(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_LIST_HEADER_COUPONS)) goto _L2; else goto _L1
_L1:
        String s;
        universallistadapter = resources.getString(0x7f0800f7);
        flag = true;
        s = s1;
_L4:
        ((LimitedListWidgetHeaderCard)(LimitedListWidgetHeaderCard)viewholder.itemView).bind(couponlistitemtype, universallistadapter, s, (GrouponViewHolder)viewholder, flag);
        return;
_L2:
        if (couponlistitemtype.isType(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_LIST_HEADER_MERCHANTS))
        {
            universallistadapter = resources.getString(0x7f080108);
            flag = false;
            s = resources.getString(0x7f0800ed).toUpperCase();
        } else
        if (couponlistitemtype.isType(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_LIST_HEADER_CATEGORIES))
        {
            universallistadapter = resources.getString(0x7f080107);
            flag = false;
            s = s1;
        } else
        if (couponlistitemtype.isType(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_LIST_HEADER_NEARBY_STORES))
        {
            universallistadapter = resources.getString(0x7f0800f6);
            flag = true;
            s = s1;
        } else
        if (couponlistitemtype.isType(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_LiST_SEARCH_HEADER_MERCHANTS))
        {
            universallistadapter = resources.getString(0x7f080108);
            flag = true;
            s = s1;
        } else
        {
            s = s1;
            if (couponlistitemtype.isType(com.groupon.v3.view.list_view.CouponListItemType.ListItemType.COUPON_LiST_SEARCH_AUTO_COMPLETE_HEADER_MERCHANTS))
            {
                universallistadapter = resources.getString(0x7f0800e5);
                flag = true;
                s = s1;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View createView(Context context)
    {
        return new LimitedListWidgetHeaderCard(context);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, UniversalListAdapter universallistadapter)
    {
        return getHolderWithCallback(context, universallistadapter);
    }

    public boolean getSpanAllColumns()
    {
        return true;
    }
}
