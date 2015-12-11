// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.recognition;


public class Signature
{

    public final long sampleMilliseconds;
    public final String uri;

    public Signature(long l, String s)
    {
        sampleMilliseconds = l;
        uri = (new StringBuilder("data:audio/vnd.shazam.sig;base64,")).append(s).toString();
    }

    public long getSampleMilliseconds()
    {
        return sampleMilliseconds;
    }
}
