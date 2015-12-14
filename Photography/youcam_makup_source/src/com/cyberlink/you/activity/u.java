// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.g;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.utility.s;
import com.cyberlink.you.utility.v;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.you.activity:
//            v, StickerShopAcitvity, StickerShopDetailActivity

public class u extends Fragment
{

    private static View d;
    private static long f;
    private ListView a;
    private View b;
    private com.cyberlink.you.activity.v c;
    private String e;
    private android.widget.AbsListView.OnScrollListener g;
    private com.cyberlink.you.utility.u h;
    private android.widget.AdapterView.OnItemClickListener i;

    public u()
    {
        g = new android.widget.AbsListView.OnScrollListener() {

            final u a;
            private int b;
            private int c;
            private int d;

            public void onScroll(AbsListView abslistview, int j, int k, int l)
            {
                b = j;
                c = k;
                d = l;
            }

            public void onScrollStateChanged(AbsListView abslistview, int j)
            {
                if (j == 0 || j == 1 || j != 2);
                if (j == 0 && b + c == d)
                {
                    Log.d("StickerShopAcitvity", "isBottom");
                }
                if (j == 0 && b == 0)
                {
                    Log.d("StickerShopAcitvity", "isTop");
                }
            }

            
            {
                a = u.this;
                super();
            }
        };
        h = new com.cyberlink.you.utility.u() {

            final u a;

            public void a(String s1, boolean flag)
            {
                if (a.getActivity() == null)
                {
                    return;
                } else
                {
                    a.getActivity().runOnUiThread(new Runnable(this, flag, s1) {

                        final boolean a;
                        final String b;
                        final _cls2 c;

                        public void run()
                        {
                            if (a && b.equals(u.a(c.a)))
                            {
                                List list = s.a().a(b);
                                if (list != null)
                                {
                                    u.b(c.a).clear();
                                    u.b(c.a).addAll(list);
                                    if (u.a(c.a).equals("New"))
                                    {
                                        com.cyberlink.you.g.a().d(true);
                                        if (u.a() != null)
                                        {
                                            u.a().setVisibility(8);
                                        }
                                    }
                                }
                            }
                            u.c(c.a).setVisibility(8);
                            Log.v("StickerShopAcitvity", (new StringBuilder()).append("UpdateStickerShopTask ").append(b).append(" done").toString());
                        }

            
            {
                c = _pcls2;
                a = flag;
                b = s1;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                a = u.this;
                super();
            }
        };
        i = new android.widget.AdapterView.OnItemClickListener() {

            final u a;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                adapterview = (StickerPackObj)u.b(a).getItem(j);
                view = new Intent(a.getActivity(), com/cyberlink/you/activity/StickerShopDetailActivity);
                view.putExtra("stickerPckObj", adapterview);
                view.putExtra("isPurchased", false);
                a.getActivity().startActivity(view);
            }

            
            {
                a = u.this;
                super();
            }
        };
    }

    static long a(long l)
    {
        f = l;
        return l;
    }

    static View a()
    {
        return d;
    }

    static View a(View view)
    {
        d = view;
        return view;
    }

    static String a(u u1)
    {
        return u1.e;
    }

    private void a(String s1)
    {
        s1 = s.a().a(s1);
        Log.e("StickerShopAcitvity", (new StringBuilder()).append("stickerPackList=").append(s1.size()).toString());
        if (s1 != null)
        {
            c.clear();
            c.addAll(s1);
            if (e.equals("New"))
            {
                com.cyberlink.you.g.a().d(true);
                if (d != null)
                {
                    d.setVisibility(8);
                }
            }
        }
        if (StickerShopAcitvity.b().get())
        {
            return;
        } else
        {
            a(false);
            return;
        }
    }

    static long b()
    {
        return f;
    }

    static com.cyberlink.you.activity.v b(u u1)
    {
        return u1.c;
    }

    static View c(u u1)
    {
        return u1.b;
    }

    public void a(boolean flag)
    {
        boolean flag1;
        Log.d("StickerShopAcitvity", (new StringBuilder()).append("[onCheckNewStickerComplete] bHasNew=").append(flag).toString());
        flag1 = flag;
        if (flag) goto _L2; else goto _L1
_L1:
        if (!e.equals("Top")) goto _L4; else goto _L3
_L3:
        flag1 = com.cyberlink.you.g.a().A();
_L2:
        if (flag1 || c.isEmpty() || s.a().b() || e.equals("Top") && s.a().c())
        {
            v v1 = new v(e, getActivity());
            s.a().a(v1);
            if (c.isEmpty())
            {
                b.setVisibility(0);
            }
        }
        return;
_L4:
        flag1 = flag;
        if (e.equals("New"))
        {
            flag1 = com.cyberlink.you.g.a().z();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(p.u_fragment_sticker_shop_list, viewgroup, false);
    }

    public void onDestroyView()
    {
        s.a().b(h);
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        if (!com.cyberlink.you.g.a().C())
        {
            d.setVisibility(0);
        }
        a = (ListView)view.findViewById(o.stickerShopList);
        a.setOnScrollListener(g);
        b = view.findViewById(o.loading);
        c = new com.cyberlink.you.activity.v(this, getActivity(), p.u_sticker_shop_item, new ArrayList());
        a.setAdapter(c);
        a.setOnItemClickListener(i);
        view = getArguments().getString("type");
        e = view;
        s.a().a(h);
        a(view);
    }
}
