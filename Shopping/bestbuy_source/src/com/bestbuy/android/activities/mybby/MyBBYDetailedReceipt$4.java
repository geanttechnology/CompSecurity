// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mybby;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.bestbuy.android.activities.mybby:
//            MyBBYDetailedReceipt

class b
    implements android.content.Listener
{

    final String a;
    final Context b;
    final MyBBYDetailedReceipt c;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse((new StringBuilder()).append("tel:").append(a).toString()));
        b.startActivity(intent);
        dialoginterface.cancel();
    }

    A(MyBBYDetailedReceipt mybbydetailedreceipt, String s, Context context)
    {
        c = mybbydetailedreceipt;
        a = s;
        b = context;
        super();
    }
}
