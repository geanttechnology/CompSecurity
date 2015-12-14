// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
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
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.comlib.util.ImageCache;
import com.fotoable.photocollage.view.ProEidtActionBarView;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.fotoable.sketch.view.TTieZhiCollectionPageScrolllView;
import com.fotoable.sketch.view.TTieZhiComposeView;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.pipcamera.activity.FullscreenActivity;
import com.pipcamera.application.PIPCameraApplication;
import ew;
import fo;
import gb;
import ge;
import gm;
import go;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jw;
import jz;
import ka;
import kf;
import kv;
import la;
import ma;
import oj;
import ok;
import on;
import oo;
import oq;
import or;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;
import ov;
import oy;
import pb;
import so;
import sp;
import tc;

public class TTieZhiActivity extends FullscreenActivity
{

    boolean A;
    public oj B;
    oj C;
    boolean D;
    so E;
    boolean F;
    private ImageView G;
    private jw H;
    private List I;
    private Map J;
    private Map K;
    private Map L;
    private List M;
    private int N;
    private int O;
    private int P;
    private BroadcastReceiver Q;
    ProEidtActionBarView a;
    ImageView b;
    ImageView c;
    FrameLayout d;
    FrameLayout e;
    ProgressBar f;
    TextView g;
    Bitmap h;
    ge i;
    oy j;
    ov k;
    sp l;
    TTieZhiComposeView m;
    on n;
    TTieZhiMainLibraryView o;
    TTieZhiCollectionPageScrolllView p;
    FrameLayout q;
    HorizontalScrollView r;
    LinearLayout s;
    boolean t;
    boolean u;
    boolean v;
    float w;
    float x;
    float y;
    String z;

    public TTieZhiActivity()
    {
        n = null;
        I = new ArrayList();
        J = new HashMap();
        K = new HashMap();
        L = new HashMap();
        M = new ArrayList();
        N = -1;
        O = -1;
        P = -1;
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
        Q = null;
        D = false;
        F = false;
    }

    static Bitmap a(TTieZhiActivity ttiezhiactivity, int i1, int j1)
    {
        return ttiezhiactivity.b(i1, j1);
    }

    static ImageView a(TTieZhiActivity ttiezhiactivity)
    {
        return ttiezhiactivity.G;
    }

    private TTieZhiInfo a(int i1)
    {
        Iterator iterator;
        int j1;
        int k1;
        if (!J.containsKey(Integer.valueOf(i1)) || !K.containsKey(Integer.valueOf(i1)))
        {
            return null;
        }
        j1 = ((Integer)J.get(Integer.valueOf(i1))).intValue();
        k1 = ((Integer)K.get(Integer.valueOf(i1))).intValue();
        iterator = I.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (or)iterator.next();
        if (((or) (obj)).a != j1) goto _L4; else goto _L3
_L3:
        if (obj == null)
        {
            return null;
        }
        iterator = ((or) (obj)).e.iterator();
_L8:
        if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        obj = (oq)iterator.next();
        if (((oq) (obj)).a != k1) goto _L8; else goto _L7
_L7:
        if (obj == null)
        {
            return null;
        }
        for (obj = ((oq) (obj)).e.iterator(); ((Iterator) (obj)).hasNext();)
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

    static TTieZhiInfo a(TTieZhiActivity ttiezhiactivity, int i1)
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
        if (I.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        iterator = I.iterator();
_L2:
        Object obj;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_228;
            }
            obj = (or)iterator.next();
        } while (((or) (obj)).a == TTieZhiInfo.kTZRecommendTypeID || ((or) (obj)).e == null || ((or) (obj)).e.size() <= 0);
        obj = ((or) (obj)).e.iterator();
_L4:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        oq oq1 = (oq)((Iterator) (obj)).next();
        if (oq1 == null || oq1.e == null || oq1.e.size() <= 0) goto _L4; else goto _L3
_L3:
        int i1 = 0;
_L6:
        if (i1 >= list.size())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((Integer)list.get(i1)).intValue() != oq1.a)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        arraylist.add(oq1);
        if (arraylist.size() != list.size()) goto _L4; else goto _L5
_L5:
        return arraylist;
        i1++;
          goto _L6
        return arraylist;
    }

    private oq a(int i1, int j1)
    {
        Iterator iterator = I.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (or)iterator.next();
        if (((or) (obj)).a != i1) goto _L4; else goto _L3
_L3:
        if (obj == null)
        {
            return null;
        }
        iterator = ((or) (obj)).e.iterator();
_L8:
        if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        obj = (oq)iterator.next();
        if (((oq) (obj)).a != j1) goto _L8; else goto _L7
_L7:
        return ((oq) (obj));
_L6:
        obj = null;
        if (true) goto _L7; else goto _L2
_L2:
        obj = null;
        if (true) goto _L3; else goto _L9
_L9:
    }

    private void a(int i1, int j1, int k1, boolean flag)
    {
        Iterator iterator;
        boolean flag1;
        flag1 = false;
        iterator = I.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (or)iterator.next();
        if (((or) (obj)).a != i1) goto _L4; else goto _L3
_L3:
        if (obj == null)
        {
            a(false, ((List) (null)), -1, false);
            return;
        }
        iterator = ((or) (obj)).e.iterator();
_L8:
        if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        obj = (oq)iterator.next();
        if (((oq) (obj)).a != j1) goto _L8; else goto _L7
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
        if (i1 >= ((oq) (obj)).e.size()) goto _L11; else goto _L10
_L10:
        if (((TTieZhiInfo)((oq) (obj)).e.get(i1)).resId != k1) goto _L13; else goto _L12
_L12:
        a(true, ((oq) (obj)).e, i1, flag);
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
            translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener(flag, view) {

                final boolean a;
                final View b;
                final TTieZhiActivity c;

                public void onAnimationEnd(Animation animation)
                {
                    if (a && b != null)
                    {
                        b.setVisibility(0);
                        return;
                    } else
                    {
                        b.setVisibility(4);
                        return;
                    }
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                c = TTieZhiActivity.this;
                a = flag;
                b = view;
                super();
            }
            });
            view.startAnimation(translateanimation);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
    }

    static void a(TTieZhiActivity ttiezhiactivity, View view, int i1, int j1, long l1, boolean flag)
    {
        ttiezhiactivity.b(view, i1, j1, l1, flag);
    }

    static void a(TTieZhiActivity ttiezhiactivity, List list, boolean flag)
    {
        ttiezhiactivity.a(list, flag);
    }

    static void a(TTieZhiActivity ttiezhiactivity, JSONObject jsonobject, boolean flag)
    {
        ttiezhiactivity.a(jsonobject, flag);
    }

    static void a(TTieZhiActivity ttiezhiactivity, boolean flag)
    {
        ttiezhiactivity.c(flag);
    }

    static void a(TTieZhiActivity ttiezhiactivity, boolean flag, String s1)
    {
        ttiezhiactivity.a(flag, s1);
    }

    private void a(ArrayList arraylist)
    {
        char c1 = '\u03C0';
        E = new so();
        E.a(l);
        E.a(arraylist);
        if (getSharedPreferences("SP", 0).getInt("setting_func_img_quality", 0) != 0) goto _L2; else goto _L1
_L1:
        if (!PIPCameraApplication.b)
        {
            c1 = '\u0500';
        }
        E.b(c1);
_L4:
        E.c(new ArrayList[] {
            arraylist
        });
        return;
_L2:
        if (PIPCameraApplication.b)
        {
            c1 = '\u0280';
        }
        E.b(c1);
        if (true) goto _L4; else goto _L3
_L3:
        arraylist;
        arraylist.printStackTrace();
        return;
    }

    private void a(List list, boolean flag)
    {
        s.removeAllViews();
        if (flag || list != null && list.size() > 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        B = null;
        C = null;
        boolean flag1 = flag;
        if (flag)
        {
            oj oj1 = new oj(this, this);
            oj1.a(true);
            Object obj = a(N, O);
            int i1;
            if (obj != null)
            {
                oj1.a(((oq) (obj)).a());
                oj1.b(true);
                oj1.a(((oq) (obj)));
                obj = new android.widget.LinearLayout.LayoutParams(-2, -1);
                obj.gravity = 83;
                s.addView(oj1, ((android.view.ViewGroup.LayoutParams) (obj)));
                C = oj1;
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
                oj oj2 = new oj(this, this);
                oj2.a(false);
                oj2.a(((oq)list.get(i1)).a());
                oj2.a((oq)list.get(i1));
                if (!flag1 && i1 == 0)
                {
                    oj2.b(true);
                    B = oj2;
                    a(true, ((oq)list.get(i1)).e, -1, true);
                } else
                {
                    oj2.b(false);
                }
                obj = new android.widget.LinearLayout.LayoutParams(-2, -1);
                obj.gravity = 83;
                (new Handler()).postDelayed(new Runnable(oj2, ((android.widget.LinearLayout.LayoutParams) (obj))) {

                    final oj a;
                    final android.widget.LinearLayout.LayoutParams b;
                    final TTieZhiActivity c;

                    public void run()
                    {
                        Animation animation = AnimationUtils.loadAnimation(c, 0x7f04002b);
                        c.s.addView(a, b);
                        a.startAnimation(animation);
                    }

            
            {
                c = TTieZhiActivity.this;
                a = oj1;
                b = layoutparams;
                super();
            }
                }, i1 * 150);
                i1++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void a(JSONObject jsonobject, boolean flag)
    {
        (new Thread(new Runnable(jsonobject, flag) {

            final JSONObject a;
            final boolean b;
            final TTieZhiActivity c;

            public void run()
            {
                boolean flag1 = false;
                c.t = true;
                c.F = true;
                if (!(a instanceof JSONObject) || a.length() <= 0) goto _L2; else goto _L1
_L1:
                JSONArray jsonarray = kv.b(a, "data");
                if (jsonarray == null) goto _L4; else goto _L3
_L3:
                if (jsonarray.length() <= 0) goto _L4; else goto _L5
_L5:
                boolean flag2;
                TTieZhiActivity.i(c).clear();
                flag2 = b;
                Object obj;
                int i1;
                if (!flag2)
                {
                    try
                    {
                        TTieZhiActivity.j(c).c("json_tiezhiLibrary");
                        TTieZhiActivity.j(c).a("json_tiezhiLibrary", a, 300);
                    }
                    catch (Error error) { }
                    catch (Exception exception)
                    {
                        c.runOnUiThread(new Runnable(this) {

                            final _cls8 a;

                            public void run()
                            {
                                a.c.F = false;
                                if (a.b)
                                {
                                    a.c.c();
                                    return;
                                } else
                                {
                                    a.c.o.setIsFinishLoad(a.c.t);
                                    a.c.o.jumpToIndex(4);
                                    return;
                                }
                            }

            
            {
                a = _pcls8;
                super();
            }
                        });
                        return;
                    }
                }
                if (jsonarray == null) goto _L7; else goto _L6
_L6:
                if (jsonarray.length() <= 0) goto _L7; else goto _L8
_L8:
                i1 = 0;
_L17:
                if (i1 >= jsonarray.length()) goto _L7; else goto _L9
_L9:
                Log.e("TTieZhiActivity", (new StringBuilder()).append("dataArray.length::::").append(jsonarray.length()).toString());
                obj = kv.a(jsonarray, i1);
                if (obj == null) goto _L11; else goto _L10
_L10:
                if (!(obj instanceof JSONObject)) goto _L11; else goto _L12
_L12:
                obj = ok.a(((JSONObject) (obj)));
                if (obj == null) goto _L11; else goto _L13
_L13:
                if (((or) (obj)).a != TTieZhiInfo.kTZRecommendTypeID);
                TTieZhiActivity.i(c).add(obj);
                  goto _L11
_L7:
                TTieZhiActivity.k(c);
                TTieZhiActivity.i(c).add(oo.a().f());
                c.runOnUiThread(new Runnable(this) {

                    final _cls8 a;

                    public void run()
                    {
                        a.c.F = false;
                        if (a.c.o.getVisibility() == 0 && TTieZhiActivity.i(a.c).size() > 0)
                        {
                            Log.e("TTieZhiActivity", "mainLibrary handleData");
                            a.c.o.setIsFinishLoad(a.c.t);
                            a.c.o.handleData(TTieZhiActivity.i(a.c));
                        }
                    }

            
            {
                a = _pcls8;
                super();
            }
                });
                i1 = ((flag1) ? 1 : 0);
_L15:
                if (i1 == 0)
                {
                    break MISSING_BLOCK_LABEL_280;
                }
                c.runOnUiThread(new Runnable(this) {

                    final _cls8 a;

                    public void run()
                    {
                        a.c.F = false;
                        if (a.b)
                        {
                            a.c.c();
                            return;
                        } else
                        {
                            a.c.o.setIsFinishLoad(a.c.t);
                            a.c.o.jumpToIndex(4);
                            return;
                        }
                    }

            
            {
                a = _pcls8;
                super();
            }
                });
                return;
_L4:
                i1 = 1;
                continue; /* Loop/switch isn't completed */
_L2:
                i1 = 1;
                if (true) goto _L15; else goto _L14
_L14:
_L11:
                i1++;
                if (true) goto _L17; else goto _L16
_L16:
            }

            
            {
                c = TTieZhiActivity.this;
                a = jsonobject;
                b = flag;
                super();
            }
        })).start();
    }

    private void a(boolean flag)
    {
        if (o.getVisibility() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        try
        {
            o.setVisibility(0);
        }
        catch (Exception exception)
        {
            return;
        }
        if (!flag) goto _L1; else goto _L3
_L3:
        Animation animation = AnimationUtils.loadAnimation(this, 0x7f040020);
        o.startAnimation(animation);
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
            G.setVisibility(0);
            p.setVisibility(0);
            c(true);
        }
        if (flag)
        {
            q.setVisibility(0);
            p.setVisibility(0);
            if (flag1)
            {
                p.setData(list, i1);
                return;
            } else
            {
                p.setSelectedIndex(i1);
                return;
            }
        } else
        {
            q.setVisibility(4);
            p.setVisibility(4);
            return;
        }
    }

    public static boolean a(TTieZhiActivity ttiezhiactivity, boolean flag, oq oq1)
    {
        return ttiezhiactivity.a(flag, oq1);
    }

    private boolean a(boolean flag, oq oq1)
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
            a(oq1.f, oq1.a, P, true);
        }
_L4:
        return false;
_L2:
        if (oq1 == null)
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
        if (B.b() == oq1.a)
        {
            continue; /* Loop/switch isn't completed */
        }
        B.b(false);
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        a(oq1.f, oq1.a, -1, true);
        return true;
    }

    static int b(TTieZhiActivity ttiezhiactivity, int i1)
    {
        ttiezhiactivity.O = i1;
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
        m.drawInCanvas(canvas, w, paint);
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
        if (!J.containsKey(Integer.valueOf(i1)) || !K.containsKey(Integer.valueOf(i1)))
        {
            a(false, ((List) (null)), -1, false);
            return;
        }
        int j1 = ((Integer)J.get(Integer.valueOf(i1))).intValue();
        int k1 = ((Integer)K.get(Integer.valueOf(i1))).intValue();
        List list = (List)L.get(Integer.valueOf(i1));
        if (O == k1 && N == j1)
        {
            a(j1, k1, i1, false);
            return;
        } else
        {
            O = k1;
            N = j1;
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
            translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener(flag, view) {

                final boolean a;
                final View b;
                final TTieZhiActivity c;

                public void onAnimationEnd(Animation animation)
                {
                    if (a && b != null)
                    {
                        b.setVisibility(0);
                        return;
                    } else
                    {
                        b.setVisibility(4);
                        return;
                    }
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                c = TTieZhiActivity.this;
                a = flag;
                b = view;
                super();
            }
            });
            view.startAnimation(translateanimation);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
    }

    static void b(TTieZhiActivity ttiezhiactivity)
    {
        ttiezhiactivity.l();
    }

    static void b(TTieZhiActivity ttiezhiactivity, boolean flag)
    {
        ttiezhiactivity.b(flag);
    }

    private void b(boolean flag)
    {
        while (o.getVisibility() == 4 || v || !flag) 
        {
            return;
        }
        try
        {
            Animation animation = AnimationUtils.loadAnimation(this, 0x7f040022);
            o.startAnimation(animation);
            v = true;
            (new Handler()).postDelayed(new Runnable() {

                final TTieZhiActivity a;

                public void run()
                {
                    a.o.setVisibility(4);
                    a.v = false;
                    if (!gb.c() && a.p.getVisibility() == 0)
                    {
                        a.p.refresh();
                    }
                }

            
            {
                a = TTieZhiActivity.this;
                super();
            }
            }, 300L);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    static int c(TTieZhiActivity ttiezhiactivity, int i1)
    {
        ttiezhiactivity.N = i1;
        return i1;
    }

    static void c(TTieZhiActivity ttiezhiactivity)
    {
        ttiezhiactivity.g();
    }

    private void c(boolean flag)
    {
        boolean flag2 = true;
        boolean flag1 = true;
        if (G.isSelected() != flag)
        {
            return;
        }
        if (!flag)
        {
            ImageView imageview = G;
            if (!flag)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            imageview.setSelected(flag);
            q();
            G.setBackgroundResource(0x7f02006b);
            return;
        }
        ImageView imageview1 = G;
        if (!flag)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        imageview1.setSelected(flag);
        p();
        G.setBackgroundResource(0x7f02006a);
    }

    static int d(TTieZhiActivity ttiezhiactivity, int i1)
    {
        ttiezhiactivity.P = i1;
        return i1;
    }

    private void d()
    {
        a(true, PIPCameraApplication.a.getString(0x7f060147));
        (new Thread(new Runnable() {

            final TTieZhiActivity a;

            public void run()
            {
                a.h = a.b();
                if (a.h == null);
                a.runOnUiThread(new Runnable(this) {

                    final _cls15 a;

                    public void run()
                    {
                        TTieZhiActivity.a(a.a, false, "");
                        TTieZhiActivity.e(a.a);
                    }

            
            {
                a = _pcls15;
                super();
            }
                });
            }

            
            {
                a = TTieZhiActivity.this;
                super();
            }
        })).start();
    }

    static void d(TTieZhiActivity ttiezhiactivity)
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
            m = new TTieZhiComposeView(this);
            m.setComposeHandleLisener(k);
            if (i != null)
            {
                i.a(1.0F / w);
                m.setFaceKeyPoint(i);
            }
            d.addView(m, layoutparams);
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
                            obj = oo.a().c(j1);
                            if (obj != null && m != null)
                            {
                                (new Handler()).postDelayed(new Runnable(((TTieZhiInfo) (obj))) {

                                    final TTieZhiInfo a;
                                    final TTieZhiActivity b;

                                    public void run()
                                    {
                                        b.m.addTieZhiWithInfo(a, false);
                                    }

            
            {
                b = TTieZhiActivity.this;
                a = ttiezhiinfo;
                super();
            }
                                }, 10L);
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

    static void e(TTieZhiActivity ttiezhiactivity)
    {
        ttiezhiactivity.e();
    }

    static void e(TTieZhiActivity ttiezhiactivity, int i1)
    {
        ttiezhiactivity.b(i1);
    }

    private void f()
    {
        String s2 = "Yes";
        String s1 = "No";
        if (pb.a())
        {
            s1 = "\u53D6\u6D88";
            s2 = "\u786E\u5B9A";
        }
        (new ka(this)).b(getResources().getString(0x7f060276)).a(getResources().getString(0x7f060274)).a(true).a("  no more tips", new android.widget.CompoundButton.OnCheckedChangeListener() {

            final TTieZhiActivity a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    la.a(PIPCameraApplication.a, "TTieZhiActivity", "TAG_BACKTIP", true);
                    return;
                } else
                {
                    la.a(PIPCameraApplication.a, "TTieZhiActivity", "TAG_BACKTIP", false);
                    return;
                }
            }

            
            {
                a = TTieZhiActivity.this;
                super();
            }
        }).a(s2, new android.content.DialogInterface.OnClickListener() {

            final TTieZhiActivity a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                TTieZhiActivity.d(a);
            }

            
            {
                a = TTieZhiActivity.this;
                super();
            }
        }).b(s1, new android.content.DialogInterface.OnClickListener() {

            final TTieZhiActivity a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
            }

            
            {
                a = TTieZhiActivity.this;
                super();
            }
        }).a().show();
    }

    static void f(TTieZhiActivity ttiezhiactivity)
    {
        ttiezhiactivity.n();
    }

    static int g(TTieZhiActivity ttiezhiactivity)
    {
        return ttiezhiactivity.P;
    }

    private void g()
    {
        if (!la.a(PIPCameraApplication.a, "TAG_BACKTIP", false) && m.hasTieZhi())
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

    static List h(TTieZhiActivity ttiezhiactivity)
    {
        return ttiezhiactivity.M;
    }

    private void h()
    {
        setResult(0);
        finish();
        if (!u)
        {
            overridePendingTransition(0, 0x7f040027);
        }
    }

    static List i(TTieZhiActivity ttiezhiactivity)
    {
        return ttiezhiactivity.I;
    }

    private on i()
    {
        if (n == null)
        {
            fo fo1 = new fo(this, ImageCache.b);
            fo1.g = true;
            fo1.d = android.graphics.Bitmap.CompressFormat.PNG;
            fo1.a(0.05F);
            n = new on(this, 140);
            n.a(getSupportFragmentManager(), fo1);
        }
        return n;
    }

    static jw j(TTieZhiActivity ttiezhiactivity)
    {
        return ttiezhiactivity.H;
    }

    private void j()
    {
        l = new sp() {

            final TTieZhiActivity a;

            public void a(int i1)
            {
                TTieZhiActivity.a(a, true, PIPCameraApplication.a.getString(0x7f060147));
            }

            public void a(ArrayList arraylist, int i1)
            {
                TTieZhiActivity.a(a, false, "");
                arraylist = (Bitmap)arraylist.get(0);
                if (arraylist == null)
                {
                    TTieZhiActivity.d(a);
                    Toast.makeText(a.getApplicationContext(), 0x7f0600e4, 0).show();
                    return;
                } else
                {
                    a.h = arraylist;
                    if (a.h == null);
                    TTieZhiActivity.e(a);
                    return;
                }
            }

            
            {
                a = TTieZhiActivity.this;
                super();
            }
        };
        j = new oy() {

            final TTieZhiActivity a;

            public TTieZhiInfo a(int i1)
            {
                return TTieZhiActivity.a(a, i1);
            }

            public void a()
            {
                TTieZhiActivity.a(a, true, "");
            }

            public void a(TTieZhiInfo ttiezhiinfo, boolean flag)
            {
                TTieZhiActivity.a(a, false, "");
                if (ttiezhiinfo != null)
                {
                    if (flag)
                    {
                        TTieZhiActivity.b(a, true);
                        if (a.m != null)
                        {
                            a.m.addTieZhiWithInfo(ttiezhiinfo, true);
                            return;
                        }
                    } else
                    if (a.B != null)
                    {
                        int i1 = a.B.a();
                        int j1 = a.r.getScrollX();
                        TTieZhiActivity.a(a, a.B, 0, -(i1 - j1), 300L, true);
                        (new Handler()).postDelayed(new Runnable(this, ttiezhiinfo) {

                            final TTieZhiInfo a;
                            final _cls3 b;

                            public void run()
                            {
                                b.a.m.addTieZhiWithInfo(a, true);
                            }

            
            {
                b = _pcls3;
                a = ttiezhiinfo;
                super();
            }
                        }, 300L);
                        return;
                    } else
                    {
                        a.m.changeCurTieZhiWithInfo(oo.a().c(ttiezhiinfo.resId));
                        return;
                    }
                }
            }

            public void a(List list)
            {
                TTieZhiActivity.a(a, false, "");
                TTieZhiActivity.b(a, true);
                if (a.m != null)
                {
                    for (int i1 = 0; i1 < list.size() - 1; i1++)
                    {
                        TTieZhiInfo ttiezhiinfo = (TTieZhiInfo)list.get(i1);
                        a.m.addTieZhiWithInfo(oo.a().c(ttiezhiinfo.resId), false);
                    }

                    if (list.size() > 1)
                    {
                        list = (TTieZhiInfo)list.get(list.size() - 1);
                        a.m.addTieZhiWithInfo(oo.a().c(((TTieZhiInfo) (list)).resId), true);
                    }
                }
            }

            public void a(boolean flag)
            {
                if (flag)
                {
                    if (a.t)
                    {
                        TTieZhiActivity.f(a);
                    }
                    return;
                } else
                {
                    a.o.reload();
                    return;
                }
            }

            public void b()
            {
                TTieZhiActivity.b(a, true);
                if (TTieZhiActivity.g(a) <= 0 && TTieZhiActivity.h(a) != null && TTieZhiActivity.h(a).size() > 0)
                {
                    TTieZhiActivity.a(a, TTieZhiActivity.h(a), false);
                }
            }

            public void b(boolean flag)
            {
                TTieZhiActivity.a(a, false, "");
            }

            
            {
                a = TTieZhiActivity.this;
                super();
            }
        };
        k = new ov() {

            final TTieZhiActivity a;

            public void a(TTieZhiInfo ttiezhiinfo)
            {
                if (ttiezhiinfo != null) goto _L2; else goto _L1
_L1:
                if (TTieZhiActivity.g(a) != -1) goto _L4; else goto _L3
_L3:
                return;
_L4:
                Log.i("TTieZhiActivity", " id -1");
                TTieZhiActivity.b(a, -1);
                TTieZhiActivity.c(a, -1);
                TTieZhiActivity.d(a, -1);
                if (TTieZhiActivity.h(a) != null && TTieZhiActivity.h(a).size() > 0)
                {
                    TTieZhiActivity.a(a, TTieZhiActivity.h(a), false);
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                Log.i("TTieZhiActivity", (new StringBuilder()).append(" id ").append(ttiezhiinfo.resId).toString());
                if (TTieZhiActivity.g(a) != ttiezhiinfo.resId)
                {
                    TTieZhiActivity.d(a, ttiezhiinfo.resId);
                    TTieZhiActivity.e(a, ttiezhiinfo.resId);
                    return;
                }
                if (true) goto _L3; else goto _L5
_L5:
            }

            
            {
                a = TTieZhiActivity.this;
                super();
            }
        };
    }

    private void k()
    {
        o.setItemClickLisener(j);
        o.initWithImageWorker(i());
        o.setIsFinishLoad(false);
        o.handleData(oo.a().g());
        o.setVisibility(4);
    }

    static void k(TTieZhiActivity ttiezhiactivity)
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
                if (!F)
                {
                    if (I.size() <= 0)
                    {
                        break label1;
                    }
                    o.setIsFinishLoad(t);
                    o.handleData(I);
                }
                return;
            }
            n();
            return;
        }
        o.setIsFinishLoad(false);
    }

    private void m()
    {
        try
        {
            Animation animation = AnimationUtils.loadAnimation(this, 0x7f040024);
            c.startAnimation(animation);
            (new Handler()).postDelayed(new Runnable() {

                final TTieZhiActivity a;

                public void run()
                {
                    if (a.o.getVisibility() != 0)
                    {
                        TTieZhiActivity.b(a);
                    }
                }

            
            {
                a = TTieZhiActivity.this;
                super();
            }
            }, 1100L);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void n()
    {
        if (!pb.l(this))
        {
            Toast.makeText(this, "\u7F51\u7EDC\u5F02\u5E38", 0);
            t = true;
            o.setIsFinishLoad(t);
            o.jumpToIndex(4);
            return;
        }
        JSONObject jsonobject = H.b("json_tiezhiLibrary");
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
        if (I.size() > 0)
        {
            Iterator iterator = I.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (or)iterator.next();
                if (obj != null && ((or) (obj)).a != TTieZhiInfo.kTZRecommendTypeID)
                {
                    if (((or) (obj)).e.size() <= 0)
                    {
                        break;
                    }
                    Iterator iterator1 = ((or) (obj)).e.iterator();
                    do
                    {
                        oq oq2;
                        do
                        {
                            if (!iterator1.hasNext())
                            {
                                break;
                            }
                            oq2 = (oq)iterator1.next();
                        } while (oq2 == null || oq2.e.size() <= 0);
                        Iterator iterator2 = oq2.e.iterator();
                        while (iterator2.hasNext()) 
                        {
                            TTieZhiInfo ttiezhiinfo = (TTieZhiInfo)iterator2.next();
                            if (ttiezhiinfo != null)
                            {
                                J.put(Integer.valueOf(ttiezhiinfo.resId), Integer.valueOf(((or) (obj)).a));
                                K.put(Integer.valueOf(ttiezhiinfo.resId), Integer.valueOf(oq2.a));
                                if (oq2.g != null && oq2.g.size() > 0)
                                {
                                    L.put(Integer.valueOf(ttiezhiinfo.resId), oq2.g);
                                }
                            }
                        }
                    } while (true);
                }
                M.clear();
                if (((or) (obj)).e == null || ((or) (obj)).e.size() <= 0)
                {
                    break;
                }
                obj = ((or) (obj)).e.iterator();
label0:
                do
                {
                    oq oq1;
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break label0;
                        }
                        oq1 = (oq)((Iterator) (obj)).next();
                    } while (oq1 == null || oq1.e == null || oq1.e.size() <= 0);
                    M.add(oq1);
                } while (M.size() < 4);
            } while (true);
        }
    }

    private void p()
    {
        ((android.widget.FrameLayout.LayoutParams)p.getLayoutParams()).bottomMargin = ew.a(this, 40F);
        p.requestLayout();
        ((android.widget.FrameLayout.LayoutParams)q.getLayoutParams()).bottomMargin = ew.a(this, 40F) + p.getHeight();
        q.requestLayout();
        a(p, p.getHeight(), 0, 300L, true);
        a(q, p.getHeight(), 0, 300L, true);
    }

    private void q()
    {
        ((android.widget.FrameLayout.LayoutParams)p.getLayoutParams()).bottomMargin = ew.a(this, 40F) - p.getHeight();
        p.requestLayout();
        ((android.widget.FrameLayout.LayoutParams)q.getLayoutParams()).bottomMargin = ew.a(this, 40F);
        q.requestLayout();
        a(p, -p.getHeight(), 0, 300L, true);
        a(q, -p.getHeight(), 0, 300L, true);
    }

    protected void a()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("ACTION_MAG_MATERIAL_SHARETOWECHAT");
        registerReceiver(Q, intentfilter);
    }

    public Bitmap b()
    {
        if (h == null || h.isRecycled())
        {
            return gm.c().k();
        } else
        {
            return h;
        }
    }

    public void c()
    {
        String s1 = tc.b();
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setConnectTimeout(20000);
        asynchttpclient.setTimeout(20000);
        t = false;
        FlurryAgent.logEvent("TieZhiRequestStart");
        asynchttpclient.get(s1, null, new JsonHttpResponseHandler() {

            final TTieZhiActivity a;

            public void onFailure(int i1, Header aheader[], Throwable throwable, JSONObject jsonobject)
            {
                if (!a.D)
                {
                    a.t = true;
                    a.o.setIsFinishLoad(a.t);
                    a.o.jumpToIndex(4);
                    aheader = new HashMap();
                    aheader.put("errorcode", (new StringBuilder()).append("").append(i1).toString());
                    FlurryAgent.logEvent("TieZhiRequestFailed", aheader);
                    if (jsonobject != null)
                    {
                        Log.v("TTieZhiActivity", (new StringBuilder()).append("TTieZhiActivityonFailure errorResponse:").append(jsonobject.toString()).toString());
                        return;
                    }
                }
            }

            public void onSuccess(int i1, Header aheader[], JSONObject jsonobject)
            {
                a.t = true;
                if (i1 == 200 && jsonobject != null)
                {
                    TTieZhiActivity.a(a, jsonobject, false);
                }
            }

            
            {
                a = TTieZhiActivity.this;
                super();
            }
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030029);
        j();
        d = (FrameLayout)findViewById(0x7f0c005a);
        a = (ProEidtActionBarView)findViewById(0x7f0c00d9);
        p = (TTieZhiCollectionPageScrolllView)findViewById(0x7f0c00d5);
        p.setItemClickLisener(j);
        p.setImageWorker(i());
        q = (FrameLayout)findViewById(0x7f0c00d6);
        r = (HorizontalScrollView)findViewById(0x7f0c00d7);
        s = new LinearLayout(this);
        s.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
        s.setOrientation(0);
        bundle = new android.widget.FrameLayout.LayoutParams(-2, -2);
        bundle.gravity = 83;
        r.addView(s, bundle);
        G = (ImageView)findViewById(0x7f0c00d8);
        G.setVisibility(4);
        G.setSelected(true);
        G.setOnClickListener(new android.view.View.OnClickListener() {

            final TTieZhiActivity a;

            public void onClick(View view)
            {
                TTieZhiActivity.a(a, TTieZhiActivity.a(a).isSelected());
            }

            
            {
                a = TTieZhiActivity.this;
                super();
            }
        });
        e = (FrameLayout)findViewById(0x7f0c00dc);
        f = (ProgressBar)findViewById(0x7f0c00de);
        g = (TextView)findViewById(0x7f0c00df);
        o = (TTieZhiMainLibraryView)findViewById(0x7f0c00db);
        a(false, "");
        c = (ImageView)findViewById(0x7f0c00da);
        c.setOnClickListener(new android.view.View.OnClickListener() {

            final TTieZhiActivity a;

            public void onClick(View view)
            {
                TTieZhiActivity.b(a);
            }

            
            {
                a = TTieZhiActivity.this;
                super();
            }
        });
        a.setActionBarTitle(getString(0x7f0602a2));
        a.setOnAcceptListener(new ma() {

            final TTieZhiActivity a;

            public void d()
            {
                while (a.e.getVisibility() == 0 || a.o != null && a.o.getVisibility() == 0 || a.h == null || a.h.isRecycled()) 
                {
                    return;
                }
                kf.b("TieZhi");
                if (a.m != null && !a.m.hasTieZhi())
                {
                    TTieZhiActivity.d(a);
                    return;
                } else
                {
                    TTieZhiActivity.a(a, true, "");
                    (new Thread(new Runnable(this) {

                        final _cls13 a;

                        public void run()
                        {
                            Bitmap bitmap = TTieZhiActivity.a(a.a, a.a.h.getWidth(), a.a.h.getHeight());
                            a.a.runOnUiThread(new Runnable(this, bitmap) {

                                final Bitmap a;
                                final _cls1 b;

                                public void run()
                                {
                                    if (a != null)
                                    {
                                        gm.c().a(new go(this) {

                                            final _cls1 a;

                                            public void a()
                                            {
                                                a.b.a.a.setResult(-1);
                                                TTieZhiActivity.a(a.b.a.a, false, "");
                                                a.b.a.a.finish();
                                                a.b.a.a.overridePendingTransition(0, 0x7f040027);
                                            }

            
            {
                a = _pcls1;
                super();
            }
                                        }, a, b.a.a);
                                        return;
                                    } else
                                    {
                                        TTieZhiActivity.a(b.a.a, false, "");
                                        return;
                                    }
                                }

            
            {
                b = _pcls1;
                a = bitmap;
                super();
            }
                            });
                        }

            
            {
                a = _pcls13;
                super();
            }
                    })).start();
                    return;
                }
            }

            public void e()
            {
                TTieZhiActivity.c(a);
            }

            
            {
                a = TTieZhiActivity.this;
                super();
            }
        });
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
            if (bundle != null)
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add(Uri.parse(bundle));
                a(arraylist);
            }
            a.setVisibility(0);
        }
        H = PIPCameraApplication.i;
        k();
        n();
        if (!u)
        {
            d();
        }
        Q = new BroadcastReceiver() {

            final TTieZhiActivity a;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getAction();
                if (context != null && context.equalsIgnoreCase("ACTION_MAG_MATERIAL_SHARETOWECHAT") && intent.getBooleanExtra("sharesucceed", false))
                {
                    context = intent.getStringExtra("shareInfoStyleId");
                    if (context != null && context.length() > 0 && !context.equalsIgnoreCase("0"))
                    {
                        la.a(context);
                    }
                    a.o.reload();
                }
            }

            
            {
                a = TTieZhiActivity.this;
                super();
            }
        };
        a();
    }

    protected void onDestroy()
    {
        D = true;
        unregisterReceiver(Q);
        super.onDestroy();
        if (E != null)
        {
            E.a(null);
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            if (o.getVisibility() == 0)
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

    protected void onResume()
    {
        super.onResume();
        Object obj = (RelativeLayout)findViewById(0x7f0c0055);
        if (!ew.n(this))
        {
            ((RelativeLayout) (obj)).setVisibility(0);
            FotoAdFactory.createAdBanner(this, ((View) (obj)));
            obj = (android.widget.FrameLayout.LayoutParams)d.getLayoutParams();
            obj.topMargin = ew.a(this, 100F);
            d.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            return;
        } else
        {
            ((RelativeLayout) (obj)).setVisibility(8);
            obj = (android.widget.FrameLayout.LayoutParams)d.getLayoutParams();
            obj.topMargin = ew.a(this, 50F);
            d.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            return;
        }
    }
}
