// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.google.a.a.e;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.target.mothership.util.o;
import com.target.ui.TargetApplication;
import com.target.ui.e.a;
import com.target.ui.e.b;
import com.target.ui.e.c;
import com.target.ui.e.d;
import com.target.ui.e.h;
import com.target.ui.fragment.cart.CartHomeFragment;
import com.target.ui.fragment.product.search.SearchOverlayDialogFragment;
import com.target.ui.fragment.shop.ShopHomeFragment;
import com.target.ui.util.deep_link.g;
import com.target.ui.util.f;
import com.target.ui.util.n;
import com.target.ui.util.q;
import com.target.ui.view.ToolbarSpinner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseNavigationFragment extends Fragment
    implements a, b, d, TraceFieldInterface
{

    private static final long ANALYTICS_POST_DELAY_MS = 15L;
    private static final String KEY_COACH_MARKS_ENABLED = "key_coach_marks_enabled";
    private static final String KEY_DRAWER_INDICATOR_ENABLED = "key_drawer_indicator_enabled";
    private static final String KEY_HAS_OPTIONS_MENU_OVERRIDE = "key_has_options_menu_override";
    private static final String KEY_SHOULD_SHOW_ACTION_BAR_DROP_SHADOW = "key_should_show_action_bar_drop_shadow";
    public static final String TAG = com/target/ui/fragment/common/BaseNavigationFragment.getSimpleName();
    private String mAnalyticsRunnableToken;
    private boolean mCoachMarksEnabled;
    private List mDelegates;
    private boolean mDrawerIndicatorEnabled;
    private b mDrawerToggleManager;
    private c mDropShadowViewHolder;
    private Handler mHandler;
    private int mHasOptionsMenuOverride;
    private d mNavigationFragmentManagerHolder;
    private boolean mOnSaveInstanceStateCalled;
    private com.target.ui.analytics.h mOnStartTimestamp;
    private com.target.ui.e.e mProgressOverlay;
    private com.h.a.b mRefWatcher;
    private boolean mShouldShowActionBarDropShadow;
    private h mToolbarChildViewHolder;

    public BaseNavigationFragment()
    {
        mCoachMarksEnabled = true;
        mDrawerIndicatorEnabled = false;
        mShouldShowActionBarDropShadow = true;
        mHandler = new Handler();
        mHasOptionsMenuOverride = 1;
        mDelegates = new ArrayList();
    }

    private void a(Menu menu)
    {
        menu = menu.findItem(0x7f100602);
        if (menu == null || menu.getActionView() == null)
        {
            return;
        } else
        {
            menu.getActionView().setOnClickListener(new android.view.View.OnClickListener() {

                final BaseNavigationFragment this$0;

                public void onClick(View view)
                {
                    a(CartHomeFragment.a());
                }

            
            {
                this$0 = BaseNavigationFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void g()
    {
        if (mToolbarChildViewHolder == null)
        {
            return;
        }
        mToolbarChildViewHolder.n().setListener(null);
        if (T() == null)
        {
            q.a(TAG, "Action bar unexpected null; can not change navigation mode");
            return;
        }
        if (aa())
        {
            mToolbarChildViewHolder.k().setVisibility(8);
            ToolbarSpinner toolbarspinner = mToolbarChildViewHolder.n();
            toolbarspinner.setVisibility(0);
            a(toolbarspinner);
            return;
        } else
        {
            mToolbarChildViewHolder.k().setVisibility(0);
            mToolbarChildViewHolder.n().setVisibility(8);
            return;
        }
    }

    private void i()
    {
        if (!mCoachMarksEnabled)
        {
            return;
        }
        android.support.v4.app.f f1 = getActivity();
        android.support.v4.app.h h1 = getFragmentManager();
        boolean flag;
        if (!mDrawerIndicatorEnabled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(f1, h1, flag);
    }

    private void j()
    {
        if (mDropShadowViewHolder == null)
        {
            return;
        }
        View view = mDropShadowViewHolder.l();
        int i1;
        if (mShouldShowActionBarDropShadow)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
    }

    private void k()
    {
        final TextView customTitle = mToolbarChildViewHolder.k();
        customTitle.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseNavigationFragment this$0;
            final TextView val$customTitle;

            public void onClick(View view)
            {
                k(customTitle.getText().toString());
            }

            
            {
                this$0 = BaseNavigationFragment.this;
                customTitle = textview;
                super();
            }
        });
        o();
    }

    private void o()
    {
        TextView textview = mToolbarChildViewHolder.k();
        boolean flag = com.target.mothership.util.o.d(textview.getText().toString());
        if (X() && flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        textview.setClickable(flag);
    }

    public boolean R()
    {
        return false;
    }

    protected void S()
    {
        m().b(ShopHomeFragment.a());
    }

    public android.support.v7.app.a T()
    {
        if (getActivity() == null)
        {
            q.a(TAG, "Activity unexpectedly null when trying to get the action bar");
            return null;
        } else
        {
            return ((android.support.v7.app.f)getActivity()).g();
        }
    }

    public final int U()
    {
        return mHasOptionsMenuOverride;
    }

    protected com.target.ui.analytics.h V()
    {
        return mOnStartTimestamp;
    }

    public e W()
    {
        return e.e();
    }

    protected boolean X()
    {
        return false;
    }

    protected final void Y()
    {
        k(null);
    }

    public final boolean Z()
    {
        return mOnSaveInstanceStateCalled;
    }

    protected long a(com.target.ui.analytics.h h1)
    {
        return com.target.ui.analytics.h.a(h1);
    }

    public void a(Bitmap bitmap, String s)
    {
    }

    protected void a(Uri uri)
    {
        if (!com.target.ui.util.deep_link.g.a(getActivity()))
        {
            uri = new Intent();
            uri.setAction("android.intent.action.VIEW");
            uri.setData(com.target.ui.util.deep_link.g.a());
            startActivity(uri);
            return;
        } else
        {
            uri = com.target.ui.util.deep_link.g.a(uri);
            com.target.ui.util.n.a(getActivity(), uri, com.target.ui.util.deep_link.g.b());
            return;
        }
    }

    protected void a(Uri uri, String s)
    {
        if (com.target.ui.util.deep_link.g.b(uri))
        {
            a(uri);
            return;
        } else
        {
            com.target.ui.util.n.a(getActivity(), uri, s);
            return;
        }
    }

    protected void a(Fragment fragment)
    {
        a(fragment, null);
    }

    protected void a(Fragment fragment, String s)
    {
        com.target.ui.f.c c1 = m();
        S();
        if (s == null)
        {
            c1.e(fragment);
            return;
        } else
        {
            c1.c(fragment, s);
            return;
        }
    }

    protected void a(com.target.ui.c.a a1)
    {
        mDelegates.add(a1);
    }

    protected void a(ToolbarSpinner toolbarspinner)
    {
    }

    protected void a(Runnable runnable)
    {
        mHandler.postAtTime(runnable, mAnalyticsRunnableToken, SystemClock.uptimeMillis() + 15L);
    }

    protected transient void a(com.target.ui.c.a aa1[])
    {
        int j1 = aa1.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            a(aa1[i1]);
        }

    }

    public boolean a(com.target.ui.e.e e1)
    {
        return false;
    }

    protected boolean aa()
    {
        return false;
    }

    public void b(boolean flag)
    {
        if (mDrawerToggleManager == null)
        {
            return;
        } else
        {
            mDrawerToggleManager.b(flag);
            mDrawerIndicatorEnabled = flag;
            return;
        }
    }

    public final void h(int i1)
    {
        mHasOptionsMenuOverride = i1;
    }

    protected void j(String s)
    {
        mToolbarChildViewHolder.k().setText(s);
        o();
    }

    protected final void k(String s)
    {
        SearchOverlayDialogFragment.a(s, this).show(getFragmentManager(), SearchOverlayDialogFragment.TAG);
    }

    protected void l(String s)
    {
        a(Uri.parse(s));
    }

    public com.target.ui.f.c m()
    {
        if (mNavigationFragmentManagerHolder == null)
        {
            return null;
        } else
        {
            return mNavigationFragmentManagerHolder.m();
        }
    }

    public void m(boolean flag)
    {
        mCoachMarksEnabled = flag;
    }

    public void n(boolean flag)
    {
        mShouldShowActionBarDropShadow = flag;
    }

    protected final void o(boolean flag)
    {
        if (mProgressOverlay == null)
        {
            return;
        } else
        {
            mProgressOverlay.c(flag);
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            mDrawerToggleManager = (b)getActivity();
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new ClassCastException((new StringBuilder()).append(getActivity().toString()).append(" must implement DrawerToggleManager").toString());
        }
        try
        {
            mDropShadowViewHolder = (c)getActivity();
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new ClassCastException((new StringBuilder()).append(getActivity().toString()).append(" must implement DropShadowViewHolder").toString());
        }
        try
        {
            mNavigationFragmentManagerHolder = (d)getActivity();
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new ClassCastException((new StringBuilder()).append(getActivity().toString()).append(" must implement NavigationFragmentManagerHolder").toString());
        }
        try
        {
            mToolbarChildViewHolder = (h)getActivity();
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new ClassCastException((new StringBuilder()).append(getActivity().toString()).append(" must implement ToolbarChildViewHolder").toString());
        }
        try
        {
            mProgressOverlay = (com.target.ui.e.e)getActivity();
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new ClassCastException((new StringBuilder()).append(getActivity().toString()).append(" must implement ProgressOverlay").toString());
        }
        mRefWatcher = TargetApplication.a(activity);
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("BaseNavigationFragment");
        TraceMachine.enterMethod(_nr_trace, "BaseNavigationFragment#onCreate", null);
_L1:
        super.onCreate(bundle);
        if (bundle != null)
        {
            mCoachMarksEnabled = bundle.getBoolean("key_coach_marks_enabled");
            mDrawerIndicatorEnabled = bundle.getBoolean("key_drawer_indicator_enabled");
            mHasOptionsMenuOverride = bundle.getInt("key_has_options_menu_override");
            mShouldShowActionBarDropShadow = bundle.getBoolean("key_should_show_action_bar_drop_shadow");
        }
        mAnalyticsRunnableToken = String.format("%s : %s", new Object[] {
            TAG, String.valueOf(hashCode())
        });
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "BaseNavigationFragment#onCreate", null);
          goto _L1
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            b(mDrawerIndicatorEnabled);
            k();
            g();
            a(menu);
            i();
            j();
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        mRefWatcher.a(this);
        for (Iterator iterator = mDelegates.iterator(); iterator.hasNext(); ((com.target.ui.c.a)iterator.next()).g()) { }
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        for (Iterator iterator = mDelegates.iterator(); iterator.hasNext(); ((com.target.ui.c.a)iterator.next()).h()) { }
    }

    public void onDetach()
    {
        super.onDetach();
        com.target.ui.util.e.a.a(this);
        mDrawerToggleManager = null;
        mDropShadowViewHolder = null;
        mNavigationFragmentManagerHolder = null;
        mToolbarChildViewHolder = null;
        for (Iterator iterator = mDelegates.iterator(); iterator.hasNext(); ((com.target.ui.c.a)iterator.next()).i()) { }
        mDelegates.clear();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 2: default 32
    //                   16908332: 38
    //                   2131756543: 83;
           goto _L1 _L2 _L3
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        if (!mDrawerIndicatorEnabled)
        {
            com.target.ui.util.e.a.a(this);
            if (getActivity().f().e() == 0)
            {
                m().a(ShopHomeFragment.a());
                return true;
            } else
            {
                getActivity().onBackPressed();
                return true;
            }
        }
          goto _L1
_L3:
        Y();
        return true;
    }

    public void onPause()
    {
        super.onPause();
        mHandler.removeCallbacksAndMessages(mAnalyticsRunnableToken);
    }

    public void onResume()
    {
        super.onResume();
        mOnSaveInstanceStateCalled = false;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        mOnSaveInstanceStateCalled = true;
        bundle.putBoolean("key_coach_marks_enabled", mCoachMarksEnabled);
        bundle.putBoolean("key_drawer_indicator_enabled", mDrawerIndicatorEnabled);
        bundle.putInt("key_has_options_menu_override", mHasOptionsMenuOverride);
        bundle.putBoolean("key_should_show_action_bar_drop_shadow", mShouldShowActionBarDropShadow);
        super.onSaveInstanceState(bundle);
    }

    public void onStart()
    {
        ApplicationStateMonitor.getInstance().activityStarted();
        mOnStartTimestamp = new com.target.ui.analytics.h();
        super.onStart();
    }

    public void onStop()
    {
        ApplicationStateMonitor.getInstance().activityStopped();
        mOnStartTimestamp.a();
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        for (view = mDelegates.iterator(); view.hasNext(); ((com.target.ui.c.a)view.next()).f()) { }
    }

    public void setHasOptionsMenu(boolean flag)
    {
        mHasOptionsMenuOverride;
        JVM INSTR tableswitch 2 3: default 28
    //                   2 34
    //                   3 39;
           goto _L1 _L2 _L3
_L1:
        super.setHasOptionsMenu(flag);
        return;
_L2:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L3:
        flag = true;
        if (true) goto _L1; else goto _L4
_L4:
    }

}
