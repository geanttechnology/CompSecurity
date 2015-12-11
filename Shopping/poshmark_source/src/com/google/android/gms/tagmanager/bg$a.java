// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


// Referenced classes of package com.google.android.gms.tagmanager:
//            bg

public static final class  extends Enum
{

    public static final VC VA;
    public static final VC VB;
    public static final VC VC;
    private static final VC VD[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/android/gms/tagmanager/bg$a, s);
    }

    public static [] values()
    {
        return ([])VD.clone();
    }

    static 
    {
        VA = new <init>("NOT_AVAILABLE", 0);
        VB = new <init>("IO_ERROR", 1);
        VC = new <init>("SERVER_ERROR", 2);
        VD = (new VD[] {
            VA, VB, VC
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
