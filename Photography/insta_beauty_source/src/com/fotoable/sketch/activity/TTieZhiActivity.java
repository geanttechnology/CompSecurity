// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import apc;
import aph;
import api;
import aqx;
import auv;
import auw;
import auz;
import avb;
import avc;
import avd;
import ave;
import avi;
import avj;
import avk;
import avl;
import avm;
import avn;
import avs;
import avt;
import avv;
import avw;
import avx;
import avy;
import avz;
import awf;
import awg;
import awj;
import awk;
import awl;
import axj;
import axt;
import azn;
import bjd;
import bje;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.comlib.util.ImageCache;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.fotoable.fotoproedit.view.ui.ProEidtActionBarView;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.fotoable.sketch.view.TTieZhiCollectionPageScrolllView;
import com.fotoable.sketch.view.TTieZhiComposeView;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;
import com.instabeauty.application.InstaBeautyApplication;
import com.loopj.android.http.AsyncHttpClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import uv;
import yp;
import zr;

public class TTieZhiActivity extends FullscreenActivity
{

    boolean A;
    public avz B;
    avz C;
    RelativeLayout D;
    public boolean E;
    bjd F;
    public boolean G;
    private ImageView H;
    private apc I;
    private List J;
    private Map K;
    private Map L;
    private Map M;
    private List N;
    private int O;
    private int P;
    private int Q;
    private BroadcastReceiver R;
    ProEidtActionBarView a;
    ImageView b;
    ImageView c;
    FrameLayout d;
    public FrameLayout e;
    ProgressBar f;
    TextView g;
    public Bitmap h;
    axt i;
    axj j;
    bje k;
    public TTieZhiComposeView l;
    awf m;
    public TTieZhiMainLibraryView n;
    public TTieZhiCollectionPageScrolllView o;
    FrameLayout p;
    public HorizontalScrollView q;
    public LinearLayout r;
    public awl s;
    public boolean t;
    boolean u;
    public boolean v;
    float w;
    float x;
    float y;
    String z;

    public TTieZhiActivity()
    {
        m = null;
        J = new ArrayList();
        K = new HashMap();
        L = new HashMap();
        M = new HashMap();
        N = new ArrayList();
        O = -1;
        P = -1;
        Q = -1;
        t = true;
        u = false;
        v = false;
        w = 1.0F;
        x = 1.0F;
        y = 1.0F;
        z = "";
        A = true;
        B = null;
        C = null;
        R = null;
        E = false;
        G = false;
    }

    public static Bitmap a(TTieZhiActivity ttiezhiactivity, int i1, int j1)
    {
        return ttiezhiactivity.b(i1, j1);
    }

    public static ImageView a(TTieZhiActivity ttiezhiactivity)
    {
        return ttiezhiactivity.H;
    }

    private awj a(int i1, int j1)
    {
        Iterator iterator = J.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (awk)iterator.next();
        if (((awk) (obj)).a != i1) goto _L4; else goto _L3
_L3:
        if (obj == null)
        {
            return null;
        }
        iterator = ((awk) (obj)).e.iterator();
_L8:
        if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        obj = (awj)iterator.next();
        if (((awj) (obj)).a != j1) goto _L8; else goto _L7
_L7:
        return ((awj) (obj));
_L6:
        obj = null;
        if (true) goto _L7; else goto _L2
_L2:
        obj = null;
        if (true) goto _L3; else goto _L9
_L9:
    }

    private TTieZhiInfo a(int i1)
    {
        Iterator iterator;
        int j1;
        int k1;
        if (!K.containsKey(Integer.valueOf(i1)) || !L.containsKey(Integer.valueOf(i1)))
        {
            return null;
        }
        j1 = ((Integer)K.get(Integer.valueOf(i1))).intValue();
        k1 = ((Integer)L.get(Integer.valueOf(i1))).intValue();
        iterator = J.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (awk)iterator.next();
        if (((awk) (obj)).a != j1) goto _L4; else goto _L3
_L3:
        if (obj == null)
        {
            return null;
        }
        iterator = ((awk) (obj)).e.iterator();
_L8:
        if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        obj = (awj)iterator.next();
        if (((awj) (obj)).a != k1) goto _L8; else goto _L7
_L7:
        if (obj == null)
        {
            return null;
        }
        for (obj = ((awj) (obj)).e.iterator(); ((Iterator) (obj)).hasNext();)
        {
            TTieZhiInfo ttiezhiinfo = (TTieZhiInfo)((Iterator) (obj)).next();
            if (ttiezhiinfo.resId == i1)
            {
                return ttiezhiinfo;
            }
        }

        return null;
_L6:
        obj = null;
        if (true) goto _L7; else goto _L2
_L2:
        obj = null;
        if (true) goto _L3; else goto _L9
_L9:
    }

    public static TTieZhiInfo a(TTieZhiActivity ttiezhiactivity, int i1)
    {
        return ttiezhiactivity.a(i1);
    }

    private List a(List list)
    {
        ArrayList arraylist;
        Iterator iterator;
        if (list == null || list.size() == 0)
        {
            return null;
        }
        arraylist = new ArrayList();
        if (J.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        iterator = J.iterator();
_L2:
        Object obj;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_228;
            }
            obj = (awk)iterator.next();
        } while (((awk) (obj)).a == TTieZhiInfo.kTZRecommendTypeID || ((awk) (obj)).e == null || ((awk) (obj)).e.size() <= 0);
        obj = ((awk) (obj)).e.iterator();
_L4:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        awj awj1 = (awj)((Iterator) (obj)).next();
        if (awj1 == null || awj1.e == null || awj1.e.size() <= 0) goto _L4; else goto _L3
_L3:
        int i1 = 0;
_L6:
        if (i1 >= list.size())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((Integer)list.get(i1)).intValue() != awj1.a)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        arraylist.add(awj1);
        if (arraylist.size() != list.size()) goto _L4; else goto _L5
_L5:
        return arraylist;
        i1++;
          goto _L6
        return arraylist;
    }

    private void a(int i1, int j1, int k1, boolean flag)
    {
        Iterator iterator;
        boolean flag1;
        flag1 = false;
        iterator = J.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (awk)iterator.next();
        if (((awk) (obj)).a != i1) goto _L4; else goto _L3
_L3:
        if (obj == null)
        {
            a(false, ((List) (null)), -1, false);
            return;
        }
        iterator = ((awk) (obj)).e.iterator();
_L8:
        if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        obj = (awj)iterator.next();
        if (((awj) (obj)).a != j1) goto _L8; else goto _L7
_L7:
        i1 = ((flag1) ? 1 : 0);
        if (obj == null)
        {
            a(false, ((List) (null)), -1, false);
            return;
        }
          goto _L9
_L13:
        i1++;
_L9:
        if (i1 >= ((awj) (obj)).e.size()) goto _L11; else goto _L10
_L10:
        if (((TTieZhiInfo)((awj) (obj)).e.get(i1)).resId != k1) goto _L13; else goto _L12
_L12:
        a(true, ((awj) (obj)).e, i1, flag);
        return;
_L11:
        i1 = -1;
        if (true) goto _L12; else goto _L6
_L6:
        obj = null;
        if (true) goto _L7; else goto _L2
_L2:
        obj = null;
        if (true) goto _L3; else goto _L14
_L14:
    }

    private void a(View view, int i1, int j1, long l1, boolean flag)
    {
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (view.getVisibility() != 0)
        {
            return;
        }
        try
        {
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, i1, j1);
            translateanimation.setDuration(l1);
            translateanimation.setInterpolator(new DecelerateInterpolator());
            translateanimation.setAnimationListener(new avk(this, flag, view));
            view.startAnimation(translateanimation);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
    }

    public static void a(TTieZhiActivity ttiezhiactivity, View view, int i1, int j1, long l1, boolean flag)
    {
        ttiezhiactivity.b(view, i1, j1, l1, flag);
    }

    public static void a(TTieZhiActivity ttiezhiactivity, List list, boolean flag)
    {
        ttiezhiactivity.a(list, flag);
    }

    public static void a(TTieZhiActivity ttiezhiactivity, JSONObject jsonobject, boolean flag)
    {
        ttiezhiactivity.a(jsonobject, flag);
    }

    public static void a(TTieZhiActivity ttiezhiactivity, boolean flag)
    {
        ttiezhiactivity.c(flag);
    }

    public static void a(TTieZhiActivity ttiezhiactivity, boolean flag, String s1)
    {
        ttiezhiactivity.a(flag, s1);
    }

    private void a(ArrayList arraylist)
    {
        try
        {
            F = new bjd();
            F.a(k);
            F.a(arraylist);
            int i1 = azn.d();
            F.b(i1);
            F.d(new ArrayList[] {
                arraylist
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            arraylist.printStackTrace();
        }
    }

    private void a(List list, boolean flag)
    {
        r.removeAllViews();
        if (flag || list != null && list.size() > 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        B = null;
        C = null;
        boolean flag1 = flag;
        if (flag)
        {
            avz avz1 = new avz(this, this);
            avz1.a(true);
            Object obj = a(O, P);
            int i1;
            if (obj != null)
            {
                avz1.a(((awj) (obj)).a());
                avz1.b(true);
                avz1.a(((awj) (obj)));
                obj = new android.widget.LinearLayout.LayoutParams(-2, -1);
                obj.gravity = 83;
                r.addView(avz1, ((android.view.ViewGroup.LayoutParams) (obj)));
                C = avz1;
                flag1 = flag;
            } else
            {
                flag1 = false;
            }
        }
        if (list != null && list.size() > 0)
        {
            i1 = 0;
            while (i1 < list.size()) 
            {
                avz avz2 = new avz(this, this);
                avz2.a(false);
                avz2.a(((awj)list.get(i1)).a());
                avz2.a((awj)list.get(i1));
                if (!flag1 && i1 == 0)
                {
                    avz2.b(true);
                    B = avz2;
                    a(true, ((awj)list.get(i1)).e, -1, true);
                } else
                {
                    avz2.b(false);
                }
                obj = new android.widget.LinearLayout.LayoutParams(-2, -1);
                obj.gravity = 83;
                (new Handler()).postDelayed(new avj(this, avz2, ((android.widget.LinearLayout.LayoutParams) (obj))), i1 * 150);
                i1++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void a(JSONObject jsonobject, boolean flag)
    {
        (new Thread(new ave(this, jsonobject, flag))).start();
    }

    private void a(boolean flag)
    {
        if (n.getVisibility() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        try
        {
            n.setVisibility(0);
        }
        catch (Exception exception)
        {
            return;
        }
        if (!flag) goto _L1; else goto _L3
_L3:
        Animation animation = AnimationUtils.loadAnimation(this, 0x7f04002d);
        n.startAnimation(animation);
        return;
    }

    private void a(boolean flag, String s1)
    {
        if (flag)
        {
            e.setVisibility(0);
            g.setText(s1);
            return;
        } else
        {
            e.setVisibility(4);
            return;
        }
    }

    private void a(boolean flag, List list, int i1, boolean flag1)
    {
        if (flag && A)
        {
            A = false;
            H.setVisibility(0);
            o.setVisibility(0);
            c(true);
        }
        if (flag)
        {
            p.setVisibility(0);
            o.setVisibility(0);
            if (flag1)
            {
                o.setData(list, i1);
                return;
            } else
            {
                o.setSelectedIndex(i1);
                return;
            }
        } else
        {
            p.setVisibility(4);
            o.setVisibility(4);
            return;
        }
    }

    public static boolean a(TTieZhiActivity ttiezhiactivity, boolean flag, awj awj1)
    {
        return ttiezhiactivity.a(flag, awj1);
    }

    private boolean a(boolean flag, awj awj1)
    {
        c(true);
        if (!flag) goto _L2; else goto _L1
_L1:
        if (B != null)
        {
            B.b(false);
            B = null;
            if (C != null)
            {
                C.b(true);
            }
            a(awj1.f, awj1.a, Q, true);
        }
_L4:
        return false;
_L2:
        if (awj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (C != null)
        {
            C.b(false);
        }
        if (B == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (B.b() == awj1.a)
        {
            continue; /* Loop/switch isn't completed */
        }
        B.b(false);
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        a(awj1.f, awj1.a, -1, true);
        return true;
    }

    public static int b(TTieZhiActivity ttiezhiactivity, int i1)
    {
        ttiezhiactivity.P = i1;
        return i1;
    }

    private Bitmap b(int i1, int j1)
    {
        Log.e("TTieZhiActivity", (new StringBuilder()).append("TTieZhiActivity:scale ").append(w).toString());
        Bitmap bitmap = Bitmap.createBitmap(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(4F);
        canvas.drawBitmap(h, 0.0F, 0.0F, paint);
        l.drawInCanvas(canvas, w, paint);
        return bitmap;
        Object obj;
        obj;
        bitmap = null;
_L4:
        Crashlytics.logException(((Throwable) (obj)));
        return bitmap;
        obj;
        bitmap = null;
_L2:
        Crashlytics.logException(((Throwable) (obj)));
        return bitmap;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void b(int i1)
    {
        if (!K.containsKey(Integer.valueOf(i1)) || !L.containsKey(Integer.valueOf(i1)))
        {
            a(false, ((List) (null)), -1, false);
            return;
        }
        int j1 = ((Integer)K.get(Integer.valueOf(i1))).intValue();
        int k1 = ((Integer)L.get(Integer.valueOf(i1))).intValue();
        List list = (List)M.get(Integer.valueOf(i1));
        if (P == k1 && O == j1)
        {
            a(j1, k1, i1, false);
            return;
        } else
        {
            P = k1;
            O = j1;
            a(j1, k1, i1, true);
            a(a(list), true);
            return;
        }
    }

    private void b(View view, int i1, int j1, long l1, boolean flag)
    {
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (view.getVisibility() != 0)
        {
            return;
        }
        try
        {
            TranslateAnimation translateanimation = new TranslateAnimation(i1, j1, 0.0F, 0.0F);
            translateanimation.setDuration(l1);
            translateanimation.setInterpolator(new DecelerateInterpolator());
            translateanimation.setAnimationListener(new avm(this, flag, view));
            view.startAnimation(translateanimation);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
    }

    public static void b(TTieZhiActivity ttiezhiactivity)
    {
        ttiezhiactivity.l();
    }

    public static void b(TTieZhiActivity ttiezhiactivity, boolean flag)
    {
        ttiezhiactivity.b(flag);
    }

    private void b(boolean flag)
    {
        while (n.getVisibility() == 4 || v || !flag) 
        {
            return;
        }
        try
        {
            Animation animation = AnimationUtils.loadAnimation(this, 0x7f04002e);
            n.startAnimation(animation);
            v = true;
            (new Handler()).postDelayed(new avd(this), 300L);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public static int c(TTieZhiActivity ttiezhiactivity, int i1)
    {
        ttiezhiactivity.O = i1;
        return i1;
    }

    public static void c(TTieZhiActivity ttiezhiactivity)
    {
        ttiezhiactivity.g();
    }

    private void c(boolean flag)
    {
        boolean flag2 = true;
        boolean flag1 = true;
        if (H.isSelected() != flag)
        {
            return;
        }
        if (!flag)
        {
            ImageView imageview = H;
            if (!flag)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            imageview.setSelected(flag);
            q();
            H.setBackgroundResource(0x7f0200a6);
            return;
        }
        ImageView imageview1 = H;
        if (!flag)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        imageview1.setSelected(flag);
        p();
        H.setBackgroundResource(0x7f0200a5);
    }

    public static int d(TTieZhiActivity ttiezhiactivity, int i1)
    {
        ttiezhiactivity.Q = i1;
        return i1;
    }

    private void d()
    {
        a(true, InstaBeautyApplication.a.getString(0x7f06015c));
        (new Thread(new avt(this))).start();
    }

    public static void d(TTieZhiActivity ttiezhiactivity)
    {
        ttiezhiactivity.h();
    }

    private void e()
    {
        if (h == null)
        {
            Log.e("configView", "The bitmap is null");
            if (!u)
            {
                d();
            } else
            {
                h();
            }
            Toast.makeText(getApplicationContext(), "The bitmap is null", 0);
        } else
        {
            x = (float)h.getWidth() / (float)h.getHeight();
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)d.getLayoutParams();
            DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
            float f4 = displaymetrics.widthPixels - (layoutparams.leftMargin + layoutparams.rightMargin);
            float f3 = (float)displaymetrics.heightPixels - (float)(layoutparams.topMargin + layoutparams.bottomMargin);
            y = f4 / f3;
            float f1;
            float f2;
            if (x > y)
            {
                f1 = f4 / x;
                f2 = f4;
            } else
            {
                f2 = x * f3;
                f1 = f3;
            }
            w = (float)h.getWidth() / f2;
            f4 -= f2;
            f3 -= f1;
            layoutparams.width = (int)f2;
            layoutparams.height = (int)f1;
            layoutparams.topMargin = (int)((float)layoutparams.topMargin + f3 / 2.0F);
            layoutparams.leftMargin = (int)((float)layoutparams.leftMargin + f4 / 2.0F);
            layoutparams.bottomMargin = (int)((float)layoutparams.bottomMargin + f3 / 2.0F);
            layoutparams.rightMargin = (int)((float)layoutparams.rightMargin + f4 / 2.0F);
            d.setLayoutParams(layoutparams);
            layoutparams = new android.widget.FrameLayout.LayoutParams(layoutparams.width, layoutparams.height);
            layoutparams.gravity = 17;
            b = new ImageView(this);
            d.addView(b, layoutparams);
            b.setImageBitmap(h);
            l = new TTieZhiComposeView(this);
            l.setComposeHandleLisener(j);
            if (s != null)
            {
                s.a(1.0F / w);
                l.setFaceKeyPoint(s);
            }
            d.addView(l, layoutparams);
            if (z != null && z.length() > 0)
            {
                String as[] = z.split(",");
                if (as.length > 0)
                {
                    int i1 = 0;
                    while (i1 < as.length) 
                    {
                        Object obj = as[i1];
                        if (((String) (obj)).length() > 0)
                        {
                            int j1 = Integer.valueOf(((String) (obj))).intValue();
                            obj = awg.a().c(j1);
                            if (obj != null && l != null)
                            {
                                (new Handler()).postDelayed(new avv(this, ((TTieZhiInfo) (obj))), 10L);
                            }
                        }
                        i1++;
                    }
                } else
                {
                    m();
                    return;
                }
            } else
            {
                m();
                return;
            }
        }
    }

    public static void e(TTieZhiActivity ttiezhiactivity)
    {
        ttiezhiactivity.e();
    }

    public static void e(TTieZhiActivity ttiezhiactivity, int i1)
    {
        ttiezhiactivity.b(i1);
    }

    private void f()
    {
        String s2 = "Yes";
        String s1 = "No";
        if (yp.a())
        {
            s1 = "\u53D6\u6D88";
            s2 = "\u786E\u5B9A";
        }
        (new api(this)).b(getResources().getString(0x7f0602ad)).a(getResources().getString(0x7f0602ab)).a(true).a("  no more tips", new avy(this)).a(s2, new avx(this)).b(s1, new avw(this)).a().show();
    }

    public static void f(TTieZhiActivity ttiezhiactivity)
    {
        ttiezhiactivity.n();
    }

    public static int g(TTieZhiActivity ttiezhiactivity)
    {
        return ttiezhiactivity.Q;
    }

    private void g()
    {
        if (!aqx.a(InstaBeautyApplication.a, "TTieZhiActivity", "TAG_BACKTIP", false) && l.hasTieZhi())
        {
            f();
            return;
        }
        try
        {
            h();
            return;
        }
        catch (Exception exception)
        {
            h();
        }
        return;
    }

    public static List h(TTieZhiActivity ttiezhiactivity)
    {
        return ttiezhiactivity.N;
    }

    private void h()
    {
        setResult(0);
        finish();
        if (!u)
        {
            overridePendingTransition(0, 0x7f04001e);
        }
    }

    private awf i()
    {
        if (m == null)
        {
            zr zr1 = new zr(this, ImageCache.b);
            zr1.g = true;
            zr1.d = android.graphics.Bitmap.CompressFormat.PNG;
            zr1.a(0.05F);
            m = new awf(this, 140);
            m.a(getSupportFragmentManager(), zr1);
        }
        return m;
    }

    public static List i(TTieZhiActivity ttiezhiactivity)
    {
        return ttiezhiactivity.J;
    }

    public static apc j(TTieZhiActivity ttiezhiactivity)
    {
        return ttiezhiactivity.I;
    }

    private void j()
    {
        k = new auw(this);
        i = new auz(this);
        j = new avb(this);
    }

    private void k()
    {
        n.setItemClickLisener(i);
        n.initWithImageWorker(i());
        n.setIsFinishLoad(false);
        n.handleData(awg.a().g());
        n.setVisibility(4);
    }

    public static void k(TTieZhiActivity ttiezhiactivity)
    {
        ttiezhiactivity.o();
    }

    private void l()
    {
label0:
        {
label1:
            {
                a(true);
                if (!t)
                {
                    break label0;
                }
                if (!G)
                {
                    if (J.size() <= 0)
                    {
                        break label1;
                    }
                    n.setIsFinishLoad(t);
                    n.handleData(J);
                }
                return;
            }
            n();
            return;
        }
        n.setIsFinishLoad(false);
    }

    private void m()
    {
        try
        {
            Animation animation = AnimationUtils.loadAnimation(this, 0x7f040032);
            c.startAnimation(animation);
            (new Handler()).postDelayed(new avc(this), 1100L);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void n()
    {
        if (!yp.k(this))
        {
            Toast.makeText(this, "\u7F51\u7EDC\u5F02\u5E38", 0);
            t = true;
            n.setIsFinishLoad(t);
            n.jumpToIndex(4);
            return;
        }
        JSONObject jsonobject = I.b("json_tiezhiLibrary");
        if (jsonobject != null)
        {
            Log.v("TTieZhiActivity", "TTieZhiActivityget data from Cache");
            a(jsonobject, true);
            return;
        } else
        {
            c();
            return;
        }
    }

    private void o()
    {
        if (J.size() > 0)
        {
            Iterator iterator = J.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (awk)iterator.next();
                if (obj != null && ((awk) (obj)).a != TTieZhiInfo.kTZRecommendTypeID)
                {
                    if (((awk) (obj)).e.size() <= 0)
                    {
                        break;
                    }
                    Iterator iterator1 = ((awk) (obj)).e.iterator();
                    do
                    {
                        awj awj2;
                        do
                        {
                            if (!iterator1.hasNext())
                            {
                                break;
                            }
                            awj2 = (awj)iterator1.next();
                        } while (awj2 == null || awj2.e.size() <= 0);
                        Iterator iterator2 = awj2.e.iterator();
                        while (iterator2.hasNext()) 
                        {
                            TTieZhiInfo ttiezhiinfo = (TTieZhiInfo)iterator2.next();
                            if (ttiezhiinfo != null)
                            {
                                K.put(Integer.valueOf(ttiezhiinfo.resId), Integer.valueOf(((awk) (obj)).a));
                                L.put(Integer.valueOf(ttiezhiinfo.resId), Integer.valueOf(awj2.a));
                                if (awj2.g != null && awj2.g.size() > 0)
                                {
                                    M.put(Integer.valueOf(ttiezhiinfo.resId), awj2.g);
                                }
                            }
                        }
                    } while (true);
                }
                N.clear();
                if (((awk) (obj)).e == null || ((awk) (obj)).e.size() <= 0)
                {
                    break;
                }
                obj = ((awk) (obj)).e.iterator();
label0:
                do
                {
                    awj awj1;
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break label0;
                        }
                        awj1 = (awj)((Iterator) (obj)).next();
                    } while (awj1 == null || awj1.e == null || awj1.e.size() <= 0);
                    N.add(awj1);
                } while (N.size() < 4);
            } while (true);
        }
    }

    private void p()
    {
        ((android.widget.FrameLayout.LayoutParams)o.getLayoutParams()).bottomMargin = yp.a(this, 44F);
        o.requestLayout();
        ((android.widget.FrameLayout.LayoutParams)p.getLayoutParams()).bottomMargin = yp.a(this, 44F) + o.getHeight();
        p.requestLayout();
        a(o, o.getHeight(), 0, 300L, true);
        a(p, o.getHeight(), 0, 300L, true);
    }

    private void q()
    {
        ((android.widget.FrameLayout.LayoutParams)o.getLayoutParams()).bottomMargin = yp.a(this, 44F) - o.getHeight();
        o.requestLayout();
        ((android.widget.FrameLayout.LayoutParams)p.getLayoutParams()).bottomMargin = yp.a(this, 44F);
        p.requestLayout();
        a(o, -o.getHeight(), 0, 300L, true);
        a(p, -o.getHeight(), 0, 300L, true);
    }

    protected void a()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("ACTION_MAG_MATERIAL_SHARETOWECHAT");
        registerReceiver(R, intentfilter);
    }

    public Bitmap b()
    {
        if (h == null || h.isRecycled())
        {
            return uv.c().i();
        } else
        {
            return h;
        }
    }

    public void c()
    {
        String s1 = azn.g();
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setConnectTimeout(20000);
        asynchttpclient.setTimeout(20000);
        t = false;
        FlurryAgent.logEvent("TieZhiRequestStart");
        asynchttpclient.get(s1, null, new avi(this));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03003c);
        j();
        d = (FrameLayout)findViewById(0x7f0d00d2);
        D = (RelativeLayout)findViewById(0x7f0d00b0);
        bundle = (android.widget.FrameLayout.LayoutParams)d.getLayoutParams();
        if (!azn.a(this))
        {
            bundle.topMargin = yp.a(this, 5F);
            D.setVisibility(8);
        }
        a = (ProEidtActionBarView)findViewById(0x7f0d0171);
        o = (TTieZhiCollectionPageScrolllView)findViewById(0x7f0d016d);
        o.setItemClickLisener(i);
        o.setImageWorker(i());
        p = (FrameLayout)findViewById(0x7f0d016e);
        q = (HorizontalScrollView)findViewById(0x7f0d016f);
        r = new LinearLayout(this);
        r.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
        r.setOrientation(0);
        bundle = new android.widget.FrameLayout.LayoutParams(-2, -2);
        bundle.gravity = 83;
        q.addView(r, bundle);
        H = (ImageView)findViewById(0x7f0d0170);
        H.setVisibility(4);
        H.setSelected(true);
        H.setOnClickListener(new auv(this));
        e = (FrameLayout)findViewById(0x7f0d0174);
        f = (ProgressBar)findViewById(0x7f0d0176);
        g = (TextView)findViewById(0x7f0d0177);
        n = (TTieZhiMainLibraryView)findViewById(0x7f0d0173);
        a(false, "");
        c = (ImageView)findViewById(0x7f0d0172);
        c.setOnClickListener(new avl(this));
        a.setActionBarTitle("");
        a.setOnAcceptListener(new avn(this));
        if (getIntent() != null)
        {
            bundle = getIntent();
            u = bundle.getBooleanExtra("KISDERECTEDTOSAVE_STRING", false);
            z = bundle.getStringExtra("KUSETIEZHIID");
            if (z == null)
            {
                z = "";
            }
            bundle = bundle.getStringExtra("KIMAGEURI");
            if (u)
            {
                a.setVisibility(4);
                if (bundle != null)
                {
                    ArrayList arraylist = new ArrayList();
                    arraylist.add(Uri.parse(bundle));
                    a(arraylist);
                }
            } else
            {
                a.setVisibility(0);
            }
        }
        I = InstaBeautyApplication.i;
        k();
        n();
        if (!u)
        {
            d();
        }
        R = new avs(this);
        a();
    }

    protected void onDestroy()
    {
        E = true;
        unregisterReceiver(R);
        super.onDestroy();
        if (F != null)
        {
            F.a(null);
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            if (n.getVisibility() == 0)
            {
                b(true);
                return false;
            } else
            {
                g();
                return super.onKeyDown(i1, keyevent);
            }
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public void onResume()
    {
        super.onResume();
        FlurryAgent.onPageView();
        if (azn.a(this))
        {
            FotoAdFactory.createAdBanner(this, D);
        }
    }
}
