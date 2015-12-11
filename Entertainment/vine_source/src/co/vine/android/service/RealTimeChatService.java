// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import co.vine.android.api.VineParsers;
import co.vine.android.client.VineAPI;
import co.vine.android.util.CrashUtil;
import com.codebutler.android_websockets.WebSocketClient;
import com.edisonwang.android.slog.SLog;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.message.BasicNameValuePair;

public class RealTimeChatService extends Service
{
    private static class Conversation extends HashMap
    {

        private Conversation(Builder builder)
        {
            put("connected", Boolean.valueOf(builder.connected));
            put("typing", Boolean.valueOf(builder.typing));
            if (builder.lastMessageId > 0L)
            {
                put("last_message_id", Long.valueOf(builder.lastMessageId));
            }
        }

    }

    public static class Conversation.Builder
    {

        private boolean connected;
        private long lastMessageId;
        private boolean typing;

        public Conversation build()
        {
            return new Conversation(this);
        }

        public Conversation.Builder setConnected()
        {
            connected = true;
            return this;
        }

        public Conversation.Builder setLastMessageId(long l)
        {
            lastMessageId = l;
            return this;
        }

        public Conversation.Builder setTyping(boolean flag)
        {
            typing = flag;
            return this;
        }




        public Conversation.Builder()
        {
            connected = false;
            typing = false;
            lastMessageId = 0L;
        }
    }

    private class ExecutionRunnable
        implements Runnable
    {

        private final int mActionCode;
        private final Bundle mBundle;
        private final Messenger mResponder;
        final RealTimeChatService this$0;

        public void run()
        {
            Message message;
            Process.setThreadPriority(10);
            executeAction(mActionCode, mBundle);
            if (!mBundle.getBoolean("respond", true))
            {
                break MISSING_BLOCK_LABEL_61;
            }
            message = Message.obtain();
            message.what = mActionCode;
            message.setData(mBundle);
            mResponder.send(message);
            return;
            Exception exception;
            exception;
            CrashUtil.logException(exception, "Error sending service response", new Object[0]);
            return;
        }

        public ExecutionRunnable(int i, Bundle bundle, Messenger messenger)
        {
            this$0 = RealTimeChatService.this;
            super();
            mActionCode = i;
            mBundle = bundle;
            mResponder = messenger;
        }
    }

    class VineServiceHandler extends Handler
    {

        final RealTimeChatService this$0;

        public void handleMessage(Message message)
        {
            message.getData().setClassLoader(getClassLoader());
            mExecutor.execute(new ExecutionRunnable(message.arg1, message.getData(), message.replyTo));
        }

        VineServiceHandler()
        {
            this$0 = RealTimeChatService.this;
            super();
        }
    }


    public static final int ACTION_CODE_ALERT_NEW_PRIVATE_MESSAGE = 8;
    public static final int ACTION_CODE_CONNECT = 1;
    public static final int ACTION_CODE_DISCONNECT = 5;
    public static final int ACTION_CODE_ERROR = 6;
    public static final int ACTION_CODE_NEW_WEBSOCKET_FRAME = 9;
    public static final int ACTION_CODE_RECONNECT = 2;
    public static final int ACTION_CODE_SUBSCRIBE = 3;
    public static final int ACTION_CODE_UNSUBSCRIBE = 4;
    public static final int ACTION_CODE_UPDATE_TYPING_STATE = 7;
    public static final String ACTION_WEBSOCKET_EVENT = "co.vine.android.rtc.WEBSOCKET_EVENT";
    public static final String EXTRA_ACTION_CODE = "action_code";
    public static final String EXTRA_CODE = "code";
    public static final String EXTRA_CONNECTED = "connected";
    public static final String EXTRA_CONVERSATION_ID = "conversation_id";
    public static final String EXTRA_DATA = "data";
    public static final String EXTRA_IS_TYPING = "is_typing";
    public static final String EXTRA_LAST_MESSAGE_ID = "last_message_id";
    public static final String EXTRA_PID = "pid";
    public static final String EXTRA_REASON = "reason";
    public static final String EXTRA_RESPOND = "respond";
    public static final String EXTRA_SESSION_KEY = "s_key";
    private static final long INITIAL_RETRY_DELAY = 1000L;
    private static final int MAX_RETRY_DELAY = 16000;
    public static final String PARAM_CONNECTED = "connected";
    public static final String PARAM_CONVERSATIONS = "conversations";
    public static final String PARAM_LAST_MESSAGE_ID = "last_message_id";
    public static final String PARAM_TYPING = "typing";
    public static final String TAG = "RTCService";
    private WebSocketClient mClient;
    private ExecutorService mExecutor;
    private Handler mMainHandler;
    private Messenger mMessenger;
    private long mReconnectDelay;
    private final Runnable mReconnectRunnable = new Runnable() {

        final RealTimeChatService this$0;

        public void run()
        {
            if (mClient != null && !clientIsActive())
            {
                mClient.connect();
                RealTimeChatService realtimechatservice = RealTimeChatService.this;
                long l;
                if (mReconnectDelay < 16000L)
                {
                    l = mReconnectDelay * 2L;
                } else
                {
                    l = mReconnectDelay;
                }
                realtimechatservice.mReconnectDelay = l;
                mMainHandler.postDelayed(mReconnectRunnable, mReconnectDelay);
                SLog.dWithTag("RTCService", (new StringBuilder()).append("Posted reconnect with delay=").append(mReconnectDelay).append("ms").toString());
            }
        }

            
            {
                this$0 = RealTimeChatService.this;
                super();
            }
    };
    private String mRtcUrl;
    private com.codebutler.android_websockets.WebSocketClient.Listener mWebSocketListener;

    public RealTimeChatService()
    {
        mWebSocketListener = new com.codebutler.android_websockets.WebSocketClient.Listener() {

            final RealTimeChatService this$0;

            public void onConnect()
            {
                SLog.dWithTag("RTCService", "Connected - now ready to subscribe to conversations.");
                removeReconnectCallback();
                broadcastEvent(1, null);
            }

            public void onDisconnect(int i, String s)
            {
                SLog.dWithTag("RTCService", String.format("Disconnected with code=%d, reason=%s, delay=%dms", new Object[] {
                    Integer.valueOf(i), s, Long.valueOf(mReconnectDelay)
                }));
                Bundle bundle = new Bundle();
                bundle.putInt("code", i);
                bundle.putString("reason", s);
                broadcastEvent(5, bundle);
            }

            public void onError(Exception exception)
            {
                SLog.dWithTag("RTCService", (new StringBuilder()).append("Error: ").append(exception.getMessage()).toString());
            }

            public void onMessage(String s)
            {
                SLog.dWithTag("RTCService", String.format("Got string message: %s", new Object[] {
                    s
                }));
                try
                {
                    s = VineParsers.parseRTCEvent(VineParsers.createParser(s));
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("data", s);
                    broadcastEvent(9, bundle);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    SLog.e("Failed to parse message.", s);
                }
            }

            public void onMessage(byte abyte0[])
            {
            }

            
            {
                this$0 = RealTimeChatService.this;
                super();
            }
        };
    }

    private void broadcastEvent(int i, Bundle bundle)
    {
        this;
        JVM INSTR monitorenter ;
        Intent intent = new Intent("co.vine.android.rtc.WEBSOCKET_EVENT");
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        intent.putExtras(bundle);
        intent.putExtra("action_code", i);
        sendBroadcast(intent, "co.vine.android.BROADCAST");
        this;
        JVM INSTR monitorexit ;
        return;
        bundle;
        throw bundle;
    }

    private boolean clientIsActive()
    {
        this;
        JVM INSTR monitorenter ;
        WebSocketClient websocketclient = mClient;
        if (websocketclient == null) goto _L2; else goto _L1
_L1:
        boolean flag = websocketclient.isConnected();
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

    private void disconnect()
    {
        this;
        JVM INSTR monitorenter ;
        WebSocketClient websocketclient = mClient;
        if (websocketclient == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        websocketclient.disconnect();
        mClient = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void executeAction(int i, Bundle bundle)
    {
        i;
        JVM INSTR tableswitch 1 8: default 48
    //                   1 49
    //                   2 83
    //                   3 121
    //                   4 159
    //                   5 194
    //                   6 48
    //                   7 199
    //                   8 250;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L1 _L7 _L8
_L1:
        return;
_L2:
        bundle = bundle.getString("s_key");
        removeReconnectCallback();
        prepareClient(bundle);
        if (!mClient.isConnected())
        {
            mClient.connect();
            return;
        }
          goto _L1
_L3:
        prepareClient(bundle.getString("s_key"));
        removeReconnectCallback();
        mReconnectDelay = 1000L;
        mMainHandler.postDelayed(mReconnectRunnable, mReconnectDelay);
        return;
_L4:
        send(getPayload(Long.valueOf(bundle.getLong("conversation_id")), new Conversation[] {
            (new Conversation.Builder()).setConnected().build()
        }));
        return;
_L5:
        send(getPayload(Long.valueOf(bundle.getLong("conversation_id")), new Conversation[] {
            (new Conversation.Builder()).build()
        }));
        return;
_L6:
        disconnect();
        return;
_L7:
        boolean flag = bundle.getBoolean("is_typing");
        send(getPayload(Long.valueOf(bundle.getLong("conversation_id")), new Conversation[] {
            (new Conversation.Builder()).setConnected().setTyping(flag).build()
        }));
        return;
_L8:
        long l = bundle.getLong("conversation_id");
        long l1 = bundle.getLong("last_message_id");
        send(getPayload(Long.valueOf(l), new Conversation[] {
            (new Conversation.Builder()).setConnected().setLastMessageId(l1).build()
        }));
        return;
    }

    private transient String getPayload(Long long1, Conversation aconversation[])
    {
        this;
        JVM INSTR monitorenter ;
        HashMap hashmap;
        HashMap hashmap1;
        int j;
        hashmap1 = new HashMap();
        hashmap = new HashMap();
        j = aconversation.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        hashmap1.put(long1, aconversation[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        hashmap.put("conversations", hashmap1);
        long1 = new ObjectMapper();
        aconversation = long1.valueToTree(hashmap);
        try
        {
            long1 = long1.writeValueAsString(aconversation);
            SLog.dWithTag("RTCService", (new StringBuilder()).append("RTC event payload=").append(long1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Long long1)
        {
            long1 = "";
        }
        this;
        JVM INSTR monitorexit ;
        return long1;
        long1;
        throw long1;
    }

    private void removeReconnectCallback()
    {
        mMainHandler.removeCallbacks(mReconnectRunnable);
    }

    private void send(String s)
    {
        WebSocketClient websocketclient;
        try
        {
            websocketclient = mClient;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            CrashUtil.log(s.getMessage());
            return;
        }
        if (websocketclient == null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        if (clientIsActive())
        {
            websocketclient.send(s);
        }
    }

    public IBinder onBind(Intent intent)
    {
        SLog.dWithTag("RTCService", "rtc service was bound");
        return mMessenger.getBinder();
    }

    public void onCreate()
    {
        super.onCreate();
        mMainHandler = new Handler(Looper.getMainLooper());
        mExecutor = Executors.newCachedThreadPool();
        mMessenger = new Messenger(new VineServiceHandler());
        mRtcUrl = VineAPI.getInstance(this).getRtcUrl();
    }

    public void onDestroy()
    {
        super.onDestroy();
        removeReconnectCallback();
        disconnect();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        return 2;
    }

    public void prepareClient(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (!clientIsActive())
        {
            SLog.d("RTCService", "preparing client now");
            Object obj = VineAPI.getInstance(this);
            URI uri = URI.create(mRtcUrl);
            obj = Arrays.asList(new BasicNameValuePair[] {
                new BasicNameValuePair("vine-session-id", s), new BasicNameValuePair("X-Vine-Client", ((VineAPI) (obj)).getVineClientHeader())
            });
            SLog.dWithTag("RTCService", (new StringBuilder()).append("Creating client: sessionKey=").append(s).append(", uri=").append(uri.toString()).toString());
            mClient = new WebSocketClient(uri, mWebSocketListener, ((java.util.List) (obj)));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }







/*
    static long access$202(RealTimeChatService realtimechatservice, long l)
    {
        realtimechatservice.mReconnectDelay = l;
        return l;
    }

*/




}
