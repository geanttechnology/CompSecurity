// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;

final class CollectPreconditions
{

    CollectPreconditions()
    {
    }

    static void checkEntryNotNull(Object obj, Object obj1)
    {
        if (obj == null)
        {
            obj = String.valueOf(obj1);
            throw new NullPointerException((new StringBuilder(String.valueOf(obj).length() + 24)).append("null key in entry: null=").append(((String) (obj))).toString());
        }
        if (obj1 == null)
        {
            obj = String.valueOf(obj);
            throw new NullPointerException((new StringBuilder(String.valueOf(obj).length() + 26)).append("null value in entry: ").append(((String) (obj))).append("=null").toString());
        } else
        {
            return;
        }
    }

    static int checkNonnegative(int i, String s)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder(String.valueOf(s).length() + 40)).append(s).append(" cannot be negative but was: ").append(i).toString());
        } else
        {
            return i;
        }
    }

    static void checkPositive(int i, String s)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException((new StringBuilder(String.valueOf(s).length() + 38)).append(s).append(" must be positive but was: ").append(i).toString());
        } else
        {
            return;
        }
    }

    static void checkRemove(boolean flag)
    {
        Preconditions.checkState(flag, "no calls to next() since the last call to remove()");
    }
}
