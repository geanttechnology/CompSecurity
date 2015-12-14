// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.graphics.Bitmap;
import android.widget.ImageView;
import uk.co.senab.photoview.PhotoView;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SlideShowFragment

class this._cls1
    implements com.amazon.gallery.framework.gallery.widget.holder.
{

    final is._cls0 this$1;

    public void onResourceReady(ImageView imageview, Bitmap bitmap)
    {
        if (imageview instanceof PhotoView)
        {
            SlideShowFragment.access$200(_fld0, (PhotoView)imageview, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
