// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mybby;

import android.content.DialogInterface;

// Referenced classes of package com.bestbuy.android.activities.mybby:
//            MyBBYDetailedReceipt

class a
    implements android.content.Listener
{

    final MyBBYDetailedReceipt a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
    }

    A(MyBBYDetailedReceipt mybbydetailedreceipt)
    {
        a = mybbydetailedreceipt;
        super();
    }
}
