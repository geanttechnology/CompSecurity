// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.photo.gpu.g;
import com.socialin.picsin.camera.CameraMainActivity;
import myobfuscated.db.a;

// Referenced classes of package com.socialin.camera.opengl:
//            a, e, n, CameraOpenGlSurfaceView, 
//            b, g, d, t, 
//            s, aa, v, y, 
//            z, x, i, j, 
//            w, ab, p, q, 
//            r, u

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        com.socialin.camera.opengl.a.p(a.a).a(0);
        com.socialin.camera.opengl.a.p(a.a).f = null;
        com.socialin.camera.opengl.a.p(a.a).g = null;
    }

    tParams(tParams tparams)
    {
        a = tparams;
        super();
    }

    // Unreferenced inner class com/socialin/camera/opengl/a$5

/* anonymous class */
    final class a._cls5
        implements Runnable
    {

        final com.socialin.camera.opengl.a a;
        private boolean b;
        private int c;
        private boolean d;

        public final void run()
        {
            boolean flag;
            if (com.socialin.camera.opengl.a.j(a) != null)
            {
                com.socialin.camera.opengl.a.j(a).removeAllViews();
            }
            flag = true;
            if (com.socialin.camera.opengl.a.i(a) != null && b)
            {
                com.socialin.camera.opengl.a.i(a).c();
            }
            c;
            JVM INSTR tableswitch 0 21: default 156
        //                       0 235
        //                       1 291
        //                       2 552
        //                       3 423
        //                       4 676
        //                       5 721
        //                       6 1149
        //                       7 1226
        //                       8 1640
        //                       9 1982
        //                       10 2163
        //                       11 2576
        //                       12 2993
        //                       13 3410
        //                       14 3829
        //                       15 4357
        //                       16 4885
        //                       17 5413
        //                       18 5943
        //                       19 6366
        //                       20 6788
        //                       21 6875;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23
_L1:
            int k = ((flag) ? 1 : 0);
_L28:
            if (k != 0)
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
            float f;
            Object obj;
            Object obj1;
            Object obj2;
            Object obj3;
            Object obj4;
            SeekBar seekbar;
            boolean flag1;
            if (d)
            {
                ((CameraMainActivity)com.socialin.camera.opengl.a.c(a)).e();
                k = 0;
            } else
            {
                k = 1;
            }
            if (com.socialin.camera.opengl.a.k(a) != null)
            {
                com.socialin.camera.opengl.a.k(a).c(false);
            }
            com.socialin.camera.opengl.a.l(a);
            continue; /* Loop/switch isn't completed */
_L3:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj = com.socialin.camera.opengl.a.m(a).c;
            if (obj != null)
            {
                f = com.socialin.camera.opengl.a.m(a).a;
                k = com.socialin.camera.opengl.a.m(a).d;
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 1;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                com.socialin.camera.opengl.a.m(a).a(k, f, true);
            }
            if (com.socialin.camera.opengl.a.k(a) != null)
            {
                com.socialin.camera.opengl.a.k(a).c(true);
                com.socialin.camera.opengl.a.k(a).b();
                k = 0;
            } else
            {
                k = 0;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj = com.socialin.camera.opengl.a.n(a).d;
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 1;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
                if (b)
                {
                    obj = com.socialin.camera.opengl.a.n(a);
                    ((com.socialin.camera.opengl.g) (obj)).a(0.0F, false);
                    ((com.socialin.camera.opengl.g) (obj)).a(0, false);
                    k = ((flag) ? 1 : 0);
                    if (((com.socialin.camera.opengl.g) (obj)).d != null)
                    {
                        com.socialin.camera.opengl.a.c(((com.socialin.camera.opengl.g) (obj)).e).runOnUiThread(new g._cls3(((com.socialin.camera.opengl.g) (obj))));
                        k = ((flag) ? 1 : 0);
                    }
                }
            }
            continue; /* Loop/switch isn't completed */
_L4:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj = com.socialin.camera.opengl.a.o(a).b;
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 16;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
                if (b)
                {
                    obj = com.socialin.camera.opengl.a.o(a);
                    ((d) (obj)).a(0.0F, false);
                    k = ((flag) ? 1 : 0);
                    if (((d) (obj)).b != null)
                    {
                        com.socialin.camera.opengl.a.c(((d) (obj)).d).runOnUiThread(new d._cls2(((d) (obj))));
                        k = ((flag) ? 1 : 0);
                    }
                }
            }
            continue; /* Loop/switch isn't completed */
_L6:
            k = ((flag) ? 1 : 0);
            if (com.socialin.camera.opengl.a.p(a) != null)
            {
                ((CameraMainActivity)com.socialin.camera.opengl.a.c(a)).c().queueEvent(new a._cls5._cls1(this));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L7:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj = com.socialin.camera.opengl.a.q(a);
            obj2 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj1 = com.socialin.camera.opengl.a.j(a);
            obj1 = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, ((android.view.ViewGroup) (obj1)), false);
            if (flag1)
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
            k = ((flag) ? 1 : 0);
            if (obj1 != null)
            {
                obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj.gravity = 1;
                ((View) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj1)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L8:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj = com.socialin.camera.opengl.a.e().a(com.socialin.camera.opengl.a.c(a), b);
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 16;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L9:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj1 = com.socialin.camera.opengl.a.r(a);
            obj2 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
            if (flag1)
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
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 16;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L10:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj1 = com.socialin.camera.opengl.a.s(a);
            obj2 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
            if (flag1)
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
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 16;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L11:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj = com.socialin.camera.opengl.a.t(a);
            obj1 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj1 = (LinearLayout)((Activity) (obj1)).getLayoutInflater().inflate(0x7f030050, null);
            if (flag1)
            {
                ((v) (obj)).a(0);
            }
            obj2 = (RadioGroup)((LinearLayout) (obj1)).findViewById(0x7f10024f);
            ((v) (obj)).a;
            JVM INSTR tableswitch 0 1: default 2080
        //                       0 2141
        //                       1 2152;
               goto _L24 _L25 _L26
_L24:
            ((RadioGroup) (obj2)).setOnCheckedChangeListener(new v._cls1(((v) (obj))));
            k = ((flag) ? 1 : 0);
            if (obj1 != null)
            {
                obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj.gravity = 16;
                ((View) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj1)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L25:
            ((RadioGroup) (obj2)).check(0x7f100250);
            continue; /* Loop/switch isn't completed */
_L26:
            ((RadioGroup) (obj2)).check(0x7f100251);
            if (true) goto _L24; else goto _L12
_L12:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj1 = com.socialin.camera.opengl.a.u(a);
            obj2 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
            if (flag1)
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
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 16;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L13:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj1 = com.socialin.camera.opengl.a.d(a);
            obj2 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
            if (flag1)
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
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 16;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L14:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj1 = com.socialin.camera.opengl.a.f(a);
            obj2 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
            if (flag1)
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
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 16;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L15:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj1 = com.socialin.camera.opengl.a.v(a);
            obj2 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
            if (flag1)
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
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 16;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L16:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj1 = com.socialin.camera.opengl.a.w(a);
            obj2 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f03004d, null);
            if (flag1)
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
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 16;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L17:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj1 = com.socialin.camera.opengl.a.x(a);
            obj2 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f03004d, null);
            if (flag1)
            {
                ((w) (obj1)).a(0.0F);
                ((w) (obj1)).b(50F);
                ((w) (obj1)).c(50F);
                ((w) (obj1)).d(50F);
            }
            obj3 = ((Activity) (obj2)).getString(0x7f0801b8);
            obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023a);
            ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((w) (obj1)).d()).toString());
            seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023b);
            seekbar.setMax(100);
            seekbar.setProgress((int)((w) (obj1)).d());
            seekbar.setOnSeekBarChangeListener(new w._cls1(((w) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
            obj3 = ((Activity) (obj2)).getString(0x7f0801bc);
            obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f10023c);
            ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((w) (obj1)).a()).toString());
            seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f10023d);
            seekbar.setMax(100);
            seekbar.setProgress((int)((w) (obj1)).a());
            seekbar.setOnSeekBarChangeListener(new w._cls2(((w) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
            obj3 = ((Activity) (obj2)).getString(0x7f0801ca);
            obj4 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100236);
            ((TextView) (obj4)).setText((new StringBuilder()).append(((String) (obj3))).append(" : ").append((int)((w) (obj1)).c()).toString());
            seekbar = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100237);
            seekbar.setMax(100);
            seekbar.setProgress((int)((w) (obj1)).c());
            seekbar.setOnSeekBarChangeListener(new w._cls3(((w) (obj1)), ((TextView) (obj4)), ((String) (obj3))));
            obj2 = ((Activity) (obj2)).getString(0x7f0801b1);
            obj3 = (TextView)((LinearLayout) (obj)).findViewById(0x7f100238);
            ((TextView) (obj3)).setText((new StringBuilder()).append(((String) (obj2))).append(" : ").append((int)((w) (obj1)).b()).toString());
            obj4 = (SeekBar)((LinearLayout) (obj)).findViewById(0x7f100239);
            ((SeekBar) (obj4)).setMax(100);
            ((SeekBar) (obj4)).setProgress((int)((w) (obj1)).b());
            ((SeekBar) (obj4)).setOnSeekBarChangeListener(new w._cls4(((w) (obj1)), ((TextView) (obj3)), ((String) (obj2))));
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 16;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L18:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj1 = com.socialin.camera.opengl.a.y(a);
            obj2 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f03004d, null);
            if (flag1)
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
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 16;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L19:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj1 = com.socialin.camera.opengl.a.g(a);
            obj2 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f03004d, null);
            if (flag1)
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
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 16;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L20:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj1 = com.socialin.camera.opengl.a.h(a);
            obj2 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
            if (flag1)
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
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                obj1.gravity = 16;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L21:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj1 = com.socialin.camera.opengl.a.z(a);
            obj2 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj = (LinearLayout)((Activity) (obj2)).getLayoutInflater().inflate(0x7f030051, null);
            if (flag1)
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
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 16;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L22:
            com.socialin.camera.opengl.a.j(a).setVisibility(0);
            obj = com.socialin.camera.opengl.a.A(a).a(com.socialin.camera.opengl.a.c(a), b, com.socialin.camera.opengl.a.j(a));
            k = ((flag) ? 1 : 0);
            if (obj != null)
            {
                obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj1.gravity = 1;
                ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj)));
                k = ((flag) ? 1 : 0);
            }
            continue; /* Loop/switch isn't completed */
_L23:
            obj = com.socialin.camera.opengl.a.i(a);
            obj1 = com.socialin.camera.opengl.a.c(a);
            flag1 = b;
            obj2 = com.socialin.camera.opengl.a.j(a);
            obj2 = (LinearLayout)((Activity) (obj1)).getLayoutInflater().inflate(0x7f03004e, ((android.view.ViewGroup) (obj2)), false);
            ((n) (obj)).a(((Activity) (obj1)), flag1, ((LinearLayout) (obj2)));
            if (obj2 != null)
            {
                obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
                obj.gravity = 1;
                ((View) (obj2)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                com.socialin.camera.opengl.a.j(a).addView(((View) (obj2)));
            }
            k = ((flag) ? 1 : 0);
            if (com.socialin.camera.opengl.a.i(a) != null)
            {
                if (com.socialin.camera.opengl.a.i(a).a() == null)
                {
                    k = ((flag) ? 1 : 0);
                    if (com.socialin.camera.opengl.a.k(a) != null)
                    {
                        com.socialin.camera.opengl.a.k(a).c(false);
                        k = ((flag) ? 1 : 0);
                    }
                } else
                {
                    k = ((flag) ? 1 : 0);
                    if (com.socialin.camera.opengl.a.k(a) != null)
                    {
                        com.socialin.camera.opengl.a.k(a).c(true);
                        com.socialin.camera.opengl.a.k(a).b();
                        k = ((flag) ? 1 : 0);
                    }
                }
            }
            if (true) goto _L28; else goto _L27
_L27:
        }

            
            {
                a = a1;
                b = flag;
                c = k;
                d = flag1;
                super();
            }
    }

}
