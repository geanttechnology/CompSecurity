// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v4.app:
//            Fragment, FragmentManager, FragmentTransaction

public abstract class FragmentStatePagerAdapter extends PagerAdapter
{

    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapter";
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private final FragmentManager mFragmentManager;
    private ArrayList mFragments;
    private ArrayList mSavedState;

    public FragmentStatePagerAdapter(FragmentManager fragmentmanager)
    {
        mCurTransaction = null;
        mSavedState = new ArrayList();
        mFragments = new ArrayList();
        mCurrentPrimaryItem = null;
        mFragmentManager = fragmentmanager;
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup = (Fragment)obj;
        if (mCurTransaction == null)
        {
            mCurTransaction = mFragmentManager.beginTransaction();
        }
        do
        {
            if (mSavedState.size() > i)
            {
                mSavedState.set(i, mFragmentManager.saveFragmentInstanceState(viewgroup));
                mFragments.set(i, null);
                mCurTransaction.remove(viewgroup);
                return;
            }
            mSavedState.add(null);
        } while (true);
    }

    public void finishUpdate(ViewGroup viewgroup)
    {
        if (mCurTransaction != null)
        {
            mCurTransaction.commitAllowingStateLoss();
            mCurTransaction = null;
            mFragmentManager.executePendingTransactions();
        }
    }

    public abstract Fragment getItem(int i);

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        if (mFragments.size() > i)
        {
            Fragment fragment = (Fragment)mFragments.get(i);
            if (fragment != null)
            {
                return fragment;
            }
        }
        if (mCurTransaction == null)
        {
            mCurTransaction = mFragmentManager.beginTransaction();
        }
        Fragment fragment1 = getItem(i);
        if (mSavedState.size() > i)
        {
            Fragment.SavedState savedstate = (Fragment.SavedState)mSavedState.get(i);
            if (savedstate != null)
            {
                fragment1.setInitialSavedState(savedstate);
            }
        }
        do
        {
            if (mFragments.size() > i)
            {
                fragment1.setMenuVisibility(false);
                fragment1.setUserVisibleHint(false);
                mFragments.set(i, fragment1);
                mCurTransaction.add(viewgroup.getId(), fragment1);
                return fragment1;
            }
            mFragments.add(null);
        } while (true);
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return ((Fragment)obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classloader)
    {
        if (parcelable == null) goto _L2; else goto _L1
_L1:
        parcelable = (Bundle)parcelable;
        parcelable.setClassLoader(classloader);
        classloader = parcelable.getParcelableArray("states");
        mSavedState.clear();
        mFragments.clear();
        if (classloader == null) goto _L4; else goto _L3
_L3:
        int i = 0;
_L7:
        if (i < classloader.length) goto _L5; else goto _L4
_L4:
        classloader = parcelable.keySet().iterator();
_L8:
        if (classloader.hasNext()) goto _L6; else goto _L2
_L2:
        return;
_L5:
        mSavedState.add((Fragment.SavedState)classloader[i]);
        i++;
          goto _L7
_L6:
        String s;
label0:
        {
            s = (String)classloader.next();
            if (s.startsWith("f"))
            {
label1:
                {
                    int j = Integer.parseInt(s.substring(1));
                    Fragment fragment = mFragmentManager.getFragment(parcelable, s);
                    if (fragment == null)
                    {
                        break label0;
                    }
                    for (; mFragments.size() <= j; mFragments.add(null))
                    {
                        break label1;
                    }

                    fragment.setMenuVisibility(false);
                    mFragments.set(j, fragment);
                }
            }
        }
          goto _L8
        Log.w("FragmentStatePagerAdapter", (new StringBuilder("Bad fragment at key ")).append(s).toString());
          goto _L8
    }

    public Parcelable saveState()
    {
        Object obj = null;
        if (mSavedState.size() > 0)
        {
            obj = new Bundle();
            Fragment.SavedState asavedstate[] = new Fragment.SavedState[mSavedState.size()];
            mSavedState.toArray(asavedstate);
            ((Bundle) (obj)).putParcelableArray("states", asavedstate);
        }
        int i = 0;
        do
        {
            if (i >= mFragments.size())
            {
                return ((Parcelable) (obj));
            }
            Fragment fragment = (Fragment)mFragments.get(i);
            Bundle bundle = ((Bundle) (obj));
            if (fragment != null)
            {
                bundle = ((Bundle) (obj));
                if (obj == null)
                {
                    bundle = new Bundle();
                }
                obj = (new StringBuilder("f")).append(i).toString();
                mFragmentManager.putFragment(bundle, ((String) (obj)), fragment);
            }
            i++;
            obj = bundle;
        } while (true);
    }

    public void setPrimaryItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup = (Fragment)obj;
        if (viewgroup != mCurrentPrimaryItem)
        {
            if (mCurrentPrimaryItem != null)
            {
                mCurrentPrimaryItem.setMenuVisibility(false);
                mCurrentPrimaryItem.setUserVisibleHint(false);
            }
            if (viewgroup != null)
            {
                viewgroup.setMenuVisibility(true);
                viewgroup.setUserVisibleHint(true);
            }
            mCurrentPrimaryItem = viewgroup;
        }
    }

    public void startUpdate(ViewGroup viewgroup)
    {
    }
}
