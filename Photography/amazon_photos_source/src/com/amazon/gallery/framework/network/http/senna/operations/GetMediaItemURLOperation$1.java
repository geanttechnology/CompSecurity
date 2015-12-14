// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations;

import com.amazon.gallery.foundation.image.ImageUtils;
import java.util.Comparator;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.network.http.senna.operations:
//            GetMediaItemURLOperation

class this._cls0
    implements Comparator
{

    final GetMediaItemURLOperation this$0;

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Map)obj, (Map)obj1);
    }

    public int compare(Map map, Map map1)
    {
        return ImageUtils.objectToInt(map.get("width")) - ImageUtils.objectToInt(map1.get("width"));
    }

    ()
    {
        this$0 = GetMediaItemURLOperation.this;
        super();
    }
}
