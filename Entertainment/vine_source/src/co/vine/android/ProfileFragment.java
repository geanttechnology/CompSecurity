// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.animation.HeightAnimation;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.network.HttpResult;
import co.vine.android.provider.VineDatabaseHelper;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import co.vine.android.util.video.VideoKey;
import co.vine.android.widget.FeedAdapter;
import co.vine.android.widget.GenericTimelineAdapter;
import co.vine.android.widget.SectionAdapter;
import co.vine.android.widget.SpanClickListener;
import co.vine.android.widget.Typefaces;
import co.vine.android.widget.TypefacesSpan;
import com.twitter.android.widget.RefreshableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            BaseTimelineFragment, ViewOffsetResolver, StartActivity, Settings, 
//            VineSpanClicker, ProfileHeaderAdapter, ProfileActivity, BaseControllerActionBarActivity, 
//            HomeTabActivity, UsersActivity, BaseActionBarActivity, ConversationActivity, 
//            PendingRequest, LikeCache

public class ProfileFragment extends BaseTimelineFragment
    implements android.view.View.OnClickListener, ViewOffsetResolver, SpanClickListener, android.view.View.OnLongClickListener
{
    private class ColorChangedReceiver extends BroadcastReceiver
    {

        final ProfileFragment this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (intent != null && "co.vine.android.profileColor".equals(intent.getAction()) && mUser != null && mFocused)
            {
                context = (BaseControllerActionBarActivity)getActivity();
                mUser.profileBackground = Util.getDefaultSharedPrefs(context).getInt("profile_background", Settings.DEFAULT_PROFILE_COLOR);
                context.setActionBarColor(mUser.profileBackground);
                context.notifyColorChange(mUser.profileBackground);
                if (mFeedAdapter != null)
                {
                    mFeedAdapter.notifyDataSetChanged();
                }
            }
        }

        private ColorChangedReceiver()
        {
            this$0 = ProfileFragment.this;
            super();
        }

    }

    class PrivateAccountAdapter extends BaseAdapter
    {

        boolean blocked;
        boolean priv;
        final ProfileFragment this$0;

        public int getCount()
        {
            return 1;
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (blocked)
            {
                return LayoutInflater.from(getActivity()).inflate(0x7f030074, viewgroup, false);
            } else
            {
                return LayoutInflater.from(getActivity()).inflate(0x7f030079, viewgroup, false);
            }
        }

        public PrivateAccountAdapter(boolean flag, boolean flag1)
        {
            this$0 = ProfileFragment.this;
            super();
            blocked = flag;
            priv = flag1;
        }
    }

    class ProfileListener extends BaseTimelineFragment.TimeLineSessionListener
    {

        final ProfileFragment this$0;

        private boolean isUsernameValid()
        {
            return mUser != null && !TextUtils.isEmpty(mUser.username);
        }

        public void onAbortAllRequestsComplete()
        {
            refresh();
        }

        public void onBlockUserComplete(String s, int i, String s1, boolean flag)
        {
            if (i == 200)
            {
                mIsUserBlocked = flag;
                getActivity().supportInvalidateOptionsMenu();
                if (flag)
                {
                    if (isUsernameValid())
                    {
                        s = mUser.username;
                    } else
                    {
                        s = getString(0x7f0e026d);
                    }
                    Util.showDefaultToast(getActivity(), getString(0x7f0e0264, new Object[] {
                        s
                    }));
                    VineDatabaseHelper.getDatabaseHelper(getActivity()).removeUserWithType(mUserId, 2, true, co.vine.android.provider.Vine.UserGroupsView.CONTENT_URI_FOLLOWERS);
                    return;
                } else
                {
                    Util.showDefaultToast(getActivity(), getString(0x7f0e0265));
                    return;
                }
            } else
            {
                Util.showDefaultToast(getActivity(), getString(0x7f0e0265));
                return;
            }
        }

        public void onDeletePostComplete(String s, long l, int i, String s1)
        {
            super.onDeletePostComplete(s, l, i, s1);
            if (i == 200)
            {
                if (mFeedAdapter != null)
                {
                    ((FeedAdapter)mFeedAdapter).removePost(l);
                }
                mSectionAdapter.notifyDataSetChanged();
                bindProfileDataAndCounts();
            }
        }

        public void onDisableUserRepostsComplete(String s, int i, String s1, boolean flag)
        {
label0:
            {
label1:
                {
                    if (removeRequest(s) != null)
                    {
                        if (i != 200)
                        {
                            break label0;
                        }
                        if (mUser != null)
                        {
                            s = mUser;
                            if (flag)
                            {
                                i = 0;
                            } else
                            {
                                i = 1;
                            }
                            s.repostsEnabled = i;
                            getActivity().supportInvalidateOptionsMenu();
                            if (!flag)
                            {
                                break label1;
                            }
                            if (isUsernameValid())
                            {
                                s = mUser.username;
                            } else
                            {
                                s = getString(0x7f0e026e);
                            }
                            Util.showDefaultToast(getActivity(), getString(0x7f0e01a9, new Object[] {
                                s
                            }));
                        }
                    }
                    return;
                }
                Util.showDefaultToast(getActivity(), getString(0x7f0e01aa));
                return;
            }
            Util.showDefaultToast(getActivity(), getString(0x7f0e01aa));
        }

        public void onEnableUserRepostsComplete(String s, int i, String s1, boolean flag)
        {
label0:
            {
label1:
                {
                    if (removeRequest(s) != null)
                    {
                        if (i != 200)
                        {
                            break label0;
                        }
                        if (mUser != null)
                        {
                            s = mUser;
                            if (flag)
                            {
                                i = 1;
                            } else
                            {
                                i = 0;
                            }
                            s.repostsEnabled = i;
                            getActivity().supportInvalidateOptionsMenu();
                            if (!flag)
                            {
                                break label1;
                            }
                            if (isUsernameValid())
                            {
                                s = mUser.username;
                            } else
                            {
                                s = getString(0x7f0e026e);
                            }
                            Util.showDefaultToast(getActivity(), getString(0x7f0e01ab, new Object[] {
                                s
                            }));
                        }
                    }
                    return;
                }
                Util.showDefaultToast(getActivity(), getString(0x7f0e01ac));
                return;
            }
            Util.showDefaultToast(getActivity(), getString(0x7f0e01ac));
        }

        public void onGetBlockedUsersComplete(String s, int i, String s1, ArrayList arraylist)
        {
            if (i == 200)
            {
                s = arraylist.iterator();
                do
                {
                    if (!s.hasNext())
                    {
                        break;
                    }
                    if (((VineUser)s.next()).userId != mUserId)
                    {
                        continue;
                    }
                    mIsUserBlocked = true;
                    break;
                } while (true);
                s = getActivity();
                if (s != null)
                {
                    s.supportInvalidateOptionsMenu();
                }
            }
        }

        public void onGetConversationRowIdComplete(long l, long l1, String s, boolean flag)
        {
            if (l == mWaitingToStartUserId)
            {
                mWaitingToStartUserId = -1L;
                mAppController.clearUnreadMessageCount(l1);
                startActivity(ConversationActivity.getIntent(getActivity(), l1, s, l, flag, true));
            }
        }

        public void onGetTimeLineComplete(String s, int i, String s1, int j, int k, boolean flag, ArrayList arraylist, 
                String s2, int l, int i1, int j1, long l1, boolean flag1, 
                int k1, String s3)
        {
            s = removeRequest(s);
            if (s != null)
            {
                if (i == 200)
                {
                    k = 0;
                    if (j == 3)
                    {
                        k = 1;
                    }
                    mProfileHeaderAdapter.updatePostCount(k1, k);
                    mProfileHeaderAdapter.notifyDataSetChanged();
                }
                if (flag && i == 200)
                {
                    mNextPage = i1;
                    mAnchor = l1;
                    s1 = (FeedAdapter)mFeedAdapter;
                    if (((PendingRequest) (s)).fetchType == 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    s1.mergePosts(arraylist, flag);
                    if (mSectionAdapter.getNumberOfAdapters() == 1)
                    {
                        mSectionAdapter = new SectionAdapter(new BaseAdapter[] {
                            mProfileHeaderAdapter, mFeedAdapter
                        });
                        mListView.setAdapter(mSectionAdapter);
                    }
                    mAppController.saveLoadedPosts(arraylist, j, s2, l, i1, j1, l1, false);
                }
                hideProgress(((PendingRequest) (s)).fetchType);
            }
        }

        public void onGetUserComplete(String s, int i, String s1, VineUser vineuser)
        {
            s = removeRequest(s);
            if (s != null)
            {
                if (i == 200)
                {
                    mUser = vineuser;
                    if (isLocked())
                    {
                        mSectionAdapter = null;
                        s1 = ProfileFragment.this;
                        boolean flag;
                        if (isFocused() || mTakeFocus)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        s1.setup(flag);
                    }
                    if (mProfileHeaderAdapter != null)
                    {
                        bindUserData(mUser);
                        mProfileHeaderAdapter.notifyDataSetChanged();
                    }
                }
                hideProgress(((PendingRequest) (s)).fetchType);
            }
        }

        public void onGetUserIdComplete(String s, int i, String s1, long l)
        {
label0:
            {
label1:
                {
label2:
                    {
                        boolean flag1 = false;
                        if (l <= 0L)
                        {
                            break label0;
                        }
                        setUserId(l);
                        s = ProfileFragment.this;
                        boolean flag;
                        if (mUserId == mAppController.getActiveId())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        s.mIsMe = flag;
                        if (!mIsMe)
                        {
                            break label1;
                        }
                        mHideProfileReposts = Util.getDefaultSharedPrefs(getActivity()).getBoolean("profile_hide_reposts", false);
                        s = ProfileFragment.this;
                        if (!isFocused())
                        {
                            flag = flag1;
                            if (!mTakeFocus)
                            {
                                break label2;
                            }
                        }
                        flag = true;
                    }
                    s.setup(flag);
                    initProfile();
                    return;
                }
                mAppController.getBlockedUsers();
                return;
            }
            getActivity().finish();
        }

        public void onGetUsersMeComplete(String s, int i, String s1, long l, VineUser vineuser)
        {
            s = removeRequest(s);
            if (s != null)
            {
                if (i == 200 && mIsMe)
                {
                    mUser = vineuser;
                    if (vineuser != null)
                    {
                        bindUserData(vineuser);
                        mProfileHeaderAdapter.notifyDataSetChanged();
                    }
                }
                hideProgress(((PendingRequest) (s)).fetchType);
                s = new Intent("co.vine.android.profileColor");
                getActivity().sendBroadcast(s, "co.vine.android.BROADCAST");
            }
        }

        public void onLikePost(String s, int i, String s1, long l)
        {
            if (removeRequest(s) != null && i != 200)
            {
                mLikeCache.removeEntry(l);
                mFeedAdapter.showUnlikedByMe(l);
                mFeedAdapter.notifyDataSetChanged();
            }
        }

        public void onPhotoImageError(ImageKey imagekey, HttpResult httpresult)
        {
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            if (mProfileHeaderAdapter != null)
            {
                mProfileHeaderAdapter.onImageLoaded(hashmap);
                mFeedAdapter.setImages(hashmap);
            }
            if (mUserProfileImageKeyForShortcut != null)
            {
                hashmap = (UrlImage)hashmap.get(mUserProfileImageKeyForShortcut);
                if (hashmap != null)
                {
                    addProfileShortCut(((UrlImage) (hashmap)).bitmap);
                }
            }
        }

        public void onReportUserComplete(String s, int i, String s1)
        {
            if (i == 200)
            {
                if (isUsernameValid())
                {
                    s = mUser.username;
                } else
                {
                    s = getString(0x7f0e026e);
                }
                Util.showDefaultToast(getActivity(), getString(0x7f0e0269, new Object[] {
                    s
                }));
                return;
            } else
            {
                Util.showDefaultToast(getActivity(), getString(0x7f0e026a));
                return;
            }
        }

        public void onRespondFollowRequestComplete(String s, int i, String s1, boolean flag, long l)
        {
            if (i == 200)
            {
                if (mFollowHeader != null)
                {
                    mFollowHeader.findViewById(0x7f0a00fa).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, 0));
                    mFollowHeader.setVisibility(8);
                }
                return;
            }
            if (flag)
            {
                Util.showCenteredToast(getActivity(), 0x7f0e003d);
                return;
            } else
            {
                Util.showCenteredToast(getActivity(), 0x7f0e00b7);
                return;
            }
        }

        public void onTrimMemory(int i)
        {
            super.onTrimMemory(i);
            GenericTimelineAdapter generictimelineadapter = mFeedAdapter;
            if (generictimelineadapter != null)
            {
                generictimelineadapter.onTrimMemory(i);
            }
        }

        public void onUnblockUserComplete(String s, int i, String s1, boolean flag)
        {
            if (i == 200)
            {
                s = ProfileFragment.this;
                boolean flag1;
                if (!flag)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                s.mIsUserBlocked = flag1;
                getActivity().supportInvalidateOptionsMenu();
                if (flag)
                {
                    if (isUsernameValid())
                    {
                        s = mUser.username;
                    } else
                    {
                        s = getString(0x7f0e026d);
                    }
                    Util.showDefaultToast(getActivity(), getString(0x7f0e026b, new Object[] {
                        s
                    }));
                    addRequest(mAppController.fetchUser(mUserId));
                    return;
                } else
                {
                    Util.showDefaultToast(getActivity(), getString(0x7f0e0265));
                    return;
                }
            } else
            {
                Util.showDefaultToast(getActivity(), getString(0x7f0e026c));
                return;
            }
        }

        public void onUnlikePost(String s, int i, String s1, long l)
        {
            if (removeRequest(s) != null && i != 200)
            {
                mLikeCache.like(l);
                mFeedAdapter.showLikedByMe(l);
                mFeedAdapter.notifyDataSetChanged();
            }
        }

        public void onUnrevine(String s, int i, String s1, long l)
        {
            if (i == 200)
            {
                ((FeedAdapter)mFeedAdapter).removePost(l);
            }
            super.onUnrevine(s, i, s1, l);
        }

        public void onVideoPathError(VideoKey videokey, HttpResult httpresult)
        {
        }

        public void onVideoPathObtained(HashMap hashmap)
        {
            mFeedAdapter.onVideoPathObtained(hashmap);
        }

        ProfileListener()
        {
            this$0 = ProfileFragment.this;
            super(ProfileFragment.this);
        }
    }


    public static final String ARG_FOLLOW_EVENT_SOURCE = "event_source";
    public static final String ARG_SHOW_PROFILE_ACTIONS = "show_profile_actions";
    public static final String ARG_USER_ID = "user_id";
    public static final String ARG_VANITY_URL = "vanity_url";
    private static final String EVENT_SOURCE_TITLE = "Profile: Tab ";
    public static final String FRAGMENT_TAG = "profile";
    public static final int MODE_LIKES = 2;
    public static final int MODE_POSTS = 1;
    private static final String STATE_HEADER_ADDED = "stated_header_added";
    private static final String STATE_MODE = "state_mode";
    private static final String TAG = "ProfileFragment";
    private TypefacesSpan mBold;
    private final ColorChangedReceiver mColorChangedReceiver = new ColorChangedReceiver();
    private boolean mColorChangedReceiverIsRegistered;
    private int mCurrentMode;
    private int mCurrentTab;
    private android.view.animation.Animation.AnimationListener mDrawerListener;
    protected String mFlurryFollowEventSource;
    private LinearLayout mFollowHeader;
    private boolean mHeaderAdded;
    private boolean mHideProfileReposts;
    private MenuItem mHideRevines;
    private boolean mIsMe;
    private boolean mIsUserBlocked;
    private int mLikePage;
    private int mPostPage;
    PrivateAccountAdapter mPrivateAdapter;
    private int mProfileBackground;
    ProfileHeaderAdapter mProfileHeaderAdapter;
    private SectionAdapter mSectionAdapter;
    private boolean mShowProfileActions;
    private boolean mTakeFocus;
    private VineUser mUser;
    private long mUserId;
    private ImageKey mUserProfileImageKeyForShortcut;
    private int mVineGreen;
    private long mWaitingToStartUserId;

    public ProfileFragment()
    {
        mWaitingToStartUserId = -1L;
        mDrawerListener = new android.view.animation.Animation.AnimationListener() {

            final ProfileFragment this$0;

            public void onAnimationEnd(Animation animation)
            {
                if (getActivity() instanceof HomeTabActivity)
                {
                    ((HomeTabActivity)getActivity()).setScrollAwayNavEnabled(true);
                }
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
                if (getActivity() instanceof HomeTabActivity)
                {
                    ((HomeTabActivity)getActivity()).setScrollAwayNavEnabled(false);
                }
            }

            
            {
                this$0 = ProfileFragment.this;
                super();
            }
        };
    }

    private void addProfileShortCut(Bitmap bitmap)
    {
        mUserProfileImageKeyForShortcut = null;
        FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null)
        {
            FlurryUtils.trackCreateProfileShortCut();
            Intent intent = new Intent(fragmentactivity, co/vine/android/StartActivity);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse((new StringBuilder()).append("https://vine.co/u/").append(mUser.userId).toString()));
            intent.setFlags(0x10000000);
            Intent intent1 = new Intent();
            intent1.putExtra("android.intent.extra.shortcut.INTENT", intent);
            intent1.putExtra("android.intent.extra.shortcut.NAME", mUser.username);
            intent1.putExtra("android.intent.extra.shortcut.ICON", Bitmap.createScaledBitmap(bitmap, 128, 128, true));
            intent1.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
            fragmentactivity.getApplicationContext().sendBroadcast(intent1);
            Util.showCenteredToast(fragmentactivity, 0x7f0e021b);
        }
    }

    private void bindProfileDataAndCounts()
    {
        if (mUser == null)
        {
            return;
        }
        if (mIsMe)
        {
            SharedPreferences sharedpreferences = Util.getDefaultSharedPrefs(getActivity());
            mUser.username = sharedpreferences.getString("settings_profile_name", null);
            mUser.description = sharedpreferences.getString("settings_profile_description", null);
            mUser.location = sharedpreferences.getString("settings_profile_location", null);
            mUser.email = sharedpreferences.getString("settings_profile_email", null);
            mUser.phoneNumber = sharedpreferences.getString("settings_profile_phone", null);
            mUser.avatarUrl = sharedpreferences.getString("settings_profile_avatar_url", null);
            mUser.followingCount = sharedpreferences.getInt("profile_follow_count", 0);
            mUser.followerCount = sharedpreferences.getInt("profile_follower_count", 0);
            mUser.authoredPostCount = sharedpreferences.getInt("profile_authored_post_count", 0);
            mUser.postCount = sharedpreferences.getInt("profile_post_count", 0);
            mUser.likeCount = sharedpreferences.getInt("profile_like_count", 0);
            mUser.loopCount = sharedpreferences.getLong("profile_loop_count", 0L);
            mUser.profileBackground = sharedpreferences.getInt("profile_background", Settings.DEFAULT_PROFILE_COLOR);
        }
        bindUserData(mUser);
    }

    private void dismissDropdown()
    {
        View view = getView();
        if (view != null)
        {
            View view1 = view.findViewById(0x7f0a0196);
            if (view1 != null)
            {
                HeightAnimation heightanimation = new HeightAnimation(getActivity(), view1, false, 300L);
                heightanimation.setAnimationListener(mDrawerListener);
                view1.startAnimation(heightanimation);
            }
            view = view.findViewById(0x7f0a0193);
            if (view instanceof ImageView)
            {
                ((ImageView)view).setColorFilter(new PorterDuffColorFilter(0x4c000000, android.graphics.PorterDuff.Mode.SRC_IN));
            }
        }
    }

    private void initProfile()
    {
        if (mUser != null)
        {
            bindProfileDataAndCounts();
            hideProgress(3);
            return;
        }
        if (mIsMe)
        {
            addRequest(mAppController.fetchUsersMe(mUserId));
            return;
        } else
        {
            addRequest(mAppController.fetchUser(mUserId));
            return;
        }
    }

    private boolean isLocked()
    {
        return mUser != null && !mIsMe && (mUser.isPrivateLocked() || mUser.isBlocked());
    }

    private void setRevineOptionText(VineUser vineuser, boolean flag)
    {
        MenuItem menuitem;
label0:
        {
            menuitem = mHideRevines;
            if (menuitem != null)
            {
                if (vineuser == null || vineuser.isFollowing())
                {
                    break label0;
                }
                menuitem.setVisible(false);
            }
            return;
        }
        if (flag)
        {
            menuitem.setVisible(true);
            menuitem.setTitle(0x7f0e010b);
            return;
        } else
        {
            menuitem.setVisible(true);
            menuitem.setTitle(0x7f0e021c);
            return;
        }
    }

    private void setUserId(long l)
    {
        mUserId = l;
        mVineSpanClicker.setUserId(mUserId);
    }

    private void setup(boolean flag)
    {
        if (mSectionAdapter != null) goto _L2; else goto _L1
_L1:
        if (!isLocked()) goto _L4; else goto _L3
_L3:
        mProfileHeaderAdapter = new ProfileHeaderAdapter(getActivity(), mAppController, this, true, mUser.isBlocked(), mFlurryFollowEventSource, mHideProfileReposts, mShowProfileActions);
        mPrivateAdapter = new PrivateAccountAdapter(mUser.isBlocked(), mUser.isPrivateLocked());
        mSectionAdapter = new SectionAdapter(new BaseAdapter[] {
            mProfileHeaderAdapter, mPrivateAdapter
        });
        mListView.setAdapter(mSectionAdapter);
        mSectionAdapter.notifyDataSetChanged();
_L6:
        return;
_L4:
        mProfileHeaderAdapter = new ProfileHeaderAdapter(getActivity(), mAppController, this, false, false, mFlurryFollowEventSource, mHideProfileReposts, mShowProfileActions);
        mSectionAdapter = new SectionAdapter(new BaseAdapter[] {
            mProfileHeaderAdapter, mFeedAdapter
        });
        if (flag)
        {
            mFeedAdapter.onResume(true);
        }
        mListView.setAdapter(mSectionAdapter);
        mFeedAdapter.setOffsetResolver(this);
        return;
_L2:
        if (mFeedAdapter != null && !isLocked() && flag)
        {
            mFeedAdapter.onResume(true);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    void bindUserData(VineUser vineuser)
    {
        if (vineuser.profileBackground <= 0)
        {
            vineuser.profileBackground = Settings.DEFAULT_PROFILE_COLOR;
        }
        if (vineuser.profileBackground > 0)
        {
            if (getActivity() instanceof ProfileActivity)
            {
                ((BaseControllerActionBarActivity)getActivity()).setActionBarColor(vineuser.profileBackground);
                ((BaseControllerActionBarActivity)getActivity()).notifyColorChange(vineuser.profileBackground);
            }
            if (mFeedAdapter != null)
            {
                mFeedAdapter.setProfileColor(vineuser.profileBackground);
            }
            mProfileBackground = vineuser.profileBackground;
        }
        mProfileHeaderAdapter.bindUser(vineuser);
        if (vineuser.hasFollowApprovalPending() && !mHeaderAdded)
        {
            LinearLayout linearlayout = (LinearLayout)LayoutInflater.from(getActivity()).inflate(0x7f030043, null, false);
            if (mListView != null)
            {
                mListView.addHeaderView(linearlayout);
                ((RelativeLayout)linearlayout.findViewById(0x7f0a00fe)).setOnClickListener(this);
                ((RelativeLayout)linearlayout.findViewById(0x7f0a00fb)).setOnClickListener(this);
                mFollowHeader = linearlayout;
                mHeaderAdded = true;
            }
            mFollowHeader.setVisibility(0);
        }
        setRevineOptionText(vineuser, vineuser.areRepostsEnabled());
        if (vineuser.profileBackground > 0 && mFeedAdapter != null && mListView != null)
        {
            mFeedAdapter.setProfileColor(vineuser.profileBackground);
            RefreshableListView refreshablelistview = (RefreshableListView)mListView;
            refreshablelistview.setPullToRefreshBackgroundColor(0xff000000 | vineuser.profileBackground);
            refreshablelistview.colorizePTR(-1);
        }
    }

    public void changeMode(int i)
    {
        i;
        JVM INSTR tableswitch 1 2: default 24
    //                   1 85
    //                   2 25;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        if (mCurrentMode != 2)
        {
            mCurrentMode = 2;
            setFlurryEventSource("Profile: Tab 2");
            mSectionAdapter = new SectionAdapter(new BaseAdapter[] {
                mProfileHeaderAdapter
            });
            mListView.setAdapter(mSectionAdapter);
            fetchContent(3, true);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (mCurrentMode != 1)
        {
            mCurrentMode = 1;
            mSectionAdapter = new SectionAdapter(new BaseAdapter[] {
                mProfileHeaderAdapter
            });
            mListView.setAdapter(mSectionAdapter);
            setFlurryEventSource("Profile: Tab 1");
            fetchContent(3, true);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void fetchContent(int i, boolean flag)
    {
        mLastFetchType = i;
        if (hasPendingRequest(i))
        {
            return;
        }
        i;
        JVM INSTR tableswitch 2 4: default 40
    //                   2 106
    //                   3 111
    //                   4 111;
           goto _L1 _L2 _L3 _L3
_L1:
        byte byte0;
        if (mHideProfileReposts)
        {
            byte0 = 10;
        } else
        {
            byte0 = 2;
        }
        if (mCurrentMode == 2)
        {
            byte0 = 3;
        }
        addRequest(mAppController.fetchPosts(mAppController.getActiveSession(), 10, mUserId, byte0, mNextPage, mAnchor, flag, String.valueOf(mUserId), null, null), i);
        return;
_L2:
        showProgress(i);
_L3:
        mNextPage = 1;
        mAnchor = 0L;
          goto _L1
    }

    protected String fetchPosts(int i, long l, boolean flag)
    {
        throw new IllegalStateException("Don't call fetch posts for ProfileFragment, this fragment handles its own fetching.");
    }

    public int getOffset(BaseAdapter baseadapter)
    {
        return mSectionAdapter.getPositionOffset(mSectionAdapter.getMyAdapterIndex(baseadapter));
    }

    public long getUserId()
    {
        return mUserId;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (getArguments().getBoolean("take_focus", false))
        {
            bundle = getActivity();
            if (bundle instanceof HomeTabActivity)
            {
                ((HomeTabActivity)bundle).showPage(3, this);
                if (BuildUtil.isLogsOn())
                {
                    Log.d("ProfileFragment", "Me tab took focus.");
                }
            }
        }
        mBold = new TypefacesSpan(null, Typefaces.get(getActivity()).getContentTypeface(1, 4));
        mVineGreen = getActivity().getResources().getColor(0x7f090096);
        setup(mTakeFocus);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR tableswitch 1 1: default 28
    //                   1 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == 1 && mUserId > 0L)
        {
            addRequest(mAppController.fetchFriends(1, 1));
            addRequest(mAppController.fetchFriends(1, 0));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 12: default 112
    //                   2131361891: 118
    //                   2131362043: 198
    //                   2131362046: 178
    //                   2131362188: 118
    //                   2131362189: 118
    //                   2131362190: 132
    //                   2131362192: 164
    //                   2131362194: 223
    //                   2131362196: 164
    //                   2131362199: 218
    //                   2131362211: 519
    //                   2131362212: 519;
           goto _L1 _L2 _L3 _L4 _L2 _L2 _L5 _L6 _L7 _L6 _L8 _L9 _L9
_L1:
        super.onClick(view);
_L11:
        return;
_L2:
        mProfileHeaderAdapter.onProfileHeaderClick(view, this, mUser);
        return;
_L5:
        if (mWaitingToStartUserId != -1L) goto _L11; else goto _L10
_L10:
        mWaitingToStartUserId = mUserId;
        mAppController.fetchConversationRowIdFromUserRemoteId(mUserId, 1);
        return;
_L6:
        mProfileHeaderAdapter.onProfileHeaderClick(view, this, mUser);
        return;
_L4:
        mAppController.acceptFollowRequest(mAppController.getActiveSession(), mUserId);
        return;
_L3:
        mAppController.acceptRejectRequest(mAppController.getActiveSession(), mUserId);
        return;
_L8:
        onDropDownClicked();
        return;
_L7:
        Object obj1 = getResources();
        if (mUser == null || obj1 == null) goto _L11; else goto _L12
_L12:
        view = getView();
        if (view == null) goto _L11; else goto _L13
_L13:
        View view1;
        View view2;
        view2 = view.findViewById(0x7f0a0190);
        view1 = view.findViewById(0x7f0a0196);
        if (view1 == null) goto _L11; else goto _L14
_L14:
        if (view1.getVisibility() == 0)
        {
            dismissDropdown();
            return;
        }
        if (view2 == null) goto _L11; else goto _L15
_L15:
        Object obj = (ProfileHeaderAdapter.DropdownHolder)view1.getTag();
        int i;
        if (mHideProfileReposts)
        {
            i = 0x7f0e021c;
        } else
        {
            i = 0x7f0e010b;
        }
        obj1 = ((Resources) (obj1)).getString(i);
        ((ProfileHeaderAdapter.DropdownHolder) (obj)).revineParent.setVisibility(0);
        Util.setTextWithSpan(mBold, ((String) (obj1)), ((ProfileHeaderAdapter.DropdownHolder) (obj)).revineLabel);
        obj1 = new SpannableStringBuilder(((CharSequence) (obj1)));
        Util.safeSetSpan(((android.text.Spannable) (obj1)), mBold, 0, ((SpannableStringBuilder) (obj1)).length(), 33);
        ((ProfileHeaderAdapter.DropdownHolder) (obj)).revineLabel.setText(((CharSequence) (obj1)));
        obj = ((ProfileHeaderAdapter.DropdownHolder) (obj)).revineIcon;
        if (mHideProfileReposts)
        {
            i = 0x7f0201dd;
        } else
        {
            i = 0x7f020192;
        }
        ((ImageView) (obj)).setImageResource(i);
        obj = new HeightAnimation(getActivity(), view1, true, 300L);
        ((Animation) (obj)).setAnimationListener(mDrawerListener);
        view1.startAnimation(((Animation) (obj)));
        view = view.findViewById(0x7f0a0193);
        if (!(view instanceof ImageView)) goto _L11; else goto _L16
_L16:
        if (mProfileBackground == Settings.DEFAULT_PROFILE_COLOR)
        {
            ((ImageView)view).setColorFilter(new PorterDuffColorFilter(0xff000000 | mVineGreen, android.graphics.PorterDuff.Mode.SRC_IN));
            return;
        } else
        {
            ((ImageView)view).setColorFilter(new PorterDuffColorFilter(0xff000000 | mProfileBackground, android.graphics.PorterDuff.Mode.SRC_IN));
            return;
        }
_L9:
        Intent intent = new Intent(getActivity(), co/vine/android/UsersActivity);
        intent.putExtra("p_id", mUserId);
        byte byte0;
        if (view.getId() == 0x7f0a01a3)
        {
            byte0 = 2;
        } else
        {
            byte0 = 1;
        }
        intent.putExtra("u_type", byte0);
        startActivity(intent);
        return;
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag;
        flag = false;
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        Bundle bundle1 = getArguments();
        setUserId(bundle1.getLong("user_id", -1L));
        setFlurryEventSource("Profile: Tab 1");
        mFlurryFollowEventSource = bundle1.getString("event_source");
        mTakeFocus = bundle1.getBoolean("take_focus", false);
        if (mTakeFocus)
        {
            setFocused(true);
        }
        mAppSessionListener = new ProfileListener();
        if (bundle != null)
        {
            mCurrentMode = bundle.getInt("state_mode");
            if (bundle.containsKey("stated_header_added"))
            {
                mHeaderAdded = bundle.getBoolean("stated_header_added");
            }
        } else
        {
            mCurrentMode = 1;
            mHeaderAdded = false;
        }
        showSadface(false);
        if (mUser != null)
        {
            mUser.repostsEnabled = 1;
        }
        if (bundle1.getStringArrayList("vanity_url") == null) goto _L2; else goto _L1
_L1:
        mAppController.fetchUserId(bundle1.getStringArrayList("vanity_url"));
_L4:
        if (mIsMe)
        {
            bindProfileDataAndCounts();
        }
        mShowProfileActions = bundle1.getBoolean("show_profile_actions", true);
        return;
_L2:
        if (mUserId > 0L)
        {
            if (mUserId == mAppController.getActiveId())
            {
                flag = true;
            }
            mIsMe = flag;
            if (!mIsMe)
            {
                mAppController.getBlockedUsers();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!mIsMe)
        {
            menuinflater.inflate(0x7f10000f, menu);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return createView(layoutinflater, 0x7f030061, viewgroup);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mColorChangedReceiverIsRegistered)
        {
            getActivity().unregisterReceiver(mColorChangedReceiver);
            mColorChangedReceiverIsRegistered = false;
        }
    }

    public void onDropDownClicked()
    {
        boolean flag1 = false;
        boolean flag;
        boolean flag2;
        if (!mHideProfileReposts)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHideProfileReposts = flag;
        flag2 = mHideProfileReposts;
        flag = flag1;
        if (mUser.following > 0)
        {
            flag = true;
        }
        FlurryUtils.trackFilterProfileReposts(flag2, flag, mIsMe);
        if (mIsMe)
        {
            android.content.SharedPreferences.Editor editor = Util.getDefaultSharedPrefs(getActivity()).edit();
            editor.putBoolean("profile_hide_reposts", mHideProfileReposts);
            editor.apply();
        } else
        {
            mAppController.setHideProfileReposts(mUserId, mHideProfileReposts);
        }
        mFeedAdapter.onPause(isFocused());
        fetchContent(3, true);
        dismissDropdown();
    }

    public boolean onLongClick(View view)
    {
        switch (view.getId())
        {
        default:
            return false;

        case 2131361891: 
        case 2131362188: 
        case 2131362189: 
            mProfileHeaderAdapter.onProfileHeaderLongClick(view);
            break;
        }
        return true;
    }

    public void onMoveTo(int i)
    {
        super.onMoveTo(i);
        setup(isFocused());
        bindProfileDataAndCounts();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        boolean flag1 = true;
        menuitem.getItemId();
        JVM INSTR tableswitch 2131362380 2131362384: default 44
    //                   2131362380 52
    //                   2131362381 87
    //                   2131362382 105
    //                   2131362383 161
    //                   2131362384 268;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        boolean flag = super.onOptionsItemSelected(menuitem);
_L8:
        return flag;
_L2:
        if (mIsUserBlocked)
        {
            mAppController.unblockUser(mUserId);
            return true;
        } else
        {
            mAppController.blockUser(mUserId);
            return true;
        }
_L3:
        addRequest(mAppController.reportPerson(mUserId));
        return true;
_L4:
        flag = flag1;
        if (mUser == null) goto _L8; else goto _L7
_L7:
        if (mUser.areRepostsEnabled())
        {
            addRequest(mAppController.disableReposts(mUserId));
            return true;
        } else
        {
            addRequest(mAppController.enableReposts(mUserId));
            return true;
        }
_L5:
        flag = flag1;
        if (mUser == null) goto _L8; else goto _L9
_L9:
        flag = flag1;
        if (mIsMe) goto _L8; else goto _L10
_L10:
        FlurryUtils.trackShareProfile();
        menuitem = new Intent("android.intent.action.SEND");
        menuitem.setType("text/plain");
        menuitem.addFlags(0x80000);
        menuitem.putExtra("android.intent.extra.SUBJECT", "");
        menuitem.putExtra("android.intent.extra.TEXT", Util.getShareProfileMessage(getActivity(), mUser.username, mUser.userId));
        startActivity(Intent.createChooser(menuitem, getString(0x7f0e01be)));
        return true;
_L6:
        if (mUser != null)
        {
            mUserProfileImageKeyForShortcut = new ImageKey(mUser.avatarUrl, true);
            Bitmap bitmap;
            if (TextUtils.isEmpty(mUser.avatarUrl) || Util.isDefaultAvatarUrl(mUser.avatarUrl))
            {
                bitmap = BitmapFactory.decodeResource(getResources(), 0x7f020065);
            } else
            {
                bitmap = mAppController.getPhotoBitmap(mUserProfileImageKeyForShortcut);
            }
            if (bitmap != null)
            {
                addProfileShortCut(bitmap);
            }
        }
        if (true) goto _L1; else goto _L11
_L11:
    }

    public void onPause()
    {
        super.onPause();
        mFeedAdapter.onPause(isFocused());
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
        MenuItem menuitem = menu.findItem(0x7f0a024c);
        boolean flag;
        if (menuitem != null)
        {
            if (mIsUserBlocked)
            {
                menuitem.setTitle(0x7f0e0252);
            } else
            {
                menuitem.setTitle(0x7f0e0053);
            }
        }
        mHideRevines = menu.findItem(0x7f0a024e);
        if (mUser == null || mUser.areRepostsEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setRevineOptionText(mUser, flag);
    }

    public void onResume()
    {
        super.onResume();
        if (mUserId == getAppController().getActiveId())
        {
            registerMergePostReceiver();
        }
        if (mAdapter.isEmpty())
        {
            fetchContent(3, true);
        }
        if (mIsMe)
        {
            mHideProfileReposts = Util.getDefaultSharedPrefs(getActivity()).getBoolean("profile_hide_reposts", false);
            setup(isFocused());
        }
        initProfile();
        if (!mColorChangedReceiverIsRegistered)
        {
            mColorChangedReceiverIsRegistered = true;
            getActivity().registerReceiver(mColorChangedReceiver, Util.COLOR_CHANGED_INTENT_FILTER, "co.vine.android.BROADCAST", null);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("state_mode", mCurrentMode);
        bundle.putBoolean("stated_header_added", mHeaderAdded);
    }

    protected void onScrollLastItem()
    {
        if (!mRefreshable || mNextPage <= 0 || mFeedAdapter.getCount() > 400) goto _L2; else goto _L1
_L1:
        mFeedAdapter.onPause(isFocused());
        mLastFetchType = 1;
        mCurrentMode;
        JVM INSTR tableswitch 1 2: default 68
    //                   1 69
    //                   2 124;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        showProgress(1);
        fetchContent(1, true);
        mPostPage = mPostPage + 1;
        FlurryUtils.trackTimeLinePageScroll((new StringBuilder()).append(getClass().getName()).append("_Post").toString(), mPostPage);
        return;
_L4:
        showProgress(1);
        fetchContent(1, true);
        mLikePage = mLikePage + 1;
        FlurryUtils.trackTimeLinePageScroll((new StringBuilder()).append(getClass().getName()).append("_Like").toString(), mLikePage);
        return;
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        setRefreshableHeaderOffset(6);
        mListView.setOnScrollListener(this);
        showProgress(3);
    }

    protected void refresh()
    {
        fetchContent(2, true);
        if (mIsMe)
        {
            addRequest(mAppController.fetchUsersMe(mAppController.getActiveId()));
            return;
        } else
        {
            addRequest(mAppController.fetchUser(mUserId));
            return;
        }
    }

    public void setActionBarColor()
    {
        FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity instanceof BaseActionBarActivity)
        {
            if (mProfileBackground == 0)
            {
                mProfileBackground = Util.getDefaultSharedPrefs(getActivity()).getInt("profile_background", Settings.DEFAULT_PROFILE_COLOR);
            }
            ((BaseActionBarActivity)fragmentactivity).setActionBarColor(mProfileBackground);
        }
    }




/*
    static long access$102(ProfileFragment profilefragment, long l)
    {
        profilefragment.mWaitingToStartUserId = l;
        return l;
    }

*/


/*
    static boolean access$1102(ProfileFragment profilefragment, boolean flag)
    {
        profilefragment.mIsUserBlocked = flag;
        return flag;
    }

*/





/*
    static boolean access$1502(ProfileFragment profilefragment, boolean flag)
    {
        profilefragment.mHideProfileReposts = flag;
        return flag;
    }

*/




/*
    static SectionAdapter access$202(ProfileFragment profilefragment, SectionAdapter sectionadapter)
    {
        profilefragment.mSectionAdapter = sectionadapter;
        return sectionadapter;
    }

*/



/*
    static boolean access$302(ProfileFragment profilefragment, boolean flag)
    {
        profilefragment.mIsMe = flag;
        return flag;
    }

*/



/*
    static VineUser access$402(ProfileFragment profilefragment, VineUser vineuser)
    {
        profilefragment.mUser = vineuser;
        return vineuser;
    }

*/





}
