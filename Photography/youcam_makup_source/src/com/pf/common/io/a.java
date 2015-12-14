// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.io;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

// Referenced classes of package com.pf.common.io:
//            d, b

public class a
    implements d
{

    public static final a a = new b(-1, "DeflateStreamCodec.DEFAULT");
    public static final a b = new b(9, "DeflateStreamCodec.BEST_COMPRESSION");
    public static final a c = new b(1, "DeflateStreamCodec.BEST_SPEED");
    private final int d;
    private final boolean e;

    public a(int i)
    {
        this(i, false);
    }

    public a(int i, boolean flag)
    {
        d = i;
        e = flag;
    }

    public InputStream a(InputStream inputstream)
    {
        return new InflaterInputStream(inputstream, new Inflater(e), 0x400000);
    }

    public OutputStream a(OutputStream outputstream)
    {
        return new DeflaterOutputStream(outputstream, new Deflater(d, e));
    }

    public String toString()
    {
        return (new StringBuilder()).append("DeflateStreamCodec [level=").append(d).append(", noHeader=").append(e).append(']').toString();
    }

}
