// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.NewFilterContainer;
import com.wantu.imagerender.ImageGLSurfaceView;
import ig;
import iv;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import pt;
import sx;
import uv;
import vs;
import vt;
import vu;
import vv;
import vw;
import vy;
import wa;
import wb;
import wc;
import wd;
import wf;
import xb;
import yo;

public class MOneKeyFragment extends Fragment
    implements android.view.SurfaceHolder.Callback
{

    private static com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState p;
    private iv A;
    private android.view.View.OnClickListener B;
    private xb a;
    private ImageView b;
    private ImageView c;
    private NewFilterContainer d;
    private ImageView e;
    private ImageView f;
    private ImageGLSurfaceView g;
    private FrameLayout h;
    private Bitmap i;
    private ig j;
    private Button k;
    private Button l;
    private Button m;
    private Button n;
    private Button o;
    private FrameLayout q;
    private String r;
    private float s;
    private float t;
    private SoftenState u;
    private boolean v;
    private ExecutorService w;
    private android.view.View.OnClickListener x;
    private wf y;
    private boolean z;

    public MOneKeyFragment()
    {
        r = "";
        s = 0.7F;
        t = 0.3F;
        u = SoftenState.IsSel2;
        v = false;
        w = Executors.newSingleThreadExecutor();
        x = new vv(this);
        y = new wf(this, this);
        z = true;
        A = new wa(this);
        B = new wb(this);
    }

    public static float a(MOneKeyFragment monekeyfragment, float f1)
    {
        monekeyfragment.s = f1;
        return f1;
    }

    private Bitmap a(Bitmap bitmap)
    {
        Bitmap bitmap1 = i.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setAlpha((int)(d.getFilterValue() * 255F));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2.0F);
        if (bitmap != null)
        {
            canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        }
        return bitmap1;
    }

    public static Bitmap a(MOneKeyFragment monekeyfragment, Bitmap bitmap)
    {
        monekeyfragment.i = bitmap;
        return bitmap;
    }

    public static Fragment a(com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState maintoolstate, String s1, float f1, boolean flag)
    {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        MOneKeyFragment monekeyfragment;
        monekeyfragment = new MOneKeyFragment();
        p = maintoolstate;
        monekeyfragment.r = s1;
        f5 = (float)Math.round(f1 * 1000F) / 1000F;
        f1 = Math.abs(f5 - 0.1F) * 100F;
        f2 = Math.abs(f5 - 0.3F) * 100F;
        f3 = Math.abs(f5 - 0.55F) * 100F;
        f4 = Math.abs(f5 - 0.75F) * 100F;
        f5 = Math.abs(f5 - 0.9F) * 100F;
        f6 = Math.min(f1, Math.min(f2, Math.min(f3, Math.min(f4, f5))));
        if (f6 != f1) goto _L2; else goto _L1
_L1:
        monekeyfragment.u = SoftenState.IsSel1;
_L4:
        monekeyfragment.v = flag;
        return monekeyfragment;
_L2:
        if (f6 == f2)
        {
            monekeyfragment.u = SoftenState.IsSel2;
        } else
        if (f6 == f3)
        {
            monekeyfragment.u = SoftenState.IsSel3;
        } else
        if (f6 == f4)
        {
            monekeyfragment.u = SoftenState.IsSel4;
        } else
        if (f6 == f5)
        {
            monekeyfragment.u = SoftenState.IsSel5;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static ImageView a(MOneKeyFragment monekeyfragment)
    {
        return monekeyfragment.b;
    }

    public static SoftenState a(MOneKeyFragment monekeyfragment, SoftenState softenstate)
    {
        monekeyfragment.u = softenstate;
        return softenstate;
    }

    public static String a(MOneKeyFragment monekeyfragment, String s1)
    {
        monekeyfragment.r = s1;
        return s1;
    }

    private void a(Bitmap bitmap, String s1)
    {
        if (s1 != null && !s1.equals(""))
        {
            i();
            if (g != null && bitmap != null && s1 != null)
            {
                g.processImage(bitmap, s1, 1.0F, y);
            }
            return;
        } else
        {
            j();
            return;
        }
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
            translateanimation.setAnimationListener(new vu(this, flag, view));
            view.startAnimation(translateanimation);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
    }

    private void a(ImageView imageview, float f1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            imageview.setAlpha(f1);
            return;
        } else
        {
            imageview.setAlpha((int)(255F * f1));
            return;
        }
    }

    private void a(SoftenState softenstate)
    {
        k.setSelected(false);
        l.setSelected(false);
        m.setSelected(false);
        n.setSelected(false);
        o.setSelected(false);
        switch (vt.a[softenstate.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            k.setSelected(true);
            t = 0.1F;
            return;

        case 2: // '\002'
            l.setSelected(true);
            t = 0.3F;
            return;

        case 3: // '\003'
            m.setSelected(true);
            t = 0.55F;
            return;

        case 4: // '\004'
            n.setSelected(true);
            t = 0.75F;
            return;

        case 5: // '\005'
            o.setSelected(true);
            break;
        }
        t = 0.9F;
    }

    public static void a(MOneKeyFragment monekeyfragment, Bitmap bitmap, String s1)
    {
        monekeyfragment.a(bitmap, s1);
    }

    public static void a(MOneKeyFragment monekeyfragment, View view, int i1, int j1, long l1, boolean flag)
    {
        monekeyfragment.a(view, i1, j1, l1, flag);
    }

    public static void a(MOneKeyFragment monekeyfragment, ImageView imageview, float f1)
    {
        monekeyfragment.a(imageview, f1);
    }

    public static void b(MOneKeyFragment monekeyfragment, SoftenState softenstate)
    {
        monekeyfragment.a(softenstate);
    }

    public static boolean b(MOneKeyFragment monekeyfragment)
    {
        return monekeyfragment.v;
    }

    public static FrameLayout c(MOneKeyFragment monekeyfragment)
    {
        return monekeyfragment.q;
    }

    public static com.fotoable.beautyui.TBeautyAdjustScrollView.MainToolState c()
    {
        return p;
    }

    public static Bitmap d(MOneKeyFragment monekeyfragment)
    {
        return monekeyfragment.i;
    }

    private void d()
    {
        if (pt.b(pt.t, getActivity(), false))
        {
            j.a(true, 0.5F, 0.3F, 0.3F, 0.2F, 0.2F);
        } else
        {
            j.a(true, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        }
        e();
    }

    public static NewFilterContainer e(MOneKeyFragment monekeyfragment)
    {
        return monekeyfragment.d;
    }

    private void e()
    {
        j.a(t);
    }

    public static xb f(MOneKeyFragment monekeyfragment)
    {
        return monekeyfragment.a;
    }

    private void f()
    {
        i();
        w.execute(new vw(this));
    }

    public static SoftenState g(MOneKeyFragment monekeyfragment)
    {
        return monekeyfragment.u;
    }

    private void g()
    {
        i();
        w.execute(new vy(this));
    }

    private void h()
    {
        if (z)
        {
            z = false;
            Bitmap bitmap = yo.b(i, 90, 120);
            d.setPresetScrollImg(bitmap);
            d.setScrollImage(bitmap);
            d.setItemViewSelected(r);
            return;
        } else
        {
            d.needScrollView();
            return;
        }
    }

    public static void h(MOneKeyFragment monekeyfragment)
    {
        monekeyfragment.f();
    }

    private void i()
    {
        h.setVisibility(0);
    }

    public static void i(MOneKeyFragment monekeyfragment)
    {
        monekeyfragment.e();
    }

    public static ig j(MOneKeyFragment monekeyfragment)
    {
        return monekeyfragment.j;
    }

    private void j()
    {
        h.setVisibility(4);
    }

    public static ImageView k(MOneKeyFragment monekeyfragment)
    {
        return monekeyfragment.c;
    }

    private boolean k()
    {
        return h.getVisibility() == 0;
    }

    public static String l(MOneKeyFragment monekeyfragment)
    {
        return monekeyfragment.r;
    }

    private void l()
    {
        if (k())
        {
            return;
        } else
        {
            i();
            w.execute(new wc(this));
            return;
        }
    }

    private void m()
    {
        i();
        if (getActivity() != null)
        {
            Object obj = new HashMap();
            ((Map) (obj)).put("SoftenSel", u.toString());
            ((Map) (obj)).put("filterSel", r);
            sx.a("OneKeyNext", ((Map) (obj)));
            obj = ((BitmapDrawable)b.getDrawable()).getBitmap();
            if (obj != null)
            {
                obj = a(((Bitmap) (obj)));
                uv.c().a(((Bitmap) (obj)), new wd(this, ((Bitmap) (obj))));
                return;
            }
        }
    }

    public static void m(MOneKeyFragment monekeyfragment)
    {
        monekeyfragment.d();
    }

    public static void n(MOneKeyFragment monekeyfragment)
    {
        monekeyfragment.j();
    }

    public static void o(MOneKeyFragment monekeyfragment)
    {
        monekeyfragment.h();
    }

    public static float p(MOneKeyFragment monekeyfragment)
    {
        return monekeyfragment.s;
    }

    public static void q(MOneKeyFragment monekeyfragment)
    {
        monekeyfragment.l();
    }

    public static void r(MOneKeyFragment monekeyfragment)
    {
        monekeyfragment.m();
    }

    public void a()
    {
        g();
    }

    public void a(int i1, KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 4)
        {
            l();
        }
    }

    public void a(xb xb1)
    {
        a = xb1;
    }

    public void a(boolean flag)
    {
        d.setBtnFindState(flag);
    }

    public boolean b()
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            int i1;
            try
            {
                if (j == null)
                {
                    break label0;
                }
                i1 = j.a();
            }
            catch (Exception exception)
            {
                Crashlytics.logException(exception);
                exception.printStackTrace();
                return false;
            }
            flag = flag1;
            if (i1 > 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
label0:
        {
            layoutinflater = layoutinflater.inflate(0x7f03005f, viewgroup, false);
            layoutinflater.setClickable(true);
            q = (FrameLayout)layoutinflater.findViewById(0x7f0d00c9);
            d = (NewFilterContainer)layoutinflater.findViewById(0x7f0d00ca);
            f = (ImageView)layoutinflater.findViewById(0x7f0d0106);
            e = (ImageView)layoutinflater.findViewById(0x7f0d00cb);
            b = (ImageView)layoutinflater.findViewById(0x7f0d00c8);
            c = (ImageView)layoutinflater.findViewById(0x7f0d00c7);
            h = (FrameLayout)layoutinflater.findViewById(0x7f0d0060);
            k = (Button)layoutinflater.findViewById(0x7f0d020a);
            l = (Button)layoutinflater.findViewById(0x7f0d0209);
            m = (Button)layoutinflater.findViewById(0x7f0d0208);
            n = (Button)layoutinflater.findViewById(0x7f0d020b);
            o = (Button)layoutinflater.findViewById(0x7f0d020c);
            k.setOnClickListener(x);
            l.setOnClickListener(x);
            m.setOnClickListener(x);
            n.setOnClickListener(x);
            o.setOnClickListener(x);
            a(u);
            h.setVisibility(8);
            h.setClickable(true);
            b.setVisibility(0);
            c.setVisibility(0);
            if (a != null)
            {
                i = a.a();
                j = a.b();
                if (i == null)
                {
                    break label0;
                }
                b.setImageBitmap(i);
                c.setImageBitmap(i);
            }
            e.setOnClickListener(B);
            f.setOnClickListener(B);
            e.getBackground().setColorFilter(getResources().getColor(0x7f0c00a6), android.graphics.PorterDuff.Mode.SRC_IN);
            f.getBackground().setColorFilter(getResources().getColor(0x7f0c009d), android.graphics.PorterDuff.Mode.SRC_IN);
            d.setListener(A);
            d.setBtnFindState(true);
            b.getViewTreeObserver().addOnGlobalLayoutListener(new vs(this));
            g = (ImageGLSurfaceView)layoutinflater.findViewById(0x7f0d00ac);
            g.setVisibility(0);
            g.getHolder().addCallback(this);
            g();
            return layoutinflater;
        }
        a.a(p);
        return null;
    }

    public void onDestroy()
    {
        if (y != null)
        {
            y.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        try
        {
            if (g != null)
            {
                g.onPause();
            }
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            exception.printStackTrace();
            return;
        }
    }

    public void onResume()
    {
        super.onResume();
        try
        {
            if (g != null)
            {
                g.onResume();
            }
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            exception.printStackTrace();
            return;
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
    }

    private class SoftenState extends Enum
    {

        private static final SoftenState $VALUES[];
        public static final SoftenState IsSel1;
        public static final SoftenState IsSel2;
        public static final SoftenState IsSel3;
        public static final SoftenState IsSel4;
        public static final SoftenState IsSel5;

        public static SoftenState valueOf(String s1)
        {
            return (SoftenState)Enum.valueOf(com/fotoable/beautyui/newui/MOneKeyFragment$SoftenState, s1);
        }

        public static SoftenState[] values()
        {
            return (SoftenState[])$VALUES.clone();
        }

        static 
        {
            IsSel1 = new SoftenState("IsSel1", 0);
            IsSel2 = new SoftenState("IsSel2", 1);
            IsSel3 = new SoftenState("IsSel3", 2);
            IsSel4 = new SoftenState("IsSel4", 3);
            IsSel5 = new SoftenState("IsSel5", 4);
            $VALUES = (new SoftenState[] {
                IsSel1, IsSel2, IsSel3, IsSel4, IsSel5
            });
        }

        private SoftenState(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
