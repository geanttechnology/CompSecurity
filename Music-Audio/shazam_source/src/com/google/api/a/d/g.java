// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.g.y;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package com.google.api.a.d:
//            j

public final class g
    implements j
{

    public g()
    {
    }

    public final String a()
    {
        return "gzip";
    }

    public final void a(y y1, OutputStream outputstream)
    {
        outputstream = new GZIPOutputStream(new BufferedOutputStream(outputstream) {

            final g a;

            public final void close()
            {
                try
                {
                    flush();
                    return;
                }
                catch (IOException ioexception)
                {
                    return;
                }
            }

            
            {
                a = g.this;
                super(outputstream);
            }
        });
        y1.a(outputstream);
        outputstream.close();
    }
}
