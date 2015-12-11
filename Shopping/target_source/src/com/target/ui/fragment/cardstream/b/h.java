// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.b;

import com.target.b.a;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.ui.fragment.cardstream.CardStreamOnClickHandler;
import com.target.ui.fragment.cardstream.b;
import com.target.ui.fragment.cardstream.f.e;

// Referenced classes of package com.target.ui.fragment.cardstream.b:
//            b, a

public class h
    implements com.target.ui.fragment.cardstream.b.b
{

    private final e mChrome = d();
    private final a mGuestProvider;
    private final a mStoreSummaryProvider;

    public h(a a1, a a2)
    {
        mGuestProvider = a1;
        mStoreSummaryProvider = a2;
    }

    private e d()
    {
        return com.target.ui.fragment.cardstream.b.a.a(0x7f020059).a(a.sShowActionsListFirstActionOnly).b(0x7f100004).a("request help").a(CardStreamOnClickHandler.b()).a();
    }

    private e e()
    {
        return com.target.ui.fragment.cardstream.f.e.a(0x7f100010).c(0x7f0900e3).a();
    }

    public boolean a()
    {
        com.google.a.a.e e1 = (com.google.a.a.e)mGuestProvider.b();
        com.google.a.a.e e2 = (com.google.a.a.e)mStoreSummaryProvider.b();
        return e1.b() && !((Guest)e1.c()).isAnonymous() && e2.b() && ((RelevantStoreSummary)e2.c()).hasRequestATeamMember() && ((RelevantStoreSummary)e2.c()).a();
    }

    public com.google.a.a.e b()
    {
        return com.google.a.a.e.b(new b(0x7f030028, mChrome, e(), c()));
    }

    public com.target.ui.fragment.cardstream.e c()
    {
        return com.target.ui.fragment.cardstream.e.REQUEST_A_TEAM_MEMBER;
    }
}
