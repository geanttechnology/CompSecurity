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
import android.support.v4.view.k;
import android.support.v7.av;
import android.support.v7.ba;
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
//            j, aj, p, g, 
//            ai, i, o, h

public class Fragment
    implements ComponentCallbacks, android.view.View.OnCreateContextMenuListener
{
    public static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel, null);
            }

            public SavedState[] a(int i1)
            {
                return new SavedState[i1];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i1)
            {
                return a(i1);
            }

        };
        final Bundle a;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            parcel.writeBundle(a);
        }


        SavedState(Bundle bundle)
        {
            a = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classloader)
        {
            a = parcel.readBundle();
            if (classloader != null && a != null)
            {
                a.setClassLoader(classloader);
            }
        }
    }

    public static class a extends RuntimeException
    {

        public a(String s1, Exception exception)
        {
            super(s1, exception);
        }
    }


    private static final ba a = new ba();
    static final Object j = new Object();
    boolean A;
    int B;
    j C;
    g D;
    j E;
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
    ai ah;
    ai ai;
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
        aa = j;
        ab = null;
        ac = j;
        ad = null;
        ae = j;
        ah = null;
        ai = null;
    }

    public static Fragment a(Context context, String s1)
    {
        return a(context, s1, ((Bundle) (null)));
    }

    public static Fragment a(Context context, String s1, Bundle bundle)
    {
        Class class1;
        Class class2;
        try
        {
            class2 = (Class)a.get(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a((new StringBuilder()).append("Unable to instantiate fragment ").append(s1).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a((new StringBuilder()).append("Unable to instantiate fragment ").append(s1).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a((new StringBuilder()).append("Unable to instantiate fragment ").append(s1).append(": make sure class name exists, is public, and has an").append(" empty constructor that is public").toString(), context);
        }
        class1 = class2;
        if (class2 != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        class1 = context.getClassLoader().loadClass(s1);
        a.put(s1, class1);
        context = (Fragment)class1.newInstance();
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        bundle.setClassLoader(context.getClass().getClassLoader());
        context.r = bundle;
        return context;
    }

    static boolean b(Context context, String s1)
    {
        Class class1;
        Class class2;
        boolean flag;
        try
        {
            class2 = (Class)a.get(s1);
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
        a.put(s1, class1);
        flag = android/support/v4/app/Fragment.isAssignableFrom(class1);
        return flag;
    }

    public Object A()
    {
        if (aa == j)
        {
            return z();
        } else
        {
            return aa;
        }
    }

    public Object B()
    {
        return ab;
    }

    public Object C()
    {
        if (ac == j)
        {
            return B();
        } else
        {
            return ac;
        }
    }

    public Object D()
    {
        return ad;
    }

    public Object E()
    {
        if (ae == j)
        {
            return D();
        } else
        {
            return ae;
        }
    }

    public boolean F()
    {
        if (ag == null)
        {
            return true;
        } else
        {
            return ag.booleanValue();
        }
    }

    public boolean G()
    {
        if (af == null)
        {
            return true;
        } else
        {
            return af.booleanValue();
        }
    }

    void H()
    {
        E = new j();
        E.a(D, new h() {

            final Fragment a;

            public View a(int i1)
            {
                if (a.S == null)
                {
                    throw new IllegalStateException("Fragment does not have a view");
                } else
                {
                    return a.S.findViewById(i1);
                }
            }

            public boolean a()
            {
                return a.S != null;
            }

            
            {
                a = Fragment.this;
                super();
            }
        }, this);
    }

    void I()
    {
        if (E != null)
        {
            E.k();
            E.g();
        }
        P = false;
        e();
        if (!P)
        {
            throw new aj((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onStart()").toString());
        }
        if (E != null)
        {
            E.n();
        }
        if (W != null)
        {
            W.g();
        }
    }

    void J()
    {
        if (E != null)
        {
            E.k();
            E.g();
        }
        P = false;
        u();
        if (!P)
        {
            throw new aj((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onResume()").toString());
        }
        if (E != null)
        {
            E.o();
            E.g();
        }
    }

    void K()
    {
        onLowMemory();
        if (E != null)
        {
            E.u();
        }
    }

    void L()
    {
        if (E != null)
        {
            E.p();
        }
        P = false;
        v();
        if (!P)
        {
            throw new aj((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onPause()").toString());
        } else
        {
            return;
        }
    }

    void M()
    {
        if (E != null)
        {
            E.q();
        }
        P = false;
        f();
        if (!P)
        {
            throw new aj((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onStop()").toString());
        } else
        {
            return;
        }
    }

    void N()
    {
label0:
        {
            if (E != null)
            {
                E.r();
            }
            if (X)
            {
                X = false;
                if (!Y)
                {
                    Y = true;
                    W = D.a(q, X, false);
                }
                if (W != null)
                {
                    if (D.h)
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

    void O()
    {
        if (E != null)
        {
            E.s();
        }
        P = false;
        g();
        if (!P)
        {
            throw new aj((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onDestroyView()").toString());
        }
        if (W != null)
        {
            W.f();
        }
    }

    void P()
    {
        if (E != null)
        {
            E.t();
        }
        P = false;
        w();
        if (!P)
        {
            throw new aj((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onDestroy()").toString());
        } else
        {
            return;
        }
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return null;
    }

    public Animation a(int i1, boolean flag, int j1)
    {
        return null;
    }

    public final String a(int i1)
    {
        return k().getString(i1);
    }

    public void a(int i1, int j1, Intent intent)
    {
    }

    final void a(int i1, Fragment fragment)
    {
        p = i1;
        if (fragment != null)
        {
            q = (new StringBuilder()).append(fragment.q).append(":").append(p).toString();
            return;
        } else
        {
            q = (new StringBuilder()).append("android:fragment:").append(p).toString();
            return;
        }
    }

    public void a(Activity activity)
    {
        P = true;
    }

    public void a(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        P = true;
    }

    public void a(Intent intent)
    {
        if (D == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(this).append(" not attached to Activity").toString());
        } else
        {
            D.a(this, intent, -1);
            return;
        }
    }

    public void a(Intent intent, int i1)
    {
        if (D == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(this).append(" not attached to Activity").toString());
        } else
        {
            D.a(this, intent, i1);
            return;
        }
    }

    void a(Configuration configuration)
    {
        onConfigurationChanged(configuration);
        if (E != null)
        {
            E.a(configuration);
        }
    }

    public void a(Bundle bundle)
    {
        P = true;
    }

    public void a(SavedState savedstate)
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

    public void a(Menu menu)
    {
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(View view, Bundle bundle)
    {
    }

    public void a(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
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
            printwriter.println((new StringBuilder()).append("Child ").append(E).append(":").toString());
            E.a((new StringBuilder()).append(s1).append("  ").toString(), filedescriptor, printwriter, as);
        }
    }

    public boolean a(MenuItem menuitem)
    {
        return false;
    }

    public LayoutInflater b(Bundle bundle)
    {
        bundle = D.getLayoutInflater().cloneInContext(D);
        m();
        android.support.v4.view.k.a(bundle, E.v());
        return bundle;
    }

    View b(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (E != null)
        {
            E.k();
        }
        return a(layoutinflater, viewgroup, bundle);
    }

    public void b(Menu menu)
    {
    }

    boolean b(Menu menu, MenuInflater menuinflater)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        if (!J)
        {
            boolean flag = flag2;
            if (N)
            {
                flag = flag2;
                if (O)
                {
                    flag = true;
                    a(menu, menuinflater);
                }
            }
            flag1 = flag;
            if (E != null)
            {
                flag1 = flag | E.a(menu, menuinflater);
            }
        }
        return flag1;
    }

    public boolean b(MenuItem menuitem)
    {
        return false;
    }

    public void c(boolean flag)
    {
    }

    boolean c(Menu menu)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        if (!J)
        {
            boolean flag = flag2;
            if (N)
            {
                flag = flag2;
                if (O)
                {
                    flag = true;
                    a(menu);
                }
            }
            flag1 = flag;
            if (E != null)
            {
                flag1 = flag | E.a(menu);
            }
        }
        return flag1;
    }

    boolean c(MenuItem menuitem)
    {
        while (!J && (N && O && a(menuitem) || E != null && E.a(menuitem))) 
        {
            return true;
        }
        return false;
    }

    public void d()
    {
        P = true;
    }

    public void d(Bundle bundle)
    {
        P = true;
    }

    void d(Menu menu)
    {
        if (!J)
        {
            if (N && O)
            {
                b(menu);
            }
            if (E != null)
            {
                E.b(menu);
            }
        }
    }

    public void d(boolean flag)
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

    boolean d(MenuItem menuitem)
    {
        while (!J && (b(menuitem) || E != null && E.b(menuitem))) 
        {
            return true;
        }
        return false;
    }

    public void e()
    {
        P = true;
        if (!X)
        {
            X = true;
            if (!Y)
            {
                Y = true;
                W = D.a(q, X, false);
            }
            if (W != null)
            {
                W.b();
            }
        }
    }

    public void e(Bundle bundle)
    {
    }

    public void e(boolean flag)
    {
        if (O != flag)
        {
            O = flag;
            if (N && n() && !q())
            {
                D.d();
            }
        }
    }

    public final boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    public void f()
    {
        P = true;
    }

    final void f(Bundle bundle)
    {
        if (o != null)
        {
            T.restoreHierarchyState(o);
            o = null;
        }
        P = false;
        h(bundle);
        if (!P)
        {
            throw new aj((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onViewStateRestored()").toString());
        } else
        {
            return;
        }
    }

    public void f(boolean flag)
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

    public void g()
    {
        P = true;
    }

    public void g(Bundle bundle)
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

    public void h(Bundle bundle)
    {
        P = true;
    }

    final boolean h()
    {
        return B > 0;
    }

    public final int hashCode()
    {
        return super.hashCode();
    }

    public final Bundle i()
    {
        return r;
    }

    void i(Bundle bundle)
    {
        if (E != null)
        {
            E.k();
        }
        P = false;
        a(bundle);
        if (!P)
        {
            throw new aj((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onCreate()").toString());
        }
        if (bundle != null)
        {
            bundle = bundle.getParcelable("android:support:fragments");
            if (bundle != null)
            {
                if (E == null)
                {
                    H();
                }
                E.a(bundle, null);
                E.l();
            }
        }
    }

    public final g j()
    {
        return D;
    }

    void j(Bundle bundle)
    {
        if (E != null)
        {
            E.k();
        }
        P = false;
        d(bundle);
        if (!P)
        {
            throw new aj((new StringBuilder()).append("Fragment ").append(this).append(" did not call through to super.onActivityCreated()").toString());
        }
        if (E != null)
        {
            E.m();
        }
    }

    public final Resources k()
    {
        if (D == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(this).append(" not attached to Activity").toString());
        } else
        {
            return D.getResources();
        }
    }

    void k(Bundle bundle)
    {
        e(bundle);
        if (E != null)
        {
            Parcelable parcelable = E.j();
            if (parcelable != null)
            {
                bundle.putParcelable("android:support:fragments", parcelable);
            }
        }
    }

    public final i l()
    {
        return C;
    }

    public final i m()
    {
        if (E != null) goto _L2; else goto _L1
_L1:
        H();
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
        if (k >= 1)
        {
            E.l();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final boolean n()
    {
        return D != null && v;
    }

    public final boolean o()
    {
        return w;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        P = true;
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        j().onCreateContextMenu(contextmenu, view, contextmenuinfo);
    }

    public void onLowMemory()
    {
        P = true;
    }

    public final boolean p()
    {
        return x;
    }

    public final boolean q()
    {
        return J;
    }

    public final boolean r()
    {
        return L;
    }

    public o s()
    {
        if (W != null)
        {
            return W;
        }
        if (D == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(this).append(" not attached to Activity").toString());
        } else
        {
            Y = true;
            W = D.a(q, X, true);
            return W;
        }
    }

    public View t()
    {
        return S;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        av.a(this, stringbuilder);
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

    public void u()
    {
        P = true;
    }

    public void v()
    {
        P = true;
    }

    public void w()
    {
        P = true;
        if (!Y)
        {
            Y = true;
            W = D.a(q, X, false);
        }
        if (W != null)
        {
            W.h();
        }
    }

    void x()
    {
        p = -1;
        q = null;
        v = false;
        w = false;
        x = false;
        y = false;
        z = false;
        A = false;
        B = 0;
        C = null;
        E = null;
        D = null;
        G = 0;
        H = 0;
        I = null;
        J = false;
        K = false;
        M = false;
        W = null;
        X = false;
        Y = false;
    }

    public void y()
    {
    }

    public Object z()
    {
        return Z;
    }

}
