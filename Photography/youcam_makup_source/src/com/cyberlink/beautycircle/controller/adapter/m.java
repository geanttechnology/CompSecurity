// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.WrapperListAdapter;
import com.cyberlink.beautycircle.model.network.d;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import com.huewu.pla.lib.internal.PLA_ListView;
import com.huewu.pla.lib.internal.n;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            n

public abstract class m extends ArrayAdapter
{

    private TreeMap a;
    private final int b;
    private int c;
    private boolean d;
    private boolean e;
    private Context f;
    public boolean g;
    protected com.cyberlink.beautycircle.controller.adapter.n h;
    protected Map i;
    public boolean j;
    private boolean k;
    private int l;
    private long m;
    private android.widget.AdapterView.OnItemClickListener n;
    private android.widget.AdapterView.OnItemLongClickListener o;
    private com.huewu.pla.lib.internal.m p;
    private n q;

    public m(Context context, View view, int i1, int j1, com.cyberlink.beautycircle.controller.adapter.n n1)
    {
        super(context, i1, new ArrayList());
        g = false;
        h = null;
        i = new HashMap();
        a = new TreeMap();
        c = 20;
        d = false;
        e = true;
        k = true;
        l = 0;
        m = System.currentTimeMillis();
        j = false;
        n = new android.widget.AdapterView.OnItemClickListener() {

            final m a;

            public void onItemClick(AdapterView adapterview, View view1, int k1, long l1)
            {
                int i2 = k1;
                if (adapterview instanceof ListView)
                {
                    i2 = k1 - ((ListView)adapterview).getHeaderViewsCount();
                }
                if (i2 >= 0 && i2 < a.getCount())
                {
                    a.a((Model)a.getItem(i2));
                }
            }

            
            {
                a = m.this;
                super();
            }
        };
        o = new android.widget.AdapterView.OnItemLongClickListener() {

            final m a;

            public boolean onItemLongClick(AdapterView adapterview, View view1, int k1, long l1)
            {
                int i2 = k1;
                if (adapterview instanceof ListView)
                {
                    i2 = k1 - ((ListView)adapterview).getHeaderViewsCount();
                }
                if (i2 >= 0 && i2 < a.getCount())
                {
                    a.b((Model)a.getItem(i2));
                }
                return true;
            }

            
            {
                a = m.this;
                super();
            }
        };
        p = new com.huewu.pla.lib.internal.m() {

            final m a;

            public void a(PLA_AdapterView pla_adapterview, View view1, int k1, long l1)
            {
                int i2 = k1;
                if (pla_adapterview instanceof PLA_ListView)
                {
                    i2 = k1 - ((PLA_ListView)pla_adapterview).getHeaderViewsCount();
                }
                if (i2 >= 0 && i2 < a.getCount())
                {
                    a.a((Model)a.getItem(i2));
                }
            }

            
            {
                a = m.this;
                super();
            }
        };
        q = new n() {

            final m a;

            public boolean a(PLA_AdapterView pla_adapterview, View view1, int k1, long l1)
            {
                int i2 = k1;
                if (pla_adapterview instanceof PLA_ListView)
                {
                    i2 = k1 - ((PLA_ListView)pla_adapterview).getHeaderViewsCount();
                }
                if (i2 >= 0 && i2 < a.getCount())
                {
                    a.b((Model)a.getItem(i2));
                }
                return true;
            }

            
            {
                a = m.this;
                super();
            }
        };
        f = context;
        h = n1;
        b = i1;
        if (j1 > 10)
        {
            c = j1;
        }
        c(view);
    }

    static int a(m m1)
    {
        return m1.l;
    }

    static int a(m m1, int i1)
    {
        i1 = m1.l + i1;
        m1.l = i1;
        return i1;
    }

    static boolean a(m m1, boolean flag)
    {
        m1.e = flag;
        return flag;
    }

    static int b(m m1)
    {
        return m1.c;
    }

    private void b()
    {
        if (a.containsKey(Integer.valueOf(l)))
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "Already loading ", Integer.valueOf(l)
            });
            return;
        } else
        {
            com.perfectcorp.utility.e.b(new Object[] {
                "Start loading ", Integer.valueOf(l)
            });
            AsyncTask asynctask = (new AsyncTask() {

                final m a;

                protected transient d a(Void avoid[])
                {
                    return a.b(m.a(a), m.b(a));
                }

                protected void a(d d1)
                {
                    boolean flag1 = true;
                    com.perfectcorp.utility.e.b(new Object[] {
                        "Loading ", Integer.valueOf(m.a(a)), " done"
                    });
                    if (d1 != null && d1.b != null)
                    {
                        a.g = false;
                    }
                    if (m.a(a) == 0)
                    {
                        a.clear();
                    }
                    m.c(a).remove(Integer.valueOf(m.a(a)));
                    if (d1 == null || d1.b == null || d1.b.size() <= 0)
                    {
                        m.a(a, false);
                        a.a(true);
                    } else
                    {
                        a.addAll(d1.b);
                        if (d1.a != null && a.getCount() >= d1.a.intValue())
                        {
                            m.a(a, false);
                            a.a(true);
                        }
                    }
                    if (a.h != null)
                    {
                        a.h.a();
                        a.h.b(false);
                        if (d1 != null && d1.a != null)
                        {
                            a.h.a(d1.a.intValue());
                        }
                        if (m.a(a) == 0)
                        {
                            com.cyberlink.beautycircle.controller.adapter.n n1 = a.h;
                            boolean flag = flag1;
                            if (d1 != null)
                            {
                                flag = flag1;
                                if (d1.b != null)
                                {
                                    if (d1.b.isEmpty())
                                    {
                                        flag = flag1;
                                    } else
                                    {
                                        flag = false;
                                    }
                                }
                            }
                            n1.a(flag);
                        }
                    }
                    m.b(a, false);
                    m.a(a, m.b(a));
                    a.a();
                    a.notifyDataSetChanged();
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onCancelled()
                {
                    m.c(a).remove(Integer.valueOf(m.a(a)));
                    m.b(a, false);
                    a.notifyDataSetChanged();
                }

                protected void onPostExecute(Object obj)
                {
                    a((d)obj);
                }

            
            {
                a = m.this;
                super();
            }
            }).executeOnExecutor(j.q, new Void[0]);
            a.put(Integer.valueOf(l), asynctask);
            return;
        }
    }

    static boolean b(m m1, boolean flag)
    {
        m1.d = flag;
        return flag;
    }

    static TreeMap c(m m1)
    {
        return m1.a;
    }

    protected void a()
    {
    }

    protected abstract void a(Model model);

    public void a(Model model, int i1)
    {
        Long long1;
        if (model != null)
        {
            long1 = model.b_();
        } else
        {
            long1 = null;
        }
        if (long1 == null || i.containsKey(Long.toString(long1.longValue())))
        {
            return;
        } else
        {
            super.insert(model, i1);
            i.put(Long.toString(long1.longValue()), model);
            return;
        }
    }

    protected abstract void a(Model model, View view);

    public void a(Model model, Model model1)
    {
        int i1 = getPosition(model);
        if (i1 >= 0)
        {
            setNotifyOnChange(false);
            d(model);
            a(model1, i1);
            setNotifyOnChange(true);
            notifyDataSetChanged();
        }
    }

    protected void a(boolean flag)
    {
    }

    public void add(Object obj)
    {
        c((Model)obj);
    }

    public void addAll(Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext(); c((Model)collection.next())) { }
    }

    protected abstract d b(int i1, int j1);

    public Model b(String s)
    {
        if (s != null && i.containsKey(s))
        {
            return (Model)i.get(s);
        } else
        {
            return null;
        }
    }

    protected abstract void b(Model model);

    public void b(Long long1)
    {
        if (long1 != null)
        {
            if ((long1 = (Model)i.remove(long1.toString())) != null)
            {
                super.remove(long1);
                return;
            }
        }
    }

    public void c()
    {
        d = true;
        for (Iterator iterator = a.values().iterator(); iterator.hasNext(); ((AsyncTask)iterator.next()).cancel(true)) { }
        e = true;
        l = 0;
        a.clear();
        b();
        m = System.currentTimeMillis();
    }

    public void c(View view)
    {
        if (view != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!(view instanceof ListView))
        {
            continue; /* Loop/switch isn't completed */
        }
        android.widget.ListAdapter listadapter2 = ((ListView)view).getAdapter();
        android.widget.ListAdapter listadapter = listadapter2;
        if (listadapter2 instanceof WrapperListAdapter)
        {
            listadapter = ((WrapperListAdapter)listadapter2).getWrappedAdapter();
        }
        if (listadapter != this)
        {
            ((ListView)view).setAdapter(this);
            ((ListView)view).setOnItemClickListener(n);
            ((ListView)view).setOnItemLongClickListener(o);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (!(view instanceof PLA_ListView)) goto _L1; else goto _L3
_L3:
        android.widget.ListAdapter listadapter3 = ((PLA_ListView)view).getAdapter();
        android.widget.ListAdapter listadapter1 = listadapter3;
        if (listadapter3 instanceof WrapperListAdapter)
        {
            listadapter1 = ((WrapperListAdapter)listadapter3).getWrappedAdapter();
        }
        if (listadapter1 != this)
        {
            ((PLA_ListView)view).setAdapter(this);
            ((PLA_ListView)view).setOnItemClickListener(p);
            ((PLA_ListView)view).setOnItemLongClickListener(q);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void c(Model model)
    {
        Long long1;
        if (model != null)
        {
            long1 = model.b_();
        } else
        {
            long1 = null;
        }
        if (long1 == null || i.containsKey(Long.toString(long1.longValue())))
        {
            com.perfectcorp.utility.e.d(new Object[] {
                "Add fail with key: ", long1
            });
            return;
        } else
        {
            super.add(model);
            i.put(Long.toString(long1.longValue()), model);
            return;
        }
    }

    public boolean c(boolean flag)
    {
        boolean flag2 = false;
        boolean flag3 = e;
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag3 == flag1)
        {
            e = flag;
            flag1 = flag2;
            if (!flag)
            {
                flag1 = true;
            }
            a(flag1);
            if (flag)
            {
                notifyDataSetChanged();
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void clear()
    {
        super.clear();
        i.clear();
    }

    public void d(Model model)
    {
        super.remove(model);
        if (model != null)
        {
            model = model.b_();
        } else
        {
            model = null;
        }
        if (model != null && i.containsKey(Long.toString(model.longValue())))
        {
            i.remove(Long.toString(model.longValue()));
        }
    }

    public void d(boolean flag)
    {
        k = flag;
    }

    public void e()
    {
        for (Iterator iterator = a.values().iterator(); iterator.hasNext(); ((AsyncTask)iterator.next()).cancel(true)) { }
        e = true;
        l = 0;
        a.clear();
        clear();
    }

    public ArrayList f()
    {
        ArrayList arraylist = new ArrayList();
        for (int i1 = 0; i1 < getCount(); i1++)
        {
            arraylist.add(getItem(i1));
        }

        return arraylist;
    }

    public boolean g()
    {
        if (d)
        {
            return false;
        } else
        {
            c();
            return true;
        }
    }

    public View getView(int i1, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = ((LayoutInflater)f.getSystemService("layout_inflater")).inflate(b, viewgroup, false);
        }
        if (e && !h())
        {
            int j1 = getCount();
            if (j1 == 0 || j1 - 1 == i1)
            {
                b();
                if (h != null)
                {
                    h.b(true);
                }
            }
        }
        view1.setTag(Integer.valueOf(i1));
        a((Model)getItem(i1), view1);
        return view1;
    }

    public boolean h()
    {
        return d;
    }

    public boolean i()
    {
        return k;
    }

    public void insert(Object obj, int i1)
    {
        a((Model)obj, i1);
    }

    public boolean j()
    {
        return System.currentTimeMillis() - m > 0x5265c00L;
    }

    public void remove(Object obj)
    {
        d((Model)obj);
    }
}
