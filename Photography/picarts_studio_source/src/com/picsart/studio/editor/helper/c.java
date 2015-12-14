// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.helper;

import android.graphics.Bitmap;
import com.socialin.android.photo.imgop.ImageOp;
import java.nio.ByteBuffer;

public final class c
{

    private ByteBuffer a;
    private ByteBuffer b;
    private Bitmap c;
    private Bitmap d;

    public c(Bitmap bitmap, Bitmap bitmap1)
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

    public final void a(int i, int j, int k)
    {
        a.position(0);
        b.position(0);
        ImageOp.customenhance4buf(a, b, c.getWidth(), c.getHeight(), d.getWidth(), d.getHeight(), (float)i / 100F, (float)j / 100F + 1.0F, k, false, -1);
        b.position(0);
        d.copyPixelsFromBuffer(b);
    }
}
