// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.cyberlink.beautycircle.c;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.n;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.setting.PhotoQuality;
import com.cyberlink.youcammakeup.utility.al;
import com.cyberlink.youcammakeup.utility.bd;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.r;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;
import com.cyberlink.youcammakeup.widgetpool.dialogs.x;
import com.cyberlink.youcammakeup.widgetpool.dialogs.y;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            q, LauncherActivity, NoticeActivity, AboutActivity, 
//            WebViewerExActivity

public class SettingActivity extends BaseActivity
    implements n
{

    private static final String m[] = {
        "Local", "SD Card"
    };
    private PhotoQuality a;
    private View b;
    private View c;
    private TextView d;
    private TextView e;
    private TextView f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private String n;
    private android.view.View.OnClickListener o;
    private android.view.View.OnClickListener p;
    private android.view.View.OnClickListener q;
    private android.view.View.OnClickListener r;
    private android.view.View.OnClickListener s;
    private android.view.View.OnClickListener t;
    private android.view.View.OnClickListener u;
    private android.view.View.OnClickListener v;
    private android.view.View.OnClickListener w;
    private android.view.View.OnClickListener x;
    private android.view.View.OnClickListener y;

    public SettingActivity()
    {
        a = PhotoQuality.d;
        n = "Local";
        o = new android.view.View.OnClickListener() {

            final SettingActivity a;

            public void onClick(View view)
            {
                a.f();
            }

            
            {
                a = SettingActivity.this;
                super();
            }
        };
        p = new android.view.View.OnClickListener() {

            final SettingActivity a;
            private Dialog b;

            static Dialog a(_cls5 _pcls5)
            {
                return _pcls5.b;
            }

            static Dialog a(_cls5 _pcls5, Dialog dialog)
            {
                _pcls5.b = dialog;
                return dialog;
            }

            public void onClick(View view)
            {
                int i1 = 0;
                if (b != null)
                {
                    b.dismiss();
                    b = null;
                }
                ArrayList arraylist = new ArrayList();
                view = PhotoQuality.e();
                int j1 = 0;
                for (; i1 < view.length; i1++)
                {
                    PhotoQuality photoquality = view[i1];
                    if (SettingActivity.a(a) == photoquality)
                    {
                        j1 = i1;
                    }
                    arraylist.add(SettingActivity.a(a, photoquality));
                }

                String as[] = (String[])arraylist.toArray(new String[arraylist.size()]);
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(a, 0x7f0a022f);
                builder.setTitle(0x7f07064c);
                builder.setSingleChoiceItems(as, j1, new android.content.DialogInterface.OnClickListener(this, view) {

                    final PhotoQuality a[];
                    final _cls5 b;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                        if (_cls5.a(b) != null)
                        {
                            _cls5.a(b).dismiss();
                            _cls5.a(b, null);
                        }
                        if (SettingActivity.a(b.a) == a[i1])
                        {
                            return;
                        }
                        dialoginterface = Globals.d().e();
                        if (a[i1] == PhotoQuality.a && (z.n() || dialoginterface.intValue() <= 0x16e360))
                        {
                            SettingActivity.b(b.a, a[i1]);
                            return;
                        } else
                        {
                            com.cyberlink.youcammakeup.activity.SettingActivity.c(b.a, a[i1]);
                            return;
                        }
                    }

            
            {
                b = _pcls5;
                a = aphotoquality;
                super();
            }
                });
                b = builder.show();
                SettingActivity.a(b, Color.parseColor("#A186C4"));
            }

            
            {
                a = SettingActivity.this;
                super();
                b = null;
            }
        };
        q = new android.view.View.OnClickListener() {

            final SettingActivity a;
            private Dialog b;

            static Dialog a(_cls6 _pcls6)
            {
                return _pcls6.b;
            }

            static Dialog a(_cls6 _pcls6, Dialog dialog)
            {
                _pcls6.b = dialog;
                return dialog;
            }

            public void onClick(View view)
            {
                boolean flag = false;
                if (b != null)
                {
                    b.dismiss();
                    b = null;
                }
                Object obj;
                int i1;
                if (SettingActivity.b(a).equalsIgnoreCase("Local"))
                {
                    i1 = 0;
                } else
                {
                    i1 = 1;
                }
                view = a.getString(0x7f07064a);
                obj = a.getString(0x7f07064b);
                if (!Exporter.d())
                {
                    i1 = ((flag) ? 1 : 0);
                }
                view = new ArrayAdapter(a.getApplicationContext(), 0x7f030191, new String[] {
                    view, obj
                });
                obj = new android.app.AlertDialog.Builder(a, 0x7f0a022f);
                ((android.app.AlertDialog.Builder) (obj)).setTitle(0x7f070650);
                ((android.app.AlertDialog.Builder) (obj)).setSingleChoiceItems(view, i1, new android.content.DialogInterface.OnClickListener(this) {

                    final _cls6 a;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                        if (_cls6.a(a) != null)
                        {
                            _cls6.a(a).dismiss();
                            _cls6.a(a, null);
                        }
                        if (SettingActivity.b(a.a).equals(SettingActivity.j()[i1]))
                        {
                            return;
                        }
                        if (i1 == 1)
                        {
                            if (android.os.Build.VERSION.SDK_INT >= 19)
                            {
                                if (android.os.Build.VERSION.SDK_INT > 19 && Exporter.d())
                                {
                                    SettingActivity.a(a.a, SettingActivity.j()[i1]);
                                    return;
                                } else
                                {
                                    SettingActivity.a(a.a, 0x7f07066a);
                                    return;
                                }
                            }
                            if (!Exporter.d())
                            {
                                SettingActivity.a(a.a, 0x7f07066b);
                                return;
                            }
                        }
                        SettingActivity.b(a.a, SettingActivity.j()[i1]);
                    }

            
            {
                a = _pcls6;
                super();
            }
                });
                b = ((android.app.AlertDialog.Builder) (obj)).show();
                SettingActivity.a(b, Color.parseColor("#A186C4"));
            }

            
            {
                a = SettingActivity.this;
                super();
                b = null;
            }
        };
        r = new q(this, "CAMERA_SETTING_GPS");
        s = new q(this, "AUTO_FLIP_PHOTO");
        t = new android.view.View.OnClickListener() {

            final SettingActivity a;

            public void onClick(View view)
            {
                boolean flag = bd.a(a);
                if (flag)
                {
                    z.a("HAS_RATE_THIS_APP", Boolean.valueOf(flag), a);
                }
            }

            
            {
                a = SettingActivity.this;
                super();
            }
        };
        u = new android.view.View.OnClickListener() {

            final SettingActivity a;

            public void onClick(View view)
            {
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/NoticeActivity);
                view.putExtra("previousActivity", "launcher");
                view.putExtra(a.getResources().getString(0x7f070729), com/cyberlink/youcammakeup/activity/SettingActivity);
                a.startActivity(view);
            }

            
            {
                a = SettingActivity.this;
                super();
            }
        };
        v = new android.view.View.OnClickListener() {

            final SettingActivity a;

            public void onClick(View view)
            {
                view = Globals.O();
                view.attachmentPath = Collections.emptyList();
                com.cyberlink.beautycircle.c.a(a, view, 2);
            }

            
            {
                a = SettingActivity.this;
                super();
            }
        };
        w = new android.view.View.OnClickListener() {

            final SettingActivity a;

            public void onClick(View view)
            {
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/AboutActivity);
                a.startActivity(view);
            }

            
            {
                a = SettingActivity.this;
                super();
            }
        };
        x = new android.view.View.OnClickListener() {

            final SettingActivity a;

            public void onClick(View view)
            {
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                view.putExtra("RedirectUrl", "http://www.perfectcorp.com/stat/faq/youcam-makeup/redirect.jsp");
                view.putExtra("Title", a.getString(0x7f070637));
                view.putExtra("TopBarStyle", 2);
                a.startActivity(view);
            }

            
            {
                a = SettingActivity.this;
                super();
            }
        };
        y = new android.view.View.OnClickListener() {

            final SettingActivity a;

            public void onClick(View view)
            {
                String s1 = a.getString(0x7f07063a);
                if (al.a("com.facebook.katana"))
                {
                    if (al.b("com.facebook.katana") >= 0x2dd1e2)
                    {
                        view = (new StringBuilder()).append("fb://facewebmodal/f?href=").append(s1).toString();
                    } else
                    {
                        view = (new StringBuilder()).append("fb://profile/").append(a.getString(0x7f070639)).toString();
                    }
                    view = new Intent("android.intent.action.VIEW", Uri.parse(view));
                } else
                {
                    view = new Intent("android.intent.action.VIEW", Uri.parse(s1));
                }
                try
                {
                    a.startActivity(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    com.pf.common.utility.m.b("SettingActivity", "start activity with exception: ", view);
                }
                view = new Intent("android.intent.action.VIEW", Uri.parse(s1));
                a.startActivity(view);
            }

            
            {
                a = SettingActivity.this;
                super();
            }
        };
    }

    static PhotoQuality a(SettingActivity settingactivity)
    {
        return settingactivity.a;
    }

    static String a(SettingActivity settingactivity, PhotoQuality photoquality)
    {
        return settingactivity.c(photoquality);
    }

    private void a(int i1)
    {
        String s1 = getString(i1);
        Globals.d().i().a(this, x.a, s1, true);
        Globals.d().i().a(new r() {

            final SettingActivity a;

            public void a()
            {
                Globals.d().i().i(a);
            }

            
            {
                a = SettingActivity.this;
                super();
            }
        });
    }

    public static void a(Dialog dialog, int i1)
    {
        Resources resources = dialog.getContext().getResources();
        View view = dialog.findViewById(resources.getIdentifier("android:id/titleDivider", null, null));
        if (view != null)
        {
            view.setBackgroundColor(i1);
        }
        dialog = (TextView)dialog.findViewById(resources.getIdentifier("android:id/alertTitle", null, null));
        if (dialog != null)
        {
            dialog.setTextColor(i1);
        }
    }

    static void a(SettingActivity settingactivity, int i1)
    {
        settingactivity.a(i1);
    }

    static void a(SettingActivity settingactivity, String s1)
    {
        settingactivity.a(s1);
    }

    private void a(PhotoQuality photoquality)
    {
        Globals.d().i().c(this);
        Object obj;
        if (z.n())
        {
            obj = getString(0x7f070670);
        } else
        {
            obj = getString(0x7f07066f);
        }
        Globals.d().i().b(x.a, ((String) (obj)));
        obj = new y(true, true, true, true, getString(0x7f0703fd), getString(0x7f0703fa));
        Globals.d().i().a(((y) (obj)));
        Globals.d().i().a(new w(photoquality) {

            final PhotoQuality a;
            final SettingActivity b;

            public void a(boolean flag)
            {
                Globals.d().i().i(b);
                com.cyberlink.youcammakeup.activity.SettingActivity.c(b, a);
            }

            public void b(boolean flag)
            {
                Globals.d().i().i(b);
            }

            
            {
                b = SettingActivity.this;
                a = photoquality;
                super();
            }
        });
    }

    private void a(String s1)
    {
        Globals.d().i().c(this);
        Object obj = getString(0x7f070669);
        Globals.d().i().b(x.a, ((String) (obj)));
        obj = new y(true, true, true, true, getString(0x7f0703fd), getString(0x7f0703fa));
        Globals.d().i().a(((y) (obj)));
        Globals.d().i().a(new w(s1) {

            final String a;
            final SettingActivity b;

            public void a(boolean flag)
            {
                Globals.d().i().i(b);
                SettingActivity.b(b, a);
            }

            public void b(boolean flag)
            {
                Globals.d().i().i(b);
            }

            
            {
                b = SettingActivity.this;
                a = s1;
                super();
            }
        });
    }

    static String b(SettingActivity settingactivity)
    {
        return settingactivity.n;
    }

    static void b(SettingActivity settingactivity, PhotoQuality photoquality)
    {
        settingactivity.a(photoquality);
    }

    static void b(SettingActivity settingactivity, String s1)
    {
        settingactivity.b(s1);
    }

    private void b(PhotoQuality photoquality)
    {
        a = photoquality;
        d.setText(c(photoquality));
        z.a("PHOTO_QUALITY", a.toString(), this);
    }

    private void b(String s1)
    {
        n = s1;
        z.a("PHOTO_SAVE_PATH", n, this);
        s1 = Exporter.a();
        e.setText(s1);
    }

    private String c(PhotoQuality photoquality)
    {
        return getResources().getString(photoquality.a());
    }

    static void c(SettingActivity settingactivity, PhotoQuality photoquality)
    {
        settingactivity.b(photoquality);
    }

    static String[] j()
    {
        return m;
    }

    private void k()
    {
        b = findViewById(0x7f0c018e);
        boolean flag = z.a("CAMERA_SETTING_GPS", false, Globals.d());
        b.setSelected(flag);
        c = findViewById(0x7f0c018f);
        flag = z.a("AUTO_FLIP_PHOTO", true, Globals.d());
        c.setSelected(flag);
        d = (TextView)findViewById(0x7f0c0196);
        a = PhotoQuality.b();
        d.setText(c(a));
        e = (TextView)findViewById(0x7f0c0193);
        if (!Exporter.d())
        {
            b("Local");
        }
        String s1 = Exporter.a();
        n = z.b("PHOTO_SAVE_PATH", "Local", Globals.d());
        e.setText(s1);
        f = (TextView)findViewById(0x7f0c0199);
        if (f != null && !Globals.d().c().b())
        {
            f.setText(getString(0x7f070666));
        }
        g = findViewById(0x7f0c0198);
        g.setOnClickListener(t);
        h = findViewById(0x7f0c019a);
        h.setOnClickListener(u);
        i = findViewById(0x7f0c019d);
        if (Globals.f)
        {
            i.setOnClickListener(v);
        } else
        {
            i.setVisibility(8);
            findViewById(0x7f0c019e).setVisibility(8);
        }
        j = findViewById(0x7f0c019f);
        j.setOnClickListener(w);
        k = findViewById(0x7f0c01a0);
        if (Locale.getDefault().getLanguage().equals("en"))
        {
            k.setOnClickListener(x);
        } else
        {
            k.setVisibility(8);
            findViewById(0x7f0c01a1).setVisibility(8);
        }
        l = findViewById(0x7f0c01a2);
        if (!Globals.d().c().b())
        {
            l.setVisibility(8);
            findViewById(0x7f0c01a4).setVisibility(8);
            return;
        } else
        {
            l.setOnClickListener(y);
            return;
        }
    }

    private void m()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.a(this);
        }
        if (findViewById(0x7f0c0189) != null)
        {
            findViewById(0x7f0c0189).setOnClickListener(o);
        }
        if (findViewById(0x7f0c0194) != null)
        {
            findViewById(0x7f0c0194).setOnClickListener(p);
        }
        if (findViewById(0x7f0c0192) != null)
        {
            findViewById(0x7f0c0192).setOnClickListener(q);
        }
        b.setOnClickListener(r);
        c.setOnClickListener(s);
    }

    private void n()
    {
        NetworkManager networkmanager = Globals.d().w();
        if (networkmanager != null)
        {
            networkmanager.b(this);
        }
    }

    public boolean e()
    {
        startActivity(new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity));
        finish();
        overridePendingTransition(0x7f040004, 0x7f040005);
        return true;
    }

    public void l()
    {
        if (af.a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.b))
        {
            af.a(this, findViewById(0x7f0c019c), com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.b);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(null);
        setContentView(0x7f03001c);
        k();
        m();
    }

    protected void onDestroy()
    {
        n();
        super.onDestroy();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            keyevent.startTracking();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            f();
            return true;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected void onPause()
    {
        Globals.d().c("settingPage");
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        Object obj = Globals.d().w();
        if (obj != null)
        {
            obj = ((NetworkManager) (obj)).K();
            ((NewBadgeState) (obj)).b(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.e);
            View view = findViewById(0x7f0c019c);
            if (view != null)
            {
                int i1;
                if (((NewBadgeState) (obj)).a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.b))
                {
                    i1 = 0;
                } else
                {
                    i1 = 4;
                }
                view.setVisibility(i1);
            }
        }
        Globals.d().c(null);
    }

}
