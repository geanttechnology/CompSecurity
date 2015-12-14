// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;


// Referenced classes of package com.amazon.gallery.thor.app.authentication:
//            AccountStateManager

public static final class Q extends Enum
{

    private static final AccountRegistered $VALUES[];
    public static final AccountRegistered AccountRegistered;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/amazon/gallery/thor/app/authentication/AccountStateManager$MetricsEvent, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        AccountRegistered = new <init>("AccountRegistered", 0);
        $VALUES = (new .VALUES[] {
            AccountRegistered
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
