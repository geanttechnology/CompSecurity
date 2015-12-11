// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.vad;

import com.amazon.blueshift.bluefront.android.SpeechClientException;

public class VADException extends SpeechClientException
{

    private static final long serialVersionUID = 0xa894dbb6176181ebL;

    public VADException(String s)
    {
        super(s);
    }

    public VADException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public VADException(Throwable throwable)
    {
        super(throwable);
    }
}
