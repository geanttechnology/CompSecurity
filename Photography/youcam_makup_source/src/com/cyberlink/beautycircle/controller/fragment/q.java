// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.ap;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.MeADPager;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.l;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.a.b;
import com.rockerhieu.emojicon.EmojiconTextView;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class q
{

    public l a;
    final p b;
    private MeADPager c;
    private View d;
    private UICImageView e;
    private ImageView f;
    private UICImageView g;
    private View h;
    private View i;
    private View j;
    private EmojiconTextView k;
    private EmojiconTextView l;
    private EmojiconTextView m;
    private TextView n;
    private View o;
    private View p;
    private View q;

    public q(p p1, Context context, ViewGroup viewgroup, MeADPager meadpager)
    {
        b = p1;
        super();
        a = new l() {

            final q a;

            public void a()
            {
            }

            public void a(Uri uri)
            {
                if (q.d(a) != null)
                {
                    q.d(a).post(new Runnable(this, uri) {

                        final Uri a;
                        final _cls3 b;

                        public void run()
                        {
                            com.cyberlink.beautycircle.controller.fragment.p.a(b.a.b, a);
                            q.d(b.a).setImageURI(a);
                        }

            
            {
                b = _pcls3;
                a = uri;
                super();
            }
                    });
                }
            }

            
            {
                a = q.this;
                super();
            }
        };
        context = (LayoutInflater)context.getSystemService("layout_inflater");
        c = meadpager;
        if (c.type.equals(com.cyberlink.beautycircle.model.MeADPager.DisplayType.b))
        {
            d = context.inflate(k.bc_view_me_item, viewgroup, false);
        } else
        {
            d = context.inflate(k.bc_view_me_ad_item, viewgroup, false);
        }
        d.setTag(Integer.valueOf(hashCode()));
        e = (UICImageView)d.findViewById(j.me_avatar);
        f = (ImageView)d.findViewById(j.avatar_crown);
        g = (UICImageView)d.findViewById(j.me_top_background);
        h = d.findViewById(j.me_change_avatar_btn);
        i = d.findViewById(j.me_change_cover_btn);
        k = (EmojiconTextView)d.findViewById(j.me_display_name);
        l = (EmojiconTextView)d.findViewById(j.me_userType);
        m = (EmojiconTextView)d.findViewById(j.me_description);
        o = d.findViewById(j.me_account_verified);
        p = d.findViewById(j.me_right_arrow);
        q = d.findViewById(j.me_edit_about);
        n = (TextView)d.findViewById(j.me_website);
        j = d.findViewById(j.me_name_panel);
        if (j != null)
        {
            j.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener(p1) {

                final p a;
                final q b;

                public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                        int k2, int l2)
                {
                    com.cyberlink.beautycircle.controller.fragment.q.a(b).removeOnLayoutChangeListener(this);
                    if (com.cyberlink.beautycircle.controller.fragment.q.a(b) != null && com.cyberlink.beautycircle.controller.fragment.q.b(b) != null && com.cyberlink.beautycircle.controller.fragment.q.c(b) != null)
                    {
                        i1 = com.cyberlink.beautycircle.controller.fragment.q.a(b).getWidth();
                        j1 = com.cyberlink.beautycircle.controller.fragment.q.b(b).getWidth();
                        com.cyberlink.beautycircle.controller.fragment.q.c(b).setMaxWidth(i1 - j1);
                    }
                }

            
            {
                b = q.this;
                a = p1;
                super();
            }
            });
        }
        viewgroup.addView(d);
    }

    static View a(q q1)
    {
        return q1.j;
    }

    private boolean a(UserInfo userinfo)
    {
        return userinfo != null && userinfo.coverUrl != null && !userinfo.coverUrl.toString().isEmpty();
    }

    static View b(q q1)
    {
        return q1.o;
    }

    static EmojiconTextView c(q q1)
    {
        return q1.k;
    }

    static UICImageView d(q q1)
    {
        return q1.g;
    }

    public View a()
    {
        return d;
    }

    public void a(UserInfo userinfo, boolean flag, boolean flag1)
    {
        int i1;
        int j1;
        Uri uri;
        String s;
        String s1;
        boolean flag2;
        if (flag && flag1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (userinfo != null)
        {
            uri = userinfo.avatarUrl;
        } else
        {
            uri = null;
        }
        if (e != null)
        {
            e.setImageURI(uri);
        }
        if (userinfo != null)
        {
            com.cyberlink.beautycircle.a.a(f, userinfo.userType);
        }
        if (g != null)
        {
            if (c.type.equals(com.cyberlink.beautycircle.model.MeADPager.DisplayType.b))
            {
                if (userinfo == null)
                {
                    g.setImageURI(null);
                } else
                if (a(userinfo))
                {
                    g.setImageURI(userinfo.coverUrl);
                } else
                if (com.cyberlink.beautycircle.controller.fragment.p.I(b))
                {
                    com.cyberlink.beautycircle.controller.fragment.p.f(b, false);
                    com.cyberlink.beautycircle.utility.j.a().a(userinfo.userType, a);
                } else
                {
                    g.setImageURI(com.cyberlink.beautycircle.controller.fragment.p.J(b));
                }
            } else
            {
                g.setImageURI(c.imageUrl);
                g.setOnClickListener(com.cyberlink.beautycircle.controller.fragment.p.K(b));
                g.setTag(c);
            }
        }
        if (userinfo != null && userinfo.description != null)
        {
            s = userinfo.description;
        } else
        {
            s = null;
        }
        if (userinfo != null && userinfo.websiteUrl != null)
        {
            s1 = userinfo.websiteUrl;
        } else
        {
            s1 = null;
        }
        if (m != null && q != null && p != null)
        {
            m.setVisibility(0);
            q.setVisibility(8);
            if ((s == null || s.isEmpty()) && (s1 == null || s1.isEmpty()))
            {
                if (flag)
                {
                    q.setVisibility(0);
                    q.setOnClickListener(com.cyberlink.beautycircle.controller.fragment.p.L(b));
                }
                m.setVisibility(8);
                p.setOnClickListener(null);
                p.setVisibility(8);
            } else
            {
                m.setText(s);
                p.setOnClickListener(com.cyberlink.beautycircle.controller.fragment.p.M(b));
                p.setVisibility(0);
            }
            m.setOnClickListener(com.cyberlink.beautycircle.controller.fragment.p.M(b));
        }
        if (userinfo != null && userinfo.displayName != null)
        {
            s = userinfo.displayName;
        } else
        {
            s = "";
        }
        if (k != null)
        {
            k.setText(s);
            k.setOnLongClickListener(b.t);
        }
        if (n != null && com.cyberlink.beautycircle.controller.fragment.p.e(b) != null && com.cyberlink.beautycircle.controller.fragment.p.e(b).websiteUrl != null)
        {
            n.setVisibility(0);
            n.setText(com.cyberlink.beautycircle.controller.fragment.p.e(b).websiteUrl);
            n.setOnClickListener(new android.view.View.OnClickListener() {

                final q a;

                public void onClick(View view)
                {
                    view = AccountManager.c();
                    if (com.cyberlink.beautycircle.controller.fragment.p.a(a.b) != -1L && (view == null || com.cyberlink.beautycircle.controller.fragment.p.a(a.b) != view.longValue()))
                    {
                        com.perfectcorp.a.b.a(new ap("click_me_url", null, Long.toString(com.cyberlink.beautycircle.controller.fragment.p.a(a.b))));
                    }
                    com.cyberlink.beautycircle.c.a(a.b.getActivity(), com.cyberlink.beautycircle.controller.fragment.p.e(a.b).websiteUrl, 2);
                }

            
            {
                a = q.this;
                super();
            }
            });
        }
        if (o != null)
        {
            if (userinfo != null && userinfo.c())
            {
                o.setVisibility(0);
            } else
            {
                o.setVisibility(8);
            }
        }
        if (l == null) goto _L2; else goto _L1
_L1:
        if (userinfo == null || userinfo.userType == null) goto _L4; else goto _L3
_L3:
        if (userinfo.userType.equals("Expert"))
        {
            j1 = m.bc_me_usertype_expert;
        } else
        if (userinfo.userType.equals("Master"))
        {
            j1 = m.bc_me_usertype_master;
        } else
        if (userinfo.userType.equals("Brand"))
        {
            j1 = m.bc_me_usertype_brand;
        } else
        if (userinfo.userType.equals("Publisher"))
        {
            j1 = m.bc_me_usertype_publisher;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (userinfo.userType.equals("Brand"))
        {
            i1 = j1;
            if (userinfo.userSubType != null)
            {
                if (userinfo.userSubType.equals("COSMETIC"))
                {
                    i1 = m.bc_me_usertype_cosmetic;
                } else
                if (userinfo.userSubType.equals("EYE"))
                {
                    i1 = m.bc_me_usertype_eye;
                } else
                if (userinfo.userSubType.equals("HAIR"))
                {
                    i1 = m.bc_me_usertype_hair;
                } else
                if (userinfo.userSubType.equals("HAIRSALON"))
                {
                    i1 = m.bc_me_usertype_hairsSalon;
                } else
                if (userinfo.userSubType.equals("EYEWEAR"))
                {
                    i1 = m.bc_me_usertype_eyewear;
                } else
                if (userinfo.userSubType.equals("JEWELRY"))
                {
                    i1 = m.bc_me_usertype_jewelry;
                } else
                {
                    i1 = j1;
                    if (userinfo.userSubType.equals("HAIRDECO"))
                    {
                        i1 = m.bc_me_usertype_hairdeco;
                    }
                }
            }
        }
        if (i1 == 0)
        {
            l.setVisibility(8);
        } else
        {
            l.setVisibility(0);
            l.setText(i1);
            m.setMaxLines(1);
        }
_L2:
        if (!flag2) goto _L6; else goto _L5
_L5:
        if (e != null)
        {
            e.setOnClickListener(com.cyberlink.beautycircle.controller.fragment.p.N(b));
        }
        if (h != null)
        {
            if (uri != null && !uri.toString().isEmpty())
            {
                h.setVisibility(4);
            } else
            {
                h.setVisibility(0);
            }
        }
        if (i != null)
        {
            i.setOnClickListener(com.cyberlink.beautycircle.controller.fragment.p.O(b));
            i.setVisibility(0);
        }
_L8:
        return;
_L4:
        l.setVisibility(8);
        continue; /* Loop/switch isn't completed */
_L6:
        if (e != null)
        {
            e.setOnClickListener(null);
        }
        if (m != null)
        {
            m.setOnClickListener(null);
        }
        if (h != null)
        {
            h.setVisibility(4);
        }
        if (i == null) goto _L8; else goto _L7
_L7:
        i.setOnClickListener(null);
        i.setVisibility(4);
        return;
        if (true) goto _L10; else goto _L9
_L10:
        break MISSING_BLOCK_LABEL_430;
_L9:
        if (true) goto _L2; else goto _L11
_L11:
    }

    public com.cyberlink.beautycircle.model.MeADPager.DisplayType b()
    {
        if (c != null)
        {
            return c.type;
        } else
        {
            return com.cyberlink.beautycircle.model.MeADPager.DisplayType.a;
        }
    }
}
