// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netswipe.sdk.core;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.jumio.netswipe.sdk.enums.ErrorCase;
import java.nio.CharBuffer;
import java.util.ArrayList;
import netswipe.aq;
import netswipe.ar;
import netswipe.as;
import netswipe.at;
import netswipe.au;
import netswipe.az;
import netswipe.b;
import netswipe.bf;
import netswipe.bm;
import netswipe.bs;
import netswipe.bu;
import netswipe.by;
import netswipe.ca;
import netswipe.cc;
import netswipe.dc;
import netswipe.dh;
import netswipe.k;
import netswipe.l;
import netswipe.m;
import netswipe.n;
import netswipe.o;

// Referenced classes of package com.jumio.netswipe.sdk.core:
//            NetswipeCardInformation

public class ScanCardActivity extends Activity
{

    private static float i = 0.75F;
    private static float j = 1.33F;
    private o a;
    private ca b;
    public at blurView;
    public au bottomButtonBar;
    private bf c;
    private Bitmap d;
    private bs e;
    private ObjectAnimator f;
    private ObjectAnimator g;
    private az h;
    private boolean k;
    protected ScrollView manualEntryScrollView;
    public bm manualEntryView;
    protected RelativeLayout rootRelativeLayout;
    public bu scanOverlayView;
    public by successView;
    public TextureView textureView;
    public cc topInfoBar;

    public ScanCardActivity()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        topInfoBar = null;
        rootRelativeLayout = null;
        bottomButtonBar = null;
        textureView = null;
        blurView = null;
        scanOverlayView = null;
        manualEntryScrollView = null;
        manualEntryView = null;
        successView = null;
        k = false;
    }

    private void a()
    {
        TypedValue typedvalue = new TypedValue();
        getTheme().resolveAttribute(0x10102eb, typedvalue, true);
        blurView.setActionBarHeight(TypedValue.complexToDimensionPixelSize(typedvalue.data, getResources().getDisplayMetrics()));
    }

    public void closeHelpView()
    {
        c.setVisibility(8);
        showBottomBar();
    }

    public void handleActionBar(boolean flag)
    {
        topInfoBar.a(flag);
        if (flag)
        {
            topInfoBar.setRightImage(null);
            getActionBar().show();
        } else
        if (h == null || h.getVisibility() == 8)
        {
            getActionBar().hide();
            if (a.f())
            {
                topInfoBar.setRightImage(d);
                return;
            }
        }
    }

    public void hideBottomBar()
    {
        if (bottomButtonBar.getVisibility() == 8 || f != null && f.isStarted())
        {
            return;
        } else
        {
            f = ObjectAnimator.ofFloat(bottomButtonBar, "alpha", new float[] {
                1.0F, 0.0F
            });
            f.setDuration(400L);
            f.setInterpolator(new DecelerateInterpolator());
            f.addListener(new l(this));
            f.start();
            return;
        }
    }

    public void hideTopBar()
    {
        if (topInfoBar.getAlpha() < 1.0F)
        {
            return;
        } else
        {
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(topInfoBar, "alpha", new float[] {
                1.0F, 0.0F
            });
            objectanimator.setDuration(400L);
            objectanimator.setInterpolator(new DecelerateInterpolator());
            objectanimator.addListener(new n(this));
            objectanimator.start();
            return;
        }
    }

    public void initLayout(ArrayList arraylist, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1)
    {
        rootRelativeLayout = new RelativeLayout(this);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        rootRelativeLayout.setLayoutParams(layoutparams);
        textureView = new TextureView(this);
        textureView.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        rootRelativeLayout.addView(textureView);
        e = new bs(this);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        e.setLayoutParams(layoutparams);
        scanOverlayView = new bu(this);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        scanOverlayView.setLayoutParams(layoutparams);
        rootRelativeLayout.addView(e);
        rootRelativeLayout.addView(scanOverlayView);
        blurView = new at(this);
        blurView.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        blurView.setVisibility(8);
        blurView.setRootRelativeLayout(rootRelativeLayout);
        a();
        rootRelativeLayout.addView(blurView);
        topInfoBar = new cc(this);
        topInfoBar.setRightImageViewClickListener(onclicklistener1);
        rootRelativeLayout.addView(topInfoBar);
        bottomButtonBar = new au(this);
        rootRelativeLayout.addView(bottomButtonBar);
        onclicklistener1 = new ImageView(this);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.bottomMargin = dc.a(this, 44);
        layoutparams.rightMargin = dc.a(this, 8);
        layoutparams.addRule(12);
        layoutparams.addRule(11);
        onclicklistener1.setLayoutParams(layoutparams);
        onclicklistener1.setAdjustViewBounds(true);
        onclicklistener1.setImageBitmap(aq.a(getResources(), aq.a));
        rootRelativeLayout.addView(onclicklistener1);
        c = new bf(this, arraylist, onclicklistener);
        c.setVisibility(8);
        rootRelativeLayout.addView(c);
        setContentView(rootRelativeLayout);
    }

    public void onBackPressed()
    {
        a.a(true, false);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        boolean flag = true;
        super.onConfigurationChanged(configuration);
        dh.b("onConfigurationChanged()");
        if (k)
        {
            int i1 = b.netswipe_dialogToScreenRatioPortrait;
            int j1 = b.netswipe_dialogToScreenRatioLandscape;
            Object obj = getTheme().obtainStyledAttributes(new int[] {
                i1, j1
            });
            Display display = getWindowManager().getDefaultDisplay();
            DisplayMetrics displaymetrics = new DisplayMetrics();
            display.getMetrics(displaymetrics);
            float f1;
            float f2;
            if (displaymetrics.heightPixels > displaymetrics.widthPixels)
            {
                f2 = ((TypedArray) (obj)).getFloat(0, 0.0F);
                f1 = i;
            } else
            {
                f2 = ((TypedArray) (obj)).getFloat(1, 0.0F);
                f1 = j;
            }
            if (f2 != 0.0F)
            {
                getWindow().setFlags(2, 2);
                obj = getWindow().getAttributes();
                obj.height = (int)(f2 * (float)displaymetrics.heightPixels);
                obj.width = (int)(f1 * (float)((android.view.WindowManager.LayoutParams) (obj)).height);
                obj.alpha = 1.0F;
                obj.dimAmount = 0.5F;
                getWindow().setAttributes(((android.view.WindowManager.LayoutParams) (obj)));
            }
        } else
        {
            if (configuration.orientation != 1)
            {
                flag = false;
            }
            handleActionBar(flag);
        }
        if (a != null)
        {
            a.a(configuration);
        }
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag = false;
        dh.b("onCreate()");
        super.onCreate(bundle);
        d = aq.a(this, "icon_manual_entry");
        getWindow().addFlags(128);
        getWindow().addFlags(8192);
        a = new o(this);
        int i1 = b.netswipe_dialogToScreenRatioPortrait;
        int j1 = b.netswipe_dialogToScreenRatioLandscape;
        Object obj = getTheme().obtainStyledAttributes(new int[] {
            i1, j1
        });
        Display display = getWindowManager().getDefaultDisplay();
        bundle = new DisplayMetrics();
        display.getMetrics(bundle);
        float f1;
        float f2;
        if (((DisplayMetrics) (bundle)).heightPixels > ((DisplayMetrics) (bundle)).widthPixels)
        {
            f2 = ((TypedArray) (obj)).getFloat(0, 0.0F);
            f1 = i;
        } else
        {
            f2 = ((TypedArray) (obj)).getFloat(1, 0.0F);
            f1 = j;
        }
        if (f2 != 0.0F)
        {
            k = true;
            getWindow().setFlags(2, 2);
            obj = getWindow().getAttributes();
            obj.height = (int)(f2 * (float)((DisplayMetrics) (bundle)).heightPixels);
            obj.width = (int)(f1 * (float)((android.view.WindowManager.LayoutParams) (obj)).height);
            obj.alpha = 1.0F;
            obj.dimAmount = 0.5F;
            getWindow().setAttributes(((android.view.WindowManager.LayoutParams) (obj)));
        } else
        {
            if (getResources().getConfiguration().orientation == 1)
            {
                flag = true;
            }
            handleActionBar(flag);
        }
        getActionBar().setTitle(ar.a(this, "activity_title_scan"));
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        a.a(menu);
        return true;
    }

    protected void onDestroy()
    {
        dh.b("onDestroy()");
        super.onDestroy();
        a.e();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            a.a(true, false);
            break;
        }
        return true;
    }

    protected void onPause()
    {
        dh.b("onPause()");
        super.onPause();
        a.d();
    }

    protected void onResume()
    {
        dh.b("onResume()");
        super.onResume();
        a.c();
    }

    public void restoreScanView()
    {
        showBottomBar();
        showTopBar();
        if (a.g() && !k)
        {
            getActionBar().hide();
        }
        if (!getActionBar().isShowing() && a.f())
        {
            topInfoBar.setRightImage(d);
        }
        if (successView != null)
        {
            successView.setVisibility(8);
        }
        if (h != null)
        {
            h.setVisibility(8);
        }
    }

    public void showAdditionalEntryView(NetswipeCardInformation netswipecardinformation, android.view.View.OnClickListener onclicklistener, ArrayList arraylist, boolean flag, boolean flag1)
    {
        hideTopBar();
        rootRelativeLayout.removeView(successView);
        b = new ca(this);
        b.setCreditCardNumber(CharBuffer.wrap(netswipecardinformation.getCardNumberGrouped()));
        if (netswipecardinformation.getExpiryDateMonth().length != 0 && netswipecardinformation.getExpiryDateYear().length != 0)
        {
            b.setExpiryDate((new StringBuilder()).append(CharBuffer.wrap(netswipecardinformation.getExpiryDateMonth())).append(" / ").append(CharBuffer.wrap(netswipecardinformation.getExpiryDateYear())).toString());
        }
        if (netswipecardinformation.getSortCode().length != 0 && netswipecardinformation.getAccountNumber().length != 0)
        {
            b.setSortCodeAndAccountNumber((new StringBuilder()).append(CharBuffer.wrap(netswipecardinformation.getSortCode())).append(" ").append(CharBuffer.wrap(netswipecardinformation.getAccountNumber())).toString());
        }
        b.a(netswipecardinformation.getCardType(), getResources());
        rootRelativeLayout.addView(b);
        manualEntryView = new bm(this);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        manualEntryView.setLayoutParams(layoutparams);
        manualEntryView.a(false, false, flag, flag1, arraylist, onclicklistener, null, true);
        if (flag1)
        {
            manualEntryView.a(CharBuffer.wrap(netswipecardinformation.getCardHolderName()));
        }
        if (flag)
        {
            manualEntryView.a(netswipecardinformation.getCardType());
        }
        manualEntryScrollView = new ScrollView(this);
        netswipecardinformation = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        netswipecardinformation.addRule(3, as.a);
        manualEntryScrollView.setLayoutParams(netswipecardinformation);
        manualEntryScrollView.addView(manualEntryView);
        rootRelativeLayout.addView(manualEntryScrollView);
        getActionBar().setTitle(ar.a(this, "activity_title_additional_info"));
    }

    public void showBottomBar()
    {
        if (bottomButtonBar.getVisibility() == 0 || g != null && g.isStarted())
        {
            return;
        } else
        {
            g = ObjectAnimator.ofFloat(bottomButtonBar, "alpha", new float[] {
                0.0F, 1.0F
            });
            g.setInterpolator(new DecelerateInterpolator());
            g.setDuration(400L);
            g.addListener(new k(this));
            g.start();
            return;
        }
    }

    public void showErrorView(ErrorCase errorcase, android.view.View.OnClickListener onclicklistener)
    {
        hideTopBar();
        hideBottomBar();
        if (a.g())
        {
            getActionBar().show();
        }
        scanOverlayView.setVisibility(4);
        if (h == null)
        {
            h = new az(this);
            rootRelativeLayout.addView(h);
        }
        h.setErrorText(ar.a(this, errorcase.message()));
        h.setButtonText(ar.a(this, errorcase.button()));
        h.setButtonOnClickListener(onclicklistener);
        h.setVisibility(0);
    }

    public void showHelpView()
    {
        c.setVisibility(0);
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(c, "alpha", new float[] {
            0.0F, 1.0F
        });
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(c, "translationY", new float[] {
            (float)c.getAnimationHeight() * 0.2F, 0.0F
        });
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.play(objectanimator1).with(objectanimator);
        animatorset.setDuration(400L);
        animatorset.setInterpolator(new DecelerateInterpolator());
        animatorset.start();
        hideBottomBar();
    }

    public void showManualEntryView(android.view.View.OnClickListener onclicklistener, boolean flag, boolean flag1, boolean flag2, boolean flag3, ArrayList arraylist, ArrayList arraylist1)
    {
        hideTopBar();
        hideBottomBar();
        manualEntryView = new bm(this);
        manualEntryView.a(flag, flag1, flag2, flag3, arraylist, onclicklistener, arraylist1, false);
        manualEntryScrollView = new ScrollView(this);
        manualEntryScrollView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2));
        manualEntryScrollView.addView(manualEntryView);
        manualEntryScrollView.setFillViewport(true);
        rootRelativeLayout.removeAllViews();
        getWindow().setBackgroundDrawable(aq.b(this, "background_manual_entry"));
        rootRelativeLayout.addView(manualEntryScrollView);
        getActionBar().setTitle(ar.a(this, "activity_title_manual_entry"));
    }

    public void showSuccessView(NetswipeCardInformation netswipecardinformation, boolean flag, boolean flag1)
    {
        byte byte0 = 8;
        boolean flag3 = true;
        hideBottomBar();
        topInfoBar.setRightImage(null);
        scanOverlayView.setVisibility(4);
        int i1;
        boolean flag2;
        if (successView == null)
        {
            successView = new by(this);
            rootRelativeLayout.addView(successView);
        } else
        {
            successView.a();
        }
        successView.a(CharBuffer.wrap(netswipecardinformation.getExpiryDateMonth()), CharBuffer.wrap(netswipecardinformation.getExpiryDateYear()));
        successView.setCreditCardNumber(CharBuffer.wrap(netswipecardinformation.getCardNumberGrouped()));
        successView.a(netswipecardinformation.getCardType(), getResources());
        netswipecardinformation = successView;
        if (flag1)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        netswipecardinformation.setSortCodeAndAccountNumberVisibility(i1);
        successView.setSortCodeAndAccountNumberPending(flag1);
        successView.setSortCodeActive(flag1);
        successView.setAccountNumberActive(false);
        netswipecardinformation = successView;
        i1 = byte0;
        if (flag)
        {
            i1 = 0;
        }
        netswipecardinformation.setCardholderNameVisibility(i1);
        netswipecardinformation = successView;
        if (flag && !flag1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        netswipecardinformation.setCardholderNamePending(flag2);
        netswipecardinformation = successView;
        if (flag && !flag1)
        {
            flag = flag3;
        } else
        {
            flag = false;
        }
        netswipecardinformation.setCardHolderNameActive(flag);
        successView.setShowSuccessIcon(false);
        successView.setVisibility(0);
    }

    public void showTopBar()
    {
        if (topInfoBar.getAlpha() > 0.0F)
        {
            return;
        } else
        {
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(topInfoBar, "alpha", new float[] {
                0.0F, 1.0F
            });
            objectanimator.setDuration(400L);
            objectanimator.setInterpolator(new DecelerateInterpolator());
            objectanimator.addListener(new m(this));
            objectanimator.start();
            return;
        }
    }

}
