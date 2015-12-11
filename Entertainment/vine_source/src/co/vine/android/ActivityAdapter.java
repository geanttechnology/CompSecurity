// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import co.vine.android.api.VineEntity;
import co.vine.android.api.VineEverydayNotification;
import co.vine.android.api.VineMilestone;
import co.vine.android.api.VineNotification;
import co.vine.android.api.VinePost;
import co.vine.android.api.VineSingleNotification;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import co.vine.android.widget.ActivityViewHolder;
import co.vine.android.widget.PinnedHeaderAdapter;
import co.vine.android.widget.PinnedHeaderListView;
import co.vine.android.widget.SpanClickListener;
import co.vine.android.widget.StyledClickableSpan;
import co.vine.android.widget.Typefaces;
import co.vine.android.widget.TypefacesSpan;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            Friendships, SingleActivity, ProfileActivity, UsersActivity

public class ActivityAdapter extends BaseAdapter
    implements SectionIndexer, PinnedHeaderAdapter
{

    private static final int BLUR_MULTIPLE = 2;
    public static final int NUM_VIEW_TYPES = 4;
    private static final int SPAN_FLAGS = 33;
    public static final int VIEW_TYPE_ACTIVITY = 0;
    public static final int VIEW_TYPE_FOLLOW_REQUEST = 2;
    public static final int VIEW_TYPE_MILESTONE = 1;
    public static final int VIEW_TYPE_USER_LIST_COUNT = 3;
    private AppController mAppController;
    private android.view.View.OnClickListener mAvatarClicker;
    private final TypefacesSpan mBold;
    private final Context mContext;
    private ArrayList mFollowRequests;
    private final String mFollowRequestsString;
    private Friendships mFriendships;
    private int mLastNewIndex;
    private final ListView mListView;
    private SpanClickListener mListener;
    private final String mNewActivityString;
    private ArrayList mNotifications;
    private final String mOlderActivityString;
    private final int mPinnedHeaderHeight;
    private int mPinnedHeaderSection;
    private android.view.View.OnClickListener mPostClicker;
    private final int mProfileImageSize;
    private ArrayList mSections;
    private boolean mShouldReloadHeaderBecauseDataChanged;
    private final int mSpanColor;
    private android.view.View.OnClickListener mUserListClicker;
    private android.view.View.OnClickListener mViewClickListener;
    private ArrayList mViewHolders;
    private final int mVineGreen;

    public ActivityAdapter(Context context, ListView listview, AppController appcontroller, SpanClickListener spanclicklistener, android.view.View.OnClickListener onclicklistener)
    {
        mFriendships = new Friendships();
        mNotifications = new ArrayList();
        mFollowRequests = new ArrayList();
        mLastNewIndex = -1;
        mSections = new ArrayList();
        mPinnedHeaderSection = -1;
        mShouldReloadHeaderBecauseDataChanged = false;
        mPostClicker = new android.view.View.OnClickListener() {

            final ActivityAdapter this$0;

            public void onClick(View view)
            {
                long l = ((Long)view.getTag()).longValue();
                SingleActivity.start(mContext, l);
            }

            
            {
                this$0 = ActivityAdapter.this;
                super();
            }
        };
        mAvatarClicker = new android.view.View.OnClickListener() {

            final ActivityAdapter this$0;

            public void onClick(View view)
            {
                long l = ((Long)view.getTag()).longValue();
                ProfileActivity.start(mContext, l, null);
            }

            
            {
                this$0 = ActivityAdapter.this;
                super();
            }
        };
        mUserListClicker = new android.view.View.OnClickListener() {

            final ActivityAdapter this$0;

            public void onClick(View view)
            {
                view = (VineEverydayNotification)view.getTag();
                UsersActivity.launchUserListForNotification(mContext, ((VineEverydayNotification) (view)).notificationId, ((VineEverydayNotification) (view)).anchor);
            }

            
            {
                this$0 = ActivityAdapter.this;
                super();
            }
        };
        mListView = listview;
        mAppController = appcontroller;
        mViewHolders = new ArrayList();
        mListener = spanclicklistener;
        mViewClickListener = onclicklistener;
        mContext = context;
        listview = context.getResources();
        mFollowRequestsString = listview.getString(0x7f0e00fd);
        mNewActivityString = listview.getString(0x7f0e014a);
        mOlderActivityString = listview.getString(0x7f0e0164);
        mVineGreen = listview.getColor(0x7f090096);
        mSpanColor = listview.getColor(0x7f090078);
        mPinnedHeaderHeight = listview.getDimensionPixelSize(0x7f0b0013);
        mProfileImageSize = context.getResources().getDimensionPixelOffset(0x7f0b0087);
        mBold = new TypefacesSpan(null, Typefaces.get(mContext).getContentTypeface(1, 4));
    }

    private void bindBodyText(ActivityViewHolder activityviewholder, VineNotification vinenotification)
    {
        Object obj;
        SpannableStringBuilder spannablestringbuilder;
        Object obj1;
        obj1 = vinenotification.comment;
        spannablestringbuilder = new SpannableStringBuilder(((CharSequence) (obj1)));
        obj = null;
        if (vinenotification.entities != null)
        {
            ArrayList arraylist = new ArrayList(vinenotification.entities.size());
            int i = 0;
            do
            {
                obj = arraylist;
                if (i >= vinenotification.entities.size())
                {
                    break;
                }
                arraylist.add(new VineEntity((VineEntity)vinenotification.entities.get(i)));
                i++;
            } while (true);
        }
        if (obj == null || TextUtils.isEmpty(((CharSequence) (obj1)))) goto _L2; else goto _L1
_L1:
        TextView textview;
        Util.adjustEntities(((ArrayList) (obj)), spannablestringbuilder, 0, true);
        textview = activityviewholder.contentLine;
        obj1 = ((ArrayList) (obj)).iterator();
_L9:
        if (!((Iterator) (obj1)).hasNext()) goto _L4; else goto _L3
_L3:
        VineEntity vineentity;
        vineentity = (VineEntity)((Iterator) (obj1)).next();
        obj = null;
        if (!vineentity.isUserType()) goto _L6; else goto _L5
_L5:
        obj = new StyledClickableSpan(1, Long.valueOf(vineentity.id), mListener);
_L7:
        if (obj != null)
        {
            try
            {
                ((StyledClickableSpan) (obj)).setColor(mSpanColor);
                Util.safeSetSpan(spannablestringbuilder, obj, vineentity.start, vineentity.end, 33);
                Util.safeSetSpan(spannablestringbuilder, mBold, vineentity.start, vineentity.end, 33);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (vineentity.isTagType())
        {
            obj = new StyledClickableSpan(3, vineentity.title, mListener);
        } else
        if (vineentity.isUserListType())
        {
            long l = vinenotification.notificationId;
            long l1 = ((VineEverydayNotification)vinenotification).anchor;
            obj = mListener;
            obj = new StyledClickableSpan(4, ((Object) (new Object[] {
                Long.valueOf(l), Long.valueOf(l1)
            })), ((SpanClickListener) (obj)));
        } else
        if (vineentity.isCommentListType())
        {
            obj = new StyledClickableSpan(5, Long.valueOf(vineentity.getPostId()), mListener);
        }
        if (true) goto _L7; else goto _L4
_L4:
        if (activityviewholder.dateLine != null)
        {
            vinenotification = Util.getRelativeTimeString(mContext, vinenotification.createdAt, true);
            activityviewholder.dateLine.setText(vinenotification);
        }
        textview.setText(spannablestringbuilder);
_L2:
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void bindFollowRequest(ActivityViewHolder activityviewholder, VineSingleNotification vinesinglenotification)
    {
        if (activityviewholder == null)
        {
            throw new RuntimeException("View tag is null.");
        } else
        {
            activityviewholder.userId = vinesinglenotification.userId;
            activityviewholder.listItemClickType = 0;
            setAvatar(activityviewholder, activityviewholder.avatar, vinesinglenotification.avatarUrl, vinesinglenotification.userId);
            activityviewholder.avatar.setTag(Long.valueOf(vinesinglenotification.userId));
            activityviewholder.avatar.setOnClickListener(mAvatarClicker);
            activityviewholder.typeIcon.setVisibility(0);
            activityviewholder.typeIcon.setImageResource(0x7f02013f);
            activityviewholder.thumbnail.setVisibility(8);
            bindBodyText(activityviewholder, vinesinglenotification);
            return;
        }
    }

    private void bindGroupNotification(ActivityViewHolder activityviewholder, VineEverydayNotification vineeverydaynotification)
    {
        activityviewholder.contentLine.setText(vineeverydaynotification.comment);
        activityviewholder.notificationId = vineeverydaynotification.notificationId;
        VineUser vineuser = vineeverydaynotification.user;
        if (vineuser != null)
        {
            activityviewholder.userId = vineuser.userId;
            activityviewholder.listItemClickType = 0;
            setAvatar(activityviewholder, activityviewholder.avatar, vineuser.avatarUrl, vineuser.userId);
            activityviewholder.avatar.setTag(Long.valueOf(vineuser.userId));
            activityviewholder.avatar.setOnClickListener(mAvatarClicker);
        }
        if (("twitter friend joined".equals(vineeverydaynotification.type) || "address book friend joined".equals(vineeverydaynotification.type)) && vineeverydaynotification.entities != null)
        {
            activityviewholder.userId = ((VineEntity)vineeverydaynotification.entities.get(0)).id;
            activityviewholder.listItemClickType = 0;
        }
        if (vineeverydaynotification.post != null)
        {
            activityviewholder.postId = vineeverydaynotification.post.postId;
            activityviewholder.listItemClickType = 1;
            activityviewholder.thumbnail.setVisibility(0);
            activityviewholder.thumbnail.setTag(Long.valueOf(activityviewholder.postId));
            activityviewholder.thumbnail.setOnClickListener(mPostClicker);
            ImageKey imagekey = new ImageKey(vineeverydaynotification.post.thumbnailUrl, false);
            activityviewholder.thumbnailImageKey = imagekey;
            setImage(activityviewholder.thumbnail, mAppController.getPhotoBitmap(imagekey));
        } else
        if ("follow approved".equals(vineeverydaynotification.type))
        {
            activityviewholder.thumbnail.setVisibility(8);
        } else
        {
            activityviewholder.thumbnail.setVisibility(4);
        }
        if ("followed".equals(vineeverydaynotification.type) || "follow approved".equals(vineeverydaynotification.type) || "address book friend joined".equals(vineeverydaynotification.type))
        {
            activityviewholder.typeIcon.setVisibility(0);
            activityviewholder.typeIcon.setImageResource(0x7f02013f);
        } else
        if ("mentioned comment".equals(vineeverydaynotification.type) || "commented".equals(vineeverydaynotification.type) || "grouped comment".equals(vineeverydaynotification.type) || "mentioned post".equals(vineeverydaynotification.type) || "mentioned".equals(vineeverydaynotification.type))
        {
            activityviewholder.typeIcon.setVisibility(0);
            activityviewholder.typeIcon.setImageResource(0x7f02013d);
        } else
        if ("liked".equals(vineeverydaynotification.type))
        {
            activityviewholder.typeIcon.setVisibility(0);
            activityviewholder.typeIcon.setImageResource(0x7f020140);
        } else
        if ("reposted".equals(vineeverydaynotification.type))
        {
            activityviewholder.typeIcon.setVisibility(0);
            activityviewholder.typeIcon.setImageResource(0x7f020149);
        } else
        if ("twitter friend joined".equals(vineeverydaynotification.type))
        {
            activityviewholder.typeIcon.setVisibility(0);
            activityviewholder.typeIcon.setImageResource(0x7f02014a);
        } else
        {
            activityviewholder.typeIcon.setVisibility(8);
            activityviewholder.clickable = false;
        }
        if ("followed".equals(vineeverydaynotification.type) || "twitter friend joined".equals(vineeverydaynotification.type) || "address book friend joined".equals(vineeverydaynotification.type))
        {
            activityviewholder.followButton.setVisibility(0);
            activityviewholder.followButton.setOnClickListener(mViewClickListener);
            if (vineuser != null)
            {
                if (!mFriendships.contains(vineuser.userId) && vineuser.isFollowing())
                {
                    mFriendships.addFollowing(vineuser.userId);
                }
                activityviewholder.followButton.setTag(Long.valueOf(vineuser.userId));
                if (isFollowing(vineuser.userId))
                {
                    activityviewholder.followButton.setBackgroundResource(0x7f020095);
                } else
                {
                    activityviewholder.followButton.setBackgroundResource(0x7f020094);
                }
            }
        } else
        {
            activityviewholder.followButton.setVisibility(8);
        }
        bindBodyText(activityviewholder, vineeverydaynotification);
    }

    private void bindHeader(ActivityViewHolder activityviewholder, int i)
    {
label0:
        {
label1:
            {
                if (activityviewholder.headerView != null)
                {
                    Object aobj[] = getSections();
                    if (aobj.length <= 0)
                    {
                        break label0;
                    }
                    int j = getSectionForPosition(i);
                    if (i != getPositionForSection(j))
                    {
                        break label1;
                    }
                    activityviewholder.headerView.setVisibility(0);
                    activityviewholder.headerText.setText((CharSequence)aobj[j]);
                }
                return;
            }
            activityviewholder.headerView.setVisibility(8);
            return;
        }
        activityviewholder.headerView.setVisibility(8);
    }

    private void bindMilestone(ActivityViewHolder activityviewholder, VineEverydayNotification vineeverydaynotification)
    {
        if (vineeverydaynotification.milestone != null)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            int i;
            if (!TextUtils.isEmpty(vineeverydaynotification.milestone.milestoneUrl))
            {
                Object obj1 = Uri.parse(vineeverydaynotification.milestone.milestoneUrl);
                Object obj = ((Uri) (obj1)).getHost();
                obj1 = Long.valueOf(Long.parseLong(((Uri) (obj1)).getLastPathSegment()));
                if ("user-id".equals(obj))
                {
                    activityviewholder.userId = ((Long) (obj1)).longValue();
                    activityviewholder.listItemClickType = 0;
                    flag = true;
                } else
                {
                    flag = flag1;
                    if ("post".equals(obj))
                    {
                        activityviewholder.listItemClickType = 1;
                        activityviewholder.postId = ((Long) (obj1)).longValue();
                        flag = false;
                    }
                }
            }
            obj = new ImageKey(vineeverydaynotification.milestone.backgroundImageUrl, true, vineeverydaynotification.milestone.blurRadius * 2, true);
            activityviewholder.milestoneBackgroundImageKey = ((ImageKey) (obj));
            setImage(activityviewholder.milestoneBackground, mAppController.getPhotoBitmap(((ImageKey) (obj))), false);
            obj = new ImageKey(vineeverydaynotification.milestone.backgroundImageUrl, mProfileImageSize, mProfileImageSize, flag);
            activityviewholder.milestoneImageImageKey = ((ImageKey) (obj));
            setImage(activityviewholder.milestoneImage, mAppController.getPhotoBitmap(((ImageKey) (obj))), false);
            obj = activityviewholder.milestoneImageFrame;
            if (flag)
            {
                i = 0x7f02021c;
            } else
            {
                i = 0x7f02021d;
            }
            ((ImageView) (obj)).setImageResource(i);
            obj = new ImageKey(vineeverydaynotification.milestone.iconUrl);
            activityviewholder.milestoneIconImageKey = ((ImageKey) (obj));
            setImage(activityviewholder.milestoneIcon, mAppController.getPhotoBitmap(((ImageKey) (obj))), false);
            activityviewholder.milestoneTitle.setText(vineeverydaynotification.milestone.title);
            obj = Util.getRelativeTimeString(mContext, vineeverydaynotification.createdAt, true);
            activityviewholder.milestoneDescription.setText(((CharSequence) (obj)));
            if (vineeverydaynotification.post != null)
            {
                activityviewholder.postId = vineeverydaynotification.post.postId;
            }
            ((GradientDrawable)activityviewholder.milestoneOverlay.getBackground()).setColor(0xff000000 | vineeverydaynotification.milestone.overlayColor);
            activityviewholder.milestoneOverlay.setAlpha(vineeverydaynotification.milestone.overlayAlpha + 0.1F);
        }
    }

    private boolean nextViewHasHeader(int i)
    {
        while (getSections().length == 0 || getSectionForPosition(i) == getSectionForPosition(i + 1)) 
        {
            return false;
        }
        return true;
    }

    private void setAvatar(ActivityViewHolder activityviewholder, ImageView imageview, String s, long l)
    {
        if (Util.isDefaultAvatarUrl(s))
        {
            Util.safeSetDefaultAvatar(imageview, co.vine.android.util.Util.ProfileImageSize.MEDIUM, 0xff000000 | mVineGreen);
        } else
        {
            s = new ImageKey(s, mProfileImageSize, mProfileImageSize, true);
            activityviewholder.avatarImageKey = s;
            setUserImage(imageview, mAppController.getPhotoBitmap(s));
        }
        imageview.setTag(Long.valueOf(l));
    }

    private void setImage(ImageView imageview, Bitmap bitmap)
    {
        setImage(imageview, bitmap, true);
    }

    private void setImage(ImageView imageview, Bitmap bitmap, boolean flag)
    {
        if (imageview == null)
        {
            return;
        }
        if (bitmap == null)
        {
            if (flag)
            {
                imageview.setBackgroundColor(mContext.getResources().getColor(0x7f09007f));
            } else
            {
                imageview.setBackgroundColor(0xffffff);
            }
            imageview.setImageBitmap(null);
            return;
        } else
        {
            imageview.setBackgroundColor(0);
            imageview.setImageDrawable(new RecyclableBitmapDrawable(mContext.getResources(), bitmap));
            return;
        }
    }

    private void setUserImage(ImageView imageview, Bitmap bitmap)
    {
        if (imageview == null)
        {
            return;
        }
        imageview.setColorFilter(null);
        if (bitmap == null)
        {
            imageview.setImageResource(0x7f0200f7);
            return;
        } else
        {
            imageview.setBackgroundColor(0);
            imageview.setImageDrawable(new RecyclableBitmapDrawable(mContext.getResources(), bitmap));
            return;
        }
    }

    public void bindView(View view, int i)
    {
        view = (ActivityViewHolder)view.getTag();
        if (view == null)
        {
            throw new RuntimeException("View tag is null.");
        }
        Object obj = ((ActivityViewHolder) (view)).divider;
        byte byte0;
        if (nextViewHasHeader(i))
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        ((View) (obj)).setVisibility(byte0);
        view.userId = 0L;
        view.postId = 0L;
        view.listItemClickType = -1;
        bindHeader(view, i);
        switch (getItemViewType(i))
        {
        default:
            return;

        case 1: // '\001'
            bindMilestone(view, (VineEverydayNotification)getItem(i));
            return;

        case 0: // '\0'
            bindGroupNotification(view, (VineEverydayNotification)getItem(i));
            return;

        case 2: // '\002'
            bindFollowRequest(view, (VineSingleNotification)getItem(i));
            return;

        case 3: // '\003'
            obj = (VineEverydayNotification)getItem(i);
            break;
        }
        view.notificationId = ((VineEverydayNotification) (obj)).notificationId;
        VineEntity vineentity = (VineEntity)((VineEverydayNotification) (obj)).entities.get(0);
        if (vineentity != null && vineentity.isCommentListType())
        {
            view.listItemClickType = 3;
            view.postId = vineentity.getPostId();
        } else
        {
            view.listItemClickType = 2;
        }
        view.anchor = ((VineEverydayNotification) (obj)).anchor;
        ((ActivityViewHolder) (view)).contentLine.setText(((VineEverydayNotification) (obj)).comment);
        ((ActivityViewHolder) (view)).contentLine.setOnClickListener(mUserListClicker);
        ((ActivityViewHolder) (view)).contentLine.setTag(obj);
    }

    public void follow(long l)
    {
        mFriendships.addFollowing(l);
        notifyDataSetChanged();
    }

    public int getCount()
    {
        return mFollowRequests.size() + mNotifications.size();
    }

    public Object getItem(int i)
    {
        if (i < mFollowRequests.size())
        {
            return mFollowRequests.get(i);
        } else
        {
            return mNotifications.get(i - mFollowRequests.size());
        }
    }

    public long getItemId(int i)
    {
        return ((VineNotification)getItem(i)).notificationId;
    }

    public int getItemViewType(int i)
    {
        if (i < mFollowRequests.size())
        {
            return 2;
        }
        VineEverydayNotification vineeverydaynotification = (VineEverydayNotification)getItem(i);
        if (vineeverydaynotification.milestone != null)
        {
            return 1;
        }
        return !"count".equals(vineeverydaynotification.type) ? 0 : 3;
    }

    public int getPinnedHeaderHeight()
    {
        return mPinnedHeaderHeight;
    }

    public co.vine.android.widget.PinnedHeaderAdapter.PinnedHeaderStatus getPinnedHeaderStatus(int i)
    {
        int k = mPinnedHeaderSection;
        int l = ((PinnedHeaderListView)mListView).getPositionForPixelLocation(i);
        int i1 = (mListView.getFirstVisiblePosition() - mListView.getHeaderViewsCount()) + l;
        mPinnedHeaderSection = getSectionForPosition(i1);
        boolean flag = false;
        int j = ((flag) ? 1 : 0);
        if (nextViewHasHeader(i1))
        {
            View view = mListView.getChildAt(l + 1);
            j = ((flag) ? 1 : 0);
            if (view != null)
            {
                j = ((flag) ? 1 : 0);
                if (view.getTop() < mPinnedHeaderHeight + i)
                {
                    j = view.getTop() - mPinnedHeaderHeight - i;
                }
            }
        }
        boolean flag1;
        if (k != mPinnedHeaderSection || mShouldReloadHeaderBecauseDataChanged)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        mShouldReloadHeaderBecauseDataChanged = false;
        return new co.vine.android.widget.PinnedHeaderAdapter.PinnedHeaderStatus(j, flag1, true);
    }

    public View getPinnedHeaderView(View view)
    {
        if (getSections().length == 0)
        {
            return null;
        }
        View view1 = view;
        if (view == null)
        {
            view1 = LayoutInflater.from(mContext).inflate(0x7f030018, null);
            view1.layout(0, 0, mListView.getWidth(), mPinnedHeaderHeight);
            view1.setTag(new ActivityViewHolder(view1));
        }
        bindHeader((ActivityViewHolder)view1.getTag(), getPositionForSection(mPinnedHeaderSection));
        return view1;
    }

    public int getPositionForSection(int i)
    {
        if (getSections().length > 0 && i != 0)
        {
            if (i == 1)
            {
                if (mFollowRequests.size() > 0)
                {
                    return mFollowRequests.size();
                }
                if (mLastNewIndex >= 0)
                {
                    return mLastNewIndex + 1;
                }
            }
            if (i == 2)
            {
                return mFollowRequests.size() + mLastNewIndex + 1;
            }
        }
        return 0;
    }

    public int getSectionForPosition(int i)
    {
        int j = 1;
        boolean flag = true;
        if (getSections().length <= 0 || i < mFollowRequests.size())
        {
            return 0;
        }
        if (i <= mFollowRequests.size() + mLastNewIndex)
        {
            if (mFollowRequests.size() > 0)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 0;
            }
            return i;
        }
        if (mFollowRequests.size() > 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (mLastNewIndex < 0)
        {
            j = 0;
        }
        return i + j;
    }

    public Object[] getSections()
    {
        mSections.clear();
        if (mFollowRequests.size() > 0)
        {
            mSections.add(mFollowRequestsString);
        }
        if (mLastNewIndex >= 0)
        {
            mSections.add(mNewActivityString);
        }
        if (mLastNewIndex >= 0 || mFollowRequests.size() > 0)
        {
            mSections.add(mOlderActivityString);
        }
        return mSections.toArray();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = newView(i, viewgroup);
        }
        bindView(view, i);
        return view;
    }

    public int getViewTypeCount()
    {
        return 4;
    }

    public boolean isFollowing(long l)
    {
        return mFriendships.isFollowing(l);
    }

    public void layoutPinnedHeader(View view, int i, int j, int k, int l)
    {
        view.layout(i, j, k, l);
    }

    public void mergeData(ArrayList arraylist, ArrayList arraylist1, boolean flag)
    {
        if (!flag)
        {
            mNotifications = new ArrayList();
            mFollowRequests = new ArrayList();
            mFriendships.clear();
            mLastNewIndex = -1;
        }
        if (arraylist != null)
        {
            VineEverydayNotification vineeverydaynotification;
            for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); mNotifications.add(vineeverydaynotification))
            {
                vineeverydaynotification = (VineEverydayNotification)iterator.next();
                if (vineeverydaynotification.isNew)
                {
                    mLastNewIndex = mLastNewIndex + 1;
                }
            }

        }
        if (arraylist1 != null)
        {
            VineSingleNotification vinesinglenotification;
            for (Iterator iterator1 = arraylist1.iterator(); iterator1.hasNext(); mFollowRequests.add(vinesinglenotification))
            {
                vinesinglenotification = (VineSingleNotification)iterator1.next();
            }

        }
        ((PinnedHeaderListView)mListView).untrackScrollawayChild();
        if (arraylist != null || arraylist1 != null)
        {
            notifyDataSetChanged();
        }
    }

    public View newView(int i, ViewGroup viewgroup)
    {
        i = getItemViewType(i);
        i;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 95
    //                   2 32
    //                   3 114;
           goto _L1 _L2 _L1 _L3
_L1:
        viewgroup = LayoutInflater.from(mContext).inflate(0x7f03001a, viewgroup, false);
_L5:
        ActivityViewHolder activityviewholder = new ActivityViewHolder(viewgroup);
        if (i != 1)
        {
            activityviewholder.contentLine.setMovementMethod(LinkMovementMethod.getInstance());
        }
        viewgroup.setTag(activityviewholder);
        mViewHolders.add(new WeakReference(activityviewholder));
        return viewgroup;
_L2:
        viewgroup = LayoutInflater.from(mContext).inflate(0x7f03001e, viewgroup, false);
        continue; /* Loop/switch isn't completed */
_L3:
        viewgroup = LayoutInflater.from(mContext).inflate(0x7f03001b, viewgroup, false);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
        mShouldReloadHeaderBecauseDataChanged = true;
    }

    public void setImages(HashMap hashmap)
    {
        Object obj = new ArrayList();
        Iterator iterator = mViewHolders.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            WeakReference weakreference = (WeakReference)iterator.next();
            ActivityViewHolder activityviewholder = (ActivityViewHolder)weakreference.get();
            if (activityviewholder == null)
            {
                ((ArrayList) (obj)).add(weakreference);
            } else
            {
                if (activityviewholder.avatarImageKey != null)
                {
                    UrlImage urlimage = (UrlImage)hashmap.get(activityviewholder.avatarImageKey);
                    if (urlimage != null && urlimage.isValid())
                    {
                        setUserImage(activityviewholder.avatar, urlimage.bitmap);
                    }
                }
                if (activityviewholder.thumbnailImageKey != null)
                {
                    UrlImage urlimage1 = (UrlImage)hashmap.get(activityviewholder.thumbnailImageKey);
                    if (urlimage1 != null && urlimage1.isValid())
                    {
                        setImage(activityviewholder.thumbnail, urlimage1.bitmap);
                    }
                }
                if (activityviewholder.milestoneImageImageKey != null)
                {
                    UrlImage urlimage2 = (UrlImage)hashmap.get(activityviewholder.milestoneImageImageKey);
                    if (urlimage2 != null && urlimage2.isValid())
                    {
                        setImage(activityviewholder.milestoneImage, urlimage2.bitmap);
                    }
                }
                if (activityviewholder.milestoneBackgroundImageKey != null)
                {
                    UrlImage urlimage3 = (UrlImage)hashmap.get(activityviewholder.milestoneBackgroundImageKey);
                    if (urlimage3 != null && urlimage3.isValid())
                    {
                        setImage(activityviewholder.milestoneBackground, urlimage3.bitmap);
                    }
                }
                if (activityviewholder.milestoneIconImageKey != null)
                {
                    UrlImage urlimage4 = (UrlImage)hashmap.get(activityviewholder.milestoneIconImageKey);
                    if (urlimage4 != null && urlimage4.isValid())
                    {
                        setImage(activityviewholder.milestoneIcon, urlimage4.bitmap);
                    }
                }
            }
        } while (true);
        for (hashmap = ((ArrayList) (obj)).iterator(); hashmap.hasNext(); mViewHolders.remove(obj))
        {
            obj = (WeakReference)hashmap.next();
        }

    }

    public void unfollow(long l)
    {
        mFriendships.removeFollowing(l);
        notifyDataSetChanged();
    }

}
