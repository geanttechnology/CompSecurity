// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;


// Referenced classes of package com.digimarc.dms.resolver:
//            PayoffContainer

public static final class  extends Enum
{

    private static final DefaultPayoff $VALUES[];
    public static final DefaultPayoff DefaultPayoff;
    public static final DefaultPayoff NetworkError;
    public static final DefaultPayoff Resolved;
    public static final DefaultPayoff Unresolved;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/digimarc/dms/resolver/PayoffContainer$PayoffResult, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Unresolved = new <init>("Unresolved", 0);
        Resolved = new <init>("Resolved", 1);
        NetworkError = new <init>("NetworkError", 2);
        DefaultPayoff = new <init>("DefaultPayoff", 3);
        $VALUES = (new .VALUES[] {
            Unresolved, Resolved, NetworkError, DefaultPayoff
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
