// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;

public class tv
{

    public final int a;
    public final byte b[];
    public final Map c;
    public final boolean d;
    public final long e;

    public tv(int i, byte abyte0[], Map map, boolean flag, long l)
    {
        a = i;
        b = abyte0;
        c = map;
        d = flag;
        e = l;
    }

    public tv(byte abyte0[], Map map)
    {
        this(200, abyte0, map, false, 0L);
    }
}
