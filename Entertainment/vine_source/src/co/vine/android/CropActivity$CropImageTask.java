// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.ImageView;
import co.vine.android.client.AppController;
import co.vine.android.util.image.ImageUtils;
import co.vine.android.widget.CroppableImageView;
import java.io.ByteArrayOutputStream;

// Referenced classes of package co.vine.android:
//            CropActivity

private static class mCropRect extends AsyncTask
{

    CropActivity mActivity;
    final int mBitmapHeight;
    final int mBitmapHeightOffset;
    final int mBitmapWidth;
    final int mBitmapWidthOffset;
    final Context mContext;
    final Rect mCropRect;
    final int mFileToViewScale;
    final Intent mIntent = new Intent();
    final Uri mUri;
    ImageView mView;
    Bitmap mViewBitmap;

    private Boolean basicCrop()
    {
        Object obj = mContext;
        Rect rect = mCropRect;
        Object obj1 = mViewBitmap;
        if (obj1 == null)
        {
            return Boolean.FALSE;
        }
        Rect rect1 = new Rect(0, 0, ((Bitmap) (obj1)).getWidth(), ((Bitmap) (obj1)).getHeight());
        int i = rect.height();
        if (rect.width() <= 1 || i <= 1)
        {
            return Boolean.FALSE;
        }
        if (rect1.contains(rect))
        {
            obj1 = ImageUtils.createBitmap(((Context) (obj)), ((Bitmap) (obj1)), rect.left, rect.top, rect.width(), rect.height());
            if (obj1 != null)
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                ((Bitmap) (obj1)).compress(android.graphics.Bitmap, 100, bytearrayoutputstream);
                obj1 = ImageUtils.resizeBitmap(((Context) (obj)), bytearrayoutputstream.toByteArray(), 200, 200);
                if (obj1 != null && ((co.vine.android.util.image.) (obj1)).p != null)
                {
                    long l = AppController.getInstance(((Context) (obj))).getActiveId();
                    obj = ImageUtils.writePicToFile(((Context) (obj)), ((co.vine.android.util.image.p) (obj1)).p, l);
                    if (obj != null)
                    {
                        int j = mFileToViewScale;
                        rect.set(rect.left * j, rect.top * j, (rect.right - mBitmapWidthOffset) * j, (rect.bottom - mBitmapHeightOffset) * j);
                        mIntent.putExtra("cropped_rect", rect);
                        mIntent.putExtra("uri", ((android.os.Parcelable) (obj)));
                        return Boolean.TRUE;
                    }
                }
            }
        }
        return Boolean.FALSE;
    }

    public void attachActivity(CropActivity cropactivity)
    {
        mActivity = cropactivity;
    }

    public void detachActivity()
    {
        mActivity = null;
        mView = null;
    }

    protected transient Boolean doInBackground(Void avoid[])
    {
        avoid = mContext;
        return basicCrop();
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Boolean boolean1)
    {
        if (mActivity != null)
        {
            mActivity.removeDialog(0);
            mActivity.onCropDone(boolean1.booleanValue(), mIntent);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    protected void onPreExecute()
    {
        ImageView imageview = mView;
        if (mActivity != null && imageview != null && imageview.getDrawable() != null)
        {
            mViewBitmap = ((BitmapDrawable)imageview.getDrawable()).getBitmap();
            mActivity.showDialog(0);
        }
    }

    pInfo(CropActivity cropactivity)
    {
        mActivity = cropactivity;
        mContext = cropactivity.getApplicationContext();
        mFileToViewScale = cropactivity.mFileToViewScale;
        mBitmapWidthOffset = cropactivity.mBitmapWidthOffset;
        mBitmapHeightOffset = cropactivity.mBitmapHeightOffset;
        mBitmapHeight = cropactivity.mBitmapHeight;
        mBitmapWidth = cropactivity.mBitmapWidth;
        mUri = cropactivity.mUri;
        mView = cropactivity.mView;
        cropactivity = ((CroppableImageView)mView).getCropRect();
        mCropRect = new Rect((int)((RectF) (cropactivity)).left, (int)((RectF) (cropactivity)).top, (int)((RectF) (cropactivity)).right, (int)((RectF) (cropactivity)).bottom);
    }
}
