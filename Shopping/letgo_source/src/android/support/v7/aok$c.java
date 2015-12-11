// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            aok

public static class n extends RuntimeException
{

    public IOException a()
    {
        return (IOException)super.getCause();
    }

    public Throwable getCause()
    {
        return a();
    }

    protected n(IOException ioexception)
    {
        super(ioexception);
    }
}
