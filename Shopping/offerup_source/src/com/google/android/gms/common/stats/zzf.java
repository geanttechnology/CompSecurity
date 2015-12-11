// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.stats;


public abstract class zzf
{

    public static int zzahY = 0;
    public static int zzahZ = 1;

    public zzf()
    {
    }

    public abstract int getEventType();

    public abstract long getTimeMillis();

    public String toString()
    {
        return (new StringBuilder()).append(getTimeMillis()).append("\t").append(getEventType()).append("\t").append(zzqd()).append(zzqg()).toString();
    }

    public abstract long zzqd();

    public abstract String zzqg();

}
