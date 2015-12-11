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
import android.support.v4.e.a;
import android.support.v4.g.d;
import android.support.v4.view.ag;
import android.support.v4.view.bi;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
//            aa, ac, Fragment, z, 
//            af, g, ad, ay, 
//            FragmentManagerState, FragmentState, BackStackState, cz, 
//            x, bd, ae, ai, 
//            an

final class ab extends aa
    implements ag
{

    static boolean a = false;
    private static boolean m;
    private static Interpolator y = new DecelerateInterpolator(2.5F);
    private static Interpolator z = new DecelerateInterpolator(1.5F);
    ArrayList b;
    ArrayList c;
    ArrayList d;
    ArrayList e;
    ArrayList f;
    ArrayList g;
    int h;
    z i;
    x j;
    boolean k;
    String l;
    private ArrayList n;
    private Runnable o[];
    private boolean p;
    private ArrayList q;
    private Fragment r;
    private boolean s;
    private boolean t;
    private boolean u;
    private Bundle v;
    private SparseArray w;
    private Runnable x;

    ab()
    {
        h = 0;
        v = null;
        w = null;
        x = new ac(this);
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

    private Animation a(Fragment fragment, int i1, boolean flag, int j1)
    {
        Animation animation = fragment.onCreateAnimation(i1, flag, fragment.mNextAnim);
        if (animation == null) goto _L2; else goto _L1
_L1:
        fragment = animation;
_L4:
        return fragment;
_L2:
        if (fragment.mNextAnim == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        animation = AnimationUtils.loadAnimation(i.a, fragment.mNextAnim);
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
                if (i.e())
                {
                    i1 = i.f();
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

    private void a(int i1, g g1)
    {
        this;
        JVM INSTR monitorenter ;
        int k1;
        if (f == null)
        {
            f = new ArrayList();
        }
        k1 = f.size();
        int j1 = k1;
        if (i1 >= k1) goto _L2; else goto _L1
_L1:
        f.set(i1, g1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (j1 >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        f.add(null);
        if (g == null)
        {
            g = new ArrayList();
        }
        g.add(Integer.valueOf(j1));
        j1++;
        if (true) goto _L2; else goto _L3
_L3:
        f.add(g1);
          goto _L4
        g1;
        this;
        JVM INSTR monitorexit ;
        throw g1;
    }

    private void a(RuntimeException runtimeexception)
    {
        Log.e("FragmentManager", runtimeexception.getMessage());
        Log.e("FragmentManager", "Activity state:");
        Object obj = new PrintWriter(new d("FragmentManager"));
        if (i != null)
        {
            try
            {
                i.a("  ", null, ((PrintWriter) (obj)), new String[0]);
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

    static boolean a(View view, Animation animation)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (bi.g(view) != 0) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (!bi.x(view)) goto _L2; else goto _L3
_L3:
        if (!(animation instanceof AlphaAnimation)) goto _L5; else goto _L4
_L4:
        int i1 = 1;
_L7:
        flag = flag1;
        if (i1 != 0)
        {
            flag = true;
        }
_L2:
        return flag;
_L5:
        if (animation instanceof AnimationSet)
        {
            view = ((AnimationSet)animation).getAnimations();
            i1 = 0;
            do
            {
                if (i1 >= view.size())
                {
                    break;
                }
                if (view.get(i1) instanceof AlphaAnimation)
                {
                    i1 = 1;
                    continue; /* Loop/switch isn't completed */
                }
                i1++;
            } while (true);
        }
        i1 = 0;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private Fragment b(int i1)
    {
        if (c == null) goto _L2; else goto _L1
_L1:
        int j1 = c.size() - 1;
_L11:
        if (j1 < 0) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)c.get(j1);
        if (fragment == null || fragment.mFragmentId != i1) goto _L5; else goto _L4
_L4:
        return fragment;
_L5:
        j1--;
        continue; /* Loop/switch isn't completed */
_L2:
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        j1 = b.size() - 1;
_L9:
        if (j1 < 0) goto _L7; else goto _L6
_L6:
        Fragment fragment1;
        fragment1 = (Fragment)b.get(j1);
        if (fragment1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        fragment = fragment1;
        if (fragment1.mFragmentId == i1) goto _L4; else goto _L8
_L8:
        j1--;
          goto _L9
_L7:
        return null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private static void b(View view, Animation animation)
    {
        while (view == null || animation == null || !a(view, animation)) 
        {
            return;
        }
        animation.setAnimationListener(new af(view, animation));
    }

    private void c(Fragment fragment)
    {
        a(fragment, h, 0, 0, false);
    }

    private void d(Fragment fragment)
    {
        if (fragment.mInnerView != null)
        {
            if (w == null)
            {
                w = new SparseArray();
            } else
            {
                w.clear();
            }
            fragment.mInnerView.saveHierarchyState(w);
            if (w.size() > 0)
            {
                fragment.mSavedViewState = w;
                w = null;
                return;
            }
        }
    }

    private Bundle e(Fragment fragment)
    {
        if (v == null)
        {
            v = new Bundle();
        }
        fragment.performSaveInstanceState(v);
        Bundle bundle;
        Bundle bundle1;
        if (!v.isEmpty())
        {
            bundle1 = v;
            v = null;
        } else
        {
            bundle1 = null;
        }
        if (fragment.mView != null)
        {
            d(fragment);
        }
        bundle = bundle1;
        if (fragment.mSavedViewState != null)
        {
            bundle = bundle1;
            if (bundle1 == null)
            {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        bundle1 = bundle;
        if (!fragment.mUserVisibleHint)
        {
            bundle1 = bundle;
            if (bundle == null)
            {
                bundle1 = new Bundle();
            }
            bundle1.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle1;
    }

    private void o()
    {
        if (b != null)
        {
            int i1 = 0;
            while (i1 < b.size()) 
            {
                Fragment fragment = (Fragment)b.get(i1);
                if (fragment != null)
                {
                    b(fragment);
                }
                i1++;
            }
        }
    }

    private void p()
    {
        if (k)
        {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (l != null)
        {
            throw new IllegalStateException((new StringBuilder("Can not perform this action inside of ")).append(l).toString());
        } else
        {
            return;
        }
    }

    public final int a(g g1)
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        if (g != null && g.size() > 0)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (f == null)
        {
            f = new ArrayList();
        }
        i1 = f.size();
        f.add(g1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        i1 = ((Integer)g.remove(g.size() - 1)).intValue();
        f.set(i1, g1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        g1;
        this;
        JVM INSTR monitorexit ;
        throw g1;
    }

    public final Fragment.SavedState a(Fragment fragment)
    {
        Object obj = null;
        if (fragment.mIndex < 0)
        {
            a(((RuntimeException) (new IllegalStateException((new StringBuilder("Fragment ")).append(fragment).append(" is not currently in the FragmentManager").toString()))));
        }
        Fragment.SavedState savedstate = obj;
        if (fragment.mState > 0)
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

    public final Fragment a(Bundle bundle, String s1)
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
            Fragment fragment = (Fragment)b.get(i1);
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
        if (c == null || s1 == null) goto _L2; else goto _L1
_L1:
        int i1 = c.size() - 1;
_L11:
        if (i1 < 0) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)c.get(i1);
        if (fragment == null || !s1.equals(fragment.mTag)) goto _L5; else goto _L4
_L4:
        return fragment;
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
        Fragment fragment1;
        fragment1 = (Fragment)b.get(i1);
        if (fragment1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        fragment = fragment1;
        if (s1.equals(fragment1.mTag)) goto _L4; else goto _L8
_L8:
        i1--;
          goto _L9
_L7:
        return null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final an a()
    {
        return new g(this);
    }

    public final void a(int i1, int j1)
    {
        if (i1 < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad id: ")).append(i1).toString());
        } else
        {
            a(((Runnable) (new ad(this, i1, 1))), false);
            return;
        }
    }

    final void a(int i1, int j1, int k1, boolean flag)
    {
        if (i == null && i1 != 0)
        {
            throw new IllegalStateException("No host");
        }
        if (flag || h != i1)
        {
            h = i1;
            if (b != null)
            {
                int l1 = 0;
                boolean flag1 = false;
                for (; l1 < b.size(); l1++)
                {
                    Fragment fragment = (Fragment)b.get(l1);
                    if (fragment == null)
                    {
                        continue;
                    }
                    a(fragment, i1, j1, k1, false);
                    if (fragment.mLoaderManager != null)
                    {
                        flag1 |= fragment.mLoaderManager.a();
                    }
                }

                if (!flag1)
                {
                    o();
                }
                if (s && i != null && h == 5)
                {
                    i.d();
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
                Fragment fragment = (Fragment)c.get(i1);
                if (fragment != null)
                {
                    fragment.performConfigurationChanged(configuration);
                }
            }

        }
    }

    public final void a(Bundle bundle, String s1, Fragment fragment)
    {
        if (fragment.mIndex < 0)
        {
            a(((RuntimeException) (new IllegalStateException((new StringBuilder("Fragment ")).append(fragment).append(" is not currently in the FragmentManager").toString()))));
        }
        bundle.putInt(s1, fragment.mIndex);
    }

    final void a(Parcelable parcelable, List list)
    {
        boolean flag = false;
        if (parcelable != null) goto _L2; else goto _L1
_L1:
        FragmentManagerState fragmentmanagerstate;
        return;
_L2:
        if ((fragmentmanagerstate = (FragmentManagerState)parcelable).a != null)
        {
            if (list != null)
            {
                for (int i1 = 0; i1 < list.size(); i1++)
                {
                    parcelable = (Fragment)list.get(i1);
                    FragmentState fragmentstate = fragmentmanagerstate.a[((Fragment) (parcelable)).mIndex];
                    fragmentstate.k = parcelable;
                    parcelable.mSavedViewState = null;
                    parcelable.mBackStackNesting = 0;
                    parcelable.mInLayout = false;
                    parcelable.mAdded = false;
                    parcelable.mTarget = null;
                    if (fragmentstate.j != null)
                    {
                        fragmentstate.j.setClassLoader(i.a.getClassLoader());
                        parcelable.mSavedViewState = fragmentstate.j.getSparseParcelableArray("android:view_state");
                        parcelable.mSavedFragmentState = fragmentstate.j;
                    }
                }

            }
            b = new ArrayList(fragmentmanagerstate.a.length);
            if (d != null)
            {
                d.clear();
            }
            int j1 = 0;
            while (j1 < fragmentmanagerstate.a.length) 
            {
                FragmentState fragmentstate1 = fragmentmanagerstate.a[j1];
                if (fragmentstate1 != null)
                {
                    parcelable = i;
                    Fragment fragment = r;
                    if (fragmentstate1.k != null)
                    {
                        parcelable = fragmentstate1.k;
                    } else
                    {
                        Context context = ((z) (parcelable)).a;
                        if (fragmentstate1.i != null)
                        {
                            fragmentstate1.i.setClassLoader(context.getClassLoader());
                        }
                        fragmentstate1.k = Fragment.instantiate(context, fragmentstate1.a, fragmentstate1.i);
                        if (fragmentstate1.j != null)
                        {
                            fragmentstate1.j.setClassLoader(context.getClassLoader());
                            fragmentstate1.k.mSavedFragmentState = fragmentstate1.j;
                        }
                        fragmentstate1.k.setIndex(fragmentstate1.b, fragment);
                        fragmentstate1.k.mFromLayout = fragmentstate1.c;
                        fragmentstate1.k.mRestored = true;
                        fragmentstate1.k.mFragmentId = fragmentstate1.d;
                        fragmentstate1.k.mContainerId = fragmentstate1.e;
                        fragmentstate1.k.mTag = fragmentstate1.f;
                        fragmentstate1.k.mRetainInstance = fragmentstate1.g;
                        fragmentstate1.k.mDetached = fragmentstate1.h;
                        fragmentstate1.k.mFragmentManager = ((z) (parcelable)).b;
                        boolean flag1 = a;
                        parcelable = fragmentstate1.k;
                    }
                    b.add(parcelable);
                    fragmentstate1.k = null;
                } else
                {
                    b.add(null);
                    if (d == null)
                    {
                        d = new ArrayList();
                    }
                    d.add(Integer.valueOf(j1));
                }
                j1++;
            }
            if (list != null)
            {
                int k1 = 0;
                while (k1 < list.size()) 
                {
                    parcelable = (Fragment)list.get(k1);
                    if (((Fragment) (parcelable)).mTargetIndex >= 0)
                    {
                        if (((Fragment) (parcelable)).mTargetIndex < b.size())
                        {
                            parcelable.mTarget = (Fragment)b.get(((Fragment) (parcelable)).mTargetIndex);
                        } else
                        {
                            Log.w("FragmentManager", (new StringBuilder("Re-attaching retained fragment ")).append(parcelable).append(" target no longer exists: ").append(((Fragment) (parcelable)).mTargetIndex).toString());
                            parcelable.mTarget = null;
                        }
                    }
                    k1++;
                }
            }
            if (fragmentmanagerstate.b != null)
            {
                c = new ArrayList(fragmentmanagerstate.b.length);
                for (int l1 = 0; l1 < fragmentmanagerstate.b.length; l1++)
                {
                    parcelable = (Fragment)b.get(fragmentmanagerstate.b[l1]);
                    if (parcelable == null)
                    {
                        a(((RuntimeException) (new IllegalStateException((new StringBuilder("No instantiated fragment for index #")).append(fragmentmanagerstate.b[l1]).toString()))));
                    }
                    parcelable.mAdded = true;
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
            if (fragmentmanagerstate.c != null)
            {
                e = new ArrayList(fragmentmanagerstate.c.length);
                int i2 = ((flag) ? 1 : 0);
                while (i2 < fragmentmanagerstate.c.length) 
                {
                    parcelable = fragmentmanagerstate.c[i2].a(this);
                    e.add(parcelable);
                    if (((g) (parcelable)).g >= 0)
                    {
                        a(((g) (parcelable)).g, ((g) (parcelable)));
                    }
                    i2++;
                }
            } else
            {
                e = null;
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void a(Fragment fragment, int i1, int j1)
    {
        int k1;
        if (!fragment.isInBackStack())
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (!fragment.mDetached || k1 != 0)
        {
            if (c != null)
            {
                c.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible)
            {
                s = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
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
        int l1;
label0:
        {
            if (fragment.mAdded)
            {
                l1 = i1;
                if (!fragment.mDetached)
                {
                    break label0;
                }
            }
            l1 = i1;
            if (i1 > 1)
            {
                l1 = 1;
            }
        }
        int j2 = l1;
        if (fragment.mRemoving)
        {
            j2 = l1;
            if (l1 > fragment.mState)
            {
                j2 = fragment.mState;
            }
        }
        i1 = j2;
        if (fragment.mDeferStart)
        {
            i1 = j2;
            if (fragment.mState < 4)
            {
                i1 = j2;
                if (j2 > 3)
                {
                    i1 = 3;
                }
            }
        }
        if (fragment.mState >= i1) goto _L2; else goto _L1
_L1:
        int i2;
        int k2;
        int l2;
        if (fragment.mFromLayout && !fragment.mInLayout)
        {
            return;
        }
        if (fragment.mAnimatingAway != null)
        {
            fragment.mAnimatingAway = null;
            a(fragment, fragment.mStateAfterAnimating, 0, 0, true);
        }
        i2 = i1;
        l2 = i1;
        k2 = i1;
        fragment.mState;
        JVM INSTR tableswitch 0 4: default 184
    //                   0 194
    //                   1 547
    //                   2 842
    //                   3 842
    //                   4 860;
           goto _L3 _L4 _L5 _L6 _L6 _L7
_L3:
        i2 = i1;
_L16:
        fragment.mState = i2;
        return;
_L4:
        k2 = i1;
        if (fragment.mSavedFragmentState != null)
        {
            fragment.mSavedFragmentState.setClassLoader(i.a.getClassLoader());
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            fragment.mTarget = a(fragment.mSavedFragmentState, "android:target_state");
            if (fragment.mTarget != null)
            {
                fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            k2 = i1;
            if (!fragment.mUserVisibleHint)
            {
                fragment.mDeferStart = true;
                k2 = i1;
                if (i1 > 3)
                {
                    k2 = 3;
                }
            }
        }
        fragment.mHost = i;
        fragment.mParentFragment = r;
        ab ab1;
        if (r != null)
        {
            ab1 = r.mChildFragmentManager;
        } else
        {
            ab1 = i.b;
        }
        fragment.mFragmentManager = ab1;
        fragment.mCalled = false;
        fragment.onAttach(i.a);
        if (!fragment.mCalled)
        {
            throw new cz((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onAttach()").toString());
        }
        if (fragment.mParentFragment == null)
        {
            i.a(fragment);
        }
        if (!fragment.mRetaining)
        {
            fragment.performCreate(fragment.mSavedFragmentState);
        }
        fragment.mRetaining = false;
        i2 = k2;
        if (fragment.mFromLayout)
        {
            fragment.mView = fragment.performCreateView(fragment.getLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            if (fragment.mView != null)
            {
                fragment.mInnerView = fragment.mView;
                Object obj1;
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    bi.b(fragment.mView, false);
                } else
                {
                    fragment.mView = android.support.v4.app.bd.a(fragment.mView);
                }
                if (fragment.mHidden)
                {
                    fragment.mView.setVisibility(8);
                }
                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                i2 = k2;
            } else
            {
                fragment.mInnerView = null;
                i2 = k2;
            }
        }
_L5:
        l2 = i2;
        if (i2 > 1)
        {
            if (!fragment.mFromLayout)
            {
                Object obj;
                if (fragment.mContainerId != 0)
                {
                    obj1 = (ViewGroup)j.a(fragment.mContainerId);
                    obj = obj1;
                    if (obj1 == null)
                    {
                        obj = obj1;
                        if (!fragment.mRestored)
                        {
                            a(((RuntimeException) (new IllegalArgumentException((new StringBuilder("No view found for id 0x")).append(Integer.toHexString(fragment.mContainerId)).append(" (").append(fragment.getResources().getResourceName(fragment.mContainerId)).append(") for fragment ").append(fragment).toString()))));
                            obj = obj1;
                        }
                    }
                } else
                {
                    obj = null;
                }
                fragment.mContainer = ((ViewGroup) (obj));
                fragment.mView = fragment.performCreateView(fragment.getLayoutInflater(fragment.mSavedFragmentState), ((ViewGroup) (obj)), fragment.mSavedFragmentState);
                if (fragment.mView != null)
                {
                    fragment.mInnerView = fragment.mView;
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        bi.b(fragment.mView, false);
                    } else
                    {
                        fragment.mView = android.support.v4.app.bd.a(fragment.mView);
                    }
                    if (obj != null)
                    {
                        obj1 = a(fragment, j1, true, k1);
                        if (obj1 != null)
                        {
                            b(fragment.mView, ((Animation) (obj1)));
                            fragment.mView.startAnimation(((Animation) (obj1)));
                        }
                        ((ViewGroup) (obj)).addView(fragment.mView);
                    }
                    if (fragment.mHidden)
                    {
                        fragment.mView.setVisibility(8);
                    }
                    fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                } else
                {
                    fragment.mInnerView = null;
                }
            }
            fragment.performActivityCreated(fragment.mSavedFragmentState);
            if (fragment.mView != null)
            {
                fragment.restoreViewState(fragment.mSavedFragmentState);
            }
            fragment.mSavedFragmentState = null;
            l2 = i2;
        }
_L6:
        k2 = l2;
        if (l2 > 3)
        {
            fragment.performStart();
            k2 = l2;
        }
_L7:
        i2 = k2;
        if (k2 > 4)
        {
            fragment.mResumed = true;
            fragment.performResume();
            fragment.mSavedFragmentState = null;
            fragment.mSavedViewState = null;
            i2 = k2;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        i2 = i1;
        if (fragment.mState <= i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        fragment.mState;
        JVM INSTR tableswitch 1 5: default 992
    //                   1 998
    //                   2 1085
    //                   3 1076
    //                   4 1067
    //                   5 1053;
           goto _L8 _L9 _L10 _L11 _L12 _L13
_L8:
        i2 = i1;
        break; /* Loop/switch isn't completed */
_L9:
        i2 = i1;
        if (i1 > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (t && fragment.mAnimatingAway != null)
        {
            obj = fragment.mAnimatingAway;
            fragment.mAnimatingAway = null;
            ((View) (obj)).clearAnimation();
        }
        if (fragment.mAnimatingAway != null)
        {
            fragment.mStateAfterAnimating = i1;
            i2 = 1;
            break; /* Loop/switch isn't completed */
        }
          goto _L14
_L13:
        if (i1 < 5)
        {
            fragment.performPause();
            fragment.mResumed = false;
        }
_L12:
        if (i1 < 4)
        {
            fragment.performStop();
        }
_L11:
        if (i1 < 3)
        {
            fragment.performReallyStop();
        }
_L10:
        if (i1 < 2)
        {
            if (fragment.mView != null && i.b() && fragment.mSavedViewState == null)
            {
                d(fragment);
            }
            fragment.performDestroyView();
            if (fragment.mView != null && fragment.mContainer != null)
            {
                if (h > 0 && !t)
                {
                    obj = a(fragment, j1, false, k1);
                } else
                {
                    obj = null;
                }
                if (obj != null)
                {
                    fragment.mAnimatingAway = fragment.mView;
                    fragment.mStateAfterAnimating = i1;
                    ((Animation) (obj)).setAnimationListener(new ae(this, fragment.mView, ((Animation) (obj)), fragment));
                    fragment.mView.startAnimation(((Animation) (obj)));
                }
                fragment.mContainer.removeView(fragment.mView);
            }
            fragment.mContainer = null;
            fragment.mView = null;
            fragment.mInnerView = null;
        }
        if (true) goto _L9; else goto _L14
_L14:
        if (!fragment.mRetaining)
        {
            fragment.performDestroy();
        }
        fragment.mCalled = false;
        fragment.onDetach();
        if (!fragment.mCalled)
        {
            throw new cz((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onDetach()").toString());
        }
        i2 = i1;
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!fragment.mRetaining)
        {
            i2 = i1;
            if (fragment.mIndex >= 0)
            {
                b.set(fragment.mIndex, null);
                if (d == null)
                {
                    d = new ArrayList();
                }
                d.add(Integer.valueOf(fragment.mIndex));
                i.b(fragment.mWho);
                fragment.initState();
                i2 = i1;
            }
        } else
        {
            fragment.mHost = null;
            fragment.mParentFragment = null;
            fragment.mFragmentManager = null;
            fragment.mChildFragmentManager = null;
            i2 = i1;
        }
        if (true) goto _L16; else goto _L15
_L15:
    }

    public final void a(Fragment fragment, boolean flag)
    {
        if (c == null)
        {
            c = new ArrayList();
        }
        if (fragment.mIndex < 0)
        {
            if (d == null || d.size() <= 0)
            {
                if (b == null)
                {
                    b = new ArrayList();
                }
                fragment.setIndex(b.size(), r);
                b.add(fragment);
            } else
            {
                fragment.setIndex(((Integer)d.remove(d.size() - 1)).intValue(), r);
                b.set(fragment.mIndex, fragment);
            }
        }
        if (!fragment.mDetached)
        {
            if (c.contains(fragment))
            {
                throw new IllegalStateException((new StringBuilder("Fragment already added: ")).append(fragment).toString());
            }
            c.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mHasMenu && fragment.mMenuVisible)
            {
                s = true;
            }
            if (flag)
            {
                c(fragment);
            }
        }
    }

    public final void a(z z1, x x1, Fragment fragment)
    {
        if (i != null)
        {
            throw new IllegalStateException("Already attached");
        } else
        {
            i = z1;
            j = x1;
            r = fragment;
            return;
        }
    }

    public final void a(Runnable runnable, boolean flag)
    {
        if (!flag)
        {
            p();
        }
        this;
        JVM INSTR monitorenter ;
        if (t || i == null)
        {
            throw new IllegalStateException("Activity has been destroyed");
        }
        break MISSING_BLOCK_LABEL_40;
        runnable;
        this;
        JVM INSTR monitorexit ;
        throw runnable;
        if (n == null)
        {
            n = new ArrayList();
        }
        n.add(runnable);
        if (n.size() == 1)
        {
            i.i().removeCallbacks(x);
            i.i().post(x);
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
            int k2 = b.size();
            if (k2 > 0)
            {
                printwriter.print(s1);
                printwriter.print("Active Fragments in ");
                printwriter.print(Integer.toHexString(System.identityHashCode(this)));
                printwriter.println(":");
                for (int i1 = 0; i1 < k2; i1++)
                {
                    Fragment fragment = (Fragment)b.get(i1);
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
        if (c != null)
        {
            int l2 = c.size();
            if (l2 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Added Fragments:");
                for (int j1 = 0; j1 < l2; j1++)
                {
                    filedescriptor = (Fragment)c.get(j1);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(j1);
                    printwriter.print(": ");
                    printwriter.println(filedescriptor.toString());
                }

            }
        }
        if (q != null)
        {
            int i3 = q.size();
            if (i3 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Fragments Created Menus:");
                for (int k1 = 0; k1 < i3; k1++)
                {
                    filedescriptor = (Fragment)q.get(k1);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(k1);
                    printwriter.print(": ");
                    printwriter.println(filedescriptor.toString());
                }

            }
        }
        if (e != null)
        {
            int j3 = e.size();
            if (j3 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Back Stack:");
                for (int l1 = 0; l1 < j3; l1++)
                {
                    filedescriptor = (g)e.get(l1);
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
        if (f == null) goto _L2; else goto _L1
_L1:
        int k3 = f.size();
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
        filedescriptor = (g)f.get(i2);
        printwriter.print(s1);
        printwriter.print("  #");
        printwriter.print(i2);
        printwriter.print(": ");
        printwriter.println(filedescriptor);
        i2++;
        if (true) goto _L4; else goto _L2
_L2:
        if (g != null && g.size() > 0)
        {
            printwriter.print(s1);
            printwriter.print("mAvailBackStackIndices: ");
            printwriter.println(Arrays.toString(g.toArray()));
        }
        this;
        JVM INSTR monitorexit ;
        if (n != null)
        {
            int l3 = n.size();
            if (l3 > 0)
            {
                printwriter.print(s1);
                printwriter.println("Pending Actions:");
                for (int j2 = ((flag) ? 1 : 0); j2 < l3; j2++)
                {
                    filedescriptor = (Runnable)n.get(j2);
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
        printwriter.print("  mHost=");
        printwriter.println(i);
        printwriter.print(s1);
        printwriter.print("  mContainer=");
        printwriter.println(j);
        if (r != null)
        {
            printwriter.print(s1);
            printwriter.print("  mParent=");
            printwriter.println(r);
        }
        printwriter.print(s1);
        printwriter.print("  mCurState=");
        printwriter.print(h);
        printwriter.print(" mStateSaved=");
        printwriter.print(k);
        printwriter.print(" mDestroyed=");
        printwriter.println(t);
        if (s)
        {
            printwriter.print(s1);
            printwriter.print("  mNeedMenuInvalidate=");
            printwriter.println(s);
        }
        if (l != null)
        {
            printwriter.print(s1);
            printwriter.print("  mNoTransactionsBecause=");
            printwriter.println(l);
        }
        if (d != null && d.size() > 0)
        {
            printwriter.print(s1);
            printwriter.print("  mAvailIndices: ");
            printwriter.println(Arrays.toString(d.toArray()));
        }
        return;
    }

    public final boolean a(Menu menu)
    {
        boolean flag1;
        if (c != null)
        {
            int i1 = 0;
            boolean flag = false;
            do
            {
                flag1 = flag;
                if (i1 >= c.size())
                {
                    break;
                }
                Fragment fragment = (Fragment)c.get(i1);
                flag1 = flag;
                if (fragment != null)
                {
                    flag1 = flag;
                    if (fragment.performPrepareOptionsMenu(menu))
                    {
                        flag1 = true;
                    }
                }
                i1++;
                flag = flag1;
            } while (true);
        } else
        {
            flag1 = false;
        }
        return flag1;
    }

    public final boolean a(Menu menu, MenuInflater menuinflater)
    {
        boolean flag = false;
        ArrayList arraylist1 = null;
        ArrayList arraylist = null;
        boolean flag2;
        if (c != null)
        {
            int i1 = 0;
            boolean flag1 = false;
            do
            {
                arraylist1 = arraylist;
                flag2 = flag1;
                if (i1 >= c.size())
                {
                    break;
                }
                Fragment fragment = (Fragment)c.get(i1);
                arraylist1 = arraylist;
                flag2 = flag1;
                if (fragment != null)
                {
                    arraylist1 = arraylist;
                    flag2 = flag1;
                    if (fragment.performCreateOptionsMenu(menu, menuinflater))
                    {
                        flag2 = true;
                        arraylist1 = arraylist;
                        if (arraylist == null)
                        {
                            arraylist1 = new ArrayList();
                        }
                        arraylist1.add(fragment);
                    }
                }
                i1++;
                flag1 = flag2;
                arraylist = arraylist1;
            } while (true);
        } else
        {
            flag2 = false;
        }
        if (q != null)
        {
            for (int j1 = ((flag) ? 1 : 0); j1 < q.size(); j1++)
            {
                menu = (Fragment)q.get(j1);
                if (arraylist1 == null || !arraylist1.contains(menu))
                {
                    menu.onDestroyOptionsMenu();
                }
            }

        }
        q = arraylist1;
        return flag2;
    }

    public final boolean a(MenuItem menuitem)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (c == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L7:
        flag = flag1;
        if (i1 >= c.size()) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)c.get(i1);
        if (fragment == null || !fragment.performOptionsItemSelected(menuitem)) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    final boolean a(String s1, int i1, int j1)
    {
        if (e != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (i1 >= 0 || (j1 & 1) != 0) goto _L4; else goto _L3
_L3:
        if ((i1 = e.size() - 1) < 0) goto _L1; else goto _L5
_L5:
        s1 = (g)e.remove(i1);
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
        l1 = e.size() - 1;
        do
        {
            if (l1 < 0)
            {
                break;
            }
            s1 = (g)e.get(l1);
            if (i1 >= 0 && i1 == ((g) (s1)).g)
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
                s1 = (g)e.get(j1);
                k1 = j1;
                if (i1 < 0)
                {
                    break;
                }
                k1 = j1;
                if (i1 != ((g) (s1)).g)
                {
                    break;
                }
                j1--;
            } while (true);
        }
        if (k1 == e.size() - 1) goto _L1; else goto _L7
_L7:
        ArrayList arraylist = new ArrayList();
        for (i1 = e.size() - 1; i1 > k1; i1--)
        {
            arraylist.add(e.remove(i1));
        }

        j1 = arraylist.size() - 1;
        SparseArray sparsearray2 = new SparseArray();
        SparseArray sparsearray3 = new SparseArray();
        for (i1 = 0; i1 <= j1; i1++)
        {
            ((g)arraylist.get(i1)).a(sparsearray2, sparsearray3);
        }

        s1 = null;
        i1 = 0;
        while (i1 <= j1) 
        {
            g g1 = (g)arraylist.get(i1);
            boolean flag;
            if (i1 == j1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            s1 = g1.a(flag, s1, sparsearray2, sparsearray3);
            i1++;
        }
          goto _L8
    }

    public final void b(Fragment fragment)
    {
label0:
        {
            if (fragment.mDeferStart)
            {
                if (!p)
                {
                    break label0;
                }
                u = true;
            }
            return;
        }
        fragment.mDeferStart = false;
        a(fragment, h, 0, 0, false);
    }

    public final void b(Fragment fragment, int i1, int j1)
    {
        if (!fragment.mHidden)
        {
            fragment.mHidden = true;
            if (fragment.mView != null)
            {
                Animation animation = a(fragment, i1, false, j1);
                if (animation != null)
                {
                    b(fragment.mView, animation);
                    fragment.mView.startAnimation(animation);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible)
            {
                s = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    public final void b(Menu menu)
    {
        if (c != null)
        {
            for (int i1 = 0; i1 < c.size(); i1++)
            {
                Fragment fragment = (Fragment)c.get(i1);
                if (fragment != null)
                {
                    fragment.performOptionsMenuClosed(menu);
                }
            }

        }
    }

    public final boolean b()
    {
        return f();
    }

    public final boolean b(MenuItem menuitem)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (c == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L7:
        flag = flag1;
        if (i1 >= c.size()) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)c.get(i1);
        if (fragment == null || !fragment.performContextItemSelected(menuitem)) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void c(Fragment fragment, int i1, int j1)
    {
        if (fragment.mHidden)
        {
            fragment.mHidden = false;
            if (fragment.mView != null)
            {
                Animation animation = a(fragment, i1, true, j1);
                if (animation != null)
                {
                    b(fragment.mView, animation);
                    fragment.mView.startAnimation(animation);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible)
            {
                s = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    public final boolean c()
    {
        p();
        f();
        return a(((String) (null)), -1, 0);
    }

    public final List d()
    {
        return b;
    }

    public final void d(Fragment fragment, int i1, int j1)
    {
        if (!fragment.mDetached)
        {
            fragment.mDetached = true;
            if (fragment.mAdded)
            {
                if (c != null)
                {
                    c.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible)
                {
                    s = true;
                }
                fragment.mAdded = false;
                a(fragment, 1, i1, j1, false);
            }
        }
    }

    public final void e(Fragment fragment, int i1, int j1)
    {
        if (fragment.mDetached)
        {
            fragment.mDetached = false;
            if (!fragment.mAdded)
            {
                if (c == null)
                {
                    c = new ArrayList();
                }
                if (c.contains(fragment))
                {
                    throw new IllegalStateException((new StringBuilder("Fragment already added: ")).append(fragment).toString());
                }
                c.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible)
                {
                    s = true;
                }
                a(fragment, h, i1, j1, false);
            }
        }
    }

    public final boolean e()
    {
        return t;
    }

    public final boolean f()
    {
        if (p)
        {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        if (Looper.myLooper() != i.i().getLooper())
        {
            throw new IllegalStateException("Must be called from main thread of process");
        }
        boolean flag = false;
_L2:
        this;
        JVM INSTR monitorenter ;
        if (n != null && n.size() != 0)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        this;
        JVM INSTR monitorexit ;
        int k1;
        if (!u)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        int i1 = 0;
        int l1;
        for (k1 = 0; i1 < b.size(); k1 = l1)
        {
            Fragment fragment = (Fragment)b.get(i1);
            l1 = k1;
            if (fragment != null)
            {
                l1 = k1;
                if (fragment.mLoaderManager != null)
                {
                    l1 = k1 | fragment.mLoaderManager.a();
                }
            }
            i1++;
        }

        break; /* Loop/switch isn't completed */
        k1 = n.size();
        if (o == null || o.length < k1)
        {
            o = new Runnable[k1];
        }
        n.toArray(o);
        n.clear();
        i.i().removeCallbacks(x);
        this;
        JVM INSTR monitorexit ;
        p = true;
        for (int j1 = 0; j1 < k1; j1++)
        {
            o[j1].run();
            o[j1] = null;
        }

        break MISSING_BLOCK_LABEL_250;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        p = false;
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
        if (k1 == 0)
        {
            u = false;
            o();
        }
        return flag;
    }

    final Parcelable g()
    {
        FragmentManagerState fragmentmanagerstate;
        fragmentmanagerstate = null;
        f();
        if (m)
        {
            k = true;
        }
        if (b != null && b.size() > 0) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        FragmentState afragmentstate[];
        boolean flag;
        int k1;
        int j2;
        j2 = b.size();
        afragmentstate = new FragmentState[j2];
        k1 = 0;
        flag = false;
_L4:
        Fragment fragment;
        FragmentState fragmentstate;
        if (k1 >= j2)
        {
            continue; /* Loop/switch isn't completed */
        }
        fragment = (Fragment)b.get(k1);
        if (fragment != null)
        {
            if (fragment.mIndex < 0)
            {
                a(new IllegalStateException((new StringBuilder("Failure saving state: active ")).append(fragment).append(" has cleared index: ").append(fragment.mIndex).toString()));
            }
            fragmentstate = new FragmentState(fragment);
            afragmentstate[k1] = fragmentstate;
            if (fragment.mState <= 0 || fragmentstate.j != null)
            {
                break; /* Loop/switch isn't completed */
            }
            fragmentstate.j = e(fragment);
            if (fragment.mTarget == null)
            {
                break MISSING_BLOCK_LABEL_301;
            }
            if (fragment.mTarget.mIndex < 0)
            {
                a(new IllegalStateException((new StringBuilder("Failure saving state: ")).append(fragment).append(" has target not in fragment manager: ").append(fragment.mTarget).toString()));
            }
            if (fragmentstate.j == null)
            {
                fragmentstate.j = new Bundle();
            }
            a(fragmentstate.j, "android:target_state", fragment.mTarget);
            if (fragment.mTargetRequestCode == 0)
            {
                break MISSING_BLOCK_LABEL_301;
            }
            fragmentstate.j.putInt("android:target_req_state", fragment.mTargetRequestCode);
            flag = true;
        }
_L5:
        k1++;
        if (true) goto _L4; else goto _L3
_L3:
        fragmentstate.j = fragment.mSavedFragmentState;
        flag = true;
          goto _L5
        if (!flag) goto _L1; else goto _L6
_L6:
        int ai1[];
label0:
        {
            if (c != null)
            {
                int l1 = c.size();
                if (l1 > 0)
                {
                    int ai2[] = new int[l1];
                    int i1 = 0;
                    do
                    {
                        ai1 = ai2;
                        if (i1 >= l1)
                        {
                            break;
                        }
                        ai2[i1] = ((Fragment)c.get(i1)).mIndex;
                        if (ai2[i1] < 0)
                        {
                            a(new IllegalStateException((new StringBuilder("Failure saving state: active ")).append(c.get(i1)).append(" has cleared index: ").append(ai2[i1]).toString()));
                        }
                        i1++;
                    } while (true);
                    break label0;
                }
            }
            ai1 = null;
        }
        BackStackState abackstackstate[] = fragmentmanagerstate;
        if (e != null)
        {
            int i2 = e.size();
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
                    abackstackstate1[j1] = new BackStackState((g)e.get(j1));
                    j1++;
                } while (true);
            }
        }
        abackstackstate1 = new FragmentManagerState();
        abackstackstate1.a = afragmentstate;
        abackstackstate1.b = ai1;
        abackstackstate1.c = abackstackstate;
        return abackstackstate1;
    }

    public final void h()
    {
        k = false;
        a(1, false);
    }

    public final void i()
    {
        k = false;
        a(2, false);
    }

    public final void j()
    {
        k = false;
        a(4, false);
    }

    public final void k()
    {
        k = false;
        a(5, false);
    }

    public final void l()
    {
        k = true;
        a(3, false);
    }

    public final void m()
    {
        t = true;
        f();
        a(0, false);
        i = null;
        j = null;
        r = null;
    }

    public final void n()
    {
        if (c != null)
        {
            for (int i1 = 0; i1 < c.size(); i1++)
            {
                Fragment fragment = (Fragment)c.get(i1);
                if (fragment != null)
                {
                    fragment.performLowMemory();
                }
            }

        }
    }

    public final View onCreateView(View view, String s1, Context context, AttributeSet attributeset)
    {
        if (!"fragment".equals(s1))
        {
            return null;
        }
        String s2 = attributeset.getAttributeValue(null, "class");
        s1 = context.obtainStyledAttributes(attributeset, android.support.v4.app.ai.a);
        if (s2 == null)
        {
            s2 = s1.getString(0);
        }
        int k1 = s1.getResourceId(1, -1);
        String s3 = s1.getString(2);
        s1.recycle();
        if (!Fragment.isSupportFragmentClass(i.a, s2))
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
            s1 = b(k1);
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
                s1 = b(i1);
            }
        }
        if (s1 == null)
        {
            view = Fragment.instantiate(context, s2);
            view.mFromLayout = true;
            int j1;
            if (k1 != 0)
            {
                j1 = k1;
            } else
            {
                j1 = i1;
            }
            view.mFragmentId = j1;
            view.mContainerId = i1;
            view.mTag = s3;
            view.mInLayout = true;
            view.mFragmentManager = this;
            view.mHost = i;
            view.onInflate(i.a, attributeset, ((Fragment) (view)).mSavedFragmentState);
            a(view, true);
        } else
        {
            if (((Fragment) (s1)).mInLayout)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Duplicate id 0x").append(Integer.toHexString(k1)).append(", tag ").append(s3).append(", or parent id 0x").append(Integer.toHexString(i1)).append(" with another fragment for ").append(s2).toString());
            }
            s1.mInLayout = true;
            if (!((Fragment) (s1)).mRetaining)
            {
                s1.onInflate(i.a, attributeset, ((Fragment) (s1)).mSavedFragmentState);
            }
            view = s1;
        }
        if (h <= 0 && ((Fragment) (view)).mFromLayout)
        {
            a(view, 1, 0, 0, false);
        } else
        {
            c(view);
        }
        if (((Fragment) (view)).mView == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(s2).append(" did not create a view.").toString());
        }
        if (k1 != 0)
        {
            ((Fragment) (view)).mView.setId(k1);
        }
        if (((Fragment) (view)).mView.getTag() == null)
        {
            ((Fragment) (view)).mView.setTag(s3);
        }
        return ((Fragment) (view)).mView;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("FragmentManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        if (r != null)
        {
            android.support.v4.e.a.a(r, stringbuilder);
        } else
        {
            android.support.v4.e.a.a(i, stringbuilder);
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
        m = flag;
        new AccelerateInterpolator(2.5F);
        new AccelerateInterpolator(1.5F);
    }
}
