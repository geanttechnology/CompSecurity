// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.d;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            aa

final class 
    implements d
{

    private final ByteBuffer a = ByteBuffer.allocate(8);

    public final void a(byte abyte0[], Object obj, MessageDigest messagedigest)
    {
        obj = (Long)obj;
        messagedigest.update(abyte0);
        synchronized (a)
        {
            a.position(0);
            messagedigest.update(a.putLong(((Long) (obj)).longValue()).array());
        }
        return;
        obj;
        abyte0;
        JVM INSTR monitorexit ;
        throw obj;
    }

    ()
    {
    }
}
