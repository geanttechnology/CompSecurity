// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import com.offerup.android.dto.Item;

// Referenced classes of package com.offerup.android.activities:
//            ChatActivity, a

final class bm
    implements android.view.View.OnClickListener
{

    private Item a;
    private ChatActivity b;

    bm(ChatActivity chatactivity, Item item)
    {
        b = chatactivity;
        a = item;
        super();
    }

    public final void onClick(View view)
    {
        b.f.a(a, b.b());
    }
}
