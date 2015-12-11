// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.offerup.android.activities:
//            BuyActivity

final class ae
    implements android.content.DialogInterface.OnClickListener
{

    private BuyActivity a;

    ae(BuyActivity buyactivity)
    {
        a = buyactivity;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        dialoginterface = new Intent();
        a.setResult(0, dialoginterface);
        a.finish();
    }
}
