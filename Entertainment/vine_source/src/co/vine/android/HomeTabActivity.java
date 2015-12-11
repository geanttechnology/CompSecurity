// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.Toast;
import co.vine.android.api.VineRTCConversation;
import co.vine.android.api.VineRTCParticipant;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.drawable.CenteredTextDrawable;
import co.vine.android.service.GCMRegistrationService;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.ClientFlagsHelper;
import co.vine.android.util.ConversationMenuHelper;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.MuteUtil;
import co.vine.android.util.Util;
import co.vine.android.widget.Typefaces;
import co.vine.android.widget.tabs.IconTabHost;
import co.vine.android.widget.tabs.ScrollAwayTabWidget;
import co.vine.android.widget.tabs.TabIndicator;
import co.vine.android.widget.tabs.TabInfo;
import co.vine.android.widget.tabs.TabsAdapter;
import com.edisonwang.android.slog.SLog;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.twitter.android.widget.TopScrollable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            BaseTimelineActivity, BaseTimelineFragment, HomeTimelineFragment, ActivityFragment, 
//            ExploreFragment, ProfileFragment, SingleActivity, AppImpl, 
//            ProfileActivity, ExploreVideoListActivity, BaseArrayListFragment, FindFriendsActivity, 
//            SettingsActivity, SearchActivity, ViewOverlayActivity

public class HomeTabActivity extends BaseTimelineActivity
    implements android.widget.TabHost.OnTabChangeListener, co.vine.android.widget.tabs.IconTabHost.OnTabClickedListener, android.view.View.OnLongClickListener, co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener
{
    public static final class DelayHandler extends Handler
    {

        public static final int DETERMINE_SERVER_STATUS = 3;
        public static final int FETCH_FOLLOWERS = 2;
        public static final int FETCH_ME = 1;
        public static final int SEND_LOOP_COUNTS = 4;
        private final WeakReference mContextRef;

        public void handleMessage(Message message)
        {
            Object obj = (Context)mContextRef.get();
            if (obj == null)
            {
                return;
            }
            obj = AppController.getInstance(((Context) (obj)));
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                ((AppController) (obj)).fetchUsersMe(((AppController) (obj)).getActiveId());
                return;

            case 2: // '\002'
                ((AppController) (obj)).fetchFollowing(((AppController) (obj)).getActiveId(), 1, 0L);
                return;

            case 3: // '\003'
                ((AppController) (obj)).determineServerStatus();
                return;

            case 4: // '\004'
                ((AppController) (obj)).sendLoopCounts();
                break;
            }
        }

        public DelayHandler(Context context)
        {
            mContextRef = new WeakReference(context.getApplicationContext());
        }
    }

    class HomeTabSessionListener extends AppSessionListener
    {

        final HomeTabActivity this$0;

        public void onAbortAllRequestsComplete()
        {
            super.onAbortAllRequestsComplete();
            mAppController.fetchActivityCounts();
        }

        public void onGetMessageCountComplete(String s, int i, String s1, int j)
        {
label0:
            {
                if (i == 200)
                {
                    s = Util.getDefaultSharedPrefs(HomeTabActivity.this);
                    i = s.getInt("pref_mrumc", 0);
                    if (!s.getBoolean("pref_dismissed", false))
                    {
                        break label0;
                    }
                    if (i != j)
                    {
                        s.edit().putBoolean("pref_dismissed", false).commit();
                        mMessageCount = j;
                        invalidateMessagesBadge();
                    }
                }
                return;
            }
            mMessageCount = j;
            invalidateMessagesBadge();
        }

        public void onGetPendingNotificationCountComplete(String s, int i, String s1, int j)
        {
            if (i == 200)
            {
                mActivityCount = j;
                invalidateActivityBadge();
            }
        }

        public void onReceiveRTCMessage(ArrayList arraylist)
        {
            for (arraylist = arraylist.iterator(); arraylist.hasNext();)
            {
                VineRTCConversation vinertcconversation = (VineRTCConversation)arraylist.next();
                Iterator iterator = vinertcconversation.participants.iterator();
                while (iterator.hasNext()) 
                {
                    VineRTCParticipant vinertcparticipant = (VineRTCParticipant)iterator.next();
                    long l = vinertcparticipant.lastMessageId;
                    if (l > 0L)
                    {
                        Long long1 = (Long)mLastMessageMap.get(vinertcparticipant.userId);
                        if (long1 != null && l > long1.longValue())
                        {
                            mAppController.fetchConversation(1, false, vinertcconversation.conversationId, 0L, true);
                            if (!getSlidingMenu().isMenuShowing())
                            {
                                mAppController.fetchActivityCounts();
                            }
                        } else
                        {
                            mLastMessageMap.put(vinertcparticipant.userId, Long.valueOf(l));
                        }
                    }
                }
            }

        }

        public void onVerifyEmailComplete(String s, int i, String s1)
        {
            if (i == 200)
            {
                s = new Intent(HomeTabActivity.this, co/vine/android/SettingsActivity);
                s.setAction(HomeTabActivity.ACTION_VERIFICATION_COMPLETE);
                startActivityForResult(s, 1);
            } else
            {
                s = getApplicationContext();
                if (s1 == null)
                {
                    s1 = getString(0x7f0e0105);
                }
                Util.showCenteredToast(s, s1);
            }
            dismissDialog();
        }

        HomeTabSessionListener()
        {
            this$0 = HomeTabActivity.this;
            super();
        }
    }

    private class HomeTabTabsAdapter extends TabsAdapter
    {

        final HomeTabActivity this$0;

        public void onPageSelected(int i)
        {
            super.onPageSelected(i);
            resetNav();
            if (i == 1)
            {
                Util.getDefaultSharedPrefs(getApplicationContext()).edit().putInt("unread_notification_count", 0).commit();
                mActivityCount = 0;
                invalidateActivityBadge();
            }
        }

        public HomeTabTabsAdapter(TabHost tabhost)
        {
            this$0 = HomeTabActivity.this;
            super(HomeTabActivity.this, tabhost, mViewPager, null);
        }
    }


    public static final String ACTION_VERIFICATION_COMPLETE = (new StringBuilder()).append(BuildUtil.getAuthority()).append(".EMAIL_VERIFIED").toString();
    public static final String ACTION_VM_SENT = "co.vine.android.VM_SENT";
    private static IntentFilter ACTIVITY_COUNT_FILTER;
    public static final int DIALOG_STORE_CONTACTS = 1;
    public static final String HOST_POST = "post";
    public static final String HOST_TIMELINES = "timelines";
    public static final int INDEX_ACTIVITY_TAB = 1;
    public static final int INDEX_EXPLORE_TAB = 2;
    public static final int INDEX_PROFILE_TAB = 3;
    public static final String PREFIX_CONFIRM_EMAIL = "confirmEmail";
    public static final String PREFIX_SHARED_VIDEO = "v";
    public static final String PREFIX_USER_ID = "u";
    public static final int REQUEST_CODE_VIEW_NOTIF = 1;
    public static final int REQUEST_CODE_VM_ONBOARD = 2;
    public static final String SCHEME_VINE = "vine";
    public static final String TAG_ACTIVITY = "activity";
    public static final String TAG_EXPLORE = "explore";
    public static final String TAG_HOME = "home";
    public static final String TAG_PROFILE = "profile";
    private int mActivityCount;
    private BroadcastReceiver mActivityCountReceiver;
    private BroadcastReceiver mExploreRefreshReciver;
    private boolean mExploreRefreshReciverIsRegistered;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private MenuItem mInboxMenu;
    private LongSparseArray mLastMessageMap;
    private Menu mMenu;
    private int mMessageCount;
    private String mRecentTab;
    private boolean mScrollAwayNavEnabled;
    private boolean mShouldShowMenu;
    private IconTabHost mTabHost;
    private TabsAdapter mTabsAdapter;
    private ViewPager mViewPager;

    public HomeTabActivity()
    {
        mActivityCountReceiver = new BroadcastReceiver() {

            final HomeTabActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                int i = intent.getIntExtra("messages_count", 0);
                int j = intent.getIntExtra("notifications_count", 0);
                mActivityCount = j;
                mMessageCount = i;
                invalidateMessagesBadge();
                invalidateActivityBadge();
            }

            
            {
                this$0 = HomeTabActivity.this;
                super();
            }
        };
        mExploreRefreshReciver = new BroadcastReceiver() {

            final HomeTabActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = mTabsAdapter.getTab(2);
                if (context != null)
                {
                    context = context.fragment();
                    if (context instanceof ExploreFragment)
                    {
                        ((ExploreFragment)context).reloadWebView();
                    }
                }
            }

            
            {
                this$0 = HomeTabActivity.this;
                super();
            }
        };
        mScrollAwayNavEnabled = true;
    }

    private void fetchClientFlags()
    {
        try
        {
            if (Util.getActiveNetworkType(this) == 0 && !ClientFlagsHelper.isClientFlagsTtlInRange(this))
            {
                mAppController.fetchClientFlags(true);
            }
            return;
        }
        catch (Exception exception)
        {
            CrashUtil.logException(exception);
        }
    }

    private void invalidateMessagesBadge()
    {
        Object obj;
label0:
        {
            Resources resources = getResources();
            if (resources != null && mInboxMenu != null)
            {
                obj = mInboxMenu.getIcon();
                CenteredTextDrawable centeredtextdrawable = null;
                if (obj instanceof CenteredTextDrawable)
                {
                    centeredtextdrawable = (CenteredTextDrawable)obj;
                }
                obj = centeredtextdrawable;
                if (centeredtextdrawable == null)
                {
                    obj = new CenteredTextDrawable(resources, new int[] {
                        0x7f02027f, 0x7f02027e
                    });
                    ((CenteredTextDrawable) (obj)).setColorFilter(1, new PorterDuffColorFilter(Util.getProfileColor(this) | 0xff000000, android.graphics.PorterDuff.Mode.SRC_IN));
                    int i = (int)(6F * resources.getDisplayMetrics().density);
                    ((CenteredTextDrawable) (obj)).setTextPadding(new Rect(i, i, i, i));
                    ((CenteredTextDrawable) (obj)).setTextColor(-1);
                    ((CenteredTextDrawable) (obj)).setTypeFace(Typefaces.get(this).boldContentBold);
                    ((CenteredTextDrawable) (obj)).setTextSize(TypedValue.applyDimension(2, 12F, resources.getDisplayMetrics()));
                }
                if (mMessageCount != 0)
                {
                    break label0;
                }
                mInboxMenu.setIcon(0x7f020134);
            }
            return;
        }
        String s;
        if (mMessageCount > 99)
        {
            s = "99+";
        } else
        {
            s = String.valueOf(mMessageCount);
        }
        ((CenteredTextDrawable) (obj)).setText(s);
        mInboxMenu.setIcon(((Drawable) (obj)));
    }

    private void logTabChange(String s)
    {
        CrashUtil.set("Current Tab", (new StringBuilder()).append(s).append(" - ").append(System.currentTimeMillis()).toString());
        if (s != null && !s.contains("switcher"))
        {
            FlurryUtils.trackTabChange(s);
        }
    }

    private CenteredTextDrawable makeAcitivytNewIndicator(Resources resources)
    {
        float f = resources.getDisplayMetrics().density;
        Object obj = new GradientDrawable();
        ((GradientDrawable) (obj)).setStroke((int)(2.0F * f), 0xff242424);
        ((GradientDrawable) (obj)).setShape(0);
        ((GradientDrawable) (obj)).setCornerRadius(4F * f);
        ((GradientDrawable) (obj)).setColor(resources.getColor(0x7f090096));
        ((GradientDrawable) (obj)).setSize((int)(19F * f), (int)(20F * f));
        obj = new CenteredTextDrawable(new Drawable[] {
            obj
        });
        ((CenteredTextDrawable) (obj)).setTextColor(-1);
        ((CenteredTextDrawable) (obj)).setTypeFace(Typefaces.get(this).boldContentBold);
        ((CenteredTextDrawable) (obj)).setTextSize(TypedValue.applyDimension(2, 12F, resources.getDisplayMetrics()));
        return ((CenteredTextDrawable) (obj));
    }

    private void setupTabs()
    {
        mTabHost = (IconTabHost)findViewById(0x1020012);
        if (mTabHost == null)
        {
            throw new RuntimeException("Your content must have a TabHost whose id attribute is 'android.R.id.tabhost'");
        } else
        {
            mTabHost.setup();
            mViewPager = (ViewPager)findViewById(0x7f0a00da);
            return;
        }
    }

    private void showSlidingMenuWithVmOnboard()
    {
        mHandler.postDelayed(new Runnable() {

            final HomeTabActivity this$0;

            public void run()
            {
                getConversationSlidingMenuHelper().showVmOnboarding();
                getSlidingMenu().toggle(true);
            }

            
            {
                this$0 = HomeTabActivity.this;
                super();
            }
        }, 250L);
    }

    private void showSlidingMenuWithVmOnboardAfterSend()
    {
        mHandler.postDelayed(new Runnable() {

            final HomeTabActivity this$0;

            public void run()
            {
                getConversationSlidingMenuHelper().showVmOnboardingAfterSend();
                getSlidingMenu().toggle(true);
            }

            
            {
                this$0 = HomeTabActivity.this;
                super();
            }
        }, 250L);
    }

    private void showSlidingMenuWithoutOnboard()
    {
        Util.getDefaultSharedPrefs(this).edit().putBoolean("vmOnboardInProgress", false).apply();
        mHandler.postDelayed(new Runnable() {

            final HomeTabActivity this$0;

            public void run()
            {
                getSlidingMenu().toggle(true);
            }

            
            {
                this$0 = HomeTabActivity.this;
                super();
            }
        }, 250L);
    }

    public static void start(Activity activity, String s)
    {
        activity.startActivity((new Intent(activity, co/vine/android/HomeTabActivity)).addFlags(0x4000000));
        activity.finish();
    }

    private String trimSegment(String s)
    {
        return s.replaceAll("\\s+", "").replace("\\", "");
    }

    protected BaseTimelineFragment getCurrentTimeLineFragment()
    {
label0:
        {
            Object obj;
            try
            {
                obj = mTabsAdapter.getCurrentFragment();
                if (!(obj instanceof BaseTimelineFragment))
                {
                    break label0;
                }
                obj = (BaseTimelineFragment)obj;
            }
            catch (Exception exception)
            {
                return null;
            }
            return ((BaseTimelineFragment) (obj));
        }
        return null;
    }

    public void invalidateActivityBadge()
    {
        if (mTabsAdapter != null)
        {
            TabsAdapter tabsadapter = mTabsAdapter;
            ImageView imageview;
            Resources resources;
            boolean flag;
            if (mActivityCount > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            tabsadapter.setNew(1, flag);
            imageview = mTabsAdapter.getNewIndicatorForTab(1);
            resources = getResources();
            if (resources != null && imageview != null)
            {
                Object obj1 = imageview.getDrawable();
                Object obj = null;
                if (obj1 instanceof CenteredTextDrawable)
                {
                    obj = (CenteredTextDrawable)obj1;
                }
                obj1 = obj;
                if (obj == null)
                {
                    obj1 = makeAcitivytNewIndicator(resources);
                    imageview.setImageDrawable(((Drawable) (obj1)));
                }
                int i = 0;
                if (mActivityCount > 9)
                {
                    i = 0 + 1;
                }
                int j = i;
                if (mActivityCount > 99)
                {
                    j = i + 1;
                }
                i = (int)(6F * resources.getDisplayMetrics().density);
                j = (int)((float)(6 - j * 2) * resources.getDisplayMetrics().density);
                ((CenteredTextDrawable) (obj1)).setTextPadding(new Rect(j, i, j, i));
                if (mActivityCount > 99)
                {
                    obj = "99+";
                } else
                {
                    obj = String.valueOf(mActivityCount);
                }
                ((CenteredTextDrawable) (obj1)).setText(((String) (obj)));
            }
        }
    }

    protected boolean isAutoCaptureIconEnabled()
    {
        return false;
    }

    public boolean isConversationSideMenuEnabled()
    {
        return true;
    }

    public void markActivitiesRead()
    {
        Util.getDefaultSharedPrefs(this).edit().putInt("unread_notification_count", 0).commit();
        mActivityCount = 0;
        invalidateActivityBadge();
    }

    public void markMessagesAsDismissed()
    {
        Util.getDefaultSharedPrefs(this).edit().putBoolean("pref_dismissed", true);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (mTabsAdapter == null) goto _L2; else goto _L1
_L1:
        Object obj = mTabsAdapter.getTabs();
        if (i != 0) goto _L4; else goto _L3
_L3:
        intent = Util.getDefaultSharedPrefs(this);
        intent.edit().putBoolean("inviteBannerWasClicked", true).apply();
        i = intent.getInt("profile_follow_count", 0);
        intent = ((TabInfo)((ArrayList) (obj)).get(mTabHost.getCurrentTab())).fragment();
        if (i > 5 && (intent instanceof HomeTimelineFragment))
        {
            ((HomeTimelineFragment)intent).removeBanner();
        }
_L2:
        return;
_L4:
        if (i != 1 || j != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((ArrayList) (obj)).iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            Fragment fragment = ((TabInfo)((Iterator) (obj)).next()).fragment();
            if (fragment instanceof BaseTimelineFragment)
            {
                fragment.onActivityResult(i, j, intent);
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (i != 1 || j != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (BuildUtil.isExplore() && mMenu != null)
        {
            mMenu.removeItem(0x7f0a023c);
            return;
        }
        if (true) goto _L2; else goto _L6
_L6:
        if (i == 2)
        {
            if (j == -1)
            {
                if (Util.isCapableOfRecording(this))
                {
                    showSlidingMenuWithVmOnboard();
                } else
                {
                    showSlidingMenuWithoutOnboard();
                }
            } else
            {
                Util.getDefaultSharedPrefs(this).edit().putBoolean("vmOnboardInProgress", false).apply();
            }
            fetchClientFlags();
            return;
        }
        obj = ((TabInfo)((ArrayList) (obj)).get(mTabHost.getCurrentTab())).fragment();
        if (obj != null)
        {
            ((Fragment) (obj)).onActivityResult(i, j, intent);
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    public void onCreate(Bundle bundle)
    {
        Object obj1;
        super.onCreate(bundle, 0x7f030052, true);
        if (BuildUtil.isExplore())
        {
            setupTabs();
        }
        if (SLog.sLogsOn)
        {
            sendBroadcast(new Intent("co.vine.android.debug_receiver"));
        }
        SLog.i("HomeTabActivity pid: {}", Integer.valueOf(Process.myPid()));
        setRequestedOrientation(1);
        setupActionBar(Boolean.valueOf(false), null, null, null);
        mAppSessionListener = new HomeTabSessionListener();
        mLastMessageMap = new LongSparseArray();
        bundle = getIntent();
        if (mAppController == null)
        {
            mAppController = AppController.getInstance(this);
        }
        obj1 = mAppController;
        if (((AppController) (obj1)).isLoggedIn()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        VineAccountHelper.migratePassword(AccountManager.get(this), VineAccountHelper.getActiveAccountReadOnly(this), this);
        Object obj = Util.getDefaultSharedPrefs(this);
        IconTabHost icontabhost = mTabHost;
        mViewPager = (ViewPager)findViewById(0x7f0a00da);
        mViewPager.setPageMargin(getResources().getDimensionPixelSize(0x7f0b0054));
        mViewPager.setPageMarginDrawable(0x7f09000e);
        mViewPager.setOffscreenPageLimit(3);
        mTabsAdapter = new HomeTabTabsAdapter(icontabhost);
        LayoutInflater layoutinflater = LayoutInflater.from(this);
        icontabhost.setOnTabChangedListener(this);
        icontabhost.setOnTabClickedListener(this);
        Bundle bundle1 = new Bundle();
        bundle1.putInt("empty_desc", 0x7f0e00da);
        mTabsAdapter.addTab(icontabhost.newTabSpec("home").setIndicator(TabIndicator.newIconIndicator(layoutinflater, 0x7f030048, icontabhost, 0x7f020193, 0)), co/vine/android/HomeTimelineFragment, bundle1);
        restoreActivityState();
        bundle1 = new Bundle();
        bundle1.putInt("empty_desc", 0x7f0e003f);
        if ("co.vine.android.ACTIVITY_NOTIFICATION_PRESSED".equals(bundle.getAction()) || TextUtils.equals(mRecentTab, "activity"))
        {
            bundle1.putBoolean("take_focus", true);
            FlurryUtils.trackNotificationClicked("Activity");
        } else
        if ("co.vine.android.MESSAGE_NOTIFICATION_PRESSED".equals(bundle.getAction()))
        {
            mShouldShowMenu = true;
            FlurryUtils.trackNotificationClicked("Message");
        } else
        if ("co.vine.android.VM_SENT".equals(bundle.getAction()) && bundle.getBooleanExtra("is_vm_onboarding", false))
        {
            showSlidingMenuWithVmOnboardAfterSend();
        }
        mTabsAdapter.addTab(icontabhost.newTabSpec("activity").setIndicator(TabIndicator.newIconIndicator(layoutinflater, 0x7f03001f, icontabhost, 0x7f02013a, 0)), co/vine/android/ActivityFragment, bundle1);
        bundle1 = new Bundle();
        if (TextUtils.equals(mRecentTab, "explore"))
        {
            bundle1.putBoolean("take_focus", true);
        }
        mTabsAdapter.addTab(icontabhost.newTabSpec("explore").setIndicator(TabIndicator.newIconIndicator(layoutinflater, 0x7f030048, icontabhost, 0x7f020166, 0)), co/vine/android/ExploreFragment, bundle1);
        bundle1 = new Bundle();
        if (TextUtils.equals(mRecentTab, "profile"))
        {
            bundle1.putBoolean("take_focus", true);
        }
        bundle1.putLong("user_id", ((AppController) (obj1)).getActiveId());
        bundle1.putBoolean("refresh", true);
        mTabsAdapter.addTab(icontabhost.newTabSpec("profile").setIndicator(TabIndicator.newIconIndicator(layoutinflater, 0x7f030048, icontabhost, 0x7f0201c8, 0)), co/vine/android/ProfileFragment, bundle1);
        obj1 = mAppController.getActiveSession();
        mAppController.determineCleanup(((co.vine.android.client.Session) (obj1)));
        mActivityCount = ((SharedPreferences) (obj)).getInt("unread_notification_count", 0);
        invalidateActivityBadge();
        mAppController.fetchActivityCounts();
        obj = bundle.getData();
        bundle = bundle.getAction();
        if ("android.intent.action.VIEW".equals(bundle) && obj != null)
        {
            bundle = new ArrayList(((Uri) (obj)).getPathSegments());
            String s = ((Uri) (obj)).getScheme();
            String s1 = ((Uri) (obj)).getHost();
            if (s1 != null && !bundle.isEmpty())
            {
                if (s1.contains("vine.co"))
                {
                    s = (String)bundle.get(0);
                    if ("v".equals(s) && bundle.size() > 1)
                    {
                        SingleActivity.start(this, trimSegment((String)bundle.get(1)));
                    } else
                    if ("u".equals(s))
                    {
                        try
                        {
                            ProfileActivity.start(this, Long.parseLong(trimSegment(((Uri) (obj)).getLastPathSegment())), "Deep Link: /u/<userId>");
                        }
                        // Misplaced declaration of an exception variable
                        catch (Bundle bundle)
                        {
                            Util.showCenteredToast(this, 0x7f0e0115);
                            finish();
                        }
                    } else
                    if ("confirmEmail".equals(s))
                    {
                        mAppController.verifyEmail(mAppController.getActiveSession(), ((Uri) (obj)).getLastPathSegment());
                        mProgressDialog = new ProgressDialog(this);
                        mProgressDialog.setMessage(getString(0x7f0e0129));
                        try
                        {
                            mProgressDialog.show();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Bundle bundle)
                        {
                            SLog.e("Failed to show pd.", bundle);
                        }
                    } else
                    {
                        ProfileActivity.start(this, bundle, "Deep Link: Vanity URL");
                    }
                } else
                if ("vine".equals(s))
                {
                    if ("post".equals(s1))
                    {
                        try
                        {
                            SingleActivity.start(this, Long.parseLong(((Uri) (obj)).getLastPathSegment()));
                        }
                        // Misplaced declaration of an exception variable
                        catch (Bundle bundle)
                        {
                            Util.showCenteredToast(this, 0x7f0e0115);
                            finish();
                        }
                    } else
                    if ("timelines".equals(s1))
                    {
                        ExploreVideoListActivity.start(this, ((Uri) (obj)));
                    }
                }
            }
        } else
        if ("co.vine.android.UPLOAD_LIST".equals(bundle))
        {
            AppImpl.getInstance().startUploadsListActivity(this);
        }
        bundle = new DelayHandler(this);
        if (bundle.hasMessages(1))
        {
            bundle.removeMessages(1);
        }
        if (bundle.hasMessages(2))
        {
            bundle.removeMessages(2);
        }
        bundle.sendMessage(bundle.obtainMessage(4, null));
        bundle.sendMessageDelayed(bundle.obtainMessage(1, null), 60000L);
        bundle.sendMessageDelayed(bundle.obtainMessage(2, null), 60000L);
        bundle.sendMessageDelayed(bundle.obtainMessage(3, null), 60000L);
        AppImpl.getInstance().startCameraService(this);
        VineAccountHelper.syncNormalVideoPlayable(this);
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) != 0) goto _L1; else goto _L3
_L3:
        startService(GCMRegistrationService.getRegisterIntent(this, mAppController.getActiveId()));
        return;
        bundle;
        CrashUtil.logException(bundle, "Failed to validate Google Player Service status.", new Object[0]);
        return;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f100007, menu);
        SharedPreferences sharedpreferences = Util.getDefaultSharedPrefs(this);
        if (BuildUtil.isExplore() && sharedpreferences.getBoolean("pref_gb_notif_dismissed", false))
        {
            menu.removeItem(0x7f0a023c);
        }
        mInboxMenu = menu.findItem(0x7f0a0247);
        invalidateMessagesBadge();
        mMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    public void onCurrentTabClicked()
    {
        scrollTop();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (mExploreRefreshReciverIsRegistered)
        {
            mExploreRefreshReciverIsRegistered = false;
            unregisterReceiver(mExploreRefreshReciver);
        }
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            break;
        }
        boolean flag;
        if (j == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            mAppController.sendAddressBook();
        }
        mAppController.updateEnableAddressBook(flag);
        Util.getDefaultSharedPrefs(this).edit().putBoolean("enable_address_book", flag).apply();
    }

    public boolean onLongClick(View view)
    {
        int i = -1;
        ((Integer)view.getTag()).intValue();
        JVM INSTR tableswitch 1 4: default 44
    //                   1 111
    //                   2 118
    //                   3 125
    //                   4 132;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (i > 0)
        {
            int j = view.getLeft();
            int k = view.getBottom();
            int l = view.getMeasuredHeight();
            Toast toast = Toast.makeText(this, i, 0);
            toast.setGravity(51, j, k + l);
            toast.show();
        }
        if (view.getClass().equals(co/vine/android/widget/tabs/TabIndicator))
        {
            view.performHapticFeedback(0);
        }
        return true;
_L2:
        i = 0x7f0e023e;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 0x7f0e0236;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 0x7f0e0238;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 0x7f0e023c;
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void onMenuClose()
    {
        if (!MuteUtil.isMuted(this))
        {
            sendBroadcast(new Intent(MuteUtil.ACTION_CHANGED_TO_UNMUTE), "co.vine.android.BROADCAST");
        }
    }

    public void onMenuOpened()
    {
        super.onMenuOpened();
        invalidateMessagesBadge();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        if ("co.vine.android.ACTIVITY_NOTIFICATION_PRESSED".equals(intent.getAction()))
        {
            intent = mTabsAdapter.getCurrentFragment();
            if (intent instanceof BaseArrayListFragment)
            {
                showPage(1, intent);
            }
        } else
        {
            if ("co.vine.android.MESSAGE_NOTIFICATION_PRESSED".equals(intent.getAction()))
            {
                mShouldShowMenu = true;
                return;
            }
            if ("co.vine.android.VM_SENT".equals(intent.getAction()) && intent.getBooleanExtra("is_vm_onboarding", false))
            {
                showSlidingMenuWithVmOnboardAfterSend();
                return;
            }
        }
    }

    public void onNotifyClick()
    {
        getSlidingMenu().toggle(true);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131362117: 
            FlurryUtils.trackVisitFindFriends("Menu");
            startActivity(new Intent(this, co/vine/android/FindFriendsActivity));
            return true;

        case 2131362188: 
            FlurryUtils.trackVisitSettings("Menu");
            startActivityForResult(new Intent(this, co/vine/android/SettingsActivity), 1);
            return true;

        case 2131362020: 
            FlurryUtils.trackVisitSearch("Menu");
            startActivity(new Intent(this, co/vine/android/SearchActivity));
            return true;

        case 2131362375: 
            FlurryUtils.trackVisitInbox("Menu");
            getSlidingMenu().toggle(true);
            return true;

        case 2131362364: 
            break;
        }
        if (BuildUtil.isExplore())
        {
            startActivityForResult(ViewOverlayActivity.getIntent(this, 0x7f030054, 0x7f0a011f, 0), 1);
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPause()
    {
        super.onPause();
        if (!mExploreRefreshReciverIsRegistered)
        {
            mExploreRefreshReciverIsRegistered = true;
            registerReceiver(mExploreRefreshReciver, AppController.ACTION_UPDATED_FILTER, "co.vine.android.BROADCAST", null);
        }
        try
        {
            unregisterReceiver(mActivityCountReceiver);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return;
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (mTabsAdapter != null && mTabHost != null)
        {
            mTabsAdapter.previousTab = mTabHost.getCurrentTab();
        }
        Object obj = AppImpl.getInstance().getNotifyFailedIntent(this);
        if (obj != null)
        {
            startService(((Intent) (obj)));
        }
        obj = mTabHost.getTabWidget();
        int i;
        int j;
        if (obj == null)
        {
            i = 0;
        } else
        {
            i = ((TabWidget) (obj)).getTabCount();
        }
        for (j = 0; j < i; j++)
        {
            View view = ((TabWidget) (obj)).getChildAt(j);
            if (view != null)
            {
                view.setTag(Integer.valueOf(j + 1));
                view.setOnLongClickListener(this);
            }
        }

        registerReceiver(mActivityCountReceiver, ACTIVITY_COUNT_FILTER, "co.vine.android.BROADCAST", null);
        mAppController.fetchActivityCounts();
        invalidateActivityBadge();
        invalidateMessagesBadge();
    }

    public void onScroll(int i)
    {
        if (mScrollAwayNavEnabled)
        {
            ScrollAwayTabWidget scrollawaytabwidget = (ScrollAwayTabWidget)mTabHost.getTabWidget();
            scrollawaytabwidget.onScroll(i);
            Fragment fragment = mTabsAdapter.getCurrentFragment();
            if (fragment instanceof BaseArrayListFragment)
            {
                ((BaseArrayListFragment)fragment).setNavBottom(scrollawaytabwidget.getNavBottom());
            }
        }
    }

    protected void onStart()
    {
        super.onStart();
        fetchClientFlags();
        if (ClientFlagsHelper.zeroRatingIsEnabled(this))
        {
            FlurryUtils.trackZeroRatedSessionStarted(true);
        }
    }

    protected void onStop()
    {
        super.onStop();
    }

    public void onSupportContentChanged()
    {
        super.onSupportContentChanged();
        if (!BuildUtil.isExplore())
        {
            setupTabs();
        }
    }

    public void onTabChanged(String s)
    {
        int i;
        if (SLog.sLogsOn)
        {
            SLog.d(Util.printCursorWindowStats());
        }
        i = mTabHost.getCurrentTab();
        mViewPager.setCurrentItem(i);
        mRecentTab = s;
        if ("activity".equals(s))
        {
            markActivitiesRead();
        }
        i;
        JVM INSTR tableswitch 0 0: default 64
    //                   0 78;
           goto _L1 _L2
_L1:
        getSlidingMenu().setTouchModeAbove(0);
_L4:
        logTabChange(s);
        return;
_L2:
        getSlidingMenu().setTouchModeAbove(1);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void resetNav()
    {
        if (mTabHost != null)
        {
            Object obj = (ScrollAwayTabWidget)mTabHost.getTabWidget();
            if (obj != null)
            {
                ((ScrollAwayTabWidget) (obj)).resetScroll();
                ((ScrollAwayTabWidget) (obj)).invalidate();
                int i = ((ScrollAwayTabWidget) (obj)).getNavBottom();
                obj = mTabsAdapter.getCurrentFragment();
                if (obj != null && (obj instanceof BaseArrayListFragment))
                {
                    ((BaseArrayListFragment)obj).setNavBottom(i);
                }
                mScrollAwayNavEnabled = true;
            }
        }
    }

    public void scrollTop()
    {
        Fragment fragment;
        fragment = mTabsAdapter.getCurrentFragment();
        resetNav();
        if (!(fragment instanceof BaseArrayListFragment)) goto _L2; else goto _L1
_L1:
        Object obj = fragment.getView();
        if (obj != null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        if ((obj = (TopScrollable)((View) (obj)).findViewById(0x102000a)) != null && !((TopScrollable) (obj)).scrollTop())
        {
            ((BaseArrayListFragment)fragment).invokeScrollFirstItem();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (fragment instanceof TopScrollable)
        {
            ((TopScrollable)fragment).scrollTop();
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void setProfileColor(int i)
    {
        int j = mTabHost.getCurrentTab();
        if (j == 3)
        {
            ((TabIndicator)mTabHost.getTabWidget().getChildTabViewAt(j)).setColor(i);
            return;
        } else
        {
            ((TabIndicator)mTabHost.getTabWidget().getChildTabViewAt(3)).unSetColor();
            return;
        }
    }

    public void setScrollAwayNavEnabled(boolean flag)
    {
        mScrollAwayNavEnabled = flag;
    }

    public void showMenuIfNeeded()
    {
        if (mShouldShowMenu)
        {
            SLog.d("Menu requested.");
            mShouldShowMenu = false;
            getSlidingMenu().showMenu(false);
        }
    }

    public void showPage(int i, Fragment fragment)
    {
        mViewPager.setCurrentItem(i);
        if (fragment instanceof BaseArrayListFragment)
        {
            ((BaseArrayListFragment)fragment).onMoveTo(1);
        }
        Fragment fragment1 = mTabsAdapter.getTab(mViewPager.getCurrentItem()).fragment();
        if (fragment1 instanceof BaseArrayListFragment)
        {
            ((BaseArrayListFragment)fragment1).onMoveAway(-1);
        }
        resetNav();
        logTabChange(fragment.getTag());
    }

    static 
    {
        ACTIVITY_COUNT_FILTER = new IntentFilter();
        ACTIVITY_COUNT_FILTER.addAction("co.vine.android.service.activityCounts");
    }


/*
    static int access$002(HomeTabActivity hometabactivity, int i)
    {
        hometabactivity.mActivityCount = i;
        return i;
    }

*/


/*
    static int access$102(HomeTabActivity hometabactivity, int i)
    {
        hometabactivity.mMessageCount = i;
        return i;
    }

*/




}
