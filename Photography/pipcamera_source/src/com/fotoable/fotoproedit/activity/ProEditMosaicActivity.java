// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;
import com.fotoable.fotoproedit.activity.mosaic.MosaicIconScrollView;
import com.fotoable.fotoproedit.activity.mosaic.MosaicInfo;
import com.fotoable.photocollage.view.ProEidtActionBarView;
import com.fotoable.photocollage.view.compose2.color.ColorSelectView;
import com.pipcamera.activity.FullscreenActivity;
import com.wantu.utility.ui.ProcessDialogFragment;
import ew;
import gm;
import go;
import ig;
import ih;
import ii;
import kf;
import la;
import ma;
import mm;

public class ProEditMosaicActivity extends FullscreenActivity
    implements ii, ma
{

    public static String a = "proedit_mosaic_mode";
    private RelativeLayout A;
    private android.view.View.OnClickListener B;
    private android.view.View.OnClickListener C;
    private android.view.View.OnClickListener D;
    private android.view.View.OnClickListener E;
    private android.view.View.OnClickListener F;
    private android.view.View.OnClickListener G;
    private String b;
    private String c;
    private ProEidtActionBarView d;
    private ImageButton e;
    private ImageButton f;
    private ImageButton g;
    private ImageButton h;
    private ImageButton i;
    private ImageButton j;
    private ImageButton k;
    private Bitmap l;
    private boolean m;
    private MosaicGLSurfaceView n;
    private FrameLayout o;
    private MosaicIconScrollView p;
    private int q;
    private MosaicInfo r;
    private ColorSelectView s;
    private ImageButton t;
    private ImageButton u;
    private LinearLayout v;
    private ProcessDialogFragment w;
    private String x;
    private ImageView y;
    private FrameLayout z;

    public ProEditMosaicActivity()
    {
        b = "ProEditMosaicActivity";
        c = "mosaic_first_tip";
        m = true;
        q = 64;
        B = new android.view.View.OnClickListener() {

            final ProEditMosaicActivity a;

            public void onClick(View view)
            {
                if (ProEditMosaicActivity.c(a).isEnabled())
                {
                    ProEditMosaicActivity.d(a).moveNext();
                }
            }

            
            {
                a = ProEditMosaicActivity.this;
                super();
            }
        };
        C = new android.view.View.OnClickListener() {

            final ProEditMosaicActivity a;

            public void onClick(View view)
            {
                if (ProEditMosaicActivity.e(a).isEnabled())
                {
                    ProEditMosaicActivity.d(a).movePrevious();
                }
            }

            
            {
                a = ProEditMosaicActivity.this;
                super();
            }
        };
        D = new android.view.View.OnClickListener() {

            final ProEditMosaicActivity a;

            public void onClick(View view)
            {
                ProEditMosaicActivity.a(a, ProEditMosaicActivity.h(a), false);
                ProEditMosaicActivity.a(a, ProEditMosaicActivity.i(a), false);
                ProEditMosaicActivity.a(a, ProEditMosaicActivity.j(a), false);
                ProEditMosaicActivity.a(a, ProEditMosaicActivity.k(a), false);
                ProEditMosaicActivity.a(a, (ImageButton)view, true);
                switch (((Integer)view.getTag()).intValue())
                {
                default:
                    return;

                case 1024: 
                    view = ProEditMosaicActivity.d(a);
                    int i1;
                    if (ProEditMosaicActivity.l(a))
                    {
                        i1 = ProEditMosaicActivity.m(a);
                    } else
                    {
                        i1 = (int)((double)ProEditMosaicActivity.m(a) * 0.5D);
                    }
                    view.setBrushSize(i1);
                    return;

                case 1025: 
                    view = ProEditMosaicActivity.d(a);
                    int j1;
                    if (ProEditMosaicActivity.l(a))
                    {
                        j1 = (int)((double)ProEditMosaicActivity.m(a) * 1.5D);
                    } else
                    {
                        j1 = ProEditMosaicActivity.m(a);
                    }
                    view.setBrushSize(j1);
                    return;

                case 1026: 
                    view = ProEditMosaicActivity.d(a);
                    int k1;
                    if (ProEditMosaicActivity.l(a))
                    {
                        k1 = ProEditMosaicActivity.m(a) * 2;
                    } else
                    {
                        k1 = (int)((double)ProEditMosaicActivity.m(a) * 1.5D);
                    }
                    view.setBrushSize(k1);
                    return;

                case 1027: 
                    view = ProEditMosaicActivity.d(a);
                    break;
                }
                int l1;
                if (ProEditMosaicActivity.l(a))
                {
                    l1 = ProEditMosaicActivity.m(a) * 3;
                } else
                {
                    l1 = (int)((double)ProEditMosaicActivity.m(a) * 2.2000000000000002D);
                }
                view.setBrushSize(l1);
            }

            
            {
                a = ProEditMosaicActivity.this;
                super();
            }
        };
        E = new android.view.View.OnClickListener() {

            final ProEditMosaicActivity a;

            public void onClick(View view)
            {
                if (view.isSelected())
                {
                    return;
                } else
                {
                    ProEditMosaicActivity.a(a, ProEditMosaicActivity.n(a), true);
                    ProEditMosaicActivity.a(a, ProEditMosaicActivity.o(a), false);
                    ProEditMosaicActivity.a(a, ProEditMosaicActivity.f(a));
                    return;
                }
            }

            
            {
                a = ProEditMosaicActivity.this;
                super();
            }
        };
        F = new android.view.View.OnClickListener() {

            final ProEditMosaicActivity a;

            public void onClick(View view)
            {
                boolean flag;
                if (!view.isSelected())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ProEditMosaicActivity.a(a, ProEditMosaicActivity.o(a), flag);
                if (flag)
                {
                    ProEditMosaicActivity.d(a).shiftEraser();
                    ProEditMosaicActivity.d(a).setBrushImagePath("mosaicRes/paintBrush/paintBrush0.png");
                    return;
                } else
                {
                    ProEditMosaicActivity.a(a, ProEditMosaicActivity.f(a));
                    return;
                }
            }

            
            {
                a = ProEditMosaicActivity.this;
                super();
            }
        };
        G = new android.view.View.OnClickListener() {

            final ProEditMosaicActivity a;

            public void onClick(View view)
            {
                ProEditMosaicActivity proeditmosaicactivity = a;
                boolean flag;
                if (!view.isSelected())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ProEditMosaicActivity.a(proeditmosaicactivity, flag);
            }

            
            {
                a = ProEditMosaicActivity.this;
                super();
            }
        };
    }

    static FrameLayout a(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.z;
    }

    private void a(View view, boolean flag)
    {
        view.setVisibility(0);
        Animation animation;
        if (flag)
        {
            animation = AnimationUtils.loadAnimation(this, 0x7f04001c);
        } else
        {
            animation = AnimationUtils.loadAnimation(this, 0x7f04001d);
        }
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(flag, view) {

            final boolean a;
            final View b;
            final ProEditMosaicActivity c;

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
                c = ProEditMosaicActivity.this;
                a = flag;
                b = view;
                super();
            }
        });
        view.startAnimation(animation);
    }

    private void a(ImageButton imagebutton, boolean flag)
    {
        imagebutton.setSelected(flag);
        if (imagebutton == e)
        {
            if (flag)
            {
                e.getDrawable().clearColorFilter();
                e.setImageResource(0x7f0201a2);
                return;
            } else
            {
                e.getDrawable().clearColorFilter();
                e.setImageResource(0x7f0201a3);
                return;
            }
        }
        if (flag)
        {
            imagebutton.getDrawable().setColorFilter(Color.argb(255, 0, 122, 255), android.graphics.PorterDuff.Mode.MULTIPLY);
            return;
        } else
        {
            imagebutton.getDrawable().clearColorFilter();
            return;
        }
    }

    static void a(ProEditMosaicActivity proeditmosaicactivity, ImageButton imagebutton, boolean flag)
    {
        proeditmosaicactivity.a(imagebutton, flag);
    }

    static void a(ProEditMosaicActivity proeditmosaicactivity, MosaicInfo mosaicinfo)
    {
        proeditmosaicactivity.a(mosaicinfo);
    }

    static void a(ProEditMosaicActivity proeditmosaicactivity, boolean flag)
    {
        proeditmosaicactivity.a(flag);
    }

    private void a(MosaicInfo mosaicinfo)
    {
        r = mosaicinfo;
        a(j, false);
        class _cls5
        {

            static final int a[];

            static 
            {
                a = new int[com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.values().length];
                try
                {
                    a[com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Mosaic_Image.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Mosaic_Maoboli.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Mosaic_Normal.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Mosaic_Youhua.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Paint_3D.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Paint_Normal.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls5.a[mosaicinfo.a.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            n.shiftNormalMosaic();
            n.setBrushImagePath("mosaicRes/paintBrush/paintBrush0.png");
            n.setMosaicImagePath(mosaicinfo.c);
            Log.e(b, (new StringBuilder()).append("mosaicImageStr:").append(mosaicinfo.c).toString());
            return;

        case 2: // '\002'
            n.shiftNormalMosaic();
            n.setBrushImagePath("mosaicRes/paintBrush/paintBrush0.png");
            n.setMosaicImagePath("maoboli");
            return;

        case 3: // '\003'
            n.shiftNormalMosaic();
            n.setBrushImagePath("mosaicRes/paintBrush/paintBrush0.png");
            n.setMosaicImagePath("mosaic");
            return;

        case 4: // '\004'
            n.shiftRandomMosaic();
            n.setBrushImagePath(mosaicinfo.b);
            Log.e(b, (new StringBuilder()).append("mosaicImageStr:").append(mosaicinfo.b).toString());
            return;

        case 5: // '\005'
            n.shift3DPen();
            n.setBrushImagePath(mosaicinfo.e);
            Log.e(b, (new StringBuilder()).append("mosaicImageStr:").append(mosaicinfo.e).toString());
            return;

        case 6: // '\006'
            n.shiftColorPen();
            break;
        }
        n.setBrushImagePath(mosaicinfo.d);
        Log.e(b, (new StringBuilder()).append("mosaicImageStr:").append(mosaicinfo.d).toString());
    }

    private void a(boolean flag)
    {
        a(e, flag);
        a(((View) (v)), flag);
    }

    static String b(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.c;
    }

    static ImageButton c(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.u;
    }

    static MosaicGLSurfaceView d(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.n;
    }

    static ImageButton e(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.t;
    }

    static MosaicInfo f(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.r;
    }

    private void f()
    {
        m = getIntent().getBooleanExtra(a, true);
        l = gm.c().k();
        if (l == null)
        {
            b();
            finish();
            return;
        }
        n = new MosaicGLSurfaceView(this);
        MosaicGLSurfaceView mosaicglsurfaceview = n;
        double d1;
        if (m)
        {
            d1 = (double)q * 1.5D;
        } else
        {
            d1 = q;
        }
        mosaicglsurfaceview.setBrushSize((int)d1);
        n.setPenColor(-256);
        n.setBrushImagePath("mosaicRes/paintBrush/paintBrush0.png");
        n.setMosaicImagePath("maoboli");
        n.setOriImage(l);
        n.setOperateDelegate(this);
        n.setMosaicOrPaint(m);
        n.setMinPenSize(q);
        if (m)
        {
            n.shiftNormalMosaic();
            r = new MosaicInfo();
            r.a = com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Mosaic_Maoboli;
            d.setActionBarTitle(getResources().getText(0x7f06029f).toString());
            ih ih1 = new ih();
            p.fillIconScroll(ih1.a());
            s.setVisibility(8);
        } else
        {
            n.shiftColorPen();
            r = new MosaicInfo();
            r.d = "mosaicRes/paintBrush/paintBrush0.png";
            r.a = com.fotoable.fotoproedit.activity.mosaic.MosaicInfo.MosaicMode.Paint_Normal;
            d.setActionBarTitle(getResources().getText(0x7f06029c).toString());
            ih ih2 = new ih();
            p.fillIconScroll(ih2.b());
            s.setMaxSizeWithDoubleLine(getResources().getDisplayMetrics().widthPixels, ew.a(this, 36F));
            s.setVisibility(0);
            s.setOnColorSelectorListener(new mm() {

                final ProEditMosaicActivity a;

                public void TouchBegin()
                {
                    ProEditMosaicActivity.g(a).setVisibility(0);
                }

                public void TouchEnd()
                {
                    ProEditMosaicActivity.g(a).setVisibility(4);
                }

                public void onColorSelector(int i1)
                {
                    ProEditMosaicActivity.a(a, ProEditMosaicActivity.f(a));
                    ProEditMosaicActivity.d(a).setPenColor(i1);
                    Bitmap bitmap = a.a(i1);
                    ProEditMosaicActivity.g(a).setImageBitmap(bitmap);
                }

            
            {
                a = ProEditMosaicActivity.this;
                super();
            }
            });
        }
        d.setOnAcceptListener(this);
        o.addView(n, new android.widget.FrameLayout.LayoutParams(-1, -1));
        p.setListener(new ig() {

            final ProEditMosaicActivity a;

            public void a(MosaicInfo mosaicinfo)
            {
                ProEditMosaicActivity.a(a, mosaicinfo);
            }

            
            {
                a = ProEditMosaicActivity.this;
                super();
            }
        });
    }

    static ImageView g(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.y;
    }

    private void g()
    {
        e.setTag("btnPen");
        f.setTag(Integer.valueOf(1024));
        g.setTag(Integer.valueOf(1025));
        h.setTag(Integer.valueOf(1026));
        i.setTag(Integer.valueOf(1027));
        j.setTag("btnErase");
        k.setTag("btnBgChange");
        e.setOnClickListener(G);
        j.setOnClickListener(F);
        k.setOnClickListener(E);
        f.setOnClickListener(D);
        g.setOnClickListener(D);
        h.setOnClickListener(D);
        i.setOnClickListener(D);
        a(e, true);
        a(g, true);
        a(f, false);
        a(h, false);
        a(i, false);
        a(k, true);
        a(j, false);
    }

    static ImageButton h(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.f;
    }

    static ImageButton i(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.g;
    }

    static ImageButton j(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.h;
    }

    static ImageButton k(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.i;
    }

    static boolean l(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.m;
    }

    static int m(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.q;
    }

    static ImageButton n(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.k;
    }

    static ImageButton o(ProEditMosaicActivity proeditmosaicactivity)
    {
        return proeditmosaicactivity.j;
    }

    public Bitmap a(int i1)
    {
        Bitmap bitmap = Bitmap.createBitmap(50, 50, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(i1);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(4F);
        canvas.drawCircle(((float)50 - 1.0F) / 2.0F, ((float)50 - 1.0F) / 2.0F, Math.min(50, 50) / 2.0F, paint);
        return bitmap;
    }

    public void a()
    {
        try
        {
            if (w != null)
            {
                return;
            }
        }
        catch (Exception exception)
        {
            return;
        }
        w = ProcessDialogFragment.a(c());
        w.setCancelable(false);
        w.show(getSupportFragmentManager(), "process");
        return;
    }

    public void a(Bitmap bitmap)
    {
        runOnUiThread(new Runnable(bitmap) {

            final Bitmap a;
            final ProEditMosaicActivity b;

            public void run()
            {
                try
                {
                    if (a != null)
                    {
                        kf.b("mosaic");
                        b.a();
                        gm.c().a(new go(this) {

                            final _cls4 a;

                            public void a()
                            {
                                a.b.setResult(-1);
                                a.b.b();
                                a.b.finish();
                                a.b.overridePendingTransition(0, 0x7f040027);
                            }

            
            {
                a = _pcls4;
                super();
            }
                        }, a, b);
                    }
                    return;
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                b.b();
            }

            
            {
                b = ProEditMosaicActivity.this;
                a = bitmap;
                super();
            }
        });
    }

    public void a(String s1)
    {
        x = s1;
    }

    public void a(boolean flag, boolean flag1)
    {
        Log.e(b, (new StringBuilder()).append("canPre:").append(flag).append("canNext:").append(flag1).toString());
        runOnUiThread(new Runnable(flag, flag1) {

            final boolean a;
            final boolean b;
            final ProEditMosaicActivity c;

            public void run()
            {
                ProEditMosaicActivity.e(c).setEnabled(a);
                ProEditMosaicActivity.c(c).setEnabled(b);
            }

            
            {
                c = ProEditMosaicActivity.this;
                a = flag;
                b = flag1;
                super();
            }
        });
    }

    public void b()
    {
        try
        {
            if (w != null)
            {
                w.dismissAllowingStateLoss();
                a(getResources().getString(0x7f0601a4));
                w = null;
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public String c()
    {
        return x;
    }

    public void d()
    {
        n.saveImage();
    }

    public void e()
    {
        b();
        finish();
        overridePendingTransition(0, 0x7f040027);
    }

    public void onBackPressed()
    {
        b();
        finish();
        overridePendingTransition(0, 0x7f040027);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030026);
        d = (ProEidtActionBarView)findViewById(0x7f0c0088);
        A = (RelativeLayout)findViewById(0x7f0c0055);
        e = (ImageButton)findViewById(0x7f0c00b6);
        f = (ImageButton)findViewById(0x7f0c00b9);
        g = (ImageButton)findViewById(0x7f0c00ba);
        h = (ImageButton)findViewById(0x7f0c00bb);
        i = (ImageButton)findViewById(0x7f0c00bc);
        j = (ImageButton)findViewById(0x7f0c00b8);
        k = (ImageButton)findViewById(0x7f0c00b7);
        o = (FrameLayout)findViewById(0x7f0c0096);
        p = (MosaicIconScrollView)findViewById(0x7f0c00b5);
        v = (LinearLayout)findViewById(0x7f0c00b3);
        s = (ColorSelectView)findViewById(0x7f0c00b4);
        y = (ImageView)findViewById(0x7f0c00b2);
        y.setVisibility(4);
        z = (FrameLayout)findViewById(0x7f0c00bd);
        u = (ImageButton)findViewById(0x7f0c00b1);
        t = (ImageButton)findViewById(0x7f0c00b0);
        t.setOnClickListener(C);
        u.setOnClickListener(B);
        t.setEnabled(false);
        u.setEnabled(false);
        q = ew.a(this, 16F);
        g();
        f();
        a(getResources().getString(0x7f0601a4));
        if (m)
        {
            bundle = "mosaic_first_tip";
        } else
        {
            bundle = "paint_first_tip";
        }
        c = bundle;
        if (!la.a(this, c, true))
        {
            z.setVisibility(8);
        }
        z.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEditMosaicActivity a;

            public void onClick(View view)
            {
                ProEditMosaicActivity.a(a).setVisibility(8);
                la.b(a, ProEditMosaicActivity.b(a), false);
            }

            
            {
                a = ProEditMosaicActivity.this;
                super();
            }
        });
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onPause()
    {
        super.onPause();
        n.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        n.onResume();
        n.bringToFront();
        Log.v(b, (new StringBuilder()).append(b).append(" onResume").toString());
        if (!ew.n(this))
        {
            A.setVisibility(0);
            FotoAdFactory.createAdBanner(this, A);
            return;
        } else
        {
            A.setVisibility(8);
            android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)o.getLayoutParams();
            android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)t.getLayoutParams();
            android.widget.FrameLayout.LayoutParams layoutparams2 = (android.widget.FrameLayout.LayoutParams)u.getLayoutParams();
            layoutparams.topMargin = ew.a(this, 58F);
            layoutparams1.topMargin = ew.a(this, 60F);
            layoutparams2.topMargin = ew.a(this, 60F);
            o.setLayoutParams(layoutparams);
            t.setLayoutParams(layoutparams1);
            u.setLayoutParams(layoutparams2);
            return;
        }
    }

}
