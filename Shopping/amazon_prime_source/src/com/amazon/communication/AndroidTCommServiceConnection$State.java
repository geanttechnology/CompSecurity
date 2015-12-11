// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;


// Referenced classes of package com.amazon.communication:
//            AndroidTCommServiceConnection

protected static final class  extends Enum
{

    private static final BOUND $VALUES[];
    public static final BOUND BINDING;
    public static final BOUND BOUND;
    public static final BOUND UNBOUND;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/communication/AndroidTCommServiceConnection$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        UNBOUND = new <init>("UNBOUND", 0);
        BINDING = new <init>("BINDING", 1);
        BOUND = new <init>("BOUND", 2);
        $VALUES = (new .VALUES[] {
            UNBOUND, BINDING, BOUND
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
