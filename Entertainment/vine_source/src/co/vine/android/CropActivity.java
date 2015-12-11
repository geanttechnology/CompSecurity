// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import co.vine.android.client.AppController;
import co.vine.android.util.image.ImageUtils;
import co.vine.android.widget.CroppableImageView;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity

public class CropActivity extends BaseControllerActionBarActivity
    implements android.content.DialogInterface.OnCancelListener
{
    private static class CropImageTask extends AsyncTask
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
                    ((Bitmap) (obj1)).compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
                    obj1 = ImageUtils.resizeBitmap(((Context) (obj)), bytearrayoutputstream.toByteArray(), 200, 200);
                    if (obj1 != null && ((co.vine.android.util.image.ImageUtils.BitmapInfo) (obj1)).bitmap != null)
                    {
                        long l = AppController.getInstance(((Context) (obj))).getActiveId();
                        obj = ImageUtils.writePicToFile(((Context) (obj)), ((co.vine.android.util.image.ImageUtils.BitmapInfo) (obj1)).bitmap, l);
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

        CropImageTask(CropActivity cropactivity)
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

    class LoadImageTask extends AsyncTask
    {

        private final WeakReference mActivity;
        final CropActivity this$0;

        protected transient Bitmap doInBackground(Void avoid[])
        {
            avoid = getResources().getDisplayMetrics();
            avoid = ImageUtils.safeDecode(CropActivity.this, mUri, ((DisplayMetrics) (avoid)).widthPixels, ((DisplayMetrics) (avoid)).heightPixels, true);
            if (avoid != null)
            {
                int i = ((co.vine.android.util.image.ImageUtils.BitmapInfo) (avoid)).scale;
                mBitmapWidth = ((co.vine.android.util.image.ImageUtils.BitmapInfo) (avoid)).origWidth;
                mBitmapHeight = ((co.vine.android.util.image.ImageUtils.BitmapInfo) (avoid)).origHeight;
                mBitmapWidthOffset = ((co.vine.android.util.image.ImageUtils.BitmapInfo) (avoid)).origWidth % i;
                mBitmapHeightOffset = ((co.vine.android.util.image.ImageUtils.BitmapInfo) (avoid)).origHeight % i;
                mFileToViewScale = i;
                return ((co.vine.android.util.image.ImageUtils.BitmapInfo) (avoid)).bitmap;
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

        LoadImageTask(CropActivity cropactivity1)
        {
            this$0 = CropActivity.this;
            super();
            mActivity = new WeakReference(cropactivity1);
            mBitmapLoaded = false;
        }
    }


    private static final int DIALOG_CROPPING_PROGRESS_ID = 0;
    private static final int DIALOG_LOADING_PROGRESS_ID = 1;
    public static final String EXTRA_CROP_RECT = "cropped_rect";
    public static final String EXTRA_CROP_TYPE = "crop_type";
    public static final String EXTRA_URI = "uri";
    private static final String STATE_DEGREES = "degrees";
    int mBitmapHeight;
    int mBitmapHeightOffset;
    protected boolean mBitmapLoaded;
    int mBitmapWidth;
    int mBitmapWidthOffset;
    protected CropImageTask mCropTask;
    private int mCurrDegrees;
    int mFileToViewScale;
    protected Uri mUri;
    protected CroppableImageView mView;

    public CropActivity()
    {
    }

    protected void doCrop()
    {
        if (!mBitmapLoaded)
        {
            return;
        }
        if (mCropTask != null)
        {
            mCropTask.detachActivity();
        }
        mCropTask = new CropImageTask(this);
        mCropTask.execute(new Void[0]);
    }

    protected void onBitmapProcessingDone(Bitmap bitmap)
    {
        mView.setVisibility(0);
        mView.setImageBitmap(bitmap);
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        setResult(0);
        finish();
    }

    public void onClickHandler(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361993: 
            doCrop();
            return;

        case 2131361992: 
            setResult(0);
            finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle, int i)
    {
        super.onCreate(bundle, i, false);
        mUri = (Uri)getIntent().getParcelableExtra("uri");
        mView = (CroppableImageView)findViewById(0x7f0a0046);
        mView.setVisibility(4);
        if (bundle != null)
        {
            mCurrDegrees = bundle.getInt("degrees", 0);
        } else
        {
            mCurrDegrees = 0;
        }
        mCropTask = (CropImageTask)getLastCustomNonConfigurationInstance();
        if (mCropTask == null)
        {
            (new LoadImageTask(this)).execute(new Void[0]);
            return;
        } else
        {
            mCropTask.attachActivity(this);
            return;
        }
    }

    protected Dialog onCreateDialog(int i)
    {
        ProgressDialog progressdialog = new ProgressDialog(this, 0x7f0f0037);
        progressdialog.setProgressStyle(0);
        progressdialog.setCanceledOnTouchOutside(false);
        progressdialog.setOnCancelListener(this);
        switch (i)
        {
        default:
            return super.onCreateDialog(i);

        case 0: // '\0'
            progressdialog.setMessage(getString(0x7f0e00a6));
            return progressdialog;

        case 1: // '\001'
            progressdialog.setMessage(getString(0x7f0e011d));
            break;
        }
        return progressdialog;
    }

    public void onCropDone(boolean flag, Intent intent)
    {
        if (flag)
        {
            setResult(-1, intent);
        } else
        {
            Toast.makeText(this, 0x7f0e00a7, 1).show();
            setResult(0);
        }
        finish();
    }

    protected void onPause()
    {
        super.onPause();
        removeDialog(0);
        removeDialog(1);
    }

    public Object onRetainCustomNonConfigurationInstance()
    {
        if (mCropTask != null)
        {
            mCropTask.detachActivity();
        }
        return mCropTask;
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("degrees", mCurrDegrees);
    }

    public boolean onSearchRequested()
    {
        return false;
    }
}
