// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;


public final class MAPArgContracts
{

    public static void throwIfNull(Object obj, String s)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException(String.format("%s cannot be null", new Object[] {
                s
            }));
        } else
        {
            return;
        }
    }
}
