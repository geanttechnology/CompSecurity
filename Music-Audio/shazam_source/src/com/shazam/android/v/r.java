// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.v;

import com.shazam.c.a;
import com.shazam.c.j;
import com.shazam.model.ActionsToIntentsConverterFactory;
import java.util.Collections;
import java.util.Map;

public final class r
    implements ActionsToIntentsConverterFactory
{

    public r()
    {
    }

    public final Object create(Object obj)
    {
        Map map = (Map)obj;
        obj = map;
        if (map == null)
        {
            obj = Collections.emptyMap();
        }
        return j.a(new a(com.shazam.i.b.ab.a.a(), com.shazam.i.d.a.a(((Map) (obj)))));
    }
}
