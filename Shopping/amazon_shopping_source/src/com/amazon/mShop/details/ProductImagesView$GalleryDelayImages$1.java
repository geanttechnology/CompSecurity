// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.graphics.Bitmap;
import com.amazon.mShop.ui.DrawableFactory;
import java.util.List;

// Referenced classes of package com.amazon.mShop.details:
//            ProductImagesView

class this._cls1
    implements com.amazon.mShop.net.s._cls1
{

    final onHttpResponseReceived this$1;

    public void onHttpRequestFailed(com.amazon.mShop.net.s._cls1 _pcls1)
    {
    }

    public void onHttpResponseReceived(Bitmap bitmap, com.amazon.mShop.net.s._cls1 _pcls1)
    {
        if (!cess._mth1400(this._cls1.this))
        {
            bitmap = DrawableFactory.getInstance().createDrawable(getResources(), bitmap, _pcls1);
            cess._mth000(this._cls1.this).add(bitmap);
            ImageReceived(bitmap, 0);
        }
    }

    public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net.s._cls1 _pcls1)
    {
        onHttpResponseReceived((Bitmap)obj, _pcls1);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
