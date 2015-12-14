// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class References extends Enum
{

    public static final Reference a = new WeakReference(null);
    private static final References b[] = new References[0];

    public static Reference a()
    {
        return a;
    }

    public static References valueOf(String s)
    {
        return (References)Enum.valueOf(com/pf/common/utility/References, s);
    }

    public static References[] values()
    {
        return (References[])b.clone();
    }

}
