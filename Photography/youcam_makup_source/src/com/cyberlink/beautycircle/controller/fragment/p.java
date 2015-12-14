// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.WrapperListAdapter;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.controller.a.ak;
import com.cyberlink.beautycircle.controller.a.ap;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.s;
import com.cyberlink.beautycircle.controller.activity.MainActivity;
import com.cyberlink.beautycircle.controller.activity.MeActivity;
import com.cyberlink.beautycircle.controller.activity.UserProfileActivity;
import com.cyberlink.beautycircle.controller.adapter.c;
import com.cyberlink.beautycircle.controller.adapter.i;
import com.cyberlink.beautycircle.controller.adapter.n;
import com.cyberlink.beautycircle.controller.adapter.v;
import com.cyberlink.beautycircle.controller.adapter.w;
import com.cyberlink.beautycircle.controller.adapter.x;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.l;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.MeADPager;
import com.cyberlink.beautycircle.model.MeTabItem;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.q;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.u;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.cyberlink.beautycircle.view.widgetpool.common.MeTabScrollView;
import com.cyberlink.beautycircle.view.widgetpool.common.ObservableScrollView;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.PLA_ListView;
import com.huewu.pla.lib.internal.d;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.h;
import com.perfectcorp.utility.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            e, q, x, TopBarFragment, 
//            y, BottomBarFragment, b, h

public class p extends com.cyberlink.beautycircle.controller.fragment.e
{

    private static int aN = 2;
    private v A;
    private w B;
    private i C;
    private com.cyberlink.beautycircle.controller.adapter.p D;
    private boolean E;
    private boolean F;
    private View G;
    private View H;
    private TextView I;
    private View J;
    private TextView K;
    private long L;
    private String M;
    private boolean N;
    private String O;
    private final Object P = new Object();
    private UserInfo Q;
    private boolean R;
    private MeTabScrollView S;
    private View T;
    private View U;
    private com.cyberlink.beautycircle.model.MeTabItem.MeListMode V;
    private com.cyberlink.beautycircle.model.MeTabItem.MeListMode W;
    private ViewPager X;
    private LinearLayout Y;
    private TreeMap Z;
    private Runnable aA;
    private UserInfo aB;
    private n aC;
    private n aD;
    private n aE;
    private q aF;
    private n aG;
    private n aH;
    private q aI;
    private n aJ;
    private PagerAdapter aK;
    private com.cyberlink.beautycircle.controller.fragment.b aL;
    private android.view.View.OnLayoutChangeListener aM;
    private ArrayList aa;
    private Uri ab;
    private int ac;
    private boolean ad;
    private AnimatorSet ae;
    private View af;
    private android.view.View.OnClickListener ag;
    private android.view.View.OnClickListener ah;
    private com.cyberlink.beautycircle.utility.a ai;
    private u aj;
    private u ak;
    private u al;
    private u am;
    private u an;
    private android.view.View.OnClickListener ao;
    private android.view.View.OnClickListener ap;
    private android.view.View.OnClickListener aq;
    private android.view.View.OnClickListener ar;
    private android.view.View.OnClickListener as;
    private android.view.View.OnClickListener at;
    private android.view.View.OnClickListener au;
    private android.view.View.OnClickListener av;
    private int aw;
    private android.view.View.OnClickListener ax;
    private android.support.v4.view.ViewPager.OnPageChangeListener ay;
    private android.view.View.OnTouchListener az;
    public boolean s;
    protected android.view.View.OnLongClickListener t;
    private boolean x;
    private c y;
    private x z;

    public p()
    {
        x = false;
        E = false;
        F = false;
        L = -1L;
        M = null;
        N = true;
        O = null;
        R = true;
        T = null;
        U = null;
        Z = new TreeMap();
        aa = new ArrayList();
        ab = null;
        ac = 0;
        ad = false;
        s = false;
        ae = null;
        af = null;
        ag = new android.view.View.OnClickListener() {

            final p a;

            public void onClick(View view)
            {
                view = ((com.cyberlink.beautycircle.view.widgetpool.common.j)view).getItem();
                com.cyberlink.beautycircle.controller.fragment.p.a(a, ((MeTabItem) (view)).listMode);
                com.cyberlink.beautycircle.controller.fragment.p.b(a, ((MeTabItem) (view)).listMode);
                view = ObjectAnimator.ofFloat(a.i, "translationY", new float[] {
                    0.0F
                });
                ObjectAnimator objectanimator = ObjectAnimator.ofFloat(com.cyberlink.beautycircle.controller.fragment.p.b(a), "translationY", new float[] {
                    0.0F
                });
                com.cyberlink.beautycircle.controller.fragment.p.a(a, (new AnimatorSet()).setDuration(300L));
                com.cyberlink.beautycircle.controller.fragment.p.c(a).playTogether(new Animator[] {
                    view, objectanimator
                });
                com.cyberlink.beautycircle.controller.fragment.p.c(a).start();
            }

            
            {
                a = p.this;
                super();
            }
        };
        ah = new android.view.View.OnClickListener() {

            final p a;

            public void onClick(View view)
            {
                android.support.v4.app.FragmentActivity fragmentactivity = a.getActivity();
                view = new PopupMenu(fragmentactivity, view);
                Menu menu = view.getMenu();
                menu.add(m.bc_post_comment_menu_report).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this, fragmentactivity) {

                    final Activity a;
                    final _cls23 b;

                    public boolean onMenuItemClick(MenuItem menuitem)
                    {
                        aq.c = "report_user";
                        AccountManager.a(a, new com.cyberlink.beautycircle.utility.b(this) {

                            final _cls1 a;

                            public void a()
                            {
                                Globals.b("Get AccountToken Fail");
                            }

                            public void a(String s1)
                            {
                                if (a.a != null)
                                {
                                    com.cyberlink.beautycircle.c.a(a.a, com.cyberlink.beautycircle.controller.fragment.p.a(a.b.a), com.cyberlink.beautycircle.controller.fragment.p.d(a.b.a));
                                }
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
                        return true;
                    }

            
            {
                b = _pcls23;
                a = activity;
                super();
            }
                });
                int i1 = m.bc_post_more_menu_block;
                if (com.cyberlink.beautycircle.controller.fragment.p.e(a).isBlocked.booleanValue())
                {
                    i1 = m.bc_post_more_menu_unblock;
                }
                menu.add(i1).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this, fragmentactivity) {

                    final Activity a;
                    final _cls23 b;

                    public boolean onMenuItemClick(MenuItem menuitem)
                    {
                        aq.c = "block_user";
                        AccountManager.a(a, new com.cyberlink.beautycircle.utility.b(this) {

                            final _cls2 a;

                            public void a()
                            {
                                Globals.b("Get AccountToken Fail");
                            }

                            public void a(String s1)
                            {
                                if (s1 == null)
                                {
                                    return;
                                }
                                int i1 = m.bc_post_more_menu_block_msg;
                                int j1 = m.bc_post_more_menu_block_btn;
                                if (com.cyberlink.beautycircle.controller.fragment.p.e(a.b.a).isBlocked.booleanValue())
                                {
                                    i1 = m.bc_post_more_menu_unblock_msg;
                                    j1 = m.bc_post_more_menu_unblock_btn;
                                }
                                DialogUtils.a(a.a, null, a.b.a.getResources().getString(i1), a.b.a.getResources().getString(m.bc_dialog_button_cancel), null, a.b.a.getResources().getString(j1), new Runnable(this, s1) {

                                    final String a;
                                    final _cls1 b;

                                    public void run()
                                    {
                                        if (com.cyberlink.beautycircle.controller.fragment.p.e(b.a.b.a).isBlocked.booleanValue())
                                        {
                                            NetworkUser.b(a, Long.valueOf(com.cyberlink.beautycircle.controller.fragment.p.a(b.a.b.a))).a(new com.perfectcorp.utility.m(this) {

                                                final _cls1 a;

                                                public void a()
                                                {
                                                    a(0x80000005);
                                                }

                                                public void a(int i1)
                                                {
                                                }

                                                public void a(Void void1)
                                                {
                                                    void1 = com.cyberlink.beautycircle.controller.fragment.p.e(a.b.a.b.a);
                                                    boolean flag;
                                                    if (!com.cyberlink.beautycircle.controller.fragment.p.e(a.b.a.b.a).isBlocked.booleanValue())
                                                    {
                                                        flag = true;
                                                    } else
                                                    {
                                                        flag = false;
                                                    }
                                                    void1.isBlocked = Boolean.valueOf(flag);
                                                    void1 = a.b.a.b.a.getResources().getString(m.bc_post_more_menu_unblock_toast);
                                                    com.perfectcorp.utility.e.a(a.b.a.b.a.getActivity(), void1);
                                                }

                                                public void b(Object obj)
                                                {
                                                    a((Void)obj);
                                                }

            
            {
                a = _pcls1;
                super();
            }
                                            });
                                            return;
                                        } else
                                        {
                                            NetworkUser.a(a, Long.valueOf(com.cyberlink.beautycircle.controller.fragment.p.a(b.a.b.a))).a(new com.perfectcorp.utility.m(this) {

                                                final _cls1 a;

                                                public void a()
                                                {
                                                    a(0x80000005);
                                                }

                                                public void a(int i1)
                                                {
                                                }

                                                public void a(Void void1)
                                                {
                                                    void1 = com.cyberlink.beautycircle.controller.fragment.p.e(a.b.a.b.a);
                                                    boolean flag;
                                                    if (!com.cyberlink.beautycircle.controller.fragment.p.e(a.b.a.b.a).isBlocked.booleanValue())
                                                    {
                                                        flag = true;
                                                    } else
                                                    {
                                                        flag = false;
                                                    }
                                                    void1.isBlocked = Boolean.valueOf(flag);
                                                    void1 = a.b.a.b.a.getResources().getString(m.bc_post_more_menu_block_toast);
                                                    com.perfectcorp.utility.e.a(a.b.a.b.a.getActivity(), void1);
                                                }

                                                public void b(Object obj)
                                                {
                                                    a((Void)obj);
                                                }

            
            {
                a = _pcls1;
                super();
            }
                                            });
                                            return;
                                        }
                                    }

            
            {
                b = _pcls1;
                a = s1;
                super();
            }
                                });
                            }

                            public void b()
                            {
                                Globals.b("Get AccountToken Cancel");
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                        return true;
                    }

            
            {
                b = _pcls23;
                a = activity;
                super();
            }
                });
                view.show();
            }

            
            {
                a = p.this;
                super();
            }
        };
        ai = new com.cyberlink.beautycircle.utility.a() {

            final p a;

            public void a(UserInfo userinfo)
            {
                com.perfectcorp.utility.e.b(new Object[0]);
                userinfo = AccountManager.b();
                if (p.f(a) || userinfo == null || userinfo.isEmpty()) goto _L2; else goto _L1
_L1:
                a.d(false);
_L4:
                if (a.a && a.isResumed())
                {
                    p.g(a);
                }
                return;
_L2:
                if (userinfo == null || userinfo.isEmpty())
                {
                    a.d(true);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = p.this;
                super();
            }
        };
        aj = new u() {

            final p a;

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "OnCircleChange"
                });
                if (com.cyberlink.beautycircle.controller.fragment.p.h(a))
                {
                    com.cyberlink.beautycircle.controller.fragment.p.a(a, true);
                    if (com.cyberlink.beautycircle.controller.fragment.p.i(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.fragment.p.i(a).g = true;
                    }
                    if (com.cyberlink.beautycircle.controller.fragment.p.j(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.fragment.p.j(a).g = true;
                    }
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        ak = new u() {

            final p a;

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "OnPostChange"
                });
                if (com.cyberlink.beautycircle.controller.fragment.p.h(a))
                {
                    com.cyberlink.beautycircle.controller.fragment.p.a(a, true);
                    if (com.cyberlink.beautycircle.controller.fragment.p.i(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.fragment.p.i(a).g = true;
                    }
                    if (com.cyberlink.beautycircle.controller.fragment.p.j(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.fragment.p.j(a).g = true;
                    }
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        al = new u() {

            final p a;

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "OnFollowChange, mUserId=", Long.valueOf(com.cyberlink.beautycircle.controller.fragment.p.a(a))
                });
                com.cyberlink.beautycircle.controller.fragment.p.a(a, true);
                if (com.cyberlink.beautycircle.controller.fragment.p.k(a) != null)
                {
                    com.cyberlink.beautycircle.controller.fragment.p.k(a).g = true;
                }
                if (com.cyberlink.beautycircle.controller.fragment.p.l(a) != null)
                {
                    com.cyberlink.beautycircle.controller.fragment.p.l(a).a = true;
                }
                if (!com.cyberlink.beautycircle.controller.fragment.p.h(a) && com.cyberlink.beautycircle.controller.fragment.p.j(a) != null)
                {
                    com.cyberlink.beautycircle.controller.fragment.p.j(a).g = true;
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        am = new u() {

            final p a;

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    "OnLikeChange, mUserId=", Long.valueOf(com.cyberlink.beautycircle.controller.fragment.p.a(a))
                });
                if (com.cyberlink.beautycircle.controller.fragment.p.h(a))
                {
                    com.cyberlink.beautycircle.controller.fragment.p.a(a, true);
                    if (com.cyberlink.beautycircle.controller.fragment.p.m(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.fragment.p.m(a).g = true;
                    }
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        an = new u() {

            final p a;

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    ""
                });
                if (com.cyberlink.beautycircle.controller.fragment.p.n(a) != null)
                {
                    com.cyberlink.beautycircle.controller.fragment.p.n(a).g = true;
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        ao = new android.view.View.OnClickListener() {

            final p a;

            public void onClick(View view)
            {
                a.k();
            }

            
            {
                a = p.this;
                super();
            }
        };
        ap = new android.view.View.OnClickListener() {

            final p a;

            public void onClick(View view)
            {
                a.l();
            }

            
            {
                a = p.this;
                super();
            }
        };
        aq = new android.view.View.OnClickListener() {

            final p a;

            public void onClick(View view)
            {
                view = a.getActivity();
                if (view == null)
                {
                    return;
                } else
                {
                    com.cyberlink.beautycircle.controller.fragment.p.a(a, com.perfectcorp.utility.h.a(view));
                    DialogUtils.a(view, 48133, 48134, p.p(a));
                    return;
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        ar = new android.view.View.OnClickListener() {

            final p a;

            public void onClick(View view)
            {
                view = a.getActivity();
                if (view == null)
                {
                    return;
                } else
                {
                    view.startActivityForResult(new Intent(view, com/cyberlink/beautycircle/controller/activity/UserProfileActivity), 48136);
                    return;
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        as = new android.view.View.OnClickListener() {

            final p a;

            public void onClick(View view)
            {
                Object obj = a.getActivity();
                if (obj == null)
                {
                    return;
                } else
                {
                    view = new PopupMenu(((android.content.Context) (obj)), view);
                    obj = view.getMenu();
                    ((Menu) (obj)).add(m.bc_me_create_circle).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this) {

                        final _cls8 a;

                        public boolean onMenuItemClick(MenuItem menuitem)
                        {
                            a.a.l();
                            return true;
                        }

            
            {
                a = _pcls8;
                super();
            }
                    });
                    ((Menu) (obj)).add(m.bc_me_create_post).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(this) {

                        final _cls8 a;

                        public boolean onMenuItemClick(MenuItem menuitem)
                        {
                            a.a.k();
                            return true;
                        }

            
            {
                a = _pcls8;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        at = new android.view.View.OnClickListener() {

            final p a;

            public void onClick(View view)
            {
                view = a.getActivity();
                if (view == null)
                {
                    return;
                } else
                {
                    com.cyberlink.beautycircle.c.a(view, 3);
                    return;
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        au = new android.view.View.OnClickListener() {

            final p a;

            public void onClick(View view)
            {
                view = a.getActivity();
                if (view == null)
                {
                    return;
                } else
                {
                    com.cyberlink.beautycircle.controller.fragment.p.a(a, com.perfectcorp.utility.h.a(view));
                    DialogUtils.a(view, 48130, 48131, p.p(a));
                    return;
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        av = new android.view.View.OnClickListener() {

            final p a;

            public void onClick(View view)
            {
                view = a.getActivity();
                if (view == null)
                {
                    return;
                } else
                {
                    com.cyberlink.beautycircle.c.a(view, com.cyberlink.beautycircle.controller.fragment.p.e(a).avatarUrl, com.cyberlink.beautycircle.controller.fragment.p.e(a).displayName, com.cyberlink.beautycircle.controller.fragment.p.e(a).description, com.cyberlink.beautycircle.controller.fragment.p.h(a), com.cyberlink.beautycircle.controller.fragment.p.e(a).websiteUrl, Long.valueOf(com.cyberlink.beautycircle.controller.fragment.p.e(a).id));
                    return;
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        aw = 0;
        t = new android.view.View.OnLongClickListener() {

            final p a;

            public boolean onLongClick(View view)
            {
                if (com.cyberlink.beautycircle.controller.fragment.p.q(a) == 3)
                {
                    view = a.getActivity();
                    if (view instanceof MainActivity)
                    {
                        ((BaseActivity)view).a(view.getString(m.bc_poweruser_text), 5000);
                        Globals.h();
                    }
                }
                return false;
            }

            
            {
                a = p.this;
                super();
            }
        };
        ax = new android.view.View.OnClickListener() {

            final p a;

            public void onClick(View view)
            {
                view = (MeADPager)view.getTag();
                if (view != null)
                {
                    if (((MeADPager) (view)).redirectUrl != null && !((MeADPager) (view)).redirectUrl.toString().isEmpty())
                    {
                        com.cyberlink.beautycircle.c.a(a.getActivity(), ((MeADPager) (view)).eventLink.toString(), 2);
                        return;
                    }
                    if (((MeADPager) (view)).id != null)
                    {
                        Object obj = a.getActivity();
                        if (obj != null)
                        {
                            String s1 = ((Activity) (obj)).getString(m.bc_appscheme);
                            obj = ((Activity) (obj)).getString(m.bc_host_free_sample);
                            view = (new StringBuilder()).append(s1).append("://").append(((String) (obj))).append("/").append(((MeADPager) (view)).id).toString();
                            try
                            {
                                view = Uri.parse(view);
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                return;
                            }
                            com.cyberlink.beautycircle.c.a(a.getActivity(), view);
                            return;
                        }
                    }
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        ay = new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final p a;

            public void onPageScrollStateChanged(int i1)
            {
                if (i1 == 0 && com.cyberlink.beautycircle.controller.fragment.p.t(a) == 0 && com.cyberlink.beautycircle.controller.fragment.p.u(a))
                {
                    com.cyberlink.beautycircle.controller.fragment.p.v(a);
                }
            }

            public void onPageScrolled(int i1, float f1, int j1)
            {
            }

            public void onPageSelected(int i1)
            {
                if (i1 < p.r(a).getChildCount())
                {
                    Object obj = (Integer)p.r(a).getTag();
                    if (obj != null)
                    {
                        if (((Integer) (obj)).intValue() == i1)
                        {
                            return;
                        }
                        obj = (ImageView)p.r(a).getChildAt(((Integer) (obj)).intValue());
                        if (obj != null)
                        {
                            ((ImageView) (obj)).setImageResource(com.cyberlink.beautycircle.i.bc_dot_g);
                        }
                    }
                    obj = (ImageView)p.r(a).getChildAt(i1);
                    if (obj != null)
                    {
                        ((ImageView) (obj)).setImageResource(com.cyberlink.beautycircle.i.bc_dot_n);
                    }
                    p.r(a).setTag(Integer.valueOf(i1));
                }
                com.cyberlink.beautycircle.controller.fragment.p.a(a, i1);
                com.cyberlink.beautycircle.controller.fragment.p.s(a);
            }

            
            {
                a = p.this;
                super();
            }
        };
        az = new android.view.View.OnTouchListener() {

            final p a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1 || motionevent.getAction() == 3)
                {
                    com.cyberlink.beautycircle.controller.fragment.p.s(a);
                } else
                {
                    com.cyberlink.beautycircle.controller.fragment.p.w(a);
                }
                return false;
            }

            
            {
                a = p.this;
                super();
            }
        };
        aA = new Runnable() {

            final p a;

            public void run()
            {
                if (com.cyberlink.beautycircle.controller.fragment.p.x(a) != null)
                {
                    p.y(a);
                    com.cyberlink.beautycircle.controller.fragment.p.b(a, p.z(a).size());
                    com.cyberlink.beautycircle.controller.fragment.p.x(a).setCurrentItem(com.cyberlink.beautycircle.controller.fragment.p.t(a), true);
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        aB = null;
        aC = new com.cyberlink.beautycircle.controller.fragment.h() {

            final p b;

            public void a(int i1)
            {
                if (p.D(b) != null)
                {
                    p.D(b).post(new Runnable(this, i1) {

                        final int a;
                        final _cls20 b;

                        public void run()
                        {
                            b.b.c(a);
                        }

            
            {
                b = _pcls20;
                a = i1;
                super();
            }
                    });
                }
            }

            public void a(boolean flag)
            {
            }

            
            {
                b = p.this;
                super(p.this);
            }
        };
        aD = new com.cyberlink.beautycircle.controller.fragment.h() {

            final p b;

            public void a(int i1)
            {
                if (p.D(b) != null)
                {
                    p.D(b).post(new Runnable(this, i1) {

                        final int a;
                        final _cls21 b;

                        public void run()
                        {
                            com.cyberlink.beautycircle.controller.fragment.p.d(b.b, a);
                        }

            
            {
                b = _pcls21;
                a = i1;
                super();
            }
                    });
                }
            }

            public void a(boolean flag)
            {
            }

            
            {
                b = p.this;
                super(p.this);
            }
        };
        aE = new com.cyberlink.beautycircle.controller.fragment.h() {

            final p b;

            public void a(int i1)
            {
                if (p.D(b) != null)
                {
                    p.D(b).post(new Runnable(this, i1) {

                        final int a;
                        final _cls22 b;

                        public void run()
                        {
                            com.cyberlink.beautycircle.controller.fragment.p.e(b.b, a);
                        }

            
            {
                b = _pcls22;
                a = i1;
                super();
            }
                    });
                }
            }

            public void a(boolean flag)
            {
            }

            
            {
                b = p.this;
                super(p.this);
            }
        };
        aF = new q() {

            final p a;

            public void a()
            {
            }

            public void a(UserInfo userinfo, boolean flag)
            {
                if (com.cyberlink.beautycircle.controller.fragment.p.h(a))
                {
                    int j1 = com.cyberlink.beautycircle.controller.fragment.p.a(a, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.f, 0);
                    int i1;
                    if (flag)
                    {
                        i1 = 1;
                    } else
                    {
                        i1 = -1;
                    }
                    i1 += j1;
                    p.f(a, i1);
                    AccountManager.a(null, Integer.valueOf(i1));
                    if (com.cyberlink.beautycircle.controller.fragment.p.e(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.fragment.p.e(a).followingCount = Integer.valueOf(i1);
                    }
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        aG = a(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.a);
        aH = a(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.b);
        aI = new q() {

            final p a;

            public void a()
            {
                com.cyberlink.beautycircle.controller.fragment.p.e(a, true);
            }

            public void a(UserInfo userinfo, boolean flag)
            {
                if (!com.cyberlink.beautycircle.controller.fragment.p.h(a))
                {
                    int j1 = com.cyberlink.beautycircle.controller.fragment.p.a(a, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.e, 0);
                    int i1;
                    if (flag)
                    {
                        i1 = 1;
                    } else
                    {
                        i1 = -1;
                    }
                    p.g(a, i1 + j1);
                    if (p.H(a) == com.cyberlink.beautycircle.model.MeTabItem.MeListMode.e)
                    {
                        if (!com.cyberlink.beautycircle.controller.fragment.p.k(a).a(AccountManager.c().longValue(), flag))
                        {
                            com.cyberlink.beautycircle.controller.fragment.p.k(a).c();
                        }
                    } else
                    if (p.H(a) == com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b && com.cyberlink.beautycircle.controller.fragment.p.j(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.fragment.p.j(a).c();
                        return;
                    }
                }
            }

            
            {
                a = p.this;
                super();
            }
        };
        aJ = new com.cyberlink.beautycircle.controller.fragment.h() {

            final p b;

            public void a(int i1)
            {
                if (p.D(b) != null)
                {
                    p.D(b).post(new Runnable(this, i1) {

                        final int a;
                        final _cls27 b;

                        public void run()
                        {
                            com.cyberlink.beautycircle.controller.fragment.p.e(b.b).productFeatureCount = Integer.valueOf(a);
                            com.cyberlink.beautycircle.controller.fragment.p.c(b.b, a);
                            com.cyberlink.beautycircle.controller.fragment.p.j(b.b, a);
                        }

            
            {
                b = _pcls27;
                a = i1;
                super();
            }
                    });
                }
            }

            public void a(boolean flag)
            {
                if (p.G(b) == null)
                {
                    return;
                } else
                {
                    p.G(b).post(new Runnable(this, flag) {

                        final boolean a;
                        final _cls27 b;

                        public void run()
                        {
                            p p1 = b.b;
                            int i1;
                            if (a)
                            {
                                i1 = 0;
                            } else
                            {
                                i1 = 1;
                            }
                            com.cyberlink.beautycircle.controller.fragment.p.j(p1, i1);
                        }

            
            {
                b = _pcls27;
                a = flag;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                b = p.this;
                super(p.this);
            }
        };
        aK = new PagerAdapter() {

            final p a;

            public void destroyItem(ViewGroup viewgroup, int i1, Object obj)
            {
                if (obj != null)
                {
                    viewgroup.removeView(((com.cyberlink.beautycircle.controller.fragment.q)obj).a());
                    if (p.o(a).containsKey(Integer.valueOf(i1)))
                    {
                        p.o(a).remove(Integer.valueOf(i1));
                    }
                }
            }

            public int getCount()
            {
                return p.z(a).size();
            }

            public int getItemPosition(Object obj)
            {
                if (p.o(a).size() <= 0) goto _L2; else goto _L1
_L1:
                Iterator iterator = p.o(a).entrySet().iterator();
_L6:
                if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (entry.getValue() != obj) goto _L6; else goto _L5
_L5:
                obj = (Integer)entry.getKey();
_L8:
                if (obj != null)
                {
                    return ((Integer) (obj)).intValue();
                } else
                {
                    return -2;
                }
_L2:
                return -2;
_L4:
                obj = null;
                if (true) goto _L8; else goto _L7
_L7:
            }

            public Object instantiateItem(ViewGroup viewgroup, int i1)
            {
                Object obj1 = null;
                android.support.v4.app.FragmentActivity fragmentactivity = a.getActivity();
                Object obj = obj1;
                if (fragmentactivity != null)
                {
                    obj = obj1;
                    if (i1 < p.z(a).size())
                    {
                        com.cyberlink.beautycircle.controller.fragment.q q1 = (com.cyberlink.beautycircle.controller.fragment.q)p.o(a).get(Integer.valueOf(i1));
                        obj = q1;
                        if (q1 == null)
                        {
                            obj = (MeADPager)p.z(a).get(i1);
                            obj = new com.cyberlink.beautycircle.controller.fragment.q(a, fragmentactivity, viewgroup, ((MeADPager) (obj)));
                            p.o(a).put(Integer.valueOf(i1), obj);
                        }
                        ((com.cyberlink.beautycircle.controller.fragment.q) (obj)).a(com.cyberlink.beautycircle.controller.fragment.p.e(a), com.cyberlink.beautycircle.controller.fragment.p.h(a), p.f(a));
                    }
                }
                return obj;
            }

            public boolean isViewFromObject(View view, Object obj)
            {
                return view.getTag().equals(Integer.valueOf(((com.cyberlink.beautycircle.controller.fragment.q)obj).hashCode()));
            }

            
            {
                a = p.this;
                super();
            }
        };
        aL = new com.cyberlink.beautycircle.controller.fragment.b() {

            final p a;

            public void a(ObservableScrollView observablescrollview, int i1)
            {
                if (i1 != 0) goto _L2; else goto _L1
_L1:
                observablescrollview = (Boolean)a.k.getTag(com.cyberlink.beautycircle.j.to_top_btn);
                if (observablescrollview == null || !observablescrollview.booleanValue()) goto _L2; else goto _L3
_L3:
                boolean flag;
                a.k.setTag(com.cyberlink.beautycircle.j.to_top_btn, null);
                flag = true;
_L5:
                com.cyberlink.beautycircle.controller.fragment.p.a(a, 0, flag);
                return;
_L2:
                flag = false;
                if (true) goto _L5; else goto _L4
_L4:
            }

            public void a(ObservableScrollView observablescrollview, int i1, int j1, int k1, int l1)
            {
                com.cyberlink.beautycircle.controller.fragment.p.a(a, j1 - l1, false);
            }

            public void a(PLA_AbsListView pla_abslistview, int i1)
            {
                super.a(pla_abslistview, i1);
                a.q.a(null, i1);
            }

            public void a(PLA_AbsListView pla_abslistview, int i1, int j1, int k1)
            {
                super.a(pla_abslistview, i1, j1, k1);
                a.q.a(pla_abslistview, i1, j1, k1);
            }

            
            {
                a = p.this;
                super();
            }
        };
        aM = new android.view.View.OnLayoutChangeListener() {

            final p a;
            private int b;

            public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                    int k2, int l2)
            {
                i1 = a.i.getHeight() + com.cyberlink.beautycircle.controller.fragment.p.b(a).getHeight();
                if (i1 == b)
                {
                    return;
                } else
                {
                    b = i1;
                    view = p.P(a).getLayoutParams();
                    view.height = i1;
                    p.P(a).setLayoutParams(view);
                    return;
                }
            }

            
            {
                a = p.this;
                super();
                b = 0;
            }
        };
    }

    static Object A(p p1)
    {
        return p1.P;
    }

    static UserInfo B(p p1)
    {
        return p1.aB;
    }

    static boolean C(p p1)
    {
        return p1.E;
    }

    static MeTabScrollView D(p p1)
    {
        return p1.S;
    }

    static void E(p p1)
    {
        p1.u();
    }

    static boolean F(p p1)
    {
        return p1.ad;
    }

    static TextView G(p p1)
    {
        return p1.I;
    }

    static com.cyberlink.beautycircle.model.MeTabItem.MeListMode H(p p1)
    {
        return p1.V;
    }

    static boolean I(p p1)
    {
        return p1.R;
    }

    static Uri J(p p1)
    {
        return p1.ab;
    }

    static android.view.View.OnClickListener K(p p1)
    {
        return p1.ax;
    }

    static android.view.View.OnClickListener L(p p1)
    {
        return p1.at;
    }

    static android.view.View.OnClickListener M(p p1)
    {
        return p1.av;
    }

    static android.view.View.OnClickListener N(p p1)
    {
        return p1.aq;
    }

    static android.view.View.OnClickListener O(p p1)
    {
        return p1.au;
    }

    static View P(p p1)
    {
        return p1.T;
    }

    static int a(p p1, int i1)
    {
        p1.ac = i1;
        return i1;
    }

    static int a(p p1, com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode, int i1)
    {
        return p1.a(melistmode, i1);
    }

    private int a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode, int i1)
    {
        int j1 = i1;
        if (S != null)
        {
            j1 = S.b(melistmode, i1);
        }
        return j1;
    }

    static long a(p p1)
    {
        return p1.L;
    }

    static AnimatorSet a(p p1, AnimatorSet animatorset)
    {
        p1.ae = animatorset;
        return animatorset;
    }

    static Uri a(p p1, Uri uri)
    {
        p1.ab = uri;
        return uri;
    }

    static c a(p p1, c c1)
    {
        p1.y = c1;
        return c1;
    }

    static i a(p p1, i i1)
    {
        p1.C = i1;
        return i1;
    }

    private n a(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType userlisttype)
    {
        return new com.cyberlink.beautycircle.controller.fragment.h(userlisttype) {

            final com.cyberlink.beautycircle.model.network.NetworkUser.UserListType b;
            final p c;

            public void a(int i1)
            {
                if (b.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.a))
                {
                    if (p.D(c) != null)
                    {
                        p.D(c).post(new Runnable(this, i1) {

                            final int a;
                            final _cls24 b;

                            public void run()
                            {
                                p.g(b.c, a);
                            }

            
            {
                b = _pcls24;
                a = i1;
                super();
            }
                        });
                    }
                    if (com.cyberlink.beautycircle.controller.fragment.p.e(c) != null)
                    {
                        com.cyberlink.beautycircle.controller.fragment.p.e(c).followerCount = Integer.valueOf(i1);
                    }
                    if (com.cyberlink.beautycircle.controller.fragment.p.h(c))
                    {
                        AccountManager.a(Integer.valueOf(i1), null);
                    }
                } else
                if (b.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.b))
                {
                    if (p.D(c) != null)
                    {
                        p.D(c).post(new Runnable(this, i1) {

                            final int a;
                            final _cls24 b;

                            public void run()
                            {
                                p.f(b.c, a);
                            }

            
            {
                b = _pcls24;
                a = i1;
                super();
            }
                        });
                    }
                    if (com.cyberlink.beautycircle.controller.fragment.p.e(c) != null)
                    {
                        com.cyberlink.beautycircle.controller.fragment.p.e(c).followingCount = Integer.valueOf(i1);
                    }
                    if (com.cyberlink.beautycircle.controller.fragment.p.h(c))
                    {
                        AccountManager.a(null, Integer.valueOf(i1));
                        return;
                    }
                }
            }

            public void a(boolean flag)
            {
                if (p.G(c) == null)
                {
                    return;
                } else
                {
                    p.G(c).post(new Runnable(this, flag) {

                        final boolean a;
                        final _cls24 b;

                        public void run()
                        {
                            boolean flag = false;
                            int i1 = 0;
                            if (b.b == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.a)
                            {
                                p p1 = b.c;
                                if (!a)
                                {
                                    i1 = 1;
                                }
                                com.cyberlink.beautycircle.controller.fragment.p.h(p1, i1);
                            } else
                            if (b.b == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.b)
                            {
                                p p2 = b.c;
                                int j1;
                                if (a)
                                {
                                    j1 = ((flag) ? 1 : 0);
                                } else
                                {
                                    j1 = 1;
                                }
                                com.cyberlink.beautycircle.controller.fragment.p.i(p2, j1);
                                return;
                            }
                        }

            
            {
                b = _pcls24;
                a = flag;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                c = p.this;
                b = userlisttype;
                super(p.this);
            }
        };
    }

    static v a(p p1, v v1)
    {
        p1.A = v1;
        return v1;
    }

    static w a(p p1, w w1)
    {
        p1.B = w1;
        return w1;
    }

    static x a(p p1, x x1)
    {
        p1.z = x1;
        return x1;
    }

    static UserInfo a(p p1, UserInfo userinfo)
    {
        p1.Q = userinfo;
        return userinfo;
    }

    static String a(p p1, String s1)
    {
        p1.O = s1;
        return s1;
    }

    static ArrayList a(p p1, UserInfo userinfo, boolean flag)
    {
        return p1.a(userinfo, flag);
    }

    private ArrayList a(UserInfo userinfo, boolean flag)
    {
        if (userinfo == null || userinfo.userType == null)
        {
            return new ArrayList();
        }
        if (userinfo.tab == null || userinfo.tab.isEmpty())
        {
            userinfo.tab = new ArrayList(Arrays.asList(new String[] {
                "CIRCLE", "POST", "LIKE", "FOLLOWER", "FOLLOWING"
            }));
        }
        return b(userinfo, flag);
    }

    private ArrayList a(ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        if (arraylist == null)
        {
            return arraylist1;
        }
        MeADPager meadpager;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); arraylist1.add(meadpager))
        {
            meadpager = (MeADPager)arraylist.next();
            meadpager.type = com.cyberlink.beautycircle.model.MeADPager.DisplayType.c;
        }

        return arraylist1;
    }

    private void a(int i1, boolean flag)
    {
        float f1;
        int j1;
        if (ae != null && ae.isRunning())
        {
            return;
        }
        if (g.getChildCount() <= 0 || flag)
        {
            i.setTranslationY(0.0F);
            U.setTranslationY(0.0F);
            return;
        }
        j1 = i.getHeight();
        f1 = -j1;
        if (g.getChildAt(0) == T)
        {
            f1 = T.getY();
        }
        i.setTranslationY(f1);
        if (aN != 1) goto _L2; else goto _L1
_L1:
        float f2 = Math.max(f1, -j1);
_L4:
        U.setTranslationY(f2);
        return;
_L2:
        f2 = f1;
        if (aN == 2)
        {
            f2 = f1;
            if (f1 <= (float)(-j1))
            {
                f2 = Math.min(-j1, Math.max(-j1 - U.getHeight(), U.getTranslationY() - (float)i1));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void a(p p1, int i1, boolean flag)
    {
        p1.a(i1, flag);
    }

    static void a(p p1, com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode)
    {
        p1.b(melistmode);
    }

    static void a(p p1, ArrayList arraylist)
    {
        p1.b(arraylist);
    }

    private void a(CircleDetail circledetail)
    {
        CircleDetail circledetail1;
        if (g != null && y != null && circledetail != null && circledetail.id != null)
        {
            if ((circledetail1 = (CircleDetail)y.b(circledetail.id.toString())) != null)
            {
                y.a(circledetail1, circledetail);
                return;
            }
        }
    }

    private void a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode)
    {
        if (melistmode == null || melistmode.equals(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a))
        {
            melistmode = AccountManager.c();
            if (melistmode != null && melistmode.longValue() == L)
            {
                W = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b;
                return;
            } else
            {
                W = NetworkPost.b();
                return;
            }
        } else
        {
            W = melistmode;
            return;
        }
    }

    static boolean a(p p1, boolean flag)
    {
        p1.E = flag;
        return flag;
    }

    private boolean a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode, CLMultiColumnListView clmulticolumnlistview)
    {
        android.support.v4.app.FragmentActivity fragmentactivity;
        Long along[];
        long l1;
        fragmentactivity = getActivity();
        if (fragmentactivity == null)
        {
            return false;
        }
        long l2 = L;
        l1 = l2;
        if (l2 == -1L)
        {
            l1 = l2;
            if (Q != null)
            {
                l1 = Q.id;
            }
        }
        along = new Long[1];
        along[0] = Long.valueOf(l1);
        class _cls31
        {

            static final int a[];

            static 
            {
                a = new int[com.cyberlink.beautycircle.model.MeTabItem.MeListMode.values().length];
                try
                {
                    a[com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[com.cyberlink.beautycircle.model.MeTabItem.MeListMode.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.cyberlink.beautycircle.model.MeTabItem.MeListMode.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.cyberlink.beautycircle.model.MeTabItem.MeListMode.e.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.cyberlink.beautycircle.model.MeTabItem.MeListMode.f.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.cyberlink.beautycircle.model.MeTabItem.MeListMode.g.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.cyberlink.beautycircle.controller.fragment._cls31.a[melistmode.ordinal()];
        JVM INSTR tableswitch 1 6: default 112
    //                   1 114
    //                   2 144
    //                   3 177
    //                   4 210
    //                   5 252
    //                   6 278;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return true;
_L2:
        y = new c(fragmentactivity, clmulticolumnlistview, l1, 1, aC);
        y.c();
        continue; /* Loop/switch isn't completed */
_L3:
        z = new x(fragmentactivity, clmulticolumnlistview, k.bc_view_item_discover_list, along, null, aD);
        z.c();
        continue; /* Loop/switch isn't completed */
_L4:
        A = new v(fragmentactivity, clmulticolumnlistview, k.bc_view_item_discover_list, along, null, aE);
        A.c();
        continue; /* Loop/switch isn't completed */
_L5:
        B = new w(fragmentactivity, clmulticolumnlistview, k.bc_view_item_user_list, l1, -1L, com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.a, aG, aF);
        B.c();
        continue; /* Loop/switch isn't completed */
_L6:
        C = new i(fragmentactivity, clmulticolumnlistview, l1, aH, aF);
        continue; /* Loop/switch isn't completed */
_L7:
        D = new com.cyberlink.beautycircle.controller.adapter.p(getActivity(), clmulticolumnlistview, k.bc_view_item_product_me, aJ);
        D.a(L);
        D.c();
        if (true) goto _L1; else goto _L8
_L8:
    }

    private boolean a(UserInfo userinfo)
    {
        return userinfo != null && userinfo.coverUrl != null && !userinfo.coverUrl.toString().isEmpty();
    }

    static int b(p p1, int i1)
    {
        i1 = p1.ac % i1;
        p1.ac = i1;
        return i1;
    }

    static View b(p p1)
    {
        return p1.U;
    }

    static UserInfo b(p p1, UserInfo userinfo)
    {
        p1.aB = userinfo;
        return userinfo;
    }

    private ArrayList b(UserInfo userinfo, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        if (userinfo == null || userinfo.tab == null)
        {
            return arraylist;
        }
        Iterator iterator = userinfo.tab.iterator();
        boolean flag1 = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)iterator.next();
            if (((String) (obj)).equals("CIRCLE"))
            {
                obj = new MeTabItem();
                obj.listMode = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b;
                obj.fieldNameRes = l.bc_me_status_circles;
                arraylist.add(obj);
                if (W.equals(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b))
                {
                    flag1 = true;
                }
            } else
            if (((String) (obj)).equals("PRODUCT"))
            {
                obj = new MeTabItem();
                obj.listMode = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.g;
                obj.fieldNameRes = l.bc_me_status_products;
                arraylist.add(obj);
                if (W.equals(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.g))
                {
                    flag1 = true;
                }
            } else
            if (((String) (obj)).equals("POST"))
            {
                obj = new MeTabItem();
                obj.listMode = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.c;
                obj.fieldNameRes = l.bc_me_status_posts;
                arraylist.add(obj);
                if (W.equals(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.c))
                {
                    flag1 = true;
                }
            } else
            if (((String) (obj)).equals("LIKE"))
            {
                obj = new MeTabItem();
                obj.listMode = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.d;
                obj.fieldNameRes = l.bc_me_status_likes;
                arraylist.add(obj);
                if (W.equals(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.d))
                {
                    flag1 = true;
                }
            } else
            if (((String) (obj)).equals("FOLLOWER"))
            {
                if (userinfo != null && (userinfo.b() != null || flag))
                {
                    obj = new MeTabItem();
                    obj.listMode = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.e;
                    obj.fieldNameRes = l.bc_me_status_followers;
                    arraylist.add(obj);
                    if (W.equals(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.e))
                    {
                        flag1 = true;
                    }
                }
            } else
            if (((String) (obj)).equals("FOLLOWING"))
            {
                MeTabItem metabitem = new MeTabItem();
                metabitem.listMode = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.f;
                metabitem.fieldNameRes = l.bc_me_status_followings;
                arraylist.add(metabitem);
                if (W.equals(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.f))
                {
                    flag1 = true;
                }
            }
        } while (true);
        if (!flag1 && arraylist.size() > 0)
        {
            d(((MeTabItem)arraylist.get(0)).listMode);
        }
        return arraylist;
    }

    static void b(p p1, UserInfo userinfo, boolean flag)
    {
        p1.c(userinfo, flag);
    }

    private void b(com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode)
    {
        (new AsyncTask(melistmode) {

            final com.cyberlink.beautycircle.model.MeTabItem.MeListMode a;
            final p b;

            protected transient Void a(Void avoid[])
            {
                Long long1;
                Long long2;
                long l1;
                if (a == com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b)
                {
                    avoid = "circles";
                    s.a = "bc_me_circle";
                } else
                if (a == com.cyberlink.beautycircle.model.MeTabItem.MeListMode.c)
                {
                    avoid = "posts";
                    s.a = "bc_me_post";
                } else
                if (a == com.cyberlink.beautycircle.model.MeTabItem.MeListMode.d)
                {
                    avoid = "likes";
                    s.a = "bc_me_like";
                } else
                if (a == com.cyberlink.beautycircle.model.MeTabItem.MeListMode.e)
                {
                    avoid = "follower";
                } else
                if (a == com.cyberlink.beautycircle.model.MeTabItem.MeListMode.f)
                {
                    avoid = "following";
                } else
                if (a == com.cyberlink.beautycircle.model.MeTabItem.MeListMode.g)
                {
                    avoid = "products";
                } else
                {
                    avoid = "circles";
                }
                long2 = AccountManager.c();
                long1 = long2;
                if (long2 == null)
                {
                    long1 = Long.valueOf(0L);
                }
                if (com.cyberlink.beautycircle.controller.fragment.p.a(b) == -1L)
                {
                    l1 = long1.longValue();
                } else
                {
                    l1 = com.cyberlink.beautycircle.controller.fragment.p.a(b);
                }
                long2 = Long.valueOf(l1);
                if (long2.longValue() > 0L)
                {
                    com.perfectcorp.a.b.a(new ak(avoid, long1, long2));
                }
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            
            {
                b = p.this;
                a = melistmode;
                super();
            }
        }).executeOnExecutor(j.q, new Void[0]);
    }

    private void b(UserInfo userinfo)
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity == null)
        {
            return;
        } else
        {
            fragmentactivity.runOnUiThread(new Runnable(userinfo) {

                final UserInfo a;
                final p b;

                public void run()
                {
                    boolean flag1 = true;
                    p p1 = b;
                    boolean flag;
                    if (com.cyberlink.beautycircle.controller.fragment.p.h(b) && !p.f(b))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    p1.d(flag);
                    if (com.cyberlink.beautycircle.controller.fragment.p.h(b) && p.f(b))
                    {
                        flag = flag1;
                    } else
                    {
                        flag = false;
                    }
                    com.cyberlink.beautycircle.controller.fragment.p.b(b, a, flag);
                }

            
            {
                b = p.this;
                a = userinfo;
                super();
            }
            });
            return;
        }
    }

    private void b(ArrayList arraylist)
    {
        if (F)
        {
            F = false;
            arraylist = a(arraylist);
            if (arraylist != null && arraylist.size() > 0)
            {
                aa.addAll(arraylist);
                aK.notifyDataSetChanged();
                o(aa.size());
            }
        }
        r();
    }

    static boolean b(p p1, com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode)
    {
        return p1.d(melistmode);
    }

    static boolean b(p p1, boolean flag)
    {
        p1.N = flag;
        return flag;
    }

    static AnimatorSet c(p p1)
    {
        return p1.ae;
    }

    static com.cyberlink.beautycircle.model.MeTabItem.MeListMode c(p p1, com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode)
    {
        p1.V = melistmode;
        return melistmode;
    }

    static void c(p p1, int i1)
    {
        p1.m(i1);
    }

    static void c(p p1, UserInfo userinfo)
    {
        p1.b(userinfo);
    }

    private void c(com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode)
    {
        if (S != null)
        {
            S.setTabSelected(melistmode);
        }
    }

    private void c(UserInfo userinfo, boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (G != null)
        {
            G.setVisibility(0);
            G.setOnClickListener(ar);
        }
        if (H != null)
        {
            H.setVisibility(0);
            H.setOnClickListener(as);
        }
_L4:
        if (Q != null && !Z.isEmpty())
        {
            userinfo = (com.cyberlink.beautycircle.controller.fragment.q)Z.get(Integer.valueOf(0));
            if (userinfo != null)
            {
                userinfo.a(Q, N, x);
            }
        }
        return;
_L2:
        if (G != null)
        {
            G.setVisibility(8);
            G.setOnClickListener(null);
        }
        if (H != null)
        {
            H.setVisibility(8);
            H.setOnClickListener(null);
        }
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        if ((fragmentactivity instanceof MeActivity) && userinfo != null)
        {
            M = userinfo.displayName;
            boolean flag1;
            if (userinfo.userType.equals("Normal") || userinfo.userType.equals("Blogger"))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (userinfo.b() == null)
            {
                if (flag1)
                {
                    ((MeActivity)fragmentactivity).b().a(0xe4000000, com.cyberlink.beautycircle.controller.fragment.x.a, x.f, 0);
                } else
                {
                    ((MeActivity)fragmentactivity).b().a();
                }
            } else
            {
                if (flag1)
                {
                    ((MeActivity)fragmentactivity).b().a(0xc5000000, com.cyberlink.beautycircle.controller.fragment.x.a, x.f, com.cyberlink.beautycircle.controller.fragment.y.b);
                } else
                {
                    ((MeActivity)fragmentactivity).b().a(0xc1000000, com.cyberlink.beautycircle.controller.fragment.x.a, 0, com.cyberlink.beautycircle.controller.fragment.y.b);
                }
                if (userinfo.b().booleanValue())
                {
                    ((MeActivity)fragmentactivity).b().f(false);
                    ((MeActivity)fragmentactivity).b().c(m.bc_following);
                } else
                {
                    ((MeActivity)fragmentactivity).b().f(true);
                    ((MeActivity)fragmentactivity).b().c(m.bc_plus_follow);
                }
                ((MeActivity)fragmentactivity).a(com.cyberlink.beautycircle.utility.p.a(Q, aI), ah);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean c(p p1, boolean flag)
    {
        p1.x = flag;
        return flag;
    }

    static String d(p p1)
    {
        return p1.M;
    }

    static void d(p p1, int i1)
    {
        p1.g(i1);
    }

    static boolean d(p p1, boolean flag)
    {
        p1.F = flag;
        return flag;
    }

    private boolean d(com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode)
    {
        com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode1;
        CLMultiColumnListView clmulticolumnlistview;
        if (g == null)
        {
            return false;
        }
        clmulticolumnlistview = (CLMultiColumnListView)g;
        melistmode1 = melistmode;
        if (melistmode == null)
        {
            melistmode1 = W;
        }
        V = melistmode1;
        com.cyberlink.beautycircle.controller.fragment._cls31.a[melistmode1.ordinal()];
        JVM INSTR tableswitch 1 6: default 80
    //                   1 91
    //                   2 170
    //                   3 249
    //                   4 328
    //                   5 418
    //                   6 508;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        q();
        clmulticolumnlistview.requestFocus();
        return true;
_L2:
        c(melistmode1);
        clmulticolumnlistview.a(com.cyberlink.beautycircle.a.b());
        if (y != null)
        {
            y.c(clmulticolumnlistview);
            if (y.g && !y.h())
            {
                y.c();
            }
        } else
        {
            a(melistmode1, clmulticolumnlistview);
        }
        d(a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b, -1));
        continue; /* Loop/switch isn't completed */
_L3:
        c(melistmode1);
        clmulticolumnlistview.a(com.cyberlink.beautycircle.a.a());
        if (z != null)
        {
            z.c(clmulticolumnlistview);
            if (z.g && !z.h())
            {
                z.c();
            }
        } else
        {
            a(melistmode1, clmulticolumnlistview);
        }
        h(a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.c, -1));
        continue; /* Loop/switch isn't completed */
_L4:
        c(melistmode1);
        clmulticolumnlistview.a(com.cyberlink.beautycircle.a.a());
        if (A != null)
        {
            A.c(clmulticolumnlistview);
            if (A.g && !A.h())
            {
                A.c();
            }
        } else
        {
            a(melistmode1, clmulticolumnlistview);
        }
        f(a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.d, -1));
        continue; /* Loop/switch isn't completed */
_L5:
        c(melistmode1);
        clmulticolumnlistview.a(1);
        if (B != null)
        {
            B.c(clmulticolumnlistview);
            if (B.g && !B.h())
            {
                j(1);
                B.c();
            } else
            {
                j(a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.e, -1));
            }
        } else
        {
            j(1);
            a(melistmode1, clmulticolumnlistview);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        c(melistmode1);
        clmulticolumnlistview.a(1);
        if (C != null)
        {
            C.a(clmulticolumnlistview);
            if (C.a && !C.a())
            {
                l(1);
                C.b();
            } else
            {
                l(a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.f, -1));
            }
        } else
        {
            l(1);
            a(melistmode1, clmulticolumnlistview);
        }
        continue; /* Loop/switch isn't completed */
_L7:
        c(melistmode1);
        clmulticolumnlistview.a(1);
        if (D != null)
        {
            D.c(clmulticolumnlistview);
            if (D.g && !D.h())
            {
                n(1);
                D.c();
            } else
            {
                n(a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.g, -1));
            }
        } else
        {
            n(1);
            a(melistmode1, clmulticolumnlistview);
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    static UserInfo e(p p1)
    {
        return p1.Q;
    }

    private void e(int i1)
    {
        if (S != null)
        {
            S.a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.d, i1);
        }
        f(i1);
    }

    static void e(p p1, int i1)
    {
        p1.e(i1);
    }

    static boolean e(p p1, boolean flag)
    {
        p1.ad = flag;
        return flag;
    }

    private void f(int i1)
    {
        boolean flag;
        if (S != null)
        {
            flag = S.a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.d);
        } else
        {
            flag = false;
        }
        if (flag && I != null && J != null)
        {
            J.setVisibility(8);
            if (i1 == 0)
            {
                I.setVisibility(0);
            } else
            {
                I.setVisibility(8);
            }
            if (i1 == 0)
            {
                if (N)
                {
                    I.setText(m.bc_me_like_promote);
                } else
                if (Q.displayName != null)
                {
                    android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
                    if (fragmentactivity != null)
                    {
                        I.setText(String.format(Locale.getDefault(), fragmentactivity.getString(m.bc_me_other_like_promote), new Object[] {
                            Q.displayName
                        }));
                        return;
                    }
                } else
                {
                    I.setText("");
                    return;
                }
            }
        }
    }

    static void f(p p1, int i1)
    {
        p1.k(i1);
    }

    static boolean f(p p1)
    {
        return p1.x;
    }

    static boolean f(p p1, boolean flag)
    {
        p1.R = flag;
        return flag;
    }

    private void g(int i1)
    {
        if (S != null)
        {
            S.a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.c, i1);
        }
        h(i1);
    }

    static void g(p p1)
    {
        p1.t();
    }

    static void g(p p1, int i1)
    {
        p1.i(i1);
    }

    private void h(int i1)
    {
        boolean flag;
        if (S != null)
        {
            flag = S.a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.c);
        } else
        {
            flag = false;
        }
        if (flag && I != null && J != null && K != null)
        {
            if (i1 == 0)
            {
                I.setVisibility(0);
            } else
            {
                I.setVisibility(8);
            }
            if (i1 == 0 && N)
            {
                J.setVisibility(0);
                J.setOnClickListener(ao);
                K.setText(m.bc_write_a_post_btn);
            } else
            {
                J.setVisibility(8);
            }
            if (i1 == 0)
            {
                if (N)
                {
                    I.setText(m.bc_me_post_promote);
                } else
                if (Q != null && Q.displayName != null)
                {
                    android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
                    if (fragmentactivity != null)
                    {
                        I.setText(String.format(Locale.getDefault(), fragmentactivity.getString(m.bc_me_other_post_promote), new Object[] {
                            Q.displayName
                        }));
                        return;
                    }
                } else
                {
                    I.setText("");
                    return;
                }
            }
        }
    }

    static void h(p p1, int i1)
    {
        p1.j(i1);
    }

    static boolean h(p p1)
    {
        return p1.N;
    }

    static x i(p p1)
    {
        return p1.z;
    }

    private void i(int i1)
    {
        if (S != null)
        {
            S.a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.e, i1);
        }
    }

    static void i(p p1, int i1)
    {
        p1.l(i1);
    }

    static c j(p p1)
    {
        return p1.y;
    }

    private void j(int i1)
    {
        boolean flag;
        if (S != null)
        {
            flag = S.a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.e);
        } else
        {
            flag = false;
        }
        if (flag && I != null && J != null)
        {
            J.setVisibility(8);
            if (i1 == 0)
            {
                I.setVisibility(0);
            } else
            {
                I.setVisibility(8);
            }
            if (i1 == 0)
            {
                if (N)
                {
                    I.setText(m.bc_me_follower_promote);
                } else
                if (Q.displayName != null)
                {
                    android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
                    if (fragmentactivity != null)
                    {
                        I.setText(String.format(Locale.getDefault(), fragmentactivity.getString(m.bc_me_other_follower_promote), new Object[] {
                            Q.displayName
                        }));
                        return;
                    }
                } else
                {
                    I.setText("");
                    return;
                }
            }
        }
    }

    static void j(p p1, int i1)
    {
        p1.n(i1);
    }

    static w k(p p1)
    {
        return p1.B;
    }

    private void k(int i1)
    {
        if (S != null)
        {
            S.a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.f, i1);
        }
    }

    static i l(p p1)
    {
        return p1.C;
    }

    private void l(int i1)
    {
label0:
        {
            boolean flag;
            if (S != null)
            {
                flag = S.a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.f);
            } else
            {
                flag = false;
            }
            if (flag && I != null && J != null)
            {
                J.setVisibility(8);
                if (i1 != 0)
                {
                    break label0;
                }
                I.setVisibility(0);
                if (N)
                {
                    I.setText(m.bc_me_following_promote);
                } else
                if (Q.displayName != null)
                {
                    android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
                    if (fragmentactivity != null)
                    {
                        I.setText(String.format(Locale.getDefault(), fragmentactivity.getString(m.bc_me_other_following_promote), new Object[] {
                            Q.displayName
                        }));
                        return;
                    }
                } else
                {
                    I.setText("");
                    return;
                }
            }
            return;
        }
        I.setVisibility(8);
    }

    static v m(p p1)
    {
        return p1.A;
    }

    private void m(int i1)
    {
        if (S != null)
        {
            S.a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.g, i1);
        }
    }

    static com.cyberlink.beautycircle.controller.adapter.p n(p p1)
    {
        return p1.D;
    }

    private void n(int i1)
    {
label0:
        {
label1:
            {
                boolean flag;
                if (S != null)
                {
                    flag = S.a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.g);
                } else
                {
                    flag = false;
                }
                if (flag && I != null)
                {
                    if (i1 != 0)
                    {
                        break label0;
                    }
                    I.setVisibility(0);
                    if (Q.displayName == null)
                    {
                        break label1;
                    }
                    android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
                    if (fragmentactivity != null)
                    {
                        I.setText(String.format(Locale.getDefault(), fragmentactivity.getString(m.bc_me_other_product_feature_promote), new Object[] {
                            Q.displayName
                        }));
                    }
                }
                return;
            }
            I.setText("");
            return;
        }
        I.setVisibility(8);
    }

    static TreeMap o(p p1)
    {
        return p1.Z;
    }

    private void o(int i1)
    {
        Object obj = getActivity();
        if (obj == null || Y == null)
        {
            return;
        }
        i1 -= Y.getChildCount();
        if (i1 > 0)
        {
            obj = (LayoutInflater)((Activity) (obj)).getSystemService("layout_inflater");
            for (; i1 > 0; i1--)
            {
                ImageView imageview = (ImageView)((LayoutInflater) (obj)).inflate(k.bc_view_item_page_indicator, Y, false);
                Y.addView(imageview);
            }

        } else
        if (i1 < 0)
        {
            Y.removeViews(Y.getChildCount() + i1, -i1);
        }
        if (Y.getChildCount() > 1)
        {
            Y.setVisibility(0);
            return;
        } else
        {
            Y.setVisibility(8);
            return;
        }
    }

    private MeADPager p()
    {
        MeADPager meadpager = new MeADPager();
        meadpager.type = com.cyberlink.beautycircle.model.MeADPager.DisplayType.b;
        return meadpager;
    }

    static String p(p p1)
    {
        return p1.O;
    }

    static int q(p p1)
    {
        int i1 = p1.aw + 1;
        p1.aw = i1;
        return i1;
    }

    private void q()
    {
        if (S != null)
        {
            S.a();
        }
    }

    static LinearLayout r(p p1)
    {
        return p1.Y;
    }

    private void r()
    {
        if (X != null && aa.size() > 1)
        {
            X.removeCallbacks(aA);
            X.postDelayed(aA, 3000L);
        }
    }

    private void s()
    {
        if (X != null)
        {
            X.removeCallbacks(aA);
        }
    }

    static void s(p p1)
    {
        p1.r();
    }

    static int t(p p1)
    {
        return p1.ac;
    }

    private void t()
    {
        (new AsyncTask() {

            final p a;

            protected transient UserInfo a(Void avoid[])
            {
                Long long1;
                boolean flag;
                flag = true;
                long1 = null;
                Object obj = p.A(a);
                obj;
                JVM INSTR monitorenter ;
                if (p.B(a) == null) goto _L2; else goto _L1
_L1:
                avoid = p.B(a);
                com.cyberlink.beautycircle.controller.fragment.p.b(a, null);
                  goto _L3
_L22:
                if (com.cyberlink.beautycircle.controller.fragment.p.a(a) == -1L) goto _L5; else goto _L4
_L4:
                Object obj1 = a;
                if (avoid == null) goto _L7; else goto _L6
_L6:
                if (com.cyberlink.beautycircle.controller.fragment.p.a(a) != ((UserInfo) (avoid)).id) goto _L7; else goto _L8
_L8:
                com.cyberlink.beautycircle.controller.fragment.p.b(((p) (obj1)), flag);
_L17:
                if (!com.cyberlink.beautycircle.controller.fragment.p.h(a)) goto _L10; else goto _L9
_L9:
                obj1 = AccountManager.b();
                if (obj1 == null) goto _L12; else goto _L11
_L11:
                if (((String) (obj1)).isEmpty()) goto _L12; else goto _L13
_L13:
                if (com.cyberlink.beautycircle.controller.fragment.p.e(a) == null) goto _L15; else goto _L14
_L14:
                flag = p.C(a);
                if (!flag) goto _L16; else goto _L15
_L15:
                com.cyberlink.beautycircle.controller.fragment.p.a(a, (UserInfo)NetworkUser.a(long1.longValue(), long1, AccountManager.b()).d());
                com.cyberlink.beautycircle.controller.fragment.p.a(a, false);
                AccountManager.a(((String) (obj1)), com.cyberlink.beautycircle.controller.fragment.p.e(a), false);
_L18:
                if (!p.f(a) && com.cyberlink.beautycircle.controller.fragment.p.x(a) != null)
                {
                    com.cyberlink.beautycircle.controller.fragment.p.x(a).post(new Runnable(this) {

                        final _cls18 a;

                        public void run()
                        {
                            com.cyberlink.beautycircle.controller.fragment.q q1 = (com.cyberlink.beautycircle.controller.fragment.q)p.o(a.a).get(Integer.valueOf(0));
                            if (q1 != null && q1.b().equals(com.cyberlink.beautycircle.model.MeADPager.DisplayType.b))
                            {
                                q1.a(com.cyberlink.beautycircle.controller.fragment.p.e(a.a), com.cyberlink.beautycircle.controller.fragment.p.h(a.a), p.f(a.a));
                            }
                        }

            
            {
                a = _pcls18;
                super();
            }
                    });
                }
                avoid = a.getActivity();
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_262;
                }
                if (avoid instanceof MainActivity)
                {
                    avoid.runOnUiThread(new Runnable(this) {

                        final _cls18 a;

                        public void run()
                        {
                            if (com.cyberlink.beautycircle.controller.fragment.p.e(a.a) != null)
                            {
                                if (com.cyberlink.beautycircle.controller.fragment.p.e(a.a).circleCount != null)
                                {
                                    a.a.c(com.cyberlink.beautycircle.controller.fragment.p.e(a.a).circleCount.intValue());
                                }
                                if (com.cyberlink.beautycircle.controller.fragment.p.e(a.a).productFeatureCount != null)
                                {
                                    com.cyberlink.beautycircle.controller.fragment.p.c(a.a, com.cyberlink.beautycircle.controller.fragment.p.e(a.a).productFeatureCount.intValue());
                                }
                                if (com.cyberlink.beautycircle.controller.fragment.p.e(a.a).postCount != null)
                                {
                                    com.cyberlink.beautycircle.controller.fragment.p.d(a.a, com.cyberlink.beautycircle.controller.fragment.p.e(a.a).postCount.intValue());
                                }
                                if (com.cyberlink.beautycircle.controller.fragment.p.e(a.a).likedTargetCount != null)
                                {
                                    com.cyberlink.beautycircle.controller.fragment.p.e(a.a, com.cyberlink.beautycircle.controller.fragment.p.e(a.a).likedTargetCount.intValue());
                                }
                                if (com.cyberlink.beautycircle.controller.fragment.p.e(a.a).followingCount != null)
                                {
                                    p.f(a.a, com.cyberlink.beautycircle.controller.fragment.p.e(a.a).followingCount.intValue());
                                }
                                if (com.cyberlink.beautycircle.controller.fragment.p.e(a.a).followerCount != null)
                                {
                                    p.g(a.a, com.cyberlink.beautycircle.controller.fragment.p.e(a.a).followerCount.intValue());
                                }
                            }
                        }

            
            {
                a = _pcls18;
                super();
            }
                    });
                }
                com.cyberlink.beautycircle.controller.fragment.p.c(a, true);
_L19:
                obj;
                JVM INSTR monitorexit ;
                return com.cyberlink.beautycircle.controller.fragment.p.e(a);
_L2:
                avoid = AccountManager.d();
                  goto _L3
_L23:
                long1 = Long.valueOf(((UserInfo) (avoid)).id);
                break; /* Loop/switch isn't completed */
_L5:
                com.cyberlink.beautycircle.controller.fragment.p.b(a, true);
                  goto _L17
                avoid;
                obj;
                JVM INSTR monitorexit ;
                throw avoid;
                Exception exception;
                exception;
                com.cyberlink.beautycircle.controller.fragment.p.a(a, avoid);
                exception.printStackTrace();
                  goto _L18
_L16:
                com.cyberlink.beautycircle.controller.fragment.p.a(a, avoid);
                  goto _L18
_L12:
                if (!p.f(a))
                {
                    break MISSING_BLOCK_LABEL_450;
                }
                com.cyberlink.beautycircle.controller.fragment.p.a(a, null);
                com.cyberlink.beautycircle.controller.fragment.p.a(a, null);
                com.cyberlink.beautycircle.controller.fragment.p.a(a, null);
                com.cyberlink.beautycircle.controller.fragment.p.a(a, null);
                com.cyberlink.beautycircle.controller.fragment.p.a(a, null);
                com.cyberlink.beautycircle.controller.fragment.p.a(a, null);
                com.cyberlink.beautycircle.controller.fragment.p.c(a, null);
                avoid = a.getActivity();
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_450;
                }
                if (avoid instanceof MainActivity)
                {
                    avoid.runOnUiThread(new Runnable(this, avoid) {

                        final Activity a;
                        final _cls18 b;

                        public void run()
                        {
                            if (b.a.g != null)
                            {
                                ((CLMultiColumnListView)b.a.g).setAdapter(null);
                            }
                            b.a.c(0);
                            com.cyberlink.beautycircle.controller.fragment.p.c(b.a, 0);
                            com.cyberlink.beautycircle.controller.fragment.p.d(b.a, 0);
                            com.cyberlink.beautycircle.controller.fragment.p.e(b.a, 0);
                            p.f(b.a, 0);
                            p.g(b.a, 0);
                            ((MainActivity)a).a(0, false);
                            com.cyberlink.beautycircle.controller.fragment.q q1 = (com.cyberlink.beautycircle.controller.fragment.q)p.o(b.a).get(Integer.valueOf(0));
                            if (q1 != null && q1.b().equals(com.cyberlink.beautycircle.model.MeADPager.DisplayType.b))
                            {
                                q1.a(null, com.cyberlink.beautycircle.controller.fragment.p.h(b.a), false);
                            }
                        }

            
            {
                b = _pcls18;
                a = activity;
                super();
            }
                    });
                }
                com.cyberlink.beautycircle.controller.fragment.p.c(a, false);
                  goto _L19
_L10:
                com.cyberlink.beautycircle.controller.fragment.p.c(a, false);
                if (com.cyberlink.beautycircle.controller.fragment.p.e(a) == null || com.cyberlink.beautycircle.controller.fragment.p.e(a).userType == null) goto _L21; else goto _L20
_L20:
                flag = p.C(a);
                if (!flag) goto _L19; else goto _L21
_L21:
                com.cyberlink.beautycircle.controller.fragment.p.a(a, (UserInfo)NetworkUser.a(com.cyberlink.beautycircle.controller.fragment.p.a(a), AccountManager.c(), AccountManager.b()).d());
                com.cyberlink.beautycircle.controller.fragment.p.d(a, true);
                com.cyberlink.beautycircle.controller.fragment.p.a(a, false);
                  goto _L19
                avoid;
                avoid.printStackTrace();
                  goto _L19
                avoid;
                avoid.printStackTrace();
                  goto _L19
                avoid;
                avoid.printStackTrace();
                  goto _L19
_L3:
                if (avoid != null) goto _L23; else goto _L22
_L7:
                flag = false;
                  goto _L8
            }

            protected void a(UserInfo userinfo)
            {
                com.cyberlink.beautycircle.controller.fragment.p.c(a, userinfo);
                if (userinfo != null)
                {
                    if (p.D(a) != null)
                    {
                        boolean flag;
                        if (com.cyberlink.beautycircle.controller.fragment.p.h(a) && p.f(a))
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        p.D(a).a(com.cyberlink.beautycircle.controller.fragment.p.a(a, userinfo, flag));
                    }
                    p.E(a);
                    com.cyberlink.beautycircle.controller.fragment.p.a(a, userinfo.eventImageList);
                }
                userinfo = a.getActivity();
                if (p.F(a))
                {
                    com.cyberlink.beautycircle.controller.fragment.p.e(a, false);
                    if (userinfo != null && (userinfo instanceof MeActivity) && ((MeActivity)userinfo).b().b() != null)
                    {
                        ((MeActivity)userinfo).b().b().performClick();
                    }
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((UserInfo)obj);
            }

            
            {
                a = p.this;
                super();
            }
        }).executeOnExecutor(j.q, new Void[0]);
    }

    private void u()
    {
        if (Q != null)
        {
            if (Q.circleCount != null)
            {
                c(Q.circleCount.intValue());
            } else
            {
                a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b, ((CLMultiColumnListView) (null)));
            }
            if (Q.productFeatureCount != null)
            {
                m(Q.productFeatureCount.intValue());
            } else
            {
                a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.g, ((CLMultiColumnListView) (null)));
            }
            if (Q.postCount != null)
            {
                g(Q.postCount.intValue());
            } else
            {
                a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.c, ((CLMultiColumnListView) (null)));
            }
            if (Q.followerCount != null)
            {
                i(Q.followerCount.intValue());
            } else
            {
                a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.e, ((CLMultiColumnListView) (null)));
            }
            if (Q.followingCount != null)
            {
                k(Q.followingCount.intValue());
            } else
            {
                a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.f, ((CLMultiColumnListView) (null)));
            }
            if (Q.likedTargetCount != null)
            {
                e(Q.likedTargetCount.intValue());
            } else
            {
                a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.d, ((CLMultiColumnListView) (null)));
            }
            d(V);
        }
    }

    static boolean u(p p1)
    {
        return p1.F;
    }

    private void v()
    {
        ac = 0;
        Z.clear();
        aa.clear();
        X.setOffscreenPageLimit(4);
        X.setAdapter(aK);
        X.setOnPageChangeListener(ay);
        aa.add(p());
        aK.notifyDataSetChanged();
        o(aa.size());
        ay.onPageSelected(0);
    }

    static void v(p p1)
    {
        p1.w();
    }

    private void w()
    {
        s();
        ac = 0;
        com.cyberlink.beautycircle.controller.fragment.q q1 = (com.cyberlink.beautycircle.controller.fragment.q)Z.get(Integer.valueOf(0));
        MeADPager meadpager;
        if (aa.size() > 0)
        {
            meadpager = (MeADPager)aa.get(0);
        } else
        {
            meadpager = p();
        }
        Z.clear();
        aa.clear();
        if (q1 != null)
        {
            Z.put(Integer.valueOf(0), q1);
        }
        aa.add(meadpager);
        aK.notifyDataSetChanged();
        o(aa.size());
    }

    static void w(p p1)
    {
        p1.s();
    }

    static ViewPager x(p p1)
    {
        return p1.X;
    }

    static int y(p p1)
    {
        int i1 = p1.ac;
        p1.ac = i1 + 1;
        return i1;
    }

    static ArrayList z(p p1)
    {
        return p1.aa;
    }

    public void a(BottomBarFragment bottombarfragment)
    {
        if (bottombarfragment != null && g != null)
        {
            bottombarfragment.a(g, k, af);
            bottombarfragment.a(aL);
        }
    }

    public void b(int i1)
    {
        super.b(i1);
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null)
        {
            Object obj = ((BaseActivity)fragmentactivity).n();
            if (obj != null)
            {
                obj = (com.cyberlink.beautycircle.model.MeTabItem.MeListMode)((Bundle) (obj)).getSerializable("ListMode");
                if (!((com.cyberlink.beautycircle.model.MeTabItem.MeListMode) (obj)).equals(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a))
                {
                    d(((com.cyberlink.beautycircle.model.MeTabItem.MeListMode) (obj)));
                }
            }
            ((BaseActivity)fragmentactivity).a(null);
        }
        b(V);
        t();
        r();
        s = true;
    }

    public void b(BottomBarFragment bottombarfragment)
    {
        if (bottombarfragment != null && g != null)
        {
            bottombarfragment.a(g, k);
            bottombarfragment.b(aL);
        }
    }

    protected void c(int i1)
    {
        if (S != null)
        {
            S.a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b, i1);
        }
        d(i1);
    }

    protected void d(int i1)
    {
        boolean flag;
        if (S != null)
        {
            flag = S.a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b);
        } else
        {
            flag = false;
        }
        if (flag && I != null && J != null && K != null)
        {
            if (i1 == 0)
            {
                I.setVisibility(0);
            } else
            {
                I.setVisibility(8);
            }
            if (i1 == 0 && N)
            {
                J.setVisibility(0);
                J.setOnClickListener(ap);
                K.setText(m.bc_write_a_circle_btn);
            } else
            {
                J.setVisibility(8);
            }
            if (i1 == 0)
            {
                if (N)
                {
                    I.setText(m.bc_me_circle_promote);
                } else
                if (Q.displayName != null)
                {
                    android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
                    if (fragmentactivity != null)
                    {
                        I.setText(String.format(Locale.getDefault(), fragmentactivity.getString(m.bc_me_other_circle_promote), new Object[] {
                            Q.displayName
                        }));
                        return;
                    }
                } else
                {
                    I.setText("");
                    return;
                }
            }
        }
    }

    public void f()
    {
        if (a)
        {
            R = true;
            s();
            if (X != null && !a(Q) && Q != null)
            {
                X.postDelayed(new Runnable() {

                    final p a;

                    public void run()
                    {
                        if (com.cyberlink.beautycircle.controller.fragment.p.e(a) != null)
                        {
                            com.cyberlink.beautycircle.controller.fragment.q q1 = (com.cyberlink.beautycircle.controller.fragment.q)p.o(a).get(Integer.valueOf(0));
                            if (q1 != null && q1.b().equals(com.cyberlink.beautycircle.model.MeADPager.DisplayType.b))
                            {
                                com.cyberlink.beautycircle.utility.j.a().b(com.cyberlink.beautycircle.controller.fragment.p.e(a).userType, q1.a);
                            }
                        }
                    }

            
            {
                a = p.this;
                super();
            }
                }, 500L);
            }
        }
        super.f();
    }

    public com.cyberlink.beautycircle.controller.adapter.m h()
    {
        if (g != null)
        {
            android.widget.ListAdapter listadapter1 = ((PLA_ListView)g).getAdapter();
            android.widget.ListAdapter listadapter = listadapter1;
            if (listadapter1 instanceof WrapperListAdapter)
            {
                listadapter = ((WrapperListAdapter)listadapter1).getWrappedAdapter();
            }
            return (com.cyberlink.beautycircle.controller.adapter.m)listadapter;
        } else
        {
            return null;
        }
    }

    public void i()
    {
        if (Q != null)
        {
            if (y != null)
            {
                y.g = true;
            }
            if (z != null)
            {
                z.g = true;
            }
            if (B != null)
            {
                B.g = true;
            }
            if (C != null)
            {
                C.a = true;
            }
            if (A != null)
            {
                A.g = true;
            }
            if (D != null)
            {
                D.g = true;
            }
            F = true;
            if (ac != 0)
            {
                X.setCurrentItem(0, true);
            } else
            {
                w();
            }
            NetworkUser.a(Q.id, AccountManager.c(), AccountManager.b()).a(new com.perfectcorp.utility.m() {

                final p a;

                public void a()
                {
                    a(0x80000005);
                }

                public void a(int i1)
                {
                    Globals.b((new StringBuilder()).append("Fetching UserInfo error: ").append(i1).toString());
                }

                public void a(UserInfo userinfo)
                {
                    if (userinfo != null)
                    {
                        if (com.cyberlink.beautycircle.controller.fragment.p.h(a))
                        {
                            AccountManager.a(AccountManager.b(), userinfo, false);
                        }
                        com.cyberlink.beautycircle.controller.fragment.p.a(a, userinfo);
                        com.cyberlink.beautycircle.controller.fragment.p.a(a, false);
                        p.g(a);
                    }
                    userinfo = a.getActivity();
                    if (userinfo != null && !com.cyberlink.beautycircle.model.network.c.a())
                    {
                        ((BaseActivity)userinfo).a(userinfo.getString(m.bc_server_connect_fail), 3000);
                    }
                }

                public void b(Object obj)
                {
                    a((UserInfo)obj);
                }

            
            {
                a = p.this;
                super();
            }
            });
        }
    }

    public void k()
    {
        super.k();
        com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.m("me"));
    }

    public String n()
    {
        String s1 = null;
        if (L > 0L)
        {
            s1 = String.format(Locale.getDefault(), "ybc://me/%d", new Object[] {
                Long.valueOf(L)
            });
        }
        return s1;
    }

    protected void o()
    {
        T = new View(getActivity());
        if (!android/widget/ListView.isAssignableFrom(g.getClass())) goto _L2; else goto _L1
_L1:
        T.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, i.getHeight() + 1000));
        ((ListView)g).addHeaderView(T, null, false);
        ((ListView)g).setOnScrollListener(aL);
_L4:
        i.addOnLayoutChangeListener(aM);
        U.addOnLayoutChangeListener(aM);
        return;
_L2:
        if (com/cyberlink/beautycircle/view/widgetpool/common/CLMultiColumnListView.isAssignableFrom(g.getClass()))
        {
            T.setLayoutParams(new com.huewu.pla.lib.internal.c(-1, i.getHeight() + 1000));
            ((CLMultiColumnListView)g).a(T, null, false);
            ((CLMultiColumnListView)g).setOnScrollListener(aL);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        i1;
        JVM INSTR lookupswitch 14: default 132
    //                   48129: 133
    //                   48130: 172
    //                   48131: 222
    //                   48132: 314
    //                   48133: 331
    //                   48134: 388
    //                   48135: 480
    //                   48136: 497
    //                   48141: 514
    //                   48144: 533
    //                   48148: 552
    //                   48152: 567
    //                   48156: 567
    //                   48164: 597;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L13 _L14
_L1:
        return;
_L2:
        if ((j1 == -1 || j1 == 48258) && (intent = intent.getStringExtra("UserInfo")) != null)
        {
            aB = (UserInfo)Model.a(com/cyberlink/beautycircle/model/UserInfo, intent);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j1 == -1 && intent != null)
        {
            intent = intent.getData();
            ArrayList arraylist = new ArrayList();
            if (intent != null)
            {
                arraylist.add(intent);
            }
            com.cyberlink.beautycircle.c.a(getActivity(), arraylist, com.cyberlink.beautycircle.Globals.CropSettings.ProfileCover, 48132);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (j1 == -1 && O != null)
        {
            intent = getActivity();
            if (intent != null)
            {
                MediaScannerConnection.scanFile(intent, new String[] {
                    O.toString()
                }, null, null);
                intent = Uri.fromFile(new File(O));
                ArrayList arraylist1 = new ArrayList();
                if (intent != null)
                {
                    arraylist1.add(intent);
                }
                com.cyberlink.beautycircle.c.a(getActivity(), arraylist1, com.cyberlink.beautycircle.Globals.CropSettings.ProfileCover, 48132);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (j1 == -1 || j1 == 48258)
        {
            t();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (j1 == -1 && intent != null && getActivity() != null)
        {
            intent = intent.getData();
            ArrayList arraylist2 = new ArrayList();
            if (intent != null)
            {
                arraylist2.add(intent);
            }
            com.cyberlink.beautycircle.c.a(getActivity(), arraylist2, com.cyberlink.beautycircle.Globals.CropSettings.Avatar, 48135);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (j1 == -1 && O != null)
        {
            intent = getActivity();
            if (intent != null)
            {
                MediaScannerConnection.scanFile(intent, new String[] {
                    O.toString()
                }, null, null);
                intent = Uri.fromFile(new File(O));
                ArrayList arraylist3 = new ArrayList();
                if (intent != null)
                {
                    arraylist3.add(intent);
                }
                com.cyberlink.beautycircle.c.a(getActivity(), arraylist3, com.cyberlink.beautycircle.Globals.CropSettings.Avatar, 48135);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (j1 == -1 || j1 == 48258)
        {
            t();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (j1 == -1 || j1 == 48258)
        {
            t();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (j1 == 48256 || j1 == 48258)
        {
            t();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if (j1 == 48256 || j1 == 48258)
        {
            t();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L12:
        if (z != null)
        {
            z.notifyDataSetChanged();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L13:
        if (j1 == -1 && intent != null)
        {
            a((CircleDetail)Model.a(com/cyberlink/beautycircle/model/CircleDetail, intent.getStringExtra("CircleDetail")));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L14:
        if (j1 == -1)
        {
            intent = getResources().getString(m.bc_me_report_message);
            com.perfectcorp.utility.e.a(getActivity(), intent);
            return;
        }
        if (true) goto _L1; else goto _L15
_L15:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        android.support.v4.app.FragmentActivity fragmentactivity;
        bundle = layoutinflater.inflate(k.bc_fragment_page_me, viewgroup, false);
        viewgroup = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a;
        fragmentactivity = getActivity();
        af = bundle.findViewById(com.cyberlink.beautycircle.j.home_btn);
        c = (TextView)bundle.findViewById(com.cyberlink.beautycircle.j.demo_server_notice);
        if (fragmentactivity instanceof MeActivity)
        {
            viewgroup = fragmentactivity.getIntent().getStringExtra("UserInfo");
            if (viewgroup != null)
            {
                Q = (UserInfo)Model.a(com/cyberlink/beautycircle/model/UserInfo, viewgroup);
            }
            if (Q != null)
            {
                L = Q.id;
            } else
            {
                L = fragmentactivity.getIntent().getLongExtra("UserId", -1L);
            }
            viewgroup = (com.cyberlink.beautycircle.model.MeTabItem.MeListMode)fragmentactivity.getIntent().getSerializableExtra("ListMode");
            a(bundle, true, false, false, "me");
        } else
        {
            a(bundle, true, false, true, "me");
        }
        a(viewgroup);
        i = bundle.findViewById(com.cyberlink.beautycircle.j.header);
        U = bundle.findViewById(com.cyberlink.beautycircle.j.header_tab_bar);
        a(layoutinflater, bundle, null, Integer.valueOf(k.bc_view_footer));
        if (bundle != null)
        {
            G = bundle.findViewById(com.cyberlink.beautycircle.j.setting_btn);
            H = bundle.findViewById(com.cyberlink.beautycircle.j.add_btn);
            S = (MeTabScrollView)bundle.findViewById(com.cyberlink.beautycircle.j.me_tab_scroll_view);
            S.setTabClickListener(ag);
            I = (TextView)bundle.findViewById(com.cyberlink.beautycircle.j.me_empty_message_text);
            J = bundle.findViewById(com.cyberlink.beautycircle.j.me_write_post_btn);
            K = (TextView)bundle.findViewById(com.cyberlink.beautycircle.j.me_create_btn_text);
            X = (ViewPager)bundle.findViewById(com.cyberlink.beautycircle.j.me_ad_view_pager);
            X.setOnTouchListener(az);
            Y = (LinearLayout)bundle.findViewById(com.cyberlink.beautycircle.j.me_ad_view_indicator);
            if (X != null)
            {
                v();
            }
            o();
        }
        u = (RelativeLayout)bundle.findViewById(com.cyberlink.beautycircle.j.me_signIn_outter);
        if (!(fragmentactivity instanceof MeActivity)) goto _L2; else goto _L1
_L1:
        t();
_L4:
        t.a.a(aj);
        t.b.a(ak);
        t.c.a(al);
        t.d.a(am);
        t.e.a(an);
        b();
        return bundle;
_L2:
        if (fragmentactivity instanceof MainActivity)
        {
            AccountManager.a(ai);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onDestroyView()
    {
        t.a.b(aj);
        t.b.b(ak);
        t.c.b(al);
        t.d.b(al);
        super.onDestroyView();
    }

    public void onPause()
    {
        super.onPause();
        s();
    }

    public void onResume()
    {
        super.onResume();
        a(g, k, af);
        t();
        if (s)
        {
            Long long1 = AccountManager.c();
            if (L != -1L && (long1 == null || L != long1.longValue()))
            {
                com.perfectcorp.a.b.a(new ap("show", "pageview_me", Long.toString(L)));
            }
            b(V);
        }
    }

}
