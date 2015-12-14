// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseFbActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.ad;
import com.cyberlink.beautycircle.controller.a.ai;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.ar;
import com.cyberlink.beautycircle.controller.a.as;
import com.cyberlink.beautycircle.controller.a.at;
import com.cyberlink.beautycircle.d;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.WeiboAccountInfo;
import com.cyberlink.beautycircle.model.a;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.model.network.h;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.QQUtils;
import com.cyberlink.beautycircle.utility.TwitterUtils;
import com.cyberlink.beautycircle.utility.ae;
import com.cyberlink.beautycircle.utility.ag;
import com.cyberlink.beautycircle.utility.ah;
import com.cyberlink.beautycircle.utility.i;
import com.cyberlink.beautycircle.utility.r;
import com.cyberlink.beautycircle.utility.s;
import com.cyberlink.beautycircle.view.widgetpool.common.PostContentTextView;
import com.cyberlink.beautycircle.view.widgetpool.facebook.LoginButton;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import com.nostra13.universalimageloader.core.f;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.ConfigHelper;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.g;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.l;
import com.rockerhieu.emojicon.EmojiconTextView;
import com.sina.weibo.sdk.exception.WeiboException;
import java.util.Locale;
import java.util.Stack;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oauth.signpost.OAuthConsumer;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            l, m

public class RegisterActivity extends BaseFbActivity
{

    public static final UUID e = UUID.randomUUID();
    private View A;
    private ae B;
    private QQUtils C;
    private TwitterUtils D;
    private android.view.View.OnClickListener E;
    private com.cyberlink.beautycircle.utility.ai F;
    private android.view.View.OnClickListener G;
    protected android.view.View.OnClickListener f;
    protected android.view.View.OnClickListener g;
    protected android.view.View.OnClickListener o;
    protected android.view.View.OnClickListener p;
    protected android.view.View.OnClickListener q;
    private int r;
    private int s;
    private PageMode t;
    private String u;
    private Stack v;
    private boolean w;
    private TextView x;
    private View y;
    private EmojiconTextView z;

    public RegisterActivity()
    {
        r = 0;
        s = 0;
        t = com.cyberlink.beautycircle.controller.activity.PageMode.a;
        u = "";
        v = new Stack();
        w = false;
        x = null;
        y = null;
        z = null;
        A = null;
        B = null;
        C = null;
        D = null;
        f = new android.view.View.OnClickListener() {

            final RegisterActivity a;

            public void onClick(View view)
            {
                a.e();
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        };
        g = new android.view.View.OnClickListener() {

            final RegisterActivity a;

            public void onClick(View view)
            {
                view = (EditText)a.findViewById(com.cyberlink.beautycircle.j.register_id);
                EditText edittext = (EditText)a.findViewById(com.cyberlink.beautycircle.j.register_password);
                if (view != null && edittext != null && com.cyberlink.beautycircle.controller.activity.RegisterActivity.d(a) != null)
                {
                    String s1 = view.getText().toString();
                    String s2 = edittext.getText().toString();
                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.d(a).setVisibility(8);
                    if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a) == com.cyberlink.beautycircle.controller.activity.PageMode.a)
                    {
                        if (!Patterns.EMAIL_ADDRESS.matcher(s1).matches())
                        {
                            view.requestFocus();
                            a.showSoftInput(view);
                            com.cyberlink.beautycircle.controller.activity.RegisterActivity.d(a).setText(m.bc_register_error_invalid_email_format);
                            com.cyberlink.beautycircle.controller.activity.RegisterActivity.d(a).setVisibility(0);
                            return;
                        }
                        if (!a.f(s2))
                        {
                            edittext.requestFocus();
                            a.showSoftInput(edittext);
                            com.cyberlink.beautycircle.controller.activity.RegisterActivity.d(a).setText(m.bc_register_error_invalid_password_format);
                            com.cyberlink.beautycircle.controller.activity.RegisterActivity.d(a).setVisibility(0);
                            return;
                        }
                        a.k();
                        AccountManager.c(s1);
                        NetworkUser.b(s1, "", s2).a(new com.cyberlink.beautycircle.controller.activity.l(a));
                        com.perfectcorp.a.b.a(new at("create_account"));
                        if (Globals.l)
                        {
                            if (Globals.k)
                            {
                                com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.b("A", "BC_welcome_page_0819"));
                                return;
                            } else
                            {
                                com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.b("B", "BC_welcome_page_0819"));
                                return;
                            }
                        }
                    } else
                    if (!Patterns.EMAIL_ADDRESS.matcher(s1).matches())
                    {
                        view.requestFocus();
                        a.showSoftInput(view);
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.d(a).setText(m.bc_register_error_invalid_email_format);
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.d(a).setVisibility(0);
                        return;
                    } else
                    {
                        a.k();
                        AccountManager.c(s1);
                        NetworkUser.a(s1, s2).a(new com.cyberlink.beautycircle.controller.activity.m(a));
                        com.perfectcorp.a.b.a(new as("log_in"));
                        return;
                    }
                }
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        };
        o = new android.view.View.OnClickListener() {

            final RegisterActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a, com.cyberlink.beautycircle.controller.activity.PageMode.b, true, true);
                com.perfectcorp.a.b.a(new at("log_in"));
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        };
        p = new android.view.View.OnClickListener() {

            final RegisterActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a, com.cyberlink.beautycircle.controller.activity.PageMode.a, true, true);
                com.perfectcorp.a.b.a(new as("sign_up"));
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        };
        q = new android.view.View.OnClickListener() {

            final RegisterActivity a;

            public void onClick(View view)
            {
                view = ((EditText)a.findViewById(com.cyberlink.beautycircle.j.register_id)).getText().toString();
                com.cyberlink.beautycircle.c.a(a, view);
                com.perfectcorp.a.b.a(new as("forgot_password"));
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        };
        E = new android.view.View.OnClickListener() {

            final RegisterActivity a;

            public void onClick(View view)
            {
label0:
                {
                    if (a.i != null)
                    {
                        view = Session.getActiveSession();
                        if (!view.isOpened())
                        {
                            break label0;
                        }
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a, view);
                    }
                    return;
                }
                a.l = true;
                a.i.performClick();
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        };
        F = new com.cyberlink.beautycircle.utility.ai() {

            final RegisterActivity a;

            public void a()
            {
                if (a.j.a())
                {
                    a.k();
                    NetworkUser.a("Weibo", a.j.b(), null).a(new com.perfectcorp.utility.m(this) {

                        final _cls6 a;

                        protected void a(int i1)
                        {
                            a.a.l();
                            DialogUtils.a(a.a, a.a.getResources().getString(m.bc_register_weibo_sign_in_failed));
                            com.perfectcorp.a.b.a(new aq("weibo", "no"));
                        }

                        protected void a(com.cyberlink.beautycircle.model.UserInfo.SignInResult signinresult)
                        {
                            AccountManager.a(com.cyberlink.beautycircle.utility.AccountManager.AccountSource.c);
                            com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a.a, com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a.a, signinresult.userInfo));
                            if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.f(a.a))
                            {
                                com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a.a, signinresult.token, signinresult.userInfo);
                            } else
                            {
                                RegisterActivity registeractivity = a.a;
                                String s1 = signinresult.token;
                                UserInfo userinfo = signinresult.userInfo;
                                long l1;
                                if (signinresult.userInfo != null)
                                {
                                    l1 = signinresult.userInfo.id;
                                } else
                                {
                                    l1 = -1L;
                                }
                                com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(registeractivity, s1, userinfo, l1);
                            }
                            if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) != com.cyberlink.beautycircle.controller.activity.PageMode.a) goto _L2; else goto _L1
_L1:
                            com.perfectcorp.a.b.a(new at("weibo"));
_L4:
                            com.perfectcorp.a.b.a(new aq("weibo", "yes"));
                            return;
_L2:
                            if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.PageMode.b)
                            {
                                com.perfectcorp.a.b.a(new as("weibo"));
                            } else
                            if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.PageMode.c || com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.PageMode.d)
                            {
                                com.perfectcorp.a.b.a(new ar("weibo"));
                            }
                            if (true) goto _L4; else goto _L3
_L3:
                        }

                        protected void b(Object obj)
                        {
                            a((com.cyberlink.beautycircle.model.UserInfo.SignInResult)obj);
                        }

            
            {
                a = _pcls6;
                super();
            }
                    });
                    return;
                } else
                {
                    DialogUtils.a(a, a.getResources().getString(m.bc_register_weibo_sign_in_failed));
                    Globals.b("Invalid Weibo token.");
                    com.perfectcorp.a.b.a(new aq("weibo", "no"));
                    return;
                }
            }

            public void a(WeiboException weiboexception)
            {
                DialogUtils.a(a, a.getResources().getString(m.bc_register_weibo_sign_in_failed));
                if (weiboexception != null && weiboexception.toString() != null)
                {
                    weiboexception = weiboexception.toString();
                } else
                {
                    weiboexception = "Unknow error";
                }
                Globals.b(weiboexception);
                com.perfectcorp.a.b.a(new aq("weibo", "no"));
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        };
        G = new android.view.View.OnClickListener() {

            final RegisterActivity a;

            public void onClick(View view)
            {
                view = new Dialog(a);
                view.requestWindowFeature(1);
                view.setContentView(k.bc_dialog_share_to_opt);
                view.findViewById(com.cyberlink.beautycircle.j.itemMore).setVisibility(8);
                ((TextView)view.findViewById(com.cyberlink.beautycircle.j.bc_dialog_desc)).setText(m.bc_register_more);
                com.cyberlink.beautycircle.controller.adapter.j j1 = new com.cyberlink.beautycircle.controller.adapter.j(a);
                ListView listview = (ListView)view.findViewById(com.cyberlink.beautycircle.j.content_list);
                listview.setAdapter(j1);
                listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(this, view, j1) {

                    final Dialog a;
                    final com.cyberlink.beautycircle.controller.adapter.j b;
                    final _cls20 c;

                    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
                    {
                        a.dismiss();
                        adapterview = (a)b.getItem(i1);
                        if (((a) (adapterview)).b == m.bc_register_fb)
                        {
                            com.cyberlink.beautycircle.controller.activity.RegisterActivity.j(c.a).onClick(view);
                        } else
                        {
                            if (((a) (adapterview)).b == m.bc_register_twitter)
                            {
                                com.cyberlink.beautycircle.controller.activity.RegisterActivity.k(c.a);
                                return;
                            }
                            if (((a) (adapterview)).b == m.bc_register_weibo)
                            {
                                com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(c.a);
                                return;
                            }
                            if (((a) (adapterview)).b == m.bc_register_qq)
                            {
                                com.cyberlink.beautycircle.controller.activity.RegisterActivity.l(c.a);
                                return;
                            }
                            if (((a) (adapterview)).b == m.bc_register_wechat)
                            {
                                com.cyberlink.beautycircle.controller.activity.RegisterActivity.b(c.a);
                                return;
                            }
                        }
                    }

            
            {
                c = _pcls20;
                a = dialog;
                b = j1;
                super();
            }
                });
                view.getWindow().setBackgroundDrawableResource(com.cyberlink.beautycircle.g.bc_color_transparent);
                view.show();
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        };
    }

    static j a(RegisterActivity registeractivity, String s1, UserInfo userinfo, long l1)
    {
        return registeractivity.a(s1, userinfo, l1);
    }

    private j a(String s1, UserInfo userinfo, long l1)
    {
        return NetworkUser.a(l1, Long.valueOf(l1), s1).a(new j(userinfo, s1) {

            final UserInfo a;
            final String b;
            final RegisterActivity c;

            protected UserInfo a(UserInfo userinfo1)
            {
                UserInfo userinfo2 = userinfo1;
                if (userinfo1 == null)
                {
                    userinfo2 = a;
                }
                com.cyberlink.beautycircle.controller.activity.RegisterActivity.b(c, b, userinfo2);
                return userinfo2;
            }

            protected volatile Object a(Object obj)
            {
                return a((UserInfo)obj);
            }

            protected void a()
            {
                com.cyberlink.beautycircle.controller.activity.RegisterActivity.b(c, b, a);
                super.a();
            }

            protected void a(int i1)
            {
                if (i1 == 420)
                {
                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(c, 48258);
                } else
                {
                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.b(c, b, a);
                }
                Globals.b((new StringBuilder()).append("Code:'").append(i1).toString());
                super.a(i1);
            }

            
            {
                c = RegisterActivity.this;
                a = userinfo;
                b = s1;
                super();
            }
        });
    }

    private void a(PageMode pagemode, boolean flag, boolean flag1)
    {
        if (e.a)
        {
            EditText edittext = (EditText)findViewById(com.cyberlink.beautycircle.j.register_id);
            EditText edittext1 = (EditText)findViewById(com.cyberlink.beautycircle.j.register_password);
            edittext.setText(ConfigHelper.a(com.perfectcorp.utility.ConfigHelper.Configs.a, ""));
            edittext1.setText(ConfigHelper.a(com.perfectcorp.utility.ConfigHelper.Configs.b, ""));
        }
        if (flag)
        {
            v.push(t);
        }
        t = pagemode;
        pagemode = (LinearLayout)findViewById(com.cyberlink.beautycircle.j.register_info_panel);
        Object obj = findViewById(com.cyberlink.beautycircle.j.bc_fb_login_panel);
        Object obj1 = findViewById(com.cyberlink.beautycircle.j.bc_weibo_login_panel);
        View view = findViewById(com.cyberlink.beautycircle.j.bc_wechat_login_panel);
        if (t == com.cyberlink.beautycircle.controller.activity.PageMode.a)
        {
            pagemode.setGravity(49);
            if (z != null)
            {
                z.setText(m.bc_register_title);
            }
            ((View) (obj)).setVisibility(4);
            ((View) (obj1)).setVisibility(8);
            view.setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.bc_welcome_desc_text).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.bc_email_login).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.bc_have_an_account).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.bc_or_saperate).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_id).setVisibility(0);
            findViewById(com.cyberlink.beautycircle.j.register_password).setVisibility(0);
            findViewById(com.cyberlink.beautycircle.j.register_link_sign_in).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_link_forget_password).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_link_new_account).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_wrong_info).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_accept_btn).setVisibility(0);
            obj = String.format(Locale.getDefault(), getResources().getString(m.bc_register_desc_sign_up), new Object[] {
                getResources().getString(m.bc_url_privacy_policy), getResources().getString(m.bc_url_terms_of_service)
            });
            obj1 = (PostContentTextView)findViewById(com.cyberlink.beautycircle.j.register_description_text);
            if (obj1 != null)
            {
                ((PostContentTextView) (obj1)).setVisibility(0);
                ((PostContentTextView) (obj1)).setText(Html.fromHtml(((String) (obj))));
            }
            ((Button)findViewById(com.cyberlink.beautycircle.j.register_accept_btn)).setText(m.bc_register_sign_up);
            ((EditText)findViewById(com.cyberlink.beautycircle.j.register_password)).setHint(m.bc_register_password_hint);
        } else
        if (t == com.cyberlink.beautycircle.controller.activity.PageMode.b)
        {
            pagemode.setGravity(49);
            if (z != null)
            {
                z.setText(m.bc_register_title_login);
            }
            if (Locale.getDefault().equals(Locale.CHINA))
            {
                ((View) (obj)).setVisibility(8);
                if (Globals.s().equals("YCN"))
                {
                    ((View) (obj1)).setVisibility(8);
                    view.setVisibility(0);
                } else
                {
                    ((View) (obj1)).setVisibility(0);
                    view.setVisibility(8);
                }
            } else
            {
                ((View) (obj)).setVisibility(0);
                ((View) (obj1)).setVisibility(8);
                view.setVisibility(8);
            }
            obj = findViewById(com.cyberlink.beautycircle.j.bc_fb_login);
            if (obj != null)
            {
                ((TextView)((View) (obj)).findViewById(com.cyberlink.beautycircle.j.bc_fb_btn_text)).setText(m.bc_welcome_btn_login_fb);
            }
            obj = findViewById(com.cyberlink.beautycircle.j.bc_weibo_login);
            if (obj != null)
            {
                ((TextView)((View) (obj)).findViewById(com.cyberlink.beautycircle.j.bc_weibo_btn_text)).setText(m.bc_welcome_btn_login_weibo);
            }
            findViewById(com.cyberlink.beautycircle.j.bc_welcome_desc_text).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.bc_email_login).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.bc_have_an_account).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.bc_or_saperate).setVisibility(0);
            findViewById(com.cyberlink.beautycircle.j.register_id).setVisibility(0);
            findViewById(com.cyberlink.beautycircle.j.register_password).setVisibility(0);
            findViewById(com.cyberlink.beautycircle.j.register_link_sign_in).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_link_forget_password).setVisibility(0);
            findViewById(com.cyberlink.beautycircle.j.register_link_new_account).setVisibility(0);
            findViewById(com.cyberlink.beautycircle.j.register_wrong_info).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_accept_btn).setVisibility(0);
            obj = (PostContentTextView)findViewById(com.cyberlink.beautycircle.j.register_description_text);
            if (obj != null)
            {
                ((PostContentTextView) (obj)).setVisibility(8);
            }
            ((Button)findViewById(com.cyberlink.beautycircle.j.register_accept_btn)).setText(m.bc_register_sign_in);
            ((EditText)findViewById(com.cyberlink.beautycircle.j.register_password)).setHint(m.bc_register_password_hint_no_limit);
        } else
        {
            pagemode.setGravity(81);
            if (z != null)
            {
                z.setText("");
            }
            if (Locale.getDefault().equals(Locale.CHINA))
            {
                ((View) (obj)).setVisibility(8);
                if (Globals.s().equals("YCN"))
                {
                    ((View) (obj1)).setVisibility(8);
                    view.setVisibility(0);
                } else
                {
                    ((View) (obj1)).setVisibility(0);
                    view.setVisibility(8);
                }
            } else
            {
                ((View) (obj)).setVisibility(0);
                ((View) (obj1)).setVisibility(8);
                view.setVisibility(8);
            }
            ((TextView)((View) (obj)).findViewById(com.cyberlink.beautycircle.j.bc_fb_btn_text)).setText(m.bc_welcome_btn_connect_fb);
            ((TextView)((View) (obj1)).findViewById(com.cyberlink.beautycircle.j.bc_weibo_btn_text)).setText(m.bc_welcome_btn_connect_weibo);
            if (t == com.cyberlink.beautycircle.controller.activity.PageMode.d)
            {
                obj = getString(m.bc_welcome_consultation, new Object[] {
                    u
                });
                ((TextView)findViewById(com.cyberlink.beautycircle.j.bc_welcome_desc_text)).setText(((CharSequence) (obj)));
            }
            findViewById(com.cyberlink.beautycircle.j.bc_welcome_desc_text).setVisibility(0);
            findViewById(com.cyberlink.beautycircle.j.bc_email_login).setVisibility(0);
            findViewById(com.cyberlink.beautycircle.j.bc_have_an_account).setVisibility(0);
            findViewById(com.cyberlink.beautycircle.j.bc_or_saperate).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_id).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_password).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_link_sign_in).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_link_forget_password).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_link_new_account).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_wrong_info).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_accept_btn).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.register_description_text).setVisibility(8);
            ((Button)findViewById(com.cyberlink.beautycircle.j.register_accept_btn)).setText(m.bc_register_sign_in);
        }
        if (flag1)
        {
            ObjectAnimator.ofFloat(pagemode, "alpha", new float[] {
                0.0F, 1.0F
            }).setDuration(500L).start();
        }
    }

    static void a(RegisterActivity registeractivity)
    {
        registeractivity.p();
    }

    static void a(RegisterActivity registeractivity, int i1)
    {
        registeractivity.c(i1);
    }

    static void a(RegisterActivity registeractivity, PageMode pagemode, boolean flag, boolean flag1)
    {
        registeractivity.a(pagemode, flag, flag1);
    }

    static void a(RegisterActivity registeractivity, Session session)
    {
        registeractivity.a(session);
    }

    static void a(RegisterActivity registeractivity, Session session, String s1, UserInfo userinfo)
    {
        registeractivity.a(session, s1, userinfo);
    }

    static void a(RegisterActivity registeractivity, Session session, String s1, UserInfo userinfo, com.cyberlink.beautycircle.utility.c c1)
    {
        registeractivity.a(session, s1, userinfo, c1);
    }

    static void a(RegisterActivity registeractivity, String s1, UserInfo userinfo)
    {
        registeractivity.b(s1, userinfo);
    }

    static void a(RegisterActivity registeractivity, String s1, UserInfo userinfo, long l1, long l2)
    {
        registeractivity.a(s1, userinfo, l1, l2);
    }

    private void a(Session session)
    {
        k();
        NetworkUser.a("Facebook", session.getAccessToken(), null).a(new com.perfectcorp.utility.m(session) {

            final Session a;
            final RegisterActivity b;

            protected void a(int i1)
            {
                b.l();
                if (b.i != null)
                {
                    b.i.b();
                }
                DialogUtils.a(b, b.getResources().getString(m.bc_register_facebook_sign_in_failed));
                com.perfectcorp.a.b.a(new aq("facebook", "no"));
            }

            protected void a(com.cyberlink.beautycircle.model.UserInfo.SignInResult signinresult)
            {
                AccountManager.a(com.cyberlink.beautycircle.utility.AccountManager.AccountSource.b);
                com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(b, com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(b, signinresult.userInfo));
                if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.f(b))
                {
                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(b, a, signinresult.token, signinresult.userInfo);
                } else
                {
                    RegisterActivity registeractivity = b;
                    String s1 = signinresult.token;
                    UserInfo userinfo = signinresult.userInfo;
                    long l1;
                    if (signinresult.userInfo != null)
                    {
                        l1 = signinresult.userInfo.id;
                    } else
                    {
                        l1 = -1L;
                    }
                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(registeractivity, s1, userinfo, l1).a(new j(this, signinresult) {

                        final com.cyberlink.beautycircle.model.UserInfo.SignInResult a;
                        final _cls4 b;

                        protected UserInfo a(UserInfo userinfo)
                        {
                            if (userinfo.receiveEmail == null || userinfo.receiveEmail.isEmpty())
                            {
                                com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(b.b, b.a, a.token, userinfo, null);
                            }
                            return null;
                        }

                        protected volatile Object a(Object obj)
                        {
                            return a((UserInfo)obj);
                        }

            
            {
                b = _pcls4;
                a = signinresult;
                super();
            }
                    });
                }
                if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(b) != com.cyberlink.beautycircle.controller.activity.PageMode.a) goto _L2; else goto _L1
_L1:
                com.perfectcorp.a.b.a(new at("facebook"));
_L4:
                com.perfectcorp.a.b.a(new aq("facebook", "yes"));
                return;
_L2:
                if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(b) == com.cyberlink.beautycircle.controller.activity.PageMode.a)
                {
                    com.perfectcorp.a.b.a(new as("facebook"));
                } else
                if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(b) == com.cyberlink.beautycircle.controller.activity.PageMode.c || com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(b) == com.cyberlink.beautycircle.controller.activity.PageMode.d)
                {
                    com.perfectcorp.a.b.a(new ar("facebook"));
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            protected void b(Object obj)
            {
                a((com.cyberlink.beautycircle.model.UserInfo.SignInResult)obj);
            }

            
            {
                b = RegisterActivity.this;
                a = session;
                super();
            }
        });
    }

    private void a(Session session, String s1, UserInfo userinfo)
    {
        runOnUiThread(new Runnable(session, userinfo, s1) {

            final Session a;
            final UserInfo b;
            final String c;
            final RegisterActivity d;

            public void run()
            {
                Request.newMeRequest(a, new com.facebook.Request.GraphUserCallback(this) {

                    final _cls5 a;

                    public void onCompleted(GraphUser graphuser, Response response)
                    {
                        if (graphuser != null)
                        {
                            (new AsyncTask(this, graphuser) {

                                final GraphUser a;
                                final _cls1 b;

                                protected transient Void a(Void avoid[])
                                {
                                    b.a.b.displayName = a.getName();
                                    avoid = (String)a.getProperty("email");
                                    b.a.b.receiveEmail = avoid;
                                    AccountManager.c(avoid);
                                    avoid = (String)a.getProperty("gender");
                                    if (avoid == null) goto _L2; else goto _L1
_L1:
                                    if (!avoid.equals("male")) goto _L4; else goto _L3
_L3:
                                    b.a.b.gender = "Male";
_L2:
                                    avoid = com.cyberlink.beautycircle.utility.i.a(a.getBirthday(), "MM/dd/yyyy", "yyyy-MM-dd");
                                    b.a.b.birthDay = avoid;
                                    b.a.b.description = (String)a.getProperty("bio");
                                    avoid = a.getId();
                                    avoid = (new StringBuilder()).append("http://graph.facebook.com/").append(avoid).append("/picture?width=").append(320).append("&height=").append(320).toString();
                                    if (!com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(b.a.d, b.a.c, avoid, b.a.b))
                                    {
                                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(b.a.d, b.a.c, b.a.b, -1L, -1L);
                                    }
                                    return null;
_L4:
                                    if (avoid.equals("female"))
                                    {
                                        b.a.b.gender = "Female";
                                    }
                                    if (true) goto _L2; else goto _L5
_L5:
                                }

                                protected Object doInBackground(Object aobj[])
                                {
                                    return a((Void[])aobj);
                                }

            
            {
                b = _pcls1;
                a = graphuser;
                super();
            }
                            }).executeOnExecutor(j.q, new Void[0]);
                            return;
                        } else
                        {
                            com.perfectcorp.utility.e.b(new Object[] {
                                "Can't get GraphUser."
                            });
                            return;
                        }
                    }

            
            {
                a = _pcls5;
                super();
            }
                }).executeAsync();
            }

            
            {
                d = RegisterActivity.this;
                a = session;
                b = userinfo;
                c = s1;
                super();
            }
        });
    }

    private void a(String s1, UserInfo userinfo)
    {
        AccountManager.a(s1, userinfo, true).a(new com.perfectcorp.utility.m() {

            final RegisterActivity a;

            protected void a(Boolean boolean1)
            {
                if (boolean1.booleanValue())
                {
                    a.l();
                    Globals.a(a.getResources().getString(m.bc_register_sign_in_success));
                    a.o();
                    return;
                } else
                {
                    AccountManager.h();
                    a.l();
                    DialogUtils.a(a, a.getResources().getString(m.bc_register_error_account_info));
                    return;
                }
            }

            protected void b(Object obj)
            {
                a((Boolean)obj);
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        });
    }

    private void a(String s1, UserInfo userinfo, long l1, long l2)
    {
        if (s1 == null || userinfo == null)
        {
            a(s1, userinfo);
            return;
        } else
        {
            AccountManager.a = w;
            AccountManager.b(userinfo.region);
            NetworkUser.a(s1, userinfo.displayName, Long.valueOf(l1), Long.valueOf(l2), userinfo.description, userinfo.gender, userinfo.region, userinfo.birthDay, userinfo.attribute, userinfo.name, userinfo.phone, userinfo.receiveEmail, userinfo.address, userinfo.websiteUrl).a(new com.perfectcorp.utility.m(s1, userinfo, l1, l2) {

                final String a;
                final UserInfo b;
                final long c;
                final long d;
                final RegisterActivity e;

                protected void a()
                {
                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.b(e, a, b);
                }

                protected void a(int i1)
                {
                    Globals.b((new StringBuilder()).append("Code:'").append(i1).toString());
                    if (i1 == 445)
                    {
                        b.displayName = AccountManager.e();
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(e, a, b, c, d);
                        return;
                    }
                    if (i1 == 420)
                    {
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(e, 48258);
                        return;
                    } else
                    {
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.b(e, a, b);
                        return;
                    }
                }

                protected void a(com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse updateuserresponse)
                {
                    try
                    {
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(e, a, b, updateuserresponse.userId);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse updateuserresponse)
                    {
                        updateuserresponse.printStackTrace();
                    }
                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.b(e, a, b);
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse)obj);
                }

            
            {
                e = RegisterActivity.this;
                a = s1;
                b = userinfo;
                c = l1;
                d = l2;
                super();
            }
            });
            return;
        }
    }

    static boolean a(RegisterActivity registeractivity, UserInfo userinfo)
    {
        return registeractivity.a(userinfo);
    }

    static boolean a(RegisterActivity registeractivity, String s1, String s2, UserInfo userinfo)
    {
        return registeractivity.a(s1, s2, userinfo);
    }

    static boolean a(RegisterActivity registeractivity, boolean flag)
    {
        registeractivity.w = flag;
        return flag;
    }

    private boolean a(UserInfo userinfo)
    {
        return userinfo == null || userinfo.displayName == null || userinfo.displayName.isEmpty();
    }

    private boolean a(String s1, String s2, UserInfo userinfo)
    {
        Object obj = null;
        if (s1 != null && s2 != null && !s2.isEmpty()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        String s3;
        s3 = ImageUtils.a(Globals.n().getBaseContext(), null);
        com.nostra13.universalimageloader.core.d d1 = (new com.nostra13.universalimageloader.core.e()).a(android.graphics.Bitmap.Config.ARGB_8888).b(false).c(false).a();
        s2 = com.nostra13.universalimageloader.core.f.b().a(s2, d1);
        Bitmap bitmap = com.cyberlink.beautycircle.utility.r.a(s2, 0, 540);
        obj = bitmap;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        if (s2 != null && !s2.isRecycled())
        {
            s2.recycle();
            System.gc();
        }
        if (obj == null || ((Bitmap) (obj)).isRecycled()) goto _L1; else goto _L3
_L3:
        ((Bitmap) (obj)).recycle();
        System.gc();
        return false;
        boolean flag = com.cyberlink.beautycircle.utility.r.a(((Bitmap) (obj)), s3, 100);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        if (s2 != null && !s2.isRecycled())
        {
            s2.recycle();
            System.gc();
        }
        if (obj == null || ((Bitmap) (obj)).isRecycled()) goto _L1; else goto _L4
_L4:
        ((Bitmap) (obj)).recycle();
        System.gc();
        return false;
        Object obj1 = new FileMetadata();
        obj1.width = Integer.valueOf(((Bitmap) (obj)).getWidth());
        obj1.height = Integer.valueOf(((Bitmap) (obj)).getHeight());
        obj1.orientation = Integer.valueOf(0);
        NetworkFile.a(s3, ((FileMetadata) (obj1)));
        obj1 = NetworkFile.a(s3, ((FileMetadata) (obj1)));
        NetworkFile.a(s1, com.cyberlink.beautycircle.model.network.NetworkFile.FileType.Avatar, ((h) (obj1)).e, ((h) (obj1)).c, ((h) (obj1)).f.toString(), ((h) (obj1)).a).a(new com.perfectcorp.utility.m(s1, userinfo) {

            final String a;
            final UserInfo b;
            final RegisterActivity c;

            protected void a(int i1)
            {
                if (i1 == 420)
                {
                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(c, 48258);
                    return;
                } else
                {
                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(c, a, b, -1L, -1L);
                    return;
                }
            }

            protected void a(com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult uploadfileresult)
            {
                if (uploadfileresult == null || uploadfileresult.fileId == null)
                {
                    b(0x80000001);
                    return;
                } else
                {
                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(c, a, b, uploadfileresult.fileId.longValue(), -1L);
                    return;
                }
            }

            protected void b(Object obj2)
            {
                a((com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult)obj2);
            }

            
            {
                c = RegisterActivity.this;
                a = s1;
                b = userinfo;
                super();
            }
        });
        boolean flag1 = true;
        if (s2 != null && !s2.isRecycled())
        {
            s2.recycle();
            System.gc();
        }
        flag = flag1;
        if (obj != null)
        {
            flag = flag1;
            if (!((Bitmap) (obj)).isRecycled())
            {
                ((Bitmap) (obj)).recycle();
                System.gc();
                flag = flag1;
            }
        }
_L5:
        return flag;
        s2;
        s1 = null;
        userinfo = ((UserInfo) (obj));
_L8:
        s2.printStackTrace();
        if (s1 != null && !s1.isRecycled())
        {
            s1.recycle();
            System.gc();
        }
        Exception exception;
        if (userinfo != null && !userinfo.isRecycled())
        {
            userinfo.recycle();
            System.gc();
            flag = false;
        } else
        {
            flag = false;
        }
          goto _L5
        s1;
        userinfo = null;
        s2 = null;
_L7:
        if (s2 != null && !s2.isRecycled())
        {
            s2.recycle();
            System.gc();
        }
        if (userinfo != null && !userinfo.isRecycled())
        {
            userinfo.recycle();
            System.gc();
        }
        throw s1;
        s1;
        userinfo = null;
        continue; /* Loop/switch isn't completed */
        s1;
        userinfo = ((UserInfo) (obj));
        continue; /* Loop/switch isn't completed */
        obj;
        s2 = s1;
        s1 = ((String) (obj));
        if (true) goto _L7; else goto _L6
_L6:
        userinfo;
        s1 = s2;
        s2 = userinfo;
        userinfo = ((UserInfo) (obj));
          goto _L8
        exception;
        userinfo = ((UserInfo) (obj));
        s1 = s2;
        s2 = exception;
          goto _L8
    }

    static void b(RegisterActivity registeractivity)
    {
        registeractivity.q();
    }

    static void b(RegisterActivity registeractivity, String s1, UserInfo userinfo)
    {
        registeractivity.a(s1, userinfo);
    }

    private void b(String s1, UserInfo userinfo)
    {
        j.b(new com.cyberlink.beautycircle.utility.ai(userinfo, s1) {

            final UserInfo a;
            final String b;
            final RegisterActivity c;

            public void a()
            {
                (new AsyncTask(this) {

                    final _cls8 a;

                    protected transient Void a(Void avoid[])
                    {
                        boolean flag1 = false;
                        avoid = a.c.j.d();
                        a.c.j.a(a.a);
                        boolean flag = flag1;
                        if (avoid != null)
                        {
                            flag = flag1;
                            if (((WeiboAccountInfo) (avoid)).avatar_large != null)
                            {
                                flag = com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a.c, a.b, ((WeiboAccountInfo) (avoid)).avatar_large, a.a);
                            }
                        }
                        if (!flag)
                        {
                            com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a.c, a.b, a.a, -1L, -1L);
                        }
                        return null;
                    }

                    protected Object doInBackground(Object aobj[])
                    {
                        return a((Void[])aobj);
                    }

            
            {
                a = _pcls8;
                super();
            }
                }).executeOnExecutor(j.q, new Void[0]);
            }

            public void a(WeiboException weiboexception)
            {
                Globals.b(weiboexception.toString());
                com.cyberlink.beautycircle.controller.activity.RegisterActivity.b(c, b, a);
            }

            
            {
                c = RegisterActivity.this;
                a = userinfo;
                b = s1;
                super();
            }
        });
    }

    static View c(RegisterActivity registeractivity)
    {
        return registeractivity.y;
    }

    private void c(int i1)
    {
        setResult(i1, new Intent());
        super.e();
    }

    static void c(RegisterActivity registeractivity, String s1, UserInfo userinfo)
    {
        registeractivity.c(s1, userinfo);
    }

    private void c(String s1, UserInfo userinfo)
    {
        B.a(userinfo).a(new l(s1, userinfo) {

            final String a;
            final UserInfo b;
            final RegisterActivity c;

            protected void a(int i1)
            {
                super.a(i1);
                com.perfectcorp.utility.e.d(new Object[] {
                    "Get twitter info fail."
                });
                com.cyberlink.beautycircle.controller.activity.RegisterActivity.b(c, a, b);
            }

            protected void a(com.cyberlink.beautycircle.model.network.NetworkWeChat.UserinfoResult userinforesult)
            {
                if (userinforesult != null)
                {
                    if (!com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(c, a, userinforesult.headimgurl, b))
                    {
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(c, a, b, -1L, -1L);
                    }
                    return;
                } else
                {
                    com.perfectcorp.utility.e.d(new Object[] {
                        "Get twitter info fail."
                    });
                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.b(c, a, b);
                    return;
                }
            }

            protected void b(Object obj)
            {
                a((com.cyberlink.beautycircle.model.network.NetworkWeChat.UserinfoResult)obj);
            }

            
            {
                c = RegisterActivity.this;
                a = s1;
                b = userinfo;
                super();
            }
        });
    }

    static TextView d(RegisterActivity registeractivity)
    {
        return registeractivity.x;
    }

    static void d(RegisterActivity registeractivity, String s1, UserInfo userinfo)
    {
        registeractivity.d(s1, userinfo);
    }

    private void d(String s1, UserInfo userinfo)
    {
        C.a(this, new s(com/cyberlink/beautycircle/utility/QQUtils$QQUserInfoResult, userinfo, s1) {

            final UserInfo a;
            final String b;
            final RegisterActivity c;

            public void a()
            {
                com.perfectcorp.utility.e.c(new Object[] {
                    "QQ getUserInfo: Cancel"
                });
            }

            public void a(com.cyberlink.beautycircle.utility.QQUtils.QQUserInfoResult qquserinforesult)
            {
                AsyncTask.execute(new Runnable(this, qquserinforesult) {

                    final com.cyberlink.beautycircle.utility.QQUtils.QQUserInfoResult a;
                    final _cls13 b;

                    public void run()
                    {
                        QQUtils.a(a, b.a);
                        boolean flag1 = false;
                        boolean flag = flag1;
                        if (a != null)
                        {
                            flag = flag1;
                            if (a.figureurl_2 != null)
                            {
                                flag = com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(b.c, b.b, a.figureurl_2.toString(), b.a);
                            }
                        }
                        if (!flag)
                        {
                            com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(b.c, b.b, b.a, -1L, -1L);
                        }
                    }

            
            {
                b = _pcls13;
                a = qquserinforesult;
                super();
            }
                });
            }

            public volatile void a(Model model)
            {
                a((com.cyberlink.beautycircle.utility.QQUtils.QQUserInfoResult)model);
            }

            public void a(com.tencent.tauth.d d1)
            {
                Globals.b(d1.toString());
                com.cyberlink.beautycircle.controller.activity.RegisterActivity.b(c, b, a);
            }

            
            {
                c = RegisterActivity.this;
                a = userinfo;
                b = s1;
                super(class1);
            }
        });
    }

    static PageMode e(RegisterActivity registeractivity)
    {
        return registeractivity.t;
    }

    static void e(RegisterActivity registeractivity, String s1, UserInfo userinfo)
    {
        registeractivity.e(s1, userinfo);
    }

    private void e(String s1, UserInfo userinfo)
    {
        D.a(userinfo).a(new l(s1, userinfo) {

            final String a;
            final UserInfo b;
            final RegisterActivity c;

            protected void a(com.cyberlink.beautycircle.utility.TwitterUtils.TwitterUser twitteruser)
            {
                boolean flag = false;
                if (twitteruser != null)
                {
                    if (!twitteruser.default_profile_image)
                    {
                        flag = com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(c, a, twitteruser.a("_400x400"), b);
                    } else
                    {
                        com.perfectcorp.utility.e.c(new Object[] {
                            "Ignore image upload: It's twitter default_profile_image."
                        });
                    }
                    if (!flag)
                    {
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(c, a, b, -1L, -1L);
                    }
                    return;
                } else
                {
                    com.perfectcorp.utility.e.d(new Object[] {
                        "Get twitter info fail."
                    });
                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.b(c, a, b);
                    return;
                }
            }

            protected void b(Object obj)
            {
                a((com.cyberlink.beautycircle.utility.TwitterUtils.TwitterUser)obj);
            }

            
            {
                c = RegisterActivity.this;
                a = s1;
                b = userinfo;
                super();
            }
        });
    }

    static boolean f(RegisterActivity registeractivity)
    {
        return registeractivity.w;
    }

    static int g(RegisterActivity registeractivity)
    {
        return registeractivity.s;
    }

    private void g(String s1)
    {
        if (s1 == null)
        {
            DialogUtils.a(this, getResources().getString(m.bc_register_twitter_sign_in_failed));
            Globals.b("Invalid Twitter oauthVerifier.");
            com.perfectcorp.a.b.a(new aq("twitter", "no"));
            return;
        } else
        {
            k();
            D.a(s1).a(new com.perfectcorp.utility.m() {

                final RegisterActivity a;

                protected void a(int i1)
                {
                    a.l();
                    DialogUtils.a(a, a.getResources().getString(m.bc_register_twitter_sign_in_failed));
                    com.perfectcorp.a.b.a(new aq("twitter", "no"));
                }

                protected void a(OAuthConsumer oauthconsumer)
                {
                    if (oauthconsumer != null && com.cyberlink.beautycircle.controller.activity.RegisterActivity.i(a).a != null)
                    {
                        NetworkUser.a("Twitter", oauthconsumer.a(), com.cyberlink.beautycircle.controller.activity.RegisterActivity.i(a).a).a(new com.perfectcorp.utility.m(this) {

                            final _cls15 a;

                            protected void a(int i1)
                            {
                                a.a.l();
                                DialogUtils.a(a.a, a.a.getResources().getString(m.bc_register_twitter_sign_in_failed));
                                com.perfectcorp.a.b.a(new aq("twitter", "no"));
                            }

                            protected void a(com.cyberlink.beautycircle.model.UserInfo.SignInResult signinresult)
                            {
                                AccountManager.a(com.cyberlink.beautycircle.utility.AccountManager.AccountSource.f);
                                com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a.a, com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a.a, signinresult.userInfo));
                                if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.f(a.a))
                                {
                                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a, signinresult.token, signinresult.userInfo);
                                } else
                                {
                                    RegisterActivity registeractivity = a.a;
                                    String s1 = signinresult.token;
                                    UserInfo userinfo = signinresult.userInfo;
                                    long l1;
                                    if (signinresult.userInfo != null)
                                    {
                                        l1 = signinresult.userInfo.id;
                                    } else
                                    {
                                        l1 = -1L;
                                    }
                                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(registeractivity, s1, userinfo, l1);
                                }
                                if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) != com.cyberlink.beautycircle.controller.activity.PageMode.a) goto _L2; else goto _L1
_L1:
                                com.perfectcorp.a.b.a(new at("twitter"));
_L4:
                                com.perfectcorp.a.b.a(new aq("twitter", "yes"));
                                return;
_L2:
                                if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.PageMode.b)
                                {
                                    com.perfectcorp.a.b.a(new as("twitter"));
                                } else
                                if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.PageMode.c || com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.PageMode.d)
                                {
                                    com.perfectcorp.a.b.a(new ar("twitter"));
                                }
                                if (true) goto _L4; else goto _L3
_L3:
                            }

                            protected void b(Object obj)
                            {
                                a((com.cyberlink.beautycircle.model.UserInfo.SignInResult)obj);
                            }

            
            {
                a = _pcls15;
                super();
            }
                        });
                        return;
                    } else
                    {
                        a.l();
                        DialogUtils.a(a, a.getResources().getString(m.bc_register_twitter_sign_in_failed));
                        Globals.b("Invalid Twitter token.");
                        com.perfectcorp.a.b.a(new aq("twitter", "no"));
                        return;
                    }
                }

                protected void b(Object obj)
                {
                    a((OAuthConsumer)obj);
                }

            
            {
                a = RegisterActivity.this;
                super();
            }
            });
            return;
        }
    }

    static QQUtils h(RegisterActivity registeractivity)
    {
        return registeractivity.C;
    }

    static TwitterUtils i(RegisterActivity registeractivity)
    {
        return registeractivity.D;
    }

    static android.view.View.OnClickListener j(RegisterActivity registeractivity)
    {
        return registeractivity.E;
    }

    static void k(RegisterActivity registeractivity)
    {
        registeractivity.u();
    }

    static void l(RegisterActivity registeractivity)
    {
        registeractivity.r();
    }

    private void p()
    {
        j.a(F);
    }

    private void q()
    {
        if (!com.perfectcorp.utility.g.a(getApplicationContext(), d.j))
        {
            com.cyberlink.beautycircle.c.c(this, d.j);
            if (r != 0)
            {
                finish();
            }
            return;
        }
        if (B == null)
        {
            B = new ae(getApplicationContext());
        }
        B.a(new ag() {

            final RegisterActivity a;

            public void a(com.cyberlink.beautycircle.model.network.NetworkWeChat.AccessTokenResult accesstokenresult)
            {
                if (accesstokenresult == null)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "tokenResult null"
                    });
                    a(((com.tencent.mm.sdk.openapi.i) (null)));
                    return;
                }
                if (accesstokenresult.errcode != null)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "errcode: ", accesstokenresult.errcode, ", errmsg: ", accesstokenresult.errmsg
                    });
                    Globals.b((new StringBuilder()).append("errcode: ").append(accesstokenresult.errcode).append(", errmsg: ").append(accesstokenresult.errmsg).toString());
                    a(((com.tencent.mm.sdk.openapi.i) (null)));
                    return;
                } else
                {
                    a.k();
                    NetworkUser.a("Wechat", accesstokenresult.access_token, accesstokenresult.unionid).a(new com.perfectcorp.utility.m(this) {

                        final _cls9 a;

                        protected void a(int i1)
                        {
                            a.a.l();
                            DialogUtils.a(a.a, a.a.getResources().getString(m.bc_register_wechat_sign_in_failed));
                            com.perfectcorp.a.b.a(new aq("wechat", "no"));
                        }

                        protected void a(com.cyberlink.beautycircle.model.UserInfo.SignInResult signinresult)
                        {
                            AccountManager.a(com.cyberlink.beautycircle.utility.AccountManager.AccountSource.d);
                            com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a.a, com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a.a, signinresult.userInfo));
                            if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.f(a.a))
                            {
                                com.cyberlink.beautycircle.controller.activity.RegisterActivity.c(a.a, signinresult.token, signinresult.userInfo);
                            } else
                            {
                                RegisterActivity registeractivity = a.a;
                                String s1 = signinresult.token;
                                UserInfo userinfo = signinresult.userInfo;
                                long l1;
                                if (signinresult.userInfo != null)
                                {
                                    l1 = signinresult.userInfo.id;
                                } else
                                {
                                    l1 = -1L;
                                }
                                com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(registeractivity, s1, userinfo, l1);
                            }
                            if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) != com.cyberlink.beautycircle.controller.activity.PageMode.a) goto _L2; else goto _L1
_L1:
                            com.perfectcorp.a.b.a(new at("wechat"));
_L4:
                            com.perfectcorp.a.b.a(new aq("wechat", "yes"));
                            return;
_L2:
                            if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.PageMode.b)
                            {
                                com.perfectcorp.a.b.a(new as("wechat"));
                            } else
                            if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.PageMode.c || com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.PageMode.d)
                            {
                                com.perfectcorp.a.b.a(new ar("wechat"));
                            }
                            if (true) goto _L4; else goto _L3
_L3:
                        }

                        protected void b(Object obj)
                        {
                            a((com.cyberlink.beautycircle.model.UserInfo.SignInResult)obj);
                        }

            
            {
                a = _pcls9;
                super();
            }
                    });
                    return;
                }
            }

            public void a(com.tencent.mm.sdk.openapi.i i1)
            {
                DialogUtils.a(a, a.getResources().getString(m.bc_register_wechat_sign_in_failed));
                if (i1 != null)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "errCode: ", ae.a(i1.a), ", errStr: ", i1.b
                    });
                    Globals.b((new StringBuilder()).append("errCode: ").append(i1.a).append(", errStr: ").append(i1.b).toString());
                }
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        });
    }

    private void r()
    {
        if (C == null)
        {
            C = new QQUtils(getApplicationContext());
        }
        C.a(this, new s(com/cyberlink/beautycircle/utility/QQUtils$QQLoginResult) {

            final RegisterActivity a;

            public void a()
            {
                com.perfectcorp.utility.e.c(new Object[] {
                    "QQ Login: Cancel"
                });
            }

            public void a(com.cyberlink.beautycircle.utility.QQUtils.QQLoginResult qqloginresult)
            {
                if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.h(a).a())
                {
                    a.k();
                    NetworkUser.a("Qq", qqloginresult.access_token, qqloginresult.openid).a(new com.perfectcorp.utility.m(this) {

                        final _cls11 a;

                        protected void a(int i1)
                        {
                            a.a.l();
                            DialogUtils.a(a.a, a.a.getResources().getString(m.bc_register_qq_sign_in_failed));
                            com.perfectcorp.a.b.a(new aq("qq", "no"));
                        }

                        protected void a(com.cyberlink.beautycircle.model.UserInfo.SignInResult signinresult)
                        {
                            AccountManager.a(com.cyberlink.beautycircle.utility.AccountManager.AccountSource.e);
                            com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a.a, com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a.a, signinresult.userInfo));
                            if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.f(a.a))
                            {
                                com.cyberlink.beautycircle.controller.activity.RegisterActivity.d(a.a, signinresult.token, signinresult.userInfo);
                            } else
                            {
                                RegisterActivity registeractivity = a.a;
                                String s1 = signinresult.token;
                                UserInfo userinfo = signinresult.userInfo;
                                long l1;
                                if (signinresult.userInfo != null)
                                {
                                    l1 = signinresult.userInfo.id;
                                } else
                                {
                                    l1 = -1L;
                                }
                                com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(registeractivity, s1, userinfo, l1);
                            }
                            if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) != com.cyberlink.beautycircle.controller.activity.PageMode.a) goto _L2; else goto _L1
_L1:
                            com.perfectcorp.a.b.a(new at("qq"));
_L4:
                            com.perfectcorp.a.b.a(new aq("qq", "yes"));
                            return;
_L2:
                            if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.PageMode.b)
                            {
                                com.perfectcorp.a.b.a(new as("qq"));
                            } else
                            if (com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.PageMode.c || com.cyberlink.beautycircle.controller.activity.RegisterActivity.e(a.a) == com.cyberlink.beautycircle.controller.activity.PageMode.d)
                            {
                                com.perfectcorp.a.b.a(new ar("qq"));
                            }
                            if (true) goto _L4; else goto _L3
_L3:
                        }

                        protected void b(Object obj)
                        {
                            a((com.cyberlink.beautycircle.model.UserInfo.SignInResult)obj);
                        }

            
            {
                a = _pcls11;
                super();
            }
                    });
                    return;
                } else
                {
                    DialogUtils.a(a, a.getResources().getString(m.bc_register_qq_sign_in_failed));
                    Globals.b("Invalid QQ session.");
                    com.perfectcorp.a.b.a(new aq("qq", "no"));
                    return;
                }
            }

            public volatile void a(Model model)
            {
                a((com.cyberlink.beautycircle.utility.QQUtils.QQLoginResult)model);
            }

            public void a(com.tencent.tauth.d d1)
            {
                if (d1 != null)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "QQ Login: Error. code:", Integer.valueOf(d1.a), ", msg:", d1.b, (new StringBuilder()).append(", detail:").append(d1.c).toString()
                    });
                }
                DialogUtils.a(a, a.getResources().getString(m.bc_register_qq_sign_in_failed));
            }

            
            {
                a = RegisterActivity.this;
                super(class1);
            }
        });
    }

    private void u()
    {
        k();
        if (D == null)
        {
            D = new TwitterUtils();
        }
        D.a(this).a(new com.perfectcorp.utility.m() {

            final RegisterActivity a;

            protected void a()
            {
                a.l();
                super.a();
            }

            protected void a(int i1)
            {
                a.l();
                super.a(i1);
            }

            protected void a(String s1)
            {
                a.l();
            }

            protected void b(Object obj)
            {
                a((String)obj);
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        });
    }

    public void a(Session session, SessionState sessionstate, Exception exception)
    {
        if (sessionstate.isOpened())
        {
            if (l)
            {
                l = false;
                a(session);
            }
        } else
        if (sessionstate == SessionState.CLOSED_LOGIN_FAILED)
        {
            DialogUtils.a(this, getResources().getString(m.bc_register_facebook_sign_in_failed));
            if (exception != null && exception.getMessage() != null)
            {
                session = exception.getMessage();
            } else
            {
                session = "Unknow error";
            }
            Globals.b(session);
            l();
            com.perfectcorp.a.b.a(new aq("facebook", "no"));
            return;
        }
    }

    protected boolean e()
    {
        if (v.size() > 0)
        {
            a((PageMode)v.pop(), false, true);
        } else
        {
            AccountManager.i();
            c(48259);
            if (t == com.cyberlink.beautycircle.controller.activity.PageMode.a)
            {
                com.perfectcorp.a.b.a(new at("back"));
                return true;
            }
            if (t == com.cyberlink.beautycircle.controller.activity.PageMode.b)
            {
                com.perfectcorp.a.b.a(new as("back"));
                return true;
            }
            if (t == com.cyberlink.beautycircle.controller.activity.PageMode.c || t == com.cyberlink.beautycircle.controller.activity.PageMode.d)
            {
                com.perfectcorp.a.b.a(new ar("back"));
                return true;
            }
        }
        return true;
    }

    protected boolean f(String s1)
    {
        return s1.length() >= 6 && s1.length() <= 20;
    }

    protected void o()
    {
        if (!w) goto _L2; else goto _L1
_L1:
        if (s != 5) goto _L4; else goto _L3
_L3:
        s = 6;
_L6:
        com.cyberlink.beautycircle.c.a(this, s);
_L2:
        c(48256);
        return;
_L4:
        if (s != 8)
        {
            s = 1;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "requestCode: ", String.valueOf(i1), ", resultCode: ", String.valueOf(j1), ", data: ", intent
        });
        super.onActivityResult(i1, j1, intent);
        if (i1 != 48128) goto _L2; else goto _L1
_L1:
        super.e();
_L4:
        return;
_L2:
        if (i1 != 48140)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (j1 != 48256 || intent == null) goto _L4; else goto _L3
_L3:
        intent = intent.getStringExtra("UserEmail");
        ((EditText)findViewById(com.cyberlink.beautycircle.j.register_id)).setText(intent);
        return;
        if (i1 != 48162) goto _L4; else goto _L5
_L5:
        if (j1 == -1 && intent != null)
        {
            g(intent.getStringExtra("OauthVerifier"));
            return;
        } else
        {
            g(((String) (null)));
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_register);
        Object obj = getIntent();
        if (((Intent) (obj)).getBooleanExtra("leave_now", false))
        {
            finish();
        } else
        {
            int i1 = ((Intent) (obj)).getIntExtra("SignInMode", 0);
            r = ((Intent) (obj)).getIntExtra("ReDirectMode", 0);
            s = ((Intent) (obj)).getIntExtra("EditProfileMode", 0);
            u = ((Intent) (obj)).getStringExtra("eventName");
            z = (EmojiconTextView)findViewById(com.cyberlink.beautycircle.j.top_bar_title);
            A = findViewById(com.cyberlink.beautycircle.j.top_bar_btn_back);
            if (A != null)
            {
                A.setOnClickListener(f);
            }
            if (i1 == 1)
            {
                t = com.cyberlink.beautycircle.controller.activity.PageMode.b;
            } else
            if (i1 == 2)
            {
                t = com.cyberlink.beautycircle.controller.activity.PageMode.c;
            } else
            if (i1 == 3)
            {
                t = com.cyberlink.beautycircle.controller.activity.PageMode.d;
            }
            if (z != null)
            {
                if (t == com.cyberlink.beautycircle.controller.activity.PageMode.a)
                {
                    z.setText(m.bc_register_title);
                } else
                if (t == com.cyberlink.beautycircle.controller.activity.PageMode.b)
                {
                    z.setText(m.bc_register_title_login);
                } else
                {
                    z.setText("");
                }
            }
            a(t, false, false);
            y = findViewById(com.cyberlink.beautycircle.j.register_accept_btn);
            if (y != null)
            {
                y.setOnClickListener(g);
            }
            obj = findViewById(com.cyberlink.beautycircle.j.bc_email_login);
            if (obj != null)
            {
                ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final RegisterActivity a;

                    public void onClick(View view)
                    {
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a, com.cyberlink.beautycircle.controller.activity.PageMode.a, true, true);
                    }

            
            {
                a = RegisterActivity.this;
                super();
            }
                });
            }
            obj = findViewById(com.cyberlink.beautycircle.j.bc_have_an_account);
            if (obj != null)
            {
                ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final RegisterActivity a;

                    public void onClick(View view)
                    {
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a, com.cyberlink.beautycircle.controller.activity.PageMode.b, true, true);
                    }

            
            {
                a = RegisterActivity.this;
                super();
            }
                });
            }
            obj = findViewById(com.cyberlink.beautycircle.j.register_link_sign_in);
            if (obj != null)
            {
                ((View) (obj)).setOnClickListener(o);
            }
            obj = findViewById(com.cyberlink.beautycircle.j.register_link_new_account);
            if (obj != null)
            {
                ((View) (obj)).setOnClickListener(p);
            }
            obj = findViewById(com.cyberlink.beautycircle.j.register_link_forget_password);
            if (obj != null)
            {
                ((View) (obj)).setOnClickListener(q);
            }
            x = (TextView)findViewById(com.cyberlink.beautycircle.j.register_wrong_info);
            a(bundle, true);
            if (j == null)
            {
                j = new ah(this);
            }
            bundle = findViewById(com.cyberlink.beautycircle.j.bc_fb_login);
            if (bundle != null)
            {
                bundle.setOnClickListener(E);
            }
            bundle = findViewById(com.cyberlink.beautycircle.j.bc_weibo_login);
            if (bundle != null)
            {
                bundle.setOnClickListener(new android.view.View.OnClickListener() {

                    final RegisterActivity a;

                    public void onClick(View view)
                    {
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(a);
                    }

            
            {
                a = RegisterActivity.this;
                super();
            }
                });
            }
            bundle = findViewById(com.cyberlink.beautycircle.j.bc_wechat_login);
            if (bundle != null)
            {
                bundle.setOnClickListener(new android.view.View.OnClickListener() {

                    final RegisterActivity a;

                    public void onClick(View view)
                    {
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.b(a);
                    }

            
            {
                a = RegisterActivity.this;
                super();
            }
                });
            }
            bundle = findViewById(com.cyberlink.beautycircle.j.bc_fb_more);
            if (bundle != null)
            {
                bundle.setOnClickListener(G);
            }
            bundle = findViewById(com.cyberlink.beautycircle.j.bc_weibo_more);
            if (bundle != null)
            {
                bundle.setOnClickListener(G);
            }
            bundle = findViewById(com.cyberlink.beautycircle.j.bc_wechat_more);
            if (bundle != null)
            {
                bundle.setOnClickListener(G);
            }
            ((EditText)findViewById(com.cyberlink.beautycircle.j.register_password)).setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                final RegisterActivity a;

                public boolean onEditorAction(TextView textview, int j1, KeyEvent keyevent)
                {
                    return com.cyberlink.beautycircle.controller.activity.RegisterActivity.c(a).performClick();
                }

            
            {
                a = RegisterActivity.this;
                super();
            }
            });
            if (r == 1)
            {
                bundle = Session.getActiveSession();
                if (bundle.isOpened())
                {
                    a(bundle);
                    return;
                } else
                {
                    l = true;
                    i.performClick();
                    return;
                }
            }
            if (r == 2)
            {
                p();
                return;
            }
            if (r == 3)
            {
                u();
                return;
            }
            if (r == 4)
            {
                r();
                return;
            }
            if (r == 5)
            {
                q();
                return;
            }
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (AccountManager.b() != null)
        {
            c(48256);
        }
        if (t == com.cyberlink.beautycircle.controller.activity.PageMode.a)
        {
            com.perfectcorp.a.b.a(new ai());
        } else
        {
            if (t == com.cyberlink.beautycircle.controller.activity.PageMode.b)
            {
                com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.ah());
                return;
            }
            if (t == com.cyberlink.beautycircle.controller.activity.PageMode.c || t == com.cyberlink.beautycircle.controller.activity.PageMode.d)
            {
                com.perfectcorp.a.b.a(new ad());
                return;
            }
        }
    }


    private class PageMode extends Enum
    {

        public static final PageMode a;
        public static final PageMode b;
        public static final PageMode c;
        public static final PageMode d;
        private static final PageMode e[];

        public static PageMode valueOf(String s1)
        {
            return (PageMode)Enum.valueOf(com/cyberlink/beautycircle/controller/activity/RegisterActivity$PageMode, s1);
        }

        public static PageMode[] values()
        {
            return (PageMode[])e.clone();
        }

        static 
        {
            a = new PageMode("RegisterMode", 0);
            b = new PageMode("SignInMode", 1);
            c = new PageMode("JoinMode", 2);
            d = new PageMode("ConsultationMode", 3);
            e = (new PageMode[] {
                a, b, c, d
            });
        }

        private PageMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
