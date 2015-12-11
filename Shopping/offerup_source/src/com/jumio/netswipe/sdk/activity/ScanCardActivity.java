// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netswipe.sdk.activity;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.netswipe.sdk.NetswipeCardInformation;
import com.jumio.netswipe.sdk.NetswipeCustomScanInterface;
import com.jumio.netswipe.sdk.core.InternalCardInformation;
import com.jumio.netswipe.sdk.enums.CreditCardType;
import java.nio.CharBuffer;
import java.util.ArrayList;
import jumiomobile.bg;
import jumiomobile.bo;
import jumiomobile.bp;
import jumiomobile.bq;
import jumiomobile.by;
import jumiomobile.cb;
import jumiomobile.ce;
import jumiomobile.cf;
import jumiomobile.cg;
import jumiomobile.ch;
import jumiomobile.ci;
import jumiomobile.cl;
import jumiomobile.cm;
import jumiomobile.cs;
import jumiomobile.cv;
import jumiomobile.cy;
import jumiomobile.cz;
import jumiomobile.da;
import jumiomobile.db;
import jumiomobile.dc;
import jumiomobile.dd;
import jumiomobile.de;
import jumiomobile.df;
import jumiomobile.dg;
import jumiomobile.dh;
import jumiomobile.dm;
import jumiomobile.dy;
import jumiomobile.dz;
import jumiomobile.eb;
import jumiomobile.ec;
import jumiomobile.ed;
import jumiomobile.ep;
import jumiomobile.ew;
import jumiomobile.fb;

public class ScanCardActivity extends AppCompatActivity
    implements NetswipeCustomScanInterface, dy
{

    public static final String INTENT_EXTRA_CARD_HOLDER_NAME_EDITABLE = "INTENT_EXTRA_CARD_HOLDER_NAME_EDITABLE";
    public static final String INTENT_EXTRA_CARD_NUMBER_MASKING_ENABLED = "INTENT_EXTRA_CARD_NUMBER_MASKING_ENABLED";
    public static final String INTENT_EXTRA_CUSTOM_FIELDS = "INTENT_EXTRA_CUSTOM_FIELDS";
    public static final String INTENT_EXTRA_MANUAL_ENTRY = "INTENT_EXTRA_MANUAL_ENTRY";
    private static float t = 0.75F;
    private static float u = 1.33F;
    private ArrayList A;
    private android.view.MenuItem.OnMenuItemClickListener B;
    private android.view.View.OnClickListener C;
    private android.content.DialogInterface.OnClickListener D;
    private android.content.DialogInterface.OnClickListener E;
    boolean a;
    private dm b;
    private fb c;
    private RelativeLayout d;
    private LinearLayout e;
    private ProgressBar f;
    private TextView g;
    private TextView h;
    private bq i;
    private bq j;
    private by k;
    private TextureView l;
    private bo m;
    private ew n;
    private ScrollView o;
    private ep p;
    private ImageView q;
    private cg r;
    private AlertDialog s;
    private boolean v;
    private MenuItem w;
    private boolean x;
    private boolean y;
    private boolean z;

    public ScanCardActivity()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        a = false;
        v = false;
        w = null;
        x = true;
        y = false;
        z = true;
        B = new db(this);
        C = new dc(this);
        D = new dd(this);
        E = new de(this);
    }

    public static AlertDialog a(ScanCardActivity scancardactivity, AlertDialog alertdialog)
    {
        scancardactivity.s = alertdialog;
        return alertdialog;
    }

    public static bq a(ScanCardActivity scancardactivity)
    {
        return scancardactivity.i;
    }

    private void a()
    {
        TypedValue typedvalue = new TypedValue();
        getTheme().resolveAttribute(0x10102eb, typedvalue, true);
        m.setActionBarHeight(TypedValue.complexToDimensionPixelSize(typedvalue.data, getResources().getDisplayMetrics()));
    }

    private void a(String s1)
    {
        if (getSupportActionBar() != null)
        {
            s1 = new SpannableString(s1);
            s1.setSpan(new AbsoluteSizeSpan(20, true), 0, s1.length(), 33);
            getSupportActionBar().setTitle(s1);
        }
    }

    private void a(boolean flag)
    {
        boolean flag2 = a;
        boolean flag1 = flag2;
        if (flag)
        {
            flag1 = flag2;
            if (!v)
            {
                flag1 = false;
            }
        }
        if (flag1)
        {
            if (bp.a(q) == 0.0F)
            {
                ObjectAnimator objectanimator = bp.a(q, 0, 255);
                objectanimator.setDuration(200L);
                objectanimator.start();
            }
            return;
        } else
        {
            bp.a(q, 0);
            return;
        }
    }

    public static ew b(ScanCardActivity scancardactivity)
    {
        return scancardactivity.n;
    }

    private void b()
    {
        byte byte0 = 8;
        boolean flag = true;
        boolean flag1 = b.l();
        bq bq1 = j;
        int i1;
        if (flag1)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        bq1.setVisibility(i1);
        j.setEnabled(flag1);
        bq1 = j;
        if (b.m())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        bq1.a(i1);
        flag1 = b.i();
        bq1 = i;
        i1 = byte0;
        if (flag1)
        {
            i1 = 0;
        }
        bq1.setVisibility(i1);
        i.setEnabled(flag1);
        bq1 = i;
        if (b.j())
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        bq1.a(i1);
        if (flag1 && k != null)
        {
            b.a(k);
        }
    }

    public static LinearLayout c(ScanCardActivity scancardactivity)
    {
        return scancardactivity.e;
    }

    private void c()
    {
        if (w != null)
        {
            w.setVisible(false);
        }
        b.w();
        showInfoTextContainer(false);
        showManualEntryView(C, true, b.q(), b.o(), false, A, b.t());
    }

    public static TextView d(ScanCardActivity scancardactivity)
    {
        return scancardactivity.h;
    }

    public static void e(ScanCardActivity scancardactivity)
    {
        scancardactivity.c();
    }

    public static dm f(ScanCardActivity scancardactivity)
    {
        return scancardactivity.b;
    }

    public static ep g(ScanCardActivity scancardactivity)
    {
        return scancardactivity.p;
    }

    public static void h(ScanCardActivity scancardactivity)
    {
        scancardactivity.b();
    }

    public static MenuItem i(ScanCardActivity scancardactivity)
    {
        return scancardactivity.w;
    }

    public static boolean j(ScanCardActivity scancardactivity)
    {
        return scancardactivity.x;
    }

    public static bq k(ScanCardActivity scancardactivity)
    {
        return scancardactivity.j;
    }

    public boolean doAdditionalStep(InternalCardInformation internalcardinformation)
    {
        return b.q() && b.r() || b.o() && internalcardinformation.getCardType() != CreditCardType.PRIVATE_LABEL || A.size() != 0 || b.p() && y;
    }

    public ew getScanOverlayView()
    {
        return n;
    }

    public TextureView getTextureView()
    {
        return l;
    }

    public void hideBlurView()
    {
        m.a();
    }

    public void hideBottomButtons()
    {
        i.setVisibility(8);
        j.setVisibility(8);
    }

    public void initLayout()
    {
        int j1 = (int)bg.a(this, 10F);
        int k1 = (int)bg.a(this, 20F);
        int i1 = (int)bg.a(this, 25F);
        int i2 = (int)bg.a(this, 5F);
        int l1 = (int)bg.a(this, 17F);
        d = new RelativeLayout(this);
        Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        d.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        l = new TextureView(this);
        l.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        d.addView(l);
        n = new ew(this);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        n.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        d.addView(n);
        n.addOnLayoutChangeListener(new cz(this, i2));
        m = new bo(this);
        m.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        m.setVisibility(8);
        m.setRootRelativeLayout(d);
        a();
        d.addView(m);
        e = new LinearLayout(this);
        e.setGravity(16);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(14);
        e.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        f = new ProgressBar(this, null, 0x1010079);
        obj = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj.rightMargin = j1;
        f.getIndeterminateDrawable().setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
        f.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        e.addView(f);
        g = new TextView(this);
        obj = new android.widget.LinearLayout.LayoutParams(-2, -2);
        g.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        g.setText(ec.a(this, "scan_area_info_extraction"));
        g.setTextSize(2, 18F);
        g.setTextColor(-1);
        e.addView(g);
        d.addView(e);
        h = new TextView(this);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(14);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(0, 0, 0, i1 * 2);
        h.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        h.setTextColor(-1);
        obj = h;
        ArrayList arraylist;
        if (cs.a())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        ((TextView) (obj)).setVisibility(i1);
        d.addView(h);
        j = new bq(this);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(9);
        j.setPadding(k1, j1, k1, 0);
        arraylist = new ArrayList();
        arraylist.add(ch.a(getResources(), ch.c));
        arraylist.add(ch.a(getResources(), ch.d));
        j.a(arraylist);
        j.setVisibility(8);
        j.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        j.setOnImageSwitchedListener(new dh(this, null));
        d.addView(j);
        i = new bq(this);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        arraylist = new ArrayList();
        arraylist.add(ch.a(getResources(), ch.e));
        arraylist.add(ch.a(getResources(), ch.f));
        i.a(arraylist);
        i.setVisibility(8);
        i.setPadding(k1, j1, k1, 0);
        i.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        i.setOnImageSwitchedListener(new dg(this, null));
        d.addView(i);
        k = new by(i);
        q = new ImageView(this);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(14);
        q.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        q.setAdjustViewBounds(true);
        q.setPadding(k1, j1, k1, l1);
        q.setImageBitmap(ch.a(getResources(), ch.b));
        bp.a(q, 0);
        d.addView(q);
        setContentView(d);
    }

    public void onBackPressed()
    {
        b.a(true, false);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        boolean flag1 = true;
        super.onConfigurationChanged(configuration);
        boolean flag;
        if (configuration.orientation == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
        if (v)
        {
            int i1 = cv.a(this, "netswipe_dialogToScreenRatioPortrait", "attr");
            int j1 = cv.a(this, "netswipe_dialogToScreenRatioLandscape", "attr");
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
                f1 = t;
            } else
            {
                f2 = ((TypedArray) (obj)).getFloat(1, 0.0F);
                f1 = u;
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
        }
        if (configuration.orientation == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        rotateBlurView(flag);
        if (b.j())
        {
            i.performClick();
            if (b.s())
            {
                i.postDelayed(new cy(this), 250L);
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        getWindow().addFlags(8192);
        cl.a(new cm());
        ch.a(new ci());
        initLayout();
        b = new dm(this, this, getIntent().getExtras(), this);
        r = cf.a(this, cv.a(this, "netswipe_positiveButtonTextColor", "attr"), cf.a(), cv.a(this, "netswipe_positiveButtonBackground", "attr"), cf.b());
        int i1 = cv.a(this, "netswipe_dialogToScreenRatioPortrait", "attr");
        int k1 = cv.a(this, "netswipe_dialogToScreenRatioLandscape", "attr");
        Object obj = getTheme().obtainStyledAttributes(new int[] {
            i1, k1
        });
        Display display = getWindowManager().getDefaultDisplay();
        bundle = new DisplayMetrics();
        display.getMetrics(bundle);
        float f1;
        float f2;
        if (((DisplayMetrics) (bundle)).heightPixels > ((DisplayMetrics) (bundle)).widthPixels)
        {
            f2 = ((TypedArray) (obj)).getFloat(0, 0.0F);
            f1 = t;
        } else
        {
            f2 = ((TypedArray) (obj)).getFloat(1, 0.0F);
            f1 = u;
        }
        if (f2 != 0.0F)
        {
            v = true;
            getWindow().setFlags(2, 2);
            obj = getWindow().getAttributes();
            obj.height = (int)(f2 * (float)((DisplayMetrics) (bundle)).heightPixels);
            obj.width = (int)(f1 * (float)((android.view.WindowManager.LayoutParams) (obj)).height);
            obj.alpha = 1.0F;
            obj.dimAmount = 0.5F;
            getWindow().setAttributes(((android.view.WindowManager.LayoutParams) (obj)));
        }
        if (getSupportActionBar() != null)
        {
            a(ec.a(this, "activity_title_scan"));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            int j1 = cv.a(this, "abc_ic_clear_mtrl_alpha", "drawable");
            getSupportActionBar().setHomeAsUpIndicator(j1);
        }
        x = getIntent().getBooleanExtra("INTENT_EXTRA_MANUAL_ENTRY", true);
        y = getIntent().getBooleanExtra("INTENT_EXTRA_CARD_HOLDER_NAME_EDITABLE", false);
        z = getIntent().getBooleanExtra("INTENT_EXTRA_CARD_NUMBER_MASKING_ENABLED", true);
        A = (ArrayList)getIntent().getSerializableExtra("INTENT_EXTRA_CUSTOM_FIELDS");
        showInfoTextContainer(false);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        w = menu.add(1, 1, 1, ec.a(this, "activity_title_manual_entry"));
        w.setEnabled(x);
        w.setVisible(x);
        w.setIcon(eb.b(this, "icon_manual_entry"));
        w.setShowAsAction(2);
        w.setOnMenuItemClickListener(B);
        return true;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        b.e();
    }

    public void onNetswipeCameraAvailable()
    {
        b();
    }

    public void onNetswipeError(int i1, String s1, boolean flag, ArrayList arraylist)
    {
        Intent intent = new Intent();
        intent.putStringArrayListExtra("EXTRA_SCAN_ATTEMPTS", arraylist);
        intent.putExtra("EXTRA_ERROR_CODE", i1);
        intent.putExtra("EXTRA_ERROR_MESSAGE", s1);
        setResult(0, intent);
        finish();
    }

    public void onNetswipeExtractionFinished(NetswipeCardInformation netswipecardinformation, ArrayList arraylist)
    {
        Intent intent = new Intent();
        intent.putStringArrayListExtra("EXTRA_SCAN_ATTEMPTS", arraylist);
        intent.putExtra("EXTRA_CARD_INFORMATION", netswipecardinformation);
        setResult(-1, intent);
        finish();
    }

    public void onNetswipeExtractionStarted()
    {
        runOnUiThread(new df(this));
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            b.a(true, false);
            break;
        }
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        b.c();
        if (s != null && s.isShowing())
        {
            s.dismiss();
            s = null;
        }
    }

    protected void onResume()
    {
        super.onResume();
        b.b();
    }

    public void performAdditionalStep(InternalCardInformation internalcardinformation)
    {
        showInfoTextContainer(false);
        android.view.View.OnClickListener onclicklistener = C;
        ArrayList arraylist = A;
        boolean flag3 = z;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (b.q() && b.r())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (b.o() && internalcardinformation.getCardType() != CreditCardType.PRIVATE_LABEL)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (b.p() && y)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        showAdditionalEntryView(internalcardinformation, onclicklistener, arraylist, flag3, flag, flag1, flag2);
    }

    public void prepareBlurView(boolean flag)
    {
        m.a(l.getBitmap(), l.getTransform(null), flag);
    }

    public void presentError(dz dz1, InternalCardInformation internalcardinformation, ArrayList arraylist)
    {
        showErrorView(dz1);
    }

    public void restoreScanView()
    {
        if (c != null)
        {
            d.removeView(c);
        }
        showBottomButtons();
    }

    public void rotateBlurView(boolean flag)
    {
        m.a(flag);
    }

    public void setDebugText(String s1)
    {
        runOnUiThread(new da(this, s1));
    }

    public void showAdditionalEntryView(InternalCardInformation internalcardinformation, android.view.View.OnClickListener onclicklistener, ArrayList arraylist, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        showBlurView();
        android.widget.RelativeLayout.LayoutParams layoutparams;
        boolean flag4;
        if (!flag1)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        showTopCreditCardDataBar(internalcardinformation, flag, flag4);
        p = new ep(this, r);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        p.setLayoutParams(layoutparams);
        p.a(false, flag1, flag2, flag3, arraylist, onclicklistener, null, true);
        if (flag1)
        {
            p.a(internalcardinformation.getCardExpiryDateMonth(), internalcardinformation.getCardExpiryDateYear());
        }
        if (flag3)
        {
            p.a(CharBuffer.wrap(internalcardinformation.getCardHolderName()));
        }
        if (flag2)
        {
            p.a(internalcardinformation.getCardType());
        }
        o = new ScrollView(this);
        internalcardinformation = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        internalcardinformation.addRule(3, ed.a);
        o.setLayoutParams(internalcardinformation);
        o.addView(p);
        d.addView(o);
        a(ec.a(this, "activity_title_additional_info"));
    }

    public void showBlurView()
    {
        m.b();
    }

    public void showBottomButtons()
    {
        i.setVisibility(0);
        j.setVisibility(0);
    }

    public void showBranding(boolean flag)
    {
        a = flag;
        a(b.x());
    }

    public void showErrorView(dz dz1)
    {
        hideBottomButtons();
        android.content.DialogInterface.OnClickListener onclicklistener;
        android.app.AlertDialog.Builder builder;
        int i1;
        if (dz1.d())
        {
            onclicklistener = D;
        } else
        {
            onclicklistener = E;
        }
        if (dz1.d())
        {
            i1 = cv.a(this, "netswipe_dialogPositiveButtonTextColor", "attr");
        } else
        {
            i1 = cv.a(this, "netswipe_dialogNegativeButtonTextColor", "attr");
        }
        if (b.x() && getSupportActionBar() != null)
        {
            getSupportActionBar().show();
        }
        n.setVisibility(4);
        if (Environment.isLollipop())
        {
            builder = new android.app.AlertDialog.Builder(this, 5);
        } else
        {
            builder = new android.app.AlertDialog.Builder(this);
        }
        builder.setTitle(ec.a(this, "error_view_title"));
        builder.setMessage(ec.a(this, dz1.b()));
        builder.setPositiveButton(ec.a(this, dz1.c()), onclicklistener);
        builder.setCancelable(false);
        s = builder.show();
        s.getButton(-1).setTextColor(ce.b(this, i1, 0xff97be0d));
    }

    public void showInfoTextContainer(boolean flag)
    {
        LinearLayout linearlayout = e;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        linearlayout.setVisibility(i1);
        a(b.x());
    }

    public void showManualEntryView(android.view.View.OnClickListener onclicklistener, boolean flag, boolean flag1, boolean flag2, boolean flag3, ArrayList arraylist, ArrayList arraylist1)
    {
        cb.f();
        hideBottomButtons();
        p = new ep(this, r);
        p.a(flag, flag1, flag2, flag3, arraylist, onclicklistener, arraylist1, false);
        o = new ScrollView(this);
        o.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2));
        o.addView(p);
        o.setFillViewport(true);
        d.removeAllViews();
        getWindow().setBackgroundDrawable(eb.b(this, "background_manual_entry"));
        d.addView(o);
        a(ec.a(this, "activity_title_manual_entry"));
    }

    public void showProcessView()
    {
        hideBottomButtons();
        n.setTextVisible(false);
    }

    public void showTopCreditCardDataBar(InternalCardInformation internalcardinformation, boolean flag, boolean flag1)
    {
        c = new fb(this);
        c.setCreditCardNumber(CharBuffer.wrap(internalcardinformation.a(flag)));
        if (internalcardinformation.getCardExpiryDateMonth().length != 0 && internalcardinformation.getCardExpiryDateYear().length != 0 && flag1)
        {
            c.setExpiryDate((new StringBuilder()).append(CharBuffer.wrap(internalcardinformation.getCardExpiryDateMonth())).append(" / ").append(CharBuffer.wrap(internalcardinformation.getCardExpiryDateYear())).toString());
        }
        if (internalcardinformation.isCardAccountNumberValid() && internalcardinformation.isCardSortCodeValid() && internalcardinformation.getCardSortCode().length != 0 && internalcardinformation.getCardAccountNumber().length != 0)
        {
            c.setSortCodeAndAccountNumber((new StringBuilder()).append(CharBuffer.wrap(internalcardinformation.getCardSortCode())).append(" ").append(CharBuffer.wrap(internalcardinformation.getCardAccountNumber())).toString());
        }
        c.a(internalcardinformation.getCardType(), getResources());
        d.addView(c);
    }

}
