// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.widget.Toast;
import co.vine.android.util.image.ImageUtils;
import java.lang.ref.WeakReference;

// Referenced classes of package co.vine.android:
//            CropActivity

class mActivity extends AsyncTask
{

    private final WeakReference mActivity;
    final CropActivity this$0;

    protected transient Bitmap doInBackground(Void avoid[])
    {
        avoid = getResources().getDisplayMetrics();
        avoid = ImageUtils.safeDecode(CropActivity.this, mUri, ((DisplayMetrics) (avoid)).widthPixels, ((DisplayMetrics) (avoid)).heightPixels, true);
        if (avoid != null)
        {
            int i = ((co.vine.android.util.image.his._cls0_20__11_) (avoid)).;
            mBitmapWidth = ((co.vine.android.util.image.) (avoid)).idth;
            mBitmapHeight = ((co.vine.android.util.image.idth) (avoid)).eight;
            mBitmapWidthOffset = ((co.vine.android.util.image.eight) (avoid)).idth % i;
            mBitmapHeightOffset = ((co.vine.android.util.image.idth) (avoid)).eight % i;
            mFileToViewScale = i;
            return ((co.vine.android.util.image.eight) (avoid)).p;
        } else
        {
            return null;
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Bitmap bitmap)
    {
        CropActivity cropactivity = (CropActivity)mActivity.get();
        if (cropactivity == null)
        {
            return;
        }
        if (bitmap != null)
        {
            cropactivity.mBitmapLoaded = true;
            cropactivity.onBitmapProcessingDone(bitmap);
        } else
        {
            Toast.makeText(CropActivity.this, 0x7f0e0119, 1).show();
            removeDialog(1);
            setResult(0);
            finish();
        }
        removeDialog(1);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Bitmap)obj);
    }

    protected void onPreExecute()
    {
        showDialog(1);
    }

    pInfo(CropActivity cropactivity1)
    {
        this$0 = CropActivity.this;
        super();
        mActivity = new WeakReference(cropactivity1);
        mBitmapLoaded = false;
    }
}
