// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.am;

import com.google.api.services.now.model.Card;
import com.google.api.services.now.model.CardContexts;
import com.shazam.android.testmode.e;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.shazam.android.am:
//            k, g, f, e

public final class c
    implements k
{

    private final g a;
    private final e b;

    public c(g g1, e e1)
    {
        a = g1;
        b = e1;
    }

    public final void a(String s, Card card)
    {
        try
        {
            s = a.a(s);
            if (!b.k())
            {
                card.setContexts((new CardContexts()).setContextIds(Collections.singletonList(s.a())).setInlineContexts(Collections.singletonList(s.a(TimeUnit.DAYS))));
            }
            s.a(card);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new com.shazam.android.am.e("Error when sending card", s);
        }
    }
}
