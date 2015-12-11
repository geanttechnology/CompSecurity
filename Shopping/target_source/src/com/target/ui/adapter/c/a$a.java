// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.c;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.target.ui.adapter.c:
//            a

private class Id
{

    public TextView couponDesc;
    public TextView couponExpires;
    public View root;
    final a this$0;

    public (View view)
    {
        this$0 = a.this;
        super();
        root = view;
        couponDesc = (TextView)view.findViewById(0x7f100394);
        couponExpires = (TextView)view.findViewById(0x7f100395);
    }
}
