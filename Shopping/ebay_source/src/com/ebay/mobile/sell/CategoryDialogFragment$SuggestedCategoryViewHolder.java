// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.sell:
//            CategoryDialogFragment

class title
{

    public final ImageView image;
    final CategoryDialogFragment this$0;
    public final TextView title;

    public (View view)
    {
        this$0 = CategoryDialogFragment.this;
        super();
        image = (ImageView)view.findViewById(0x7f10005b);
        title = (TextView)view.findViewById(0x1020014);
    }
}
