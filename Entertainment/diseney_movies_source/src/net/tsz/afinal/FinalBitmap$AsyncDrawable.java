// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

// Referenced classes of package net.tsz.afinal:
//            FinalBitmap

private static class bitmapWorkerTaskReference extends BitmapDrawable
{

    private final WeakReference bitmapWorkerTaskReference;

    public isplayTask getBitmapWorkerTask()
    {
        return (isplayTask)bitmapWorkerTaskReference.get();
    }

    public isplayTask(Resources resources, Bitmap bitmap, isplayTask isplaytask)
    {
        super(resources, bitmap);
        bitmapWorkerTaskReference = new WeakReference(isplaytask);
    }
}
