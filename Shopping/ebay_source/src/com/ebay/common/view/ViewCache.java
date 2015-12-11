// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;

public class ViewCache
{

    public final RemoteImageView image;
    public final ImageView imageItemShipped;
    public final ImageView imageLeaveFeedback;
    public final ImageView imageStampEnding;
    public final ImageView imageStampOutbid;
    public final ImageView imageStampPaid;
    public boolean isCurrencyConversionPending;
    public Object object;
    public final TextView rightColumnText1;
    public final TextView rightColumnText2;
    public final TextView rightColumnText3;
    public final TextView rightColumnText4;
    public final TextView rightColumnText5;
    public final View rootCellLayout;
    public final View rootView;
    public final TextView specialText;
    public final TextView text;

    public ViewCache(View view)
    {
        object = null;
        rootView = view;
        rootCellLayout = view.findViewById(0x7f10013a);
        image = (RemoteImageView)view.findViewById(0x7f10005b);
        text = (TextView)view.findViewById(0x1020014);
        rightColumnText1 = (TextView)view.findViewById(0x7f100135);
        rightColumnText2 = (TextView)view.findViewById(0x7f100137);
        rightColumnText3 = (TextView)view.findViewById(0x7f100139);
        rightColumnText4 = (TextView)view.findViewById(0x7f100138);
        rightColumnText5 = (TextView)view.findViewById(0x7f100136);
        specialText = (TextView)view.findViewById(0x7f100133);
        imageLeaveFeedback = (ImageView)view.findViewById(0x7f10036d);
        imageItemShipped = (ImageView)view.findViewById(0x7f1003c2);
        imageStampPaid = (ImageView)view.findViewById(0x7f1003bd);
        imageStampOutbid = (ImageView)view.findViewById(0x7f1003be);
        imageStampEnding = (ImageView)view.findViewById(0x7f1003bf);
    }
}
