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
import android.support.v4.view.ai;
import android.support.v4.view.n;
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
//            h, f, Fragment, e, 
//            o, FragmentManagerState, FragmentState, BackStackState, 
//            ai, g, r, l

final class i extends h
    implements n
{
    static class a
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
    f o;
    g p;
    Fragment q;
    boolean r;
    boolean s;
    boolean t;
    String u;
    boolean v;
    Bundle w;
    SparseArray x;
    Runnable y;

    i()
    {
        n = 0;
        w = null;
        x = null;
        y = new Runnable() {

            final i a;

            public void run()
            {
                a.h();
            }

            
            {
                a = i.this;
                super();
            }
        };
    }

    static Animation a(Context context, float f1, float f2)
    {
        context = new AlphaAnimation(f1, f2);
        context.setInterpolator(A);
        context.setDuration(220L);
        return context;
    }

    static Animation a(Context context, float f1, float f2, float f3, float f4)
    {
        context = new AnimationSet(false);
        Object obj = new ScaleAnimation(f1, f2, f1, f2, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation) (obj)).setInterpolator(z);
        ((ScaleAnimation) (obj)).setDuration(220L);
        context.addAnimation(((Animation) (obj)));
        obj = new AlphaAnimation(f3, f4);
        ((AlphaAnimation) (obj)).setInterpolator(A);
        ((AlphaAnimation) (obj)).setDuration(220L);
        context.addAnimation(((Animation) (obj)));
        return context;
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

    public static int b(int i1, boolean flag)
    {
        switch (i1)
        {
        default:
            return -1;

        case 4097: 
            return !flag ? 2 : 1;

        case 8194: 
            return !flag ? 4 : 3;

        case 4099: 
            break;
        }
        return !flag ? 6 : 5;
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

    private void x()
    {
        if (s)
        {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (u != null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Can not perform this action inside of ").append(u).toString());
        } else
        {
            return;
        }
    }

    public int a(e e1)
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        if (l != null && l.size() > 0)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        if (k == null)
        {
            k = new ArrayList();
        }
        i1 = k.size();
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Setting back stack index ").append(i1).append(" to ").append(e1).toString());
        }
        k.add(e1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        i1 = ((Integer)l.remove(l.size() - 1)).intValue();
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Adding back stack index ").append(i1).append(" with ").append(e1).toString());
        }
        k.set(i1, e1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        e1;
        this;
        JVM INSTR monitorexit ;
        throw e1;
    }

    public Fragment.SavedState a(Fragment fragment)
    {
        Object obj = null;
        if (fragment.mIndex < 0)
        {
            a(((RuntimeException) (new IllegalStateException((new StringBuilder()).append("Fragment ").append(fragment).append(" is not currently in the FragmentManager").toString()))));
        }
        Fragment.SavedState savedstate = obj;
        if (fragment.mState > 0)
        {
            fragment = g(fragment);
            savedstate = obj;
            if (fragment != null)
            {
                savedstate = new Fragment.SavedState(fragment);
            }
        }
        return savedstate;
    }

    public Fragment a(int i1)
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

    public Fragment a(Bundle bundle, String s1)
    {
        int i1 = bundle.getInt(s1, -1);
        if (i1 == -1)
        {
            bundle = null;
        } else
        {
            if (i1 >= f.size())
            {
                a(((RuntimeException) (new IllegalStateException((new StringBuilder()).append("Fragment no longer exists for key ").append(s1).append(": index ").append(i1).toString()))));
            }
            Fragment fragment = (Fragment)f.get(i1);
            bundle = fragment;
            if (fragment == null)
            {
                a(((RuntimeException) (new IllegalStateException((new StringBuilder()).append("Fragment no longer exists for key ").append(s1).append(": index ").append(i1).toString()))));
                return fragment;
            }
        }
        return bundle;
    }

    public Fragment a(String s1)
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

    public l a()
    {
        return new e(this);
    }

    public View a(View view, String s1, Context context, AttributeSet attributeset)
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
        if (!Fragment.isSupportFragmentClass(o, s2))
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
            Log.v("FragmentManager", (new StringBuilder()).append("onCreateView: id=0x").append(Integer.toHexString(k1)).append(" fname=").append(s2).append(" existing=").append(s1).toString());
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
            view.onInflate(o, attributeset, ((Fragment) (view)).mSavedFragmentState);
            a(((Fragment) (view)), true);
        } else
        {
            if (((Fragment) (s1)).mInLayout)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Duplicate id 0x").append(Integer.toHexString(k1)).append(", tag ").append(s3).append(", or parent id 0x").append(Integer.toHexString(i1)).append(" with another fragment for ").append(s2).toString());
            }
            s1.mInLayout = true;
            if (!((Fragment) (s1)).mRetaining)
            {
                s1.onInflate(o, attributeset, ((Fragment) (s1)).mSavedFragmentState);
            }
            view = s1;
        }
        if (n < 1 && ((Fragment) (view)).mFromLayout)
        {
            a(((Fragment) (view)), 1, 0, 0, false);
        } else
        {
            c(view);
        }
        if (((Fragment) (view)).mView == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(s2).append(" did not create a view.").toString());
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

    Animation a(Fragment fragment, int i1, boolean flag, int j1)
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
        if (i1 == 0)
        {
            return null;
        }
        i1 = b(i1, flag);
        if (i1 < 0)
        {
            return null;
        }
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
            return a(((Context) (o)), 1.125F, 1.0F, 0.0F, 1.0F);

        case 2: // '\002'
            return a(((Context) (o)), 1.0F, 0.975F, 1.0F, 0.0F);

        case 3: // '\003'
            return a(((Context) (o)), 0.975F, 1.0F, 0.0F, 1.0F);

        case 4: // '\004'
            return a(((Context) (o)), 1.0F, 1.075F, 1.0F, 0.0F);

        case 5: // '\005'
            return a(((Context) (o)), 0.0F, 1.0F);

        case 6: // '\006'
            return a(((Context) (o)), 1.0F, 0.0F);
        }
    }

    public void a(int i1, int j1)
    {
        if (i1 < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Bad id: ").append(i1).toString());
        } else
        {
            a(new Runnable(i1, j1) {

                final int a;
                final int b;
                final i c;

                public void run()
                {
                    c.a(c.o.mHandler, null, a, b);
                }

            
            {
                c = i.this;
                a = j1;
                b = k1;
                super();
            }
            }, false);
            return;
        }
    }

    void a(int i1, int j1, int k1, boolean flag)
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
                    g();
                }
                if (r && o != null && n == 5)
                {
                    o.d();
                    r = false;
                    return;
                }
            }
        }
    }

    public void a(int i1, e e1)
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
            Log.v("FragmentManager", (new StringBuilder()).append("Setting back stack index ").append(i1).append(" to ").append(e1).toString());
        }
        k.set(i1, e1);
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
            Log.v("FragmentManager", (new StringBuilder()).append("Adding available back stack index ").append(j1).toString());
        }
        l.add(Integer.valueOf(j1));
        j1++;
        if (true) goto _L2; else goto _L3
_L3:
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Adding back stack index ").append(i1).append(" with ").append(e1).toString());
        }
        k.add(e1);
          goto _L4
        e1;
        this;
        JVM INSTR monitorexit ;
        throw e1;
    }

    void a(int i1, boolean flag)
    {
        a(i1, 0, 0, flag);
    }

    public void a(Configuration configuration)
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

    public void a(Bundle bundle, String s1, Fragment fragment)
    {
        if (fragment.mIndex < 0)
        {
            a(((RuntimeException) (new IllegalStateException((new StringBuilder()).append("Fragment ").append(fragment).append(" is not currently in the FragmentManager").toString()))));
        }
        bundle.putInt(s1, fragment.mIndex);
    }

    void a(Parcelable parcelable, ArrayList arraylist)
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
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: re-attaching retained ").append(fragment).toString());
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
                    Fragment fragment2 = fragmentstate.a(o, q);
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: active #").append(j1).append(": ").append(fragment2).toString());
                    }
                    f.add(fragment2);
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
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: avail #").append(j1).toString());
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
                            Log.w("FragmentManager", (new StringBuilder()).append("Re-attaching retained fragment ").append(fragment1).append(" target no longer exists: ").append(fragment1.mTargetIndex).toString());
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
                        a(((RuntimeException) (new IllegalStateException((new StringBuilder()).append("No instantiated fragment for index #").append(((FragmentManagerState) (parcelable)).b[l1]).toString()))));
                    }
                    arraylist.mAdded = true;
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: added #").append(l1).append(": ").append(arraylist).toString());
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
                        Log.v("FragmentManager", (new StringBuilder()).append("restoreAllState: back stack #").append(i2).append(" (index ").append(((e) (arraylist)).p).append("): ").append(arraylist).toString());
                        arraylist.a("  ", new PrintWriter(new d("FragmentManager")), false);
                    }
                    i.add(arraylist);
                    if (((e) (arraylist)).p >= 0)
                    {
                        a(((e) (arraylist)).p, ((e) (arraylist)));
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

    public void a(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("remove: ").append(fragment).append(" nesting=").append(fragment.mBackStackNesting).toString());
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

    void a(Fragment fragment, int i1, int j1, int k1, boolean flag)
    {
        int i2;
label0:
        {
            if (fragment.mAdded)
            {
                i2 = i1;
                if (!fragment.mDetached)
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
        if (fragment.mRemoving)
        {
            k2 = i2;
            if (i2 > fragment.mState)
            {
                k2 = fragment.mState;
            }
        }
        i1 = k2;
        if (fragment.mDeferStart)
        {
            i1 = k2;
            if (fragment.mState < 4)
            {
                i1 = k2;
                if (k2 > 3)
                {
                    i1 = 3;
                }
            }
        }
        if (fragment.mState >= i1) goto _L2; else goto _L1
_L1:
        int j2;
        int l2;
        int i3;
        if (fragment.mFromLayout && !fragment.mInLayout)
        {
            return;
        }
        if (fragment.mAnimatingAway != null)
        {
            fragment.mAnimatingAway = null;
            a(fragment, fragment.mStateAfterAnimating, 0, 0, true);
        }
        j2 = i1;
        i3 = i1;
        l2 = i1;
        fragment.mState;
        JVM INSTR tableswitch 0 4: default 184
    //                   0 194
    //                   1 576
    //                   2 899
    //                   3 899
    //                   4 949;
           goto _L3 _L4 _L5 _L6 _L6 _L7
_L3:
        j2 = i1;
_L16:
        fragment.mState = j2;
        return;
_L4:
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("moveto CREATED: ").append(fragment).toString());
        }
        l2 = i1;
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
            l2 = i1;
            if (!fragment.mUserVisibleHint)
            {
                fragment.mDeferStart = true;
                l2 = i1;
                if (i1 > 3)
                {
                    l2 = 3;
                }
            }
        }
        fragment.mActivity = o;
        fragment.mParentFragment = q;
        i l1;
        if (q != null)
        {
            l1 = q.mChildFragmentManager;
        } else
        {
            l1 = o.mFragments;
        }
        fragment.mFragmentManager = l1;
        fragment.mCalled = false;
        fragment.onAttach(o);
        if (!fragment.mCalled)
        {
            throw new android.support.v4.app.ai((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onAttach()").toString());
        }
        if (fragment.mParentFragment == null)
        {
            o.a(fragment);
        }
        if (!fragment.mRetaining)
        {
            fragment.performCreate(fragment.mSavedFragmentState);
        }
        fragment.mRetaining = false;
        j2 = l2;
        if (fragment.mFromLayout)
        {
            fragment.mView = fragment.performCreateView(fragment.getLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            if (fragment.mView != null)
            {
                fragment.mInnerView = fragment.mView;
                Object obj1;
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    ai.a(fragment.mView, false);
                } else
                {
                    fragment.mView = android.support.v4.app.r.a(fragment.mView);
                }
                if (fragment.mHidden)
                {
                    fragment.mView.setVisibility(8);
                }
                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                j2 = l2;
            } else
            {
                fragment.mInnerView = null;
                j2 = l2;
            }
        }
_L5:
        i3 = j2;
        if (j2 > 1)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("moveto ACTIVITY_CREATED: ").append(fragment).toString());
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
                            a(((RuntimeException) (new IllegalArgumentException((new StringBuilder()).append("No view found for id 0x").append(Integer.toHexString(fragment.mContainerId)).append(" (").append(fragment.getResources().getResourceName(fragment.mContainerId)).append(") for fragment ").append(fragment).toString()))));
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
                        ai.a(fragment.mView, false);
                    } else
                    {
                        fragment.mView = android.support.v4.app.r.a(fragment.mView);
                    }
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
            i3 = j2;
        }
_L6:
        l2 = i3;
        if (i3 > 3)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("moveto STARTED: ").append(fragment).toString());
            }
            fragment.performStart();
            l2 = i3;
        }
_L7:
        j2 = l2;
        if (l2 > 4)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("moveto RESUMED: ").append(fragment).toString());
            }
            fragment.mResumed = true;
            fragment.performResume();
            fragment.mSavedFragmentState = null;
            fragment.mSavedViewState = null;
            j2 = l2;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        j2 = i1;
        if (fragment.mState <= i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        fragment.mState;
        JVM INSTR tableswitch 1 5: default 1116
    //                   1 1122
    //                   2 1306
    //                   3 1265
    //                   4 1224
    //                   5 1178;
           goto _L8 _L9 _L10 _L11 _L12 _L13
_L8:
        j2 = i1;
        break; /* Loop/switch isn't completed */
_L9:
        j2 = i1;
        if (i1 >= 1)
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
            j2 = 1;
            break; /* Loop/switch isn't completed */
        }
          goto _L14
_L13:
        if (i1 < 5)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("movefrom RESUMED: ").append(fragment).toString());
            }
            fragment.performPause();
            fragment.mResumed = false;
        }
_L12:
        if (i1 < 4)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("movefrom STARTED: ").append(fragment).toString());
            }
            fragment.performStop();
        }
_L11:
        if (i1 < 3)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("movefrom STOPPED: ").append(fragment).toString());
            }
            fragment.performReallyStop();
        }
_L10:
        if (i1 < 2)
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("movefrom ACTIVITY_CREATED: ").append(fragment).toString());
            }
            if (fragment.mView != null && !o.isFinishing() && fragment.mSavedViewState == null)
            {
                f(fragment);
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
                    ((Animation) (obj)).setAnimationListener(new android.view.animation.Animation.AnimationListener(fragment) {

                        final Fragment a;
                        final i b;

                        public void onAnimationEnd(Animation animation)
                        {
                            if (a.mAnimatingAway != null)
                            {
                                a.mAnimatingAway = null;
                                b.a(a, a.mStateAfterAnimating, 0, 0, false);
                            }
                        }

                        public void onAnimationRepeat(Animation animation)
                        {
                        }

                        public void onAnimationStart(Animation animation)
                        {
                        }

            
            {
                b = i.this;
                a = fragment;
                super();
            }
                    });
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
            Log.v("FragmentManager", (new StringBuilder()).append("movefrom CREATED: ").append(fragment).toString());
        }
        if (!fragment.mRetaining)
        {
            fragment.performDestroy();
        }
        fragment.mCalled = false;
        fragment.onDetach();
        if (!fragment.mCalled)
        {
            throw new android.support.v4.app.ai((new StringBuilder()).append("Fragment ").append(fragment).append(" did not call through to super.onDetach()").toString());
        }
        j2 = i1;
        if (!flag)
        {
            if (!fragment.mRetaining)
            {
                e(fragment);
                j2 = i1;
            } else
            {
                fragment.mActivity = null;
                fragment.mParentFragment = null;
                fragment.mFragmentManager = null;
                fragment.mChildFragmentManager = null;
                j2 = i1;
            }
        }
        if (true) goto _L16; else goto _L15
_L15:
    }

    public void a(Fragment fragment, boolean flag)
    {
        if (g == null)
        {
            g = new ArrayList();
        }
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("add: ").append(fragment).toString());
        }
        d(fragment);
        if (!fragment.mDetached)
        {
            if (g.contains(fragment))
            {
                throw new IllegalStateException((new StringBuilder()).append("Fragment already added: ").append(fragment).toString());
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
                c(fragment);
            }
        }
    }

    public void a(f f1, g g1, Fragment fragment)
    {
        if (o != null)
        {
            throw new IllegalStateException("Already attached");
        } else
        {
            o = f1;
            p = g1;
            q = fragment;
            return;
        }
    }

    public void a(Runnable runnable, boolean flag)
    {
        if (!flag)
        {
            x();
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

    public void a(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
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
                    Fragment fragment1 = (Fragment)g.get(j1);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(j1);
                    printwriter.print(": ");
                    printwriter.println(fragment1.toString());
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
                    Fragment fragment2 = (Fragment)j.get(k1);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(k1);
                    printwriter.print(": ");
                    printwriter.println(fragment2.toString());
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
                    e e1 = (e)i.get(l1);
                    printwriter.print(s1);
                    printwriter.print("  #");
                    printwriter.print(l1);
                    printwriter.print(": ");
                    printwriter.println(e1.toString());
                    e1.a(s2, filedescriptor, printwriter, as);
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
        filedescriptor = (e)k.get(i2);
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
        break MISSING_BLOCK_LABEL_710;
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

    boolean a(Handler handler, String s1, int i1, int j1)
    {
        if (i != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (s1 != null || i1 >= 0 || (j1 & 1) != 0) goto _L4; else goto _L3
_L3:
        if ((i1 = i.size() - 1) < 0) goto _L1; else goto _L5
_L5:
        handler = (e)i.remove(i1);
        s1 = new SparseArray();
        SparseArray sparsearray = new SparseArray();
        handler.a(s1, sparsearray);
        handler.a(true, null, s1, sparsearray);
        i();
_L8:
        return true;
_L4:
        int k1;
        int l1;
        k1 = -1;
        if (s1 == null && i1 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        l1 = i.size() - 1;
        break MISSING_BLOCK_LABEL_112;
        if (l1 < 0) goto _L1; else goto _L6
_L6:
        k1 = l1;
        if ((j1 & 1) == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        j1 = l1 - 1;
        do
        {
            k1 = j1;
            if (j1 < 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            handler = (e)i.get(j1);
            if (s1 == null || !s1.equals(handler.c()))
            {
                k1 = j1;
                if (i1 < 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                k1 = j1;
                if (i1 != ((e) (handler)).p)
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            j1--;
        } while (true);
        do
        {
            if (l1 < 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            handler = (e)i.get(l1);
            if (s1 != null && s1.equals(handler.c()) || i1 >= 0 && i1 == ((e) (handler)).p)
            {
                continue; /* Loop/switch isn't completed */
            }
            l1--;
        } while (true);
        if (k1 == i.size() - 1) goto _L1; else goto _L7
_L7:
        s1 = new ArrayList();
        for (i1 = i.size() - 1; i1 > k1; i1--)
        {
            s1.add(i.remove(i1));
        }

        j1 = s1.size() - 1;
        SparseArray sparsearray1 = new SparseArray();
        SparseArray sparsearray2 = new SparseArray();
        for (i1 = 0; i1 <= j1; i1++)
        {
            ((e)s1.get(i1)).a(sparsearray1, sparsearray2);
        }

        handler = null;
        i1 = 0;
        while (i1 <= j1) 
        {
            if (a)
            {
                Log.v("FragmentManager", (new StringBuilder()).append("Popping back stack state: ").append(s1.get(i1)).toString());
            }
            e e1 = (e)s1.get(i1);
            boolean flag;
            if (i1 == j1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            handler = e1.a(flag, handler, sparsearray1, sparsearray2);
            i1++;
        }
        i();
          goto _L8
    }

    public boolean a(Menu menu)
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

    public boolean a(Menu menu, MenuInflater menuinflater)
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

    public boolean a(MenuItem menuitem)
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

    public boolean a(String s1, int i1)
    {
        x();
        b();
        return a(o.mHandler, s1, -1, i1);
    }

    public Fragment b(String s1)
    {
        if (f != null && s1 != null)
        {
            for (int i1 = f.size() - 1; i1 >= 0; i1--)
            {
                Fragment fragment = (Fragment)f.get(i1);
                if (fragment == null)
                {
                    continue;
                }
                fragment = fragment.findFragmentByWho(s1);
                if (fragment != null)
                {
                    return fragment;
                }
            }

        }
        return null;
    }

    public void b(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        k.set(i1, null);
        if (l == null)
        {
            l = new ArrayList();
        }
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Freeing back stack index ").append(i1).toString());
        }
        l.add(Integer.valueOf(i1));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b(Fragment fragment)
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

    public void b(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("hide: ").append(fragment).toString());
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

    void b(e e1)
    {
        if (i == null)
        {
            i = new ArrayList();
        }
        i.add(e1);
        i();
    }

    public void b(Menu menu)
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

    public boolean b()
    {
        return h();
    }

    public boolean b(MenuItem menuitem)
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

    public void c()
    {
        a(new Runnable() {

            final i a;

            public void run()
            {
                a.a(a.o.mHandler, null, -1, 0);
            }

            
            {
                a = i.this;
                super();
            }
        }, false);
    }

    void c(Fragment fragment)
    {
        a(fragment, n, 0, 0, false);
    }

    public void c(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("show: ").append(fragment).toString());
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

    void d(Fragment fragment)
    {
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
                Log.v("FragmentManager", (new StringBuilder()).append("Allocated fragment index ").append(fragment).toString());
                return;
            }
        }
    }

    public void d(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("detach: ").append(fragment).toString());
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
                        Log.v("FragmentManager", (new StringBuilder()).append("remove from detach: ").append(fragment).toString());
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

    public boolean d()
    {
        x();
        b();
        return a(o.mHandler, ((String) (null)), -1, 0);
    }

    public int e()
    {
        if (i != null)
        {
            return i.size();
        } else
        {
            return 0;
        }
    }

    void e(Fragment fragment)
    {
        if (fragment.mIndex < 0)
        {
            return;
        }
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("Freeing fragment index ").append(fragment).toString());
        }
        f.set(fragment.mIndex, null);
        if (h == null)
        {
            h = new ArrayList();
        }
        h.add(Integer.valueOf(fragment.mIndex));
        o.a(fragment.mWho);
        fragment.initState();
    }

    public void e(Fragment fragment, int i1, int j1)
    {
        if (a)
        {
            Log.v("FragmentManager", (new StringBuilder()).append("attach: ").append(fragment).toString());
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
                    throw new IllegalStateException((new StringBuilder()).append("Fragment already added: ").append(fragment).toString());
                }
                if (a)
                {
                    Log.v("FragmentManager", (new StringBuilder()).append("add from attach: ").append(fragment).toString());
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

    public List f()
    {
        return f;
    }

    void f(Fragment fragment)
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

    Bundle g(Fragment fragment)
    {
        if (w == null)
        {
            w = new Bundle();
        }
        fragment.performSaveInstanceState(w);
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
        if (fragment.mView != null)
        {
            f(fragment);
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

    void g()
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

    public boolean h()
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
            g();
        }
        return flag;
    }

    void i()
    {
        if (m != null)
        {
            for (int i1 = 0; i1 < m.size(); i1++)
            {
                ((h.a)m.get(i1)).a();
            }

        }
    }

    ArrayList j()
    {
        ArrayList arraylist1 = null;
        ArrayList arraylist = null;
        if (f != null)
        {
            int i1 = 0;
            do
            {
                arraylist1 = arraylist;
                if (i1 >= f.size())
                {
                    break;
                }
                Fragment fragment = (Fragment)f.get(i1);
                ArrayList arraylist2 = arraylist;
                if (fragment != null)
                {
                    arraylist2 = arraylist;
                    if (fragment.mRetainInstance)
                    {
                        arraylist1 = arraylist;
                        if (arraylist == null)
                        {
                            arraylist1 = new ArrayList();
                        }
                        arraylist1.add(fragment);
                        fragment.mRetaining = true;
                        int j1;
                        if (fragment.mTarget != null)
                        {
                            j1 = fragment.mTarget.mIndex;
                        } else
                        {
                            j1 = -1;
                        }
                        fragment.mTargetIndex = j1;
                        arraylist2 = arraylist1;
                        if (a)
                        {
                            Log.v("FragmentManager", (new StringBuilder()).append("retainNonConfig: keeping retained ").append(fragment).toString());
                            arraylist2 = arraylist1;
                        }
                    }
                }
                i1++;
                arraylist = arraylist2;
            } while (true);
        }
        return arraylist1;
    }

    Parcelable k()
    {
        FragmentManagerState fragmentmanagerstate;
        fragmentmanagerstate = null;
        h();
        if (b)
        {
            s = true;
        }
        if (f != null && f.size() > 0) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        FragmentState afragmentstate[];
        int j2 = f.size();
        afragmentstate = new FragmentState[j2];
        int k1 = 0;
        boolean flag = false;
        while (k1 < j2) 
        {
            Fragment fragment = (Fragment)f.get(k1);
            if (fragment == null)
            {
                continue;
            }
            if (fragment.mIndex < 0)
            {
                a(new IllegalStateException((new StringBuilder()).append("Failure saving state: active ").append(fragment).append(" has cleared index: ").append(fragment.mIndex).toString()));
            }
            FragmentState fragmentstate = new FragmentState(fragment);
            afragmentstate[k1] = fragmentstate;
            if (fragment.mState > 0 && fragmentstate.j == null)
            {
                fragmentstate.j = g(fragment);
                if (fragment.mTarget != null)
                {
                    if (fragment.mTarget.mIndex < 0)
                    {
                        a(new IllegalStateException((new StringBuilder()).append("Failure saving state: ").append(fragment).append(" has target not in fragment manager: ").append(fragment.mTarget).toString()));
                    }
                    if (fragmentstate.j == null)
                    {
                        fragmentstate.j = new Bundle();
                    }
                    a(fragmentstate.j, "android:target_state", fragment.mTarget);
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
                Log.v("FragmentManager", (new StringBuilder()).append("Saved state of ").append(fragment).append(": ").append(fragmentstate.j).toString());
            }
            flag = true;
            k1++;
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
        int ai1[];
label0:
        {
            if (g != null)
            {
                int l1 = g.size();
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
                        ai2[i1] = ((Fragment)g.get(i1)).mIndex;
                        if (ai2[i1] < 0)
                        {
                            a(new IllegalStateException((new StringBuilder()).append("Failure saving state: active ").append(g.get(i1)).append(" has cleared index: ").append(ai2[i1]).toString()));
                        }
                        if (a)
                        {
                            Log.v("FragmentManager", (new StringBuilder()).append("saveAllState: adding fragment #").append(i1).append(": ").append(g.get(i1)).toString());
                        }
                        i1++;
                    } while (true);
                    break label0;
                }
            }
            ai1 = null;
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
                    abackstackstate1[j1] = new BackStackState(this, (e)i.get(j1));
                    if (a)
                    {
                        Log.v("FragmentManager", (new StringBuilder()).append("saveAllState: adding back stack #").append(j1).append(": ").append(i.get(j1)).toString());
                    }
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

    public void l()
    {
        s = false;
    }

    public void m()
    {
        s = false;
        a(1, false);
    }

    public void n()
    {
        s = false;
        a(2, false);
    }

    public void o()
    {
        s = false;
        a(4, false);
    }

    public void p()
    {
        s = false;
        a(5, false);
    }

    public void q()
    {
        a(4, false);
    }

    public void r()
    {
        s = true;
        a(3, false);
    }

    public void s()
    {
        a(2, false);
    }

    public void t()
    {
        a(1, false);
    }

    public String toString()
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

    public void u()
    {
        t = true;
        h();
        a(0, false);
        o = null;
        p = null;
        q = null;
    }

    public void v()
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

    n w()
    {
        return this;
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
