// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.ba;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.i;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.h;
import com.rockerhieu.emojicon.EmojiconTextView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class UserProfileActivity extends BaseActivity
{

    private android.view.View.OnClickListener A;
    private android.view.View.OnClickListener B;
    private android.view.View.OnClickListener C;
    private android.view.View.OnClickListener D;
    private android.view.View.OnClickListener E;
    private android.view.View.OnClickListener F;
    private android.view.View.OnClickListener G;
    private android.view.View.OnClickListener H;
    private android.view.View.OnClickListener I;
    private android.view.View.OnClickListener J;
    private Runnable K;
    private UICImageView e;
    private EmojiconTextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private String t;
    private Dialog u;
    private android.view.View.OnClickListener v;
    private android.view.View.OnClickListener w;
    private android.view.View.OnClickListener x;
    private android.view.View.OnClickListener y;
    private android.view.View.OnClickListener z;

    public UserProfileActivity()
    {
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        u = null;
        v = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                UserProfileActivity.a(a, com.perfectcorp.utility.h.a(view.getContext()));
                DialogUtils.a(a, 48133, 48134, UserProfileActivity.a(a));
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        w = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.c.a(a, 2);
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        x = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.c.a(a, 3);
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        y = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.c.b(a, 0);
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        z = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                ArrayList arraylist = new ArrayList();
                ArrayList arraylist1 = new ArrayList();
                String as[] = AccountManager.d;
                int k2 = as.length;
                int l1 = 0;
                int k1 = 0;
                int j1 = 0;
                int i1 = 0;
                while (l1 < k2) 
                {
                    Object obj = as[l1];
                    view = ((View) (obj));
                    if (((String) (obj)).length() < 5)
                    {
                        view = Locale.getDefault().toString();
                    }
                    int i2;
                    if (view.equalsIgnoreCase("others"))
                    {
                        arraylist.add(a.getResources().getString(m.bc_user_profile_other_country));
                    } else
                    {
                        arraylist.add(com.cyberlink.beautycircle.utility.i.b(view));
                    }
                    arraylist1.add(view);
                    if (AccountManager.a().equals(view))
                    {
                        i1 = 1;
                        k1 = j1;
                    } else
                    {
                        int j2 = i1;
                        i1 = k1;
                        k1 = j2;
                    }
                    i2 = l1 + 1;
                    j1++;
                    l1 = k1;
                    k1 = i1;
                    i1 = l1;
                    l1 = i2;
                }
                if (k1 == 0)
                {
                    i1 = AccountManager.d.length - 1;
                }
                view = (String[])arraylist.toArray(new String[arraylist.size()]);
                obj = new android.app.AlertDialog.Builder(a);
                ((android.app.AlertDialog.Builder) (obj)).setTitle(m.bc_user_profile_country_title);
                ((android.app.AlertDialog.Builder) (obj)).setSingleChoiceItems(view, i1, new android.content.DialogInterface.OnClickListener(this, arraylist1, arraylist) {

                    final ArrayList a;
                    final ArrayList b;
                    final _cls15 c;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                        if (com.cyberlink.beautycircle.controller.activity.UserProfileActivity.b(c.a) != null)
                        {
                            com.cyberlink.beautycircle.controller.activity.UserProfileActivity.b(c.a).dismiss();
                            UserProfileActivity.a(c.a, null);
                        }
                        (new AsyncTask(this, i1, new AsyncTask(this, i1) {

                            final int a;
                            final _cls1 b;

                            protected transient Void a(UserInfo auserinfo[])
                            {
                                if (auserinfo.length >= 1 && auserinfo[0] != null)
                                {
                                    auserinfo = auserinfo[0];
                                    String s1 = AccountManager.b();
                                    String s2 = (String)b.a.get(a);
                                    b.c.a.k();
                                    if (auserinfo != null)
                                    {
                                        auserinfo.region = s2;
                                        try
                                        {
                                            AccountManager.a(s1, auserinfo, new com.cyberlink.beautycircle.utility.c(this) {

                                                final _cls1 a;

                                                public void a()
                                                {
                                                }

                                                public void b()
                                                {
                                                    UserProfileActivity.a(a.b.c.a, 48258);
                                                }

            
            {
                a = _pcls1;
                super();
            }
                                            }, false).d();
                                        }
                                        // Misplaced declaration of an exception variable
                                        catch (UserInfo auserinfo[])
                                        {
                                            auserinfo.printStackTrace();
                                            return null;
                                        }
                                        // Misplaced declaration of an exception variable
                                        catch (UserInfo auserinfo[])
                                        {
                                            auserinfo.printStackTrace();
                                            return null;
                                        }
                                        // Misplaced declaration of an exception variable
                                        catch (UserInfo auserinfo[])
                                        {
                                            auserinfo.printStackTrace();
                                            return null;
                                        }
                                        return null;
                                    }
                                }
                                return null;
                            }

                            protected void a(Void void1)
                            {
                                b.c.a.l();
                                com.cyberlink.beautycircle.controller.activity.UserProfileActivity.c(b.c.a);
                            }

                            protected Object doInBackground(Object aobj[])
                            {
                                return a((UserInfo[])aobj);
                            }

                            protected void onPostExecute(Object obj)
                            {
                                a((Void)obj);
                            }

            
            {
                b = _pcls1;
                a = i1;
                super();
            }
                        }) {

                            final int a;
                            final AsyncTask b;
                            final _cls1 c;

                            protected transient Void a(Void avoid[])
                            {
                                avoid = AccountManager.d();
                                String s1 = (String)c.a.get(a);
                                if (((UserInfo) (avoid)).region.equals(s1) || s1.equals("others") && !AccountManager.a(((UserInfo) (avoid)).region))
                                {
                                    return null;
                                } else
                                {
                                    com.perfectcorp.a.b.a(new ba());
                                    String s2 = c.c.a.getResources().getString(m.bc_user_edit_confirm_locale_change);
                                    DialogUtils.a(c.c.a, "", String.format(Locale.getDefault(), s2, new Object[] {
                                        c.b.get(a)
                                    }), null, null, c.c.a.getResources().getString(m.bc_dialog_button_ok), new Runnable(this, avoid) {

                                        final UserInfo a;
                                        final _cls2 b;

                                        public void run()
                                        {
                                            b.b.executeOnExecutor(com.perfectcorp.utility.j.q, new UserInfo[] {
                                                a
                                            });
                                        }

            
            {
                b = _pcls2;
                a = userinfo;
                super();
            }
                                    });
                                    return null;
                                }
                            }

                            protected Object doInBackground(Object aobj[])
                            {
                                return a((Void[])aobj);
                            }

            
            {
                c = _pcls1;
                a = i1;
                b = asynctask;
                super();
            }
                        }).executeOnExecutor(com.perfectcorp.utility.j.q, new Void[0]);
                    }

            
            {
                c = _pcls15;
                a = arraylist;
                b = arraylist1;
                super();
            }
                });
                UserProfileActivity.a(a, ((android.app.AlertDialog.Builder) (obj)).show());
                Globals.a(com.cyberlink.beautycircle.controller.activity.UserProfileActivity.b(a), a.getResources().getColor(g.bc_color_main_style));
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        A = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                (new AsyncTask(this) {

                    final _cls16 a;

                    protected transient UserInfo a(Void avoid[])
                    {
                        return AccountManager.d();
                    }

                    protected void a(UserInfo userinfo)
                    {
                        if (userinfo != null && userinfo.avatarUrl != null)
                        {
                            com.cyberlink.beautycircle.c.a(a.a, userinfo.avatarUrl);
                        }
                    }

                    protected Object doInBackground(Object aobj[])
                    {
                        return a((Void[])aobj);
                    }

                    protected void onPostExecute(Object obj)
                    {
                        a((UserInfo)obj);
                    }

            
            {
                a = _pcls16;
                super();
            }
                }).executeOnExecutor(com.perfectcorp.utility.j.q, new Void[0]);
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        B = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                (new AsyncTask(this) {

                    final _cls17 a;

                    protected transient UserInfo a(Void avoid[])
                    {
                        return AccountManager.d();
                    }

                    protected void a(UserInfo userinfo)
                    {
                        if (userinfo != null && userinfo.coverUrl != null)
                        {
                            com.cyberlink.beautycircle.c.a(a.a, userinfo.coverUrl);
                        }
                    }

                    protected Object doInBackground(Object aobj[])
                    {
                        return a((Void[])aobj);
                    }

                    protected void onPostExecute(Object obj)
                    {
                        a((UserInfo)obj);
                    }

            
            {
                a = _pcls17;
                super();
            }
                }).executeOnExecutor(com.perfectcorp.utility.j.q, new Void[0]);
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        C = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.c.a(a, a.getResources().getString(m.bc_url_terms_of_service), 1);
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        D = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.c.a(a, a.getResources().getString(m.bc_url_privacy_policy), 1);
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        E = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                DialogUtils.a(a, null, a.getResources().getString(m.bc_user_log_out_title_description), a.getResources().getString(m.bc_dialog_button_no), null, a.getResources().getString(m.bc_user_log_out_btn), new Runnable(this) {

                    final _cls3 a;

                    public void run()
                    {
                        a.a.k();
                        NetworkUser.a(AccountManager.b()).a(new com.perfectcorp.utility.j(this) {

                            final _cls1 a;

                            protected volatile Object a(Object obj)
                            {
                                return a((Void)obj);
                            }

                            protected Void a(Void void1)
                            {
                                try
                                {
                                    AccountManager.a(true, false, Globals.c()).d();
                                }
                                // Misplaced declaration of an exception variable
                                catch (Void void1)
                                {
                                    void1.printStackTrace();
                                }
                                // Misplaced declaration of an exception variable
                                catch (Void void1)
                                {
                                    void1.printStackTrace();
                                }
                                // Misplaced declaration of an exception variable
                                catch (Void void1)
                                {
                                    void1.printStackTrace();
                                }
                                return null;
                            }

            
            {
                a = _pcls1;
                super();
            }
                        }).a(new com.perfectcorp.utility.m(this) {

                            final _cls1 a;

                            protected void a()
                            {
                                Globals.a(a.a.a.getResources().getString(m.bc_user_log_out_fail));
                                a.a.a.l();
                                a.a.a.e();
                            }

                            protected void a(int i1)
                            {
                                Globals.a(a.a.a.getResources().getString(m.bc_user_log_out_fail));
                                a.a.a.l();
                                a.a.a.e();
                            }

                            protected void a(Void void1)
                            {
                                a.a.a.l();
                                a.a.a.e();
                            }

                            protected void b(Object obj)
                            {
                                a((Void)obj);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                    }

            
            {
                a = _pcls3;
                super();
            }
                });
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        F = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                DialogUtils.a(a, null, a.getResources().getString(m.bc_user_delete_user_description), a.getResources().getString(m.bc_dialog_button_no), null, a.getResources().getString(m.bc_user_delete_user_btn), new Runnable(this) {

                    final _cls4 a;

                    public void run()
                    {
                        a.a.k();
                        NetworkUser.b(AccountManager.b()).a(new com.perfectcorp.utility.j(this) {

                            final _cls1 a;

                            protected volatile Object a(Object obj)
                            {
                                return a((Void)obj);
                            }

                            protected Void a(Void void1)
                            {
                                try
                                {
                                    AccountManager.a(true, false, Globals.c()).d();
                                }
                                // Misplaced declaration of an exception variable
                                catch (Void void1)
                                {
                                    void1.printStackTrace();
                                }
                                // Misplaced declaration of an exception variable
                                catch (Void void1)
                                {
                                    void1.printStackTrace();
                                }
                                // Misplaced declaration of an exception variable
                                catch (Void void1)
                                {
                                    void1.printStackTrace();
                                }
                                return null;
                            }

            
            {
                a = _pcls1;
                super();
            }
                        }).a(new com.perfectcorp.utility.m(this) {

                            final _cls1 a;

                            protected void a()
                            {
                                Globals.a(a.a.a.getResources().getString(m.bc_user_delete_user_fail));
                                a.a.a.l();
                                a.a.a.e();
                            }

                            protected void a(int i1)
                            {
                                Globals.a(a.a.a.getResources().getString(m.bc_user_delete_user_fail));
                                a.a.a.l();
                                a.a.a.e();
                            }

                            protected void a(Void void1)
                            {
                                a.a.a.l();
                                a.a.a.e();
                            }

                            protected void b(Object obj)
                            {
                                a((Void)obj);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                    }

            
            {
                a = _pcls4;
                super();
            }
                });
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        G = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                com.perfectcorp.utility.e.a(a.getBaseContext());
                com.perfectcorp.utility.e.a(a);
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        H = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.c.d(a);
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        I = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.c.c(a);
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        J = new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                view = com.cyberlink.beautycircle.model.network.i.a();
                String s1 = Globals.c();
                int i1 = Arrays.asList(view).indexOf(s1);
                view = (new android.app.AlertDialog.Builder(a)).setTitle("Change Server and Logout").setSingleChoiceItems(view, i1, null).setPositiveButton(m.bc_dialog_button_yes, new android.content.DialogInterface.OnClickListener(this, i1, view) {

                    final int a;
                    final String b[];
                    final _cls8 c;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                        dialoginterface.dismiss();
                        i1 = ((AlertDialog)dialoginterface).getListView().getCheckedItemPosition();
                        if (i1 != a)
                        {
                            Globals.a((String)Arrays.asList(b).get(i1));
                            UserProfileActivity.d(c.a).run();
                        }
                    }

            
            {
                c = _pcls8;
                a = i1;
                b = as;
                super();
            }
                }).setNegativeButton(m.bc_dialog_button_no, null).create();
                view.show();
                Globals.a(view, a.getResources().getColor(g.bc_color_main_style));
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
        K = new Runnable() {

            final UserProfileActivity a;

            public void run()
            {
                a.k();
                Globals.f().a(new com.perfectcorp.utility.j(this) {

                    final _cls10 a;

                    protected Boolean a(Boolean boolean1)
                    {
                        if (boolean1.booleanValue())
                        {
                            try
                            {
                                AccountManager.a(false, true, Globals.c()).d();
                            }
                            catch (CancellationException cancellationexception)
                            {
                                cancellationexception.printStackTrace();
                                return boolean1;
                            }
                            catch (InterruptedException interruptedexception)
                            {
                                interruptedexception.printStackTrace();
                                return boolean1;
                            }
                            catch (ExecutionException executionexception)
                            {
                                executionexception.printStackTrace();
                                return boolean1;
                            }
                        }
                        return boolean1;
                    }

                    protected volatile Object a(Object obj)
                    {
                        return a((Boolean)obj);
                    }

            
            {
                a = _pcls10;
                super();
            }
                }).a(new com.perfectcorp.utility.m(this) {

                    final _cls10 a;

                    protected void a(Boolean boolean1)
                    {
                        a.a.l();
                        if (boolean1.booleanValue())
                        {
                            a.a.e();
                            Globals.a(String.format(Locale.getDefault(), a.a.getResources().getString(m.bc_user_profile_change_webserver_success), new Object[] {
                                Globals.e()
                            }));
                            return;
                        } else
                        {
                            Globals.a(String.format(Locale.getDefault(), a.a.getResources().getString(m.bc_user_profile_change_webserver_fail), new Object[] {
                                Globals.e()
                            }));
                            return;
                        }
                    }

                    protected void b(Object obj)
                    {
                        a((Boolean)obj);
                    }

            
            {
                a = _pcls10;
                super();
            }
                });
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        };
    }

    static Dialog a(UserProfileActivity userprofileactivity, Dialog dialog)
    {
        userprofileactivity.u = dialog;
        return dialog;
    }

    private TextView a(int i1, int j1, android.view.View.OnClickListener onclicklistener)
    {
        View view = findViewById(i1);
        if (onclicklistener != null)
        {
            view.setOnClickListener(onclicklistener);
        } else
        {
            view.findViewById(j.bc_goto_image).setVisibility(4);
        }
        ((TextView)view.findViewById(j.bc_goto_left_text)).setText(j1);
        return (TextView)view.findViewById(j.bc_goto_right_text);
    }

    static String a(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.t;
    }

    static String a(UserProfileActivity userprofileactivity, String s1)
    {
        userprofileactivity.t = s1;
        return s1;
    }

    static void a(UserProfileActivity userprofileactivity, int i1)
    {
        userprofileactivity.c(i1);
    }

    static Dialog b(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.u;
    }

    private void c(int i1)
    {
        setResult(i1, new Intent());
        super.e();
    }

    static void c(UserProfileActivity userprofileactivity)
    {
        userprofileactivity.o();
    }

    static Runnable d(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.K;
    }

    static UICImageView e(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.e;
    }

    static EmojiconTextView f(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.f;
    }

    static TextView g(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.g;
    }

    static TextView h(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.h;
    }

    static TextView i(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.i;
    }

    static TextView j(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.j;
    }

    static TextView k(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.k;
    }

    static TextView l(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.o;
    }

    static TextView m(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.p;
    }

    static TextView n(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.q;
    }

    static TextView o(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.l;
    }

    private void o()
    {
        (new AsyncTask() {

            final UserProfileActivity a;

            protected transient UserInfo a(Void avoid[])
            {
                avoid = AccountManager.d();
                if (avoid != null)
                {
                    avoid.email = AccountManager.e();
                }
                return avoid;
            }

            protected void a(UserInfo userinfo)
            {
                String s1;
                Uri uri;
                String s2;
                String s3;
                String s4;
                String s5;
                String s6;
                String s7;
                String s8;
                String s9;
                String s10;
                if (userinfo != null)
                {
                    uri = userinfo.avatarUrl;
                } else
                {
                    uri = null;
                }
                if (userinfo != null && userinfo.displayName != null)
                {
                    s2 = userinfo.displayName;
                } else
                {
                    s2 = a.getResources().getString(m.bc_me_anonymous);
                }
                if (userinfo != null && userinfo.description != null)
                {
                    s3 = userinfo.description;
                } else
                {
                    s3 = "";
                }
                if (userinfo != null && userinfo.email != null)
                {
                    s4 = userinfo.email;
                } else
                {
                    s4 = "";
                }
                if (userinfo != null && userinfo.receiveEmail != null)
                {
                    s5 = userinfo.receiveEmail;
                } else
                {
                    s5 = "";
                }
                if (userinfo != null && userinfo.region != null)
                {
                    s1 = userinfo.region;
                } else
                {
                    s1 = "";
                }
                if (!s1.isEmpty())
                {
                    s6 = s1;
                    if (s1.length() < 5)
                    {
                        s6 = Locale.getDefault().toString();
                    }
                    com.cyberlink.beautycircle.utility.AccountManager.AccountSource accountsource;
                    if (!AccountManager.a(s6))
                    {
                        s1 = a.getResources().getString(m.bc_user_profile_other_country);
                    } else
                    {
                        s1 = com.cyberlink.beautycircle.utility.i.b(s6);
                    }
                } else
                {
                    s1 = "";
                }
                if (userinfo != null)
                {
                    s6 = String.valueOf(userinfo.id);
                } else
                {
                    s6 = "null";
                }
                s7 = AccountManager.b();
                if (s7 == null)
                {
                    s7 = "null";
                }
                if (userinfo != null && userinfo.userType != null)
                {
                    s8 = userinfo.userType;
                } else
                {
                    s8 = "null";
                }
                if (userinfo != null && userinfo.lastModified != null)
                {
                    s9 = com.cyberlink.beautycircle.utility.i.b(userinfo.lastModified);
                } else
                {
                    s9 = "null";
                }
                if (userinfo != null && userinfo.avatarUrl != null)
                {
                    s10 = userinfo.avatarUrl.toString();
                } else
                {
                    s10 = "null";
                }
                if (userinfo != null && userinfo.coverUrl != null)
                {
                    userinfo = userinfo.coverUrl.toString();
                } else
                {
                    userinfo = "null";
                }
                accountsource = AccountManager.f();
                com.cyberlink.beautycircle.controller.activity.UserProfileActivity.e(a).setImageURI(uri);
                UserProfileActivity.f(a).setText(s2);
                com.cyberlink.beautycircle.controller.activity.UserProfileActivity.g(a).setText(s3);
                if (accountsource == com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a)
                {
                    com.cyberlink.beautycircle.controller.activity.UserProfileActivity.h(a).setText(s4);
                } else
                {
                    com.cyberlink.beautycircle.controller.activity.UserProfileActivity.h(a).setText(s5);
                }
                com.cyberlink.beautycircle.controller.activity.UserProfileActivity.i(a).setText(s1);
                com.cyberlink.beautycircle.controller.activity.UserProfileActivity.j(a).setText(Globals.c());
                com.cyberlink.beautycircle.controller.activity.UserProfileActivity.k(a).setText(s6);
                UserProfileActivity.l(a).setText(s7);
                com.cyberlink.beautycircle.controller.activity.UserProfileActivity.m(a).setText(s8);
                if (accountsource != null)
                {
                    UserProfileActivity.n(a).setText(accountsource.toString());
                }
                UserProfileActivity.o(a).setText(s9);
                UserProfileActivity.p(a).setText(s10);
                UserProfileActivity.q(a).setText(userinfo);
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((UserInfo)obj);
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        }).executeOnExecutor(com.perfectcorp.utility.j.q, new Void[0]);
    }

    static TextView p(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.m;
    }

    static TextView q(UserProfileActivity userprofileactivity)
    {
        return userprofileactivity.n;
    }

    protected boolean e()
    {
        c(-1);
        return true;
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        i1;
        JVM INSTR lookupswitch 5: default 60
    //                   48129: 188
    //                   48133: 61
    //                   48134: 108
    //                   48135: 188
    //                   48141: 213;
           goto _L1 _L2 _L3 _L4 _L2 _L5
_L1:
        return;
_L3:
        if (j1 == -1 && intent != null)
        {
            ArrayList arraylist = new ArrayList();
            intent = intent.getData();
            if (intent != null)
            {
                arraylist.add(intent);
            }
            com.cyberlink.beautycircle.c.a(this, arraylist, com.cyberlink.beautycircle.Globals.CropSettings.Avatar, 48135);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (j1 == -1 && t != null)
        {
            MediaScannerConnection.scanFile(this, new String[] {
                t.toString()
            }, null, null);
            intent = new ArrayList();
            Uri uri = Uri.fromFile(new File(t));
            if (uri != null)
            {
                intent.add(uri);
            }
            com.cyberlink.beautycircle.c.a(this, intent, com.cyberlink.beautycircle.Globals.CropSettings.Avatar, 48135);
            return;
        }
        if (true) goto _L1; else goto _L2
_L2:
        if (j1 == -1)
        {
            o();
            return;
        }
        if (j1 == 48258)
        {
            c(48258);
            return;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        if (j1 == 48256)
        {
            o();
            return;
        }
        if (j1 == 48258)
        {
            c(48258);
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_user_profile);
        if (Globals.j())
        {
            findViewById(j.profile_developer_mode).setVisibility(0);
        }
        b(m.bc_user_profile_title);
        b().a();
        e = (UICImageView)findViewById(j.profile_avatar);
        e.setOnClickListener(v);
        findViewById(j.profile_banner_inside).setOnClickListener(w);
        f = (EmojiconTextView)findViewById(j.profile_username_item);
        g = a(j.profile_about_me_item, m.bc_user_profile_about_me, x);
        a(j.profile_beauty_item, m.bc_user_profile_beauty_profile, y);
        h = a(j.profile_email_item, m.bc_user_profile_email, null);
        i = a(j.profile_country_item, m.bc_user_profile_country, z);
        String s1;
        if (AccountManager.f() == com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a)
        {
            a(j.profile_change_password, m.bc_user_profile_change_password, H);
        } else
        {
            bundle = findViewById(j.profile_change_password);
            if (bundle != null)
            {
                bundle.setVisibility(8);
            }
        }
        bundle = findViewById(j.profile_push_notification);
        s1 = Globals.a(getApplicationContext(), "PushNotificationType");
        if (s1 != null && s1.equals("Baidu"))
        {
            bundle.setVisibility(8);
        } else
        {
            a(j.profile_push_notification, m.bc_user_profile_push_notfications, I);
        }
        j = a(j.profile_server_item, m.bc_user_server, J);
        k = a(j.profile_userid_item, m.bc_user_profile_userid, null);
        o = a(j.profile_usertoken_item, m.bc_user_profile_usertoken, null);
        p = a(j.profile_usertype_item, m.bc_user_profile_usertype, null);
        q = a(j.profile_accout_source_item, m.bc_user_profile_accountsource, null);
        l = a(j.profile_lastmodify_item, m.bc_user_profile_lastmodify, null);
        m = a(j.profile_avatarurl_item, m.bc_user_profile_avatarurl, A);
        n = a(j.profile_coverurl_item, m.bc_user_profile_coverurl, B);
        a(j.profile_delete_user_item, m.bc_user_delete_user, F);
        a(j.profile_send_latest_log_item, m.bc_user_profile_send_latest_log, G);
        a(j.profile_terms_of_service_item, m.bc_user_profile_terms, C);
        a(j.profile_privacy_item, m.bc_user_profile_privacy, D);
        r = a(j.profile_version_item, m.bc_user_profile_version, null);
        r.setText(m.BC_BUILD_NUMBER);
        s = a(j.profile_device_id, m.bc_user_profile_deviceid, null);
        s.setText(Globals.w());
        s.setTag(Globals.w());
        s.setOnClickListener(new android.view.View.OnClickListener() {

            final UserProfileActivity a;

            public void onClick(View view)
            {
                view = (String)view.getTag();
                ((ClipboardManager)a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, view));
                Globals.a((new StringBuilder()).append("Copy DeepLink to Clipboard: ").append(view).toString());
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        });
        ((Button)findViewById(j.bc_log_out_btn)).setOnClickListener(E);
        o();
    }
}
