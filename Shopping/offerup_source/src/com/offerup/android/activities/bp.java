// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import com.offerup.android.dto.BuyRequest;
import com.offerup.android.dto.Item;

// Referenced classes of package com.offerup.android.activities:
//            ChatActivity, a

final class bp
    implements android.view.View.OnClickListener
{

    private Item a;
    private BuyRequest b;
    private ChatActivity c;

    bp(ChatActivity chatactivity, Item item, BuyRequest buyrequest)
    {
        c = chatactivity;
        a = item;
        b = buyrequest;
        super();
    }

    public final void onClick(View view)
    {
        c.f.a(a, b);
    }
}
