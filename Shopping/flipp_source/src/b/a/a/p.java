// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;

import b.a.a.d.a;
import b.a.a.d.d;

// Referenced classes of package b.a.a:
//            q

public final class p extends IllegalArgumentException
{

    public p(long l, String s)
    {
        String s1 = a.a("yyyy-MM-dd'T'HH:mm:ss.SSS").a(new q(l));
        if (s != null)
        {
            s = (new StringBuilder(" (")).append(s).append(")").toString();
        } else
        {
            s = "";
        }
        super((new StringBuilder("Illegal instant due to time zone offset transition (daylight savings time 'gap'): ")).append(s1).append(s).toString());
    }

    public p(String s)
    {
        super(s);
    }
}
