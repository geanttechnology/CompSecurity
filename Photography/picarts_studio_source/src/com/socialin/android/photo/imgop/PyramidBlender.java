// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.imgop;

import java.nio.ByteBuffer;

public class PyramidBlender
{

    public PyramidBlender()
    {
    }

    public static native void putOverlay(ByteBuffer bytebuffer, int i, int j, ByteBuffer bytebuffer1, int k, int l, ByteBuffer bytebuffer2, int i1, 
            int j1, int k1, int l1, int i2, int j2);

    public native void blend(ByteBuffer bytebuffer);

    public native void feed(ByteBuffer bytebuffer, int i, int j, int k, int l);

    public native void prepare(int i, int j, int k);
}
