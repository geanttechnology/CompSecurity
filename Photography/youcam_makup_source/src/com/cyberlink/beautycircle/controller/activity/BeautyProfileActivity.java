// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.BaseFbActivity;
import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserAtrribute;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.c;
import com.cyberlink.beautycircle.utility.i;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import java.util.Calendar;
import java.util.UUID;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            a, b

public class BeautyProfileActivity extends BaseFbActivity
{

    public static final UUID e = UUID.randomUUID();
    private EditText A;
    private EditText B;
    private ScrollView C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private String M;
    private UserAtrribute N;
    private UserAtrribute O;
    private int P;
    private android.app.DatePickerDialog.OnDateSetListener Q;
    private final int f = -1;
    private int g[];
    private int o[];
    private int p[];
    private int q[];
    private int r[];
    private int s[];
    private int t[];
    private int u[];
    private int v[];
    private Calendar w;
    private TextView x;
    private EditText y;
    private EditText z;

    public BeautyProfileActivity()
    {
        g = (new int[] {
            j.user_profile_sex_female, j.user_profile_sex_male, j.user_profile_sex_unspecified
        });
        o = (new int[] {
            j.user_profile_skin_normal, j.user_profile_skin_dry, j.user_profile_skin_oily, j.user_profile_skin_combo
        });
        p = (new int[] {
            j.user_profile_skintone_fair, j.user_profile_skintone_light, j.user_profile_skintone_med, j.user_profile_skintone_deep, j.user_profile_skintone_dark
        });
        q = (new int[] {
            j.user_profile_skinsensitivity_yes, j.user_profile_skinsensitivity_no
        });
        r = (new int[] {
            j.user_profile_eyecolor_blue, j.user_profile_eyecolor_green, j.user_profile_eyecolor_hazel, j.user_profile_eyecolor_darkbrown, j.user_profile_eyecolor_gray, j.user_profile_eyecolor_black
        });
        s = (new int[] {
            j.user_profile_lashlength_short, j.user_profile_lashlength_medium, j.user_profile_lashlength_long
        });
        t = (new int[] {
            j.user_profile_hairtexture_fine, j.user_profile_hairtexture_medium, j.user_profile_hairtexture_thick, j.user_profile_hairtexture_coarse
        });
        u = (new int[] {
            j.user_profile_haircolor_blonde, j.user_profile_haircolor_red, j.user_profile_haircolor_brown, j.user_profile_haircolor_darkbrown, j.user_profile_haircolor_gray, j.user_profile_haircolor_black
        });
        v = (new int[] {
            j.user_profile_hairtype_straight, j.user_profile_hairtype_wavy, j.user_profile_hairtype_curly, j.user_profile_hairtype_coils
        });
        D = -1;
        E = -1;
        F = -1;
        G = -1;
        H = -1;
        I = -1;
        J = -1;
        K = -1;
        L = -1;
        Q = new android.app.DatePickerDialog.OnDateSetListener() {

            final BeautyProfileActivity a;

            public void onDateSet(DatePicker datepicker, int i1, int j1, int k1)
            {
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.k(a).set(1, i1);
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.k(a).set(2, j1);
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.k(a).set(5, k1);
                BeautyProfileActivity.l(a);
            }

            
            {
                a = BeautyProfileActivity.this;
                super();
            }
        };
    }

    static int[] A(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.u;
    }

    static int B(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.K;
    }

    static int[] C(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.v;
    }

    static int D(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.L;
    }

    static boolean E(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.BaseActivity.e();
    }

    static int a(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.P;
    }

    private int a(int ai[], View view)
    {
        for (int i1 = 0; i1 < ai.length; i1++)
        {
            View view1 = findViewById(ai[i1]);
            if (view1 != null && view1 == view)
            {
                return ai[i1];
            }
        }

        return -1;
    }

    static UserAtrribute a(BeautyProfileActivity beautyprofileactivity, UserAtrribute useratrribute)
    {
        beautyprofileactivity.N = useratrribute;
        return useratrribute;
    }

    static String a(BeautyProfileActivity beautyprofileactivity, String s1)
    {
        beautyprofileactivity.M = s1;
        return s1;
    }

    private void a(int i1, int j1)
    {
        ((ImageView)((RelativeLayout)findViewById(i1)).findViewById(j.hair_color)).setColorFilter(j1);
    }

    private void a(int i1, int j1, int k1)
    {
        TextView textview = (TextView)(TextView)findViewById(j1);
        if (i1 == -1 && (P == 5 || P == 6))
        {
            textview.setText(Html.fromHtml((new StringBuilder()).append(getResources().getString(k1)).append(" ").append(getResources().getString(m.bc_beauty_profile_must_fill)).toString()));
            return;
        } else
        {
            textview.setText(Html.fromHtml(getResources().getString(k1)));
            return;
        }
    }

    private void a(View view)
    {
        int i1 = a(g, view);
        if (i1 != -1)
        {
            D = i1;
            b(g, D);
        } else
        {
            int j1 = a(o, view);
            if (j1 != -1)
            {
                E = j1;
                a(o, E);
                a(E, j.bc_beauty_profile_skin_title_text, m.bc_beauty_profile_skin_title);
                return;
            }
            j1 = a(p, view);
            if (j1 != -1)
            {
                F = j1;
                b(p, F);
                a(F, j.bc_beauty_profile_skintone_title_text, m.bc_beauty_profile_skintone_title);
                return;
            }
            j1 = a(q, view);
            if (j1 != -1)
            {
                G = j1;
                a(q, G);
                a(G, j.bc_beauty_profile_skinsensitivity_title_text, m.bc_beauty_profile_skinsensitivity_title);
                return;
            }
            j1 = a(r, view);
            if (j1 != -1)
            {
                H = j1;
                b(r, H);
                a(H, j.bc_beauty_profile_eyecolor_title_text, m.bc_beauty_profile_eyecolor_title);
                return;
            }
            j1 = a(s, view);
            if (j1 != -1)
            {
                I = j1;
                a(s, I);
                a(I, j.bc_beauty_profile_lashlength_title_text, m.bc_beauty_profile_lashlength_title);
                return;
            }
            j1 = a(t, view);
            if (j1 != -1)
            {
                J = j1;
                a(t, J);
                a(J, j.bc_beauty_profile_hairtexture_title_text, m.bc_beauty_profile_hairtexture_title);
                return;
            }
            j1 = a(u, view);
            if (j1 != -1)
            {
                K = j1;
                b(u, K);
                a(K, j.bc_beauty_profile_haircolor_title_text, m.bc_beauty_profile_haircolor_title);
                return;
            }
            j1 = a(v, view);
            if (j1 != -1)
            {
                L = j1;
                a(v, L);
                a(L, j.bc_beauty_profile_hairtype_title_text, m.bc_beauty_profile_hairtype_title);
                return;
            }
        }
    }

    static void a(BeautyProfileActivity beautyprofileactivity, int i1)
    {
        beautyprofileactivity.c(i1);
    }

    static void a(BeautyProfileActivity beautyprofileactivity, int i1, int j1, int k1)
    {
        beautyprofileactivity.a(i1, j1, k1);
    }

    static void a(BeautyProfileActivity beautyprofileactivity, UserInfo userinfo)
    {
        beautyprofileactivity.a(userinfo);
    }

    static void a(BeautyProfileActivity beautyprofileactivity, UserInfo userinfo, boolean flag)
    {
        beautyprofileactivity.a(userinfo, flag);
    }

    static void a(BeautyProfileActivity beautyprofileactivity, int ai[], int i1)
    {
        beautyprofileactivity.b(ai, i1);
    }

    private void a(UserInfo userinfo)
    {
        if (userinfo != null)
        {
            if (y != null)
            {
                y.setText(userinfo.name);
            }
            if (z != null)
            {
                z.setText(userinfo.phone);
            }
            com.cyberlink.beautycircle.utility.AccountManager.AccountSource accountsource = AccountManager.f();
            if (accountsource == com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a)
            {
                A.setText(userinfo.email);
                A.setEnabled(false);
            } else
            if (accountsource == com.cyberlink.beautycircle.utility.AccountManager.AccountSource.b)
            {
                a(userinfo, new c(userinfo) {

                    final UserInfo a;
                    final BeautyProfileActivity b;

                    public void a()
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.e(b).setText(a.receiveEmail);
                    }

                    public void b()
                    {
                        com.perfectcorp.utility.e.e(new Object[] {
                            "Query FB email fail."
                        });
                    }

            
            {
                b = BeautyProfileActivity.this;
                a = userinfo;
                super();
            }
                });
            } else
            {
                A.setText(userinfo.receiveEmail);
            }
            if (B != null)
            {
                B.setText(userinfo.address);
                return;
            }
        }
    }

    private void a(UserInfo userinfo, boolean flag)
    {
        String s1 = userinfo.birthDay;
        String s2 = userinfo.gender;
        String s3 = userinfo.attribute;
        String s4 = userinfo.name;
        String s5 = userinfo.phone;
        String s6 = userinfo.receiveEmail;
        userinfo = userinfo.address;
        if (s1 == null && s2 == null && s3 == null || !flag)
        {
            c(48256);
            return;
        } else
        {
            k();
            NetworkUser.a(AccountManager.b(), null, null, null, null, s2, null, s1, s3, s4, s5, s6, userinfo, null).a(new com.perfectcorp.utility.m(s1, s2, s3, s4, s5, s6, userinfo) {

                final String a;
                final String b;
                final String c;
                final String d;
                final String e;
                final String f;
                final String g;
                final BeautyProfileActivity h;

                protected void a(int i1)
                {
                    h.l();
                    String s7 = (new StringBuilder()).append(h.getResources().getString(m.bc_register_error_unknown_error)).append(com.cyberlink.beautycircle.model.network.s.a(i1)).toString();
                    if (!com.cyberlink.beautycircle.model.network.c.a())
                    {
                        s7 = (new StringBuilder()).append(h.getResources().getString(m.bc_register_error_network_unavailabe)).append(com.cyberlink.beautycircle.model.network.s.a(i1)).toString();
                    } else
                    if (i1 == 420)
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(h, 48258);
                        return;
                    }
                    DialogUtils.a(h, null, s7, null, null, h.getResources().getString(m.bc_dialog_button_ok), new Runnable(this) {

                        final _cls8 a;

                        public void run()
                        {
                            BeautyProfileActivity.E(a.h);
                        }

            
            {
                a = _pcls8;
                super();
            }
                    });
                }

                protected void a(com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse updateuserresponse)
                {
                    h.l();
                    updateuserresponse = AccountManager.b();
                    UserInfo userinfo1 = AccountManager.d();
                    userinfo1.birthDay = a;
                    userinfo1.gender = b;
                    userinfo1.attribute = c;
                    userinfo1.name = d;
                    userinfo1.phone = e;
                    userinfo1.receiveEmail = f;
                    userinfo1.address = g;
                    AccountManager.a(updateuserresponse, userinfo1, false).a(new com.perfectcorp.utility.m(this) {

                        final _cls8 a;

                        protected void a(Boolean boolean1)
                        {
                            if (boolean1 != null && boolean1.booleanValue())
                            {
                                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a.h, 48256);
                            }
                        }

                        protected void b(Object obj)
                        {
                            a((Boolean)obj);
                        }

            
            {
                a = _pcls8;
                super();
            }
                    });
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse)obj);
                }

            
            {
                h = BeautyProfileActivity.this;
                a = s1;
                b = s2;
                c = s3;
                d = s4;
                e = s5;
                f = s6;
                g = s7;
                super();
            }
            });
            return;
        }
    }

    private void a(int ai[], int i1)
    {
        int j1 = 0;
        while (j1 < ai.length) 
        {
            Button button = (Button)(Button)findViewById(ai[j1]);
            if (button != null)
            {
                if (ai[j1] != i1)
                {
                    button.setSelected(false);
                    button.setTypeface(null, 0);
                } else
                {
                    button.setSelected(true);
                    button.setTypeface(null, 1);
                }
            }
            j1++;
        }
    }

    static int b(BeautyProfileActivity beautyprofileactivity, int i1)
    {
        beautyprofileactivity.D = i1;
        return i1;
    }

    static EditText b(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.y;
    }

    static UserAtrribute b(BeautyProfileActivity beautyprofileactivity, UserAtrribute useratrribute)
    {
        beautyprofileactivity.O = useratrribute;
        return useratrribute;
    }

    static void b(BeautyProfileActivity beautyprofileactivity, int ai[], int i1)
    {
        beautyprofileactivity.a(ai, i1);
    }

    private void b(int ai[], int i1)
    {
        int j1 = 0;
        while (j1 < ai.length) 
        {
            View view = findViewById(ai[j1]);
            if (view != null)
            {
                if (ai[j1] != i1)
                {
                    view.setSelected(false);
                } else
                {
                    view.setSelected(true);
                }
            }
            j1++;
        }
    }

    static int c(BeautyProfileActivity beautyprofileactivity, int i1)
    {
        beautyprofileactivity.E = i1;
        return i1;
    }

    static EditText c(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.B;
    }

    private void c(int i1)
    {
        setResult(i1, new Intent());
        super.e();
    }

    static int d(BeautyProfileActivity beautyprofileactivity, int i1)
    {
        beautyprofileactivity.F = i1;
        return i1;
    }

    static EditText d(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.z;
    }

    static int e(BeautyProfileActivity beautyprofileactivity, int i1)
    {
        beautyprofileactivity.G = i1;
        return i1;
    }

    static EditText e(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.A;
    }

    static int f(BeautyProfileActivity beautyprofileactivity, int i1)
    {
        beautyprofileactivity.H = i1;
        return i1;
    }

    static TextView f(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.x;
    }

    static int g(BeautyProfileActivity beautyprofileactivity, int i1)
    {
        beautyprofileactivity.I = i1;
        return i1;
    }

    static ScrollView g(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.C;
    }

    static int h(BeautyProfileActivity beautyprofileactivity, int i1)
    {
        beautyprofileactivity.J = i1;
        return i1;
    }

    static UserAtrribute h(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.N;
    }

    static int i(BeautyProfileActivity beautyprofileactivity, int i1)
    {
        beautyprofileactivity.K = i1;
        return i1;
    }

    static UserAtrribute i(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.O;
    }

    static int j(BeautyProfileActivity beautyprofileactivity, int i1)
    {
        beautyprofileactivity.L = i1;
        return i1;
    }

    static String j(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.M;
    }

    static Calendar k(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.w;
    }

    static void l(BeautyProfileActivity beautyprofileactivity)
    {
        beautyprofileactivity.u();
    }

    static int[] m(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.g;
    }

    static int n(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.D;
    }

    static int[] o(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.o;
    }

    static int p(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.E;
    }

    private void p()
    {
        a(j.user_profile_haircolor_blonde_ico, 0xffefd5b4);
        a(j.user_profile_haircolor_red_ico, 0xffcf9f91);
        a(j.user_profile_haircolor_brown_ico, 0xff5c4124);
        a(j.user_profile_haircolor_darkbrown_ico, 0xff2d1d06);
        a(j.user_profile_haircolor_gray_ico, 0xff959595);
        a(j.user_profile_haircolor_black_ico, 0xff0a0601);
    }

    private void q()
    {
        ((ImageView)findViewById(j.user_profile_skintone_fair_ico)).setColorFilter(0xffefd5b4);
        ((ImageView)findViewById(j.user_profile_skintone_light_ico)).setColorFilter(0xffccb28d);
        ((ImageView)findViewById(j.user_profile_skintone_med_ico)).setColorFilter(0xff846640);
        ((ImageView)findViewById(j.user_profile_skintone_deep_ico)).setColorFilter(0xff5c4124);
        ((ImageView)findViewById(j.user_profile_skintone_dark_ico)).setColorFilter(0xff412108);
    }

    static int[] q(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.p;
    }

    static int r(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.F;
    }

    private void r()
    {
        (new AsyncTask() {

            final BeautyProfileActivity a;

            protected transient UserInfo a(Void avoid[])
            {
                avoid = AccountManager.d();
                if (avoid == null) goto _L2; else goto _L1
_L1:
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, null);
                if (((UserInfo) (avoid)).birthDay != null && !((UserInfo) (avoid)).birthDay.isEmpty())
                {
                    com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, ((UserInfo) (avoid)).birthDay);
                }
                BeautyProfileActivity.b(a, -1);
                if (((UserInfo) (avoid)).gender == null || ((UserInfo) (avoid)).gender.isEmpty()) goto _L4; else goto _L3
_L3:
                if (!((UserInfo) (avoid)).gender.equals("Female")) goto _L6; else goto _L5
_L5:
                BeautyProfileActivity.b(a, j.user_profile_sex_female);
_L4:
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, (UserAtrribute)Model.a(com/cyberlink/beautycircle/model/UserAtrribute, ((UserInfo) (avoid)).attribute));
                BeautyProfileActivity.b(a, new UserAtrribute());
                UserAtrribute.a(BeautyProfileActivity.h(a), com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a));
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.c(a, -1);
                if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinType != null && !com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinType.isEmpty())
                {
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinType.equals("Normal"))
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.c(a, j.user_profile_skin_normal);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinType.equals("Oily"))
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.c(a, j.user_profile_skin_oily);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinType.equals("Combination"))
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.c(a, j.user_profile_skin_combo);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinType.equals("Dry"))
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.c(a, j.user_profile_skin_dry);
                    }
                }
                BeautyProfileActivity.d(a, -1);
                if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinColor != null && !com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinColor.isEmpty())
                {
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinColor.equals("Fair"))
                    {
                        BeautyProfileActivity.d(a, j.user_profile_skintone_fair);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinColor.equals("Light"))
                    {
                        BeautyProfileActivity.d(a, j.user_profile_skintone_light);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinColor.equals("Medium"))
                    {
                        BeautyProfileActivity.d(a, j.user_profile_skintone_med);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinColor.equals("Deep"))
                    {
                        BeautyProfileActivity.d(a, j.user_profile_skintone_deep);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).skinColor.equals("Dark"))
                    {
                        BeautyProfileActivity.d(a, j.user_profile_skintone_dark);
                    }
                }
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.e(a, -1);
                if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).isSensitive != null)
                {
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).isSensitive.booleanValue())
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.e(a, j.user_profile_skinsensitivity_yes);
                    } else
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.e(a, j.user_profile_skinsensitivity_no);
                    }
                }
                BeautyProfileActivity.f(a, -1);
                if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor != null && !com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor.isEmpty())
                {
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor.equals("Blue"))
                    {
                        BeautyProfileActivity.f(a, j.user_profile_eyecolor_blue);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor.equals("Green"))
                    {
                        BeautyProfileActivity.f(a, j.user_profile_eyecolor_green);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor.equals("Hazel"))
                    {
                        BeautyProfileActivity.f(a, j.user_profile_eyecolor_hazel);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor.equals("DarkBrown"))
                    {
                        BeautyProfileActivity.f(a, j.user_profile_eyecolor_darkbrown);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor.equals("Gray"))
                    {
                        BeautyProfileActivity.f(a, j.user_profile_eyecolor_gray);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).eyeColor.equals("Black"))
                    {
                        BeautyProfileActivity.f(a, j.user_profile_eyecolor_black);
                    }
                }
                BeautyProfileActivity.g(a, -1);
                if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).lashLength != null && !com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).lashLength.isEmpty())
                {
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).lashLength.equals("Short"))
                    {
                        BeautyProfileActivity.g(a, j.user_profile_lashlength_short);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).lashLength.equals("Medium"))
                    {
                        BeautyProfileActivity.g(a, j.user_profile_lashlength_medium);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).lashLength.equals("Long"))
                    {
                        BeautyProfileActivity.g(a, j.user_profile_lashlength_long);
                    }
                }
                BeautyProfileActivity.h(a, -1);
                if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairTexture != null && !com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairTexture.isEmpty())
                {
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairTexture.equals("Fine"))
                    {
                        BeautyProfileActivity.h(a, j.user_profile_hairtexture_fine);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairTexture.equals("Medium"))
                    {
                        BeautyProfileActivity.h(a, j.user_profile_hairtexture_medium);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairTexture.equals("Thick"))
                    {
                        BeautyProfileActivity.h(a, j.user_profile_hairtexture_thick);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairTexture.equals("Coarse"))
                    {
                        BeautyProfileActivity.h(a, j.user_profile_hairtexture_coarse);
                    }
                }
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a, -1);
                if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor != null && !com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor.isEmpty())
                {
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor.equals("Blonde"))
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a, j.user_profile_haircolor_blonde);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor.equals("Red"))
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a, j.user_profile_haircolor_red);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor.equals("Brown"))
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a, j.user_profile_haircolor_brown);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor.equals("DarkBrown"))
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a, j.user_profile_haircolor_darkbrown);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor.equals("Gray"))
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a, j.user_profile_haircolor_gray);
                    } else
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairColor.equals("Black"))
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a, j.user_profile_haircolor_black);
                    }
                }
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.j(a, -1);
                if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairType == null || com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairType.isEmpty()) goto _L2; else goto _L7
_L7:
                if (!com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairType.equals("Straight")) goto _L9; else goto _L8
_L8:
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.j(a, j.user_profile_hairtype_straight);
_L2:
                return avoid;
_L6:
                if (((UserInfo) (avoid)).gender.equals("Male"))
                {
                    BeautyProfileActivity.b(a, j.user_profile_sex_male);
                } else
                if (((UserInfo) (avoid)).gender.equals("Unspecified"))
                {
                    BeautyProfileActivity.b(a, j.user_profile_sex_unspecified);
                }
                continue; /* Loop/switch isn't completed */
_L9:
                if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairType.equals("Wavy"))
                {
                    com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.j(a, j.user_profile_hairtype_wavy);
                    return avoid;
                }
                if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairType.equals("Curly"))
                {
                    com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.j(a, j.user_profile_hairtype_curly);
                    return avoid;
                }
                if (!com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.i(a).hairType.equals("Coils")) goto _L2; else goto _L10
_L10:
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.j(a, j.user_profile_hairtype_coils);
                return avoid;
                if (true) goto _L4; else goto _L11
_L11:
            }

            protected void a(UserInfo userinfo)
            {
                if (userinfo != null)
                {
                    if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a) == 1)
                    {
                        userinfo = a.findViewById(j.user_profile_private_info);
                        if (userinfo != null)
                        {
                            userinfo.setVisibility(8);
                        }
                    } else
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, userinfo);
                    }
                }
                userinfo = com.cyberlink.beautycircle.utility.i.a(com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.j(a));
                if (userinfo != null)
                {
                    com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.k(a).setTime(userinfo);
                    BeautyProfileActivity.l(a);
                }
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.m(a), BeautyProfileActivity.n(a));
                BeautyProfileActivity.b(a, BeautyProfileActivity.o(a), BeautyProfileActivity.p(a));
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, BeautyProfileActivity.q(a), BeautyProfileActivity.r(a));
                BeautyProfileActivity.b(a, com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.s(a), BeautyProfileActivity.t(a));
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, BeautyProfileActivity.u(a), BeautyProfileActivity.v(a));
                BeautyProfileActivity.b(a, BeautyProfileActivity.w(a), com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.x(a));
                BeautyProfileActivity.b(a, BeautyProfileActivity.y(a), BeautyProfileActivity.z(a));
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, BeautyProfileActivity.A(a), BeautyProfileActivity.B(a));
                BeautyProfileActivity.b(a, BeautyProfileActivity.C(a), BeautyProfileActivity.D(a));
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, BeautyProfileActivity.p(a), j.bc_beauty_profile_skin_title_text, m.bc_beauty_profile_skin_title);
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, BeautyProfileActivity.r(a), j.bc_beauty_profile_skintone_title_text, m.bc_beauty_profile_skintone_title);
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, BeautyProfileActivity.t(a), j.bc_beauty_profile_skinsensitivity_title_text, m.bc_beauty_profile_skinsensitivity_title);
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, BeautyProfileActivity.v(a), j.bc_beauty_profile_eyecolor_title_text, m.bc_beauty_profile_eyecolor_title);
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.x(a), j.bc_beauty_profile_lashlength_title_text, m.bc_beauty_profile_lashlength_title);
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, BeautyProfileActivity.z(a), j.bc_beauty_profile_hairtexture_title_text, m.bc_beauty_profile_hairtexture_title);
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, BeautyProfileActivity.B(a), j.bc_beauty_profile_haircolor_title_text, m.bc_beauty_profile_haircolor_title);
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, BeautyProfileActivity.D(a), j.bc_beauty_profile_hairtype_title_text, m.bc_beauty_profile_hairtype_title);
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
                a = BeautyProfileActivity.this;
                super();
            }
        }).executeOnExecutor(com.perfectcorp.utility.j.q, new Void[0]);
    }

    static int[] s(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.q;
    }

    static int t(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.G;
    }

    private void u()
    {
        TextView textview = (TextView)(TextView)findViewById(j.user_profile_beauty_birthday);
        if (textview != null)
        {
            textview.setText(com.cyberlink.beautycircle.utility.i.c(w.getTime()));
        }
        M = com.cyberlink.beautycircle.utility.i.d(w.getTime());
    }

    static int[] u(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.r;
    }

    static int v(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.H;
    }

    private com.cyberlink.beautycircle.controller.activity.a v()
    {
        Object obj2 = null;
        boolean flag1 = true;
        if (O == null)
        {
            return new com.cyberlink.beautycircle.controller.activity.a(this, null, false, null);
        }
        if (E != -1)
        {
            Object obj;
            Object obj1;
            boolean flag;
            boolean flag2;
            boolean flag3;
            if (E == j.user_profile_skin_normal)
            {
                O.skinType = "Normal";
            } else
            if (E == j.user_profile_skin_oily)
            {
                O.skinType = "Oily";
            } else
            if (E == j.user_profile_skin_combo)
            {
                O.skinType = "Combination";
            } else
            {
                O.skinType = "Dry";
            }
            if (N.skinType == null || !N.skinType.equals(O.skinType))
            {
                obj = null;
                flag = true;
                flag2 = true;
            } else
            {
                obj = null;
                flag = false;
                flag2 = true;
            }
        } else
        if (true)
        {
            obj = findViewById(j.bc_beauty_profile_skin_panel);
            flag = false;
            flag2 = false;
        } else
        {
            obj = null;
            flag = false;
            flag2 = false;
        }
        if (F != -1)
        {
label0:
            {
                if (F == j.user_profile_skintone_fair)
                {
                    O.skinColor = "Fair";
                } else
                if (F == j.user_profile_skintone_light)
                {
                    O.skinColor = "Light";
                } else
                if (F == j.user_profile_skintone_med)
                {
                    O.skinColor = "Medium";
                } else
                if (F == j.user_profile_skintone_deep)
                {
                    O.skinColor = "Deep";
                } else
                {
                    O.skinColor = "Dark";
                }
                if (N.skinColor != null)
                {
                    obj1 = obj;
                    flag3 = flag2;
                    if (N.skinColor.equals(O.skinColor))
                    {
                        break label0;
                    }
                }
                flag = true;
                flag3 = flag2;
                obj1 = obj;
            }
        } else
        if (obj == null)
        {
            obj1 = findViewById(j.bc_beauty_profile_skintone_panel);
            flag3 = false;
        } else
        {
            flag3 = false;
            obj1 = obj;
        }
        if (G != -1)
        {
label1:
            {
                if (G == j.user_profile_skinsensitivity_yes)
                {
                    O.isSensitive = Boolean.valueOf(true);
                } else
                {
                    O.isSensitive = Boolean.valueOf(false);
                }
                if (N.isSensitive != null)
                {
                    obj = obj1;
                    flag2 = flag3;
                    if (N.isSensitive.booleanValue() == O.isSensitive.booleanValue())
                    {
                        break label1;
                    }
                }
                flag = true;
                flag2 = flag3;
                obj = obj1;
            }
        } else
        if (obj1 == null)
        {
            obj = findViewById(j.bc_beauty_profile_skinsensitivity_panel);
            flag2 = false;
        } else
        {
            flag2 = false;
            obj = obj1;
        }
        if (H != -1)
        {
label2:
            {
                if (H == j.user_profile_eyecolor_blue)
                {
                    O.eyeColor = "Blue";
                } else
                if (H == j.user_profile_eyecolor_green)
                {
                    O.eyeColor = "Green";
                } else
                if (H == j.user_profile_eyecolor_hazel)
                {
                    O.eyeColor = "Hazel";
                } else
                if (H == j.user_profile_eyecolor_darkbrown)
                {
                    O.eyeColor = "DarkBrown";
                } else
                if (H == j.user_profile_eyecolor_gray)
                {
                    O.eyeColor = "Gray";
                } else
                {
                    O.eyeColor = "Black";
                }
                if (N.eyeColor != null)
                {
                    obj1 = obj;
                    flag3 = flag2;
                    if (N.eyeColor.equals(O.eyeColor))
                    {
                        break label2;
                    }
                }
                flag = true;
                flag3 = flag2;
                obj1 = obj;
            }
        } else
        if (obj == null)
        {
            obj1 = findViewById(j.bc_beauty_profile_eyecolor_panel);
            flag3 = false;
        } else
        {
            flag3 = false;
            obj1 = obj;
        }
        if (I != -1)
        {
label3:
            {
                if (I == j.user_profile_lashlength_short)
                {
                    O.lashLength = "Short";
                } else
                if (I == j.user_profile_lashlength_medium)
                {
                    O.lashLength = "Medium";
                } else
                {
                    O.lashLength = "Long";
                }
                if (N.lashLength != null)
                {
                    obj = obj1;
                    flag2 = flag3;
                    if (N.lashLength.equals(O.lashLength))
                    {
                        break label3;
                    }
                }
                flag = true;
                flag2 = flag3;
                obj = obj1;
            }
        } else
        if (obj1 == null)
        {
            obj = findViewById(j.bc_beauty_profile_lashlength_panel);
            flag2 = false;
        } else
        {
            flag2 = false;
            obj = obj1;
        }
        if (J != -1)
        {
label4:
            {
                if (J == j.user_profile_hairtexture_fine)
                {
                    O.hairTexture = "Fine";
                } else
                if (J == j.user_profile_hairtexture_medium)
                {
                    O.hairTexture = "Medium";
                } else
                if (J == j.user_profile_hairtexture_thick)
                {
                    O.hairTexture = "Thick";
                } else
                {
                    O.hairTexture = "Coarse";
                }
                if (N.hairTexture != null)
                {
                    obj1 = obj;
                    flag3 = flag2;
                    if (N.hairTexture.equals(O.hairTexture))
                    {
                        break label4;
                    }
                }
                flag = true;
                flag3 = flag2;
                obj1 = obj;
            }
        } else
        if (obj == null)
        {
            obj1 = findViewById(j.bc_beauty_profile_hairtexture_panel);
            flag3 = false;
        } else
        {
            flag3 = false;
            obj1 = obj;
        }
label5:
        {
            if (K == -1)
            {
                break MISSING_BLOCK_LABEL_1193;
            }
            if (K == j.user_profile_haircolor_blonde)
            {
                O.hairColor = "Blonde";
            } else
            if (K == j.user_profile_haircolor_red)
            {
                O.hairColor = "Red";
            } else
            if (K == j.user_profile_haircolor_brown)
            {
                O.hairColor = "Brown";
            } else
            if (K == j.user_profile_haircolor_darkbrown)
            {
                O.hairColor = "DarkBrown";
            } else
            if (K == j.user_profile_haircolor_gray)
            {
                O.hairColor = "Gray";
            } else
            {
                O.hairColor = "Black";
            }
            if (N.hairColor != null)
            {
                obj = obj1;
                flag2 = flag3;
                if (N.hairColor.equals(O.hairColor))
                {
                    break label5;
                }
            }
            flag = true;
            flag2 = flag3;
            obj = obj1;
        }
_L2:
        if (L != -1)
        {
            if (L == j.user_profile_hairtype_straight)
            {
                O.hairType = "Straight";
            } else
            if (L == j.user_profile_hairtype_wavy)
            {
                O.hairType = "Wavy";
            } else
            if (L == j.user_profile_hairtype_curly)
            {
                O.hairType = "Curly";
            } else
            {
                O.hairType = "Coils";
            }
            if (N.hairType == null || !N.hairType.equals(O.hairType))
            {
                flag = flag1;
            }
        } else
        if (obj == null)
        {
            obj = findViewById(j.bc_beauty_profile_hairtype_panel);
            flag2 = false;
        } else
        {
            flag2 = false;
        }
        obj1 = obj2;
        if (flag)
        {
            obj1 = O.toString();
        }
        return new com.cyberlink.beautycircle.controller.activity.a(this, ((String) (obj1)), flag2, ((View) (obj)));
        if (obj1 == null)
        {
            obj = findViewById(j.bc_beauty_profile_haircolor_panel);
            flag2 = false;
        } else
        {
            flag2 = false;
            obj = obj1;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    static int[] w(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.s;
    }

    static int x(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.I;
    }

    static int[] y(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.t;
    }

    static int z(BeautyProfileActivity beautyprofileactivity)
    {
        return beautyprofileactivity.J;
    }

    protected void d()
    {
        b().a(0xe4000000, x.a, x.d, 0);
    }

    protected boolean e()
    {
        if (P == 5 || P == 6)
        {
            Object obj = o();
            boolean flag1 = ((b) (obj)).a;
            obj = ((b) (obj)).c;
            com.cyberlink.beautycircle.utility.AccountManager.AccountSource accountsource = AccountManager.f();
            boolean flag;
            if (((UserInfo) (obj)).name.length() != 0 && ((UserInfo) (obj)).phone.length() != 0 && ((UserInfo) (obj)).address.length() == 0 && (accountsource == com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a || accountsource != com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a && ((UserInfo) (obj)).receiveEmail.length() != 0))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag1 || !flag)
            {
                DialogUtils.a(this, null, getResources().getString(m.bc_freesample_fill_data_incompleted), getResources().getString(m.bc_dialog_button_skip), new Runnable() {

                    final BeautyProfileActivity a;

                    public void run()
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, 48259);
                    }

            
            {
                a = BeautyProfileActivity.this;
                super();
            }
                }, getResources().getString(m.bc_dialog_button_continue), null);
                return true;
            }
        }
        c(48259);
        return true;
    }

    public b o()
    {
label0:
        {
            boolean flag2 = true;
            UserInfo userinfo = AccountManager.d();
            Object obj;
            String s1;
            boolean flag;
            boolean flag1;
            boolean flag3;
            if (M != null && (userinfo.birthDay == null || !userinfo.birthDay.equals(M)))
            {
                userinfo.birthDay = M;
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag = flag1;
            if (y == null)
            {
                break label0;
            }
            obj = y.getText().toString();
            if (userinfo.name != null)
            {
                flag = flag1;
                if (userinfo.name.equals(obj))
                {
                    break label0;
                }
            }
            userinfo.name = ((String) (obj));
            flag = flag1 | true;
        }
label1:
        {
            flag1 = flag;
            if (z == null)
            {
                break label1;
            }
            obj = z.getText().toString();
            if (userinfo.phone != null)
            {
                flag1 = flag;
                if (userinfo.phone.equals(obj))
                {
                    break label1;
                }
            }
            userinfo.phone = ((String) (obj));
            flag1 = flag | true;
        }
label2:
        {
            flag = flag1;
            if (A == null)
            {
                break label2;
            }
            flag = flag1;
            if (!A.isEnabled())
            {
                break label2;
            }
            obj = A.getText().toString();
            if (userinfo.receiveEmail != null)
            {
                flag = flag1;
                if (userinfo.receiveEmail.equals(obj))
                {
                    break label2;
                }
            }
            userinfo.receiveEmail = ((String) (obj));
            flag = flag1 | true;
        }
label3:
        {
            flag1 = flag;
            if (B == null)
            {
                break label3;
            }
            obj = B.getText().toString();
            if (userinfo.address != null)
            {
                flag1 = flag;
                if (userinfo.address.equals(obj))
                {
                    break label3;
                }
            }
            userinfo.address = ((String) (obj));
            flag1 = flag | true;
        }
label4:
        {
            obj = null;
            if (D != -1)
            {
                if (D == j.user_profile_sex_female)
                {
                    obj = "Female";
                } else
                if (D == j.user_profile_sex_male)
                {
                    obj = "Male";
                } else
                {
                    obj = "Unspecified";
                }
            }
            flag = flag1;
            if (obj == null)
            {
                break label4;
            }
            if (userinfo.gender != null)
            {
                flag = flag1;
                if (userinfo.gender.equals(obj))
                {
                    break label4;
                }
            }
            userinfo.gender = ((String) (obj));
            flag = flag1 | true;
        }
label5:
        {
            obj = v();
            s1 = ((com.cyberlink.beautycircle.controller.activity.a) (obj)).a;
            if (s1 != null)
            {
                userinfo.attribute = s1;
                flag |= true;
            }
            flag3 = ((com.cyberlink.beautycircle.controller.activity.a) (obj)).b;
            if (userinfo.birthDay != null && userinfo.gender != null && userinfo.attribute != null)
            {
                flag1 = flag2;
                if (flag3)
                {
                    break label5;
                }
            }
            flag1 = false;
        }
        return new b(this, flag1, flag, userinfo, ((com.cyberlink.beautycircle.controller.activity.a) (obj)).c);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_beauty_profile);
        P = getIntent().getIntExtra("EditProfileMode", 0);
        b(m.bc_beauty_profile_basic_title);
        Object obj = (TextView)findViewById(j.user_profile_title_text);
        if (obj != null)
        {
            if (P == 5 || P == 6)
            {
                ((TextView) (obj)).setText(m.bc_beauty_profile_basic_full_fill_description);
            } else
            {
                ((TextView) (obj)).setText(m.bc_beauty_profile_basic_description);
            }
        }
        C = (ScrollView)(ScrollView)findViewById(j.user_profile_scroll_view);
        w = Calendar.getInstance();
        y = (EditText)(EditText)findViewById(j.user_profile_name);
        z = (EditText)(EditText)findViewById(j.user_profile_phone);
        A = (EditText)(EditText)findViewById(j.user_profile_receiveEmail);
        B = (EditText)(EditText)findViewById(j.user_profile_address);
        x = (TextView)(TextView)findViewById(j.user_profile_beauty_birthday);
        if (x != null)
        {
            x.setTag(this);
            x.setOnClickListener(new android.view.View.OnClickListener() {

                final BeautyProfileActivity a;

                public void onClick(View view)
                {
                    ((BeautyProfileActivity)view.getTag()).setBirthday(view);
                }

            
            {
                a = BeautyProfileActivity.this;
                super();
            }
            });
        }
        obj = (Button)(Button)findViewById(j.user_profile_send_btn);
        if (obj != null)
        {
            ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                final BeautyProfileActivity a;

                public void onClick(View view)
                {
                    a.onRightBtnClick(view);
                }

            
            {
                a = BeautyProfileActivity.this;
                super();
            }
            });
            if (P == 5 || P == 6)
            {
                ((Button) (obj)).setVisibility(0);
            } else
            {
                ((Button) (obj)).setVisibility(8);
            }
        }
        a(bundle, false);
        q();
        p();
        r();
    }

    public void onRightBtnClick(View view)
    {
        (new AsyncTask() {

            final BeautyProfileActivity a;

            protected transient b a(Void avoid[])
            {
                return a.o();
            }

            protected void a(b b1)
            {
                boolean flag2 = b1.a;
                boolean flag3 = b1.b;
                UserInfo userinfo = b1.c;
                b1 = b1.d;
                com.cyberlink.beautycircle.utility.AccountManager.AccountSource accountsource = AccountManager.f();
                boolean flag;
                boolean flag1;
                boolean flag4;
                boolean flag5;
                boolean flag6;
                if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a) == 5 || com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a) == 6)
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                if (flag && com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a) != 7)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag4 = com.cyberlink.beautycircle.a.a(BeautyProfileActivity.b(a), a.a, flag1);
                flag5 = com.cyberlink.beautycircle.a.a(com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.c(a), a.a, flag);
                flag6 = com.cyberlink.beautycircle.a.a(BeautyProfileActivity.d(a), a.c, flag1);
                flag1 = com.cyberlink.beautycircle.a.a(com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.e(a), a.b, flag1);
                if (BeautyProfileActivity.f(a).getText().toString().equalsIgnoreCase(a.getResources().getString(m.bc_beauty_profile_birthday_hint)))
                {
                    BeautyProfileActivity.f(a).setSelected(true);
                } else
                {
                    BeautyProfileActivity.f(a).setSelected(false);
                }
                flag4 = flag4 & flag5 & flag6 & flag1;
                if (!flag)
                {
                    (new Handler()).post(new Runnable(this, b1, flag4) {

                        final View a;
                        final boolean b;
                        final _cls4 c;

                        public void run()
                        {
                            if (a == null || !b)
                            {
                                BeautyProfileActivity.g(c.a).scrollTo(0, 0);
                                return;
                            } else
                            {
                                BeautyProfileActivity.g(c.a).scrollTo(0, a.getTop());
                                return;
                            }
                        }

            
            {
                c = _pcls4;
                a = view;
                b = flag;
                super();
            }
                    });
                }
                if (!flag4)
                {
                    if (!flag1)
                    {
                        DialogUtils.a(a, null, a.getResources().getString(m.bc_register_error_invalid_email_format), null, null, a.getResources().getString(m.bc_dialog_button_ok), null);
                        return;
                    } else
                    {
                        DialogUtils.a(a, null, a.getResources().getString(m.bc_beauty_warning_message), null, null, a.getResources().getString(m.bc_dialog_button_ok), null);
                        return;
                    }
                }
                if (!flag)
                {
                    if (!flag2 || userinfo.name.length() == 0 || userinfo.phone.length() == 0 || userinfo.address.length() == 0 || accountsource != com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a && userinfo.receiveEmail.length() == 0)
                    {
                        DialogUtils.a(a, null, a.getResources().getString(m.bc_beauty_warning_message), null, null, a.getResources().getString(m.bc_dialog_button_continue), null);
                        return;
                    } else
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, userinfo, flag3);
                        AccountManager.d(AccountManager.b());
                        return;
                    }
                }
                if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a) == 7)
                {
                    if (userinfo.birthDay == null || userinfo.name.length() == 0 || userinfo.phone.length() == 0 || accountsource != com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a && userinfo.receiveEmail.length() == 0)
                    {
                        DialogUtils.a(a, null, a.getResources().getString(m.bc_beauty_warning_message), null, null, a.getResources().getString(m.bc_dialog_button_continue), null);
                        return;
                    } else
                    {
                        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, userinfo, flag3);
                        AccountManager.d(AccountManager.b());
                        return;
                    }
                }
                if (flag2 || com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a) == 8)
                {
                    com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, userinfo, flag3);
                    AccountManager.d(AccountManager.b());
                    return;
                } else
                {
                    DialogUtils.a(a, null, a.getResources().getString(m.bc_beauty_warning_message), a.getResources().getString(m.bc_dialog_button_skip), new Runnable(this, userinfo, flag3) {

                        final UserInfo a;
                        final boolean b;
                        final _cls4 c;

                        public void run()
                        {
                            com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(c.a, a, b);
                            AccountManager.d(AccountManager.b());
                        }

            
            {
                c = _pcls4;
                a = userinfo;
                b = flag;
                super();
            }
                    }, a.getResources().getString(m.bc_dialog_button_continue), null);
                    return;
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((b)obj);
            }

            
            {
                a = BeautyProfileActivity.this;
                super();
            }
        }).executeOnExecutor(com.perfectcorp.utility.j.q, new Void[0]);
    }

    public void setBirthday(View view)
    {
        (new DatePickerDialog(this, Q, w.get(1), w.get(2), w.get(5))).show();
    }

    public void setOptionSelected(View view)
    {
        a(view);
    }

}
