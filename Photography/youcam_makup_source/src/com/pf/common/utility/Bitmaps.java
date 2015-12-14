// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import android.graphics.Bitmap;
import com.pf.common.a;
import java.nio.ByteBuffer;

public final class Bitmaps
{

    public static final android.graphics.BitmapFactory.Options a;

    public static boolean a(Bitmap bitmap)
    {
        return bitmap != null && !bitmap.isRecycled();
    }

    public static native ByteBuffer lockPixels(Bitmap bitmap);

    public static native void unlockPixels(Bitmap bitmap);

    static 
    {
        a = new android.graphics.BitmapFactory.Options();
        a.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        com.pf.common.a.b();
    }
}
