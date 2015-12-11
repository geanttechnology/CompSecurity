// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.a;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.target.ui.adapter.a:
//            a

private class Id
{

    public TextView giftCardAccessNumber;
    public TextView giftCardBalance;
    public TextView giftCardNumber;
    public int position;
    final a this$0;

    public (View view)
    {
        this$0 = a.this;
        super();
        position = -1;
        giftCardNumber = (TextView)view.findViewById(0x7f1002c3);
        giftCardAccessNumber = (TextView)view.findViewById(0x7f1002c4);
        giftCardBalance = (TextView)view.findViewById(0x7f1002c5);
    }
}
