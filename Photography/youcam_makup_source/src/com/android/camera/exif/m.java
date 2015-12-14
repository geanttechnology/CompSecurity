// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.camera.exif;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

// Referenced classes of package com.android.camera.exif:
//            n

class m extends FilterOutputStream
{

    private final ByteBuffer a = ByteBuffer.allocate(4);

    public m(OutputStream outputstream)
    {
        super(outputstream);
    }

    public m a(int i)
    {
        a.rewind();
        a.putInt(i);
        out.write(a.array());
        return this;
    }

    public m a(n n1)
    {
        a((int)n1.a());
        a((int)n1.b());
        return this;
    }

    public m a(ByteOrder byteorder)
    {
        a.order(byteorder);
        return this;
    }

    public m a(short word0)
    {
        a.rewind();
        a.putShort(word0);
        out.write(a.array(), 0, 2);
        return this;
    }
}
