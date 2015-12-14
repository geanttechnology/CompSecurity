// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.content.Intent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsService

public class A extends AroundClosure
{

    public Object run(Object aobj[])
    {
        aobj = super.state;
        AviaryCdsService.handleKeys_aroundBody0((AviaryCdsService)aobj[0], (Intent)aobj[1], (JoinPoint)aobj[2]);
        return null;
    }

    public A(Object aobj[])
    {
        super(aobj);
    }
}
