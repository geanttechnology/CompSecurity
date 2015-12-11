// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.api.VineRecipient;
import co.vine.android.service.VineUploadService;
import co.vine.android.util.Util;
import co.vine.android.util.ViewUtil;
import co.vine.android.views.FlowLayout;
import co.vine.android.widget.FakeActionBar;
import co.vine.android.widget.Typefaces;
import co.vine.android.widget.TypefacesEditText;
import co.vine.android.widget.TypefacesTextView;
import co.vine.android.widget.tabs.IconTabHost;
import co.vine.android.widget.tabs.TabIndicator;
import co.vine.android.widget.tabs.TabInfo;
import co.vine.android.widget.tabs.TabsAdapter;
import co.vine.android.widget.tabs.ViewPagerScrollBar;
import com.edisonwang.android.slog.SLog;
import com.twitter.android.widget.TopScrollable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, Settings, BaseRecipientPickerFragment, FriendsRecipientPickerFragment, 
//            ContactsRecipientPickerFragment, HomeTabActivity, BaseCursorListFragment

public class RecipientPickerActivity extends BaseControllerActionBarActivity
    implements android.widget.TabHost.OnTabChangeListener, co.vine.android.widget.tabs.IconTabHost.OnTabClickedListener, TextWatcher, co.vine.android.widget.TypefacesEditText.KeyboardListener
{
    public class RecipientItemClickListener
        implements android.view.View.OnClickListener
    {

        private final int position;
        private final VineRecipient recipient;
        final RecipientPickerActivity this$0;

        public void onClick(View view)
        {
            onItemClick(recipient);
        }

        public RecipientItemClickListener(VineRecipient vinerecipient, int i)
        {
            this$0 = RecipientPickerActivity.this;
            super();
            recipient = vinerecipient;
            position = i;
        }
    }


    public static final String ARG_TAG = "tag";
    public static final String EXTRA_IS_VM_ONBOARDING = "is_vm_onboarding";
    public static final String EXTRA_MAX_LOOPS = "max_loops";
    public static final String EXTRA_MESSAGE = "message";
    public static final String EXTRA_POST_ID = "post_id";
    public static final String EXTRA_PREVIEW_PATH = "preview_path";
    public static final String EXTRA_SHARED_THUMB_URL = "thumb_url";
    public static final String EXTRA_SHARED_VIDEO_URL = "vid_url";
    public static final String EXTRA_THUMBNAIL_PATH = "thumbnail_path";
    public static final String EXTRA_VIDEO_PATH = "video_path";
    private static final int OVERFLOW_INDEX = 3;
    public static final String TAG_ADDRESS_BOOK = "address_book";
    public static final String TAG_FRIENDS = "friends";
    private boolean isForcingFullList;
    private String mCaptionMessage;
    private float mDensity;
    private FlowLayout mFlowLayout;
    private boolean mIsVmOnboarding;
    private final VineRecipient mLastExtra = VineRecipient.fromEmail(null, -1L, null, 0L);
    private int mMaxLoops;
    private TextView mOnboardingOverlay;
    private View mOverFlowView;
    private long mPostId;
    private int mProfileColor;
    private EditText mQuery;
    private CharSequence mQueryHint;
    private final ArrayList mRecipients = new ArrayList();
    private final ArrayList mRecycledViews = new ArrayList();
    private int mSelectedForRemoval;
    private ImageView mSendButton;
    private String mSharedThumbnailUrl;
    private String mSharedVideoUrl;
    private IconTabHost mTabHost;
    private TabsAdapter mTabsAdapter;
    private String mVideoPath;
    private ViewPager mViewPager;
    private int mVineGreen;
    private final android.view.animation.Animation.AnimationListener mVmOnboardingFadeListener = new android.view.animation.Animation.AnimationListener() {

        final RecipientPickerActivity this$0;

        public void onAnimationEnd(Animation animation)
        {
            mOnboardingOverlay.setVisibility(8);
            mOnboardingOverlay.setClickable(false);
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

            
            {
                this$0 = RecipientPickerActivity.this;
                super();
            }
    };

    public RecipientPickerActivity()
    {
        mSelectedForRemoval = -1;
    }

    private void addSendIcon()
    {
        Object obj = getResources();
        FakeActionBar fakeactionbar = getFakeActionBar();
        obj = new ImageView(((Resources) (obj)).getColor(0x7f090057)) {

            final RecipientPickerActivity this$0;
            final int val$gray;

            public void setEnabled(boolean flag)
            {
                super.setEnabled(flag);
                int i;
                if (flag)
                {
                    i = mProfileColor;
                } else
                {
                    i = gray;
                }
                setColorFilter(new PorterDuffColorFilter(i, android.graphics.PorterDuff.Mode.SRC_IN));
            }

            
            {
                this$0 = RecipientPickerActivity.this;
                gray = i;
                super(final_context);
            }
        };
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams((int)((double)mDensity * 36.5D), (int)((double)mDensity * 36.5D));
        ((ImageView) (obj)).setImageResource(0x7f020137);
        ((ImageView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final RecipientPickerActivity this$0;

            public void onClick(View view)
            {
                onSendButtonClicked();
            }

            
            {
                this$0 = RecipientPickerActivity.this;
                super();
            }
        });
        ((ImageView) (obj)).setLayoutParams(layoutparams);
        ((ImageView) (obj)).setScaleType(android.widget.ImageView.ScaleType.CENTER);
        fakeactionbar.getActionBarRight().addView(((View) (obj)));
        mSendButton = ((ImageView) (obj));
        mSendButton.setEnabled(isSendButtonEnabled());
    }

    private View bindOrCreateViewForRecipient(int i, View view, VineRecipient vinerecipient, boolean flag)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = getLayoutInflater().inflate(0x7f030081, mFlowLayout, false);
        }
        TypefacesTextView typefacestextview = (TypefacesTextView)((RelativeLayout)view1).getChildAt(0);
        typefacestextview.setOnClickListener(new RecipientItemClickListener(vinerecipient, i));
        if (vinerecipient.color <= 0 || vinerecipient.color == Settings.DEFAULT_PROFILE_COLOR)
        {
            vinerecipient.color = mVineGreen;
        }
        view = typefacestextview.getBackground();
        if (!(view instanceof GradientDrawable))
        {
            view = new GradientDrawable();
            view.setShape(0);
            view.setCornerRadius(mDensity * 2.0F);
        } else
        {
            view = (GradientDrawable)view;
        }
        if (flag)
        {
            view.setStroke((int)(mDensity * 2.0F), vinerecipient.color | 0xff000000);
            view.setColor(0);
            typefacestextview.setTextColor(vinerecipient.color | 0xff000000);
        } else
        {
            view.setStroke(0, 0);
            view.setColor(vinerecipient.color | 0xff000000);
            typefacestextview.setTextColor(getResources().getColor(0x7f090083));
        }
        ViewUtil.setBackground(typefacestextview, view);
        typefacestextview.setText(vinerecipient.display);
        return view1;
    }

    public static Intent getIntent(Activity activity, long l, String s, String s1)
    {
        activity = new Intent(activity, co/vine/android/RecipientPickerActivity);
        activity.putExtra("post_id", l);
        activity.putExtra("vid_url", s);
        activity.putExtra("thumb_url", s1);
        return activity;
    }

    public static Intent getIntent(Activity activity, String s, String s1, String s2, String s3, int i, boolean flag)
    {
        activity = new Intent(activity, co/vine/android/RecipientPickerActivity);
        activity.putExtra("message", s);
        activity.putExtra("video_path", s1);
        activity.putExtra("thumbnail_path", s2);
        activity.putExtra("preview_path", s3);
        activity.putExtra("max_loops", i);
        activity.putExtra("is_vm_onboarding", flag);
        return activity;
    }

    private void invalidateDisplayForExtra(int i)
    {
        if (i == 1)
        {
            mLastExtra.display = getString(0x7f0e004d);
            return;
        } else
        {
            mLastExtra.display = getString(0x7f0e004c, new Object[] {
                Integer.valueOf(i)
            });
            return;
        }
    }

    private void invalidateEditTextUI(int i, VineRecipient vinerecipient, boolean flag, boolean flag1)
    {
        SLog.d("Invalidate UI: adding: {}, original index: {}, wasOverflow: {}.", Boolean.valueOf(flag), Integer.valueOf(i), Boolean.valueOf(flag1));
        SLog.d("Before child count: {}.", Integer.valueOf(mFlowLayout.getChildCount()));
        if (!flag) goto _L2; else goto _L1
_L1:
        if (isInOverflowMode())
        {
            invalidateDisplayForExtra(mRecipients.size() - 3);
            mOverFlowView = bindOrCreateViewForRecipient(i, mOverFlowView, mLastExtra, false);
            if (mFlowLayout.getChildCount() <= 4)
            {
                mFlowLayout.addView(mOverFlowView, 3);
            }
        } else
        {
            if (mRecycledViews.isEmpty())
            {
                vinerecipient = bindOrCreateViewForRecipient(i, null, vinerecipient, false);
            } else
            {
                vinerecipient = bindOrCreateViewForRecipient(i, (View)mRecycledViews.remove(mRecycledViews.size() - 1), vinerecipient, false);
            }
            mFlowLayout.addView(vinerecipient, mFlowLayout.getChildCount() - 1);
        }
_L9:
        SLog.d("After child count: {}.", Integer.valueOf(mFlowLayout.getChildCount()));
        return;
_L2:
        if (!flag1) goto _L4; else goto _L3
_L3:
        if (i >= 3) goto _L6; else goto _L5
_L5:
        vinerecipient = (VineRecipient)mRecipients.get(2);
        mRecycledViews.add(mFlowLayout.getChildAt(i));
        mFlowLayout.removeViewAt(i);
        if (mRecycledViews.isEmpty())
        {
            vinerecipient = bindOrCreateViewForRecipient(i, null, vinerecipient, false);
        } else
        {
            vinerecipient = bindOrCreateViewForRecipient(i, (View)mRecycledViews.remove(mRecycledViews.size() - 1), vinerecipient, false);
        }
        mFlowLayout.addView(vinerecipient, 2);
        if (isInOverflowMode())
        {
            invalidateDisplayForExtra(mRecipients.size() - 3);
            bindOrCreateViewForRecipient(i, mOverFlowView, mLastExtra, false);
        }
_L7:
        if (!isInOverflowMode())
        {
            mFlowLayout.removeView(mOverFlowView);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (isInOverflowMode() && i != 3)
        {
            invalidateDisplayForExtra(mRecipients.size() - 3);
            bindOrCreateViewForRecipient(i, mOverFlowView, mLastExtra, false);
        }
        if (true) goto _L7; else goto _L4
_L4:
        mRecycledViews.add(mFlowLayout.getChildAt(i));
        mFlowLayout.removeViewAt(i);
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void notifyItemRemoval(VineRecipient vinerecipient)
    {
        Iterator iterator = getSupportFragmentManager().getFragments().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Fragment fragment = (Fragment)iterator.next();
            if (fragment instanceof BaseRecipientPickerFragment)
            {
                ((BaseRecipientPickerFragment)fragment).onRecipientItemRemoved(vinerecipient);
            }
        } while (true);
    }

    private void setItemForRemoval(int i)
    {
        if (mSelectedForRemoval >= 0)
        {
            bindOrCreateViewForRecipient(mSelectedForRemoval, mFlowLayout.getChildAt(mSelectedForRemoval), (VineRecipient)mRecipients.get(mSelectedForRemoval), false);
        }
        if (i >= 0)
        {
            bindOrCreateViewForRecipient(i, mFlowLayout.getChildAt(i), (VineRecipient)mRecipients.get(i), true);
        }
        mSelectedForRemoval = i;
    }

    public void addRecipient(VineRecipient vinerecipient)
    {
        boolean flag = isInOverflowMode();
        mRecipients.add(vinerecipient);
        SLog.d("Recipient added: {} {} {}", vinerecipient.key, Long.valueOf(vinerecipient.userId), vinerecipient.value);
        if (!TextUtils.isEmpty(mQuery.getHint()))
        {
            mQueryHint = mQuery.getHint();
            mQuery.setHint("");
        }
        if (!TextUtils.isEmpty(mQuery.getText()))
        {
            mQuery.setText("");
        }
        invalidateEditTextUI(mRecipients.size() - 1, vinerecipient, true, flag);
        if (mSendButton != null)
        {
            mSendButton.setEnabled(isSendButtonEnabled());
        }
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public int getCount()
    {
        if (isForcingFullList)
        {
            return mRecipients.size();
        } else
        {
            return Math.min(mRecipients.size(), 3);
        }
    }

    public boolean isFakeActionBarEnabled()
    {
        return true;
    }

    public boolean isInOverflowMode()
    {
        return !isForcingFullList && mRecipients.size() > getCount();
    }

    public boolean isRecipientSelected(VineRecipient vinerecipient)
    {
        return mRecipients.contains(vinerecipient);
    }

    public boolean isSendButtonEnabled()
    {
        return mRecipients.size() > 0;
    }

    public boolean isShowing(String s)
    {
        return s != null && s.equals(mTabHost.getCurrentTabTag());
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        Fragment fragment = mTabsAdapter.getCurrentFragment();
        if (fragment instanceof BaseRecipientPickerFragment)
        {
            fragment.onActivityResult(i, j, intent);
        }
    }

    public void onBackPressed()
    {
        if (!TextUtils.isEmpty(mQuery.getText()))
        {
            mQuery.setText("");
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f03007d, true);
        bundle = getIntent();
        mVineGreen = getResources().getColor(0x7f090096);
        mVideoPath = bundle.getStringExtra("video_path");
        setupActionBar(Boolean.valueOf(false), Boolean.valueOf(true), 0x7f0e01c0, Boolean.valueOf(true));
        mProfileColor = Util.getDefaultSharedPrefs(this).getInt("profile_background", Settings.DEFAULT_PROFILE_COLOR);
        if (mProfileColor == Settings.DEFAULT_PROFILE_COLOR || mProfileColor <= 0)
        {
            mProfileColor = 0xffffff & getResources().getColor(0x7f090096);
        }
        mProfileColor = 0xff000000 | mProfileColor;
        Object obj1 = (ViewPagerScrollBar)findViewById(0x7f0a011c);
        ((ViewPagerScrollBar) (obj1)).setLineColor(mProfileColor);
        ((ViewPagerScrollBar) (obj1)).setRange(2);
        Object obj = TabIndicator.createTextColorList(mProfileColor, getResources().getColor(0x7f090057));
        bundle = (ViewPager)findViewById(0x7f0a00da);
        bundle.setPageMargin(getResources().getDimensionPixelSize(0x7f0b0054));
        bundle.setPageMarginDrawable(0x7f09000e);
        bundle.setOffscreenPageLimit(1);
        IconTabHost icontabhost = mTabHost;
        obj1 = new TabsAdapter(this, icontabhost, bundle, ((ViewPagerScrollBar) (obj1)));
        ((TabsAdapter) (obj1)).setSetActionBarColorOnPageSelectedEnabled(false);
        LayoutInflater layoutinflater = LayoutInflater.from(this);
        icontabhost.setOnTabChangedListener(this);
        icontabhost.setOnTabClickedListener(this);
        Bundle bundle1 = new Bundle();
        bundle1.putString("tag", "friends");
        bundle1.putBoolean("refresh", true);
        bundle1.putInt("empty_desc", 0x7f0e0151);
        TabIndicator tabindicator = TabIndicator.newTextIndicator(layoutinflater, 0x7f030062, icontabhost, 0x7f0e023f, false);
        TextView textview = tabindicator.getIndicatorText();
        textview.setTextColor(((android.content.res.ColorStateList) (obj)));
        textview.setTypeface(Typefaces.get(this).boldContent);
        ((TabsAdapter) (obj1)).addTab(icontabhost.newTabSpec("friends").setIndicator(tabindicator), co/vine/android/FriendsRecipientPickerFragment, bundle1);
        bundle1 = new Bundle();
        bundle1.putString("tag", "address_book");
        bundle1.putBoolean("refresh", false);
        bundle1.putInt("empty_desc", 0x7f0e014f);
        tabindicator = TabIndicator.newTextIndicator(layoutinflater, 0x7f030062, icontabhost, 0x7f0e0237, false);
        textview = tabindicator.getIndicatorText();
        textview.setTextColor(((android.content.res.ColorStateList) (obj)));
        textview.setTypeface(Typefaces.get(this).regularContentBold);
        ((TabsAdapter) (obj1)).addTab(icontabhost.newTabSpec("address_book").setIndicator(tabindicator), co/vine/android/ContactsRecipientPickerFragment, bundle1);
        mCaptionMessage = getIntent().getStringExtra("message");
        mMaxLoops = getIntent().getIntExtra("max_loops", 0);
        mPostId = getIntent().getLongExtra("post_id", 0L);
        mSharedVideoUrl = getIntent().getStringExtra("vid_url");
        mSharedThumbnailUrl = getIntent().getStringExtra("thumb_url");
        ((ViewGroup)findViewById(0x1020013)).setBackgroundColor(getResources().getColor(0x7f090083));
        mFlowLayout = (FlowLayout)findViewById(0x7f0a01a6);
        obj = (TypefacesEditText)layoutinflater.inflate(0x7f03007f, mFlowLayout, false);
        ((TypefacesEditText) (obj)).setKeyboardListener(this);
        ((TypefacesEditText) (obj)).addTextChangedListener(this);
        ((TypefacesEditText) (obj)).setInputType(0x80000);
        ((TypefacesEditText) (obj)).setTypeface(Typefaces.get(this).boldContent);
        mFlowLayout.addView(((View) (obj)));
        mQuery = ((EditText) (obj));
        mQuery.setOnClickListener(new android.view.View.OnClickListener() {

            final RecipientPickerActivity this$0;

            public void onClick(View view)
            {
                setForceFullList(false);
            }

            
            {
                this$0 = RecipientPickerActivity.this;
                super();
            }
        });
        mTabsAdapter = ((TabsAdapter) (obj1));
        mViewPager = bundle;
        mIsVmOnboarding = getIntent().getBooleanExtra("is_vm_onboarding", false);
        if (mIsVmOnboarding)
        {
            mOnboardingOverlay = (TextView)findViewById(0x7f0a01a7);
            mOnboardingOverlay.setText(getString(0x7f0e020e));
            mOnboardingOverlay.setVisibility(0);
            mOnboardingOverlay.setOnClickListener(new android.view.View.OnClickListener() {

                final RecipientPickerActivity this$0;

                public void onClick(View view)
                {
                    view = AnimationUtils.loadAnimation(RecipientPickerActivity.this, 0x7f04000f);
                    view.setAnimationListener(mVmOnboardingFadeListener);
                    mOnboardingOverlay.startAnimation(view);
                }

            
            {
                this$0 = RecipientPickerActivity.this;
                super();
            }
            });
        }
        mDensity = getResources().getDisplayMetrics().density;
    }

    public void onCurrentTabClicked()
    {
        scrollTop();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        mQuery.removeTextChangedListener(this);
    }

    public void onItemClick(VineRecipient vinerecipient)
    {
        if (mLastExtra == vinerecipient)
        {
            setForceFullList(true);
            return;
        }
        int i = mRecipients.indexOf(vinerecipient);
        if (mSelectedForRemoval == i)
        {
            setItemForRemoval(-1);
            return;
        } else
        {
            setItemForRemoval(i);
            return;
        }
    }

    public void onKeyboardDismissed()
    {
        setForceFullList(false);
    }

    public void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        Object obj = getResources();
        bundle = getFakeActionBar();
        obj = ((Resources) (obj)).getDrawable(0x7f02014c);
        ((Drawable) (obj)).setColorFilter(new PorterDuffColorFilter(mProfileColor, android.graphics.PorterDuff.Mode.SRC_IN));
        bundle.getBackIcon().setImageDrawable(((Drawable) (obj)));
        bundle.getTitleView().setTypeface(Typefaces.get(this).mediumContent);
        bundle.getTitleView().setTextSize(2, 18F);
        addSendIcon();
    }

    protected void onResume()
    {
        super.onResume();
        mTabsAdapter.previousTab = mTabHost.getCurrentTab();
    }

    public void onSendButtonClicked()
    {
        if (!mRecipients.isEmpty())
        {
            if (mPostId > 0L)
            {
                startService(VineUploadService.getVMSharePostIntent(this, false, -1L, new ArrayList(mRecipients), mPostId, mSharedVideoUrl, mSharedThumbnailUrl));
            } else
            {
                startService(VineUploadService.getVMPostIntent(this, mVideoPath, false, -1L, new ArrayList(mRecipients), mCaptionMessage, mMaxLoops));
            }
            startService(VineUploadService.getShowProgressIntent(this));
            if (mIsVmOnboarding || mPostId <= 0L)
            {
                Intent intent = new Intent(getApplicationContext(), co/vine/android/HomeTabActivity);
                intent.setAction("co.vine.android.VM_SENT");
                intent.putExtra("is_vm_onboarding", mIsVmOnboarding);
                intent.setFlags(0x4000000);
                startActivity(intent);
            }
            finish();
        }
    }

    public void onSupportContentChanged()
    {
        super.onSupportContentChanged();
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

    public void onTabChanged(String s)
    {
        mViewPager.setCurrentItem(mTabHost.getCurrentTab());
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        Fragment fragment = mTabsAdapter.getCurrentFragment();
        if (fragment instanceof BaseRecipientPickerFragment)
        {
            ((BaseRecipientPickerFragment)fragment).onTextChanged(charsequence, i, j, k);
        }
        if (k > 0)
        {
            setItemForRemoval(-1);
        }
    }

    public void removeRecipient(VineRecipient vinerecipient)
    {
        boolean flag = isInOverflowMode();
        int i = mRecipients.indexOf(vinerecipient);
        mRecipients.remove(vinerecipient);
        SLog.d("Recipient removed: {} {} {}", vinerecipient.key, Long.valueOf(vinerecipient.userId), vinerecipient.value);
        if (mRecipients.size() == 0)
        {
            mQuery.setHint(mQueryHint);
        }
        invalidateEditTextUI(i, vinerecipient, false, flag);
        mSelectedForRemoval = -1;
        if (mSendButton != null)
        {
            mSendButton.setEnabled(isSendButtonEnabled());
        }
    }

    public void scrollTop()
    {
        Fragment fragment;
        Object obj;
        if (mTabsAdapter != null && mViewPager != null)
        {
            if (((fragment = mTabsAdapter.getCurrentFragment()) instanceof BaseCursorListFragment) && (obj = fragment.getView()) != null && ((obj = (TopScrollable)((View) (obj)).findViewById(0x102000a)) != null && !((TopScrollable) (obj)).scrollTop()))
            {
                ((BaseCursorListFragment)fragment).invokeScrollFirstItem();
                return;
            }
        }
    }

    public boolean sendKeyEvent(KeyEvent keyevent)
    {
        if (keyevent.getAction() != 1 || keyevent.getKeyCode() != 67)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        if (mSelectedForRemoval >= 0)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        keyevent = mQuery.getText();
        if (keyevent == null || keyevent.length() != 0)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        if (!isInOverflowMode()) goto _L2; else goto _L1
_L1:
        setForceFullList(true);
_L4:
        return true;
_L2:
        if (mRecipients.size() <= 0) goto _L4; else goto _L3
_L3:
        int i = mRecipients.size();
        if (mSelectedForRemoval >= 0) goto _L4; else goto _L5
_L5:
        setItemForRemoval(i - 1);
        return true;
        keyevent = (VineRecipient)mRecipients.get(mSelectedForRemoval);
        removeRecipient(keyevent);
        notifyItemRemoval(keyevent);
        return false;
    }

    public void setForceFullList(boolean flag)
    {
        if (isForcingFullList != flag) goto _L2; else goto _L1
_L1:
        return;
_L2:
        isForcingFullList = flag;
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        mFlowLayout.removeViewAt(3);
        int i = 3;
        while (i < mRecipients.size()) 
        {
            invalidateEditTextUI(i, (VineRecipient)mRecipients.get(i), true, true);
            i++;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!isInOverflowMode()) goto _L1; else goto _L4
_L4:
        if (mSelectedForRemoval >= 3)
        {
            setItemForRemoval(-1);
        }
        for (; mFlowLayout.getChildCount() > 4; mFlowLayout.removeViewAt(3)) { }
        invalidateEditTextUI(3, mLastExtra, true, false);
        return;
    }

    public void showPage(String s)
    {
        ArrayList arraylist = mTabsAdapter.getTabs();
        for (int i = 0; i < arraylist.size(); i++)
        {
            if (s.equals(((TabInfo)arraylist.get(i)).getTag()))
            {
                mViewPager.setCurrentItem(i, true);
            }
        }

    }



}
