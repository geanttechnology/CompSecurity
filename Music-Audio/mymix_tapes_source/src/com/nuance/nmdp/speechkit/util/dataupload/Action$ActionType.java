// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.dataupload;


// Referenced classes of package com.nuance.nmdp.speechkit.util.dataupload:
//            Action

public static final class A extends Enum
{

    public static final CLEARALL ADD;
    public static final CLEARALL CLEARALL;
    public static final CLEARALL REMOVE;
    private static final CLEARALL a[];

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/nuance/nmdp/speechkit/util/dataupload/Action$ActionType, s);
    }

    public static A[] values()
    {
        return (A[])a.clone();
    }

    static 
    {
        ADD = new <init>("ADD", 0);
        REMOVE = new <init>("REMOVE", 1);
        CLEARALL = new <init>("CLEARALL", 2);
        a = (new a[] {
            ADD, REMOVE, CLEARALL
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
