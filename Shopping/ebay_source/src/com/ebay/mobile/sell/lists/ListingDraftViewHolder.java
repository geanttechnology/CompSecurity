// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            SellListBaseViewHolder, ListingDraftListItem

public class ListingDraftViewHolder extends SellListBaseViewHolder
{

    public ImageView checkbox;
    private final java.text.DateFormat dateFormat;
    public TextView edited;
    public TextView editedDate;
    public RemoteImageView image;

    public ListingDraftViewHolder(View view, SellListBaseViewHolder.OnViewHolderClickListener onviewholderclicklistener)
    {
        super(view, onviewholderclicklistener);
        Context context = view.getContext();
        boolean flag = context.getResources().getBoolean(0x7f0b0006);
        listener = onviewholderclicklistener;
        view.setOnClickListener(this);
        image = (RemoteImageView)view.findViewById(0x7f10005b);
        textView.setLines(2);
        textView2.setVisibility(8);
        if (flag)
        {
            textView.setTextAppearance(context, 0x7f0a013f);
            edited = (TextView)view.findViewById(0x7f100128);
            edited.setTextAppearance(context, 0x7f0a013e);
            editedDate = (TextView)view.findViewById(0x7f100728);
        } else
        {
            textView.setTextAppearance(context, 0x7f0a013e);
            edited = (TextView)view.findViewById(0x7f100729);
            editedDate = (TextView)view.findViewById(0x7f10072a);
        }
        edited.setText(0x7f0703a5);
        dateFormat = DateFormat.getMediumDateFormat(context);
    }

    protected void onBindView(int i, Object obj)
    {
        if (obj instanceof ListingDraftListItem)
        {
            obj = (ListingDraftListItem)obj;
            editedDate.setVisibility(4);
            edited.setVisibility(4);
            if (!TextUtils.isEmpty(((ListingDraftListItem) (obj)).title))
            {
                textView.setText(((ListingDraftListItem) (obj)).title);
            } else
            {
                textView.setText(0x7f070b92);
            }
            image.setRemoteImageUrl(((ListingDraftListItem) (obj)).imageUrl);
            if (((ListingDraftListItem) (obj)).date != null)
            {
                editedDate.setText(dateFormat.format(((ListingDraftListItem) (obj)).date));
                editedDate.setVisibility(0);
                edited.setVisibility(0);
                return;
            }
        }
    }
}
