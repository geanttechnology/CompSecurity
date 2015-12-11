// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

// Referenced classes of package android.support.v7:
//            aok

public static class newEncoder extends BufferedOutputStream
{

    private final CharsetEncoder a;

    public eam a(String s)
        throws IOException
    {
        s = a.encode(CharBuffer.wrap(s));
        super.write(s.array(), 0, s.limit());
        return this;
    }

    public ncoder(OutputStream outputstream, String s, int i)
    {
        super(outputstream, i);
        a = Charset.forName(aok.e(s)).newEncoder();
    }
}
