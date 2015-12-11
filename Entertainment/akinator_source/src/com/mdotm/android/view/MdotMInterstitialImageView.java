// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mdotm.android.listener.MdotMAdActionListener;
import com.mdotm.android.model.MdotMAdResponse;
import com.mdotm.android.utils.MdotMLogger;
import com.mdotm.android.utils.MdotMUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class MdotMInterstitialImageView extends RelativeLayout
{

    private static final int HIGHLIGHT_BACKGROUND_COLOR = 0xffee7f27;
    private static final int HIGHLIGHT_COLOR = -19456;
    private ProgressBar activityIndicator;
    private String adLandingUrl;
    public boolean adLoadSuccess;
    private Drawable adSelectedBackground;
    private boolean adSelectionInProgress;
    private int backgroundColor;
    private Drawable defaultBackground;
    Handler handler;
    Bitmap imagrBitmap;
    private boolean isAdClicked;
    private int launchType;
    private MdotMAdActionListener mAdClickListener;
    private WebView webView;

    public MdotMInterstitialImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public MdotMInterstitialImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        backgroundColor = 0xff000000;
        webView = null;
        isAdClicked = false;
    }

    public MdotMInterstitialImageView(Context context, MdotMAdResponse mdotmadresponse, MdotMAdActionListener mdotmadactionlistener)
    {
        super(context);
        backgroundColor = 0xff000000;
        webView = null;
        isAdClicked = false;
        handler = new Handler();
        launchType = mdotmadresponse.getLaunchType();
        webView = new WebView(context);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new _cls1());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        setLayoutParams(layoutparams);
        mAdClickListener = mdotmadactionlistener;
        setFocusable(true);
        setClickable(true);
        setOnClickListener(new _cls2());
        setAdSelectionInProgress(false);
        try
        {
            initializeAdView(mdotmadresponse, context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MdotMLogger.e(this, "Exception initializing interstitial adview");
        }
        adLoadSuccess = false;
    }

    private void adNetworkCompleted()
    {
        MdotMLogger.i(this, "On ad network completed");
        setClickable(true);
        setAdSelectionInProgress(false);
        isAdClicked = false;
        hideActivityIndicator();
    }

    private void clicked(Context context)
    {
        MdotMLogger.i(this, "  Selected to clicked  ");
        if (adLandingUrl != null)
        {
            if (!isAdSelectionInProgress())
            {
                context = adLandingUrl;
                setAdSelectionInProgress(true);
                showActivityIndicator();
                (new _cls4(context)).start();
                return;
            } else
            {
                MdotMLogger.i(this, "ad selection under progress");
                return;
            }
        } else
        {
            MdotMLogger.i(this, "selected ad is null");
            return;
        }
    }

    private void createAdWithBannerView(Bitmap bitmap, MdotMAdResponse mdotmadresponse)
    {
        if (bitmap != null)
        {
            mdotmadresponse = new ImageView(getContext());
            mdotmadresponse.setImageBitmap(bitmap);
            mdotmadresponse.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            bitmap = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            bitmap.addRule(13);
            mdotmadresponse.setLayoutParams(bitmap);
            mdotmadresponse.setId(1);
            addView(mdotmadresponse);
            adLoadSuccess = true;
            return;
        } else
        {
            bitmap = new TextView(getContext());
            bitmap.setText("Oops! error while downloading Image. Click here to view detail.");
            mdotmadresponse = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            mdotmadresponse.addRule(13);
            bitmap.setLayoutParams(mdotmadresponse);
            bitmap.setPadding(50, 50, 50, 50);
            bitmap.setId(1);
            bitmap.setTextColor(0xff000000);
            bitmap.setBackgroundColor(0xffcccccc);
            addView(bitmap);
            adLoadSuccess = true;
            return;
        }
    }

    private void drawBackgroundView(boolean flag)
    {
        MdotMLogger.d(this, (new StringBuilder(" drawBackgroundView   :: ")).append(flag).toString());
        if (adSelectedBackground == null)
        {
            adSelectedBackground = populateDrawablwBackGround(0xffee7f27, -19456);
        }
        if (defaultBackground == null)
        {
            defaultBackground = populateDrawablwBackGround(0xff000000, backgroundColor);
        }
        if (flag)
        {
            setBackgroundDrawable(defaultBackground);
            return;
        } else
        {
            setBackgroundDrawable(adSelectedBackground);
            return;
        }
    }

    private Bitmap fetchImage(String s, boolean flag)
    {
        Bitmap bitmap = null;
        if (s == null) goto _L2; else goto _L1
_L1:
        Object obj = null;
        Object obj1 = null;
        int i;
        int j;
        try
        {
            s = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = obj1;
        }
        try
        {
            s = (HttpURLConnection)s.openConnection();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = obj;
        }
        s.setConnectTimeout(10000);
        s.setReadTimeout(30000);
        i = 0;
        try
        {
            j = s.getResponseCode();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            continue; /* Loop/switch isn't completed */
        }
        i = j;
_L4:
        if (i == 200 || i == 201)
        {
            bitmap = null;
            try
            {
                s = new BufferedInputStream(s.getInputStream());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                s = bitmap;
            }
            bitmap = BitmapFactory.decodeStream(s);
        }
        return bitmap;
_L2:
        MdotMLogger.e(this, "Image url is null");
        return null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private int getPixels(int i)
    {
        float f = getResources().getDisplayMetrics().density;
        return (int)((float)i * f + 0.5F);
    }

    private void hideActivityIndicator()
    {
        post(new _cls6());
    }

    private void initializeAdView(MdotMAdResponse mdotmadresponse, Context context)
        throws Exception
    {
        if (mdotmadresponse != null)
        {
            activityIndicator = new ProgressBar(getContext());
            activityIndicator.setIndeterminate(false);
            context = new android.widget.RelativeLayout.LayoutParams(getPixels(25), getPixels(25));
            activityIndicator.setLayoutParams(context);
            activityIndicator.setVisibility(4);
            activityIndicator.setMinimumHeight(30);
            activityIndicator.setMinimumWidth(30);
            activityIndicator.setMax(100);
            if (activityIndicator != null)
            {
                activityIndicator.setId(2);
                context.addRule(13);
            }
            adLandingUrl = mdotmadresponse.getLandingUrl();
            setFocusable(true);
            setClickable(true);
            if (mdotmadresponse.isCachedLocally())
            {
                imagrBitmap = BitmapFactory.decodeFile(mdotmadresponse.getImageUrl());
            } else
            {
                imagrBitmap = fetchImage(mdotmadresponse.getImageUrl(), false);
            }
            MdotMLogger.i(this, (new StringBuilder("Image is ")).append(mdotmadresponse.getImageUrl()).toString());
            if (imagrBitmap != null)
            {
                displayImageView(mdotmadresponse, imagrBitmap);
            } else
            {
                MdotMLogger.e(this, "Unable to create bitmap from cached file. Trying to download from remote");
                adLoadSuccess = true;
                (new _cls3(mdotmadresponse)).start();
                if (activityIndicator != null)
                {
                    addView(activityIndicator);
                }
                showActivityIndicator();
            }
            drawBackgroundView(true);
            setVisibility(getVisibility());
            return;
        } else
        {
            adLoadSuccess = false;
            return;
        }
    }

    private boolean isAdSelectionInProgress()
    {
        return adSelectionInProgress;
    }

    private static Drawable populateDrawablwBackGround(int i, int j)
    {
        MdotMLogger.i("", "populate backgnd called");
        Rect rect = new Rect(0, 0, 1, 1);
        MdotMLogger.i("", (new StringBuilder("rect width and height ")).append(rect.width()).append(" ").append(rect.height()).toString());
        Bitmap bitmap = Bitmap.createBitmap(rect.width(), rect.height(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(i);
        paint.setAntiAlias(true);
        canvas.drawRect(rect, paint);
        return new BitmapDrawable(bitmap);
    }

    private void setAdSelectionInProgress(boolean flag)
    {
        adSelectionInProgress = flag;
    }

    private void showActivityIndicator()
    {
        post(new _cls5());
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        int i = keyevent.getAction();
        if (!isAdClicked && i == 1)
        {
            isAdClicked = true;
            clicked(getContext());
        }
        return super.dispatchKeyEvent(keyevent);
    }

    public void displayImageView(MdotMAdResponse mdotmadresponse, Bitmap bitmap)
    {
        if (mdotmadresponse.getAdType() == MdotMUtils.AD_WITH_BANNER_OR_XHTML_OR_VIDEO)
        {
            createAdWithBannerView(bitmap, mdotmadresponse);
            if (activityIndicator != null)
            {
                removeView(activityIndicator);
                addView(activityIndicator);
                hideActivityIndicator();
            }
            return;
        } else
        {
            adLoadSuccess = false;
            MdotMLogger.e(this, (new StringBuilder("Woooo!! unable to display ad, We got unsupported ad type for interstitial. AdType : ")).append(mdotmadresponse.getAdType()).toString());
            return;
        }
    }












    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls5 {}

}
