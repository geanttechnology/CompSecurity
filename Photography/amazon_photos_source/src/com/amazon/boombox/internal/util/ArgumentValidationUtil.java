// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.internal.util;


public class ArgumentValidationUtil
{

    public static void validateNotNull(Object obj, String s, Class class1)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException(String.format("Argument '%s' cannot be null in %s", new Object[] {
                s, class1.getSimpleName()
            }));
        } else
        {
            return;
        }
    }
}
