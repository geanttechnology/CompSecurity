// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.application;

import com.leanplum.callbacks.VariablesChangedCallback;

// Referenced classes of package com.offerup.android.application:
//            OfferUpApplication

final class b extends VariablesChangedCallback
{

    private OfferUpApplication a;

    b(OfferUpApplication offerupapplication)
    {
        a = offerupapplication;
        super();
    }

    public final void variablesChanged()
    {
        OfferUpApplication.a(a);
    }
}
