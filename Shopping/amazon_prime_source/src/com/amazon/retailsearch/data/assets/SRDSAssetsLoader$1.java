// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.assets;

import android.graphics.Bitmap;
import com.amazon.ansel.fetch.AbstractResourceListener;
import java.util.Map;

// Referenced classes of package com.amazon.retailsearch.data.assets:
//            SRDSAssetsLoader

class val.badgeId extends AbstractResourceListener
{

    final SRDSAssetsLoader this$0;
    final String val$badgeId;

    public void error(Throwable throwable)
    {
        SRDSAssetsLoader.access$202(SRDSAssetsLoader.this, true);
    }

    public void result(Bitmap bitmap)
    {
        SRDSAssetsLoader.access$300(SRDSAssetsLoader.this).put(val$badgeId, bitmap);
    }

    public volatile void result(Object obj)
    {
        result((Bitmap)obj);
    }

    ()
    {
        this$0 = final_srdsassetsloader;
        val$badgeId = String.this;
        super();
    }
}
