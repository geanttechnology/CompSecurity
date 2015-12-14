// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import android.graphics.Bitmap;
import android.util.Log;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaJavaUndo

public static class 
{

    private static final String TAG = "MoaUndoBitmap";
    public Bitmap bitmap;
    public long ptr;

    public boolean isEmpty()
    {
        Log.d("MoaUndoBitmap", String.format("ptr: 0x%x, bitmap: %s", new Object[] {
            Long.valueOf(ptr), bitmap
        }));
        return bitmap == null;
    }

    public String toString()
    {
        return String.format("MoaUndoBitmap{ptr:0x%x, bitmap:%s}", new Object[] {
            Long.valueOf(ptr), bitmap
        });
    }

    public ()
    {
    }
}
