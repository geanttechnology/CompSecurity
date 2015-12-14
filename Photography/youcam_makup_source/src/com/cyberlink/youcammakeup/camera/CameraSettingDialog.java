// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.a;
import com.cyberlink.youcammakeup.kernelctrl.y;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.aj;
import com.cyberlink.youcammakeup.utility.ak;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            g, h

public class CameraSettingDialog extends a
{

    private static boolean s = false;
    private View a;
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;
    private View g;
    private h h;
    private g i;
    private boolean j;
    private Setting k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;

    public CameraSettingDialog()
    {
        boolean flag = true;
        super();
        j = false;
        k = y.a;
        l = false;
        n = false;
        o = true;
        p = true;
        q = y.b;
        r = true;
        j();
        if (s)
        {
            flag = false;
        }
        r = flag;
        k();
        l();
    }

    static View a(CameraSettingDialog camerasettingdialog)
    {
        return camerasettingdialog.a;
    }

    private void a(Setting setting)
    {
        if (setting != com.cyberlink.youcammakeup.camera.Setting.a && setting != Setting.b && setting != Setting.c)
        {
            return;
        }
        k = setting;
        class _cls5
        {

            static final int a[];

            static 
            {
                a = new int[Setting.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.camera.Setting.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[Setting.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[Setting.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.cyberlink.youcammakeup.camera._cls5.a[setting.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            a.setSelected(true);
            b.setSelected(false);
            c.setSelected(false);
            d.setEnabled(true);
            return;

        case 2: // '\002'
            a.setSelected(false);
            b.setSelected(true);
            c.setSelected(false);
            d.setEnabled(true);
            return;

        case 3: // '\003'
            a.setSelected(false);
            break;
        }
        b.setSelected(false);
        c.setSelected(true);
        d.setEnabled(false);
    }

    static void a(CameraSettingDialog camerasettingdialog, Setting setting)
    {
        camerasettingdialog.a(setting);
    }

    static boolean a(CameraSettingDialog camerasettingdialog, boolean flag)
    {
        camerasettingdialog.n = flag;
        return flag;
    }

    static void b(CameraSettingDialog camerasettingdialog, boolean flag)
    {
        camerasettingdialog.c(flag);
    }

    static boolean b(CameraSettingDialog camerasettingdialog)
    {
        return camerasettingdialog.n;
    }

    static void c(CameraSettingDialog camerasettingdialog, boolean flag)
    {
        camerasettingdialog.d(flag);
    }

    private void c(boolean flag)
    {
        o = flag;
        e.setSelected(flag);
    }

    static boolean c(CameraSettingDialog camerasettingdialog)
    {
        return camerasettingdialog.m;
    }

    static View d(CameraSettingDialog camerasettingdialog)
    {
        return camerasettingdialog.b;
    }

    static void d(CameraSettingDialog camerasettingdialog, boolean flag)
    {
        camerasettingdialog.e(flag);
    }

    private void d(boolean flag)
    {
        p = flag;
        f.setSelected(flag);
    }

    static View e(CameraSettingDialog camerasettingdialog)
    {
        return camerasettingdialog.c;
    }

    private void e(boolean flag)
    {
        r = flag;
        g.setSelected(flag);
    }

    static View f(CameraSettingDialog camerasettingdialog)
    {
        return camerasettingdialog.d;
    }

    static boolean g(CameraSettingDialog camerasettingdialog)
    {
        return camerasettingdialog.l;
    }

    static View h(CameraSettingDialog camerasettingdialog)
    {
        return camerasettingdialog.e;
    }

    public static boolean h()
    {
        return s;
    }

    static boolean i(CameraSettingDialog camerasettingdialog)
    {
        return camerasettingdialog.o;
    }

    static View j(CameraSettingDialog camerasettingdialog)
    {
        return camerasettingdialog.f;
    }

    private static void j()
    {
        boolean flag = true;
        boolean flag1 = z.a("HAD_RUN_GPU_BENCHMARK", false, Globals.d());
        float f1;
        String s1;
        if (z.a("CAMERA_SETTING_CAMERA_FACING_BACK", false, Globals.d()))
        {
            s1 = "GPU_BENCHMARK_ESTIMATE_FPS_BACK";
        } else
        {
            s1 = "GPU_BENCHMARK_ESTIMATE_FPS_FRONT";
        }
        f1 = z.b(s1, 0.0F, Globals.d());
        if (!flag1)
        {
            if (Globals.d().e().intValue() <= 0x16e360)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            s = flag;
            return;
        }
        if (f1 >= 15F)
        {
            flag = false;
        }
        s = flag;
    }

    private void k()
    {
        boolean flag = true;
        j = z.a("CAMERA_SETTING_CAMERA_FACING_BACK", false, Globals.d());
        z.a("CAMERA_SETTING_CAPTURE_MODE", com.cyberlink.youcammakeup.camera.Setting.a.toString(), Globals.d());
        k = Setting.valueOf(z.b("CAMERA_SETTING_CAPTURE_MODE", y.a.toString(), Globals.d()));
        l = z.a("CAMERA_SETTING_TIMER", false, Globals.d());
        o = z.a("CAMERA_SETTING_FILTER", true, Globals.d());
        p = z.a("CAMERA_SETTING_SOUND", true, Globals.d());
        q = z.a("CAMERA_SETTING_PREVIEW_QUALITY", y.b, Globals.d());
        if (s)
        {
            flag = false;
        }
        r = z.a("CAMERA_SETTING_LIVE_PREVIEW", flag, Globals.d());
    }

    static boolean k(CameraSettingDialog camerasettingdialog)
    {
        return camerasettingdialog.p;
    }

    static View l(CameraSettingDialog camerasettingdialog)
    {
        return camerasettingdialog.g;
    }

    private void l()
    {
        z.a("CAMERA_SETTING_CAMERA_FACING_BACK", Boolean.valueOf(j), Globals.d());
        z.a("CAMERA_SETTING_CAPTURE_MODE", k.toString(), Globals.d());
        if (n)
        {
            z.a("CAMERA_SETTING_TIMER", Boolean.valueOf(m), Globals.d());
        } else
        {
            z.a("CAMERA_SETTING_TIMER", Boolean.valueOf(l), Globals.d());
        }
        z.a("CAMERA_SETTING_FILTER", Boolean.valueOf(o), Globals.d());
        z.a("CAMERA_SETTING_SOUND", Boolean.valueOf(p), Globals.d());
        z.a("CAMERA_SETTING_PREVIEW_QUALITY", Boolean.valueOf(q), Globals.d());
        z.a("CAMERA_SETTING_LIVE_PREVIEW", Boolean.valueOf(r), Globals.d());
    }

    static boolean m(CameraSettingDialog camerasettingdialog)
    {
        return camerasettingdialog.r;
    }

    static void n(CameraSettingDialog camerasettingdialog)
    {
        camerasettingdialog.l();
    }

    static h o(CameraSettingDialog camerasettingdialog)
    {
        return camerasettingdialog.h;
    }

    public void a(g g1)
    {
        i = g1;
    }

    public void a(h h1)
    {
        h = h1;
    }

    public void a(boolean flag)
    {
        l = flag;
        d.setSelected(flag);
    }

    public Setting b()
    {
        return k;
    }

    public void b(boolean flag)
    {
        j = flag;
        l();
    }

    public boolean c()
    {
        return l;
    }

    public boolean d()
    {
        return o;
    }

    public boolean e()
    {
        return p;
    }

    public boolean f()
    {
        return q;
    }

    public boolean g()
    {
        return r;
    }

    public boolean i()
    {
        return j;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getView();
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            final CameraSettingDialog a;

            public void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = CameraSettingDialog.this;
                super();
            }
        });
        bundle.findViewById(0x7f0c0538).setOnTouchListener(new android.view.View.OnTouchListener() {

            final CameraSettingDialog a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = CameraSettingDialog.this;
                super();
            }
        });
        a = bundle.findViewById(0x7f0c053a);
        b = bundle.findViewById(0x7f0c053c);
        c = bundle.findViewById(0x7f0c053e);
        d = bundle.findViewById(0x7f0c0543);
        e = bundle.findViewById(0x7f0c0541);
        f = bundle.findViewById(0x7f0c0545);
        g = bundle.findViewById(0x7f0c0547);
        Object obj = new android.view.View.OnClickListener() {

            final CameraSettingDialog a;

            public void onClick(View view)
            {
                boolean flag;
                boolean flag4;
                boolean flag5;
                boolean flag6;
                flag4 = true;
                flag5 = true;
                flag6 = true;
                flag = true;
                if (view != com.cyberlink.youcammakeup.camera.CameraSettingDialog.a(a)) goto _L2; else goto _L1
_L1:
                Setting setting = com.cyberlink.youcammakeup.camera.Setting.a;
                view = setting;
                if (CameraSettingDialog.b(a))
                {
                    a.a(CameraSettingDialog.c(a));
                    com.cyberlink.youcammakeup.camera.CameraSettingDialog.a(a, false);
                    view = setting;
                }
_L4:
                com.cyberlink.youcammakeup.camera.CameraSettingDialog.a(a, view);
                CameraSettingDialog.n(a);
                if (CameraSettingDialog.o(a) != null)
                {
                    CameraSettingDialog.o(a).a(view);
                }
                return;
_L2:
                if (view == CameraSettingDialog.d(a))
                {
                    Setting setting1 = Setting.b;
                    view = setting1;
                    if (CameraSettingDialog.b(a))
                    {
                        a.a(CameraSettingDialog.c(a));
                        com.cyberlink.youcammakeup.camera.CameraSettingDialog.a(a, false);
                        view = setting1;
                    }
                } else
                if (view == CameraSettingDialog.e(a))
                {
                    Setting setting2 = Setting.c;
                    view = setting2;
                    if (CameraSettingDialog.b(a))
                    {
                        a.a(CameraSettingDialog.c(a));
                        com.cyberlink.youcammakeup.camera.CameraSettingDialog.a(a, false);
                        view = setting2;
                    }
                } else
                if (view == CameraSettingDialog.f(a))
                {
                    view = Setting.d;
                    CameraSettingDialog camerasettingdialog = a;
                    if (CameraSettingDialog.g(a))
                    {
                        flag = false;
                    }
                    camerasettingdialog.a(flag);
                } else
                if (view == CameraSettingDialog.h(a))
                {
                    view = Setting.e;
                    CameraSettingDialog camerasettingdialog1 = a;
                    boolean flag1;
                    if (!CameraSettingDialog.i(a))
                    {
                        flag1 = flag4;
                    } else
                    {
                        flag1 = false;
                    }
                    CameraSettingDialog.b(camerasettingdialog1, flag1);
                } else
                if (view == CameraSettingDialog.j(a))
                {
                    view = Setting.f;
                    CameraSettingDialog camerasettingdialog2 = a;
                    boolean flag2;
                    if (!CameraSettingDialog.k(a))
                    {
                        flag2 = flag5;
                    } else
                    {
                        flag2 = false;
                    }
                    CameraSettingDialog.c(camerasettingdialog2, flag2);
                } else
                if (view == CameraSettingDialog.l(a))
                {
                    view = Setting.g;
                    CameraSettingDialog camerasettingdialog3 = a;
                    boolean flag3;
                    if (!CameraSettingDialog.m(a))
                    {
                        flag3 = flag6;
                    } else
                    {
                        flag3 = false;
                    }
                    CameraSettingDialog.d(camerasettingdialog3, flag3);
                } else
                {
                    view = null;
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = CameraSettingDialog.this;
                super();
            }
        };
        a.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        b.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        c.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        d.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        e.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        f.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        g.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        obj = aj.a(getActivity().getWindowManager().getDefaultDisplay(), new ak[] {
            new ak(360F, 12F, new String[] {
                "ja"
            }), new ak(360F, 11F, new String[] {
                "it"
            })
        });
        if (obj != null)
        {
            ((TextView)bundle.findViewById(0x7f0c0539)).setTextSize(1, ((Float) (obj)).floatValue());
        }
        obj = aj.a(getActivity().getWindowManager().getDefaultDisplay(), new ak[] {
            new ak(360F, 9F, new String[] {
                "ru"
            })
        });
        if (obj != null)
        {
            ((TextView)bundle.findViewById(0x7f0c053b)).setTextSize(1, ((Float) (obj)).floatValue());
            ((TextView)bundle.findViewById(0x7f0c053d)).setTextSize(1, ((Float) (obj)).floatValue());
            ((TextView)bundle.findViewById(0x7f0c053f)).setTextSize(1, ((Float) (obj)).floatValue());
        }
        getDialog().setOnKeyListener(new android.content.DialogInterface.OnKeyListener() {

            final CameraSettingDialog a;

            public boolean onKey(DialogInterface dialoginterface, int i1, KeyEvent keyevent)
            {
                return i1 == 27 || i1 == 24 || i1 == 25;
            }

            
            {
                a = CameraSettingDialog.this;
                super();
            }
        });
        a(k);
        a(l);
        c(o);
        d(p);
        e(r);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(1, 0x7f0a0209);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0300ee, viewgroup);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (i != null)
        {
            i.a();
        }
    }

    static 
    {
        j();
    }

    private class Setting extends Enum
    {

        public static final Setting a;
        public static final Setting b;
        public static final Setting c;
        public static final Setting d;
        public static final Setting e;
        public static final Setting f;
        public static final Setting g;
        public static final Setting h;
        private static final Setting i[];

        public static Setting valueOf(String s1)
        {
            return (Setting)Enum.valueOf(com/cyberlink/youcammakeup/camera/CameraSettingDialog$Setting, s1);
        }

        public static Setting[] values()
        {
            return (Setting[])i.clone();
        }

        static 
        {
            a = new Setting("GENERAL", 0);
            b = new Setting("TOUCH", 1);
            c = new Setting("DETECT", 2);
            d = new Setting("TIMER", 3);
            e = new Setting("FILTER", 4);
            f = new Setting("SOUND", 5);
            g = new Setting("PREVIEW", 6);
            h = new Setting("QUALITY", 7);
            i = (new Setting[] {
                a, b, c, d, e, f, g, h
            });
        }

        private Setting(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
