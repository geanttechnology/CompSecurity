// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.graphics.Bitmap;
import com.groupon.util.MapUtils;
import com.squareup.picasso.Transformation;

// Referenced classes of package com.groupon.view:
//            MapSliceImprovedView

class val.url
    implements Transformation
{

    final MapSliceImprovedView this$0;
    final String val$url;

    public String key()
    {
        return val$url;
    }

    public Bitmap transform(Bitmap bitmap)
    {
        return MapUtils.drawMapWithGreenPin(getContext(), bitmap);
    }

    ()
    {
        this$0 = final_mapsliceimprovedview;
        val$url = String.this;
        super();
    }
}
