// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.extractors;


// Referenced classes of package com.rdio.android.audioplayer.extractors:
//            AacExtractor

private static class A
{

    public static final long CO64 = 0x636f3634L;
    public static final long DINF = 0x64696e66L;
    public static final long ESDS = 0x65736473L;
    public static final long FTYP = 0x66747970L;
    public static final long HDLR = 0x68646c72L;
    public static final long MDAT = 0x6d646174L;
    public static final long MDHD = 0x6d646864L;
    public static final long MDIA = 0x6d646961L;
    public static final long MINF = 0x6d696e66L;
    public static final long MOOV = 0x6d6f6f76L;
    public static final long MP4A = 0x6d703461L;
    public static final long MVHD = 0x6d766864L;
    public static final long NONE = 0L;
    public static final long SMHD = 0x736d6864L;
    public static final long STBL = 0x7374626cL;
    public static final long STCO = 0x7374636fL;
    public static final long STSC = 0x73747363L;
    public static final long STSD = 0x73747364L;
    public static final long STSZ = 0x7374737aL;
    public static final long STTS = 0x73747473L;
    public static final long TKHD = 0x746b6864L;
    public static final long TRAK = 0x7472616bL;
    public static final long UUID = 0x75756964L;
    public final long DREF = 0x64726566L;

    public static String toString(long l)
    {
        if (l == 0L)
        {
            return "Unknown/Unsupported";
        }
        if (l == 0x75756964L)
        {
            return "uuid (unsupported)";
        }
        char ac[] = new char[4];
        for (int i = 3; i >= 0; i--)
        {
            ac[3 - i] = (char)(int)(l >> i * 8 & 255L);
        }

        return new String(ac);
    }

    private A()
    {
    }
}
