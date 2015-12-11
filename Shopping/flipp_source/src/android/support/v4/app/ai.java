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
import android.support.v4.c.d;
import android.support.v4.c.e;
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

// Referenced classes of package android.support.v4.app:
//            ah, aj, Fragment, ac, 
//            r, ak, bb, FragmentManagerState, 
//            FragmentState, BackStackState, dc, bi, 
//            ag, al, am, ar

final class ai extends ah
    implements android.view.LayoutInflater.Factory
{

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
    ac o;
    ag p;
    Fragment q;
    boolean r;
    boolean s;
    boolean t;
    String u;
    boolean v;
    Bundle w;
    SparseArray x;
    Runnable y;

    ai()
    {
        n = 0;
        w = null;
        x = null;
        y = new aj(this);
    }

    private Fragment a(Bundle bundle, String s1)
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
        animation = AnimationUtils.loadAnimation(o, fragment.mNextAnim);
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

    private void a(int i1, r r1)
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
            Log.v("FragmentManager", (new StringBuilder("Setting back stack index ")).append(i1).append(" to ").append(r1).toString());
        }
        k.set(i1, r1);
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
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder("Adding available back stack index ")).append(j1).toString());
        }
        l.add(Integer.valueOf(j1));
        j1++;
        if (true) goto _L2; else goto _L3
_L3:
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder("Adding back stack index ")).append(i1).append(" with ").append(r1).toString());
        }
        k.add(r1);
          goto _L4
        r1;
        this;
        JVM INSTR monitorexit ;
        throw r1;
    }

    private void a(RuntimeException runtimeexception)
    {
        Log.e("FragmentManager", runtimeexception.getMessage());
        Log.e("FragmentManager", "Activity state:");
        Object obj = new PrintWriter(new e("FragmentManager"));
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

    private void b(Fragment fragment)
    {
        a(fragment, n, 0, 0, false);
    }

    public static int c(int i1)
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

    private void c(Fragment fragment)
    {
        if (fragment.mInnerView != null)
        {
            if (x == null)
            {
                x = new SparseArray();
            } else
            {
                x.clear();
            }
            fragment.mInnerView.saveHierarchyState(x);
            if (x.size() > 0)
            {
                fragment.mSavedViewState = x;
                x = null;
                return;
            }
        }
    }

    private Fragment d(int i1)
    {
        if (g == null) goto _L2; else goto _L1
_L1:
        int j1 = g.size() - 1;
_L11:
        if (j1 < 0) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)g.get(j1);
        if (fragment == null || fragment.mFragmentId != i1) goto _L5; else goto _L4
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
        if (fragment1.mFragmentId == i1) goto _L4; else goto _L8
_L8:
        j1--;
          goto _L9
_L7:
        return null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final int a(r r1)
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        if (l != null && l.size() > 0)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        if (k == null)
        {
            k = new ArrayList();
        }
        i1 = k.size();
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder("Setting back stack index ")).append(i1).append(" to ").append(r1).toString());
        }
        k.add(r1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        i1 = ((Integer)l.remove(l.size() - 1)).intValue();
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder("Adding back stack index ")).append(i1).append(" with ").append(r1).toString());
        }
        k.set(i1, r1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        r1;
        this;
        JVM INSTR monitorexit ;
        throw r1;
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
        if (fragment == null || !s1.equals(fragment.mTag)) goto _L5; else goto _L4
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
        if (s1.equals(fragment1.mTag)) goto _L4; else goto _L8
_L8:
        i1--;
          goto _L9
_L7:
        return null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final ar a()
    {
        return new r(this);
    }

    public final void a(int i1)
    {
        if (i1 < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad id: ")).append(i1).toString());
        } else
        {
            a(((Runnable) (new ak(this, i1))), false);
            return;
        }
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
                    if (fragment.mLoaderManager != null)
                    {
                        flag1 |= fragment.mLoaderManager.a();
                    }
                }

                if (!flag1)
                {
                    c();
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
                if (fragment != null)
                {
                    fragment.performConfigurationChanged(configuration);
                }
            }

        }
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
                        Log.v("FragmentManager", (new StringBuilder("restoreAllState: re-attaching retained ")).append(fragment).toString());
                    }
                    FragmentState fragmentstate1 = ((FragmentManagerState) (parcelable)).a[fragment.mIndex];
                    fragmentstate1.k = fragment;
                    fragment.mSavedViewState = null;
                    fragment.mBackStackNesting = 0;
                    fragment.mInLayout = false;
                    fragment.mAdded = false;
                    fragment.mTarget = null;
                    if (fragmentstate1.j != null)
                    {
                        fragmentstate1.j.setClassLoader(o.getClassLoader());
                        fragment.mSavedViewState = fragmentstate1.j.getSparseParcelableArray("android:view_state");
                        fragment.mSavedFragmentState = fragmentstate1.j;
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
                            fragmentstate.i.setClassLoader(((ac) (obj)).getClassLoader());
                        }
                        fragmentstate.k = Fragment.instantiate(((Context) (obj)), fragmentstate.a, fragmentstate.i);
                        if (fragmentstate.j != null)
                        {
                            fragmentstate.j.setClassLoader(((ac) (obj)).getClassLoader());
                            fragmentstate.k.mSavedFragmentState = fragmentstate.j;
                        }
                        fragmentstate.k.setIndex(fragmentstate.b, fragment2);
                        fragmentstate.k.mFromLayout = fragmentstate.c;
                        fragmentstate.k.mRestored = true;
                        fragmentstate.k.mFragmentId = fragmentstate.d;
                        fragmentstate.k.mContainerId = fragmentstate.e;
                        fragmentstate.k.mTag = fragmentstate.f;
                        fragmentstate.k.mRetainInstance = fragmentstate.g;
                        fragmentstate.k.mDetached = fragmentstate.h;
                        fragmentstate.k.mFragmentManager = ((ac) (obj)).mFragments;
                        if (a)
                        {
                            Log.v("FragmentManager", (new StringBuilder("Instantiated fragment ")).append(fragmentstate.k).toString());
                        }
                    }
                    obj = fragmentstate.k;
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder("restoreAllState: active #")).append(j1).append(": ").append(obj).toString());
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
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder("restoreAllState: avail #")).append(j1).toString());
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
                    if (fragment1.mTargetIndex >= 0)
                    {
                        if (fragment1.mTargetIndex < f.size())
                        {
                            fragment1.mTarget = (Fragment)f.get(fragment1.mTargetIndex);
                        } else
                        {
                            Log.w("FragmentManager", (new StringBuilder("Re-attaching retained fragment ")).append(fragment1).append(" target no longer exists: ").append(fragment1.mTargetIndex).toString());
                            fragment1.mTarget = null;
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
                    arraylist.mAdded = true;
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder("restoreAllState: added #")).append(l1).append(": ").append(arraylist).toString());
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
                        Log.v("FragmentManager", (new StringBuilder("restoreAllState: back stack #")).append(i2).append(" (index ").append(((r) (arraylist)).o).append("): ").append(arraylist).toString());
                        arraylist.a("  ", new PrintWriter(new e("FragmentManager")), false);
                    }
                    i.add(arraylist);
                    if (((r) (arraylist)).o >= 0)
                    {
                        a(((r) (arraylist)).o, ((r) (arraylist)));
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

    public final void a(Fragment fragment)
    {
label0:
        {
            if (fragment.mDeferStart)
            {
                if (!e)
                {
                    break label0;
                }
                v = true;
            }
            return;
        }
        fragment.mDeferStart = false;
        a(fragment, n, 0, 0, false);
    }

    public final void a(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder("remove: ")).append(fragment).append(" nesting=").append(fragment.mBackStackNesting).toString());
        }
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
            if (g != null)
            {
                g.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible)
            {
                r = true;
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
    //                   1 565
    //                   2 877
    //                   3 877
    //                   4 924;
           goto _L3 _L4 _L5 _L6 _L6 _L7
_L3:
        i2 = i1;
_L16:
        fragment.mState = i2;
        return;
_L4:
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder("moveto CREATED: ")).append(fragment).toString());
        }
        k2 = i1;
        if (fragment.mSavedFragmentState != null)
        {
            fragment.mSavedFragmentState.setClassLoader(o.getClassLoader());
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
        fragment.mActivity = o;
        fragment.mParentFragment = q;
        ai ai1;
        if (q != null)
        {
            ai1 = q.mChildFragmentManager;
        } else
        {
            ai1 = o.mFragments;
        }
        fragment.mFragmentManager = ai1;
        fragment.mCalled = false;
        fragment.onAttach(o);
        if (!fragment.mCalled)
        {
            throw new dc((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onAttach()").toString());
        }
        if (fragment.mParentFragment == null)
        {
            o.onAttachFragment(fragment);
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
            Object obj1;
            if (fragment.mView != null)
            {
                fragment.mInnerView = fragment.mView;
                fragment.mView = bi.a(fragment.mView);
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
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder("moveto ACTIVITY_CREATED: ")).append(fragment).toString());
            }
            if (!fragment.mFromLayout)
            {
                Object obj;
                if (fragment.mContainerId != 0)
                {
                    obj1 = (ViewGroup)p.a(fragment.mContainerId);
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
                    fragment.mView = bi.a(fragment.mView);
                    if (obj != null)
                    {
                        obj1 = a(fragment, j1, true, k1);
                        if (obj1 != null)
                        {
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
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder("moveto STARTED: ")).append(fragment).toString());
            }
            fragment.performStart();
            k2 = l2;
        }
_L7:
        i2 = k2;
        if (k2 > 4)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder("moveto RESUMED: ")).append(fragment).toString());
            }
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
        JVM INSTR tableswitch 1 5: default 1060
    //                   1 1066
    //                   2 1240
    //                   3 1202
    //                   4 1164
    //                   5 1121;
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
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder("movefrom RESUMED: ")).append(fragment).toString());
            }
            fragment.performPause();
            fragment.mResumed = false;
        }
_L12:
        if (i1 < 4)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder("movefrom STARTED: ")).append(fragment).toString());
            }
            fragment.performStop();
        }
_L11:
        if (i1 < 3)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder("movefrom STOPPED: ")).append(fragment).toString());
            }
            fragment.performReallyStop();
        }
_L10:
        if (i1 < 2)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder("movefrom ACTIVITY_CREATED: ")).append(fragment).toString());
            }
            if (fragment.mView != null && !o.isFinishing() && fragment.mSavedViewState == null)
            {
                c(fragment);
            }
            fragment.performDestroyView();
            if (fragment.mView != null && fragment.mContainer != null)
            {
                if (n > 0 && !t)
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
                    ((Animation) (obj)).setAnimationListener(new al(this, fragment));
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
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder("movefrom CREATED: ")).append(fragment).toString());
        }
        if (!fragment.mRetaining)
        {
            fragment.performDestroy();
        }
        fragment.mCalled = false;
        fragment.onDetach();
        if (!fragment.mCalled)
        {
            throw new dc((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onDetach()").toString());
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
                if (a)
                {
                    Log.v("FragmentManager", (new StringBuilder("Freeing fragment index ")).append(fragment).toString());
                }
                f.set(fragment.mIndex, null);
                if (h == null)
                {
                    h = new ArrayList();
                }
                h.add(Integer.valueOf(fragment.mIndex));
                o.invalidateSupportFragment(fragment.mWho);
                fragment.initState();
                i2 = i1;
            }
        } else
        {
            fragment.mActivity = null;
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
        if (g == null)
        {
            g = new ArrayList();
        }
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder("add: ")).append(fragment).toString());
        }
        if (fragment.mIndex < 0)
        {
            if (h == null || h.size() <= 0)
            {
                if (f == null)
                {
                    f = new ArrayList();
                }
                fragment.setIndex(f.size(), q);
                f.add(fragment);
            } else
            {
                fragment.setIndex(((Integer)h.remove(h.size() - 1)).intValue(), q);
                f.set(fragment.mIndex, fragment);
            }
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder("Allocated fragment index ")).append(fragment).toString());
            }
        }
        if (!fragment.mDetached)
        {
            if (g.contains(fragment))
            {
                throw new IllegalStateException((new StringBuilder("Fragment already added: ")).append(fragment).toString());
            }
            g.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mHasMenu && fragment.mMenuVisible)
            {
                r = true;
            }
            if (flag)
            {
                b(fragment);
            }
        }
    }

    public final void a(ac ac1, ag ag1, Fragment fragment)
    {
        if (o != null)
        {
            throw new IllegalStateException("Already attached");
        } else
        {
            o = ac1;
            p = ag1;
            q = fragment;
            return;
        }
    }

    public final void a(Runnable runnable, boolean flag)
    {
        if (!flag)
        {
            d();
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
                    filedescriptor = (r)i.get(l1);
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
        filedescriptor = (r)k.get(i2);
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
        r r1 = (r)i.remove(i1);
        SparseArray sparsearray = new SparseArray();
        SparseArray sparsearray1 = new SparseArray();
        r1.a(sparsearray, sparsearray1);
        r1.a(true, null, sparsearray, sparsearray1);
_L8:
        f();
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
            r r2 = (r)i.get(l1);
            if (i1 >= 0 && i1 == r2.o)
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
                r r3 = (r)i.get(j1);
                k1 = j1;
                if (i1 < 0)
                {
                    break;
                }
                k1 = j1;
                if (i1 != r3.o)
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
            ((r)arraylist.get(i1)).a(sparsearray2, sparsearray3);
        }

        w w1 = null;
        i1 = 0;
        while (i1 <= j1) 
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder("Popping back stack state: ")).append(arraylist.get(i1)).toString());
            }
            r r4 = (r)arraylist.get(i1);
            boolean flag;
            if (i1 == j1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w1 = r4.a(flag, w1, sparsearray2, sparsearray3);
            i1++;
        }
          goto _L8
    }

    public final boolean a(Menu menu)
    {
        boolean flag1;
        if (g != null)
        {
            int i1 = 0;
            boolean flag = false;
            do
            {
                flag1 = flag;
                if (i1 >= g.size())
                {
                    break;
                }
                Fragment fragment = (Fragment)g.get(i1);
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
        if (g != null)
        {
            int i1 = 0;
            boolean flag1 = false;
            do
            {
                arraylist1 = arraylist;
                flag2 = flag1;
                if (i1 >= g.size())
                {
                    break;
                }
                Fragment fragment = (Fragment)g.get(i1);
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
        if (j != null)
        {
            for (int j1 = ((flag) ? 1 : 0); j1 < j.size(); j1++)
            {
                menu = (Fragment)j.get(j1);
                if (arraylist1 == null || !arraylist1.contains(menu))
                {
                    menu.onDestroyOptionsMenu();
                }
            }

        }
        j = arraylist1;
        return flag2;
    }

    public final boolean a(MenuItem menuitem)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (g == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L7:
        flag = flag1;
        if (i1 >= g.size()) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)g.get(i1);
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

    final void b(int i1)
    {
        a(i1, 0, 0, false);
    }

    public final void b(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder("hide: ")).append(fragment).toString());
        }
        if (!fragment.mHidden)
        {
            fragment.mHidden = true;
            if (fragment.mView != null)
            {
                Animation animation = a(fragment, i1, false, j1);
                if (animation != null)
                {
                    fragment.mView.startAnimation(animation);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible)
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
                if (fragment != null)
                {
                    fragment.performOptionsMenuClosed(menu);
                }
            }

        }
    }

    public final boolean b()
    {
        return e();
    }

    public final boolean b(MenuItem menuitem)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (g == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L7:
        flag = flag1;
        if (i1 >= g.size()) goto _L2; else goto _L3
_L3:
        Fragment fragment = (Fragment)g.get(i1);
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

    final void c()
    {
        if (f != null)
        {
            int i1 = 0;
            while (i1 < f.size()) 
            {
                Fragment fragment = (Fragment)f.get(i1);
                if (fragment != null)
                {
                    a(fragment);
                }
                i1++;
            }
        }
    }

    public final void c(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder("show: ")).append(fragment).toString());
        }
        if (fragment.mHidden)
        {
            fragment.mHidden = false;
            if (fragment.mView != null)
            {
                Animation animation = a(fragment, i1, true, j1);
                if (animation != null)
                {
                    fragment.mView.startAnimation(animation);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible)
            {
                r = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    final void d()
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

    public final void d(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder("detach: ")).append(fragment).toString());
        }
        if (!fragment.mDetached)
        {
            fragment.mDetached = true;
            if (fragment.mAdded)
            {
                if (g != null)
                {
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder("remove from detach: ")).append(fragment).toString());
                    }
                    g.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible)
                {
                    r = true;
                }
                fragment.mAdded = false;
                a(fragment, 1, i1, j1, false);
            }
        }
    }

    public final void e(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder("attach: ")).append(fragment).toString());
        }
        if (fragment.mDetached)
        {
            fragment.mDetached = false;
            if (!fragment.mAdded)
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
                    Log.v("FragmentManager", (new StringBuilder("add from attach: ")).append(fragment).toString());
                }
                g.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible)
                {
                    r = true;
                }
                a(fragment, n, i1, j1, false);
            }
        }
    }

    public final boolean e()
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
                if (fragment.mLoaderManager != null)
                {
                    l1 = k1 | fragment.mLoaderManager.a();
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
            c();
        }
        return flag;
    }

    final void f()
    {
        if (m != null)
        {
            for (int i1 = 0; i1 < m.size(); i1++)
            {
                m.get(i1);
            }

        }
    }

    final Parcelable g()
    {
        BackStackState abackstackstate[];
        abackstackstate = null;
        e();
        if (b)
        {
            s = true;
        }
        if (f != null && f.size() > 0) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        int k1 = f.size();
        FragmentState afragmentstate[] = new FragmentState[k1];
        int j1 = 0;
        boolean flag = false;
        while (j1 < k1) 
        {
            Fragment fragment = (Fragment)f.get(j1);
            if (fragment == null)
            {
                continue;
            }
            if (fragment.mIndex < 0)
            {
                a(new IllegalStateException((new StringBuilder("Failure saving state: active ")).append(fragment).append(" has cleared index: ").append(fragment.mIndex).toString()));
            }
            FragmentState fragmentstate = new FragmentState(fragment);
            afragmentstate[j1] = fragmentstate;
            if (fragment.mState > 0 && fragmentstate.j == null)
            {
                if (w == null)
                {
                    w = new Bundle();
                }
                fragment.performSaveInstanceState(w);
                Bundle bundle;
                int ai1[];
                Object obj;
                FragmentManagerState fragmentmanagerstate;
                int i1;
                if (!w.isEmpty())
                {
                    obj = w;
                    w = null;
                } else
                {
                    obj = null;
                }
                if (fragment.mView != null)
                {
                    c(fragment);
                }
                bundle = ((Bundle) (obj));
                if (fragment.mSavedViewState != null)
                {
                    bundle = ((Bundle) (obj));
                    if (obj == null)
                    {
                        bundle = new Bundle();
                    }
                    bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
                }
                obj = bundle;
                if (!fragment.mUserVisibleHint)
                {
                    obj = bundle;
                    if (bundle == null)
                    {
                        obj = new Bundle();
                    }
                    ((Bundle) (obj)).putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
                }
                fragmentstate.j = ((Bundle) (obj));
                if (fragment.mTarget != null)
                {
                    if (fragment.mTarget.mIndex < 0)
                    {
                        a(new IllegalStateException((new StringBuilder("Failure saving state: ")).append(fragment).append(" has target not in fragment manager: ").append(fragment.mTarget).toString()));
                    }
                    if (fragmentstate.j == null)
                    {
                        fragmentstate.j = new Bundle();
                    }
                    Bundle bundle1 = fragmentstate.j;
                    obj = fragment.mTarget;
                    if (((Fragment) (obj)).mIndex < 0)
                    {
                        a(new IllegalStateException((new StringBuilder("Fragment ")).append(obj).append(" is not currently in the FragmentManager").toString()));
                    }
                    bundle1.putInt("android:target_state", ((Fragment) (obj)).mIndex);
                    if (fragment.mTargetRequestCode != 0)
                    {
                        fragmentstate.j.putInt("android:target_req_state", fragment.mTargetRequestCode);
                    }
                }
            } else
            {
                fragmentstate.j = fragment.mSavedFragmentState;
            }
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder("Saved state of ")).append(fragment).append(": ").append(fragmentstate.j).toString());
            }
            flag = true;
            j1++;
        }
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (a)
        {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
        if (true) goto _L1; else goto _L3
_L3:
label0:
        {
            if (g != null)
            {
                j1 = g.size();
                if (j1 > 0)
                {
                    obj = new int[j1];
                    i1 = 0;
                    do
                    {
                        ai1 = ((int []) (obj));
                        if (i1 >= j1)
                        {
                            break;
                        }
                        obj[i1] = ((Fragment)g.get(i1)).mIndex;
                        if (obj[i1] < 0)
                        {
                            a(new IllegalStateException((new StringBuilder("Failure saving state: active ")).append(g.get(i1)).append(" has cleared index: ").append(obj[i1]).toString()));
                        }
                        if (a)
                        {
                            Log.v("FragmentManager", (new StringBuilder("saveAllState: adding fragment #")).append(i1).append(": ").append(g.get(i1)).toString());
                        }
                        i1++;
                    } while (true);
                    break label0;
                }
            }
            ai1 = null;
        }
        obj = abackstackstate;
        if (i != null)
        {
            j1 = i.size();
            obj = abackstackstate;
            if (j1 > 0)
            {
                abackstackstate = new BackStackState[j1];
                i1 = 0;
                do
                {
                    obj = abackstackstate;
                    if (i1 >= j1)
                    {
                        break;
                    }
                    abackstackstate[i1] = new BackStackState((r)i.get(i1));
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder("saveAllState: adding back stack #")).append(i1).append(": ").append(i.get(i1)).toString());
                    }
                    i1++;
                } while (true);
            }
        }
        fragmentmanagerstate = new FragmentManagerState();
        fragmentmanagerstate.a = afragmentstate;
        fragmentmanagerstate.b = ai1;
        fragmentmanagerstate.c = ((BackStackState []) (obj));
        return fragmentmanagerstate;
    }

    public final void h()
    {
        s = false;
        b(1);
    }

    public final void i()
    {
        s = false;
        b(2);
    }

    public final void j()
    {
        s = false;
        b(4);
    }

    public final void k()
    {
        s = false;
        b(5);
    }

    public final void l()
    {
        s = true;
        b(3);
    }

    public final void m()
    {
        t = true;
        e();
        b(0);
        o = null;
        p = null;
        q = null;
    }

    public final void n()
    {
        if (g != null)
        {
            for (int i1 = 0; i1 < g.size(); i1++)
            {
                Fragment fragment = (Fragment)g.get(i1);
                if (fragment != null)
                {
                    fragment.performLowMemory();
                }
            }

        }
    }

    public final View onCreateView(String s1, Context context, AttributeSet attributeset)
    {
        if (!"fragment".equals(s1))
        {
            return null;
        }
        String s2 = attributeset.getAttributeValue(null, "class");
        s1 = context.obtainStyledAttributes(attributeset, am.a);
        if (s2 == null)
        {
            s2 = s1.getString(0);
        }
        int j1 = s1.getResourceId(1, -1);
        String s3 = s1.getString(2);
        s1.recycle();
        if (!Fragment.isSupportFragmentClass(o, s2))
        {
            return null;
        }
        Object obj;
        if (j1 != -1)
        {
            obj = d(j1);
        } else
        {
            obj = null;
        }
        s1 = ((String) (obj));
        if (obj == null)
        {
            s1 = ((String) (obj));
            if (s3 != null)
            {
                s1 = a(s3);
            }
        }
        obj = s1;
        if (s1 == null)
        {
            obj = d(0);
        }
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder("onCreateView: id=0x")).append(Integer.toHexString(j1)).append(" fname=").append(s2).append(" existing=").append(obj).toString());
        }
        if (obj == null)
        {
            s1 = Fragment.instantiate(context, s2);
            s1.mFromLayout = true;
            int i1;
            if (j1 != 0)
            {
                i1 = j1;
            } else
            {
                i1 = 0;
            }
            s1.mFragmentId = i1;
            s1.mContainerId = 0;
            s1.mTag = s3;
            s1.mInLayout = true;
            s1.mFragmentManager = this;
            s1.onInflate(o, attributeset, ((Fragment) (s1)).mSavedFragmentState);
            a(s1, true);
        } else
        {
            if (((Fragment) (obj)).mInLayout)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Duplicate id 0x").append(Integer.toHexString(j1)).append(", tag ").append(s3).append(", or parent id 0x").append(Integer.toHexString(0)).append(" with another fragment for ").append(s2).toString());
            }
            obj.mInLayout = true;
            if (!((Fragment) (obj)).mRetaining)
            {
                ((Fragment) (obj)).onInflate(o, attributeset, ((Fragment) (obj)).mSavedFragmentState);
            }
            s1 = ((String) (obj));
        }
        if (n <= 0 && ((Fragment) (s1)).mFromLayout)
        {
            a(s1, 1, 0, 0, false);
        } else
        {
            b(s1);
        }
        if (((Fragment) (s1)).mView == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(s2).append(" did not create a view.").toString());
        }
        if (j1 != 0)
        {
            ((Fragment) (s1)).mView.setId(j1);
        }
        if (((Fragment) (s1)).mView.getTag() == null)
        {
            ((Fragment) (s1)).mView.setTag(s3);
        }
        return ((Fragment) (s1)).mView;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("FragmentManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        if (q != null)
        {
            android.support.v4.c.d.a(q, stringbuilder);
        } else
        {
            android.support.v4.c.d.a(o, stringbuilder);
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
