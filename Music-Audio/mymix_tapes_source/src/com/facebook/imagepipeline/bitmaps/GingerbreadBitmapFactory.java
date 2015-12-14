// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;

public class GingerbreadBitmapFactory
{

    private final ResourceReleaser mBitmapResourceReleaser = new ResourceReleaser() {

        final GingerbreadBitmapFactory this$0;

        public void release(Bitmap bitmap)
        {
            bitmap.recycle();
        }

        public volatile void release(Object obj)
        {
            release((Bitmap)obj);
        }

            
            {
                this$0 = GingerbreadBitmapFactory.this;
                super();
            }
    };

    public GingerbreadBitmapFactory()
    {
    }

    CloseableReference createBitmap(int i, int j)
    {
        return CloseableReference.of(Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888), mBitmapResourceReleaser);
    }
}
