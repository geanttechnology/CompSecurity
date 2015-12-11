// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sellsmartbox;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.sellsmartbox:
//            SmartboxResultsAdapter

public static final class categoryTitle
{

    public final View categoryTitle;
    public final View change;
    public final ImageView image;
    public final TextView subtext;
    public final TextView text;

    public (View view)
    {
        image = (ImageView)view.findViewById(0x7f10005e);
        text = (TextView)view.findViewById(0x7f100135);
        subtext = (TextView)view.findViewById(0x7f100137);
        change = view.findViewById(0x7f100711);
        categoryTitle = view.findViewById(0x7f100710);
    }
}
