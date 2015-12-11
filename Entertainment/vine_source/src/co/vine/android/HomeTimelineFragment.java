// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.accounts.AccountManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import co.vine.android.api.VineClientFlags;
import co.vine.android.client.AppController;
import co.vine.android.client.Session;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.ClientFlagsHelper;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.Util;
import co.vine.android.widget.GenericTimelineAdapter;
import co.vine.android.widgets.PromptDialogSupportFragment;

// Referenced classes of package co.vine.android:
//            BaseTimelineFragment, ViewOverlayActivity, AppImpl, HomeTabActivity, 
//            FindFriendsActivity

public class HomeTimelineFragment extends BaseTimelineFragment
    implements co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener
{
    private class HomeTimeLineSessionListener extends BaseTimelineFragment.TimeLineSessionListener
    {

        final HomeTimelineFragment this$0;

        public void onFetchClientFlagsComplete(String s, int i, String s1, VineClientFlags vineclientflags, boolean flag)
        {
            super.onFetchClientFlagsComplete(s, i, s1, vineclientflags, flag);
            if (i == 200 && isFocused() && mInviteBottomBanner != null && flag)
            {
                mInviteBottomBanner.setVisibility(8);
            }
        }

        public void onMobileDataNetworkActivated()
        {
            super.onMobileDataNetworkActivated();
            if (ClientFlagsHelper.shouldShowClientFlagsBanner(getActivity()) && isFocused() && mInviteBottomBanner != null)
            {
                mInviteBottomBanner.setVisibility(8);
            }
        }

        private HomeTimeLineSessionListener()
        {
            this$0 = HomeTimelineFragment.this;
            super(HomeTimelineFragment.this);
        }

    }


    private static final int DIALOG_ADD_WIDGET = 992;
    private static final String EVENT_SOURCE_TITLE = "Home Timeline";
    public static final String PREF_INVITE_BANNER_CLICKED = "inviteBannerWasClicked";
    public static final String PREF_INVITE_BANNER_VIEW_COUNT = "inviteBannerViewCount";
    public static final String PREF_VM_ONBOARD_IN_PROGRESS = "vmOnboardInProgress";
    public static final int REQUEST_FIND_FRIENDS = 0;
    public static final int REQUEST_SETTINGS = 1;
    public static final int SHOW_ADD_WIDGET_THRESHOLD = 5;
    private static boolean sIsNewUser = false;
    private FrameLayout mInviteBottomBanner;

    public HomeTimelineFragment()
    {
    }

    protected String fetchPosts(int i, long l, boolean flag)
    {
        mAppController.fetchActivityCounts();
        return mAppController.fetchPosts(mAppController.getActiveSession(), 10, mAppController.getActiveId(), 1, i, l, flag, String.valueOf(mAppController.getActiveId()), null, null);
    }

    public void onActivityCreated(Bundle bundle)
    {
        Object obj;
        android.accounts.Account account;
        SharedPreferences sharedpreferences;
        super.onActivityCreated(bundle);
        mListView.setAdapter(mFeedAdapter);
        bundle = getActivity();
        obj = AccountManager.get(bundle);
        account = VineAccountHelper.getAccount(getActivity(), mAppController.getActiveSession().getLoginEmail());
        sharedpreferences = Util.getDefaultSharedPrefs(getActivity());
        int i = sharedpreferences.getInt("profile_follow_count", 0);
        if (sharedpreferences.getBoolean("inviteBannerWasClicked", false) && i > 5)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        long l;
        mInviteBottomBanner = (FrameLayout)getView().findViewById(0x7f0a0145);
        mInviteBottomBanner.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeTimelineFragment this$0;

            public void onClick(View view)
            {
                FlurryUtils.trackVisitFindFriends("InviteBanner");
                view = new Intent(getActivity(), co/vine/android/FindFriendsActivity);
                getActivity().startActivityForResult(view, 0);
            }

            
            {
                this$0 = HomeTimelineFragment.this;
                super();
            }
        });
        mInviteBottomBanner.setVisibility(0);
        l = sharedpreferences.getLong("inviteBannerViewCount", 0L) + 1L;
        sharedpreferences.edit().putLong("inviteBannerViewCount", l).apply();
          goto _L1
_L2:
        sharedpreferences = Util.getDefaultSharedPrefs(getActivity());
        if (getActivity().getIntent().hasExtra("is_new_user"))
        {
            sIsNewUser = true;
        }
        Exception exception;
        boolean flag;
        int j;
        if (account != null && VineAccountHelper.shouldShowVmOnboard(((AccountManager) (obj)), account) && !sIsNewUser)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            VineAccountHelper.setDidShowVmOnboard(((AccountManager) (obj)), account);
            sharedpreferences.edit().putBoolean("vmOnboardInProgress", true).apply();
            bundle.startActivityForResult(ViewOverlayActivity.getIntent(bundle, 0x7f0300a7, 0x7f0a0236, 0x7f0a008a), 2);
        } else
        {
            sharedpreferences.edit().putBoolean("vmOnboardInProgress", false).apply();
        }
        j = getActivity().getSharedPreferences("capture", 0).getInt("recorder_launch_count", 0);
        if (account != null && !flag && !BuildUtil.isAmazon() && AppImpl.getInstance().doAddWidget(bundle, ((AccountManager) (obj)), account) && j > 5)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_398;
        }
        VineAccountHelper.setDidShowAddWidget(((AccountManager) (obj)), account);
        obj = PromptDialogSupportFragment.newInstance(992);
        ((PromptDialogSupportFragment) (obj)).setTitle(0x7f0e0046);
        ((PromptDialogSupportFragment) (obj)).setMessage(0x7f0e0045);
        ((PromptDialogSupportFragment) (obj)).setNegativeButton(0x7f0e0057);
        ((PromptDialogSupportFragment) (obj)).setPositiveButton(0x7f0e0048);
        ((PromptDialogSupportFragment) (obj)).setListener(this);
        ((PromptDialogSupportFragment) (obj)).show(bundle.getSupportFragmentManager());
        return;
        bundle;
        return;
_L1:
        if (l < 10L && l % 5L == 0L || l % 10L == 0L)
        {
            try
            {
                FlurryUtils.trackInviteBannerViewed(l);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                CrashUtil.logException(exception, "Failed to show invite banner, which is ok.", new Object[0]);
                sharedpreferences.edit().putBoolean("inviteBannerWasClicked", true).apply();
            }
        }
          goto _L2
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 1 && j == 1)
        {
            mFetched = false;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAppSessionListener = new HomeTimeLineSessionListener();
        setFlurryEventSource("Home Timeline");
        setFocused(true);
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        switch (i)
        {
        case 992: 
            switch (j)
            {
            case -1: 
                AppImpl.getInstance().setupWidget(getActivity());
                break;
            }
            break;
        }
        while (true) 
        {
            dialoginterface.dismiss();
            return;
        }
    }

    public void onPause()
    {
        super.onPause();
        mFeedAdapter.onPause(isFocused());
    }

    public void onResume()
    {
        super.onResume();
        registerMergePostReceiver();
        ((HomeTabActivity)getActivity()).showMenuIfNeeded();
        mFeedAdapter.onResume(isFocused());
        mFeedAdapter.startLoadingTimeProfiling("HomeTimelineFragment");
        if (mAdapter.isEmpty())
        {
            fetchContent(3, true);
        }
        if (ClientFlagsHelper.shouldShowClientFlagsBanner(getActivity()) && !mClientFlagsBannerWasDismissed && Util.getActiveNetworkType(getActivity()) == 0)
        {
            showClientFlagsBanner();
            Object obj = Util.getDefaultSharedPrefs(getActivity());
            String s = ((SharedPreferences) (obj)).getString("client_flags_message_title", null);
            obj = ((SharedPreferences) (obj)).getString("client_flags_message_text", null);
            if (!TextUtils.isEmpty(s))
            {
                setBannerText(0x7f0a008d, s);
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                setBannerText(0x7f0a0093, ((String) (obj)));
            }
            if (mInviteBottomBanner != null)
            {
                mInviteBottomBanner.setVisibility(8);
            }
        }
    }

    public void removeBanner()
    {
        if (mInviteBottomBanner != null)
        {
            mInviteBottomBanner.setVisibility(8);
        }
    }

    protected boolean trackNewCount()
    {
        return true;
    }


}
