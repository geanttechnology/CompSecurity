// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.MuteUtil;
import co.vine.android.util.SystemUtil;
import co.vine.android.widget.FakeActionBar;
import co.vine.android.widget.Typefaces;
import com.android.debug.hv.ViewServer;
import com.edisonwang.android.slog.SLog;
import com.jeremyfeinstein.slidingmenu.lib.SlidingActivityHelper;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

// Referenced classes of package co.vine.android:
//            StartActivity, AppImpl, HomeTabActivity, Settings

public abstract class BaseActionBarActivity extends ActionBarActivity
    implements com.jeremyfeinstein.slidingmenu.lib.SlidingActivityHelper.MenuStateHandler.MenuStateListener
{

    public static final int COLOR_TRANSITION_DURATION = 100;
    public static final String FINISH_BROADCAST_ACTION = "co.vine.android.FINISH";
    private static IntentFilter FINISH_INTENT_FILTER;
    private static final String TAG = "BaseActionBarActivity";
    private static int mDebugMenuSecrets[] = {
        24, 25, 24, 25
    };
    private int mDebugMenu;
    private FakeActionBar mFakeActionBar;
    private final BroadcastReceiver mFinishReceiver = new BroadcastReceiver() {

        final BaseActionBarActivity this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (intent != null && "co.vine.android.FINISH".equals(intent.getAction()))
            {
                finish();
            }
        }

            
            {
                this$0 = BaseActionBarActivity.this;
                super();
            }
    };
    protected Menu mMenu;
    protected ProgressDialog mProgressDialog;
    private SlidingActivityHelper mSlidingMenuHelper;
    private int mVineGreen;

    public BaseActionBarActivity()
    {
        mDebugMenu = 0;
    }

    private void setupActionBarJBOnly(Boolean boolean1, Boolean boolean2, Boolean boolean3)
    {
        ActionBar actionbar = getActionBar();
        if (actionbar != null)
        {
            if (boolean1 != null)
            {
                actionbar.setHomeButtonEnabled(boolean1.booleanValue());
            }
            if (boolean2 != null)
            {
                actionbar.setDisplayShowTitleEnabled(boolean2.booleanValue());
            }
            if (boolean3 != null)
            {
                actionbar.setDisplayHomeAsUpEnabled(boolean3.booleanValue());
            }
        }
    }

    protected void applyDefaultTitleViewStylingToFakeActionBar()
    {
        Resources resources = getResources();
        FakeActionBar fakeactionbar = getFakeActionBar();
        fakeactionbar.getTitleView().setTextColor(resources.getColor(0x7f090061));
        fakeactionbar.getTitleView().setTypeface(Typefaces.get(this).mediumContent);
        fakeactionbar.getTitleView().setTextSize(0, resources.getDimensionPixelSize(0x7f0b0046));
    }

    protected SlidingActivityHelper createSlidingMenuHelper()
    {
        return new SlidingActivityHelper(this);
    }

    protected void dismissDialog()
    {
        if (mProgressDialog != null)
        {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    public View findViewById(int i)
    {
        View view = super.findViewById(i);
        if (view != null)
        {
            return view;
        }
        if (mSlidingMenuHelper != null)
        {
            return mSlidingMenuHelper.findViewById(i);
        } else
        {
            return null;
        }
    }

    public FakeActionBar getFakeActionBar()
    {
        return mFakeActionBar;
    }

    public SlidingMenu getSlidingMenu()
    {
        if (mSlidingMenuHelper != null)
        {
            return mSlidingMenuHelper.getSlidingMenu();
        } else
        {
            return null;
        }
    }

    public SlidingActivityHelper getSlidingMenuHelper()
    {
        return mSlidingMenuHelper;
    }

    public boolean isFakeActionBarEnabled()
    {
        return false;
    }

    protected boolean isSlidingMenuEnabled()
    {
        return false;
    }

    public void onBackPressed()
    {
        try
        {
            super.onBackPressed();
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            CrashUtil.logException(illegalstateexception);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        throw new IllegalArgumentException("If extending BaseActivity, please use multiple parameter version of this method.");
    }

    public void onCreate(Bundle bundle, int i, boolean flag, boolean flag1)
    {
        boolean flag2 = true;
        try
        {
            super.onCreate(bundle);
        }
        catch (AndroidRuntimeException androidruntimeexception)
        {
            CrashUtil.logException(androidruntimeexception);
        }
        if (isFakeActionBarEnabled())
        {
            mFakeActionBar = new FakeActionBar(this);
            mFakeActionBar.onCreate();
            requestWindowFeature(1);
        }
        mVineGreen = getResources().getColor(0x7f090096);
        if (isSlidingMenuEnabled())
        {
            SLog.i("Sliding menu is enabled.");
            mSlidingMenuHelper = createSlidingMenuHelper();
            mSlidingMenuHelper.onCreate(bundle);
            mSlidingMenuHelper.setMenuStateListener(this);
        }
        preSetContentView();
        setContentView(i);
        bundle = getParent();
        if (flag && !VineAccountHelper.isLoggedIn(this, flag1))
        {
            i = ((flag2) ? 1 : 0);
        } else
        {
            i = 0;
        }
        if (i != 0 && bundle == null)
        {
            StartActivity.toStart(this);
        }
        if (SystemUtil.isViewServerEnabled(this))
        {
            ViewServer.get(this).addWindow(this);
        }
        registerReceiver(mFinishReceiver, FINISH_INTENT_FILTER, "co.vine.android.BROADCAST", null);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        updateMuteActionState(menu.findItem(0x7f0a0240));
        mMenu = menu;
        if (mFakeActionBar != null)
        {
            mFakeActionBar.onCreateOptionsMenu(mMenu, true);
        }
        return true;
    }

    public boolean onCreatePanelMenu(int i, Menu menu)
    {
        boolean flag;
        try
        {
            flag = super.onCreatePanelMenu(i, menu);
        }
        // Misplaced declaration of an exception variable
        catch (Menu menu)
        {
            CrashUtil.logException(menu);
            return false;
        }
        return flag;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (SystemUtil.isViewServerEnabled(this))
        {
            ViewServer.get(this).removeWindow(this);
        }
        unregisterReceiver(mFinishReceiver);
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (mSlidingMenuHelper != null && mSlidingMenuHelper.onKeyUp(i, keyevent))
        {
            return true;
        }
        if (SLog.sLogsOn && mDebugMenu < mDebugMenuSecrets.length && i == mDebugMenuSecrets[mDebugMenu])
        {
            mDebugMenu = mDebugMenu + 1;
            if (mDebugMenu == mDebugMenuSecrets.length)
            {
                sendBroadcast(new Intent("co.vine.android.debug_receiver"));
            }
        }
        return super.onKeyUp(i, keyevent);
    }

    public void onMenuClick(View view)
    {
    }

    public void onMenuClose()
    {
    }

    public void onMenuClosed()
    {
    }

    public boolean onMenuDrag(View view, DragEvent dragevent)
    {
        return false;
    }

    public void onMenuOpen()
    {
    }

    public void onMenuOpened()
    {
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            if (mSlidingMenuHelper != null)
            {
                mSlidingMenuHelper.toggle();
                return true;
            }
            try
            {
                super.onBackPressed();
            }
            // Misplaced declaration of an exception variable
            catch (MenuItem menuitem)
            {
                return true;
            }
            return true;

        case 2131362364: 
            AppImpl.getInstance().startCapture(this);
            return true;

        case 2131362368: 
            break;
        }
        boolean flag;
        if (!MuteUtil.isMuted(this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        MuteUtil.setMuted(this, flag);
        updateMuteActionState(menuitem);
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        dismissDialog();
    }

    public void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        if (mFakeActionBar != null)
        {
            mFakeActionBar.onPostCreate(bundle);
            applyDefaultTitleViewStylingToFakeActionBar();
        }
        if (mSlidingMenuHelper != null)
        {
            mSlidingMenuHelper.onPostCreate(bundle);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        boolean flag = super.onPrepareOptionsMenu(menu);
        if (mFakeActionBar != null)
        {
            mFakeActionBar.onPrepareOptionsMenu(menu, flag);
        }
        return flag;
    }

    protected void onResume()
    {
        super.onResume();
        if (getSlidingMenu() == null || !getSlidingMenu().isMenuShowing()) goto _L2; else goto _L1
_L1:
        sendBroadcast(new Intent(MuteUtil.ACTION_CHANGED_TO_MUTE), "co.vine.android.BROADCAST");
_L4:
        CrashUtil.set("Activity", (new StringBuilder()).append(getClass().getName()).append(" - ").append(System.currentTimeMillis()).toString());
        if (BuildUtil.isLogsOn() && SystemUtil.isViewServerEnabled(this))
        {
            ViewServer.get(this).setFocusedWindow(this);
        }
        if (mMenu != null)
        {
            updateMuteActionState(mMenu.findItem(0x7f0a0240));
        }
        registerReceiver(mFinishReceiver, FINISH_INTENT_FILTER, "co.vine.android.BROADCAST", null);
        return;
_L2:
        if (!MuteUtil.isMuted(this))
        {
            sendBroadcast(new Intent(MuteUtil.ACTION_CHANGED_TO_UNMUTE), "co.vine.android.BROADCAST");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (mSlidingMenuHelper != null)
        {
            mSlidingMenuHelper.onSaveInstanceState(bundle);
        }
    }

    protected void onStart()
    {
        super.onStart();
        FlurryUtils.start(this);
    }

    protected void onStop()
    {
        super.onStop();
        FlurryUtils.stop(this);
    }

    public void preSetContentView()
    {
    }

    protected void restoreActivityState()
    {
        if (BuildUtil.isLogsOn())
        {
            Log.d("BaseActionBarActivity", (new StringBuilder()).append("Restoring activity ").append(getClass().getName()).toString());
        }
    }

    public void setActionBarColor()
    {
        setActionBarColor(mVineGreen);
    }

    public void setActionBarColor(int i)
    {
        if (i == 0) goto _L2; else goto _L1
_L1:
        if (mFakeActionBar != null)
        {
            mFakeActionBar.setActionBarColor(i | 0xff000000);
            mFakeActionBar.getActionBar().invalidate();
        } else
        {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(i | 0xff000000));
        }
        if (this instanceof HomeTabActivity)
        {
            if (i == Settings.DEFAULT_PROFILE_COLOR || i <= 0 || i == (Settings.DEFAULT_PROFILE_COLOR | 0xff000000))
            {
                ((HomeTabActivity)this).setProfileColor(getResources().getColor(0x7f090096));
            } else
            {
                ((HomeTabActivity)this).setProfileColor(i | 0xff000000);
            }
        }
_L4:
        invalidateOptionsMenu();
        return;
_L2:
        if (mVineGreen != 0)
        {
            setActionBarColor(mVineGreen);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setActionBarTransition(TransitionDrawable transitiondrawable)
    {
        if (mFakeActionBar != null)
        {
            mFakeActionBar.setActionBarTransition(transitiondrawable);
        } else
        {
            getSupportActionBar().setBackgroundDrawable(transitiondrawable);
        }
        transitiondrawable.startTransition(100);
    }

    public View setBehindContentView(int i)
    {
        View view = getLayoutInflater().inflate(i, null);
        setBehindContentView(view);
        return view;
    }

    public View setBehindContentView(View view)
    {
        setBehindContentView(view, new android.view.ViewGroup.LayoutParams(-1, -1));
        return view;
    }

    public View setBehindContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        mSlidingMenuHelper.setBehindContentView(view, layoutparams);
        return view;
    }

    public void setContentView(int i)
    {
        if (mSlidingMenuHelper != null || mFakeActionBar != null)
        {
            setContentView(getLayoutInflater().inflate(i, null));
            return;
        } else
        {
            super.setContentView(i);
            return;
        }
    }

    public void setContentView(View view)
    {
        if (mSlidingMenuHelper != null || mFakeActionBar != null)
        {
            setContentView(view, new android.view.ViewGroup.LayoutParams(-1, -1));
            return;
        } else
        {
            super.setContentView(view);
            return;
        }
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        Object obj = view;
        if (mFakeActionBar != null)
        {
            mFakeActionBar.setContentView(view, layoutparams);
            obj = mFakeActionBar.getRoot();
        }
        super.setContentView(((View) (obj)), layoutparams);
        if (mSlidingMenuHelper != null)
        {
            mSlidingMenuHelper.registerAboveContentView(((View) (obj)), layoutparams);
        }
    }

    protected void setupActionBar(Boolean boolean1, Boolean boolean2, int i, Boolean boolean3)
    {
        String s;
        if (i > 0)
        {
            s = getString(i);
        } else
        {
            s = null;
        }
        setupActionBar(boolean1, boolean2, s, boolean3);
    }

    protected void setupActionBar(Boolean boolean1, Boolean boolean2, String s, Boolean boolean3)
    {
        if (mFakeActionBar != null)
        {
            if (boolean1 != null)
            {
                mFakeActionBar.setHomeButtonEnabled(boolean1);
            }
            if (boolean2 != null)
            {
                mFakeActionBar.setDisplayShowTitleEnabled(boolean2);
            }
            if (boolean3 != null)
            {
                mFakeActionBar.setDisplayHomeAsUpEnabled(boolean3);
            }
            if (!TextUtils.isEmpty(s))
            {
                mFakeActionBar.setTitle(s);
            }
        } else
        {
            android.support.v7.app.ActionBar actionbar = getSupportActionBar();
            if (actionbar != null)
            {
                if (boolean1 != null)
                {
                    actionbar.setHomeButtonEnabled(boolean1.booleanValue());
                }
                if (boolean2 != null)
                {
                    actionbar.setDisplayShowTitleEnabled(boolean2.booleanValue());
                }
                if (boolean3 != null)
                {
                    actionbar.setDisplayHomeAsUpEnabled(boolean3.booleanValue());
                }
                if (!TextUtils.isEmpty(s))
                {
                    actionbar.setTitle(s);
                }
            }
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                setupActionBarJBOnly(boolean1, boolean2, boolean3);
                return;
            }
        }
    }

    public void updateMuteActionState(MenuItem menuitem)
    {
        if (menuitem != null)
        {
            boolean flag = MuteUtil.isMuted(this);
            SLog.d("Is muted? {}", Boolean.valueOf(flag));
            int i;
            if (flag)
            {
                i = 0x7f0e0254;
            } else
            {
                i = 0x7f0e0148;
            }
            menuitem.setTitle(i);
        }
    }

    static 
    {
        FINISH_INTENT_FILTER = new IntentFilter();
        FINISH_INTENT_FILTER.addAction("co.vine.android.FINISH");
    }
}
