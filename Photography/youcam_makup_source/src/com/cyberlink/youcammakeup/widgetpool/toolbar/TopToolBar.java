// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.MoreActivity;
import com.cyberlink.youcammakeup.activity.f;
import com.cyberlink.youcammakeup.clflurry.YMKEditStayTimeEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.ar;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.RateOfFeaturePointAdjustment;
import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.n;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.u;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.cyberlink.youcammakeup.masteraccess.c;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.setting.PhotoQuality;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.ca;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ak;
import com.cyberlink.youcammakeup.widgetpool.panel.a;
import java.util.Locale;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            l

public class TopToolBar extends Fragment
    implements n, u
{

    private View a;
    private View b;
    private TextView c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private a i;
    private View j;
    private Toast k;
    private boolean l;
    private boolean m;
    private android.view.View.OnClickListener n;
    private android.view.View.OnClickListener o;
    private android.view.View.OnClickListener p;
    private android.view.View.OnClickListener q;

    public TopToolBar()
    {
        m = false;
        n = new android.view.View.OnClickListener() {

            final TopToolBar a;

            public void onClick(View view)
            {
                if (!StatusManager.j().E().booleanValue())
                {
                    return;
                }
                long l1 = System.currentTimeMillis();
                Object obj;
                Globals globals;
                BaseActivity baseactivity;
                boolean flag;
                if (YMKSavingPageEvent.g().equals(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Source.a.a()))
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(YMKSavingPageEvent.b, l1, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.b, true, true));
                } else
                {
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(YMKSavingPageEvent.b, l1, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.b, true, false));
                }
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(YMKSavingPageEvent.b, l1, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.e, false, false));
                view = ca.b().a("%d");
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKEditStayTimeEvent(com.cyberlink.youcammakeup.clflurry.YMKEditStayTimeEvent.Button.b, view));
                com.cyberlink.youcammakeup.flurry.a.a(new com.cyberlink.youcammakeup.flurry.YMKEditStayTimeEvent(com.cyberlink.youcammakeup.flurry.YMKEditStayTimeEvent.Button.b, view));
                com.cyberlink.youcammakeup.flurry.a.a(new RateOfFeaturePointAdjustment());
                if (PhotoQuality.a(StatusManager.j().l()))
                {
                    (new ag(Globals.d().getApplicationContext())).f();
                }
                view = new Bundle();
                flag = PhotoQuality.a(StatusManager.j().l());
                view.putString("BUNDLE_KEY_MESSAGE", ak.a);
                view.putBoolean("IS_DELAY_LOAD_AD", flag);
                obj = new com.cyberlink.youcammakeup.camera.ag();
                ((com.cyberlink.youcammakeup.camera.ag) (obj)).a(new android.content.DialogInterface.OnDismissListener(this) {

                    final _cls1 a;

                    public void onDismiss(DialogInterface dialoginterface)
                    {
                        ca.b().a();
                        YMKSavingPageEvent.b = System.currentTimeMillis();
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
                ((com.cyberlink.youcammakeup.camera.ag) (obj)).setArguments(view);
                ((com.cyberlink.youcammakeup.camera.ag) (obj)).c();
                a.a(Boolean.valueOf(true));
                globals = Globals.d();
                baseactivity = (BaseActivity)a.getActivity();
                baseactivity.a(MakeupMode.g);
                l1 = StatusManager.j().l();
                view = StatusManager.j().d();
                if (view != null)
                {
                    view.a(new ar());
                }
                if (com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(l1))
                {
                    view = ViewEngine.a().a(l1, 1.0D, null);
                } else
                {
                    view = null;
                }
                obj = new c(this, globals, l1, baseactivity, ((com.cyberlink.youcammakeup.camera.ag) (obj))) {

                    final Globals a;
                    final long b;
                    final BaseActivity c;
                    final com.cyberlink.youcammakeup.camera.ag d;
                    final _cls1 e;

                    public void a()
                    {
                        e.a.a(Boolean.valueOf(false));
                    }

                    public void a(com.cyberlink.youcammakeup.masteraccess.Exporter.Error error)
                    {
                        e.a.getActivity().runOnUiThread(new Runnable(this, error) {

                            final com.cyberlink.youcammakeup.masteraccess.Exporter.Error a;
                            final _cls2 b;

                            public void run()
                            {
                                String s;
                                if (a.a() != com.cyberlink.youcammakeup.masteraccess.Exporter.Error.JavaError.a)
                                {
                                    if (a.a() == com.cyberlink.youcammakeup.masteraccess.Exporter.Error.JavaError.j)
                                    {
                                        s = (new StringBuilder()).append("").append(Globals.d().getApplicationContext().getString(0x7f070060)).toString();
                                    } else
                                    {
                                        s = (new StringBuilder()).append("").append(a.a().name()).toString();
                                    }
                                } else
                                {
                                    s = (new StringBuilder()).append("").append(a.b().toString()).toString();
                                }
                                if (com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar.a(b.e.a) != null)
                                {
                                    com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar.a(b.e.a).cancel();
                                    com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar.a(b.e.a, null);
                                }
                                com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar.a(b.e.a, Toast.makeText(b.e.a.getActivity(), s, 1));
                                com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar.a(b.e.a).show();
                                b.c.i();
                                b.e.a.a(Boolean.valueOf(false));
                            }

            
            {
                b = _pcls2;
                a = error;
                super();
            }
                        });
                    }

                    public void a(com.cyberlink.youcammakeup.masteraccess.b b1)
                    {
                        e.a.getActivity().runOnUiThread(new Runnable(this, b1) {

                            final com.cyberlink.youcammakeup.masteraccess.b a;
                            final _cls2 b;

                            public void run()
                            {
                                b.a.a(a.a());
                                com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e.a().a(b.b);
                                b.c.i();
                                b.d.a(a.a());
                                View view = b.e.a.getActivity().findViewById(0x7f0c00ea);
                                view.setVisibility(0);
                                view.postDelayed(new Runnable(this, view) {

                                    final View a;
                                    final _cls1 b;

                                    public void run()
                                    {
                                        a.setVisibility(8);
                                        ((BaseActivity)b.b.e.a.getActivity()).a(new Runnable(this) {

                                            final _cls1 a;

                                            public void run()
                                            {
                                                FragmentManager fragmentmanager = a.b.b.e.a.getFragmentManager();
                                                com.cyberlink.youcammakeup.utility.o.a(fragmentmanager, a.b.b.d, "SharePageDialog");
                                                fragmentmanager.executePendingTransactions();
                                            }

            
            {
                a = _pcls1;
                super();
            }
                                        });
                                    }

            
            {
                b = _pcls1;
                a = view;
                super();
            }
                                }, 500L);
                                b.e.a.a(Boolean.valueOf(false));
                            }

            
            {
                b = _pcls2;
                a = b1;
                super();
            }
                        });
                    }

            
            {
                e = _pcls1;
                a = globals;
                b = l1;
                c = baseactivity;
                d = ag;
                super();
            }
                };
                if (com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(l1))
                {
                    if (l1 == -7L)
                    {
                        globals.r().a(UIImageOrientation.b, view, true, ((c) (obj)));
                        return;
                    } else
                    {
                        globals.r().a(UIImageOrientation.b, view, false, ((c) (obj)));
                        return;
                    }
                } else
                {
                    globals.r().a(l1, false, ((c) (obj)));
                    return;
                }
            }

            
            {
                a = TopToolBar.this;
                super();
            }
        };
        o = new android.view.View.OnClickListener() {

            final TopToolBar a;

            public void onClick(View view)
            {
                view = Globals.d().t();
                if (view != null)
                {
                    view.d(false);
                }
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(YMKSavingPageEvent.b, System.currentTimeMillis(), com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.a, false, false));
                break MISSING_BLOCK_LABEL_37;
label0:
                while (true) 
                {
                    do
                    {
                        do
                        {
                            return;
                        } while (!StatusManager.j().E().booleanValue() || Globals.d().i().a());
                        a.a(Boolean.valueOf(true));
                        if (StatusManager.j().r() != MakeupMode.a)
                        {
                            continue;
                        }
                        view = Globals.d().t();
                        if (StatusManager.j().o() == "editView" && view != null)
                        {
                            view.a(new f(this) {

                                final _cls2 a;

                                public void a()
                                {
                                    a.a.a(Boolean.valueOf(false));
                                }

            
            {
                a = _pcls2;
                super();
            }
                            });
                            return;
                        }
                        continue label0;
                    } while (a.b() || com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar.b(a));
                    view = Globals.d().t();
                    if (StatusManager.j().o() == "editView" && view != null)
                    {
                        view.I();
                        a.a(Boolean.valueOf(false));
                        return;
                    }
                }
            }

            
            {
                a = TopToolBar.this;
                super();
            }
        };
        p = new android.view.View.OnClickListener() {

            final TopToolBar a;

            public void onClick(View view)
            {
                if (!StatusManager.j().E().booleanValue())
                {
                    return;
                }
                a.a(Boolean.valueOf(true));
                if (com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar.c(a) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar.c(a).b();
                    if (StatusManager.j().o().equals("editView"))
                    {
                        com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar.a(a, null);
                    }
                }
                a.b();
            }

            
            {
                a = TopToolBar.this;
                super();
            }
        };
        q = new android.view.View.OnClickListener() {

            final TopToolBar a;

            public void onClick(View view)
            {
                if (!StatusManager.j().E().booleanValue())
                {
                    return;
                } else
                {
                    StatusManager.j().a(Boolean.valueOf(false));
                    view = new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/MoreActivity);
                    a.startActivity(view);
                    return;
                }
            }

            
            {
                a = TopToolBar.this;
                super();
            }
        };
    }

    static Toast a(TopToolBar toptoolbar)
    {
        return toptoolbar.k;
    }

    static Toast a(TopToolBar toptoolbar, Toast toast)
    {
        toptoolbar.k = toast;
        return toast;
    }

    static a a(TopToolBar toptoolbar, a a1)
    {
        toptoolbar.i = a1;
        return a1;
    }

    private void a(View view)
    {
        if (view.isPressed())
        {
            view.setPressed(false);
        }
    }

    private static int b(boolean flag)
    {
        return !flag ? 4 : 0;
    }

    static boolean b(TopToolBar toptoolbar)
    {
        return toptoolbar.m;
    }

    static a c(TopToolBar toptoolbar)
    {
        return toptoolbar.i;
    }

    private void c(boolean flag)
    {
        if (l)
        {
            return;
        }
        if (!flag)
        {
            a(b);
            a(d);
            a(f);
            a(e);
            a(g);
        }
        e.setClickable(flag);
        b.setClickable(flag);
        d.setClickable(flag);
        f.setClickable(flag);
        g.setClickable(flag);
    }

    private void e()
    {
        b = a.findViewById(0x7f0c0752);
        c = (TextView)a.findViewById(0x7f0c05bf);
        d = a.findViewById(0x7f0c0749);
        e = a.findViewById(0x7f0c074a);
        f = a.findViewById(0x7f0c074b);
        g = a.findViewById(0x7f0c0750);
        h = a.findViewById(0x7f0c074f);
        j = a.findViewById(0x7f0c0751);
        StatusManager.j().y();
        f();
    }

    private void f()
    {
        float f1;
        Object obj;
        String s;
        obj = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        f1 = (float)((DisplayMetrics) (obj)).widthPixels / ((DisplayMetrics) (obj)).density;
        obj = null;
        s = Locale.getDefault().getLanguage().split("_")[0];
        if (!s.equals("es")) goto _L2; else goto _L1
_L1:
        obj = Integer.valueOf(16);
_L4:
        if (obj != null)
        {
            c.setTextSize(1, (int)(((float)((Integer) (obj)).intValue() * f1) / 360F));
        }
        return;
_L2:
        if (s.equals("it"))
        {
            obj = Integer.valueOf(14);
        } else
        if (s.equals("fr"))
        {
            obj = Integer.valueOf(15);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void g()
    {
        b.setOnClickListener(n);
        d.setOnClickListener(o);
        e.setOnClickListener(o);
        f.setOnClickListener(p);
        g.setOnClickListener(q);
        StatusManager.j().a(this);
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.a(this);
        }
    }

    private void h()
    {
        b.setOnClickListener(null);
        d.setOnClickListener(null);
        e.setOnClickListener(null);
        f.setOnClickListener(null);
        g.setOnClickListener(null);
        StatusManager.j().b(this);
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.b(this);
        }
    }

    private void i()
    {
        boolean flag = af.a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.a);
        if (j != null)
        {
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            j.setVisibility(i1);
        }
    }

    public void a()
    {
        if (f.isEnabled())
        {
            p.onClick(null);
            return;
        } else
        {
            b();
            return;
        }
    }

    public void a(int i1)
    {
        a.setVisibility(i1);
    }

    public void a(a a1)
    {
        i = a1;
    }

    public void a(l l1)
    {
        if (l1 != null)
        {
            int i1 = b(l1.a);
            int j1;
            boolean flag;
            if (!l1.a)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            j1 = b(flag);
            d.setVisibility(j1);
            b.setVisibility(j1);
            e.setVisibility(i1);
            f.setVisibility(i1);
            c.setText(l1.c);
            h.setVisibility(8);
            if (l1.a)
            {
                f();
                return;
            }
        }
    }

    public void a(Boolean boolean1)
    {
        boolean flag1 = true;
        StatusManager statusmanager = StatusManager.j();
        boolean flag;
        if (!boolean1.booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        statusmanager.a(Boolean.valueOf(flag));
        if (!boolean1.booleanValue())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        c(flag);
    }

    public void a(String s)
    {
        if (c == null)
        {
            return;
        } else
        {
            c.setText(s);
            return;
        }
    }

    public void a(String s, Boolean boolean1)
    {
        if (s.equals("Apply") && f != null)
        {
            f.setEnabled(boolean1.booleanValue());
        }
    }

    public void a(boolean flag)
    {
        l = flag;
    }

    public boolean b()
    {
        boolean flag = true;
        EditViewActivity editviewactivity = Globals.d().t();
        if (editviewactivity == null)
        {
            flag = false;
        } else
        if (!editviewactivity.G())
        {
            if (i != null)
            {
                i.c();
                return true;
            } else
            {
                return false;
            }
        }
        return flag;
    }

    public boolean c()
    {
        return !d.isClickable();
    }

    public void d()
    {
        if (d != null)
        {
            d.performClick();
        }
    }

    public void g(boolean flag)
    {
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c(flag);
    }

    public void l()
    {
        af.a(Globals.d().t(), j, com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.a);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        e();
        g();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f0301a0, viewgroup, false);
        return a;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        h();
        i = null;
    }

    public void onResume()
    {
        super.onResume();
        i();
    }
}
