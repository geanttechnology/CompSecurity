// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.graphics.Matrix;
import android.os.Handler;
import android.util.Log;
import it.sephiroth.android.library.imagezoom.graphics.IBitmapDrawable;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            CropImageView, HighlightView

class this._cls0
    implements Runnable
{

    final CropImageView this$0;

    public void run()
    {
label0:
        {
            android.graphics.drawable.Drawable drawable = getDrawable();
            if (drawable != null && ((IBitmapDrawable)drawable).getBitmap() != null && CropImageView.access$000(CropImageView.this) != null)
            {
                if (!CropImageView.access$000(CropImageView.this).isRunning())
                {
                    break label0;
                }
                mHandler.post(this);
            }
            return;
        }
        Log.d("ImageViewTouchBase", "onLayoutRunnable.. running");
        CropImageView.access$000(CropImageView.this).getMatrix().set(getImageMatrix());
        CropImageView.access$000(CropImageView.this).invalidate();
    }

    pDrawable()
    {
        this$0 = CropImageView.this;
        super();
    }
}
