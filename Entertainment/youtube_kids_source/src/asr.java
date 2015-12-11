// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;

public final class asr extends IOException
{

    public asr(long l, long l1)
    {
        super((new StringBuilder(57)).append("Expected: ").append(l).append(", got: ").append(l1).toString());
    }
}
