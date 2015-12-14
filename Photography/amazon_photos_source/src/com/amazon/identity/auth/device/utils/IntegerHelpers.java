// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;


public final class IntegerHelpers
{

    public static int compare(Integer integer, Integer integer1)
    {
        if (integer == null)
        {
            return integer1 == null ? 0 : -1;
        }
        if (integer1 == null)
        {
            return 1;
        } else
        {
            return Integer.signum(integer.intValue() - integer1.intValue());
        }
    }
}
