// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.e;

import java.io.IOException;

public final class i extends RuntimeException
{

    protected i(IOException ioexception)
    {
        super(ioexception);
    }

    public final volatile Throwable getCause()
    {
        return (IOException)super.getCause();
    }
}
