// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

// Referenced classes of package com.applovin.adview:
//            AdViewController

public class AppLovinAdView extends RelativeLayout
{

    public static final String NAMESPACE = "http://schemas.applovin.com/android/1.0";
    private AdViewController a;

    public AppLovinAdView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public AppLovinAdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(null, null, context, attributeset);
    }

    public AppLovinAdView(AppLovinAdSize applovinadsize, Activity activity)
    {
        super(activity);
        Log.d("AppLovinSdk", "Created new AdView");
        a(applovinadsize, null, activity, null);
    }

    public AppLovinAdView(AppLovinSdk applovinsdk, AppLovinAdSize applovinadsize, Activity activity)
    {
        super(activity);
        a(applovinadsize, applovinsdk, activity, null);
    }

    private void a(AttributeSet attributeset, Context context)
    {
        attributeset = context.getResources().getDisplayMetrics();
        int i = ((DisplayMetrics) (attributeset)).widthPixels;
        int j = (int)TypedValue.applyDimension(1, 50F, attributeset);
        attributeset = new TextView(context);
        attributeset.setBackgroundColor(Color.rgb(220, 220, 220));
        attributeset.setTextColor(0xff000000);
        attributeset.setText("AppLovin Ad");
        attributeset.setGravity(17);
        addView(attributeset, i, j);
    }

    private void a(AppLovinAdSize applovinadsize, AppLovinSdk applovinsdk, Context context, AttributeSet attributeset)
    {
        if (!isInEditMode())
        {
            AdViewControllerImpl adviewcontrollerimpl = new AdViewControllerImpl();
            adviewcontrollerimpl.initializeAdView(this, context, applovinadsize, applovinsdk, attributeset);
            a = adviewcontrollerimpl;
            return;
        } else
        {
            a(attributeset, context);
            return;
        }
    }

    public void destroy()
    {
        if (a != null)
        {
            a.destroy();
        }
    }

    public AdViewController getAdViewController()
    {
        return a;
    }

    public AppLovinAdSize getSize()
    {
        if (a != null)
        {
            return a.getSize();
        } else
        {
            return null;
        }
    }

    public void loadNextAd()
    {
        if (a != null)
        {
            a.loadNextAd();
            return;
        } else
        {
            Log.i("AppLovinSdk", "Unable to load next ad: AppLovinAdView is not initialized.");
            return;
        }
    }

    protected void onDetachedFromWindow()
    {
        if (a != null)
        {
            a.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    protected void onVisibilityChanged(View view, int i)
    {
        super.onVisibilityChanged(view, i);
        if (a != null)
        {
            a.onVisibilityChanged(i);
        }
    }

    public void pause()
    {
        if (a != null)
        {
            a.pause();
        }
    }

    public void renderAd(AppLovinAd applovinad)
    {
        if (a != null)
        {
            a.renderAd(applovinad);
        }
    }

    public void resume()
    {
        if (a != null)
        {
            a.resume();
        }
    }

    public void setAdClickListener(AppLovinAdClickListener applovinadclicklistener)
    {
        if (a != null)
        {
            a.setAdClickListener(applovinadclicklistener);
        }
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener applovinaddisplaylistener)
    {
        if (a != null)
        {
            a.setAdDisplayListener(applovinaddisplaylistener);
        }
    }

    public void setAdLoadListener(AppLovinAdLoadListener applovinadloadlistener)
    {
        if (a != null)
        {
            a.setAdLoadListener(applovinadloadlistener);
        }
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener)
    {
        if (a != null)
        {
            a.setAdVideoPlaybackListener(applovinadvideoplaybacklistener);
        }
    }

    public void setAutoDestroy(boolean flag)
    {
        if (a != null)
        {
            a.setAutoDestroy(flag);
        }
    }
}
