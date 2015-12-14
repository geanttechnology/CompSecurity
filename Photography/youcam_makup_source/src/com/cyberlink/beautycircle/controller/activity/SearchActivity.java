// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseArcMenuActivity;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.adapter.n;
import com.cyberlink.beautycircle.controller.adapter.w;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.f;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkSearch;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.a;
import com.cyberlink.beautycircle.view.widgetpool.common.BiDirectionSwipeRefreshLayout;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.d;
import com.huewu.pla.lib.internal.q;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            o, s, p, q, 
//            t

public class SearchActivity extends BaseArcMenuActivity
{

    private static final int t;
    private static final int u;
    private static final int v;
    private static final int w;
    private static final int x;
    private boolean A;
    private CLMultiColumnListView B;
    private com.cyberlink.beautycircle.controller.activity.q C;
    private p D;
    private View E;
    private LinearLayout F;
    private View G;
    private BiDirectionSwipeRefreshLayout H;
    private TextView I;
    private View J;
    private View K;
    private View L;
    private View M;
    private TextView N;
    private TextView O;
    private TextView P;
    private View Q;
    private EditText R;
    private TopBarFragment S;
    private boolean T;
    private boolean U;
    private final s V = new s() {

        final SearchActivity a;

        protected void a()
        {
        }

        protected void a(String s1)
        {
            super.a(s1);
            s1 = NetworkSearch.a();
            s1.a(new t(this, "listTopPostKeyword", false));
            a.o = s1;
        }

        protected void b()
        {
        }

        protected void b(String s1)
        {
        }

            
            {
                a = SearchActivity.this;
                super(SearchActivity.this);
                b = m.bc_search_header_trending;
                c = m.bc_search_header_trending;
                d = m.bc_search_hint;
            }
    };
    private final s W = new s() {

        final SearchActivity a;

        protected void a()
        {
            c("Post");
        }

        protected void a(String s1)
        {
            super.a(s1);
            s1 = NetworkSearch.b(s1);
            s1.a(new t(this, "listPostKeywordSuggestion", false));
            a.o = s1;
        }

        protected void b()
        {
            d("Post");
        }

        protected void b(String s1)
        {
            a("Post", s1);
            com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a).a(com.cyberlink.beautycircle.a.a());
            com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a, new p(a, a, com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a), k.bc_view_item_discover_list, s1, com.cyberlink.beautycircle.controller.activity.SearchActivity.g(a)));
            SearchActivity.h(a).c();
        }

            
            {
                a = SearchActivity.this;
                super(SearchActivity.this);
                b = m.bc_search_header_recent_posts;
                c = m.bc_search_suggestions_posts;
                d = m.bc_search_hint_posts;
            }
    };
    private final s X = new s() {

        final SearchActivity a;

        protected void a()
        {
            c("User");
        }

        protected void a(String s1)
        {
            super.a(s1);
            s1 = NetworkSearch.a(s1, AccountManager.c());
            s1.a(new t(this, "listPeopleSuggestion", false));
            a.o = s1;
        }

        protected void b()
        {
            d("User");
        }

        protected void b(String s1)
        {
            a("User", s1);
            com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a).a(1);
            Object obj = AccountManager.c();
            SearchActivity searchactivity = a;
            CLMultiColumnListView clmulticolumnlistview = com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a);
            int i1 = k.bc_view_item_search_result;
            long l1;
            if (obj != null)
            {
                l1 = ((Long) (obj)).longValue();
            } else
            {
                l1 = -1L;
            }
            obj = new w(searchactivity, clmulticolumnlistview, i1, l1, -1L, com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.d, com.cyberlink.beautycircle.controller.activity.SearchActivity.g(a), null);
            ((w) (obj)).a(s1);
            ((w) (obj)).c();
        }

            
            {
                a = SearchActivity.this;
                super(SearchActivity.this);
                b = m.bc_search_header_recent_people;
                c = m.bc_search_suggestions_people;
                d = m.bc_search_hint_people;
            }
    };
    private final s Y = new s() {

        final SearchActivity a;

        protected void a()
        {
            c("Circle");
        }

        protected void a(String s1)
        {
            super.a(s1);
            s1 = NetworkSearch.a(s1);
            s1.a(new t(this, "listCircleSuggestion", false));
            a.o = s1;
        }

        protected void b()
        {
            d("Circle");
        }

        protected void b(String s1)
        {
            a("Circle", s1);
            com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a).a(com.cyberlink.beautycircle.a.b());
            Object obj = AccountManager.c();
            SearchActivity searchactivity = a;
            CLMultiColumnListView clmulticolumnlistview = com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a);
            long l1;
            if (obj != null)
            {
                l1 = ((Long) (obj)).longValue();
            } else
            {
                l1 = -1L;
            }
            obj = new com.cyberlink.beautycircle.controller.adapter.c(searchactivity, clmulticolumnlistview, l1, 3, com.cyberlink.beautycircle.controller.activity.SearchActivity.g(a));
            ((com.cyberlink.beautycircle.controller.adapter.c) (obj)).a(s1);
            ((com.cyberlink.beautycircle.controller.adapter.c) (obj)).c();
        }

            
            {
                a = SearchActivity.this;
                super(SearchActivity.this);
                b = m.bc_search_header_recent_circles;
                c = m.bc_search_suggestions_circles;
                d = m.bc_search_hint_circles;
            }
    };
    private android.view.View.OnClickListener Z;
    private android.view.View.OnClickListener aa;
    private s ab;
    private android.view.View.OnClickListener ac;
    private d ad;
    private android.view.View.OnClickListener ae;
    private a af;
    private o ag;
    private Runnable ah;
    private ArrayList ai;
    private n aj;
    protected com.perfectcorp.utility.j o;
    protected com.perfectcorp.utility.j p;
    protected com.perfectcorp.utility.j q;
    protected com.perfectcorp.utility.j r;
    protected android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener s;
    private SearchActivityState y;
    private LayoutInflater z;

    public SearchActivity()
    {
        y = new SearchActivityState();
        z = null;
        A = false;
        B = null;
        C = null;
        D = null;
        E = null;
        F = null;
        G = null;
        H = null;
        I = null;
        J = null;
        K = null;
        L = null;
        M = null;
        N = null;
        O = null;
        P = null;
        Q = null;
        R = null;
        S = null;
        o = null;
        p = null;
        q = null;
        r = null;
        T = false;
        U = false;
        Z = new android.view.View.OnClickListener() {

            final SearchActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.controller.activity.SearchActivity.c(a).setVisibility(0);
                SearchActivity.l(a).c(true);
                com.cyberlink.beautycircle.controller.activity.SearchActivity.m(a).setVisibility(8);
                com.cyberlink.beautycircle.controller.activity.SearchActivity.d(a).setVisibility(0);
                com.cyberlink.beautycircle.controller.activity.SearchActivity.d(a).requestFocus();
                a.showSoftInput(com.cyberlink.beautycircle.controller.activity.SearchActivity.d(a));
                if (com.cyberlink.beautycircle.controller.activity.SearchActivity.d(a) != null && com.cyberlink.beautycircle.controller.activity.SearchActivity.n(a) != null && com.cyberlink.beautycircle.controller.activity.SearchActivity.d(a).getText().toString().length() > 0)
                {
                    com.cyberlink.beautycircle.controller.activity.SearchActivity.n(a).a(true);
                }
                com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a).a(1);
                com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a).setAdapter(SearchActivity.b(a));
                com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a).setOnItemClickListener(SearchActivity.b(a));
                SearchActivity.o(a);
                SearchActivity.b(a).clear();
                SearchActivity.b(a).notifyDataSetChanged();
            }

            
            {
                a = SearchActivity.this;
                super();
            }
        };
        aa = new android.view.View.OnClickListener() {

            final SearchActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a, view, true);
            }

            
            {
                a = SearchActivity.this;
                super();
            }
        };
        ab = null;
        ac = new android.view.View.OnClickListener() {

            final SearchActivity a;

            public void onClick(View view)
            {
                if (SearchActivity.b(a) != null)
                {
                    SearchActivity.b(a).a(true, false);
                }
            }

            
            {
                a = SearchActivity.this;
                super();
            }
        };
        ad = new d() {

            final SearchActivity a;
            private boolean b;

            public void a(PLA_AbsListView pla_abslistview, int i1)
            {
                if (i1 == 0)
                {
                    b = false;
                    return;
                } else
                {
                    b = true;
                    return;
                }
            }

            public void a(PLA_AbsListView pla_abslistview, int i1, int j1, int k1)
            {
                boolean flag;
                for (flag = false; !b || j1 <= 0 || SearchActivity.r(a) == null;)
                {
                    return;
                }

                if (i1 == 0)
                {
                    com.cyberlink.beautycircle.controller.activity.SearchActivity.c(a, false);
                } else
                {
                    flag = true;
                }
                SearchActivity.b(a, SearchActivity.r(a), flag);
            }

            
            {
                a = SearchActivity.this;
                super();
                b = false;
            }
        };
        ae = new android.view.View.OnClickListener() {

            final SearchActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a) != null)
                {
                    int i1 = com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a).getFirstVisiblePosition();
                    com.cyberlink.beautycircle.controller.activity.SearchActivity.c(a, true);
                    if (i1 > 4)
                    {
                        com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a).setSelection(4);
                    }
                    com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a).h(0);
                    com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a).postDelayed(new Runnable(this) {

                        final _cls3 a;

                        public void run()
                        {
                            com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a.a).setSelection(0);
                        }

            
            {
                a = _pcls3;
                super();
            }
                    }, 300L);
                }
            }

            
            {
                a = SearchActivity.this;
                super();
            }
        };
        af = new a() {

            final SearchActivity a;

            public void a(UserInfo userinfo)
            {
                com.perfectcorp.utility.e.b(new Object[0]);
                com.cyberlink.beautycircle.controller.activity.SearchActivity.d(a, true);
            }

            
            {
                a = SearchActivity.this;
                super();
            }
        };
        ag = new o(this);
        ah = new Runnable() {

            final SearchActivity a;

            public void run()
            {
                if (SearchActivity.b(a) == null)
                {
                    return;
                }
                String s1 = com.cyberlink.beautycircle.controller.activity.SearchActivity.d(a).getText().toString().trim();
                com.perfectcorp.utility.e.b(new Object[] {
                    "[QuerySearchSuggestionListRun][", s1, "]"
                });
                if (s1.isEmpty())
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "[QuerySearchSuggestionListRun] Empty; show history."
                    });
                    SearchActivity.s(a).a();
                    return;
                }
                if (s1.length() <= 1)
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "[QuerySearchSuggestionListRun] Length less than ", Integer.valueOf(1), "; Leave the suggestion list untouched."
                    });
                    return;
                } else
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "[QuerySearchSuggestionListRun] querySuggestionList"
                    });
                    SearchActivity.s(a).a(s1);
                    return;
                }
            }

            
            {
                a = SearchActivity.this;
                super();
            }
        };
        ai = new ArrayList();
        aj = new n() {

            final SearchActivity a;

            public void a()
            {
                com.perfectcorp.utility.e.b(new Object[0]);
                a.runOnUiThread(new Runnable(this) {

                    final _cls7 a;

                    public void run()
                    {
                        SearchActivity.b(a.a).b();
                        com.cyberlink.beautycircle.controller.activity.SearchActivity.f(a.a).setRefreshing(false);
                    }

            
            {
                a = _pcls7;
                super();
            }
                });
            }

            public void a(int i1)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    Integer.valueOf(i1)
                });
            }

            public void a(Post post)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    post
                });
                if (post == null)
                {
                    return;
                } else
                {
                    a.a(post);
                    return;
                }
            }

            public void a(boolean flag)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    Boolean.valueOf(flag)
                });
                com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a, flag);
            }

            public void b(boolean flag)
            {
                com.perfectcorp.utility.e.b(new Object[] {
                    Boolean.valueOf(flag)
                });
            }

            
            {
                a = SearchActivity.this;
                super();
            }
        };
        s = new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final SearchActivity a;

            public void onRefresh()
            {
                Object obj;
label0:
                {
                    String s1;
label1:
                    {
                        if (!SearchActivity.p(a).isEmpty())
                        {
                            break label0;
                        }
                        if (com.cyberlink.beautycircle.controller.activity.SearchActivity.d(a) != null)
                        {
                            com.cyberlink.beautycircle.controller.activity.SearchActivity.d(a).setHint(SearchActivity.s(a).d);
                            s1 = com.cyberlink.beautycircle.controller.activity.SearchActivity.d(a).getText().toString();
                            if (s1.length() > 0)
                            {
                                break label1;
                            }
                            SearchActivity.s(a).a();
                        }
                        return;
                    }
                    SearchActivity.s(a).a(s1);
                    return;
                }
                obj = com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a).getAdapter();
                if (!(obj instanceof q)) goto _L2; else goto _L1
_L1:
                android.widget.ListAdapter listadapter;
                obj = (q)obj;
                listadapter = ((q) (obj)).getWrappedAdapter();
                if (!(listadapter instanceof com.cyberlink.beautycircle.controller.adapter.m)) goto _L4; else goto _L3
_L3:
                obj = (com.cyberlink.beautycircle.controller.adapter.m)((q) (obj)).getWrappedAdapter();
_L5:
                if (obj != null)
                {
                    SearchActivity.b(a).a();
                    ((com.cyberlink.beautycircle.controller.adapter.m) (obj)).c();
                    return;
                } else
                {
                    com.cyberlink.beautycircle.controller.activity.SearchActivity.f(a).setRefreshing(false);
                    return;
                }
_L4:
                com.perfectcorp.utility.e.e(new Object[] {
                    "Unexpected adapter class: ", listadapter.getClass()
                });
_L6:
                obj = null;
                  goto _L5
_L2:
label2:
                {
                    if (!obj.getClass().isAssignableFrom(com/cyberlink/beautycircle/controller/adapter/m))
                    {
                        break label2;
                    }
                    obj = (com.cyberlink.beautycircle.controller.adapter.m)obj;
                }
                  goto _L5
                com.perfectcorp.utility.e.e(new Object[] {
                    "Unexpected adapter class: ", obj.getClass()
                });
                  goto _L6
            }

            
            {
                a = SearchActivity.this;
                super();
            }
        };
    }

    private void A()
    {
        com.perfectcorp.utility.e.b(new Object[0]);
        a(false);
        R.setText(TextUtils.join(" ", ai));
        ai.clear();
        R.setSelection(R.length());
        ab.a(R.getText().toString());
    }

    static p a(SearchActivity searchactivity, p p1)
    {
        searchactivity.D = p1;
        return p1;
    }

    static CLMultiColumnListView a(SearchActivity searchactivity)
    {
        return searchactivity.B;
    }

    static void a(SearchActivity searchactivity, View view, boolean flag)
    {
        searchactivity.b(view, flag);
    }

    static void a(SearchActivity searchactivity, boolean flag)
    {
        searchactivity.a(flag);
    }

    private void a(boolean flag)
    {
        if (I != null)
        {
            I.post(new Runnable(flag) {

                final boolean a;
                final SearchActivity b;

                public void run()
                {
                    if (a)
                    {
                        String s1 = b.getResources().getString(m.bc_search_empty_message, new Object[] {
                            TextUtils.join(" ", SearchActivity.p(b))
                        });
                        com.cyberlink.beautycircle.controller.activity.SearchActivity.q(b).setText(s1);
                    } else
                    {
                        com.cyberlink.beautycircle.controller.activity.SearchActivity.q(b).setText("");
                    }
                    SearchActivity.b(b, a);
                }

            
            {
                b = SearchActivity.this;
                a = flag;
                super();
            }
            });
        }
    }

    static com.cyberlink.beautycircle.controller.activity.q b(SearchActivity searchactivity)
    {
        return searchactivity.C;
    }

    private void b(View view, boolean flag)
    {
label0:
        {
            Object obj;
label1:
            {
                obj = (ViewGroup)view.getParent();
                int j1 = ((ViewGroup) (obj)).getChildCount();
                for (int i1 = 0; i1 < j1; i1++)
                {
                    View view1 = ((ViewGroup) (obj)).getChildAt(i1);
                    if (view1 != view)
                    {
                        view1.setSelected(false);
                    }
                }

                view.setSelected(true);
                ab = (s)view.getTag();
                Q.animate().cancel();
                Q.setPivotX(0.0F);
                float f1 = (float)view.getWidth() / (float)Q.getWidth();
                float f2 = view.getLeft();
                if (flag)
                {
                    Q.animate().scaleX(f1).translationX(f2).setDuration(300L).start();
                } else
                {
                    Q.setScaleX(f1);
                    Q.setTranslationX(f2);
                }
                view = (s)view.getTag();
                if (!ai.isEmpty())
                {
                    break label0;
                }
                if (R != null)
                {
                    R.setHint(((s) (view)).d);
                    obj = R.getText().toString();
                    if (((String) (obj)).length() > 0)
                    {
                        break label1;
                    }
                    view.a();
                }
                return;
            }
            view.a(((String) (obj)));
            return;
        }
        f(TextUtils.join(" ", ai));
    }

    static void b(SearchActivity searchactivity, View view, boolean flag)
    {
        searchactivity.c(view, flag);
    }

    static void b(SearchActivity searchactivity, boolean flag)
    {
        searchactivity.b(flag);
    }

    private void b(boolean flag)
    {
        boolean flag1 = false;
        if (G != null)
        {
            Object obj = G;
            int i1;
            if (flag)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            ((View) (obj)).setVisibility(i1);
        }
        if (H != null)
        {
            obj = H;
            i1 = ((flag1) ? 1 : 0);
            if (flag)
            {
                i1 = 4;
            }
            ((BiDirectionSwipeRefreshLayout) (obj)).setVisibility(i1);
        }
    }

    static View c(SearchActivity searchactivity)
    {
        return searchactivity.M;
    }

    private void c(View view, boolean flag)
    {
        if (T)
        {
            flag = false;
        }
        if (flag)
        {
            if (view.getVisibility() != 0)
            {
                view.setVisibility(0);
                ObjectAnimator.ofFloat(view, "alpha", new float[] {
                    0.0F, 1.0F
                }).setDuration(300L).start();
            }
        } else
        if (view.getVisibility() != 4)
        {
            view.setVisibility(4);
            return;
        }
    }

    static boolean c(SearchActivity searchactivity, boolean flag)
    {
        searchactivity.T = flag;
        return flag;
    }

    static EditText d(SearchActivity searchactivity)
    {
        return searchactivity.R;
    }

    static boolean d(SearchActivity searchactivity, boolean flag)
    {
        searchactivity.U = flag;
        return flag;
    }

    static LayoutInflater e(SearchActivity searchactivity)
    {
        return searchactivity.z;
    }

    static BiDirectionSwipeRefreshLayout f(SearchActivity searchactivity)
    {
        return searchactivity.H;
    }

    private void f(String s1)
    {
        ab.b(s1);
    }

    static n g(SearchActivity searchactivity)
    {
        return searchactivity.aj;
    }

    static p h(SearchActivity searchactivity)
    {
        return searchactivity.D;
    }

    static boolean i(SearchActivity searchactivity)
    {
        return searchactivity.A;
    }

    static View j(SearchActivity searchactivity)
    {
        return searchactivity.Q;
    }

    static TextView k(SearchActivity searchactivity)
    {
        return searchactivity.N;
    }

    static TopBarFragment l(SearchActivity searchactivity)
    {
        return searchactivity.S;
    }

    static View m(SearchActivity searchactivity)
    {
        return searchactivity.E;
    }

    static o n(SearchActivity searchactivity)
    {
        return searchactivity.ag;
    }

    static void o(SearchActivity searchactivity)
    {
        searchactivity.A();
    }

    static ArrayList p(SearchActivity searchactivity)
    {
        return searchactivity.ai;
    }

    static TextView q(SearchActivity searchactivity)
    {
        return searchactivity.I;
    }

    static View r(SearchActivity searchactivity)
    {
        return searchactivity.K;
    }

    static s s(SearchActivity searchactivity)
    {
        return searchactivity.ab;
    }

    static s t(SearchActivity searchactivity)
    {
        return searchactivity.V;
    }

    static int u()
    {
        return t;
    }

    static SearchActivityState u(SearchActivity searchactivity)
    {
        return searchactivity.y;
    }

    static int v()
    {
        return u;
    }

    static Runnable v(SearchActivity searchactivity)
    {
        return searchactivity.ah;
    }

    static int w()
    {
        return v;
    }

    static LinearLayout w(SearchActivity searchactivity)
    {
        return searchactivity.F;
    }

    static int x()
    {
        return w;
    }

    static void x(SearchActivity searchactivity)
    {
        searchactivity.z();
    }

    static int y()
    {
        return x;
    }

    private void z()
    {
        com.perfectcorp.utility.e.b(new Object[0]);
        R.removeCallbacks(ah);
        S.c(false);
        E.setVisibility(0);
        R.setVisibility(8);
        F.removeAllViews();
        for (int i1 = 0; i1 < ai.size(); i1++)
        {
            String s1 = (String)ai.get(i1);
            View view = z.inflate(k.bc_view_item_search_text_bubble, F, false);
            view.setTag(s1);
            ((TextView)view.findViewById(j.bubble_text)).setText(s1);
            view.findViewById(j.close_btn).setOnClickListener(new android.view.View.OnClickListener() {

                final SearchActivity a;

                public void onClick(View view1)
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        view1.getTag()
                    });
                    com.cyberlink.beautycircle.controller.activity.SearchActivity.w(a).removeView((View)view1.getParent());
                    com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a).requestFocus();
                    SearchActivity.p(a).clear();
                    for (int j1 = 0; j1 < com.cyberlink.beautycircle.controller.activity.SearchActivity.w(a).getChildCount(); j1++)
                    {
                        view1 = com.cyberlink.beautycircle.controller.activity.SearchActivity.w(a).getChildAt(j1);
                        SearchActivity.p(a).add((String)view1.getTag());
                    }

                    com.perfectcorp.utility.e.b(new Object[] {
                        SearchActivity.p(a)
                    });
                    if (SearchActivity.p(a).isEmpty())
                    {
                        SearchActivity.l(a).c(true);
                        com.cyberlink.beautycircle.controller.activity.SearchActivity.d(a).setText(null);
                        SearchActivity.s(a).a();
                        return;
                    } else
                    {
                        SearchActivity.x(a);
                        return;
                    }
                }

            
            {
                a = SearchActivity.this;
                super();
            }
            });
            F.addView(view);
        }

        f(TextUtils.join(" ", ai));
    }

    public void a(View view, boolean flag)
    {
        com.perfectcorp.utility.e.b(new Object[] {
            Boolean.valueOf(flag)
        });
        if (y.isLanding && flag)
        {
            B.requestFocus();
            com.cyberlink.beautycircle.c.a(this, false, null, A);
        }
    }

    public void c(String s1)
    {
        if (s1 != null && !s1.isEmpty())
        {
            com.perfectcorp.utility.e.b(new Object[] {
                s1
            });
            if (ab != null)
            {
                ai.clear();
                s1 = s1.split(" ");
                int j1 = s1.length;
                int i1 = 0;
                while (i1 < j1) 
                {
                    String s2 = s1[i1].trim();
                    if (!s2.isEmpty())
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            "[", s2, "]"
                        });
                        ai.add(s2);
                    }
                    i1++;
                }
                z();
                if (ag != null)
                {
                    ag.a(false);
                    return;
                }
            }
        }
    }

    protected boolean e()
    {
        super.e();
        finish();
        overridePendingTransition(f.bc_slide_in_left, f.bc_slide_out_right);
        return true;
    }

    public void g()
    {
        if (S != null)
        {
            S.c(true);
        }
        if (E != null)
        {
            E.setVisibility(8);
        }
        if (R != null)
        {
            R.setVisibility(0);
            R.setText("");
            R.requestFocus();
            R.setSelection(0);
        }
        showSoftInput(R);
        ab.a();
    }

    public void h()
    {
        if (y.isLanding)
        {
            B.requestFocus();
            com.cyberlink.beautycircle.c.a(this, false, null, A);
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "requestCode: ", String.valueOf(i1), ", resultCode: ", String.valueOf(j1), ", data: ", intent
        });
        super.onActivityResult(i1, j1, intent);
        i1;
        JVM INSTR lookupswitch 2: default 80
    //                   48148: 81
    //                   48165: 96;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (D != null)
        {
            D.notifyDataSetChanged();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j1 == -1)
        {
            setResult(j1, intent);
            finish();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_search);
        z = (LayoutInflater)getSystemService("layout_inflater");
        if (bundle != null)
        {
            y = (SearchActivityState)Model.a(y.getClass(), bundle.getString(y.getClass().getSimpleName()));
        }
        Intent intent = getIntent();
        String s1;
        if (intent != null)
        {
            y.isLanding = intent.getBooleanExtra("IsSearchLanding", false);
            s1 = intent.getStringExtra("SearchKeyword");
            A = intent.getBooleanExtra("ForShare", false);
        } else
        {
            s1 = null;
        }
        c();
        S = b();
        R = (EditText)S.a(true, true);
        R.setTypeface(Typeface.DEFAULT_BOLD);
        R.setHint(m.bc_search_hint);
        R.setOnClickListener(ac);
        G = findViewById(j.empty_layout);
        if (G != null)
        {
            I = (TextView)G.findViewById(j.error_message_text);
            J = G.findViewById(j.error_icon);
            if (J != null)
            {
                J.setVisibility(8);
            }
        }
        B = (CLMultiColumnListView)findViewById(j.search_suggestion_list);
        B.setOnScrollListener(ad);
        H = (BiDirectionSwipeRefreshLayout)findViewById(j.normal_layout);
        if (H != null)
        {
            H.setOnRefreshListener(s);
            H.setColorSchemeResources(new int[] {
                g.bc_color_main_style, g.bc_color_main_style, g.bc_color_main_style, g.bc_color_main_style
            });
        }
        a(false);
        if (y.isLanding)
        {
            C = new com.cyberlink.beautycircle.controller.activity.q(this, B);
            R.setHint(V.d);
            ab = V;
            V.a(null);
            H.setEnabled(false);
        } else
        {
            Object obj = (ViewGroup)R.getParent();
            E = z.inflate(k.bc_view_search_bubble_container, ((ViewGroup) (obj)), false);
            F = (LinearLayout)E.findViewById(j.bubble_container);
            F.setOnClickListener(Z);
            ((ViewGroup) (obj)).addView(E);
            ((ViewGroup) (obj)).setOnClickListener(Z);
            obj = z.inflate(k.bc_view_item_search_header_tabbar, B, false);
            M = ((View) (obj)).findViewById(j.tab_bar);
            B.c(((View) (obj)));
            C = new com.cyberlink.beautycircle.controller.activity.q(this, B);
            S.a();
            N = (TextView)M.findViewById(j.search_tab_posts);
            N.setOnClickListener(aa);
            N.setTag(W);
            O = (TextView)M.findViewById(j.search_tab_people);
            O.setOnClickListener(aa);
            O.setTag(X);
            P = (TextView)M.findViewById(j.search_tab_circles);
            P.setOnClickListener(aa);
            P.setTag(Y);
            Q = M.findViewById(j.search_tab_indicator);
            Q.setTag(s1);
            Q.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() {

                final SearchActivity a;

                public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                        int k2, int l2)
                {
                    com.cyberlink.beautycircle.controller.activity.SearchActivity.j(a).removeOnLayoutChangeListener(this);
                    com.cyberlink.beautycircle.controller.activity.SearchActivity.a(a, com.cyberlink.beautycircle.controller.activity.SearchActivity.k(a), false);
                    view = (String)view.getTag();
                    if (view != null)
                    {
                        a.c(view);
                    }
                }

            
            {
                a = SearchActivity.this;
                super();
            }
            });
            R.requestFocus();
            R.addTextChangedListener(ag);
        }
        K = findViewById(j.to_top_btn);
        if (K != null)
        {
            K.setOnClickListener(ae);
        }
        L = findViewById(j.create_post_btn);
        if (L != null)
        {
            L.setVisibility(8);
        }
        b(bundle);
        AccountManager.a(af);
    }

    protected void onResume()
    {
label0:
        {
            com.perfectcorp.utility.e.c(new Object[0]);
            super.onResume();
            if (U)
            {
                U = false;
                if (!y.isLanding)
                {
                    break label0;
                }
            }
            return;
        }
        if (!ai.isEmpty())
        {
            ab.b(TextUtils.join(" ", ai));
            return;
        }
        if (R.getText().length() == 0)
        {
            ab.a();
            return;
        } else
        {
            ab.a(R.getText().toString());
            return;
        }
    }

    public void onRightBtnClick(View view)
    {
        e();
    }

    public void q()
    {
        if (D != null)
        {
            D.notifyDataSetChanged();
        }
    }

    static 
    {
        t = k.bc_view_item_search_suggestion;
        u = k.bc_view_item_search_result;
        v = k.bc_view_item_search_result;
        w = k.bc_view_item_search_header_suggestion;
        x = k.bc_view_waiting_panel;
    }

    private class SearchActivityState extends Model
    {

        public boolean isLanding;

        public SearchActivityState()
        {
            isLanding = true;
        }
    }

}
