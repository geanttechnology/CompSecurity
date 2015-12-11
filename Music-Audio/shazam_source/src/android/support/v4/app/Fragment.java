// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.f.c;
import android.support.v4.f.h;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.support.v4.app:
//            l, p, i, ag, 
//            k, o, j

public class Fragment
    implements ComponentCallbacks, android.view.View.OnCreateContextMenuListener
{
    public static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object[] newArray(int j)
            {
                return new SavedState[j];
            }

        };
        final Bundle a;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int j)
        {
            parcel.writeBundle(a);
        }


        SavedState(Bundle bundle)
        {
            a = bundle;
        }

        SavedState(Parcel parcel)
        {
            a = parcel.readBundle();
        }
    }

    public static final class a extends RuntimeException
    {

        public a(String s1, Exception exception)
        {
            super(s1, exception);
        }
    }


    static final Object a_ = new Object();
    private static final h sClassMap = new h();
    boolean A;
    int B;
    l C;
    i D;
    l E;
    Fragment F;
    int G;
    int H;
    String I;
    boolean J;
    boolean K;
    boolean L;
    boolean M;
    boolean N;
    boolean O;
    boolean P;
    int Q;
    ViewGroup R;
    View S;
    View T;
    boolean U;
    boolean V;
    p W;
    boolean X;
    boolean Y;
    Object Z;
    Object aa;
    Object ab;
    Object ac;
    Object ad;
    Object ae;
    Boolean af;
    Boolean ag;
    ag ah;
    ag ai;
    int k;
    View l;
    int m;
    Bundle n;
    SparseArray o;
    int p;
    String q;
    Bundle r;
    Fragment s;
    int t;
    int u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    boolean z;

    public Fragment()
    {
        k = 0;
        p = -1;
        t = -1;
        O = true;
        V = true;
        Z = null;
        aa = a_;
        ab = null;
        ac = a_;
        ad = null;
        ae = a_;
        ah = null;
        ai = null;
    }

    static boolean a(Context context, String s1)
    {
        Class class1;
        Class class2;
        boolean flag;
        try
        {
            class2 = (Class)sClassMap.get(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        class1 = class2;
        if (class2 != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        class1 = context.getClassLoader().loadClass(s1);
        sClassMap.put(s1, class1);
        flag = android/support/v4/app/Fragment.isAssignableFrom(class1);
        return flag;
    }

    public static Fragment instantiate(Context context, String s1)
    {
        return instantiate(context, s1, null);
    }

    public static Fragment instantiate(Context context, String s1, Bundle bundle)
    {
        Class class1;
        Class class2;
        try
        {
            class2 = (Class)sClassMap.get(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a((new StringBuilder("Unable to instantiate fragment ")).append(s1).append(": make sure class name exists, is public, and has an empty constructor that is public").toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a((new StringBuilder("Unable to instantiate fragment ")).append(s1).append(": make sure class name exists, is public, and has an empty constructor that is public").toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a((new StringBuilder("Unable to instantiate fragment ")).append(s1).append(": make sure class name exists, is public, and has an empty constructor that is public").toString(), context);
        }
        class1 = class2;
        if (class2 != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        class1 = context.getClassLoader().loadClass(s1);
        sClassMap.put(s1, class1);
        context = (Fragment)class1.newInstance();
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        bundle.setClassLoader(context.getClass().getClassLoader());
        context.r = bundle;
        return context;
    }

    final View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (E != null)
        {
            E.s = false;
        }
        return onCreateView(layoutinflater, viewgroup, bundle);
    }

    final void a(int j, Fragment fragment)
    {
        p = j;
        if (fragment != null)
        {
            q = (new StringBuilder()).append(fragment.q).append(":").append(p).toString();
            return;
        } else
        {
            q = (new StringBuilder("android:fragment:")).append(p).toString();
            return;
        }
    }

    final void b(Bundle bundle)
    {
        onSaveInstanceState(bundle);
        if (E != null)
        {
            Parcelable parcelable = E.k();
            if (parcelable != null)
            {
                bundle.putParcelable("android:support:fragments", parcelable);
            }
        }
    }

    public void dump(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.print(s1);
        printwriter.print("mFragmentId=#");
        printwriter.print(Integer.toHexString(G));
        printwriter.print(" mContainerId=#");
        printwriter.print(Integer.toHexString(H));
        printwriter.print(" mTag=");
        printwriter.println(I);
        printwriter.print(s1);
        printwriter.print("mState=");
        printwriter.print(k);
        printwriter.print(" mIndex=");
        printwriter.print(p);
        printwriter.print(" mWho=");
        printwriter.print(q);
        printwriter.print(" mBackStackNesting=");
        printwriter.println(B);
        printwriter.print(s1);
        printwriter.print("mAdded=");
        printwriter.print(v);
        printwriter.print(" mRemoving=");
        printwriter.print(w);
        printwriter.print(" mResumed=");
        printwriter.print(x);
        printwriter.print(" mFromLayout=");
        printwriter.print(y);
        printwriter.print(" mInLayout=");
        printwriter.println(z);
        printwriter.print(s1);
        printwriter.print("mHidden=");
        printwriter.print(J);
        printwriter.print(" mDetached=");
        printwriter.print(K);
        printwriter.print(" mMenuVisible=");
        printwriter.print(O);
        printwriter.print(" mHasMenu=");
        printwriter.println(N);
        printwriter.print(s1);
        printwriter.print("mRetainInstance=");
        printwriter.print(L);
        printwriter.print(" mRetaining=");
        printwriter.print(M);
        printwriter.print(" mUserVisibleHint=");
        printwriter.println(V);
        if (C != null)
        {
            printwriter.print(s1);
            printwriter.print("mFragmentManager=");
            printwriter.println(C);
        }
        if (D != null)
        {
            printwriter.print(s1);
            printwriter.print("mActivity=");
            printwriter.println(D);
        }
        if (F != null)
        {
            printwriter.print(s1);
            printwriter.print("mParentFragment=");
            printwriter.println(F);
        }
        if (r != null)
        {
            printwriter.print(s1);
            printwriter.print("mArguments=");
            printwriter.println(r);
        }
        if (n != null)
        {
            printwriter.print(s1);
            printwriter.print("mSavedFragmentState=");
            printwriter.println(n);
        }
        if (o != null)
        {
            printwriter.print(s1);
            printwriter.print("mSavedViewState=");
            printwriter.println(o);
        }
        if (s != null)
        {
            printwriter.print(s1);
            printwriter.print("mTarget=");
            printwriter.print(s);
            printwriter.print(" mTargetRequestCode=");
            printwriter.println(u);
        }
        if (Q != 0)
        {
            printwriter.print(s1);
            printwriter.print("mNextAnim=");
            printwriter.println(Q);
        }
        if (R != null)
        {
            printwriter.print(s1);
            printwriter.print("mContainer=");
            printwriter.println(R);
        }
        if (S != null)
        {
            printwriter.print(s1);
            printwriter.print("mView=");
            printwriter.println(S);
        }
        if (T != null)
        {
            printwriter.print(s1);
            printwriter.print("mInnerView=");
            printwriter.println(S);
        }
        if (l != null)
        {
            printwriter.print(s1);
            printwriter.print("mAnimatingAway=");
            printwriter.println(l);
            printwriter.print(s1);
            printwriter.print("mStateAfterAnimating=");
            printwriter.println(m);
        }
        if (W != null)
        {
            printwriter.print(s1);
            printwriter.println("Loader Manager:");
            W.a((new StringBuilder()).append(s1).append("  ").toString(), filedescriptor, printwriter, as);
        }
        if (E != null)
        {
            printwriter.print(s1);
            printwriter.println((new StringBuilder("Child ")).append(E).append(":").toString());
            E.a((new StringBuilder()).append(s1).append("  ").toString(), filedescriptor, printwriter, as);
        }
    }

    public final boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    public final i getActivity()
    {
        return D;
    }

    public boolean getAllowEnterTransitionOverlap()
    {
        if (ag == null)
        {
            return true;
        } else
        {
            return ag.booleanValue();
        }
    }

    public boolean getAllowReturnTransitionOverlap()
    {
        if (af == null)
        {
            return true;
        } else
        {
            return af.booleanValue();
        }
    }

    public final Bundle getArguments()
    {
        return r;
    }

    public final k getChildFragmentManager()
    {
        if (E != null) goto _L2; else goto _L1
_L1:
        q_();
        if (k < 5) goto _L4; else goto _L3
_L3:
        E.o();
_L2:
        return E;
_L4:
        if (k >= 4)
        {
            E.n();
        } else
        if (k >= 2)
        {
            E.m();
        } else
        if (k > 0)
        {
            E.l();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public Object getEnterTransition()
    {
        return Z;
    }

    public Object getExitTransition()
    {
        return ab;
    }

    public final k getFragmentManager()
    {
        return C;
    }

    public final int getId()
    {
        return G;
    }

    public LayoutInflater getLayoutInflater(Bundle bundle)
    {
        bundle = D.getLayoutInflater().cloneInContext(D);
        getChildFragmentManager();
        android.support.v4.view.h.a(bundle, E);
        return bundle;
    }

    public o getLoaderManager()
    {
        if (W != null)
        {
            return W;
        }
        if (D == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            Y = true;
            W = D.getLoaderManager(q, X, true);
            return W;
        }
    }

    public final Fragment getParentFragment()
    {
        return F;
    }

    public Object getReenterTransition()
    {
        if (ac == a_)
        {
            return getExitTransition();
        } else
        {
            return ac;
        }
    }

    public final Resources getResources()
    {
        if (D == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            return D.getResources();
        }
    }

    public final boolean getRetainInstance()
    {
        return L;
    }

    public Object getReturnTransition()
    {
        if (aa == a_)
        {
            return getEnterTransition();
        } else
        {
            return aa;
        }
    }

    public Object getSharedElementEnterTransition()
    {
        return ad;
    }

    public Object getSharedElementReturnTransition()
    {
        if (ae == a_)
        {
            return getSharedElementEnterTransition();
        } else
        {
            return ae;
        }
    }

    public final String getString(int j)
    {
        return getResources().getString(j);
    }

    public final transient String getString(int j, Object aobj[])
    {
        return getResources().getString(j, aobj);
    }

    public final String getTag()
    {
        return I;
    }

    public final Fragment getTargetFragment()
    {
        return s;
    }

    public final int getTargetRequestCode()
    {
        return u;
    }

    public final CharSequence getText(int j)
    {
        return getResources().getText(j);
    }

    public boolean getUserVisibleHint()
    {
        return V;
    }

    public View getView()
    {
        return S;
    }

    public final boolean hasOptionsMenu()
    {
        return N;
    }

    public final int hashCode()
    {
        return super.hashCode();
    }

    public final boolean isAdded()
    {
        return D != null && v;
    }

    public final boolean isDetached()
    {
        return K;
    }

    public final boolean isHidden()
    {
        return J;
    }

    public final boolean isInLayout()
    {
        return z;
    }

    public final boolean isMenuVisible()
    {
        return O;
    }

    public final boolean isRemoving()
    {
        return w;
    }

    public final boolean isResumed()
    {
        return x;
    }

    public final boolean isVisible()
    {
        return isAdded() && !isHidden() && S != null && S.getWindowToken() != null && S.getVisibility() == 0;
    }

    public void onActivityCreated(Bundle bundle)
    {
        P = true;
    }

    public void onActivityResult(int j, int i1, Intent intent)
    {
    }

    public void onAttach(Activity activity)
    {
        P = true;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        P = true;
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        return false;
    }

    public void onCreate(Bundle bundle)
    {
        P = true;
    }

    public Animation onCreateAnimation(int j, boolean flag, int i1)
    {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        getActivity().onCreateContextMenu(contextmenu, view, contextmenuinfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return null;
    }

    public void onDestroy()
    {
        P = true;
        if (!Y)
        {
            Y = true;
            W = D.getLoaderManager(q, X, false);
        }
        if (W != null)
        {
            W.g();
        }
    }

    public void onDestroyOptionsMenu()
    {
    }

    public void onDestroyView()
    {
        P = true;
    }

    public void onDetach()
    {
        P = true;
    }

    public void onHiddenChanged(boolean flag)
    {
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        P = true;
    }

    public void onLowMemory()
    {
        P = true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu)
    {
    }

    public void onPause()
    {
        P = true;
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
    }

    public void onResume()
    {
        P = true;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
    }

    public void onStart()
    {
        P = true;
        if (!X)
        {
            X = true;
            if (!Y)
            {
                Y = true;
                W = D.getLoaderManager(q, X, false);
            }
            if (W != null)
            {
                W.b();
            }
        }
    }

    public void onStop()
    {
        P = true;
    }

    public void onViewCreated(View view, Bundle bundle)
    {
    }

    public void onViewStateRestored(Bundle bundle)
    {
        P = true;
    }

    final void p_()
    {
label0:
        {
            if (E != null)
            {
                E.c(2);
            }
            if (X)
            {
                X = false;
                if (!Y)
                {
                    Y = true;
                    W = D.getLoaderManager(q, X, false);
                }
                if (W != null)
                {
                    if (D.mRetaining)
                    {
                        break label0;
                    }
                    W.c();
                }
            }
            return;
        }
        W.d();
    }

    final void q_()
    {
        E = new l();
        E.a(D, new j() {

            final Fragment a;

            public final View a(int i1)
            {
                if (a.S == null)
                {
                    throw new IllegalStateException("Fragment does not have a view");
                } else
                {
                    return a.S.findViewById(i1);
                }
            }

            public final boolean a()
            {
                return a.S != null;
            }

            
            {
                a = Fragment.this;
                super();
            }
        }, this);
    }

    public void registerForContextMenu(View view)
    {
        view.setOnCreateContextMenuListener(this);
    }

    public void setAllowEnterTransitionOverlap(boolean flag)
    {
        ag = Boolean.valueOf(flag);
    }

    public void setAllowReturnTransitionOverlap(boolean flag)
    {
        af = Boolean.valueOf(flag);
    }

    public void setArguments(Bundle bundle)
    {
        if (p >= 0)
        {
            throw new IllegalStateException("Fragment already active");
        } else
        {
            r = bundle;
            return;
        }
    }

    public void setEnterSharedElementCallback(ag ag1)
    {
        ah = ag1;
    }

    public void setEnterTransition(Object obj)
    {
        Z = obj;
    }

    public void setExitSharedElementCallback(ag ag1)
    {
        ai = ag1;
    }

    public void setExitTransition(Object obj)
    {
        ab = obj;
    }

    public void setHasOptionsMenu(boolean flag)
    {
        if (N != flag)
        {
            N = flag;
            if (isAdded() && !isHidden())
            {
                D.supportInvalidateOptionsMenu();
            }
        }
    }

    public void setInitialSavedState(SavedState savedstate)
    {
        if (p >= 0)
        {
            throw new IllegalStateException("Fragment already active");
        }
        if (savedstate != null && savedstate.a != null)
        {
            savedstate = savedstate.a;
        } else
        {
            savedstate = null;
        }
        n = savedstate;
    }

    public void setMenuVisibility(boolean flag)
    {
        if (O != flag)
        {
            O = flag;
            if (N && isAdded() && !isHidden())
            {
                D.supportInvalidateOptionsMenu();
            }
        }
    }

    public void setReenterTransition(Object obj)
    {
        ac = obj;
    }

    public void setRetainInstance(boolean flag)
    {
        if (flag && F != null)
        {
            throw new IllegalStateException("Can't retain fragements that are nested in other fragments");
        } else
        {
            L = flag;
            return;
        }
    }

    public void setReturnTransition(Object obj)
    {
        aa = obj;
    }

    public void setSharedElementEnterTransition(Object obj)
    {
        ad = obj;
    }

    public void setSharedElementReturnTransition(Object obj)
    {
        ae = obj;
    }

    public void setTargetFragment(Fragment fragment, int j)
    {
        s = fragment;
        u = j;
    }

    public void setUserVisibleHint(boolean flag)
    {
        if (!V && flag && k < 4)
        {
            C.b(this);
        }
        V = flag;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        U = flag;
    }

    public void startActivity(Intent intent)
    {
        if (D == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            D.startActivityFromFragment(this, intent, -1);
            return;
        }
    }

    public void startActivityForResult(Intent intent, int j)
    {
        if (D == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            D.startActivityFromFragment(this, intent, j);
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        c.a(this, stringbuilder);
        if (p >= 0)
        {
            stringbuilder.append(" #");
            stringbuilder.append(p);
        }
        if (G != 0)
        {
            stringbuilder.append(" id=0x");
            stringbuilder.append(Integer.toHexString(G));
        }
        if (I != null)
        {
            stringbuilder.append(" ");
            stringbuilder.append(I);
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    public void unregisterForContextMenu(View view)
    {
        view.setOnCreateContextMenuListener(null);
    }

}
