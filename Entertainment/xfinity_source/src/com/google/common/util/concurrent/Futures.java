// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.common.util.concurrent:
//            SettableFuture, ListenableFuture

public final class Futures
{

    private static final Ordering WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new Function() {

        public Boolean apply(Constructor constructor)
        {
            return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(java/lang/String));
        }

        public volatile Object apply(Object obj)
        {
            return apply((Constructor)obj);
        }

    }).reverse();

    public static ListenableFuture immediateFuture(Object obj)
    {
        SettableFuture settablefuture = SettableFuture.create();
        settablefuture.set(obj);
        return settablefuture;
    }

}
