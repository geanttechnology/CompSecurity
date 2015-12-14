// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;

// Referenced classes of package com.facebook.imagepipeline.bitmaps:
//            GingerbreadBitmapFactory

class this._cls0
    implements ResourceReleaser
{

    final GingerbreadBitmapFactory this$0;

    public void release(Bitmap bitmap)
    {
        bitmap.recycle();
    }

    public volatile void release(Object obj)
    {
        release((Bitmap)obj);
    }

    ()
    {
        this$0 = GingerbreadBitmapFactory.this;
        super();
    }
}
