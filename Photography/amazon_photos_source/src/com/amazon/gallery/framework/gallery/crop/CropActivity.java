// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.crop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import uk.co.senab.photoview.PhotoViewAttacher;

// Referenced classes of package com.amazon.gallery.framework.gallery.crop:
//            CropBaseActivity, OverlayView, CropParameters, LoadBitmapAsyncTask, 
//            CropBitmapAsyncTask

public class CropActivity extends CropBaseActivity
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent CropFailedBitmap;
        public static final MetricsEvent CropFailedUri;
        public static final MetricsEvent CropSuccessBitmap;
        public static final MetricsEvent CropSuccessUri;
        public static final MetricsEvent LoadBitmapFailure;
        public static final MetricsEvent LoadBitmapSuccess;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/gallery/crop/CropActivity$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            CropSuccessUri = new MetricsEvent("CropSuccessUri", 0);
            CropSuccessBitmap = new MetricsEvent("CropSuccessBitmap", 1);
            CropFailedUri = new MetricsEvent("CropFailedUri", 2);
            CropFailedBitmap = new MetricsEvent("CropFailedBitmap", 3);
            LoadBitmapSuccess = new MetricsEvent("LoadBitmapSuccess", 4);
            LoadBitmapFailure = new MetricsEvent("LoadBitmapFailure", 5);
            $VALUES = (new MetricsEvent[] {
                CropSuccessUri, CropSuccessBitmap, CropFailedUri, CropFailedBitmap, LoadBitmapSuccess, LoadBitmapFailure
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private PhotoViewAttacher attacher;
    private Button cancelButton;
    private CropParameters cropParams;
    private ImageView imageView;
    private OverlayView overlayView;
    private Button setButton;

    public CropActivity()
    {
    }

    void onBitmapCropped(Bitmap bitmap)
    {
        getProfiler().trackEvent(MetricsEvent.CropSuccessBitmap);
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", bitmap);
        setResult(-1, (new Intent()).setAction("inline-data").putExtras(bundle));
        finish();
    }

    void onBitmapCropped(Uri uri)
    {
        getProfiler().trackEvent(MetricsEvent.CropSuccessUri);
        Intent intent = getIntent();
        intent.setData(uri);
        setResult(-1, intent);
        finish();
    }

    void onBitmapLoaded(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            imageView.setImageBitmap(bitmap);
            attacher = new PhotoViewAttacher(imageView);
            attacher.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            bitmap = overlayView.getCropRect();
            if (bitmap != null)
            {
                attacher.setCustomBounds(bitmap);
            }
            cancelButton.setEnabled(true);
            setButton.setEnabled(true);
            getProfiler().trackEvent(MetricsEvent.LoadBitmapSuccess);
            return;
        } else
        {
            getProfiler().trackEvent(MetricsEvent.LoadBitmapFailure);
            finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03007b);
        cropParams = new CropParameters(getIntent());
        imageView = (ImageView)findViewById(0x7f0c0125);
        overlayView = (OverlayView)findViewById(0x7f0c0126);
        if (!cropParams.isCircleCrop())
        {
            break MISSING_BLOCK_LABEL_190;
        }
        overlayView.enableCircleCrop();
_L1:
        overlayView.setSizeChangedListener(new OverlayView.SizeChangedListener() {

            final CropActivity this$0;

            public void sizeChanged(int i, int j, int k, int l)
            {
                if (attacher != null)
                {
                    attacher.setCustomBounds(overlayView.getCropRect());
                }
            }

            
            {
                this$0 = CropActivity.this;
                super();
            }
        });
        (new LoadBitmapAsyncTask(getContentResolver(), this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Uri[] {
            cropParams.getImageUri()
        });
        setButton = (Button)findViewById(0x7f0c012a);
        cancelButton = (Button)findViewById(0x7f0c0129);
        cancelButton.setEnabled(false);
        cancelButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CropActivity this$0;

            public void onClick(View view)
            {
                setResult(0);
                finish();
            }

            
            {
                this$0 = CropActivity.this;
                super();
            }
        });
        setButton.setEnabled(false);
        setButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CropActivity this$0;

            public void onClick(View view)
            {
                setButton.setEnabled(false);
                view = new CropBitmapAsyncTask(CropActivity.this, cropParams, overlayView.getCropRect());
                Bitmap bitmap = attacher.getVisibleRectangleBitmap();
                view.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[] {
                    bitmap
                });
            }

            
            {
                this$0 = CropActivity.this;
                super();
            }
        });
        return;
        try
        {
            overlayView.setAspectRatio(cropParams.getAspectX(), cropParams.getAspectY());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            setResult(0);
            finish();
            return;
        }
          goto _L1
    }

    void onCropFailed()
    {
        ComponentProfiler componentprofiler = getProfiler();
        MetricsEvent metricsevent;
        if (cropParams.isReturningUri())
        {
            metricsevent = MetricsEvent.CropFailedUri;
        } else
        {
            metricsevent = MetricsEvent.CropFailedBitmap;
        }
        componentprofiler.trackEvent(metricsevent);
        finish();
    }




}
