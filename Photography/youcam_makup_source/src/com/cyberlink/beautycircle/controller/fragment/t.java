// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.a;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.b;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            g

public abstract class t extends com.cyberlink.beautycircle.controller.fragment.g
{

    static int v = 0;
    private View A;
    private View B;
    private View C;
    private View D;
    private View E;
    private View F;
    private android.view.View.OnClickListener G;
    private android.view.View.OnClickListener H;
    private android.view.View.OnClickListener I;
    private android.view.View.OnClickListener J;
    private android.view.View.OnClickListener K;
    private android.view.View.OnClickListener L;
    private View s;
    private View t;
    protected RelativeLayout u;
    protected android.view.View.OnLongClickListener w;
    private View x;
    private View y;
    private View z;

    public t()
    {
        u = null;
        s = null;
        t = null;
        x = null;
        y = null;
        z = null;
        A = null;
        B = null;
        C = null;
        D = null;
        E = null;
        F = null;
        G = new android.view.View.OnClickListener() {

            final t a;

            public void onClick(View view)
            {
                AccountManager.a(a.getActivity(), 1, new b(this) {

                    final _cls1 a;

                    public void a()
                    {
                    }

                    public void a(String s1)
                    {
                    }

                    public void b()
                    {
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            
            {
                a = t.this;
                super();
            }
        };
        H = new android.view.View.OnClickListener() {

            final t a;

            public void onClick(View view)
            {
                AccountManager.a(a.getActivity(), 0, new b(this) {

                    final _cls2 a;

                    public void a()
                    {
                    }

                    public void a(String s1)
                    {
                    }

                    public void b()
                    {
                    }

            
            {
                a = _pcls2;
                super();
            }
                });
            }

            
            {
                a = t.this;
                super();
            }
        };
        I = new android.view.View.OnClickListener() {

            final t a;

            public void onClick(View view)
            {
                c.a(a.getActivity(), 0, 1, 0);
            }

            
            {
                a = t.this;
                super();
            }
        };
        J = new android.view.View.OnClickListener() {

            final t a;

            public void onClick(View view)
            {
                c.a(a.getActivity(), 0, 2, 0);
            }

            
            {
                a = t.this;
                super();
            }
        };
        K = new android.view.View.OnClickListener() {

            final t a;

            public void onClick(View view)
            {
                c.a(a.getActivity(), 0, 5, 0);
            }

            
            {
                a = t.this;
                super();
            }
        };
        L = new android.view.View.OnClickListener() {

            final t a;

            public void onClick(View view)
            {
                view = new Dialog(a.getActivity());
                view.requestWindowFeature(1);
                view.setContentView(k.bc_dialog_share_to_opt);
                view.findViewById(j.itemMore).setVisibility(8);
                ((TextView)view.findViewById(j.bc_dialog_desc)).setText(m.bc_register_more);
                com.cyberlink.beautycircle.controller.adapter.j j1 = new com.cyberlink.beautycircle.controller.adapter.j(a.getActivity());
                ListView listview = (ListView)view.findViewById(j.content_list);
                listview.setAdapter(j1);
                listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(this, view, j1) {

                    final Dialog a;
                    final com.cyberlink.beautycircle.controller.adapter.j b;
                    final _cls6 c;

                    public void onItemClick(AdapterView adapterview, View view, int i, long l)
                    {
                        a.dismiss();
                        adapterview = (a)b.getItem(i);
                        if (((a) (adapterview)).b == m.bc_register_fb)
                        {
                            com.cyberlink.beautycircle.c.a(c.a.getActivity(), 0, 1, 0);
                        } else
                        {
                            if (((a) (adapterview)).b == m.bc_register_twitter)
                            {
                                com.cyberlink.beautycircle.c.a(c.a.getActivity(), 0, 3, 0);
                                return;
                            }
                            if (((a) (adapterview)).b == m.bc_register_weibo)
                            {
                                com.cyberlink.beautycircle.c.a(c.a.getActivity(), 0, 2, 0);
                                return;
                            }
                            if (((a) (adapterview)).b == m.bc_register_qq)
                            {
                                com.cyberlink.beautycircle.c.a(c.a.getActivity(), 0, 4, 0);
                                return;
                            }
                            if (((a) (adapterview)).b == m.bc_register_wechat)
                            {
                                com.cyberlink.beautycircle.c.a(c.a.getActivity(), 0, 5, 0);
                                return;
                            }
                        }
                    }

            
            {
                c = _pcls6;
                a = dialog;
                b = j1;
                super();
            }
                });
                view.getWindow().setBackgroundDrawableResource(g.bc_color_transparent);
                view.show();
            }

            
            {
                a = t.this;
                super();
            }
        };
        w = new android.view.View.OnLongClickListener() {

            final t a;

            public boolean onLongClick(View view)
            {
                t.v++;
                if (t.v >= 3)
                {
                    t.v = 0;
                    view = a.getActivity();
                    if (view instanceof MainActivity)
                    {
                        ((MainActivity)view).v();
                    }
                }
                return false;
            }

            
            {
                a = t.this;
                super();
            }
        };
    }

    protected void d(boolean flag)
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        if (u != null && fragmentactivity != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        u.setVisibility(0);
        if (s == null)
        {
            s = fragmentactivity.getLayoutInflater().inflate(k.bc_view_me_sign_in, u);
            t = s.findViewById(j.bc_have_an_account);
            x = s.findViewById(j.bc_email_login);
            y = s.findViewById(j.bc_fb_login);
            z = s.findViewById(j.bc_weibo_login);
            A = s.findViewById(j.bc_wechat_login);
            B = s.findViewById(j.bc_fb_login_panel);
            C = s.findViewById(j.bc_weibo_login_panel);
            D = s.findViewById(j.bc_wechat_login_panel);
            if (Locale.getDefault().equals(Locale.CHINA))
            {
                if (Globals.s().equals("YCN"))
                {
                    E = s.findViewById(j.bc_wechat_more);
                    if (C != null)
                    {
                        C.setVisibility(8);
                    }
                } else
                {
                    E = s.findViewById(j.bc_weibo_more);
                    if (D != null)
                    {
                        D.setVisibility(8);
                    }
                }
                if (B != null)
                {
                    B.setVisibility(8);
                }
            } else
            {
                E = s.findViewById(j.bc_fb_more);
                if (C != null)
                {
                    C.setVisibility(8);
                }
                if (D != null)
                {
                    D.setVisibility(8);
                }
            }
            F = (TextView)s.findViewById(j.bc_welcome_desc_text);
        }
        if (t != null)
        {
            t.setOnClickListener(G);
        }
        if (x != null)
        {
            x.setOnClickListener(H);
        }
        if (y != null)
        {
            y.setOnClickListener(I);
        }
        if (z != null)
        {
            z.setOnClickListener(J);
        }
        if (A != null)
        {
            A.setOnClickListener(K);
        }
        if (E != null)
        {
            E.setOnClickListener(L);
        }
        if (F != null)
        {
            F.setOnLongClickListener(w);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (u != null)
        {
            u.setVisibility(8);
        }
        if (t != null)
        {
            t.setOnClickListener(null);
        }
        if (t != null)
        {
            t.setOnLongClickListener(null);
        }
        if (x != null)
        {
            x.setOnClickListener(null);
        }
        if (y != null)
        {
            y.setOnClickListener(null);
        }
        if (z != null)
        {
            z.setOnClickListener(null);
        }
        if (A != null)
        {
            A.setOnClickListener(null);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

}
