// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.support.v7.at;
import android.support.v7.aw;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            m, j, Fragment, n, 
//            ai, h

final class e extends m
    implements Runnable
{
    static final class a
    {

        a a;
        a b;
        int c;
        Fragment d;
        int e;
        int f;
        int g;
        int h;
        ArrayList i;

        a()
        {
        }
    }

    public class b
    {

        public at a;
        public ArrayList b;
        public n.a c;
        public View d;
        final e e;

        public b()
        {
            e = e.this;
            super();
            a = new at();
            b = new ArrayList();
            c = new n.a();
        }
    }


    static final boolean a;
    final j b;
    a c;
    a d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    boolean l;
    boolean m;
    String n;
    boolean o;
    int p;
    int q;
    CharSequence r;
    int s;
    CharSequence t;
    ArrayList u;
    ArrayList v;

    public e(j j1)
    {
        m = true;
        p = -1;
        b = j1;
    }

    private b a(SparseArray sparsearray, SparseArray sparsearray1, boolean flag)
    {
        boolean flag4 = false;
        b b1 = new b();
        b1.d = new View(b.o);
        int i1 = 0;
        boolean flag1 = false;
        int k1;
        boolean flag3;
        do
        {
            k1 = ((flag4) ? 1 : 0);
            flag3 = flag1;
            if (i1 >= sparsearray.size())
            {
                break;
            }
            if (a(sparsearray.keyAt(i1), b1, flag, sparsearray, sparsearray1))
            {
                flag1 = true;
            }
            i1++;
        } while (true);
        while (k1 < sparsearray1.size()) 
        {
            int j1 = sparsearray1.keyAt(k1);
            boolean flag2 = flag3;
            if (sparsearray.get(j1) == null)
            {
                flag2 = flag3;
                if (a(j1, b1, flag, sparsearray, sparsearray1))
                {
                    flag2 = true;
                }
            }
            k1++;
            flag3 = flag2;
        }
        sparsearray = b1;
        if (!flag3)
        {
            sparsearray = null;
        }
        return sparsearray;
    }

    private at a(b b1, Fragment fragment, boolean flag)
    {
        at at2 = new at();
        at at1 = at2;
        if (u != null)
        {
            android.support.v4.app.n.a(at2, fragment.t());
            if (flag)
            {
                at2.a(v);
                at1 = at2;
            } else
            {
                at1 = a(u, v, at2);
            }
        }
        if (flag)
        {
            if (fragment.ah != null)
            {
                fragment.ah.a(v, at1);
            }
            a(b1, at1, false);
            return at1;
        }
        if (fragment.ai != null)
        {
            fragment.ai.a(v, at1);
        }
        b(b1, at1, false);
        return at1;
    }

    private at a(b b1, boolean flag, Fragment fragment)
    {
        at at1 = b(b1, fragment, flag);
        if (flag)
        {
            if (fragment.ai != null)
            {
                fragment.ai.a(v, at1);
            }
            a(b1, at1, true);
            return at1;
        }
        if (fragment.ah != null)
        {
            fragment.ah.a(v, at1);
        }
        b(b1, at1, true);
        return at1;
    }

    static at a(e e1, b b1, boolean flag, Fragment fragment)
    {
        return e1.a(b1, flag, fragment);
    }

    private static at a(ArrayList arraylist, ArrayList arraylist1, at at1)
    {
        if (at1.isEmpty())
        {
            return at1;
        }
        at at2 = new at();
        int j1 = arraylist.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view = (View)at1.get(arraylist.get(i1));
            if (view != null)
            {
                at2.put(arraylist1.get(i1), view);
            }
        }

        return at2;
    }

    private static Object a(Fragment fragment, Fragment fragment1, boolean flag)
    {
        if (fragment == null || fragment1 == null)
        {
            return null;
        }
        if (flag)
        {
            fragment = ((Fragment) (fragment1.E()));
        } else
        {
            fragment = ((Fragment) (fragment.D()));
        }
        return android.support.v4.app.n.a(fragment);
    }

    private static Object a(Fragment fragment, boolean flag)
    {
        if (fragment == null)
        {
            return null;
        }
        if (flag)
        {
            fragment = ((Fragment) (fragment.C()));
        } else
        {
            fragment = ((Fragment) (fragment.z()));
        }
        return android.support.v4.app.n.a(fragment);
    }

    private static Object a(Object obj, Fragment fragment, ArrayList arraylist, at at1, View view)
    {
        Object obj1 = obj;
        if (obj != null)
        {
            obj1 = android.support.v4.app.n.a(obj, fragment.t(), arraylist, at1, view);
        }
        return obj1;
    }

    private void a(int i1, Fragment fragment, String s1, int j1)
    {
        fragment.C = b;
        if (s1 != null)
        {
            if (fragment.I != null && !s1.equals(fragment.I))
            {
                throw new IllegalStateException((new StringBuilder()).append("Can't change tag of fragment ").append(fragment).append(": was ").append(fragment.I).append(" now ").append(s1).toString());
            }
            fragment.I = s1;
        }
        if (i1 != 0)
        {
            if (fragment.G != 0 && fragment.G != i1)
            {
                throw new IllegalStateException((new StringBuilder()).append("Can't change container ID of fragment ").append(fragment).append(": was ").append(fragment.G).append(" now ").append(i1).toString());
            }
            fragment.G = i1;
            fragment.H = i1;
        }
        s1 = new a();
        s1.c = j1;
        s1.d = fragment;
        a(((a) (s1)));
    }

    private void a(b b1, int i1, Object obj)
    {
        if (b.g != null)
        {
            int j1 = 0;
            while (j1 < b.g.size()) 
            {
                Fragment fragment = (Fragment)b.g.get(j1);
                if (fragment.S != null && fragment.R != null && fragment.H == i1)
                {
                    if (fragment.J)
                    {
                        if (!b1.b.contains(fragment.S))
                        {
                            android.support.v4.app.n.a(obj, fragment.S, true);
                            b1.b.add(fragment.S);
                        }
                    } else
                    {
                        android.support.v4.app.n.a(obj, fragment.S, false);
                        b1.b.remove(fragment.S);
                    }
                }
                j1++;
            }
        }
    }

    private void a(b b1, Fragment fragment, Fragment fragment1, boolean flag, at at1)
    {
        if (flag)
        {
            b1 = fragment1.ah;
        } else
        {
            b1 = fragment.ah;
        }
        if (b1 != null)
        {
            b1.b(new ArrayList(at1.keySet()), new ArrayList(at1.values()), null);
        }
    }

    private void a(b b1, at at1, boolean flag)
    {
        int i1;
        int j1;
        if (v == null)
        {
            i1 = 0;
        } else
        {
            i1 = v.size();
        }
        j1 = 0;
        while (j1 < i1) 
        {
            String s1 = (String)u.get(j1);
            Object obj = (View)at1.get((String)v.get(j1));
            if (obj != null)
            {
                obj = android.support.v4.app.n.a(((View) (obj)));
                if (flag)
                {
                    a(b1.a, s1, ((String) (obj)));
                } else
                {
                    a(b1.a, ((String) (obj)), s1);
                }
            }
            j1++;
        }
    }

    private void a(b b1, View view, Object obj, Fragment fragment, Fragment fragment1, boolean flag, ArrayList arraylist)
    {
        view.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener(view, obj, arraylist, b1, flag, fragment, fragment1) {

            final View a;
            final Object b;
            final ArrayList c;
            final b d;
            final boolean e;
            final Fragment f;
            final Fragment g;
            final e h;

            public boolean onPreDraw()
            {
                a.getViewTreeObserver().removeOnPreDrawListener(this);
                if (b != null)
                {
                    android.support.v4.app.n.a(b, c);
                    c.clear();
                    at at1 = e.a(h, d, e, f);
                    c.add(d.d);
                    c.addAll(at1.values());
                    android.support.v4.app.n.b(b, c);
                    e.a(h, at1, d);
                    e.a(h, d, f, g, e, at1);
                }
                return true;
            }

            
            {
                h = e.this;
                a = view;
                b = obj;
                c = arraylist;
                d = b1;
                e = flag;
                f = fragment;
                g = fragment1;
                super();
            }
        });
    }

    private static void a(b b1, ArrayList arraylist, ArrayList arraylist1)
    {
        if (arraylist != null)
        {
            for (int i1 = 0; i1 < arraylist.size(); i1++)
            {
                String s1 = (String)arraylist.get(i1);
                String s2 = (String)arraylist1.get(i1);
                a(b1.a, s1, s2);
            }

        }
    }

    static void a(e e1, b b1, int i1, Object obj)
    {
        e1.a(b1, i1, obj);
    }

    static void a(e e1, b b1, Fragment fragment, Fragment fragment1, boolean flag, at at1)
    {
        e1.a(b1, fragment, fragment1, flag, at1);
    }

    static void a(e e1, at at1, b b1)
    {
        e1.a(at1, b1);
    }

    private void a(at at1, b b1)
    {
        if (v != null && !at1.isEmpty())
        {
            at1 = (View)at1.get(v.get(0));
            if (at1 != null)
            {
                b1.c.a = at1;
            }
        }
    }

    private static void a(at at1, String s1, String s2)
    {
        if (s1 == null || s2 == null || s1.equals(s2)) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L6:
        if (i1 >= at1.size())
        {
            break; /* Loop/switch isn't completed */
        }
        if (!s1.equals(at1.c(i1))) goto _L4; else goto _L3
_L3:
        at1.a(i1, s2);
_L2:
        return;
_L4:
        i1++;
        if (true) goto _L6; else goto _L5
_L5:
        at1.put(s1, s2);
        return;
    }

    private static void a(SparseArray sparsearray, Fragment fragment)
    {
        if (fragment != null)
        {
            int i1 = fragment.H;
            if (i1 != 0 && !fragment.q() && fragment.n() && fragment.t() != null && sparsearray.get(i1) == null)
            {
                sparsearray.put(i1, fragment);
            }
        }
    }

    private void a(View view, b b1, int i1, Object obj)
    {
        view.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener(view, b1, i1, obj) {

            final View a;
            final b b;
            final int c;
            final Object d;
            final e e;

            public boolean onPreDraw()
            {
                a.getViewTreeObserver().removeOnPreDrawListener(this);
                e.a(e, b, c, d);
                return true;
            }

            
            {
                e = e.this;
                a = view;
                b = b1;
                c = i1;
                d = obj;
                super();
            }
        });
    }

    private boolean a(int i1, b b1, boolean flag, SparseArray sparsearray, SparseArray sparsearray1)
    {
        ViewGroup viewgroup = (ViewGroup)b.p.a(i1);
        if (viewgroup == null)
        {
            return false;
        }
        Object obj1 = (Fragment)sparsearray1.get(i1);
        Object obj4 = (Fragment)sparsearray.get(i1);
        Object obj2 = a(((Fragment) (obj1)), flag);
        Object obj3 = a(((Fragment) (obj1)), ((Fragment) (obj4)), flag);
        Object obj5 = b(((Fragment) (obj4)), flag);
        if (obj2 == null && obj3 == null && obj5 == null)
        {
            return false;
        }
        sparsearray = null;
        ArrayList arraylist = new ArrayList();
        if (obj3 != null)
        {
            Object obj = a(b1, ((Fragment) (obj4)), flag);
            arraylist.add(b1.d);
            arraylist.addAll(((at) (obj)).values());
            if (flag)
            {
                sparsearray1 = ((Fragment) (obj4)).ah;
            } else
            {
                sparsearray1 = ((Fragment) (obj1)).ah;
            }
            sparsearray = ((SparseArray) (obj));
            if (sparsearray1 != null)
            {
                sparsearray1.a(new ArrayList(((at) (obj)).keySet()), new ArrayList(((at) (obj)).values()), null);
                sparsearray = ((SparseArray) (obj));
            }
        }
        sparsearray1 = new ArrayList();
        obj = a(obj5, ((Fragment) (obj4)), ((ArrayList) (sparsearray1)), ((at) (sparsearray)), b1.d);
        if (v != null && sparsearray != null)
        {
            sparsearray = (View)sparsearray.get(v.get(0));
            if (sparsearray != null)
            {
                if (obj != null)
                {
                    android.support.v4.app.n.a(obj, sparsearray);
                }
                if (obj3 != null)
                {
                    android.support.v4.app.n.a(obj3, sparsearray);
                }
            }
        }
        sparsearray = new n.b(((Fragment) (obj1))) {

            final Fragment a;
            final e b;

            public View a()
            {
                return a.t();
            }

            
            {
                b = e.this;
                a = fragment;
                super();
            }
        };
        if (obj3 != null)
        {
            a(b1, ((View) (viewgroup)), obj3, ((Fragment) (obj1)), ((Fragment) (obj4)), flag, arraylist);
        }
        obj4 = new ArrayList();
        obj5 = new at();
        if (flag)
        {
            flag = ((Fragment) (obj1)).G();
        } else
        {
            flag = ((Fragment) (obj1)).F();
        }
        obj1 = android.support.v4.app.n.a(obj2, obj, obj3, flag);
        if (obj1 != null)
        {
            android.support.v4.app.n.a(obj2, obj3, viewgroup, sparsearray, b1.d, b1.c, b1.a, ((ArrayList) (obj4)), ((java.util.Map) (obj5)), arraylist);
            a(((View) (viewgroup)), b1, i1, obj1);
            android.support.v4.app.n.a(obj1, b1.d, true);
            a(b1, i1, obj1);
            android.support.v4.app.n.a(viewgroup, obj1);
            android.support.v4.app.n.a(viewgroup, b1.d, obj2, ((ArrayList) (obj4)), obj, sparsearray1, obj3, arraylist, obj1, b1.b, ((java.util.Map) (obj5)));
        }
        return obj1 != null;
    }

    private at b(b b1, Fragment fragment, boolean flag)
    {
        at at1;
label0:
        {
            at1 = new at();
            fragment = fragment.t();
            b1 = at1;
            if (fragment != null)
            {
                b1 = at1;
                if (u != null)
                {
                    android.support.v4.app.n.a(at1, fragment);
                    if (!flag)
                    {
                        break label0;
                    }
                    b1 = a(u, v, at1);
                }
            }
            return b1;
        }
        at1.a(v);
        return at1;
    }

    private static Object b(Fragment fragment, boolean flag)
    {
        if (fragment == null)
        {
            return null;
        }
        if (flag)
        {
            fragment = ((Fragment) (fragment.A()));
        } else
        {
            fragment = ((Fragment) (fragment.B()));
        }
        return android.support.v4.app.n.a(fragment);
    }

    private void b(b b1, at at1, boolean flag)
    {
        int j1 = at1.size();
        int i1 = 0;
        while (i1 < j1) 
        {
            String s1 = (String)at1.b(i1);
            String s2 = android.support.v4.app.n.a((View)at1.c(i1));
            if (flag)
            {
                a(b1.a, s1, s2);
            } else
            {
                a(b1.a, s2, s1);
            }
            i1++;
        }
    }

    private void b(SparseArray sparsearray, Fragment fragment)
    {
        if (fragment != null)
        {
            int i1 = fragment.H;
            if (i1 != 0)
            {
                sparsearray.put(i1, fragment);
            }
        }
    }

    private void b(SparseArray sparsearray, SparseArray sparsearray1)
    {
        if (b.p.a()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        a a1 = c;
_L12:
        if (a1 == null) goto _L1; else goto _L3
_L3:
        a1.c;
        JVM INSTR tableswitch 1 7: default 76
    //                   1 86
    //                   2 99
    //                   3 218
    //                   4 230
    //                   5 242
    //                   6 255
    //                   7 267;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L4:
        break; /* Loop/switch isn't completed */
_L11:
        break MISSING_BLOCK_LABEL_267;
_L13:
        a1 = a1.a;
          goto _L12
_L5:
        b(sparsearray1, a1.d);
          goto _L13
_L6:
        Fragment fragment = a1.d;
        Fragment fragment1;
        if (b.g != null)
        {
            int i1 = 0;
label0:
            do
            {
label1:
                {
                    fragment1 = fragment;
                    if (i1 >= b.g.size())
                    {
                        break label0;
                    }
                    Fragment fragment2 = (Fragment)b.g.get(i1);
                    if (fragment != null)
                    {
                        fragment1 = fragment;
                        if (fragment2.H != fragment.H)
                        {
                            break label1;
                        }
                    }
                    if (fragment2 == fragment)
                    {
                        fragment1 = null;
                    } else
                    {
                        a(sparsearray, fragment2);
                        fragment1 = fragment;
                    }
                }
                i1++;
                fragment = fragment1;
            } while (true);
        } else
        {
            fragment1 = fragment;
        }
        b(sparsearray1, fragment1);
          goto _L13
_L7:
        a(sparsearray, a1.d);
          goto _L13
_L8:
        a(sparsearray, a1.d);
          goto _L13
_L9:
        b(sparsearray1, a1.d);
          goto _L13
_L10:
        a(sparsearray, a1.d);
          goto _L13
        b(sparsearray1, a1.d);
          goto _L13
    }

    public int a()
    {
        return a(false);
    }

    int a(boolean flag)
    {
        if (o)
        {
            throw new IllegalStateException("commit already called");
        }
        if (j.a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Commit: ").append(this).toString());
            a("  ", ((FileDescriptor) (null)), new PrintWriter(new aw("FragmentManager")), ((String []) (null)));
        }
        o = true;
        if (l)
        {
            p = b.a(this);
        } else
        {
            p = -1;
        }
        b.a(this, flag);
        return p;
    }

    public b a(boolean flag, b b1, SparseArray sparsearray, SparseArray sparsearray1)
    {
        b b2;
        if (j.a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("popFromBackStack: ").append(this).toString());
            a("  ", ((FileDescriptor) (null)), new PrintWriter(new aw("FragmentManager")), ((String []) (null)));
        }
        b2 = b1;
        if (!a) goto _L2; else goto _L1
_L1:
        if (b1 != null) goto _L4; else goto _L3
_L3:
        if (sparsearray.size() != 0) goto _L6; else goto _L5
_L5:
        b2 = b1;
        if (sparsearray1.size() == 0) goto _L2; else goto _L6
_L6:
        b2 = a(sparsearray, sparsearray1, true);
_L2:
        int i1;
        int j1;
        int k1;
        int l1;
        a(-1);
        if (b2 != null)
        {
            i1 = 0;
        } else
        {
            i1 = k;
        }
        if (b2 != null)
        {
            j1 = 0;
        } else
        {
            j1 = j;
        }
        b1 = d;
_L17:
        if (b1 == null) goto _L8; else goto _L7
_L7:
        if (b2 != null)
        {
            k1 = 0;
        } else
        {
            k1 = ((a) (b1)).g;
        }
        if (b2 != null)
        {
            l1 = 0;
        } else
        {
            l1 = ((a) (b1)).h;
        }
        ((a) (b1)).c;
        JVM INSTR tableswitch 1 7: default 192
    //                   1 284
    //                   2 318
    //                   3 407
    //                   4 430
    //                   5 459
    //                   6 488
    //                   7 517;
           goto _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L9:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown cmd: ").append(((a) (b1)).c).toString());
_L4:
        b2 = b1;
        if (!flag)
        {
            a(b1, v, u);
            b2 = b1;
        }
          goto _L2
_L10:
        sparsearray = ((a) (b1)).d;
        sparsearray.Q = l1;
        b.a(sparsearray, android.support.v4.app.j.c(j1), i1);
_L18:
        b1 = ((a) (b1)).b;
          goto _L17
_L11:
        sparsearray = ((a) (b1)).d;
        if (sparsearray != null)
        {
            sparsearray.Q = l1;
            b.a(sparsearray, android.support.v4.app.j.c(j1), i1);
        }
        if (((a) (b1)).i != null)
        {
            l1 = 0;
            while (l1 < ((a) (b1)).i.size()) 
            {
                sparsearray = (Fragment)((a) (b1)).i.get(l1);
                sparsearray.Q = k1;
                b.a(sparsearray, false);
                l1++;
            }
        }
          goto _L18
_L12:
        sparsearray = ((a) (b1)).d;
        sparsearray.Q = k1;
        b.a(sparsearray, false);
          goto _L18
_L13:
        sparsearray = ((a) (b1)).d;
        sparsearray.Q = k1;
        b.c(sparsearray, android.support.v4.app.j.c(j1), i1);
          goto _L18
_L14:
        sparsearray = ((a) (b1)).d;
        sparsearray.Q = l1;
        b.b(sparsearray, android.support.v4.app.j.c(j1), i1);
          goto _L18
_L15:
        sparsearray = ((a) (b1)).d;
        sparsearray.Q = k1;
        b.e(sparsearray, android.support.v4.app.j.c(j1), i1);
          goto _L18
_L16:
        sparsearray = ((a) (b1)).d;
        sparsearray.Q = k1;
        b.d(sparsearray, android.support.v4.app.j.c(j1), i1);
          goto _L18
_L8:
        if (flag)
        {
            b.a(b.n, android.support.v4.app.j.c(j1), i1, true);
            b2 = null;
        }
        if (p >= 0)
        {
            b.b(p);
            p = -1;
        }
        return b2;
    }

    public m a(int i1, Fragment fragment)
    {
        a(i1, fragment, ((String) (null)), 1);
        return this;
    }

    public m a(int i1, Fragment fragment, String s1)
    {
        a(i1, fragment, s1, 1);
        return this;
    }

    public m a(Fragment fragment)
    {
        a a1 = new a();
        a1.c = 3;
        a1.d = fragment;
        a(a1);
        return this;
    }

    public m a(Fragment fragment, String s1)
    {
        a(0, fragment, s1, 1);
        return this;
    }

    void a(int i1)
    {
        if (l)
        {
            if (j.a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("Bump nesting in ").append(this).append(" by ").append(i1).toString());
            }
            a a1 = c;
            while (a1 != null) 
            {
                if (a1.d != null)
                {
                    Fragment fragment = a1.d;
                    fragment.B = fragment.B + i1;
                    if (j.a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("Bump nesting of ").append(a1.d).append(" to ").append(a1.d.B).toString());
                    }
                }
                if (a1.i != null)
                {
                    for (int j1 = a1.i.size() - 1; j1 >= 0; j1--)
                    {
                        Fragment fragment1 = (Fragment)a1.i.get(j1);
                        fragment1.B = fragment1.B + i1;
                        if (j.a)
                        {
                            Log.v("FragmentManager", (new StringBuilder()).append("Bump nesting of ").append(fragment1).append(" to ").append(fragment1.B).toString());
                        }
                    }

                }
                a1 = a1.a;
            }
        }
    }

    void a(a a1)
    {
        if (c == null)
        {
            d = a1;
            c = a1;
        } else
        {
            a1.b = d;
            d.a = a1;
            d = a1;
        }
        a1.e = f;
        a1.f = g;
        a1.g = h;
        a1.h = i;
        e = e + 1;
    }

    public void a(SparseArray sparsearray, SparseArray sparsearray1)
    {
        if (b.p.a()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        a a1 = c;
_L12:
        if (a1 == null) goto _L1; else goto _L3
_L3:
        a1.c;
        JVM INSTR tableswitch 1 7: default 72
    //                   1 80
    //                   2 91
    //                   3 151
    //                   4 163
    //                   5 175
    //                   6 186
    //                   7 198;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L4:
        break; /* Loop/switch isn't completed */
_L11:
        break MISSING_BLOCK_LABEL_198;
_L13:
        a1 = a1.a;
          goto _L12
_L5:
        a(sparsearray, a1.d);
          goto _L13
_L6:
        if (a1.i != null)
        {
            for (int i1 = a1.i.size() - 1; i1 >= 0; i1--)
            {
                b(sparsearray1, (Fragment)a1.i.get(i1));
            }

        }
        a(sparsearray, a1.d);
          goto _L13
_L7:
        b(sparsearray1, a1.d);
          goto _L13
_L8:
        b(sparsearray1, a1.d);
          goto _L13
_L9:
        a(sparsearray, a1.d);
          goto _L13
_L10:
        b(sparsearray1, a1.d);
          goto _L13
        a(sparsearray, a1.d);
          goto _L13
    }

    public void a(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        a(s1, printwriter, true);
    }

    public void a(String s1, PrintWriter printwriter, boolean flag)
    {
        a a1;
        String s3;
        int i1;
        if (flag)
        {
            printwriter.print(s1);
            printwriter.print("mName=");
            printwriter.print(n);
            printwriter.print(" mIndex=");
            printwriter.print(p);
            printwriter.print(" mCommitted=");
            printwriter.println(o);
            if (j != 0)
            {
                printwriter.print(s1);
                printwriter.print("mTransition=#");
                printwriter.print(Integer.toHexString(j));
                printwriter.print(" mTransitionStyle=#");
                printwriter.println(Integer.toHexString(k));
            }
            if (f != 0 || g != 0)
            {
                printwriter.print(s1);
                printwriter.print("mEnterAnim=#");
                printwriter.print(Integer.toHexString(f));
                printwriter.print(" mExitAnim=#");
                printwriter.println(Integer.toHexString(g));
            }
            if (h != 0 || i != 0)
            {
                printwriter.print(s1);
                printwriter.print("mPopEnterAnim=#");
                printwriter.print(Integer.toHexString(h));
                printwriter.print(" mPopExitAnim=#");
                printwriter.println(Integer.toHexString(i));
            }
            if (q != 0 || r != null)
            {
                printwriter.print(s1);
                printwriter.print("mBreadCrumbTitleRes=#");
                printwriter.print(Integer.toHexString(q));
                printwriter.print(" mBreadCrumbTitleText=");
                printwriter.println(r);
            }
            if (s != 0 || t != null)
            {
                printwriter.print(s1);
                printwriter.print("mBreadCrumbShortTitleRes=#");
                printwriter.print(Integer.toHexString(s));
                printwriter.print(" mBreadCrumbShortTitleText=");
                printwriter.println(t);
            }
        }
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_823;
        }
        printwriter.print(s1);
        printwriter.println("Operations:");
        s3 = (new StringBuilder()).append(s1).append("    ").toString();
        a1 = c;
        i1 = 0;
_L13:
        if (a1 == null) goto _L2; else goto _L1
_L1:
        a1.c;
        JVM INSTR tableswitch 0 7: default 424
    //                   0 702
    //                   1 710
    //                   2 718
    //                   3 726
    //                   4 734
    //                   5 742
    //                   6 750
    //                   7 758;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L11:
        break MISSING_BLOCK_LABEL_758;
_L3:
        String s2 = (new StringBuilder()).append("cmd=").append(a1.c).toString();
_L12:
        printwriter.print(s1);
        printwriter.print("  Op #");
        printwriter.print(i1);
        printwriter.print(": ");
        printwriter.print(s2);
        printwriter.print(" ");
        printwriter.println(a1.d);
        if (flag)
        {
            if (a1.e != 0 || a1.f != 0)
            {
                printwriter.print(s1);
                printwriter.print("enterAnim=#");
                printwriter.print(Integer.toHexString(a1.e));
                printwriter.print(" exitAnim=#");
                printwriter.println(Integer.toHexString(a1.f));
            }
            if (a1.g != 0 || a1.h != 0)
            {
                printwriter.print(s1);
                printwriter.print("popEnterAnim=#");
                printwriter.print(Integer.toHexString(a1.g));
                printwriter.print(" popExitAnim=#");
                printwriter.println(Integer.toHexString(a1.h));
            }
        }
        if (a1.i != null && a1.i.size() > 0)
        {
            int j1 = 0;
            while (j1 < a1.i.size()) 
            {
                printwriter.print(s3);
                if (a1.i.size() == 1)
                {
                    printwriter.print("Removed: ");
                } else
                {
                    if (j1 == 0)
                    {
                        printwriter.println("Removed:");
                    }
                    printwriter.print(s3);
                    printwriter.print("  #");
                    printwriter.print(j1);
                    printwriter.print(": ");
                }
                printwriter.println(a1.i.get(j1));
                j1++;
            }
        }
        break MISSING_BLOCK_LABEL_807;
_L4:
        s2 = "NULL";
          goto _L12
_L5:
        s2 = "ADD";
          goto _L12
_L6:
        s2 = "REPLACE";
          goto _L12
_L7:
        s2 = "REMOVE";
          goto _L12
_L8:
        s2 = "HIDE";
          goto _L12
_L9:
        s2 = "SHOW";
          goto _L12
_L10:
        s2 = "DETACH";
          goto _L12
        s2 = "ATTACH";
          goto _L12
        a1 = a1.a;
        i1++;
          goto _L13
_L2:
    }

    public int b()
    {
        return a(true);
    }

    public m b(Fragment fragment)
    {
        a a1 = new a();
        a1.c = 6;
        a1.d = fragment;
        a(a1);
        return this;
    }

    public m c(Fragment fragment)
    {
        a a1 = new a();
        a1.c = 7;
        a1.d = fragment;
        a(a1);
        return this;
    }

    public String c()
    {
        return n;
    }

    public void run()
    {
        if (j.a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Run: ").append(this).toString());
        }
        if (l && p < 0)
        {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        a(1);
        Fragment fragment;
        Object obj;
        a a1;
        Fragment fragment1;
        Fragment fragment2;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        if (a)
        {
            SparseArray sparsearray = new SparseArray();
            obj = new SparseArray();
            b(sparsearray, ((SparseArray) (obj)));
            obj = a(sparsearray, ((SparseArray) (obj)), false);
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            i1 = 0;
        } else
        {
            i1 = k;
        }
        if (obj != null)
        {
            j1 = 0;
        } else
        {
            j1 = j;
        }
        a1 = c;
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_700;
        }
        if (obj != null)
        {
            k1 = 0;
        } else
        {
            k1 = a1.e;
        }
        if (obj != null)
        {
            l1 = 0;
        } else
        {
            l1 = a1.f;
        }
        a1.c;
        JVM INSTR tableswitch 1 7: default 184
    //                   1 251
    //                   2 279
    //                   3 570
    //                   4 596
    //                   5 622
    //                   6 648
    //                   7 674;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_674;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown cmd: ").append(a1.c).toString());
_L2:
        fragment = a1.d;
        fragment.Q = k1;
        b.a(fragment, false);
_L12:
        a1 = a1.a;
        if (true) goto _L10; else goto _L9
_L10:
        break MISSING_BLOCK_LABEL_118;
_L9:
        fragment = a1.d;
        if (b.g != null)
        {
            i2 = 0;
label0:
            do
            {
label1:
                {
                    fragment1 = fragment;
                    if (i2 >= b.g.size())
                    {
                        break label0;
                    }
                    fragment2 = (Fragment)b.g.get(i2);
                    if (j.a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("OP_REPLACE: adding=").append(fragment).append(" old=").append(fragment2).toString());
                    }
                    if (fragment != null)
                    {
                        fragment1 = fragment;
                        if (fragment2.H != fragment.H)
                        {
                            break label1;
                        }
                    }
                    if (fragment2 == fragment)
                    {
                        a1.d = null;
                        fragment1 = null;
                    } else
                    {
                        if (a1.i == null)
                        {
                            a1.i = new ArrayList();
                        }
                        a1.i.add(fragment2);
                        fragment2.Q = l1;
                        if (l)
                        {
                            fragment2.B = fragment2.B + 1;
                            if (j.a)
                            {
                                Log.v("FragmentManager", (new StringBuilder()).append("Bump nesting of ").append(fragment2).append(" to ").append(fragment2.B).toString());
                            }
                        }
                        b.a(fragment2, j1, i1);
                        fragment1 = fragment;
                    }
                }
                i2++;
                fragment = fragment1;
            } while (true);
        } else
        {
            fragment1 = fragment;
        }
        if (fragment1 != null)
        {
            fragment1.Q = k1;
            b.a(fragment1, false);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        fragment = a1.d;
        fragment.Q = l1;
        b.a(fragment, j1, i1);
        continue; /* Loop/switch isn't completed */
_L5:
        fragment = a1.d;
        fragment.Q = l1;
        b.b(fragment, j1, i1);
        continue; /* Loop/switch isn't completed */
_L6:
        fragment = a1.d;
        fragment.Q = k1;
        b.c(fragment, j1, i1);
        continue; /* Loop/switch isn't completed */
_L7:
        fragment = a1.d;
        fragment.Q = l1;
        b.d(fragment, j1, i1);
        continue; /* Loop/switch isn't completed */
        fragment = a1.d;
        fragment.Q = k1;
        b.e(fragment, j1, i1);
        if (true) goto _L12; else goto _L11
_L11:
        b.a(b.n, j1, i1, true);
        if (l)
        {
            b.b(this);
        }
        return;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("BackStackEntry{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (p >= 0)
        {
            stringbuilder.append(" #");
            stringbuilder.append(p);
        }
        if (n != null)
        {
            stringbuilder.append(" ");
            stringbuilder.append(n);
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
