// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.camera.ag;
import com.cyberlink.youcammakeup.clflurry.YMKEditStayTimeEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.ar;
import com.cyberlink.youcammakeup.flurry.RateOfFeaturePointAdjustment;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.cyberlink.youcammakeup.masteraccess.b;
import com.cyberlink.youcammakeup.masteraccess.c;
import com.cyberlink.youcammakeup.setting.PhotoQuality;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.ca;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ak;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            TopToolBar

class d
    implements c
{

    final Globals a;
    final long b;
    final BaseActivity c;
    final ag d;
    final e e;

    public void a()
    {
        e.e.a(Boolean.valueOf(false));
    }

    public void a(com.cyberlink.youcammakeup.masteraccess.r._cls1._cls2 _pcls2)
    {
        e.e.getActivity().runOnUiThread(new Runnable(_pcls2) {

            final com.cyberlink.youcammakeup.masteraccess.Exporter.Error a;
            final TopToolBar._cls1._cls2 b;

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
                b = TopToolBar._cls1._cls2.this;
                a = error;
                super();
            }
        });
    }

    public void a(b b1)
    {
        e.e.getActivity().runOnUiThread(new Runnable(b1) {

            final b a;
            final TopToolBar._cls1._cls2 b;

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
                                o.a(fragmentmanager, a.b.b.d, "SharePageDialog");
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
                b = TopToolBar._cls1._cls2.this;
                a = b1;
                super();
            }
        });
    }

    a(a a1, Globals globals, long l, BaseActivity baseactivity, ag ag)
    {
        e = a1;
        a = globals;
        b = l;
        c = baseactivity;
        d = ag;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/TopToolBar$1

/* anonymous class */
    class TopToolBar._cls1
        implements android.view.View.OnClickListener
    {

        final TopToolBar a;

        public void onClick(View view)
        {
            if (!StatusManager.j().E().booleanValue())
            {
                return;
            }
            long l = System.currentTimeMillis();
            Object obj;
            Globals globals;
            BaseActivity baseactivity;
            boolean flag;
            if (YMKSavingPageEvent.g().equals(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Source.a.a()))
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(YMKSavingPageEvent.b, l, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.b, true, true));
            } else
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(YMKSavingPageEvent.b, l, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.b, true, false));
            }
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(YMKSavingPageEvent.b, l, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.e, false, false));
            view = ca.b().a("%d");
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKEditStayTimeEvent(com.cyberlink.youcammakeup.clflurry.YMKEditStayTimeEvent.Button.b, view));
            com.cyberlink.youcammakeup.flurry.a.a(new com.cyberlink.youcammakeup.flurry.YMKEditStayTimeEvent(com.cyberlink.youcammakeup.flurry.YMKEditStayTimeEvent.Button.b, view));
            com.cyberlink.youcammakeup.flurry.a.a(new RateOfFeaturePointAdjustment());
            if (PhotoQuality.a(StatusManager.j().l()))
            {
                (new com.cyberlink.youcammakeup.kernelctrl.ag(Globals.d().getApplicationContext())).f();
            }
            view = new Bundle();
            flag = PhotoQuality.a(StatusManager.j().l());
            view.putString("BUNDLE_KEY_MESSAGE", ak.a);
            view.putBoolean("IS_DELAY_LOAD_AD", flag);
            obj = new ag();
            ((ag) (obj)).a(new TopToolBar._cls1._cls1());
            ((ag) (obj)).setArguments(view);
            ((ag) (obj)).c();
            a.a(Boolean.valueOf(true));
            globals = Globals.d();
            baseactivity = (BaseActivity)a.getActivity();
            baseactivity.a(MakeupMode.g);
            l = StatusManager.j().l();
            view = StatusManager.j().d();
            if (view != null)
            {
                view.a(new ar());
            }
            if (com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(l))
            {
                view = ViewEngine.a().a(l, 1.0D, null);
            } else
            {
                view = null;
            }
            obj = new TopToolBar._cls1._cls2(this, globals, l, baseactivity, ((ag) (obj)));
            if (com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(l))
            {
                if (l == -7L)
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
                globals.r().a(l, false, ((c) (obj)));
                return;
            }
        }

            
            {
                a = toptoolbar;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/TopToolBar$1$1

/* anonymous class */
        class TopToolBar._cls1._cls1
            implements android.content.DialogInterface.OnDismissListener
        {

            final TopToolBar._cls1 a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                ca.b().a();
                YMKSavingPageEvent.b = System.currentTimeMillis();
            }

                    
                    {
                        a = TopToolBar._cls1.this;
                        super();
                    }
        }

    }

}
