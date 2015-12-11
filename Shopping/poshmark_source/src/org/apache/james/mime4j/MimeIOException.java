// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j;

import java.io.IOException;

// Referenced classes of package org.apache.james.mime4j:
//            MimeException

public class MimeIOException extends IOException
{

    private static final long serialVersionUID = 0x4ad9f6dd674625f1L;

    public MimeIOException(MimeException mimeexception)
    {
        String s;
        if (mimeexception == null)
        {
            s = null;
        } else
        {
            s = mimeexception.getMessage();
        }
        super(s);
        initCause(mimeexception);
    }

    public volatile Throwable getCause()
    {
        return getCause();
    }

    public MimeException getCause()
    {
        return (MimeException)super.getCause();
    }
}
