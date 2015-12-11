// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.v4.widget.CursorAdapter;
import android.support.v8.renderscript.RenderScript;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import co.vine.android.api.VineEntity;
import co.vine.android.api.VinePost;
import co.vine.android.api.VinePrivateMessage;
import co.vine.android.client.AppController;
import co.vine.android.drawable.ColoredOvalDrawable;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.player.HasVideoPlayerAdapter;
import co.vine.android.player.OnListVideoClickListener;
import co.vine.android.player.SdkVideoView;
import co.vine.android.player.VideoViewInterface;
import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.recorder.RsBlur;
import co.vine.android.service.VineUploadService;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.MuteUtil;
import co.vine.android.util.SeekInfoManager;
import co.vine.android.util.SystemUtil;
import co.vine.android.util.Util;
import co.vine.android.util.ViewUtil;
import co.vine.android.util.VineDateFormatter;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import co.vine.android.util.video.UrlVideo;
import co.vine.android.util.video.VideoKey;
import co.vine.android.widget.ColoredSpan;
import co.vine.android.widget.StyledClickableSpan;
import co.vine.android.widget.Typefaces;
import co.vine.android.widget.TypefacesSpan;
import com.edisonwang.android.slog.SLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package co.vine.android:
//            VineSpanClicker, Settings, ConversationActivity

public class ConversationAdapter extends CursorAdapter
    implements co.vine.android.player.SdkVideoTimer.HasVideoPlayerViewController, HasVideoPlayerAdapter, android.view.View.OnClickListener
{
    public class BlurRunnable
        implements Runnable
    {

        private final Bitmap bitmap;
        private final ImageView imageView;
        private boolean setImage;
        final ConversationAdapter this$0;

        public void run()
        {
            if (mBlurTempBitmap == null)
            {
                mBlurTempBitmap = RecordConfigUtils.createDefaultSizeBitmap();
            }
            if (mRsBlur == null)
            {
                mRsBlur = new RsBlur(RenderScript.create(mActivity), mBlurTempBitmap, 25F);
            }
            if (setImage)
            {
                imageView.setImageBitmap(mBlurTempBitmap);
                return;
            } else
            {
                mRsBlur.execute(bitmap, mBlurTempBitmap, 6);
                setImage = true;
                mHandler.post(this);
                return;
            }
        }

        public BlurRunnable(Bitmap bitmap1, ImageView imageview)
        {
            this$0 = ConversationAdapter.this;
            super();
            bitmap = bitmap1;
            imageView = imageview;
        }
    }

    public class ConversationVideoClickedListener extends OnListVideoClickListener
    {

        final ConversationAdapter this$0;

        public void onClick(View view)
        {
            super.onClick(view);
            mSingleLoopPosition = -1;
        }

        public ConversationVideoClickedListener()
        {
            this$0 = ConversationAdapter.this;
            super(ConversationAdapter.this);
        }
    }

    public static class ConversationViewHolder
    {

        public ImageKey avatarKey;
        public final View bottomPaddingView;
        public int color;
        public final TextView errorMessage;
        public boolean hasVideoImage;
        public boolean isCurrentUser;
        public boolean isSharedPost;
        public boolean isVideoImageLoaded;
        public final View loadImage;
        public VinePrivateMessage message;
        public final ViewGroup messageContainer;
        public final TextView messageContainerMessage;
        public final ImageView messageContainerUserImage;
        public final View nibs;
        public final View nibsChatNib;
        public int position;
        public final ViewGroup postMessageContainer;
        public final TextView postMessageContainerMessage;
        public View postNibs;
        public final View secondaryMessageContainer;
        public final TextView secondaryMessageContainerMessage;
        public ColoredOvalDrawable timerOval;
        public final TextView timestamp;
        public final ViewGroup topMessageContainer;
        public final TextView topMessageContainerMessage;
        public final ImageView topMessageContainerUserImage;
        public View userImageProgressNormal;
        public View userImageProgressTop;
        public final View vanishMessageContainer;
        public final TextView vanishMessageOverlay;
        public final View vanishPlayButton;
        public VanishPlayButtonListener vanishPlayButtonListener;
        public final View vanishThumbnailOverlay;
        public final TextView vanishTimerText;
        public final ImageView vanishUserImage;
        public final View videoContainer;
        public final ImageView videoImage;
        public ImageKey videoImageKey;
        public OnListVideoClickListener videoListener;
        public SdkVideoView videoView;

        public ConversationViewHolder(View view)
        {
            messageContainer = (ViewGroup)view.findViewById(0x7f0a0135);
            messageContainerUserImage = (ImageView)view.findViewById(0x7f0a0136);
            messageContainerMessage = (TextView)view.findViewById(0x7f0a0138);
            topMessageContainer = (ViewGroup)view.findViewById(0x7f0a0141);
            topMessageContainerUserImage = (ImageView)view.findViewById(0x7f0a0142);
            topMessageContainerMessage = (TextView)view.findViewById(0x7f0a0144);
            vanishThumbnailOverlay = view.findViewById(0x7f0a012c);
            vanishMessageOverlay = (TextView)view.findViewById(0x7f0a00b1);
            vanishMessageContainer = view.findViewById(0x7f0a012d);
            vanishUserImage = (ImageView)view.findViewById(0x7f0a012e);
            vanishPlayButton = view.findViewById(0x7f0a012f);
            vanishTimerText = (TextView)view.findViewById(0x7f0a0134);
            postMessageContainer = (ViewGroup)view.findViewById(0x7f0a0139);
            postMessageContainerMessage = (TextView)view.findViewById(0x7f0a013a);
            userImageProgressNormal = view.findViewById(0x7f0a013e);
            userImageProgressTop = view.findViewById(0x7f0a0143);
            secondaryMessageContainer = view.findViewById(0x7f0a013b);
            secondaryMessageContainerMessage = (TextView)view.findViewById(0x7f0a013c);
            videoContainer = view.findViewById(0x7f0a012a);
            videoImage = (ImageView)view.findViewById(0x7f0a012b);
            videoView = (SdkVideoView)view.findViewById(0x7f0a0130);
            loadImage = view.findViewById(0x7f0a0074);
            errorMessage = (TextView)view.findViewById(0x7f0a013f);
            bottomPaddingView = view.findViewById(0x7f0a013d);
            nibs = view.findViewById(0x7f0a0131);
            postNibs = view.findViewById(0x7f0a0132);
            nibsChatNib = view.findViewById(0x7f0a0137);
            timestamp = (TextView)view.findViewById(0x7f0a0140);
        }
    }

    public class VanishPlayButtonListener
        implements android.view.View.OnClickListener
    {

        private final ConversationViewHolder holder;
        final ConversationAdapter this$0;

        public void onClick(View view)
        {
            holder.vanishMessageContainer.setVisibility(8);
            holder.vanishThumbnailOverlay.setVisibility(8);
            holder.loadImage.setVisibility(0);
            holder.timerOval.setColor(0xff000000 | holder.color);
            holder.vanishTimerText.setVisibility(0);
            holder.vanishTimerText.invalidate();
            play(holder.position);
        }

        public VanishPlayButtonListener(ConversationViewHolder conversationviewholder)
        {
            this$0 = ConversationAdapter.this;
            super();
            holder = conversationviewholder;
        }
    }


    private static final int VIEW_TYPE_COUNT = 2;
    private static final int VIEW_TYPE_ME = 1;
    private static final int VIEW_TYPE_YOU = 0;
    private final ConversationActivity mActivity;
    private final AppController mAppController;
    private final float mAvatarMargin;
    private final SparseArray mAvatars = new SparseArray();
    private Handler mBlurHandler;
    private HandlerThread mBlurHandlerThread;
    private final Runnable mBlurQueueRunnable = new Runnable() {

        final ConversationAdapter this$0;

        public void run()
        {
            if (mCurrentBlurImageView != null && mCurrentBlurBitmap != null)
            {
                (new BlurRunnable(mCurrentBlurBitmap, mCurrentBlurImageView)).run();
            }
        }

            
            {
                this$0 = ConversationAdapter.this;
                super();
            }
    };
    private Bitmap mBlurTempBitmap;
    private final TypefacesSpan mBoldSpan;
    private Bitmap mCurrentBlurBitmap;
    private ImageView mCurrentBlurImageView;
    private int mCurrentPlaying;
    private final ColoredSpan mDarkGreySpan;
    private final Handler mHandler = new Handler();
    private final HashMap mIdToPositionMap = new HashMap();
    private SdkVideoView mLastPlayer;
    private final ListView mListView;
    private final SparseArray mMessages = new SparseArray();
    private boolean mMuted;
    private final int mMyColor;
    private long mMyUserId;
    private final SparseArray mPaths = new SparseArray();
    private final Runnable mPlayCurrentPositionRunnable = new Runnable() {

        final ConversationAdapter this$0;

        public void run()
        {
            this;
            JVM INSTR monitorenter ;
            Object obj;
            int i1;
            i1 = mListView.getFirstVisiblePosition();
            obj = (VinePrivateMessage)mMessages.get(i1);
            if (obj == null) goto _L2; else goto _L1
_L1:
            if (!((VinePrivateMessage) (obj)).hasVideo) goto _L2; else goto _L3
_L3:
            int j = 1;
_L10:
            obj = getViewAt(i1);
            float f;
            int k;
            f = -1F;
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_107;
            }
            k = 0;
            if (getLastPlayer() != null)
            {
                k = getLastPlayer().getHeight() / 2;
            }
            f = ((float)((View) (obj)).getBottom() + (float)k) / ((float)((View) (obj)).getHeight() + (float)k);
            SLog.d("Current First: {}, ratio: {}", Integer.valueOf(i1), Float.valueOf(f));
            byte byte0;
            byte0 = -1;
            if ((double)f < 0.5D || i1 == -1 || j == 0)
            {
                break MISSING_BLOCK_LABEL_288;
            }
              goto _L4
_L11:
            k = byte0;
            if (j >= getCount()) goto _L6; else goto _L5
_L5:
            obj = (VinePrivateMessage)mMessages.get(j);
            k = byte0;
            if (obj == null) goto _L6; else goto _L7
_L7:
            if (!((VinePrivateMessage) (obj)).hasVideo) goto _L9; else goto _L8
_L8:
            k = j;
_L6:
            SLog.d("Current Next: {}", Integer.valueOf(k));
            if (k == -1)
            {
                break MISSING_BLOCK_LABEL_231;
            }
            if (k != mCurrentPlaying)
            {
                play(k);
            }
_L12:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            j = 0;
              goto _L10
_L9:
            j++;
              goto _L11
_L4:
            if (i1 == mCurrentPlaying)
            {
                break MISSING_BLOCK_LABEL_275;
            }
            play(i1);
              goto _L12
            Exception exception;
            exception;
            throw exception;
            playFile(i1, false);
              goto _L12
            j = i1 + 1;
              goto _L11
        }

            
            {
                this$0 = ConversationAdapter.this;
                super();
            }
    };
    private final SparseArray mPlayers = new SparseArray();
    private RsBlur mRsBlur;
    private final int mScreenWidth;
    private final SeekInfoManager mSeekInfoManager;
    private final float mSharedDescSize;
    private int mShouldBePlaying;
    private final float mSidePadding;
    private int mSingleLoopPosition;
    private final VineSpanClicker mSpanClicker;
    private final SparseArray mThumbnails = new SparseArray();
    private final HashMap mUrlReverse = new HashMap();
    private final HashMap mVanishedIdDateMap = new HashMap();
    private AttributeSet mVideoAttr;
    private final ArrayList mViewHolders = new ArrayList();
    private final SparseArray mViewedPorterDuffFilterSet = new SparseArray();
    private final VineDateFormatter mVineDateFormatter;
    private final ColorDrawable mWaitingBg = new ColorDrawable(-1);

    public ConversationAdapter(ConversationActivity conversationactivity, AppController appcontroller, ListView listview, long l, int i)
    {
        super(conversationactivity, null, i);
        mCurrentPlaying = 0x80000000;
        mShouldBePlaying = 0x80000000;
        mMyUserId = l;
        mActivity = conversationactivity;
        mSpanClicker = new VineSpanClicker(conversationactivity);
        mSpanClicker.setFlurryEventSource("ConversationAdapter");
        mAppController = appcontroller;
        mSeekInfoManager = new SeekInfoManager(mAppController);
        mListView = listview;
        mScreenWidth = SystemUtil.getDisplaySize(conversationactivity).x;
        mMyColor = PreferenceManager.getDefaultSharedPreferences(conversationactivity).getInt("profile_background", Settings.DEFAULT_PROFILE_COLOR);
        conversationactivity = conversationactivity.getResources();
        mSharedDescSize = conversationactivity.getDimension(0x7f0b0045);
        mSidePadding = conversationactivity.getDimension(0x7f0b0026);
        mAvatarMargin = conversationactivity.getDimension(0x7f0b0021) + conversationactivity.getDimension(0x7f0b007c);
        mBoldSpan = new TypefacesSpan(null, Typefaces.get(mContext).getContentTypeface(1, 3));
        mDarkGreySpan = new ColoredSpan(conversationactivity.getColor(0x7f09007b));
        mVineDateFormatter = new VineDateFormatter(conversationactivity);
        mVineDateFormatter.refreshDates();
        mVineDateFormatter.addSpanForDateSection(mBoldSpan);
    }

    private co.vine.android.util.SeekInfoManager.SeekInfo getSeekInfo(int i)
    {
        VinePrivateMessage vineprivatemessage;
label0:
        {
            co.vine.android.util.SeekInfoManager.SeekInfo seekinfo = null;
            vineprivatemessage = (VinePrivateMessage)mMessages.get(i);
            if (vineprivatemessage != null)
            {
                if (vineprivatemessage.ephemeral)
                {
                    break label0;
                }
                seekinfo = SeekInfoManager.NO_LOOP_LIMIT;
            }
            return seekinfo;
        }
        return mSeekInfoManager.getSeekInfo(null, vineprivatemessage);
    }

    private co.vine.android.util.SeekInfoManager.SeekInfo getSeekInfoMarkAsRead(VideoViewInterface videoviewinterface, int i)
    {
        co.vine.android.util.SeekInfoManager.SeekInfo seekinfo = null;
        VinePrivateMessage vineprivatemessage = (VinePrivateMessage)mMessages.get(i);
        if (vineprivatemessage != null)
        {
            if (!vineprivatemessage.ephemeral)
            {
                seekinfo = SeekInfoManager.NO_LOOP_LIMIT;
            } else
            {
                co.vine.android.util.SeekInfoManager.SeekInfo seekinfo1 = mSeekInfoManager.getSeekInfo(null, vineprivatemessage);
                seekinfo = seekinfo1;
                if (seekinfo1 == null)
                {
                    return mSeekInfoManager.markAsRead(videoviewinterface.getDuration(), vineprivatemessage);
                }
            }
        }
        return seekinfo;
    }

    private View getViewAt(int i)
    {
        ListView listview = mListView;
        int j = listview.getFirstVisiblePosition() - listview.getHeaderViewsCount() - 0;
        i -= j;
        if (i < 0 || i >= listview.getChildCount())
        {
            SLog.w("Unable to get view for desired position, because it's not being displayed on screen: {} {} {}.", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(listview.getChildCount())
            });
            return null;
        } else
        {
            return listview.getChildAt(i);
        }
    }

    private boolean hasPlayerPlaying()
    {
        return mLastPlayer != null && !mLastPlayer.isPaused();
    }

    private VinePrivateMessage initMessage(Cursor cursor)
    {
        int i = cursor.getPosition();
        cursor = new VinePrivateMessage(cursor);
        mMessages.put(i, cursor);
        return cursor;
    }

    private void initVideoView(final int position, final ConversationViewHolder holder)
    {
        final SdkVideoView view = holder.videoView;
        view.setAutoShow(true);
        view.setOnPreparedListener(new co.vine.android.player.VideoViewInterface.OnPreparedListener() {

            final ConversationAdapter this$0;
            final ConversationViewHolder val$holder;
            final int val$position;

            public void onPrepared(VideoViewInterface videoviewinterface)
            {
                if (!holder.isCurrentUser) goto _L2; else goto _L1
_L1:
                videoviewinterface.start();
                onLoadFinish(holder);
_L4:
                holder.nibs.bringToFront();
                holder.postNibs.bringToFront();
                return;
_L2:
                co.vine.android.util.SeekInfoManager.SeekInfo seekinfo = getSeekInfoMarkAsRead(videoviewinterface, position);
                if (seekinfo == null)
                {
                    CrashUtil.log("Invalid state onPrepared.");
                } else
                if (!seekinfo.isExpired())
                {
                    if (seekinfo.hasLoopLimit() && !seekinfo.isExpired())
                    {
                        videoviewinterface.seekTo(seekinfo.getSeekTime());
                        holder.vanishTimerText.setVisibility(0);
                        holder.vanishTimerText.setText(seekinfo.getLoopsLeftForDisplay());
                    }
                    if (!seekinfo.isExpired())
                    {
                        videoviewinterface.start();
                        onLoadFinish(holder);
                    }
                } else
                {
                    onLoopFinished(videoviewinterface, position);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = ConversationAdapter.this;
                holder = conversationviewholder;
                position = i;
                super();
            }
        });
        view.setOnErrorListener(new co.vine.android.player.VideoViewInterface.OnErrorListener() {

            final ConversationAdapter this$0;
            final SdkVideoView val$view;

            public boolean onError(VideoViewInterface videoviewinterface, int i, int j)
            {
                SLog.d("Got error, try recycling it more aggressively: {}, {}", Integer.valueOf(i), Integer.valueOf(j));
                releaseOtherPlayers(view);
                view.retryOpenVideo(false);
                return true;
            }

            
            {
                this$0 = ConversationAdapter.this;
                view = sdkvideoview;
                super();
            }
        });
        view.setOnCompletionListener(new co.vine.android.player.VideoViewInterface.OnCompletionListener() {

            final ConversationAdapter this$0;
            final int val$position;
            final SdkVideoView val$view;

            public void onCompletion(VideoViewInterface videoviewinterface)
            {
                if (onLoopFinished(view, position))
                {
                    videoviewinterface.seekTo(0);
                    if (position != mSingleLoopPosition)
                    {
                        videoviewinterface.start();
                    }
                }
            }

            
            {
                this$0 = ConversationAdapter.this;
                view = sdkvideoview;
                position = i;
                super();
            }
        });
        mPlayers.put(position, view);
    }

    private void invalidateTimestamp(ConversationViewHolder conversationviewholder, int i, Cursor cursor, VinePrivateMessage vineprivatemessage)
    {
        int j = 0;
        if (i == 0)
        {
            j = 1;
        } else
        {
            VinePrivateMessage vineprivatemessage2 = (VinePrivateMessage)mMessages.get(i - 1);
            VinePrivateMessage vineprivatemessage1 = vineprivatemessage2;
            i = j;
            if (vineprivatemessage2 == null)
            {
                if (cursor.moveToPrevious())
                {
                    vineprivatemessage1 = initMessage(cursor);
                    cursor.moveToNext();
                    i = j;
                } else
                {
                    i = 1;
                    vineprivatemessage1 = vineprivatemessage2;
                }
            }
            j = i;
            if (i == 0)
            {
                if (vineprivatemessage.created <= 0L || vineprivatemessage1.created <= 0L || Math.abs(vineprivatemessage.created - vineprivatemessage1.created) >= 0x36ee80L)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
            }
        }
        if (j != 0)
        {
            conversationviewholder.timestamp.setText(mVineDateFormatter.format(vineprivatemessage.created));
            conversationviewholder.timestamp.setVisibility(0);
            return;
        } else
        {
            conversationviewholder.timestamp.setVisibility(8);
            return;
        }
    }

    private boolean isMessageAlreadyVanished(VinePrivateMessage vineprivatemessage)
    {
        if (vineprivatemessage.ephemeral)
        {
            boolean flag;
            if (vineprivatemessage.vanished)
            {
                flag = true;
            } else
            {
                co.vine.android.util.SeekInfoManager.SeekInfo seekinfo = mSeekInfoManager.get(vineprivatemessage.messageId);
                if (seekinfo != null)
                {
                    if (vineprivatemessage.localStartTime != 0L)
                    {
                        seekinfo.startTime = vineprivatemessage.localStartTime;
                    }
                    boolean flag1 = seekinfo.isExpired();
                    flag = flag1;
                    if (flag1)
                    {
                        vanishMessage(vineprivatemessage);
                        return flag1;
                    }
                } else
                {
                    return false;
                }
            }
            return flag;
        } else
        {
            return false;
        }
    }

    private boolean onLoopFinished(VideoViewInterface videoviewinterface, int i)
    {
        VinePrivateMessage vineprivatemessage;
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = true;
        vineprivatemessage = (VinePrivateMessage)mMessages.get(i);
        if (vineprivatemessage == null || vineprivatemessage.userId == mAppController.getActiveId() || !vineprivatemessage.ephemeral) goto _L2; else goto _L1
_L1:
        co.vine.android.util.SeekInfoManager.SeekInfo seekinfo = mSeekInfoManager.getSeekInfo(videoviewinterface, vineprivatemessage);
        SLog.d("{} just looped, seekInfo {}", Long.valueOf(vineprivatemessage.messageId), seekinfo);
        flag = flag1;
        if (seekinfo != null)
        {
            if (!seekinfo.isExpired())
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        flag1 = flag;
        if (seekinfo != null)
        {
            ((ConversationViewHolder)videoviewinterface.getTag()).vanishTimerText.setText(seekinfo.getLoopsLeftForDisplay());
            flag1 = flag;
        }
_L6:
        return flag1;
_L4:
        vanishMessage(vineprivatemessage);
        mAppController.removeFromVideoCache(new VideoKey(vineprivatemessage.videoUrl));
        vanishView(vineprivatemessage, (ConversationViewHolder)videoviewinterface.getTag(), videoviewinterface);
        return flag;
_L2:
        flag1 = flag;
        if (vineprivatemessage == null)
        {
            CrashUtil.log("Message was null, limited loop function not working.");
            return true;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void refreshVideoView(int i, ConversationViewHolder conversationviewholder)
    {
        ViewGroup viewgroup = (ViewGroup)conversationviewholder.videoView.getParent();
        if (mVideoAttr == null)
        {
            mVideoAttr = conversationviewholder.videoView.getAttributes();
        }
        conversationviewholder.videoView.suspend();
        co.vine.android.util.SeekInfoManager.SeekInfo seekinfo;
        try
        {
            viewgroup.removeView(conversationviewholder.videoView);
        }
        catch (RuntimeException runtimeexception)
        {
            try
            {
                viewgroup.removeView(conversationviewholder.videoView);
            }
            catch (Exception exception)
            {
                CrashUtil.logException(runtimeexception, "Weird things are happening.", new Object[0]);
            }
        }
        conversationviewholder.videoView = new SdkVideoView(mContext, mVideoAttr);
        seekinfo = getSeekInfo(i);
        if (!conversationviewholder.isCurrentUser && seekinfo != null && seekinfo.isExpired())
        {
            conversationviewholder.videoView.setVisibility(4);
        }
        viewgroup.addView(conversationviewholder.videoView);
        initVideoView(i, conversationviewholder);
    }

    private void releaseOtherPlayers(SdkVideoView sdkvideoview)
    {
label0:
        {
            int j = -1;
            int i = 0;
            while (i < mPlayers.size()) 
            {
                int k = mPlayers.keyAt(i);
                SdkVideoView sdkvideoview1 = (SdkVideoView)mPlayers.get(k);
                if (sdkvideoview1 != sdkvideoview)
                {
                    sdkvideoview1.suspend();
                } else
                {
                    j = k;
                }
                i++;
            }
            mPlayers.clear();
            if (sdkvideoview != null)
            {
                if (j < 0)
                {
                    break label0;
                }
                mPlayers.put(j, sdkvideoview);
            }
            return;
        }
        CrashUtil.logException(new RuntimeException("Invalid state in conversation adapter. Was seeing this a lot coming back from full record. Commented out the runtime and am just logging"));
    }

    private boolean setImage(ImageView imageview, Bitmap bitmap, ConversationViewHolder conversationviewholder)
    {
        int i = conversationviewholder.position;
        if (bitmap == null)
        {
            imageview.setBackgroundColor(mContext.getResources().getColor(0x7f09007f));
            imageview.setImageBitmap(null);
            return false;
        }
        boolean flag1 = false;
        boolean flag = flag1;
        if (imageview == conversationviewholder.videoImage)
        {
            flag = flag1;
            if (bitmap.getWidth() == 480)
            {
                flag = flag1;
                if (bitmap.getHeight() == 480)
                {
                    conversationviewholder = (VinePrivateMessage)mMessages.get(i);
                    flag = flag1;
                    if (conversationviewholder != null)
                    {
                        flag = flag1;
                        if (((VinePrivateMessage) (conversationviewholder)).ephemeral)
                        {
                            flag = flag1;
                            if (getSeekInfo(i) == null)
                            {
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        if (flag)
        {
            imageview.setBackgroundColor(mContext.getResources().getColor(0x7f090083));
            imageview.setImageDrawable(mWaitingBg);
            mCurrentBlurBitmap = bitmap;
            mCurrentBlurImageView = imageview;
            mBlurHandler.removeCallbacks(mBlurQueueRunnable);
            mBlurHandler.post(mBlurQueueRunnable);
        } else
        {
            imageview.setImageDrawable(new RecyclableBitmapDrawable(mContext.getResources(), bitmap));
            imageview.setBackgroundColor(mContext.getResources().getColor(0x106000d));
        }
        return true;
    }

    private void setupUserImageImage(VinePrivateMessage vineprivatemessage, ConversationViewHolder conversationviewholder, ImageView imageview, boolean flag)
    {
        if (flag)
        {
            imageview.setColorFilter(null);
            imageview.setImageResource(0x7f02016b);
            return;
        }
        if (Util.isDefaultAvatarUrl(vineprivatemessage.avatarUrl))
        {
            Util.safeSetDefaultAvatar(imageview, co.vine.android.util.Util.ProfileImageSize.MEDIUM, 0xff000000 | conversationviewholder.color);
            return;
        }
        imageview.setColorFilter(null);
        vineprivatemessage = new ImageKey(vineprivatemessage.avatarUrl, true);
        conversationviewholder.avatarKey = vineprivatemessage;
        Bitmap bitmap = (Bitmap)mAvatars.get(conversationviewholder.position);
        if (bitmap != null)
        {
            setImage(imageview, bitmap, conversationviewholder);
            return;
        } else
        {
            setImage(imageview, mAppController.getPhotoBitmap(vineprivatemessage), conversationviewholder);
            return;
        }
    }

    private void setupUserImageProperties(int i, ImageView imageview, boolean flag)
    {
        imageview.setVisibility(0);
        imageview.setTag(Integer.valueOf(i));
        imageview.setOnClickListener(this);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)imageview.getLayoutParams();
        if (!flag)
        {
            layoutparams.addRule(11, 0);
            layoutparams.addRule(9);
        } else
        {
            layoutparams.addRule(9, 0);
            layoutparams.addRule(11);
        }
        imageview.setLayoutParams(layoutparams);
    }

    private boolean shouldShowThumbnail(int i)
    {
        return mCurrentPlaying != i || !hasPlayerPlaying();
    }

    private void styleDescription(TextView textview, VinePost vinepost, int i, boolean flag)
    {
        SpannableStringBuilder spannablestringbuilder;
        VineEntity vineentity1;
        i |= 0xff000000;
        if (vinepost != null && vinepost.transientEntities == null && vinepost.entities != null)
        {
            vinepost.transientEntities = new ArrayList();
            VineEntity vineentity;
            for (Iterator iterator = vinepost.entities.iterator(); iterator.hasNext(); vinepost.transientEntities.add(vineentity.duplicate()))
            {
                vineentity = (VineEntity)iterator.next();
            }

        }
        Object obj;
        StyledClickableSpan styledclickablespan;
        if (vinepost != null)
        {
            obj = vinepost.transientEntities;
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        if (vinepost.descriptionSb != null || vinepost.description == null) goto _L2; else goto _L1
_L1:
        vinepost.descriptionSb = new SpannableStringBuilder(vinepost.description);
        spannablestringbuilder = vinepost.descriptionSb;
        Util.adjustEntities(((ArrayList) (obj)), spannablestringbuilder, 0, false);
        obj = ((ArrayList) (obj)).iterator();
_L6:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L3
_L3:
        vineentity1 = (VineEntity)((Iterator) (obj)).next();
        if (!vineentity1.isUserType()) goto _L5; else goto _L4
_L4:
        styledclickablespan = new StyledClickableSpan(1, Long.valueOf(vineentity1.id), mSpanClicker);
        styledclickablespan.setColor(i);
        Util.safeSetSpan(spannablestringbuilder, styledclickablespan, vineentity1.start, vineentity1.end, 33);
          goto _L6
        obj;
        CrashUtil.logException(((Throwable) (obj)));
_L2:
        textview.setText(vinepost.descriptionSb);
        return;
_L5:
        if (!vineentity1.isTagType()) goto _L6; else goto _L7
_L7:
        StyledClickableSpan styledclickablespan1 = new StyledClickableSpan(4, vineentity1.title, mSpanClicker);
        styledclickablespan1.setColor(i);
        Util.safeSetSpan(spannablestringbuilder, styledclickablespan1, vineentity1.start, vineentity1.end, 33);
          goto _L6
        if (flag || vinepost == null)
        {
            vinepost = new SpannableStringBuilder(mActivity.getString(0x7f0e0215));
            Util.safeSetSpan(vinepost, mDarkGreySpan, 0, vinepost.length(), 33);
            textview.setText(vinepost);
            return;
        } else
        {
            textview.setText(vinepost.description);
            return;
        }
    }

    private void styleTopSharedDescription(VinePost vinepost, boolean flag, int i, TextView textview, boolean flag1)
    {
        if (flag1 || vinepost == null || vinepost.username == null)
        {
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
            Context context = mContext;
            if (flag)
            {
                i = 0x7f0e0218;
            } else
            {
                i = 0x7f0e0216;
            }
            spannablestringbuilder.append(context.getString(i));
            Util.safeSetSpan(spannablestringbuilder, mDarkGreySpan, 0, spannablestringbuilder.length(), 33);
            textview.setText(spannablestringbuilder);
            if (vinepost != null && vinepost.username == null)
            {
                CrashUtil.logException(new IllegalArgumentException((new StringBuilder()).append("Username is null: ").append(vinepost.postId).toString()));
            }
            return;
        }
        if (vinepost.sharedVmSb == null)
        {
            Object obj = mContext;
            String s;
            SpannableStringBuilder spannablestringbuilder1;
            int j;
            int k;
            int l;
            if (flag)
            {
                j = 0x7f0e0219;
            } else
            {
                j = 0x7f0e0217;
            }
            s = ((Context) (obj)).getString(j);
            vinepost.sharedVmSb = new SpannableStringBuilder();
            spannablestringbuilder1 = vinepost.sharedVmSb;
            j = s.indexOf("{");
            if (j > 0)
            {
                spannablestringbuilder1.append(s.substring(0, j));
            }
            obj = s;
            if (s.indexOf("}") < 0)
            {
                obj = (new StringBuilder()).append(s).append("}").toString();
            }
            try
            {
                s = ((String) (obj)).substring(j + 1, ((String) (obj)).indexOf("}"));
            }
            catch (Exception exception)
            {
                CrashUtil.logException(exception, "Failed top post span thing. locale: {}", new Object[] {
                    Util.getLocale()
                });
                exception = "%s";
            }
            spannablestringbuilder1.append(s.replace("%s", vinepost.username));
            k = spannablestringbuilder1.length();
            l = ((String) (obj)).indexOf("}");
            if (l < ((String) (obj)).length() - 1)
            {
                spannablestringbuilder1.append(((String) (obj)).substring(l + 1));
            }
            obj = new StyledClickableSpan(9, Long.valueOf(vinepost.postId), mSpanClicker);
            ((StyledClickableSpan) (obj)).setColor(i | 0xff000000);
            Util.safeSetSpan(spannablestringbuilder1, obj, j, k, 33);
            Util.safeSetSpan(spannablestringbuilder1, mBoldSpan, j, k, 33);
            Util.safeSetSpan(spannablestringbuilder1, mDarkGreySpan, 0, j, 33);
        }
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        textview.setText(vinepost.sharedVmSb);
    }

    private void vanishMessage(VinePrivateMessage vineprivatemessage)
    {
        vineprivatemessage.vanished = true;
        vineprivatemessage.vanishedDate = System.currentTimeMillis();
        mVanishedIdDateMap.put(Long.valueOf(vineprivatemessage.messageId), Long.valueOf(vineprivatemessage.vanishedDate));
    }

    private void vanishView(VinePrivateMessage vineprivatemessage, ConversationViewHolder conversationviewholder, VideoViewInterface videoviewinterface)
    {
        if (videoviewinterface.isInPlaybackState())
        {
            videoviewinterface.stopPlayback();
            videoviewinterface.setVideoPath(null);
        }
        if (conversationviewholder.videoContainer.getVisibility() != 8)
        {
            conversationviewholder.videoContainer.setVisibility(8);
        }
        if (conversationviewholder.vanishTimerText.getVisibility() != 8)
        {
            conversationviewholder.vanishTimerText.setVisibility(8);
        }
        int i = 0x60000000 | conversationviewholder.color;
        PorterDuffColorFilter porterduffcolorfilter = (PorterDuffColorFilter)mViewedPorterDuffFilterSet.get(i);
        videoviewinterface = porterduffcolorfilter;
        if (porterduffcolorfilter == null)
        {
            videoviewinterface = new PorterDuffColorFilter(i, android.graphics.PorterDuff.Mode.SRC_IN);
            mViewedPorterDuffFilterSet.put(i, videoviewinterface);
        }
        conversationviewholder.secondaryMessageContainer.getBackground().setColorFilter(videoviewinterface);
        conversationviewholder.secondaryMessageContainer.setVisibility(0);
        if (vineprivatemessage.vanishedViewedSb == null)
        {
            vineprivatemessage.vanishedViewedSb = new SpannableStringBuilder();
            videoviewinterface = (Long)mVanishedIdDateMap.get(Long.valueOf(vineprivatemessage.messageId));
            Object obj;
            int j;
            int k;
            long l;
            if (videoviewinterface != null)
            {
                l = videoviewinterface.longValue();
            } else
            {
                l = vineprivatemessage.vanishedDate;
            }
            obj = new Date(l);
            videoviewinterface = mActivity.getString(0x7f0e0270);
            obj = DateFormat.format("hh:mm aa", ((Date) (obj))).toString();
            j = videoviewinterface.indexOf("%s");
            k = j + ((String) (obj)).length();
            vineprivatemessage.vanishedViewedSb.append(videoviewinterface.replace("%s", ((CharSequence) (obj))));
            Util.safeSetSpan(vineprivatemessage.vanishedViewedSb, new ColoredSpan(0xff000000 | conversationviewholder.color), 0, k, 33);
            Util.safeSetSpan(vineprivatemessage.vanishedViewedSb, mBoldSpan, j, k, 33);
        }
        conversationviewholder.secondaryMessageContainerMessage.setText(vineprivatemessage.vanishedViewedSb);
    }

    public boolean atLastPage()
    {
        return mCursor != null && mCursor.moveToFirst() && mCursor.getInt(8) == 1;
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        final VinePrivateMessage vpm;
        Object obj;
        boolean flag;
        int j;
        boolean flag1;
        int k;
        int l;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
label0:
        {
            l = cursor.getPosition();
            vpm = initMessage(cursor);
            obj = context.getResources();
            android.view.View.OnLongClickListener onlongclicklistener = new android.view.View.OnLongClickListener() {

                final ConversationAdapter this$0;
                final VinePrivateMessage val$vpm;

                public boolean onLongClick(View view1)
                {
                    mActivity.showDeleteMessageDialog(vpm.messageId);
                    return true;
                }

            
            {
                this$0 = ConversationAdapter.this;
                vpm = vineprivatemessage;
                super();
            }
            };
            context = (ConversationViewHolder)view.getTag();
            view.setOnLongClickListener(onlongclicklistener);
            ((ConversationViewHolder) (context)).videoContainer.setOnLongClickListener(onlongclicklistener);
            context.avatarKey = null;
            context.videoImageKey = null;
            context.position = l;
            if (((ConversationViewHolder) (context)).userImageProgressNormal != null && ((ConversationViewHolder) (context)).userImageProgressTop != null)
            {
                ((ConversationViewHolder) (context)).userImageProgressTop.setVisibility(8);
                ((ConversationViewHolder) (context)).userImageProgressNormal.setVisibility(8);
            }
            int i;
            if (mMyUserId == vpm.userId)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            context.isCurrentUser = flag2;
            ((ConversationViewHolder) (context)).videoListener.setPosition(l);
            invalidateTimestamp(context, l, cursor, vpm);
            if (flag2)
            {
                j = mMyColor;
            } else
            {
                j = cursor.getInt(25);
            }
            i = j;
            if (j <= 0)
            {
                i = Settings.DEFAULT_PROFILE_COLOR;
            }
            if (i != Settings.DEFAULT_PROFILE_COLOR)
            {
                j = i;
                if (i > 0)
                {
                    break label0;
                }
            }
            j = 0xffffff & mContext.getResources().getColor(0x7f090096);
        }
        context.color = j;
        if (vpm.postId > 0L)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        context.isSharedPost = flag3;
        flag6 = isMessageAlreadyVanished(vpm);
        if (flag3 && (vpm.videoUrl == null || vpm.thumbnailUrl == null || vpm.post.username == null))
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        if (vpm.hasVideo || vpm.ephemeral && !flag6 || flag4)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (TextUtils.isEmpty(vpm.message))
        {
            view = "";
        } else
        {
            view = vpm.message;
        }
        if (vpm.ephemeral && flag6)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag1)
        {
            if (vpm.ephemeral)
            {
                ((ConversationViewHolder) (context)).vanishThumbnailOverlay.setVisibility(0);
            } else
            {
                ((ConversationViewHolder) (context)).vanishThumbnailOverlay.setVisibility(8);
            }
        }
        ((ConversationViewHolder) (context)).vanishTimerText.setVisibility(8);
        if (flag4)
        {
            ((ConversationViewHolder) (context)).videoImage.setScaleType(android.widget.ImageView.ScaleType.CENTER);
            ((ConversationViewHolder) (context)).videoImage.setBackgroundColor(((Resources) (obj)).getColor(0x7f09007f));
        } else
        {
            ((ConversationViewHolder) (context)).videoImage.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            ((ConversationViewHolder) (context)).videoImage.setBackgroundColor(((Resources) (obj)).getColor(0x106000d));
        }
        if (vpm.ephemeral)
        {
            ((ConversationViewHolder) (context)).videoContainer.setOnClickListener(null);
            ((ConversationViewHolder) (context)).messageContainer.setVisibility(8);
            if (getSeekInfo(((ConversationViewHolder) (context)).position) == null)
            {
                ((ConversationViewHolder) (context)).vanishMessageContainer.setVisibility(0);
                ((ConversationViewHolder) (context)).vanishMessageOverlay.setText(view);
                if (flag2)
                {
                    ((ConversationViewHolder) (context)).vanishPlayButton.setVisibility(8);
                } else
                {
                    ((ConversationViewHolder) (context)).vanishPlayButton.setVisibility(0);
                }
            }
            view = ((ConversationViewHolder) (context)).vanishUserImage;
            if (vpm.errorCode != 0)
            {
                flag5 = true;
            } else
            {
                flag5 = false;
            }
            setupUserImageImage(vpm, context, view, flag5);
            ((ConversationViewHolder) (context)).topMessageContainer.setVisibility(8);
        } else
        {
            TextView textview;
            if (flag4)
            {
                ((ConversationViewHolder) (context)).videoContainer.setOnClickListener(null);
                ((ConversationViewHolder) (context)).videoImage.setImageResource(0x7f02006e);
            } else
            {
                ((ConversationViewHolder) (context)).videoContainer.setOnClickListener(((ConversationViewHolder) (context)).videoListener);
                ((ConversationViewHolder) (context)).videoImage.setImageBitmap(null);
            }
            ((ConversationViewHolder) (context)).vanishMessageContainer.setVisibility(8);
            ((ConversationViewHolder) (context)).messageContainer.setVisibility(0);
            ((ConversationViewHolder) (context)).postMessageContainer.setVisibility(8);
            textview = ((ConversationViewHolder) (context)).messageContainerMessage;
            if (flag3)
            {
                ((ConversationViewHolder) (context)).messageContainer.setVisibility(8);
                ((ConversationViewHolder) (context)).postMessageContainer.setVisibility(0);
                ((ConversationViewHolder) (context)).topMessageContainer.setVisibility(0);
                setupUserImageProperties(l, ((ConversationViewHolder) (context)).topMessageContainerUserImage, flag2);
                view = ((ConversationViewHolder) (context)).topMessageContainerUserImage;
                if (vpm.errorCode != 0)
                {
                    flag5 = true;
                } else
                {
                    flag5 = false;
                }
                setupUserImageImage(vpm, context, view, flag5);
                view = ((ConversationViewHolder) (context)).topMessageContainerMessage;
                if (flag2)
                {
                    k = 5;
                } else
                {
                    k = 3;
                }
                view.setGravity(k | 0x10);
                view = (android.widget.RelativeLayout.LayoutParams)((ConversationViewHolder) (context)).topMessageContainerMessage.getLayoutParams();
                if (flag2)
                {
                    k = (int)mAvatarMargin;
                } else
                {
                    k = 0;
                }
                view.rightMargin = k;
                if (flag2)
                {
                    k = 0;
                } else
                {
                    k = (int)mAvatarMargin;
                }
                view.leftMargin = k;
                styleTopSharedDescription(vpm.post, flag2, j, ((ConversationViewHolder) (context)).topMessageContainerMessage, flag4);
                styleDescription(((ConversationViewHolder) (context)).postMessageContainerMessage, vpm.post, j, flag4);
                ((ConversationViewHolder) (context)).postMessageContainerMessage.setTextColor(0xff000000);
                ((ConversationViewHolder) (context)).postMessageContainerMessage.setTextSize(0, mSharedDescSize);
                ViewUtil.setBackground(((ConversationViewHolder) (context)).postMessageContainerMessage, null);
            } else
            {
                textview.setText(view);
                setupUserImageProperties(l, ((ConversationViewHolder) (context)).messageContainerUserImage, flag2);
                ImageView imageview = ((ConversationViewHolder) (context)).messageContainerUserImage;
                if (vpm.errorCode != 0)
                {
                    flag5 = true;
                } else
                {
                    flag5 = false;
                }
                setupUserImageImage(vpm, context, imageview, flag5);
                ((ConversationViewHolder) (context)).topMessageContainer.setVisibility(8);
                if (TextUtils.isEmpty(vpm.errorReason))
                {
                    if (((ConversationViewHolder) (context)).errorMessage != null)
                    {
                        ((ConversationViewHolder) (context)).errorMessage.setVisibility(8);
                    }
                    textview.setVisibility(0);
                    textview.setTextColor(0xff000000 | j);
                    if (!TextUtils.isEmpty(view))
                    {
                        if (flag2)
                        {
                            ViewUtil.fillColor(((Resources) (obj)), 0x33000000 | j, 0x7f0200ed, textview);
                            ViewUtil.fillColor(((Resources) (obj)), 0x33000000 | j, 0x7f020287, ((ConversationViewHolder) (context)).nibsChatNib);
                        } else
                        if (mMyColor != j)
                        {
                            ViewUtil.fillColor(((Resources) (obj)), 0x33000000 | j, 0x7f0200ed, textview);
                            ViewUtil.fillColor(((Resources) (obj)), 0x33000000 | j, 0x7f020288, ((ConversationViewHolder) (context)).nibsChatNib);
                        } else
                        {
                            ViewUtil.fillColor(((Resources) (obj)), 0xff000000 | j, 0x7f0200ed, textview);
                            ViewUtil.fillColor(((Resources) (obj)), 0xff000000 | j, 0x7f020288, ((ConversationViewHolder) (context)).nibsChatNib);
                            textview.setTextColor(-1);
                        }
                    } else
                    {
                        textview.setVisibility(8);
                    }
                } else
                {
                    if (TextUtils.isEmpty(view))
                    {
                        textview.setVisibility(8);
                    } else
                    {
                        j = ((Resources) (obj)).getColor(0x7f090081);
                        k = ((Resources) (obj)).getColor(0x7f090080);
                        textview.setVisibility(0);
                        textview.setTextColor(j);
                        ViewUtil.fillColor(((Resources) (obj)), k, 0x7f0200ed, textview);
                        ViewUtil.fillColor(((Resources) (obj)), k, 0x7f020287, ((ConversationViewHolder) (context)).nibsChatNib);
                    }
                    if (((ConversationViewHolder) (context)).errorMessage != null)
                    {
                        ((ConversationViewHolder) (context)).errorMessage.setVisibility(0);
                        ((ConversationViewHolder) (context)).errorMessage.setText(vpm.errorReason);
                    }
                }
            }
        }
        if (flag4)
        {
            view = null;
        } else
        {
            view = vpm.thumbnailUrl;
        }
        if (view != null)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        context.hasVideoImage = flag5;
        if (((ConversationViewHolder) (context)).hasVideoImage)
        {
            view = new ImageKey(view);
            context.videoImageKey = view;
            obj = (Bitmap)mThumbnails.get(l);
            if (obj != null)
            {
                SLog.d("setting thumbnail for {}", Integer.valueOf(l));
                context.isVideoImageLoaded = setImage(((ConversationViewHolder) (context)).videoImage, ((Bitmap) (obj)), context);
            } else
            {
                SLog.d("fetching thumbnail for {}", Integer.valueOf(l));
                view = mAppController.getPhotoBitmap(view);
                if (view != null)
                {
                    mThumbnails.put(l, view);
                }
                context.isVideoImageLoaded = setImage(((ConversationViewHolder) (context)).videoImage, view, context);
            }
            ((ConversationViewHolder) (context)).loadImage.setVisibility(8);
        } else
        if (vpm.ephemeral || flag4)
        {
            ((ConversationViewHolder) (context)).loadImage.setVisibility(8);
        } else
        if (!flag2)
        {
            ((ConversationViewHolder) (context)).loadImage.setVisibility(0);
        }
        k = 0;
        if (flag1)
        {
            ((ConversationViewHolder) (context)).videoContainer.setVisibility(0);
            ((ConversationViewHolder) (context)).nibsChatNib.setVisibility(4);
            if (shouldShowThumbnail(l) && ((ConversationViewHolder) (context)).videoView.getPlayingPosition() != l)
            {
                ((ConversationViewHolder) (context)).videoView.setVisibility(4);
            }
            initVideoView(l, context);
            view = ((ConversationViewHolder) (context)).nibs;
            if (flag3)
            {
                j = 8;
            } else
            {
                j = 0;
            }
            view.setVisibility(j);
            view = ((ConversationViewHolder) (context)).postNibs;
            if (flag3)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            view.setVisibility(j);
            j = k;
        } else
        {
            ((ConversationViewHolder) (context)).videoContainer.setVisibility(8);
            ((ConversationViewHolder) (context)).nibsChatNib.setVisibility(0);
            ((ConversationViewHolder) (context)).videoView.setTag(context);
            mPlayers.remove(l);
            j = k;
            if (flag6)
            {
                vanishView(vpm, context, ((ConversationViewHolder) (context)).videoView);
                j = 1;
            }
        }
        if (flag)
        {
            if (j == 0)
            {
                vanishView(vpm, context, ((ConversationViewHolder) (context)).videoView);
            }
        } else
        {
            ((ConversationViewHolder) (context)).secondaryMessageContainer.setVisibility(8);
        }
        ((ConversationViewHolder) (context)).vanishThumbnailOverlay.setBackgroundColor(0xd2000000 | ((ConversationViewHolder) (context)).color);
        if (cursor.getPosition() == cursor.getCount() - 1)
        {
            ((ConversationViewHolder) (context)).bottomPaddingView.setVisibility(0);
        } else
        {
            ((ConversationViewHolder) (context)).bottomPaddingView.setVisibility(8);
        }
        ((ConversationViewHolder) (context)).videoView.setMute(mMuted);
    }

    public long getIdAtLastPosition()
    {
        Cursor cursor = getCursor();
        if (cursor != null && cursor.moveToLast())
        {
            return cursor.getLong(3);
        } else
        {
            return -1L;
        }
    }

    public long getItemId(int i)
    {
        if (mCursor != null && mCursor.moveToPosition(i))
        {
            return mCursor.getLong(0);
        } else
        {
            return -1L;
        }
    }

    public int getItemViewType(int i)
    {
        Cursor cursor = (Cursor)getItem(i);
        return mMyUserId != cursor.getLong(3) ? 0 : 1;
    }

    public SdkVideoView getLastPlayer()
    {
        return mLastPlayer;
    }

    public SdkVideoView getPlayer(int i, boolean flag)
    {
        return (SdkVideoView)mPlayers.get(i);
    }

    public int getPositionForId(long l)
    {
        if (mIdToPositionMap.containsKey(Long.valueOf(l)))
        {
            return ((Integer)mIdToPositionMap.get(Long.valueOf(l))).intValue();
        } else
        {
            return -1;
        }
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        context = LayoutInflater.from(context);
        boolean flag;
        if ((long)cursor.getInt(3) == mMyUserId)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            context = context.inflate(0x7f03005c, viewgroup, false);
        } else
        {
            context = context.inflate(0x7f03005b, viewgroup, false);
        }
        cursor = new ConversationViewHolder(context);
        ((ConversationViewHolder) (cursor)).videoContainer.setVisibility(0);
        cursor.timerOval = new ColoredOvalDrawable();
        ViewUtil.setBackground(((ConversationViewHolder) (cursor)).vanishTimerText, ((ConversationViewHolder) (cursor)).timerOval);
        cursor.videoListener = new ConversationVideoClickedListener();
        viewgroup = ((ConversationViewHolder) (cursor)).videoContainer.getLayoutParams();
        viewgroup.height = (int)((float)mScreenWidth - mSidePadding * 2.0F);
        viewgroup.width = (int)((float)mScreenWidth - mSidePadding * 2.0F);
        ((ConversationViewHolder) (cursor)).videoContainer.setLayoutParams(viewgroup);
        viewgroup = ((ConversationViewHolder) (cursor)).videoImage.getLayoutParams();
        viewgroup.width = (int)((float)mScreenWidth - mSidePadding * 2.0F);
        viewgroup.height = (int)((float)mScreenWidth - mSidePadding * 2.0F);
        cursor.vanishPlayButtonListener = new VanishPlayButtonListener(cursor);
        ((ConversationViewHolder) (cursor)).vanishPlayButton.setOnClickListener(((ConversationViewHolder) (cursor)).vanishPlayButtonListener);
        ((ConversationViewHolder) (cursor)).videoImage.setLayoutParams(viewgroup);
        ((ConversationViewHolder) (cursor)).messageContainerUserImage.bringToFront();
        context.setTag(cursor);
        mViewHolders.add(new WeakReference(cursor));
        return context;
    }

    public void onClick(final View v)
    {
        final VinePrivateMessage vpm = ((VinePrivateMessage) (v.getTag()));
        if (vpm instanceof Integer)
        {
            vpm = (VinePrivateMessage)mMessages.get(((Integer)vpm).intValue());
            v = new Runnable() ;
            if (vpm.errorCode == 616)
            {
                mActivity.startPhoneConfirmation(v);
            } else
            if (vpm.errorCode != 0)
            {
                v.run();
                return;
            }
        }
    }

    void onLoadFinish(ConversationViewHolder conversationviewholder)
    {
        if ((VinePrivateMessage)mMessages.get(conversationviewholder.position) != null && conversationviewholder.videoView.getVisibility() != 0)
        {
            conversationviewholder.videoView.setVisibility(0);
        }
    }

    public void onPause()
    {
        if (mBlurHandlerThread != null)
        {
            Looper looper = mBlurHandlerThread.getLooper();
            if (looper != null)
            {
                looper.quit();
            }
            mBlurHandlerThread = null;
        }
        if (mLastPlayer != null && mLastPlayer.hasStarted() && mCurrentPlaying > 0)
        {
            VinePrivateMessage vineprivatemessage = (VinePrivateMessage)mMessages.get(mCurrentPlaying);
            if (vineprivatemessage != null && vineprivatemessage.userId != mAppController.getActiveId() && vineprivatemessage.ephemeral && mSeekInfoManager.get(vineprivatemessage.messageId) != null)
            {
                SLog.i("Vanishing onPause for {}.", Long.valueOf(vineprivatemessage.messageId));
                vanishMessage(vineprivatemessage);
            }
        }
        stopCurrentPlayer();
        releaseOtherPlayers(null);
    }

    public void onResume()
    {
        mBlurHandlerThread = new HandlerThread("blur-thread");
        mBlurHandlerThread.start();
        mBlurHandler = new Handler(mBlurHandlerThread.getLooper());
        mMuted = MuteUtil.isMuted(mContext);
        playCurrentPosition();
        mVineDateFormatter.refreshDates();
    }

    public void onVideoPathObtained(HashMap hashmap)
    {
        Iterator iterator = hashmap.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VideoKey videokey = (VideoKey)iterator.next();
            UrlVideo urlvideo = (UrlVideo)hashmap.get(videokey);
            if (urlvideo.isValid() && mUrlReverse.get(videokey) != null)
            {
                mPaths.put(((Integer)mUrlReverse.get(videokey)).intValue(), urlvideo.getAbsolutePath());
                if (((Integer)mUrlReverse.get(videokey)).intValue() == mShouldBePlaying)
                {
                    playCurrentPosition();
                }
            }
        } while (true);
    }

    public void pauseCurrentPlayer()
    {
        if (hasPlayerPlaying())
        {
            mLastPlayer.pause();
        }
    }

    public void play(int i)
    {
        this;
        JVM INSTR monitorenter ;
        SLog.d("Play {} requested.", Integer.valueOf(i));
        if (mPaths.get(i) == null) goto _L2; else goto _L1
_L1:
        playFile(i, true);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (mMessages.get(i) == null) goto _L4; else goto _L3
_L3:
        Object obj;
        Object obj1;
        obj = new VideoKey(((VinePrivateMessage)mMessages.get(i)).videoUrl);
        obj1 = mAppController.getVideoFilePath(((VideoKey) (obj)));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        mPaths.put(i, obj1);
        SLog.d("playing file at position {}", Integer.valueOf(i));
        playFile(i, true);
          goto _L4
        obj;
        throw obj;
        obj1 = getViewAt(i);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        obj1 = (ConversationViewHolder)((View) (obj1)).getTag();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        if (((ConversationViewHolder) (obj1)).vanishMessageContainer.getVisibility() == 0) goto _L4; else goto _L5
_L5:
        ((ConversationViewHolder) (obj1)).loadImage.setVisibility(0);
        mShouldBePlaying = i;
        mUrlReverse.put(obj, Integer.valueOf(i));
          goto _L4
    }

    public void playCurrentPosition()
    {
        this;
        JVM INSTR monitorenter ;
        mHandler.removeCallbacks(mPlayCurrentPositionRunnable);
        mHandler.postDelayed(mPlayCurrentPositionRunnable, 50L);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void playFile(int i, boolean flag)
    {
        if (i >= 0)
        {
            View view = getViewAt(i);
            if (view == null)
            {
                SLog.i("Item is not visible: {}", Integer.valueOf(i));
                return;
            }
            Object obj1 = (ConversationViewHolder)view.getTag();
            if (obj1 != null)
            {
                if (((ConversationViewHolder) (obj1)).vanishMessageContainer.getVisibility() == 0)
                {
                    SLog.d("No AutoPlay for Ephemeral.");
                    return;
                }
                String s = (String)mPaths.get(i);
                Object obj = ((ConversationViewHolder) (obj1)).videoView.getPath();
                if (s != null)
                {
                    pauseCurrentPlayer();
                    if (!s.equals(obj))
                    {
                        refreshVideoView(i, ((ConversationViewHolder) (obj1)));
                        obj = ((ConversationViewHolder) (obj1)).videoView;
                        ((SdkVideoView) (obj)).setVideoPath(s);
                        ((SdkVideoView) (obj)).setPlayingPosition(i);
                        ((SdkVideoView) (obj)).setTag(obj1);
                        ((ConversationViewHolder) (obj1)).videoListener.setPosition(i);
                    } else
                    {
                        obj = ((ConversationViewHolder) (obj1)).videoView;
                        obj1 = (VinePrivateMessage)mMessages.get(i);
                        if (obj1 != null && !((VinePrivateMessage) (obj1)).ephemeral && ((SdkVideoView) (obj)).getVisibility() != 0)
                        {
                            ((SdkVideoView) (obj)).setVisibility(0);
                        }
                        ((SdkVideoView) (obj)).setPlayingPosition(i);
                        if (((SdkVideoView) (obj)).isInPlaybackState() && ((SdkVideoView) (obj)).isPathPlaying(s))
                        {
                            ((SdkVideoView) (obj)).start();
                        } else
                        {
                            ((SdkVideoView) (obj)).setVideoPath(s);
                        }
                    }
                    mCurrentPlaying = i;
                    mLastPlayer = ((SdkVideoView) (obj));
                    ((SdkVideoView) (obj)).setMute(mMuted);
                    return;
                }
            }
        }
    }

    public void setImages(HashMap hashmap)
    {
        Object obj = new ArrayList();
        Iterator iterator = mViewHolders.iterator();
        do
        {
            if (iterator.hasNext())
            {
                WeakReference weakreference = (WeakReference)iterator.next();
                ConversationViewHolder conversationviewholder = (ConversationViewHolder)weakreference.get();
                if (conversationviewholder == null)
                {
                    ((ArrayList) (obj)).add(weakreference);
                } else
                {
                    if (conversationviewholder.avatarKey != null)
                    {
                        UrlImage urlimage = (UrlImage)hashmap.get(conversationviewholder.avatarKey);
                        if (urlimage != null && urlimage.isValid())
                        {
                            if (conversationviewholder.isSharedPost)
                            {
                                setImage(conversationviewholder.topMessageContainerUserImage, urlimage.bitmap, conversationviewholder);
                            } else
                            {
                                setImage(conversationviewholder.messageContainerUserImage, urlimage.bitmap, conversationviewholder);
                                setImage(conversationviewholder.vanishUserImage, urlimage.bitmap, conversationviewholder);
                            }
                        }
                    }
                    if (conversationviewholder.videoImageKey != null)
                    {
                        urlimage = (UrlImage)hashmap.get(conversationviewholder.videoImageKey);
                        if (urlimage != null && urlimage.isValid())
                        {
                            conversationviewholder.isVideoImageLoaded = setImage(conversationviewholder.videoImage, urlimage.bitmap, conversationviewholder);
                            mThumbnails.put(conversationviewholder.videoListener.getPosition(), urlimage.bitmap);
                            SLog.d("Image found: {}.", Integer.valueOf(conversationviewholder.videoListener.getPosition()));
                            playCurrentPosition();
                        }
                    }
                }
            } else
            {
                for (hashmap = ((ArrayList) (obj)).iterator(); hashmap.hasNext(); mViewHolders.remove(obj))
                {
                    obj = (WeakReference)hashmap.next();
                }

                return;
            }
        } while (true);
    }

    public void stopCurrentPlayer()
    {
        if (mLastPlayer != null)
        {
            mLastPlayer.suspend();
            mLastPlayer = null;
            mCurrentPlaying = -1;
        }
    }

    public Cursor swapCursor(Cursor cursor)
    {
        Cursor cursor1 = swapCursor(cursor);
        mIdToPositionMap.clear();
        mThumbnails.clear();
        mPaths.clear();
        if (cursor != null && cursor.moveToFirst())
        {
            mSingleLoopPosition = cursor.getCount() - 1;
            do
            {
                mIdToPositionMap.put(Long.valueOf(cursor.getLong(0)), Integer.valueOf(cursor.getPosition()));
            } while (cursor.moveToNext());
            return cursor1;
        } else
        {
            mSingleLoopPosition = -1;
            return cursor1;
        }
    }

    public void toggleMute(boolean flag)
    {
        mMuted = flag;
        SLog.d("Mute state changed to muted? {}.", Boolean.valueOf(flag));
        SdkVideoView sdkvideoview = getLastPlayer();
        if (sdkvideoview != null)
        {
            sdkvideoview.setMute(mMuted);
        }
    }








/*
    static Bitmap access$1302(ConversationAdapter conversationadapter, Bitmap bitmap)
    {
        conversationadapter.mBlurTempBitmap = bitmap;
        return bitmap;
    }

*/



/*
    static RsBlur access$1402(ConversationAdapter conversationadapter, RsBlur rsblur)
    {
        conversationadapter.mRsBlur = rsblur;
        return rsblur;
    }

*/










/*
    static int access$802(ConversationAdapter conversationadapter, int i)
    {
        conversationadapter.mSingleLoopPosition = i;
        return i;
    }

*/

}
