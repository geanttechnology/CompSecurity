// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.support.v4.f.a;
import android.support.v4.f.d;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package android.support.v4.app:
//            m, l, Fragment, n, 
//            j

final class f extends m
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

    public final class b
    {

        public android.support.v4.f.a a;
        public ArrayList b;
        public n.a c;
        public View d;
        final f e;

        public b()
        {
            e = f.this;
            super();
            a = new android.support.v4.f.a();
            b = new ArrayList();
            c = new n.a();
        }
    }


    static final boolean a;
    final l b;
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

    public f(l l1)
    {
        m = true;
        p = -1;
        b = l1;
    }

    private int a(boolean flag)
    {
        if (o)
        {
            throw new IllegalStateException("commit already called");
        }
        if (android.support.v4.app.l.a)
        {
            (new StringBuilder("Commit: ")).append(this);
            a("  ", new PrintWriter(new d("FragmentManager")));
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

    private android.support.v4.f.a a(b b1, Fragment fragment, boolean flag)
    {
        android.support.v4.f.a a2 = new android.support.v4.f.a();
        android.support.v4.f.a a1 = a2;
        if (u != null)
        {
            android.support.v4.app.n.a(a2, fragment.getView());
            if (flag)
            {
                android.support.v4.f.f.a(a2, v);
                a1 = a2;
            } else
            {
                a1 = a(u, v, a2);
            }
        }
        if (flag)
        {
            if (fragment.ah != null)
            {
                fragment = fragment.ah;
            }
            a(b1, a1, false);
            return a1;
        }
        if (fragment.ai != null)
        {
            fragment = fragment.ai;
        }
        b(b1, a1, false);
        return a1;
    }

    static android.support.v4.f.a a(f f1, b b1, boolean flag, Fragment fragment)
    {
        android.support.v4.f.a a2 = new android.support.v4.f.a();
        View view = fragment.getView();
        android.support.v4.f.a a1 = a2;
        if (view != null)
        {
            a1 = a2;
            if (f1.u != null)
            {
                android.support.v4.app.n.a(a2, view);
                if (flag)
                {
                    a1 = a(f1.u, f1.v, a2);
                } else
                {
                    android.support.v4.f.f.a(a2, f1.v);
                    a1 = a2;
                }
            }
        }
        if (flag)
        {
            if (fragment.ai != null)
            {
                fragment = fragment.ai;
            }
            f1.a(b1, a1, true);
            return a1;
        }
        if (fragment.ah != null)
        {
            f1 = fragment.ah;
        }
        b(b1, a1, true);
        return a1;
    }

    private static android.support.v4.f.a a(ArrayList arraylist, ArrayList arraylist1, android.support.v4.f.a a1)
    {
        if (a1.isEmpty())
        {
            return a1;
        }
        android.support.v4.f.a a2 = new android.support.v4.f.a();
        int j1 = arraylist.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view = (View)a1.get(arraylist.get(i1));
            if (view != null)
            {
                a2.put(arraylist1.get(i1), view);
            }
        }

        return a2;
    }

    private static Object a(Object obj, Fragment fragment, ArrayList arraylist, android.support.v4.f.a a1, View view)
    {
label0:
        {
            Object obj1 = obj;
            if (obj != null)
            {
                fragment = fragment.getView();
                obj1 = obj;
                if (obj != null)
                {
                    android.support.v4.app.n.a(arraylist, fragment);
                    if (a1 != null)
                    {
                        arraylist.removeAll(a1.values());
                    }
                    if (!arraylist.isEmpty())
                    {
                        break label0;
                    }
                    obj1 = null;
                }
            }
            return obj1;
        }
        arraylist.add(view);
        android.support.v4.app.n.b((Transition)obj, arraylist);
        return obj;
    }

    private void a(int i1, Fragment fragment, String s1, int j1)
    {
        fragment.C = b;
        if (s1 != null)
        {
            if (fragment.I != null && !s1.equals(fragment.I))
            {
                throw new IllegalStateException((new StringBuilder("Can't change tag of fragment ")).append(fragment).append(": was ").append(fragment.I).append(" now ").append(s1).toString());
            }
            fragment.I = s1;
        }
        if (i1 != 0)
        {
            if (fragment.G != 0 && fragment.G != i1)
            {
                throw new IllegalStateException((new StringBuilder("Can't change container ID of fragment ")).append(fragment).append(": was ").append(fragment.G).append(" now ").append(i1).toString());
            }
            fragment.G = i1;
            fragment.H = i1;
        }
        s1 = new a();
        s1.c = j1;
        s1.d = fragment;
        a(((a) (s1)));
    }

    static void a(Fragment fragment, Fragment fragment1, boolean flag, android.support.v4.f.a a1)
    {
        if (flag)
        {
            fragment = fragment1.ah;
        } else
        {
            fragment = fragment.ah;
        }
        if (fragment != null)
        {
            new ArrayList(a1.keySet());
            new ArrayList(a1.values());
        }
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

    private void a(b b1, android.support.v4.f.a a1, boolean flag)
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
            Object obj = (View)a1.get((String)v.get(j1));
            if (obj != null)
            {
                obj = ((View) (obj)).getTransitionName();
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

    static void a(f f1, b b1, int i1, Object obj)
    {
        f1.a(b1, i1, obj);
    }

    static void a(f f1, android.support.v4.f.a a1, b b1)
    {
        if (f1.v != null && !a1.isEmpty())
        {
            f1 = (View)a1.get(f1.v.get(0));
            if (f1 != null)
            {
                b1.c.a = f1;
            }
        }
    }

    private static void a(android.support.v4.f.a a1, String s1, String s2)
    {
        if (s1 == null || s2 == null || s1.equals(s2)) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L6:
        if (i1 >= a1.size())
        {
            break; /* Loop/switch isn't completed */
        }
        if (!s1.equals(a1.c(i1))) goto _L4; else goto _L3
_L3:
        a1.a(i1, s2);
_L2:
        return;
_L4:
        i1++;
        if (true) goto _L6; else goto _L5
_L5:
        a1.put(s1, s2);
        return;
    }

    private static void a(SparseArray sparsearray, Fragment fragment)
    {
        if (fragment != null)
        {
            int i1 = fragment.H;
            if (i1 != 0 && !fragment.isHidden() && fragment.isAdded() && fragment.getView() != null && sparsearray.get(i1) == null)
            {
                sparsearray.put(i1, fragment);
            }
        }
    }

    private boolean a(int i1, b b1, boolean flag, SparseArray sparsearray, SparseArray sparsearray1)
    {
        ViewGroup viewgroup = (ViewGroup)b.p.a(i1);
        if (viewgroup == null)
        {
            return false;
        }
        Object obj4 = (Fragment)sparsearray1.get(i1);
        Object obj5 = (Fragment)sparsearray.get(i1);
        Object obj;
        if (obj4 == null)
        {
            sparsearray1 = null;
        } else
        {
            if (flag)
            {
                sparsearray = ((SparseArray) (((Fragment) (obj4)).getReenterTransition()));
            } else
            {
                sparsearray = ((SparseArray) (((Fragment) (obj4)).getEnterTransition()));
            }
            sparsearray1 = ((SparseArray) (android.support.v4.app.n.a(sparsearray)));
        }
        if (obj4 == null || obj5 == null)
        {
            obj = null;
        } else
        {
            if (flag)
            {
                sparsearray = ((SparseArray) (((Fragment) (obj5)).getSharedElementReturnTransition()));
            } else
            {
                sparsearray = ((SparseArray) (((Fragment) (obj4)).getSharedElementEnterTransition()));
            }
            obj = android.support.v4.app.n.a(sparsearray);
        }
        if (obj5 == null)
        {
            sparsearray = null;
        } else
        {
            if (flag)
            {
                sparsearray = ((SparseArray) (((Fragment) (obj5)).getReturnTransition()));
            } else
            {
                sparsearray = ((SparseArray) (((Fragment) (obj5)).getExitTransition()));
            }
            sparsearray = ((SparseArray) (android.support.v4.app.n.a(sparsearray)));
        }
        if (sparsearray1 == null && obj == null && sparsearray == null)
        {
            return false;
        }
        Object obj1 = null;
        ArrayList arraylist = new ArrayList();
        if (obj != null)
        {
            Object obj3 = a(b1, ((Fragment) (obj5)), flag);
            arraylist.add(b1.d);
            arraylist.addAll(((android.support.v4.f.a) (obj3)).values());
            Object obj2;
            Object obj6;
            android.support.v4.f.a a1;
            n.b b2;
            Transition transition;
            if (flag)
            {
                obj2 = ((Fragment) (obj5)).ah;
            } else
            {
                obj2 = ((Fragment) (obj4)).ah;
            }
            obj1 = obj3;
            if (obj2 != null)
            {
                new ArrayList(((android.support.v4.f.a) (obj3)).keySet());
                new ArrayList(((android.support.v4.f.a) (obj3)).values());
                obj1 = obj3;
            }
        }
        obj3 = new ArrayList();
        obj6 = a(sparsearray, ((Fragment) (obj5)), ((ArrayList) (obj3)), ((android.support.v4.f.a) (obj1)), b1.d);
        if (v != null && obj1 != null)
        {
            sparsearray = (View)((android.support.v4.f.a) (obj1)).get(v.get(0));
            if (sparsearray != null)
            {
                if (obj6 != null)
                {
                    android.support.v4.app.n.a(obj6, sparsearray);
                }
                if (obj != null)
                {
                    android.support.v4.app.n.a(obj, sparsearray);
                }
            }
        }
        b2 = new n.b(((Fragment) (obj4))) {

            final Fragment a;
            final f b;

            public final View a()
            {
                return a.getView();
            }

            
            {
                b = f.this;
                a = fragment;
                super();
            }
        };
        if (obj != null)
        {
            viewgroup.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener(viewgroup, obj, arraylist, b1, flag, ((Fragment) (obj4)), ((Fragment) (obj5))) {

                final View a;
                final Object b;
                final ArrayList c;
                final b d;
                final boolean e;
                final Fragment f;
                final Fragment g;
                final f h;

                public final boolean onPreDraw()
                {
                    a.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (b != null)
                    {
                        android.support.v4.app.n.a(b, c);
                        c.clear();
                        android.support.v4.f.a a2 = android.support.v4.app.f.a(h, d, e, f);
                        c.add(d.d);
                        c.addAll(a2.values());
                        android.support.v4.app.n.b(b, c);
                        android.support.v4.app.f.a(h, a2, d);
                        android.support.v4.app.f.a(f, g, e, a2);
                    }
                    return true;
                }

            
            {
                h = f.this;
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
        obj5 = new ArrayList();
        a1 = new android.support.v4.f.a();
        if (flag)
        {
            flag = ((Fragment) (obj4)).getAllowReturnTransitionOverlap();
        } else
        {
            flag = ((Fragment) (obj4)).getAllowEnterTransitionOverlap();
        }
        obj1 = (Transition)sparsearray1;
        sparsearray = (Transition)obj6;
        obj4 = (Transition)obj;
        if (obj1 == null || sparsearray == null)
        {
            flag = true;
        }
        if (flag)
        {
            obj2 = new TransitionSet();
            if (obj1 != null)
            {
                ((TransitionSet) (obj2)).addTransition(((Transition) (obj1)));
            }
            if (sparsearray != null)
            {
                ((TransitionSet) (obj2)).addTransition(sparsearray);
            }
            sparsearray = ((SparseArray) (obj2));
            if (obj4 != null)
            {
                ((TransitionSet) (obj2)).addTransition(((Transition) (obj4)));
                sparsearray = ((SparseArray) (obj2));
            }
        } else
        {
            if (sparsearray != null && obj1 != null)
            {
                sparsearray = (new TransitionSet()).addTransition(sparsearray).addTransition(((Transition) (obj1))).setOrdering(1);
            } else
            if (sparsearray == null)
            {
                sparsearray = ((SparseArray) (obj1));
                if (obj1 == null)
                {
                    sparsearray = null;
                }
            }
            if (obj4 != null)
            {
                obj1 = new TransitionSet();
                if (sparsearray != null)
                {
                    ((TransitionSet) (obj1)).addTransition(sparsearray);
                }
                ((TransitionSet) (obj1)).addTransition(((Transition) (obj4)));
                sparsearray = ((SparseArray) (obj1));
            }
        }
        if (sparsearray != null)
        {
            obj1 = b1.d;
            obj2 = b1.c;
            obj4 = b1.a;
            if (sparsearray1 != null || obj != null)
            {
                transition = (Transition)sparsearray1;
                if (transition != null)
                {
                    transition.addTarget(((View) (obj1)));
                }
                if (obj != null)
                {
                    android.support.v4.app.n.b((Transition)obj, arraylist);
                }
                viewgroup.getViewTreeObserver().addOnPreDrawListener(new n._cls2(viewgroup, b2, ((Map) (obj4)), a1, transition, ((ArrayList) (obj5)), ((View) (obj1))));
                if (transition != null)
                {
                    transition.setEpicenterCallback(new n._cls3(((n.a) (obj2))));
                }
            }
            viewgroup.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener(viewgroup, b1, i1, sparsearray) {

                final View a;
                final b b;
                final int c;
                final Object d;
                final f e;

                public final boolean onPreDraw()
                {
                    a.getViewTreeObserver().removeOnPreDrawListener(this);
                    android.support.v4.app.f.a(e, b, c, d);
                    return true;
                }

            
            {
                e = f.this;
                a = view;
                b = b1;
                c = i1;
                d = obj;
                super();
            }
            });
            android.support.v4.app.n.a(sparsearray, b1.d, true);
            a(b1, i1, sparsearray);
            TransitionManager.beginDelayedTransition(viewgroup, (Transition)sparsearray);
            obj1 = b1.d;
            b1 = b1.b;
            sparsearray1 = (Transition)sparsearray1;
            obj2 = (Transition)obj6;
            obj = (Transition)obj;
            obj4 = (Transition)sparsearray;
            if (obj4 != null)
            {
                viewgroup.getViewTreeObserver().addOnPreDrawListener(new n._cls4(viewgroup, sparsearray1, ((View) (obj1)), ((ArrayList) (obj5)), ((Transition) (obj2)), ((ArrayList) (obj3)), ((Transition) (obj)), arraylist, a1, b1, ((Transition) (obj4))));
            }
        }
        return sparsearray != null;
    }

    private static void b(b b1, android.support.v4.f.a a1, boolean flag)
    {
        int j1 = a1.size();
        int i1 = 0;
        while (i1 < j1) 
        {
            String s1 = (String)a1.b(i1);
            String s2 = ((View)a1.c(i1)).getTransitionName();
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

    private static void b(SparseArray sparsearray, Fragment fragment)
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
    //                   2 98
    //                   3 216
    //                   4 228
    //                   5 240
    //                   6 252
    //                   7 264;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L4:
        break; /* Loop/switch isn't completed */
_L11:
        break MISSING_BLOCK_LABEL_264;
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

    public final int a()
    {
        return a(false);
    }

    public final b a(boolean flag, b b1, SparseArray sparsearray, SparseArray sparsearray1)
    {
        b b2;
        if (android.support.v4.app.l.a)
        {
            (new StringBuilder("popFromBackStack: ")).append(this);
            a("  ", new PrintWriter(new d("FragmentManager")));
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
        JVM INSTR tableswitch 1 7: default 176
    //                   1 265
    //                   2 299
    //                   3 388
    //                   4 411
    //                   5 440
    //                   6 469
    //                   7 498;
           goto _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L9:
        throw new IllegalArgumentException((new StringBuilder("Unknown cmd: ")).append(((a) (b1)).c).toString());
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
        b.a(sparsearray, android.support.v4.app.l.d(j1), i1);
_L18:
        b1 = ((a) (b1)).b;
          goto _L17
_L11:
        sparsearray = ((a) (b1)).d;
        if (sparsearray != null)
        {
            sparsearray.Q = l1;
            b.a(sparsearray, android.support.v4.app.l.d(j1), i1);
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
        b.c(sparsearray, android.support.v4.app.l.d(j1), i1);
          goto _L18
_L14:
        sparsearray = ((a) (b1)).d;
        sparsearray.Q = l1;
        b.b(sparsearray, android.support.v4.app.l.d(j1), i1);
          goto _L18
_L15:
        sparsearray = ((a) (b1)).d;
        sparsearray.Q = k1;
        b.e(sparsearray, android.support.v4.app.l.d(j1), i1);
          goto _L18
_L16:
        sparsearray = ((a) (b1)).d;
        sparsearray.Q = k1;
        b.d(sparsearray, android.support.v4.app.l.d(j1), i1);
          goto _L18
_L8:
        if (flag)
        {
            b.a(b.n, android.support.v4.app.l.d(j1), i1, true);
            b2 = null;
        }
        if (p < 0) goto _L20; else goto _L19
_L19:
        b1 = b;
        i1 = p;
        b1;
        JVM INSTR monitorenter ;
        ((l) (b1)).k.set(i1, null);
        if (((l) (b1)).l == null)
        {
            b1.l = new ArrayList();
        }
        flag = android.support.v4.app.l.a;
        ((l) (b1)).l.add(Integer.valueOf(i1));
        b1;
        JVM INSTR monitorexit ;
        p = -1;
_L20:
        return b2;
        sparsearray;
        b1;
        JVM INSTR monitorexit ;
        throw sparsearray;
    }

    public final m a(int i1, Fragment fragment)
    {
        a(i1, fragment, ((String) (null)), 1);
        return this;
    }

    public final m a(int i1, Fragment fragment, String s1)
    {
        a(i1, fragment, s1, 1);
        return this;
    }

    public final m a(Fragment fragment)
    {
        a a1 = new a();
        a1.c = 3;
        a1.d = fragment;
        a(a1);
        return this;
    }

    public final m a(Fragment fragment, String s1)
    {
        a(0, fragment, s1, 1);
        return this;
    }

    public final m a(String s1)
    {
        if (!m)
        {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        } else
        {
            l = true;
            n = s1;
            return this;
        }
    }

    final void a(int i1)
    {
        if (l)
        {
            if (android.support.v4.app.l.a)
            {
                (new StringBuilder("Bump nesting in ")).append(this).append(" by ").append(i1);
            }
            a a1 = c;
            while (a1 != null) 
            {
                if (a1.d != null)
                {
                    Fragment fragment = a1.d;
                    fragment.B = fragment.B + i1;
                    if (android.support.v4.app.l.a)
                    {
                        (new StringBuilder("Bump nesting of ")).append(a1.d).append(" to ").append(a1.d.B);
                    }
                }
                if (a1.i != null)
                {
                    for (int j1 = a1.i.size() - 1; j1 >= 0; j1--)
                    {
                        Fragment fragment1 = (Fragment)a1.i.get(j1);
                        fragment1.B = fragment1.B + i1;
                        if (android.support.v4.app.l.a)
                        {
                            (new StringBuilder("Bump nesting of ")).append(fragment1).append(" to ").append(fragment1.B);
                        }
                    }

                }
                a1 = a1.a;
            }
        }
    }

    final void a(a a1)
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

    public final void a(SparseArray sparsearray, SparseArray sparsearray1)
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
    //                   3 150
    //                   4 161
    //                   5 172
    //                   6 183
    //                   7 194;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L4:
        break; /* Loop/switch isn't completed */
_L11:
        break MISSING_BLOCK_LABEL_194;
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

    public final void a(String s1, PrintWriter printwriter)
    {
        a(s1, printwriter, true);
    }

    public final void a(String s1, PrintWriter printwriter, boolean flag)
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
            break MISSING_BLOCK_LABEL_820;
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
    //                   0 699
    //                   1 707
    //                   2 715
    //                   3 723
    //                   4 731
    //                   5 739
    //                   6 747
    //                   7 755;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L11:
        break MISSING_BLOCK_LABEL_755;
_L3:
        String s2 = (new StringBuilder("cmd=")).append(a1.c).toString();
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
        break MISSING_BLOCK_LABEL_804;
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

    public final int b()
    {
        return a(true);
    }

    public final m b(int i1, Fragment fragment, String s1)
    {
        if (i1 == 0)
        {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        } else
        {
            a(i1, fragment, s1, 2);
            return this;
        }
    }

    public final void run()
    {
        if (android.support.v4.app.l.a)
        {
            (new StringBuilder("Run: ")).append(this);
        }
        if (l && p < 0)
        {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        a(1);
        Object obj;
        Object obj1;
        a a1;
        Fragment fragment;
        Fragment fragment1;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        if (a)
        {
            SparseArray sparsearray = new SparseArray();
            obj1 = new SparseArray();
            b(sparsearray, ((SparseArray) (obj1)));
            obj1 = a(sparsearray, ((SparseArray) (obj1)), false);
        } else
        {
            obj1 = null;
        }
        if (obj1 != null)
        {
            i1 = 0;
        } else
        {
            i1 = k;
        }
        if (obj1 != null)
        {
            j1 = 0;
        } else
        {
            j1 = j;
        }
        a1 = c;
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_661;
        }
        if (obj1 != null)
        {
            k1 = 0;
        } else
        {
            k1 = a1.e;
        }
        if (obj1 != null)
        {
            l1 = 0;
        } else
        {
            l1 = a1.f;
        }
        a1.c;
        JVM INSTR tableswitch 1 7: default 172
    //                   1 236
    //                   2 264
    //                   3 531
    //                   4 557
    //                   5 583
    //                   6 609
    //                   7 635;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_635;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown cmd: ")).append(a1.c).toString());
_L2:
        obj = a1.d;
        obj.Q = k1;
        b.a(((Fragment) (obj)), false);
_L12:
        a1 = a1.a;
        if (true) goto _L10; else goto _L9
_L10:
        break MISSING_BLOCK_LABEL_106;
_L9:
        obj = a1.d;
        if (b.g != null)
        {
            i2 = 0;
label0:
            do
            {
label1:
                {
                    fragment = ((Fragment) (obj));
                    if (i2 >= b.g.size())
                    {
                        break label0;
                    }
                    fragment1 = (Fragment)b.g.get(i2);
                    if (android.support.v4.app.l.a)
                    {
                        (new StringBuilder("OP_REPLACE: adding=")).append(obj).append(" old=").append(fragment1);
                    }
                    if (obj != null)
                    {
                        fragment = ((Fragment) (obj));
                        if (fragment1.H != ((Fragment) (obj)).H)
                        {
                            break label1;
                        }
                    }
                    if (fragment1 == obj)
                    {
                        a1.d = null;
                        fragment = null;
                    } else
                    {
                        if (a1.i == null)
                        {
                            a1.i = new ArrayList();
                        }
                        a1.i.add(fragment1);
                        fragment1.Q = l1;
                        if (l)
                        {
                            fragment1.B = fragment1.B + 1;
                            if (android.support.v4.app.l.a)
                            {
                                (new StringBuilder("Bump nesting of ")).append(fragment1).append(" to ").append(fragment1.B);
                            }
                        }
                        b.a(fragment1, j1, i1);
                        fragment = ((Fragment) (obj));
                    }
                }
                i2++;
                obj = fragment;
            } while (true);
        } else
        {
            fragment = ((Fragment) (obj));
        }
        if (fragment != null)
        {
            fragment.Q = k1;
            b.a(fragment, false);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        obj = a1.d;
        obj.Q = l1;
        b.a(((Fragment) (obj)), j1, i1);
        continue; /* Loop/switch isn't completed */
_L5:
        obj = a1.d;
        obj.Q = l1;
        b.b(((Fragment) (obj)), j1, i1);
        continue; /* Loop/switch isn't completed */
_L6:
        obj = a1.d;
        obj.Q = k1;
        b.c(((Fragment) (obj)), j1, i1);
        continue; /* Loop/switch isn't completed */
_L7:
        obj = a1.d;
        obj.Q = l1;
        b.d(((Fragment) (obj)), j1, i1);
        continue; /* Loop/switch isn't completed */
        obj = a1.d;
        obj.Q = k1;
        b.e(((Fragment) (obj)), j1, i1);
        if (true) goto _L12; else goto _L11
_L11:
        b.a(b.n, j1, i1, true);
        if (l)
        {
            obj = b;
            if (((l) (obj)).i == null)
            {
                obj.i = new ArrayList();
            }
            ((l) (obj)).i.add(this);
            ((l) (obj)).j();
        }
        return;
    }

    public final String toString()
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
