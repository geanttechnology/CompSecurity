// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;


// Referenced classes of package com.amazon.identity.auth.accounts:
//            SubAuthenticatorConnection

private static final class  extends Enum
{

    private static final Bound $VALUES[];
    public static final Bound Binding;
    public static final Bound Bound;
    public static final Bound Unbound;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Unbound = new <init>("Unbound", 0);
        Binding = new <init>("Binding", 1);
        Bound = new <init>("Bound", 2);
        $VALUES = (new .VALUES[] {
            Unbound, Binding, Bound
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
