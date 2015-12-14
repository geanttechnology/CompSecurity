// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.utility.e;
import com.rockerhieu.emojicon.EmojiconTextView;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            x, z

public class TopBarFragment extends Fragment
{

    private static int a = 5;
    private static long b = 2000L;
    private long A;
    private int B;
    private int C[];
    private boolean D;
    private android.view.View.OnClickListener E;
    private android.view.View.OnClickListener F;
    private android.view.View.OnClickListener G;
    private int c;
    private ArrayList d;
    private LayoutInflater e;
    private RelativeLayout f;
    private ArrayList g;
    private Animation h;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private ImageView t;
    private View u;
    private EditText v;
    private View w;
    private View x;
    private View y;
    private int z;

    public TopBarFragment()
    {
        c = 0;
        d = new ArrayList();
        e = null;
        f = null;
        g = new ArrayList();
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        v = null;
        w = null;
        x = null;
        y = null;
        z = 0;
        A = 0L;
        B = 0;
        C = null;
        D = false;
        E = new android.view.View.OnClickListener() {

            final TopBarFragment a;

            public void onClick(View view)
            {
                for (view = com.cyberlink.beautycircle.controller.fragment.TopBarFragment.e(a).iterator(); view.hasNext(); ((z)view.next()).f()) { }
            }

            
            {
                a = TopBarFragment.this;
                super();
            }
        };
        F = new android.view.View.OnClickListener() {

            final TopBarFragment a;

            public void onClick(View view)
            {
                for (Iterator iterator = com.cyberlink.beautycircle.controller.fragment.TopBarFragment.e(a).iterator(); iterator.hasNext(); ((z)iterator.next()).onRightBtnClick(view)) { }
            }

            
            {
                a = TopBarFragment.this;
                super();
            }
        };
        G = new android.view.View.OnClickListener() {

            final TopBarFragment a;

            public void onClick(View view)
            {
                for (Iterator iterator = com.cyberlink.beautycircle.controller.fragment.TopBarFragment.e(a).iterator(); iterator.hasNext(); ((z)iterator.next()).onRightSubBtnClick(view)) { }
            }

            
            {
                a = TopBarFragment.this;
                super();
            }
        };
    }

    static int a(TopBarFragment topbarfragment, int i1)
    {
        topbarfragment.z = i1;
        return i1;
    }

    static long a(TopBarFragment topbarfragment)
    {
        return topbarfragment.A;
    }

    static long a(TopBarFragment topbarfragment, long l1)
    {
        topbarfragment.A = l1;
        return l1;
    }

    private void a(int i1, int j1)
    {
        if (n != null && i1 != 0)
        {
            n.setVisibility(0);
            if (j1 != 0)
            {
                n.setImageResource(j1);
            }
        }
    }

    private void a(int i1, int j1, boolean flag)
    {
        if (o != null && i1 != 0)
        {
            o.setVisibility(0);
            if (j1 != 0)
            {
                o.setImageResource(j1);
                if (flag)
                {
                    o.setRotation(180F);
                }
            }
        }
    }

    private void a(View view, int i1, int j1)
    {
        if (view != null)
        {
            if (i1 != 0)
            {
                j1 = 0;
            }
            view.setVisibility(j1);
        }
    }

    static int b(TopBarFragment topbarfragment)
    {
        int i1 = topbarfragment.z;
        topbarfragment.z = i1 + 1;
        return i1;
    }

    private void b(int i1, int j1)
    {
        if (q != null && i1 != 0)
        {
            q.setVisibility(0);
            q.setText(j1);
        }
    }

    static int c(TopBarFragment topbarfragment)
    {
        return topbarfragment.z;
    }

    static long c()
    {
        return b;
    }

    private void c(int i1, int j1)
    {
        if (r != null && i1 != 0)
        {
            r.setVisibility(0);
            r.setText(j1);
        }
    }

    static int d()
    {
        return a;
    }

    private void d(int i1, int j1)
    {
        if (t != null && i1 != 0)
        {
            t.setVisibility(0);
            t.setImageResource(j1);
        }
    }

    static boolean d(TopBarFragment topbarfragment)
    {
        return topbarfragment.f();
    }

    private int e(int i1)
    {
        if (c != 1) goto _L2; else goto _L1
_L1:
        if (i1 != x.a) goto _L4; else goto _L3
_L3:
        int j1 = x.n;
_L6:
        return j1;
_L4:
        if (i1 == x.d)
        {
            return x.o;
        }
        j1 = i1;
        if (i1 == x.h)
        {
            return x.p;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (c != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = i1;
        if (i1 == x.a)
        {
            return x.q;
        }
        if (true) goto _L6; else goto _L5
_L5:
        j1 = i1;
        if (c == 3)
        {
            if (i1 == x.a)
            {
                return x.r;
            }
            j1 = i1;
            if (i1 == x.d)
            {
                return x.s;
            }
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    static ArrayList e(TopBarFragment topbarfragment)
    {
        return topbarfragment.d;
    }

    private void e()
    {
        int i1;
        if (k != null && k.getVisibility() == 0)
        {
            i1 = k.getWidth();
        } else
        if (j != null && j.getVisibility() == 0)
        {
            i1 = j.getWidth();
        } else
        {
            i1 = 0;
        }
        if (f != null)
        {
            f.setPadding(i1, 0, i1, 0);
        }
    }

    static void f(TopBarFragment topbarfragment)
    {
        topbarfragment.e();
    }

    private boolean f()
    {
        Iterator iterator = d.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = ((z)iterator.next()).d(null);
            if (s1 == null)
            {
                continue;
            }
            ((ClipboardManager)getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, s1));
            Globals.a((new StringBuilder()).append("Copy DeepLink to Clipboard: ").append(s1).toString());
            break;
        } while (true);
        return false;
    }

    static EditText g(TopBarFragment topbarfragment)
    {
        return topbarfragment.v;
    }

    public View a(boolean flag)
    {
        return a(flag, false);
    }

    public View a(boolean flag, boolean flag1)
    {
        boolean flag2 = false;
        if (v == null || u == null || w == null || x == null)
        {
            return null;
        }
        View view = u;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
        if (flag)
        {
            View view1 = w;
            if (flag1)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view1.setVisibility(i1);
            view1 = x;
            if (!flag1)
            {
                i1 = ((flag2) ? 1 : 0);
            } else
            {
                i1 = 8;
            }
            view1.setVisibility(i1);
            v.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

                final TopBarFragment a;

                public void onFocusChange(View view2, boolean flag3)
                {
                    for (Iterator iterator = com.cyberlink.beautycircle.controller.fragment.TopBarFragment.e(a).iterator(); iterator.hasNext(); ((z)iterator.next()).a(view2, flag3)) { }
                }

            
            {
                a = TopBarFragment.this;
                super();
            }
            });
            v.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                final TopBarFragment a;

                public boolean onEditorAction(TextView textview, int j1, KeyEvent keyevent)
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "actionId: ", Integer.valueOf(j1), "; KeyEvent: ", keyevent
                    });
                    if (j1 != 0)
                    {
                        return false;
                    }
                    ((BaseActivity)a.getActivity()).i();
                    for (textview = com.cyberlink.beautycircle.controller.fragment.TopBarFragment.e(a).iterator(); textview.hasNext(); ((z)textview.next()).c(com.cyberlink.beautycircle.controller.fragment.TopBarFragment.g(a).getText().toString())) { }
                    return true;
                }

            
            {
                a = TopBarFragment.this;
                super();
            }
            });
        }
        return v;
    }

    public void a()
    {
        D = true;
        a(0x80000000, x.a, 0, 0);
        D = false;
    }

    public void a(int i1)
    {
        Integer integer;
        integer = null;
        c = i1;
        c;
        JVM INSTR tableswitch 1 3: default 36
    //                   1 137
    //                   2 154
    //                   3 171;
           goto _L1 _L2 _L3 _L4
_L1:
        Integer integer1 = null;
_L6:
        if (integer1 != null)
        {
            if (i != null)
            {
                i.setBackgroundResource(integer1.intValue());
            }
            if (l != null)
            {
                l.setBackgroundResource(integer1.intValue());
            }
            if (m != null)
            {
                m.setBackgroundResource(integer1.intValue());
            }
        }
        if (integer != null)
        {
            if (n != null)
            {
                n.setBackgroundResource(integer.intValue());
            }
            if (o != null)
            {
                o.setBackgroundResource(integer.intValue());
            }
        }
        return;
_L2:
        integer1 = Integer.valueOf(g.launcher_background);
        integer = Integer.valueOf(g.bc_color_transparent);
        continue; /* Loop/switch isn't completed */
_L3:
        integer1 = Integer.valueOf(g.bc_color_white);
        integer = Integer.valueOf(g.bc_color_transparent);
        continue; /* Loop/switch isn't completed */
_L4:
        integer1 = Integer.valueOf(g.bc_color_white);
        integer = Integer.valueOf(g.bc_color_transparent);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void a(int i1, int j1, int k1, int l1)
    {
        boolean flag = false;
        if (!D)
        {
            C = (new int[] {
                i1, j1, k1, l1
            });
        }
        j1 = e(j1);
        k1 = e(k1);
        a(j, i1 & 0x80000000, 4);
        a(k, 0x40000000 & i1, 4);
        a(l, 0x20000000 & i1, 4);
        a(((View) (o)), 0x4000000 & i1, 4);
        a(((View) (p)), 0x100000 & i1, 8);
        a(((View) (q)), 0x2000000 & i1, 4);
        a(((View) (r)), 0x1000000 & i1, 4);
        a(((View) (t)), 0x8000000 & i1, 4);
        n.setVisibility(8);
        a(i1 & 0x80000000, j1);
        o.setVisibility(8);
        if ((i1 & 1) != 0)
        {
            flag = true;
        }
        a(0x4000000 & i1, k1, flag);
        r.setVisibility(8);
        r.setSelected(true);
        c(0x1000000 & i1, l1);
        q.setVisibility(8);
        b(0x2000000 & i1, l1);
        t.setVisibility(8);
        d(0x8000000 & i1, k1);
    }

    public void a(Uri uri)
    {
        if (uri == null)
        {
            return;
        }
        if (g.isEmpty())
        {
            a(new Uri[] {
                uri
            });
            return;
        }
        View view = (View)g.get(B);
        if (view instanceof UICImageView)
        {
            ((UICImageView)view).setImageURI(uri);
            return;
        } else
        {
            UICImageView uicimageview = (UICImageView)e.inflate(k.bc_view_item_topbar_logo, f, false);
            uicimageview.setImageURI(uri);
            f.removeView(view);
            f.addView(uicimageview);
            g.set(B, uicimageview);
            return;
        }
    }

    public void a(z z1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!d.contains(z1))
        {
            d.add(z1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        z1;
        throw z1;
    }

    public void a(String s1)
    {
        if (v != null)
        {
            v.setText(s1);
        }
    }

    public void a(Uri auri[])
    {
        f.removeAllViews();
        g.clear();
        int j1 = auri.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            Uri uri = auri[i1];
            UICImageView uicimageview = (UICImageView)e.inflate(k.bc_view_item_topbar_logo, f, false);
            uicimageview.setImageURI(uri);
            f.addView(uicimageview);
            g.add(uicimageview);
        }

    }

    public void a(String as[])
    {
        int i1;
        f.removeAllViews();
        g.clear();
        i1 = k.bc_view_item_topbar_title;
        if (c != 1) goto _L2; else goto _L1
_L1:
        i1 = k.bc_view_item_topbar_title_black;
_L4:
        int k1 = as.length;
        for (int j1 = 0; j1 < k1; j1++)
        {
            String s1 = as[j1];
            EmojiconTextView emojicontextview = (EmojiconTextView)e.inflate(i1, f, false);
            emojicontextview.setText(s1);
            f.addView(emojicontextview);
            g.add(emojicontextview);
        }

        break; /* Loop/switch isn't completed */
_L2:
        if (c == 2)
        {
            i1 = k.bc_view_item_topbar_title_white;
        } else
        if (c == 3)
        {
            i1 = k.bc_view_item_topbar_title_red_violet;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public TextView b()
    {
        return r;
    }

    public void b(int i1)
    {
        if (p != null && i1 != 0)
        {
            p.setImageResource(i1);
        }
    }

    public void b(z z1)
    {
        this;
        JVM INSTR monitorenter ;
        if (d.contains(z1))
        {
            d.remove(z1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        z1;
        throw z1;
    }

    public void b(String s1)
    {
        if (s1 == null)
        {
            s.setVisibility(8);
            return;
        } else
        {
            s.setText(s1);
            s.setVisibility(0);
            return;
        }
    }

    public void b(boolean flag)
    {
        if (y != null)
        {
            View view = y;
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
    }

    public void c(int i1)
    {
        if (r != null)
        {
            r.setText(i1);
        }
    }

    public void c(String s1)
    {
        if (s1 != null)
        {
            if (g.isEmpty())
            {
                a(new String[] {
                    s1
                });
                return;
            }
            View view = (View)g.get(B);
            if (view instanceof TextView)
            {
                ((TextView)view).setText(s1);
                return;
            }
        }
    }

    public void c(boolean flag)
    {
        if (w != null)
        {
            View view = w;
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            view.setVisibility(i1);
        }
    }

    public void d(int i1)
    {
        if (r != null)
        {
            r.setBackgroundResource(i1);
        }
    }

    public void d(boolean flag)
    {
        if (flag)
        {
            a();
        } else
        if (C != null)
        {
            a(C[0], C[1], C[2], C[3]);
            return;
        }
    }

    public void e(boolean flag)
    {
        if (s != null)
        {
            s.setSelected(flag);
        }
    }

    public void f(boolean flag)
    {
        if (r != null)
        {
            r.setSelected(flag);
        }
    }

    public void g(boolean flag)
    {
        if (r != null)
        {
            r.setEnabled(flag);
        }
    }

    public void h(boolean flag)
    {
        if (!g.isEmpty())
        {
            View view = (View)g.get(B);
            if (view != null)
            {
                if (h != null)
                {
                    h.cancel();
                }
                if (flag)
                {
                    h = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
                } else
                {
                    h = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
                }
                h.setDuration(75L);
                h.setFillAfter(true);
                view.startAnimation(h);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        e = layoutinflater;
        layoutinflater = layoutinflater.inflate(k.bc_fragment_topbar, viewgroup, false);
        i = layoutinflater.findViewById(j.top_bar_background);
        f = (RelativeLayout)layoutinflater.findViewById(j.top_bar_title_layout);
        f.setOnClickListener(new android.view.View.OnClickListener() {

            final TopBarFragment a;

            public void onClick(View view)
            {
                long l1 = System.currentTimeMillis();
                if (l1 - TopBarFragment.a(a) > TopBarFragment.c())
                {
                    TopBarFragment.a(a, 1);
                } else
                {
                    TopBarFragment.b(a);
                }
                TopBarFragment.a(a, l1);
                if (TopBarFragment.c(a) >= TopBarFragment.d())
                {
                    TopBarFragment.a(a, 0);
                    TopBarFragment.d(a);
                }
            }

            
            {
                a = TopBarFragment.this;
                super();
            }
        });
        v = (EditText)layoutinflater.findViewById(j.top_bar_title_edit);
        u = layoutinflater.findViewById(j.top_bar_edit_panel);
        x = layoutinflater.findViewById(j.top_bar_title_edit_left_padding);
        w = layoutinflater.findViewById(j.top_bar_title_edit_icon);
        w.setOnClickListener(new android.view.View.OnClickListener() {

            final TopBarFragment a;

            public void onClick(View view)
            {
                for (view = com.cyberlink.beautycircle.controller.fragment.TopBarFragment.e(a).iterator(); view.hasNext(); ((z)view.next()).h()) { }
            }

            
            {
                a = TopBarFragment.this;
                super();
            }
        });
        y = layoutinflater.findViewById(j.top_bar_title_edit_clean);
        y.setOnClickListener(new android.view.View.OnClickListener() {

            final TopBarFragment a;

            public void onClick(View view)
            {
                for (view = com.cyberlink.beautycircle.controller.fragment.TopBarFragment.e(a).iterator(); view.hasNext(); ((z)view.next()).g()) { }
            }

            
            {
                a = TopBarFragment.this;
                super();
            }
        });
        j = layoutinflater.findViewById(j.top_bar_left_panel);
        k = layoutinflater.findViewById(j.top_bar_right_panel);
        l = layoutinflater.findViewById(j.right_seperater);
        m = layoutinflater.findViewById(j.left_seperater);
        n = (ImageView)layoutinflater.findViewById(j.top_bar_btn_back);
        if (n != null)
        {
            n.setOnClickListener(E);
        }
        o = (ImageView)layoutinflater.findViewById(j.top_bar_right_icon);
        if (o != null)
        {
            o.setOnClickListener(F);
        }
        p = (ImageView)layoutinflater.findViewById(j.top_bar_right_icon_sub);
        if (p != null)
        {
            p.setOnClickListener(G);
        }
        r = (TextView)layoutinflater.findViewById(j.top_bar_right_text_btn);
        if (r != null)
        {
            r.setOnClickListener(F);
        }
        q = (TextView)layoutinflater.findViewById(j.top_bar_right_text);
        if (q != null)
        {
            q.setOnClickListener(F);
        }
        s = (TextView)layoutinflater.findViewById(j.top_bar_right_text_desc);
        t = (ImageView)layoutinflater.findViewById(j.top_bar_right_share_in_icon);
        if (t != null)
        {
            t.setOnClickListener(F);
        }
        return layoutinflater;
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        view.post(new Runnable() {

            final TopBarFragment a;

            public void run()
            {
                TopBarFragment.f(a);
            }

            
            {
                a = TopBarFragment.this;
                super();
            }
        });
    }

}
