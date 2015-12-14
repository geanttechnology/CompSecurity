// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.i;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            h, UICImageView, CircleList, g

public class CirclePager extends FrameLayout
{

    private LayoutInflater a;
    private ViewPager b;
    private h c;
    private LinearLayout d;
    private View e;
    private int f;
    private int g;
    private CreateCircleBtnPos h;
    private long i;
    private String j;
    private boolean k;
    private LinkedHashMap l;
    private TreeSet m;
    private View n;
    private int o;
    private android.support.v4.view.ViewPager.OnPageChangeListener p = new android.support.v4.view.ViewPager.OnPageChangeListener() {

        final CirclePager a;

        public void onPageScrollStateChanged(int i1)
        {
        }

        public void onPageScrolled(int i1, float f1, int j1)
        {
        }

        public void onPageSelected(int i1)
        {
label0:
            {
                Object obj;
label1:
                {
                    if (i1 < CirclePager.l(a).getChildCount())
                    {
                        obj = (Integer)CirclePager.l(a).getTag();
                        if (obj == null)
                        {
                            break label0;
                        }
                        if (((Integer) (obj)).intValue() != i1)
                        {
                            break label1;
                        }
                    }
                    return;
                }
                obj = (ImageView)CirclePager.l(a).getChildAt(((Integer) (obj)).intValue());
                if (obj != null)
                {
                    ((ImageView) (obj)).setImageResource(i.bc_dot_g);
                }
            }
            ImageView imageview = (ImageView)CirclePager.l(a).getChildAt(i1);
            if (imageview != null)
            {
                imageview.setImageResource(i.bc_dot_n);
            }
            CirclePager.l(a).setTag(Integer.valueOf(i1));
        }

            
            {
                a = CirclePager.this;
                super();
            }
    };
    private g q;

    public CirclePager(Context context)
    {
        super(context);
        a = null;
        b = null;
        c = new h(this);
        d = null;
        e = null;
        f = 0;
        g = 0;
        h = CreateCircleBtnPos.a;
        i = -1L;
        j = null;
        k = false;
        l = new LinkedHashMap();
        m = new TreeSet(new Comparator() {

            final CirclePager a;

            public int a(CircleBasic circlebasic, CircleBasic circlebasic1)
            {
                return circlebasic.id.compareTo(circlebasic1.id);
            }

            public int compare(Object obj, Object obj1)
            {
                return a((CircleBasic)obj, (CircleBasic)obj1);
            }

            
            {
                a = CirclePager.this;
                super();
            }
        });
        n = null;
        o = 0;
        q = null;
        a(context);
    }

    public CirclePager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        b = null;
        c = new h(this);
        d = null;
        e = null;
        f = 0;
        g = 0;
        h = CreateCircleBtnPos.a;
        i = -1L;
        j = null;
        k = false;
        l = new LinkedHashMap();
        m = new TreeSet(new _cls1());
        n = null;
        o = 0;
        q = null;
        a(context);
    }

    static int a(CirclePager circlepager, int i1)
    {
        circlepager.f = i1;
        return i1;
    }

    private View a(ViewGroup viewgroup, List list)
    {
        GridLayout gridlayout = (GridLayout)a.inflate(k.bc_view_item_circle_list_page, viewgroup, false);
        if (list != null)
        {
            for (list = list.iterator(); list.hasNext();)
            {
                Object obj = (CircleBasic)list.next();
                if (obj == null)
                {
                    obj = a.inflate(k.bc_view_item_create_circle, gridlayout, false);
                    ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                        final CirclePager a;

                        public void onClick(View view1)
                        {
                            if (com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.d(a) != null)
                            {
                                com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.d(a).a();
                            }
                        }

            
            {
                a = CirclePager.this;
                super();
            }
                    });
                    gridlayout.addView(((View) (obj)));
                } else
                {
                    View view = a.inflate(k.bc_view_item_circle_post, gridlayout, false);
                    view.setTag(obj);
                    view.setOnClickListener(new android.view.View.OnClickListener() {

                        final CirclePager a;

                        public void onClick(View view1)
                        {
                            if (!view1.isSelected())
                            {
                                CirclePager.a(a, view1, (CircleBasic)view1.getTag(), true, true, false);
                                CircleList.a(CirclePager.h(a));
                            }
                        }

            
            {
                a = CirclePager.this;
                super();
            }
                    });
                    TextView textview = (TextView)view.findViewById(j.bc_discover_category_name);
                    if (textview != null)
                    {
                        textview.setText(((CircleBasic) (obj)).circleName);
                    }
                    CircleList.a((UICImageView)view.findViewById(j.bc_discover_category_view), ((CircleBasic) (obj)));
                    gridlayout.addView(view);
                    a(view, ((CircleBasic) (obj)), m.contains(obj), false, false);
                }
            }

        }
        viewgroup.addView(gridlayout);
        return gridlayout;
    }

    static View a(CirclePager circlepager, ViewGroup viewgroup, List list)
    {
        return circlepager.a(viewgroup, list);
    }

    static CreateCircleBtnPos a(CirclePager circlepager)
    {
        return circlepager.h;
    }

    private void a(int i1)
    {
        i1 -= d.getChildCount();
        if (i1 > 0)
        {
            for (; i1 > 0; i1--)
            {
                ImageView imageview = (ImageView)a.inflate(k.bc_view_item_page_indicator, d, false);
                d.addView(imageview);
            }

        } else
        if (i1 < 0)
        {
            d.removeViews(d.getChildCount() + i1, -i1);
        }
    }

    private void a(Context context)
    {
        a = LayoutInflater.from(context);
        context = inflate(getContext(), k.bc_view_circle_pager, this);
        b = (ViewPager)context.findViewById(j.view_pager);
        d = (LinearLayout)context.findViewById(j.page_indicator);
        e = context.findViewById(j.empty_message_text);
        g = ((GridLayout)a.inflate(k.bc_view_item_circle_list_page, b, false)).getColumnCount();
        b.setOnPageChangeListener(p);
        b.setAdapter(c);
    }

    private void a(View view, CircleBasic circlebasic, boolean flag, boolean flag1, boolean flag2)
    {
        if (view != null)
        {
            view.setSelected(flag);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        if (n != null)
        {
            n.setSelected(false);
        }
        n = view;
        m.clear();
        m.add(circlebasic);
        if (flag1 && q != null)
        {
            q.a(m);
        }
        if (flag2) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Iterator iterator = l.entrySet().iterator();
_L5:
        if (!iterator.hasNext()) goto _L1; else goto _L3
_L3:
        Object obj1 = (java.util.Map.Entry)iterator.next();
        Object obj = (Integer)((java.util.Map.Entry) (obj1)).getKey();
        view = ((View) (obj));
        if (obj == null)
        {
            view = Integer.valueOf(0);
        }
        obj = (ArrayList)((java.util.Map.Entry) (obj1)).getValue();
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((ArrayList) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj1 = (CircleBasic)((Iterator) (obj)).next();
        } while (obj1 == null || ((CircleBasic) (obj1)).id != circlebasic.id);
        break; /* Loop/switch isn't completed */
        if (true) goto _L5; else goto _L4
_L4:
        if (b.getCurrentItem() != view.intValue())
        {
            b.setCurrentItem(view.intValue());
            return;
        } else
        {
            p.onPageSelected(view.intValue());
            return;
        }
        m.remove(circlebasic);
        return;
    }

    static void a(CirclePager circlepager, View view, CircleBasic circlebasic, boolean flag, boolean flag1, boolean flag2)
    {
        circlepager.a(view, circlebasic, flag, flag1, flag2);
    }

    static int b(CirclePager circlepager)
    {
        return circlepager.g;
    }

    private void b()
    {
        Long long1 = AccountManager.c();
        if (long1 == null)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "Not logged in"
            });
            if (q != null)
            {
                q.a(32769);
            }
            return;
        }
        if (q != null)
        {
            q.b();
        }
        NetworkCircle.a(long1.longValue(), long1.longValue()).a(new m(long1) {

            final Long a;
            final CirclePager b;
            private final int c = 5000;
            private final int d = 1;
            private int e;

            protected void a()
            {
                a(0x80000005);
            }

            protected void a(int i1)
            {
                if (i1 == 0x80000005) goto _L2; else goto _L1
_L1:
                int j1;
                j1 = e;
                e = j1 + 1;
                if (j1 >= 1) goto _L2; else goto _L3
_L3:
                com.perfectcorp.utility.e.d(new Object[] {
                    "listCircleByUser retry: code=", Integer.valueOf(i1), ", retryCount=", Integer.valueOf(e), ", retryInterval=", Integer.valueOf(5000)
                });
                b.postDelayed(new Runnable(this, this) {

                    final m a;
                    final _cls2 b;

                    public void run()
                    {
                        NetworkCircle.a(b.a.longValue(), b.a.longValue()).a(a);
                    }

            
            {
                b = _pcls2;
                a = m1;
                super();
            }
                }, 5000L);
_L5:
                return;
_L2:
                if (com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.d(b) != null)
                {
                    com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.d(b).c();
                    com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.d(b).a(i1);
                    return;
                }
                if (true) goto _L5; else goto _L4
_L4:
            }

            protected void a(d d1)
            {
                if (d1 != null && d1.b != null) goto _L2; else goto _L1
_L1:
                a(0x80000003);
_L8:
                return;
_L2:
                Iterator iterator = d1.b.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    CircleBasic circlebasic1 = (CircleBasic)iterator.next();
                    if (circlebasic1 != null && "HOW-TO".equals(circlebasic1.defaultType))
                    {
                        iterator.remove();
                        Integer integer = d1.a;
                        d1.a = Integer.valueOf(d1.a.intValue() - 1);
                    }
                } while (true);
                CirclePager.a(b, d1.a.intValue());
                if (CirclePager.a(b) != CreateCircleBtnPos.b) goto _L4; else goto _L3
_L3:
                d1.b.add(0, null);
_L6:
                int k1 = CirclePager.b(b) * 2;
                int j1 = 0;
                for (int i1 = 0; j1 < d1.b.size(); i1++)
                {
                    CirclePager.c(b).put(Integer.valueOf(i1), new ArrayList(d1.b.subList(j1, Math.min(j1 + k1, d1.b.size()))));
                    j1 += k1;
                }

                break; /* Loop/switch isn't completed */
_L4:
                if (CirclePager.a(b) == CreateCircleBtnPos.c)
                {
                    d1.b.add(null);
                }
                if (true) goto _L6; else goto _L5
_L5:
                if (com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.d(b) != null)
                {
                    com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.d(b).c();
                }
                if (com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.e(b))
                {
                    CirclePager.f(b);
                    CirclePager.g(b).onPageSelected(0);
                    return;
                }
                CirclePager.h(b).clear();
                if (com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.i(b) == null && com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.j(b) == -1L)
                {
                    continue; /* Loop/switch isn't completed */
                }
                Iterator iterator1 = d1.b.iterator();
                CircleBasic circlebasic = null;
                CircleBasic circlebasic2 = null;
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    CircleBasic circlebasic3 = (CircleBasic)iterator1.next();
                    if (circlebasic3 != null)
                    {
                        if (com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.i(b) != null && circlebasic3.defaultType != null && com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.i(b).equals(circlebasic3.defaultType))
                        {
                            circlebasic2 = circlebasic3;
                        } else
                        if (circlebasic3.id.equals(Long.valueOf(com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.j(b))))
                        {
                            com.perfectcorp.utility.e.b(new Object[] {
                                "set default: ", circlebasic3.id
                            });
                            circlebasic = circlebasic3;
                        }
                    }
                } while (true);
                if (circlebasic2 != null)
                {
                    circlebasic = circlebasic2;
                } else
                if (circlebasic == null)
                {
                    circlebasic = null;
                }
                if (circlebasic != null)
                {
                    CirclePager.f(b);
                    CirclePager.a(b, null, circlebasic, true, true, true);
                }
                if (!CirclePager.h(b).isEmpty()) goto _L8; else goto _L7
_L7:
                CircleList.a().a(new m(this, d1) {

                    final d a;
                    final _cls2 b;

                    protected void a(ArrayList arraylist)
                    {
                        Iterator iterator = a.b.iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            CircleBasic circlebasic1 = (CircleBasic)iterator.next();
                            if (circlebasic1 == null || !arraylist.contains(circlebasic1.id))
                            {
                                continue;
                            }
                            com.perfectcorp.utility.e.b(new Object[] {
                                "set default: ", circlebasic1.id
                            });
                            CirclePager.f(b.b);
                            CirclePager.a(b.b, null, circlebasic1, true, true, true);
                            break;
                        } while (true);
                        if (CirclePager.h(b.b).isEmpty() && a.b.size() > 1)
                        {
                            arraylist = a.b.iterator();
                            do
                            {
                                if (!arraylist.hasNext())
                                {
                                    break;
                                }
                                CircleBasic circlebasic = (CircleBasic)arraylist.next();
                                if (circlebasic == null || circlebasic.id.longValue() == -1L)
                                {
                                    continue;
                                }
                                com.perfectcorp.utility.e.b(new Object[] {
                                    "set default: ", circlebasic.id
                                });
                                CirclePager.f(b.b);
                                CirclePager.a(b.b, null, circlebasic, true, true, true);
                                break;
                            } while (true);
                            return;
                        } else
                        {
                            CirclePager.f(b.b);
                            return;
                        }
                    }

                    protected void b(Object obj)
                    {
                        a((ArrayList)obj);
                    }

            
            {
                b = _pcls2;
                a = d1;
                super();
            }
                });
                return;
            }

            protected void b(Object obj)
            {
                a((d)obj);
            }

            
            {
                b = CirclePager.this;
                a = long1;
                super();
                e = 0;
            }
        });
    }

    static LinkedHashMap c(CirclePager circlepager)
    {
        return circlepager.l;
    }

    private void c()
    {
        boolean flag = false;
        int j1 = g * 2;
        int i1;
        if (h == CreateCircleBtnPos.a)
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        o = (f + i1) / j1;
        if ((i1 + f) % j1 > 0)
        {
            o = o + 1;
        }
        if (d.getChildCount() != o)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                Integer.valueOf(o)
            });
            a(o);
        }
        c.notifyDataSetChanged();
        if (e != null)
        {
            if (o == 0)
            {
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = 8;
            }
            e.setVisibility(i1);
        }
    }

    static g d(CirclePager circlepager)
    {
        return circlepager.q;
    }

    static boolean e(CirclePager circlepager)
    {
        return circlepager.k;
    }

    static void f(CirclePager circlepager)
    {
        circlepager.c();
    }

    static android.support.v4.view.ViewPager.OnPageChangeListener g(CirclePager circlepager)
    {
        return circlepager.p;
    }

    static TreeSet h(CirclePager circlepager)
    {
        return circlepager.m;
    }

    static String i(CirclePager circlepager)
    {
        return circlepager.j;
    }

    static long j(CirclePager circlepager)
    {
        return circlepager.i;
    }

    static int k(CirclePager circlepager)
    {
        return circlepager.o;
    }

    static LinearLayout l(CirclePager circlepager)
    {
        return circlepager.d;
    }

    public void a()
    {
        l.clear();
        b();
    }

    public TreeSet getSelectedCircles()
    {
        return m;
    }

    public void setCreateCircleBtnPos(CreateCircleBtnPos createcirclebtnpos)
    {
        h = createcirclebtnpos;
    }

    public void setDefaultCircleId(long l1)
    {
        i = l1;
    }

    public void setDefaultCircleType(String s)
    {
        if (s == null || s.isEmpty())
        {
            j = null;
            return;
        } else
        {
            j = s;
            return;
        }
    }

    public void setEventListener(g g1)
    {
        q = g1;
    }

    public void setPickMode(boolean flag)
    {
        k = flag;
    }

    private class CreateCircleBtnPos extends Enum
    {

        public static final CreateCircleBtnPos a;
        public static final CreateCircleBtnPos b;
        public static final CreateCircleBtnPos c;
        private static final CreateCircleBtnPos d[];

        public static CreateCircleBtnPos valueOf(String s)
        {
            return (CreateCircleBtnPos)Enum.valueOf(com/cyberlink/beautycircle/view/widgetpool/common/CirclePager$CreateCircleBtnPos, s);
        }

        public static CreateCircleBtnPos[] values()
        {
            return (CreateCircleBtnPos[])d.clone();
        }

        static 
        {
            a = new CreateCircleBtnPos("None", 0);
            b = new CreateCircleBtnPos("FirstItem", 1);
            c = new CreateCircleBtnPos("LastItem", 2);
            d = (new CreateCircleBtnPos[] {
                a, b, c
            });
        }

        private CreateCircleBtnPos(String s, int i1)
        {
            super(s, i1);
        }
    }

}
