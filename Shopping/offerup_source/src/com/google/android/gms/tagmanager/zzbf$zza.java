// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


public final class  extends Enum
{

    public static final zzaXA zzaXA;
    private static final zzaXA zzaXB[];
    public static final zzaXA zzaXy;
    public static final zzaXA zzaXz;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/android/gms/tagmanager/zzbf$zza, s);
    }

    public static [] values()
    {
        return ([])zzaXB.clone();
    }

    static 
    {
        zzaXy = new <init>("NOT_AVAILABLE", 0);
        zzaXz = new <init>("IO_ERROR", 1);
        zzaXA = new <init>("SERVER_ERROR", 2);
        zzaXB = (new zzaXB[] {
            zzaXy, zzaXz, zzaXA
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
