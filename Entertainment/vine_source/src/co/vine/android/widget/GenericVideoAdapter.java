// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import co.vine.android.LikeCache;
import co.vine.android.RevineCache;
import co.vine.android.Settings;
import co.vine.android.ViewOffsetResolver;
import co.vine.android.VineLoggingException;
import co.vine.android.api.VineComment;
import co.vine.android.api.VineEntity;
import co.vine.android.api.VineLike;
import co.vine.android.api.VinePagedData;
import co.vine.android.api.VinePost;
import co.vine.android.client.AppController;
import co.vine.android.client.Session;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.SystemUtil;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import co.vine.android.util.video.VideoCache;
import co.vine.android.util.video.VideoKey;
import com.edisonwang.android.slog.SLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package co.vine.android.widget:
//            TypefacesSpan, Typefaces, GenericFeedViewHolder, StyledClickableSpan, 
//            ColorizedCircleButton, SpanClickListener

public abstract class GenericVideoAdapter extends BaseAdapter
{
    public class SpanCommentObjectTag
    {

        public final long authorId;
        public final long postId;
        final GenericVideoAdapter this$0;

        public SpanCommentObjectTag(long l, long l1)
        {
            this$0 = GenericVideoAdapter.this;
            super();
            postId = l;
            authorId = l1;
        }
    }


    protected static final int COMMENT_TYPE_FEW = 1;
    protected static final int COMMENT_TYPE_MANY = 2;
    private static final int HQ_THRESHOLD = 200;
    protected static final char INTERPUNCT = 183;
    protected static final int MAX_COMMENT_ITEMS = 3;
    protected static final char SPACE = 32;
    protected static final int SPAN_FLAGS = 33;
    protected final AppController mAppController;
    protected final SparseArray mAvatars = new SparseArray();
    protected final TypefacesSpan mBoldSpan;
    protected final Context mContext;
    protected final int mDimen;
    protected final HashSet mDismissedWarnings = new HashSet();
    protected final String mFollowEventSource;
    protected boolean mIconsSwitched;
    protected LikeCache mLikeCache;
    protected String mLoadingTimeTag;
    private Boolean mNormalVideoPlayable;
    protected int mProfileColor;
    private int mProfileImageSize;
    protected RevineCache mRevineCache;
    protected final SpanClickListener mSpanClickListener;
    protected long mStartLoadingTime;
    protected final SparseArray mThumbnails = new SparseArray();
    protected final android.view.View.OnClickListener mViewClickListener;
    protected final ArrayList mViewHolders = new ArrayList();
    protected ViewOffsetResolver mViewOffsetResolver;
    private final int mVineGray;
    private final int mVineGreen;

    public GenericVideoAdapter(Activity activity, LikeCache likecache, RevineCache revinecache, android.view.View.OnClickListener onclicklistener, SpanClickListener spanclicklistener, String s)
    {
        Resources resources = activity.getResources();
        mContext = activity;
        mAppController = AppController.getInstance(activity);
        mViewClickListener = onclicklistener;
        mSpanClickListener = spanclicklistener;
        mBoldSpan = new TypefacesSpan(null, Typefaces.get(mContext).getContentTypeface(1, 3));
        mDimen = SystemUtil.getDisplaySize(activity).x;
        mLikeCache = likecache;
        mRevineCache = revinecache;
        mFollowEventSource = s;
        mProfileImageSize = resources.getDimensionPixelOffset(0x7f0b0087);
        mVineGreen = resources.getColor(0x7f090096);
        mVineGray = resources.getColor(0x7f090018);
        mProfileColor = mVineGreen;
    }

    protected void bindAvatar(GenericFeedViewHolder genericfeedviewholder)
    {
        ImageView imageview;
        Object obj;
        int i;
label0:
        {
label1:
            {
                obj = genericfeedviewholder.post;
                i = genericfeedviewholder.position;
                imageview = genericfeedviewholder.userImage;
                if (((VinePost) (obj)).avatarUrl != null)
                {
                    if (!Util.isDefaultAvatarUrl(((VinePost) (obj)).avatarUrl))
                    {
                        break label0;
                    }
                    if (!((VinePost) (obj)).isRevined())
                    {
                        break label1;
                    }
                    Util.safeSetDefaultAvatar(imageview, co.vine.android.util.Util.ProfileImageSize.MEDIUM, mVineGreen);
                }
                return;
            }
            Util.safeSetDefaultAvatar(imageview, co.vine.android.util.Util.ProfileImageSize.MEDIUM, mProfileColor);
            return;
        }
        obj = new ImageKey(((VinePost) (obj)).avatarUrl, mProfileImageSize, mProfileImageSize, true);
        Bitmap bitmap = (Bitmap)mAvatars.get(i);
        if (bitmap != null)
        {
            setUserImage(imageview, bitmap);
        } else
        {
            setUserImage(imageview, mAppController.getPhotoBitmap(((ImageKey) (obj))));
        }
        genericfeedviewholder.avatarKey = ((ImageKey) (obj));
    }

    protected boolean bindVideoImage(GenericFeedViewHolder genericfeedviewholder)
    {
        boolean flag2 = true;
        this;
        JVM INSTR monitorenter ;
        Object obj;
        int i;
        obj = genericfeedviewholder.post;
        i = genericfeedviewholder.position;
        boolean flag1 = flag2;
        if (obj == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (((VinePost) (obj)).thumbnailUrl != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        genericfeedviewholder.hasVideoImage = flag1;
        if (((VinePost) (obj)).isExplicit() && !mDismissedWarnings.contains(Integer.valueOf(i)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        genericfeedviewholder.sensitiveTextContainer.setVisibility(0);
        createSensitiveLisenter(genericfeedviewholder);
        flag1 = flag2;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag1;
_L4:
        createInsensitiveListener(genericfeedviewholder);
        flag1 = flag2;
        Bitmap bitmap;
        if (!genericfeedviewholder.hasVideoImage)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new ImageKey(((VinePost) (obj)).thumbnailUrl);
        genericfeedviewholder.videoImageKey = ((ImageKey) (obj));
        bitmap = (Bitmap)mThumbnails.get(i);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        SLog.d("setting thumbnail for {}", Integer.valueOf(i));
        genericfeedviewholder.isVideoImageLoaded = setImage(genericfeedviewholder.getViewForVideoImage(), bitmap);
        flag1 = flag2;
        continue; /* Loop/switch isn't completed */
        genericfeedviewholder;
        throw genericfeedviewholder;
        SLog.d("fetching thumbnail for {}", Integer.valueOf(i));
        genericfeedviewholder.isVideoImageLoaded = setImage(genericfeedviewholder.getViewForVideoImage(), mAppController.getPhotoBitmap(((ImageKey) (obj))));
        flag1 = false;
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected abstract void createInsensitiveListener(GenericFeedViewHolder genericfeedviewholder);

    protected abstract void createSensitiveLisenter(GenericFeedViewHolder genericfeedviewholder);

    protected void endLoadingTimeProfiling()
    {
        if (mStartLoadingTime > 0L)
        {
            long l = Math.round(timeSinceStartLoadingTime() / 500L) * 500;
            mStartLoadingTime = 0L;
            SLog.i("Loading time for {} was {}ms.", mLoadingTimeTag, Long.valueOf(l));
            FlurryUtils.trackLoadingTime(mLoadingTimeTag, l);
        }
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    protected VideoKey getRequestKey(VinePost vinepost, boolean flag)
    {
        VideoKey videokey;
        VideoKey videokey1;
        boolean flag1;
        boolean flag2;
        if (mNormalVideoPlayable == null)
        {
            int i;
            if (SystemUtil.isNormalVideoPlayable(mContext) != co.vine.android.util.SystemUtil.PrefBooleanState.FALSE)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            mNormalVideoPlayable = Boolean.valueOf(flag2);
        }
        i = VideoCache.getCurrentAverageSpeed();
        if (i > 200)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        SLog.d("Getting HQ Video: speed {}, hq? {} && can play normal vid {}", Integer.valueOf(i), Boolean.valueOf(flag2), mNormalVideoPlayable);
        videokey1 = new VideoKey(vinepost.videoUrl);
        if (!mNormalVideoPlayable.booleanValue()) goto _L2; else goto _L1
_L1:
        videokey = videokey1;
        if (flag2) goto _L3; else goto _L2
_L2:
        if (vinepost.videoLowURL != null && !vinepost.videoLowURL.isEmpty())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1) goto _L5; else goto _L4
_L4:
        SLog.e("Low key does NOT exist: forceLowKey {}. ", Boolean.valueOf(flag), mNormalVideoPlayable);
        if (flag) goto _L7; else goto _L6
_L6:
        videokey = videokey1;
        if (mNormalVideoPlayable.booleanValue()) goto _L3; else goto _L7
_L7:
        videokey = null;
_L3:
        return videokey;
_L5:
        vinepost = new VideoKey(vinepost.videoLowURL);
        if (flag || !mNormalVideoPlayable.booleanValue())
        {
            return vinepost;
        }
        videokey = videokey1;
        if (mAppController.peekVideoFilePath(videokey1) == null)
        {
            return vinepost;
        }
        if (true) goto _L3; else goto _L8
_L8:
    }

    public long getStartLoadingTime()
    {
        return mStartLoadingTime;
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isPlaying()
    {
        return false;
    }

    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
        resetStates(true);
    }

    public boolean onBackPressed()
    {
        return false;
    }

    public void onDestroy()
    {
    }

    public void onDestroyView()
    {
    }

    protected void onInvalidRequestKey()
    {
        SLog.e("Invalid request key.");
    }

    public void onLowMemory()
    {
        SLog.e("onLowMemory called.", new VineLoggingException());
        mThumbnails.clear();
        mAvatars.clear();
    }

    public void onPause(boolean flag)
    {
    }

    public void onResume(boolean flag)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    public void onTrimMemory(int i)
    {
        if (i != 80)
        {
            SLog.d("onTrimMemory: Adapter has cleaned it's bitmaps: {}, {}.", Integer.valueOf(mAvatars.size()), Integer.valueOf(mThumbnails.size()));
            mAvatars.clear();
            mThumbnails.clear();
        }
    }

    protected void onVideoImageObtained(GenericFeedViewHolder genericfeedviewholder, boolean flag)
    {
    }

    public void onVideoPathObtained(HashMap hashmap)
    {
    }

    protected void resetStates(boolean flag)
    {
        if (flag)
        {
            mThumbnails.clear();
            mAvatars.clear();
        }
    }

    protected boolean setImage(View view, Bitmap bitmap)
    {
        if (bitmap == null)
        {
            view.setBackgroundColor(mContext.getResources().getColor(0x7f09007f));
            return false;
        } else
        {
            view.setBackgroundDrawable(new RecyclableBitmapDrawable(mContext.getResources(), bitmap));
            return true;
        }
    }

    public void setImages(HashMap hashmap)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = mViewHolders.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            WeakReference weakreference = (WeakReference)iterator.next();
            GenericFeedViewHolder genericfeedviewholder = (GenericFeedViewHolder)weakreference.get();
            if (genericfeedviewholder == null)
            {
                arraylist.add(weakreference);
            } else
            {
                if (genericfeedviewholder.avatarKey != null)
                {
                    UrlImage urlimage = (UrlImage)hashmap.get(genericfeedviewholder.avatarKey);
                    if (urlimage != null && urlimage.isValid())
                    {
                        setUserImage(genericfeedviewholder.userImage, urlimage.bitmap);
                        SLog.d("found for avatar.");
                    }
                }
                if (genericfeedviewholder.videoImageKey != null)
                {
                    UrlImage urlimage1 = (UrlImage)hashmap.get(genericfeedviewholder.videoImageKey);
                    if (urlimage1 != null && urlimage1.isValid())
                    {
                        SLog.d("found for video: {}", urlimage1.url);
                        onVideoImageObtained(genericfeedviewholder, setImage(genericfeedviewholder.getViewForVideoImage(), urlimage1.bitmap));
                    }
                }
            }
        } while (true);
        mViewHolders.removeAll(arraylist);
    }

    public void setOffsetResolver(ViewOffsetResolver viewoffsetresolver)
    {
        mViewOffsetResolver = viewoffsetresolver;
    }

    public void setProfileColor(int i)
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
            j = mContext.getResources().getColor(0x7f090096);
        }
        if (mProfileColor != j)
        {
            mProfileColor = 0xff000000 | j;
        }
    }

    protected void setStyledComments(GenericFeedViewHolder genericfeedviewholder, VinePagedData vinepageddata)
    {
        Resources resources;
        resources = mContext.getResources();
        genericfeedviewholder.comments1.setVisibility(8);
        genericfeedviewholder.comments2.setVisibility(8);
        genericfeedviewholder.comments3.setVisibility(8);
        View view = genericfeedviewholder.postCommentsDivider;
        if (vinepageddata != null && !vinepageddata.isEmpty())
        {
            view.setVisibility(0);
        } else
        {
            view.setVisibility(8);
        }
        if (vinepageddata != null && vinepageddata.items != null && !vinepageddata.items.isEmpty() && genericfeedviewholder != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        VineComment vinecomment;
        Object obj1;
        int i;
        int j;
        int l;
        ArrayList arraylist;
        Object obj2;
        Object obj4;
        Object obj5;
        int k;
        int i1;
        int j1;
        int k1;
        if (vinepageddata.count > 3)
        {
            Object obj = resources.getString(0x7f0e0245, new Object[] {
                Integer.valueOf(vinepageddata.count)
            });
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
            spannablestringbuilder.append(((CharSequence) (obj)));
            obj = new StyledClickableSpan(3, new SpanCommentObjectTag(genericfeedviewholder.post.postId, genericfeedviewholder.post.userId), mSpanClickListener);
            ((StyledClickableSpan) (obj)).setColor(mVineGray);
            Util.safeSetSpan(spannablestringbuilder, obj, 0, spannablestringbuilder.length(), 33);
            obj = genericfeedviewholder.viewAllComments;
            ((TextView) (obj)).setVisibility(0);
            ((TextView) (obj)).setMovementMethod(LinkMovementMethod.getInstance());
            ((TextView) (obj)).setText(spannablestringbuilder);
        } else
        {
            genericfeedviewholder.viewAllComments.setVisibility(8);
        }
        arraylist = vinepageddata.items;
        k = arraylist.size();
        i = 0;
        j = Math.max(k - 3, 0);
_L10:
        if (j >= k) goto _L1; else goto _L3
_L3:
        vinecomment = (VineComment)arraylist.get(j);
        if (i >= 3) goto _L1; else goto _L4
_L4:
        i;
        JVM INSTR tableswitch 0 1: default 304
    //                   0 657
    //                   1 665;
           goto _L5 _L6 _L7
_L5:
        vinepageddata = genericfeedviewholder.comments3;
_L9:
        vinepageddata.setVisibility(0);
        if (vinecomment.commentSb != null)
        {
            break MISSING_BLOCK_LABEL_950;
        }
        vinecomment.commentSb = new SpannableStringBuilder();
        obj1 = vinecomment.commentSb;
        obj2 = Util.getRelativeTimeString(mContext, vinecomment.timestamp, false);
        ((SpannableStringBuilder) (obj1)).append(vinecomment.username).append(' ').append(vinecomment.comment).append(' ').append(((CharSequence) (obj2)));
        l = vinecomment.username.length();
        i1 = vinecomment.comment.length();
        j1 = ((SpannableStringBuilder) (obj1)).length();
        obj2 = new StyledClickableSpan(1, Long.valueOf(vinecomment.userId), mSpanClickListener);
        obj4 = new TypefacesSpan(null, Typefaces.get(mContext).getContentTypeface(0, 3));
        k1 = resources.getColor(0x7f090018);
        obj5 = new ColorStateList(new int[][] {
            new int[0]
        }, new int[] {
            k1
        });
        obj5 = new TextAppearanceSpan(null, 0, resources.getDimensionPixelSize(0x7f0b004a), ((ColorStateList) (obj5)), null);
        ((StyledClickableSpan) (obj2)).setColor(mProfileColor);
        Util.safeSetSpan(((android.text.Spannable) (obj1)), obj2, 0, l, 33);
        Util.safeSetSpan(((android.text.Spannable) (obj1)), obj4, 0, l, 33);
        Util.safeSetSpan(((android.text.Spannable) (obj1)), obj5, i1 + l + 2, j1, 33);
        if (vinecomment.transientEntities == null && vinecomment.entities != null)
        {
            vinecomment.transientEntities = new ArrayList();
            for (obj2 = vinecomment.entities.iterator(); ((Iterator) (obj2)).hasNext(); vinecomment.transientEntities.add(((VineEntity) (obj4)).duplicate()))
            {
                obj4 = (VineEntity)((Iterator) (obj2)).next();
            }

        }
        break; /* Loop/switch isn't completed */
_L6:
        vinepageddata = genericfeedviewholder.comments1;
        continue; /* Loop/switch isn't completed */
_L7:
        vinepageddata = genericfeedviewholder.comments2;
        if (true) goto _L9; else goto _L8
        vinepageddata;
        CrashUtil.logException(vinepageddata, "Comment attribute caused NPE: {} {} {}", new Object[] {
            Long.valueOf(vinecomment.commentId), vinecomment.username, vinecomment.comment
        });
_L15:
        j++;
        i++;
          goto _L10
_L8:
        Object obj3;
        obj3 = vinecomment.transientEntities;
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_950;
        }
        Util.adjustEntities(((ArrayList) (obj3)), ((android.text.Editable) (obj1)), l + 1, false);
        obj3 = ((ArrayList) (obj3)).iterator();
_L13:
        VineEntity vineentity;
        if (!((Iterator) (obj3)).hasNext())
        {
            break MISSING_BLOCK_LABEL_950;
        }
        vineentity = (VineEntity)((Iterator) (obj3)).next();
        if (!vineentity.isUserType()) goto _L12; else goto _L11
_L11:
        StyledClickableSpan styledclickablespan = new StyledClickableSpan(1, Long.valueOf(vineentity.id), mSpanClickListener);
        styledclickablespan.setColor(mProfileColor);
        Util.safeSetSpan(((android.text.Spannable) (obj1)), styledclickablespan, vineentity.start, vineentity.end, 33);
          goto _L13
        obj1;
        if (BuildUtil.isLogsOn())
        {
            throw new RuntimeException(((Throwable) (obj1)));
        }
        break MISSING_BLOCK_LABEL_917;
_L12:
        if (!vineentity.isTagType()) goto _L13; else goto _L14
_L14:
        StyledClickableSpan styledclickablespan1 = new StyledClickableSpan(4, vineentity.title, mSpanClickListener);
        styledclickablespan1.setColor(mProfileColor);
        Util.safeSetSpan(((android.text.Spannable) (obj1)), styledclickablespan1, vineentity.start, vineentity.end, 33);
          goto _L13
        CrashUtil.logException(((Throwable) (obj1)), (new StringBuilder()).append("Failed to adjust entities on ").append(vinecomment.commentId).toString(), new Object[0]);
        vinepageddata.setMovementMethod(LinkMovementMethod.getInstance());
        vinepageddata.setText(vinecomment.commentSb);
          goto _L15
    }

    protected void setStyledCompactLikesComments(GenericFeedViewHolder genericfeedviewholder)
    {
        int k = genericfeedviewholder.post.likesCount;
        int l = genericfeedviewholder.post.commentsCount;
        int j = genericfeedviewholder.post.revinersCount;
        SpannableStringBuilder spannablestringbuilder;
        Object obj;
        int i;
        if (genericfeedviewholder.post.comments != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        obj = mContext.getResources();
        spannablestringbuilder = new SpannableStringBuilder();
        if (k > 0)
        {
            spannablestringbuilder.append(((Resources) (obj)).getQuantityString(0x7f0d0017, k, new Object[] {
                Util.numberFormat(((Resources) (obj)), k)
            }));
            StyledClickableSpan styledclickablespan = new StyledClickableSpan(2, Long.valueOf(genericfeedviewholder.post.postId), mSpanClickListener);
            styledclickablespan.setColor(mVineGray);
            Util.safeSetSpan(spannablestringbuilder, styledclickablespan, 0, spannablestringbuilder.length(), 33);
        }
        if (l > 0 && i != 0)
        {
            if (spannablestringbuilder.length() > 0)
            {
                spannablestringbuilder.append(' ').append('\267').append(' ');
            }
            spannablestringbuilder.append(((Resources) (obj)).getQuantityString(0x7f0d0016, l, new Object[] {
                Util.numberFormat(((Resources) (obj)), l)
            }));
            StyledClickableSpan styledclickablespan1 = new StyledClickableSpan(3, new SpanCommentObjectTag(genericfeedviewholder.post.postId, genericfeedviewholder.post.userId), mSpanClickListener);
            styledclickablespan1.setColor(mVineGray);
            i = spannablestringbuilder.toString().indexOf('\267');
            if (i < 0)
            {
                i = 0;
            } else
            {
                i += 2;
            }
            Util.safeSetSpan(spannablestringbuilder, styledclickablespan1, i, spannablestringbuilder.length(), 33);
        }
        if (j > 0)
        {
            if (spannablestringbuilder.length() > 0)
            {
                spannablestringbuilder.append(' ').append('\267').append(' ');
            }
            spannablestringbuilder.append(((Resources) (obj)).getQuantityString(0x7f0d0006, j, new Object[] {
                Util.numberFormat(((Resources) (obj)), j)
            }));
            obj = new StyledClickableSpan(7, new SpanCommentObjectTag(genericfeedviewholder.post.postId, genericfeedviewholder.post.userId), mSpanClickListener);
            ((StyledClickableSpan) (obj)).setColor(mVineGray);
            i = spannablestringbuilder.toString().lastIndexOf('\267');
            if (i < 0)
            {
                i = 0;
            } else
            {
                i += 2;
            }
            Util.safeSetSpan(spannablestringbuilder, obj, i, spannablestringbuilder.length(), 33);
        }
        if (spannablestringbuilder.length() > 0)
        {
            Util.safeSetSpan(spannablestringbuilder, new TypefacesSpan(null, Typefaces.get(mContext).getContentTypeface(0, 2)), 0, spannablestringbuilder.length(), 33);
            genericfeedviewholder.compactLikesCommentsRevinesCounts.setMovementMethod(LinkMovementMethod.getInstance());
            genericfeedviewholder.compactLikesCommentsRevinesCounts.setText(spannablestringbuilder);
        } else
        {
            genericfeedviewholder.compactLikesCommentsRevinesCounts.setText(mContext.getString(0x7f0e00fa));
        }
        genericfeedviewholder.compactLikesCommentsRevinesCounts.setVisibility(0);
    }

    protected boolean setUserImage(ImageView imageview, Bitmap bitmap)
    {
        imageview.setColorFilter(null);
        if (bitmap == null)
        {
            imageview.setImageResource(0x7f0200f7);
            return false;
        } else
        {
            imageview.setBackgroundColor(0);
            imageview.setImageDrawable(new RecyclableBitmapDrawable(mContext.getResources(), bitmap));
            return true;
        }
    }

    public void showLikedByMe(long l)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator1 = mViewHolders.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            WeakReference weakreference = (WeakReference)iterator1.next();
            GenericFeedViewHolder genericfeedviewholder = (GenericFeedViewHolder)weakreference.get();
            if (genericfeedviewholder == null)
            {
                arraylist.add(weakreference);
            } else
            if (genericfeedviewholder.post != null && genericfeedviewholder.post.postId == l)
            {
                Object obj = genericfeedviewholder.post;
                obj.likesCount = ((VinePost) (obj)).likesCount + 1;
                VinePagedData vinepageddata = genericfeedviewholder.post.likes;
                VineLike vinelike = new VineLike();
                obj = mAppController.getActiveSession();
                vinelike.likeId = -1L;
                vinelike.postId = l;
                vinelike.username = ((Session) (obj)).getName();
                vinelike.userId = ((Session) (obj)).getUserId();
                obj = vinepageddata;
                if (vinepageddata == null)
                {
                    obj = new VinePagedData();
                }
                if (((VinePagedData) (obj)).items == null)
                {
                    obj.items = new ArrayList();
                }
                ((VinePagedData) (obj)).items.add(vinelike);
                genericfeedviewholder.liked.setSelected(true);
                setStyledCompactLikesComments(genericfeedviewholder);
            }
        } while (true);
        WeakReference weakreference1;
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); mViewHolders.remove(weakreference1))
        {
            weakreference1 = (WeakReference)iterator.next();
        }

    }

    public void showUnlikedByMe(long l)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator1 = mViewHolders.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            WeakReference weakreference = (WeakReference)iterator1.next();
            GenericFeedViewHolder genericfeedviewholder = (GenericFeedViewHolder)weakreference.get();
            if (genericfeedviewholder == null)
            {
                arraylist.add(weakreference);
            } else
            if (genericfeedviewholder.post != null && genericfeedviewholder.post.postId == l)
            {
                if (genericfeedviewholder.post.likesCount > 0)
                {
                    VinePost vinepost = genericfeedviewholder.post;
                    vinepost.likesCount = vinepost.likesCount - 1;
                }
                if (genericfeedviewholder.post.likes != null && genericfeedviewholder.post.likes.items != null)
                {
                    ArrayList arraylist1 = genericfeedviewholder.post.likes.items;
                    VineLike vinelike = null;
                    Iterator iterator2 = arraylist1.iterator();
                    do
                    {
                        if (!iterator2.hasNext())
                        {
                            break;
                        }
                        VineLike vinelike1 = (VineLike)iterator2.next();
                        if (vinelike1.userId == mAppController.getActiveId())
                        {
                            vinelike = vinelike1;
                        }
                    } while (true);
                    if (vinelike != null)
                    {
                        arraylist1.remove(vinelike);
                    }
                }
                genericfeedviewholder.liked.setSelected(false);
                setStyledCompactLikesComments(genericfeedviewholder);
            }
        } while (true);
        WeakReference weakreference1;
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); mViewHolders.remove(weakreference1))
        {
            weakreference1 = (WeakReference)iterator.next();
        }

    }

    public void startLoadingTimeProfiling(String s)
    {
        mLoadingTimeTag = s;
        mStartLoadingTime = System.currentTimeMillis();
    }

    public long timeSinceStartLoadingTime()
    {
        return System.currentTimeMillis() - mStartLoadingTime;
    }

    public void toggleMute(boolean flag)
    {
    }

    public void updateRevinedCount(long l, boolean flag)
    {
        Object obj = new ArrayList();
        Iterator iterator = mViewHolders.iterator();
        do
        {
            if (iterator.hasNext())
            {
                WeakReference weakreference1 = (WeakReference)iterator.next();
                GenericFeedViewHolder genericfeedviewholder = (GenericFeedViewHolder)weakreference1.get();
                if (genericfeedviewholder == null)
                {
                    ((ArrayList) (obj)).add(weakreference1);
                } else
                if (genericfeedviewholder.post != null && genericfeedviewholder.post.postId == l)
                {
                    if (flag)
                    {
                        VinePost vinepost = genericfeedviewholder.post;
                        vinepost.revinersCount = vinepost.revinersCount + 1;
                        genericfeedviewholder.share.setPressed(true);
                    } else
                    {
                        if (genericfeedviewholder.post.revinersCount > 0)
                        {
                            VinePost vinepost1 = genericfeedviewholder.post;
                            vinepost1.revinersCount = vinepost1.revinersCount - 1;
                        }
                        genericfeedviewholder.share.setPressed(false);
                    }
                    genericfeedviewholder.share.setColorFilter(mProfileColor, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    setStyledCompactLikesComments(genericfeedviewholder);
                }
            } else
            {
                WeakReference weakreference;
                for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); mViewHolders.remove(weakreference))
                {
                    weakreference = (WeakReference)((Iterator) (obj)).next();
                }

                return;
            }
        } while (true);
    }
}
