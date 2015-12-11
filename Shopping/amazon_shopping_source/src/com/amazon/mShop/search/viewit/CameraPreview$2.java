// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import java.util.Comparator;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            CameraPreview

class this._cls0
    implements Comparator
{

    final CameraPreview this$0;

    public int compare(zeAndRatio zeandratio, zeAndRatio zeandratio1)
    {
        return zeandratio1.size.ht - zeandratio.size.ht;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((zeAndRatio)obj, (zeAndRatio)obj1);
    }

    zeAndRatio()
    {
        this$0 = CameraPreview.this;
        super();
    }
}
