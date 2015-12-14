// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.activity.CircleActivity;
import com.cyberlink.beautycircle.controller.adapter.e;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.l;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.a;
import com.cyberlink.beautycircle.utility.n;
import com.cyberlink.beautycircle.utility.o;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.u;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.model.Model;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            e, h

public class i extends com.cyberlink.beautycircle.controller.fragment.e
{

    private u A;
    private com.cyberlink.beautycircle.controller.adapter.n B;
    private o C;
    private long s;
    private long t;
    private long x;
    private CircleDetail y;
    private a z;

    public i()
    {
        s = -1L;
        t = -1L;
        x = -1L;
        z = new a() {

            final i a;

            public void a(UserInfo userinfo)
            {
                com.perfectcorp.utility.e.b(new Object[0]);
                if (a.h != null)
                {
                    a.h.g = true;
                }
            }

            
            {
                a = i.this;
                super();
            }
        };
        A = new u() {

            final i a;

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "OnPostRefresh"
                });
                if (a.h != null)
                {
                    a.h.g = true;
                }
            }

            
            {
                a = i.this;
                super();
            }
        };
        B = new h(this);
        C = new o() {

            final i a;

            public void a(CircleDetail circledetail, boolean flag)
            {
                Long long1;
                if (a.i != null)
                {
                    if ((circledetail = (TextView)a.i.findViewById(j.circle_panel_follower)) != null && (long1 = i.b(a).followerCount) != null)
                    {
                        circledetail.setText((new StringBuilder()).append(long1).append(" ").append(circledetail.getResources().getQuantityString(l.bc_me_status_followers, long1.intValue())).toString());
                        if (long1.longValue() > 0L)
                        {
                            circledetail.setEnabled(true);
                            return;
                        } else
                        {
                            circledetail.setEnabled(false);
                            return;
                        }
                    }
                }
            }

            
            {
                a = i.this;
                super();
            }
        };
    }

    static long a(i i1, long l1)
    {
        i1.s = l1;
        return l1;
    }

    static CircleDetail a(i i1, CircleDetail circledetail)
    {
        i1.y = circledetail;
        return circledetail;
    }

    private void a(View view)
    {
        if (view != null && y != null)
        {
            Object obj = getActivity();
            boolean flag;
            if (s != -1L && s == y.circleCreatorId.longValue())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (obj instanceof BaseActivity)
            {
                ((BaseActivity)obj).a(y.circleName);
            }
            obj = view.findViewById(j.circle_description_panel);
            if (obj != null)
            {
                if (flag)
                {
                    ((View) (obj)).setVisibility(0);
                } else
                {
                    if (y.description == null || y.description.length() == 0)
                    {
                        ((View) (obj)).setVisibility(8);
                    } else
                    {
                        ((View) (obj)).setVisibility(0);
                    }
                    if (o != null)
                    {
                        TextView textview = (TextView)o.findViewById(j.error_message_text);
                        if (textview != null)
                        {
                            String s1 = getResources().getString(m.bc_circle_no_post_others_circle);
                            if (y.creatorName != null)
                            {
                                obj = y.creatorName;
                            } else
                            {
                                obj = "";
                            }
                            textview.setText(String.format(Locale.getDefault(), s1, new Object[] {
                                obj
                            }));
                        }
                    }
                }
            }
            obj = (TextView)view.findViewById(j.circle_description);
            if (obj != null)
            {
                if (y.description != null && y.description.length() > 0)
                {
                    ((TextView) (obj)).setText(y.description);
                } else
                {
                    ((TextView) (obj)).setText(m.bc_edit_circle_empty_hint);
                }
            }
            obj = view.findViewById(j.circle_panel_secret);
            if (obj != null)
            {
                if (y.isSecret != null && y.isSecret.booleanValue())
                {
                    ((View) (obj)).setSelected(true);
                    ((View) (obj)).setVisibility(0);
                } else
                {
                    ((View) (obj)).setSelected(false);
                    ((View) (obj)).setVisibility(4);
                }
            }
            obj = (TextView)view.findViewById(j.circle_panel_follower);
            if (obj != null)
            {
                Long long1 = y.followerCount;
                if (long1 != null)
                {
                    ((TextView) (obj)).setText((new StringBuilder()).append(long1).append(" ").append(((TextView) (obj)).getResources().getQuantityString(l.bc_me_status_followers, long1.intValue())).toString());
                    ((TextView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                        final i a;

                        public void onClick(View view1)
                        {
                            com.cyberlink.beautycircle.c.a(a.getActivity(), com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.c, i.b(a).circleCreatorId, i.b(a).id);
                        }

            
            {
                a = i.this;
                super();
            }
                    });
                    if (long1.longValue() > 0L)
                    {
                        ((TextView) (obj)).setEnabled(true);
                    } else
                    {
                        ((TextView) (obj)).setEnabled(false);
                    }
                }
            }
            if (y.isEditable != null && y.isEditable.booleanValue())
            {
                obj = view.findViewById(j.circle_edit_description);
                if (obj != null)
                {
                    ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                        final i a;

                        public void onClick(View view1)
                        {
                            com.cyberlink.beautycircle.c.a(a.getActivity(), 4, i.b(a));
                        }

            
            {
                a = i.this;
                super();
            }
                    });
                }
            } else
            {
                view.findViewById(j.circle_edit_description_icon).setVisibility(4);
            }
            view = (TextView)view.findViewById(j.circle_panel_edit);
            if (view != null)
            {
                if (y.isEditable != null && y.isEditable.booleanValue())
                {
                    view.setOnClickListener(new android.view.View.OnClickListener() {

                        final i a;

                        public void onClick(View view1)
                        {
                            com.cyberlink.beautycircle.c.a(a.getActivity(), i.b(a), Boolean.valueOf(true));
                        }

            
            {
                a = i.this;
                super();
            }
                    });
                    return;
                }
                view.setBackgroundResource(com.cyberlink.beautycircle.i.bc_follow_button_background);
                try
                {
                    android.content.res.XmlResourceParser xmlresourceparser = getResources().getXml(com.cyberlink.beautycircle.i.bc_follow_button_text_selector);
                    view.setTextColor(ColorStateList.createFromXml(getResources(), xmlresourceparser));
                }
                catch (Exception exception)
                {
                    Globals.b("Load color XML fail");
                }
                com.cyberlink.beautycircle.utility.n.a(view, view, y, C);
                return;
            }
        }
    }

    static void a(i i1)
    {
        i1.q();
    }

    static void a(i i1, View view)
    {
        i1.a(view);
    }

    private void a(Long long1, Long long2, CircleDetail circledetail)
    {
        FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null)
        {
            ((BaseActivity)fragmentactivity).k();
        }
        (new com.perfectcorp.utility.j(circledetail, long2, long1) {

            final CircleDetail a;
            final Long b;
            final Long c;
            final i d;

            protected CircleDetail a(Void void1)
            {
                void1 = AccountManager.d();
                if (void1 != null)
                {
                    com.cyberlink.beautycircle.controller.fragment.i.a(d, ((UserInfo) (void1)).id);
                }
                if (a != null)
                {
                    return a;
                }
                try
                {
                    void1 = (CircleDetail)((d)NetworkCircle.a(b, c, Long.valueOf(com.cyberlink.beautycircle.controller.fragment.i.c(d))).d()).b.get(0);
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                    return null;
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                    return null;
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                    return null;
                }
                return void1;
            }

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            
            {
                d = i.this;
                a = circledetail;
                b = long1;
                c = long2;
                super();
            }
        }).d(null).a(new com.perfectcorp.utility.m() {

            final i a;

            protected void a(CircleDetail circledetail1)
            {
                if (circledetail1 != null)
                {
                    com.cyberlink.beautycircle.controller.fragment.i.a(a, circledetail1);
                    com.cyberlink.beautycircle.controller.fragment.i.a(a);
                    com.cyberlink.beautycircle.controller.fragment.i.a(a, a.i);
                }
                circledetail1 = a.getActivity();
                if (circledetail1 != null)
                {
                    ((BaseActivity)circledetail1).l();
                    if (circledetail1 instanceof CircleActivity)
                    {
                        ((CircleActivity)circledetail1).a(i.b(a));
                    }
                }
            }

            protected void b(Object obj)
            {
                a((CircleDetail)obj);
            }

            
            {
                a = i.this;
                super();
            }
        });
    }

    static CircleDetail b(i i1)
    {
        return i1.y;
    }

    static long c(i i1)
    {
        return i1.s;
    }

    private void q()
    {
        if (getActivity() != null)
        {
            h = new e(getActivity(), g, k.bc_view_item_discover_list, null, B);
            ((e)h).a(y);
            h.d(false);
            h.c();
        }
    }

    public boolean n()
    {
        if (y != null)
        {
            return Globals.a(y.isFollowed);
        } else
        {
            return false;
        }
    }

    public Long o()
    {
        if (y != null)
        {
            return y.id;
        } else
        {
            return null;
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        i1;
        JVM INSTR tableswitch 48148 48153: default 48
    //                   48148 82
    //                   48149 48
    //                   48150 48
    //                   48151 48
    //                   48152 49
    //                   48153 49;
           goto _L1 _L2 _L1 _L1 _L1 _L3 _L3
_L1:
        return;
_L3:
        if (j1 == -1)
        {
            y = (CircleDetail)Model.a(com/cyberlink/beautycircle/model/CircleDetail, intent.getStringExtra("CircleDetail"));
            a(i);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (h != null)
        {
            h.notifyDataSetChanged();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(k.bc_fragment_page_hot_topic, viewgroup, false);
        bundle = getActivity().getIntent();
        if (bundle != null)
        {
            viewgroup = bundle.getStringExtra("CircleDetail");
            if (viewgroup != null && !viewgroup.isEmpty())
            {
                viewgroup = (CircleDetail)Model.a(com/cyberlink/beautycircle/model/CircleDetail, viewgroup);
            } else
            {
                viewgroup = null;
            }
            t = bundle.getLongExtra("CreatorId", -1L);
            x = bundle.getLongExtra("CircleId", -1L);
        } else
        {
            viewgroup = null;
        }
        a(layoutinflater, view, Integer.valueOf(k.bc_view_header_circle), Integer.valueOf(k.bc_view_footer));
        if (t != -1L)
        {
            layoutinflater = Long.valueOf(t);
        } else
        {
            layoutinflater = null;
        }
        if (x != -1L)
        {
            bundle = Long.valueOf(x);
        } else
        {
            bundle = null;
        }
        a(layoutinflater, bundle, viewgroup);
        a(view, false, false, false, null);
        a(view, m.bc_circle_no_post_in_circle, false);
        AccountManager.a(z);
        t.b.a(A);
        b();
        return view;
    }

    public void onDestroy()
    {
        AccountManager.b(z);
        t.b.b(A);
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        if (h != null && h.j())
        {
            h.g = true;
            com.perfectcorp.utility.e.b(new Object[] {
                "Set ForcedRefresh by refresh expired."
            });
        }
        if (h != null && h.g)
        {
            h.c();
        }
    }

    public CircleDetail p()
    {
        return y;
    }
}
