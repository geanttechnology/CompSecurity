// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;


// Referenced classes of package com.digimarc.dms.resolver:
//            ResolverService

private static final class  extends Enum
{

    private static final resolved $VALUES[];
    public static final resolved resolved;
    public static final resolved resolving;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/digimarc/dms/resolver/ResolverService$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        resolving = new <init>("resolving", 0);
        resolved = new <init>("resolved", 1);
        $VALUES = (new .VALUES[] {
            resolving, resolved
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
