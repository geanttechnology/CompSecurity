// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.b;

import com.target.ui.fragment.cardstream.CardStreamOnClickHandler;
import com.target.ui.fragment.cardstream.b;
import com.target.ui.fragment.cardstream.f.e;

// Referenced classes of package com.target.ui.fragment.cardstream.b:
//            b, a

public class f
    implements com.target.ui.fragment.cardstream.b.b
{

    private final boolean isDebugBuild;

    public f(boolean flag)
    {
        isDebugBuild = flag;
    }

    private e d()
    {
        return com.target.ui.fragment.cardstream.f.e.a(0x7f100010).a("Dev/test-only card.  Isn't it exciting?").a();
    }

    private e e()
    {
        return com.target.ui.fragment.cardstream.b.a.a(0x7f020057, 0x7f0900ea).a(a.sShowActionsListFirstActionOnly).b(0x7f100004).a("Say Hi").a(CardStreamOnClickHandler.a("Hello, cardified world!")).a();
    }

    public boolean a()
    {
        return isDebugBuild;
    }

    public com.google.a.a.e b()
    {
        return com.google.a.a.e.b(new b(0x7f030028, e(), d(), c()));
    }

    public com.target.ui.fragment.cardstream.e c()
    {
        return com.target.ui.fragment.cardstream.e.DEV_TEST_CARD;
    }
}
