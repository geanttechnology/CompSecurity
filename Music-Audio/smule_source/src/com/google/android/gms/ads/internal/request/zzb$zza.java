// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;


final class zzyl extends Exception
{

    private final int zzyl;

    public int getErrorCode()
    {
        return zzyl;
    }

    public _cls9(String s, int i)
    {
        super(s);
        zzyl = i;
    }
}
