// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            fk, eu

public static final class m extends Enum
{

    public static final k a;
    public static final k b;
    public static final k c;
    public static final k d;
    public static final k e;
    public static final k f;
    public static final k g;
    public static final k h;
    public static final k i;
    public static final k j;
    public static final k k;
    private static final k n[];
    private final String l;
    private final String m;

    static m a(eu eu1)
    {
        return valueOf(eu1.name());
    }

    public static me valueOf(String s)
    {
        return (me)Enum.valueOf(com/tapjoy/internal/fk$c, s);
    }

    public static me[] values()
    {
        return (me[])n.clone();
    }

    public final String a()
    {
        return m;
    }

    final eu b()
    {
        return eu.valueOf(name());
    }

    public final String toString()
    {
        return l;
    }

    static 
    {
        a = new <init>("THM_NotYet", 0);
        b = new <init>("THM_OK", 1);
        c = new <init>("THM_Connection_Error", 2);
        d = new <init>("THM_HostNotFound_Error", 3);
        e = new <init>("THM_NetworkTimeout_Error", 4);
        f = new <init>("THM_Internal_Error", 5);
        g = new <init>("THM_HostVerification_Error", 6);
        h = new <init>("THM_Interrupted_Error", 7);
        i = new <init>("THM_InvalidOrgID", 8);
        j = new <init>("THM_ConfigurationError", 9);
        k = new <init>("THM_PartialProfile", 10);
        n = (new n[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }

    private (String s, int i1)
    {
        super(s, i1);
        s = eu.valueOf(name());
        l = s.toString();
        m = s.a();
    }
}
