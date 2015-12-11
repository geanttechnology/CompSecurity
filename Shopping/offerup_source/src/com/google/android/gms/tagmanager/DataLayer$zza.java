// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.Arrays;

final class zzJy
{

    public final Object zzJy;
    public final String zzue;

    public final boolean equals(Object obj)
    {
        if (obj instanceof zzJy)
        {
            if (zzue.equals(((zzue) (obj = (zzue)obj)).zzue) && zzJy.equals(((zzJy) (obj)).zzJy))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Integer[] {
            Integer.valueOf(zzue.hashCode()), Integer.valueOf(zzJy.hashCode())
        });
    }

    public final String toString()
    {
        return (new StringBuilder("Key: ")).append(zzue).append(" value: ").append(zzJy.toString()).toString();
    }

    (String s, Object obj)
    {
        zzue = s;
        zzJy = obj;
    }
}
