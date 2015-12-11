// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.groupon.db.models.CouponCategory;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.view.list_view.CouponCategoryWrapper;
import com.groupon.view.CustomPlaceholderUrlImageView;
import com.groupon.view.Transformation.RoundedCropTransformation;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class CouponCategorySeeAllMapping extends Mapping
{

    private Context context;

    public CouponCategorySeeAllMapping()
    {
        super(com/groupon/v3/view/list_view/CouponCategoryWrapper);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (CouponCategoryWrapper)universallistadapter.getItem(i);
        Object obj = universallistadapter.getCouponCategory();
        CustomPlaceholderUrlImageView customplaceholderurlimageview = (CustomPlaceholderUrlImageView)viewholder.itemView.findViewById(0x7f100079);
        TextView textview = (TextView)viewholder.itemView.findViewById(0x7f10016b);
        String s = ((CouponCategory) (obj)).getImageUrl();
        android.graphics.drawable.Drawable drawable = context.getResources().getDrawable(0x7f020208);
        if (Strings.notEmpty(s))
        {
            customplaceholderurlimageview.setImageUrl((new StringBuilder()).append("https://").append(s).append("/v1/t200x200.png").toString(), new RoundedCropTransformation(), drawable, com.groupon.view.UrlImageView.ScaleImageType.CENTER_INSIDE);
        } else
        {
            customplaceholderurlimageview.setImageDrawable(drawable);
        }
        textview.setText(((CouponCategory) (obj)).getTitle());
        obj = (IViewCallback)getCallback(com/groupon/v3/adapter/callback/IViewCallback);
        if (obj != null)
        {
            ((IViewCallback) (obj)).onViewBound(i, universallistadapter);
        }
        viewholder.itemView.setTag(0x7f100001, universallistadapter);
    }

    public View createView(Context context1)
    {
        context = context1;
        return LayoutInflater.from(context1).inflate(0x7f030077, null);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context1, UniversalListAdapter universallistadapter)
    {
        return getHolderWithCallback(context1, universallistadapter);
    }
}
