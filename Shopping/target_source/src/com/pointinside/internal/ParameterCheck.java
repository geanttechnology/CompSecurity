// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal;

import java.util.List;
import java.util.Map;

public final class ParameterCheck
{

    public ParameterCheck()
    {
    }

    public static final boolean isNullOrEmpty(Object obj)
    {
        if (obj == null)
        {
            return true;
        }
        if (obj instanceof String)
        {
            return ((String)obj).trim().isEmpty();
        }
        if (obj instanceof List)
        {
            return ((List)obj).isEmpty();
        }
        if (obj instanceof Map)
        {
            return ((Map)obj).isEmpty();
        } else
        {
            return false;
        }
    }

    public static final void throwIfNullOrEmpty(String s, String s1)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException(String.format("parameter %s cannot be null", new Object[] {
                s1
            }));
        }
        if (s1.trim().equals(""))
        {
            throw new IllegalArgumentException(String.format("parameter %s cannot be empty", new Object[] {
                s1
            }));
        } else
        {
            return;
        }
    }
}
