// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;
import com.offerup.android.dto.Item;

// Referenced classes of package com.offerup.android.activities:
//            MyOffersActivity

final class du
    implements android.content.DialogInterface.OnClickListener
{

    private Item a;
    private MyOffersActivity b;

    du(MyOffersActivity myoffersactivity, Item item)
    {
        b = myoffersactivity;
        a = item;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        MyOffersActivity.a(b, a);
    }
}
