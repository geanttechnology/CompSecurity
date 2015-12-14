// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


public final class zzDv extends Exception
{

    private final int zzDv;

    public final int getErrorCode()
    {
        return zzDv;
    }

    public (String s, int i)
    {
        super(s);
        zzDv = i;
    }
}
