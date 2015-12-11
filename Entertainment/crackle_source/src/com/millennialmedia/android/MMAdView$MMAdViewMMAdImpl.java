// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import java.util.Map;
import java.util.Random;

// Referenced classes of package com.millennialmedia.android:
//            MMAdView, MMSDK

class animateTransition extends animateTransition
{

    final MMAdView this$0;

    void animateTransition()
    {
        if (refreshAnimationimageView.getDrawable() != null)
        {
            MMSDK.runOnUiThread(new Runnable() {

                final MMAdView.MMAdViewMMAdImpl this$1;

                public void run()
                {
                    int i;
                    int j = transitionType;
                    i = j;
                    if (j == 4)
                    {
                        i = (new Random()).nextInt(4);
                    }
                    i;
                    JVM INSTR tableswitch 2 3: default 52
                //                               2 110
                //                               3 136;
                       goto _L1 _L2 _L3
_L1:
                    Object obj = new AlphaAnimation(1.0F, 0.0F);
_L5:
                    ((Animation) (obj)).setDuration(1000L);
                    ((Animation) (obj)).setAnimationListener(this$0);
                    ((Animation) (obj)).setFillEnabled(true);
                    ((Animation) (obj)).setFillBefore(true);
                    ((Animation) (obj)).setFillAfter(true);
                    refreshAnimationimageView.startAnimation(((Animation) (obj)));
                    return;
_L2:
                    obj = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(float)getHeight());
                    continue; /* Loop/switch isn't completed */
_L3:
                    obj = new TranslateAnimation(0.0F, 0.0F, 0.0F, getHeight());
                    if (true) goto _L5; else goto _L4
_L4:
                }

            
            {
                this$1 = MMAdView.MMAdViewMMAdImpl.this;
                super();
            }
            });
        }
    }

    String getReqType()
    {
        return "getad";
    }

    String getRequestCompletedAction()
    {
        return "millennialmedia.action.ACTION_GETAD_SUCCEEDED";
    }

    String getRequestFailedAction()
    {
        return "millennialmedia.action.ACTION_GETAD_FAILED";
    }

    public boolean hasCachedVideoSupport()
    {
        return false;
    }

    void insertUrlAdMetaValues(Map map)
    {
        if (height > 0)
        {
            map.put("hsht", String.valueOf(height));
        }
        if (width > 0)
        {
            map.put("hswd", String.valueOf(width));
        }
        super.insertUrlAdMetaValues(map);
    }

    public boolean isBanner()
    {
        return true;
    }

    boolean isLifecycleObservable()
    {
        return getWindowToken() != null;
    }

    boolean isTransitionAnimated()
    {
        return transitionType != 0;
    }

    void prepareTransition(Bitmap bitmap)
    {
        refreshAnimationimageView.setImageBitmap(bitmap);
        refreshAnimationimageView.setVisibility(0);
        refreshAnimationimageView.bringToFront();
    }

    public _cls2.this._cls1(Context context)
    {
        this.this$0 = MMAdView.this;
        super(MMAdView.this, context);
        mmWebViewClientListener = new MMAdImpl.BasicMMWebViewClientListener() {

            final MMAdView.MMAdViewMMAdImpl this$1;
            final MMAdView val$this$0;

            public void onPageFinished(String s)
            {
                super.onPageFinished(s);
                if (isTransitionAnimated())
                {
                    animateTransition();
                }
            }

            
            {
                this$1 = MMAdView.MMAdViewMMAdImpl.this;
                this$0 = mmadview;
                super(MMAdView.MMAdViewMMAdImpl.this);
            }
        };
    }
}
