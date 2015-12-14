// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.h;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.i;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.view.widgetpool.common.ObservableScrollView;
import com.cyberlink.uma.g;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.u;
import com.perfectcorp.utility.x;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            f, BottomBarFragment

public class k extends f
{

    ObservableScrollView g;
    private android.view.View.OnClickListener h;
    private android.view.View.OnClickListener i;
    private android.view.View.OnClickListener j;
    private android.view.View.OnClickListener k;
    private android.view.View.OnClickListener l;
    private android.view.View.OnClickListener m;
    private android.view.View.OnClickListener n;
    private android.view.View.OnClickListener o;
    private android.view.View.OnClickListener p;

    public k()
    {
        g = null;
        h = new android.view.View.OnClickListener() {

            final k a;

            public void onClick(View view)
            {
                Globals.a("OnClick");
                (new AsyncTask(this) {

                    final _cls11 a;

                    protected transient String a(Void avoid[])
                    {
                        Globals.a("doInBackground");
                        return k.a(a.a.getActivity());
                    }

                    protected void a(String s)
                    {
                        Globals.a("onPostExecute");
                        Object obj = a.a.getActivity();
                        if (obj != null && s != null)
                        {
                            obj = new android.app.AlertDialog.Builder(((android.content.Context) (obj)));
                            if (s != null)
                            {
                                ((android.app.AlertDialog.Builder) (obj)).setMessage(Html.fromHtml(s));
                            }
                            ((android.app.AlertDialog.Builder) (obj)).setPositiveButton("Ok", null);
                            s = ((android.app.AlertDialog.Builder) (obj)).show();
                            ((TextView)s.findViewById(0x102000b)).setTextSize(Globals.b(h.t5dp));
                            Globals.a(s, a.a.getResources().getColor(com.cyberlink.beautycircle.g.bc_color_main_style));
                        }
                    }

                    protected Object doInBackground(Object aobj[])
                    {
                        return a((Void[])aobj);
                    }

                    protected void onPostExecute(Object obj)
                    {
                        a((String)obj);
                    }

            
            {
                a = _pcls11;
                super();
            }
                }).executeOnExecutor(com.perfectcorp.utility.j.q, new Void[0]);
            }

            
            {
                a = k.this;
                super();
            }
        };
        i = new android.view.View.OnClickListener() {

            final k a;

            public void onClick(View view)
            {
                view = a.getActivity();
                if (view instanceof MainActivity)
                {
                    ((MainActivity)view).v();
                }
            }

            
            {
                a = k.this;
                super();
            }
        };
        j = new android.view.View.OnClickListener() {

            final k a;

            public void onClick(View view)
            {
                c.g(a.getActivity());
            }

            
            {
                a = k.this;
                super();
            }
        };
        k = new android.view.View.OnClickListener() {

            final k a;

            public void onClick(View view)
            {
                c.f(a.getActivity());
            }

            
            {
                a = k.this;
                super();
            }
        };
        l = new android.view.View.OnClickListener() {

            final k a;

            public void onClick(View view)
            {
                c.e(a.getActivity());
            }

            
            {
                a = k.this;
                super();
            }
        };
        m = new android.view.View.OnClickListener() {

            final k a;

            public void onClick(View view)
            {
                int i1 = 1;
                if (!Globals.d())
                {
                    i1 = 0;
                }
                view = (new android.app.AlertDialog.Builder(a.getActivity())).setTitle("Set Dominant Color Mode").setSingleChoiceItems(new String[] {
                    "Normal", "Dominant Color"
                }, i1, null).setPositiveButton(m.bc_dialog_button_yes, new android.content.DialogInterface.OnClickListener(this) {

                    final _cls3 a;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                        dialoginterface.dismiss();
                        boolean flag;
                        if (((AlertDialog)dialoginterface).getListView().getCheckedItemPosition() == 0)
                        {
                            flag = false;
                        } else
                        {
                            flag = true;
                        }
                        Globals.b(flag);
                    }

            
            {
                a = _pcls3;
                super();
            }
                }).setNegativeButton(m.bc_dialog_button_no, null).create();
                view.show();
                Globals.a(view, a.getResources().getColor(com.cyberlink.beautycircle.g.bc_color_main_style));
            }

            
            {
                a = k.this;
                super();
            }
        };
        n = new android.view.View.OnClickListener() {

            final k a;

            public void onClick(View view)
            {
                (new com.perfectcorp.utility.j(this) {

                    final _cls4 a;

                    protected volatile Object a(Object obj)
                    {
                        return a((Void)obj);
                    }

                    protected String a(Void void1)
                    {
                        return e.b(true);
                    }

            
            {
                a = _pcls4;
                super();
            }
                }).d(null).a(new com.perfectcorp.utility.m(this) {

                    final _cls4 a;

                    protected void a(String s)
                    {
                        if (s == null)
                        {
                            Globals.b("Dump logcat failed");
                            return;
                        } else
                        {
                            Globals.b((new StringBuilder()).append("Dump logcat to '").append(s).append("'").toString());
                            return;
                        }
                    }

                    protected void b(Object obj)
                    {
                        a((String)obj);
                    }

            
            {
                a = _pcls4;
                super();
            }
                });
            }

            
            {
                a = k.this;
                super();
            }
        };
        o = new android.view.View.OnClickListener() {

            final k a;

            public void onClick(View view)
            {
                if (Globals.c() == "PRODUCTION")
                {
                    Globals.b("Auto post only allow on Demo server.");
                    return;
                } else
                {
                    c.c(a.getActivity());
                    return;
                }
            }

            
            {
                a = k.this;
                super();
            }
        };
        p = new android.view.View.OnClickListener() {

            final k a;

            public void onClick(View view)
            {
                c.a(a.getActivity(), true, null, true);
            }

            
            {
                a = k.this;
                super();
            }
        };
    }

    public static int a()
    {
        EGL10 egl10 = (EGL10)EGLContext.getEGL();
        javax.microedition.khronos.egl.EGLDisplay egldisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(egldisplay, new int[2]);
        int ai[] = new int[1];
        egl10.eglGetConfigs(egldisplay, null, 0, ai);
        EGLConfig aeglconfig[] = new EGLConfig[ai[0]];
        egl10.eglGetConfigs(egldisplay, aeglconfig, ai[0], ai);
        int ai1[] = new int[1];
        int i1 = 0;
        int j1;
        int k1;
        for (j1 = 0; i1 < ai[0]; j1 = k1)
        {
            egl10.eglGetConfigAttrib(egldisplay, aeglconfig[i1], 12332, ai1);
            k1 = j1;
            if (j1 < ai1[0])
            {
                k1 = ai1[0];
            }
            i1++;
        }

        egl10.eglTerminate(egldisplay);
        return j1;
    }

    public static String a(Activity activity)
    {
        boolean flag = false;
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        ArrayList arraylist = new ArrayList();
        String s = AccountManager.b();
        Object obj1 = AccountManager.d();
        String s1 = AccountManager.g();
        if (obj1 != null)
        {
            arraylist1.add(String.format(Locale.getDefault(), "- Login: %d", new Object[] {
                Long.valueOf(((UserInfo) (obj1)).id)
            }));
            Locale locale = Locale.getDefault();
            float f1;
            Object obj;
            int i1;
            if (((UserInfo) (obj1)).displayName == null)
            {
                obj = "[null]";
            } else
            {
                obj = ((UserInfo) (obj1)).displayName;
            }
            arraylist1.add(String.format(locale, "- Name: %s", new Object[] {
                obj
            }));
            locale = Locale.getDefault();
            if (((UserInfo) (obj1)).region == null)
            {
                obj = "[null]";
            } else
            {
                obj = ((UserInfo) (obj1)).region;
            }
            arraylist1.add(String.format(locale, "- Region: %s", new Object[] {
                obj
            }));
            obj1 = Locale.getDefault();
            if (s1 == null)
            {
                obj = "[null]";
            } else
            {
                obj = s1;
            }
            arraylist1.add(String.format(((Locale) (obj1)), "- Source: %s", new Object[] {
                obj
            }));
            arraylist1.add(String.format(Locale.getDefault(), "- Version: %s", new Object[] {
                activity.getResources().getString(m.BC_BUILD_NUMBER)
            }));
        } else
        {
            arraylist1.add("- Logout");
        }
        arraylist2.add(String.format(Locale.getDefault(), "- UMA UUID: %s", new Object[] {
            Globals.w()
        }));
        arraylist2.add(String.format(Locale.getDefault(), "- Android: %s (SDK %d)", new Object[] {
            android.os.Build.VERSION.RELEASE, Integer.valueOf(android.os.Build.VERSION.SDK_INT)
        }));
        arraylist2.add(String.format(Locale.getDefault(), "- Model: %s", new Object[] {
            Globals.x()
        }));
        arraylist2.add(String.format(Locale.getDefault(), "- Vender: %s", new Object[] {
            Globals.y()
        }));
        arraylist2.add(String.format(Locale.getDefault(), "- CPU: %s", new Object[] {
            Globals.z()
        }));
        i1 = a();
        arraylist2.add(String.format(Locale.getDefault(), "- OpenGL: %d x %d", new Object[] {
            Integer.valueOf(i1), Integer.valueOf(i1)
        }));
        arraylist2.add(String.format(Locale.getDefault(), "- TotalRAM: %,d MB", new Object[] {
            Integer.valueOf(Globals.o().intValue() / 1024)
        }));
        if (activity != null)
        {
            obj = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
            arraylist2.add(String.format(Locale.getDefault(), "- ScreenRes: %dx%d", new Object[] {
                Integer.valueOf(((DisplayMetrics) (obj)).heightPixels), Integer.valueOf(((DisplayMetrics) (obj)).widthPixels)
            }));
            f1 = activity.getResources().getDisplayMetrics().density;
            arraylist2.add(String.format(Locale.getDefault(), "- ScreenDensity: %.2f", new Object[] {
                Float.valueOf(f1)
            }));
            arraylist2.add(String.format(Locale.getDefault(), "- ScreenDpi: %s", new Object[] {
                Globals.a(activity)
            }));
            arraylist2.add(String.format(Locale.getDefault(), "- LogicalWidth: w%ddp", new Object[] {
                Integer.valueOf((int)((float)((DisplayMetrics) (obj)).widthPixels / f1))
            }));
            arraylist2.add(String.format(Locale.getDefault(), "- UsingWidth: w%ddp", new Object[] {
                Integer.valueOf((int)((float)Globals.b(h.f360dp) / f1))
            }));
        }
        arraylist2.add(String.format(Locale.getDefault(), "- SystemCountry: %s", new Object[] {
            Locale.getDefault().toString()
        }));
        arraylist.add(String.format(Locale.getDefault(), "- ServerType: %s", new Object[] {
            Globals.c()
        }));
        arraylist.add(String.format(Locale.getDefault(), "- ServerUrl: %s", new Object[] {
            com.cyberlink.beautycircle.model.network.i.a(Globals.c())
        }));
        arraylist.add(String.format(Locale.getDefault(), "- CurrentConnectionCount: %d", new Object[] {
            Long.valueOf(u.i.a)
        }));
        obj = Locale.getDefault();
        if (s == null)
        {
            activity = "[null]";
        } else
        {
            activity = s;
        }
        arraylist.add(String.format(((Locale) (obj)), "- Token: %s", new Object[] {
            activity
        }));
        activity = (new StringBuilder()).append("<br>").append("<b>Device Info</b><br>").toString();
        for (i1 = 0; i1 < arraylist2.size(); i1++)
        {
            activity = (new StringBuilder()).append(activity).append((String)arraylist2.get(i1)).append("<br>").toString();
        }

        activity = (new StringBuilder()).append(activity).append("<br>").toString();
        activity = (new StringBuilder()).append(activity).append("<b>User Info</b><br>").toString();
        for (int j1 = 0; j1 < arraylist1.size(); j1++)
        {
            activity = (new StringBuilder()).append(activity).append((String)arraylist1.get(j1)).append("<br>").toString();
        }

        activity = (new StringBuilder()).append(activity).append("<br>").toString();
        activity = (new StringBuilder()).append(activity).append("<b>Server Info</b><br>").toString();
        for (int k1 = ((flag) ? 1 : 0); k1 < arraylist.size(); k1++)
        {
            activity = (new StringBuilder()).append(activity).append((String)arraylist.get(k1)).append("<br>").toString();
        }

        return (new StringBuilder()).append(activity).append("<br>").toString();
    }

    private void a(ObservableScrollView observablescrollview)
    {
        View view = observablescrollview.findViewById(j.developer_system_info);
        if (view != null)
        {
            view.setOnClickListener(h);
        }
        view = observablescrollview.findViewById(j.developer_server_switch);
        if (view != null)
        {
            view.setOnClickListener(i);
        }
        view = observablescrollview.findViewById(j.developer_history_web_request);
        if (view != null)
        {
            view.setOnClickListener(k);
        }
        view = observablescrollview.findViewById(j.developer_history_deeplink);
        if (view != null)
        {
            view.setOnClickListener(j);
        }
        view = observablescrollview.findViewById(j.develop_btn_todo_function_one);
        if (view != null)
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final k a;

                public void onClick(View view1)
                {
                    view1 = new com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackConfig();
                    view1.apiUri = "https://stage2.cyberlink.com/prog/support/app/feedback.jsp";
                    view1.product = "YouCam Perfect";
                    view1.version = "1.0";
                    view1.sr = "YCP201402-001";
                    view1.hwid = "42033dc0-1faa-4fb8-bb44-8c4cbd925d59";
                    view1.phoneid = "APA91bEg3sA71aEZZ93KqSYw1oeYcjSTJoE3TdSFdxwDBXS11Iwkgkrimha6RfHlu_1FhVWCIEbip1EdXZrzufS2RrGkJoHuIHcBQITAw7RoX8HHiXu8bAnxrRP8LdWjK7GXrM0opN9DreLN2nYAQaeg0hN7etOPcqQz8L5qqMqumvI5eras6U8";
                    view1.appversion = "1.4.0";
                    view1.versionUpgradeHistory = "1.0;2.0;3.0";
                    view1.umaid = com.cyberlink.uma.g.a(a.getActivity().getApplicationContext());
                    String s = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/cyberlink/ypf").append("/testserver.config").toString();
                    view1.attachmentPath = new ArrayList();
                    ((com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackConfig) (view1)).attachmentPath.add(s);
                    view1.bNeedLog = false;
                    c.a(a.getActivity(), view1, 2);
                }

            
            {
                a = k.this;
                super();
            }
            });
        }
        view = observablescrollview.findViewById(j.developer_Log);
        if (view != null)
        {
            view.setOnClickListener(l);
        }
        view = observablescrollview.findViewById(j.develop_btn_todo_function_second);
        if (view != null)
        {
            view.setOnClickListener(m);
        }
        view = observablescrollview.findViewById(j.develop_btn_logcat);
        if (view != null)
        {
            view.setOnClickListener(n);
        }
        view = observablescrollview.findViewById(j.develop_btn_auto_post);
        if (view != null)
        {
            view.setOnClickListener(o);
        }
        view = observablescrollview.findViewById(j.develop_btn_post_json);
        if (view != null)
        {
            view.setOnClickListener(p);
        }
        view = observablescrollview.findViewById(j.develop_btn_tutorial);
        if (view != null)
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final k a;

                public void onClick(View view1)
                {
                    c.d(a.getActivity());
                }

            
            {
                a = k.this;
                super();
            }
            });
        }
        view = observablescrollview.findViewById(j.develop_btn_consultation);
        if (view != null)
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final k a;

                public void onClick(View view1)
                {
                    c.a(a.getActivity(), Long.valueOf(0x248b74d93402814L), null, null);
                }

            
            {
                a = k.this;
                super();
            }
            });
        }
        view = observablescrollview.findViewById(j.develop_btn_deeplink);
        if (view != null)
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final k a;

                public void onClick(View view1)
                {
                    c.a(a.getActivity(), Uri.parse("https://dl.dropboxusercontent.com/u/19164442/BC_DeepLink.html"));
                }

            
            {
                a = k.this;
                super();
            }
            });
        }
        observablescrollview.findViewById(j.develop_btn_looks_parser).setOnClickListener(new android.view.View.OnClickListener() {

            final k a;
            private final String b[] = {
                "Feline", "Mime", "Masquerade", "Empress Wu", "Mustache"
            };
            private final String c[] = {
                "https://dl.dropboxusercontent.com/u/20081637/BC/Looks%20Sample/Art_thumb_1.zip", "https://dl.dropboxusercontent.com/u/20081637/BC/Looks%20Sample/Art_thumb_2.zip", "https://dl.dropboxusercontent.com/u/20081637/BC/Looks%20Sample/Art_thumb_3.zip", "https://dl.dropboxusercontent.com/u/20081637/BC/Looks%20Sample/Art_thumb_4.zip", "https://dl.dropboxusercontent.com/u/20081637/BC/Looks%20Sample/Art_thumb_5.zip"
            };
            private android.widget.AdapterView.OnItemClickListener d;

            static String[] a(_cls10 _pcls10)
            {
                return _pcls10.c;
            }

            public void onClick(View view1)
            {
                Object obj = a.getActivity();
                if (obj == null)
                {
                    return;
                } else
                {
                    view1 = new ArrayAdapter(((android.content.Context) (obj)), 0x1090011);
                    view1.addAll(b);
                    obj = new Dialog(((android.content.Context) (obj)));
                    ((Dialog) (obj)).setTitle("Select a look pageage:");
                    ((Dialog) (obj)).setContentView(0x1090014);
                    ListView listview = (ListView)((Dialog) (obj)).findViewById(0x102000a);
                    listview.setAdapter(view1);
                    listview.setOnItemClickListener(d);
                    ((Dialog) (obj)).show();
                    return;
                }
            }

            
            {
                a = k.this;
                super();
                d = new _cls1(this);
            }
        });
    }

    public void a(BottomBarFragment bottombarfragment)
    {
        if (bottombarfragment != null && g != null)
        {
            bottombarfragment.a(g, null, null);
        }
    }

    public void b(BottomBarFragment bottombarfragment)
    {
        if (bottombarfragment != null && g != null)
        {
            bottombarfragment.a(g, null);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        g = (ObservableScrollView)layoutinflater.inflate(com.cyberlink.beautycircle.k.bc_fragment_page_developer, viewgroup, false);
        a(g);
        b();
        return g;
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/k$10$1

/* anonymous class */
    class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final _cls10 a;

        public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
        {
            adapterview = (BaseActivity)a.a.getActivity();
            break MISSING_BLOCK_LABEL_14;
            if (adapterview != null && _cls10.a(a).length > i1)
            {
                view = e.a();
                if (view != null && !view.isEmpty())
                {
                    adapterview.k();
                    String s = _cls10.a(a)[i1];
                    (new com.cyberlink.beautycircle.model.network.k()).d(new u(s)).a(new com.perfectcorp.utility.j(this, view, s) {

                        final String a;
                        final String b;
                        final _cls1 c;

                        protected com.perfectcorp.utility.i a(byte abyte0[])
                        {
                            String s = com.perfectcorp.utility.h.a(new String[] {
                                a, "Looks", b.substring(b.lastIndexOf('/'))
                            });
                            com.perfectcorp.utility.h.a(abyte0, s);
                            return new com.perfectcorp.utility.i(s, s.substring(0, s.lastIndexOf('.')));
                        }

                        protected volatile Object a(Object obj)
                        {
                            return a((byte[])obj);
                        }

            
            {
                c = _pcls1;
                a = s;
                b = s1;
                super();
            }
                    }).a(com.perfectcorp.utility.h.b(Globals.n())).a(new com.perfectcorp.utility.m(this, adapterview) {

                        final BaseActivity a;
                        final _cls1 b;

                        protected void a()
                        {
                            a(0x80000005);
                        }

                        protected void a(int i1)
                        {
                            a.l();
                            DialogUtils.a(a, (new StringBuilder()).append("Unzip error: ").append(i1).toString());
                        }

                        protected void a(String s)
                        {
                            a.l();
                            c.d(a, s);
                        }

                        protected void b(Object obj)
                        {
                            a((String)obj);
                        }

            
            {
                b = _pcls1;
                a = baseactivity;
                super();
            }
                    });
                    return;
                }
            }
            return;
        }

            
            {
                a = _pcls10;
                super();
            }
    }

}
