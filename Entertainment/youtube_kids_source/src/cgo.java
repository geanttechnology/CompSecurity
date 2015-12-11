// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class cgo
    implements Iterable
{

    public static final cgo a;
    private static final Map c;
    private final Map b;

    public cgo()
    {
        this(((Map) (new HashMap())));
    }

    private cgo(Map map)
    {
        b = map;
    }

    static Map a(cgo cgo1)
    {
        return cgo1.b;
    }

    public final cgo a(String s, String s1)
    {
        b.put(s, s1);
        return this;
    }

    public final Iterator iterator()
    {
        return new cgp(this);
    }

    public final String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s;
        String s1;
        for (Iterator iterator1 = b.keySet().iterator(); iterator1.hasNext(); stringbuffer.append((new StringBuilder(String.valueOf(s).length() + 2 + String.valueOf(s1).length())).append(s).append(":").append(s1).append(" ").toString()))
        {
            s = (String)iterator1.next();
            s1 = (String)b.get(s);
        }

        return stringbuffer.toString();
    }

    static 
    {
        c = Collections.emptyMap();
        a = new cgo(c);
    }
}
