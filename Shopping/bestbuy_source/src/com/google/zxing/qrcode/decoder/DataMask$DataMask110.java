// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;


// Referenced classes of package com.google.zxing.qrcode.decoder:
//            DataMask

final class <init> extends DataMask
{

    boolean isMasked(int i, int j)
    {
        i *= j;
        return (i % 3 + (i & 1) & 1) == 0;
    }

    private ()
    {
        super(null);
    }

    ( )
    {
        this();
    }
}
