// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            eu, fb

public class ev
    implements eu
{

    public ev()
    {
    }

    public Object a(InputStream inputstream)
        throws IOException
    {
        return b(inputstream);
    }

    public volatile void a(OutputStream outputstream, Object obj)
        throws IOException
    {
        a(outputstream, (String)obj);
    }

    public void a(OutputStream outputstream, String s)
        throws IOException
    {
        if (outputstream == null || s == null)
        {
            return;
        } else
        {
            s = s.getBytes("utf-8");
            outputstream.write(s, 0, s.length);
            return;
        }
    }

    public String b(InputStream inputstream)
        throws IOException
    {
        if (inputstream == null)
        {
            return null;
        } else
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            fb.a(inputstream, bytearrayoutputstream);
            return bytearrayoutputstream.toString();
        }
    }
}
