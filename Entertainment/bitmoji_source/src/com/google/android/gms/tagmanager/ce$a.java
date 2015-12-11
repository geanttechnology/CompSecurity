// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


// Referenced classes of package com.google.android.gms.tagmanager:
//            ce

static final class  extends Enum
{

    public static final VY VW;
    public static final VY VX;
    public static final VY VY;
    private static final VY VZ[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/android/gms/tagmanager/ce$a, s);
    }

    public static [] values()
    {
        return ([])VZ.clone();
    }

    static 
    {
        VW = new <init>("NONE", 0);
        VX = new <init>("CONTAINER", 1);
        VY = new <init>("CONTAINER_DEBUG", 2);
        VZ = (new VZ[] {
            VW, VX, VY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
