// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.a;
import com.cyberlink.youcammakeup.activity.LauncherActivity;
import com.cyberlink.youcammakeup.b.h;
import com.cyberlink.youcammakeup.b.j;
import com.cyberlink.youcammakeup.clflurry.UInstallTrackEvent;
import com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent;
import com.cyberlink.youcammakeup.clflurry.YMKShareToEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.shareview.ShareItemAdapter;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.bc;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ae, ag

public class ai extends a
{

    public static final UUID a = UUID.randomUUID();
    private android.content.DialogInterface.OnKeyListener A = new android.content.DialogInterface.OnKeyListener() {

        final ai a;

        public boolean onKey(DialogInterface dialoginterface, int i1, KeyEvent keyevent)
        {
            if (!ai.f(a).isEnabled())
            {
                return true;
            }
            if (i1 == 4 && keyevent.getAction() == 1)
            {
                ai.f(a).performClick();
                return true;
            } else
            {
                return false;
            }
        }

            
            {
                a = ai.this;
                super();
            }
    };
    private FrameLayout b;
    private View c;
    private View d;
    private View e;
    private View f;
    private ListView g;
    private View h;
    private View i;
    private TextView j;
    private View k;
    private BlockingQueue l;
    private TextView m;
    private ShareItemAdapter n;
    private ae o;
    private String p;
    private String q;
    private Uri r;
    private Handler s;
    private boolean t;
    private h u;
    private com.cyberlink.youcammakeup.a.a v;
    private boolean w;
    private android.view.View.OnClickListener x = new android.view.View.OnClickListener() {

        final ai a;

        public void onClick(View view)
        {
            (new AsyncTask(this) {

                final _cls3 a;

                protected transient Void a(Void avoid[])
                {
                    try
                    {
                        if (ai.c(a.a) == null)
                        {
                            ai.d(a.a).take();
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        avoid.printStackTrace();
                    }
                    return null;
                }

                protected void a(Void void1)
                {
                    a.a.dismissAllowingStateLoss();
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((Void)obj);
                }

                protected void onPreExecute()
                {
                    com.cyberlink.youcammakeup.widgetpool.dialogs.ai.a(a.a, false);
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKAfterSavePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.g));
                }

            
            {
                a = _pcls3;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

            
            {
                a = ai.this;
                super();
            }
    };
    private android.view.View.OnClickListener y = new android.view.View.OnClickListener() {

        final ai a;

        public void onClick(View view)
        {
            (new AsyncTask(this) {

                final _cls4 a;

                protected transient Void a(Void avoid[])
                {
                    try
                    {
                        if (ai.c(a.a) == null)
                        {
                            ai.d(a.a).take();
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        avoid.printStackTrace();
                    }
                    return null;
                }

                protected void a(Void void1)
                {
                    void1 = (new Intent(a.a.getActivity(), com/cyberlink/youcammakeup/activity/LauncherActivity)).setFlags(0x4000000);
                    a.a.startActivity(void1);
                    a.a.getActivity().finish();
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((Void)obj);
                }

                protected void onPreExecute()
                {
                    com.cyberlink.youcammakeup.widgetpool.dialogs.ai.a(a.a, false);
                    com.cyberlink.youcammakeup.clflurry.b.a(new YMKAfterSavePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.f));
                }

            
            {
                a = _pcls4;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

            
            {
                a = ai.this;
                super();
            }
    };
    private android.widget.AdapterView.OnItemClickListener z = new android.widget.AdapterView.OnItemClickListener() {

        final ai a;

        public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
        {
            adapterview = new AsyncTask(this, view, i1) {

                final View a;
                final int b;
                final _cls5 c;

                protected transient ArrayList a(Void avoid[])
                {
                    avoid = new ArrayList(1);
                    try
                    {
                        avoid.add(ai.d(c.a).take());
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                        return avoid;
                    }
                    return avoid;
                }

                protected void a(ArrayList arraylist)
                {
                    ai.e(c.a).a(b, arraylist);
                    com.cyberlink.youcammakeup.widgetpool.dialogs.ai.a(c.a, true);
                    com.cyberlink.youcammakeup.widgetpool.dialogs.ai.b(c.a);
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((ArrayList)obj);
                }

                protected void onPreExecute()
                {
                    a.setPressed(true);
                    com.cyberlink.youcammakeup.widgetpool.dialogs.ai.a(c.a, false);
                }

            
            {
                c = _pcls5;
                a = view;
                b = i1;
                super();
            }
            };
            if (ai.c(a) != null)
            {
                ai.c(a).a(new ag(this, adapterview) {

                    final AsyncTask a;
                    final _cls5 b;

                    public void a(Uri uri)
                    {
                        b.a.a(uri);
                        a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    }

            
            {
                b = _pcls5;
                a = asynctask;
                super();
            }
                });
                return;
            } else
            {
                adapterview.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
        }

            
            {
                a = ai.this;
                super();
            }
    };

    public ai(ShareItemAdapter shareitemadapter)
    {
        v = null;
        w = false;
        n = shareitemadapter;
    }

    public ai(ShareItemAdapter shareitemadapter, ae ae)
    {
        v = null;
        w = false;
        n = shareitemadapter;
        o = ae;
    }

    static View a(ai ai1)
    {
        return ai1.k;
    }

    static void a(ai ai1, boolean flag)
    {
        ai1.a(flag);
    }

    private void a(boolean flag)
    {
        e.setEnabled(flag);
        g.setEnabled(flag);
    }

    private void b()
    {
        if (Globals.d().f().a().booleanValue() && isResumed() && v != null)
        {
            v.e();
            v.b();
        }
    }

    static void b(ai ai1)
    {
        ai1.e();
    }

    static ae c(ai ai1)
    {
        return ai1.o;
    }

    private void c()
    {
        v = new com.cyberlink.youcammakeup.a.a();
        v.a(getActivity(), com.cyberlink.youcammakeup.flurry.ClickAdsEvent.SourceName.a);
        v.a(b, c, getActivity());
        v.a(b);
        v.b(c);
    }

    static BlockingQueue d(ai ai1)
    {
        return ai1.l;
    }

    private void d()
    {
        if (n == null)
        {
            n = new ShareItemAdapter(getActivity());
        }
        g.setAdapter(n);
    }

    static ShareItemAdapter e(ai ai1)
    {
        return ai1.n;
    }

    private void e()
    {
        if (r == null)
        {
            return;
        }
        f.setVisibility(8);
        if (q != null)
        {
            h.setVisibility(0);
        }
        if (!l.isEmpty())
        {
            l.clear();
        }
        l.add(r);
    }

    static View f(ai ai1)
    {
        return ai1.e;
    }

    public void a(Uri uri)
    {
        r = uri;
        if (!t)
        {
            return;
        } else
        {
            s.post(new Runnable() {

                final ai a;

                public void run()
                {
                    com.cyberlink.youcammakeup.widgetpool.dialogs.ai.b(a);
                }

            
            {
                a = ai.this;
                super();
            }
            });
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        e = d.findViewById(0x7f0c06e6);
        f = d.findViewById(0x7f0c01b3);
        g = (ListView)d.findViewById(0x7f0c06f0);
        h = d.findViewById(0x7f0c06e8);
        m = (TextView)d.findViewById(0x7f0c06e9);
        i = d.findViewById(0x7f0c06ea);
        j = (TextView)d.findViewById(0x7f0c06eb);
        k = d.findViewById(0x7f0c06ec);
        e.setOnClickListener(x);
        g.setOnItemClickListener(z);
        getDialog().setOnKeyListener(A);
        p = getArguments().getString("BUNDLE_KEY_TITLE");
        q = getArguments().getString("BUNDLE_KEY_MESSAGE");
        r = (Uri)getArguments().getParcelable("BUNDLE_KEY_URI");
        l = new LinkedBlockingQueue(1);
        s = new Handler();
        t = false;
        if (p == null) goto _L2; else goto _L1
_L1:
        h.setVisibility(8);
_L4:
        w = getArguments().getBoolean("IS_DELAY_LOAD_AD");
        if (Globals.d().f().a().booleanValue())
        {
            b = (FrameLayout)d.findViewById(0x7f0c06e7);
            c = d.findViewById(0x7f0c06f1);
            if (!w)
            {
                c();
            }
        }
        return;
_L2:
        if (q != null)
        {
            h.setVisibility(4);
            bundle = getResources().getString(0x7f07037a);
            bundle = (new StringBuilder()).append(String.format(bundle, new Object[] {
                "YouCam Makeup"
            })).append(" ").append(getResources().getString(0x7f0703a7)).toString();
            m.setText(bundle);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        d = layoutinflater.inflate(0x7f030193, viewgroup);
        return d;
    }

    public void onDestroyView()
    {
        if (Globals.d().f().a().booleanValue() && v != null)
        {
            v.c(b);
            v.d(c);
            v.d();
            v.a();
            v = null;
        }
        super.onDestroyView();
    }

    public void onPause()
    {
        if (Globals.d().f().a().booleanValue() && v != null)
        {
            v.c();
        }
        if (u != null)
        {
            u.k();
        }
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        d();
        a(true);
        String s1 = com.cyberlink.youcammakeup.kernelctrl.z.f();
        boolean flag;
        if (!s1.isEmpty())
        {
            if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.UInstallTrackEvent.STATUS.a.toString()))
            {
                if (al.a("com.cyberlink.U"))
                {
                    com.cyberlink.youcammakeup.kernelctrl.z.a(com.cyberlink.youcammakeup.clflurry.UInstallTrackEvent.STATUS.b);
                    com.cyberlink.youcammakeup.clflurry.b.a(new UInstallTrackEvent(com.cyberlink.youcammakeup.clflurry.UInstallTrackEvent.STATUS.b));
                }
            } else
            if (s1.equalsIgnoreCase(com.cyberlink.youcammakeup.clflurry.UInstallTrackEvent.STATUS.b.toString()) && !al.a("com.cyberlink.U"))
            {
                com.cyberlink.youcammakeup.kernelctrl.z.a(com.cyberlink.youcammakeup.clflurry.UInstallTrackEvent.STATUS.c);
                com.cyberlink.youcammakeup.clflurry.b.a(new UInstallTrackEvent(com.cyberlink.youcammakeup.clflurry.UInstallTrackEvent.STATUS.c));
            }
        }
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKShareToEvent(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Operation.a, null));
        b();
        flag = al.a("com.cyberlink.U");
        if (u != null)
        {
            u.n();
            u = null;
        }
        if (Globals.d().c().b() && !flag)
        {
            i.setVisibility(8);
            k.setVisibility(8);
        } else
        {
            i.setVisibility(8);
            k.setVisibility(8);
        }
        u = new h(getActivity(), k, j);
        u.a();
        u.j();
        u.a(new j() {

            final ai a;

            public void a()
            {
                com.cyberlink.youcammakeup.widgetpool.dialogs.ai.a(a).setVisibility(0);
            }

            
            {
                a = ai.this;
                super();
            }
        });
        t = true;
        if (o != null)
        {
            f.setVisibility(8);
            return;
        } else
        {
            e();
            return;
        }
    }

}
