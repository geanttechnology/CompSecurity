// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.gifencoder;

import java.io.IOException;

// Referenced classes of package com.picsart.studio.gifencoder:
//            GifError

public class GifIOException extends IOException
{

    private static final long serialVersionUID = 0xbdbbd5fa1b9L;
    public final GifError reason;

    GifIOException(int i)
    {
        this(GifError.fromCode(i));
    }

    private GifIOException(GifError giferror)
    {
        super(giferror.getFormattedDescription());
        reason = giferror;
    }

    static GifIOException fromCode(int i)
    {
        if (i == GifError.NO_ERROR.errorCode)
        {
            return null;
        } else
        {
            return new GifIOException(i);
        }
    }
}
