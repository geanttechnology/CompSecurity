// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import com.google.api.a.f.a.a.a.a.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

// Referenced classes of package com.google.api.a.g:
//            c, y

public final class m
{

    public static long a(y y1)
    {
        com.google.api.a.g.c c1 = new com.google.api.a.g.c();
        y1.a(c1);
        c1.close();
        return c1.a;
        y1;
        c1.close();
        throw y1;
    }

    public static Serializable a(InputStream inputstream)
    {
        Serializable serializable = (Serializable)(new ObjectInputStream(inputstream)).readObject();
        inputstream.close();
        return serializable;
        Object obj;
        obj;
        IOException ioexception = new IOException("Failed to deserialize object");
        ioexception.initCause(((Throwable) (obj)));
        throw ioexception;
        obj;
        inputstream.close();
        throw obj;
    }

    public static void a(InputStream inputstream, OutputStream outputstream, boolean flag)
    {
        byte abyte0[];
        c.a(inputstream);
        c.a(outputstream);
        abyte0 = new byte[4096];
_L1:
        int i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        outputstream.write(abyte0, 0, i);
          goto _L1
        outputstream;
        if (flag)
        {
            inputstream.close();
        }
        throw outputstream;
        if (flag)
        {
            inputstream.close();
        }
        return;
    }

    public static byte[] a(Object obj)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        (new ObjectOutputStream(bytearrayoutputstream)).writeObject(obj);
        bytearrayoutputstream.close();
        return bytearrayoutputstream.toByteArray();
        obj;
        bytearrayoutputstream.close();
        throw obj;
    }
}
