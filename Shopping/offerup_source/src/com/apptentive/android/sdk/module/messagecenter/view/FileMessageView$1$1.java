// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter.view;

import android.graphics.Bitmap;
import android.widget.ImageView;

class val.imageBitmap
    implements Runnable
{

    final l.imageView this$1;
    final Bitmap val$imageBitmap;

    public void run()
    {
        imageView.setImageBitmap(val$imageBitmap);
        imageView.setPadding(0, 0, 0, 0);
        imageView.setVisibility(0);
    }

    ()
    {
        this$1 = final_;
        val$imageBitmap = Bitmap.this;
        super();
    }
}
