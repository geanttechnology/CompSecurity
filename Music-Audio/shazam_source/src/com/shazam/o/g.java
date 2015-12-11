// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.o;

import com.shazam.i.e.a;
import com.shazam.model.Cache;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import java.util.Map;

public final class g
    implements Cache
{

    private final Map a = com.shazam.i.e.a.a(1);

    public g()
    {
    }

    public final Object a(Object obj)
    {
        obj = (String)obj;
        return (Tag)a.get(obj);
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (String)obj;
        obj1 = (Tag)obj1;
        if (((Tag) (obj1)).track.isFull && obj != null)
        {
            a.clear();
            a.put(obj, obj1);
        }
    }

    public final void b(Object obj)
    {
        obj = (String)obj;
        a.remove(obj);
    }
}
