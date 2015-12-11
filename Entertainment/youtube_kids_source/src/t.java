// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class t extends r
    implements android.view.LayoutInflater.Factory
{

    static boolean a = false;
    private static boolean l;
    private static Interpolator y = new DecelerateInterpolator(2.5F);
    private static Interpolator z = new DecelerateInterpolator(1.5F);
    ArrayList b;
    ArrayList c;
    ArrayList d;
    ArrayList e;
    ArrayList f;
    int g;
    m h;
    q i;
    boolean j;
    String k;
    private ArrayList m;
    private Runnable n[];
    private boolean o;
    private ArrayList p;
    private ArrayList q;
    private j r;
    private boolean s;
    private boolean t;
    private boolean u;
    private Bundle v;
    private SparseArray w;
    private Runnable x;

    t()
    {
        g = 0;
        v = null;
        w = null;
        x = new u(this);
    }

    public static int a(int i1)
    {
        switch (i1)
        {
        default:
            return 0;

        case 4097: 
            return 8194;

        case 8194: 
            return 4097;

        case 4099: 
            return 4099;
        }
    }

    private static Animation a(float f1, float f2)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(f1, f2);
        alphaanimation.setInterpolator(z);
        alphaanimation.setDuration(220L);
        return alphaanimation;
    }

    private static Animation a(float f1, float f2, float f3, float f4)
    {
        AnimationSet animationset = new AnimationSet(false);
        Object obj = new ScaleAnimation(f1, f2, f1, f2, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation) (obj)).setInterpolator(y);
        ((ScaleAnimation) (obj)).setDuration(220L);
        animationset.addAnimation(((Animation) (obj)));
        obj = new AlphaAnimation(f3, f4);
        ((AlphaAnimation) (obj)).setInterpolator(z);
        ((AlphaAnimation) (obj)).setDuration(220L);
        animationset.addAnimation(((Animation) (obj)));
        return animationset;
    }

    private Animation a(j j1, int i1, boolean flag, int k1)
    {
        int l1;
        l1 = j1.I;
        j.g();
        if (j1.I != 0)
        {
            j1 = AnimationUtils.loadAnimation(h, j1.I);
            if (j1 != null)
            {
                return j1;
            }
        }
        if (i1 == 0)
        {
            return null;
        }
        l1 = -1;
        i1;
        JVM INSTR lookupswitch 3: default 80
    //                   4097: 89
    //                   4099: 117
    //                   8194: 103;
           goto _L1 _L2 _L3 _L4
_L1:
        i1 = l1;
_L6:
        if (i1 < 0)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (flag)
        {
            i1 = 3;
        } else
        {
            i1 = 4;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (flag)
        {
            i1 = 5;
        } else
        {
            i1 = 6;
        }
        if (true) goto _L6; else goto _L5
_L5:
        switch (i1)
        {
        default:
            i1 = k1;
            if (k1 == 0)
            {
                i1 = k1;
                if (h.getWindow() != null)
                {
                    i1 = h.getWindow().getAttributes().windowAnimations;
                }
            }
            if (i1 == 0)
            {
                return null;
            } else
            {
                return null;
            }

        case 1: // '\001'
            j1 = h;
            return a(1.125F, 1.0F, 0.0F, 1.0F);

        case 2: // '\002'
            j1 = h;
            return a(1.0F, 0.975F, 1.0F, 0.0F);

        case 3: // '\003'
            j1 = h;
            return a(0.975F, 1.0F, 0.0F, 1.0F);

        case 4: // '\004'
            j1 = h;
            return a(1.0F, 1.075F, 1.0F, 0.0F);

        case 5: // '\005'
            j1 = h;
            return a(0.0F, 1.0F);

        case 6: // '\006'
            j1 = h;
            return a(1.0F, 0.0F);
        }
    }

    private j a(Bundle bundle, String s1)
    {
        int i1 = bundle.getInt(s1, -1);
        if (i1 == -1)
        {
            bundle = null;
        } else
        {
            if (i1 >= b.size())
            {
                a(((RuntimeException) (new IllegalStateException((new StringBuilder("Fragment no longer exists for key ")).append(s1).append(": index ").append(i1).toString()))));
            }
            j j1 = (j)b.get(i1);
            bundle = j1;
            if (j1 == null)
            {
                a(((RuntimeException) (new IllegalStateException((new StringBuilder("Fragment no longer exists for key ")).append(s1).append(": index ").append(i1).toString()))));
                return j1;
            }
        }
        return bundle;
    }

    private void a(int i1, c c1)
    {
        this;
        JVM INSTR monitorenter ;
        int k1;
        if (e == null)
        {
            e = new ArrayList();
        }
        k1 = e.size();
        int j1 = k1;
        if (i1 >= k1) goto _L2; else goto _L1
_L1:
        e.set(i1, c1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (j1 >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        e.add(null);
        if (f == null)
        {
            f = new ArrayList();
        }
        f.add(Integer.valueOf(j1));
        j1++;
        if (true) goto _L2; else goto _L3
_L3:
        e.add(c1);
          goto _L4
        c1;
        this;
        JVM INSTR monitorexit ;
        throw c1;
    }

    private void a(j j1)
    {
        a(j1, g, 0, 0, false);
    }

    private void a(RuntimeException runtimeexception)
    {
        Log.e("FragmentManager", runtimeexception.getMessage());
        Log.e("FragmentManager", "Activity state:");
        Object obj = new PrintWriter(new dc("FragmentManager"));
        if (h != null)
        {
            try
            {
                h.dump("  ", null, ((PrintWriter) (obj)), new String[0]);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e("FragmentManager", "Failed dumping state", ((Throwable) (obj)));
            }
        } else
        {
            try
            {
                a("  ", ((FileDescriptor) (null)), ((PrintWriter) (obj)), new String[0]);
            }
            catch (Exception exception)
            {
                Log.e("FragmentManager", "Failed dumping state", exception);
            }
        }
        throw runtimeexception;
    }

    private j b(int i1)
    {
        if (c == null) goto _L2; else goto _L1
_L1:
        int k1 = c.size() - 1;
_L11:
        if (k1 < 0) goto _L2; else goto _L3
_L3:
        j j1 = (j)c.get(k1);
        if (j1 == null || j1.z != i1) goto _L5; else goto _L4
_L4:
        return j1;
_L5:
        k1--;
        continue; /* Loop/switch isn't completed */
_L2:
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        k1 = b.size() - 1;
_L9:
        if (k1 < 0) goto _L7; else goto _L6
_L6:
        j j2;
        j2 = (j)b.get(k1);
        if (j2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        j1 = j2;
        if (j2.z == i1) goto _L4; else goto _L8
_L8:
        k1--;
          goto _L9
_L7:
        return null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private void b(j j1)
    {
        if (j1.L != null)
        {
            if (w == null)
            {
                w = new SparseArray();
            } else
            {
                w.clear();
            }
            j1.L.saveHierarchyState(w);
            if (w.size() > 0)
            {
                j1.h = w;
                w = null;
                return;
            }
        }
    }

    public final int a(c c1)
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        if (f != null && f.size() > 0)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (e == null)
        {
            e = new ArrayList();
        }
        i1 = e.size();
        e.add(c1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        i1 = ((Integer)f.remove(f.size() - 1)).intValue();
        e.set(i1, c1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        c1;
        this;
        JVM INSTR monitorexit ;
        throw c1;
    }

    public final ac a()
    {
        return new c(this);
    }

    public final j a(String s1)
    {
        if (c == null || s1 == null) goto _L2; else goto _L1
_L1:
        int i1 = c.size() - 1;
_L11:
        if (i1 < 0) goto _L2; else goto _L3
_L3:
        j j1 = (j)c.get(i1);
        if (j1 == null || !s1.equals(j1.B)) goto _L5; else goto _L4
_L4:
        return j1;
_L5:
        i1--;
        continue; /* Loop/switch isn't completed */
_L2:
        if (b == null || s1 == null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        i1 = b.size() - 1;
_L9:
        if (i1 < 0) goto _L7; else goto _L6
_L6:
        j j2;
        j2 = (j)b.get(i1);
        if (j2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        j1 = j2;
        if (s1.equals(j2.B)) goto _L4; else goto _L8
_L8:
        i1--;
          goto _L9
_L7:
        return null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final void a(int i1, int j1)
    {
        if (i1 < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad id: ")).append(i1).toString());
        } else
        {
            a(((Runnable) (new v(this, i1, 1))), false);
            return;
        }
    }

    final void a(int i1, int j1, int k1, boolean flag)
    {
        if (h == null && i1 != 0)
        {
            throw new IllegalStateException("No activity");
        }
        if (flag || g != i1)
        {
            g = i1;
            if (b != null)
            {
                int l1 = 0;
                boolean flag1 = false;
                for (; l1 < b.size(); l1++)
                {
                    j j2 = (j)b.get(l1);
                    if (j2 == null)
                    {
                        continue;
                    }
                    a(j2, i1, j1, k1, false);
                    if (j2.O != null)
                    {
                        flag1 |= j2.O.a();
                    }
                }

                if (!flag1)
                {
                    d();
                }
                if (s && h != null && g == 5)
                {
                    m m1 = h;
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        m1.invalidateOptionsMenu();
                    } else
                    {
                        m1.e = true;
                    }
                    s = false;
                    return;
                }
            }
        }
    }

    final void a(int i1, boolean flag)
    {
        a(i1, 0, 0, false);
    }

    public final void a(Configuration configuration)
    {
        if (c != null)
        {
            for (int i1 = 0; i1 < c.size(); i1++)
            {
                j j1 = (j)c.get(i1);
                if (j1 == null)
                {
                    continue;
                }
                j1.onConfigurationChanged(configuration);
                if (j1.x != null)
                {
                    j1.x.a(configuration);
                }
            }

        }
    }

    final void a(Parcelable parcelable, ArrayList arraylist)
    {
        boolean flag = false;
        if (parcelable != null) goto _L2; else goto _L1
_L1:
        y y1;
        return;
_L2:
        if ((y1 = (y)parcelable).a != null)
        {
            if (arraylist != null)
            {
                for (int i1 = 0; i1 < arraylist.size(); i1++)
                {
                    parcelable = (j)arraylist.get(i1);
                    aa aa1 = y1.a[((j) (parcelable)).i];
                    aa1.k = parcelable;
                    parcelable.h = null;
                    parcelable.u = 0;
                    parcelable.s = false;
                    parcelable.o = false;
                    parcelable.l = null;
                    if (aa1.j != null)
                    {
                        aa1.j.setClassLoader(h.getClassLoader());
                        parcelable.h = aa1.j.getSparseParcelableArray("android:view_state");
                        parcelable.g = aa1.j;
                    }
                }

            }
            b = new ArrayList(y1.a.length);
            if (p != null)
            {
                p.clear();
            }
            int k1 = 0;
            while (k1 < y1.a.length) 
            {
                aa aa2 = y1.a[k1];
                if (aa2 != null)
                {
                    parcelable = h;
                    j j1 = r;
                    if (aa2.k != null)
                    {
                        parcelable = aa2.k;
                    } else
                    {
                        if (aa2.i != null)
                        {
                            aa2.i.setClassLoader(parcelable.getClassLoader());
                        }
                        aa2.k = j.a(parcelable, aa2.a, aa2.i);
                        if (aa2.j != null)
                        {
                            aa2.j.setClassLoader(parcelable.getClassLoader());
                            aa2.k.g = aa2.j;
                        }
                        aa2.k.a(aa2.b, j1);
                        aa2.k.r = aa2.c;
                        aa2.k.t = true;
                        aa2.k.z = aa2.d;
                        aa2.k.A = aa2.e;
                        aa2.k.B = aa2.f;
                        aa2.k.E = aa2.g;
                        aa2.k.D = aa2.h;
                        aa2.k.v = ((m) (parcelable)).b;
                        parcelable = aa2.k;
                    }
                    b.add(parcelable);
                    aa2.k = null;
                } else
                {
                    b.add(null);
                    if (p == null)
                    {
                        p = new ArrayList();
                    }
                    p.add(Integer.valueOf(k1));
                }
                k1++;
            }
            if (arraylist != null)
            {
                int l1 = 0;
                while (l1 < arraylist.size()) 
                {
                    parcelable = (j)arraylist.get(l1);
                    if (((j) (parcelable)).m >= 0)
                    {
                        if (((j) (parcelable)).m < b.size())
                        {
                            parcelable.l = (j)b.get(((j) (parcelable)).m);
                        } else
                        {
                            Log.w("FragmentManager", (new StringBuilder("Re-attaching retained fragment ")).append(parcelable).append(" target no longer exists: ").append(((j) (parcelable)).m).toString());
                            parcelable.l = null;
                        }
                    }
                    l1++;
                }
            }
            if (y1.b != null)
            {
                c = new ArrayList(y1.b.length);
                for (int i2 = 0; i2 < y1.b.length; i2++)
                {
                    parcelable = (j)b.get(y1.b[i2]);
                    if (parcelable == null)
                    {
                        a(((RuntimeException) (new IllegalStateException((new StringBuilder("No instantiated fragment for index #")).append(y1.b[i2]).toString()))));
                    }
                    parcelable.o = true;
                    if (c.contains(parcelable))
                    {
                        throw new IllegalStateException("Already added!");
                    }
                    c.add(parcelable);
                }

            } else
            {
                c = null;
            }
            if (y1.c != null)
            {
                d = new ArrayList(y1.c.length);
                int j2 = ((flag) ? 1 : 0);
                while (j2 < y1.c.length) 
                {
                    parcelable = y1.c[j2].a(this);
                    d.add(parcelable);
                    if (((c) (parcelable)).g >= 0)
                    {
                        a(((c) (parcelable)).g, ((c) (parcelable)));
                    }
                    j2++;
                }
            } else
            {
                d = null;
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void a(j j1, int i1, int k1)
    {
        int l1;
        if (j1.u > 0)
        {
            l1 = 1;
        } else
        {
            l1 = 0;
        }
        if (l1 == 0)
        {
            l1 = 1;
        } else
        {
            l1 = 0;
        }
        if (!j1.D || l1 != 0)
        {
            if (c != null)
            {
                c.remove(j1);
            }
            j1.o = false;
            j1.p = true;
            if (l1 != 0)
            {
                l1 = 0;
            } else
            {
                l1 = 1;
            }
            a(j1, l1, i1, k1, false);
        }
    }

    final void a(j j1, int i1, int k1, int l1, boolean flag)
    {
        int i2;
label0:
        {
            if (j1.o)
            {
                i2 = i1;
                if (!j1.D)
                {
                    break label0;
                }
            }
            i2 = i1;
            if (i1 > 1)
            {
                i2 = 1;
            }
        }
        int k2 = i2;
        if (j1.p)
        {
            k2 = i2;
            if (i2 > j1.d)
            {
                k2 = j1.d;
            }
        }
        i1 = k2;
        if (j1.M)
        {
            i1 = k2;
            if (j1.d < 4)
            {
                i1 = k2;
                if (k2 > 3)
                {
                    i1 = 3;
                }
            }
        }
        if (j1.d >= i1) goto _L2; else goto _L1
_L1:
        int j2;
        int l2;
        int i3;
        if (j1.r && !j1.s)
        {
            return;
        }
        if (j1.e != null)
        {
            j1.e = null;
            a(j1, j1.f, 0, 0, true);
        }
        j2 = i1;
        i3 = i1;
        l2 = i1;
        j1.d;
        JVM INSTR tableswitch 0 4: default 184
    //                   0 194
    //                   1 647
    //                   2 1143
    //                   3 1143
    //                   4 1259;
           goto _L3 _L4 _L5 _L6 _L6 _L7
_L3:
        j2 = i1;
_L16:
        j1.d = j2;
        return;
_L4:
        l2 = i1;
        if (j1.g != null)
        {
            j1.g.setClassLoader(h.getClassLoader());
            j1.h = j1.g.getSparseParcelableArray("android:view_state");
            j1.l = a(j1.g, "android:target_state");
            if (j1.l != null)
            {
                j1.n = j1.g.getInt("android:target_req_state", 0);
            }
            j1.N = j1.g.getBoolean("android:user_visible_hint", true);
            l2 = i1;
            if (!j1.N)
            {
                j1.M = true;
                l2 = i1;
                if (i1 > 3)
                {
                    l2 = 3;
                }
            }
        }
        j1.w = h;
        j1.y = r;
        Object obj;
        if (r != null)
        {
            obj = r.x;
        } else
        {
            obj = h.b;
        }
        j1.v = ((t) (obj));
        j1.H = false;
        j1.a(h);
        if (!j1.H)
        {
            throw new bt((new StringBuilder("Fragment ")).append(j1).append(" did not call through to super.onAttach()").toString());
        }
        if (j1.y == null)
        {
            obj = h;
        }
        if (!j1.F)
        {
            Object obj1 = j1.g;
            if (j1.x != null)
            {
                j1.x.j = false;
            }
            j1.H = false;
            j1.a(((Bundle) (obj1)));
            if (!j1.H)
            {
                throw new bt((new StringBuilder("Fragment ")).append(j1).append(" did not call through to super.onCreate()").toString());
            }
            if (obj1 != null)
            {
                obj1 = ((Bundle) (obj1)).getParcelable("android:support:fragments");
                if (obj1 != null)
                {
                    if (j1.x == null)
                    {
                        j1.j();
                    }
                    j1.x.a(((Parcelable) (obj1)), ((ArrayList) (null)));
                    j1.x.h();
                }
            }
        }
        j1.F = false;
        j2 = l2;
        if (j1.r)
        {
            j1.K = j1.a(j1.b(j1.g), null, j1.g);
            if (j1.K != null)
            {
                j1.L = j1.K;
                j1.K = an.a(j1.K);
                if (j1.C)
                {
                    j1.K.setVisibility(8);
                }
                Object obj2 = j1.K;
                obj2 = j1.g;
                j.h();
                j2 = l2;
            } else
            {
                j1.L = null;
                j2 = l2;
            }
        }
_L5:
        i3 = j2;
        if (j2 > 1)
        {
            if (!j1.r)
            {
                Object obj3;
                if (j1.A != 0)
                {
                    ViewGroup viewgroup = (ViewGroup)i.a(j1.A);
                    obj3 = viewgroup;
                    if (viewgroup == null)
                    {
                        obj3 = viewgroup;
                        if (!j1.t)
                        {
                            obj3 = (new StringBuilder("No view found for id 0x")).append(Integer.toHexString(j1.A)).append(" (");
                            if (j1.w == null)
                            {
                                throw new IllegalStateException((new StringBuilder("Fragment ")).append(j1).append(" not attached to Activity").toString());
                            }
                            a(((RuntimeException) (new IllegalArgumentException(((StringBuilder) (obj3)).append(j1.w.getResources().getResourceName(j1.A)).append(") for fragment ").append(j1).toString()))));
                            obj3 = viewgroup;
                        }
                    }
                } else
                {
                    obj3 = null;
                }
                j1.J = ((ViewGroup) (obj3));
                j1.K = j1.a(j1.b(j1.g), ((ViewGroup) (obj3)), j1.g);
                if (j1.K != null)
                {
                    j1.L = j1.K;
                    j1.K = an.a(j1.K);
                    if (obj3 != null)
                    {
                        Animation animation = a(j1, k1, true, l1);
                        if (animation != null)
                        {
                            j1.K.startAnimation(animation);
                        }
                        ((ViewGroup) (obj3)).addView(j1.K);
                    }
                    if (j1.C)
                    {
                        j1.K.setVisibility(8);
                    }
                    obj3 = j1.K;
                    obj3 = j1.g;
                    j.h();
                } else
                {
                    j1.L = null;
                }
            }
            obj3 = j1.g;
            if (j1.x != null)
            {
                j1.x.j = false;
            }
            j1.H = false;
            j1.d(((Bundle) (obj3)));
            if (!j1.H)
            {
                throw new bt((new StringBuilder("Fragment ")).append(j1).append(" did not call through to super.onActivityCreated()").toString());
            }
            if (j1.x != null)
            {
                j1.x.i();
            }
            if (j1.K != null)
            {
                obj3 = j1.g;
                if (j1.h != null)
                {
                    j1.L.restoreHierarchyState(j1.h);
                    j1.h = null;
                }
                j1.H = false;
                j1.H = true;
                if (!j1.H)
                {
                    throw new bt((new StringBuilder("Fragment ")).append(j1).append(" did not call through to super.onViewStateRestored()").toString());
                }
            }
            j1.g = null;
            i3 = j2;
        }
_L6:
        l2 = i3;
        if (i3 > 3)
        {
            if (j1.x != null)
            {
                j1.x.j = false;
                j1.x.f();
            }
            j1.H = false;
            j1.b();
            if (!j1.H)
            {
                throw new bt((new StringBuilder("Fragment ")).append(j1).append(" did not call through to super.onStart()").toString());
            }
            if (j1.x != null)
            {
                j1.x.j();
            }
            l2 = i3;
            if (j1.O != null)
            {
                j1.O.f();
                l2 = i3;
            }
        }
_L7:
        j2 = l2;
        if (l2 > 4)
        {
            j1.q = true;
            if (j1.x != null)
            {
                j1.x.j = false;
                j1.x.f();
            }
            j1.H = false;
            j1.H = true;
            if (!j1.H)
            {
                throw new bt((new StringBuilder("Fragment ")).append(j1).append(" did not call through to super.onResume()").toString());
            }
            if (j1.x != null)
            {
                j1.x.k();
                j1.x.f();
            }
            j1.g = null;
            j1.h = null;
            j2 = l2;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        j2 = i1;
        if (j1.d <= i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        j1.d;
        JVM INSTR tableswitch 1 5: default 1432
    //                   1 1438
    //                   2 1640
    //                   3 1631
    //                   4 1565
    //                   5 1493;
           goto _L8 _L9 _L10 _L11 _L12 _L13
_L8:
        j2 = i1;
        break; /* Loop/switch isn't completed */
_L9:
        j2 = i1;
        if (i1 > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (t && j1.e != null)
        {
            obj3 = j1.e;
            j1.e = null;
            ((View) (obj3)).clearAnimation();
        }
        if (j1.e != null)
        {
            j1.f = i1;
            j2 = 1;
            break; /* Loop/switch isn't completed */
        }
          goto _L14
_L13:
        if (i1 < 5)
        {
            if (j1.x != null)
            {
                j1.x.l();
            }
            j1.H = false;
            j1.H = true;
            if (!j1.H)
            {
                throw new bt((new StringBuilder("Fragment ")).append(j1).append(" did not call through to super.onPause()").toString());
            }
            j1.q = false;
        }
_L12:
        if (i1 < 4)
        {
            if (j1.x != null)
            {
                j1.x.m();
            }
            j1.H = false;
            j1.c();
            if (!j1.H)
            {
                throw new bt((new StringBuilder("Fragment ")).append(j1).append(" did not call through to super.onStop()").toString());
            }
        }
_L11:
        if (i1 < 3)
        {
            j1.k();
        }
_L10:
        if (i1 < 2)
        {
            if (j1.K != null && !h.isFinishing() && j1.h == null)
            {
                b(j1);
            }
            if (j1.x != null)
            {
                j1.x.a(1, false);
            }
            j1.H = false;
            j1.d();
            if (!j1.H)
            {
                throw new bt((new StringBuilder("Fragment ")).append(j1).append(" did not call through to super.onDestroyView()").toString());
            }
            if (j1.O != null)
            {
                j1.O.e();
            }
            if (j1.K != null && j1.J != null)
            {
                if (g > 0 && !t)
                {
                    obj3 = a(j1, k1, false, l1);
                } else
                {
                    obj3 = null;
                }
                if (obj3 != null)
                {
                    j1.e = j1.K;
                    j1.f = i1;
                    ((Animation) (obj3)).setAnimationListener(new w(this, j1));
                    j1.K.startAnimation(((Animation) (obj3)));
                }
                j1.J.removeView(j1.K);
            }
            j1.J = null;
            j1.K = null;
            j1.L = null;
        }
        if (true) goto _L9; else goto _L14
_L14:
        if (!j1.F)
        {
            j1.l();
        }
        j1.H = false;
        j1.a();
        if (!j1.H)
        {
            throw new bt((new StringBuilder("Fragment ")).append(j1).append(" did not call through to super.onDetach()").toString());
        }
        j2 = i1;
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!j1.F)
        {
            j2 = i1;
            if (j1.i >= 0)
            {
                b.set(j1.i, null);
                if (p == null)
                {
                    p = new ArrayList();
                }
                p.add(Integer.valueOf(j1.i));
                h.a(j1.j);
                j1.i = -1;
                j1.j = null;
                j1.o = false;
                j1.p = false;
                j1.q = false;
                j1.r = false;
                j1.s = false;
                j1.t = false;
                j1.u = 0;
                j1.v = null;
                j1.x = null;
                j1.w = null;
                j1.z = 0;
                j1.A = 0;
                j1.B = null;
                j1.C = false;
                j1.D = false;
                j1.F = false;
                j1.O = null;
                j1.P = false;
                j1.Q = false;
                j2 = i1;
            }
        } else
        {
            j1.w = null;
            j1.y = null;
            j1.v = null;
            j1.x = null;
            j2 = i1;
        }
        if (true) goto _L16; else goto _L15
_L15:
    }

    public final void a(j j1, boolean flag)
    {
        if (c == null)
        {
            c = new ArrayList();
        }
        if (j1.i < 0)
        {
            if (p == null || p.size() <= 0)
            {
                if (b == null)
                {
                    b = new ArrayList();
                }
                j1.a(b.size(), r);
                b.add(j1);
            } else
            {
                j1.a(((Integer)p.remove(p.size() - 1)).intValue(), r);
                b.set(j1.i, j1);
            }
        }
        if (!j1.D)
        {
            if (c.contains(j1))
            {
                throw new IllegalStateException((new StringBuilder("Fragment already added: ")).append(j1).toString());
            }
            c.add(j1);
            j1.o = true;
            j1.p = false;
            if (flag)
            {
                a(j1);
            }
        }
    }

    public final void a(Runnable runnable, boolean flag)
    {
        if (!flag)
        {
            e();
        }
        this;
        JVM INSTR monitorenter ;
        if (t || h == null)
        {
            throw new IllegalStateException("Activity has been destroyed");
        }
        break MISSING_BLOCK_LABEL_40;
        runnable;
        this;
        JVM INSTR monitorexit ;
        throw runnable;
        if (m == null)
        {
            m = new ArrayList();
        }
        m.add(runnable);
        if (m.size() == 1)
        {
            h.a.removeCallbacks(x);
            h.a.post(x);
        }
        this;
        JVM INSTR monitorexit ;
    }

    public final void a(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        boolean flag;
        flag = false;
        String s2 = (new StringBuilder()).append(s1).append("    ").toString();
        if (b != null)
        {
            int l2 = b.size();
            if (l2 > 0)
            {
                printwriter.print(s1);
                printwriter.print("Active Fragments in ");
                printwriter.print(Integer.toHexString(System.identityHashCode(this)));
                printwriter.println(":");
                for (int i1 = 0; i1 < l2; i1++)
                {
                    j j1 = (j)b.get(i1);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(i1);
                    printwriter.print(": ");
                    printwriter.println(j1);
                    if (j1 == null)
                    {
                        continue;
                    }
                    printwriter.print(s2);
                    printwriter.print("mFragmentId=#");
                    printwriter.print(Integer.toHexString(j1.z));
                    printwriter.print(" mContainerId=#");
                    printwriter.print(Integer.toHexString(j1.A));
                    printwriter.print(" mTag=");
                    printwriter.println(j1.B);
                    printwriter.print(s2);
                    printwriter.print("mState=");
                    printwriter.print(j1.d);
                    printwriter.print(" mIndex=");
                    printwriter.print(j1.i);
                    printwriter.print(" mWho=");
                    printwriter.print(j1.j);
                    printwriter.print(" mBackStackNesting=");
                    printwriter.println(j1.u);
                    printwriter.print(s2);
                    printwriter.print("mAdded=");
                    printwriter.print(j1.o);
                    printwriter.print(" mRemoving=");
                    printwriter.print(j1.p);
                    printwriter.print(" mResumed=");
                    printwriter.print(j1.q);
                    printwriter.print(" mFromLayout=");
                    printwriter.print(j1.r);
                    printwriter.print(" mInLayout=");
                    printwriter.println(j1.s);
                    printwriter.print(s2);
                    printwriter.print("mHidden=");
                    printwriter.print(j1.C);
                    printwriter.print(" mDetached=");
                    printwriter.print(j1.D);
                    printwriter.print(" mMenuVisible=");
                    printwriter.print(j1.G);
                    printwriter.print(" mHasMenu=");
                    printwriter.println(false);
                    printwriter.print(s2);
                    printwriter.print("mRetainInstance=");
                    printwriter.print(j1.E);
                    printwriter.print(" mRetaining=");
                    printwriter.print(j1.F);
                    printwriter.print(" mUserVisibleHint=");
                    printwriter.println(j1.N);
                    if (j1.v != null)
                    {
                        printwriter.print(s2);
                        printwriter.print("mFragmentManager=");
                        printwriter.println(j1.v);
                    }
                    if (j1.w != null)
                    {
                        printwriter.print(s2);
                        printwriter.print("mActivity=");
                        printwriter.println(j1.w);
                    }
                    if (j1.y != null)
                    {
                        printwriter.print(s2);
                        printwriter.print("mParentFragment=");
                        printwriter.println(j1.y);
                    }
                    if (j1.k != null)
                    {
                        printwriter.print(s2);
                        printwriter.print("mArguments=");
                        printwriter.println(j1.k);
                    }
                    if (j1.g != null)
                    {
                        printwriter.print(s2);
                        printwriter.print("mSavedFragmentState=");
                        printwriter.println(j1.g);
                    }
                    if (j1.h != null)
                    {
                        printwriter.print(s2);
                        printwriter.print("mSavedViewState=");
                        printwriter.println(j1.h);
                    }
                    if (j1.l != null)
                    {
                        printwriter.print(s2);
                        printwriter.print("mTarget=");
                        printwriter.print(j1.l);
                        printwriter.print(" mTargetRequestCode=");
                        printwriter.println(j1.n);
                    }
                    if (j1.I != 0)
                    {
                        printwriter.print(s2);
                        printwriter.print("mNextAnim=");
                        printwriter.println(j1.I);
                    }
                    if (j1.J != null)
                    {
                        printwriter.print(s2);
                        printwriter.print("mContainer=");
                        printwriter.println(j1.J);
                    }
                    if (j1.K != null)
                    {
                        printwriter.print(s2);
                        printwriter.print("mView=");
                        printwriter.println(j1.K);
                    }
                    if (j1.L != null)
                    {
                        printwriter.print(s2);
                        printwriter.print("mInnerView=");
                        printwriter.println(j1.K);
                    }
                    if (j1.e != null)
                    {
                        printwriter.print(s2);
                        printwriter.print("mAnimatingAway=");
                        printwriter.println(j1.e);
                        printwriter.print(s2);
                        printwriter.print("mStateAfterAnimating=");
                        printwriter.println(j1.f);
                    }
                    if (j1.O != null)
                    {
                        printwriter.print(s2);
                        printwriter.println("Loader Manager:");
                        j1.O.a((new StringBuilder()).append(s2).append("  ").toString(), filedescriptor, printwriter, as);
                    }
                    if (j1.x != null)
                    {
                        printwriter.print(s2);
                        printwriter.println((new StringBuilder("Child ")).append(j1.x).append(":").toString());
                        j1.x.a((new StringBuilder()).append(s2).append("  ").toString(), filedescriptor, printwriter, as);
                    }
                }

            }
        }
        if (c != null)
        {
            int i3 = c.size();
            if (i3 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Added Fragments:");
                for (int k1 = 0; k1 < i3; k1++)
                {
                    filedescriptor = (j)c.get(k1);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(k1);
                    printwriter.print(": ");
                    printwriter.println(filedescriptor.toString());
                }

            }
        }
        if (q != null)
        {
            int j3 = q.size();
            if (j3 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Fragments Created Menus:");
                for (int l1 = 0; l1 < j3; l1++)
                {
                    filedescriptor = (j)q.get(l1);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(l1);
                    printwriter.print(": ");
                    printwriter.println(filedescriptor.toString());
                }

            }
        }
        if (d != null)
        {
            int k3 = d.size();
            if (k3 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Back Stack:");
                for (int i2 = 0; i2 < k3; i2++)
                {
                    filedescriptor = (c)d.get(i2);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(i2);
                    printwriter.print(": ");
                    printwriter.println(filedescriptor.toString());
                    filedescriptor.a(s2, printwriter);
                }

            }
        }
        this;
        JVM INSTR monitorenter ;
        if (e == null) goto _L2; else goto _L1
_L1:
        int l3 = e.size();
        if (l3 <= 0) goto _L2; else goto _L3
_L3:
        printwriter.print(s1);
        printwriter.println("Back Stack Indices:");
        int j2 = 0;
_L4:
        if (j2 >= l3)
        {
            break; /* Loop/switch isn't completed */
        }
        filedescriptor = (c)e.get(j2);
        printwriter.print(s1);
        printwriter.print("  #");
        printwriter.print(j2);
        printwriter.print(": ");
        printwriter.println(filedescriptor);
        j2++;
        if (true) goto _L4; else goto _L2
_L2:
        if (f != null && f.size() > 0)
        {
            printwriter.print(s1);
            printwriter.print("mAvailBackStackIndices: ");
            printwriter.println(Arrays.toString(f.toArray()));
        }
        this;
        JVM INSTR monitorexit ;
        if (m != null)
        {
            int i4 = m.size();
            if (i4 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Pending Actions:");
                for (int k2 = ((flag) ? 1 : 0); k2 < i4; k2++)
                {
                    filedescriptor = (Runnable)m.get(k2);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(k2);
                    printwriter.print(": ");
                    printwriter.println(filedescriptor);
                }

            }
        }
        break MISSING_BLOCK_LABEL_1553;
        s1;
        this;
        JVM INSTR monitorexit ;
        throw s1;
        printwriter.print(s1);
        printwriter.println("FragmentManager misc state:");
        printwriter.print(s1);
        printwriter.print("  mActivity=");
        printwriter.println(h);
        printwriter.print(s1);
        printwriter.print("  mContainer=");
        printwriter.println(i);
        if (r != null)
        {
            printwriter.print(s1);
            printwriter.print("  mParent=");
            printwriter.println(r);
        }
        printwriter.print(s1);
        printwriter.print("  mCurState=");
        printwriter.print(g);
        printwriter.print(" mStateSaved=");
        printwriter.print(j);
        printwriter.print(" mDestroyed=");
        printwriter.println(t);
        if (s)
        {
            printwriter.print(s1);
            printwriter.print("  mNeedMenuInvalidate=");
            printwriter.println(s);
        }
        if (k != null)
        {
            printwriter.print(s1);
            printwriter.print("  mNoTransactionsBecause=");
            printwriter.println(k);
        }
        if (p != null && p.size() > 0)
        {
            printwriter.print(s1);
            printwriter.print("  mAvailIndices: ");
            printwriter.println(Arrays.toString(p.toArray()));
        }
        return;
    }

    public final void a(m m1, q q1, j j1)
    {
        if (h != null)
        {
            throw new IllegalStateException("Already attached");
        } else
        {
            h = m1;
            i = q1;
            r = j1;
            return;
        }
    }

    public final boolean a(Menu menu)
    {
        if (c == null) goto _L2; else goto _L1
_L1:
        int i1;
        boolean flag1;
        i1 = 0;
        flag1 = false;
_L5:
        boolean flag2 = flag1;
        if (i1 >= c.size()) goto _L4; else goto _L3
_L3:
        j j1 = (j)c.get(i1);
        flag2 = flag1;
        if (j1 != null)
        {
            boolean flag;
            if (!j1.C && j1.x != null)
            {
                flag = j1.x.a(menu) | false;
            } else
            {
                flag = false;
            }
            flag2 = flag1;
            if (flag)
            {
                flag2 = true;
            }
        }
        i1++;
        flag1 = flag2;
        if (true) goto _L5; else goto _L4
_L2:
        flag2 = false;
_L4:
        return flag2;
    }

    public final boolean a(Menu menu, MenuInflater menuinflater)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        boolean flag1;
        flag1 = false;
        arraylist1 = null;
        arraylist = null;
        if (c == null) goto _L2; else goto _L1
_L1:
        int i1;
        boolean flag2;
        i1 = 0;
        flag2 = false;
_L5:
        boolean flag3;
        arraylist1 = arraylist;
        flag3 = flag2;
        if (i1 >= c.size()) goto _L4; else goto _L3
_L3:
        j j1 = (j)c.get(i1);
        arraylist1 = arraylist;
        flag3 = flag2;
        if (j1 != null)
        {
            boolean flag;
            if (!j1.C && j1.x != null)
            {
                flag = j1.x.a(menu, menuinflater) | false;
            } else
            {
                flag = false;
            }
            arraylist1 = arraylist;
            flag3 = flag2;
            if (flag)
            {
                flag3 = true;
                arraylist1 = arraylist;
                if (arraylist == null)
                {
                    arraylist1 = new ArrayList();
                }
                arraylist1.add(j1);
            }
        }
        i1++;
        flag2 = flag3;
        arraylist = arraylist1;
        if (true) goto _L5; else goto _L4
_L2:
        flag3 = false;
_L4:
        if (q != null)
        {
            for (i1 = ((flag1) ? 1 : 0); i1 < q.size(); i1++)
            {
                menu = (j)q.get(i1);
                if (arraylist1 == null || !arraylist1.contains(menu))
                {
                    j.i();
                }
            }

        }
        q = arraylist1;
        return flag3;
    }

    public final boolean a(MenuItem menuitem)
    {
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = flag2;
        if (c == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L8:
        flag1 = flag2;
        if (i1 >= c.size()) goto _L2; else goto _L3
_L3:
        j j1 = (j)c.get(i1);
        if (j1 == null) goto _L5; else goto _L4
_L4:
        boolean flag;
        if (!j1.C && j1.x != null && j1.x.a(menuitem))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L5; else goto _L6
_L6:
        flag1 = true;
_L2:
        return flag1;
_L5:
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    final boolean a(String s1, int i1, int j1)
    {
        if (d != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (i1 >= 0 || (j1 & 1) != 0) goto _L4; else goto _L3
_L3:
        if ((i1 = d.size() - 1) < 0) goto _L1; else goto _L5
_L5:
        s1 = (c)d.remove(i1);
        SparseArray sparsearray = new SparseArray();
        SparseArray sparsearray1 = new SparseArray();
        s1.a(sparsearray, sparsearray1);
        s1.a(true, null, sparsearray, sparsearray1);
_L8:
        return true;
_L4:
        int k1;
        int l1;
        k1 = -1;
        if (i1 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        l1 = d.size() - 1;
        do
        {
            if (l1 < 0)
            {
                break;
            }
            s1 = (c)d.get(l1);
            if (i1 >= 0 && i1 == ((c) (s1)).g)
            {
                break;
            }
            l1--;
        } while (true);
        if (l1 < 0) goto _L1; else goto _L6
_L6:
        k1 = l1;
        if ((j1 & 1) != 0)
        {
            j1 = l1 - 1;
            do
            {
                k1 = j1;
                if (j1 < 0)
                {
                    break;
                }
                s1 = (c)d.get(j1);
                k1 = j1;
                if (i1 < 0)
                {
                    break;
                }
                k1 = j1;
                if (i1 != ((c) (s1)).g)
                {
                    break;
                }
                j1--;
            } while (true);
        }
        if (k1 == d.size() - 1) goto _L1; else goto _L7
_L7:
        ArrayList arraylist = new ArrayList();
        for (i1 = d.size() - 1; i1 > k1; i1--)
        {
            arraylist.add(d.remove(i1));
        }

        j1 = arraylist.size() - 1;
        SparseArray sparsearray2 = new SparseArray();
        SparseArray sparsearray3 = new SparseArray();
        for (i1 = 0; i1 <= j1; i1++)
        {
            ((c)arraylist.get(i1)).a(sparsearray2, sparsearray3);
        }

        s1 = null;
        i1 = 0;
        while (i1 <= j1) 
        {
            c c1 = (c)arraylist.get(i1);
            boolean flag;
            if (i1 == j1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            s1 = c1.a(flag, s1, sparsearray2, sparsearray3);
            i1++;
        }
          goto _L8
    }

    public final void b(Menu menu)
    {
        if (c != null)
        {
            for (int i1 = 0; i1 < c.size(); i1++)
            {
                j j1 = (j)c.get(i1);
                if (j1 != null && !j1.C && j1.x != null)
                {
                    j1.x.b(menu);
                }
            }

        }
    }

    public final void b(j j1, int i1, int k1)
    {
        if (!j1.C)
        {
            j1.C = true;
            if (j1.K != null)
            {
                Animation animation = a(j1, i1, false, k1);
                if (animation != null)
                {
                    j1.K.startAnimation(animation);
                }
                j1.K.setVisibility(8);
            }
            boolean flag = j1.o;
            j.e();
        }
    }

    public final boolean b()
    {
        return f();
    }

    public final boolean b(MenuItem menuitem)
    {
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = flag2;
        if (c == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L8:
        flag1 = flag2;
        if (i1 >= c.size()) goto _L2; else goto _L3
_L3:
        j j1 = (j)c.get(i1);
        if (j1 == null) goto _L5; else goto _L4
_L4:
        boolean flag;
        if (!j1.C && j1.x != null && j1.x.b(menuitem))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L5; else goto _L6
_L6:
        flag1 = true;
_L2:
        return flag1;
_L5:
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final List c()
    {
        return b;
    }

    public final void c(j j1, int i1, int k1)
    {
        if (j1.C)
        {
            j1.C = false;
            if (j1.K != null)
            {
                Animation animation = a(j1, i1, true, k1);
                if (animation != null)
                {
                    j1.K.startAnimation(animation);
                }
                j1.K.setVisibility(0);
            }
            boolean flag = j1.o;
            j.e();
        }
    }

    final void d()
    {
        if (b != null)
        {
            int i1 = 0;
            while (i1 < b.size()) 
            {
                j j1 = (j)b.get(i1);
                if (j1 != null && j1.M)
                {
                    if (o)
                    {
                        u = true;
                    } else
                    {
                        j1.M = false;
                        a(j1, g, 0, 0, false);
                    }
                }
                i1++;
            }
        }
    }

    public final void d(j j1, int i1, int k1)
    {
        if (!j1.D)
        {
            j1.D = true;
            if (j1.o)
            {
                if (c != null)
                {
                    c.remove(j1);
                }
                j1.o = false;
                a(j1, 1, i1, k1, false);
            }
        }
    }

    void e()
    {
        if (j)
        {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (k != null)
        {
            throw new IllegalStateException((new StringBuilder("Can not perform this action inside of ")).append(k).toString());
        } else
        {
            return;
        }
    }

    public final void e(j j1, int i1, int k1)
    {
        if (j1.D)
        {
            j1.D = false;
            if (!j1.o)
            {
                if (c == null)
                {
                    c = new ArrayList();
                }
                if (c.contains(j1))
                {
                    throw new IllegalStateException((new StringBuilder("Fragment already added: ")).append(j1).toString());
                }
                c.add(j1);
                j1.o = true;
                a(j1, g, i1, k1, false);
            }
        }
    }

    public final boolean f()
    {
        if (o)
        {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        if (Looper.myLooper() != h.a.getLooper())
        {
            throw new IllegalStateException("Must be called from main thread of process");
        }
        boolean flag = false;
_L2:
        this;
        JVM INSTR monitorenter ;
        if (m != null && m.size() != 0)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        this;
        JVM INSTR monitorexit ;
        int l1;
        if (!u)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        int i1 = 0;
        int i2;
        for (l1 = 0; i1 < b.size(); l1 = i2)
        {
            j j1 = (j)b.get(i1);
            i2 = l1;
            if (j1 != null)
            {
                i2 = l1;
                if (j1.O != null)
                {
                    i2 = l1 | j1.O.a();
                }
            }
            i1++;
        }

        break; /* Loop/switch isn't completed */
        l1 = m.size();
        if (n == null || n.length < l1)
        {
            n = new Runnable[l1];
        }
        m.toArray(n);
        m.clear();
        h.a.removeCallbacks(x);
        this;
        JVM INSTR monitorexit ;
        o = true;
        for (int k1 = 0; k1 < l1; k1++)
        {
            n[k1].run();
            n[k1] = null;
        }

        break MISSING_BLOCK_LABEL_250;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        o = false;
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
        if (l1 == 0)
        {
            u = false;
            d();
        }
        return flag;
    }

    final Parcelable g()
    {
        g ag[];
        ag = null;
        f();
        if (l)
        {
            j = true;
        }
        if (b != null && b.size() > 0) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        aa aaa[];
        int i1;
        int k1;
        int l1;
        l1 = b.size();
        aaa = new aa[l1];
        k1 = 0;
        i1 = 0;
_L4:
        if (k1 >= l1)
        {
            continue; /* Loop/switch isn't completed */
        }
        j j1 = (j)b.get(k1);
        if (j1 != null)
        {
            if (j1.i < 0)
            {
                a(new IllegalStateException((new StringBuilder("Failure saving state: active ")).append(j1).append(" has cleared index: ").append(j1.i).toString()));
            }
            aa aa1 = new aa(j1);
            aaa[k1] = aa1;
            if (j1.d <= 0 || aa1.j != null)
            {
                break; /* Loop/switch isn't completed */
            }
            if (v == null)
            {
                v = new Bundle();
            }
            j1.f(v);
            Bundle bundle;
            int ai[];
            Object obj;
            y y1;
            if (!v.isEmpty())
            {
                obj = v;
                v = null;
            } else
            {
                obj = null;
            }
            if (j1.K != null)
            {
                b(j1);
            }
            bundle = ((Bundle) (obj));
            if (j1.h != null)
            {
                bundle = ((Bundle) (obj));
                if (obj == null)
                {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray("android:view_state", j1.h);
            }
            obj = bundle;
            if (!j1.N)
            {
                obj = bundle;
                if (bundle == null)
                {
                    obj = new Bundle();
                }
                ((Bundle) (obj)).putBoolean("android:user_visible_hint", j1.N);
            }
            aa1.j = ((Bundle) (obj));
            if (j1.l == null)
            {
                break MISSING_BLOCK_LABEL_501;
            }
            if (j1.l.i < 0)
            {
                a(new IllegalStateException((new StringBuilder("Failure saving state: ")).append(j1).append(" has target not in fragment manager: ").append(j1.l).toString()));
            }
            if (aa1.j == null)
            {
                aa1.j = new Bundle();
            }
            bundle = aa1.j;
            obj = j1.l;
            if (((j) (obj)).i < 0)
            {
                a(new IllegalStateException((new StringBuilder("Fragment ")).append(obj).append(" is not currently in the FragmentManager").toString()));
            }
            bundle.putInt("android:target_state", ((j) (obj)).i);
            if (j1.n == 0)
            {
                break MISSING_BLOCK_LABEL_501;
            }
            aa1.j.putInt("android:target_req_state", j1.n);
            i1 = 1;
        }
_L5:
        k1++;
        if (true) goto _L4; else goto _L3
_L3:
        aa1.j = j1.g;
        i1 = 1;
          goto _L5
        if (!i1) goto _L1; else goto _L6
_L6:
label0:
        {
            if (c != null)
            {
                k1 = c.size();
                if (k1 > 0)
                {
                    obj = new int[k1];
                    i1 = 0;
                    do
                    {
                        ai = ((int []) (obj));
                        if (i1 >= k1)
                        {
                            break;
                        }
                        obj[i1] = ((j)c.get(i1)).i;
                        if (obj[i1] < 0)
                        {
                            a(new IllegalStateException((new StringBuilder("Failure saving state: active ")).append(c.get(i1)).append(" has cleared index: ").append(obj[i1]).toString()));
                        }
                        i1++;
                    } while (true);
                    break label0;
                }
            }
            ai = null;
        }
        obj = ag;
        if (d != null)
        {
            k1 = d.size();
            obj = ag;
            if (k1 > 0)
            {
                ag = new g[k1];
                i1 = 0;
                do
                {
                    obj = ag;
                    if (i1 >= k1)
                    {
                        break;
                    }
                    ag[i1] = new g((c)d.get(i1));
                    i1++;
                } while (true);
            }
        }
        y1 = new y();
        y1.a = aaa;
        y1.b = ai;
        y1.c = ((g []) (obj));
        return y1;
    }

    public final void h()
    {
        j = false;
        a(1, false);
    }

    public final void i()
    {
        j = false;
        a(2, false);
    }

    public final void j()
    {
        j = false;
        a(4, false);
    }

    public final void k()
    {
        j = false;
        a(5, false);
    }

    public final void l()
    {
        a(4, false);
    }

    public final void m()
    {
        j = true;
        a(3, false);
    }

    public final void n()
    {
        t = true;
        f();
        a(0, false);
        h = null;
        i = null;
        r = null;
    }

    public final void o()
    {
        if (c != null)
        {
            for (int i1 = 0; i1 < c.size(); i1++)
            {
                j j1 = (j)c.get(i1);
                if (j1 == null)
                {
                    continue;
                }
                j1.onLowMemory();
                if (j1.x != null)
                {
                    j1.x.o();
                }
            }

        }
    }

    public final View onCreateView(String s1, Context context, AttributeSet attributeset)
    {
        Object obj = null;
        if (!"fragment".equals(s1))
        {
            return null;
        }
        String s2 = attributeset.getAttributeValue(null, "class");
        s1 = context.obtainStyledAttributes(attributeset, x.a);
        if (s2 == null)
        {
            s2 = s1.getString(0);
        }
        int j1 = s1.getResourceId(1, -1);
        String s3 = s1.getString(2);
        s1.recycle();
        if (!j.b(h, s2))
        {
            return null;
        }
        s1 = ((String) (obj));
        if (j1 != -1)
        {
            s1 = b(j1);
        }
        obj = s1;
        if (s1 == null)
        {
            obj = s1;
            if (s3 != null)
            {
                obj = a(s3);
            }
        }
        s1 = ((String) (obj));
        if (obj == null)
        {
            s1 = b(0);
        }
        if (s1 == null)
        {
            context = j.a(context, s2);
            context.r = true;
            int i1;
            if (j1 != 0)
            {
                i1 = j1;
            } else
            {
                i1 = 0;
            }
            context.z = i1;
            context.A = 0;
            context.B = s3;
            context.s = true;
            context.v = this;
            s1 = h;
            s1 = ((j) (context)).g;
            context.H = true;
            a(context, true);
        } else
        {
            if (((j) (s1)).s)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Duplicate id 0x").append(Integer.toHexString(j1)).append(", tag ").append(s3).append(", or parent id 0x").append(Integer.toHexString(0)).append(" with another fragment for ").append(s2).toString());
            }
            s1.s = true;
            context = s1;
            if (!((j) (s1)).F)
            {
                context = h;
                context = ((j) (s1)).g;
                s1.H = true;
                context = s1;
            }
        }
        if (g <= 0 && ((j) (context)).r)
        {
            a(context, 1, 0, 0, false);
        } else
        {
            a(context);
        }
        if (((j) (context)).K == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(s2).append(" did not create a view.").toString());
        }
        if (j1 != 0)
        {
            ((j) (context)).K.setId(j1);
        }
        if (((j) (context)).K.getTag() == null)
        {
            ((j) (context)).K.setTag(s3);
        }
        return ((j) (context)).K;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("FragmentManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        if (r != null)
        {
            a.a(r, stringbuilder);
        } else
        {
            a.a(h, stringbuilder);
        }
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

    static 
    {
        boolean flag = false;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag = true;
        }
        l = flag;
        new AccelerateInterpolator(2.5F);
        new AccelerateInterpolator(1.5F);
    }
}
