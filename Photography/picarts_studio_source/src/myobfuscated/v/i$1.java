// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

// Referenced classes of package myobfuscated.v:
//            g, i

final class putStream
    implements g
{

    public final Class a()
    {
        return java/io/InputStream;
    }

    public final Object a(byte abyte0[])
    {
        return new ByteArrayInputStream(abyte0);
    }

    putStream()
    {
    }
}
