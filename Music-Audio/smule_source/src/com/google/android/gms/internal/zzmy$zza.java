// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


public final class  extends Enum
{

    public static final zzaHL zzaHJ;
    public static final zzaHL zzaHK;
    public static final zzaHL zzaHL;
    private static final zzaHL zzaHM[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/android/gms/internal/zzmy$zza, s);
    }

    public static [] values()
    {
        return ([])zzaHM.clone();
    }

    static 
    {
        zzaHJ = new <init>("NOT_AVAILABLE", 0);
        zzaHK = new <init>("IO_ERROR", 1);
        zzaHL = new <init>("SERVER_ERROR", 2);
        zzaHM = (new zzaHM[] {
            zzaHJ, zzaHK, zzaHL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
