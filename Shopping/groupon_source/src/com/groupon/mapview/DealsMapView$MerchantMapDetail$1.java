// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;

import android.widget.ImageView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.groupon.mapview:
//            DealsMapView

class this._cls1
    implements Callback
{

    final rker this$1;

    public void onError(ImageView imageview)
    {
    }

    public void onSuccess(ImageView imageview)
    {
        if (stener != null)
        {
            stener.onImageLoaded(rker);
        }
    }

    dListener()
    {
        this$1 = this._cls1.this;
        super();
    }
}
