// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;

// Referenced classes of package com.ebay.mobile.home.cards:
//            WatchingViewHolder

public static class placeholder extends ViewHolder
{

    public final RemoteImageView image;
    public final View placeholder;
    public final TextView price;
    public final TextView signal;
    public final TextView title;

    public (View view)
    {
        super(view);
        title = (TextView)view.findViewById(0x7f1002de);
        image = (RemoteImageView)view.findViewById(0x7f1002dc);
        price = (TextView)view.findViewById(0x7f1002dd);
        signal = (TextView)view.findViewById(0x7f1002df);
        placeholder = view.findViewById(0x7f1002e0);
    }
}
