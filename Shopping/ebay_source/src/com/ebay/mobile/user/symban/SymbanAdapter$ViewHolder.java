// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.user.symban:
//            SymbanAdapter

private class body
{

    final TextView body;
    final ImageView image;
    final View row;
    final SymbanAdapter this$0;
    final TextView title;

    (View view)
    {
        this$0 = SymbanAdapter.this;
        super();
        row = view.findViewById(0x7f100827);
        image = (ImageView)view.findViewById(0x7f10005b);
        title = (TextView)view.findViewById(0x7f10005f);
        body = (TextView)view.findViewById(0x7f1000f8);
    }
}
