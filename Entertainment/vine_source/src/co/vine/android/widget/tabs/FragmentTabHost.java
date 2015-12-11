// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget.tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import co.vine.android.util.CrashUtil;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android.widget.tabs:
//            DummyTabFactory, TabInfo

public class FragmentTabHost extends TabHost
    implements android.widget.TabHost.OnTabChangeListener
{
    static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        String curTab;

        public String toString()
        {
            return (new StringBuilder()).append("FragmentTabHost.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" curTab=").append(curTab).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeString(curTab);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            curTab = parcel.readString();
        }


        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    static class TabInfo extends co.vine.android.widget.tabs.TabInfo
    {

        private Fragment fragment;



/*
        static Fragment access$102(TabInfo tabinfo, Fragment fragment1)
        {
            tabinfo.fragment = fragment1;
            return fragment1;
        }

*/

        TabInfo(String s, Class class1, Bundle bundle)
        {
            super(class1, bundle, s);
        }
    }


    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private TabInfo mLastTab;
    private android.widget.TabHost.OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private final ArrayList mTabs;

    public FragmentTabHost(Context context)
    {
        super(context, null);
        mTabs = new ArrayList();
        initFragmentTabHost(context, null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mTabs = new ArrayList();
        initFragmentTabHost(context, attributeset);
    }

    private FragmentTransaction doTabChanged(String s, FragmentTransaction fragmenttransaction)
    {
        String s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = "users";
        }
        String s2 = null;
        Iterator iterator = mTabs.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            s = (TabInfo)iterator.next();
            if (((TabInfo) (s)).mTag.equals(s1))
            {
                s2 = s;
            }
        } while (true);
        if (s2 == null)
        {
            CrashUtil.logException(new IllegalStateException((new StringBuilder()).append("No tab known for tag ").append(s1).toString()));
            return fragmenttransaction;
        }
        s = fragmenttransaction;
        if (mLastTab != s2)
        {
            s = fragmenttransaction;
            if (fragmenttransaction == null)
            {
                s = mFragmentManager.beginTransaction();
            }
            if (mLastTab != null && mLastTab.fragment != null)
            {
                s.detach(mLastTab.fragment);
            }
            if (((TabInfo) (s2)).fragment == null)
            {
                s2.fragment = Fragment.instantiate(mContext, ((TabInfo) (s2)).clss.getName(), ((TabInfo) (s2)).bundle);
                s.add(mContainerId, ((TabInfo) (s2)).fragment, ((TabInfo) (s2)).mTag);
            } else
            {
                s.attach(((TabInfo) (s2)).fragment);
            }
            mLastTab = s2;
        }
        return s;
    }

    private void ensureContent()
    {
        if (mRealTabContent == null)
        {
            mRealTabContent = (FrameLayout)findViewById(mContainerId);
            if (mRealTabContent == null)
            {
                throw new IllegalStateException((new StringBuilder()).append("No tab content FrameLayout found for id ").append(mContainerId).toString());
            }
        }
    }

    private void initFragmentTabHost(Context context, AttributeSet attributeset)
    {
        attributeset = context.obtainStyledAttributes(attributeset, new int[] {
            0x10100f3
        }, 0, 0);
        if (attributeset != null)
        {
            mContainerId = attributeset.getResourceId(0, 0);
            attributeset.recycle();
        }
        super.setOnTabChangedListener(this);
        if (findViewById(0x1020013) == null)
        {
            attributeset = new LinearLayout(context);
            attributeset.setOrientation(1);
            addView(attributeset, new android.widget.FrameLayout.LayoutParams(-1, -1));
            Object obj = new TabWidget(context);
            ((TabWidget) (obj)).setId(0x1020013);
            ((TabWidget) (obj)).setOrientation(0);
            attributeset.addView(((android.view.View) (obj)), new android.widget.LinearLayout.LayoutParams(-1, -2, 0.0F));
            obj = new FrameLayout(context);
            ((FrameLayout) (obj)).setId(0x1020011);
            attributeset.addView(((android.view.View) (obj)), new android.widget.LinearLayout.LayoutParams(0, 0, 0.0F));
            context = new FrameLayout(context);
            mRealTabContent = context;
            mRealTabContent.setId(mContainerId);
            attributeset.addView(context, new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0F));
        }
    }

    public void addTab(android.widget.TabHost.TabSpec tabspec, Class class1, Bundle bundle)
    {
        tabspec.setContent(new DummyTabFactory(mContext));
        String s = tabspec.getTag();
        class1 = new TabInfo(s, class1, bundle);
        if (mAttached)
        {
            class1.fragment = mFragmentManager.findFragmentByTag(s);
            if (((TabInfo) (class1)).fragment != null && !((TabInfo) (class1)).fragment.isDetached())
            {
                bundle = mFragmentManager.beginTransaction();
                bundle.detach(((TabInfo) (class1)).fragment);
                bundle.commit();
            }
        }
        mTabs.add(class1);
        addTab(tabspec);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        String s = getCurrentTabTag();
        FragmentTransaction fragmenttransaction = null;
        Iterator iterator = mTabs.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            TabInfo tabinfo = (TabInfo)iterator.next();
            tabinfo.fragment = mFragmentManager.findFragmentByTag(tabinfo.mTag);
            if (tabinfo.fragment != null && !tabinfo.fragment.isDetached())
            {
                if (tabinfo.mTag.equals(s))
                {
                    mLastTab = tabinfo;
                } else
                {
                    FragmentTransaction fragmenttransaction1 = fragmenttransaction;
                    if (fragmenttransaction == null)
                    {
                        fragmenttransaction1 = mFragmentManager.beginTransaction();
                    }
                    fragmenttransaction1.detach(tabinfo.fragment);
                    fragmenttransaction = fragmenttransaction1;
                }
            }
        } while (true);
        mAttached = true;
        fragmenttransaction = doTabChanged(s, fragmenttransaction);
        if (fragmenttransaction != null)
        {
            fragmenttransaction.commitAllowingStateLoss();
            mFragmentManager.executePendingTransactions();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mAttached = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        setCurrentTabByTag(((SavedState) (parcelable)).curTab);
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.curTab = getCurrentTabTag();
        return savedstate;
    }

    public void onTabChanged(String s)
    {
        if (mAttached)
        {
            FragmentTransaction fragmenttransaction = doTabChanged(s, null);
            if (fragmenttransaction != null)
            {
                fragmenttransaction.commitAllowingStateLoss();
            }
        }
        if (mOnTabChangeListener != null)
        {
            mOnTabChangeListener.onTabChanged(s);
        }
    }

    public void setOnTabChangedListener(android.widget.TabHost.OnTabChangeListener ontabchangelistener)
    {
        mOnTabChangeListener = ontabchangelistener;
    }

    public void setup()
    {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setup(Context context, FragmentManager fragmentmanager)
    {
        super.setup();
        mContext = context;
        mFragmentManager = fragmentmanager;
        ensureContent();
    }

    public void setup(Context context, FragmentManager fragmentmanager, int i)
    {
        super.setup();
        mContext = context;
        mFragmentManager = fragmentmanager;
        mContainerId = i;
        ensureContent();
        mRealTabContent.setId(i);
        if (getId() == -1)
        {
            setId(0x1020012);
        }
    }
}
