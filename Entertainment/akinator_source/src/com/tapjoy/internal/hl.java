// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            hm, ht, hq

public final class hl
{

    final hm a = new hm();
    final ht b;
    private final String c;

    public hl(String s, ht ht1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Name may not be null");
        }
        if (ht1 == null)
        {
            throw new IllegalArgumentException("Body may not be null");
        }
        c = s;
        b = ht1;
        s = new StringBuilder();
        s.append("form-data; name=\"");
        s.append(c);
        s.append("\"");
        a("Content-Disposition", s.toString());
        s = new StringBuilder();
        s.append(ht1.a());
        if (ht1.b() != null)
        {
            s.append("; charset=");
            s.append(ht1.b());
        }
        a("Content-Type", s.toString());
        a("Content-Transfer-Encoding", ht1.c());
    }

    private void a(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Field name may not be null");
        } else
        {
            a.a(new hq(s, s1));
            return;
        }
    }
}
