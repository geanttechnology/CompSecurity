// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.audio;

import com.amazon.blueshift.bluefront.android.SpeechClientException;

public class AudioEncoderException extends SpeechClientException
{

    private static final long serialVersionUID = 0xc842b01a61b23d60L;

    public AudioEncoderException(String s)
    {
        super(s);
    }

    public AudioEncoderException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public AudioEncoderException(Throwable throwable)
    {
        super(throwable);
    }
}
