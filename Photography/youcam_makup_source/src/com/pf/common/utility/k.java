// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import android.graphics.Bitmap;
import com.pf.common.io.IO;
import com.pf.common.io.c;
import com.pf.common.io.d;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.pf.common.utility:
//            e, c

public class k extends e
{

    private final d a;

    public k(d d1, com.pf.common.utility.c c1)
    {
        super(c1);
        if (d1 == null)
        {
            throw new NullPointerException("streamCodec == null");
        } else
        {
            a = d1;
            return;
        }
    }

    public Bitmap a(InputStream inputstream, android.graphics.BitmapFactory.Options options)
    {
        return super.a(a.a(inputstream), options);
    }

    public void a(Bitmap bitmap, OutputStream outputstream)
    {
        outputstream = a.a(new c(outputstream));
        super.a(bitmap, outputstream);
        IO.a(outputstream);
        return;
        bitmap;
        IO.a(outputstream);
        throw bitmap;
    }

    public String toString()
    {
        return (new StringBuilder()).append("StreamCodecWrapper [mStreamCodec=").append(a).append(']').toString();
    }
}
