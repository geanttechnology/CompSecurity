// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mybby;

import android.view.View;

// Referenced classes of package com.bestbuy.android.activities.mybby:
//            MyBBYDetailedReceipt

class a
    implements android.view..MyBBYDetailedReceipt._cls2
{

    final String a;
    final MyBBYDetailedReceipt b;

    public void onClick(View view)
    {
        MyBBYDetailedReceipt.a(b, view.getContext(), a);
    }

    A(MyBBYDetailedReceipt mybbydetailedreceipt, String s)
    {
        b = mybbydetailedreceipt;
        a = s;
        super();
    }
}
