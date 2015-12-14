// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            kn, ig, kg, js, 
//            kk, ht

class it>
    implements it>
{

    final long a;
    final boolean b;
    final ig c;

    public volatile void a(kn kn1, Object obj)
    {
        a(kn1, (byte[])obj);
    }

    public void a(kn kn1, byte abyte0[])
    {
        Object obj;
        int i;
        obj = null;
        i = kn1.h();
        kg.a(3, ig.e(), (new StringBuilder()).append("Proton config request: HTTP status code is:").append(i).toString());
        if (i != 400 && i != 406 && i != 412 && i != 415) goto _L2; else goto _L1
_L1:
        ig.a(c, 10000L);
_L4:
        return;
_L2:
        long l;
        ht ht1 = obj;
        if (!kn1.f())
        {
            continue; /* Loop/switch isn't completed */
        }
        ht1 = obj;
        if (abyte0 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        class _cls1 extends ly
        {

            final byte a[];
            final ig._cls2 b;

            public void a()
            {
                ig.a(b.c, b.a, b.b, a);
            }

            _cls1(byte abyte0[])
            {
                b = ig._cls2.this;
                a = abyte0;
                super();
            }
        }

        js.a().b(new _cls1(abyte0));
        long l1;
        try
        {
            abyte0 = (ht)ig.e(c).d(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            kg.a(5, ig.e(), (new StringBuilder()).append("Failed to decode proton config response: ").append(abyte0).toString());
            abyte0 = null;
        }
        ht1 = abyte0;
        if (!ig.a(c, abyte0))
        {
            ht1 = null;
        }
        if (ht1 != null)
        {
            ig.a(c, 10000L);
            ig.b(c, a);
            ig.a(c, b);
            ig.b(c, ht1);
            ig.f(c);
            if (!ig.g(c))
            {
                ig.b(c, true);
                ig.a(c, "flurry.session_start", null);
            }
            ig.h(c);
        }
        if (ht1 != null) goto _L4; else goto _L3
_L3:
        l = ig.i(c);
        if (i != 429) goto _L6; else goto _L5
_L5:
        kn1 = kn1.b("Retry-After");
        if (kn1.isEmpty()) goto _L6; else goto _L7
_L7:
        kn1 = (String)kn1.get(0);
        kg.a(3, ig.e(), (new StringBuilder()).append("Server returned retry time: ").append(kn1).toString());
        l1 = Long.parseLong(kn1);
        l = l1 * 1000L;
_L9:
        ig.a(c, l);
        kg.a(3, ig.e(), (new StringBuilder()).append("Proton config request failed, backing off: ").append(ig.i(c)).append("ms").toString());
        js.a().b(ig.j(c), ig.i(c));
        return;
        kn1;
        kg.a(3, ig.e(), "Server returned nonsensical retry time");
_L6:
        l <<= 1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    atException(ig ig1, long l, boolean flag)
    {
        c = ig1;
        a = l;
        b = flag;
        super();
    }
}
