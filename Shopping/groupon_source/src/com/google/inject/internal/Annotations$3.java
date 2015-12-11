// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import java.util.Arrays;
import org.roboguice.shaded.goole.common.base.Function;

// Referenced classes of package com.google.inject.internal:
//            Annotations

static final class nction
    implements Function
{

    public volatile Object apply(Object obj)
    {
        return apply(obj);
    }

    public String apply(Object obj)
    {
        obj = Arrays.deepToString(new Object[] {
            obj
        });
        return ((String) (obj)).substring(1, ((String) (obj)).length() - 1);
    }

    nction()
    {
    }
}
