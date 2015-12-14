// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.instabeauty.application.InstaBeautyApplication;
import yp;

public class FlexibleThumbSeekbar extends SeekBar
{

    public FlexibleThumbSeekbar(Context context)
    {
        super(context);
    }

    public FlexibleThumbSeekbar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = BitmapFactory.decodeResource(getResources(), 0x7f020083);
        attributeset = Bitmap.createBitmap(yp.a(InstaBeautyApplication.a, 30F), yp.a(InstaBeautyApplication.a, 30F), android.graphics.Bitmap.Config.ARGB_8888);
        (new Canvas(attributeset)).drawBitmap(context, new Rect(0, 0, context.getWidth(), context.getHeight()), new Rect(0, 0, attributeset.getWidth(), attributeset.getHeight()), null);
        setThumb(new BitmapDrawable(getResources(), attributeset));
    }
}
