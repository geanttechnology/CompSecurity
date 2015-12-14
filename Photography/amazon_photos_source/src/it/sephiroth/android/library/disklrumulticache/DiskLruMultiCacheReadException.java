// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.disklrumulticache;


public class DiskLruMultiCacheReadException extends Exception
{

    private static final long serialVersionUID = -1L;
    private Throwable ex;

    public DiskLruMultiCacheReadException()
    {
        super((Throwable)null);
    }

    public DiskLruMultiCacheReadException(String s)
    {
        super(s, null);
    }

    public DiskLruMultiCacheReadException(String s, Throwable throwable)
    {
        super(s);
        ex = throwable;
    }

    public DiskLruMultiCacheReadException(Throwable throwable)
    {
        String s;
        if (throwable == null)
        {
            s = null;
        } else
        {
            s = throwable.toString();
        }
        super(s, throwable);
    }

    public Throwable getCause()
    {
        return ex;
    }

    public Throwable getException()
    {
        return ex;
    }
}
