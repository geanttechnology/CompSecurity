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
import android.support.v4.e.a;
import android.support.v4.g.l;
import android.support.v4.view.aa;
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
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            r, ay, ab, z, 
//            t, q, cz, cy, 
//            aa, ax

public class Fragment
    implements ComponentCallbacks, android.view.View.OnCreateContextMenuListener
{

    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 5;
    static final int STARTED = 4;
    static final int STOPPED = 3;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    private static final l sClassMap = new l();
    boolean mAdded;
    Boolean mAllowEnterTransitionOverlap;
    Boolean mAllowReturnTransitionOverlap;
    View mAnimatingAway;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    boolean mCheckedForLoaderManager;
    ab mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    Object mEnterTransition;
    cy mEnterTransitionCallback;
    Object mExitTransition;
    cy mExitTransitionCallback;
    int mFragmentId;
    ab mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    z mHost;
    boolean mInLayout;
    int mIndex;
    View mInnerView;
    ay mLoaderManager;
    boolean mLoadersStarted;
    boolean mMenuVisible;
    int mNextAnim;
    Fragment mParentFragment;
    Object mReenterTransition;
    boolean mRemoving;
    boolean mRestored;
    boolean mResumed;
    boolean mRetainInstance;
    boolean mRetaining;
    Object mReturnTransition;
    Bundle mSavedFragmentState;
    SparseArray mSavedViewState;
    Object mSharedElementEnterTransition;
    Object mSharedElementReturnTransition;
    int mState;
    int mStateAfterAnimating;
    String mTag;
    Fragment mTarget;
    int mTargetIndex;
    int mTargetRequestCode;
    boolean mUserVisibleHint;
    View mView;
    String mWho;

    public Fragment()
    {
        mState = 0;
        mIndex = -1;
        mTargetIndex = -1;
        mMenuVisible = true;
        mUserVisibleHint = true;
        mEnterTransition = null;
        mReturnTransition = USE_DEFAULT_TRANSITION;
        mExitTransition = null;
        mReenterTransition = USE_DEFAULT_TRANSITION;
        mSharedElementEnterTransition = null;
        mSharedElementReturnTransition = USE_DEFAULT_TRANSITION;
        mEnterTransitionCallback = null;
        mExitTransitionCallback = null;
    }

    public static Fragment instantiate(Context context, String s)
    {
        return instantiate(context, s, null);
    }

    public static Fragment instantiate(Context context, String s, Bundle bundle)
    {
        Class class1;
        Class class2;
        try
        {
            class2 = (Class)sClassMap.get(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new r((new StringBuilder("Unable to instantiate fragment ")).append(s).append(": make sure class name exists, is public, and has an empty constructor that is public").toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new r((new StringBuilder("Unable to instantiate fragment ")).append(s).append(": make sure class name exists, is public, and has an empty constructor that is public").toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new r((new StringBuilder("Unable to instantiate fragment ")).append(s).append(": make sure class name exists, is public, and has an empty constructor that is public").toString(), context);
        }
        class1 = class2;
        if (class2 != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        class1 = context.getClassLoader().loadClass(s);
        sClassMap.put(s, class1);
        context = (Fragment)class1.newInstance();
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        bundle.setClassLoader(context.getClass().getClassLoader());
        context.mArguments = bundle;
        return context;
    }

    static boolean isSupportFragmentClass(Context context, String s)
    {
        Class class1;
        Class class2;
        boolean flag;
        try
        {
            class2 = (Class)sClassMap.get(s);
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
        class1 = context.getClassLoader().loadClass(s);
        sClassMap.put(s, class1);
        flag = android/support/v4/app/Fragment.isAssignableFrom(class1);
        return flag;
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.print(s);
        printwriter.print("mFragmentId=#");
        printwriter.print(Integer.toHexString(mFragmentId));
        printwriter.print(" mContainerId=#");
        printwriter.print(Integer.toHexString(mContainerId));
        printwriter.print(" mTag=");
        printwriter.println(mTag);
        printwriter.print(s);
        printwriter.print("mState=");
        printwriter.print(mState);
        printwriter.print(" mIndex=");
        printwriter.print(mIndex);
        printwriter.print(" mWho=");
        printwriter.print(mWho);
        printwriter.print(" mBackStackNesting=");
        printwriter.println(mBackStackNesting);
        printwriter.print(s);
        printwriter.print("mAdded=");
        printwriter.print(mAdded);
        printwriter.print(" mRemoving=");
        printwriter.print(mRemoving);
        printwriter.print(" mResumed=");
        printwriter.print(mResumed);
        printwriter.print(" mFromLayout=");
        printwriter.print(mFromLayout);
        printwriter.print(" mInLayout=");
        printwriter.println(mInLayout);
        printwriter.print(s);
        printwriter.print("mHidden=");
        printwriter.print(mHidden);
        printwriter.print(" mDetached=");
        printwriter.print(mDetached);
        printwriter.print(" mMenuVisible=");
        printwriter.print(mMenuVisible);
        printwriter.print(" mHasMenu=");
        printwriter.println(mHasMenu);
        printwriter.print(s);
        printwriter.print("mRetainInstance=");
        printwriter.print(mRetainInstance);
        printwriter.print(" mRetaining=");
        printwriter.print(mRetaining);
        printwriter.print(" mUserVisibleHint=");
        printwriter.println(mUserVisibleHint);
        if (mFragmentManager != null)
        {
            printwriter.print(s);
            printwriter.print("mFragmentManager=");
            printwriter.println(mFragmentManager);
        }
        if (mHost != null)
        {
            printwriter.print(s);
            printwriter.print("mHost=");
            printwriter.println(mHost);
        }
        if (mParentFragment != null)
        {
            printwriter.print(s);
            printwriter.print("mParentFragment=");
            printwriter.println(mParentFragment);
        }
        if (mArguments != null)
        {
            printwriter.print(s);
            printwriter.print("mArguments=");
            printwriter.println(mArguments);
        }
        if (mSavedFragmentState != null)
        {
            printwriter.print(s);
            printwriter.print("mSavedFragmentState=");
            printwriter.println(mSavedFragmentState);
        }
        if (mSavedViewState != null)
        {
            printwriter.print(s);
            printwriter.print("mSavedViewState=");
            printwriter.println(mSavedViewState);
        }
        if (mTarget != null)
        {
            printwriter.print(s);
            printwriter.print("mTarget=");
            printwriter.print(mTarget);
            printwriter.print(" mTargetRequestCode=");
            printwriter.println(mTargetRequestCode);
        }
        if (mNextAnim != 0)
        {
            printwriter.print(s);
            printwriter.print("mNextAnim=");
            printwriter.println(mNextAnim);
        }
        if (mContainer != null)
        {
            printwriter.print(s);
            printwriter.print("mContainer=");
            printwriter.println(mContainer);
        }
        if (mView != null)
        {
            printwriter.print(s);
            printwriter.print("mView=");
            printwriter.println(mView);
        }
        if (mInnerView != null)
        {
            printwriter.print(s);
            printwriter.print("mInnerView=");
            printwriter.println(mView);
        }
        if (mAnimatingAway != null)
        {
            printwriter.print(s);
            printwriter.print("mAnimatingAway=");
            printwriter.println(mAnimatingAway);
            printwriter.print(s);
            printwriter.print("mStateAfterAnimating=");
            printwriter.println(mStateAfterAnimating);
        }
        if (mLoaderManager != null)
        {
            printwriter.print(s);
            printwriter.println("Loader Manager:");
            mLoaderManager.a((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }
        if (mChildFragmentManager != null)
        {
            printwriter.print(s);
            printwriter.println((new StringBuilder("Child ")).append(mChildFragmentManager).append(":").toString());
            mChildFragmentManager.a((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }
    }

    public final boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    Fragment findFragmentByWho(String s)
    {
        if (!s.equals(mWho)) goto _L2; else goto _L1
_L1:
        Fragment fragment = this;
_L6:
        return fragment;
_L2:
        ab ab1;
        int i;
        if (mChildFragmentManager == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        ab1 = mChildFragmentManager;
        if (ab1.b == null || s == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        i = ab1.b.size() - 1;
_L7:
        if (i < 0) goto _L4; else goto _L3
_L3:
        Fragment fragment1;
        fragment = (Fragment)ab1.b.get(i);
        if (fragment == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        fragment1 = fragment.findFragmentByWho(s);
        fragment = fragment1;
        if (fragment1 != null) goto _L6; else goto _L5
_L5:
        i--;
          goto _L7
_L4:
        return null;
        return null;
    }

    public final t getActivity()
    {
        if (mHost == null)
        {
            return null;
        } else
        {
            return (t)mHost.h();
        }
    }

    public boolean getAllowEnterTransitionOverlap()
    {
        if (mAllowEnterTransitionOverlap == null)
        {
            return true;
        } else
        {
            return mAllowEnterTransitionOverlap.booleanValue();
        }
    }

    public boolean getAllowReturnTransitionOverlap()
    {
        if (mAllowReturnTransitionOverlap == null)
        {
            return true;
        } else
        {
            return mAllowReturnTransitionOverlap.booleanValue();
        }
    }

    public final Bundle getArguments()
    {
        return mArguments;
    }

    public final android.support.v4.app.aa getChildFragmentManager()
    {
        if (mChildFragmentManager != null) goto _L2; else goto _L1
_L1:
        instantiateChildFragmentManager();
        if (mState < 5) goto _L4; else goto _L3
_L3:
        mChildFragmentManager.k();
_L2:
        return mChildFragmentManager;
_L4:
        if (mState >= 4)
        {
            mChildFragmentManager.j();
        } else
        if (mState >= 2)
        {
            mChildFragmentManager.i();
        } else
        if (mState > 0)
        {
            mChildFragmentManager.h();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public Context getContext()
    {
        if (mHost == null)
        {
            return null;
        } else
        {
            return mHost.a;
        }
    }

    public Object getEnterTransition()
    {
        return mEnterTransition;
    }

    public Object getExitTransition()
    {
        return mExitTransition;
    }

    public final android.support.v4.app.aa getFragmentManager()
    {
        return mFragmentManager;
    }

    public final Object getHost()
    {
        if (mHost == null)
        {
            return null;
        } else
        {
            return mHost.g();
        }
    }

    public final int getId()
    {
        return mFragmentId;
    }

    public LayoutInflater getLayoutInflater(Bundle bundle)
    {
        bundle = mHost.c();
        getChildFragmentManager();
        aa.a(bundle, mChildFragmentManager);
        return bundle;
    }

    public ax getLoaderManager()
    {
        if (mLoaderManager != null)
        {
            return mLoaderManager;
        }
        if (mHost == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            mCheckedForLoaderManager = true;
            mLoaderManager = mHost.a(mWho, mLoadersStarted, true);
            return mLoaderManager;
        }
    }

    public final Fragment getParentFragment()
    {
        return mParentFragment;
    }

    public Object getReenterTransition()
    {
        if (mReenterTransition == USE_DEFAULT_TRANSITION)
        {
            return getExitTransition();
        } else
        {
            return mReenterTransition;
        }
    }

    public final Resources getResources()
    {
        if (mHost == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            return mHost.a.getResources();
        }
    }

    public final boolean getRetainInstance()
    {
        return mRetainInstance;
    }

    public Object getReturnTransition()
    {
        if (mReturnTransition == USE_DEFAULT_TRANSITION)
        {
            return getEnterTransition();
        } else
        {
            return mReturnTransition;
        }
    }

    public Object getSharedElementEnterTransition()
    {
        return mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition()
    {
        if (mSharedElementReturnTransition == USE_DEFAULT_TRANSITION)
        {
            return getSharedElementEnterTransition();
        } else
        {
            return mSharedElementReturnTransition;
        }
    }

    public final String getString(int i)
    {
        return getResources().getString(i);
    }

    public final transient String getString(int i, Object aobj[])
    {
        return getResources().getString(i, aobj);
    }

    public final String getTag()
    {
        return mTag;
    }

    public final Fragment getTargetFragment()
    {
        return mTarget;
    }

    public final int getTargetRequestCode()
    {
        return mTargetRequestCode;
    }

    public final CharSequence getText(int i)
    {
        return getResources().getText(i);
    }

    public boolean getUserVisibleHint()
    {
        return mUserVisibleHint;
    }

    public View getView()
    {
        return mView;
    }

    public final boolean hasOptionsMenu()
    {
        return mHasMenu;
    }

    public final int hashCode()
    {
        return super.hashCode();
    }

    void initState()
    {
        mIndex = -1;
        mWho = null;
        mAdded = false;
        mRemoving = false;
        mResumed = false;
        mFromLayout = false;
        mInLayout = false;
        mRestored = false;
        mBackStackNesting = 0;
        mFragmentManager = null;
        mChildFragmentManager = null;
        mHost = null;
        mFragmentId = 0;
        mContainerId = 0;
        mTag = null;
        mHidden = false;
        mDetached = false;
        mRetaining = false;
        mLoaderManager = null;
        mLoadersStarted = false;
        mCheckedForLoaderManager = false;
    }

    void instantiateChildFragmentManager()
    {
        mChildFragmentManager = new ab();
        mChildFragmentManager.a(mHost, new q(this), this);
    }

    public final boolean isAdded()
    {
        return mHost != null && mAdded;
    }

    public final boolean isDetached()
    {
        return mDetached;
    }

    public final boolean isHidden()
    {
        return mHidden;
    }

    final boolean isInBackStack()
    {
        return mBackStackNesting > 0;
    }

    public final boolean isInLayout()
    {
        return mInLayout;
    }

    public final boolean isMenuVisible()
    {
        return mMenuVisible;
    }

    public final boolean isRemoving()
    {
        return mRemoving;
    }

    public final boolean isResumed()
    {
        return mResumed;
    }

    public final boolean isVisible()
    {
        return isAdded() && !isHidden() && mView != null && mView.getWindowToken() != null && mView.getVisibility() == 0;
    }

    public void onActivityCreated(Bundle bundle)
    {
        mCalled = true;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
    }

    public void onAttach(Activity activity)
    {
        mCalled = true;
    }

    public void onAttach(Context context)
    {
        mCalled = true;
        if (mHost == null)
        {
            context = null;
        } else
        {
            context = mHost.h();
        }
        if (context != null)
        {
            mCalled = false;
            onAttach(((Activity) (context)));
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        return false;
    }

    public void onCreate(Bundle bundle)
    {
        mCalled = true;
    }

    public Animation onCreateAnimation(int i, boolean flag, int j)
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
        mCalled = true;
        if (!mCheckedForLoaderManager)
        {
            mCheckedForLoaderManager = true;
            mLoaderManager = mHost.a(mWho, mLoadersStarted, false);
        }
        if (mLoaderManager != null)
        {
            mLoaderManager.g();
        }
    }

    public void onDestroyOptionsMenu()
    {
    }

    public void onDestroyView()
    {
        mCalled = true;
    }

    public void onDetach()
    {
        mCalled = true;
    }

    public void onHiddenChanged(boolean flag)
    {
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        mCalled = true;
    }

    public void onInflate(Context context, AttributeSet attributeset, Bundle bundle)
    {
        mCalled = true;
        if (mHost == null)
        {
            context = null;
        } else
        {
            context = mHost.h();
        }
        if (context != null)
        {
            mCalled = false;
            onInflate(((Activity) (context)), attributeset, bundle);
        }
    }

    public void onLowMemory()
    {
        mCalled = true;
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
        mCalled = true;
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
    }

    public void onRequestPermissionsResult(int i, String as[], int ai[])
    {
    }

    public void onResume()
    {
        mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
    }

    public void onStart()
    {
        mCalled = true;
        if (!mLoadersStarted)
        {
            mLoadersStarted = true;
            if (!mCheckedForLoaderManager)
            {
                mCheckedForLoaderManager = true;
                mLoaderManager = mHost.a(mWho, mLoadersStarted, false);
            }
            if (mLoaderManager != null)
            {
                mLoaderManager.b();
            }
        }
    }

    public void onStop()
    {
        mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle)
    {
    }

    public void onViewStateRestored(Bundle bundle)
    {
        mCalled = true;
    }

    void performActivityCreated(Bundle bundle)
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.k = false;
        }
        mCalled = false;
        onActivityCreated(bundle);
        if (!mCalled)
        {
            throw new cz((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onActivityCreated()").toString());
        }
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.i();
        }
    }

    void performConfigurationChanged(Configuration configuration)
    {
        onConfigurationChanged(configuration);
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.a(configuration);
        }
    }

    boolean performContextItemSelected(MenuItem menuitem)
    {
        while (!mHidden && (onContextItemSelected(menuitem) || mChildFragmentManager != null && mChildFragmentManager.b(menuitem))) 
        {
            return true;
        }
        return false;
    }

    void performCreate(Bundle bundle)
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.k = false;
        }
        mCalled = false;
        onCreate(bundle);
        if (!mCalled)
        {
            throw new cz((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onCreate()").toString());
        }
        if (bundle != null)
        {
            bundle = bundle.getParcelable("android:support:fragments");
            if (bundle != null)
            {
                if (mChildFragmentManager == null)
                {
                    instantiateChildFragmentManager();
                }
                mChildFragmentManager.a(bundle, null);
                mChildFragmentManager.h();
            }
        }
    }

    boolean performCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        if (!mHidden)
        {
            boolean flag = flag2;
            if (mHasMenu)
            {
                flag = flag2;
                if (mMenuVisible)
                {
                    flag = true;
                    onCreateOptionsMenu(menu, menuinflater);
                }
            }
            flag1 = flag;
            if (mChildFragmentManager != null)
            {
                flag1 = flag | mChildFragmentManager.a(menu, menuinflater);
            }
        }
        return flag1;
    }

    View performCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.k = false;
        }
        return onCreateView(layoutinflater, viewgroup, bundle);
    }

    void performDestroy()
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.m();
        }
        mCalled = false;
        onDestroy();
        if (!mCalled)
        {
            throw new cz((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onDestroy()").toString());
        } else
        {
            return;
        }
    }

    void performDestroyView()
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.a(1, false);
        }
        mCalled = false;
        onDestroyView();
        if (!mCalled)
        {
            throw new cz((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onDestroyView()").toString());
        }
        if (mLoaderManager != null)
        {
            mLoaderManager.e();
        }
    }

    void performLowMemory()
    {
        onLowMemory();
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.n();
        }
    }

    boolean performOptionsItemSelected(MenuItem menuitem)
    {
        while (!mHidden && (mHasMenu && mMenuVisible && onOptionsItemSelected(menuitem) || mChildFragmentManager != null && mChildFragmentManager.a(menuitem))) 
        {
            return true;
        }
        return false;
    }

    void performOptionsMenuClosed(Menu menu)
    {
        if (!mHidden)
        {
            if (mHasMenu && mMenuVisible)
            {
                onOptionsMenuClosed(menu);
            }
            if (mChildFragmentManager != null)
            {
                mChildFragmentManager.b(menu);
            }
        }
    }

    void performPause()
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.a(4, false);
        }
        mCalled = false;
        onPause();
        if (!mCalled)
        {
            throw new cz((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onPause()").toString());
        } else
        {
            return;
        }
    }

    boolean performPrepareOptionsMenu(Menu menu)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        if (!mHidden)
        {
            boolean flag = flag2;
            if (mHasMenu)
            {
                flag = flag2;
                if (mMenuVisible)
                {
                    flag = true;
                    onPrepareOptionsMenu(menu);
                }
            }
            flag1 = flag;
            if (mChildFragmentManager != null)
            {
                flag1 = flag | mChildFragmentManager.a(menu);
            }
        }
        return flag1;
    }

    void performReallyStop()
    {
label0:
        {
            if (mChildFragmentManager != null)
            {
                mChildFragmentManager.a(2, false);
            }
            if (mLoadersStarted)
            {
                mLoadersStarted = false;
                if (!mCheckedForLoaderManager)
                {
                    mCheckedForLoaderManager = true;
                    mLoaderManager = mHost.a(mWho, mLoadersStarted, false);
                }
                if (mLoaderManager != null)
                {
                    if (mRetaining)
                    {
                        break label0;
                    }
                    mLoaderManager.c();
                }
            }
            return;
        }
        mLoaderManager.d();
    }

    void performResume()
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.k = false;
            mChildFragmentManager.f();
        }
        mCalled = false;
        onResume();
        if (!mCalled)
        {
            throw new cz((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onResume()").toString());
        }
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.k();
            mChildFragmentManager.f();
        }
    }

    void performSaveInstanceState(Bundle bundle)
    {
        onSaveInstanceState(bundle);
        if (mChildFragmentManager != null)
        {
            android.os.Parcelable parcelable = mChildFragmentManager.g();
            if (parcelable != null)
            {
                bundle.putParcelable("android:support:fragments", parcelable);
            }
        }
    }

    void performStart()
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.k = false;
            mChildFragmentManager.f();
        }
        mCalled = false;
        onStart();
        if (!mCalled)
        {
            throw new cz((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onStart()").toString());
        }
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.j();
        }
        if (mLoaderManager != null)
        {
            mLoaderManager.f();
        }
    }

    void performStop()
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.l();
        }
        mCalled = false;
        onStop();
        if (!mCalled)
        {
            throw new cz((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onStop()").toString());
        } else
        {
            return;
        }
    }

    public void registerForContextMenu(View view)
    {
        view.setOnCreateContextMenuListener(this);
    }

    public final void requestPermissions(String as[], int i)
    {
        if (mHost == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            mHost.a(this, as, i);
            return;
        }
    }

    final void restoreViewState(Bundle bundle)
    {
        if (mSavedViewState != null)
        {
            mInnerView.restoreHierarchyState(mSavedViewState);
            mSavedViewState = null;
        }
        mCalled = false;
        onViewStateRestored(bundle);
        if (!mCalled)
        {
            throw new cz((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onViewStateRestored()").toString());
        } else
        {
            return;
        }
    }

    public void setAllowEnterTransitionOverlap(boolean flag)
    {
        mAllowEnterTransitionOverlap = Boolean.valueOf(flag);
    }

    public void setAllowReturnTransitionOverlap(boolean flag)
    {
        mAllowReturnTransitionOverlap = Boolean.valueOf(flag);
    }

    public void setArguments(Bundle bundle)
    {
        if (mIndex >= 0)
        {
            throw new IllegalStateException("Fragment already active");
        } else
        {
            mArguments = bundle;
            return;
        }
    }

    public void setEnterSharedElementCallback(cy cy)
    {
        mEnterTransitionCallback = cy;
    }

    public void setEnterTransition(Object obj)
    {
        mEnterTransition = obj;
    }

    public void setExitSharedElementCallback(cy cy)
    {
        mExitTransitionCallback = cy;
    }

    public void setExitTransition(Object obj)
    {
        mExitTransition = obj;
    }

    public void setHasOptionsMenu(boolean flag)
    {
        if (mHasMenu != flag)
        {
            mHasMenu = flag;
            if (isAdded() && !isHidden())
            {
                mHost.d();
            }
        }
    }

    final void setIndex(int i, Fragment fragment)
    {
        mIndex = i;
        if (fragment != null)
        {
            mWho = (new StringBuilder()).append(fragment.mWho).append(":").append(mIndex).toString();
            return;
        } else
        {
            mWho = (new StringBuilder("android:fragment:")).append(mIndex).toString();
            return;
        }
    }

    public void setInitialSavedState(SavedState savedstate)
    {
        if (mIndex >= 0)
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
        mSavedFragmentState = savedstate;
    }

    public void setMenuVisibility(boolean flag)
    {
        if (mMenuVisible != flag)
        {
            mMenuVisible = flag;
            if (mHasMenu && isAdded() && !isHidden())
            {
                mHost.d();
            }
        }
    }

    public void setReenterTransition(Object obj)
    {
        mReenterTransition = obj;
    }

    public void setRetainInstance(boolean flag)
    {
        if (flag && mParentFragment != null)
        {
            throw new IllegalStateException("Can't retain fragements that are nested in other fragments");
        } else
        {
            mRetainInstance = flag;
            return;
        }
    }

    public void setReturnTransition(Object obj)
    {
        mReturnTransition = obj;
    }

    public void setSharedElementEnterTransition(Object obj)
    {
        mSharedElementEnterTransition = obj;
    }

    public void setSharedElementReturnTransition(Object obj)
    {
        mSharedElementReturnTransition = obj;
    }

    public void setTargetFragment(Fragment fragment, int i)
    {
        mTarget = fragment;
        mTargetRequestCode = i;
    }

    public void setUserVisibleHint(boolean flag)
    {
        if (!mUserVisibleHint && flag && mState < 4)
        {
            mFragmentManager.b(this);
        }
        mUserVisibleHint = flag;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mDeferStart = flag;
    }

    public boolean shouldShowRequestPermissionRationale(String s)
    {
        if (mHost != null)
        {
            return mHost.a(s);
        } else
        {
            return false;
        }
    }

    public void startActivity(Intent intent)
    {
        if (mHost == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            mHost.a(this, intent, -1);
            return;
        }
    }

    public void startActivityForResult(Intent intent, int i)
    {
        if (mHost == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            mHost.a(this, intent, i);
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        a.a(this, stringbuilder);
        if (mIndex >= 0)
        {
            stringbuilder.append(" #");
            stringbuilder.append(mIndex);
        }
        if (mFragmentId != 0)
        {
            stringbuilder.append(" id=0x");
            stringbuilder.append(Integer.toHexString(mFragmentId));
        }
        if (mTag != null)
        {
            stringbuilder.append(" ");
            stringbuilder.append(mTag);
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    public void unregisterForContextMenu(View view)
    {
        view.setOnCreateContextMenuListener(null);
    }


    private class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new s();
        final Bundle a;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
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
        }
    }

}
