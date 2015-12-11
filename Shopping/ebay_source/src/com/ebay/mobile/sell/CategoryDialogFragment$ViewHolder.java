// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.sell:
//            CategoryDialogFragment

public static class icon
{

    TextView categoryName;
    TextView categoryPath;
    ImageView checkbox;
    ImageView icon;

    public (View view)
    {
        categoryName = (TextView)view.findViewById(0x1020014);
        categoryPath = (TextView)view.findViewById(0x1020015);
        checkbox = (ImageView)view.findViewById(0x7f100623);
        icon = (ImageView)view.findViewById(0x7f100622);
    }
}
