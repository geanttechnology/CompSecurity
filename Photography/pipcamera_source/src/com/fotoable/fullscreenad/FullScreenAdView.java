// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fullscreenad;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import es;
import ev;
import ew;
import ex;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import jf;
import jg;
import jh;
import org.apache.http.Header;

public class FullScreenAdView extends FrameLayout
{

    public static boolean hasShowFullAd = false;
    private String FULLVIEWTAG;
    private View btnClickView;
    private TextView btnDismiss;
    private Context ctx;
    float imageHeight;
    private ImageView imageView;
    float imageWidth;
    private String launchAdCancel;
    private String launchAdClicked;
    private String launchAdShow;
    float logoHeight;
    private ImageView logoView;
    float logoWidth;
    private int mAdId;
    private String mAdUrl;
    private String mAnalysizetUrl;
    private long mInterVal;
    private jh mListener;
    float screenHeight;
    float screenWidth;

    public FullScreenAdView(Context context)
    {
        super(context);
        FULLVIEWTAG = "FULLVIEWTAG";
        launchAdShow = "launchAdShow";
        launchAdCancel = "launchAdCancel";
        launchAdClicked = "launchAdClicked";
        ctx = null;
        imageView = null;
        logoView = null;
        btnDismiss = null;
        btnClickView = null;
        mAdUrl = null;
        mAnalysizetUrl = null;
        mAdId = -1;
        mInterVal = 3000L;
        mListener = null;
        ctx = context;
        initFullScreenSize();
        initView();
    }

    public FullScreenAdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        FULLVIEWTAG = "FULLVIEWTAG";
        launchAdShow = "launchAdShow";
        launchAdCancel = "launchAdCancel";
        launchAdClicked = "launchAdClicked";
        ctx = null;
        imageView = null;
        logoView = null;
        btnDismiss = null;
        btnClickView = null;
        mAdUrl = null;
        mAnalysizetUrl = null;
        mAdId = -1;
        mInterVal = 3000L;
        mListener = null;
        ctx = context;
        initFullScreenSize();
        initView();
    }

    public FullScreenAdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        FULLVIEWTAG = "FULLVIEWTAG";
        launchAdShow = "launchAdShow";
        launchAdCancel = "launchAdCancel";
        launchAdClicked = "launchAdClicked";
        ctx = null;
        imageView = null;
        logoView = null;
        btnDismiss = null;
        btnClickView = null;
        mAdUrl = null;
        mAnalysizetUrl = null;
        mAdId = -1;
        mInterVal = 3000L;
        mListener = null;
        ctx = context;
        initFullScreenSize();
        initView();
    }

    private void dismissSelf()
    {
        ViewGroup viewgroup;
        View view;
label0:
        {
            viewgroup = (ViewGroup)getParent();
            if (viewgroup != null)
            {
                view = viewgroup.findViewWithTag(FULLVIEWTAG);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    break label0;
                }
                viewgroup.removeView(view);
            }
            return;
        }
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(view, "alpha", new float[] {
            1.0F, 0.0F
        });
        objectanimator.setInterpolator(new AccelerateInterpolator());
        objectanimator.addListener(new android.animation.Animator.AnimatorListener(view, viewgroup) {

            final View a;
            final ViewGroup b;
            final FullScreenAdView c;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                try
                {
                    a.setAlpha(1.0F);
                }
                // Misplaced declaration of an exception variable
                catch (Animator animator)
                {
                    animator.printStackTrace();
                }
                b.removeView(a);
                if (c.mListener != null)
                {
                    c.mListener.a();
                }
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                c = FullScreenAdView.this;
                a = view;
                b = viewgroup;
                super();
            }
        });
        objectanimator.start();
    }

    private jg getManager()
    {
        return jg.a(getContext());
    }

    private void initFullScreenSize()
    {
        screenWidth = ctx.getResources().getDisplayMetrics().widthPixels;
        screenHeight = ctx.getResources().getDisplayMetrics().heightPixels;
        setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(-1);
        Log.v(FULLVIEWTAG, (new StringBuilder()).append("enter here screenWidth:").append(screenWidth).append(" h").append(screenHeight).toString());
        if (screenWidth * 3F < screenHeight * 2.0F)
        {
            imageWidth = screenWidth;
            imageHeight = (imageWidth * 3F) / 2.0F;
        } else
        {
            imageWidth = screenWidth;
            imageHeight = screenHeight;
        }
        logoWidth = screenWidth;
        logoHeight = screenHeight - imageHeight;
    }

    private void initView()
    {
        setTag(FULLVIEWTAG);
        setBackgroundColor(-1);
        imageView = new ImageView(ctx);
        imageView.setLayoutParams(new android.widget.FrameLayout.LayoutParams((int)imageWidth, (int)imageHeight, 48));
        imageView.setBackgroundColor(-1);
        imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        addView(imageView);
        btnClickView = new View(ctx);
        btnClickView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(0, 0, 48));
        btnClickView.setBackgroundColor(0);
        btnClickView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final FullScreenAdView a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 0 || motionevent.getAction() == 2)
                {
                    a.btnClickView.setBackgroundColor(0x33000000);
                    return false;
                } else
                {
                    a.btnClickView.setBackgroundColor(0);
                    return false;
                }
            }

            
            {
                a = FullScreenAdView.this;
                super();
            }
        });
        btnClickView.setOnClickListener(new android.view.View.OnClickListener() {

            final FullScreenAdView a;

            public void onClick(View view)
            {
label0:
                {
                    view = new HashMap();
                    view.put("adId", (new StringBuilder()).append("").append(a.mAdId).toString());
                    Log.e("FullScreenAd", (new StringBuilder()).append("adid:").append(a.mAdId).toString());
                    FlurryAgent.logEvent(a.launchAdClicked, view);
                    if (a.mAdUrl != null && a.mAdUrl.length() > 0)
                    {
                        if (!a.mAdUrl.startsWith("market://"))
                        {
                            break label0;
                        }
                        es.a(a.ctx, a.mAdUrl);
                        a.dismissSelf();
                    }
                    return;
                }
                if (a.mListener != null)
                {
                    a.mListener.a(a.mAdUrl);
                }
                a.dismissSelf();
            }

            
            {
                a = FullScreenAdView.this;
                super();
            }
        });
        addView(btnClickView);
        FrameLayout framelayout = new FrameLayout(ctx);
        framelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(ew.a(ctx, 26F) + ew.a(ctx, 10F) + (int)screenWidth / 16, ew.a(ctx, 26F) + (int)screenHeight / 16));
        Object obj = (android.widget.FrameLayout.LayoutParams)framelayout.getLayoutParams();
        obj.gravity = 53;
        obj.width = ew.a(ctx, 26F) + ew.a(ctx, 10F) + (int)screenWidth / 16;
        obj.height = ew.a(ctx, 26F) + (int)screenHeight / 16;
        obj.topMargin = 0;
        obj.rightMargin = 0;
        addView(framelayout);
        btnDismiss = new TextView(ctx);
        btnDismiss.setLayoutParams(new android.widget.FrameLayout.LayoutParams((int)screenWidth / 12, ew.a(ctx, 26F)));
        btnDismiss.setTextSize(16F);
        btnDismiss.setGravity(17);
        btnDismiss.setText(com.fotoable.fotoadpackage.R.string.full_close);
        btnDismiss.setTextColor(-1);
        btnDismiss.setBackgroundResource(com.fotoable.fotoadpackage.R.drawable.textview);
        obj = btnDismiss.getPaint();
        float f = Layout.getDesiredWidth(getResources().getString(com.fotoable.fotoadpackage.R.string.full_close), ((android.text.TextPaint) (obj)));
        obj = (android.widget.FrameLayout.LayoutParams)btnDismiss.getLayoutParams();
        obj.gravity = 17;
        obj.width = (int)f + ew.a(ctx, 10F);
        obj.height = ew.a(ctx, 26F);
        framelayout.setOnClickListener(new android.view.View.OnClickListener() {

            final FullScreenAdView a;

            public void onClick(View view)
            {
                FlurryAgent.logEvent(a.launchAdCancel);
                a.dismissSelf();
            }

            
            {
                a = FullScreenAdView.this;
                super();
            }
        });
        framelayout.addView(btnDismiss);
        logoView = new ImageView(ctx);
        logoView.setLayoutParams(new android.widget.FrameLayout.LayoutParams((int)logoWidth, (int)logoHeight, 81));
        ((android.widget.FrameLayout.LayoutParams)logoView.getLayoutParams()).setMargins(0, (int)imageHeight, 0, 0);
        logoView.requestLayout();
        logoView.setBackgroundColor(-1);
        addView(logoView);
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final FullScreenAdView a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = FullScreenAdView.this;
                super();
            }
        });
    }

    private void postAnalysizeUrl()
    {
        if (mAnalysizetUrl == null || mAnalysizetUrl.length() <= 1)
        {
            return;
        } else
        {
            AsyncHttpClient asynchttpclient = new AsyncHttpClient();
            asynchttpclient.setTimeout(10000);
            asynchttpclient.post(mAnalysizetUrl, new AsyncHttpResponseHandler() {

                final FullScreenAdView a;

                public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
                {
                    Log.v(a.FULLVIEWTAG, "post failed...");
                }

                public void onSuccess(int i, Header aheader[], byte abyte0[])
                {
                    Log.v(a.FULLVIEWTAG, "post succeed...");
                }

            
            {
                a = FullScreenAdView.this;
                super();
            }
            });
            return;
        }
    }

    public void destroyView()
    {
        mListener = null;
        try
        {
            if (logoView != null)
            {
                logoView.setImageBitmap(null);
                logoView.destroyDrawingCache();
            }
        }
        catch (Exception exception1) { }
        try
        {
            if (imageView != null)
            {
                imageView.setImageBitmap(null);
                imageView.destroyDrawingCache();
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void handleDismissAction()
    {
        long l = 3000L;
        if (mInterVal > 3000L)
        {
            l = mInterVal;
        }
        (new Handler()).postDelayed(new Runnable() {

            final FullScreenAdView a;

            public void run()
            {
                a.dismissSelf();
            }

            
            {
                a = FullScreenAdView.this;
                super();
            }
        }, l);
    }

    public void loadDefaultImage()
    {
        jf jf1;
        try
        {
            jf1 = getManager().b(getContext());
        }
        catch (Exception exception)
        {
            return;
        }
        if (jf1 == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        imageView.setImageDrawable(getResources().getDrawable(jf1.g));
        setAdUrl(jf1.c);
        setAdId(jf1.a);
        setClickFram(jf1.j, new Point(320, 480));
    }

    public boolean loadImage()
    {
        jf jf1 = getManager().b();
        if (jf1 != null)
        {
            Object obj = (new StringBuilder()).append(getManager().c()).append(File.separator).append(jf1.b.substring(jf1.b.lastIndexOf("/") + 1)).toString();
            try
            {
                imageView.setImageDrawable(null);
                Point point = ev.a(((String) (obj)), ctx);
                ex.a().a(ctx, obj, imageView, point.x, point.y);
                setAdUrl(jf1.c);
                setAdId(jf1.a);
                setAnalysizeUrl(jf1.k);
                setClickFram(jf1.j, new Point(point.x, point.y));
                setLastTime(jf1.h);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                Crashlytics.logException(exception);
                return false;
            }
            catch (OutOfMemoryError outofmemoryerror)
            {
                Crashlytics.logException(outofmemoryerror);
                return false;
            }
            getManager().a(jf1.a);
            obj = new HashMap();
            ((Map) (obj)).put("adId", (new StringBuilder()).append("").append(jf1.a).toString());
            FlurryAgent.logEvent(launchAdShow, ((Map) (obj)));
            postAnalysizeUrl();
        }
        return true;
    }

    public void setAdId(int i)
    {
        mAdId = i;
    }

    public void setAdUrl(String s)
    {
        mAdUrl = s;
    }

    public void setAnalysizeUrl(String s)
    {
        mAnalysizetUrl = s;
    }

    public void setClickFram(Rect rect, Point point)
    {
        if (rect != null && point != null)
        {
            float f = imageWidth / (float)point.x;
            point = (android.widget.FrameLayout.LayoutParams)btnClickView.getLayoutParams();
            point.gravity = 51;
            point.width = (int)((float)rect.width() * f);
            point.height = (int)((float)rect.height() * f);
            point.topMargin = (int)((float)rect.top * f);
            point.leftMargin = (int)(f * (float)rect.left);
        }
    }

    public void setImage(int i)
    {
        if (imageView != null)
        {
            imageView.setImageResource(i);
        }
    }

    public void setImage(Bitmap bitmap)
    {
        if (imageView != null)
        {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void setImage(Drawable drawable)
    {
        if (imageView != null)
        {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setLastTime(long l)
    {
        mInterVal = l;
    }

    public void setLogo(int i)
    {
        if (logoView != null)
        {
            logoView.setImageResource(i);
        }
    }

    public void setLogo(Bitmap bitmap)
    {
        if (logoView != null)
        {
            logoView.setImageBitmap(bitmap);
        }
    }

    public void setLogo(Drawable drawable)
    {
        if (logoView != null)
        {
            logoView.setImageDrawable(drawable);
        }
    }

    public void setLogoBackgroundColor(int i)
    {
        if (logoView != null)
        {
            logoView.setBackgroundColor(i);
        }
    }

    public void setLogoBg(int i)
    {
        if (logoView != null)
        {
            logoView.setBackgroundResource(i);
        }
    }

    public void setLogoFrame(float f, float f1)
    {
        float f3 = (320F - f) / 320F;
        float f2 = f3;
        if (f3 >= 1.0F)
        {
            f2 = 0.0625F;
        }
        logoWidth = (1.0F - f2) * screenWidth;
        logoHeight = (logoWidth * f1) / f;
        f = (screenHeight - imageHeight - logoHeight) / 2.0F;
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)logoView.getLayoutParams();
        layoutparams.width = (int)logoWidth;
        layoutparams.height = (int)logoHeight;
        layoutparams.bottomMargin = (int)f;
        logoView.requestLayout();
    }

    public void setOnAdviewListener(jh jh)
    {
        mListener = jh;
    }










}
