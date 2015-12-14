// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.content.Context;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.runtime.internal.Conversions;

// Referenced classes of package com.aviary.android.feather.cds:
//            CdsUtils

public class _cls9 extends AroundClosure
{

    public Object run(Object aobj[])
    {
        aobj = super.state;
        return CdsUtils.requestPackDownload_aroundBody2((Context)aobj[0], Conversions.longValue(aobj[1]), Conversions.booleanValue(aobj[2]), (JoinPoint)aobj[3]);
    }

    public _cls9(Object aobj[])
    {
        super(aobj);
    }
}
