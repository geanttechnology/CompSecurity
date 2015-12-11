// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.am;

import java.io.IOException;
import java.util.Date;

// Referenced classes of package com.shazam.android.am:
//            i, l, h, d

public final class a
    implements i
{

    private final l a;
    private final h b;

    public a(l l1, h h1)
    {
        a = l1;
        b = h1;
    }

    public final String a()
    {
        if (a.c())
        {
            b.a();
            throw new d("We were expecting a HaveTokenAlreadyException");
        }
        break MISSING_BLOCK_LABEL_49;
        Object obj;
        obj;
        String s = ((com.google.android.now.NowAuthService.HaveTokenAlreadyException) (obj)).getAccessToken();
        a.a(s);
        return s;
        throw new d("Google Now auth code cool-down period");
        s;
        long l1 = s.getNextRetryTimestampMillis();
        a.a(l1);
        String s1 = (new Date(l1)).toString();
        throw new d((new StringBuilder("Could not authenticate with Now API at this point but can retry for auth code after: ")).append(s1).toString(), s);
        s;
_L2:
        throw new d("Could not authenticate with Now API", s);
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
