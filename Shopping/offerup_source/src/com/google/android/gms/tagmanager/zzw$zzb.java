// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.Arrays;

class zzaWO
{

    final byte zzaWO[];
    final String zzue;

    public String toString()
    {
        return (new StringBuilder("KeyAndSerialized: key = ")).append(zzue).append(" serialized hash = ").append(Arrays.hashCode(zzaWO)).toString();
    }

    (String s, byte abyte0[])
    {
        zzue = s;
        zzaWO = abyte0;
    }
}
