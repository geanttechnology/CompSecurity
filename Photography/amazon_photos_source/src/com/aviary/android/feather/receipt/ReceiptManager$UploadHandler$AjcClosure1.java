// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.receipt;

import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;

public class Q extends AroundClosure
{

    public Object run(Object aobj[])
    {
        aobj = super.state;
        dBody0((dBody0)aobj[0], (JoinPoint)aobj[1]);
        return null;
    }

    public Q(Object aobj[])
    {
        super(aobj);
    }
}
