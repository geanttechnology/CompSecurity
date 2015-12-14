// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.activity.compose2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.ad.FotoCustomReport;
import com.fotoable.photocollage.model.res.collage.TPhotoCollageComposeInfo;
import com.fotoable.photocollage.view.compose2.Compose2MaskView;
import com.pipcamera.activity.FullscreenActivity;
import com.pipcamera.activity.NewPhotoShareActivity;
import com.wantu.model.res.TFrameItemInfo;
import com.wantu.model.res.TResInfo;
import com.wantu.utility.ui.ProcessDialogFragment;
import ew;
import gh;
import gj;
import gm;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lg;
import lh;
import li;
import lj;
import ly;
import me;
import mf;
import mg;
import mh;
import rd;
import so;
import sp;

// Referenced classes of package com.fotoable.photocollage.activity.compose2:
//            CollageStylesType, CollageModuleFragment2, CollageHandleView

public class ComposePhotoesActivity2 extends FullscreenActivity
    implements lh, me, mf, mg, sp
{

    ImageView A;
    int B;
    Uri C;
    String D;
    public Bitmap E;
    public boolean F;
    public boolean G;
    Uri H;
    public com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType I;
    com.wantu.service.material.TComposeFreeStyleManager.FreeComposeType J;
    TextView K;
    TextView L;
    TPhotoCollageComposeInfo M;
    RelativeLayout N;
    boolean O;
    so P;
    so Q;
    private int R;
    private ProgressDialog S;
    private Bitmap T;
    private int U;
    private int V;
    private boolean W;
    private String X;
    View a;
    FrameLayout b;
    FrameLayout c;
    FrameLayout d;
    public CollageHandleView e;
    public FrameLayout f;
    public CollageStylesType g;
    FrameLayout h;
    ViewGroup i;
    int j;
    int k;
    int l;
    int m;
    int n;
    int o;
    int p;
    public List q;
    int r;
    int s;
    public CollageModuleFragment2 t;
    ProcessDialogFragment u;
    Compose2MaskView v;
    ArrayList w;
    public View x;
    public boolean y;
    View z;

    public ComposePhotoesActivity2()
    {
        g = CollageStylesType.collageFrame;
        j = 40;
        k = 100;
        l = 90;
        m = 90;
        n = 90;
        o = 50;
        p = 0;
        q = new ArrayList();
        R = 0;
        y = false;
        U = -1;
        V = -1;
        W = false;
        C = null;
        E = null;
        F = false;
        G = false;
        H = null;
        I = com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11;
        J = com.wantu.service.material.TComposeFreeStyleManager.FreeComposeType.COMPOSE_11;
        O = true;
    }

    private void a(int i1, int j1, boolean flag)
    {
        float f1 = (float)i1 / (float)j1;
        i1 = ew.a(this, p - 16);
        j1 = ew.d(this) - ew.a(this, 16F);
        android.widget.FrameLayout.LayoutParams layoutparams;
        if (f1 > (float)i1 / (float)j1)
        {
            j1 = (int)((float)i1 / f1);
        } else
        {
            i1 = (int)((float)j1 * f1);
        }
        layoutparams = (android.widget.FrameLayout.LayoutParams)c.getLayoutParams();
        layoutparams.height = i1;
        layoutparams.width = j1;
        layoutparams.gravity = 17;
        c.requestLayout();
        r = j1;
        s = i1;
    }

    private void a(Uri uri)
    {
        try
        {
            W = true;
            a(true);
            ArrayList arraylist = new ArrayList();
            arraylist.add(uri);
            C = null;
            Q = new so();
            Q.a(this);
            Q.a(arraylist);
            Q.c(new ArrayList[] {
                arraylist
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            uri.printStackTrace();
        }
        Crashlytics.logException(uri);
    }

    private void a(Bundle bundle)
    {
        Log.d("ComposePhotoesActivity2", "reload......");
        a(true);
        int i1 = bundle.getInt("imagesCounts");
        V = bundle.getInt("selectIndex");
        String s1 = bundle.getString("composePhotoType");
        r = bundle.getInt("collageViewWidth");
        s = bundle.getInt("collageViewHeight");
        w = bundle.getStringArrayList("ImageIds");
        q = gm.c().a(i1, V);
        U = -1;
        bundle = s1;
        if (s1 == null)
        {
            bundle = "module";
        }
        if (bundle.equals("module"))
        {
            t = (CollageModuleFragment2)getSupportFragmentManager().findFragmentByTag("moduleFrame");
            t.a(this);
        }
        b(true);
    }

    private void a(View view, int i1, long l1, boolean flag)
    {
        if (view == null)
        {
            return;
        }
        try
        {
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), i1);
            animation.setDuration(l1);
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(flag, view) {

                final boolean a;
                final View b;
                final ComposePhotoesActivity2 c;

                public void onAnimationEnd(Animation animation1)
                {
                    if (a)
                    {
                        b.setVisibility(0);
                        return;
                    } else
                    {
                        b.setVisibility(4);
                        return;
                    }
                }

                public void onAnimationRepeat(Animation animation1)
                {
                }

                public void onAnimationStart(Animation animation1)
                {
                }

            
            {
                c = ComposePhotoesActivity2.this;
                a = flag;
                b = view;
                super();
            }
            });
            view.startAnimation(animation);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    public static void a(ComposePhotoesActivity2 composephotoesactivity2, View view, int i1, long l1, boolean flag)
    {
        composephotoesactivity2.a(view, i1, l1, flag);
    }

    public static void a(ComposePhotoesActivity2 composephotoesactivity2, File file)
    {
        composephotoesactivity2.a(file);
    }

    public static void a(ComposePhotoesActivity2 composephotoesactivity2, boolean flag)
    {
        composephotoesactivity2.e(flag);
    }

    private void a(File file)
    {
        if (file == null || !file.exists())
        {
            b(false);
            if (E != null && !E.isRecycled())
            {
                E.recycle();
                E = null;
            }
        } else
        {
            rd.a(file.getAbsolutePath(), this);
            file = Uri.fromFile(file);
            if (file != null)
            {
                FlurryAgent.logEvent("PhotoSave_Collage_Strip");
                Intent intent = new Intent(this, com/pipcamera/activity/NewPhotoShareActivity);
                intent.putExtra("PhotoShareActivity_ToShareImageUri", file.toString());
                intent.putExtra("colloageReIn", true);
                intent.putStringArrayListExtra("CollageIds", w);
                intent.putExtra("isLinkShare", true);
                FotoCustomReport.addStringToArray(FotoCustomReport.userSavedFunction, "collage");
                startActivity(intent);
                overridePendingTransition(0x7f040007, 0);
                b(false);
                x.setEnabled(true);
                y = true;
                return;
            }
        }
    }

    private void d()
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        int i1;
        try
        {
            a(true);
            arraylist = w;
            arraylist1 = new ArrayList();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return;
        }
        i1 = 0;
        if (i1 >= arraylist.size())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist1.add(Uri.parse((String)arraylist.get(i1)));
        i1++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_20;
_L1:
        P = new so();
        P.a(this);
        P.a(arraylist1);
        P.b(ly.a(arraylist1.size()));
        P.c(new ArrayList[] {
            arraylist1
        });
        Log.d("ComposePhotoesActivity2", (new StringBuilder()).append("mBitmaps").append(q.toString()).toString());
        return;
    }

    private void e()
    {
        K = (TextView)findViewById(0x7f0c004f);
        a = findViewById(0x7f0c0047);
        p = ew.b(this) - j - k;
        h = (FrameLayout)findViewById(0x7f0c0052);
        h.setOnClickListener(new li(this));
        h.setVisibility(0);
        b = (FrameLayout)findViewById(0x7f0c0056);
        ((android.widget.FrameLayout.LayoutParams)b.getLayoutParams()).topMargin = ew.a(this, k);
        b.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ComposePhotoesActivity2 a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (a.f.getVisibility() == 0)
                {
                    ComposePhotoesActivity2.a(a, a.f, 0x7f04002e, 300L, false);
                    if (a.t != null)
                    {
                        a.t.c(false);
                        ComposePhotoesActivity2.a(a, false);
                    }
                }
                return false;
            }

            
            {
                a = ComposePhotoesActivity2.this;
                super();
            }
        });
        c = (FrameLayout)findViewById(0x7f0c0057);
        L = (TextView)findViewById(0x7f0c002d);
        x = findViewById(0x7f0c004e);
        x.setOnClickListener(new lj(this));
        if (!ew.a())
        {
            J = com.wantu.service.material.TComposeFreeStyleManager.FreeComposeType.COMPOSE_11;
            I = com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11;
        } else
        {
            J = com.wantu.service.material.TComposeFreeStyleManager.FreeComposeType.COMPOSE_43;
            I = com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_43;
        }
        z = findViewById(0x7f0c004a);
        z.setOnClickListener(new android.view.View.OnClickListener() {

            final ComposePhotoesActivity2 a;

            public void onClick(View view)
            {
                a.b();
            }

            
            {
                a = ComposePhotoesActivity2.this;
                super();
            }
        });
        A = (ImageView)findViewById(0x7f0c029f);
        d = (FrameLayout)findViewById(0x7f0c0050);
    }

    private void e(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            f(flag);
        }
    }

    private void f()
    {
        if (t != null)
        {
            getSupportFragmentManager().beginTransaction().remove(t).commitAllowingStateLoss();
            t = null;
        }
    }

    private void f(boolean flag)
    {
        if (flag)
        {
            int i1 = ew.a(this, 190F);
            int j1 = ew.a(this, k);
            int k1 = ew.e(this);
            if (k1 >= i1 + j1 + s)
            {
                i1 = ew.a(this, 150F) / 2;
                c.setScaleX(1.0F);
                c.setScaleY(1.0F);
                c.setTranslationY(-i1);
                return;
            } else
            {
                i1 = (k1 - i1 - j1) + ew.a(this, 10F);
                float f1 = (float)i1 / (float)ew.a(this, p);
                c.setScaleX(f1);
                c.setScaleY(f1);
                c.setTranslationY(-((ew.a(this, p) - i1) + ew.a(this, 10F)) / 2);
                return;
            }
        } else
        {
            c.setTranslationY(0.0F);
            c.setScaleX(1.0F);
            c.setScaleY(1.0F);
            return;
        }
    }

    private void g()
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)c.getLayoutParams();
        layoutparams.height = -1;
        layoutparams.width = -1;
        layoutparams.gravity = 17;
        c.requestLayout();
        int i1 = ew.a(this, p);
        r = ew.d(this);
        s = i1;
    }

    public void a()
    {
        if (S == null || !S.isShowing() || isFinishing())
        {
            break MISSING_BLOCK_LABEL_36;
        }
        S.dismiss();
        S = null;
        return;
        Exception exception;
        exception;
        Crashlytics.logException(exception);
        return;
    }

    public void a(int i1)
    {
        Log.v("ComposePhotoesActivity2", "StartProcessing");
    }

    public void a(com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType fixcomposetype, TPhotoCollageComposeInfo tphotocollagecomposeinfo)
    {
        Log.e("ComposePhotoesActivity2", (new StringBuilder()).append("fixComposeFrame selected: ").append(tphotocollagecomposeinfo.name).toString());
        float f2 = t.f();
        float f1 = t.d();
        boolean flag1 = t.e();
        boolean flag = t.g();
        if (M == null || !M.name.equals(tphotocollagecomposeinfo.name))
        {
            f2 = tphotocollagecomposeinfo.getDefaultEdge();
            f1 = tphotocollagecomposeinfo.getRoundRadius();
            M = tphotocollagecomposeinfo;
            flag = false;
            flag1 = false;
        }
        a(fixcomposetype, tphotocollagecomposeinfo, ((TFrameItemInfo) (null)));
        e.setRadius(f1);
        e.setEdge(f2);
        e.setShadow(flag1);
        e.setBK(flag);
        t.a((int)f1);
        t.b((int)f2);
        t.a(flag1);
        t.b(flag);
        y = false;
    }

    public void a(com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType fixcomposetype, TPhotoCollageComposeInfo tphotocollagecomposeinfo, TFrameItemInfo tframeiteminfo)
    {
        boolean flag;
        if (I != fixcomposetype)
        {
            e(false);
            flag = true;
        } else
        {
            flag = false;
        }
        g();
        I = fixcomposetype;
        if (fixcomposetype != com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11) goto _L2; else goto _L1
_L1:
        a(1, 1, false);
        if (t == null)
        {
            Log.i("ComposePhotoesActivity2", "test   0004");
            t = new CollageModuleFragment2();
            t.a(this);
            t.a(r, s);
            t.a(q);
            t.a(tphotocollagecomposeinfo);
            t.a(tframeiteminfo);
            getSupportFragmentManager().beginTransaction().add(0x7f0c0057, t, "moduleFrame").commitAllowingStateLoss();
        } else
        {
            Log.i("ComposePhotoesActivity2", "test   0005");
            t.a(r, s);
            t.a(tphotocollagecomposeinfo);
        }
_L4:
        if (flag)
        {
            e(true);
        }
        if (t != null)
        {
            t.c(true);
            e(true);
        }
        return;
_L2:
        if (fixcomposetype == com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_43)
        {
            a(4, 3, false);
            if (t == null)
            {
                Log.i("ComposePhotoesActivity2", "test   0006");
                t = new CollageModuleFragment2();
                t.a(this);
                t.a(r, s);
                t.a(q);
                t.a(tphotocollagecomposeinfo);
                t.a(tframeiteminfo);
                getSupportFragmentManager().beginTransaction().add(0x7f0c0057, t, "moduleFrame").commitAllowingStateLoss();
            } else
            {
                Log.i("ComposePhotoesActivity2", "test   0007");
                t.a(r, s);
                t.a(tphotocollagecomposeinfo);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(TResInfo tresinfo)
    {
        if (tresinfo instanceof TFrameItemInfo)
        {
            tresinfo = (TFrameItemInfo)tresinfo;
            if (t != null)
            {
                t.a(tresinfo);
            }
            y = false;
        }
    }

    public void a(String s1)
    {
        while (isFinishing() || isFinishing()) 
        {
            return;
        }
        try
        {
            S = ProgressDialog.show(this, "", s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Crashlytics.logException(s1);
        }
    }

    public void a(ArrayList arraylist, int i1)
    {
        if (!W)
        {
            if (arraylist == null || arraylist.size() < 0)
            {
                arraylist = "Crop failed";
                if (ew.a())
                {
                    arraylist = "\u88C1\u56FE\u5931\u8D25\uFF01";
                }
                Toast.makeText(this, arraylist, 0);
                return;
            }
            q = arraylist;
            try
            {
                arraylist = mh.a();
                a(((com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType) (arraylist)), mh.a(arraylist, q.size()), mh.b());
            }
            // Misplaced declaration of an exception variable
            catch (ArrayList arraylist)
            {
                arraylist.printStackTrace();
                Crashlytics.logException(arraylist);
            }
            arraylist = new gh();
            arraylist.a(q);
            arraylist.a(new gj() {

                final ComposePhotoesActivity2 a;

                public void a(boolean flag)
                {
                }

            
            {
                a = ComposePhotoesActivity2.this;
                super();
            }
            });
            arraylist.execute(new String[0]);
            return;
        }
        if (arraylist.size() > 0)
        {
            if (t != null)
            {
                U = t.b();
            }
            if (U >= 0 && U < q.size())
            {
                w.set(U, D);
                Bitmap bitmap = (Bitmap)q.get(U);
                q.set(U, arraylist.get(0));
                if (bitmap != null && !bitmap.isRecycled())
                {
                    bitmap.recycle();
                }
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            T = (Bitmap)arraylist.get(0);
            if (t != null && i1 != 0)
            {
                t.a((Bitmap)arraylist.get(0), U);
            }
        }
        Log.v("ComposePhotoesActivity2", "on photo");
    }

    public void a(boolean flag)
    {
        try
        {
            if (u == null)
            {
                ProcessDialogFragment processdialogfragment = new ProcessDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putString("text", c());
                processdialogfragment.setArguments(bundle);
                processdialogfragment.setCancelable(false);
                u = processdialogfragment;
                u.show(getSupportFragmentManager(), "process");
            }
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        if (flag)
        {
            if (v == null)
            {
                v = new Compose2MaskView(this);
                v.setBackgroundColor(getResources().getColor(0x7f0b0081));
            }
            if (b.indexOfChild(v) < 0)
            {
                b.addView(v);
            }
        }
    }

    public void a(boolean flag, boolean flag1)
    {
        if (f.getVisibility() == 0 && flag1)
        {
            a(((View) (f)), 0x7f04002e, 300L, false);
            if (t != null)
            {
                t.c(false);
                e(false);
            }
        }
    }

    public void b()
    {
        gm.c().i();
        f();
        FlurryAgent.logEvent("Collage_backClicked");
        finish();
    }

    public void b(int i1)
    {
        if (t != null)
        {
            t.a(i1);
            e.setRadius(i1);
            y = false;
            Log.v("ComposePhotoesActivity2", String.valueOf(i1));
        }
    }

    public void b(boolean flag)
    {
        runOnUiThread(new Runnable(flag) {

            final boolean a;
            final ComposePhotoesActivity2 b;

            public void run()
            {
                if (b.u != null)
                {
                    b.u.dismissAllowingStateLoss();
                    b.u = null;
                }
                if (a && b.v != null)
                {
                    b.b.removeView(b.v);
                }
                b.a();
            }

            
            {
                b = ComposePhotoesActivity2.this;
                a = flag;
                super();
            }
        });
    }

    public String c()
    {
        return X;
    }

    public void c(int i1)
    {
        if (t != null)
        {
            if (t.h)
            {
                t.b(i1);
            }
            e.setEdge(i1);
        }
    }

    public void c(boolean flag)
    {
        if (t != null)
        {
            t.a(flag);
            e.setShadow(flag);
        }
    }

    public void d(boolean flag)
    {
        if (t != null)
        {
            t.b(flag);
            e.setBK(flag);
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        Log.d("ComposePhotoesActivity2", (new StringBuilder()).append("onActivityResult ...--------------------0,,,resutltCode:").append(j1).toString());
        if (j1 == -1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Log.d("ComposePhotoesActivity2", "onActivityResult ...--------------------1");
        if (i1 != 153) goto _L4; else goto _L3
_L3:
        Log.v("ComposePhotoesActivity2", "RESULT_IMAGE_LIB_WITH_DATA");
        if (intent == null) goto _L1; else goto _L5
_L5:
        C = intent.getData();
        D = C.toString();
_L8:
        Log.i("ComposePhotoesActivity2", "onActivityResult");
        return;
_L4:
        Log.d("ComposePhotoesActivity2", "onActivityResult ...--------------------2");
        intent = gm.c().k();
        if (t != null)
        {
            U = t.b();
        }
        if (q == null || q.size() == 0 || U == -1) goto _L1; else goto _L6
_L6:
        Bitmap bitmap;
        if (U < 0 || U >= q.size())
        {
            break MISSING_BLOCK_LABEL_231;
        }
        bitmap = (Bitmap)q.get(U);
        q.set(U, intent);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        if (bitmap.isRecycled() || bitmap == intent)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        bitmap.recycle();
        T = intent;
        Log.d("ComposePhotoesActivity2", q.toString());
        if (t == null)
        {
            break MISSING_BLOCK_LABEL_288;
        }
        U = t.b();
        if (U == -1) goto _L1; else goto _L7
_L7:
        t.a(intent);
        U = -1;
_L9:
        Log.d("ComposePhotoesActivity2", q.toString());
          goto _L8
        intent;
        Crashlytics.logException(intent);
          goto _L9
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030018);
        j = 40;
        B = 94;
        X = getResources().getString(0x7f0601a4);
        i = (ViewGroup)(ViewGroup)getWindow().getDecorView().findViewById(0x1020002);
        boolean flag;
        if (!ew.n(this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        O = flag;
        N = (RelativeLayout)findViewById(0x7f0c0055);
        N.setVisibility(0);
        if (!O)
        {
            k = 50;
            N.setVisibility(4);
        }
        e();
        if (getIntent() != null)
        {
            w = getIntent().getExtras().getStringArrayList("CollageIds");
        }
        if (bundle != null)
        {
            Log.d("ComposePhotoesActivity2", "null != savedInstanceState");
            V = bundle.getInt("selectIndex");
            int i1 = bundle.getInt("imagesCounts");
            q = gm.c().a(i1, V);
            if (q == null || q.size() <= 0)
            {
                if (w != null && w.size() > 0)
                {
                    d();
                } else
                {
                    Toast.makeText(this, "No photo to show", 0);
                }
            } else
            {
                a(bundle);
            }
        } else
        {
            Log.d("ComposePhotoesActivity2", "null == savedInstanceState");
            if (w != null && w.size() > 0)
            {
                d();
            } else
            {
                Toast.makeText(this, "No photo to show", 0);
            }
        }
        f = (FrameLayout)findViewById(0x7f0c0058);
        e = (CollageHandleView)findViewById(0x7f0c0059);
        e.setListener(new lg() {

            final ComposePhotoesActivity2 a;

            public void a()
            {
                ComposePhotoesActivity2.a(a, a.f, 0x7f04002e, 300L, false);
                a.h.setVisibility(0);
                if (a.t != null)
                {
                    a.t.c(false);
                    ComposePhotoesActivity2.a(a, false);
                }
            }

            
            {
                a = ComposePhotoesActivity2.this;
                super();
            }
        });
        if (g == CollageStylesType.collageFrame)
        {
            e.setData(w.size(), I);
            a(f, 0x7f04002d, 300L, true);
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("ComposePhotoesActivity2", "onDestroy...........");
        if (Q != null)
        {
            Q.a(null);
        }
        if (P != null)
        {
            P.a(null);
        }
        if (q != null)
        {
            Iterator iterator = q.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Bitmap bitmap = (Bitmap)iterator.next();
                if (bitmap != null && !bitmap.isRecycled())
                {
                    bitmap.recycle();
                }
            } while (true);
        }
        q.clear();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            b();
            return true;
        } else
        {
            return false;
        }
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        if (O)
        {
            FotoAdFactory.createAdBanner(this, N);
        }
        if (C != null)
        {
            a(C);
        }
        if (t == null);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("ImageIds", w);
        bundle.putInt("imagesCounts", q.size());
        bundle.putInt("selectIndex", U);
        bundle.putInt("collageViewWidth", r);
        bundle.putInt("collageViewHeight", s);
        bundle.putStringArrayList("ImageIds", w);
        if (t != null)
        {
            bundle.putString("composePhotoType", "module");
        }
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }
}
