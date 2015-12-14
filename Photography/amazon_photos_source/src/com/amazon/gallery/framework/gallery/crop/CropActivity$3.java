// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.crop;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import uk.co.senab.photoview.PhotoViewAttacher;

// Referenced classes of package com.amazon.gallery.framework.gallery.crop:
//            CropActivity, CropBitmapAsyncTask, OverlayView

class this._cls0
    implements android.view.tener
{

    final CropActivity this$0;

    public void onClick(View view)
    {
        CropActivity.access$200(CropActivity.this).setEnabled(false);
        view = new CropBitmapAsyncTask(CropActivity.this, CropActivity.access$300(CropActivity.this), CropActivity.access$100(CropActivity.this).getCropRect());
        Bitmap bitmap = CropActivity.access$000(CropActivity.this).getVisibleRectangleBitmap();
        view.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[] {
            bitmap
        });
    }

    Task()
    {
        this$0 = CropActivity.this;
        super();
    }
}
