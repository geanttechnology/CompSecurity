// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.opengl.GLSurfaceView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.photo.gpu.g;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import com.socialin.picsin.camera.CameraMainActivity;
import com.socialin.picsin.camera.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import myobfuscated.de.b;

// Referenced classes of package com.socialin.camera.opengl:
//            o, c, ac, f, 
//            b, g, d, e, 
//            t, s, aa, v, 
//            y, z, x, i, 
//            j, w, ab, p, 
//            q, r, u, n, 
//            h, CameraOpenGlSurfaceView

public final class a
    implements o
{

    private static final HashMap J = new CameraOpenGlEffects._cls1();
    private com.socialin.camera.opengl.g A;
    private com.socialin.camera.opengl.d B;
    private y C;
    private i D;
    private j E;
    private com.socialin.camera.opengl.w F;
    private ab G;
    private u H;
    private HashMap I;
    public Activity a;
    public HashMap b;
    public int c;
    public String d;
    com.socialin.camera.opengl.b e;
    public e f;
    public t g;
    public s h;
    public aa i;
    public v j;
    z k;
    x l;
    p m;
    public q n;
    public r o;
    public n p;
    public LinearLayout q;
    public ArrayList r;
    public HashMap s;
    public int t;
    public int u;
    public boolean v;
    public LinkedHashMap w;
    public myobfuscated.db.a x;
    public h y;
    private f z;

    public a(Activity activity)
    {
        Object obj;
        d = "";
        t = -1;
        u = -1;
        v = false;
        y = null;
        a = activity;
        r = new ArrayList();
        s = new HashMap();
        w = new LinkedHashMap();
        w.put(Integer.valueOf(0), "Normal");
        w.put(Integer.valueOf(1), "Color splash");
        w.put(Integer.valueOf(2), "Graffit");
        w.put(Integer.valueOf(3), "Unsharpen");
        w.put(Integer.valueOf(4), "Masks");
        w.put(Integer.valueOf(5), "Light Cross");
        w.put(Integer.valueOf(7), "Hue");
        w.put(Integer.valueOf(8), "Swirl");
        w.put(Integer.valueOf(9), "Mirror");
        w.put(Integer.valueOf(10), "Poster");
        w.put(Integer.valueOf(11), "Sketcher");
        w.put(Integer.valueOf(12), "Pastel");
        w.put(Integer.valueOf(13), "Comic");
        w.put(Integer.valueOf(14), "Contours");
        w.put(Integer.valueOf(15), "Neon");
        w.put(Integer.valueOf(16), "Watercolor");
        w.put(Integer.valueOf(17), "Gouache");
        w.put(Integer.valueOf(18), "Holgaart1");
        w.put(Integer.valueOf(19), "Holgaart2");
        w.put(Integer.valueOf(20), "Lomo");
        w.put(Integer.valueOf(21), "Ghost");
        r.add(Integer.valueOf(0));
        r.add(Integer.valueOf(1));
        r.add(Integer.valueOf(5));
        r.add(Integer.valueOf(20));
        r.add(Integer.valueOf(10));
        r.add(Integer.valueOf(12));
        r.add(Integer.valueOf(13));
        r.add(Integer.valueOf(16));
        r.add(Integer.valueOf(14));
        r.add(Integer.valueOf(11));
        r.add(Integer.valueOf(2));
        r.add(Integer.valueOf(15));
        r.add(Integer.valueOf(17));
        r.add(Integer.valueOf(18));
        r.add(Integer.valueOf(19));
        r.add(Integer.valueOf(8));
        r.add(Integer.valueOf(9));
        r.add(Integer.valueOf(7));
        r.add(Integer.valueOf(3));
        r.add(Integer.valueOf(21));
        s.put(Integer.valueOf(0), Integer.valueOf(0x7f0200ea));
        s.put(Integer.valueOf(1), Integer.valueOf(0x7f0200e8));
        s.put(Integer.valueOf(2), Integer.valueOf(0x7f0201e5));
        s.put(Integer.valueOf(3), Integer.valueOf(0x7f0201f4));
        s.put(Integer.valueOf(5), Integer.valueOf(0x7f0201ea));
        s.put(Integer.valueOf(7), Integer.valueOf(0x7f0201e9));
        s.put(Integer.valueOf(8), Integer.valueOf(0x7f0201f2));
        s.put(Integer.valueOf(9), Integer.valueOf(0x7f0201ec));
        s.put(Integer.valueOf(10), Integer.valueOf(0x7f0201f0));
        s.put(Integer.valueOf(11), Integer.valueOf(0x7f0201f1));
        s.put(Integer.valueOf(12), Integer.valueOf(0x7f0201ef));
        s.put(Integer.valueOf(13), Integer.valueOf(0x7f0201d8));
        s.put(Integer.valueOf(14), Integer.valueOf(0x7f0201d9));
        s.put(Integer.valueOf(15), Integer.valueOf(0x7f0201ed));
        s.put(Integer.valueOf(16), Integer.valueOf(0x7f0201f5));
        s.put(Integer.valueOf(17), Integer.valueOf(0x7f0201e6));
        s.put(Integer.valueOf(18), Integer.valueOf(0x7f0201e7));
        s.put(Integer.valueOf(19), Integer.valueOf(0x7f0201e8));
        s.put(Integer.valueOf(20), Integer.valueOf(0x7f0201eb));
        s.put(Integer.valueOf(21), Integer.valueOf(0x7f0200e9));
        I = new HashMap();
        I.put(Integer.valueOf(0), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/orig_image.fs"));
        I.put(Integer.valueOf(1), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/color_splash.fs"));
        I.put(Integer.valueOf(2), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/grafit.fs"));
        I.put(Integer.valueOf(3), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/unshurpen.fs"));
        I.put(Integer.valueOf(4), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/masks.fs"));
        I.put(Integer.valueOf(5), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/light_cross.fs"));
        I.put(Integer.valueOf(7), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/hue.fs"));
        I.put(Integer.valueOf(8), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/swirl.fs"));
        I.put(Integer.valueOf(9), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/mirror.fs"));
        I.put(Integer.valueOf(10), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/poster.fs"));
        I.put(Integer.valueOf(11), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/sketcher.fs"));
        I.put(Integer.valueOf(12), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/pastel.fs"));
        I.put(Integer.valueOf(13), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/comic.fs"));
        I.put(Integer.valueOf(14), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/contours.fs"));
        I.put(Integer.valueOf(15), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/neon.fs"));
        I.put(Integer.valueOf(16), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/watercolor.fs"));
        I.put(Integer.valueOf(17), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/gouache.fs"));
        I.put(Integer.valueOf(18), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/holgaart1.fs"));
        I.put(Integer.valueOf(19), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/holgaart2.fs"));
        I.put(Integer.valueOf(20), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/lomo.fs"));
        I.put(Integer.valueOf(21), new com.socialin.camera.opengl.c("shaders/preview.vs", "shaders/ghost.fs"));
        b = new HashMap();
        int i1 = 0;
        while (i1 < r.size()) 
        {
            int j1 = ((Integer)r.get(i1)).intValue();
            if (I.containsKey(Integer.valueOf(j1)))
            {
                activity = (com.socialin.camera.opengl.c)I.get(Integer.valueOf(j1));
                activity = new ac(((com.socialin.camera.opengl.c) (activity)).a, ((com.socialin.camera.opengl.c) (activity)).b);
            } else
            {
                activity = new ac();
            }
            b.put(Integer.valueOf(j1), activity);
            i1++;
        }
        activity = (com.socialin.camera.opengl.c)I.get(Integer.valueOf(4));
        activity = new ac(((com.socialin.camera.opengl.c) (activity)).a, ((com.socialin.camera.opengl.c) (activity)).b);
        b.put(Integer.valueOf(4), activity);
        c = 0;
        q = null;
        z = new f();
        obj = a.getString(0x7f0801d8);
        activity = a.getString(0x7f0801d6);
        e = new com.socialin.camera.opengl.b(this);
        LinearLayout linearlayout = (LinearLayout)a.getLayoutInflater().inflate(0x7f030073, null);
        Object obj1 = (TextView)linearlayout.findViewById(0x7f1002c0);
        ((TextView) (obj1)).setText((new StringBuilder()).append(((String) (obj))).append(" : 30").toString());
        SeekBar seekbar = (SeekBar)linearlayout.findViewById(0x7f1002c1);
        seekbar.setMax(100);
        seekbar.setProgress(30);
        seekbar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(((TextView) (obj1)), ((String) (obj))) {

            private TextView a;
            private String b;
            private a c;

            public final void onProgressChanged(SeekBar seekbar1, int k1, boolean flag)
            {
                a.setText((new StringBuilder()).append(b).append(" : ").append(k1).toString());
                a.m(c).a(k1);
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar1.getProgress()).toString());
                a.m(c).a(seekbar1.getProgress());
            }

            
            {
                c = a.this;
                a = textview;
                b = s1;
                super();
            }
        });
        obj = (TextView)linearlayout.findViewById(0x7f1002c2);
        ((TextView) (obj)).setText((new StringBuilder()).append(activity).append(" : 30").toString());
        obj1 = (SeekBar)linearlayout.findViewById(0x7f1002c3);
        ((SeekBar) (obj1)).setMax(100);
        ((SeekBar) (obj1)).setProgress(30);
        ((SeekBar) (obj1)).setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(((TextView) (obj)), activity) {

            private TextView a;
            private String b;
            private a c;

            public final void onProgressChanged(SeekBar seekbar1, int k1, boolean flag)
            {
                a.setText((new StringBuilder()).append(b).append(" : ").append(k1).toString());
                a.m(c).b(k1);
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar1.getProgress()).toString());
                a.m(c).b(seekbar1.getProgress());
            }

            
            {
                c = a.this;
                a = textview;
                b = s1;
                super();
            }
        });
        linearlayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        e.c = linearlayout;
        linearlayout.findViewById(0x7f1002bf).setOnClickListener(new android.view.View.OnClickListener() {

            private a a;

            public final void onClick(View view)
            {
                a.a(0, true, true, true);
            }

            
            {
                a = a.this;
                super();
            }
        });
        A = new com.socialin.camera.opengl.g(this, ((ac)b.get(Integer.valueOf(3))).b);
        obj = (LinearLayout)a.getLayoutInflater().inflate(0x7f0300e1, null);
        A.d = ((LinearLayout) (obj));
        A.a;
        JVM INSTR tableswitch 0 1: default 2028
    //                   0 2849
    //                   1 2866;
           goto _L1 _L2 _L3
_L1:
        ((RadioGroup)((LinearLayout) (obj)).findViewById(0x7f1004a4)).setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            private a a;

            public final void onCheckedChanged(RadioGroup radiogroup, int k1)
            {
                if (k1 == 0x7f1004a5)
                {
                    a.n(a).a(0, true);
                    return;
                } else
                {
                    a.n(a).a(1, true);
                    return;
                }
            }

            
            {
                a = a.this;
                super();
            }
        });
        activity = a.getString(0x7f0801bc);
        TextView textview = (TextView)((LinearLayout) (obj)).findViewById(0x7f1004a7);
        textview.setText((new StringBuilder()).append(activity).append(" : ").append(A.b).toString());
        obj = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f1004a8);
        ((SeekBar) (obj)).setMax(100);
        ((SeekBar) (obj)).setProgress((int)A.b);
        ((SeekBar) (obj)).setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(textview, activity) {

            private TextView a;
            private String b;
            private a c;

            public final void onProgressChanged(SeekBar seekbar1, int k1, boolean flag)
            {
                a.setText((new StringBuilder()).append(b).append(" : ").append(k1).toString());
                a.n(c).a(k1, true);
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar1.getProgress()).toString());
                a.n(c).a(seekbar1.getProgress(), true);
            }

            
            {
                c = a.this;
                a = textview;
                b = s1;
                super();
            }
        });
        B = new com.socialin.camera.opengl.d(this, ((ac)b.get(Integer.valueOf(2))).b);
        obj = (LinearLayout)a.getLayoutInflater().inflate(0x7f0300c4, null);
        B.b = ((LinearLayout) (obj));
        activity = a.getString(0x7f0801bc);
        textview = (TextView)((LinearLayout) (obj)).findViewById(0x7f100400);
        textview.setText((new StringBuilder()).append(activity).append(" : ").append(B.c).toString());
        obj = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100401);
        ((SeekBar) (obj)).setMax(100);
        ((SeekBar) (obj)).setProgress((int)B.c);
        ((SeekBar) (obj)).setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(textview, activity) {

            private TextView a;
            private String b;
            private a c;

            public final void onProgressChanged(SeekBar seekbar1, int k1, boolean flag)
            {
                a.setText((new StringBuilder()).append(b).append(" : ").append(k1).toString());
                a.o(c).a(k1, true);
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                a.setText((new StringBuilder()).append(b).append(" : ").append(seekbar1.getProgress()).toString());
                a.o(c).a(seekbar1.getProgress(), true);
            }

            
            {
                c = a.this;
                a = textview;
                b = s1;
                super();
            }
        });
        f = new e(this, ((ac)b.get(Integer.valueOf(4))).b);
        g = new t(((ac)b.get(Integer.valueOf(5))).b);
        h = new s(((ac)b.get(Integer.valueOf(7))).b);
        i = new aa(((ac)b.get(Integer.valueOf(8))).b);
        j = new v(((ac)b.get(Integer.valueOf(9))).b);
        activity = ((ac)b.get(Integer.valueOf(10))).b;
        C = new y(a, activity);
        k = new z(((ac)b.get(Integer.valueOf(11))).b);
        l = new x(((ac)b.get(Integer.valueOf(12))).b);
        D = new i(((ac)b.get(Integer.valueOf(13))).b);
        E = new j(((ac)b.get(Integer.valueOf(14))).b);
        F = new com.socialin.camera.opengl.w(((ac)b.get(Integer.valueOf(15))).b);
        G = new ab(((ac)b.get(Integer.valueOf(16))).b);
        m = new p(((ac)b.get(Integer.valueOf(17))).b);
        n = new q(((ac)b.get(Integer.valueOf(18))).b);
        o = new r(((ac)b.get(Integer.valueOf(19))).b);
        H = new u(((ac)b.get(Integer.valueOf(20))).b);
        p = new n(((ac)b.get(Integer.valueOf(21))).b);
        p.e = this;
        activity = ((ac)b.get(Integer.valueOf(1))).b;
        e.b = activity;
        e.a(0xff0000ff, 240F, false);
        return;
_L2:
        ((RadioButton)((LinearLayout) (obj)).findViewById(0x7f1004a5)).setChecked(true);
        continue; /* Loop/switch isn't completed */
_L3:
        ((RadioButton)((LinearLayout) (obj)).findViewById(0x7f1004a6)).setChecked(false);
        if (true) goto _L1; else goto _L4
_L4:
    }

    static u A(a a1)
    {
        return a1.H;
    }

    static int B(a a1)
    {
        return a1.t;
    }

    static HashMap C(a a1)
    {
        return a1.b;
    }

    public static int a(com.socialin.camera.masks.a a1)
    {
        switch (a1.h)
        {
        default:
            return 0;

        case -1: 
            Log.e("ex", "MODE_NORMAL");
            return 1;

        case 0: // '\0'
            Log.e("ex", "MODE_SCREEN");
            return 2;

        case 2: // '\002'
            Log.e("ex", "MODE_OVERLAY");
            return 3;

        case 1: // '\001'
            return 4;
        }
    }

    static int a(a a1)
    {
        return a1.c;
    }

    static int a(a a1, int i1)
    {
        a1.c = i1;
        return i1;
    }

    public static String a(Context context, int i1)
    {
        return context.getString(((Integer)J.get(Integer.valueOf(i1))).intValue());
    }

    public static boolean a(Activity activity)
    {
        return ((ActivityManager)activity.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 0x20000;
    }

    static String b(a a1)
    {
        return a1.d;
    }

    static Activity c(a a1)
    {
        return a1.a;
    }

    static z d(a a1)
    {
        return a1.k;
    }

    static g e()
    {
        return null;
    }

    static boolean e(a a1)
    {
        a1.v = true;
        return true;
    }

    static x f(a a1)
    {
        return a1.l;
    }

    static p g(a a1)
    {
        return a1.m;
    }

    static q h(a a1)
    {
        return a1.n;
    }

    static n i(a a1)
    {
        return a1.p;
    }

    static LinearLayout j(a a1)
    {
        return a1.q;
    }

    static myobfuscated.db.a k(a a1)
    {
        return a1.x;
    }

    static f l(a a1)
    {
        return a1.z;
    }

    static com.socialin.camera.opengl.b m(a a1)
    {
        return a1.e;
    }

    static com.socialin.camera.opengl.g n(a a1)
    {
        return a1.A;
    }

    static com.socialin.camera.opengl.d o(a a1)
    {
        return a1.B;
    }

    static e p(a a1)
    {
        return a1.f;
    }

    static t q(a a1)
    {
        return a1.g;
    }

    static s r(a a1)
    {
        return a1.h;
    }

    static aa s(a a1)
    {
        return a1.i;
    }

    static v t(a a1)
    {
        return a1.j;
    }

    static y u(a a1)
    {
        return a1.C;
    }

    static i v(a a1)
    {
        return a1.D;
    }

    static j w(a a1)
    {
        return a1.E;
    }

    static com.socialin.camera.opengl.w x(a a1)
    {
        return a1.F;
    }

    static ab y(a a1)
    {
        return a1.G;
    }

    static r z(a a1)
    {
        return a1.o;
    }

    public final int a()
    {
        return ((ac)b.get(Integer.valueOf(c))).a;
    }

    public final void a(int i1, boolean flag, boolean flag1, boolean flag2)
    {
        a(i1, flag, flag1, flag2, false);
    }

    public final void a(int i1, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        if (a == null || ((CameraMainActivity)a).h == null)
        {
            return;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        ((CameraMainActivity)a).h.queueEvent(new Runnable(i1, flag3, flag2) {

            private int a;
            private boolean b;
            private boolean c;
            private a d;

            public final void run()
            {
                a.a(d, a);
                if (b)
                {
                    AnalyticUtils analyticutils = AnalyticUtils.getInstance(com.socialin.camera.opengl.a.c(d));
                    com.socialin.android.apiv3.events.EventsFactory.CameraActionEvent cameraactionevent = new com.socialin.android.apiv3.events.EventsFactory.CameraActionEvent(com.socialin.camera.opengl.a.b(d), "effect_try");
                    String s1;
                    if (d.w.get(Integer.valueOf(a.a(d))) != null)
                    {
                        s1 = ((String)d.w.get(Integer.valueOf(a.a(d)))).toLowerCase();
                    } else
                    {
                        s1 = null;
                    }
                    analyticutils.track(cameraactionevent.setEffectName(s1));
                }
                a.a(d);
                JVM INSTR tableswitch 11 18: default 160
            //                           11 193
            //                           12 214
            //                           13 160
            //                           14 160
            //                           15 160
            //                           16 160
            //                           17 235
            //                           18 256;
                   goto _L1 _L2 _L3 _L1 _L1 _L1 _L1 _L4 _L5
_L1:
                if (c && a.i(d) != null)
                {
                    a.i(d).b();
                }
                return;
_L2:
                if (com.socialin.camera.opengl.a.d(d) != null)
                {
                    a.e(d);
                }
                continue; /* Loop/switch isn't completed */
_L3:
                if (a.f(d) != null)
                {
                    a.e(d);
                }
                continue; /* Loop/switch isn't completed */
_L4:
                if (com.socialin.camera.opengl.a.g(d) != null)
                {
                    a.e(d);
                }
                continue; /* Loop/switch isn't completed */
_L5:
                if (a.h(d) != null)
                {
                    a.e(d);
                }
                if (true) goto _L1; else goto _L6
_L6:
            }

            
            {
                d = a.this;
                a = i1;
                b = flag;
                c = flag1;
                super();
            }
        });
_L4:
        a.runOnUiThread(new Runnable(flag2, i1, flag1) {

            final a a;
            private boolean b;
            private int c;
            private boolean d;

            public final void run()
            {
                boolean flag4;
                if (a.j(a) != null)
                {
                    a.j(a).removeAllViews();
                }
                flag4 = true;
                if (a.i(a) != null && b)
                {
                    a.i(a).c();
                }
                c;
                JVM INSTR tableswitch 0 21: default 156
            //                           0 235
            //                           1 291
            //                           2 552
            //                           3 423
            //                           4 676
            //                           5 721
            //                           6 1149
            //                           7 1226
            //                           8 1640
            //                           9 1982
            //                           10 2163
            //                           11 2576
            //                           12 2993
            //                           13 3410
            //                           14 3829
            //                           15 4357
            //                           16 4885
            //                           17 5413
            //                           18 5943
            //                           19 6366
            //                           20 6788
            //                           21 6875;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23
_L1:
                int j1 = ((flag4) ? 1 : 0);
_L28:
                if (j1 != 0)
                {
                    CameraMainActivity cameramainactivity = (CameraMainActivity)com.socialin.camera.opengl.a.c(a);
                    RelativeLayout relativelayout = (RelativeLayout)cameramainactivity.findViewById(0x7f1001f6);
                    View view = relativelayout.findViewWithTag("COLOR_SPLASH_FOREGROUND_VIEW_TAG");
                    if (view != null)
                    {
                        relativelayout.removeView(view);
                    }
                    if (cameramainactivity.g != null && cameramainactivity.h != null)
                    {
                        cameramainactivity.h.queueEvent(new com.socialin.picsin.camera.CameraMainActivity._cls19(cameramainactivity));
                    }
                }
                return;
_L2:
                float f1;
                Object obj;
                Object obj1;
                Object obj2;
                Object obj3;
                Object obj4;
                SeekBar seekbar;
                boolean flag5;
                if (d)
                {
                    ((CameraMainActivity)com.socialin.camera.opengl.a.c(a)).e();
                    j1 = 0;
                } else
                {
                    j1 = 1;
                }
                if (a.k(a) != null)
                {
                    a.k(a).c(false);
                }
                a.l(a);
                continue; /* Loop/switch isn't completed */
_L3:
                a.j(a).setVisibility(0);
                obj = a.m(a).c;
                if (obj != null)
                {
                    f1 = a.m(a).a;
                    j1 = a.m(a).d;
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 1;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    a.m(a).a(j1, f1, true);
                }
                if (a.k(a) != null)
                {
                    a.k(a).c(true);
                    a.k(a).b();
                    j1 = 0;
                } else
                {
                    j1 = 0;
                }
                continue; /* Loop/switch isn't completed */
_L5:
                a.j(a).setVisibility(0);
                obj = a.n(a).d;
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 1;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                    if (b)
                    {
                        obj = a.n(a);
                        ((com.socialin.camera.opengl.g) (obj)).a(0.0F, false);
                        ((com.socialin.camera.opengl.g) (obj)).a(0, false);
                        j1 = ((flag4) ? 1 : 0);
                        if (((com.socialin.camera.opengl.g) (obj)).d != null)
                        {
                            com.socialin.camera.opengl.a.c(((com.socialin.camera.opengl.g) (obj)).e).runOnUiThread(new g._cls3(((com.socialin.camera.opengl.g) (obj))));
                            j1 = ((flag4) ? 1 : 0);
                        }
                    }
                }
                continue; /* Loop/switch isn't completed */
_L4:
                a.j(a).setVisibility(0);
                obj = a.o(a).b;
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 16;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                    if (b)
                    {
                        obj = a.o(a);
                        ((com.socialin.camera.opengl.d) (obj)).a(0.0F, false);
                        j1 = ((flag4) ? 1 : 0);
                        if (((com.socialin.camera.opengl.d) (obj)).b != null)
                        {
                            com.socialin.camera.opengl.a.c(((com.socialin.camera.opengl.d) (obj)).d).runOnUiThread(new d._cls2(((com.socialin.camera.opengl.d) (obj))));
                            j1 = ((flag4) ? 1 : 0);
                        }
                    }
                }
                continue; /* Loop/switch isn't completed */
_L6:
                j1 = ((flag4) ? 1 : 0);
                if (a.p(a) != null)
                {
                    ((CameraMainActivity)com.socialin.camera.opengl.a.c(a)).c().queueEvent(new Runnable(this) {

                        private _cls5 a;

                        public final void run()
                        {
                            a.p(a.a).a(0);
                            a.p(a.a).f = null;
                            a.p(a.a).g = null;
                        }

            
            {
                a = _pcls5;
                super();
            }
                    });
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L7:
                a.j(a).setVisibility(0);
                obj = a.q(a);
                obj2 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj1 = a.j(a);
                obj1 = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, ((android.view.ViewGroup) (obj1)), false);
                if (flag5)
                {
                    ((t) (obj)).a(0.0F);
                    ((t) (obj)).b(50F);
                    ((t) (obj)).c(50F);
                }
                obj3 = ((Activity) (obj2)).getString(0x7f0801bc);
                obj4 = (TextView)((LinearLayout) (obj1)).findViewById(0x7f10023a);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((t) (obj)).a()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj1)).findViewById(0x7f10023b);
                seekbar.setMax(100);
                seekbar.setProgress((int)((t) (obj)).a());
                seekbar.setOnSeekBarChangeListener(new t._cls1(((t) (obj)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801b8);
                obj4 = (TextView)((LinearLayout) (obj1)).findViewById(0x7f100236);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((t) (obj)).c()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj1)).findViewById(0x7f100237);
                seekbar.setMax(100);
                seekbar.setProgress((int)((t) (obj)).c());
                seekbar.setOnSeekBarChangeListener(new t._cls2(((t) (obj)), ((TextView) (obj4)), ((String) (obj3))));
                obj2 = ((Activity) (obj2)).getString(0x7f080061);
                obj3 = (TextView)((LinearLayout) (obj1)).findViewById(0x7f100238);
                ((TextView) (obj3)).setText((new StringBuilder()).append(((String) (obj2))).append(" : ").append((int)((t) (obj)).b()).toString());
                obj4 = (SeekBar)((LinearLayout) (obj1)).findViewById(0x7f100239);
                ((SeekBar) (obj4)).setMax(100);
                ((SeekBar) (obj4)).setProgress((int)((t) (obj)).b());
                ((SeekBar) (obj4)).setOnSeekBarChangeListener(new t._cls3(((t) (obj)), ((TextView) (obj3)), ((String) (obj2))));
                j1 = ((flag4) ? 1 : 0);
                if (obj1 != null)
                {
                    obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj.gravity = 1;
                    ((View) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                    a.j(a).addView(((View) (obj1)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L8:
                a.j(a).setVisibility(0);
                obj = a.e().a(com.socialin.camera.opengl.a.c(a), b);
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 16;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L9:
                a.j(a).setVisibility(0);
                obj1 = a.r(a);
                obj2 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
                if (flag5)
                {
                    ((s) (obj1)).d();
                }
                obj3 = ((Activity) (obj2)).getString(0x7f0801bc);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023a);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((s) (obj1)).a()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023b);
                seekbar.setMax(100);
                seekbar.setProgress((int)((s) (obj1)).a());
                seekbar.setOnSeekBarChangeListener(new s._cls1(((s) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f080389);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100236);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((s) (obj1)).b()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100237);
                seekbar.setMax(360);
                seekbar.setProgress((int)((s) (obj1)).b());
                seekbar.setOnSeekBarChangeListener(new s._cls2(((s) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj2 = ((Activity) (obj2)).getString(0x7f0801e8);
                obj3 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100238);
                ((TextView) (obj3)).setText((new StringBuilder()).append(((String) (obj2))).append(" : ").append((int)(((s) (obj1)).c() + 50F)).toString());
                obj4 = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100239);
                ((SeekBar) (obj4)).setMax(100);
                ((SeekBar) (obj4)).setProgress((int)(((s) (obj1)).c() + 50F));
                ((SeekBar) (obj4)).setOnSeekBarChangeListener(new s._cls3(((s) (obj1)), ((TextView) (obj3)), ((String) (obj2))));
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 16;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L10:
                a.j(a).setVisibility(0);
                obj1 = a.s(a);
                obj2 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
                if (flag5)
                {
                    ((aa) (obj1)).c();
                }
                ((TextView)((LinearLayout) (obj)).findViewById(0x7f10023a)).setVisibility(8);
                ((SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023b)).setVisibility(8);
                obj3 = ((Activity) (obj2)).getString(0x7f0801e2);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100236);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((aa) (obj1)).a()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100237);
                seekbar.setMax(100);
                seekbar.setProgress((int)((aa) (obj1)).a());
                seekbar.setOnSeekBarChangeListener(new aa._cls1(((aa) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj2 = ((Activity) (obj2)).getString(0x7f0801a3);
                obj3 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100238);
                ((TextView) (obj3)).setText((new StringBuilder()).append(((String) (obj2))).append(" : ").append((int)((aa) (obj1)).b()).toString());
                obj4 = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100239);
                ((SeekBar) (obj4)).setMax(360);
                ((SeekBar) (obj4)).setProgress((int)(((aa) (obj1)).b() + 180F));
                ((SeekBar) (obj4)).setOnSeekBarChangeListener(new aa._cls2(((aa) (obj1)), ((TextView) (obj3)), ((String) (obj2))));
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 16;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L11:
                a.j(a).setVisibility(0);
                obj = a.t(a);
                obj1 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj1 = (LinearLayout)((Activity) (obj1)).getLayoutInflater().inflate(0x7f030050, null);
                if (flag5)
                {
                    ((v) (obj)).a(0);
                }
                obj2 = (RadioGroup)((LinearLayout) (obj1)).findViewById(0x7f10024f);
                ((v) (obj)).a;
                JVM INSTR tableswitch 0 1: default 2080
            //                           0 2141
            //                           1 2152;
                   goto _L24 _L25 _L26
_L24:
                ((RadioGroup) (obj2)).setOnCheckedChangeListener(new v._cls1(((v) (obj))));
                j1 = ((flag4) ? 1 : 0);
                if (obj1 != null)
                {
                    obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj.gravity = 16;
                    ((View) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                    a.j(a).addView(((View) (obj1)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L25:
                ((RadioGroup) (obj2)).check(0x7f100250);
                continue; /* Loop/switch isn't completed */
_L26:
                ((RadioGroup) (obj2)).check(0x7f100251);
                if (true) goto _L24; else goto _L12
_L12:
                a.j(a).setVisibility(0);
                obj1 = a.u(a);
                obj2 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
                if (flag5)
                {
                    ((y) (obj1)).a(true);
                }
                obj3 = ((Activity) (obj2)).getString(0x7f0801c9);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023a);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((y) (obj1)).c()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023b);
                seekbar.setMax(95);
                seekbar.setProgress((int)((y) (obj1)).c() - 5);
                seekbar.setOnSeekBarChangeListener(new y._cls4(((y) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801b7);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100236);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((y) (obj1)).a()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100237);
                seekbar.setMax(95);
                seekbar.setProgress((int)((y) (obj1)).a());
                seekbar.setOnSeekBarChangeListener(new y._cls5(((y) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj2 = ((Activity) (obj2)).getString(0x7f0801e8);
                obj3 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100238);
                ((TextView) (obj3)).setText((new StringBuilder()).append(((String) (obj2))).append(" : ").append((int)((y) (obj1)).b()).toString());
                obj4 = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100239);
                ((SeekBar) (obj4)).setMax(95);
                ((SeekBar) (obj4)).setProgress((int)((y) (obj1)).b() - 5);
                ((SeekBar) (obj4)).setOnSeekBarChangeListener(new y._cls6(((y) (obj1)), ((TextView) (obj3)), ((String) (obj2))));
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 16;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L13:
                a.j(a).setVisibility(0);
                obj1 = com.socialin.camera.opengl.a.d(a);
                obj2 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
                if (flag5)
                {
                    ((z) (obj1)).a(0.0F);
                    ((z) (obj1)).b(50F);
                    ((z) (obj1)).c(50F);
                }
                obj3 = ((Activity) (obj2)).getString(0x7f0801bc);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023a);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append(((z) (obj1)).a()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023b);
                seekbar.setMax(100);
                seekbar.setProgress((int)((z) (obj1)).a());
                seekbar.setOnSeekBarChangeListener(new z._cls1(((z) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801b8);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100236);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append(((z) (obj1)).c()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100237);
                seekbar.setMax(100);
                seekbar.setProgress((int)((z) (obj1)).c());
                seekbar.setOnSeekBarChangeListener(new z._cls2(((z) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj2 = ((Activity) (obj2)).getString(0x7f0801b1);
                obj3 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100238);
                ((TextView) (obj3)).setText((new StringBuilder()).append(((String) (obj2))).append(" : ").append(((z) (obj1)).b()).toString());
                obj4 = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100239);
                ((SeekBar) (obj4)).setMax(100);
                ((SeekBar) (obj4)).setProgress((int)((z) (obj1)).b());
                ((SeekBar) (obj4)).setOnSeekBarChangeListener(new z._cls3(((z) (obj1)), ((TextView) (obj3)), ((String) (obj2))));
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 16;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L14:
                a.j(a).setVisibility(0);
                obj1 = a.f(a);
                obj2 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
                if (flag5)
                {
                    ((x) (obj1)).a(0.0F);
                    ((x) (obj1)).b(50F);
                    ((x) (obj1)).c(50F);
                }
                obj3 = ((Activity) (obj2)).getString(0x7f0801bc);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023a);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append(((x) (obj1)).a()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023b);
                seekbar.setMax(100);
                seekbar.setProgress((int)((x) (obj1)).a());
                seekbar.setOnSeekBarChangeListener(new x._cls1(((x) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801b8);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100236);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append(((x) (obj1)).c()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100237);
                seekbar.setMax(100);
                seekbar.setProgress((int)((x) (obj1)).c());
                seekbar.setOnSeekBarChangeListener(new x._cls2(((x) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj2 = ((Activity) (obj2)).getString(0x7f0801b1);
                obj3 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100238);
                ((TextView) (obj3)).setText((new StringBuilder()).append(((String) (obj2))).append(" : ").append(((x) (obj1)).b()).toString());
                obj4 = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100239);
                ((SeekBar) (obj4)).setMax(100);
                ((SeekBar) (obj4)).setProgress((int)((x) (obj1)).b());
                ((SeekBar) (obj4)).setOnSeekBarChangeListener(new x._cls3(((x) (obj1)), ((TextView) (obj3)), ((String) (obj2))));
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 16;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L15:
                a.j(a).setVisibility(0);
                obj1 = a.v(a);
                obj2 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
                if (flag5)
                {
                    ((i) (obj1)).a(0.0F);
                    ((i) (obj1)).b(80F);
                    ((i) (obj1)).c(80F);
                }
                obj3 = ((Activity) (obj2)).getString(0x7f0801bc);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023a);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append(((i) (obj1)).a()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023b);
                seekbar.setMax(100);
                seekbar.setProgress((int)((i) (obj1)).a());
                seekbar.setOnSeekBarChangeListener(new i._cls1(((i) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801ca);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100236);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append(((i) (obj1)).c()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100237);
                seekbar.setMax(100);
                seekbar.setProgress((int)((i) (obj1)).c());
                seekbar.setOnSeekBarChangeListener(new i._cls2(((i) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj2 = ((Activity) (obj2)).getString(0x7f0801b1);
                obj3 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100238);
                ((TextView) (obj3)).setText((new StringBuilder()).append(((String) (obj2))).append(" : ").append(((i) (obj1)).b()).toString());
                obj4 = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100239);
                ((SeekBar) (obj4)).setMax(100);
                ((SeekBar) (obj4)).setProgress((int)((i) (obj1)).b());
                ((SeekBar) (obj4)).setOnSeekBarChangeListener(new i._cls3(((i) (obj1)), ((TextView) (obj3)), ((String) (obj2))));
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 16;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L16:
                a.j(a).setVisibility(0);
                obj1 = com.socialin.camera.opengl.a.w(a);
                obj2 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f03004d, null);
                if (flag5)
                {
                    ((j) (obj1)).a(0.0F);
                    ((j) (obj1)).b(50F);
                    ((j) (obj1)).c(50F);
                    ((j) (obj1)).d(50F);
                }
                obj3 = ((Activity) (obj2)).getString(0x7f0801b8);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023a);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((j) (obj1)).d()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023b);
                seekbar.setMax(100);
                seekbar.setProgress((int)((j) (obj1)).d());
                seekbar.setOnSeekBarChangeListener(new j._cls1(((j) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801bc);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023c);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((j) (obj1)).a()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023d);
                seekbar.setMax(100);
                seekbar.setProgress((int)((j) (obj1)).a());
                seekbar.setOnSeekBarChangeListener(new j._cls2(((j) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801ca);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100236);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((j) (obj1)).c()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100237);
                seekbar.setMax(100);
                seekbar.setProgress((int)((j) (obj1)).c());
                seekbar.setOnSeekBarChangeListener(new j._cls3(((j) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj2 = ((Activity) (obj2)).getString(0x7f0801b1);
                obj3 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100238);
                ((TextView) (obj3)).setText((new StringBuilder()).append(((String) (obj2))).append(" : ").append((int)((j) (obj1)).b()).toString());
                obj4 = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100239);
                ((SeekBar) (obj4)).setMax(100);
                ((SeekBar) (obj4)).setProgress((int)((j) (obj1)).b());
                ((SeekBar) (obj4)).setOnSeekBarChangeListener(new j._cls4(((j) (obj1)), ((TextView) (obj3)), ((String) (obj2))));
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 16;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L17:
                a.j(a).setVisibility(0);
                obj1 = a.x(a);
                obj2 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f03004d, null);
                if (flag5)
                {
                    ((com.socialin.camera.opengl.w) (obj1)).a(0.0F);
                    ((com.socialin.camera.opengl.w) (obj1)).b(50F);
                    ((com.socialin.camera.opengl.w) (obj1)).c(50F);
                    ((com.socialin.camera.opengl.w) (obj1)).d(50F);
                }
                obj3 = ((Activity) (obj2)).getString(0x7f0801b8);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023a);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((com.socialin.camera.opengl.w) (obj1)).d()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023b);
                seekbar.setMax(100);
                seekbar.setProgress((int)((com.socialin.camera.opengl.w) (obj1)).d());
                seekbar.setOnSeekBarChangeListener(new w._cls1(((com.socialin.camera.opengl.w) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801bc);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023c);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((com.socialin.camera.opengl.w) (obj1)).a()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023d);
                seekbar.setMax(100);
                seekbar.setProgress((int)((com.socialin.camera.opengl.w) (obj1)).a());
                seekbar.setOnSeekBarChangeListener(new w._cls2(((com.socialin.camera.opengl.w) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801ca);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100236);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((com.socialin.camera.opengl.w) (obj1)).c()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100237);
                seekbar.setMax(100);
                seekbar.setProgress((int)((com.socialin.camera.opengl.w) (obj1)).c());
                seekbar.setOnSeekBarChangeListener(new w._cls3(((com.socialin.camera.opengl.w) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj2 = ((Activity) (obj2)).getString(0x7f0801b1);
                obj3 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100238);
                ((TextView) (obj3)).setText((new StringBuilder()).append(((String) (obj2))).append(" : ").append((int)((com.socialin.camera.opengl.w) (obj1)).b()).toString());
                obj4 = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100239);
                ((SeekBar) (obj4)).setMax(100);
                ((SeekBar) (obj4)).setProgress((int)((com.socialin.camera.opengl.w) (obj1)).b());
                ((SeekBar) (obj4)).setOnSeekBarChangeListener(new w._cls4(((com.socialin.camera.opengl.w) (obj1)), ((TextView) (obj3)), ((String) (obj2))));
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 16;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L18:
                a.j(a).setVisibility(0);
                obj1 = a.y(a);
                obj2 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f03004d, null);
                if (flag5)
                {
                    ((ab) (obj1)).a(0.0F);
                    ((ab) (obj1)).b(50F);
                    ((ab) (obj1)).c(50F);
                    ((ab) (obj1)).d(50F);
                }
                obj3 = ((Activity) (obj2)).getString(0x7f0801b8);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023a);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((ab) (obj1)).d()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023b);
                seekbar.setMax(100);
                seekbar.setProgress((int)((ab) (obj1)).d());
                seekbar.setOnSeekBarChangeListener(new ab._cls1(((ab) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801bc);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023c);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((ab) (obj1)).a()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023d);
                seekbar.setMax(100);
                seekbar.setProgress((int)((ab) (obj1)).a());
                seekbar.setOnSeekBarChangeListener(new ab._cls2(((ab) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801ca);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100236);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((ab) (obj1)).c()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100237);
                seekbar.setMax(100);
                seekbar.setProgress((int)((ab) (obj1)).c());
                seekbar.setOnSeekBarChangeListener(new ab._cls3(((ab) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj2 = ((Activity) (obj2)).getString(0x7f0801b1);
                obj3 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100238);
                ((TextView) (obj3)).setText((new StringBuilder()).append(((String) (obj2))).append(" : ").append((int)((ab) (obj1)).b()).toString());
                obj4 = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100239);
                ((SeekBar) (obj4)).setMax(100);
                ((SeekBar) (obj4)).setProgress((int)((ab) (obj1)).b());
                ((SeekBar) (obj4)).setOnSeekBarChangeListener(new ab._cls4(((ab) (obj1)), ((TextView) (obj3)), ((String) (obj2))));
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 16;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L19:
                a.j(a).setVisibility(0);
                obj1 = com.socialin.camera.opengl.a.g(a);
                obj2 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f03004d, null);
                if (flag5)
                {
                    ((p) (obj1)).a(0.0F);
                    ((p) (obj1)).b(50F);
                    ((p) (obj1)).c(100F);
                    ((p) (obj1)).d(35F);
                }
                obj3 = ((Activity) (obj2)).getString(0x7f0801b8);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023a);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((p) (obj1)).d()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023b);
                seekbar.setMax(100);
                seekbar.setProgress((int)((p) (obj1)).d());
                seekbar.setOnSeekBarChangeListener(new p._cls1(((p) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801bc);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023c);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((p) (obj1)).a()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023d);
                seekbar.setMax(100);
                seekbar.setProgress((int)((p) (obj1)).a());
                seekbar.setOnSeekBarChangeListener(new p._cls2(((p) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801ca);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100236);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((p) (obj1)).c()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100237);
                seekbar.setMax(100);
                seekbar.setProgress((int)((p) (obj1)).c());
                seekbar.setOnSeekBarChangeListener(new p._cls3(((p) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj2 = ((Activity) (obj2)).getString(0x7f0801b1);
                obj3 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100238);
                ((TextView) (obj3)).setText((new StringBuilder()).append(((String) (obj2))).append(" : ").append((int)((p) (obj1)).b()).toString());
                obj4 = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100239);
                ((SeekBar) (obj4)).setMax(100);
                ((SeekBar) (obj4)).setProgress((int)((p) (obj1)).b());
                ((SeekBar) (obj4)).setOnSeekBarChangeListener(new p._cls4(((p) (obj1)), ((TextView) (obj3)), ((String) (obj2))));
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 16;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L20:
                a.j(a).setVisibility(0);
                obj1 = a.h(a);
                obj2 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
                if (flag5)
                {
                    ((q) (obj1)).a(0.0F);
                    ((q) (obj1)).b(25F);
                    ((q) (obj1)).c(25F);
                }
                obj3 = ((Activity) (obj2)).getString(0x7f0801bc);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023a);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((q) (obj1)).a()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023b);
                seekbar.setMax(100);
                seekbar.setProgress((int)((q) (obj1)).a());
                seekbar.setOnSeekBarChangeListener(new q._cls1(((q) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801c4);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100236);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((q) (obj1)).c()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100237);
                seekbar.setMax(100);
                seekbar.setProgress((int)((q) (obj1)).c());
                seekbar.setOnSeekBarChangeListener(new q._cls2(((q) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj2 = ((Activity) (obj2)).getString(0x7f0801e5);
                obj3 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100238);
                ((TextView) (obj3)).setText((new StringBuilder()).append(((String) (obj2))).append(" : ").append((int)((q) (obj1)).b()).toString());
                obj4 = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100239);
                ((SeekBar) (obj4)).setMax(100);
                ((SeekBar) (obj4)).setProgress((int)((q) (obj1)).b());
                ((SeekBar) (obj4)).setOnSeekBarChangeListener(new q._cls3(((q) (obj1)), ((TextView) (obj3)), ((String) (obj2))));
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                    obj1.gravity = 16;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L21:
                a.j(a).setVisibility(0);
                obj1 = a.z(a);
                obj2 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
                if (flag5)
                {
                    ((r) (obj1)).a(0.0F);
                    ((r) (obj1)).b(3F);
                    ((r) (obj1)).c(3F);
                }
                obj3 = ((Activity) (obj2)).getString(0x7f0801bc);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023a);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((r) (obj1)).a()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023b);
                seekbar.setMax(100);
                seekbar.setProgress((int)((r) (obj1)).a());
                seekbar.setOnSeekBarChangeListener(new r._cls1(((r) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj3 = ((Activity) (obj2)).getString(0x7f0801c4);
                obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100236);
                ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((r) (obj1)).c()).toString());
                seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100237);
                seekbar.setMax(100);
                seekbar.setProgress((int)((r) (obj1)).c());
                seekbar.setOnSeekBarChangeListener(new r._cls2(((r) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
                obj2 = ((Activity) (obj2)).getString(0x7f0801e5);
                obj3 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100238);
                ((TextView) (obj3)).setText((new StringBuilder()).append(((String) (obj2))).append(" : ").append((int)((r) (obj1)).b()).toString());
                obj4 = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100239);
                ((SeekBar) (obj4)).setMax(100);
                ((SeekBar) (obj4)).setProgress((int)((r) (obj1)).b());
                ((SeekBar) (obj4)).setOnSeekBarChangeListener(new r._cls3(((r) (obj1)), ((TextView) (obj3)), ((String) (obj2))));
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 16;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L22:
                a.j(a).setVisibility(0);
                obj = a.A(a).a(com.socialin.camera.opengl.a.c(a), b, a.j(a));
                j1 = ((flag4) ? 1 : 0);
                if (obj != null)
                {
                    obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj1.gravity = 1;
                    ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                    a.j(a).addView(((View) (obj)));
                    j1 = ((flag4) ? 1 : 0);
                }
                continue; /* Loop/switch isn't completed */
_L23:
                obj = a.i(a);
                obj1 = com.socialin.camera.opengl.a.c(a);
                flag5 = b;
                obj2 = a.j(a);
                obj2 = (LinearLayout)((Activity) (obj1)).getLayoutInflater().inflate(0x7f03004e, ((android.view.ViewGroup) (obj2)), false);
                ((n) (obj)).a(((Activity) (obj1)), flag5, ((LinearLayout) (obj2)));
                if (obj2 != null)
                {
                    obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
                    obj.gravity = 1;
                    ((View) (obj2)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                    a.j(a).addView(((View) (obj2)));
                }
                j1 = ((flag4) ? 1 : 0);
                if (a.i(a) != null)
                {
                    if (a.i(a).a() == null)
                    {
                        j1 = ((flag4) ? 1 : 0);
                        if (a.k(a) != null)
                        {
                            a.k(a).c(false);
                            j1 = ((flag4) ? 1 : 0);
                        }
                    } else
                    {
                        j1 = ((flag4) ? 1 : 0);
                        if (a.k(a) != null)
                        {
                            a.k(a).c(true);
                            a.k(a).b();
                            j1 = ((flag4) ? 1 : 0);
                        }
                    }
                }
                if (true) goto _L28; else goto _L27
_L27:
            }

            
            {
                a = a.this;
                b = flag;
                c = i1;
                d = flag1;
                super();
            }
        });
        return;
_L2:
        c = i1;
        switch (c)
        {
        case 11: // '\013'
            if (k != null)
            {
                v = true;
            }
            break;

        case 12: // '\f'
            if (l != null)
            {
                v = true;
            }
            break;

        case 17: // '\021'
            if (m != null)
            {
                v = true;
            }
            break;

        case 18: // '\022'
            if (n != null)
            {
                v = true;
            }
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(Bitmap bitmap, int i1, boolean flag)
    {
        int k1 = 640;
        CameraMainActivity cameramainactivity = (CameraMainActivity)a;
        if (bitmap == null || bitmap.isRecycled())
        {
            return;
        }
        cameramainactivity.k = false;
        cameramainactivity.l = false;
        cameramainactivity.j = System.currentTimeMillis();
        cameramainactivity.e.b();
        if (cameramainactivity.n != null && cameramainactivity.n.c())
        {
            cameramainactivity.n.b(false);
        }
        cameramainactivity.findViewById(0x7f10022b).setVisibility(0);
        cameramainactivity.a(8);
        cameramainactivity.findViewById(0x7f100210).setVisibility(8);
        ((ImageView)cameramainactivity.findViewById(0x7f10022c)).setImageBitmap(null);
        if (cameramainactivity.i != null && !cameramainactivity.i.isRecycled())
        {
            com.socialin.android.util.c.a(cameramainactivity.i);
            cameramainactivity.i = null;
        }
        cameramainactivity.h();
        Object obj = new DisplayMetrics();
        cameramainactivity.getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        int j1 = ((DisplayMetrics) (obj)).widthPixels;
        int l1 = ((DisplayMetrics) (obj)).heightPixels;
        float f1;
        Bitmap bitmap1;
        Bitmap bitmap2;
        int i2;
        if (j1 == 0 || l1 == 0)
        {
            j1 = 640;
        } else
        {
            k1 = l1;
        }
        l1 = bitmap.getWidth();
        i2 = bitmap.getHeight();
        if ((float)j1 / (float)l1 < (float)k1 / (float)i2)
        {
            f1 = (float)j1 / (float)l1;
        } else
        {
            f1 = (float)k1 / (float)i2;
        }
        bitmap2 = com.socialin.android.util.w.a(bitmap, (int)((float)l1 * f1), (int)(f1 * (float)i2));
        bitmap1 = bitmap2;
        if (cameramainactivity.a == null) goto _L2; else goto _L1
_L1:
        obj = bitmap2;
        if (!flag) goto _L4; else goto _L3
_L3:
        i1;
        JVM INSTR lookupswitch 2: default 328
    //                   90: 456
    //                   270: 456;
           goto _L5 _L6 _L6
_L5:
        obj = bitmap2;
_L4:
        j1 = cameramainactivity.a.E();
        bitmap1 = ((Bitmap) (obj));
        if (j1 != 0)
        {
            bitmap1 = com.socialin.android.util.w.d(((Bitmap) (obj)), j1);
        }
_L2:
        cameramainactivity.i = bitmap1;
        if (cameramainactivity.i != null && !cameramainactivity.i.isRecycled())
        {
            ((ImageView)cameramainactivity.findViewById(0x7f10022c)).setImageBitmap(cameramainactivity.i);
            cameramainactivity.h();
        }
        cameramainactivity.b(false);
        cameramainactivity.d = new d(cameramainactivity, bitmap, i1, flag);
        cameramainactivity.d.start();
        return;
_L6:
        obj = com.socialin.android.util.w.d(bitmap2, 180);
        if (true) goto _L4; else goto _L7
_L7:
    }

    public final boolean b()
    {
        return c == 4 || c == 9 || c == 8 || c == 5 || c == 7 || c == 18 || c == 19;
    }

    public final void c()
    {
        if (x != null)
        {
            x.c(false);
        }
        ((CameraMainActivity)a).h.queueEvent(new Runnable() {

            private a a;

            public final void run()
            {
                if (a.a(a) == 21 && a.i(a) != null)
                {
                    n n1 = a.i(a);
                    a.C(a).get(Integer.valueOf(a.a(a)));
                    n1.b();
                }
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

    public final void d()
    {
        if (a != null)
        {
            a.runOnUiThread(new Runnable() {

                private a a;

                public final void run()
                {
                    CameraMainActivity cameramainactivity = (CameraMainActivity)com.socialin.camera.opengl.a.c(a);
                    if (cameramainactivity.b != null && cameramainactivity.b.isShowing())
                    {
                        cameramainactivity.b.dismiss();
                    }
                    if (a.k(a) != null)
                    {
                        a.k(a).c(true);
                        a.k(a).b();
                        a.k(a).a();
                    }
                    cameramainactivity.a.setPictureTaking(false);
                }

            
            {
                a = a.this;
                super();
            }
            });
        }
    }

    static 
    {
        Color.argb(255, 50, 50, 50);
    }

    // Unreferenced inner class com/socialin/camera/opengl/CameraOpenGlEffects$1

/* anonymous class */
    final class CameraOpenGlEffects._cls1 extends HashMap
    {

            
            {
                put(Integer.valueOf(0), Integer.valueOf(0x7f08019d));
                put(Integer.valueOf(1), Integer.valueOf(0x7f08016b));
                put(Integer.valueOf(2), Integer.valueOf(0x7f080182));
                put(Integer.valueOf(3), Integer.valueOf(0x7f080172));
                put(Integer.valueOf(5), Integer.valueOf(0x7f08021a));
                put(Integer.valueOf(6), Integer.valueOf(0x7f080755));
                put(Integer.valueOf(7), Integer.valueOf(0x7f080189));
                put(Integer.valueOf(8), Integer.valueOf(0x7f080217));
                put(Integer.valueOf(9), Integer.valueOf(0x7f080196));
                put(Integer.valueOf(10), Integer.valueOf(0x7f0801fc));
                put(Integer.valueOf(11), Integer.valueOf(0x7f080208));
                put(Integer.valueOf(12), Integer.valueOf(0x7f0801f5));
                put(Integer.valueOf(13), Integer.valueOf(0x7f08016d));
                put(Integer.valueOf(14), Integer.valueOf(0x7f08016e));
                put(Integer.valueOf(15), Integer.valueOf(0x7f08019b));
                put(Integer.valueOf(16), Integer.valueOf(0x7f080149));
                put(Integer.valueOf(17), Integer.valueOf(0x7f08014e));
                put(Integer.valueOf(18), Integer.valueOf(0x7f080187));
                put(Integer.valueOf(19), Integer.valueOf(0x7f080188));
                put(Integer.valueOf(20), Integer.valueOf(0x7f08018c));
                put(Integer.valueOf(21), Integer.valueOf(0x7f080181));
            }
    }


    // Unreferenced inner class com/socialin/camera/opengl/a$6

/* anonymous class */
    public final class _cls6
        implements Runnable
    {

        final LinearLayout a;
        final a b;
        private com.socialin.camera.masks.a c;
        private String d;
        private boolean e;

        public final void run()
        {
            int i1 = a.a(c);
            AnalyticUtils analyticutils = AnalyticUtils.getInstance(com.socialin.camera.opengl.a.c(b));
            com.socialin.android.apiv3.events.EventsFactory.CameraActionEvent cameraactionevent = new com.socialin.android.apiv3.events.EventsFactory.CameraActionEvent(com.socialin.camera.opengl.a.b(b), "mask_try");
            String s1;
            if (c.d != null)
            {
                s1 = c.d.toLowerCase();
            } else
            {
                s1 = null;
            }
            analyticutils.track(cameraactionevent.setMaskName(s1));
            if (a.p(b) != null)
            {
                a.p(b).a(i1);
                a.p(b).f = d;
                a.p(b).g = c;
                if (e)
                {
                    a.p(b).a(0.0F, false);
                }
                if (com.socialin.camera.opengl.a.c(b) != null)
                {
                    com.socialin.camera.opengl.a.c(b).runOnUiThread(new Runnable(this) {

                        private _cls6 a;

                        public final void run()
                        {
    public final class _cls6
        implements Runnable
    {
                            e e1 = a.p(a.b);
                            Object obj = a.a;
                            if (obj != null)
                            {
                                String s1 = com.socialin.camera.opengl.a.c(e1.h).getString(0x7f0801bc);
                                TextView textview = (TextView)((LinearLayout) (obj)).findViewById(0x7f100403);
                                textview.setText((new StringBuilder()).append(s1).append(" : ").append((int)e1.b).toString());
                                obj = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100404);
                                ((SeekBar) (obj)).setMax(100);
                                ((SeekBar) (obj)).setProgress((int)e1.b);
                                ((SeekBar) (obj)).setOnSeekBarChangeListener(new e._cls2(e1, textview, s1));
                            }
                        }

            
            {
                a = _pcls6;
                super();
            }
                    });
                }
            }
            a.e(b);
        }

            public 
            {
                b = a.this;
                c = a2;
                d = s1;
                e = flag;
                a = linearlayout;
                super();
            }
    }

}
