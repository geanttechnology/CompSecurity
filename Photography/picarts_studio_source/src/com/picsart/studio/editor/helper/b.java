// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.helper;

import android.graphics.Bitmap;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class b
{

    private ByteBuffer a;
    private ByteBuffer b;
    private Bitmap c;
    private Bitmap d;

    public b(Bitmap bitmap, Bitmap bitmap1)
    {
        c = bitmap;
        d = bitmap1;
        a = ImageOp.a(bitmap.getHeight() * bitmap.getRowBytes());
        b = ImageOp.a(bitmap1.getHeight() * bitmap1.getRowBytes());
        bitmap.copyPixelsToBuffer(a);
    }

    public final void a()
    {
        ImageOp.a(a);
        ImageOp.a(b);
    }

    public final void a(int ai[], int ai1[], int ai2[], int ai3[])
    {
        ai = Arrays.copyOf(ai, ai.length);
        ai1 = Arrays.copyOf(ai1, ai1.length);
        ai2 = Arrays.copyOf(ai2, ai2.length);
        ai3 = Arrays.copyOf(ai3, ai3.length);
        a.position(0);
        b.position(0);
        ImageOpCommon.changeChannelsWithCurve(a, b, c.getWidth(), c.getHeight(), ai, ai1, ai2, ai3);
        b.position(0);
        d.copyPixelsFromBuffer(b);
    }
}
