// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.ab;
import com.cyberlink.beautycircle.controller.a.s;
import com.cyberlink.beautycircle.controller.activity.HotTopicActivity;
import com.cyberlink.beautycircle.controller.adapter.g;
import com.cyberlink.beautycircle.controller.adapter.m;
import com.cyberlink.beautycircle.controller.adapter.n;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.CircleType;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.a;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            e, h

public class o extends com.cyberlink.beautycircle.controller.fragment.e
{

    private n A;
    public boolean s;
    private Long t;
    private String x;
    private String y;
    private a z;

    public o()
    {
        t = null;
        x = null;
        y = null;
        s = false;
        z = new a() {

            final o a;

            public void a(UserInfo userinfo)
            {
                e.b(new Object[0]);
                if (a.h != null)
                {
                    a.h.g = true;
                }
            }

            
            {
                a = o.this;
                super();
            }
        };
        A = new h(this);
    }

    static Long a(o o1)
    {
        return o1.t;
    }

    static String a(o o1, String s1)
    {
        o1.x = s1;
        return s1;
    }

    static String b(o o1)
    {
        return o1.y;
    }

    static String c(o o1)
    {
        return o1.x;
    }

    private void o()
    {
        if (t == null)
        {
            e.b(new Object[] {
                "The category is invalid."
            });
            return;
        } else
        {
            CircleType.b().a(new com.perfectcorp.utility.m() {

                final o a;

                protected void a()
                {
                    a(0x80000005);
                }

                protected void a(int i)
                {
                    e.e(new Object[] {
                        Integer.valueOf(i)
                    });
                }

                protected void a(d d1)
                {
                    if (d1 != null && d1.b != null && !d1.b.isEmpty()) goto _L2; else goto _L1
_L1:
                    a(0x80000003);
_L8:
                    return;
_L2:
                    FragmentActivity fragmentactivity;
                    fragmentactivity = a.getActivity();
                    d1 = d1.b.iterator();
_L4:
                    CircleType circletype;
                    do
                    {
                        if (!d1.hasNext())
                        {
                            continue; /* Loop/switch isn't completed */
                        }
                        circletype = (CircleType)d1.next();
                    } while (circletype == null || !com.cyberlink.beautycircle.controller.fragment.o.a(a).equals(circletype.id));
                    if (!circletype.defaultType.equals("HOW-TO"))
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    s.a = "bc_howto";
                    ((HotTopicActivity)fragmentactivity).a(true);
_L6:
                    com.cyberlink.beautycircle.controller.fragment.o.a(a, circletype.circleTypeName);
                    if (true) goto _L4; else goto _L3
_L3:
                    if (a.l == null) goto _L6; else goto _L5
_L5:
                    a.f = true;
                    a.l.setVisibility(0);
                    a.l.setOnClickListener(new android.view.View.OnClickListener(this, fragmentactivity) {

                        final Activity a;
                        final _cls2 b;

                        public void onClick(View view)
                        {
                            com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.e(com.cyberlink.beautycircle.controller.fragment.o.b(b.a), 0L, "createpost", b.a.s, b.a.n()));
                            com.cyberlink.beautycircle.c.a(a, com.cyberlink.beautycircle.controller.fragment.o.a(b.a).longValue(), null, null, false, null, null, com.cyberlink.beautycircle.controller.fragment.o.b(b.a));
                        }

            
            {
                b = _pcls2;
                a = activity;
                super();
            }
                    });
                      goto _L6
                    if (fragmentactivity == null || !(fragmentactivity instanceof HotTopicActivity)) goto _L8; else goto _L7
_L7:
                    ((HotTopicActivity)fragmentactivity).f(com.cyberlink.beautycircle.controller.fragment.o.c(a));
                    return;
                }

                protected void b(Object obj)
                {
                    a((d)obj);
                }

            
            {
                a = o.this;
                super();
            }
            });
            return;
        }
    }

    public long n()
    {
        if (h != null)
        {
            return ((g)h).d;
        } else
        {
            return 0L;
        }
    }

    public void onActivityResult(int i, int l, Intent intent)
    {
        super.onActivityResult(i, l, intent);
        i;
        JVM INSTR tableswitch 48148 48148: default 28
    //                   48148 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (h != null)
        {
            h.notifyDataSetChanged();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        bundle = layoutinflater.inflate(k.bc_fragment_page_hot_topic, viewgroup, false);
        Intent intent = getActivity().getIntent();
        if (intent != null)
        {
            viewgroup = Long.valueOf(intent.getLongExtra("CategoryId", 0L));
        } else
        {
            viewgroup = null;
        }
        t = viewgroup;
        if (intent != null)
        {
            viewgroup = intent.getStringExtra("CategoryName");
        } else
        {
            viewgroup = null;
        }
        x = viewgroup;
        if (intent != null)
        {
            viewgroup = intent.getStringExtra("CategoryType");
        } else
        {
            viewgroup = null;
        }
        y = viewgroup;
        o();
        a(layoutinflater, bundle, null, Integer.valueOf(k.bc_view_footer));
        h = new g(getActivity(), g, k.bc_view_item_discover_list, null, A);
        ((g)h).a(t);
        h.d(false);
        h.c();
        h.j = s;
        a(bundle, true, false, false, null);
        a(bundle, 0, true);
        AccountManager.a(z);
        b();
        return bundle;
    }

    public void onDestroy()
    {
        AccountManager.b(z);
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        if (h != null && h.j())
        {
            h.g = true;
            e.b(new Object[] {
                "Set ForcedRefresh by refresh expired."
            });
        }
        if (h != null && h.g)
        {
            h.c();
        }
        if (t != null)
        {
            com.perfectcorp.a.b.a(new ab(Long.toString(t.longValue())));
        }
        s.a = "bc_howto";
    }
}
