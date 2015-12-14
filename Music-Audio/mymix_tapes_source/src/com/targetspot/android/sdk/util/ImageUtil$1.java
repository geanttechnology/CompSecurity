// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package com.targetspot.android.sdk.util:
//            ImageUtil

static final class ageHandler extends ageHandler
{

    final ImageView val$view;

    public void handleError(Throwable throwable)
    {
        throwable.printStackTrace();
    }

    public void handleImage(Bitmap bitmap)
    {
        if (val$view != null)
        {
            val$view.setImageBitmap(bitmap);
            val$view.requestLayout();
        }
    }

    ageHandler(ImageView imageview)
    {
        val$view = imageview;
        super();
    }
}
