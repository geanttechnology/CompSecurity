// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.support.v4.f.a;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            c, s, q

public class p extends c
{

    public p()
    {
    }

    public static p j()
    {
        return new p();
    }

    protected Map b()
    {
        a a1 = new a();
        a1.put("events", "giftCardSavedToAccount");
        return a1;
    }

    protected s c()
    {
        return s.AccountGiftCards;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected q i()
    {
        return q.SaveGiftCardToAccount;
    }
}
