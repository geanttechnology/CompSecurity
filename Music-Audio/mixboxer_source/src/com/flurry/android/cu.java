// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.util.Set;

// Referenced classes of package com.flurry.android:
//            FlurryDataSenderHandler, cy, ce, FlurryDataSenderIndex

final class cu
    implements FlurryDataSenderHandler
{

    private ce eQ;

    cu(ce ce1)
    {
        eQ = ce1;
        super();
    }

    public final void onResponse(int i, String s, String s1)
    {
        cy.d("FlurryDataSender", (new StringBuilder()).append("--onReport ").append(s1).append(" sent. HTTP response: ").append(i).append(" : ").append(s).toString());
        s = eQ.au();
        if (!eQ.em.removeBlockInfoWithIdentifier(s1, s))
        {
            cy.d("FlurryDataSender", (new StringBuilder()).append("Internal error. Block wasn't deleted with id = ").append(s1).toString());
        }
        if (!eQ.ep.remove(s1))
        {
            cy.d("FlurryDataSender", (new StringBuilder()).append("Internal error. Block with id = ").append(s1).append(" was not in progress state").toString());
        }
        ce.a(eQ);
    }

    public final void onServerError(String s)
    {
        cy.d("FlurryDataSender", (new StringBuilder()).append("--onServerError ").append(s).toString());
        if (!eQ.ep.remove(s))
        {
            cy.d("FlurryDataSender", (new StringBuilder()).append("Internal error. Block with id = ").append(s).append(" was not in progress state").toString());
        }
    }
}
