// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.math;


final class MathPreconditions
{

    static void checkRoundingUnnecessary(boolean flag)
    {
        if (!flag)
        {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        } else
        {
            return;
        }
    }
}
