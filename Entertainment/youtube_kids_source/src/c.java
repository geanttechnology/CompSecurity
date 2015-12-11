// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

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

final class c extends ac
    implements Runnable
{

    b a;
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
    private t n;
    private b o;
    private boolean p;

    public c(t t1)
    {
        g = -1;
        n = t1;
    }

    private int a(boolean flag)
    {
        if (p)
        {
            throw new IllegalStateException("commit already called");
        }
        p = true;
        if (e)
        {
            g = n.a(this);
        } else
        {
            g = -1;
        }
        n.a(this, flag);
        return g;
    }

    static cz a(c c1, f f1, boolean flag, j j1)
    {
        cz cz1 = new cz();
        View view = j1.K;
        j1 = cz1;
        if (view != null)
        {
            j1 = cz1;
            if (c1.l != null)
            {
                a.a(cz1, view);
                if (flag)
                {
                    j1 = a(c1.l, c1.m, cz1);
                } else
                {
                    de.a(cz1, c1.m);
                    j1 = cz1;
                }
            }
        }
        if (flag)
        {
            c1.a(f1, ((cz) (j1)), true);
            return j1;
        } else
        {
            b(f1, j1, true);
            return j1;
        }
    }

    private cz a(f f1, j j1, boolean flag)
    {
        cz cz2 = new cz();
        cz cz1 = cz2;
        if (l != null)
        {
            a.a(cz2, j1.K);
            if (flag)
            {
                de.a(cz2, m);
                cz1 = cz2;
            } else
            {
                cz1 = a(l, m, cz2);
            }
        }
        if (flag)
        {
            a(f1, cz1, false);
            return cz1;
        } else
        {
            b(f1, cz1, false);
            return cz1;
        }
    }

    private static cz a(ArrayList arraylist, ArrayList arraylist1, cz cz1)
    {
        if (cz1.isEmpty())
        {
            return cz1;
        }
        cz cz2 = new cz();
        int j1 = arraylist.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view = (View)cz1.get(arraylist.get(i1));
            if (view != null)
            {
                cz2.put(arraylist1.get(i1), view);
            }
        }

        return cz2;
    }

    private f a(SparseArray sparsearray, SparseArray sparsearray1, boolean flag)
    {
        boolean flag4 = false;
        f f1 = new f(this);
        f1.d = new View(n.h);
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
            if (a(sparsearray.keyAt(i1), f1, flag, sparsearray, sparsearray1))
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
                if (a(j1, f1, flag, sparsearray, sparsearray1))
                {
                    flag2 = true;
                }
            }
            k1++;
            flag3 = flag2;
        }
        sparsearray = f1;
        if (!flag3)
        {
            sparsearray = null;
        }
        return sparsearray;
    }

    private static Object a(Object obj, j j1, ArrayList arraylist, cz cz1)
    {
label0:
        {
            Object obj1 = obj;
            if (obj != null)
            {
                j1 = j1.K;
                obj1 = obj;
                if (obj != null)
                {
                    a.a(arraylist, j1);
                    if (cz1 != null)
                    {
                        arraylist.removeAll(cz1.values());
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
        a.b((Transition)obj, arraylist);
        return obj;
    }

    private static void a(SparseArray sparsearray, j j1)
    {
        if (j1 != null)
        {
            int i1 = j1.A;
            if (i1 != 0 && !j1.C)
            {
                boolean flag;
                if (j1.w != null && j1.o)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag && j1.K != null && sparsearray.get(i1) == null)
                {
                    sparsearray.put(i1, j1);
                }
            }
        }
    }

    static void a(c c1, cz cz1, f f1)
    {
        if (c1.m != null && !cz1.isEmpty())
        {
            c1 = (View)cz1.get(c1.m.get(0));
            if (c1 != null)
            {
                f1.c.a = c1;
            }
        }
    }

    static void a(c c1, f f1, int i1, Object obj)
    {
        c1.a(f1, i1, obj);
    }

    static void a(c c1, f f1, j j1, j j2, boolean flag, cz cz1)
    {
    }

    private static void a(cz cz1, String s, String s1)
    {
        if (s == null || s1 == null || s.equals(s1)) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L6:
        if (i1 >= cz1.size())
        {
            break; /* Loop/switch isn't completed */
        }
        if (!s.equals(cz1.c(i1))) goto _L4; else goto _L3
_L3:
        cz1.a(i1, s1);
_L2:
        return;
_L4:
        i1++;
        if (true) goto _L6; else goto _L5
_L5:
        cz1.put(s, s1);
        return;
    }

    private void a(f f1, int i1, Object obj)
    {
        if (n.c != null)
        {
            int k1 = 0;
            while (k1 < n.c.size()) 
            {
                j j1 = (j)n.c.get(k1);
                if (j1.K != null && j1.J != null && j1.A == i1)
                {
                    if (j1.C)
                    {
                        if (!f1.b.contains(j1.K))
                        {
                            a.a(obj, j1.K, true);
                            f1.b.add(j1.K);
                        }
                    } else
                    {
                        a.a(obj, j1.K, false);
                        f1.b.remove(j1.K);
                    }
                }
                k1++;
            }
        }
    }

    private void a(f f1, cz cz1, boolean flag)
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
            Object obj = (View)cz1.get((String)m.get(j1));
            if (obj != null)
            {
                obj = ((View) (obj)).getTransitionName();
                if (flag)
                {
                    a(f1.a, s, ((String) (obj)));
                } else
                {
                    a(f1.a, ((String) (obj)), s);
                }
            }
            j1++;
        }
    }

    private boolean a(int i1, f f1, boolean flag, SparseArray sparsearray, SparseArray sparsearray1)
    {
        ViewGroup viewgroup = (ViewGroup)n.i.a(i1);
        if (viewgroup == null)
        {
            return false;
        }
        Object obj2 = (j)sparsearray1.get(i1);
        Object obj3 = (j)sparsearray.get(i1);
        Object obj;
        if (obj2 == null)
        {
            sparsearray1 = null;
        } else
        {
            if (flag)
            {
                if (((j) (obj2)).S == j.c)
                {
                    sparsearray = null;
                } else
                {
                    sparsearray = ((SparseArray) (((j) (obj2)).S));
                }
            } else
            {
                sparsearray = null;
            }
            sparsearray1 = ((SparseArray) (a.a(sparsearray)));
        }
        if (obj2 == null || obj3 == null)
        {
            obj = null;
        } else
        {
            if (flag)
            {
                if (((j) (obj3)).T == j.c)
                {
                    sparsearray = null;
                } else
                {
                    sparsearray = ((SparseArray) (((j) (obj3)).T));
                }
            } else
            {
                sparsearray = null;
            }
            obj = a.a(sparsearray);
        }
        if (obj3 == null)
        {
            sparsearray = null;
        } else
        {
            if (flag)
            {
                if (((j) (obj3)).R == j.c)
                {
                    sparsearray = null;
                } else
                {
                    sparsearray = ((SparseArray) (((j) (obj3)).R));
                }
            } else
            {
                sparsearray = null;
            }
            sparsearray = ((SparseArray) (a.a(sparsearray)));
        }
        if (sparsearray1 == null && obj == null && sparsearray == null)
        {
            return false;
        }
        Object obj1 = null;
        ArrayList arraylist = new ArrayList();
        if (obj != null)
        {
            obj1 = a(f1, ((j) (obj3)), flag);
            ArrayList arraylist1;
            Object obj4;
            Transition transition;
            Transition transition1;
            Transition transition2;
            if (((cz) (obj1)).isEmpty())
            {
                arraylist.add(f1.d);
            } else
            {
                arraylist.addAll(((cz) (obj1)).values());
            }
        }
        arraylist1 = new ArrayList();
        sparsearray = ((SparseArray) (a(sparsearray, ((j) (obj3)), arraylist1, ((cz) (obj1)))));
        if (m != null && obj1 != null)
        {
            obj1 = (View)((cz) (obj1)).get(m.get(0));
            if (obj1 != null)
            {
                if (sparsearray != null)
                {
                    a.a(sparsearray, ((View) (obj1)));
                }
                if (obj != null)
                {
                    a.a(obj, ((View) (obj1)));
                }
            }
        }
        obj4 = new a(this, ((j) (obj2)));
        if (obj != null)
        {
            viewgroup.getViewTreeObserver().addOnPreDrawListener(new d(this, viewgroup, obj, arraylist, f1, flag, ((j) (obj2)), ((j) (obj3))));
        }
        obj1 = new ArrayList();
        obj2 = new cz();
        transition = (Transition)sparsearray1;
        transition1 = (Transition)sparsearray;
        transition2 = (Transition)obj;
        if (transition != null)
        {
            if (transition1 == null);
        }
        obj3 = new TransitionSet();
        if (transition != null)
        {
            ((TransitionSet) (obj3)).addTransition(transition);
        }
        if (transition1 != null)
        {
            ((TransitionSet) (obj3)).addTransition(transition1);
        }
        if (transition2 != null)
        {
            ((TransitionSet) (obj3)).addTransition(transition2);
        }
        if (obj3 != null)
        {
            a.a(sparsearray1, obj, viewgroup, ((ai) (obj4)), f1.d, f1.c, f1.a, ((ArrayList) (obj1)), ((Map) (obj2)), arraylist);
            viewgroup.getViewTreeObserver().addOnPreDrawListener(new e(this, viewgroup, f1, i1, obj3));
            a.a(obj3, f1.d, true);
            a(f1, i1, obj3);
            TransitionManager.beginDelayedTransition(viewgroup, (Transition)obj3);
            obj4 = f1.d;
            f1 = f1.b;
            sparsearray1 = (Transition)sparsearray1;
            sparsearray = (Transition)sparsearray;
            obj = (Transition)obj;
            transition = (Transition)obj3;
            if (transition != null)
            {
                viewgroup.getViewTreeObserver().addOnPreDrawListener(new ag(viewgroup, sparsearray1, ((View) (obj4)), ((ArrayList) (obj1)), sparsearray, arraylist1, ((Transition) (obj)), arraylist, ((Map) (obj2)), f1, transition));
            }
        }
        return obj3 != null;
    }

    private void b(SparseArray sparsearray, SparseArray sparsearray1)
    {
        if (n.i.a()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        b b1 = a;
_L12:
        if (b1 == null) goto _L1; else goto _L3
_L3:
        b1.c;
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
        b1 = b1.a;
          goto _L12
_L5:
        b(sparsearray1, b1.d);
          goto _L13
_L6:
        j j1 = b1.d;
        j j2;
        if (n.c != null)
        {
            int i1 = 0;
label0:
            do
            {
label1:
                {
                    j2 = j1;
                    if (i1 >= n.c.size())
                    {
                        break label0;
                    }
                    j j3 = (j)n.c.get(i1);
                    if (j1 != null)
                    {
                        j2 = j1;
                        if (j3.A != j1.A)
                        {
                            break label1;
                        }
                    }
                    if (j3 == j1)
                    {
                        j2 = null;
                    } else
                    {
                        a(sparsearray, j3);
                        j2 = j1;
                    }
                }
                i1++;
                j1 = j2;
            } while (true);
        } else
        {
            j2 = j1;
        }
        b(sparsearray1, j2);
          goto _L13
_L7:
        a(sparsearray, b1.d);
          goto _L13
_L8:
        a(sparsearray, b1.d);
          goto _L13
_L9:
        b(sparsearray1, b1.d);
          goto _L13
_L10:
        a(sparsearray, b1.d);
          goto _L13
        b(sparsearray1, b1.d);
          goto _L13
    }

    private static void b(SparseArray sparsearray, j j1)
    {
        if (j1 != null)
        {
            int i1 = j1.A;
            if (i1 != 0)
            {
                sparsearray.put(i1, j1);
            }
        }
    }

    private static void b(f f1, cz cz1, boolean flag)
    {
        int j1 = cz1.size();
        int i1 = 0;
        while (i1 < j1) 
        {
            String s = (String)cz1.b(i1);
            String s1 = ((View)cz1.c(i1)).getTransitionName();
            if (flag)
            {
                a(f1.a, s, s1);
            } else
            {
                a(f1.a, s1, s);
            }
            i1++;
        }
    }

    public final int a()
    {
        return a(false);
    }

    public final ac a(j j1)
    {
        b b1 = new b();
        b1.c = 3;
        b1.d = j1;
        a(b1);
        return this;
    }

    public final ac a(j j1, String s)
    {
        j1.v = n;
        if (s != null)
        {
            if (j1.B != null && !s.equals(j1.B))
            {
                throw new IllegalStateException((new StringBuilder("Can't change tag of fragment ")).append(j1).append(": was ").append(j1.B).append(" now ").append(s).toString());
            }
            j1.B = s;
        }
        s = new b();
        s.c = 1;
        s.d = j1;
        a(((b) (s)));
        return this;
    }

    public final f a(boolean flag, f f1, SparseArray sparsearray, SparseArray sparsearray1)
    {
        if (f1 != null) goto _L2; else goto _L1
_L1:
        Object obj;
label0:
        {
            if (sparsearray.size() == 0)
            {
                obj = f1;
                if (sparsearray1.size() == 0)
                {
                    break label0;
                }
            }
            obj = a(sparsearray, sparsearray1, true);
        }
_L18:
        int i1;
        int j1;
        int k1;
        int l1;
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
        f1 = o;
_L13:
        if (f1 == null) goto _L4; else goto _L3
_L3:
        if (obj != null)
        {
            k1 = 0;
        } else
        {
            k1 = ((b) (f1)).g;
        }
        if (obj != null)
        {
            l1 = 0;
        } else
        {
            l1 = ((b) (f1)).h;
        }
        ((b) (f1)).c;
        JVM INSTR tableswitch 1 7: default 124
    //                   1 271
    //                   2 305
    //                   3 394
    //                   4 417
    //                   5 446
    //                   6 475
    //                   7 504;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L5:
        throw new IllegalArgumentException((new StringBuilder("Unknown cmd: ")).append(((b) (f1)).c).toString());
_L2:
        obj = f1;
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        sparsearray = m;
        sparsearray1 = l;
        obj = f1;
        if (sparsearray == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = 0;
        do
        {
            obj = f1;
            if (i1 >= sparsearray.size())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (String)sparsearray.get(i1);
            s = (String)sparsearray1.get(i1);
            a(f1.a, ((String) (obj)), s);
            i1++;
        } while (true);
        continue; /* Loop/switch isn't completed */
_L6:
        sparsearray = ((b) (f1)).d;
        sparsearray.I = l1;
        n.a(sparsearray, t.a(j1), i1);
_L14:
        f1 = ((b) (f1)).b;
          goto _L13
_L7:
        sparsearray = ((b) (f1)).d;
        if (sparsearray != null)
        {
            sparsearray.I = l1;
            n.a(sparsearray, t.a(j1), i1);
        }
        if (((b) (f1)).i != null)
        {
            l1 = 0;
            while (l1 < ((b) (f1)).i.size()) 
            {
                sparsearray = (j)((b) (f1)).i.get(l1);
                sparsearray.I = k1;
                n.a(sparsearray, false);
                l1++;
            }
        }
          goto _L14
_L8:
        sparsearray = ((b) (f1)).d;
        sparsearray.I = k1;
        n.a(sparsearray, false);
          goto _L14
_L9:
        sparsearray = ((b) (f1)).d;
        sparsearray.I = k1;
        n.c(sparsearray, t.a(j1), i1);
          goto _L14
_L10:
        sparsearray = ((b) (f1)).d;
        sparsearray.I = l1;
        n.b(sparsearray, t.a(j1), i1);
          goto _L14
_L11:
        sparsearray = ((b) (f1)).d;
        sparsearray.I = k1;
        n.e(sparsearray, t.a(j1), i1);
          goto _L14
_L12:
        sparsearray = ((b) (f1)).d;
        sparsearray.I = k1;
        n.d(sparsearray, t.a(j1), i1);
          goto _L14
_L4:
        if (flag)
        {
            n.a(n.g, t.a(j1), i1, true);
            obj = null;
        }
        if (g < 0) goto _L16; else goto _L15
_L15:
        f1 = n;
        i1 = g;
        f1;
        JVM INSTR monitorenter ;
        ((t) (f1)).e.set(i1, null);
        if (((t) (f1)).f == null)
        {
            f1.f = new ArrayList();
        }
        ((t) (f1)).f.add(Integer.valueOf(i1));
        f1;
        JVM INSTR monitorexit ;
        g = -1;
_L16:
        return ((f) (obj));
        sparsearray;
        f1;
        JVM INSTR monitorexit ;
        throw sparsearray;
        if (true) goto _L18; else goto _L17
_L17:
    }

    final void a(int i1)
    {
        if (e)
        {
            b b1 = a;
            while (b1 != null) 
            {
                if (b1.d != null)
                {
                    j j1 = b1.d;
                    j1.u = j1.u + i1;
                }
                if (b1.i != null)
                {
                    for (int k1 = b1.i.size() - 1; k1 >= 0; k1--)
                    {
                        j j2 = (j)b1.i.get(k1);
                        j2.u = j2.u + i1;
                    }

                }
                b1 = b1.a;
            }
        }
    }

    public final void a(SparseArray sparsearray, SparseArray sparsearray1)
    {
        if (n.i.a()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        b b1 = a;
_L12:
        if (b1 == null) goto _L1; else goto _L3
_L3:
        b1.c;
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
        b1 = b1.a;
          goto _L12
_L5:
        a(sparsearray, b1.d);
          goto _L13
_L6:
        if (b1.i != null)
        {
            for (int i1 = b1.i.size() - 1; i1 >= 0; i1--)
            {
                b(sparsearray1, (j)b1.i.get(i1));
            }

        }
        a(sparsearray, b1.d);
          goto _L13
_L7:
        b(sparsearray1, b1.d);
          goto _L13
_L8:
        b(sparsearray1, b1.d);
          goto _L13
_L9:
        a(sparsearray, b1.d);
          goto _L13
_L10:
        b(sparsearray1, b1.d);
          goto _L13
        a(sparsearray, b1.d);
          goto _L13
    }

    final void a(b b1)
    {
        if (a == null)
        {
            o = b1;
            a = b1;
        } else
        {
            b1.b = o;
            o.a = b1;
            o = b1;
        }
        b1.e = 0;
        b1.f = 0;
        b1.g = 0;
        b1.h = 0;
        b = b + 1;
    }

    public final void a(String s, PrintWriter printwriter)
    {
        b b1;
        String s2;
        int i1;
        printwriter.print(s);
        printwriter.print("mName=");
        printwriter.print(f);
        printwriter.print(" mIndex=");
        printwriter.print(g);
        printwriter.print(" mCommitted=");
        printwriter.println(p);
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
        b1 = a;
        i1 = 0;
_L13:
        if (b1 == null) goto _L2; else goto _L1
_L1:
        b1.c;
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
        String s1 = (new StringBuilder("cmd=")).append(b1.c).toString();
_L12:
        printwriter.print(s);
        printwriter.print("  Op #");
        printwriter.print(i1);
        printwriter.print(": ");
        printwriter.print(s1);
        printwriter.print(" ");
        printwriter.println(b1.d);
        if (b1.e != 0 || b1.f != 0)
        {
            printwriter.print(s);
            printwriter.print("enterAnim=#");
            printwriter.print(Integer.toHexString(b1.e));
            printwriter.print(" exitAnim=#");
            printwriter.println(Integer.toHexString(b1.f));
        }
        if (b1.g != 0 || b1.h != 0)
        {
            printwriter.print(s);
            printwriter.print("popEnterAnim=#");
            printwriter.print(Integer.toHexString(b1.g));
            printwriter.print(" popExitAnim=#");
            printwriter.println(Integer.toHexString(b1.h));
        }
        if (b1.i != null && b1.i.size() > 0)
        {
            int j1 = 0;
            while (j1 < b1.i.size()) 
            {
                printwriter.print(s2);
                if (b1.i.size() == 1)
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
                printwriter.println(b1.i.get(j1));
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
        b1 = b1.a;
        i1++;
          goto _L13
_L2:
    }

    public final int b()
    {
        return a(true);
    }

    public final void run()
    {
        if (e && g < 0)
        {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        a(1);
        Object obj;
        Object obj1;
        b b1;
        j j1;
        j j2;
        int i1;
        int k1;
        int l1;
        int i2;
        int k2;
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
            i1 = d;
        }
        if (obj1 != null)
        {
            k1 = 0;
        } else
        {
            k1 = c;
        }
        b1 = a;
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_573;
        }
        if (obj1 != null)
        {
            l1 = 0;
        } else
        {
            l1 = b1.e;
        }
        if (obj1 != null)
        {
            i2 = 0;
        } else
        {
            i2 = b1.f;
        }
        b1.c;
        JVM INSTR tableswitch 1 7: default 152
    //                   1 216
    //                   2 244
    //                   3 443
    //                   4 469
    //                   5 495
    //                   6 521
    //                   7 547;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_547;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown cmd: ")).append(b1.c).toString());
_L2:
        obj = b1.d;
        obj.I = l1;
        n.a(((j) (obj)), false);
_L12:
        b1 = b1.a;
        if (true) goto _L10; else goto _L9
_L10:
        break MISSING_BLOCK_LABEL_87;
_L9:
        obj = b1.d;
        if (n.c != null)
        {
            k2 = 0;
label0:
            do
            {
label1:
                {
                    j1 = ((j) (obj));
                    if (k2 >= n.c.size())
                    {
                        break label0;
                    }
                    j2 = (j)n.c.get(k2);
                    if (obj != null)
                    {
                        j1 = ((j) (obj));
                        if (j2.A != ((j) (obj)).A)
                        {
                            break label1;
                        }
                    }
                    if (j2 == obj)
                    {
                        b1.d = null;
                        j1 = null;
                    } else
                    {
                        if (b1.i == null)
                        {
                            b1.i = new ArrayList();
                        }
                        b1.i.add(j2);
                        j2.I = i2;
                        if (e)
                        {
                            j2.u = j2.u + 1;
                        }
                        n.a(j2, k1, i1);
                        j1 = ((j) (obj));
                    }
                }
                k2++;
                obj = j1;
            } while (true);
        } else
        {
            j1 = ((j) (obj));
        }
        if (j1 != null)
        {
            j1.I = l1;
            n.a(j1, false);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        obj = b1.d;
        obj.I = i2;
        n.a(((j) (obj)), k1, i1);
        continue; /* Loop/switch isn't completed */
_L5:
        obj = b1.d;
        obj.I = i2;
        n.b(((j) (obj)), k1, i1);
        continue; /* Loop/switch isn't completed */
_L6:
        obj = b1.d;
        obj.I = l1;
        n.c(((j) (obj)), k1, i1);
        continue; /* Loop/switch isn't completed */
_L7:
        obj = b1.d;
        obj.I = i2;
        n.d(((j) (obj)), k1, i1);
        continue; /* Loop/switch isn't completed */
        obj = b1.d;
        obj.I = l1;
        n.e(((j) (obj)), k1, i1);
        if (true) goto _L12; else goto _L11
_L11:
        n.a(n.g, k1, i1, true);
        if (e)
        {
            obj = n;
            if (((t) (obj)).d == null)
            {
                obj.d = new ArrayList();
            }
            ((t) (obj)).d.add(this);
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
}
