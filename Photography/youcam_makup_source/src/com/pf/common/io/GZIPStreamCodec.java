// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.io;

import com.pf.common.utility.s;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package com.pf.common.io:
//            d

public final class GZIPStreamCodec extends Enum
    implements d
{

    public static final GZIPStreamCodec a;
    private static final GZIPStreamCodec b[];

    private GZIPStreamCodec(String s1, int i)
    {
        super(s1, i);
    }

    public static GZIPStreamCodec valueOf(String s1)
    {
        return (GZIPStreamCodec)Enum.valueOf(com/pf/common/io/GZIPStreamCodec, s1);
    }

    public static GZIPStreamCodec[] values()
    {
        return (GZIPStreamCodec[])b.clone();
    }

    public InputStream a(InputStream inputstream)
    {
        try
        {
            inputstream = new GZIPInputStream(inputstream, 0x400000);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw s.a(inputstream);
        }
        return inputstream;
    }

    public OutputStream a(OutputStream outputstream)
    {
        try
        {
            outputstream = new GZIPOutputStream(outputstream);
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            throw s.a(outputstream);
        }
        return outputstream;
    }

    public String toString()
    {
        return "GZIPStreamCodec";
    }

    static 
    {
        a = new GZIPStreamCodec("INSTANCE", 0);
        b = (new GZIPStreamCodec[] {
            a
        });
    }
}
