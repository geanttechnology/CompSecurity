// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.text.TextUtils;
import java.util.Collection;

public final class MAPArgContracts
{

    private MAPArgContracts()
    {
    }

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

    public static void throwIfNullOrEmptry(String s, String s1)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException(String.format("%s cannot be null or empty", new Object[] {
                s1
            }));
        } else
        {
            return;
        }
    }

    public static void throwIfNullOrEmptry(Collection collection, String s)
    {
        if (collection == null || collection.isEmpty())
        {
            throw new IllegalArgumentException(String.format("%s cannot be null or empty", new Object[] {
                s
            }));
        } else
        {
            return;
        }
    }
}
