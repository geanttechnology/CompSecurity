// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.util.concurrent;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import org.roboguice.shaded.goole.common.base.Function;

// Referenced classes of package org.roboguice.shaded.goole.common.util.concurrent:
//            Futures

static final class A
    implements Function
{

    public Boolean apply(Constructor constructor)
    {
        return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(java/lang/String));
    }

    public volatile Object apply(Object obj)
    {
        return apply((Constructor)obj);
    }

    A()
    {
    }
}
