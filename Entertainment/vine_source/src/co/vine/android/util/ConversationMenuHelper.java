// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.AbstractRecordingActivity;
import co.vine.android.BaseControllerActionBarActivity;
import co.vine.android.ConversationActivity;
import co.vine.android.FriendSearchAdapter;
import co.vine.android.InboxFragment;
import co.vine.android.Settings;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.views.TouchableRelativeLayout;
import com.jeremyfeinstein.slidingmenu.lib.SlidingActivityHelper;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.twitter.android.widget.RefreshableListView;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android.util:
//            Util, ViewUtil, ViewBehindTouchListener

public class ConversationMenuHelper extends SlidingActivityHelper
    implements TextWatcher, android.view.View.OnClickListener, android.os.Handler.Callback, android.widget.AdapterView.OnItemClickListener
{
    public class ConversationMenuHelperAppSessionListener extends AppSessionListener
    {

        final ConversationMenuHelper this$0;

        public void onGetConversationRowIdComplete(long l, long l1, String s, boolean flag)
        {
            if (l == mWaitingToStartUserId || l == mWaitingToStartSearchUserId)
            {
                if (l == mWaitingToStartSearchUserId)
                {
                    toggleContactSearch(false);
                }
                mWaitingToStartUserId = -1L;
                mAppController.clearUnreadMessageCount(l1);
                mActivity.startActivity(ConversationActivity.getIntent(mActivity, l1, s, l, flag, false));
            }
        }

        public void onGetFriendsTypeAheadComplete(String s, int i, String s1, String s2, ArrayList arraylist)
        {
            showSearchProgressBar(false);
            if (arraylist != null && mIsSearching)
            {
                displaySearchResults(arraylist);
            }
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            if (mIsSearching && mFriendSearchAdapter != null)
            {
                mFriendSearchAdapter.setUserImages(hashmap);
            }
        }

        public ConversationMenuHelperAppSessionListener()
        {
            this$0 = ConversationMenuHelper.this;
            super();
        }
    }

    private class OnboardingOverlayFadeOutRunnable
        implements Runnable
    {

        private View mView;
        final ConversationMenuHelper this$0;

        public void run()
        {
            Animation animation = AnimationUtils.loadAnimation(mActivity, 0x7f04000f);
            animation.setAnimationListener(mMessageSentFadeListener);
            if (mView != null && mView.getVisibility() == 0)
            {
                mView.startAnimation(animation);
            }
        }

        public void setView(View view)
        {
            mView = view;
        }

        private OnboardingOverlayFadeOutRunnable()
        {
            this$0 = ConversationMenuHelper.this;
            super();
        }

    }


    private static final long FETCH_THRESHOLD_MS = 200L;
    private static final int MSG_SEARCH_USERS = 1;
    private static final int QUERY_FETCH_THRESHOLD = 2;
    private static final String TAG_INBOX_FRAGMENT = "Inbox";
    private ViewGroup mActionContainer;
    private final BaseControllerActionBarActivity mActivity;
    private AppController mAppController;
    private final ConversationMenuHelperAppSessionListener mAppSessionListener = new ConversationMenuHelperAppSessionListener();
    private FriendSearchAdapter mFriendSearchAdapter;
    private Handler mHandler;
    private InboxFragment mInboxFragment;
    private boolean mIsSearching;
    private final android.view.animation.Animation.AnimationListener mMessageSentFadeListener = new android.view.animation.Animation.AnimationListener() {

        final ConversationMenuHelper this$0;

        public void onAnimationEnd(Animation animation)
        {
            mOnboardingOverlay.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

            
            {
                this$0 = ConversationMenuHelper.this;
                super();
            }
    };
    private View mNothingFoundText;
    private TextView mOnboardingOverlay;
    private TextView mOthersText;
    private int mProfileColor;
    private View mSadFace;
    private ViewGroup mSearchContainer;
    private EditText mSearchField;
    private ProgressBar mSearchInProgress;
    private View mSearchOnBackgroundView;
    private RefreshableListView mSearchResultView;
    private final android.view.animation.Animation.AnimationListener mTapToStartFadeListener = new android.view.animation.Animation.AnimationListener() {

        final ConversationMenuHelper this$0;

        public void onAnimationEnd(Animation animation)
        {
            mTapToStartText.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

            
            {
                this$0 = ConversationMenuHelper.this;
                super();
            }
    };
    private TextView mTapToStartText;
    private long mWaitingToStartSearchUserId;
    private long mWaitingToStartUserId;

    public ConversationMenuHelper(BaseControllerActionBarActivity basecontrolleractionbaractivity)
    {
        super(basecontrolleractionbaractivity);
        mWaitingToStartUserId = -1L;
        mWaitingToStartSearchUserId = -1L;
        mActivity = basecontrolleractionbaractivity;
    }

    private void displaySearchResults(ArrayList arraylist)
    {
        if (arraylist.isEmpty())
        {
            mSearchResultView.setVisibility(8);
            mSadFace.setVisibility(0);
            mNothingFoundText.setVisibility(0);
            return;
        }
        mSadFace.setVisibility(8);
        if (mFriendSearchAdapter == null)
        {
            mFriendSearchAdapter = new FriendSearchAdapter(mActivity, mAppController, arraylist);
            mSearchResultView.setAdapter(mFriendSearchAdapter);
        } else
        {
            FriendSearchAdapter friendsearchadapter = mFriendSearchAdapter;
            friendsearchadapter.clear();
            friendsearchadapter.setData(arraylist);
            friendsearchadapter.notifyDataSetChanged();
        }
        mSearchResultView.setVisibility(0);
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public TextView getOthersText()
    {
        return mOthersText;
    }

    public boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 26;
           goto _L1 _L2
_L1:
        return false;
_L2:
        mAppController.fetchFriendsTypeAhead(String.valueOf(message.obj));
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131361976: 
        default:
            return;

        case 2131361974: 
            boolean flag;
            if (mTapToStartText != null && mTapToStartText.getVisibility() == 0)
            {
                view = AnimationUtils.loadAnimation(mActivity, 0x7f04000f);
                view.setAnimationListener(mTapToStartFadeListener);
                mTapToStartText.startAnimation(view);
                flag = true;
            } else
            {
                flag = false;
            }
            Util.startActionOnRecordingAvailable(mActivity, AbstractRecordingActivity.getIntentForMessaging(mActivity, 0, flag, "New VM"), 0);
            return;

        case 2131361975: 
            toggleContactSearch(true);
            return;

        case 2131361977: 
            toggleContactSearch(false);
            return;
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        l = mFriendSearchAdapter.getItemId(i);
        mWaitingToStartSearchUserId = l;
        if (l < 1L)
        {
            throw new IllegalStateException("The userRemoteId of the clicked search result item is invalid");
        } else
        {
            mAppController.fetchConversationRowIdFromUserRemoteId(l, 1);
            return;
        }
    }

    public void onPause()
    {
        mAppController.removeListener(mAppSessionListener);
    }

    public void onResume()
    {
        SlidingMenu slidingmenu = getSlidingMenu();
        if (slidingmenu.isMenuShowing())
        {
            slidingmenu.showContent(false);
        }
        mAppController.addListener(mAppSessionListener);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        mHandler.removeMessages(1);
        String s = charsequence.toString().toLowerCase();
        if (!TextUtils.isEmpty(s) && charsequence.length() >= 2)
        {
            charsequence = Message.obtain(null, 1, s);
            if (charsequence != null)
            {
                showSearchProgressBar(true);
                mHandler.sendMessageDelayed(charsequence, 200L);
                mIsSearching = true;
            }
        } else
        if (mIsSearching)
        {
            showSearchProgressBar(false);
            mSearchResultView.setVisibility(8);
            mSadFace.setVisibility(8);
            mIsSearching = false;
            return;
        }
    }

    public void setPersonalizedColor(int i)
    {
        int j;
label0:
        {
            if (i != Settings.DEFAULT_PROFILE_COLOR)
            {
                j = i;
                if (i > 0)
                {
                    break label0;
                }
            }
            j = 0xffffff & mActivity.getResources().getColor(0x7f090096);
        }
        mProfileColor = 0xff000000 | j;
        mActionContainer.setBackgroundColor(mProfileColor);
        if (mInboxFragment != null)
        {
            mInboxFragment.setPersonalizedColor(j);
        }
    }

    public void setupConversationSlidingMenu()
    {
        mAppController = AppController.getInstance(mActivity);
        Object obj = mActivity.setBehindContentView(0x7f03002f);
        mSearchField = (EditText)((View) (obj)).findViewById(0x7f0a00bb);
        mSearchField.addTextChangedListener(this);
        mActionContainer = (ViewGroup)((View) (obj)).findViewById(0x7f0a00b4);
        setPersonalizedColor(Util.getProfileColor(mActivity));
        mSearchContainer = (ViewGroup)((View) (obj)).findViewById(0x7f0a00b8);
        mSearchResultView = (RefreshableListView)((View) (obj)).findViewById(0x7f0a00bf);
        mSearchResultView.setOnItemClickListener(this);
        mSearchOnBackgroundView = ((View) (obj)).findViewById(0x7f0a00be);
        mSearchOnBackgroundView.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationMenuHelper this$0;

            public void onClick(View view)
            {
                toggleContactSearch(false);
            }

            
            {
                this$0 = ConversationMenuHelper.this;
                super();
            }
        });
        mSadFace = ((View) (obj)).findViewById(0x7f0a00c0);
        mNothingFoundText = ((View) (obj)).findViewById(0x7f0a00c2);
        mTapToStartText = (TextView)((View) (obj)).findViewById(0x7f0a00bc);
        ((View) (obj)).findViewById(0x7f0a00b6).setOnClickListener(this);
        ((View) (obj)).findViewById(0x7f0a00b7).setOnClickListener(this);
        ((View) (obj)).findViewById(0x7f0a00b9).setOnClickListener(this);
        ViewUtil.setActionBarHeight(mActivity, ((View) (obj)).findViewById(0x7f0a00b3));
        mSearchInProgress = (ProgressBar)((View) (obj)).findViewById(0x7f0a00ba);
        setSlidingActionBarEnabled(true);
        obj = getSlidingMenu();
        ((SlidingMenu) (obj)).setShadowWidth(35);
        ((SlidingMenu) (obj)).setBehindOffset(mActivity.getResources().getDimensionPixelSize(0x7f0b0071));
        ((SlidingMenu) (obj)).setTouchModeAbove(1);
        ((TouchableRelativeLayout)mActivity.findViewById(0x7f0a00bd)).setTouchListener(new ViewBehindTouchListener(mActivity, ((SlidingMenu) (obj))));
        Object obj1 = mActivity.getSupportFragmentManager();
        android.support.v4.app.Fragment fragment = ((FragmentManager) (obj1)).findFragmentByTag("Inbox");
        if (fragment == null)
        {
            mInboxFragment = new InboxFragment();
            obj1 = ((FragmentManager) (obj1)).beginTransaction();
            ((FragmentTransaction) (obj1)).add(0x7f0a00bd, mInboxFragment, "Inbox");
            ((FragmentTransaction) (obj1)).commit();
        } else
        {
            mInboxFragment = (InboxFragment)fragment;
        }
        ((SlidingMenu) (obj)).setOnClosedListener(mInboxFragment);
        ((SlidingMenu) (obj)).setOnOpenedListener(mInboxFragment);
        mHandler = new Handler(Looper.getMainLooper(), this);
    }

    public void showSearchProgressBar(boolean flag)
    {
        ProgressBar progressbar = mSearchInProgress;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        progressbar.setVisibility(i);
    }

    public void showVmOnboarding()
    {
        mTapToStartText.bringToFront();
        mTapToStartText.setVisibility(0);
    }

    public void showVmOnboardingAfterSend()
    {
        RelativeLayout relativelayout = (RelativeLayout)getSlidingMenu().getMenu();
        TextView textview = (TextView)mActivity.getLayoutInflater().inflate(0x7f030067, relativelayout, false);
        textview.setVisibility(0);
        textview.setText(0x7f0e0281);
        final OnboardingOverlayFadeOutRunnable fadeOut = new OnboardingOverlayFadeOutRunnable();
        fadeOut.setView(textview);
        mHandler.postDelayed(fadeOut, 10000L);
        textview.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationMenuHelper this$0;
            final OnboardingOverlayFadeOutRunnable val$fadeOut;

            public void onClick(View view)
            {
                mHandler.removeCallbacks(fadeOut);
                mHandler.post(fadeOut);
            }

            
            {
                this$0 = ConversationMenuHelper.this;
                fadeOut = onboardingoverlayfadeoutrunnable;
                super();
            }
        });
        fadeOut = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        fadeOut.addRule(12, -1);
        relativelayout.addView(textview, fadeOut);
        mOnboardingOverlay = textview;
    }

    public void toggleContactSearch(boolean flag)
    {
        byte byte0 = 4;
        Object obj = mSearchOnBackgroundView;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        ((View) (obj)).setVisibility(i);
        obj = mSearchContainer;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        ((ViewGroup) (obj)).setVisibility(i);
        obj = mActionContainer;
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        ((ViewGroup) (obj)).setVisibility(i);
        if (flag)
        {
            mSearchField.requestFocus();
        } else
        {
            mSearchField.clearFocus();
            mSearchField.setText("");
        }
        Util.setSoftKeyboardVisibility(mActivity, mSearchField, flag);
    }










/*
    static long access$602(ConversationMenuHelper conversationmenuhelper, long l)
    {
        conversationmenuhelper.mWaitingToStartUserId = l;
        return l;
    }

*/



}
