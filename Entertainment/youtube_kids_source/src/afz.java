// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.Space;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class afz extends BaseAdapter
{

    public List a;
    public int b;
    public eyz c;
    public String d;
    private final blu e;
    private final bqe f;
    private final afv g;
    private final Context h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private afc o;
    private aev p;
    private afh q;
    private afr r;

    public afz(Context context, blu blu1, bqe bqe1, afv afv1, int i1, int j1, int k1, 
            int l1, int i2, int j2, eyz eyz, bov bov, bxe bxe)
    {
        a = new ArrayList();
        e = (blu)b.a(blu1);
        f = (bqe)b.a(bqe1);
        g = afv1;
        h = context;
        i = i1;
        j = j1;
        k = k1;
        l = l1;
        m = i2;
        n = j2;
        b = -1;
        c = eyz;
        o = new afc((Activity)context, bqe1, blu1, bov, bxe);
        p = new aev((Activity)context, bqe1, blu1, bov, bxe);
        q = new afh((Activity)context, bqe1, blu1, bov, bxe);
        r = new afr((Activity)context, bqe1, blu1, bov, bxe);
    }

    private static agc a(Object obj)
    {
        agc agc1 = null;
        if (obj instanceof brg)
        {
            agc1 = agc.a;
        } else
        {
            if (obj instanceof bra)
            {
                return agc.b;
            }
            if (obj instanceof brd)
            {
                return agc.c;
            }
            if (obj instanceof bta)
            {
                return agc.d;
            }
        }
        return agc1;
    }

    private void a(int i1, agb agb1)
    {
        int j1 = n * i1;
        while (j1 < n * (i1 + 1)) 
        {
            if (j1 < a())
            {
                Object obj = a.get(j1);
                Object obj2 = a(obj);
                Object obj1 = a(obj);
                int k1;
                int l1;
                if (obj1 == agc.a)
                {
                    obj = q.d().a(new bxh(), (brg)obj);
                } else
                if (obj1 == agc.b)
                {
                    obj = ((aes)p.a()).a(new bxh(), (bra)obj);
                } else
                if (obj1 == agc.c)
                {
                    obj = ((aew)o.a()).a(new bxh(), (brd)obj);
                } else
                if (obj1 == agc.d)
                {
                    obj1 = r;
                    obj = (new afo(((afr) (obj1)).a, ((afr) (obj1)).b, ((afr) (obj1)).c, ((afr) (obj1)).d, ((afr) (obj1)).e)).a(new bxh(), (bta)obj);
                } else
                {
                    obj = null;
                }
                obj1 = obj;
                obj = obj2;
            } else
            if (j1 == a() && b())
            {
                obj1 = LayoutInflater.from(h).inflate(0x7f040040, null);
                g.a(d);
                d = null;
                obj = null;
            } else
            {
                obj = null;
                obj1 = null;
            }
            if (obj1 != null)
            {
                obj2 = new android.widget.LinearLayout.LayoutParams(i, j);
                l1 = k;
                k1 = l;
                if (obj == agc.c)
                {
                    obj2.width = ((android.widget.LinearLayout.LayoutParams) (obj2)).width + (k << 1);
                    obj2.height = ((android.widget.LinearLayout.LayoutParams) (obj2)).height + (l << 1);
                    k1 = 0;
                    l1 = 0;
                }
                ((android.widget.LinearLayout.LayoutParams) (obj2)).setMargins(l1, k1, l1, k1);
                if (j1 == b)
                {
                    ((View) (obj1)).setBackgroundResource(0x7f020048);
                }
                ((View) (obj1)).setTag(0x7f100017, Integer.valueOf(j1));
                agb1.addView(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj2)));
                agb1.a.add(obj);
            }
            j1++;
        }
    }

    private void a(agb agb1)
    {
        do
        {
            if (agb1.getChildCount() <= 0)
            {
                break;
            }
            Object obj = agb1.getChildAt(0);
            agb.a(((View) (obj)));
            agb1.removeViewAt(0);
            obj = new Pair(obj, agb1.a.remove(0));
            agc agc1 = (agc)((Pair) (obj)).second;
            if (agc1 == agc.a)
            {
                q.a((View)((Pair) (obj)).first);
            } else
            if (agc1 == agc.b)
            {
                p.a((View)((Pair) (obj)).first);
            } else
            if (agc1 == agc.c)
            {
                o.a((View)((Pair) (obj)).first);
            }
        } while (true);
    }

    private void b(List list)
    {
        list = list.iterator();
        do
        {
            brj brj1;
label0:
            {
                if (list.hasNext())
                {
                    brj1 = (brj)list.next();
                    if (!brj1.a(2))
                    {
                        break label0;
                    }
                    d = brj1.a;
                }
                return;
            }
            if (brj1.a(3))
            {
                d = brj1.a;
            }
        } while (true);
    }

    private boolean b()
    {
        return !TextUtils.isEmpty(d) && g != null;
    }

    public final int a()
    {
        return a.size();
    }

    public final View a(ViewGroup viewgroup, int i1)
    {
        int k1 = viewgroup.getChildCount();
        View view = null;
        int j1 = 0;
        while (j1 < k1 && view == null) 
        {
            View view1 = viewgroup.getChildAt(j1);
            if (view1 != null)
            {
                Object obj = view1.getTag(0x7f100017);
                if (obj != null && (obj instanceof Integer) && i1 == ((Integer)obj).intValue())
                {
                    view = view1;
                } else
                if (view1 instanceof ViewGroup)
                {
                    view = a((ViewGroup)view1, i1);
                }
            }
            j1++;
        }
        return view;
    }

    public final void a(bsd bsd1, boolean flag)
    {
        if (bsd1 == null || e == null || f == null)
        {
            return;
        }
        a(bsd1.c());
        if (flag && g != null)
        {
            if (bsd1.b == null)
            {
                bsd1.b = new ArrayList(bsd1.a.b.length);
                don adon[] = bsd1.a.b;
                int j1 = adon.length;
                int i1 = 0;
                while (i1 < j1) 
                {
                    don don1 = adon[i1];
                    if (don1.b != null)
                    {
                        bsd1.b.add(new brj(don1.b));
                    } else
                    if (don1.c != null)
                    {
                        bsd1.b.add(new brj(don1.c));
                    }
                    i1++;
                }
            }
            b(bsd1.b);
        }
        notifyDataSetChanged();
    }

    public final void a(btk btk1, boolean flag)
    {
        if (btk1 == null || e == null || f == null)
        {
            return;
        }
        a(btk1.c());
        if (flag && g != null)
        {
            if (btk1.b == null)
            {
                btk1.b = new ArrayList(btk1.a.b.length);
                dws adws[] = btk1.a.b;
                int j1 = adws.length;
                int i1 = 0;
                while (i1 < j1) 
                {
                    dws dws1 = adws[i1];
                    if (dws1.b != null)
                    {
                        btk1.b.add(new brj(dws1.b));
                    } else
                    if (dws1.c != null)
                    {
                        btk1.b.add(new brj(dws1.c));
                    }
                    i1++;
                }
            }
            b(btk1.b);
        }
        notifyDataSetChanged();
    }

    public void a(List list)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = list.next();
            if ((obj instanceof brg) || (obj instanceof bra) || (obj instanceof brd) || (obj instanceof bta))
            {
                a.add(obj);
            } else
            if (obj instanceof bty)
            {
                a(((bty)obj).d());
            } else
            if (obj instanceof btk)
            {
                a((btk)obj, true);
            } else
            if (obj instanceof bsd)
            {
                a((bsd)obj, true);
            }
        } while (true);
    }

    public final int getCount()
    {
        boolean flag = true;
        int j1 = a.size();
        int i1;
        if (b())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        i1 += j1;
        j1 = i1 / n;
        if (i1 % n > 0)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        return j1 + 1 + i1;
    }

    public final Object getItem(int i1)
    {
        return a.get(i1);
    }

    public final long getItemId(int i1)
    {
        return (long)i1;
    }

    public final View getView(int i1, View view, ViewGroup viewgroup)
    {
        if (i1 == 0)
        {
            view = new LinearLayout(h);
            view.setOrientation(1);
            view.addView(new Space(h), new android.widget.LinearLayout.LayoutParams(m, 0));
            return view;
        }
        if (view != null && (view instanceof agb))
        {
            view = (agb)view;
            a(view);
        } else
        {
            view = new agb(this, h);
            view.setOrientation(1);
        }
        a(i1 - 1, view);
        return view;
    }
}
