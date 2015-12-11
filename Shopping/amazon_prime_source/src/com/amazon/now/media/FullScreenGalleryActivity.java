// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.media;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.amazon.now.AmazonActivity;
import com.amazon.now.ChromeStyle;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.ImageUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

// Referenced classes of package com.amazon.now.media:
//            Gallery, GalleryPanel, PinchImageView

public class FullScreenGalleryActivity extends AmazonActivity
{
    private class GestureListener extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final FullScreenGalleryActivity this$0;

        public boolean onDoubleTap(MotionEvent motionevent)
        {
            if (mGallery.getVisibility() == 0)
            {
                mGallery.setVisibility(4);
                mPinchImage.setVisibility(0);
            }
            mPinchImage.doubleTapScale(motionevent.getX(), motionevent.getY());
            return true;
        }

        private GestureListener()
        {
            this$0 = FullScreenGalleryActivity.this;
            super();
        }

    }

    private class ScaleListener extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
    {

        final FullScreenGalleryActivity this$0;

        public boolean onScale(ScaleGestureDetector scalegesturedetector)
        {
            if (scalegesturedetector.getScaleFactor() <= 1.0F)
            {
                return false;
            }
            if (mGallery.getVisibility() == 0)
            {
                mGallery.setVisibility(4);
                mPinchImage.setVisibility(0);
            }
            mPinchImage.updateScale(scalegesturedetector);
            return true;
        }

        private ScaleListener()
        {
            this$0 = FullScreenGalleryActivity.this;
            super();
        }

    }


    private static String KEY_INDEX = "index";
    private static String KEY_URLS = "urls";
    private static final String TAG = com/amazon/now/media/FullScreenGalleryActivity.getSimpleName();
    private Gallery mGallery;
    private GestureDetector mGestureDetector;
    private boolean mIsForeground;
    private GalleryPanel mPanel;
    private PinchImageView mPinchImage;
    private ScaleGestureDetector mScaleDetector;
    private int mScreenHeight;
    private int mScreenWidth;
    private final android.view.View.OnTouchListener onTouchListener = new android.view.View.OnTouchListener() {

        final FullScreenGalleryActivity this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            mScaleDetector.onTouchEvent(motionevent);
            mGestureDetector.onTouchEvent(motionevent);
            if (mPinchImage.getVisibility() == 4)
            {
                view.onTouchEvent(motionevent);
            }
            return true;
        }

            
            {
                this$0 = FullScreenGalleryActivity.this;
                super();
            }
    };

    public FullScreenGalleryActivity()
    {
    }

    private void downloadImage(String s, final int postion, final GalleryPanel panel)
    {
        (new AsyncTask() {

            final FullScreenGalleryActivity this$0;
            final GalleryPanel val$panel;
            final int val$postion;

            protected transient Bitmap doInBackground(String as[])
            {
                Object obj4;
                obj4 = null;
                as = as[0];
                if (as != null) goto _L2; else goto _L1
_L1:
                as = obj4;
_L3:
                return as;
_L2:
                Object obj;
                Object obj2;
                Object obj3;
                obj3 = ImageUtil.getImageUrlReplacingTags(as, mScreenWidth, mScreenHeight);
                obj2 = null;
                as = null;
                obj = null;
                obj3 = (new URL(((String) (obj3)))).openStream();
                obj = obj3;
                obj2 = obj3;
                as = ((String []) (obj3));
                Object obj5 = new android.graphics.BitmapFactory.Options();
                obj = obj3;
                obj2 = obj3;
                as = ((String []) (obj3));
                obj5.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
                obj = obj3;
                obj2 = obj3;
                as = ((String []) (obj3));
                obj5 = BitmapFactory.decodeStream(((InputStream) (obj3)), null, ((android.graphics.BitmapFactory.Options) (obj5)));
                obj = obj5;
                as = ((String []) (obj));
                if (obj3 != null)
                {
                    try
                    {
                        ((InputStream) (obj3)).close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (String as[])
                    {
                        Log.e(FullScreenGalleryActivity.TAG, "Error closing stream", as);
                        return ((Bitmap) (obj));
                    }
                    return ((Bitmap) (obj));
                }
                  goto _L3
                obj2;
                as = ((String []) (obj));
                Log.e(FullScreenGalleryActivity.TAG, "Failure to download Image", ((Throwable) (obj2)));
                as = obj4;
                if (obj != null)
                {
                    try
                    {
                        ((InputStream) (obj)).close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (String as[])
                    {
                        Log.e(FullScreenGalleryActivity.TAG, "Error closing stream", as);
                        return null;
                    }
                    return null;
                }
                  goto _L3
                Object obj1;
                obj1;
                as = ((String []) (obj2));
                Log.e(FullScreenGalleryActivity.TAG, "Out of Memory! Aborting download", ((Throwable) (obj1)));
                as = obj4;
                if (obj2 == null) goto _L3; else goto _L4
_L4:
                try
                {
                    ((InputStream) (obj2)).close();
                }
                // Misplaced declaration of an exception variable
                catch (String as[])
                {
                    Log.e(FullScreenGalleryActivity.TAG, "Error closing stream", as);
                    return null;
                }
                return null;
                obj1;
                if (as != null)
                {
                    try
                    {
                        as.close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (String as[])
                    {
                        Log.e(FullScreenGalleryActivity.TAG, "Error closing stream", as);
                    }
                }
                throw obj1;
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((String[])aobj);
            }

            protected void onPostExecute(Bitmap bitmap)
            {
                if (bitmap != null && mIsForeground)
                {
                    mGallery.addImageViewToTheGallery(bitmap, postion);
                    panel.setThumbnail(bitmap, postion);
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Bitmap)obj);
            }

            
            {
                this$0 = FullScreenGalleryActivity.this;
                postion = i;
                panel = gallerypanel;
                super();
            }
        }).execute(new String[] {
            s
        });
    }

    public static void startFullScreenGalleryActivity(Context context, String as[], int i, ChromeStyle chromestyle)
    {
        Intent intent = new Intent(context, com/amazon/now/media/FullScreenGalleryActivity);
        intent.putExtra(KEY_URLS, as);
        intent.putExtra(KEY_INDEX, i);
        intent.putExtra("intentStyleKey", chromestyle);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ChromeStyle chromestyle = new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL);
        bundle = chromestyle;
        if (getIntent().hasExtra("intentStyleKey"))
        {
            bundle = chromestyle;
            if (getIntent().getParcelableExtra("intentStyleKey") != null)
            {
                bundle = (ChromeStyle)getIntent().getParcelableExtra("intentStyleKey");
            }
        }
        setRootView(LayoutInflater.from(this).inflate(0x7f03000c, null), bundle);
        mIsForeground = true;
        bundle = AppUtils.getDeviceDisplayMetrics(this);
        mScreenWidth = ((DisplayMetrics) (bundle)).widthPixels;
        mScreenHeight = ((DisplayMetrics) (bundle)).heightPixels;
        bundle = getIntent();
        mScaleDetector = new ScaleGestureDetector(this, new ScaleListener());
        mGestureDetector = new GestureDetector(this, new GestureListener());
        mGallery = (Gallery)findViewById(0x7f0e005a);
        mPanel = (GalleryPanel)findViewById(0x7f0e005c);
        mPanel.attachTo(mGallery);
        mGallery.setOnTouchListener(onTouchListener);
        mGallery.setCurrentPage(bundle.getIntExtra(KEY_INDEX, 0));
        mPinchImage = (PinchImageView)findViewById(0x7f0e005b);
        mPinchImage.setGallery(mGallery);
        mGallery.setPinchImage(mPinchImage);
        bundle = bundle.getStringArrayExtra(KEY_URLS);
        for (int i = 0; i < bundle.length; i++)
        {
            downloadImage(bundle[i], i, mPanel);
        }

        mPanel.populateDots(bundle.length, mGallery.getOnClickListener());
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mPanel != null)
        {
            mPanel.recycleBitmaps();
        }
    }

    public void onPause()
    {
        super.onPause();
        mIsForeground = false;
    }









}
