// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.crop;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.soundcloud.android.crop.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.soundcloud.android.crop:
//            MonitoredActivity, CropUtil, CropImageView, RotateBitmap, 
//            HighlightView

public class CropImageActivity extends MonitoredActivity
{
    private class Cropper
    {

        final CropImageActivity this$0;

        private void makeDefault()
        {
            boolean flag1 = false;
            if (rotateBitmap == null)
            {
                return;
            }
            HighlightView highlightview = new HighlightView(imageView);
            int j1 = rotateBitmap.getWidth();
            int i1 = rotateBitmap.getHeight();
            Rect rect = new Rect(0, 0, j1, i1);
            int k = (Math.min(j1, i1) * 4) / 5;
            int l = k;
            int i = l;
            int j = k;
            if (aspectX != 0)
            {
                i = l;
                j = k;
                RectF rectf;
                Matrix matrix;
                boolean flag;
                if (aspectY != 0)
                {
                    if (aspectX > aspectY)
                    {
                        i = (aspectY * k) / aspectX;
                        j = k;
                    } else
                    {
                        j = (aspectX * l) / aspectY;
                        i = l;
                    }
                }
            }
            k = (j1 - j) / 2;
            l = (i1 - i) / 2;
            rectf = new RectF(k, l, k + j, l + i);
            matrix = imageView.getUnrotatedMatrix();
            flag = flag1;
            if (aspectX != 0)
            {
                flag = flag1;
                if (aspectY != 0)
                {
                    flag = true;
                }
            }
            highlightview.setup(matrix, rect, rectf, flag);
            imageView.add(highlightview);
        }

        public void crop()
        {
            handler.post(new Runnable() {

                final Cropper this$1;

                public void run()
                {
                    makeDefault();
                    imageView.invalidate();
                    if (imageView.highlightViews.size() == 1)
                    {
                        cropView = (HighlightView)imageView.highlightViews.get(0);
                        cropView.setFocus(true);
                    }
                }

            
            {
                this$1 = Cropper.this;
                super();
            }
            });
        }


        private Cropper()
        {
            this$0 = CropImageActivity.this;
            super();
        }

    }


    private static final boolean IN_MEMORY_CROP;
    private static final int SIZE_DEFAULT = 2048;
    private static final int SIZE_LIMIT = 4096;
    private int aspectX;
    private int aspectY;
    private HighlightView cropView;
    private int exifRotation;
    private final Handler handler = new Handler();
    private CropImageView imageView;
    private boolean isSaving;
    private int maxX;
    private int maxY;
    private RotateBitmap rotateBitmap;
    private int sampleSize;
    private Uri saveUri;
    private Uri sourceUri;

    public CropImageActivity()
    {
    }

    private int calculateBitmapSampleSize(Uri uri)
        throws IOException
    {
        Uri uri1;
        android.graphics.BitmapFactory.Options options;
        uri1 = null;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        uri = getContentResolver().openInputStream(uri);
        uri1 = uri;
        BitmapFactory.decodeStream(uri, null, options);
        int i;
        CropUtil.closeSilently(uri);
        int j = getMaxImageSize();
        for (i = 1; options.outHeight / i > j || options.outWidth / i > j; i <<= 1) { }
        break MISSING_BLOCK_LABEL_86;
        uri;
        CropUtil.closeSilently(uri1);
        throw uri;
        return i;
    }

    private void clearImageView()
    {
        imageView.clear();
        if (rotateBitmap != null)
        {
            rotateBitmap.recycle();
        }
        System.gc();
    }

    private Bitmap decodeRegionCrop(Bitmap bitmap, Rect rect)
    {
        float f1;
        java.io.InputStream inputstream;
        java.io.InputStream inputstream1;
        java.io.InputStream inputstream2;
        f1 = 0.0F;
        clearImageView();
        inputstream2 = null;
        inputstream = null;
        inputstream1 = null;
        java.io.InputStream inputstream3 = getContentResolver().openInputStream(sourceUri);
        inputstream1 = inputstream3;
        inputstream2 = inputstream3;
        inputstream = inputstream3;
        BitmapRegionDecoder bitmapregiondecoder = BitmapRegionDecoder.newInstance(inputstream3, false);
        inputstream1 = inputstream3;
        inputstream2 = inputstream3;
        inputstream = inputstream3;
        int i = bitmapregiondecoder.getWidth();
        inputstream1 = inputstream3;
        inputstream2 = inputstream3;
        inputstream = inputstream3;
        int j = bitmapregiondecoder.getHeight();
        Object obj;
        obj = rect;
        inputstream1 = inputstream3;
        inputstream2 = inputstream3;
        inputstream = inputstream3;
        if (exifRotation == 0)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        inputstream1 = inputstream3;
        inputstream2 = inputstream3;
        inputstream = inputstream3;
        obj = new Matrix();
        inputstream1 = inputstream3;
        inputstream2 = inputstream3;
        inputstream = inputstream3;
        ((Matrix) (obj)).setRotate(-exifRotation);
        inputstream1 = inputstream3;
        inputstream2 = inputstream3;
        inputstream = inputstream3;
        RectF rectf = new RectF();
        inputstream1 = inputstream3;
        inputstream2 = inputstream3;
        inputstream = inputstream3;
        ((Matrix) (obj)).mapRect(rectf, new RectF(rect));
        inputstream1 = inputstream3;
        inputstream2 = inputstream3;
        inputstream = inputstream3;
        float f;
        if (rectf.left < 0.0F)
        {
            f = i;
        } else
        {
            f = 0.0F;
        }
        inputstream1 = inputstream3;
        inputstream2 = inputstream3;
        inputstream = inputstream3;
        if (rectf.top < 0.0F)
        {
            f1 = j;
        }
        inputstream1 = inputstream3;
        inputstream2 = inputstream3;
        inputstream = inputstream3;
        rectf.offset(f, f1);
        inputstream1 = inputstream3;
        inputstream2 = inputstream3;
        inputstream = inputstream3;
        obj = new Rect((int)rectf.left, (int)rectf.top, (int)rectf.right, (int)rectf.bottom);
        inputstream1 = inputstream3;
        inputstream2 = inputstream3;
        inputstream = inputstream3;
        rect = bitmapregiondecoder.decodeRegion(((Rect) (obj)), new android.graphics.BitmapFactory.Options());
        CropUtil.closeSilently(inputstream3);
        return rect;
        rect;
        inputstream1 = inputstream3;
        inputstream2 = inputstream3;
        inputstream = inputstream3;
        throw new IllegalArgumentException((new StringBuilder()).append("Rectangle ").append(obj).append(" is outside of the image (").append(i).append(",").append(j).append(",").append(exifRotation).append(")").toString(), rect);
        rect;
        inputstream = inputstream1;
        Log.e((new StringBuilder()).append("Error cropping image: ").append(rect.getMessage()).toString(), rect);
        inputstream = inputstream1;
        finish();
        CropUtil.closeSilently(inputstream1);
        return bitmap;
        rect;
        inputstream = inputstream2;
        Log.e((new StringBuilder()).append("OOM cropping image: ").append(rect.getMessage()).toString(), rect);
        inputstream = inputstream2;
        setResultException(rect);
        CropUtil.closeSilently(inputstream2);
        return bitmap;
        bitmap;
        CropUtil.closeSilently(inputstream);
        throw bitmap;
    }

    private int getMaxImageSize()
    {
        int i = getMaxTextureSize();
        if (i == 0)
        {
            return 2048;
        } else
        {
            return Math.min(i, 4096);
        }
    }

    private int getMaxTextureSize()
    {
        int ai[] = new int[1];
        GLES10.glGetIntegerv(3379, ai, 0);
        return ai[0];
    }

    private Bitmap inMemoryCrop(RotateBitmap rotatebitmap, Bitmap bitmap, Rect rect, int i, int j, int k, int l)
    {
        System.gc();
        Bitmap bitmap1 = Bitmap.createBitmap(k, l, android.graphics.Bitmap.Config.RGB_565);
        bitmap = bitmap1;
        Canvas canvas = new Canvas(bitmap1);
        bitmap = bitmap1;
        RectF rectf = new RectF(0.0F, 0.0F, i, j);
        bitmap = bitmap1;
        Matrix matrix = new Matrix();
        bitmap = bitmap1;
        matrix.setRectToRect(new RectF(rect), rectf, android.graphics.Matrix.ScaleToFit.FILL);
        bitmap = bitmap1;
        matrix.preConcat(rotatebitmap.getRotateMatrix());
        bitmap = bitmap1;
        canvas.drawBitmap(rotatebitmap.getBitmap(), matrix, null);
        bitmap = bitmap1;
_L2:
        clearImageView();
        return bitmap;
        rotatebitmap;
        Log.e((new StringBuilder()).append("OOM cropping image: ").append(rotatebitmap.getMessage()).toString(), rotatebitmap);
        setResultException(rotatebitmap);
        System.gc();
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void initViews()
    {
        imageView = (CropImageView)findViewById(R.id.crop_image);
        imageView.context = this;
        imageView.setRecycler(new ImageViewTouchBase.Recycler() {

            final CropImageActivity this$0;

            public void recycle(Bitmap bitmap)
            {
                bitmap.recycle();
                System.gc();
            }

            
            {
                this$0 = CropImageActivity.this;
                super();
            }
        });
        findViewById(R.id.btn_cancel).setOnClickListener(new android.view.View.OnClickListener() {

            final CropImageActivity this$0;

            public void onClick(View view)
            {
                setResult(0);
                finish();
            }

            
            {
                this$0 = CropImageActivity.this;
                super();
            }
        });
        findViewById(R.id.btn_done).setOnClickListener(new android.view.View.OnClickListener() {

            final CropImageActivity this$0;

            public void onClick(View view)
            {
                onSaveClicked();
            }

            
            {
                this$0 = CropImageActivity.this;
                super();
            }
        });
    }

    private void onSaveClicked()
    {
        Object obj;
label0:
        {
            if (cropView == null || isSaving)
            {
                return;
            }
            isSaving = true;
            obj = cropView.getScaledCropRect(sampleSize);
            int i1 = ((Rect) (obj)).width();
            int j1 = ((Rect) (obj)).height();
            int k = i1;
            int l = j1;
            int i = k;
            int j = l;
            if (maxX <= 0)
            {
                break label0;
            }
            i = k;
            j = l;
            if (maxY <= 0)
            {
                break label0;
            }
            if (i1 <= maxX)
            {
                i = k;
                j = l;
                if (j1 <= maxY)
                {
                    break label0;
                }
            }
            float f = (float)i1 / (float)j1;
            Bitmap bitmap;
            if ((float)maxX / (float)maxY > f)
            {
                j = maxY;
                i = (int)((float)maxY * f + 0.5F);
            } else
            {
                i = maxX;
                j = (int)((float)maxX / f + 0.5F);
            }
        }
        if (!IN_MEMORY_CROP || rotateBitmap == null) goto _L2; else goto _L1
_L1:
        bitmap = inMemoryCrop(rotateBitmap, null, ((Rect) (obj)), i1, j1, i, j);
        obj = bitmap;
        if (bitmap != null)
        {
            imageView.setImageBitmapResetBase(bitmap, true);
            imageView.center(true, true);
            imageView.highlightViews.clear();
            obj = bitmap;
        }
_L4:
        saveImage(((Bitmap) (obj)));
        return;
_L2:
        Bitmap bitmap1;
        try
        {
            bitmap1 = decodeRegionCrop(null, ((Rect) (obj)));
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            setResultException(illegalargumentexception);
            finish();
            return;
        }
        obj = bitmap1;
        if (bitmap1 != null)
        {
            imageView.setImageRotateBitmapResetBase(new RotateBitmap(bitmap1, exifRotation), true);
            imageView.center(true, true);
            imageView.highlightViews.clear();
            obj = bitmap1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void saveImage(final Bitmap b)
    {
        if (b != null)
        {
            CropUtil.startBackgroundJob(this, null, getResources().getString(R.string.crop__saving), new Runnable() {

                final CropImageActivity this$0;
                final Bitmap val$b;

                public void run()
                {
                    saveOutput(b);
                }

            
            {
                this$0 = CropImageActivity.this;
                b = bitmap;
                super();
            }
            }, handler);
            return;
        } else
        {
            finish();
            return;
        }
    }

    private void saveOutput(final Bitmap b)
    {
        if (saveUri == null) goto _L2; else goto _L1
_L1:
        java.io.OutputStream outputstream;
        java.io.OutputStream outputstream1;
        outputstream1 = null;
        outputstream = null;
        java.io.OutputStream outputstream2 = getContentResolver().openOutputStream(saveUri);
        if (outputstream2 == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        outputstream = outputstream2;
        outputstream1 = outputstream2;
        b.compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, outputstream2);
        CropUtil.closeSilently(outputstream2);
_L4:
        if (!IN_MEMORY_CROP)
        {
            CropUtil.copyExifRotation(CropUtil.getFromMediaUri(getContentResolver(), sourceUri), CropUtil.getFromMediaUri(getContentResolver(), saveUri));
        }
        setResultUri(saveUri);
_L2:
        handler.post(new Runnable() {

            final CropImageActivity this$0;
            final Bitmap val$b;

            public void run()
            {
                imageView.clear();
                b.recycle();
            }

            
            {
                this$0 = CropImageActivity.this;
                b = bitmap;
                super();
            }
        });
        finish();
        return;
        IOException ioexception;
        ioexception;
        outputstream1 = outputstream;
        setResultException(ioexception);
        outputstream1 = outputstream;
        Log.e((new StringBuilder()).append("Cannot open file: ").append(saveUri).toString(), ioexception);
        CropUtil.closeSilently(outputstream);
        if (true) goto _L4; else goto _L3
_L3:
        b;
        CropUtil.closeSilently(outputstream1);
        throw b;
    }

    private void setResultException(Throwable throwable)
    {
        setResult(404, (new Intent()).putExtra("error", throwable));
    }

    private void setResultUri(Uri uri)
    {
        setResult(-1, (new Intent()).putExtra("output", uri));
    }

    private void setupFromIntent()
    {
        Object obj;
        Object obj1;
        Object obj3;
        java.io.InputStream inputstream;
        android.graphics.BitmapFactory.Options options;
        Object obj4;
        obj = getIntent();
        obj1 = ((Intent) (obj)).getExtras();
        if (obj1 != null)
        {
            aspectX = ((Bundle) (obj1)).getInt("aspect_x");
            aspectY = ((Bundle) (obj1)).getInt("aspect_y");
            maxX = ((Bundle) (obj1)).getInt("max_x");
            maxY = ((Bundle) (obj1)).getInt("max_y");
            saveUri = (Uri)((Bundle) (obj1)).getParcelable("output");
        }
        sourceUri = ((Intent) (obj)).getData();
        if (sourceUri == null)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        exifRotation = CropUtil.getExifRotation(CropUtil.getFromMediaUri(getContentResolver(), sourceUri));
        options = null;
        obj4 = null;
        inputstream = null;
        obj1 = inputstream;
        obj3 = options;
        obj = obj4;
        sampleSize = calculateBitmapSampleSize(sourceUri);
        obj1 = inputstream;
        obj3 = options;
        obj = obj4;
        inputstream = getContentResolver().openInputStream(sourceUri);
        obj1 = inputstream;
        obj3 = inputstream;
        obj = inputstream;
        options = new android.graphics.BitmapFactory.Options();
        obj1 = inputstream;
        obj3 = inputstream;
        obj = inputstream;
        options.inSampleSize = sampleSize;
        obj1 = inputstream;
        obj3 = inputstream;
        obj = inputstream;
        rotateBitmap = new RotateBitmap(BitmapFactory.decodeStream(inputstream, null, options), exifRotation);
        CropUtil.closeSilently(inputstream);
        return;
        obj3;
        obj = obj1;
        Log.e((new StringBuilder()).append("Error reading image: ").append(((IOException) (obj3)).getMessage()).toString(), ((Throwable) (obj3)));
        obj = obj1;
        setResultException(((Throwable) (obj3)));
        CropUtil.closeSilently(((java.io.Closeable) (obj1)));
        return;
        Object obj2;
        obj2;
        obj = obj3;
        Log.e((new StringBuilder()).append("OOM reading image: ").append(((OutOfMemoryError) (obj2)).getMessage()).toString(), ((Throwable) (obj2)));
        obj = obj3;
        setResultException(((Throwable) (obj2)));
        CropUtil.closeSilently(((java.io.Closeable) (obj3)));
        return;
        obj2;
        CropUtil.closeSilently(((java.io.Closeable) (obj)));
        throw obj2;
    }

    private void startCrop()
    {
        if (isFinishing())
        {
            return;
        } else
        {
            imageView.setImageRotateBitmapResetBase(rotateBitmap, true);
            CropUtil.startBackgroundJob(this, null, getResources().getString(R.string.crop__wait), new Runnable() {

                final CropImageActivity this$0;

                public void run()
                {
                    CountDownLatch countdownlatch = new CountDownLatch(1);
                    handler.post(countdownlatch. new Runnable() {

                        final _cls4 this$1;
                        final CountDownLatch val$latch;

                        public void run()
                        {
                            if (imageView.getScale() == 1.0F)
                            {
                                imageView.center(true, true);
                            }
                            latch.countDown();
                        }

            
            {
                this$1 = final__pcls4;
                latch = CountDownLatch.this;
                super();
            }
                    });
                    try
                    {
                        countdownlatch.await();
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        throw new RuntimeException(interruptedexception);
                    }
                    (new Cropper()).crop();
                }

            
            {
                this$0 = CropImageActivity.this;
                super();
            }
            }, handler);
            return;
        }
    }

    public volatile void addLifeCycleListener(MonitoredActivity.LifeCycleListener lifecyclelistener)
    {
        super.addLifeCycleListener(lifecyclelistener);
    }

    public boolean isSaving()
    {
        return isSaving;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.crop__activity_crop);
        initViews();
        setupFromIntent();
        if (rotateBitmap == null)
        {
            finish();
            return;
        } else
        {
            startCrop();
            return;
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (rotateBitmap != null)
        {
            rotateBitmap.recycle();
        }
    }

    public boolean onSearchRequested()
    {
        return false;
    }

    public volatile void removeLifeCycleListener(MonitoredActivity.LifeCycleListener lifecyclelistener)
    {
        super.removeLifeCycleListener(lifecyclelistener);
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT < 10)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        IN_MEMORY_CROP = flag;
    }









/*
    static HighlightView access$802(CropImageActivity cropimageactivity, HighlightView highlightview)
    {
        cropimageactivity.cropView = highlightview;
        return highlightview;
    }

*/

}
