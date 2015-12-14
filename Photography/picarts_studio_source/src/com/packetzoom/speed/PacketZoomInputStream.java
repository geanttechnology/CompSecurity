// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;

import java.io.InputStream;

class PacketZoomInputStream extends InputStream
{

    private Object a_java_lang_Object_fld;
    private final String a_java_lang_String_fld = "libpz";

    public PacketZoomInputStream(Object obj)
    {
        a_java_lang_Object_fld = obj;
    }

    private native void nativeClose(Object obj, boolean flag);

    private native int nativeRead(Object obj, byte abyte0[], int i, int j);

    public void close()
    {
        super.close();
        if (a_java_lang_Object_fld != null)
        {
            nativeClose(a_java_lang_Object_fld, false);
        }
    }

    protected void finalize()
    {
        if (a_java_lang_Object_fld != null)
        {
            nativeClose(a_java_lang_Object_fld, true);
        }
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public boolean markSupported()
    {
        return false;
    }

    public int read()
    {
        byte abyte0[] = new byte[1];
        if (read(abyte0, 0, 1) == 1)
        {
            return abyte0[0];
        } else
        {
            return -1;
        }
    }

    public int read(byte abyte0[])
    {
        return nativeRead(a_java_lang_Object_fld, abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
    {
        return nativeRead(a_java_lang_Object_fld, abyte0, i, j);
    }

    public long skip(long l)
    {
        byte abyte0[] = new byte[(int)l];
        return (long)nativeRead(a_java_lang_Object_fld, abyte0, 0, abyte0.length);
    }
}
