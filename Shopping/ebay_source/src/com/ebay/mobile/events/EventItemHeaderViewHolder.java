// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;

public class EventItemHeaderViewHolder extends com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.HeaderViewHolder
{

    private final String bannerImageUrl;
    private final String endsInText;
    private final TextView endsInTextView;
    private final TextView headerRefineButton;
    private final RemoteImageView image;
    private final TextView refineButton;
    private final TextView shareButton;
    private final TextView subTitle;

    public EventItemHeaderViewHolder(View view, EventItemsAdapter.EventHeaderInfo eventheaderinfo, android.view.View.OnClickListener onclicklistener)
    {
        super(view);
        image = (RemoteImageView)view.findViewById(0x7f10005b);
        subTitle = (TextView)view.findViewById(0x1020015);
        refineButton = (TextView)view.findViewById(0x7f100198);
        headerRefineButton = (TextView)view.findViewById(0x7f1000e8);
        shareButton = (TextView)view.findViewById(0x7f10012e);
        endsInTextView = (TextView)view.findViewById(0x7f100197);
        refineButton.setOnClickListener(onclicklistener);
        headerRefineButton.setOnClickListener(onclicklistener);
        shareButton.setOnClickListener(onclicklistener);
        subTitle.setVisibility(8);
        bannerImageUrl = eventheaderinfo.eventBannerImageUrl;
        endsInText = eventheaderinfo.endsInText;
        if (eventheaderinfo.shareUrl == null)
        {
            shareButton.setEnabled(false);
        }
    }

    protected void onBindView(int i, CharSequence charsequence)
    {
        super.onBindView(i, charsequence);
        image.setRemoteImageUrl(bannerImageUrl);
        endsInTextView.setText(endsInText);
        if (!TextUtils.isEmpty(bannerImageUrl))
        {
            image.setVisibility(0);
            return;
        } else
        {
            image.setVisibility(8);
            return;
        }
    }
}
