// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.g.a;

import com.google.a.a.c;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.a.g.a:
//            i

static final class structor
    implements c
{

    public final Object a(Object obj)
    {
        return Boolean.valueOf(Arrays.asList(((Constructor)obj).getParameterTypes()).contains(java/lang/String));
    }

    structor()
    {
    }
}
