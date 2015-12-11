// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.d;

import com.target.mothership.common.tender.a;

// Referenced classes of package com.target.ui.adapter.d:
//            a

private class cardType
    implements com.target.ui.view.account.entCardView.b
{

    private String addressLine;
    private a cardType;
    private String last4Digits;
    final com.target.ui.adapter.d.a this$0;

    public String a()
    {
        return last4Digits;
    }

    public String b()
    {
        return addressLine;
    }

    public a c()
    {
        return cardType;
    }

    .tender.a(String s, String s1, a a2)
    {
        this$0 = com.target.ui.adapter.d.a.this;
        super();
        last4Digits = s;
        addressLine = s1;
        cardType = a2;
    }
}
