// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;


// Referenced classes of package com.google.common.util.concurrent:
//            FuturesGetChecked

static final class  extends ClassValue
{

    protected Boolean computeValue(Class class1)
    {
        FuturesGetChecked.checkExceptionClassValidity(class1.asSubclass(java/lang/Exception));
        return Boolean.valueOf(true);
    }

    protected volatile Object computeValue(Class class1)
    {
        return computeValue(class1);
    }

    ()
    {
    }
}
