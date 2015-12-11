// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.zip.CRC32;
import java.util.zip.Checksum;

final class ema extends elz
{

    ema(String s, int i, int j)
    {
        super(s, 0, 32);
    }

    public final Checksum a()
    {
        return new CRC32();
    }

    public final Object get()
    {
        return new CRC32();
    }
}
