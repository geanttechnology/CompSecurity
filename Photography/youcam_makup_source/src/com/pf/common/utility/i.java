// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import android.graphics.Bitmap;
import com.cyberlink.uma.internal.a;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.channels.ReadableByteChannel;

class i
{

    final int a;
    final int b;
    final int c;
    final Bitmaps.Raw.AndroidBitmap.Format d;

    i(Bitmap bitmap)
    {
        a = bitmap.getWidth();
        b = bitmap.getHeight();
        c = bitmap.getRowBytes();
        d = com.pf.common.utility.Bitmaps.Raw.AndroidBitmap.Format.a(bitmap.getConfig());
    }

    i(IntBuffer intbuffer)
    {
        a = intbuffer.get();
        b = intbuffer.get();
        c = intbuffer.get();
        d = com.pf.common.utility.Bitmaps.Raw.AndroidBitmap.Format.a(intbuffer.get());
    }

    static i a(ReadableByteChannel readablebytechannel)
    {
        Object obj = ByteBuffer.allocateDirect(28).order(ByteOrder.nativeOrder());
        int j = readablebytechannel.read(((ByteBuffer) (obj)));
        if (j < 28)
        {
            throw com.cyberlink.uma.internal.a.a(new EOFException("File is too small."));
        }
        ((ByteBuffer) (obj)).flip();
        obj = ((ByteBuffer) (obj)).asIntBuffer();
        int k = ((IntBuffer) (obj)).get();
        if (k != 0x504d4241)
        {
            throw new RuntimeException((new StringBuilder()).append("Invalid magic number ").append(k).append(". Not our business.").toString());
        }
        k = ((IntBuffer) (obj)).get();
        if (j < k + 8)
        {
            throw com.cyberlink.uma.internal.a.a(new EOFException("File is too small."));
        }
        if (k < 20)
        {
            throw new RuntimeException("Invalid size.");
        }
        if (k > 20)
        {
            readablebytechannel.read(ByteBuffer.allocateDirect(k - 20));
        }
        return new i(((IntBuffer) (obj)));
    }

    Bitmap a()
    {
        return Bitmap.createBitmap(a, b, d.config);
    }

    ByteBuffer b()
    {
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(28).order(ByteOrder.nativeOrder());
        bytebuffer.putInt(0x504d4241);
        bytebuffer.putInt(20);
        bytebuffer.putInt(a);
        bytebuffer.putInt(b);
        bytebuffer.putInt(c);
        bytebuffer.putInt(d.nativeValue);
        bytebuffer.clear();
        return bytebuffer;
    }
}
