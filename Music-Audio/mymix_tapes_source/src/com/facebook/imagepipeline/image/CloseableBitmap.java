// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;

// Referenced classes of package com.facebook.imagepipeline.image:
//            CloseableImage

public abstract class CloseableBitmap extends CloseableImage
{

    public CloseableBitmap()
    {
    }

    public abstract Bitmap getUnderlyingBitmap();
}
