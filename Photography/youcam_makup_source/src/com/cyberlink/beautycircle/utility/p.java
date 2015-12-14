// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.q;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            q, AccountManager, t, v, 
//            DialogUtils, b

public abstract class p
{

    private static boolean a = false;

    public static android.view.View.OnClickListener a(UserInfo userinfo, com.cyberlink.beautycircle.utility.q q)
    {
        if (userinfo == null)
        {
            return null;
        } else
        {
            return new android.view.View.OnClickListener(q, userinfo) {

                final com.cyberlink.beautycircle.utility.q a;
                final UserInfo b;

                private void a(View view)
                {
                    if (!(view instanceof TextView)) goto _L2; else goto _L1
_L1:
                    ((TextView)view).setText(m.bc_following);
                    view.setSelected(false);
_L4:
                    if (a != null)
                    {
                        a.a(b, true);
                    }
                    return;
_L2:
                    view = view.findViewById(j.follow_text);
                    if (view instanceof TextView)
                    {
                        ((TextView)view).setText(m.bc_following);
                        view.setSelected(false);
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

                private void a(View view, String s)
                {
                    if (b.b() == null)
                    {
                        e.d(new Object[] {
                            "Unable to follow/unfollow: userId=", Long.valueOf(b.id)
                        });
                        Globals.b((new StringBuilder()).append("Unable to follow userId=").append(b.id).toString());
                        view.setVisibility(4);
                        return;
                    }
                    if (!b.b().booleanValue())
                    {
                        b.isFollowed = Boolean.valueOf(true);
                        if (b.followerCount != null)
                        {
                            Object obj = b.followerCount;
                            obj = b;
                            obj.followerCount = Integer.valueOf(((UserInfo) (obj)).followerCount.intValue() + 1);
                        }
                        if (AccountManager.c() != null)
                        {
                            com.perfectcorp.a.b.a(new q(Long.valueOf(b.id), AccountManager.c()));
                        }
                        NetworkUser.a(s, b.id).a(new com.perfectcorp.utility.m(this, view) {

                            final View a;
                            final _cls1 b;

                            protected void a()
                            {
                                a(0x80000005);
                            }

                            protected void a(int i)
                            {
                                e.b(new Object[] {
                                    "Follow userId=", Long.valueOf(b.b.id), " fail: ", Integer.valueOf(i)
                                });
                                String s = a.getResources().getString(m.bc_follow_fail);
                                Globals.a(String.format(Locale.getDefault(), s, new Object[] {
                                    b.b.displayName
                                }));
                                b.b.isFollowed = Boolean.valueOf(false);
                                _cls1.a(b, a);
                            }

                            public void a(Void void1)
                            {
                                e.b(new Object[] {
                                    "Follow userId=", Long.valueOf(b.b.id), " success"
                                });
                                void1 = a.getResources().getString(m.bc_follow_success);
                                Globals.a(String.format(Locale.getDefault(), void1, new Object[] {
                                    b.b.displayName
                                }));
                            }

                            public void b(Object obj)
                            {
                                a((Void)obj);
                            }

            
            {
                b = _pcls1;
                a = view;
                super();
            }
                        });
                        a(view);
                        t.c.a();
                        return;
                    }
                    s = new Runnable(this, s, view) {

                        final String a;
                        final View b;
                        final _cls1 c;

                        public void run()
                        {
                            c.b.isFollowed = Boolean.valueOf(false);
                            if (c.b.followerCount != null)
                            {
                                Object obj = c.b.followerCount;
                                obj = c.b;
                                obj.followerCount = Integer.valueOf(((UserInfo) (obj)).followerCount.intValue() - 1);
                            }
                            NetworkUser.b(a, c.b.id).a(new com.perfectcorp.utility.m(this) {

                                final _cls4 a;

                                protected void a()
                                {
                                    a(0x80000005);
                                }

                                protected void a(int i)
                                {
                                    e.b(new Object[] {
                                        "Unfollow userId=", Long.valueOf(a.c.b.id), " fail: ", Integer.valueOf(i)
                                    });
                                    String s = a.b.getResources().getString(m.bc_unfollow_fail);
                                    Globals.a(String.format(Locale.getDefault(), s, new Object[] {
                                        a.c.b.displayName
                                    }));
                                    a.c.b.isFollowed = Boolean.valueOf(true);
                                    com.cyberlink.beautycircle.utility._cls1.b(a.c, a.b);
                                }

                                public void a(Void void1)
                                {
                                    e.b(new Object[] {
                                        "Unfollow userId=", Long.valueOf(a.c.b.id), " success"
                                    });
                                    void1 = a.b.getResources().getString(m.bc_unfollow_success);
                                    Globals.a(String.format(Locale.getDefault(), void1, new Object[] {
                                        a.c.b.displayName
                                    }));
                                }

                                public void b(Object obj)
                                {
                                    a((Void)obj);
                                }

            
            {
                a = _pcls4;
                super();
            }
                            });
                            _cls1.a(c, b);
                            t.c.a();
                        }

            
            {
                c = _pcls1;
                a = s;
                b = view;
                super();
            }
                    };
                    android.content.Context context = view.getContext();
                    if (p.a() && (context instanceof Activity))
                    {
                        view = view.getResources();
                        DialogUtils.a((Activity)context, view.getString(m.bc_unfollow_title), view.getString(m.bc_unfollow_confirm), view.getString(m.bc_dialog_button_cancel), null, view.getString(m.bc_unfollow_button), s);
                        return;
                    } else
                    {
                        s.run();
                        return;
                    }
                }

                static void a(_cls1 _pcls1, View view)
                {
                    _pcls1.b(view);
                }

                static void a(_cls1 _pcls1, View view, String s)
                {
                    _pcls1.a(view, s);
                }

                private void b(View view)
                {
                    if (!(view instanceof TextView)) goto _L2; else goto _L1
_L1:
                    ((TextView)view).setText(m.bc_plus_follow);
                    view.setSelected(true);
_L4:
                    if (a != null)
                    {
                        a.a(b, false);
                    }
                    return;
_L2:
                    view = view.findViewById(j.follow_text);
                    if (view instanceof TextView)
                    {
                        ((TextView)view).setText(m.bc_plus_follow);
                        view.setSelected(true);
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

                static void b(_cls1 _pcls1, View view)
                {
                    _pcls1.a(view);
                }

                public void onClick(View view)
                {
                    if (view == null)
                    {
                        return;
                    } else
                    {
                        (new com.perfectcorp.utility.j(this) {

                            final _cls1 a;

                            protected volatile Object a(Object obj)
                            {
                                return a((Void)obj);
                            }

                            protected String a(Void void1)
                            {
                                return com.cyberlink.beautycircle.utility.AccountManager.b();
                            }

            
            {
                a = _pcls1;
                super();
            }
                        }).d(null).a(new com.perfectcorp.utility.m(this, view) {

                            final View a;
                            final _cls1 b;

                            protected void a(String s)
                            {
                                if (s == null)
                                {
                                    aq.c = "follow_user,";
                                    AccountManager.a(a.getContext(), new com.cyberlink.beautycircle.utility.b(this) {

                                        final _cls1 a;

                                        public void a()
                                        {
                                            Globals.b("Get AccountToken Fail");
                                        }

                                        public void a(String s)
                                        {
                                            a.a.post(new Runnable(this) {

                                                final _cls1 a;

                                                public void run()
                                                {
                                                    if (a.a.b.a != null)
                                                    {
                                                        a.a.b.a.a();
                                                    }
                                                }

            
            {
                a = _pcls1;
                super();
            }
                                            });
                                        }

                                        public void b()
                                        {
                                            Globals.b("Get AccountToken Cancel");
                                        }

            
            {
                a = _pcls1;
                super();
            }
                                    });
                                    return;
                                } else
                                {
                                    _cls1.a(b, a, s);
                                    return;
                                }
                            }

                            protected void b(Object obj)
                            {
                                a((String)obj);
                            }

            
            {
                b = _pcls1;
                a = view;
                super();
            }
                        });
                        return;
                    }
                }

            
            {
                a = q1;
                b = userinfo;
                super();
            }
            };
        }
    }

    public static void a(View view, TextView textview, UserInfo userinfo)
    {
        a(view, textview, userinfo, null);
    }

    public static void a(View view, TextView textview, UserInfo userinfo, com.cyberlink.beautycircle.utility.q q)
    {
label0:
        {
            if (view != null && textview != null)
            {
                if (userinfo.b() != null)
                {
                    break label0;
                }
                view.setVisibility(4);
            }
            return;
        }
        if (userinfo.b().booleanValue())
        {
            textview.setText(m.bc_following);
            textview.setSelected(false);
            view.setOnClickListener(a(userinfo, q));
            view.setVisibility(0);
            return;
        } else
        {
            textview.setText(m.bc_plus_follow);
            textview.setSelected(true);
            view.setOnClickListener(a(userinfo, q));
            view.setVisibility(0);
            return;
        }
    }

    static boolean a()
    {
        return a;
    }

}
