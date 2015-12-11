// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.f.c;
import android.support.v4.f.d;
import android.support.v4.view.k;
import android.support.v4.view.w;
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

// Referenced classes of package android.support.v4.app:
//            k, Fragment, i, f, 
//            p, FragmentManagerState, FragmentState, BackStackState, 
//            ah, j, r, m

final class l extends android.support.v4.app.k
    implements k
{
    static final class a
    {

        public static final int a[] = {
            0x1010003, 0x10100d0, 0x10100d1
        };

    }


    static final Interpolator A = new DecelerateInterpolator(1.5F);
    static final Interpolator B = new AccelerateInterpolator(2.5F);
    static final Interpolator C = new AccelerateInterpolator(1.5F);
    static boolean a = false;
    static final boolean b;
    static final Interpolator z = new DecelerateInterpolator(2.5F);
    ArrayList c;
    Runnable d[];
    boolean e;
    ArrayList f;
    ArrayList g;
    ArrayList h;
    ArrayList i;
    ArrayList j;
    ArrayList k;
    ArrayList l;
    ArrayList m;
    int n;
    i o;
    j p;
    Fragment q;
    boolean r;
    boolean s;
    boolean t;
    String u;
    boolean v;
    Bundle w;
    SparseArray x;
    Runnable y;

    l()
    {
        n = 0;
        w = null;
        x = null;
        y = new Runnable() {

            final l a;

            public final void run()
            {
                a.i();
            }

            
            {
                a = l.this;
                super();
            }
        };
    }

    private static Animation a(float f1, float f2)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(f1, f2);
        alphaanimation.setInterpolator(A);
        alphaanimation.setDuration(220L);
        return alphaanimation;
    }

    private static Animation a(float f1, float f2, float f3, float f4)
    {
        AnimationSet animationset = new AnimationSet(false);
        Object obj = new ScaleAnimation(f1, f2, f1, f2, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation) (obj)).setInterpolator(z);
        ((ScaleAnimation) (obj)).setDuration(220L);
        animationset.addAnimation(((Animation) (obj)));
        obj = new AlphaAnimation(f3, f4);
        ((AlphaAnimation) (obj)).setInterpolator(A);
        ((AlphaAnimation) (obj)).setDuration(220L);
        animationset.addAnimation(((Animation) (obj)));
        return animationset;
    }

    private Animation a(Fragment fragment, int i1, boolean flag, int j1)
    {
        Animation animation = fragment.onCreateAnimation(i1, flag, fragment.Q);
        if (animation == null) goto _L2; else goto _L1
_L1:
        fragment = animation;
_L4:
        return fragment;
_L2:
        if (fragment.Q == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        animation = AnimationUtils.loadAnimation(o, fragment.Q);
        fragment = animation;
        if (animation != null) goto _L4; else goto _L3
_L3:
        byte byte0;
        if (i1 == 0)
        {
            return null;
        }
        byte0 = -1;
        i1;
        JVM INSTR lookupswitch 3: default 96
    //                   4097: 105
    //                   4099: 133
    //                   8194: 119;
           goto _L5 _L6 _L7 _L8
_L5:
        i1 = byte0;
_L10:
        if (i1 < 0)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L6:
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (flag)
        {
            i1 = 3;
        } else
        {
            i1 = 4;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (flag)
        {
            i1 = 5;
        } else
        {
            i1 = 6;
        }
        if (true) goto _L10; else goto _L9
_L9:
        switch (i1)
        {
        default:
            i1 = j1;
            if (j1 == 0)
            {
                i1 = j1;
                if (o.getWindow() != null)
                {
                    i1 = o.getWindow().getAttributes().windowAnimations;
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
            return a(1.125F, 1.0F, 0.0F, 1.0F);

        case 2: // '\002'
            return a(1.0F, 0.975F, 1.0F, 0.0F);

        case 3: // '\003'
            return a(0.975F, 1.0F, 0.0F, 1.0F);

        case 4: // '\004'
            return a(1.0F, 1.075F, 1.0F, 0.0F);

        case 5: // '\005'
            return a(0.0F, 1.0F);

        case 6: // '\006'
            return a(1.0F, 0.0F);
        }
    }

    private void a(int i1, f f1)
    {
        this;
        JVM INSTR monitorenter ;
        int k1;
        if (k == null)
        {
            k = new ArrayList();
        }
        k1 = k.size();
        int j1 = k1;
        if (i1 >= k1) goto _L2; else goto _L1
_L1:
        if (a)
        {
            (new StringBuilder("Setting back stack index ")).append(i1).append(" to ").append(f1);
        }
        k.set(i1, f1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (j1 >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        k.add(null);
        if (l == null)
        {
            l = new ArrayList();
        }
        l.add(Integer.valueOf(j1));
        j1++;
        if (true) goto _L2; else goto _L3
_L3:
        if (a)
        {
            (new StringBuilder("Adding back stack index ")).append(i1).append(" with ").append(f1);
        }
        k.add(f1);
          goto _L4
        f1;
        this;
        JVM INSTR monitorexit ;
        throw f1;
    }

    private void a(RuntimeException runtimeexception)
    {
        Log.e("FragmentManager", runtimeexception.getMessage());
        Log.e("FragmentManager", "Activity state:");
        Object obj = new PrintWriter(new d("FragmentManager"));
        if (o != null)
        {
            try
            {
                o.dump("  ", null, ((PrintWriter) (obj)), new String[0]);
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

    private void c(Fragment fragment)
    {
        a(fragment, n, 0, 0, false);
    }

    public static int d(int i1)
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

    private void d(Fragment fragment)
    {
        if (fragment.T != null)
        {
            if (x == null)
            {
                x = new SparseArray();
            } else
            {
                x.clear();
            }
            fragment.T.saveHierarchyState(x);
            if (x.size() > 0)
            {
                fragment.o = x;
                x = null;
                return;
            }
        }
    }

    private Bundle e(Fragment fragment)
    {
        if (w == null)
        {
            w = new Bundle();
        }
        fragment.b(w);
        Bundle bundle;
        Bundle bundle1;
        if (!w.isEmpty())
        {
            bundle1 = w;
            w = null;
        } else
        {
            bundle1 = null;
        }
        if (fragment.S != null)
        {
            d(fragment);
        }
        bundle = bundle1;
        if (fragment.o != null)
        {
            bundle = bundle1;
            if (bundle1 == null)
            {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.o);
        }
        bundle1 = bundle;
        if (!fragment.V)
        {
            bundle1 = bundle;
            if (bundle == null)
            {
                bundle1 = new Bundle();
            }
            bundle1.putBoolean("android:user_visible_hint", fragment.V);
        }
        return bundle1;
    }

    private void s()
    {
        if (s)
        {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (u != null)
        {
            throw new IllegalStateException((new StringBuilder("Can not perform this action inside of ")).append(u).toString());
        } else
        {
            return;
        }
    }

    public final int a(f f1)
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        if (l != null && l.size() > 0)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (k == null)
        {
            k = new ArrayList();
        }
        i1 = k.size();
        if (a)
        {
            (new StringBuilder("Setting back stack index ")).append(i1).append(" to ").append(f1);
        }
        k.add(f1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        i1 = ((Integer)l.remove(l.size() - 1)).intValue();
        if (a)
        {
            (new StringBuilder("Adding back stack index ")).append(i1).append(" with ").append(f1);
        }
        k.set(i1, f1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        f1;
        this;
        JVM INSTR monitorexit ;
        throw f1;
    }

    public final Fragment.SavedState a(Fragment fragment)
    {
        Object obj = null;
        if (fragment.p < 0)
        {
            a(((RuntimeException) (new IllegalStateException((new StringBuilder("Fragment ")).append(fragment).append(" is not currently in the FragmentManager").toString()))));
        }
        Fragment.SavedState savedstate = obj;
        if (fragment.k > 0)
        {
            fragment = e(fragment);
            savedstate = obj;
            if (fragment != null)
            {
                savedstate = new Fragment.SavedState(fragment);
            }
        }
        return savedstate;
    }

    public final Fragment a(int i1)
    {
        if (g == null) goto _L2; else goto _L1
_L1:
        int j1 = g.size() - 1;
_L11:
        if (j1 < 0) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)g.get(j1);
        if (fragment == null || fragment.G != i1) goto _L5; else goto _L4
_L4:
        return fragment;
_L5:
        j1--;
        continue; /* Loop/switch isn't completed */
_L2:
        if (f == null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        j1 = f.size() - 1;
_L9:
        if (j1 < 0) goto _L7; else goto _L6
_L6:
        Fragment fragment1;
        fragment1 = (Fragment)f.get(j1);
        if (fragment1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        fragment = fragment1;
        if (fragment1.G == i1) goto _L4; else goto _L8
_L8:
        j1--;
          goto _L9
_L7:
        return null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final Fragment a(Bundle bundle, String s1)
    {
        int i1 = bundle.getInt(s1, -1);
        if (i1 == -1)
        {
            bundle = null;
        } else
        {
            if (i1 >= f.size())
            {
                a(((RuntimeException) (new IllegalStateException((new StringBuilder("Fragment no longer exists for key ")).append(s1).append(": index ").append(i1).toString()))));
            }
            Fragment fragment = (Fragment)f.get(i1);
            bundle = fragment;
            if (fragment == null)
            {
                a(((RuntimeException) (new IllegalStateException((new StringBuilder("Fragment no longer exists for key ")).append(s1).append(": index ").append(i1).toString()))));
                return fragment;
            }
        }
        return bundle;
    }

    public final Fragment a(String s1)
    {
        if (g == null || s1 == null) goto _L2; else goto _L1
_L1:
        int i1 = g.size() - 1;
_L11:
        if (i1 < 0) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)g.get(i1);
        if (fragment == null || !s1.equals(fragment.I)) goto _L5; else goto _L4
_L4:
        return fragment;
_L5:
        i1--;
        continue; /* Loop/switch isn't completed */
_L2:
        if (f == null || s1 == null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        i1 = f.size() - 1;
_L9:
        if (i1 < 0) goto _L7; else goto _L6
_L6:
        Fragment fragment1;
        fragment1 = (Fragment)f.get(i1);
        if (fragment1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        fragment = fragment1;
        if (s1.equals(fragment1.I)) goto _L4; else goto _L8
_L8:
        i1--;
          goto _L9
_L7:
        return null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final m a()
    {
        return new f(this);
    }

    public final View a(View view, String s1, Context context, AttributeSet attributeset)
    {
        if (!"fragment".equals(s1))
        {
            return null;
        }
        String s2 = attributeset.getAttributeValue(null, "class");
        s1 = context.obtainStyledAttributes(attributeset, a.a);
        if (s2 == null)
        {
            s2 = s1.getString(0);
        }
        int k1 = s1.getResourceId(1, -1);
        String s3 = s1.getString(2);
        s1.recycle();
        if (!Fragment.a(o, s2))
        {
            return null;
        }
        int i1;
        if (view != null)
        {
            i1 = view.getId();
        } else
        {
            i1 = 0;
        }
        if (i1 == -1 && k1 == -1 && s3 == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Must specify unique android:id, android:tag, or have a parent with an id for ").append(s2).toString());
        }
        if (k1 != -1)
        {
            s1 = a(k1);
        } else
        {
            s1 = null;
        }
        view = s1;
        if (s1 == null)
        {
            view = s1;
            if (s3 != null)
            {
                view = a(s3);
            }
        }
        s1 = view;
        if (view == null)
        {
            s1 = view;
            if (i1 != -1)
            {
                s1 = a(i1);
            }
        }
        if (a)
        {
            (new StringBuilder("onCreateView: id=0x")).append(Integer.toHexString(k1)).append(" fname=").append(s2).append(" existing=").append(s1);
        }
        if (s1 == null)
        {
            view = Fragment.instantiate(context, s2);
            view.y = true;
            int j1;
            if (k1 != 0)
            {
                j1 = k1;
            } else
            {
                j1 = i1;
            }
            view.G = j1;
            view.H = i1;
            view.I = s3;
            view.z = true;
            view.C = this;
            view.onInflate(o, attributeset, ((Fragment) (view)).n);
            a(((Fragment) (view)), true);
        } else
        {
            if (((Fragment) (s1)).z)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Duplicate id 0x").append(Integer.toHexString(k1)).append(", tag ").append(s3).append(", or parent id 0x").append(Integer.toHexString(i1)).append(" with another fragment for ").append(s2).toString());
            }
            s1.z = true;
            if (!((Fragment) (s1)).M)
            {
                s1.onInflate(o, attributeset, ((Fragment) (s1)).n);
            }
            view = s1;
        }
        if (n <= 0 && ((Fragment) (view)).y)
        {
            a(((Fragment) (view)), 1, 0, 0, false);
        } else
        {
            c(view);
        }
        if (((Fragment) (view)).S == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(s2).append(" did not create a view.").toString());
        }
        if (k1 != 0)
        {
            ((Fragment) (view)).S.setId(k1);
        }
        if (((Fragment) (view)).S.getTag() == null)
        {
            ((Fragment) (view)).S.setTag(s3);
        }
        return ((Fragment) (view)).S;
    }

    final void a(int i1, int j1, int k1, boolean flag)
    {
        if (o == null && i1 != 0)
        {
            throw new IllegalStateException("No activity");
        }
        if (flag || n != i1)
        {
            n = i1;
            if (f != null)
            {
                int l1 = 0;
                boolean flag1 = false;
                for (; l1 < f.size(); l1++)
                {
                    Fragment fragment = (Fragment)f.get(l1);
                    if (fragment == null)
                    {
                        continue;
                    }
                    a(fragment, i1, j1, k1, false);
                    if (fragment.W != null)
                    {
                        flag1 |= fragment.W.a();
                    }
                }

                if (!flag1)
                {
                    h();
                }
                if (r && o != null && n == 5)
                {
                    o.supportInvalidateOptionsMenu();
                    r = false;
                    return;
                }
            }
        }
    }

    public final void a(Configuration configuration)
    {
        if (g != null)
        {
            for (int i1 = 0; i1 < g.size(); i1++)
            {
                Fragment fragment = (Fragment)g.get(i1);
                if (fragment == null)
                {
                    continue;
                }
                fragment.onConfigurationChanged(configuration);
                if (fragment.E != null)
                {
                    fragment.E.a(configuration);
                }
            }

        }
    }

    public final void a(Bundle bundle, String s1, Fragment fragment)
    {
        if (fragment.p < 0)
        {
            a(((RuntimeException) (new IllegalStateException((new StringBuilder("Fragment ")).append(fragment).append(" is not currently in the FragmentManager").toString()))));
        }
        bundle.putInt(s1, fragment.p);
    }

    final void a(Parcelable parcelable, ArrayList arraylist)
    {
        if (parcelable != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (((FragmentManagerState) (parcelable = (FragmentManagerState)parcelable)).a != null)
        {
            if (arraylist != null)
            {
                for (int i1 = 0; i1 < arraylist.size(); i1++)
                {
                    Fragment fragment = (Fragment)arraylist.get(i1);
                    if (a)
                    {
                        (new StringBuilder("restoreAllState: re-attaching retained ")).append(fragment);
                    }
                    FragmentState fragmentstate1 = ((FragmentManagerState) (parcelable)).a[fragment.p];
                    fragmentstate1.k = fragment;
                    fragment.o = null;
                    fragment.B = 0;
                    fragment.z = false;
                    fragment.v = false;
                    fragment.s = null;
                    if (fragmentstate1.j != null)
                    {
                        fragmentstate1.j.setClassLoader(o.getClassLoader());
                        fragment.o = fragmentstate1.j.getSparseParcelableArray("android:view_state");
                        fragment.n = fragmentstate1.j;
                    }
                }

            }
            f = new ArrayList(((FragmentManagerState) (parcelable)).a.length);
            if (h != null)
            {
                h.clear();
            }
            int j1 = 0;
            while (j1 < ((FragmentManagerState) (parcelable)).a.length) 
            {
                FragmentState fragmentstate = ((FragmentManagerState) (parcelable)).a[j1];
                if (fragmentstate != null)
                {
                    Object obj = o;
                    Fragment fragment2 = q;
                    if (fragmentstate.k == null)
                    {
                        if (fragmentstate.i != null)
                        {
                            fragmentstate.i.setClassLoader(((i) (obj)).getClassLoader());
                        }
                        fragmentstate.k = Fragment.instantiate(((Context) (obj)), fragmentstate.a, fragmentstate.i);
                        if (fragmentstate.j != null)
                        {
                            fragmentstate.j.setClassLoader(((i) (obj)).getClassLoader());
                            fragmentstate.k.n = fragmentstate.j;
                        }
                        fragmentstate.k.a(fragmentstate.b, fragment2);
                        fragmentstate.k.y = fragmentstate.c;
                        fragmentstate.k.A = true;
                        fragmentstate.k.G = fragmentstate.d;
                        fragmentstate.k.H = fragmentstate.e;
                        fragmentstate.k.I = fragmentstate.f;
                        fragmentstate.k.L = fragmentstate.g;
                        fragmentstate.k.K = fragmentstate.h;
                        fragmentstate.k.C = ((i) (obj)).mFragments;
                        if (a)
                        {
                            (new StringBuilder("Instantiated fragment ")).append(fragmentstate.k);
                        }
                    }
                    obj = fragmentstate.k;
                    if (a)
                    {
                        (new StringBuilder("restoreAllState: active #")).append(j1).append(": ").append(obj);
                    }
                    f.add(obj);
                    fragmentstate.k = null;
                } else
                {
                    f.add(null);
                    if (h == null)
                    {
                        h = new ArrayList();
                    }
                    h.add(Integer.valueOf(j1));
                }
                j1++;
            }
            if (arraylist != null)
            {
                int k1 = 0;
                while (k1 < arraylist.size()) 
                {
                    Fragment fragment1 = (Fragment)arraylist.get(k1);
                    if (fragment1.t >= 0)
                    {
                        if (fragment1.t < f.size())
                        {
                            fragment1.s = (Fragment)f.get(fragment1.t);
                        } else
                        {
                            (new StringBuilder("Re-attaching retained fragment ")).append(fragment1).append(" target no longer exists: ").append(fragment1.t);
                            fragment1.s = null;
                        }
                    }
                    k1++;
                }
            }
            if (((FragmentManagerState) (parcelable)).b != null)
            {
                g = new ArrayList(((FragmentManagerState) (parcelable)).b.length);
                for (int l1 = 0; l1 < ((FragmentManagerState) (parcelable)).b.length; l1++)
                {
                    arraylist = (Fragment)f.get(((FragmentManagerState) (parcelable)).b[l1]);
                    if (arraylist == null)
                    {
                        a(((RuntimeException) (new IllegalStateException((new StringBuilder("No instantiated fragment for index #")).append(((FragmentManagerState) (parcelable)).b[l1]).toString()))));
                    }
                    arraylist.v = true;
                    if (a)
                    {
                        (new StringBuilder("restoreAllState: added #")).append(l1).append(": ").append(arraylist);
                    }
                    if (g.contains(arraylist))
                    {
                        throw new IllegalStateException("Already added!");
                    }
                    g.add(arraylist);
                }

            } else
            {
                g = null;
            }
            if (((FragmentManagerState) (parcelable)).c != null)
            {
                i = new ArrayList(((FragmentManagerState) (parcelable)).c.length);
                int i2 = 0;
                while (i2 < ((FragmentManagerState) (parcelable)).c.length) 
                {
                    arraylist = ((FragmentManagerState) (parcelable)).c[i2].a(this);
                    if (a)
                    {
                        (new StringBuilder("restoreAllState: back stack #")).append(i2).append(" (index ").append(((f) (arraylist)).p).append("): ").append(arraylist);
                        arraylist.a("  ", new PrintWriter(new d("FragmentManager")), false);
                    }
                    i.add(arraylist);
                    if (((f) (arraylist)).p >= 0)
                    {
                        a(((f) (arraylist)).p, ((f) (arraylist)));
                    }
                    i2++;
                }
            } else
            {
                i = null;
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void a(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            (new StringBuilder("remove: ")).append(fragment).append(" nesting=").append(fragment.B);
        }
        int k1;
        if (fragment.B > 0)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (k1 == 0)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (!fragment.K || k1 != 0)
        {
            if (g != null)
            {
                g.remove(fragment);
            }
            if (fragment.N && fragment.O)
            {
                r = true;
            }
            fragment.v = false;
            fragment.w = true;
            if (k1 != 0)
            {
                k1 = 0;
            } else
            {
                k1 = 1;
            }
            a(fragment, k1, i1, j1, false);
        }
    }

    final void a(Fragment fragment, int i1, int j1, int k1, boolean flag)
    {
        int i2;
label0:
        {
            if (fragment.v)
            {
                i2 = i1;
                if (!fragment.K)
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
        if (fragment.w)
        {
            k2 = i2;
            if (i2 > fragment.k)
            {
                k2 = fragment.k;
            }
        }
        i1 = k2;
        if (fragment.U)
        {
            i1 = k2;
            if (fragment.k < 4)
            {
                i1 = k2;
                if (k2 > 3)
                {
                    i1 = 3;
                }
            }
        }
        if (fragment.k >= i1) goto _L2; else goto _L1
_L1:
        int j2;
        int l2;
        int i3;
        if (fragment.y && !fragment.z)
        {
            return;
        }
        if (fragment.l != null)
        {
            fragment.l = null;
            a(fragment, fragment.m, 0, 0, true);
        }
        j2 = i1;
        i3 = i1;
        l2 = i1;
        fragment.k;
        JVM INSTR tableswitch 0 4: default 184
    //                   0 194
    //                   1 671
    //                   2 1173
    //                   3 1173
    //                   4 1310;
           goto _L3 _L4 _L5 _L6 _L6 _L7
_L3:
        j2 = i1;
_L16:
        fragment.k = j2;
        return;
_L4:
        if (a)
        {
            (new StringBuilder("moveto CREATED: ")).append(fragment);
        }
        l2 = i1;
        if (fragment.n != null)
        {
            fragment.n.setClassLoader(o.getClassLoader());
            fragment.o = fragment.n.getSparseParcelableArray("android:view_state");
            fragment.s = a(fragment.n, "android:target_state");
            if (fragment.s != null)
            {
                fragment.u = fragment.n.getInt("android:target_req_state", 0);
            }
            fragment.V = fragment.n.getBoolean("android:user_visible_hint", true);
            l2 = i1;
            if (!fragment.V)
            {
                fragment.U = true;
                l2 = i1;
                if (i1 > 3)
                {
                    l2 = 3;
                }
            }
        }
        fragment.D = o;
        fragment.F = q;
        l l1;
        if (q != null)
        {
            l1 = q.E;
        } else
        {
            l1 = o.mFragments;
        }
        fragment.C = l1;
        fragment.P = false;
        fragment.onAttach(o);
        if (!fragment.P)
        {
            throw new ah((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onAttach()").toString());
        }
        if (fragment.F == null)
        {
            o.onAttachFragment(fragment);
        }
        if (!fragment.M)
        {
            Object obj = fragment.n;
            if (fragment.E != null)
            {
                fragment.E.s = false;
            }
            fragment.P = false;
            fragment.onCreate(((Bundle) (obj)));
            if (!fragment.P)
            {
                throw new ah((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onCreate()").toString());
            }
            if (obj != null)
            {
                obj = ((Bundle) (obj)).getParcelable("android:support:fragments");
                if (obj != null)
                {
                    if (fragment.E == null)
                    {
                        fragment.q_();
                    }
                    fragment.E.a(((Parcelable) (obj)), ((ArrayList) (null)));
                    fragment.E.l();
                }
            }
        }
        fragment.M = false;
        j2 = l2;
        if (fragment.y)
        {
            fragment.S = fragment.a(fragment.getLayoutInflater(fragment.n), null, fragment.n);
            if (fragment.S != null)
            {
                fragment.T = fragment.S;
                Object obj2;
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    android.support.v4.view.w.s(fragment.S);
                } else
                {
                    fragment.S = android.support.v4.app.r.a(fragment.S);
                }
                if (fragment.J)
                {
                    fragment.S.setVisibility(8);
                }
                fragment.onViewCreated(fragment.S, fragment.n);
                j2 = l2;
            } else
            {
                fragment.T = null;
                j2 = l2;
            }
        }
_L5:
        i3 = j2;
        if (j2 > 1)
        {
            if (a)
            {
                (new StringBuilder("moveto ACTIVITY_CREATED: ")).append(fragment);
            }
            if (!fragment.y)
            {
                Object obj1;
                if (fragment.H != 0)
                {
                    obj2 = (ViewGroup)p.a(fragment.H);
                    obj1 = obj2;
                    if (obj2 == null)
                    {
                        obj1 = obj2;
                        if (!fragment.A)
                        {
                            a(((RuntimeException) (new IllegalArgumentException((new StringBuilder("No view found for id 0x")).append(Integer.toHexString(fragment.H)).append(" (").append(fragment.getResources().getResourceName(fragment.H)).append(") for fragment ").append(fragment).toString()))));
                            obj1 = obj2;
                        }
                    }
                } else
                {
                    obj1 = null;
                }
                fragment.R = ((ViewGroup) (obj1));
                fragment.S = fragment.a(fragment.getLayoutInflater(fragment.n), ((ViewGroup) (obj1)), fragment.n);
                if (fragment.S != null)
                {
                    fragment.T = fragment.S;
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        android.support.v4.view.w.s(fragment.S);
                    } else
                    {
                        fragment.S = android.support.v4.app.r.a(fragment.S);
                    }
                    if (obj1 != null)
                    {
                        obj2 = a(fragment, j1, true, k1);
                        if (obj2 != null)
                        {
                            fragment.S.startAnimation(((Animation) (obj2)));
                        }
                        ((ViewGroup) (obj1)).addView(fragment.S);
                    }
                    if (fragment.J)
                    {
                        fragment.S.setVisibility(8);
                    }
                    fragment.onViewCreated(fragment.S, fragment.n);
                } else
                {
                    fragment.T = null;
                }
            }
            obj1 = fragment.n;
            if (fragment.E != null)
            {
                fragment.E.s = false;
            }
            fragment.P = false;
            fragment.onActivityCreated(((Bundle) (obj1)));
            if (!fragment.P)
            {
                throw new ah((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onActivityCreated()").toString());
            }
            if (fragment.E != null)
            {
                fragment.E.m();
            }
            if (fragment.S != null)
            {
                obj1 = fragment.n;
                if (fragment.o != null)
                {
                    fragment.T.restoreHierarchyState(fragment.o);
                    fragment.o = null;
                }
                fragment.P = false;
                fragment.onViewStateRestored(((Bundle) (obj1)));
                if (!fragment.P)
                {
                    throw new ah((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onViewStateRestored()").toString());
                }
            }
            fragment.n = null;
            i3 = j2;
        }
_L6:
        l2 = i3;
        if (i3 > 3)
        {
            if (a)
            {
                (new StringBuilder("moveto STARTED: ")).append(fragment);
            }
            if (fragment.E != null)
            {
                fragment.E.s = false;
                fragment.E.i();
            }
            fragment.P = false;
            fragment.onStart();
            if (!fragment.P)
            {
                throw new ah((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onStart()").toString());
            }
            if (fragment.E != null)
            {
                fragment.E.n();
            }
            l2 = i3;
            if (fragment.W != null)
            {
                fragment.W.f();
                l2 = i3;
            }
        }
_L7:
        j2 = l2;
        if (l2 > 4)
        {
            if (a)
            {
                (new StringBuilder("moveto RESUMED: ")).append(fragment);
            }
            fragment.x = true;
            if (fragment.E != null)
            {
                fragment.E.s = false;
                fragment.E.i();
            }
            fragment.P = false;
            fragment.onResume();
            if (!fragment.P)
            {
                throw new ah((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onResume()").toString());
            }
            if (fragment.E != null)
            {
                fragment.E.o();
                fragment.E.i();
            }
            fragment.n = null;
            fragment.o = null;
            j2 = l2;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        j2 = i1;
        if (fragment.k <= i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        fragment.k;
        JVM INSTR tableswitch 1 5: default 1504
    //                   1 1510
    //                   2 1775
    //                   3 1745
    //                   4 1658
    //                   5 1565;
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
        if (t && fragment.l != null)
        {
            obj1 = fragment.l;
            fragment.l = null;
            ((View) (obj1)).clearAnimation();
        }
        if (fragment.l != null)
        {
            fragment.m = i1;
            j2 = 1;
            break; /* Loop/switch isn't completed */
        }
          goto _L14
_L13:
        if (i1 < 5)
        {
            if (a)
            {
                (new StringBuilder("movefrom RESUMED: ")).append(fragment);
            }
            if (fragment.E != null)
            {
                fragment.E.c(4);
            }
            fragment.P = false;
            fragment.onPause();
            if (!fragment.P)
            {
                throw new ah((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onPause()").toString());
            }
            fragment.x = false;
        }
_L12:
        if (i1 < 4)
        {
            if (a)
            {
                (new StringBuilder("movefrom STARTED: ")).append(fragment);
            }
            if (fragment.E != null)
            {
                fragment.E.p();
            }
            fragment.P = false;
            fragment.onStop();
            if (!fragment.P)
            {
                throw new ah((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onStop()").toString());
            }
        }
_L11:
        if (i1 < 3)
        {
            if (a)
            {
                (new StringBuilder("movefrom STOPPED: ")).append(fragment);
            }
            fragment.p_();
        }
_L10:
        if (i1 < 2)
        {
            if (a)
            {
                (new StringBuilder("movefrom ACTIVITY_CREATED: ")).append(fragment);
            }
            if (fragment.S != null && !o.isFinishing() && fragment.o == null)
            {
                d(fragment);
            }
            if (fragment.E != null)
            {
                fragment.E.c(1);
            }
            fragment.P = false;
            fragment.onDestroyView();
            if (!fragment.P)
            {
                throw new ah((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onDestroyView()").toString());
            }
            if (fragment.W != null)
            {
                fragment.W.e();
            }
            if (fragment.S != null && fragment.R != null)
            {
                if (n > 0 && !t)
                {
                    obj1 = a(fragment, j1, false, k1);
                } else
                {
                    obj1 = null;
                }
                if (obj1 != null)
                {
                    fragment.l = fragment.S;
                    fragment.m = i1;
                    ((Animation) (obj1)).setAnimationListener(new android.view.animation.Animation.AnimationListener(fragment) {

                        final Fragment a;
                        final l b;

                        public final void onAnimationEnd(Animation animation)
                        {
                            if (a.l != null)
                            {
                                a.l = null;
                                b.a(a, a.m, 0, 0, false);
                            }
                        }

                        public final void onAnimationRepeat(Animation animation)
                        {
                        }

                        public final void onAnimationStart(Animation animation)
                        {
                        }

            
            {
                b = l.this;
                a = fragment;
                super();
            }
                    });
                    fragment.S.startAnimation(((Animation) (obj1)));
                }
                fragment.R.removeView(fragment.S);
            }
            fragment.R = null;
            fragment.S = null;
            fragment.T = null;
        }
        if (true) goto _L9; else goto _L14
_L14:
        if (a)
        {
            (new StringBuilder("movefrom CREATED: ")).append(fragment);
        }
        if (!fragment.M)
        {
            if (fragment.E != null)
            {
                fragment.E.q();
            }
            fragment.P = false;
            fragment.onDestroy();
            if (!fragment.P)
            {
                throw new ah((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onDestroy()").toString());
            }
        }
        fragment.P = false;
        fragment.onDetach();
        if (!fragment.P)
        {
            throw new ah((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onDetach()").toString());
        }
        j2 = i1;
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!fragment.M)
        {
            j2 = i1;
            if (fragment.p >= 0)
            {
                if (a)
                {
                    (new StringBuilder("Freeing fragment index ")).append(fragment);
                }
                f.set(fragment.p, null);
                if (h == null)
                {
                    h = new ArrayList();
                }
                h.add(Integer.valueOf(fragment.p));
                o.invalidateSupportFragment(fragment.q);
                fragment.p = -1;
                fragment.q = null;
                fragment.v = false;
                fragment.w = false;
                fragment.x = false;
                fragment.y = false;
                fragment.z = false;
                fragment.A = false;
                fragment.B = 0;
                fragment.C = null;
                fragment.E = null;
                fragment.D = null;
                fragment.G = 0;
                fragment.H = 0;
                fragment.I = null;
                fragment.J = false;
                fragment.K = false;
                fragment.M = false;
                fragment.W = null;
                fragment.X = false;
                fragment.Y = false;
                j2 = i1;
            }
        } else
        {
            fragment.D = null;
            fragment.F = null;
            fragment.C = null;
            fragment.E = null;
            j2 = i1;
        }
        if (true) goto _L16; else goto _L15
_L15:
    }

    public final void a(Fragment fragment, boolean flag)
    {
        if (g == null)
        {
            g = new ArrayList();
        }
        if (a)
        {
            (new StringBuilder("add: ")).append(fragment);
        }
        if (fragment.p < 0)
        {
            if (h == null || h.size() <= 0)
            {
                if (f == null)
                {
                    f = new ArrayList();
                }
                fragment.a(f.size(), q);
                f.add(fragment);
            } else
            {
                fragment.a(((Integer)h.remove(h.size() - 1)).intValue(), q);
                f.set(fragment.p, fragment);
            }
            if (a)
            {
                (new StringBuilder("Allocated fragment index ")).append(fragment);
            }
        }
        if (!fragment.K)
        {
            if (g.contains(fragment))
            {
                throw new IllegalStateException((new StringBuilder("Fragment already added: ")).append(fragment).toString());
            }
            g.add(fragment);
            fragment.v = true;
            fragment.w = false;
            if (fragment.N && fragment.O)
            {
                r = true;
            }
            if (flag)
            {
                c(fragment);
            }
        }
    }

    public final void a(i i1, j j1, Fragment fragment)
    {
        if (o != null)
        {
            throw new IllegalStateException("Already attached");
        } else
        {
            o = i1;
            p = j1;
            q = fragment;
            return;
        }
    }

    public final void a(k.a a1)
    {
        if (m == null)
        {
            m = new ArrayList();
        }
        m.add(a1);
    }

    public final void a(Runnable runnable, boolean flag)
    {
        if (!flag)
        {
            s();
        }
        this;
        JVM INSTR monitorenter ;
        if (t || o == null)
        {
            throw new IllegalStateException("Activity has been destroyed");
        }
        break MISSING_BLOCK_LABEL_40;
        runnable;
        this;
        JVM INSTR monitorexit ;
        throw runnable;
        if (c == null)
        {
            c = new ArrayList();
        }
        c.add(runnable);
        if (c.size() == 1)
        {
            o.mHandler.removeCallbacks(y);
            o.mHandler.post(y);
        }
        this;
        JVM INSTR monitorexit ;
    }

    public final void a(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        boolean flag;
        flag = false;
        String s2 = (new StringBuilder()).append(s1).append("    ").toString();
        if (f != null)
        {
            int k2 = f.size();
            if (k2 > 0)
            {
                printwriter.print(s1);
                printwriter.print("Active Fragments in ");
                printwriter.print(Integer.toHexString(System.identityHashCode(this)));
                printwriter.println(":");
                for (int i1 = 0; i1 < k2; i1++)
                {
                    Fragment fragment = (Fragment)f.get(i1);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(i1);
                    printwriter.print(": ");
                    printwriter.println(fragment);
                    if (fragment != null)
                    {
                        fragment.dump(s2, filedescriptor, printwriter, as);
                    }
                }

            }
        }
        if (g != null)
        {
            int l2 = g.size();
            if (l2 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Added Fragments:");
                for (int j1 = 0; j1 < l2; j1++)
                {
                    filedescriptor = (Fragment)g.get(j1);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(j1);
                    printwriter.print(": ");
                    printwriter.println(filedescriptor.toString());
                }

            }
        }
        if (j != null)
        {
            int i3 = j.size();
            if (i3 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Fragments Created Menus:");
                for (int k1 = 0; k1 < i3; k1++)
                {
                    filedescriptor = (Fragment)j.get(k1);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(k1);
                    printwriter.print(": ");
                    printwriter.println(filedescriptor.toString());
                }

            }
        }
        if (i != null)
        {
            int j3 = i.size();
            if (j3 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Back Stack:");
                for (int l1 = 0; l1 < j3; l1++)
                {
                    filedescriptor = (f)i.get(l1);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(l1);
                    printwriter.print(": ");
                    printwriter.println(filedescriptor.toString());
                    filedescriptor.a(s2, printwriter);
                }

            }
        }
        this;
        JVM INSTR monitorenter ;
        if (k == null) goto _L2; else goto _L1
_L1:
        int k3 = k.size();
        if (k3 <= 0) goto _L2; else goto _L3
_L3:
        printwriter.print(s1);
        printwriter.println("Back Stack Indices:");
        int i2 = 0;
_L4:
        if (i2 >= k3)
        {
            break; /* Loop/switch isn't completed */
        }
        filedescriptor = (f)k.get(i2);
        printwriter.print(s1);
        printwriter.print("  #");
        printwriter.print(i2);
        printwriter.print(": ");
        printwriter.println(filedescriptor);
        i2++;
        if (true) goto _L4; else goto _L2
_L2:
        if (l != null && l.size() > 0)
        {
            printwriter.print(s1);
            printwriter.print("mAvailBackStackIndices: ");
            printwriter.println(Arrays.toString(l.toArray()));
        }
        this;
        JVM INSTR monitorexit ;
        if (c != null)
        {
            int l3 = c.size();
            if (l3 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Pending Actions:");
                for (int j2 = ((flag) ? 1 : 0); j2 < l3; j2++)
                {
                    filedescriptor = (Runnable)c.get(j2);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(j2);
                    printwriter.print(": ");
                    printwriter.println(filedescriptor);
                }

            }
        }
        break MISSING_BLOCK_LABEL_700;
        s1;
        this;
        JVM INSTR monitorexit ;
        throw s1;
        printwriter.print(s1);
        printwriter.println("FragmentManager misc state:");
        printwriter.print(s1);
        printwriter.print("  mActivity=");
        printwriter.println(o);
        printwriter.print(s1);
        printwriter.print("  mContainer=");
        printwriter.println(p);
        if (q != null)
        {
            printwriter.print(s1);
            printwriter.print("  mParent=");
            printwriter.println(q);
        }
        printwriter.print(s1);
        printwriter.print("  mCurState=");
        printwriter.print(n);
        printwriter.print(" mStateSaved=");
        printwriter.print(s);
        printwriter.print(" mDestroyed=");
        printwriter.println(t);
        if (r)
        {
            printwriter.print(s1);
            printwriter.print("  mNeedMenuInvalidate=");
            printwriter.println(r);
        }
        if (u != null)
        {
            printwriter.print(s1);
            printwriter.print("  mNoTransactionsBecause=");
            printwriter.println(u);
        }
        if (h != null && h.size() > 0)
        {
            printwriter.print(s1);
            printwriter.print("  mAvailIndices: ");
            printwriter.println(Arrays.toString(h.toArray()));
        }
        return;
    }

    final boolean a(int i1, int j1)
    {
        if (i != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (i1 >= 0 || (j1 & 1) != 0) goto _L4; else goto _L3
_L3:
        if ((i1 = i.size() - 1) < 0) goto _L1; else goto _L5
_L5:
        f f1 = (f)i.remove(i1);
        SparseArray sparsearray = new SparseArray();
        SparseArray sparsearray1 = new SparseArray();
        f1.a(sparsearray, sparsearray1);
        f1.a(true, null, sparsearray, sparsearray1);
_L8:
        j();
        return true;
_L4:
        int k1;
        int l1;
        k1 = -1;
        if (i1 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        l1 = i.size() - 1;
        do
        {
            if (l1 < 0)
            {
                break;
            }
            f f2 = (f)i.get(l1);
            if (i1 >= 0 && i1 == f2.p)
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
                f f3 = (f)i.get(j1);
                k1 = j1;
                if (i1 < 0)
                {
                    break;
                }
                k1 = j1;
                if (i1 != f3.p)
                {
                    break;
                }
                j1--;
            } while (true);
        }
        if (k1 == i.size() - 1) goto _L1; else goto _L7
_L7:
        ArrayList arraylist = new ArrayList();
        for (i1 = i.size() - 1; i1 > k1; i1--)
        {
            arraylist.add(i.remove(i1));
        }

        j1 = arraylist.size() - 1;
        SparseArray sparsearray2 = new SparseArray();
        SparseArray sparsearray3 = new SparseArray();
        for (i1 = 0; i1 <= j1; i1++)
        {
            ((f)arraylist.get(i1)).a(sparsearray2, sparsearray3);
        }

        f.b b1 = null;
        i1 = 0;
        while (i1 <= j1) 
        {
            if (a)
            {
                (new StringBuilder("Popping back stack state: ")).append(arraylist.get(i1));
            }
            f f4 = (f)arraylist.get(i1);
            boolean flag;
            if (i1 == j1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            b1 = f4.a(flag, b1, sparsearray2, sparsearray3);
            i1++;
        }
          goto _L8
    }

    public final boolean a(Menu menu)
    {
        if (g == null) goto _L2; else goto _L1
_L1:
        int i1;
        boolean flag2;
        i1 = 0;
        flag2 = false;
_L5:
        boolean flag3 = flag2;
        if (i1 >= g.size()) goto _L4; else goto _L3
_L3:
        Fragment fragment = (Fragment)g.get(i1);
        flag3 = flag2;
        if (fragment != null)
        {
            boolean flag1;
            if (!fragment.J)
            {
                boolean flag;
                if (fragment.N && fragment.O)
                {
                    fragment.onPrepareOptionsMenu(menu);
                    flag = true;
                } else
                {
                    flag = false;
                }
                flag1 = flag;
                if (fragment.E != null)
                {
                    flag1 = flag | fragment.E.a(menu);
                }
            } else
            {
                flag1 = false;
            }
            flag3 = flag2;
            if (flag1)
            {
                flag3 = true;
            }
        }
        i1++;
        flag2 = flag3;
        if (true) goto _L5; else goto _L4
_L2:
        flag3 = false;
_L4:
        return flag3;
    }

    public final boolean a(Menu menu, MenuInflater menuinflater)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        boolean flag1;
        flag1 = false;
        arraylist1 = null;
        arraylist = null;
        if (g == null) goto _L2; else goto _L1
_L1:
        int j1;
        boolean flag2;
        j1 = 0;
        flag2 = false;
_L5:
        boolean flag3;
        arraylist1 = arraylist;
        flag3 = flag2;
        if (j1 >= g.size()) goto _L4; else goto _L3
_L3:
        Fragment fragment = (Fragment)g.get(j1);
        if (fragment != null)
        {
            boolean flag;
            if (!fragment.J)
            {
                int i1;
                if (fragment.N && fragment.O)
                {
                    fragment.onCreateOptionsMenu(menu, menuinflater);
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                flag = i1;
                if (fragment.E != null)
                {
                    flag = i1 | fragment.E.a(menu, menuinflater);
                }
            } else
            {
                flag = false;
            }
            if (flag)
            {
                arraylist1 = arraylist;
                if (arraylist == null)
                {
                    arraylist1 = new ArrayList();
                }
                arraylist1.add(fragment);
                flag2 = true;
                arraylist = arraylist1;
            }
        }
        j1++;
        if (true) goto _L5; else goto _L4
_L2:
        flag3 = false;
_L4:
        if (j != null)
        {
            for (i1 = ((flag1) ? 1 : 0); i1 < j.size(); i1++)
            {
                menu = (Fragment)j.get(i1);
                if (arraylist1 == null || !arraylist1.contains(menu))
                {
                    menu.onDestroyOptionsMenu();
                }
            }

        }
        j = arraylist1;
        return flag3;
    }

    public final boolean a(MenuItem menuitem)
    {
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = flag2;
        if (g == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L12:
        flag1 = flag2;
        if (i1 >= g.size()) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)g.get(i1);
        if (fragment == null) goto _L5; else goto _L4
_L4:
        if (fragment.J) goto _L7; else goto _L6
_L6:
        if (!fragment.N || !fragment.O || !fragment.onOptionsItemSelected(menuitem)) goto _L9; else goto _L8
_L8:
        boolean flag = true;
_L10:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = true;
_L2:
        return flag1;
_L9:
        if (fragment.E != null && fragment.E.a(menuitem))
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
_L7:
        flag = false;
        if (true) goto _L10; else goto _L5
_L5:
        i1++;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public final void b(int i1)
    {
        if (i1 < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad id: ")).append(i1).toString());
        } else
        {
            a(new Runnable(i1) {

                final int a;
                final int b = 1;
                final l c;

                public final void run()
                {
                    l l1 = c;
                    i j1 = c.o;
                    l1.a(a, b);
                }

            
            {
                c = l.this;
                a = i1;
                super();
            }
            }, false);
            return;
        }
    }

    public final void b(Fragment fragment)
    {
label0:
        {
            if (fragment.U)
            {
                if (!e)
                {
                    break label0;
                }
                v = true;
            }
            return;
        }
        fragment.U = false;
        a(fragment, n, 0, 0, false);
    }

    public final void b(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            (new StringBuilder("hide: ")).append(fragment);
        }
        if (!fragment.J)
        {
            fragment.J = true;
            if (fragment.S != null)
            {
                Animation animation = a(fragment, i1, false, j1);
                if (animation != null)
                {
                    fragment.S.startAnimation(animation);
                }
                fragment.S.setVisibility(8);
            }
            if (fragment.v && fragment.N && fragment.O)
            {
                r = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    public final void b(Menu menu)
    {
        if (g != null)
        {
            for (int i1 = 0; i1 < g.size(); i1++)
            {
                Fragment fragment = (Fragment)g.get(i1);
                if (fragment == null || fragment.J)
                {
                    continue;
                }
                if (fragment.N && fragment.O)
                {
                    fragment.onOptionsMenuClosed(menu);
                }
                if (fragment.E != null)
                {
                    fragment.E.b(menu);
                }
            }

        }
    }

    public final boolean b()
    {
        return i();
    }

    public final boolean b(MenuItem menuitem)
    {
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = flag2;
        if (g == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L12:
        flag1 = flag2;
        if (i1 >= g.size()) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)g.get(i1);
        if (fragment == null) goto _L5; else goto _L4
_L4:
        if (fragment.J) goto _L7; else goto _L6
_L6:
        if (!fragment.onContextItemSelected(menuitem)) goto _L9; else goto _L8
_L8:
        boolean flag = true;
_L10:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = true;
_L2:
        return flag1;
_L9:
        if (fragment.E != null && fragment.E.b(menuitem))
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
_L7:
        flag = false;
        if (true) goto _L10; else goto _L5
_L5:
        i1++;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public final void c()
    {
        a(new Runnable() {

            final l a;

            public final void run()
            {
                l l1 = a;
                i i1 = a.o;
                l1.a(-1, 0);
            }

            
            {
                a = l.this;
                super();
            }
        }, false);
    }

    final void c(int i1)
    {
        a(i1, 0, 0, false);
    }

    public final void c(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            (new StringBuilder("show: ")).append(fragment);
        }
        if (fragment.J)
        {
            fragment.J = false;
            if (fragment.S != null)
            {
                Animation animation = a(fragment, i1, true, j1);
                if (animation != null)
                {
                    fragment.S.startAnimation(animation);
                }
                fragment.S.setVisibility(0);
            }
            if (fragment.v && fragment.N && fragment.O)
            {
                r = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    public final void d(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            (new StringBuilder("detach: ")).append(fragment);
        }
        if (!fragment.K)
        {
            fragment.K = true;
            if (fragment.v)
            {
                if (g != null)
                {
                    if (a)
                    {
                        (new StringBuilder("remove from detach: ")).append(fragment);
                    }
                    g.remove(fragment);
                }
                if (fragment.N && fragment.O)
                {
                    r = true;
                }
                fragment.v = false;
                a(fragment, 1, i1, j1, false);
            }
        }
    }

    public final boolean d()
    {
        s();
        i();
        return a(-1, 0);
    }

    public final int e()
    {
        if (i != null)
        {
            return i.size();
        } else
        {
            return 0;
        }
    }

    public final void e(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            (new StringBuilder("attach: ")).append(fragment);
        }
        if (fragment.K)
        {
            fragment.K = false;
            if (!fragment.v)
            {
                if (g == null)
                {
                    g = new ArrayList();
                }
                if (g.contains(fragment))
                {
                    throw new IllegalStateException((new StringBuilder("Fragment already added: ")).append(fragment).toString());
                }
                if (a)
                {
                    (new StringBuilder("add from attach: ")).append(fragment);
                }
                g.add(fragment);
                fragment.v = true;
                if (fragment.N && fragment.O)
                {
                    r = true;
                }
                a(fragment, n, i1, j1, false);
            }
        }
    }

    public final List f()
    {
        return f;
    }

    public final boolean g()
    {
        return t;
    }

    final void h()
    {
        if (f != null)
        {
            int i1 = 0;
            while (i1 < f.size()) 
            {
                Fragment fragment = (Fragment)f.get(i1);
                if (fragment != null)
                {
                    b(fragment);
                }
                i1++;
            }
        }
    }

    public final boolean i()
    {
        if (e)
        {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        if (Looper.myLooper() != o.mHandler.getLooper())
        {
            throw new IllegalStateException("Must be called from main thread of process");
        }
        boolean flag = false;
_L2:
        this;
        JVM INSTR monitorenter ;
        if (c != null && c.size() != 0)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        this;
        JVM INSTR monitorexit ;
        int k1;
        if (!v)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        int i1 = 0;
        int l1;
        for (k1 = 0; i1 < f.size(); k1 = l1)
        {
            Fragment fragment = (Fragment)f.get(i1);
            l1 = k1;
            if (fragment != null)
            {
                l1 = k1;
                if (fragment.W != null)
                {
                    l1 = k1 | fragment.W.a();
                }
            }
            i1++;
        }

        break; /* Loop/switch isn't completed */
        k1 = c.size();
        if (d == null || d.length < k1)
        {
            d = new Runnable[k1];
        }
        c.toArray(d);
        c.clear();
        o.mHandler.removeCallbacks(y);
        this;
        JVM INSTR monitorexit ;
        e = true;
        for (int j1 = 0; j1 < k1; j1++)
        {
            d[j1].run();
            d[j1] = null;
        }

        break MISSING_BLOCK_LABEL_250;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        e = false;
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
        if (k1 == 0)
        {
            v = false;
            h();
        }
        return flag;
    }

    final void j()
    {
        if (m != null)
        {
            for (int i1 = 0; i1 < m.size(); i1++)
            {
                ((k.a)m.get(i1)).a();
            }

        }
    }

    final Parcelable k()
    {
        FragmentManagerState fragmentmanagerstate = null;
        i();
        if (b)
        {
            s = true;
        }
        if (f != null && f.size() > 0)
        {
            int j2 = f.size();
            FragmentState afragmentstate[] = new FragmentState[j2];
            int k1 = 0;
            boolean flag = false;
            while (k1 < j2) 
            {
                Fragment fragment = (Fragment)f.get(k1);
                if (fragment == null)
                {
                    continue;
                }
                if (fragment.p < 0)
                {
                    a(new IllegalStateException((new StringBuilder("Failure saving state: active ")).append(fragment).append(" has cleared index: ").append(fragment.p).toString()));
                }
                FragmentState fragmentstate = new FragmentState(fragment);
                afragmentstate[k1] = fragmentstate;
                if (fragment.k > 0 && fragmentstate.j == null)
                {
                    fragmentstate.j = e(fragment);
                    if (fragment.s != null)
                    {
                        if (fragment.s.p < 0)
                        {
                            a(new IllegalStateException((new StringBuilder("Failure saving state: ")).append(fragment).append(" has target not in fragment manager: ").append(fragment.s).toString()));
                        }
                        if (fragmentstate.j == null)
                        {
                            fragmentstate.j = new Bundle();
                        }
                        a(fragmentstate.j, "android:target_state", fragment.s);
                        if (fragment.u != 0)
                        {
                            fragmentstate.j.putInt("android:target_req_state", fragment.u);
                        }
                    }
                } else
                {
                    fragmentstate.j = fragment.n;
                }
                if (a)
                {
                    (new StringBuilder("Saved state of ")).append(fragment).append(": ").append(fragmentstate.j);
                }
                flag = true;
                k1++;
            }
            if (flag)
            {
                int ai[];
label0:
                {
                    if (g != null)
                    {
                        int l1 = g.size();
                        if (l1 > 0)
                        {
                            int ai1[] = new int[l1];
                            int i1 = 0;
                            do
                            {
                                ai = ai1;
                                if (i1 >= l1)
                                {
                                    break;
                                }
                                ai1[i1] = ((Fragment)g.get(i1)).p;
                                if (ai1[i1] < 0)
                                {
                                    a(new IllegalStateException((new StringBuilder("Failure saving state: active ")).append(g.get(i1)).append(" has cleared index: ").append(ai1[i1]).toString()));
                                }
                                if (a)
                                {
                                    (new StringBuilder("saveAllState: adding fragment #")).append(i1).append(": ").append(g.get(i1));
                                }
                                i1++;
                            } while (true);
                            break label0;
                        }
                    }
                    ai = null;
                }
                BackStackState abackstackstate[] = fragmentmanagerstate;
                if (i != null)
                {
                    int i2 = i.size();
                    abackstackstate = fragmentmanagerstate;
                    if (i2 > 0)
                    {
                        BackStackState abackstackstate1[] = new BackStackState[i2];
                        int j1 = 0;
                        do
                        {
                            abackstackstate = abackstackstate1;
                            if (j1 >= i2)
                            {
                                break;
                            }
                            abackstackstate1[j1] = new BackStackState((f)i.get(j1));
                            if (a)
                            {
                                (new StringBuilder("saveAllState: adding back stack #")).append(j1).append(": ").append(i.get(j1));
                            }
                            j1++;
                        } while (true);
                    }
                }
                abackstackstate1 = new FragmentManagerState();
                abackstackstate1.a = afragmentstate;
                abackstackstate1.b = ai;
                abackstackstate1.c = abackstackstate;
                return abackstackstate1;
            }
        }
        return null;
    }

    public final void l()
    {
        s = false;
        c(1);
    }

    public final void m()
    {
        s = false;
        c(2);
    }

    public final void n()
    {
        s = false;
        c(4);
    }

    public final void o()
    {
        s = false;
        c(5);
    }

    public final void p()
    {
        s = true;
        c(3);
    }

    public final void q()
    {
        t = true;
        i();
        c(0);
        o = null;
        p = null;
        q = null;
    }

    public final void r()
    {
        if (g != null)
        {
            for (int i1 = 0; i1 < g.size(); i1++)
            {
                Fragment fragment = (Fragment)g.get(i1);
                if (fragment == null)
                {
                    continue;
                }
                fragment.onLowMemory();
                if (fragment.E != null)
                {
                    fragment.E.r();
                }
            }

        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("FragmentManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        if (q != null)
        {
            android.support.v4.f.c.a(q, stringbuilder);
        } else
        {
            android.support.v4.f.c.a(o, stringbuilder);
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
        b = flag;
    }
}
