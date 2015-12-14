// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.controller.a.aa;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkEvent;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.j;
import com.rockerhieu.emojicon.EmojiconTextView;

public class FreeSampleResultActivity extends BaseActivity
{

    private static final Long f = Long.valueOf(0L);
    private View A;
    private View B;
    private View C;
    private View D;
    private View E;
    private View F;
    private android.view.View.OnClickListener G;
    protected android.view.View.OnClickListener e;
    private com.cyberlink.beautycircle.model.Event.ReceiveUserInfo g;
    private Long h;
    private TextView i;
    private UICImageView j;
    private View k;
    private UICImageView l;
    private EmojiconTextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public FreeSampleResultActivity()
    {
        G = new android.view.View.OnClickListener() {

            final FreeSampleResultActivity a;

            public void onClick(View view)
            {
                view = new Dialog(a);
                view.requestWindowFeature(1);
                view.setContentView(k.bc_dialog_store_confirm);
                TextView textview = (TextView)view.findViewById(com.cyberlink.beautycircle.j.bc_dialog_positive);
                TextView textview1 = (TextView)view.findViewById(com.cyberlink.beautycircle.j.bc_dialog_negative);
                if ("CONSULTATION".equals(FreeSampleResultActivity.d(a).serviceType))
                {
                    TextView textview2 = (TextView)view.findViewById(com.cyberlink.beautycircle.j.bc_dialog_confirm_desc);
                    if (textview2 != null)
                    {
                        textview2.setText(m.bc_consultation_result_dialog_confirm_desc);
                    }
                    textview2 = (TextView)view.findViewById(com.cyberlink.beautycircle.j.bc_dialog_confirm_alert);
                    if (textview2 != null)
                    {
                        textview2.setVisibility(8);
                    }
                    if (textview != null)
                    {
                        textview.setText(m.bc_consultation_result_dialog_confirm_ok);
                    }
                    if (textview1 != null)
                    {
                        textview1.setText(m.bc_consultation_result_dialog_confirm_cancel);
                    }
                }
                textview1.setOnClickListener(new android.view.View.OnClickListener(this, view) {

                    final Dialog a;
                    final _cls3 b;

                    public void onClick(View view)
                    {
                        a.cancel();
                    }

            
            {
                b = _pcls3;
                a = dialog;
                super();
            }
                });
                textview.setOnClickListener(new android.view.View.OnClickListener(this, view) {

                    final Dialog a;
                    final _cls3 b;

                    public void onClick(View view)
                    {
                        NetworkEvent.b(AccountManager.b(), FreeSampleResultActivity.a(b.a).longValue()).a(new com.perfectcorp.utility.m(this) {

                            final _cls2 a;

                            protected void a(int i1)
                            {
                                super.a(i1);
                            }

                            protected void a(Void void1)
                            {
                                if (FreeSampleResultActivity.e(a.b.a) != null && FreeSampleResultActivity.f(a.b.a) != null)
                                {
                                    FreeSampleResultActivity.e(a.b.a).setVisibility(8);
                                    if ("CONSULTATION".equals(FreeSampleResultActivity.d(a.b.a).serviceType))
                                    {
                                        FreeSampleResultActivity.f(a.b.a).setText(m.bc_consultation_result_store_btn_redeemed);
                                    } else
                                    {
                                        FreeSampleResultActivity.f(a.b.a).setText(m.bc_freesample_result_store_btn_redeemed);
                                    }
                                    FreeSampleResultActivity.f(a.b.a).setEnabled(false);
                                }
                                a.a.dismiss();
                            }

                            protected void b(Object obj)
                            {
                                a((Void)obj);
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                    }

            
            {
                b = _pcls3;
                a = dialog;
                super();
            }
                });
                view.show();
            }

            
            {
                a = FreeSampleResultActivity.this;
                super();
            }
        };
    }

    static com.cyberlink.beautycircle.model.Event.ReceiveUserInfo a(FreeSampleResultActivity freesampleresultactivity, com.cyberlink.beautycircle.model.Event.ReceiveUserInfo receiveuserinfo)
    {
        freesampleresultactivity.g = receiveuserinfo;
        return receiveuserinfo;
    }

    static Long a(FreeSampleResultActivity freesampleresultactivity)
    {
        return freesampleresultactivity.h;
    }

    static void b(FreeSampleResultActivity freesampleresultactivity)
    {
        freesampleresultactivity.q();
    }

    static void c(FreeSampleResultActivity freesampleresultactivity)
    {
        freesampleresultactivity.r();
    }

    static com.cyberlink.beautycircle.model.Event.ReceiveUserInfo d(FreeSampleResultActivity freesampleresultactivity)
    {
        return freesampleresultactivity.g;
    }

    static TextView e(FreeSampleResultActivity freesampleresultactivity)
    {
        return freesampleresultactivity.y;
    }

    static TextView f(FreeSampleResultActivity freesampleresultactivity)
    {
        return freesampleresultactivity.z;
    }

    static Long o()
    {
        return f;
    }

    private void p()
    {
        (new AsyncTask() {

            final FreeSampleResultActivity a;

            protected transient Void a(Void avoid[])
            {
                if (AccountManager.b() != null)
                {
                    if (FreeSampleResultActivity.a(a) != FreeSampleResultActivity.o());
                }
                return null;
            }

            protected void a(Void void1)
            {
                com.cyberlink.beautycircle.controller.activity.FreeSampleResultActivity.b(a);
                a.l();
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = FreeSampleResultActivity.this;
                super();
            }
        }).executeOnExecutor(j.q, new Void[0]);
    }

    private void q()
    {
        k();
        NetworkEvent.a(AccountManager.b(), h.longValue()).a(new com.perfectcorp.utility.m() {

            final FreeSampleResultActivity a;

            protected void a(int i1)
            {
                a.l();
            }

            protected void a(com.cyberlink.beautycircle.model.network.NetworkEvent.ReceiveUserInfoResult receiveuserinforesult)
            {
                a.l();
                FreeSampleResultActivity.a(a, receiveuserinforesult.result);
                FreeSampleResultActivity.c(a);
                if (FreeSampleResultActivity.a(a) != null && FreeSampleResultActivity.d(a) != null)
                {
                    com.perfectcorp.a.b.a(new aa(FreeSampleResultActivity.a(a).toString(), FreeSampleResultActivity.d(a).serviceType));
                }
            }

            protected void b(Object obj)
            {
                a((com.cyberlink.beautycircle.model.network.NetworkEvent.ReceiveUserInfoResult)obj);
            }

            
            {
                a = FreeSampleResultActivity.this;
                super();
            }
        });
    }

    private void r()
    {
        if (g != null)
        {
            if ("CONSULTATION".equals(g.serviceType))
            {
                if (i != null)
                {
                    i.setText(g.title);
                }
                if (k != null)
                {
                    k.setVisibility(8);
                }
                if (F != null)
                {
                    F.setVisibility(8);
                }
                if (o != null)
                {
                    o.setVisibility(8);
                }
                if (q != null)
                {
                    E.setVisibility(8);
                }
                if (z != null && y != null)
                {
                    if ("Redeemed".equals(g.userStatus))
                    {
                        y.setVisibility(8);
                        z.setText(m.bc_consultation_result_store_btn_redeemed);
                        z.setEnabled(false);
                    } else
                    {
                        y.setText(m.bc_consultation_result_store_alert);
                        z.setText(m.bc_consultation_result_store_btn);
                    }
                }
            } else
            {
                if (A != null)
                {
                    A.setVisibility(8);
                }
                if (j != null && g.imageUrl != null)
                {
                    j.setImageURI(g.imageUrl);
                    j.setVisibility(0);
                }
                if (E != null)
                {
                    E.setVisibility(8);
                }
            }
            if (g.organizerLogo != null)
            {
                b().a(g.organizerLogo);
            } else
            if (g.organizerName != null)
            {
                b().c(g.organizerName);
            }
            if (l != null && g.avatarUrl != null)
            {
                l.setImageURI(g.avatarUrl);
            }
            if (m != null && g.displayName != null)
            {
                m.setText(g.displayName);
            }
            if (n != null && g.receiveTemplate != null && g.b().message != null)
            {
                n.setText(g.b().message);
            }
            if (o != null && g.receiveTemplate != null && g.b().footer != null)
            {
                o.setText(g.b().footer);
            }
            if (p != null && g.name != null)
            {
                p.setText(g.name);
            }
            if (r != null && g.phone != null)
            {
                r.setText(g.phone);
            }
            if (s != null && g.mail != null)
            {
                s.setText(g.mail);
            }
            if (B != null && C != null && D != null)
            {
                com.cyberlink.beautycircle.model.Event.AddressInfo addressinfo = g.c();
                if (g.receiveType.equals("Home".toString()))
                {
                    B.setVisibility(0);
                    C.setVisibility(8);
                    D.setVisibility(8);
                    if (t != null)
                    {
                        t.setText(addressinfo.address);
                    }
                } else
                {
                    B.setVisibility(8);
                    C.setVisibility(0);
                    D.setVisibility(0);
                    if (u != null)
                    {
                        u.setText(addressinfo.location);
                    }
                    if (v != null)
                    {
                        v.setText(addressinfo.name);
                    }
                    if (w != null)
                    {
                        w.setText(addressinfo.address);
                    }
                    if (z != null && y != null)
                    {
                        if ("Redeemed".equals(g.userStatus))
                        {
                            y.setVisibility(8);
                            if ("CONSULTATION".equals(g.serviceType))
                            {
                                z.setText(m.bc_consultation_result_store_btn_redeemed);
                            } else
                            {
                                z.setText(m.bc_freesample_result_store_btn_redeemed);
                            }
                            z.setEnabled(false);
                        } else
                        {
                            z.setOnClickListener(G);
                        }
                    }
                }
            }
            if (x != null && g.prodName != null)
            {
                x.setText(g.prodName);
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_free_sample_result);
        h = Long.valueOf(getIntent().getLongExtra("brandEventId", f.longValue()));
        j = (UICImageView)findViewById(com.cyberlink.beautycircle.j.free_sample_banner);
        i = (TextView)findViewById(com.cyberlink.beautycircle.j.brand_event_title);
        k = findViewById(com.cyberlink.beautycircle.j.userItem);
        l = (UICImageView)findViewById(com.cyberlink.beautycircle.j.free_sample_avatar_image);
        m = (EmojiconTextView)findViewById(com.cyberlink.beautycircle.j.display_name);
        n = (TextView)findViewById(com.cyberlink.beautycircle.j.free_sample_result_message);
        o = (TextView)findViewById(com.cyberlink.beautycircle.j.free_sample_result_footer);
        p = (TextView)findViewById(com.cyberlink.beautycircle.j.free_sample_result_name);
        q = (TextView)findViewById(com.cyberlink.beautycircle.j.free_sample_result_birthday);
        r = (TextView)findViewById(com.cyberlink.beautycircle.j.free_sample_result_phone);
        s = (TextView)findViewById(com.cyberlink.beautycircle.j.free_sample_result_mail);
        t = (TextView)findViewById(com.cyberlink.beautycircle.j.free_sample_result_address);
        x = (TextView)findViewById(com.cyberlink.beautycircle.j.free_sample_result_product);
        u = (TextView)findViewById(com.cyberlink.beautycircle.j.free_sample_result_store_area);
        v = (TextView)findViewById(com.cyberlink.beautycircle.j.free_sample_result_store_name);
        w = (TextView)findViewById(com.cyberlink.beautycircle.j.free_sample_result_store_address);
        y = (TextView)findViewById(com.cyberlink.beautycircle.j.free_sample_result_redeem_alert);
        z = (TextView)findViewById(com.cyberlink.beautycircle.j.free_sample_result_redeem_btn);
        A = findViewById(com.cyberlink.beautycircle.j.brand_event_title_row);
        B = findViewById(com.cyberlink.beautycircle.j.freesample_home_row);
        C = findViewById(com.cyberlink.beautycircle.j.freesample_store_row);
        D = findViewById(com.cyberlink.beautycircle.j.freesample_redeem_row);
        E = findViewById(com.cyberlink.beautycircle.j.freesample_birthday_row);
        F = findViewById(com.cyberlink.beautycircle.j.freesample_product_row);
        b(m.bc_freesample_title);
        p();
    }

    public void onResume()
    {
        super.onResume();
        if (h != null && g != null)
        {
            com.perfectcorp.a.b.a(new aa(h.toString(), g.serviceType));
        }
    }

    public void onRightBtnClick(View view)
    {
        if (e != null)
        {
            e.onClick(view);
        }
    }

}
