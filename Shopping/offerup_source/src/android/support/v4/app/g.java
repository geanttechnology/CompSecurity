// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.support.v4.g.a;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.io.PrintWriter;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            an, ab, l, z, 
//            Fragment, d, k, as, 
//            x, i, h, j, 
//            ar

final class g extends an
    implements Runnable
{

    private static boolean n;
    k a;
    int b;
    int c;
    int d;
    boolean e;
    String f;
    int g;
    int h;
    CharSequence i;
    int j;
    CharSequence k;
    ArrayList l;
    ArrayList m;
    private ab o;
    private k p;
    private boolean q;
    private boolean r;

    public g(ab ab1)
    {
        q = true;
        g = -1;
        o = ab1;
    }

    private int a(boolean flag)
    {
        if (r)
        {
            throw new IllegalStateException("commit already called");
        }
        boolean flag1 = android.support.v4.app.ab.a;
        r = true;
        if (e)
        {
            g = o.a(this);
        } else
        {
            g = -1;
        }
        o.a(this, flag);
        return g;
    }

    private l a(SparseArray sparsearray, SparseArray sparsearray1, boolean flag)
    {
        boolean flag4 = false;
        l l1 = new l(this);
        l1.d = new View(o.i.a);
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
            if (a(sparsearray.keyAt(i1), l1, flag, sparsearray, sparsearray1))
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
                if (a(j1, l1, flag, sparsearray, sparsearray1))
                {
                    flag2 = true;
                }
            }
            k1++;
            flag3 = flag2;
        }
        sparsearray = l1;
        if (!flag3)
        {
            sparsearray = null;
        }
        return sparsearray;
    }

    static a a(g g1, l l1, boolean flag, Fragment fragment)
    {
        a a2 = new a();
        View view = fragment.getView();
        a a1 = a2;
        if (view != null)
        {
            a1 = a2;
            if (g1.l != null)
            {
                android.support.v4.app.d.a(a2, view);
                if (flag)
                {
                    a1 = a(g1.l, g1.m, a2);
                } else
                {
                    a2.a(g1.m);
                    a1 = a2;
                }
            }
        }
        if (flag)
        {
            if (fragment.mExitTransitionCallback != null)
            {
                fragment = fragment.mExitTransitionCallback;
            }
            g1.a(l1, a1, true);
            return a1;
        }
        if (fragment.mEnterTransitionCallback != null)
        {
            g1 = fragment.mEnterTransitionCallback;
        }
        b(l1, a1, true);
        return a1;
    }

    private a a(l l1, Fragment fragment, boolean flag)
    {
        a a2 = new a();
        a a1 = a2;
        if (l != null)
        {
            android.support.v4.app.d.a(a2, fragment.getView());
            if (flag)
            {
                a2.a(m);
                a1 = a2;
            } else
            {
                a1 = a(l, m, a2);
            }
        }
        if (flag)
        {
            if (fragment.mEnterTransitionCallback != null)
            {
                fragment = fragment.mEnterTransitionCallback;
            }
            a(l1, a1, false);
            return a1;
        }
        if (fragment.mExitTransitionCallback != null)
        {
            fragment = fragment.mExitTransitionCallback;
        }
        b(l1, a1, false);
        return a1;
    }

    private static a a(ArrayList arraylist, ArrayList arraylist1, a a1)
    {
        if (a1.isEmpty())
        {
            return a1;
        }
        a a2 = new a();
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

    private void a(int i1, Fragment fragment, String s, int j1)
    {
        fragment.mFragmentManager = o;
        if (s != null)
        {
            if (fragment.mTag != null && !s.equals(fragment.mTag))
            {
                throw new IllegalStateException((new StringBuilder("Can't change tag of fragment ")).append(fragment).append(": was ").append(fragment.mTag).append(" now ").append(s).toString());
            }
            fragment.mTag = s;
        }
        if (i1 != 0)
        {
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != i1)
            {
                throw new IllegalStateException((new StringBuilder("Can't change container ID of fragment ")).append(fragment).append(": was ").append(fragment.mFragmentId).append(" now ").append(i1).toString());
            }
            fragment.mFragmentId = i1;
            fragment.mContainerId = i1;
        }
        s = new k();
        s.c = j1;
        s.d = fragment;
        a(((k) (s)));
    }

    static void a(g g1, l l1, int i1, Object obj)
    {
        g1.a(l1, i1, obj);
    }

    static void a(g g1, l l1, Fragment fragment, Fragment fragment1, boolean flag, a a1)
    {
        if (flag)
        {
            g1 = fragment1.mEnterTransitionCallback;
        } else
        {
            g1 = fragment.mEnterTransitionCallback;
        }
        if (g1 != null)
        {
            new ArrayList(a1.keySet());
            new ArrayList(a1.values());
        }
    }

    static void a(g g1, a a1, l l1)
    {
        if (g1.m != null && !a1.isEmpty())
        {
            g1 = (View)a1.get(g1.m.get(0));
            if (g1 != null)
            {
                l1.c.a = g1;
            }
        }
    }

    private void a(l l1, int i1, Object obj)
    {
        if (o.c != null)
        {
            int j1 = 0;
            while (j1 < o.c.size()) 
            {
                Fragment fragment = (Fragment)o.c.get(j1);
                if (fragment.mView != null && fragment.mContainer != null && fragment.mContainerId == i1)
                {
                    if (fragment.mHidden)
                    {
                        if (!l1.b.contains(fragment.mView))
                        {
                            android.support.v4.app.d.a(obj, fragment.mView, true);
                            l1.b.add(fragment.mView);
                        }
                    } else
                    {
                        android.support.v4.app.d.a(obj, fragment.mView, false);
                        l1.b.remove(fragment.mView);
                    }
                }
                j1++;
            }
        }
    }

    private void a(l l1, a a1, boolean flag)
    {
        int i1;
        int j1;
        if (m == null)
        {
            i1 = 0;
        } else
        {
            i1 = m.size();
        }
        j1 = 0;
        while (j1 < i1) 
        {
            String s = (String)l.get(j1);
            Object obj = (View)a1.get((String)m.get(j1));
            if (obj != null)
            {
                obj = ((View) (obj)).getTransitionName();
                if (flag)
                {
                    a(l1.a, s, ((String) (obj)));
                } else
                {
                    a(l1.a, ((String) (obj)), s);
                }
            }
            j1++;
        }
    }

    private static void a(a a1, String s, String s1)
    {
        if (s == null || s1 == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L6:
        if (i1 >= a1.size())
        {
            break; /* Loop/switch isn't completed */
        }
        if (!s.equals(a1.c(i1))) goto _L4; else goto _L3
_L3:
        a1.a(i1, s1);
_L2:
        return;
_L4:
        i1++;
        if (true) goto _L6; else goto _L5
_L5:
        a1.put(s, s1);
        return;
    }

    private static void a(SparseArray sparsearray, Fragment fragment)
    {
        if (fragment != null)
        {
            int i1 = fragment.mContainerId;
            if (i1 != 0 && !fragment.isHidden() && fragment.isAdded() && fragment.getView() != null && sparsearray.get(i1) == null)
            {
                sparsearray.put(i1, fragment);
            }
        }
    }

    private boolean a(int i1, l l1, boolean flag, SparseArray sparsearray, SparseArray sparsearray1)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Fragment fragment;
        ViewGroup viewgroup;
        ArrayList arraylist;
        viewgroup = (ViewGroup)o.j.a(i1);
        if (viewgroup == null)
        {
            return false;
        }
        obj3 = (Fragment)sparsearray1.get(i1);
        fragment = (Fragment)sparsearray.get(i1);
        if (obj3 == null)
        {
            obj1 = null;
        } else
        {
            if (flag)
            {
                sparsearray = ((SparseArray) (((Fragment) (obj3)).getReenterTransition()));
            } else
            {
                sparsearray = ((SparseArray) (((Fragment) (obj3)).getEnterTransition()));
            }
            obj1 = android.support.v4.app.d.a(sparsearray);
        }
        if (obj3 == null || fragment == null)
        {
            sparsearray = null;
        } else
        {
            if (flag)
            {
                sparsearray = ((SparseArray) (fragment.getSharedElementReturnTransition()));
            } else
            {
                sparsearray = ((SparseArray) (((Fragment) (obj3)).getSharedElementEnterTransition()));
            }
            if (sparsearray == null)
            {
                sparsearray = null;
            } else
            {
                sparsearray1 = (Transition)sparsearray;
                if (sparsearray1 == null)
                {
                    sparsearray = null;
                } else
                {
                    sparsearray = new TransitionSet();
                    sparsearray.addTransition(sparsearray1);
                }
            }
        }
        if (fragment == null)
        {
            sparsearray1 = null;
        } else
        {
            if (flag)
            {
                sparsearray1 = ((SparseArray) (fragment.getReturnTransition()));
            } else
            {
                sparsearray1 = ((SparseArray) (fragment.getExitTransition()));
            }
            sparsearray1 = ((SparseArray) (android.support.v4.app.d.a(sparsearray1)));
        }
        obj = null;
        arraylist = new ArrayList();
        if (sparsearray == null) goto _L2; else goto _L1
_L1:
        obj2 = a(l1, fragment, flag);
        if (!((a) (obj2)).isEmpty()) goto _L4; else goto _L3
_L3:
        obj = null;
        obj2 = null;
_L6:
        if (obj1 == null && obj2 == null && sparsearray1 == null)
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (flag)
        {
            obj = fragment.mEnterTransitionCallback;
        } else
        {
            obj = ((Fragment) (obj3)).mEnterTransitionCallback;
        }
        if (obj != null)
        {
            new ArrayList(((a) (obj2)).keySet());
            new ArrayList(((a) (obj2)).values());
        }
        viewgroup.getViewTreeObserver().addOnPreDrawListener(new i(this, viewgroup, sparsearray, arraylist, l1, flag, ((Fragment) (obj3)), fragment));
        obj = obj2;
_L2:
        obj2 = sparsearray;
        if (true) goto _L6; else goto _L5
_L5:
        ArrayList arraylist1 = new ArrayList();
        sparsearray = l1.d;
        if (sparsearray1 != null)
        {
            sparsearray1 = ((SparseArray) (android.support.v4.app.d.a(sparsearray1, fragment.getView(), arraylist1, ((java.util.Map) (obj)), sparsearray)));
        }
        if (m != null && obj != null)
        {
            sparsearray = (View)((a) (obj)).get(m.get(0));
            if (sparsearray != null)
            {
                if (sparsearray1 != null)
                {
                    android.support.v4.app.d.a(sparsearray1, sparsearray);
                }
                if (obj2 != null)
                {
                    android.support.v4.app.d.a(obj2, sparsearray);
                }
            }
        }
        h h1 = new h(this, ((Fragment) (obj3)));
        ArrayList arraylist2 = new ArrayList();
        a a1 = new a();
        Transition transition;
        if (obj3 != null)
        {
            if (flag)
            {
                flag = ((Fragment) (obj3)).getAllowReturnTransitionOverlap();
            } else
            {
                flag = ((Fragment) (obj3)).getAllowEnterTransitionOverlap();
            }
        } else
        {
            flag = true;
        }
        obj3 = (Transition)obj1;
        sparsearray = (Transition)sparsearray1;
        transition = (Transition)obj2;
        if (obj3 == null || sparsearray == null)
        {
            flag = true;
        }
        if (flag)
        {
            TransitionSet transitionset = new TransitionSet();
            if (obj3 != null)
            {
                transitionset.addTransition(((Transition) (obj3)));
            }
            if (sparsearray != null)
            {
                transitionset.addTransition(sparsearray);
            }
            sparsearray = transitionset;
            if (transition != null)
            {
                transitionset.addTransition(transition);
                sparsearray = transitionset;
            }
        } else
        {
            if (sparsearray != null && obj3 != null)
            {
                sparsearray = (new TransitionSet()).addTransition(sparsearray).addTransition(((Transition) (obj3))).setOrdering(1);
            } else
            if (sparsearray == null)
            {
                sparsearray = ((SparseArray) (obj3));
                if (obj3 == null)
                {
                    sparsearray = null;
                }
            }
            if (transition != null)
            {
                obj3 = new TransitionSet();
                if (sparsearray != null)
                {
                    ((TransitionSet) (obj3)).addTransition(sparsearray);
                }
                ((TransitionSet) (obj3)).addTransition(transition);
                sparsearray = ((SparseArray) (obj3));
            }
        }
        if (sparsearray != null)
        {
            android.support.v4.app.d.a(obj1, obj2, viewgroup, h1, l1.d, l1.c, l1.a, arraylist2, ((java.util.Map) (obj)), a1, arraylist);
            viewgroup.getViewTreeObserver().addOnPreDrawListener(new j(this, viewgroup, l1, i1, sparsearray));
            android.support.v4.app.d.a(sparsearray, l1.d, true);
            a(l1, i1, sparsearray);
            TransitionManager.beginDelayedTransition(viewgroup, (Transition)sparsearray);
            obj = l1.d;
            l1 = l1.b;
            obj1 = (Transition)obj1;
            sparsearray1 = (Transition)sparsearray1;
            obj2 = (Transition)obj2;
            obj3 = (Transition)sparsearray;
            if (obj3 != null)
            {
                viewgroup.getViewTreeObserver().addOnPreDrawListener(new ar(viewgroup, ((Transition) (obj1)), arraylist2, sparsearray1, arraylist1, ((Transition) (obj2)), arraylist, a1, l1, ((Transition) (obj3)), ((View) (obj))));
            }
        }
        return sparsearray != null;
    }

    private static void b(l l1, a a1, boolean flag)
    {
        int j1 = a1.size();
        int i1 = 0;
        while (i1 < j1) 
        {
            String s = (String)a1.b(i1);
            String s1 = ((View)a1.c(i1)).getTransitionName();
            if (flag)
            {
                a(l1.a, s, s1);
            } else
            {
                a(l1.a, s1, s);
            }
            i1++;
        }
    }

    private static void b(SparseArray sparsearray, Fragment fragment)
    {
        if (fragment != null)
        {
            int i1 = fragment.mContainerId;
            if (i1 != 0)
            {
                sparsearray.put(i1, fragment);
            }
        }
    }

    private void b(SparseArray sparsearray, SparseArray sparsearray1)
    {
        if (o.j.a()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        k k1 = a;
_L12:
        if (k1 == null) goto _L1; else goto _L3
_L3:
        k1.c;
        JVM INSTR tableswitch 1 7: default 72
    //                   1 82
    //                   2 94
    //                   3 212
    //                   4 224
    //                   5 236
    //                   6 248
    //                   7 260;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L4:
        break; /* Loop/switch isn't completed */
_L11:
        break MISSING_BLOCK_LABEL_260;
_L13:
        k1 = k1.a;
          goto _L12
_L5:
        b(sparsearray1, k1.d);
          goto _L13
_L6:
        Fragment fragment = k1.d;
        Fragment fragment1;
        if (o.c != null)
        {
            int i1 = 0;
label0:
            do
            {
label1:
                {
                    fragment1 = fragment;
                    if (i1 >= o.c.size())
                    {
                        break label0;
                    }
                    Fragment fragment2 = (Fragment)o.c.get(i1);
                    if (fragment != null)
                    {
                        fragment1 = fragment;
                        if (fragment2.mContainerId != fragment.mContainerId)
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
        a(sparsearray, k1.d);
          goto _L13
_L8:
        a(sparsearray, k1.d);
          goto _L13
_L9:
        b(sparsearray1, k1.d);
          goto _L13
_L10:
        a(sparsearray, k1.d);
          goto _L13
        b(sparsearray1, k1.d);
          goto _L13
    }

    public final an a()
    {
        if (e)
        {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        } else
        {
            q = false;
            return this;
        }
    }

    public final an a(int i1, Fragment fragment)
    {
        a(i1, fragment, ((String) (null)), 1);
        return this;
    }

    public final an a(int i1, Fragment fragment, String s)
    {
        a(i1, fragment, s, 1);
        return this;
    }

    public final an a(Fragment fragment)
    {
        k k1 = new k();
        k1.c = 3;
        k1.d = fragment;
        a(k1);
        return this;
    }

    public final an a(Fragment fragment, String s)
    {
        a(0, fragment, s, 1);
        return this;
    }

    public final an a(String s)
    {
        if (!q)
        {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        } else
        {
            e = true;
            f = null;
            return this;
        }
    }

    public final l a(boolean flag, l l1, SparseArray sparsearray, SparseArray sparsearray1)
    {
        Object obj;
        boolean flag1 = android.support.v4.app.ab.a;
        obj = l1;
        if (!n) goto _L2; else goto _L1
_L1:
        if (l1 != null) goto _L4; else goto _L3
_L3:
        if (sparsearray.size() != 0) goto _L6; else goto _L5
_L5:
        obj = l1;
        if (sparsearray1.size() == 0) goto _L2; else goto _L6
_L6:
        obj = a(sparsearray, sparsearray1, true);
_L2:
        int i1;
        int j1;
        int k1;
        int i2;
        a(-1);
        String s;
        if (obj != null)
        {
            i1 = 0;
        } else
        {
            i1 = d;
        }
        if (obj != null)
        {
            j1 = 0;
        } else
        {
            j1 = c;
        }
        l1 = p;
_L17:
        if (l1 == null) goto _L8; else goto _L7
_L7:
        if (obj != null)
        {
            k1 = 0;
        } else
        {
            k1 = ((k) (l1)).g;
        }
        if (obj != null)
        {
            i2 = 0;
        } else
        {
            i2 = ((k) (l1)).h;
        }
        ((k) (l1)).c;
        JVM INSTR tableswitch 1 7: default 140
    //                   1 287
    //                   2 321
    //                   3 410
    //                   4 433
    //                   5 462
    //                   6 491
    //                   7 520;
           goto _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L9:
        throw new IllegalArgumentException((new StringBuilder("Unknown cmd: ")).append(((k) (l1)).c).toString());
_L4:
        obj = l1;
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        sparsearray = m;
        sparsearray1 = l;
        obj = l1;
        if (sparsearray == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = 0;
        do
        {
            obj = l1;
            if (i1 >= sparsearray.size())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (String)sparsearray.get(i1);
            s = (String)sparsearray1.get(i1);
            a(l1.a, ((String) (obj)), s);
            i1++;
        } while (true);
        continue; /* Loop/switch isn't completed */
_L10:
        sparsearray = ((k) (l1)).d;
        sparsearray.mNextAnim = i2;
        o.a(sparsearray, android.support.v4.app.ab.a(j1), i1);
_L18:
        l1 = ((k) (l1)).b;
          goto _L17
_L11:
        sparsearray = ((k) (l1)).d;
        if (sparsearray != null)
        {
            sparsearray.mNextAnim = i2;
            o.a(sparsearray, android.support.v4.app.ab.a(j1), i1);
        }
        if (((k) (l1)).i != null)
        {
            i2 = 0;
            while (i2 < ((k) (l1)).i.size()) 
            {
                sparsearray = (Fragment)((k) (l1)).i.get(i2);
                sparsearray.mNextAnim = k1;
                o.a(sparsearray, false);
                i2++;
            }
        }
          goto _L18
_L12:
        sparsearray = ((k) (l1)).d;
        sparsearray.mNextAnim = k1;
        o.a(sparsearray, false);
          goto _L18
_L13:
        sparsearray = ((k) (l1)).d;
        sparsearray.mNextAnim = k1;
        o.c(sparsearray, android.support.v4.app.ab.a(j1), i1);
          goto _L18
_L14:
        sparsearray = ((k) (l1)).d;
        sparsearray.mNextAnim = i2;
        o.b(sparsearray, android.support.v4.app.ab.a(j1), i1);
          goto _L18
_L15:
        sparsearray = ((k) (l1)).d;
        sparsearray.mNextAnim = k1;
        o.e(sparsearray, android.support.v4.app.ab.a(j1), i1);
          goto _L18
_L16:
        sparsearray = ((k) (l1)).d;
        sparsearray.mNextAnim = k1;
        o.d(sparsearray, android.support.v4.app.ab.a(j1), i1);
          goto _L18
_L8:
        if (flag)
        {
            o.a(o.h, android.support.v4.app.ab.a(j1), i1, true);
            obj = null;
        }
        if (g < 0) goto _L20; else goto _L19
_L19:
        l1 = o;
        i1 = g;
        l1;
        JVM INSTR monitorenter ;
        ((ab) (l1)).f.set(i1, null);
        if (((ab) (l1)).g == null)
        {
            l1.g = new ArrayList();
        }
        ((ab) (l1)).g.add(Integer.valueOf(i1));
        l1;
        JVM INSTR monitorexit ;
        g = -1;
_L20:
        return ((l) (obj));
        sparsearray;
        l1;
        JVM INSTR monitorexit ;
        throw sparsearray;
        if (true) goto _L2; else goto _L21
_L21:
    }

    final void a(int i1)
    {
        if (e)
        {
            boolean flag = android.support.v4.app.ab.a;
            k k1 = a;
            while (k1 != null) 
            {
                if (k1.d != null)
                {
                    Fragment fragment = k1.d;
                    fragment.mBackStackNesting = fragment.mBackStackNesting + i1;
                    boolean flag1 = android.support.v4.app.ab.a;
                }
                if (k1.i != null)
                {
                    for (int j1 = k1.i.size() - 1; j1 >= 0; j1--)
                    {
                        Fragment fragment1 = (Fragment)k1.i.get(j1);
                        fragment1.mBackStackNesting = fragment1.mBackStackNesting + i1;
                        boolean flag2 = android.support.v4.app.ab.a;
                    }

                }
                k1 = k1.a;
            }
        }
    }

    final void a(k k1)
    {
        if (a == null)
        {
            p = k1;
            a = k1;
        } else
        {
            k1.b = p;
            p.a = k1;
            p = k1;
        }
        k1.e = 0;
        k1.f = 0;
        k1.g = 0;
        k1.h = 0;
        b = b + 1;
    }

    public final void a(SparseArray sparsearray, SparseArray sparsearray1)
    {
        if (o.j.a()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        k k1 = a;
_L12:
        if (k1 == null) goto _L1; else goto _L3
_L3:
        k1.c;
        JVM INSTR tableswitch 1 7: default 68
    //                   1 76
    //                   2 87
    //                   3 146
    //                   4 157
    //                   5 168
    //                   6 179
    //                   7 190;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L4:
        break; /* Loop/switch isn't completed */
_L11:
        break MISSING_BLOCK_LABEL_190;
_L13:
        k1 = k1.a;
          goto _L12
_L5:
        a(sparsearray, k1.d);
          goto _L13
_L6:
        if (k1.i != null)
        {
            for (int i1 = k1.i.size() - 1; i1 >= 0; i1--)
            {
                b(sparsearray1, (Fragment)k1.i.get(i1));
            }

        }
        a(sparsearray, k1.d);
          goto _L13
_L7:
        b(sparsearray1, k1.d);
          goto _L13
_L8:
        b(sparsearray1, k1.d);
          goto _L13
_L9:
        a(sparsearray, k1.d);
          goto _L13
_L10:
        b(sparsearray1, k1.d);
          goto _L13
        a(sparsearray, k1.d);
          goto _L13
    }

    public final void a(String s, PrintWriter printwriter)
    {
        k k1;
        String s2;
        int i1;
        printwriter.print(s);
        printwriter.print("mName=");
        printwriter.print(f);
        printwriter.print(" mIndex=");
        printwriter.print(g);
        printwriter.print(" mCommitted=");
        printwriter.println(r);
        if (c != 0)
        {
            printwriter.print(s);
            printwriter.print("mTransition=#");
            printwriter.print(Integer.toHexString(c));
            printwriter.print(" mTransitionStyle=#");
            printwriter.println(Integer.toHexString(d));
        }
        if (h != 0 || i != null)
        {
            printwriter.print(s);
            printwriter.print("mBreadCrumbTitleRes=#");
            printwriter.print(Integer.toHexString(h));
            printwriter.print(" mBreadCrumbTitleText=");
            printwriter.println(i);
        }
        if (j != 0 || k != null)
        {
            printwriter.print(s);
            printwriter.print("mBreadCrumbShortTitleRes=#");
            printwriter.print(Integer.toHexString(j));
            printwriter.print(" mBreadCrumbShortTitleText=");
            printwriter.println(k);
        }
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_690;
        }
        printwriter.print(s);
        printwriter.println("Operations:");
        s2 = (new StringBuilder()).append(s).append("    ").toString();
        k1 = a;
        i1 = 0;
_L13:
        if (k1 == null) goto _L2; else goto _L1
_L1:
        k1.c;
        JVM INSTR tableswitch 0 7: default 308
    //                   0 577
    //                   1 584
    //                   2 591
    //                   3 598
    //                   4 605
    //                   5 612
    //                   6 619
    //                   7 626;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L11:
        break MISSING_BLOCK_LABEL_626;
_L3:
        String s1 = (new StringBuilder("cmd=")).append(k1.c).toString();
_L12:
        printwriter.print(s);
        printwriter.print("  Op #");
        printwriter.print(i1);
        printwriter.print(": ");
        printwriter.print(s1);
        printwriter.print(" ");
        printwriter.println(k1.d);
        if (k1.e != 0 || k1.f != 0)
        {
            printwriter.print(s);
            printwriter.print("enterAnim=#");
            printwriter.print(Integer.toHexString(k1.e));
            printwriter.print(" exitAnim=#");
            printwriter.println(Integer.toHexString(k1.f));
        }
        if (k1.g != 0 || k1.h != 0)
        {
            printwriter.print(s);
            printwriter.print("popEnterAnim=#");
            printwriter.print(Integer.toHexString(k1.g));
            printwriter.print(" popExitAnim=#");
            printwriter.println(Integer.toHexString(k1.h));
        }
        if (k1.i != null && k1.i.size() > 0)
        {
            int j1 = 0;
            while (j1 < k1.i.size()) 
            {
                printwriter.print(s2);
                if (k1.i.size() == 1)
                {
                    printwriter.print("Removed: ");
                } else
                {
                    if (j1 == 0)
                    {
                        printwriter.println("Removed:");
                    }
                    printwriter.print(s2);
                    printwriter.print("  #");
                    printwriter.print(j1);
                    printwriter.print(": ");
                }
                printwriter.println(k1.i.get(j1));
                j1++;
            }
        }
        break MISSING_BLOCK_LABEL_674;
_L4:
        s1 = "NULL";
          goto _L12
_L5:
        s1 = "ADD";
          goto _L12
_L6:
        s1 = "REPLACE";
          goto _L12
_L7:
        s1 = "REMOVE";
          goto _L12
_L8:
        s1 = "HIDE";
          goto _L12
_L9:
        s1 = "SHOW";
          goto _L12
_L10:
        s1 = "DETACH";
          goto _L12
        s1 = "ATTACH";
          goto _L12
        k1 = k1.a;
        i1++;
          goto _L13
_L2:
    }

    public final int b()
    {
        return a(false);
    }

    public final an b(int i1, Fragment fragment)
    {
        return b(i1, fragment, ((String) (null)));
    }

    public final an b(int i1, Fragment fragment, String s)
    {
        if (i1 == 0)
        {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        } else
        {
            a(i1, fragment, s, 2);
            return this;
        }
    }

    public final an b(Fragment fragment)
    {
        k k1 = new k();
        k1.c = 4;
        k1.d = fragment;
        a(k1);
        return this;
    }

    public final int c()
    {
        return a(true);
    }

    public final an c(Fragment fragment)
    {
        k k1 = new k();
        k1.c = 5;
        k1.d = fragment;
        a(k1);
        return this;
    }

    public final an d(Fragment fragment)
    {
        k k1 = new k();
        k1.c = 6;
        k1.d = fragment;
        a(k1);
        return this;
    }

    public final an e(Fragment fragment)
    {
        k k1 = new k();
        k1.c = 7;
        k1.d = fragment;
        a(k1);
        return this;
    }

    public final void run()
    {
        boolean flag = android.support.v4.app.ab.a;
        if (e && g < 0)
        {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        a(1);
        Object obj;
        Object obj1;
        k k1;
        Fragment fragment;
        Fragment fragment1;
        int i1;
        int j1;
        int l1;
        int i2;
        int j2;
        int k2;
        if (n)
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
            i1 = d;
        }
        if (obj1 != null)
        {
            j1 = 0;
        } else
        {
            j1 = c;
        }
        k1 = a;
        if (k1 == null)
        {
            break MISSING_BLOCK_LABEL_587;
        }
        if (obj1 != null)
        {
            l1 = 0;
        } else
        {
            l1 = k1.e;
        }
        if (obj1 != null)
        {
            i2 = 0;
        } else
        {
            i2 = k1.f;
        }
        k1.c;
        JVM INSTR tableswitch 1 7: default 156
    //                   1 220
    //                   2 248
    //                   3 457
    //                   4 483
    //                   5 509
    //                   6 535
    //                   7 561;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_561;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown cmd: ")).append(k1.c).toString());
_L2:
        obj = k1.d;
        obj.mNextAnim = l1;
        o.a(((Fragment) (obj)), false);
_L12:
        k1 = k1.a;
        if (true) goto _L10; else goto _L9
_L10:
        break MISSING_BLOCK_LABEL_90;
_L9:
        obj = k1.d;
        k2 = ((Fragment) (obj)).mContainerId;
        if (o.c != null)
        {
            j2 = 0;
            do
            {
                fragment = ((Fragment) (obj));
                if (j2 >= o.c.size())
                {
                    break;
                }
                fragment1 = (Fragment)o.c.get(j2);
                flag = android.support.v4.app.ab.a;
                fragment = ((Fragment) (obj));
                if (fragment1.mContainerId == k2)
                {
                    if (fragment1 == obj)
                    {
                        k1.d = null;
                        fragment = null;
                    } else
                    {
                        if (k1.i == null)
                        {
                            k1.i = new ArrayList();
                        }
                        k1.i.add(fragment1);
                        fragment1.mNextAnim = i2;
                        if (e)
                        {
                            fragment1.mBackStackNesting = fragment1.mBackStackNesting + 1;
                            flag = android.support.v4.app.ab.a;
                        }
                        o.a(fragment1, j1, i1);
                        fragment = ((Fragment) (obj));
                    }
                }
                j2++;
                obj = fragment;
            } while (true);
        } else
        {
            fragment = ((Fragment) (obj));
        }
        if (fragment != null)
        {
            fragment.mNextAnim = l1;
            o.a(fragment, false);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        obj = k1.d;
        obj.mNextAnim = i2;
        o.a(((Fragment) (obj)), j1, i1);
        continue; /* Loop/switch isn't completed */
_L5:
        obj = k1.d;
        obj.mNextAnim = i2;
        o.b(((Fragment) (obj)), j1, i1);
        continue; /* Loop/switch isn't completed */
_L6:
        obj = k1.d;
        obj.mNextAnim = l1;
        o.c(((Fragment) (obj)), j1, i1);
        continue; /* Loop/switch isn't completed */
_L7:
        obj = k1.d;
        obj.mNextAnim = i2;
        o.d(((Fragment) (obj)), j1, i1);
        continue; /* Loop/switch isn't completed */
        obj = k1.d;
        obj.mNextAnim = l1;
        o.e(((Fragment) (obj)), j1, i1);
        if (true) goto _L12; else goto _L11
_L11:
        o.a(o.h, j1, i1, true);
        if (e)
        {
            obj = o;
            if (((ab) (obj)).e == null)
            {
                obj.e = new ArrayList();
            }
            ((ab) (obj)).e.add(this);
        }
        return;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("BackStackEntry{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (g >= 0)
        {
            stringbuilder.append(" #");
            stringbuilder.append(g);
        }
        if (f != null)
        {
            stringbuilder.append(" ");
            stringbuilder.append(f);
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
        n = flag;
    }
}
