// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.netverify.sdk.custom.NetverifyCustomConfirmationView;
import com.jumio.netverify.sdk.custom.NetverifyCustomScanView;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVScanSide;
import com.jumio.netverify.sdk.gui.view.LivenessDetectionDebugView;
import java.util.ArrayList;

// Referenced classes of package jumiomobile:
//            bg, cv, ce, hq, 
//            mh, cf, mg, mp, 
//            mk, nk, ni, mn, 
//            mu, na, ms, ns, 
//            at, ch, mt, ml, 
//            nu, mq, nj, oo, 
//            mr, bx, bq, bp, 
//            nd, hp

public class mf
{

    public static final int A;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final int E;
    public static final int F;
    public static final int G;
    public static final int H;
    public static final int I;
    public static final int J;
    public static final int K;
    public static final int L;
    public static final int M;
    public static final int N;
    public static final int O;
    public static final int P;
    public static final int Q;
    public static final int R;
    public static final int S;
    public static final int T;
    public static final int U;
    public static final int V;
    public static final int W;
    public static final int X;
    public static final int Y;
    public static final int Z;
    public static int a = 0x9a000000;
    public static final int aA;
    public static final int aB;
    public static final int aC;
    public static final int aD;
    public static final int aE;
    private static int aF;
    private static final int aG;
    public static final int aa;
    public static final int ab;
    public static final int ac;
    public static final int ad;
    public static final int ae;
    public static final int af;
    public static final int ag;
    public static final int ah;
    public static final int ai;
    public static final int aj;
    public static final int ak;
    public static final int al;
    public static final int am;
    public static final int an;
    public static final int ao;
    public static final int ap;
    public static final int aq;
    public static final int ar;
    public static final int as;
    public static final int at;
    public static final int au;
    public static final int av;
    public static final int aw;
    public static final int ax;
    public static final int ay;
    public static final int az;
    public static int b = 0xe6000000;
    public static int c = 0xe6000000;
    public static final int d = 1;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;

    private static View a(Activity activity, NVDocumentType nvdocumenttype, hq hq1)
    {
        int i1 = (int)bg.a(activity, 10F);
        int j1 = (int)bg.a(activity, 20F);
        bg.a(activity, 33F);
        float f1 = bg.b(activity, 14F);
        Object obj3 = ce.b(activity, cv.a(activity, "netverify_infoBarTextColor", "attr"), -1);
        RelativeLayout relativelayout = new RelativeLayout(activity);
        b(relativelayout, -1, -2);
        relativelayout.setPadding(i1, 0, i1, j1);
        relativelayout.setId(ad);
        relativelayout.setAlpha(0.0F);
        Object obj = new View(activity);
        a(((View) (obj)), -1, (int)bg.a(activity, 1.0F));
        ((View) (obj)).setBackgroundColor(0x42ffffff);
        ((View) (obj)).setId(ae);
        relativelayout.addView(((View) (obj)));
        obj = new TextView(activity);
        Object obj1 = a(((View) (obj)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(3, ae);
        obj1.topMargin = j1;
        ((TextView) (obj)).setId(ag);
        ((TextView) (obj)).setTextSize(0, f1);
        ((TextView) (obj)).setTextColor(((android.content.res.ColorStateList) (obj3)));
        relativelayout.addView(((View) (obj)));
        obj1 = new ImageView(activity);
        Object obj2 = a(((View) (obj1)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(3, ag);
        obj2.topMargin = i1;
        ((ImageView) (obj1)).setId(aj);
        ((ImageView) (obj1)).setScaleType(android.widget.ImageView.ScaleType.CENTER);
        relativelayout.addView(((View) (obj1)));
        obj2 = new TextView(activity);
        Object obj4 = a(((View) (obj2)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj4)).addRule(3, aj);
        obj4.topMargin = i1;
        ((TextView) (obj2)).setId(ah);
        ((TextView) (obj2)).setTextSize(0, f1);
        ((TextView) (obj2)).setTextColor(((android.content.res.ColorStateList) (obj3)));
        relativelayout.addView(((View) (obj2)));
        obj4 = new ImageView(activity);
        Object obj5 = a(((View) (obj4)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj5)).addRule(3, ah);
        obj5.topMargin = i1;
        obj5.bottomMargin = j1 + i1;
        ((ImageView) (obj4)).setId(ak);
        ((ImageView) (obj4)).setScaleType(android.widget.ImageView.ScaleType.CENTER);
        relativelayout.addView(((View) (obj4)));
        obj5 = new TextView(activity);
        Object obj6 = a(((View) (obj5)), -1, -2);
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if (hq1.equals(hq.k))
        {
            ((android.widget.RelativeLayout.LayoutParams) (obj6)).addRule(8, ak);
            obj6.bottomMargin = 15;
        } else
        {
            ((android.widget.RelativeLayout.LayoutParams) (obj6)).addRule(3, ak);
            obj6.topMargin = i1;
        }
        ((TextView) (obj5)).setId(ai);
        ((TextView) (obj5)).setTextSize(0, f1);
        ((TextView) (obj5)).setTextColor(((android.content.res.ColorStateList) (obj3)));
        relativelayout.addView(((View) (obj5)));
        obj3 = new ImageView(activity);
        obj6 = a(((View) (obj3)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj6)).addRule(7, ak);
        ((android.widget.RelativeLayout.LayoutParams) (obj6)).addRule(8, ak);
        obj6.bottomMargin = -j1 - i1;
        ((ImageView) (obj3)).setId(af);
        ((ImageView) (obj3)).setImageBitmap(mh.a(activity.getResources(), mh.ai));
        if (hq1.equals(hq.m) || hq1.equals(hq.k))
        {
            ((ImageView) (obj3)).setVisibility(4);
        }
        relativelayout.addView(((View) (obj3)));
        obj6 = new Button(activity);
        layoutparams = a(((View) (obj6)), -1, -2);
        layoutparams.addRule(3, af);
        layoutparams.topMargin = j1 + j1;
        ((Button) (obj6)).setVisibility(8);
        ((Button) (obj6)).setId(al);
        ((Button) (obj6)).setTypeface(Typeface.create("sans-serif-regular", 0));
        cf.a(activity, ((Button) (obj6)), cf.a(activity, cv.a(activity, "netverify_fallbackButtonTextColor", "attr"), cf.a(), cv.a(activity, "netverify_fallbackButtonBackground", "attr"), cf.d()));
        relativelayout.addView(((View) (obj6)));
        a(((Context) (activity)), nvdocumenttype, hq1, ((TextView) (obj)), ((TextView) (obj2)), ((TextView) (obj5)), ((ImageView) (obj1)), ((ImageView) (obj4)), ((ImageView) (obj3)), ((Button) (obj6)));
        return relativelayout;
    }

    private static View a(Context context, hq hq1, hp hp, NVScanSide nvscanside, boolean flag, nu nu1)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        if (hq1 != null) goto _L2; else goto _L1
_L1:
        hp = obj;
_L12:
        return hp;
_L2:
        mg.a[hq1.ordinal()];
        JVM INSTR tableswitch 1 13: default 88
    //                   1 129
    //                   2 129
    //                   3 161
    //                   4 161
    //                   5 161
    //                   6 175
    //                   7 175
    //                   8 189
    //                   9 189
    //                   10 202
    //                   11 216
    //                   12 230
    //                   13 242;
           goto _L3 _L4 _L4 _L5 _L5 _L5 _L6 _L6 _L7 _L7 _L8 _L9 _L10 _L11
_L3:
        hq1 = obj1;
_L13:
        hp = hq1;
        if (hq1 instanceof mp)
        {
            nu1 = (mp)hq1;
            boolean flag1;
            if (nvscanside == NVScanSide.FRONT)
            {
                hp = "use_front_side_of_card";
            } else
            {
                hp = "use_back_side_of_card";
            }
            nu1.setOverlayText(mk.a(context, hp));
            return hq1;
        }
        if (true) goto _L12; else goto _L4
_L4:
        if (hq1 == hq.b)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        hq1 = new nk(context, flag, flag1);
          goto _L13
_L5:
        hq1 = new ni(context, hp, hq1);
          goto _L13
_L6:
        hq1 = new mn(context, nu1);
          goto _L13
_L7:
        hq1 = new mu(context, hp);
          goto _L13
_L8:
        hq1 = new mn(context, nu1);
          goto _L13
_L9:
        hq1 = new na(context, nu1);
          goto _L13
_L10:
        hq1 = new ms(context);
          goto _L13
_L11:
        hq1 = new ns(context, nu1);
          goto _L13
    }

    public static ViewGroup a(Activity activity, int i1, int j1)
    {
        int k1 = (int)bg.a(activity, 15F);
        int l1 = (int)bg.a(activity, 5F);
        RelativeLayout relativelayout = new RelativeLayout(activity);
        a(((View) (relativelayout)), -1, -2);
        Object obj = new ImageView(activity);
        a(((View) (obj)), -2, -2);
        ((ImageView) (obj)).setAdjustViewBounds(true);
        ((ImageView) (obj)).setId(o);
        relativelayout.addView(((View) (obj)));
        obj = new LinearLayout(activity);
        Object obj1 = a(((View) (obj)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(1, o);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(k1, 0, 0, 0);
        ((LinearLayout) (obj)).setOrientation(1);
        relativelayout.addView(((View) (obj)));
        obj1 = new TextView(activity);
        ((TextView) (obj1)).setId(p);
        ((TextView) (obj1)).setTextSize(0, activity.getResources().getDimension(cv.a(activity, "textXLarge", "dimen")));
        ((TextView) (obj1)).setTextColor(0xff000000);
        ((LinearLayout) (obj)).addView(((View) (obj1)));
        obj = new ProgressBar(activity, null, 0x1010079);
        obj1 = a(((View) (obj)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(1, p);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(4, p);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(l1, 0, l1, 0);
        ((ProgressBar) (obj)).setId(q);
        ((ProgressBar) (obj)).setVisibility(8);
        ((ProgressBar) (obj)).setIndeterminate(true);
        jumiomobile.at.a(((ProgressBar) (obj)).getIndeterminateDrawable(), 0xff666666);
        relativelayout.addView(((View) (obj)));
        if (Environment.isLollipop())
        {
            activity = b(activity);
            activity.setContentPadding(0, 0, 0, 0);
            activity.addView(relativelayout);
            return activity;
        } else
        {
            a(((View) (relativelayout)), ((Drawable) (cf.a(activity, i1, j1))));
            return relativelayout;
        }
    }

    public static FrameLayout a(Activity activity)
    {
        activity = new FrameLayout(activity);
        activity.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        activity.setId(R);
        return activity;
    }

    private static android.widget.RelativeLayout.LayoutParams a(View view, int i1, int j1)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(i1, j1);
        view.setLayoutParams(layoutparams);
        return layoutparams;
    }

    public static RelativeLayout a(Activity activity, boolean flag)
    {
        int i1 = 0;
        int j1 = (int)bg.a(activity, 5F);
        int k1 = (int)bg.a(activity, 10F);
        int l1 = (int)bg.a(activity, 17F);
        RelativeLayout relativelayout = new RelativeLayout(activity);
        a(((View) (relativelayout)), -1, -1);
        Object obj = new ProgressBar(activity, null, 0x1010287);
        android.widget.RelativeLayout.LayoutParams layoutparams = a(((View) (obj)), -2, -2);
        layoutparams.addRule(13);
        ((ProgressBar) (obj)).setLayoutParams(layoutparams);
        ((ProgressBar) (obj)).setVisibility(0);
        ((ProgressBar) (obj)).setId(aG);
        jumiomobile.at.a(((ProgressBar) (obj)).getIndeterminateDrawable(), 0xff666666);
        relativelayout.addView(((View) (obj)));
        obj = new ImageView(activity);
        layoutparams = a(((View) (obj)), -2, -2);
        layoutparams.addRule(12);
        layoutparams.addRule(14);
        layoutparams.setMargins(0, j1, k1, l1);
        ((ImageView) (obj)).setAdjustViewBounds(true);
        ((ImageView) (obj)).setImageBitmap(ch.a(activity.getResources(), ch.b));
        ((ImageView) (obj)).setId(m);
        if (!flag)
        {
            i1 = 4;
        }
        ((ImageView) (obj)).setVisibility(i1);
        relativelayout.addView(((View) (obj)));
        return relativelayout;
    }

    public static mt a(Context context, hq hq1, hp hp, NVScanSide nvscanside, RelativeLayout relativelayout, boolean flag, nu nu1)
    {
        View view = relativelayout.findViewById(U);
        int i1 = relativelayout.indexOfChild(view);
        relativelayout.removeView(view);
        context = a(context, hq1, hp, nvscanside, flag, nu1);
        a(((View) (context)), -1, -1);
        relativelayout.addView(context, i1);
        return (mt)context;
    }

    public static void a(Activity activity, RelativeLayout relativelayout, NVDocumentType nvdocumenttype, hq hq1)
    {
        View view = e(activity);
        ScrollView scrollview = new ScrollView(activity);
        android.widget.RelativeLayout.LayoutParams layoutparams = a(((View) (scrollview)), -1, -2);
        layoutparams.addRule(10);
        layoutparams.addRule(12);
        scrollview.setBackgroundColor(a);
        scrollview.setVisibility(4);
        scrollview.setId(ac);
        scrollview.addView(a(activity, nvdocumenttype, hq1));
        boolean flag;
        if (hq1 == hq.m)
        {
            nvdocumenttype = new ml(activity);
        } else
        {
            nvdocumenttype = new mq(activity, false, false);
        }
        nvdocumenttype.setId(J);
        if (hq1 != hq.j && hq1 != hq.l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        nvdocumenttype.setShowHelpButton(flag);
        activity = new RelativeLayout(activity);
        a(((View) (activity)), -2, -2);
        activity.setId(V);
        relativelayout.addView(activity);
        relativelayout.addView(scrollview);
        relativelayout.addView(view);
        nvdocumenttype.a(false, false);
        nvdocumenttype.setCenterText(false);
        relativelayout.addView(nvdocumenttype);
        scrollview.setPadding(0, nvdocumenttype.getCurrentHeight(), 0, 0);
    }

    public static void a(Activity activity, RelativeLayout relativelayout, boolean flag)
    {
        relativelayout = (LinearLayout)relativelayout.findViewById(au);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)relativelayout.getLayoutParams();
        float f1;
        if (flag)
        {
            f1 = 59F;
        } else
        {
            f1 = 39F;
        }
        layoutparams.height = (int)bg.a(activity, f1);
        relativelayout.setLayoutParams(layoutparams);
    }

    public static void a(Activity activity, ScrollView scrollview, boolean flag)
    {
        boolean flag1 = false;
        int j1 = (int)bg.a(activity, 10F);
        int k1 = (int)bg.a(activity, 20F);
        float f1;
        if (flag)
        {
            f1 = 59F;
        } else
        {
            f1 = 39F;
        }
        scrollview.setPadding(0, (int)bg.a(activity, f1), 0, 0);
        activity = (ImageView)scrollview.findViewById(af);
        if (activity != null)
        {
            activity = (android.widget.RelativeLayout.LayoutParams)activity.getLayoutParams();
            int i1;
            if (flag)
            {
                i1 = -k1 - j1;
            } else
            {
                i1 = 0;
            }
            activity.bottomMargin = i1;
        }
        activity = (ImageView)scrollview.findViewById(ak);
        if (activity != null)
        {
            activity = (android.widget.RelativeLayout.LayoutParams)activity.getLayoutParams();
            i1 = ((flag1) ? 1 : 0);
            if (flag)
            {
                i1 = k1 + j1;
            }
            activity.bottomMargin = i1;
        }
    }

    public static void a(Context context)
    {
        a = ce.a(context, cv.a(context, "netverify_infoBarBackgroundColor", "attr"), 0x9a000000);
        int i1 = ce.a(context, cv.a(context, "netverify_infoBarActiveBackgroundColor", "attr"), 0xe6000000);
        b = i1;
        c = i1;
    }

    public static void a(Context context, RelativeLayout relativelayout)
    {
        context = new mn(context, null);
        a(((View) (context)), -2, -2).addRule(10);
        context.setId(U);
        relativelayout.addView(context);
    }

    public static void a(Context context, NVDocumentType nvdocumenttype, hq hq1, RelativeLayout relativelayout)
    {
        a(context, nvdocumenttype, hq1, (TextView)relativelayout.findViewById(ag), (TextView)relativelayout.findViewById(ah), (TextView)relativelayout.findViewById(ai), (ImageView)relativelayout.findViewById(aj), (ImageView)relativelayout.findViewById(ak), (ImageView)relativelayout.findViewById(af), (Button)relativelayout.findViewById(al));
    }

    private static void a(Context context, NVDocumentType nvdocumenttype, hq hq1, TextView textview, TextView textview1, TextView textview2, ImageView imageview, ImageView imageview1, 
            ImageView imageview2, Button button)
    {
        if (hq1 == hq.a)
        {
            textview.setText(mk.a(context, "help_view_passport"));
            textview1.setText(mk.a(context, "help_view_mrz"));
            imageview.setImageBitmap(mh.a(context.getResources(), mh.aa));
            imageview1.setImageBitmap(mh.a(context.getResources(), mh.ab));
            textview.setVisibility(0);
            imageview.setVisibility(0);
            textview2.setVisibility(8);
            button.setText(mk.a(context, "help_view_fallback_button_mrz"));
        } else
        if (hq1 == hq.b)
        {
            textview.setText(mk.a(context, "help_view_visa"));
            textview1.setText(mk.a(context, "help_view_mrz"));
            imageview.setImageBitmap(mh.a(context.getResources(), mh.ag));
            imageview1.setImageBitmap(mh.a(context.getResources(), mh.ah));
            textview.setVisibility(0);
            imageview.setVisibility(0);
            textview2.setVisibility(8);
            button.setText(mk.a(context, "help_view_fallback_button_mrv"));
        } else
        if (hq1 == hq.c || hq1 == hq.d || hq1 == hq.e)
        {
            int i1;
            if (nvdocumenttype == NVDocumentType.DRIVER_LICENSE)
            {
                nvdocumenttype = "help_view_driverlicense_mrz";
            } else
            {
                nvdocumenttype = "help_view_idcard";
            }
            textview.setText(mk.a(context, nvdocumenttype));
            textview1.setText(mk.a(context, "help_view_mrz"));
            nvdocumenttype = context.getResources();
            if (hq1 == hq.c)
            {
                i1 = mh.ac;
            } else
            {
                i1 = mh.ae;
            }
            imageview.setImageBitmap(mh.a(nvdocumenttype, i1));
            nvdocumenttype = context.getResources();
            if (hq1 == hq.c)
            {
                i1 = mh.ad;
            } else
            {
                i1 = mh.af;
            }
            imageview1.setImageBitmap(mh.a(nvdocumenttype, i1));
            textview.setVisibility(0);
            imageview.setVisibility(0);
            textview2.setVisibility(8);
            button.setText(mk.a(context, "help_view_fallback_button_mrz"));
        } else
        if (hq1 == hq.h || hq1 == hq.i)
        {
            textview.setText(null);
            textview1.setText(mk.a(context, "help_view_linefind"));
            imageview.setImageBitmap(null);
            imageview1.setImageBitmap(mh.a(context.getResources(), mh.Z));
            textview.setVisibility(8);
            imageview.setVisibility(8);
            textview2.setVisibility(8);
        } else
        if (hq1 == hq.f)
        {
            textview.setText(null);
            textview1.setText(mk.a(context, "help_view_driverlicense_barcode"));
            imageview.setImageBitmap(null);
            imageview1.setImageBitmap(mh.a(context.getResources(), mh.Y));
            textview.setVisibility(8);
            imageview.setVisibility(8);
            textview2.setVisibility(8);
            button.setText(mk.a(context, "help_view_fallback_button_barcode"));
        } else
        if (hq1 == hq.j)
        {
            textview.setVisibility(8);
            textview1.setVisibility(8);
            imageview.setVisibility(8);
            imageview1.setVisibility(8);
            textview2.setVisibility(8);
        } else
        if (hq1 == hq.k)
        {
            textview.setText(mk.a(context, "help_view_liveness_line1"));
            textview1.setText(mk.a(context, "help_view_liveness_line2"));
            textview2.setText(mk.a(context, "help_view_liveness_line3"));
            imageview.setImageBitmap(mh.a(context.getResources(), mh.an));
            imageview1.setImageBitmap(mh.a(context.getResources(), mh.ao));
            textview2.setVisibility(0);
        } else
        if (hq1 == hq.m)
        {
            textview.setText(mk.a(context, "help_view_templatematcher_dl_line1"));
            textview1.setText(mk.a(context, "help_view_templatematcher_dl_line2"));
            imageview.setImageBitmap(mh.a(context.getResources(), mh.ak));
            imageview1.setImageBitmap(mh.a(context.getResources(), mh.aj));
            button.setText(mk.a(context, "help_view_templatematcher_fallback"));
            textview2.setVisibility(8);
        }
        context = (android.widget.RelativeLayout.LayoutParams)imageview2.getLayoutParams();
        if (textview2.getVisibility() == 8)
        {
            context.addRule(8, ak);
        } else
        {
            context.addRule(8, ai);
        }
        button.setVisibility(8);
    }

    public static void a(View view, Drawable drawable)
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            view.setBackgroundDrawable(drawable);
            return;
        } else
        {
            view.setBackground(drawable);
            return;
        }
    }

    public static void a(RelativeLayout relativelayout, hq hq1, hp hp, NVScanSide nvscanside, boolean flag, nu nu1)
    {
        hp = a(relativelayout.getContext(), hq1, hp, nvscanside, flag, nu1);
        if (hp != null)
        {
            a(((View) (hp)), -1, -1).addRule(10);
            hp.setId(U);
            relativelayout.addView(hp);
        }
        if (oo.a())
        {
            hp = relativelayout.getContext();
            if (hq.k.equals(hq1))
            {
                hq1 = new LivenessDetectionDebugView(hp);
            } else
            {
                hq1 = new mr(hp);
            }
            a(((View) (hq1)), -1, -1);
            hq1.setId(ab);
            relativelayout.addView(hq1);
        }
    }

    public static void a(NetverifyCustomConfirmationView netverifycustomconfirmationview)
    {
        bg.a(netverifycustomconfirmationview.getContext(), 5F);
        bx bx1 = new bx(netverifycustomconfirmationview.getContext());
        a(((View) (bx1)), -1, -2).addRule(13);
        bx1.setId(aq);
        bx1.setVisibility(0);
        netverifycustomconfirmationview.addView(bx1);
    }

    public static void a(NetverifyCustomScanView netverifycustomscanview, boolean flag)
    {
        Context context = netverifycustomscanview.getContext();
        int j1 = (int)bg.a(context, 10F);
        int k1 = (int)bg.a(context, 20F);
        int l1 = (int)bg.a(context, 17F);
        Object obj = new TextureView(context);
        a(((View) (obj)), -1, -1);
        ((TextureView) (obj)).setId(T);
        netverifycustomscanview.addView(((View) (obj)));
        obj = new ImageView(context);
        android.widget.RelativeLayout.LayoutParams layoutparams = a(((View) (obj)), -2, -2);
        layoutparams.addRule(12);
        layoutparams.addRule(14);
        ((ImageView) (obj)).setAdjustViewBounds(true);
        ((ImageView) (obj)).setImageBitmap(ch.a(context.getResources(), ch.b));
        ((ImageView) (obj)).setId(m);
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        ((ImageView) (obj)).setVisibility(i1);
        ((ImageView) (obj)).setPadding(k1, j1, k1, l1);
        netverifycustomscanview.addView(((View) (obj)));
    }

    private static CardView b(Context context)
    {
        CardView cardview = new CardView(context);
        int i1 = (int)bg.a(context, 20F);
        context = context.obtainStyledAttributes(new int[] {
            0x101030e
        });
        Drawable drawable = context.getDrawable(0);
        context.recycle();
        cardview.setForeground(drawable);
        cardview.setUseCompatPadding(true);
        cardview.setMaxCardElevation(0.0F);
        cardview.setClickable(true);
        cardview.setContentPadding(0, i1, 0, i1);
        return cardview;
    }

    public static ViewGroup b(Activity activity, int i1, int j1)
    {
        int k1 = (int)bg.a(activity, 15F);
        int l1 = (int)bg.a(activity, 5F);
        RelativeLayout relativelayout = new RelativeLayout(activity);
        a(relativelayout, -1, -2);
        Object obj = new ImageView(activity);
        a(((View) (obj)), -2, -2);
        ((ImageView) (obj)).setAdjustViewBounds(true);
        ((ImageView) (obj)).setId(aC);
        relativelayout.addView(((View) (obj)));
        obj = new LinearLayout(activity);
        Object obj1 = a(((View) (obj)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(1, aC);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(k1, 0, 0, 0);
        ((LinearLayout) (obj)).setOrientation(1);
        relativelayout.addView(((View) (obj)));
        obj1 = new TextView(activity);
        ((TextView) (obj1)).setId(aD);
        ((TextView) (obj1)).setTextSize(0, activity.getResources().getDimension(cv.a(activity, "textXLarge", "dimen")));
        ((TextView) (obj1)).setTextColor(0xff000000);
        ((LinearLayout) (obj)).addView(((View) (obj1)));
        obj = new ProgressBar(activity, null, 0x1010079);
        obj1 = a(((View) (obj)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(1, aD);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(4, aD);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(l1, 0, l1, 0);
        ((ProgressBar) (obj)).setId(aE);
        ((ProgressBar) (obj)).setVisibility(8);
        ((ProgressBar) (obj)).setIndeterminate(true);
        jumiomobile.at.a(((ProgressBar) (obj)).getIndeterminateDrawable(), 0xff666666);
        relativelayout.addView(((View) (obj)));
        if (Environment.isLollipop())
        {
            activity = b(((Context) (activity)));
            activity.setContentPadding(0, 0, 0, 0);
            activity.addView(relativelayout);
            return activity;
        } else
        {
            a(relativelayout, cf.a(activity, i1, j1));
            return relativelayout;
        }
    }

    private static android.widget.LinearLayout.LayoutParams b(View view, int i1, int j1)
    {
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(i1, j1);
        view.setLayoutParams(layoutparams);
        return layoutparams;
    }

    public static RelativeLayout b(Activity activity)
    {
        int i1 = (int)bg.a(activity, 10F);
        int j1 = (int)bg.a(activity, 20F);
        RelativeLayout relativelayout = new RelativeLayout(activity);
        a(relativelayout, -1, -1);
        relativelayout.setId(d);
        Object obj = new NetverifyCustomScanView(activity);
        a(((View) (obj)), -1, -1);
        ((NetverifyCustomScanView) (obj)).setId(S);
        relativelayout.addView(((View) (obj)));
        obj = new bq(activity);
        Object obj1 = a(((View) (obj)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(9);
        ((bq) (obj)).setPadding(j1, i1, j1, 0);
        ((bq) (obj)).setId(Z);
        obj1 = new ArrayList();
        ((ArrayList) (obj1)).add(ch.a(activity.getResources(), ch.c));
        ((ArrayList) (obj1)).add(ch.a(activity.getResources(), ch.d));
        ((bq) (obj)).a(((ArrayList) (obj1)));
        ((bq) (obj)).setAlpha(0.7F);
        ((bq) (obj)).setVisibility(8);
        relativelayout.addView(((View) (obj)));
        obj = new bq(activity);
        obj1 = a(((View) (obj)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
        ((bq) (obj)).setId(aa);
        obj1 = new ArrayList();
        ((ArrayList) (obj1)).add(ch.a(activity.getResources(), ch.e));
        ((ArrayList) (obj1)).add(ch.a(activity.getResources(), ch.f));
        ((bq) (obj)).a(((ArrayList) (obj1)));
        ((bq) (obj)).setVisibility(8);
        ((bq) (obj)).setPadding(j1, i1, j1, 0);
        relativelayout.addView(((View) (obj)));
        obj = new ImageView(activity);
        ((ImageView) (obj)).setImageResource(cv.a(activity, "netverify_button_shutter", "drawable"));
        activity = a(((View) (obj)), -2, -2);
        activity.addRule(14);
        activity.addRule(12);
        ((ImageView) (obj)).setId(Y);
        ((ImageView) (obj)).setVisibility(8);
        relativelayout.addView(((View) (obj)));
        return relativelayout;
    }

    public static RelativeLayout b(Activity activity, boolean flag)
    {
        int i1 = (int)bg.a(activity, 5F);
        int j1 = (int)bg.a(activity, 10F);
        int k1 = (int)bg.a(activity, 20F);
        int l1 = (int)bg.a(activity, 17F);
        RelativeLayout relativelayout = new RelativeLayout(activity);
        a(relativelayout, -1, -1);
        Object obj = new mq(activity);
        ((nu) (obj)).setText(mk.a(activity, "infobar_issuer_country"));
        ((nu) (obj)).setId(J);
        relativelayout.addView(((View) (obj)));
        Object obj1;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if (Environment.isLollipop())
        {
            obj = b(((Context) (activity)));
        } else
        {
            obj = new RelativeLayout(activity);
            a(((View) (obj)), cf.a(activity, mh.G, mh.K));
            ((ViewGroup) (obj)).setPadding(0, k1, 0, k1);
        }
        obj1 = a(((View) (obj)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(14);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(3, J);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(0, k1 * 2, 0, 0);
        ((ViewGroup) (obj)).setId(f);
        relativelayout.addView(((View) (obj)));
        obj1 = new RelativeLayout(activity);
        a(((View) (obj1)), -1, -2).addRule(13);
        ((ViewGroup) (obj)).addView(((View) (obj1)));
        obj = new ImageView(activity);
        layoutparams = a(((View) (obj)), -2, -2);
        layoutparams.addRule(5, h);
        layoutparams.addRule(7, h);
        layoutparams.addRule(6, h);
        layoutparams.addRule(8, h);
        layoutparams.addRule(14);
        ((ImageView) (obj)).setAdjustViewBounds(true);
        ((ImageView) (obj)).setPadding(0, 0, 0, (int)bg.a(activity, 2.0F));
        ((ImageView) (obj)).setImageBitmap(mh.a(activity.getResources(), mh.E));
        ((ImageView) (obj)).setId(g);
        ((RelativeLayout) (obj1)).addView(((View) (obj)));
        obj = new ImageView(activity);
        a(((View) (obj)), -2, -2).addRule(14);
        ((ImageView) (obj)).setAdjustViewBounds(true);
        ((ImageView) (obj)).setImageBitmap(mh.a(activity.getResources(), mh.F));
        ((ImageView) (obj)).setId(h);
        ((RelativeLayout) (obj1)).addView(((View) (obj)));
        obj = new TextView(activity);
        layoutparams = a(((View) (obj)), -1, -2);
        layoutparams.addRule(3, g);
        layoutparams.setMargins(0, i1, 0, 0);
        ((TextView) (obj)).setGravity(1);
        ((TextView) (obj)).setTextColor(0xff333333);
        ((TextView) (obj)).setId(i);
        ((TextView) (obj)).setTextSize(0, activity.getResources().getDimension(cv.a(activity, "textLarge", "dimen")));
        ((RelativeLayout) (obj1)).addView(((View) (obj)));
        obj = new ProgressBar(activity, null, 0x1010079);
        layoutparams = a(((View) (obj)), -2, -2);
        layoutparams.addRule(11);
        layoutparams.addRule(15);
        layoutparams.setMargins(i1, 0, i1, 0);
        ((ProgressBar) (obj)).setId(j);
        ((ProgressBar) (obj)).setVisibility(8);
        ((ProgressBar) (obj)).setIndeterminate(true);
        jumiomobile.at.a(((ProgressBar) (obj)).getIndeterminateDrawable(), 0xff666666);
        ((RelativeLayout) (obj1)).addView(((View) (obj)));
        if (Environment.isLollipop())
        {
            obj = b(((Context) (activity)));
            ((CardView)obj).setContentPadding(0, 0, 0, 0);
        } else
        {
            obj = new RelativeLayout(activity);
            a(((View) (obj)), cf.a(activity, mh.G, mh.K));
        }
        ((ViewGroup) (obj)).setId(k);
        obj1 = a(((View) (obj)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(14);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(3, f);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(0, k1 * 2, 0, 0);
        relativelayout.addView(((View) (obj)));
        obj1 = new TextView(activity);
        ((TextView) (obj1)).setId(l);
        a(((View) (obj1)), ((Drawable) (null)));
        ((TextView) (obj1)).setText(mk.a(activity, "button_select_another_country"));
        ((TextView) (obj1)).setTextSize(0, activity.getResources().getDimension(cv.a(activity, "textMedium", "dimen")));
        ((TextView) (obj1)).setTextColor(0xff666666);
        ((TextView) (obj1)).setPadding(j1, i1 * 3, j1, i1 * 3);
        a(((View) (obj1)), -1, -2).addRule(14);
        ((TextView) (obj1)).setGravity(1);
        ((ViewGroup) (obj)).addView(((View) (obj1)));
        obj = new ImageView(activity);
        obj1 = a(((View) (obj)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(14);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(0, i1, j1, l1);
        ((ImageView) (obj)).setAdjustViewBounds(true);
        ((ImageView) (obj)).setImageBitmap(ch.a(activity.getResources(), ch.b));
        ((ImageView) (obj)).setId(m);
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        ((ImageView) (obj)).setVisibility(i1);
        relativelayout.addView(((View) (obj)));
        return relativelayout;
    }

    public static ViewGroup c(Activity activity, int i1, int j1)
    {
        int k1 = (int)bg.a(activity, 0.5F);
        int l1 = (int)bg.a(activity, 2.0F);
        int i2 = (int)bg.a(activity, 10F);
        int j2 = (int)bg.a(activity, 20F);
        int k2 = (int)bg.a(activity, 100F);
        int l2 = (int)Math.round((double)k2 * 0.84999999999999998D);
        RelativeLayout relativelayout = new RelativeLayout(activity);
        relativelayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        relativelayout.setPadding(k1, k1, i2, l1);
        Object obj = new RelativeLayout(activity);
        a(((View) (obj)), k2, k2);
        ((RelativeLayout) (obj)).setId(v);
        relativelayout.addView(((View) (obj)));
        Object obj1 = new ImageView(activity);
        a(((View) (obj1)), l2, l2).addRule(13);
        ((ImageView) (obj1)).setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        ((ImageView) (obj1)).setAdjustViewBounds(true);
        ((ImageView) (obj1)).setId(w);
        ((ImageView) (obj1)).setBackgroundColor(Color.parseColor("#00000000"));
        ((RelativeLayout) (obj)).addView(((View) (obj1)));
        obj1 = new ImageView(activity);
        Object obj2 = a(((View) (obj1)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(2, w);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(5, w);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(7, w);
        ((ImageView) (obj1)).setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        ((ImageView) (obj1)).setId(x);
        ((ImageView) (obj1)).setImageBitmap(mh.a(activity.getResources(), mh.A));
        ((ImageView) (obj1)).setVisibility(4);
        ((RelativeLayout) (obj)).addView(((View) (obj1)));
        obj1 = new ImageView(activity);
        obj2 = a(((View) (obj1)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(3, w);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(5, w);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(7, w);
        ((ImageView) (obj1)).setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        ((ImageView) (obj1)).setId(y);
        ((ImageView) (obj1)).setImageBitmap(mh.a(activity.getResources(), mh.B));
        ((ImageView) (obj1)).setVisibility(4);
        ((RelativeLayout) (obj)).addView(((View) (obj1)));
        obj1 = new ImageView(activity);
        obj2 = a(((View) (obj1)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(0, w);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(6, w);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(8, w);
        ((ImageView) (obj1)).setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        ((ImageView) (obj1)).setId(z);
        ((ImageView) (obj1)).setImageBitmap(mh.a(activity.getResources(), mh.D));
        ((ImageView) (obj1)).setVisibility(4);
        ((RelativeLayout) (obj)).addView(((View) (obj1)));
        obj1 = new ImageView(activity);
        obj2 = a(((View) (obj1)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(1, w);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(6, w);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(8, w);
        ((ImageView) (obj1)).setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        ((ImageView) (obj1)).setId(A);
        ((ImageView) (obj1)).setImageBitmap(mh.a(activity.getResources(), mh.C));
        ((ImageView) (obj1)).setVisibility(4);
        ((RelativeLayout) (obj)).addView(((View) (obj1)));
        obj = new LinearLayout(activity);
        obj1 = a(((View) (obj)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(1, v);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(j2, 0, 0, 0);
        ((LinearLayout) (obj)).setOrientation(1);
        ((LinearLayout) (obj)).setId(B);
        relativelayout.addView(((View) (obj)));
        obj2 = new TextView(activity);
        obj1 = ce.a(0xff000000, 0xffcccccc, 0xff000000);
        a(((View) (obj2)), -1, -2);
        ((TextView) (obj2)).setTextColor(((android.content.res.ColorStateList) (obj1)));
        ((TextView) (obj2)).setId(C);
        ((TextView) (obj2)).setTextSize(0, activity.getResources().getDimension(cv.a(activity, "textSmall", "dimen")));
        ((TextView) (obj2)).setTypeface(null, 1);
        ((LinearLayout) (obj)).addView(((View) (obj2)));
        obj2 = new TextView(activity);
        a(((View) (obj2)), -1, -2);
        ((TextView) (obj2)).setTextColor(((android.content.res.ColorStateList) (obj1)));
        ((TextView) (obj2)).setId(D);
        ((TextView) (obj2)).setTextSize(0, activity.getResources().getDimension(cv.a(activity, "textSmall", "dimen")));
        ((LinearLayout) (obj)).addView(((View) (obj2)));
        obj = new RelativeLayout(activity);
        obj1 = a(((View) (obj)), -1, k2 - j2 * 2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(1, v);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(j2, 0, 0, 0);
        ((RelativeLayout) (obj)).setId(E);
        ((RelativeLayout) (obj)).setVisibility(8);
        relativelayout.addView(((View) (obj)));
        ((RelativeLayout) (obj)).addView(d(activity));
        if (Environment.isLollipop())
        {
            activity = b(activity);
            activity.setContentPadding(0, 0, 0, 0);
            activity.addView(relativelayout);
            return activity;
        } else
        {
            a(relativelayout, cf.a(activity, i1, j1));
            return relativelayout;
        }
    }

    public static RelativeLayout c(Activity activity)
    {
        int i1 = (int)bg.a(activity, 10F);
        int j1 = (int)bg.a(activity, 5F);
        RelativeLayout relativelayout = new RelativeLayout(activity);
        relativelayout.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
        relativelayout.setPadding(i1, i1, i1, i1);
        relativelayout.setClickable(false);
        relativelayout.setDescendantFocusability(0x60000);
        bp.a(relativelayout, cf.a(activity, cf.e()));
        Object obj = new TextView(activity, null, 0x1010040);
        android.widget.RelativeLayout.LayoutParams layoutparams = a(((View) (obj)), -2, -2);
        layoutparams.addRule(3, I);
        layoutparams.addRule(15);
        layoutparams.setMargins(i1, 0, 0, 0);
        ((TextView) (obj)).setId(i);
        ((TextView) (obj)).setTextColor(0xff333333);
        relativelayout.addView(((View) (obj)));
        activity = new ProgressBar(activity, null, 0x1010079);
        obj = a(activity, -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(6, i);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(8, i);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(j1, 0, j1, 0);
        activity.setId(j);
        activity.setVisibility(8);
        activity.setIndeterminate(true);
        jumiomobile.at.a(activity.getIndeterminateDrawable(), 0xff666666);
        relativelayout.addView(activity);
        return relativelayout;
    }

    public static RelativeLayout c(Activity activity, boolean flag)
    {
        bg.a(activity, 5F);
        bg.a(activity, 10F);
        RelativeLayout relativelayout = new RelativeLayout(activity);
        a(relativelayout, -1, -1);
        Object obj = new ListView(activity);
        ((ListView) (obj)).setDivider(null);
        a(((View) (obj)), -1, -2);
        ((ListView) (obj)).setId(0x102000a);
        ((ListView) (obj)).setDrawSelectorOnTop(true);
        relativelayout.addView(((View) (obj)));
        obj = new TextView(activity, null, 0x1010040);
        a(((View) (obj)), -1, -1);
        ((TextView) (obj)).setGravity(17);
        ((TextView) (obj)).setId(0x1020004);
        ((TextView) (obj)).setText(mk.a(activity, "empty_list"));
        relativelayout.addView(((View) (obj)));
        return relativelayout;
    }

    private static RelativeLayout d(Activity activity)
    {
        RelativeLayout relativelayout = new RelativeLayout(activity);
        a(relativelayout, -2, -2).addRule(13);
        ImageView imageview = new ImageView(activity);
        a(imageview, -2, -2).addRule(13);
        imageview.setId(F);
        imageview.setImageBitmap(mh.a(activity.getResources(), mh.O));
        relativelayout.addView(imageview);
        imageview = new ImageView(activity);
        a(imageview, -2, -2).addRule(13);
        imageview.setId(G);
        imageview.setImageBitmap(mh.a(activity.getResources(), mh.P));
        relativelayout.addView(imageview);
        activity = new ImageView(activity);
        a(activity, -2, -2).addRule(13);
        activity.setId(H);
        relativelayout.addView(activity);
        return relativelayout;
    }

    public static RelativeLayout d(Activity activity, boolean flag)
    {
        int i1 = 0;
        int j1 = (int)bg.a(activity, 5F);
        int k1 = (int)bg.a(activity, 10F);
        int l1 = (int)bg.a(activity, 17F);
        RelativeLayout relativelayout = new RelativeLayout(activity);
        Object obj = new mq(activity, false, false);
        ((nu) (obj)).setText(mk.a(activity, "infobar_document_type"));
        ((nu) (obj)).setId(J);
        ((nu) (obj)).a(false, false);
        relativelayout.addView(((View) (obj)));
        obj = new ScrollView(activity);
        Object obj1 = a(((View) (obj)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(3, J);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(2, m);
        ((ScrollView) (obj)).setPadding(0, k1 * 4, 0, 0);
        relativelayout.addView(((View) (obj)));
        obj1 = new LinearLayout(activity);
        b(((View) (obj1)), -1, -2);
        ((LinearLayout) (obj1)).setOrientation(1);
        ((LinearLayout) (obj1)).setId(n);
        ((ScrollView) (obj)).addView(((View) (obj1)));
        obj = new ImageView(activity);
        obj1 = a(((View) (obj)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(14);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(0, j1, k1, l1);
        ((ImageView) (obj)).setAdjustViewBounds(true);
        ((ImageView) (obj)).setImageBitmap(ch.a(activity.getResources(), ch.b));
        ((ImageView) (obj)).setId(m);
        if (!flag)
        {
            i1 = 4;
        }
        ((ImageView) (obj)).setVisibility(i1);
        relativelayout.addView(((View) (obj)));
        return relativelayout;
    }

    private static View e(Activity activity)
    {
        int i1 = (int)bg.a(activity, 5F);
        int j1 = (int)bg.a(activity, 10F);
        int k1 = (int)bg.a(activity, 20F);
        int l1 = (int)bg.a(activity, 40F);
        int i2 = (int)bg.a(activity, 59F);
        RelativeLayout relativelayout = new RelativeLayout(activity);
        Object obj = a(relativelayout, -1, -1);
        relativelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        relativelayout.setId(an);
        relativelayout.setBackgroundColor(c);
        relativelayout.setVisibility(4);
        Object obj1 = new LinearLayout(activity);
        Object obj2 = b(((View) (obj1)), -1, i2);
        ((LinearLayout) (obj1)).setId(au);
        ((LinearLayout) (obj1)).setWeightSum(1.0F);
        ((LinearLayout) (obj1)).setPadding(j1, 0, j1, 0);
        ((android.widget.LinearLayout.LayoutParams) (obj2)).setMargins(j1, 0, j1, 0);
        ((LinearLayout) (obj1)).setOrientation(0);
        obj2 = new ProgressBar(activity);
        android.widget.LinearLayout.LayoutParams layoutparams = b(((View) (obj2)), -2, -2);
        layoutparams.weight = 0.1F;
        layoutparams.setMargins(0, i1, j1, 0);
        ((ProgressBar) (obj2)).setPadding(j1, 0, j1, 0);
        ((ProgressBar) (obj2)).setVisibility(8);
        ((ProgressBar) (obj2)).setId(at);
        ((ProgressBar) (obj2)).getIndeterminateDrawable().setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
        ((LinearLayout) (obj1)).addView(((View) (obj2)));
        obj2 = new TextView(activity);
        b(((View) (obj2)), -1, -2).weight = 0.9F;
        ((TextView) (obj2)).setTextSize(15F);
        ((TextView) (obj2)).setGravity(17);
        ((TextView) (obj2)).setMaxHeight(i2);
        ((TextView) (obj2)).setTextColor(-1);
        ((TextView) (obj2)).setText(mk.a(activity, "confirm_linefinder_result_title"));
        ((TextView) (obj2)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        ((TextView) (obj2)).setId(am);
        ((LinearLayout) (obj1)).addView(((View) (obj2)));
        relativelayout.addView(((View) (obj1)));
        obj = new View(activity);
        obj1 = a(((View) (obj)), -1, (int)bg.a(activity, 1.0F));
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(j1, 0, j1, 0);
        ((View) (obj)).setId(ar);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(3, au);
        ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        ((View) (obj)).setVisibility(0);
        ((View) (obj)).setBackgroundColor(0x42ffffff);
        relativelayout.addView(((View) (obj)));
        obj = new NetverifyCustomConfirmationView(activity);
        obj1 = a(((View) (obj)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(3, ar);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(2, as);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(13);
        ((NetverifyCustomConfirmationView) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        ((NetverifyCustomConfirmationView) (obj)).setId(av);
        ((NetverifyCustomConfirmationView) (obj)).setVisibility(0);
        relativelayout.addView(((View) (obj)));
        obj = new LinearLayout(activity);
        ((LinearLayout) (obj)).setId(as);
        ((LinearLayout) (obj)).setOrientation(0);
        obj1 = new Button(activity);
        obj2 = b(((View) (obj1)), -2, -2);
        obj2.weight = 0.5F;
        ((android.widget.LinearLayout.LayoutParams) (obj2)).setMargins(j1, 0, j1, k1);
        ((Button) (obj1)).setText("Retry");
        ((Button) (obj1)).setId(ap);
        ((Button) (obj1)).setVisibility(0);
        ((Button) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        cf.a(activity, ((Button) (obj1)), cf.a(activity, cv.a(activity, "netverify_negativeButtonTextColor", "attr"), cf.a(), cv.a(activity, "netverify_negativeButtonBackground", "attr"), cf.c()));
        ((Button) (obj1)).setTextSize(2, 18F);
        ((Button) (obj1)).setTypeface(Typeface.create("sans-serif-regular", 0));
        ((LinearLayout) (obj)).addView(((View) (obj1)));
        obj2 = new Button(activity);
        obj1 = b(((View) (obj1)), -2, -2);
        obj1.weight = 0.5F;
        ((android.widget.LinearLayout.LayoutParams) (obj1)).setMargins(j1, 0, j1, l1);
        ((Button) (obj2)).setText("OK");
        ((Button) (obj2)).setId(ao);
        ((Button) (obj2)).setVisibility(0);
        ((Button) (obj2)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        cf.a(activity, ((Button) (obj2)), cf.a(activity, cv.a(activity, "netverify_positiveButtonTextColor", "attr"), cf.a(), cv.a(activity, "netverify_positiveButtonBackground", "attr"), cf.b()));
        ((Button) (obj2)).setTextSize(2, 18F);
        ((Button) (obj2)).setTypeface(Typeface.create("sans-serif-regular", 0));
        ((LinearLayout) (obj)).addView(((View) (obj2)));
        activity = a(((View) (obj)), -1, -2);
        activity.addRule(12);
        ((LinearLayout) (obj)).setLayoutParams(activity);
        relativelayout.addView(((View) (obj)));
        return relativelayout;
    }

    public static RelativeLayout e(Activity activity, boolean flag)
    {
        int i1 = 0;
        int j1 = (int)bg.a(activity, 5F);
        int k1 = (int)bg.a(activity, 10F);
        int l1 = (int)bg.a(activity, 17F);
        RelativeLayout relativelayout = new RelativeLayout(activity);
        Object obj = new mq(activity, false, false);
        ((nu) (obj)).setText(mk.a(activity, "infobar_document_variant"));
        ((nu) (obj)).setId(J);
        ((nu) (obj)).a(false, false);
        relativelayout.addView(((View) (obj)));
        obj = new ScrollView(activity);
        Object obj1 = a(((View) (obj)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(3, J);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(2, m);
        ((ScrollView) (obj)).setPadding(0, k1 * 4, 0, 0);
        relativelayout.addView(((View) (obj)));
        obj1 = new LinearLayout(activity);
        b(((View) (obj1)), -1, -2);
        ((LinearLayout) (obj1)).setOrientation(1);
        ((LinearLayout) (obj1)).setId(aB);
        ((ScrollView) (obj)).addView(((View) (obj1)));
        obj = new ImageView(activity);
        obj1 = a(((View) (obj)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(14);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(0, j1, k1, l1);
        ((ImageView) (obj)).setAdjustViewBounds(true);
        ((ImageView) (obj)).setImageBitmap(ch.a(activity.getResources(), ch.b));
        ((ImageView) (obj)).setId(m);
        if (!flag)
        {
            i1 = 4;
        }
        ((ImageView) (obj)).setVisibility(i1);
        relativelayout.addView(((View) (obj)));
        return relativelayout;
    }

    public static RelativeLayout f(Activity activity, boolean flag)
    {
        int j1 = (int)bg.a(activity, 5F);
        int k1 = (int)bg.a(activity, 10F);
        int i1 = (int)bg.a(activity, 17F);
        int l1 = (int)bg.a(activity, 30F);
        cg cg = cf.a(activity, cv.a(activity, "netverify_positiveButtonTextColor", "attr"), cf.a(), cv.a(activity, "netverify_positiveButtonBackground", "attr"), cf.b());
        RelativeLayout relativelayout = new RelativeLayout(activity);
        relativelayout.setId(d);
        Object obj = new ScrollView(activity);
        Object obj1 = a(((View) (obj)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(3, J);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(2, t);
        relativelayout.addView(((View) (obj)));
        obj1 = new LinearLayout(activity);
        Object obj2 = new android.widget.LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout) (obj1)).setPadding(0, k1 * 3, 0, 0);
        ((LinearLayout) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        ((LinearLayout) (obj1)).setOrientation(1);
        ((LinearLayout) (obj1)).setId(u);
        ((ScrollView) (obj)).addView(((View) (obj1)));
        obj = new Button(activity);
        obj1 = a(((View) (obj)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(2, m);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(14);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(k1, 0, k1, j1);
        cf.a(activity, ((Button) (obj)), cg);
        ((Button) (obj)).setText(mk.a(activity, "button_submit"));
        ((Button) (obj)).setId(t);
        ((Button) (obj)).setTextSize(2, 18F);
        ((Button) (obj)).setTypeface(Typeface.create("sans-serif-regular", 0));
        ((Button) (obj)).setVisibility(4);
        relativelayout.addView(((View) (obj)));
        obj = new ImageView(activity);
        obj1 = a(((View) (obj)), -2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(14);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(0, j1, k1, i1);
        ((ImageView) (obj)).setAdjustViewBounds(true);
        ((ImageView) (obj)).setImageBitmap(ch.a(activity.getResources(), ch.b));
        ((ImageView) (obj)).setId(m);
        Object obj3;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        ((ImageView) (obj)).setVisibility(i1);
        relativelayout.addView(((View) (obj)));
        obj = new View(activity);
        obj1 = a(((View) (obj)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((View) (obj)).setBackgroundColor(a);
        ((View) (obj)).setVisibility(4);
        ((View) (obj)).setId(ac);
        relativelayout.addView(((View) (obj)));
        obj1 = new mq(activity);
        ((nu) (obj1)).setId(J);
        relativelayout.addView(((View) (obj1)));
        ((View) (obj)).setPadding(k1, ((nu) (obj1)).getCurrentHeight(), k1, k1);
        obj2 = new RelativeLayout(activity);
        a(((View) (obj2)), -1, -2);
        ((RelativeLayout) (obj2)).setVisibility(8);
        ((RelativeLayout) (obj2)).setAlpha(0.0F);
        ((RelativeLayout) (obj2)).setId(N);
        relativelayout.addView(((View) (obj2)));
        obj = new nd(activity);
        ((nd) (obj)).setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -2));
        ((nd) (obj)).setOKColor(0xff97be0d);
        ((nd) (obj)).setErrorColor(0xffbe0d0d);
        ((nd) (obj)).setUploadText(mk.a(activity, "milestone_upload"));
        ((nd) (obj)).setFinishText(mk.a(activity, "milestone_finish"));
        ((nd) (obj)).setOKIcon(mh.a(activity.getResources(), mh.Q));
        ((nd) (obj)).setErrorIcon(mh.a(activity.getResources(), mh.R));
        ((nd) (obj)).setId(O);
        ((RelativeLayout) (obj2)).addView(((View) (obj)));
        obj1 = new ProgressBar(activity);
        ((ProgressBar) (obj1)).setIndeterminate(true);
        obj3 = new android.widget.RelativeLayout.LayoutParams((int)bg.a(activity, 35F), (int)bg.a(activity, 35F));
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(14);
        ((ProgressBar) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj3)));
        ((ProgressBar) (obj1)).setId(P);
        ((ProgressBar) (obj1)).setVisibility(4);
        jumiomobile.at.a(((ProgressBar) (obj1)).getIndeterminateDrawable(), -1);
        ((RelativeLayout) (obj2)).addView(((View) (obj1)));
        obj3 = new TextView(activity);
        layoutparams = a(((View) (obj3)), -1, -2);
        layoutparams.addRule(3, O);
        layoutparams.topMargin = l1;
        layoutparams.leftMargin = l1;
        layoutparams.rightMargin = l1;
        ((TextView) (obj3)).setId(Q);
        ((TextView) (obj3)).setTextSize(2, 16F);
        ((TextView) (obj3)).setTypeface(Typeface.create("sans-serif-medium", 3));
        ((TextView) (obj3)).setTextColor(-1);
        ((TextView) (obj3)).setGravity(1);
        ((RelativeLayout) (obj2)).addView(((View) (obj3)));
        obj2 = new Button(activity);
        obj3 = a(((View) (obj2)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(2, m);
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(14);
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).setMargins(k1, 0, k1, j1);
        ((Button) (obj2)).setVisibility(4);
        ((Button) (obj2)).setAlpha(0.0F);
        cf.a(activity, ((Button) (obj2)), cg);
        ((Button) (obj2)).setId(r);
        ((Button) (obj2)).setText(mk.a(activity, "button_done"));
        ((Button) (obj2)).setTextSize(2, 18F);
        ((Button) (obj2)).setTypeface(Typeface.create("sans-serif-regular", 0));
        relativelayout.addView(((View) (obj2)));
        obj2 = new Button(activity);
        obj3 = a(((View) (obj2)), -1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(2, m);
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).addRule(14);
        ((android.widget.RelativeLayout.LayoutParams) (obj3)).setMargins(k1, 0, k1, j1);
        ((Button) (obj2)).setVisibility(4);
        ((Button) (obj2)).setAlpha(0.0F);
        cf.a(activity, ((Button) (obj2)), cg);
        ((Button) (obj2)).setId(s);
        ((Button) (obj2)).setText(mk.a(activity, "button_retry"));
        ((Button) (obj2)).setTextSize(2, 18F);
        ((Button) (obj2)).setTypeface(Typeface.create("sans-serif-regular", 0));
        relativelayout.addView(((View) (obj2)));
        ((nd) (obj)).setLoadingIndicator(((ProgressBar) (obj1)));
        return relativelayout;
    }

    static 
    {
        aF = 1;
        aF = 2;
        int i1 = aF;
        aF = i1 + 1;
        e = i1;
        i1 = aF;
        aF = i1 + 1;
        f = i1;
        i1 = aF;
        aF = i1 + 1;
        g = i1;
        i1 = aF;
        aF = i1 + 1;
        h = i1;
        i1 = aF;
        aF = i1 + 1;
        i = i1;
        i1 = aF;
        aF = i1 + 1;
        j = i1;
        i1 = aF;
        aF = i1 + 1;
        k = i1;
        i1 = aF;
        aF = i1 + 1;
        l = i1;
        i1 = aF;
        aF = i1 + 1;
        m = i1;
        i1 = aF;
        aF = i1 + 1;
        n = i1;
        i1 = aF;
        aF = i1 + 1;
        o = i1;
        i1 = aF;
        aF = i1 + 1;
        p = i1;
        i1 = aF;
        aF = i1 + 1;
        q = i1;
        i1 = aF;
        aF = i1 + 1;
        r = i1;
        i1 = aF;
        aF = i1 + 1;
        s = i1;
        i1 = aF;
        aF = i1 + 1;
        t = i1;
        i1 = aF;
        aF = i1 + 1;
        u = i1;
        i1 = aF;
        aF = i1 + 1;
        v = i1;
        i1 = aF;
        aF = i1 + 1;
        w = i1;
        i1 = aF;
        aF = i1 + 1;
        x = i1;
        i1 = aF;
        aF = i1 + 1;
        y = i1;
        i1 = aF;
        aF = i1 + 1;
        z = i1;
        i1 = aF;
        aF = i1 + 1;
        A = i1;
        i1 = aF;
        aF = i1 + 1;
        B = i1;
        i1 = aF;
        aF = i1 + 1;
        C = i1;
        i1 = aF;
        aF = i1 + 1;
        D = i1;
        i1 = aF;
        aF = i1 + 1;
        E = i1;
        i1 = aF;
        aF = i1 + 1;
        F = i1;
        i1 = aF;
        aF = i1 + 1;
        G = i1;
        i1 = aF;
        aF = i1 + 1;
        H = i1;
        i1 = aF;
        aF = i1 + 1;
        I = i1;
        i1 = aF;
        aF = i1 + 1;
        J = i1;
        i1 = aF;
        aF = i1 + 1;
        K = i1;
        i1 = aF;
        aF = i1 + 1;
        L = i1;
        i1 = aF;
        aF = i1 + 1;
        M = i1;
        i1 = aF;
        aF = i1 + 1;
        N = i1;
        i1 = aF;
        aF = i1 + 1;
        O = i1;
        i1 = aF;
        aF = i1 + 1;
        P = i1;
        i1 = aF;
        aF = i1 + 1;
        Q = i1;
        i1 = aF;
        aF = i1 + 1;
        R = i1;
        i1 = aF;
        aF = i1 + 1;
        S = i1;
        i1 = aF;
        aF = i1 + 1;
        T = i1;
        i1 = aF;
        aF = i1 + 1;
        U = i1;
        i1 = aF;
        aF = i1 + 1;
        V = i1;
        i1 = aF;
        aF = i1 + 1;
        W = i1;
        i1 = aF;
        aF = i1 + 1;
        X = i1;
        i1 = aF;
        aF = i1 + 1;
        Y = i1;
        i1 = aF;
        aF = i1 + 1;
        Z = i1;
        i1 = aF;
        aF = i1 + 1;
        aa = i1;
        i1 = aF;
        aF = i1 + 1;
        ab = i1;
        i1 = aF;
        aF = i1 + 1;
        ac = i1;
        i1 = aF;
        aF = i1 + 1;
        ad = i1;
        i1 = aF;
        aF = i1 + 1;
        ae = i1;
        i1 = aF;
        aF = i1 + 1;
        af = i1;
        i1 = aF;
        aF = i1 + 1;
        ag = i1;
        i1 = aF;
        aF = i1 + 1;
        ah = i1;
        i1 = aF;
        aF = i1 + 1;
        ai = i1;
        i1 = aF;
        aF = i1 + 1;
        aj = i1;
        i1 = aF;
        aF = i1 + 1;
        ak = i1;
        i1 = aF;
        aF = i1 + 1;
        al = i1;
        i1 = aF;
        aF = i1 + 1;
        am = i1;
        i1 = aF;
        aF = i1 + 1;
        an = i1;
        i1 = aF;
        aF = i1 + 1;
        ao = i1;
        i1 = aF;
        aF = i1 + 1;
        ap = i1;
        i1 = aF;
        aF = i1 + 1;
        aq = i1;
        i1 = aF;
        aF = i1 + 1;
        ar = i1;
        i1 = aF;
        aF = i1 + 1;
        as = i1;
        i1 = aF;
        aF = i1 + 1;
        at = i1;
        i1 = aF;
        aF = i1 + 1;
        au = i1;
        i1 = aF;
        aF = i1 + 1;
        av = i1;
        i1 = aF;
        aF = i1 + 1;
        aG = i1;
        i1 = aF;
        aF = i1 + 1;
        aw = i1;
        i1 = aF;
        aF = i1 + 1;
        ax = i1;
        i1 = aF;
        aF = i1 + 1;
        ay = i1;
        i1 = aF;
        aF = i1 + 1;
        az = i1;
        i1 = aF;
        aF = i1 + 1;
        aA = i1;
        i1 = aF;
        aF = i1 + 1;
        aB = i1;
        i1 = aF;
        aF = i1 + 1;
        aC = i1;
        i1 = aF;
        aF = i1 + 1;
        aD = i1;
        i1 = aF;
        aF = i1 + 1;
        aE = i1;
    }
}
