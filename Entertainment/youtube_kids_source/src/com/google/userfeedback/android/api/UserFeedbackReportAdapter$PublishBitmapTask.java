// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackReportAdapter

class width extends AsyncTask
{

    private int height;
    private final WeakReference imageViewReference;
    final UserFeedbackReportAdapter this$0;
    private int width;

    protected transient Bitmap doInBackground(width awidth[])
    {
        return UserFeedbackReportAdapter.access$000(UserFeedbackReportAdapter.this, awidth[0]._fld0, width, height);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((doInBackground[])aobj);
    }

    protected void onPostExecute(Bitmap bitmap)
    {
        if (imageViewReference != null && bitmap != null)
        {
            ImageView imageview = (ImageView)imageViewReference.get();
            if (imageview != null)
            {
                imageview.setImageBitmap(bitmap);
            }
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Bitmap)obj);
    }

    public (ImageView imageview)
    {
        this$0 = UserFeedbackReportAdapter.this;
        super();
        height = 0;
        width = 0;
        imageViewReference = new WeakReference(imageview);
        height = imageview.getHeight();
        width = imageview.getWidth();
    }
}
