// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.util.LongSparseArray;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.provider.VineProviderHelper;
import co.vine.android.recorder.InlineVineRecorder;
import co.vine.android.recorder.ProgressView;
import co.vine.android.recorder.RecordSessionManager;
import co.vine.android.recorder.RecordSessionVersion;
import co.vine.android.recorder.RecordingFile;
import co.vine.android.service.VineUploadService;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.MuteUtil;
import co.vine.android.util.UploadManager;
import co.vine.android.util.Util;
import co.vine.android.util.ViewUtil;
import co.vine.android.widget.ConversationList;
import co.vine.android.widget.TypefacesEditText;
import com.edisonwang.android.slog.SLog;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            BaseCursorListFragment, ConversationActivity, AbstractRecordingActivity, ConversationAdapter, 
//            InlineRecorderManager, Settings, PostOptionsDialogActivity, BaseActionBarActivity

public class ConversationFragment extends BaseCursorListFragment
    implements android.view.View.OnClickListener, TextWatcher, android.widget.TextView.OnEditorActionListener, co.vine.android.widget.TypefacesEditText.KeyboardListener
{
    private class ConversationSessionListener extends AppSessionListener
    {

        final ConversationFragment this$0;

        public void onGetConversationComplete(String s, int i, String s1, long l, int j, boolean flag)
        {
            if (removeRequest(s) != null && l == mConversationRowId)
            {
                hideProgress(3);
                if (flag)
                {
                    showSadface(true, false);
                } else
                {
                    showSadface(false);
                }
                s = (ConversationAdapter)mCursorAdapter;
                if (mFetched && (s.atLastPage() || flag || s.isEmpty()))
                {
                    mLoadMoreHeaderContent.setVisibility(8);
                }
                if (j == 4)
                {
                    mLoadMoreHeaderContent.setVisibility(0);
                }
            }
        }

        public void onGetConversationRemoteIdComplete(long l)
        {
            mConversationId = l;
            if (l <= 0L)
            {
                mLoadMoreHeaderContent.setVisibility(8);
            }
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            ((ConversationAdapter)mCursorAdapter).setImages(hashmap);
        }

        public void onVideoPathObtained(HashMap hashmap)
        {
            ((ConversationAdapter)mCursorAdapter).onVideoPathObtained(hashmap);
        }

        private ConversationSessionListener()
        {
            this$0 = ConversationFragment.this;
            super();
        }

    }

    private class HeightAnimation extends Animation
    {

        private View mView;
        final ConversationFragment this$0;

        protected void applyTransformation(float f, Transformation transformation)
        {
            int i = getResources().getDimensionPixelSize(0x7f0b001e);
            mView.getLayoutParams().height = (int)((float)i * (1.0F - f));
            mView.requestLayout();
        }

        public boolean willChangeBounds()
        {
            return true;
        }

        public HeightAnimation(View view, Runnable runnable)
        {
            this.this$0 = ConversationFragment.this;
            super();
            setFillAfter(true);
            setDuration(300L);
            mView = view;
            setAnimationListener(runnable. new _cls1());
        }
    }

    private class UploadProgressHandler extends Handler
    {

        final ConversationFragment this$0;

        public void handleMessage(Message message)
        {
            int i = message.what;
            if (message.obj == null)
            {
                message = new Bundle();
            } else
            {
                message = (Bundle)message.obj;
            }
            SLog.dWithTag("ConversationFrag", (new StringBuilder()).append("Message received, what=").append(i).toString());
            i;
            JVM INSTR tableswitch 3 7: default 84
        //                       3 96
        //                       4 233
        //                       5 241
        //                       6 321
        //                       7 405;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            return;
_L2:
            boolean flag = message.getBoolean("is_active");
            long l = message.getLong("conversation_row_id");
            message = message.getString("thumbnail");
            SLog.dWithTag("ConversationFrag", (new StringBuilder()).append("Result receiver was set in VineUploadService, conversationId=").append(l).toString());
            if (flag && mConversationRowId == l)
            {
                mUploadProgressContainer.setVisibility(0);
                mProgressView = (ProgressView)mUploadProgressContainer.findViewById(0x7f0a00c6);
                if (!TextUtils.isEmpty(message))
                {
                    message = BitmapFactory.decodeFile(message);
                    mUploadThumbnail.setImageBitmap(message);
                    return;
                } else
                {
                    mUploadThumbnail.setVisibility(8);
                    return;
                }
            }
              goto _L1
_L3:
            SLog.dWithTag("ConversationFrag", "Video transcoding started");
            return;
_L4:
            double d = message.getDouble("transcode_progress");
            SLog.dWithTag("ConversationFrag", (new StringBuilder()).append("Transcode progress changed to p=").append(d).toString());
            if (mProgressViewWidth == 0)
            {
                mProgressViewWidth = mProgressView.getMeasuredWidth();
            }
            mProgressView.setProgressRatio((float)((0.65000000000000002D * d) / 100D));
            return;
_L5:
            double d1 = message.getDouble("upload_progress");
            SLog.dWithTag("ConversationFrag", (new StringBuilder()).append("Upload progress changed to p=").append(d1).toString());
            if (mProgressViewWidth == 0)
            {
                mProgressViewWidth = mProgressView.getMeasuredWidth();
            }
            mProgressView.setProgressRatio((float)(0.65000000000000002D + (0.33000000000000002D * d1) / 100D));
            return;
_L6:
            boolean flag1 = message.getBoolean("success");
            SLog.dWithTag("ConversationFrag", (new StringBuilder()).append("Post completed, success=").append(flag1).toString());
            mUploadProgressContainer.setVisibility(8);
            sendMessage(Message.obtain(null, 2));
            return;
        }

        private UploadProgressHandler()
        {
            this$0 = ConversationFragment.this;
            super();
        }

    }


    public static final String ARG_AM_FOLLOWING = "am_following_recipient";
    public static final String ARG_CONVERSATION_ROW_ID = "conversation_row_id";
    public static final String ARG_ENCODER_VERSION = "arg_encoder_version";
    private static final long COLLAPSE_DURATION_MS = 300L;
    private static final int MAX_CHARS = 420;
    public static final int REQUEST_POST_OPTIONS = 2;
    public static final int REQUEST_RECORD_REPLY = 1991;
    private static final int SCROLL_TO_BOTTOM_MESSAGE_COUNT_THRESHOLD = 1;
    private static final String STATE_FETCHED = "fetched";
    private static final String TAG = "ConversationFrag";
    private boolean mAmFollowing;
    private boolean mBound;
    private ConversationActivity mCallback;
    private ViewGroup mChatPresenceContainer;
    private ImageView mChatPresenceEllipsis;
    private ViewGroup mChatPresenceFooter;
    private LongSparseArray mColorMap;
    private View mComposeContainer;
    private ServiceConnection mConnection;
    private ContentResolver mContentResolver;
    private ConversationAdapter mConversationAdapter;
    private long mConversationId;
    private long mConversationRowId;
    private TypefacesEditText mEdit;
    private boolean mFetchWasInitial;
    private boolean mFetchWasLoadMore;
    private boolean mFetched;
    private Intent mFullRecordIntent;
    private Handler mIncomingHandler;
    private boolean mIsSending;
    private long mLastTopItemId;
    private int mLastTopItemPixelOffset;
    private final Runnable mLaunchFullRecordRunnable = new Runnable() {

        final ConversationFragment this$0;

        public void run()
        {
            Util.startActionOnRecordingAvailable(getActivity(), mFullRecordIntent, 1991);
        }

            
            {
                this$0 = ConversationFragment.this;
                super();
            }
    };
    private final android.view.View.OnClickListener mLaunchRecorderListener = new android.view.View.OnClickListener() {

        final ConversationFragment this$0;

        public void onClick(View view)
        {
            launchFullRecord();
        }

            
            {
                this$0 = ConversationFragment.this;
                super();
            }
    };
    private View mLoadMoreHeaderContent;
    private View mLoadMoreProgress;
    private int mLocalUnreadCount;
    private final BroadcastReceiver mMuteChangeReceiver = new BroadcastReceiver() {

        final ConversationFragment this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (intent == null || intent.getAction() == null)
            {
                CrashUtil.log("Something wrong has happened");
                return;
            } else
            {
                boolean flag = intent.getAction().equals(MuteUtil.ACTION_CHANGED_TO_MUTE);
                ((ConversationAdapter)mCursorAdapter).toggleMute(flag);
                return;
            }
        }

            
            {
                this$0 = ConversationFragment.this;
                super();
            }
    };
    private int mMyColor;
    private long mMyUserRowId;
    private View mNewMessageBarContainer;
    private TextView mNewMessageBarText;
    private ProgressView mProgressView;
    private int mProgressViewWidth;
    private int mRecipientColor;
    private String mRecipientUsername;
    private ImageView mRecordButton;
    private InlineRecorderManager mRecorderManager;
    private boolean mRecordingEnabled;
    private ImageView mSendButton;
    private RelativeLayout mTextInputContainer;
    private View mTextInputToggle;
    private ViewGroup mUploadProgressContainer;
    private Messenger mUploadServiceMessenger;
    private ImageView mUploadThumbnail;
    private RecordSessionVersion mVersion;

    public ConversationFragment()
    {
        mFetched = false;
        mFetchWasLoadMore = false;
        mProgressViewWidth = 0;
        mMyColor = 0;
        mRecipientColor = 0;
        mFetchWasInitial = false;
    }

    private void fetchContent(int i)
    {
        if (mConversationRowId <= 0L || hasPendingRequest()) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 1 3: default 44
    //                   1 76
    //                   2 44
    //                   3 45;
           goto _L2 _L3 _L2 _L4
_L2:
        return;
_L4:
        mFetched = true;
        showProgress(3);
        addRequest(mAppController.fetchConversation(1, false, 0L, mConversationRowId, false));
        return;
_L3:
        mFetchWasLoadMore = true;
        showProgress(1);
        addRequest(mAppController.fetchConversation(3, true, 0L, mConversationRowId, false));
        return;
    }

    private Bundle getMessageBundle()
    {
        Bundle bundle = new Bundle();
        bundle.putLong("conversation_row_id", mConversationRowId);
        return bundle;
    }

    private void hideTypingContainer()
    {
        mEdit.clearFocus();
        if (mLocalUnreadCount > 0)
        {
            toggleNewMessageBar(true);
        }
        mTextInputContainer.setVisibility(8);
        ViewUtil.setBackground(mComposeContainer, new ColorDrawable(getMyColor()));
        mRecordButton.setVisibility(0);
        mTextInputToggle.setVisibility(0);
    }

    private void saveTopItemInfo()
    {
        if (mCursorAdapter.getCount() != 0)
        {
            mLastTopItemId = mCursorAdapter.getItemId(mListView.getFirstVisiblePosition());
            View view = mListView.getChildAt(mListView.getFirstVisiblePosition() + mListView.getHeaderViewsCount());
            if (view != null)
            {
                mLastTopItemPixelOffset = view.getTop();
                return;
            }
        }
    }

    private void scrollToBottom(boolean flag, final boolean smooth)
    {
        final ListView listView = mListView;
        final int count = mCursorAdapter.getCount() + listView.getHeaderViewsCount();
        if (!flag || count - listView.getLastVisiblePosition() < 2)
        {
            listView.post(new Runnable() {

                final ConversationFragment this$0;
                final int val$count;
                final ListView val$listView;
                final boolean val$smooth;

                public void run()
                {
                    if (smooth)
                    {
                        listView.smoothScrollToPosition(count - 1);
                        return;
                    } else
                    {
                        listView.setSelectionFromTop(count - 1, 0);
                        return;
                    }
                }

            
            {
                this$0 = ConversationFragment.this;
                smooth = flag;
                listView = listview;
                count = i;
                super();
            }
            });
        }
    }

    private void sendMessage(String s)
    {
        s = VineUploadService.getVMPostIntent(getActivity(), s, false, mConversationRowId, VineProviderHelper.getConversationRecipients(mContentResolver, mConversationRowId), null, 0);
        SLog.d("intent={}, extras={}", s, s.getExtras());
        getActivity().startService(s);
        mIncomingHandler = new UploadProgressHandler();
        subscribe(mIncomingHandler);
    }

    private void sendMessageToUploadService(Message message)
    {
        try
        {
            if (mUploadServiceMessenger != null)
            {
                mUploadServiceMessenger.send(message);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            message.printStackTrace();
        }
    }

    private void sendTextMessage()
    {
        TypefacesEditText typefacesedittext = mEdit;
        if (typefacesedittext.getText().length() > 420)
        {
            Util.showTopToast(getActivity(), 0x7f0e013c);
            return;
        }
        if (validate(mEdit))
        {
            Object obj = typefacesedittext.getText().toString();
            obj = VineUploadService.getVMPostIntent(getActivity(), null, false, mConversationRowId, VineProviderHelper.getConversationRecipients(mContentResolver, mConversationRowId), ((String) (obj)), 0);
            getActivity().startService(((Intent) (obj)));
            mIsSending = true;
            typefacesedittext.getText().clear();
            mIsSending = false;
            return;
        } else
        {
            Util.setSoftKeyboardVisibility(getActivity(), mEdit, false);
            hideTypingContainer();
            return;
        }
    }

    private void subscribe(Handler handler)
    {
        handler = new Messenger(handler);
        Message message = Message.obtain(null, 1);
        message.replyTo = handler;
        sendMessageToUploadService(message);
    }

    private void toggleInput()
    {
        FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null)
        {
            TypefacesEditText typefacesedittext = mEdit;
            typefacesedittext.requestFocus();
            Util.setSoftKeyboardVisibility(fragmentactivity, typefacesedittext, true);
            mTextInputContainer.setVisibility(0);
            ViewUtil.setBackground(mComposeContainer.findViewById(0x7f0a0097), new ColorDrawable(fragmentactivity.getResources().getColor(0x7f090083)));
            mRecordButton.setVisibility(8);
            mTextInputToggle.setVisibility(8);
        }
    }

    private void toggleNewMessageBar(boolean flag)
    {
        View view = mNewMessageBarContainer;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    private boolean validate(EditText edittext)
    {
        return edittext != null && edittext.length() > 0;
    }

    public void afterTextChanged(Editable editable)
    {
        if (!TextUtils.isEmpty(editable))
        {
            mCallback.onTypingStatusChanged(true, mIsSending);
            return;
        } else
        {
            mCallback.onTypingStatusChanged(false, mIsSending);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public int getMyColor()
    {
        return mMyColor;
    }

    public void hideProgress(int i)
    {
        mLoadMoreProgress.setVisibility(8);
    }

    public boolean isInTextInputMode()
    {
        return mRecordButton.getVisibility() == 8;
    }

    void launchFullRecord()
    {
        mFullRecordIntent = AbstractRecordingActivity.getIntentForConversation(getActivity(), 0, "ConversationFullRecord", mConversationRowId, false, mRecipientUsername, mAmFollowing);
        mIncomingHandler = new UploadProgressHandler();
        subscribe(mIncomingHandler);
        mHandler.post(mLaunchFullRecordRunnable);
    }

    public void onActivityCreated(Bundle bundle)
    {
label0:
        {
            super.onActivityCreated(bundle);
            bundle = (ConversationActivity)getActivity();
            SharedPreferences sharedpreferences = Util.getDefaultSharedPrefs(bundle);
            mRecordingEnabled = Util.isCapableOfRecording(bundle);
            Object obj;
            ViewGroup viewgroup;
            int i;
            int j;
            if (mRecordingEnabled)
            {
                try
                {
                    mVersion.getManager(bundle);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    mRecordingEnabled = false;
                    if (obj instanceof co.vine.android.recorder.RecordSessionManager.NotEnoughSpaceException)
                    {
                        Util.showCenteredToast(bundle, 0x7f0e00dc);
                    } else
                    {
                        Util.showCenteredToast(bundle, 0x7f0e00dd);
                    }
                    CrashUtil.log("Exception has happened: {}", new Object[] {
                        obj
                    });
                }
            }
            mMyUserRowId = sharedpreferences.getLong("pref_user_row_id", 0L);
            if (mCursorAdapter == null)
            {
                mConversationAdapter = new ConversationAdapter(bundle, mAppController, mListView, mMyUserRowId, 0);
                mCursorAdapter = mConversationAdapter;
            }
            obj = mListView;
            ((ListView) (obj)).setOnScrollListener(this);
            ((ListView) (obj)).setDivider(null);
            ((ConversationList)obj).deactivateRefresh(true);
            mAppSessionListener = new ConversationSessionListener();
            viewgroup = (ViewGroup)LayoutInflater.from(bundle).inflate(0x7f03002e, null);
            mLoadMoreHeaderContent = viewgroup.findViewById(0x7f0a00b0);
            mLoadMoreHeaderContent.setVisibility(8);
            mLoadMoreProgress = viewgroup.findViewById(0x7f0a00b2);
            ((ListView) (obj)).addHeaderView(viewgroup);
            mLoadMoreHeaderContent.setOnClickListener(this);
            mLoadMoreHeaderContent.setVisibility(0);
            ((ListView) (obj)).setAdapter(mCursorAdapter);
            obj = (ViewGroup)LayoutInflater.from(bundle).inflate(0x7f030031, mListView, false);
            mUploadProgressContainer = (ViewGroup)((ViewGroup) (obj)).findViewById(0x7f0a00c5);
            mProgressView = (ProgressView)((ViewGroup) (obj)).findViewById(0x7f0a00c6);
            mUploadThumbnail = (ImageView)((ViewGroup) (obj)).findViewById(0x7f0a0065);
            obj = (ViewGroup)LayoutInflater.from(bundle).inflate(0x7f03002b, mListView, false);
            mChatPresenceContainer = (ViewGroup)((ViewGroup) (obj)).findViewById(0x7f0a00ad);
            mChatPresenceEllipsis = (ImageView)((ViewGroup) (obj)).findViewById(0x7f0a00ae);
            mChatPresenceFooter = ((ViewGroup) (obj));
            mListView.addFooterView(mChatPresenceFooter);
            obj = getView();
            if (mRecordingEnabled)
            {
                mRecorderManager = (InlineRecorderManager)((View) (obj)).findViewById(0x7f0a009d);
                mRecorderManager.init(this, bundle, mVersion);
            } else
            {
                ((InlineRecorderManager)((View) (obj)).findViewById(0x7f0a009d)).initDisabled(this);
            }
            bundle.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(mRecipientColor));
            mComposeContainer = ((View) (obj)).findViewById(0x7f0a0097);
            j = sharedpreferences.getInt("profile_background", Settings.DEFAULT_PROFILE_COLOR);
            if (j != Settings.DEFAULT_PROFILE_COLOR)
            {
                i = j;
                if (j > 0)
                {
                    break label0;
                }
            }
            i = 0xffffff & getResources().getColor(0x7f090096);
        }
        mMyColor = 0xff000000 | i;
        ((ProgressView)getView().findViewById(0x7f0a00a1)).setColor(mMyColor);
        ((ProgressView)getView().findViewById(0x7f0a00a7)).setColor(mMyColor);
        ViewUtil.setBackground(mComposeContainer, new ColorDrawable(getMyColor()));
        ((GradientDrawable)bundle.getResources().getDrawable(0x7f0200f5)).setColor(0xff000000 | mMyColor);
        mNewMessageBarContainer.setBackgroundDrawable(new ColorDrawable(mRecipientColor));
        mSendButton.setOnClickListener(mLaunchRecorderListener);
        mSendButton.setColorFilter(new PorterDuffColorFilter(getMyColor(), android.graphics.PorterDuff.Mode.SRC_IN));
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i != 2) goto _L2; else goto _L1
_L1:
        processPostOptionsResult(PostOptionsDialogActivity.onActivityResult(mAppController, getActivity(), j, intent));
_L4:
        return;
_L2:
        if (i != 1991 || intent == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        SLog.dWithTag("ConversationFrag", (new StringBuilder()).append("resultCode=").append(j).append(", data=").append(intent).toString());
        if (BuildUtil.isIsHwEncodingEnabled()) goto _L4; else goto _L3
_L3:
        sendMessage(intent.getStringExtra("upload_path"));
        return;
        if (j != 100) goto _L4; else goto _L5
_L5:
        sendMessageToUploadService(Message.obtain(null, 2));
        return;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mCallback = (ConversationActivity)activity;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361947: 
            sendTextMessage();
            return;

        case 2131361944: 
            toggleInput();
            return;

        case 2131361968: 
            mLoadMoreHeaderContent.setVisibility(8);
            mLoadMoreProgress.setVisibility(0);
            fetchContent(1);
            return;

        case 2131361963: 
            scrollToBottom(false, false);
            toggleNewMessageBar(false);
            mLocalUnreadCount = 0;
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        long l;
label0:
        {
            super.onCreate(bundle);
            if (bundle != null && bundle.containsKey("fetched"))
            {
                mFetched = bundle.getBoolean("fetched");
            }
            bundle = ((BaseActionBarActivity)getActivity()).getSlidingMenu();
            if (bundle != null)
            {
                bundle.setTouchModeAbove(0);
            }
            bundle = getArguments();
            mConversationRowId = bundle.getLong("conversation_row_id", -1L);
            mAmFollowing = bundle.getBoolean("am_following_recipient");
            setHasOptionsMenu(true);
            mVersion = (RecordSessionVersion)bundle.getSerializable("arg_encoder_version");
            if (mVersion == null)
            {
                mVersion = RecordSessionManager.getCurrentVersion(getActivity());
            }
            mIncomingHandler = new UploadProgressHandler();
            mBound = false;
            mConnection = new ServiceConnection() {

                final ConversationFragment this$0;

                public void onServiceConnected(ComponentName componentname, IBinder ibinder)
                {
                    SLog.dWithTag("ConversationFrag", "Bound to VineUploadService");
                    mUploadServiceMessenger = new Messenger(ibinder);
                    mBound = true;
                    subscribe(mIncomingHandler);
                }

                public void onServiceDisconnected(ComponentName componentname)
                {
                    SLog.dWithTag("ConversationFrag", "Connection to VineUploadService lost unexpectedly!");
                    mUploadServiceMessenger = null;
                    mBound = false;
                }

            
            {
                this$0 = ConversationFragment.this;
                super();
            }
            };
            if (mColorMap == null)
            {
                mColorMap = new LongSparseArray();
            }
            l = System.currentTimeMillis();
            mContentResolver = getActivity().getContentResolver();
            bundle = VineProviderHelper.queryConversationRecipientsUsersView(mContentResolver, mConversationRowId);
            if (bundle == null)
            {
                break label0;
            }
            while (bundle.moveToNext()) 
            {
                int i;
                long l1;
label1:
                {
                    l1 = bundle.getLong(6);
                    int j = bundle.getInt(7);
                    if (j != Settings.DEFAULT_PROFILE_COLOR)
                    {
                        i = j;
                        if (j > 0)
                        {
                            break label1;
                        }
                    }
                    i = 0xffffff & getResources().getColor(0x7f090096);
                }
                i |= 0xff000000;
                if (mRecipientColor == 0)
                {
                    mRecipientColor = i;
                }
                mColorMap.put(l1, Integer.valueOf(i));
                mRecipientUsername = bundle.getString(3);
            }
            bundle.close();
        }
        ((ConversationActivity)getActivity()).setRecipientUsername(mRecipientUsername);
        SLog.d("onCreate queries took {}ms.", Long.valueOf(System.currentTimeMillis() - l));
        mLocalUnreadCount = 0;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        long l = mConversationRowId;
        bundle = co.vine.android.provider.Vine.ConversationMessageUsersView.CONTENT_URI_CONVERSATION.buildUpon().appendQueryParameter("conversation_row_id", String.valueOf(l)).build();
        return new CursorLoader(getActivity(), bundle, co.vine.android.provider.VineDatabaseSQL.ConversationMessageUsersQuery.PROJECTION, null, null, "message_id ASC");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = createView(layoutinflater, 0x7f03002a, viewgroup);
        viewgroup = (TypefacesEditText)layoutinflater.findViewById(0x7f0a0083);
        viewgroup.setOnEditorActionListener(this);
        viewgroup.addTextChangedListener(this);
        viewgroup.setKeyboardListener(this);
        mEdit = viewgroup;
        mTextInputContainer = (RelativeLayout)layoutinflater.findViewById(0x7f0a0099);
        mTextInputToggle = layoutinflater.findViewById(0x7f0a0098);
        mTextInputToggle.setOnClickListener(this);
        mNewMessageBarContainer = layoutinflater.findViewById(0x7f0a00ab);
        mNewMessageBarContainer.setOnClickListener(this);
        mNewMessageBarText = (TextView)mNewMessageBarContainer.findViewById(0x7f0a00ac);
        mRecordButton = (ImageView)layoutinflater.findViewById(0x7f0a00aa);
        mSendButton = (ImageView)layoutinflater.findViewById(0x7f0a009b);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mRecorderManager != null)
        {
            mRecorderManager.release();
        }
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        switch (textview.getId())
        {
        default:
            return false;

        case 2131361923: 
            break;
        }
        if (i == 4)
        {
            sendTextMessage();
        }
        return true;
    }

    public void onKeyboardDismissed()
    {
        mCallback.onTypingStatusChanged(false, mIsSending);
        hideTypingContainer();
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        loader.getId();
        JVM INSTR tableswitch 0 0: default 24
    //                   0 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        saveTopItemInfo();
        super.onLoadFinished(loader, cursor);
        hideProgress(3);
        if (!mFetched)
        {
            fetchContent(3);
            mFetchWasInitial = true;
            return;
        }
        if (!mCursorAdapter.isEmpty()) goto _L4; else goto _L3
_L3:
        showSadface(true, false);
_L5:
        mFetchWasInitial = false;
        if (((ConversationAdapter)mCursorAdapter).atLastPage())
        {
            mLoadMoreHeaderContent.setVisibility(8);
        } else
        {
            mLoadMoreHeaderContent.setVisibility(0);
        }
        if (!mCursorAdapter.isEmpty())
        {
            ((ConversationAdapter)mCursorAdapter).playCurrentPosition();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        showSadface(false);
        if (mFetchWasLoadMore)
        {
            mFetchWasLoadMore = false;
            mLoadMoreHeaderContent.setVisibility(0);
            hideProgress(3);
            mListView.setSelectionFromTop(((ConversationAdapter)mCursorAdapter).getPositionForId(mLastTopItemId) + mListView.getHeaderViewsCount(), mLastTopItemPixelOffset);
        } else
        if (mFetchWasInitial)
        {
            scrollToBottom(false, false);
        } else
        if (mListView.getLastVisiblePosition() >= cursor.getCount() - 1)
        {
            scrollToBottom(false, true);
        }
          goto _L5
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onNewMessage()
    {
        if (mListView.getLastVisiblePosition() < mCursorAdapter.getCount() && mTextInputContainer.getVisibility() != 0)
        {
            mLocalUnreadCount = mLocalUnreadCount + 1;
            mNewMessageBarText.setText(getResources().getQuantityString(0x7f0d0000, mLocalUnreadCount, new Object[] {
                Integer.valueOf(mLocalUnreadCount)
            }));
            toggleNewMessageBar(true);
        }
    }

    public void onPause()
    {
        super.onPause();
        mConversationAdapter.onPause();
        getActivity().unregisterReceiver(mMuteChangeReceiver);
        if (mBound)
        {
            SLog.dWithTag("ConversationFrag", "Will unbind from VineUploadService now");
            sendMessageToUploadService(Message.obtain(null, 2));
            getActivity().unbindService(mConnection);
            mBound = false;
        }
        if (mRecorderManager != null)
        {
            mRecorderManager.onPaused();
        }
    }

    public void onRecorderHidden()
    {
        mTextInputToggle.setVisibility(0);
        ((ConversationAdapter)mCursorAdapter).playCurrentPosition();
    }

    public void onRecorderShown()
    {
        mTextInputToggle.setVisibility(8);
        ((ConversationAdapter)mCursorAdapter).stopCurrentPlayer();
    }

    public void onResume()
    {
        super.onResume();
        ((GradientDrawable)getResources().getDrawable(0x7f0200f5)).setColor(0xff000000 | mMyColor);
        ConversationActivity conversationactivity = (ConversationActivity)getActivity();
        if (conversationactivity.keyBoardUpOnStart)
        {
            conversationactivity.keyBoardUpOnStart = false;
            mHandler.post(new Runnable() {

                final ConversationFragment this$0;

                public void run()
                {
                    toggleInput();
                }

            
            {
                this$0 = ConversationFragment.this;
                super();
            }
            });
        }
        mConversationAdapter.onResume();
        conversationactivity.registerReceiver(mMuteChangeReceiver, MuteUtil.MUTE_INTENT_FILTER, "co.vine.android.BROADCAST", null);
        if (mCursorAdapter.getCursor() == null)
        {
            initLoader();
        }
        if (!mBound)
        {
            SLog.dWithTag("ConversationFrag", "Will bind to VineUploadService now");
            conversationactivity.bindService(new Intent(conversationactivity, co/vine/android/service/VineUploadService), mConnection, 1);
        }
        mUploadProgressContainer.setVisibility(8);
        mChatPresenceContainer.setVisibility(8);
        if (mRecorderManager == null)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        mRecorderManager.onResume();
        return;
        IOException ioexception;
        ioexception;
        mRecordingEnabled = false;
        CrashUtil.log("Failed to create folder.");
        Util.showCenteredToast(getActivity(), 0x7f0e00dd);
        return;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("fetched", mFetched);
    }

    protected void onScrollLastItem(Cursor cursor)
    {
        mLocalUnreadCount = 0;
        toggleNewMessageBar(false);
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        super.onScrollStateChanged(abslistview, i);
        if (mCursorAdapter != null && i == 0)
        {
            ((ConversationAdapter)mCursorAdapter).playCurrentPosition();
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (mEdit.getText().length() == 0)
        {
            mSendButton.setImageResource(0x7f020204);
            mSendButton.setOnClickListener(mLaunchRecorderListener);
            return;
        } else
        {
            mSendButton.setImageResource(0x7f020137);
            mSendButton.setOnClickListener(this);
            return;
        }
    }

    protected void prepareUpload()
    {
        InlineVineRecorder inlinevinerecorder;
        inlinevinerecorder = mRecorderManager.getRecorder();
        if (inlinevinerecorder == null || inlinevinerecorder.finalFile == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        sendMessage(UploadManager.addToUploadQueue(getActivity(), inlinevinerecorder.finalFile, inlinevinerecorder.finalFile.getThumbnailPath(), inlinevinerecorder.finalFile.folder.getName(), true, mConversationRowId));
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
        return;
    }

    public boolean sendKeyEvent(KeyEvent keyevent)
    {
        return false;
    }

    public void showProgress(int i)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            mLoadMoreHeaderContent.setVisibility(8);
            break;
        }
        mLoadMoreProgress.setVisibility(0);
    }

    public void showTypingIndicator(boolean flag, long l)
    {
        final ViewGroup container = mChatPresenceContainer;
        container.clearAnimation();
        if (flag)
        {
            ImageView imageview = mChatPresenceEllipsis;
            ((ConversationAdapter)mCursorAdapter).getIdAtLastPosition();
            Integer integer = null;
            if (mColorMap != null)
            {
                integer = (Integer)mColorMap.get(l);
            }
            Integer integer1 = integer;
            if (integer == null)
            {
                integer1 = Integer.valueOf(mRecipientColor);
            }
            container.setVisibility(0);
            container.getLayoutParams().height = getResources().getDimensionPixelSize(0x7f0b001e);
            imageview.setColorFilter(0x5a000000 | integer1.intValue() & 0xffffff);
            scrollToBottom(true, false);
            return;
        } else
        {
            container.startAnimation(new HeightAnimation(container, new Runnable() {

                final ConversationFragment this$0;
                final ViewGroup val$container;

                public void run()
                {
                    container.setVisibility(8);
                }

            
            {
                this$0 = ConversationFragment.this;
                container = viewgroup;
                super();
            }
            }));
            return;
        }
    }

    public void startPostOptionsActivity(Intent intent)
    {
        startActivityForResult(intent, 2);
    }



/*
    static Messenger access$102(ConversationFragment conversationfragment, Messenger messenger)
    {
        conversationfragment.mUploadServiceMessenger = messenger;
        return messenger;
    }

*/



/*
    static int access$1102(ConversationFragment conversationfragment, int i)
    {
        conversationfragment.mProgressViewWidth = i;
        return i;
    }

*/





/*
    static long access$1502(ConversationFragment conversationfragment, long l)
    {
        conversationfragment.mConversationId = l;
        return l;
    }

*/


/*
    static boolean access$202(ConversationFragment conversationfragment, boolean flag)
    {
        conversationfragment.mBound = flag;
        return flag;
    }

*/








/*
    static ProgressView access$902(ConversationFragment conversationfragment, ProgressView progressview)
    {
        conversationfragment.mProgressView = progressview;
        return progressview;
    }

*/

    // Unreferenced inner class co/vine/android/ConversationFragment$HeightAnimation$1

/* anonymous class */
    class HeightAnimation._cls1
        implements android.view.animation.Animation.AnimationListener
    {

        final HeightAnimation this$1;
        final Runnable val$onAnimationEnd;
        final ConversationFragment val$this$0;

        public void onAnimationEnd(Animation animation)
        {
            onAnimationEnd.run();
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

            
            {
                this$1 = final_heightanimation;
                this$0 = conversationfragment;
                onAnimationEnd = Runnable.this;
                super();
            }
    }

}
