// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;
import com.offerup.android.dto.Item;

// Referenced classes of package com.offerup.android.activities:
//            MyArchivedOffersActivity

final class dg
    implements android.content.DialogInterface.OnClickListener
{

    private Item a;
    private MyArchivedOffersActivity b;

    dg(MyArchivedOffersActivity myarchivedoffersactivity, Item item)
    {
        b = myarchivedoffersactivity;
        a = item;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        MyArchivedOffersActivity.a(b, a);
    }
}
