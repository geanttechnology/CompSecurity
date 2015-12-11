// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import co.vine.android.api.VineParsers;
import co.vine.android.api.VineRTCConversation;
import co.vine.android.api.VineRTCParticipant;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.client.VineAPI;
import co.vine.android.recorder.RecordSessionManager;
import co.vine.android.recorder.RecordSessionVersion;
import co.vine.android.recorder.RecordingActivityHelper;
import co.vine.android.service.GCMNotificationService;
import co.vine.android.service.ResourceService;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.IntentionalObjectCounter;
import co.vine.android.util.MuteUtil;
import co.vine.android.util.Util;
import co.vine.android.widgets.PromptDialogFragment;
import com.codebutler.android_websockets.WebSocketClient;
import com.edisonwang.android.slog.SLog;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, VineWebSocketClient, ConversationActivityMain, ConversationFragment, 
//            VineLoggingException, ProfileActivity, ConfirmationFlowActivity

public class ConversationActivity extends BaseControllerActionBarActivity
    implements co.vine.android.widgets.PromptDialogFragment.OnDialogDoneListener
{
    private class ConversationSessionListener extends AppSessionListener
    {

        final ConversationActivity this$0;

        private void showTypingIndicator(final boolean show, long l)
        {
            runOnUiThread(l. new Runnable() {

                final ConversationSessionListener this$1;
                final boolean val$show;
                final long val$userId;

                public void run()
                {
                    Fragment fragment = getSupportFragmentManager().findFragmentByTag("conversationFragment");
                    if (fragment instanceof ConversationFragment)
                    {
                        ((ConversationFragment)fragment).showTypingIndicator(show, userId);
                    }
                }

            
            {
                this$1 = final_conversationsessionlistener;
                show = flag;
                userId = J.this;
                super();
            }
            });
        }

        public void onFollowComplete(String s, int i, String s1, long l)
        {
            if (i == 200 && mDirectUserId == l && mMenu != null)
            {
                mMenu.removeItem(0x7f0a0241);
            }
        }

        public void onGetConversationRemoteIdComplete(long l)
        {
            mConversationId = l;
            if (clientIsActive())
            {
                SLog.dWithTag("ConvActivity;RTC", (new StringBuilder()).append("Subscribing to conversation=").append(mConversationId).toString());
                mClient.subscribeConversation(mConversationId);
            }
        }

        public void onReceiveRTCMessage(ArrayList arraylist)
        {
            for (arraylist = arraylist.iterator(); arraylist.hasNext();)
            {
                Object obj = (VineRTCConversation)arraylist.next();
                if (((VineRTCConversation) (obj)).conversationId == mConversationId)
                {
                    obj = ((VineRTCConversation) (obj)).participants.iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        VineRTCParticipant vinertcparticipant = (VineRTCParticipant)((Iterator) (obj)).next();
                        long l = vinertcparticipant.userId;
                        if (vinertcparticipant.isTyping)
                        {
                            showTypingIndicator(true, l);
                        } else
                        {
                            showTypingIndicator(false, l);
                        }
                        l = vinertcparticipant.lastMessageId;
                        if (l > 0L)
                        {
                            if (l > mLastMessageId)
                            {
                                mAppController.fetchConversation(1, false, 0L, mConversationRowId, false);
                                Fragment fragment = getSupportFragmentManager().findFragmentByTag("conversationFragment");
                                if (fragment instanceof ConversationFragment)
                                {
                                    ((ConversationFragment)fragment).onNewMessage();
                                }
                            }
                            mLastMessageId = l;
                        }
                    }
                }
            }

        }

        public void onWebSocketConnectComplete()
        {
            if (mConversationId > 0L)
            {
                SLog.dWithTag("ConvActivity;RTC", (new StringBuilder()).append("Subscribing to conversation=").append(mConversationId).toString());
                mClient.subscribeConversation(mConversationId);
            }
        }

        public void onWebSocketDisconnected()
        {
            showTypingIndicator(false, -1L);
            reconnectWithBackoff();
        }

        private ConversationSessionListener()
        {
            this$0 = ConversationActivity.this;
            super();
        }

    }

    private class RealTimeChatReceiver extends BroadcastReceiver
    {

        final ConversationActivity this$0;

        public void onReceive(Context context, Intent intent)
        {
            if ("co.vine.android.service.mergeSelfNewMessage".equals(intent.getAction()))
            {
                long l = intent.getLongExtra("message_id", 0L);
                long l1 = intent.getLongExtra("conversation_id", 0L);
                if (l > 0L && l1 > 0L && mClient != null)
                {
                    mClient.alertNewPrivateMessage(l1, l);
                }
            }
        }

        private RealTimeChatReceiver()
        {
            this$0 = ConversationActivity.this;
            super();
        }

    }


    private static final int DIALOG_DELETE = 0;
    private static final int DIALOG_DELETE_MESSAGE = 2;
    private static final int DIALOG_IGNORE = 1;
    private static final String EVENT_SOURCE_TITLE = co/vine/android/ConversationActivity.getName();
    public static final String EXTRA_AM_FOLLOWING_RECIPIENT = "am_following_recipient";
    public static final String EXTRA_CONVERSATION_ROW_ID = "conversation_row_id";
    public static final String EXTRA_KEYBOARD_UP = "keyboard_up";
    public static final String EXTRA_RECIPIENT_USERNAME = "recipient_username";
    private static final String EXTRA_USER_ID = "user_id";
    private static final String FRAGMENT_TAG = "conversationFragment";
    private static final long INITIAL_RETRY_DELAY = 1000L;
    private static final long INVALID_ID = -1L;
    private static final int MAX_RETRY_DELAY = 16000;
    public static final int REQUEST_CONFIRMATION = 101;
    private static final String TAG = "ConvActivity;RTC";
    public boolean keyBoardUpOnStart;
    private boolean mAmFollowingRecipient;
    private RealTimeChatReceiver mChatReceiver;
    private VineWebSocketClient mClient;
    private BroadcastReceiver mConnectivityReceiver;
    private long mConversationId;
    private long mConversationRowId;
    private long mDirectUserId;
    private RecordingActivityHelper mHelper;
    private final IntentionalObjectCounter mIntentionalObjectCounter = new IntentionalObjectCounter("recorder", this);
    private boolean mLastIsConnected;
    private long mLastMessageId;
    private boolean mLastTyping;
    private Handler mMainHandler;
    private long mMessageIdToDelete;
    private SharedPreferences mPref;
    private String mRecipientUserName;
    private long mReconnectDelay;
    private final Runnable mReconnectRunnable = new Runnable() {

        final ConversationActivity this$0;

        public void run()
        {
            if (mClient == null)
            {
                prepareClient();
            }
            Object obj = mClient;
            if (obj != null && !((VineWebSocketClient) (obj)).isConnecting() && !((VineWebSocketClient) (obj)).isConnected())
            {
                ((VineWebSocketClient) (obj)).connect();
                obj = ConversationActivity.this;
                long l;
                if (mReconnectDelay < 16000L)
                {
                    l = mReconnectDelay * 2L;
                } else
                {
                    l = mReconnectDelay;
                }
                obj.mReconnectDelay = l;
                mMainHandler.postDelayed(mReconnectRunnable, mReconnectDelay);
                SLog.dWithTag("ConvActivity;RTC", (new StringBuilder()).append("Posted reconnect with delay=").append(mReconnectDelay).append("ms").toString());
            }
        }

            
            {
                this$0 = ConversationActivity.this;
                super();
            }
    };
    private Runnable mRetrySuccessRunnable;
    private RecordSessionVersion mVersion;
    private com.codebutler.android_websockets.WebSocketClient.Listener mWebSocketListener;

    public ConversationActivity()
    {
        mHelper = new RecordingActivityHelper();
        mConnectivityReceiver = new BroadcastReceiver() {

            final ConversationActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                boolean flag;
                try
                {
                    context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    SLog.e("We are not gangsta enough to acess the connectivity state.", context);
                    return;
                }
                if (context == null) goto _L2; else goto _L1
_L1:
                if (!context.isConnected()) goto _L2; else goto _L3
_L3:
                flag = true;
_L5:
                if (!flag)
                {
                    break MISSING_BLOCK_LABEL_72;
                }
                if (mLastIsConnected != flag)
                {
                    SLog.dWithTag("ConvActivity;RTC", "Connectivity change received, reconnecting");
                    mMainHandler.removeCallbacks(mReconnectRunnable);
                    reconnectWithBackoff();
                }
                mLastIsConnected = flag;
                return;
_L2:
                flag = false;
                if (true) goto _L5; else goto _L4
_L4:
            }

            
            {
                this$0 = ConversationActivity.this;
                super();
            }
        };
        mWebSocketListener = new com.codebutler.android_websockets.WebSocketClient.Listener() {

            final ConversationActivity this$0;

            public void onConnect()
            {
                SLog.dWithTag("ConvActivity;RTC", "Websocket connected");
                mMainHandler.removeCallbacks(mReconnectRunnable);
                mAppSessionListener.onWebSocketConnectComplete();
            }

            public void onDisconnect(int i, String s)
            {
                SLog.dWithTag("ConvActivity;RTC", (new StringBuilder()).append("Websocket disconnected, reason=").append(s).toString());
                mAppSessionListener.onWebSocketDisconnected();
            }

            public void onError(Exception exception)
            {
                SLog.dWithTag("ConvActivity;RTC", (new StringBuilder()).append("Websocket error=").append(exception.getMessage()).toString());
                mAppSessionListener.onWebSocketError();
            }

            public void onMessage(String s)
            {
                SLog.dWithTag("ConvActivity;RTC", String.format("Got string message: %s", new Object[] {
                    s
                }));
                try
                {
                    s = VineParsers.parseRTCEvent(VineParsers.createParser(s));
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    SLog.e("Failed to parse message.", s);
                    return;
                }
                if (s == null)
                {
                    break MISSING_BLOCK_LABEL_41;
                }
                mAppSessionListener.onReceiveRTCMessage(s);
            }

            public void onMessage(byte abyte0[])
            {
            }

            
            {
                this$0 = ConversationActivity.this;
                super();
            }
        };
    }

    private boolean clientIsActive()
    {
        this;
        JVM INSTR monitorenter ;
        VineWebSocketClient vinewebsocketclient = mClient;
        if (vinewebsocketclient == null) goto _L2; else goto _L1
_L1:
        boolean flag = vinewebsocketclient.isConnected();
        if (!flag) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    private void disconnectClient()
    {
        mMainHandler.removeCallbacks(mReconnectRunnable);
        VineWebSocketClient vinewebsocketclient = mClient;
        if (vinewebsocketclient != null)
        {
            vinewebsocketclient.disconnect();
            mClient = null;
        }
    }

    public static long[] getConversationActivityStates(Activity activity)
    {
        String s;
        int i;
        s = Util.getRecentActivityData(activity);
        i = s.indexOf(":");
        activity = new long[2];
        activity;
        activity[0] = -1L;
        activity[1] = -1L;
        long l = Long.valueOf(s.substring(0, i)).longValue();
        if (l <= 0L)
        {
            l = -1L;
        }
        activity[0] = l;
_L2:
        NumberFormatException numberformatexception1;
        try
        {
            l = Long.valueOf(s.substring(i + 1)).longValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            CrashUtil.logException(numberformatexception, "Attempted to restore activity state with an invalid direct user id", new Object[0]);
            return activity;
        }
        if (l <= 0L)
        {
            l = -1L;
        }
        activity[1] = l;
        return activity;
        numberformatexception1;
        CrashUtil.logException(numberformatexception1, "Attempted to restore activity state with an invalid conversation id", new Object[0]);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Intent getIntent(Context context, long l, String s, long l1, boolean flag, boolean flag1)
    {
        if (Util.isCapableOfInline(context))
        {
            s = co/vine/android/ConversationActivity;
        } else
        {
            s = co/vine/android/ConversationActivityMain;
        }
        context = new Intent(context, s);
        context.setFlags(0x4000000);
        context.putExtra("conversation_row_id", l);
        context.putExtra("user_id", l1);
        context.putExtra("am_following_recipient", flag);
        context.putExtra("keyboard_up", flag1);
        return context;
    }

    private void prepareClient()
    {
        VineWebSocketClient vinewebsocketclient = mClient;
        if (vinewebsocketclient == null || !vinewebsocketclient.isConnecting() && !vinewebsocketclient.isConnected())
        {
            SLog.d("ConvActivity;RTC", "Preparing client now");
            Object obj = VineAPI.getInstance(this);
            URI uri = URI.create(BuildUtil.getRtcUrl(getResources()));
            String s = mAppController.getActiveSessionReadOnly().getSessionKey();
            obj = Arrays.asList(new BasicNameValuePair[] {
                new BasicNameValuePair("vine-session-id", s), new BasicNameValuePair("X-Vine-Client", ((VineAPI) (obj)).getVineClientHeader())
            });
            SLog.dWithTag("ConvActivity;RTC", (new StringBuilder()).append("Creating client: sessionKey=").append(s).append(", uri=").append(uri).toString());
            mClient = new VineWebSocketClient(uri, mWebSocketListener, ((java.util.List) (obj)));
        }
    }

    private void reconnectWithBackoff()
    {
        mReconnectDelay = 1000L;
        mMainHandler.postDelayed(mReconnectRunnable, mReconnectDelay);
        SLog.dWithTag("ConvActivity;RTC", (new StringBuilder()).append("Posting reconnect runnable with delay=").append(mReconnectDelay).toString());
    }

    public RecordingActivityHelper getRecordingActivityHelper()
    {
        return mHelper;
    }

    public boolean isConversationSideMenuEnabled()
    {
        return true;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 101)
        {
            if (j == 1527)
            {
                mPref.edit().putBoolean("profile_phone_verified", true).commit();
                if (mRetrySuccessRunnable != null)
                {
                    mRetrySuccessRunnable.run();
                }
            }
            return;
        }
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("conversationFragment");
        if (fragment instanceof ConversationFragment)
        {
            fragment.onActivityResult(i - 0x10000, j, intent);
            return;
        } else
        {
            super.onActivityResult(i, j, intent);
            return;
        }
    }

    public void onBackPressed(View view)
    {
        try
        {
            onBackPressed();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030046, true, true);
        Object obj = getIntent();
        mIntentionalObjectCounter.add();
        mConversationRowId = ((Intent) (obj)).getLongExtra("conversation_row_id", -1L);
        mDirectUserId = ((Intent) (obj)).getLongExtra("user_id", -1L);
        mRecipientUserName = ((Intent) (obj)).getStringExtra("recipient_username");
        mAmFollowingRecipient = ((Intent) (obj)).getBooleanExtra("am_following_recipient", false);
        keyBoardUpOnStart = ((Intent) (obj)).getBooleanExtra("keyboard_up", false);
        mPref = Util.getDefaultSharedPrefs(this);
        if ("co.vine.android.MESSAGE_NOTIFICATION_PRESSED".equals(((Intent) (obj)).getAction()))
        {
            mAppController.clearPushNotifications(2);
        }
        if (mConversationRowId < 0L && mDirectUserId < 0L)
        {
            restoreActivityState();
        }
        mAppSessionListener = new ConversationSessionListener();
        if (mConversationRowId < 0L)
        {
            if (mDirectUserId <= 0L);
        }
        mHelper.bindCameraService(this);
        mVersion = RecordSessionManager.getCurrentVersion(this);
        if (bundle == null)
        {
            bundle = new ConversationFragment();
            obj = ConversationFragment.prepareArguments(((Intent) (obj)), false);
            ((Bundle) (obj)).putSerializable("arg_encoder_version", mVersion);
            ((Bundle) (obj)).putLong("conversation_row_id", mConversationRowId);
            bundle.setArguments(((Bundle) (obj)));
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, bundle, "conversationFragment").commit();
        }
        mMainHandler = new Handler(Looper.getMainLooper());
        mAppController.getConversationRemoteId(mConversationRowId);
        mChatReceiver = new RealTimeChatReceiver();
        mLastTyping = false;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f100003, menu);
        if (mAmFollowingRecipient || mDirectUserId <= 0L || TextUtils.isEmpty(mRecipientUserName))
        {
            menu.removeItem(0x7f0a0241);
        } else
        {
            menu.findItem(0x7f0a0241).setTitle(String.format(getString(0x7f0e0101), new Object[] {
                mRecipientUserName
            }));
        }
        if (mDirectUserId > 0L && !TextUtils.isEmpty(mRecipientUserName))
        {
            menu.findItem(0x7f0a0243).setTitle(String.format(getString(0x7f0e010e), new Object[] {
                mRecipientUserName
            }));
            menu.findItem(0x7f0a0242).setTitle(String.format(getString(0x7f0e010a), new Object[] {
                mRecipientUserName
            }));
        } else
        {
            menu.removeItem(0x7f0a0243);
            menu.removeItem(0x7f0a0242);
        }
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        int i;
        mIntentionalObjectCounter.release();
        i = mIntentionalObjectCounter.getCount();
label0:
        {
            {
                if (i != 0)
                {
                    break label0;
                }
                try
                {
                    CrashUtil.log("Clean up folders because we are the last one.");
                    mVersion.getManager(this).cleanUnusedFolders();
                }
                catch (IOException ioexception)
                {
                    CrashUtil.logException(ioexception);
                }
            }
            mHelper.unBindCameraService(this);
            return;
        }
        if (i <= 1)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        CrashUtil.logException(new VineLoggingException("Double instance violation, but it's ok."));
        break MISSING_BLOCK_LABEL_40;
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            switch (j)
            {
            default:
                return;

            case -1: 
                mAppController.deleteConversation(mConversationRowId);
                break;
            }
            finish();
            return;

        case 1: // '\001'
            switch (j)
            {
            default:
                return;

            case -1: 
                mAppController.ignoreConversation(mConversationRowId);
                break;
            }
            finish();
            return;

        case 2: // '\002'
            switch (j)
            {
            default:
                return;

            case -1: 
                mAppController.deleteMessage(mMessageIdToDelete);
                break;
            }
            break;
        }
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
        if (!MuteUtil.isMuted(this))
        {
            sendBroadcast(new Intent(MuteUtil.ACTION_CHANGED_TO_MUTE), "co.vine.android.BROADCAST");
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        mConversationRowId = intent.getLongExtra("conversation_row_id", -1L);
        mAmFollowingRecipient = intent.getBooleanExtra("am_following_recipient", false);
        if (mConversationRowId < 0L)
        {
            if (mDirectUserId <= 0L);
        }
        mDirectUserId = intent.getLongExtra("user_id", -1L);
        mRecipientUserName = intent.getStringExtra("recipient_username");
        mAmFollowingRecipient = intent.getBooleanExtra("am_following_recipient", false);
        ConversationFragment conversationfragment = new ConversationFragment();
        intent = ConversationFragment.prepareArguments(intent, false);
        intent.putSerializable("arg_encoder_version", mVersion);
        intent.putLong("conversation_row_id", mConversationRowId);
        intent.putBoolean("am_following_recipient", mAmFollowingRecipient);
        conversationfragment.setArguments(intent);
        getSupportFragmentManager().beginTransaction().replace(0x7f0a0102, conversationfragment, "conversationFragment").commit();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131362371: 
            showIgnoreDialog();
            return true;

        case 2131362372: 
            showDeleteDialog();
            return true;

        case 16908332: 
            onBackPressed();
            return true;

        case 2131362370: 
            ProfileActivity.start(this, mDirectUserId, EVENT_SOURCE_TITLE);
            return true;

        case 2131362369: 
            mAppController.followUser(mAppController.getActiveSession(), mDirectUserId, true);
            return true;
        }
    }

    protected void onPause()
    {
        super.onPause();
        try
        {
            unregisterReceiver(mChatReceiver);
        }
        catch (IllegalArgumentException illegalargumentexception1) { }
        try
        {
            unregisterReceiver(mConnectivityReceiver);
        }
        catch (IllegalArgumentException illegalargumentexception) { }
        onTypingStatusChanged(false, false);
        disconnectClient();
    }

    protected void onResume()
    {
        super.onResume();
        ResourceService.lastActiveconversationRowId = mConversationRowId;
        Object obj = new IntentFilter();
        ((IntentFilter) (obj)).addAction("co.vine.android.rtc.WEBSOCKET_EVENT");
        ((IntentFilter) (obj)).addAction("co.vine.android.service.mergeSelfNewMessage");
        registerReceiver(mChatReceiver, ((IntentFilter) (obj)), "co.vine.android.BROADCAST", null);
        startService(GCMNotificationService.getUpdateNotificationIntent(this, 2, mConversationRowId));
        obj = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(mConnectivityReceiver, ((IntentFilter) (obj)), "co.vine.android.BROADCAST", null);
        prepareClient();
        obj = mClient;
        if (obj != null)
        {
            ((VineWebSocketClient) (obj)).connect();
        }
    }

    protected void onStart()
    {
        super.onStart();
        ResourceService.isConversationActive = true;
    }

    protected void onStop()
    {
        super.onStop();
        ResourceService.isConversationActive = false;
    }

    public void onTypingStatusChanged(boolean flag, boolean flag1)
    {
        if (mConversationId <= 0L || !clientIsActive() || mLastTyping == flag) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        mClient.updateTypingState(mConversationId, true);
_L2:
        mLastTyping = flag;
        return;
_L4:
        if (!flag1)
        {
            mClient.updateTypingState(mConversationId, false);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected void restoreActivityState()
    {
        super.restoreActivityState();
        Intent intent = getIntent();
        if (intent != null && "android.intent.action.MAIN".equals(intent.getAction()))
        {
            long al[] = getConversationActivityStates(this);
            mConversationRowId = al[0];
            mDirectUserId = al[1];
        }
    }

    public void setRecipientUsername(String s)
    {
        boolean flag = true;
        mRecipientUserName = s;
        if (TextUtils.isEmpty(mRecipientUserName))
        {
            flag = false;
        }
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(flag), mRecipientUserName, null);
    }

    public void showDeleteDialog()
    {
        PromptDialogFragment promptdialogfragment = PromptDialogFragment.newInstance(0);
        promptdialogfragment.setListener(this);
        promptdialogfragment.setMessage(0x7f0e00b2);
        promptdialogfragment.setPositiveButton(0x7f0e00b6);
        promptdialogfragment.setNegativeButton(0x7f0e0057);
        promptdialogfragment.show(getFragmentManager());
    }

    public void showDeleteMessageDialog(long l)
    {
        mMessageIdToDelete = l;
        PromptDialogFragment promptdialogfragment = PromptDialogFragment.newInstance(2);
        promptdialogfragment.setListener(this);
        promptdialogfragment.setMessage(0x7f0e00b4);
        promptdialogfragment.setPositiveButton(0x7f0e00b6);
        promptdialogfragment.setNegativeButton(0x7f0e0057);
        promptdialogfragment.show(getFragmentManager());
    }

    public void showIgnoreDialog()
    {
        PromptDialogFragment promptdialogfragment = PromptDialogFragment.newInstance(1);
        promptdialogfragment.setListener(this);
        promptdialogfragment.setMessage(0x7f0e010d);
        promptdialogfragment.setPositiveButton(0x7f0e010f);
        promptdialogfragment.setNegativeButton(0x7f0e0057);
        promptdialogfragment.show(getFragmentManager());
    }

    public void startPhoneConfirmation(Runnable runnable)
    {
        if (mPref.getBoolean("profile_phone_verified", false))
        {
            runnable.run();
            return;
        } else
        {
            mRetrySuccessRunnable = runnable;
            startActivityForResult(ConfirmationFlowActivity.getIntent(this, mPref.getString("settings_profile_phone", ""), false), 101);
            return;
        }
    }






/*
    static long access$1202(ConversationActivity conversationactivity, long l)
    {
        conversationactivity.mLastMessageId = l;
        return l;
    }

*/





/*
    static boolean access$302(ConversationActivity conversationactivity, boolean flag)
    {
        conversationactivity.mLastIsConnected = flag;
        return flag;
    }

*/







/*
    static long access$802(ConversationActivity conversationactivity, long l)
    {
        conversationactivity.mReconnectDelay = l;
        return l;
    }

*/



/*
    static long access$902(ConversationActivity conversationactivity, long l)
    {
        conversationactivity.mConversationId = l;
        return l;
    }

*/
}
