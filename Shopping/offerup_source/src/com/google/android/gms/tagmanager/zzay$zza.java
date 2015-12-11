// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


final class  extends Enum
{

    public static final zzaXs zzaXq;
    public static final zzaXs zzaXr;
    public static final zzaXs zzaXs;
    private static final zzaXs zzaXt[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/android/gms/tagmanager/zzay$zza, s);
    }

    public static [] values()
    {
        return ([])zzaXt.clone();
    }

    static 
    {
        zzaXq = new <init>("NONE", 0);
        zzaXr = new <init>("URL", 1);
        zzaXs = new <init>("BACKSLASH", 2);
        zzaXt = (new zzaXt[] {
            zzaXq, zzaXr, zzaXs
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
