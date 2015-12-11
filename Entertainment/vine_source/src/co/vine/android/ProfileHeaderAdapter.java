// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.SystemUtil;
import co.vine.android.util.Util;
import co.vine.android.util.ViewUtil;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import co.vine.android.widget.DotIndicators;
import co.vine.android.widget.Typefaces;
import co.vine.android.widget.TypefacesSpan;
import co.vine.android.widget.TypefacesTextView;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            Settings, ProfileFragment, SettingsActivity, HomeTabActivity, 
//            ImageActivity

public class ProfileHeaderAdapter extends BaseAdapter
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{
    public static class DropdownHolder
    {

        public final ImageView revineIcon;
        public final TextView revineLabel;
        public final View revineParent;

        public DropdownHolder(View view)
        {
            revineParent = view.findViewById(0x7f0a0197);
            revineLabel = (TextView)view.findViewById(0x7f0a0198);
            revineIcon = (ImageView)view.findViewById(0x7f0a0199);
        }
    }

    static class PagerDetailsViewHolder
    {

        public TextView description;
        public TextView location;
        public View parent;
        public TextView userLoopCount;

        public PagerDetailsViewHolder(View view)
        {
            parent = view.findViewById(0x7f0a019c);
            location = (TextView)view.findViewById(0x7f0a019e);
            description = (TextView)view.findViewById(0x7f0a019d);
            userLoopCount = (TextView)view.findViewById(0x7f0a019f);
        }
    }

    static class PagerMainViewHolder
    {

        public final TypefacesTextView followers;
        public final TypefacesTextView following;
        public ImageView imageAction;
        public ImageView imageFrame;
        public ImageView imageView;
        public ImageKey userImageKey;
        public TextView username;
        public ImageView verified;

        public PagerMainViewHolder(View view)
        {
            imageFrame = (ImageView)view.findViewById(0x7f0a022a);
            username = (TextView)view.findViewById(0x7f0a00c4);
            verified = (ImageView)view.findViewById(0x7f0a01a2);
            imageView = (ImageView)view.findViewById(0x7f0a0063);
            imageAction = (ImageView)view.findViewById(0x7f0a022b);
            followers = (TypefacesTextView)view.findViewById(0x7f0a01a3);
            following = (TypefacesTextView)view.findViewById(0x7f0a01a4);
        }
    }

    static class ProfileViewHolder
    {

        public final DotIndicators dots;
        public final DropdownHolder dropDownHolder;
        public final Button follow;
        public final TypefacesTextView likesLabel;
        public final View likesParent;
        public final Button messageButton;
        public final ViewPager pager;
        public final TypefacesTextView postsLabel;
        public final View postsParent;
        public final ViewGroup profileActions;
        public final RelativeLayout profileBackground;
        public final ViewGroup profileTabArrow;
        public final ImageView profileTabArrowImage;
        public final ProgressBar progress;
        public final Button settings;
        public long userId;

        public ProfileViewHolder(View view)
        {
            pager = (ViewPager)view.findViewById(0x7f0a00da);
            profileBackground = (RelativeLayout)view.findViewById(0x7f0a018a);
            follow = (Button)view.findViewById(0x7f0a018d);
            settings = (Button)view.findViewById(0x7f0a018c);
            messageButton = (Button)view.findViewById(0x7f0a018e);
            postsParent = view.findViewById(0x7f0a0190);
            postsLabel = (TypefacesTextView)view.findViewById(0x7f0a0191);
            likesParent = view.findViewById(0x7f0a0194);
            likesLabel = (TypefacesTextView)view.findViewById(0x7f0a0195);
            progress = (ProgressBar)view.findViewById(0x7f0a019a);
            profileTabArrow = (ViewGroup)view.findViewById(0x7f0a0192);
            profileTabArrowImage = (ImageView)view.findViewById(0x7f0a0193);
            dots = (DotIndicators)view.findViewById(0x7f0a00db);
            profileActions = (ViewGroup)view.findViewById(0x7f0a018b);
            view = view.findViewById(0x7f0a0196);
            dropDownHolder = new DropdownHolder(view);
            view.setTag(dropDownHolder);
        }
    }

    private class ProfileViewPagerAdapter extends PagerAdapter
    {

        public static final int PAGER_COUNT = 2;
        public static final int PAGER_INDEX_DETAILS = 1;
        public static final int PAGER_INDEX_MAIN = 0;
        final ProfileHeaderAdapter this$0;

        public int getCount()
        {
            return 2;
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            Object obj = (LayoutInflater)viewgroup.getContext().getSystemService("layout_inflater");
            i;
            JVM INSTR tableswitch 0 1: default 36
        //                       0 40
        //                       1 98;
               goto _L1 _L2 _L3
_L1:
            viewgroup = null;
_L5:
            return viewgroup;
_L2:
            obj = ((LayoutInflater) (obj)).inflate(0x7f030078, viewgroup, false);
            mHolderPagerMain = new PagerMainViewHolder(((View) (obj)));
            viewgroup.addView(((View) (obj)));
            viewgroup = ((ViewGroup) (obj));
            if (mUser == null) goto _L5; else goto _L4
_L4:
            bindUser(mUser);
            return obj;
_L3:
            obj = ((LayoutInflater) (obj)).inflate(0x7f030077, viewgroup, false);
            mHolderPagerDetails = new PagerDetailsViewHolder(((View) (obj)));
            viewgroup.addView(((View) (obj)));
            if (mUser != null)
            {
                bindUser(mUser);
            }
            invalidateDetailHeight();
            return obj;
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            return view == obj;
        }

        private ProfileViewPagerAdapter()
        {
            this$0 = ProfileHeaderAdapter.this;
            super();
        }

    }


    private static final int FOLLOWING = 2;
    private static final int FOLLOW_REQUESTED = 3;
    private static final int NOT_FOLLOWING = 1;
    private static final int SPAN_FLAGS = 33;
    public static final int TAB_LIKES = 1;
    public static final int TAB_POST = 0;
    private AppController mAppController;
    private boolean mBlocked;
    private final TypefacesSpan mBold;
    private Context mContext;
    private int mCurrentTab;
    private int mDetailPageHeight;
    private String mFollowEventSource;
    private int mFollowState;
    private final ProfileFragment mFragment;
    private ProfileViewHolder mHolder;
    private PagerDetailsViewHolder mHolderPagerDetails;
    private PagerMainViewHolder mHolderPagerMain;
    private android.view.View.OnClickListener mListener;
    private boolean mLocked;
    private int mMainPageHeight;
    private final int mNumberUnSelectedColor;
    private final TypefacesSpan mRegular;
    private boolean mShowActionsContainer;
    private int mTabSelectedColor;
    private VineUser mUser;

    public ProfileHeaderAdapter(Context context, AppController appcontroller, ProfileFragment profilefragment, boolean flag, boolean flag1, String s, boolean flag2, 
            boolean flag3)
    {
        mFollowState = 0;
        mContext = context;
        mListener = profilefragment;
        mAppController = appcontroller;
        mFragment = profilefragment;
        mLocked = flag;
        mBlocked = flag1;
        mFollowEventSource = s;
        mNumberUnSelectedColor = context.getResources().getColor(0x7f090018);
        mBold = new TypefacesSpan(null, Typefaces.get(mContext).getContentTypeface(1, 4));
        mRegular = new TypefacesSpan(null, Typefaces.get(mContext).getContentTypeface(0, 2));
        mShowActionsContainer = flag3;
        mCurrentTab = 0;
    }

    private void invalidateCount(int i, Resources resources, int j, TypefacesTextView typefacestextview)
    {
        resources = resources.getQuantityString(j, i, new Object[] {
            Util.numberFormat(resources, i)
        });
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(resources);
        i = resources.indexOf('"');
        j = resources.indexOf('"', i + 1);
        Util.safeSetSpan(spannablestringbuilder, mBold, i, j, 33);
        Util.safeSetSpan(spannablestringbuilder, mRegular, j, resources.length(), 33);
        spannablestringbuilder.delete(i, i + 1);
        spannablestringbuilder.delete(j - 1, j);
        typefacestextview.setText(spannablestringbuilder);
    }

    private void invalidateCountAndTabColor(int i, int j, Resources resources, int k, TypefacesTextView typefacestextview)
    {
        invalidateCount(j, resources, k, typefacestextview);
        invalidateTabColor(i, typefacestextview);
    }

    private void invalidateDetailHeight()
    {
        if (mHolderPagerDetails != null)
        {
            View view = mHolderPagerDetails.parent;
            if (view != null)
            {
                int i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                view.measure(android.view.View.MeasureSpec.makeMeasureSpec(SystemUtil.getDisplaySize(mContext).x, 0x40000000), i);
                mDetailPageHeight = view.getMeasuredHeight();
                if (mMainPageHeight <= 0)
                {
                    mMainPageHeight = mHolder.pager.getHeight();
                }
            }
        }
    }

    private void invalidateTabColor(int i, TextView textview)
    {
        if (mCurrentTab == i)
        {
            textview.setTextColor(mTabSelectedColor);
            return;
        } else
        {
            textview.setTextColor(mNumberUnSelectedColor);
            return;
        }
    }

    private void setImage(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            mHolderPagerMain.imageView.setImageResource(0x7f020065);
            if (mUser != null && mUser.userId == mAppController.getActiveId())
            {
                mHolderPagerMain.imageAction.setVisibility(0);
                return;
            } else
            {
                mHolderPagerMain.imageAction.setVisibility(8);
                return;
            }
        } else
        {
            mHolderPagerMain.imageAction.setVisibility(8);
            mHolderPagerMain.imageView.setImageDrawable(new RecyclableBitmapDrawable(mHolderPagerMain.imageView.getResources(), bitmap));
            return;
        }
    }

    private void setupFollowButton(Button button, VineUser vineuser)
    {
        int i;
label0:
        {
            int k = vineuser.profileBackground;
            if (k != Settings.DEFAULT_PROFILE_COLOR)
            {
                i = k;
                if (k > 0)
                {
                    break label0;
                }
            }
            i = mContext.getResources().getColor(0x7f090096);
        }
        i |= 0xff000000;
        boolean flag;
        if (vineuser.hasFollowRequested())
        {
            mFollowState = 3;
        } else
        if (vineuser.isFollowing())
        {
            mFollowState = 2;
        } else
        if (mAppController.getActiveId() != vineuser.userId)
        {
            mFollowState = 1;
        }
        if (mFollowState == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        button.setActivated(flag);
        vineuser = mContext.getResources();
        if (mFollowState == 2)
        {
            button.setTextColor(vineuser.getColor(0x7f090083));
            button.setText(vineuser.getString(0x7f0e0102));
        } else
        if (mFollowState == 1)
        {
            button.setTextColor(i | 0xff000000);
            button.setText(vineuser.getString(0x7f0e00fb));
        }
        if (mFollowState != 3)
        {
            ViewUtil.fillColor(vineuser, i, 0x7f020121, button);
            button.setPadding(0, 0, 0, 0);
            return;
        } else
        {
            int j = vineuser.getColor(0x7f09007b);
            ViewUtil.fillColor(vineuser, j, 0x7f020121, button);
            button.setTextColor(j);
            button.setText(vineuser.getString(0x7f0e0100));
            button.setPadding(vineuser.getDimensionPixelSize(0x7f0b007f), 0, 0, 0);
            return;
        }
    }

    private void setupMessageButton(Button button, VineUser vineuser)
    {
        int i;
label0:
        {
            int j = vineuser.profileBackground;
            if (j != Settings.DEFAULT_PROFILE_COLOR)
            {
                i = j;
                if (j > 0)
                {
                    break label0;
                }
            }
            i = 0xffffff & mContext.getResources().getColor(0x7f090096);
        }
        button.setTextColor(0xff000000 | i);
        ViewUtil.fillColor(mContext.getResources(), 0x3d000000 | i, 0x7f0200b3, button);
    }

    public void bindUser(VineUser vineuser)
    {
label0:
        {
            ProfileViewHolder profileviewholder;
            PagerMainViewHolder pagermainviewholder;
            PagerDetailsViewHolder pagerdetailsviewholder;
            Resources resources;
            Button button;
label1:
            {
                if (mHolder == null || mHolderPagerMain == null || mHolderPagerDetails == null)
                {
                    break label0;
                }
                mUser = vineuser;
                profileviewholder = mHolder;
                pagermainviewholder = mHolderPagerMain;
                pagerdetailsviewholder = mHolderPagerDetails;
                resources = mContext.getResources();
                int i;
                int k;
                if (TextUtils.isEmpty(vineuser.avatarUrl) || Util.isDefaultAvatarUrl(vineuser.avatarUrl))
                {
                    setImage(null);
                } else
                {
                    pagermainviewholder.userImageKey = new ImageKey(vineuser.avatarUrl, true);
                    setImage(mAppController.getPhotoBitmap(pagermainviewholder.userImageKey));
                }
                pagermainviewholder.imageView.setOnClickListener(mListener);
                pagermainviewholder.imageView.setOnLongClickListener((android.view.View.OnLongClickListener)mListener);
                pagermainviewholder.username.setText(vineuser.username);
                if (vineuser.profileBackground > 0)
                {
                    profileviewholder.profileBackground.setBackgroundColor(vineuser.profileBackground | 0xff000000);
                }
                k = vineuser.profileBackground;
                if (k != Settings.DEFAULT_PROFILE_COLOR)
                {
                    i = k;
                    if (k > 0)
                    {
                        break label1;
                    }
                }
                i = mContext.getResources().getColor(0x7f090096);
            }
            mTabSelectedColor = i | 0xff000000;
            profileviewholder.profileTabArrowImage.setColorFilter(new PorterDuffColorFilter(0x4c000000, android.graphics.PorterDuff.Mode.SRC_IN));
            if (!TextUtils.isEmpty(vineuser.description))
            {
                pagerdetailsviewholder.description.setText(vineuser.description);
                pagerdetailsviewholder.description.setVisibility(0);
            } else
            {
                pagerdetailsviewholder.description.setVisibility(8);
            }
            if (!TextUtils.isEmpty(vineuser.location))
            {
                pagerdetailsviewholder.location.setText(vineuser.location);
                pagerdetailsviewholder.location.setVisibility(0);
            } else
            {
                pagerdetailsviewholder.location.setVisibility(8);
            }
            profileviewholder.userId = vineuser.userId;
            if (vineuser.isVerified())
            {
                pagermainviewholder.verified.setVisibility(0);
            } else
            {
                pagermainviewholder.verified.setVisibility(8);
            }
            if (mBlocked || mAppController.getActiveId() == vineuser.userId)
            {
                profileviewholder.messageButton.setVisibility(8);
            } else
            {
                profileviewholder.messageButton.setVisibility(0);
                profileviewholder.messageButton.setOnClickListener(mListener);
                setupMessageButton(profileviewholder.messageButton, vineuser);
            }
            button = profileviewholder.follow;
            if (mBlocked || mAppController.getActiveId() == vineuser.userId)
            {
                button.setVisibility(8);
            } else
            {
                button.setVisibility(0);
                setupFollowButton(button, vineuser);
                button.setOnClickListener(mListener);
            }
            button = profileviewholder.settings;
            if (mAppController.getActiveId() == vineuser.userId)
            {
                button.setVisibility(0);
                button.setOnClickListener(mListener);
            } else
            {
                button.setVisibility(8);
            }
            if (mLocked)
            {
                profileviewholder.postsParent.setVisibility(8);
                profileviewholder.likesParent.setVisibility(8);
                pagerdetailsviewholder.userLoopCount.setVisibility(8);
                profileviewholder.profileTabArrow.setVisibility(8);
            } else
            {
                profileviewholder.postsParent.setVisibility(0);
                profileviewholder.likesParent.setVisibility(0);
                pagerdetailsviewholder.userLoopCount.setVisibility(0);
                ViewGroup viewgroup = profileviewholder.profileTabArrow;
                int j;
                if (mCurrentTab == 0)
                {
                    j = 0;
                } else
                {
                    j = 8;
                }
                viewgroup.setVisibility(j);
                profileviewholder.likesParent.setOnClickListener(mListener);
                profileviewholder.postsParent.setOnClickListener(mListener);
                if (vineuser.loopCount > 0x7fffffffL)
                {
                    vineuser.loopCount = 0x7fffffffL;
                }
                pagerdetailsviewholder.userLoopCount.setText(resources.getQuantityString(0x7f0d0004, (int)vineuser.loopCount, new Object[] {
                    Util.numberFormat(resources, vineuser.loopCount, false)
                }));
                invalidateCountAndTabColor(1, vineuser.likeCount, resources, 0x7f0d0003, profileviewholder.likesLabel);
                invalidateCountAndTabColor(0, vineuser.postCount, resources, 0x7f0d0005, profileviewholder.postsLabel);
            }
            pagermainviewholder.imageFrame.setVisibility(0);
            profileviewholder.progress.setVisibility(8);
            profileviewholder.profileTabArrow.setOnClickListener(mListener);
            invalidateCount(vineuser.followerCount, resources, 0x7f0d0001, pagermainviewholder.followers);
            invalidateCount(vineuser.followingCount, resources, 0x7f0d0002, pagermainviewholder.following);
            pagermainviewholder.followers.setOnClickListener(mListener);
            pagermainviewholder.following.setOnClickListener(mListener);
        }
        invalidateDetailHeight();
        mUser = vineuser;
    }

    public void changeSelectedTab(int i)
    {
        boolean flag;
        flag = false;
        if (mHolder == null)
        {
            return;
        }
        i;
        JVM INSTR lookupswitch 2: default 36
    //                   2131362192: 83
    //                   2131362196: 99;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_99;
_L4:
        invalidateTabColor(0, mHolder.postsLabel);
        invalidateTabColor(1, mHolder.likesLabel);
        ViewGroup viewgroup = mHolder.profileTabArrow;
        if (mCurrentTab == 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        viewgroup.setVisibility(i);
        return;
_L2:
        mCurrentTab = 0;
        mFragment.changeMode(1);
          goto _L4
        mCurrentTab = 1;
        mFragment.changeMode(2);
          goto _L4
    }

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
        i = 0;
        View view1 = view;
        if (view == null)
        {
            view = LayoutInflater.from(mContext).inflate(0x7f030076, viewgroup, false);
            mHolder = new ProfileViewHolder(view);
            mHolder.pager.setAdapter(new ProfileViewPagerAdapter());
            mHolder.pager.setOnPageChangeListener(this);
            mHolder.progress.setVisibility(0);
            mHolder.dots.setFinalIcon(false);
            mHolder.dots.setNumberOfDots(2);
            mHolder.dropDownHolder.revineParent.setOnClickListener(mFragment);
            viewgroup = mHolder.profileActions;
            if (!mShowActionsContainer)
            {
                i = 8;
            }
            viewgroup.setVisibility(i);
            view1 = view;
            if (mUser != null)
            {
                bindUser(mUser);
                view1 = view;
            }
        }
        return view1;
    }

    public void onImageLoaded(HashMap hashmap)
    {
        if (mHolderPagerMain != null && mHolderPagerMain.userImageKey != null)
        {
            hashmap = (UrlImage)hashmap.get(mHolderPagerMain.userImageKey);
            if (hashmap != null)
            {
                setImage(((UrlImage) (hashmap)).bitmap);
            }
        }
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
        if (f > 0.0F && mMainPageHeight > 0 && mDetailPageHeight > mMainPageHeight)
        {
            i = mDetailPageHeight;
            j = mMainPageHeight;
            android.view.ViewGroup.LayoutParams layoutparams = mHolder.pager.getLayoutParams();
            layoutparams.height = (int)((float)mMainPageHeight + (float)(i - j) * f);
            mHolder.pager.setLayoutParams(layoutparams);
        }
    }

    public void onPageSelected(int i)
    {
        if (mHolder != null && mHolder.dots != null)
        {
            mHolder.dots.setActiveDot(i);
        }
    }

    public void onProfileHeaderClick(View view, ProfileFragment profilefragment, VineUser vineuser)
    {
        Context context = mContext;
        view.getId();
        JVM INSTR lookupswitch 6: default 68
    //                   2131361891: 275
    //                   2131362188: 69
    //                   2131362189: 93
    //                   2131362190: 68
    //                   2131362192: 240
    //                   2131362196: 240;
           goto _L1 _L2 _L3 _L4 _L1 _L5 _L5
_L1:
        return;
_L3:
        FlurryUtils.trackVisitFindFriends("Profile");
        context.startActivity(new Intent(context, co/vine/android/SettingsActivity));
        return;
_L4:
        if (mFollowState == 2)
        {
            profilefragment.addRequest(mAppController.unfollowUser(mAppController.getActiveSession(), mHolder.userId, true));
            vineuser.following = 0;
            setupFollowButton(mHolder.follow, vineuser);
            FlurryUtils.trackFollow(mFollowEventSource);
            return;
        }
        if (mFollowState == 1)
        {
            if (vineuser.isPrivate())
            {
                vineuser.followStatus = vineuser.followStatus | 2;
            } else
            {
                vineuser.following = 1;
                vineuser.repostsEnabled = 1;
            }
            setupFollowButton(mHolder.follow, vineuser);
            profilefragment.addRequest(mAppController.followUser(mAppController.getActiveSession(), mHolder.userId, true));
            return;
        }
        if (mFollowState == 3)
        {
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (mFragment.getActivity() instanceof HomeTabActivity)
        {
            ((HomeTabActivity)mFragment.getActivity()).resetNav();
        }
        changeSelectedTab(view.getId());
        return;
_L2:
        if (mUser != null)
        {
            if (mUser.userId == mAppController.getActiveId())
            {
                FlurryUtils.trackVisitSettings("Profile");
                context.startActivity(new Intent(context, co/vine/android/SettingsActivity));
                return;
            } else
            {
                FlurryUtils.trackProfileImageClick(false);
                ImageActivity.start(context, mUser.avatarUrl, 0x7f0e021e);
                return;
            }
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void onProfileHeaderLongClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131361891 2131361891: default 24
    //                   2131361891 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (mUser != null && mUser.userId == mAppController.getActiveId())
        {
            FlurryUtils.trackProfileImageClick(true);
            view.performHapticFeedback(0);
            ImageActivity.start(mContext, mUser.avatarUrl, 0x7f0e021e);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void updatePostCount(int i, int j)
    {
        ProfileViewHolder profileviewholder;
        Resources resources;
label0:
        {
            profileviewholder = mHolder;
            resources = mContext.getResources();
            if (resources != null && profileviewholder != null)
            {
                if (j != 0)
                {
                    break label0;
                }
                invalidateCountAndTabColor(0, i, resources, 0x7f0d0005, profileviewholder.postsLabel);
                invalidateTabColor(1, profileviewholder.likesLabel);
            }
            return;
        }
        invalidateCountAndTabColor(1, i, resources, 0x7f0d0003, profileviewholder.likesLabel);
        invalidateTabColor(0, profileviewholder.postsLabel);
    }


/*
    static PagerMainViewHolder access$102(ProfileHeaderAdapter profileheaderadapter, PagerMainViewHolder pagermainviewholder)
    {
        profileheaderadapter.mHolderPagerMain = pagermainviewholder;
        return pagermainviewholder;
    }

*/



/*
    static PagerDetailsViewHolder access$302(ProfileHeaderAdapter profileheaderadapter, PagerDetailsViewHolder pagerdetailsviewholder)
    {
        profileheaderadapter.mHolderPagerDetails = pagerdetailsviewholder;
        return pagerdetailsviewholder;
    }

*/

}
