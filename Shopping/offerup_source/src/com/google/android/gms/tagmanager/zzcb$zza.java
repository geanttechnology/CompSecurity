// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


final class  extends Enum
{

    public static final zzaYa zzaXY;
    public static final zzaYa zzaXZ;
    public static final zzaYa zzaYa;
    private static final zzaYa zzaYb[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/android/gms/tagmanager/zzcb$zza, s);
    }

    public static [] values()
    {
        return ([])zzaYb.clone();
    }

    static 
    {
        zzaXY = new <init>("NONE", 0);
        zzaXZ = new <init>("CONTAINER", 1);
        zzaYa = new <init>("CONTAINER_DEBUG", 2);
        zzaYb = (new zzaYb[] {
            zzaXY, zzaXZ, zzaYa
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
