// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.cameralibrary;

import java.util.Comparator;

// Referenced classes of package com.a9.cameralibrary:
//            A9CameraPreview

class this._cls0
    implements Comparator
{

    final A9CameraPreview this$0;

    public int compare(zeAndRatio zeandratio, zeAndRatio zeandratio1)
    {
        return zeandratio1.size. - zeandratio.size.;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((zeAndRatio)obj, (zeAndRatio)obj1);
    }

    zeAndRatio()
    {
        this$0 = A9CameraPreview.this;
        super();
    }
}
