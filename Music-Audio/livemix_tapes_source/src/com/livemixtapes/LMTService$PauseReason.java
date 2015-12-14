// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;


// Referenced classes of package com.livemixtapes:
//            LMTService

static final class  extends Enum
{

    private static final FocusLoss ENUM$VALUES[];
    public static final FocusLoss FocusLoss;
    public static final FocusLoss UserRequest;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/livemixtapes/LMTService$PauseReason, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        UserRequest = new <init>("UserRequest", 0);
        FocusLoss = new <init>("FocusLoss", 1);
        ENUM$VALUES = (new ENUM.VALUES[] {
            UserRequest, FocusLoss
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
