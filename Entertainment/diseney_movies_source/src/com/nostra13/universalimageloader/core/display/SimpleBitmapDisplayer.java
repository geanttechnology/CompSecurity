// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package com.nostra13.universalimageloader.core.display:
//            BitmapDisplayer

public final class SimpleBitmapDisplayer
    implements BitmapDisplayer
{

    public SimpleBitmapDisplayer()
    {
    }

    public Bitmap display(Bitmap bitmap, ImageView imageview)
    {
        imageview.setImageBitmap(bitmap);
        return bitmap;
    }
}
