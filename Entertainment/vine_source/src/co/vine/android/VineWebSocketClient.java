// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import com.codebutler.android_websockets.WebSocketClient;
import com.edisonwang.android.slog.SLog;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

public class VineWebSocketClient extends WebSocketClient
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


    public static final String PARAM_CONNECTED = "connected";
    public static final String PARAM_CONVERSATIONS = "conversations";
    public static final String PARAM_LAST_MESSAGE_ID = "last_message_id";
    public static final String PARAM_TYPING = "typing";
    private static final String TAG = "VineWebSocketClient;RTC";

    public VineWebSocketClient(URI uri, com.codebutler.android_websockets.WebSocketClient.Listener listener, List list)
    {
        super(uri, listener, list);
    }

    private void sendPayload(String s)
    {
        try
        {
            if (isConnected())
            {
                send(s);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void alertNewPrivateMessage(long l, long l1)
    {
        sendPayload(getPayload(Long.valueOf(l), new Conversation[] {
            (new Conversation.Builder()).setConnected().setLastMessageId(l1).setTyping(false).build()
        }));
    }

    public transient String getPayload(Long long1, Conversation aconversation[])
    {
        HashMap hashmap1 = new HashMap();
        HashMap hashmap = new HashMap();
        int j = aconversation.length;
        for (int i = 0; i < j; i++)
        {
            hashmap1.put(long1, aconversation[i]);
        }

        hashmap.put("conversations", hashmap1);
        long1 = new ObjectMapper();
        aconversation = long1.valueToTree(hashmap);
        try
        {
            long1 = long1.writeValueAsString(aconversation);
            SLog.dWithTag("VineWebSocketClient;RTC", (new StringBuilder()).append("RTC event payload=").append(long1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Long long1)
        {
            return "";
        }
        return long1;
    }

    public void subscribeConversation(long l)
    {
        sendPayload(getPayload(Long.valueOf(l), new Conversation[] {
            (new Conversation.Builder()).setConnected().build()
        }));
    }

    public void updateTypingState(long l, boolean flag)
    {
        sendPayload(getPayload(Long.valueOf(l), new Conversation[] {
            (new Conversation.Builder()).setConnected().setTyping(flag).build()
        }));
    }
}
