// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;


// Referenced classes of package com.target.ui.analytics.a:
//            ac

private static final class  extends Enum
{

    private static final PdpDeepLink $VALUES[];
    public static final PdpDeepLink InternalPromo;
    public static final PdpDeepLink PdpDeepLink;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/analytics/a/ac$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        InternalPromo = new <init>("InternalPromo", 0);
        PdpDeepLink = new <init>("PdpDeepLink", 1);
        $VALUES = (new .VALUES[] {
            InternalPromo, PdpDeepLink
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
