// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.support.v4.c.a;
import android.support.v4.c.e;
import android.support.v4.c.f;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.io.PrintWriter;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            ar, ai, w, Fragment, 
//            as, ax, ag, s, 
//            t, u, v

final class r extends ar
    implements Runnable
{

    final ai a;
    v b;
    v c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    boolean k;
    boolean l;
    String m;
    boolean n;
    int o;
    int p;
    CharSequence q;
    int r;
    CharSequence s;
    ArrayList t;
    ArrayList u;

    public r(ai ai1)
    {
        l = true;
        o = -1;
        a = ai1;
    }

    private int a(boolean flag)
    {
        if (n)
        {
            throw new IllegalStateException("commit already called");
        }
        if (android.support.v4.app.ai.a)
        {
            Log.v("FragmentManager", (new StringBuilder("Commit: ")).append(this).toString());
            a("  ", new PrintWriter(new e("FragmentManager")));
        }
        n = true;
        if (k)
        {
            o = a.a(this);
        } else
        {
            o = -1;
        }
        a.a(this, flag);
        return o;
    }

    private w a(SparseArray sparsearray, SparseArray sparsearray1, boolean flag)
    {
        boolean flag4 = false;
        w w1 = new w(this);
        w1.d = new View(a.o);
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
            if (a(sparsearray.keyAt(i1), w1, flag, sparsearray, sparsearray1))
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
                if (a(j1, w1, flag, sparsearray, sparsearray1))
                {
                    flag2 = true;
                }
            }
            k1++;
            flag3 = flag2;
        }
        sparsearray = w1;
        if (!flag3)
        {
            sparsearray = null;
        }
        return sparsearray;
    }

    static a a(r r1, w w1, boolean flag, Fragment fragment)
    {
        a a2 = new a();
        View view = fragment.getView();
        a a1 = a2;
        if (view != null)
        {
            a1 = a2;
            if (r1.t != null)
            {
                android.support.v4.app.as.a(a2, view);
                if (flag)
                {
                    a1 = a(r1.t, r1.u, a2);
                } else
                {
                    android.support.v4.c.f.a(a2, r1.u);
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
            r1.a(w1, a1, true);
            return a1;
        }
        if (fragment.mEnterTransitionCallback != null)
        {
            r1 = fragment.mEnterTransitionCallback;
        }
        b(w1, a1, true);
        return a1;
    }

    private a a(w w1, Fragment fragment, boolean flag)
    {
        a a2 = new a();
        a a1 = a2;
        if (t != null)
        {
            android.support.v4.app.as.a(a2, fragment.getView());
            if (flag)
            {
                android.support.v4.c.f.a(a2, u);
                a1 = a2;
            } else
            {
                a1 = a(t, u, a2);
            }
        }
        if (flag)
        {
            if (fragment.mEnterTransitionCallback != null)
            {
                fragment = fragment.mEnterTransitionCallback;
            }
            a(w1, a1, false);
            return a1;
        }
        if (fragment.mExitTransitionCallback != null)
        {
            fragment = fragment.mExitTransitionCallback;
        }
        b(w1, a1, false);
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

    static void a(Fragment fragment, Fragment fragment1, boolean flag, a a1)
    {
        if (flag)
        {
            fragment = fragment1.mEnterTransitionCallback;
        } else
        {
            fragment = fragment.mEnterTransitionCallback;
        }
        if (fragment != null)
        {
            new ArrayList(a1.keySet());
            new ArrayList(a1.values());
        }
    }

    static void a(r r1, w w1, int i1, Object obj)
    {
        r1.a(w1, i1, obj);
    }

    static void a(r r1, a a1, w w1)
    {
        if (r1.u != null && !a1.isEmpty())
        {
            r1 = (View)a1.get(r1.u.get(0));
            if (r1 != null)
            {
                w1.c.a = r1;
            }
        }
    }

    private void a(w w1, int i1, Object obj)
    {
        if (a.g != null)
        {
            int j1 = 0;
            while (j1 < a.g.size()) 
            {
                Fragment fragment = (Fragment)a.g.get(j1);
                if (fragment.mView != null && fragment.mContainer != null && fragment.mContainerId == i1)
                {
                    if (fragment.mHidden)
                    {
                        if (!w1.b.contains(fragment.mView))
                        {
                            android.support.v4.app.as.a(obj, fragment.mView, true);
                            w1.b.add(fragment.mView);
                        }
                    } else
                    {
                        android.support.v4.app.as.a(obj, fragment.mView, false);
                        w1.b.remove(fragment.mView);
                    }
                }
                j1++;
            }
        }
    }

    private void a(w w1, a a1, boolean flag)
    {
        int i1;
        int j1;
        if (u == null)
        {
            i1 = 0;
        } else
        {
            i1 = u.size();
        }
        j1 = 0;
        while (j1 < i1) 
        {
            String s1 = (String)t.get(j1);
            Object obj = (View)a1.get((String)u.get(j1));
            if (obj != null)
            {
                obj = android.support.v4.app.as.a(((View) (obj)));
                if (flag)
                {
                    a(w1.a, s1, ((String) (obj)));
                } else
                {
                    a(w1.a, ((String) (obj)), s1);
                }
            }
            j1++;
        }
    }

    private static void a(w w1, ArrayList arraylist, ArrayList arraylist1)
    {
        if (arraylist != null)
        {
            for (int i1 = 0; i1 < arraylist.size(); i1++)
            {
                String s1 = (String)arraylist.get(i1);
                String s2 = (String)arraylist1.get(i1);
                a(w1.a, s1, s2);
            }

        }
    }

    private static void a(a a1, String s1, String s2)
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
            int i1 = fragment.mContainerId;
            if (i1 != 0 && !fragment.isHidden() && fragment.isAdded() && fragment.getView() != null && sparsearray.get(i1) == null)
            {
                sparsearray.put(i1, fragment);
            }
        }
    }

    private boolean a(int i1, w w1, boolean flag, SparseArray sparsearray, SparseArray sparsearray1)
    {
        ViewGroup viewgroup = (ViewGroup)a.p.a(i1);
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
            sparsearray1 = ((SparseArray) (android.support.v4.app.as.a(sparsearray)));
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
            obj = android.support.v4.app.as.a(sparsearray);
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
            sparsearray = ((SparseArray) (android.support.v4.app.as.a(sparsearray)));
        }
        if (sparsearray1 == null && obj == null && sparsearray == null)
        {
            return false;
        }
        Object obj2 = null;
        ArrayList arraylist = new ArrayList();
        if (obj != null)
        {
            Object obj3 = a(w1, ((Fragment) (obj5)), flag);
            Object obj1;
            if (((a) (obj3)).isEmpty())
            {
                arraylist.add(w1.d);
            } else
            {
                arraylist.addAll(((a) (obj3)).values());
            }
            if (flag)
            {
                obj1 = ((Fragment) (obj5)).mEnterTransitionCallback;
            } else
            {
                obj1 = ((Fragment) (obj4)).mEnterTransitionCallback;
            }
            obj2 = obj3;
            if (obj1 != null)
            {
                new ArrayList(((a) (obj3)).keySet());
                new ArrayList(((a) (obj3)).values());
                obj2 = obj3;
            }
        }
        obj3 = new ArrayList();
        obj1 = sparsearray;
        if (sparsearray != null)
        {
            obj1 = android.support.v4.app.as.a(sparsearray, ((Fragment) (obj5)).getView(), ((ArrayList) (obj3)), ((java.util.Map) (obj2)));
        }
        if (u != null && obj2 != null)
        {
            sparsearray = (View)((a) (obj2)).get(u.get(0));
            if (sparsearray != null)
            {
                if (obj1 != null)
                {
                    android.support.v4.app.as.a(obj1, sparsearray);
                }
                if (obj != null)
                {
                    android.support.v4.app.as.a(obj, sparsearray);
                }
            }
        }
        sparsearray = new s(this, ((Fragment) (obj4)));
        if (obj != null)
        {
            viewgroup.getViewTreeObserver().addOnPreDrawListener(new t(this, viewgroup, obj, arraylist, w1, flag, ((Fragment) (obj4)), ((Fragment) (obj5))));
        }
        obj2 = new ArrayList();
        obj5 = new a();
        if (flag)
        {
            flag = ((Fragment) (obj4)).getAllowReturnTransitionOverlap();
        } else
        {
            flag = ((Fragment) (obj4)).getAllowEnterTransitionOverlap();
        }
        obj4 = android.support.v4.app.as.a(sparsearray1, obj1, obj, flag);
        if (obj4 != null)
        {
            android.support.v4.app.as.a(sparsearray1, obj, viewgroup, sparsearray, w1.d, w1.c, w1.a, ((ArrayList) (obj2)), ((java.util.Map) (obj5)), arraylist);
            viewgroup.getViewTreeObserver().addOnPreDrawListener(new u(this, viewgroup, w1, i1, obj4));
            android.support.v4.app.as.a(obj4, w1.d, true);
            a(w1, i1, obj4);
            android.support.v4.app.as.a(viewgroup, obj4);
            android.support.v4.app.as.a(viewgroup, w1.d, sparsearray1, ((ArrayList) (obj2)), obj1, ((ArrayList) (obj3)), obj, arraylist, obj4, w1.b, ((java.util.Map) (obj5)));
        }
        return obj4 != null;
    }

    private void b(int i1, Fragment fragment, String s1)
    {
        fragment.mFragmentManager = a;
        if (s1 != null)
        {
            if (fragment.mTag != null && !s1.equals(fragment.mTag))
            {
                throw new IllegalStateException((new StringBuilder("Can't change tag of fragment ")).append(fragment).append(": was ").append(fragment.mTag).append(" now ").append(s1).toString());
            }
            fragment.mTag = s1;
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
        s1 = new v();
        s1.c = 1;
        s1.d = fragment;
        a(s1);
    }

    private static void b(w w1, a a1, boolean flag)
    {
        int j1 = a1.size();
        int i1 = 0;
        while (i1 < j1) 
        {
            String s1 = (String)a1.b(i1);
            String s2 = android.support.v4.app.as.a((View)a1.c(i1));
            if (flag)
            {
                a(w1.a, s1, s2);
            } else
            {
                a(w1.a, s2, s1);
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
        if (a.p.a()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        v v1 = b;
_L12:
        if (v1 == null) goto _L1; else goto _L3
_L3:
        v1.c;
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
        v1 = v1.a;
          goto _L12
_L5:
        b(sparsearray1, v1.d);
          goto _L13
_L6:
        Fragment fragment = v1.d;
        Fragment fragment1;
        if (a.g != null)
        {
            int i1 = 0;
label0:
            do
            {
label1:
                {
                    fragment1 = fragment;
                    if (i1 >= a.g.size())
                    {
                        break label0;
                    }
                    Fragment fragment2 = (Fragment)a.g.get(i1);
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
        a(sparsearray, v1.d);
          goto _L13
_L8:
        a(sparsearray, v1.d);
          goto _L13
_L9:
        b(sparsearray1, v1.d);
          goto _L13
_L10:
        a(sparsearray, v1.d);
          goto _L13
        b(sparsearray1, v1.d);
          goto _L13
    }

    public final int a()
    {
        return a(false);
    }

    public final ar a(int i1, Fragment fragment, String s1)
    {
        b(i1, fragment, s1);
        return this;
    }

    public final ar a(Fragment fragment)
    {
        v v1 = new v();
        v1.c = 3;
        v1.d = fragment;
        a(v1);
        return this;
    }

    public final ar a(Fragment fragment, String s1)
    {
        b(0, fragment, s1);
        return this;
    }

    public final w a(boolean flag, w w1, SparseArray sparsearray, SparseArray sparsearray1)
    {
        w w2;
        int i1;
        int j1;
        int k1;
        int l1;
        if (android.support.v4.app.ai.a)
        {
            Log.v("FragmentManager", (new StringBuilder("popFromBackStack: ")).append(this).toString());
            a("  ", new PrintWriter(new e("FragmentManager")));
        }
        if (w1 == null)
        {
label0:
            {
                if (sparsearray.size() == 0)
                {
                    w2 = w1;
                    if (sparsearray1.size() == 0)
                    {
                        break label0;
                    }
                }
                w2 = a(sparsearray, sparsearray1, true);
            }
        } else
        {
            w2 = w1;
            if (!flag)
            {
                a(w1, u, t);
                w2 = w1;
            }
        }
        a(-1);
        if (w2 != null)
        {
            i1 = 0;
        } else
        {
            i1 = j;
        }
        if (w2 != null)
        {
            j1 = 0;
        } else
        {
            j1 = i;
        }
        w1 = c;
_L10:
        if (w1 == null)
        {
            break MISSING_BLOCK_LABEL_527;
        }
        if (w2 != null)
        {
            k1 = 0;
        } else
        {
            k1 = ((v) (w1)).g;
        }
        if (w2 != null)
        {
            l1 = 0;
        } else
        {
            l1 = ((v) (w1)).h;
        }
        ((v) (w1)).c;
        JVM INSTR tableswitch 1 7: default 176
    //                   1 265
    //                   2 299
    //                   3 388
    //                   4 411
    //                   5 440
    //                   6 469
    //                   7 498;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_498;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown cmd: ")).append(((v) (w1)).c).toString());
_L2:
        sparsearray = ((v) (w1)).d;
        sparsearray.mNextAnim = l1;
        a.a(sparsearray, ai.c(j1), i1);
_L11:
        w1 = ((v) (w1)).b;
        if (true) goto _L10; else goto _L9
_L9:
        sparsearray = ((v) (w1)).d;
        if (sparsearray != null)
        {
            sparsearray.mNextAnim = l1;
            a.a(sparsearray, ai.c(j1), i1);
        }
        if (((v) (w1)).i != null)
        {
            l1 = 0;
            while (l1 < ((v) (w1)).i.size()) 
            {
                sparsearray = (Fragment)((v) (w1)).i.get(l1);
                sparsearray.mNextAnim = k1;
                a.a(sparsearray, false);
                l1++;
            }
        }
          goto _L11
_L4:
        sparsearray = ((v) (w1)).d;
        sparsearray.mNextAnim = k1;
        a.a(sparsearray, false);
          goto _L11
_L5:
        sparsearray = ((v) (w1)).d;
        sparsearray.mNextAnim = k1;
        a.c(sparsearray, ai.c(j1), i1);
          goto _L11
_L6:
        sparsearray = ((v) (w1)).d;
        sparsearray.mNextAnim = l1;
        a.b(sparsearray, ai.c(j1), i1);
          goto _L11
_L7:
        sparsearray = ((v) (w1)).d;
        sparsearray.mNextAnim = k1;
        a.e(sparsearray, ai.c(j1), i1);
          goto _L11
        sparsearray = ((v) (w1)).d;
        sparsearray.mNextAnim = k1;
        a.d(sparsearray, ai.c(j1), i1);
          goto _L11
        if (flag)
        {
            a.a(a.n, ai.c(j1), i1, true);
            w2 = null;
        }
        if (o < 0)
        {
            break MISSING_BLOCK_LABEL_655;
        }
        w1 = a;
        i1 = o;
        w1;
        JVM INSTR monitorenter ;
        ((ai) (w1)).k.set(i1, null);
        if (((ai) (w1)).l == null)
        {
            w1.l = new ArrayList();
        }
        if (android.support.v4.app.ai.a)
        {
            Log.v("FragmentManager", (new StringBuilder("Freeing back stack index ")).append(i1).toString());
        }
        ((ai) (w1)).l.add(Integer.valueOf(i1));
        w1;
        JVM INSTR monitorexit ;
        o = -1;
        return w2;
        sparsearray;
        w1;
        JVM INSTR monitorexit ;
        throw sparsearray;
    }

    final void a(int i1)
    {
        if (k)
        {
            if (android.support.v4.app.ai.a)
            {
                Log.v("FragmentManager", (new StringBuilder("Bump nesting in ")).append(this).append(" by ").append(i1).toString());
            }
            v v1 = b;
            while (v1 != null) 
            {
                if (v1.d != null)
                {
                    Fragment fragment = v1.d;
                    fragment.mBackStackNesting = fragment.mBackStackNesting + i1;
                    if (android.support.v4.app.ai.a)
                    {
                        Log.v("FragmentManager", (new StringBuilder("Bump nesting of ")).append(v1.d).append(" to ").append(v1.d.mBackStackNesting).toString());
                    }
                }
                if (v1.i != null)
                {
                    for (int j1 = v1.i.size() - 1; j1 >= 0; j1--)
                    {
                        Fragment fragment1 = (Fragment)v1.i.get(j1);
                        fragment1.mBackStackNesting = fragment1.mBackStackNesting + i1;
                        if (android.support.v4.app.ai.a)
                        {
                            Log.v("FragmentManager", (new StringBuilder("Bump nesting of ")).append(fragment1).append(" to ").append(fragment1.mBackStackNesting).toString());
                        }
                    }

                }
                v1 = v1.a;
            }
        }
    }

    final void a(v v1)
    {
        if (b == null)
        {
            c = v1;
            b = v1;
        } else
        {
            v1.b = c;
            c.a = v1;
            c = v1;
        }
        v1.e = e;
        v1.f = f;
        v1.g = g;
        v1.h = h;
        d = d + 1;
    }

    public final void a(SparseArray sparsearray, SparseArray sparsearray1)
    {
        if (a.p.a()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        v v1 = b;
_L12:
        if (v1 == null) goto _L1; else goto _L3
_L3:
        v1.c;
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
        v1 = v1.a;
          goto _L12
_L5:
        a(sparsearray, v1.d);
          goto _L13
_L6:
        if (v1.i != null)
        {
            for (int i1 = v1.i.size() - 1; i1 >= 0; i1--)
            {
                b(sparsearray1, (Fragment)v1.i.get(i1));
            }

        }
        a(sparsearray, v1.d);
          goto _L13
_L7:
        b(sparsearray1, v1.d);
          goto _L13
_L8:
        b(sparsearray1, v1.d);
          goto _L13
_L9:
        a(sparsearray, v1.d);
          goto _L13
_L10:
        b(sparsearray1, v1.d);
          goto _L13
        a(sparsearray, v1.d);
          goto _L13
    }

    public final void a(String s1, PrintWriter printwriter)
    {
        a(s1, printwriter, true);
    }

    public final void a(String s1, PrintWriter printwriter, boolean flag)
    {
        v v1;
        String s3;
        int i1;
        if (flag)
        {
            printwriter.print(s1);
            printwriter.print("mName=");
            printwriter.print(m);
            printwriter.print(" mIndex=");
            printwriter.print(o);
            printwriter.print(" mCommitted=");
            printwriter.println(n);
            if (i != 0)
            {
                printwriter.print(s1);
                printwriter.print("mTransition=#");
                printwriter.print(Integer.toHexString(i));
                printwriter.print(" mTransitionStyle=#");
                printwriter.println(Integer.toHexString(j));
            }
            if (e != 0 || f != 0)
            {
                printwriter.print(s1);
                printwriter.print("mEnterAnim=#");
                printwriter.print(Integer.toHexString(e));
                printwriter.print(" mExitAnim=#");
                printwriter.println(Integer.toHexString(f));
            }
            if (g != 0 || h != 0)
            {
                printwriter.print(s1);
                printwriter.print("mPopEnterAnim=#");
                printwriter.print(Integer.toHexString(g));
                printwriter.print(" mPopExitAnim=#");
                printwriter.println(Integer.toHexString(h));
            }
            if (p != 0 || q != null)
            {
                printwriter.print(s1);
                printwriter.print("mBreadCrumbTitleRes=#");
                printwriter.print(Integer.toHexString(p));
                printwriter.print(" mBreadCrumbTitleText=");
                printwriter.println(q);
            }
            if (r != 0 || s != null)
            {
                printwriter.print(s1);
                printwriter.print("mBreadCrumbShortTitleRes=#");
                printwriter.print(Integer.toHexString(r));
                printwriter.print(" mBreadCrumbShortTitleText=");
                printwriter.println(s);
            }
        }
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_820;
        }
        printwriter.print(s1);
        printwriter.println("Operations:");
        s3 = (new StringBuilder()).append(s1).append("    ").toString();
        v1 = b;
        i1 = 0;
_L13:
        if (v1 == null) goto _L2; else goto _L1
_L1:
        v1.c;
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
        String s2 = (new StringBuilder("cmd=")).append(v1.c).toString();
_L12:
        printwriter.print(s1);
        printwriter.print("  Op #");
        printwriter.print(i1);
        printwriter.print(": ");
        printwriter.print(s2);
        printwriter.print(" ");
        printwriter.println(v1.d);
        if (flag)
        {
            if (v1.e != 0 || v1.f != 0)
            {
                printwriter.print(s1);
                printwriter.print("enterAnim=#");
                printwriter.print(Integer.toHexString(v1.e));
                printwriter.print(" exitAnim=#");
                printwriter.println(Integer.toHexString(v1.f));
            }
            if (v1.g != 0 || v1.h != 0)
            {
                printwriter.print(s1);
                printwriter.print("popEnterAnim=#");
                printwriter.print(Integer.toHexString(v1.g));
                printwriter.print(" popExitAnim=#");
                printwriter.println(Integer.toHexString(v1.h));
            }
        }
        if (v1.i != null && v1.i.size() > 0)
        {
            int j1 = 0;
            while (j1 < v1.i.size()) 
            {
                printwriter.print(s3);
                if (v1.i.size() == 1)
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
                printwriter.println(v1.i.get(j1));
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
        v1 = v1.a;
        i1++;
          goto _L13
_L2:
    }

    public final int b()
    {
        return a(true);
    }

    public final ar b(Fragment fragment)
    {
        v v1 = new v();
        v1.c = 6;
        v1.d = fragment;
        a(v1);
        return this;
    }

    public final ar c(Fragment fragment)
    {
        v v1 = new v();
        v1.c = 7;
        v1.d = fragment;
        a(v1);
        return this;
    }

    public final void run()
    {
        if (android.support.v4.app.ai.a)
        {
            Log.v("FragmentManager", (new StringBuilder("Run: ")).append(this).toString());
        }
        if (k && o < 0)
        {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        a(1);
        Object obj;
        Object obj1;
        v v1;
        Fragment fragment;
        Fragment fragment1;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        if (android.os.Build.VERSION.SDK_INT >= 21)
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
            i1 = j;
        }
        if (obj1 != null)
        {
            j1 = 0;
        } else
        {
            j1 = i;
        }
        v1 = b;
        if (v1 == null)
        {
            break MISSING_BLOCK_LABEL_685;
        }
        if (obj1 != null)
        {
            k1 = 0;
        } else
        {
            k1 = v1.e;
        }
        if (obj1 != null)
        {
            l1 = 0;
        } else
        {
            l1 = v1.f;
        }
        v1.c;
        JVM INSTR tableswitch 1 7: default 180
    //                   1 244
    //                   2 272
    //                   3 555
    //                   4 581
    //                   5 607
    //                   6 633
    //                   7 659;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_659;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown cmd: ")).append(v1.c).toString());
_L2:
        obj = v1.d;
        obj.mNextAnim = k1;
        a.a(((Fragment) (obj)), false);
_L12:
        v1 = v1.a;
        if (true) goto _L10; else goto _L9
_L10:
        break MISSING_BLOCK_LABEL_116;
_L9:
        obj = v1.d;
        if (a.g != null)
        {
            i2 = 0;
label0:
            do
            {
label1:
                {
                    fragment = ((Fragment) (obj));
                    if (i2 >= a.g.size())
                    {
                        break label0;
                    }
                    fragment1 = (Fragment)a.g.get(i2);
                    if (android.support.v4.app.ai.a)
                    {
                        Log.v("FragmentManager", (new StringBuilder("OP_REPLACE: adding=")).append(obj).append(" old=").append(fragment1).toString());
                    }
                    if (obj != null)
                    {
                        fragment = ((Fragment) (obj));
                        if (fragment1.mContainerId != ((Fragment) (obj)).mContainerId)
                        {
                            break label1;
                        }
                    }
                    if (fragment1 == obj)
                    {
                        v1.d = null;
                        fragment = null;
                    } else
                    {
                        if (v1.i == null)
                        {
                            v1.i = new ArrayList();
                        }
                        v1.i.add(fragment1);
                        fragment1.mNextAnim = l1;
                        if (k)
                        {
                            fragment1.mBackStackNesting = fragment1.mBackStackNesting + 1;
                            if (android.support.v4.app.ai.a)
                            {
                                Log.v("FragmentManager", (new StringBuilder("Bump nesting of ")).append(fragment1).append(" to ").append(fragment1.mBackStackNesting).toString());
                            }
                        }
                        a.a(fragment1, j1, i1);
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
            fragment.mNextAnim = k1;
            a.a(fragment, false);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        obj = v1.d;
        obj.mNextAnim = l1;
        a.a(((Fragment) (obj)), j1, i1);
        continue; /* Loop/switch isn't completed */
_L5:
        obj = v1.d;
        obj.mNextAnim = l1;
        a.b(((Fragment) (obj)), j1, i1);
        continue; /* Loop/switch isn't completed */
_L6:
        obj = v1.d;
        obj.mNextAnim = k1;
        a.c(((Fragment) (obj)), j1, i1);
        continue; /* Loop/switch isn't completed */
_L7:
        obj = v1.d;
        obj.mNextAnim = l1;
        a.d(((Fragment) (obj)), j1, i1);
        continue; /* Loop/switch isn't completed */
        obj = v1.d;
        obj.mNextAnim = k1;
        a.e(((Fragment) (obj)), j1, i1);
        if (true) goto _L12; else goto _L11
_L11:
        a.a(a.n, j1, i1, true);
        if (k)
        {
            obj = a;
            if (((ai) (obj)).i == null)
            {
                obj.i = new ArrayList();
            }
            ((ai) (obj)).i.add(this);
            ((ai) (obj)).f();
        }
        return;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("BackStackEntry{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (o >= 0)
        {
            stringbuilder.append(" #");
            stringbuilder.append(o);
        }
        if (m != null)
        {
            stringbuilder.append(" ");
            stringbuilder.append(m);
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}
