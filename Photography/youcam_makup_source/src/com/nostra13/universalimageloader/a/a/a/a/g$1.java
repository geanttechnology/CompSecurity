// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.a.a.a.a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

// Referenced classes of package com.nostra13.universalimageloader.a.a.a.a:
//            g

class a extends ByteArrayOutputStream
{

    final g a;

    public String toString()
    {
        String s;
        int i;
        if (count > 0 && buf[count - 1] == 13)
        {
            i = count - 1;
        } else
        {
            i = count;
        }
        try
        {
            s = new String(buf, 0, i, g.a(a).name());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new AssertionError(unsupportedencodingexception);
        }
        return s;
    }

    (g g1, int i)
    {
        a = g1;
        super(i);
    }
}
