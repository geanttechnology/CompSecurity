// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;

// Referenced classes of package com.ebay.mobile.home.cards:
//            NotificationsViewHolder

private static class itemDetails
{

    public final TextView itemCounter;
    public final TextView itemDetails;
    public final RemoteImageView itemImage;
    public final TextView itemTitle;
    View rootView;

    public (View view)
    {
        rootView = view;
        itemCounter = (TextView)view.findViewById(0x7f100285);
        itemImage = (RemoteImageView)view.findViewById(0x7f100286);
        itemTitle = (TextView)view.findViewById(0x7f100287);
        itemDetails = (TextView)view.findViewById(0x7f100288);
    }
}
