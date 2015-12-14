// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.memory.BitmapCounter;

// Referenced classes of package com.facebook.imagepipeline.bitmaps:
//            DalvikBitmapFactory

class this._cls0
    implements ResourceReleaser
{

    final DalvikBitmapFactory this$0;

    public void release(Bitmap bitmap)
    {
        DalvikBitmapFactory.access$000(DalvikBitmapFactory.this).decrease(bitmap);
        bitmap.recycle();
        return;
        Exception exception;
        exception;
        bitmap.recycle();
        throw exception;
    }

    public volatile void release(Object obj)
    {
        release((Bitmap)obj);
    }

    ()
    {
        this$0 = DalvikBitmapFactory.this;
        super();
    }
}
