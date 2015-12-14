// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.fragment.aa;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.i;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.a;
import com.cyberlink.beautycircle.view.widgetpool.common.o;
import com.perfectcorp.a.b;
import java.util.Locale;

public class TutorialActivity extends FragmentActivity
{

    ViewPager a;
    aa b;
    private android.view.View.OnClickListener c;
    private android.view.View.OnClickListener d;
    private android.view.View.OnClickListener e;
    private android.view.View.OnClickListener f;
    private android.view.View.OnClickListener g;
    private android.view.View.OnClickListener h;
    private android.view.View.OnClickListener i;

    public TutorialActivity()
    {
        c = new android.view.View.OnClickListener() {

            final TutorialActivity a;

            public void onClick(View view)
            {
                Globals.a();
                com.perfectcorp.a.b.a(new aq("explore", ""));
            }

            
            {
                a = TutorialActivity.this;
                super();
            }
        };
        d = new android.view.View.OnClickListener() {

            final TutorialActivity a;

            public void onClick(View view)
            {
                Globals.a();
                com.cyberlink.beautycircle.c.a(a, 0, 0, 0);
            }

            
            {
                a = TutorialActivity.this;
                super();
            }
        };
        e = new android.view.View.OnClickListener() {

            final TutorialActivity a;

            public void onClick(View view)
            {
                Globals.a();
                com.cyberlink.beautycircle.c.a(a, 2, 2, 0);
            }

            
            {
                a = TutorialActivity.this;
                super();
            }
        };
        f = new android.view.View.OnClickListener() {

            final TutorialActivity a;

            public void onClick(View view)
            {
                Globals.a();
                com.cyberlink.beautycircle.c.a(a, 2, 5, 0);
            }

            
            {
                a = TutorialActivity.this;
                super();
            }
        };
        g = new android.view.View.OnClickListener() {

            final TutorialActivity a;

            public void onClick(View view)
            {
                Globals.a();
                com.cyberlink.beautycircle.c.a(a, 2, 1, 0);
            }

            
            {
                a = TutorialActivity.this;
                super();
            }
        };
        h = new android.view.View.OnClickListener() {

            final TutorialActivity a;

            public void onClick(View view)
            {
                view = new Dialog(a);
                view.requestWindowFeature(1);
                view.setContentView(k.bc_dialog_share_to_opt);
                view.findViewById(j.itemMore).setVisibility(8);
                ((TextView)view.findViewById(j.bc_dialog_desc)).setText(m.bc_register_more);
                com.cyberlink.beautycircle.controller.adapter.j j1 = new com.cyberlink.beautycircle.controller.adapter.j(a);
                ListView listview = (ListView)view.findViewById(j.content_list);
                listview.setAdapter(j1);
                listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(this, view, j1) {

                    final Dialog a;
                    final com.cyberlink.beautycircle.controller.adapter.j b;
                    final _cls6 c;

                    public void onItemClick(AdapterView adapterview, View view, int l, long l1)
                    {
                        a.dismiss();
                        Globals.a();
                        adapterview = (a)b.getItem(l);
                        if (((a) (adapterview)).b == m.bc_register_fb)
                        {
                            com.cyberlink.beautycircle.c.a(c.a, 0, 1, 0);
                        } else
                        {
                            if (((a) (adapterview)).b == m.bc_register_twitter)
                            {
                                com.cyberlink.beautycircle.c.a(c.a, 0, 3, 0);
                                return;
                            }
                            if (((a) (adapterview)).b == m.bc_register_weibo)
                            {
                                com.cyberlink.beautycircle.c.a(c.a, 0, 2, 0);
                                return;
                            }
                            if (((a) (adapterview)).b == m.bc_register_qq)
                            {
                                com.cyberlink.beautycircle.c.a(c.a, 0, 4, 0);
                                return;
                            }
                            if (((a) (adapterview)).b == m.bc_register_wechat)
                            {
                                com.cyberlink.beautycircle.c.a(c.a, 0, 5, 0);
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
                a = TutorialActivity.this;
                super();
            }
        };
        i = new android.view.View.OnClickListener() {

            final TutorialActivity a;

            public void onClick(View view)
            {
                Globals.a();
                com.cyberlink.beautycircle.c.a(a, 1, 0, 0);
            }

            
            {
                a = TutorialActivity.this;
                super();
            }
        };
    }

    private void a()
    {
label0:
        {
label1:
            {
                View view = findViewById(j.bc_login_panel);
                if (view != null)
                {
                    view.findViewById(j.bc_explore).setOnClickListener(c);
                    view.findViewById(j.bc_email_login).setOnClickListener(d);
                    view.findViewById(j.bc_weibo_login).setOnClickListener(e);
                    view.findViewById(j.bc_weibo_more).setOnClickListener(h);
                    view.findViewById(j.bc_wechat_login).setOnClickListener(f);
                    view.findViewById(j.bc_wechat_more).setOnClickListener(h);
                    view.findViewById(j.bc_fb_login).setOnClickListener(g);
                    view.findViewById(j.bc_fb_more).setOnClickListener(h);
                    view.findViewById(j.bc_have_an_account).setOnClickListener(i);
                    if (!Locale.getDefault().equals(Locale.CHINA))
                    {
                        break label0;
                    }
                    findViewById(j.bc_fb_login_panel).setVisibility(8);
                    if (!Globals.s().equals("YCN"))
                    {
                        break label1;
                    }
                    findViewById(j.bc_weibo_login_panel).setVisibility(8);
                }
                return;
            }
            findViewById(j.bc_wechat_login_panel).setVisibility(8);
            return;
        }
        findViewById(j.bc_weibo_login_panel).setVisibility(8);
        findViewById(j.bc_wechat_login_panel).setVisibility(8);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_tutorial);
        a = (ViewPager)findViewById(j.pager);
        a.setBackgroundColor(0xff000000);
        bundle = new o(j.bc_tutorial_bg);
        bundle.a(0.75F);
        a.setPageTransformer(false, bundle);
        b = new aa(getSupportFragmentManager());
        b.a(a);
        b.a(new com.cyberlink.beautycircle.controller.fragment.TutorialFragment.Tutorial(null, null, Integer.valueOf(m.bc_tutorial_content_1)));
        b.a(new com.cyberlink.beautycircle.controller.fragment.TutorialFragment.Tutorial(Integer.valueOf(i._mg_0123), Integer.valueOf(m.bc_tutorial_title_2), Integer.valueOf(m.bc_tutorial_content_2)));
        b.a(new com.cyberlink.beautycircle.controller.fragment.TutorialFragment.Tutorial(Integer.valueOf(i._beauty_tips), Integer.valueOf(m.bc_tutorial_title_3), Integer.valueOf(m.bc_tutorial_content_3)));
        b.a(new com.cyberlink.beautycircle.controller.fragment.TutorialFragment.Tutorial(Integer.valueOf(i._megan), Integer.valueOf(m.bc_tutorial_title_4), Integer.valueOf(m.bc_tutorial_content_4)));
        a.setAdapter(b);
        a();
    }
}
