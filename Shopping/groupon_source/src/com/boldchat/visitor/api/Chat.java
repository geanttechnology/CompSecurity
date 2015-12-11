// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;

import com.boldchat.visitor.api.internal.RPCMethod;
import com.boldchat.visitor.api.internal.RPCSender;
import com.boldchat.visitor.api.internal.RequestUtil;
import com.boldchat.visitor.api.internal.RestAPIRequest;
import com.boldchat.visitor.api.internal.ResultListener;
import com.boldchat.visitor.api.internal.VisitorLongPoll;
import com.boldchat.visitor.api.internal.VisitorMessageListener;
import com.boldchat.visitor.api.internal.VisitorMessageProcessor;
import com.boldchat.visitor.api.internal.VisitorWebSocket;
import com.boldchat.visitor.api.json.JSONObject;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;

// Referenced classes of package com.boldchat.visitor.api:
//            EndedReason, Account, Message, PersonType, 
//            ChatMessageListener, ChatStartListener, Form, FormField, 
//            ChatListener, ChatQueueListener, ChatTyperListener, LanguageChangeListener, 
//            ChatFinishedListener, ChatUnavailableListener, ChatRecaptureListener, PostChatSubmitListener, 
//            ActiveAssistSession, ActiveAssistListener, Typer, UnavailableReason, 
//            UnavailableForm, PostChat

public class Chat
{
    private class MethodRetry
        implements Runnable
    {

        final Chat this$0;
        RPCMethod topMethod;

        public void run()
        {
            long l = 15L;
            if (retrySleep <= 15L) goto _L2; else goto _L1
_L1:
            Thread.sleep(l);
_L3:
            synchronized (retryQueue)
            {
                if (retryQueue.size() > 0)
                {
                    topMethod = (RPCMethod)retryQueue.remove(0);
                }
            }
            if (topMethod != null && ended == null)
            {
                callMethod(topMethod.getMethod(), topMethod.getParams(), new ResultListener() );
                return;
            } else
            {
                retryThread = null;
                return;
            }
_L2:
            l = retrySleep;
            l *= 2000L;
              goto _L1
            obj;
            ((InterruptedException) (obj)).printStackTrace();
              goto _L3
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
              goto _L1
        }

        private MethodRetry()
        {
            this$0 = Chat.this;
            super();
            topMethod = null;
        }

    }

    private class OSSListener
        implements VisitorMessageListener
    {

        private boolean isConnected;
        final Chat this$0;

        public void addMessage(long l, JSONObject jsonobject)
        {
            jsonobject = new Message(l, jsonobject);
            synchronized (chatHistory)
            {
                chatHistory.add(jsonobject);
            }
            obj = chatMessageListeners;
            obj;
            JVM INSTR monitorenter ;
            for (Iterator iterator = (new HashSet(chatMessageListeners.keySet())).iterator(); iterator.hasNext(); ((ChatMessageListener)iterator.next()).onMessageAdded(jsonobject)) { }
            break MISSING_BLOCK_LABEL_112;
            jsonobject;
            obj;
            JVM INSTR monitorexit ;
            throw jsonobject;
            jsonobject;
            obj;
            JVM INSTR monitorexit ;
            throw jsonobject;
            obj;
            JVM INSTR monitorexit ;
        }

        public void autoMessage(String s)
        {
            WeakHashMap weakhashmap = chatMessageListeners;
            weakhashmap;
            JVM INSTR monitorenter ;
            for (Iterator iterator = (new HashSet(chatMessageListeners.keySet())).iterator(); iterator.hasNext(); ((ChatMessageListener)iterator.next()).onAutoMessage(s)) { }
            break MISSING_BLOCK_LABEL_63;
            s;
            weakhashmap;
            JVM INSTR monitorexit ;
            throw s;
            weakhashmap;
            JVM INSTR monitorexit ;
        }

        public void beginActiveAssist(JSONObject jsonobject)
        {
            if (activeAssistListeners.size() <= 0) goto _L2; else goto _L1
_L1:
            ActiveAssistSession activeassistsession;
            activeassistsession = new ActiveAssistSession(jsonobject);
            activeAssist.put(activeassistsession.getActiveAssistID(), activeassistsession);
            jsonobject = activeAssistListeners;
            jsonobject;
            JVM INSTR monitorenter ;
            for (Iterator iterator = (new HashSet(activeAssistListeners.keySet())).iterator(); iterator.hasNext(); ((ActiveAssistListener)iterator.next()).onBeginActiveAssist(activeassistsession)) { }
            break MISSING_BLOCK_LABEL_101;
            Exception exception;
            exception;
            jsonobject;
            JVM INSTR monitorexit ;
            throw exception;
            jsonobject;
            JVM INSTR monitorexit ;
_L2:
        }

        public void chatClosed(VisitorMessageProcessor visitormessageprocessor)
        {
            if (ended == null)
            {
                ended = new Date();
                endedReason = EndedReason.Disconnected;
            }
            visitormessageprocessor = chatListeners;
            visitormessageprocessor;
            JVM INSTR monitorenter ;
            for (Iterator iterator = (new HashSet(chatListeners.keySet())).iterator(); iterator.hasNext(); ((ChatListener)iterator.next()).onChatUpdated(Chat.this)) { }
            break MISSING_BLOCK_LABEL_102;
            Exception exception;
            exception;
            visitormessageprocessor;
            JVM INSTR monitorexit ;
            throw exception;
            visitormessageprocessor;
            JVM INSTR monitorexit ;
        }

        public void heartbeat()
        {
            lastHeartbeat = System.currentTimeMillis();
        }

        public boolean isConnected()
        {
            return isConnected;
        }

        public void onClose(int i, String s, boolean flag, VisitorMessageProcessor visitormessageprocessor)
        {
            isConnected = false;
            Iterator iterator;
            if (visitormessageprocessor == webSocket)
            {
                webSocket = null;
            } else
            if (visitormessageprocessor == longPollSocket)
            {
                longPollSocket = null;
            }
            if (activeMessageProcessor != visitormessageprocessor || i != -100) goto _L2; else goto _L1
_L1:
            visitormessageprocessor = chatListeners;
            visitormessageprocessor;
            JVM INSTR monitorenter ;
            for (iterator = (new HashSet(chatListeners.keySet())).iterator(); iterator.hasNext(); ((ChatListener)iterator.next()).onChatFatalError(i, s)) { }
            break MISSING_BLOCK_LABEL_138;
            s;
            visitormessageprocessor;
            JVM INSTR monitorexit ;
            throw s;
            visitormessageprocessor;
            JVM INSTR monitorexit ;
_L2:
        }

        public void onError(Exception exception, VisitorMessageProcessor visitormessageprocessor)
        {
            exception.printStackTrace();
        }

        public void onOpen(VisitorMessageProcessor visitormessageprocessor)
        {
            isConnected = true;
            if (webSocket == visitormessageprocessor)
            {
                activeMessageProcessor = webSocket;
            } else
            if (activeMessageProcessor == null || (activeMessageProcessor instanceof VisitorLongPoll))
            {
                activeMessageProcessor = visitormessageprocessor;
                return;
            }
        }

        public void onReconnecting(VisitorMessageProcessor visitormessageprocessor)
        {
            isConnected = false;
        }

        public void redirect(String s, VisitorMessageProcessor visitormessageprocessor)
        {
            visitormessageprocessor.close();
            VisitorMessageProcessor visitormessageprocessor1 = activeMessageProcessor;
            if (visitormessageprocessor == webSocket)
            {
                webSocketURL = s;
                webSocket = null;
                connectWebSocket();
                if (visitormessageprocessor1 == visitormessageprocessor)
                {
                    activeMessageProcessor = webSocket;
                }
            } else
            if (visitormessageprocessor == longPollSocket)
            {
                longPollURL = s;
                longPollSocket = null;
                connectLongPoll();
                if (visitormessageprocessor1 == visitormessageprocessor)
                {
                    activeMessageProcessor = longPollSocket;
                    return;
                }
            }
        }

        public void reset(VisitorMessageProcessor visitormessageprocessor)
        {
            if (webSocket != null)
            {
                webSocket.close();
            }
            if (longPollSocket != null)
            {
                longPollSocket.close();
            }
            webSocket = null;
            longPollSocket = null;
            activeMessageProcessor = null;
            clientID = 0L;
            webSocketURL = null;
            longPollURL = null;
            startChat(null);
        }

        public void updateActiveAssist(long l, JSONObject jsonobject)
        {
            if (activeAssistListeners.size() <= 0) goto _L2; else goto _L1
_L1:
            ActiveAssistSession activeassistsession = (ActiveAssistSession)activeAssist.get(Long.valueOf(l));
            if (activeassistsession == null) goto _L2; else goto _L3
_L3:
            activeassistsession.updateValues(jsonobject);
            jsonobject = activeAssistListeners;
            jsonobject;
            JVM INSTR monitorenter ;
            for (Iterator iterator = (new HashSet(activeAssistListeners.keySet())).iterator(); iterator.hasNext(); ((ActiveAssistListener)iterator.next()).onActiveAssistUpdated(activeassistsession)) { }
            break MISSING_BLOCK_LABEL_112;
            Exception exception;
            exception;
            jsonobject;
            JVM INSTR monitorexit ;
            throw exception;
            jsonobject;
            JVM INSTR monitorexit ;
_L2:
        }

        public void updateBusy(JSONObject jsonobject)
        {
            int i;
            boolean flag;
            i = jsonobject.optInt("Position", -1);
            flag = jsonobject.optBoolean("UnavailableFormEnabled", false);
            jsonobject = chatQueueListeners;
            jsonobject;
            JVM INSTR monitorenter ;
            for (Iterator iterator = (new HashSet(chatQueueListeners.keySet())).iterator(); iterator.hasNext(); ((ChatQueueListener)iterator.next()).onUpdateQueue(i, flag)) { }
            break MISSING_BLOCK_LABEL_83;
            Exception exception;
            exception;
            jsonobject;
            JVM INSTR monitorexit ;
            throw exception;
            jsonobject;
            JVM INSTR monitorexit ;
        }

        public void updateChat(long l, JSONObject jsonobject)
        {
            if (l != chatID) goto _L2; else goto _L1
_L1:
            updateChatValues(jsonobject);
            jsonobject = chatListeners;
            jsonobject;
            JVM INSTR monitorenter ;
            for (Iterator iterator = (new HashSet(chatListeners.keySet())).iterator(); iterator.hasNext(); ((ChatListener)iterator.next()).onChatUpdated(Chat.this)) { }
            break MISSING_BLOCK_LABEL_91;
            Exception exception;
            exception;
            jsonobject;
            JVM INSTR monitorexit ;
            throw exception;
            jsonobject;
            JVM INSTR monitorexit ;
_L2:
        }

        public void updateTyper(long l, JSONObject jsonobject)
        {
            Object obj1 = typers;
            obj1;
            JVM INSTR monitorenter ;
            Object obj = (Typer)typers.get(Long.valueOf(l));
            if (obj != null) goto _L2; else goto _L1
_L1:
            jsonobject = new Typer(l, jsonobject);
            typers.put(Long.valueOf(l), jsonobject);
_L4:
            obj1;
            JVM INSTR monitorexit ;
            obj = chatTyperListeners;
            obj;
            JVM INSTR monitorenter ;
            for (obj1 = (new HashSet(chatTyperListeners.keySet())).iterator(); ((Iterator) (obj1)).hasNext(); ((ChatTyperListener)((Iterator) (obj1)).next()).onTyperUpdated(jsonobject)) { }
            break; /* Loop/switch isn't completed */
            jsonobject;
            obj;
            JVM INSTR monitorexit ;
            throw jsonobject;
_L2:
            ((Typer) (obj)).update(jsonobject);
            jsonobject = ((JSONObject) (obj));
            if (true) goto _L4; else goto _L3
_L6:
            obj1;
            JVM INSTR monitorexit ;
            throw jsonobject;
_L3:
            obj;
            JVM INSTR monitorexit ;
            return;
            jsonobject;
            continue; /* Loop/switch isn't completed */
            jsonobject;
            if (true) goto _L6; else goto _L5
_L5:
        }

        private OSSListener()
        {
            this$0 = Chat.this;
            super();
            isConnected = false;
        }

    }

    private class StartChatResultListener
        implements ResultListener
    {

        private final ChatStartListener listener;
        final Chat this$0;

        public void failure(int i, String s, JSONObject jsonobject)
        {
            if (listener != null)
            {
                listener.onChatStartFailed(i, s);
            }
        }

        public void failure(IOException ioexception)
        {
            ioexception.printStackTrace();
            if (listener != null)
            {
                ChatStartListener chatstartlistener = listener;
                if (ioexception.getLocalizedMessage() != null)
                {
                    ioexception = ioexception.getLocalizedMessage();
                } else
                {
                    ioexception = ioexception.getMessage();
                }
                chatstartlistener.onChatStartFailed(-100, ioexception);
            }
        }

        public void success(JSONObject jsonobject)
        {
            updateChatValues(jsonobject);
            if (jsonobject.optString("UnavailableReason", null) != null)
            {
                if (listener != null)
                {
                    UnavailableReason unavailablereason = UnavailableReason.getUnavailableReason(jsonobject.optString("UnavailableReason"));
                    jsonobject = new UnavailableForm(jsonobject.optJSONObject("UnavailableForm"));
                    listener.onChatUnavailable(unavailablereason, jsonobject);
                }
            } else
            {
                connectSockets();
                if (listener != null)
                {
                    listener.onChatStarted();
                    return;
                }
            }
        }

        public StartChatResultListener(ChatStartListener chatstartlistener)
        {
            this$0 = Chat.this;
            super();
            listener = chatstartlistener;
        }
    }


    private Account account;
    private HashMap activeAssist;
    private WeakHashMap activeAssistListeners;
    private VisitorMessageProcessor activeMessageProcessor;
    private int answerTimeout;
    private Date answered;
    private Map brandings;
    private ArrayList chatHistory;
    private long chatID;
    private String chatKey;
    private WeakHashMap chatListeners;
    private WeakHashMap chatMessageListeners;
    private WeakHashMap chatQueueListeners;
    private WeakHashMap chatTyperListeners;
    private long clientID;
    private int clientTimeout;
    private Date ended;
    private EndedReason endedReason;
    private String language;
    private long lastHeartbeat;
    private VisitorLongPoll longPollSocket;
    private String longPollURL;
    private OSSListener oss;
    private Random rand;
    private ArrayList retryQueue;
    private long retrySleep;
    private MethodRetry retryThread;
    private Date started;
    private HashMap typers;
    private long visitorID;
    private String visitorName;
    boolean visitorTyping;
    private VisitorWebSocket webSocket;
    private String webSocketURL;

    protected Chat(Account account1, JSONObject jsonobject, Map map)
    {
        chatListeners = new WeakHashMap();
        chatQueueListeners = new WeakHashMap();
        chatMessageListeners = new WeakHashMap();
        chatTyperListeners = new WeakHashMap();
        activeAssistListeners = new WeakHashMap();
        clientTimeout = 120;
        answerTimeout = -1;
        endedReason = EndedReason.Unknown;
        rand = new Random();
        visitorName = "Visitor";
        typers = new HashMap();
        activeAssist = new HashMap();
        visitorTyping = false;
        oss = null;
        brandings = null;
        chatHistory = new ArrayList();
        lastHeartbeat = System.currentTimeMillis();
        retryQueue = new ArrayList();
        retryThread = null;
        retrySleep = 1L;
        account = account1;
        brandings = map;
        updateChatValues(jsonobject);
    }

    private void callMethod(String s, HashMap hashmap, ResultListener resultlistener)
    {
        callMethod(s, hashmap, resultlistener, false);
    }

    private void callMethod(String s, HashMap hashmap, ResultListener resultlistener, boolean flag)
    {
        if (flag || activeMessageProcessor == null || !isConnected() || !(activeMessageProcessor instanceof RPCSender))
        {
            (new Thread(new RestAPIRequest(account.getTimeout(), account.getAccountID(), account.getApiAccessKey(), account.getServerSet(), null, s, hashmap, resultlistener))).start();
            return;
        }
        try
        {
            ((RPCSender)activeMessageProcessor).sendRPC(s, hashmap, resultlistener);
            return;
        }
        catch (Exception exception)
        {
            callMethod(s, hashmap, resultlistener, true);
        }
    }

    private void connectLongPoll()
    {
        if (oss == null)
        {
            oss = new OSSListener();
        }
        longPollSocket = new VisitorLongPoll(longPollURL, account, this, oss);
    }

    private void connectSockets()
    {
        connectWebSocket();
        (new Thread(new Runnable() {

            final Chat this$0;

            public void run()
            {
                try
                {
                    Thread.sleep(5000L);
                }
                catch (InterruptedException interruptedexception)
                {
                    interruptedexception.printStackTrace();
                }
                if (activeMessageProcessor == null)
                {
                    connectLongPoll();
                    activeMessageProcessor = longPollSocket;
                }
            }

            
            {
                this$0 = Chat.this;
                super();
            }
        })).start();
    }

    private void connectWebSocket()
    {
        if (oss == null)
        {
            oss = new OSSListener();
        }
        webSocket = new VisitorWebSocket(webSocketURL, account, this, oss);
    }

    private HashMap getParamBase()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("ChatKey", chatKey);
        return hashmap;
    }

    private void updateChatValues(JSONObject jsonobject)
    {
        long l = jsonobject.optLong("VisitorID", -1L);
        long l1 = jsonobject.optLong("ChatID", -1L);
        String s = jsonobject.optString("ChatKey", null);
        long l2 = jsonobject.optLong("ClientID", -1L);
        String s1 = jsonobject.optString("WebSocketURL", null);
        String s2 = jsonobject.optString("LongPollURL", null);
        String s3 = jsonobject.optString("Answered", null);
        String s4 = jsonobject.optString("Ended", null);
        String s5 = jsonobject.optString("EndedReason", null);
        int i = jsonobject.optInt("ClientTimeout", -1);
        String s6 = jsonobject.optString("Name", null);
        String s7 = jsonobject.optString("Language", null);
        int j = jsonobject.optInt("AnswerTimeout", -1);
        if (l > 0L)
        {
            visitorID = l;
        }
        if (l1 > 0L)
        {
            chatID = l1;
        }
        if (s != null)
        {
            chatKey = s;
        }
        if (l2 > 0L)
        {
            clientID = l2;
        }
        if (s1 != null)
        {
            webSocketURL = s1;
            if (started == null)
            {
                started = new Date();
            }
        }
        if (s2 != null)
        {
            longPollURL = s2;
        }
        if (s3 != null)
        {
            answered = RequestUtil.getDateFromISO8601(s3);
        }
        if (s4 != null)
        {
            ended = RequestUtil.getDateFromISO8601(s4);
        }
        if (s5 != null)
        {
            endedReason = EndedReason.getEndedReason(s5);
        }
        if (i > 0)
        {
            clientTimeout = i;
        }
        if (s6 != null)
        {
            visitorName = s6;
        }
        if (s7 != null)
        {
            language = s7;
        }
        if (j > 0)
        {
            answerTimeout = j;
        }
    }

    public void addChatListener(ChatListener chatlistener)
    {
        synchronized (chatListeners)
        {
            chatListeners.put(chatlistener, null);
        }
        return;
        chatlistener;
        weakhashmap;
        JVM INSTR monitorexit ;
        throw chatlistener;
    }

    public void addMessageListener(ChatMessageListener chatmessagelistener)
    {
        synchronized (chatMessageListeners)
        {
            chatMessageListeners.put(chatmessagelistener, null);
        }
        return;
        chatmessagelistener;
        weakhashmap;
        JVM INSTR monitorexit ;
        throw chatmessagelistener;
    }

    public void addQueueListener(ChatQueueListener chatqueuelistener)
    {
        synchronized (chatQueueListeners)
        {
            chatQueueListeners.put(chatqueuelistener, null);
        }
        return;
        chatqueuelistener;
        weakhashmap;
        JVM INSTR monitorexit ;
        throw chatqueuelistener;
    }

    public void addTyperListener(ChatTyperListener chattyperlistener)
    {
        synchronized (chatTyperListeners)
        {
            chatTyperListeners.put(chattyperlistener, null);
        }
        return;
        chattyperlistener;
        weakhashmap;
        JVM INSTR monitorexit ;
        throw chattyperlistener;
    }

    public void changeLanguage(String s, final LanguageChangeListener languageChangeListener)
    {
        HashMap hashmap = getParamBase();
        hashmap.put("Language", s);
        callMethod("changeLanguage", hashmap, new ResultListener() {

            final Chat this$0;
            final LanguageChangeListener val$languageChangeListener;

            public void failure(int i, String s1, JSONObject jsonobject)
            {
                languageChangeListener.onLanguageChangeFailed(s1);
            }

            public void failure(IOException ioexception)
            {
            }

            public void success(JSONObject jsonobject)
            {
                Chat chat = Chat.this;
                Map map;
                if (jsonobject.optJSONObject("Brandings") == null)
                {
                    map = null;
                } else
                {
                    map = RequestUtil.getStringMap(jsonobject.optJSONObject("Brandings"));
                }
                chat.brandings = map;
                languageChangeListener.onLanguageChange(jsonobject.optString("Language"));
            }

            
            {
                this$0 = Chat.this;
                languageChangeListener = languagechangelistener;
                super();
            }
        });
    }

    public void finishChat(final ChatFinishedListener listener)
    {
        HashMap hashmap = getParamBase();
        hashmap.put("ClientID", Long.valueOf(clientID));
        if (webSocket != null)
        {
            webSocket.setCloseExpected(true);
        }
        if (longPollSocket != null)
        {
            longPollSocket.setCloseExpected(true);
        }
        callMethod("finishChat", hashmap, new ResultListener() {

            final Chat this$0;
            final ChatFinishedListener val$listener;

            public void failure(int i, String s, JSONObject jsonobject)
            {
                oss = null;
                System.err.println((new StringBuilder()).append("Failed to finish chat: ").append(i).append(": ").append(s).toString());
                listener.onChatFinished(null);
            }

            public void failure(IOException ioexception)
            {
                oss = null;
                ioexception.printStackTrace();
                listener.onChatFinished(null);
            }

            public void success(JSONObject jsonobject)
            {
                Object obj = null;
                oss = null;
                jsonobject = jsonobject.optJSONObject("PostChat");
                if (jsonobject == null)
                {
                    jsonobject = obj;
                } else
                {
                    jsonobject = new PostChat(account, Chat.this, jsonobject);
                }
                listener.onChatFinished(jsonobject);
            }

            
            {
                this$0 = Chat.this;
                listener = chatfinishedlistener;
                super();
            }
        }, true);
    }

    public int getAnswerTimeout()
    {
        return answerTimeout;
    }

    public Date getAnswered()
    {
        return answered;
    }

    public Map getBrandings()
    {
        return brandings;
    }

    public List getChatHistory()
    {
        return chatHistory;
    }

    public int getClientTimeout()
    {
        return clientTimeout;
    }

    public Date getEnded()
    {
        return ended;
    }

    public EndedReason getEndedReason()
    {
        return endedReason;
    }

    public Date getStarted()
    {
        return started;
    }

    public Map getTypers()
    {
        return typers;
    }

    public void getUnavailableForm(final ChatUnavailableListener chatUnavailableListener)
    {
        HashMap hashmap = getParamBase();
        hashmap.put("ClientID", Long.valueOf(clientID));
        callMethod("getUnavailableForm", hashmap, new ResultListener() {

            final Chat this$0;
            final ChatUnavailableListener val$chatUnavailableListener;

            public void failure(int i, String s, JSONObject jsonobject)
            {
                if (chatUnavailableListener != null)
                {
                    chatUnavailableListener.onChatUnavailableFailed(i, s);
                }
            }

            public void failure(IOException ioexception)
            {
                if (chatUnavailableListener != null)
                {
                    ChatUnavailableListener chatunavailablelistener = chatUnavailableListener;
                    String s;
                    if (ioexception.getLocalizedMessage() != null)
                    {
                        s = ioexception.getLocalizedMessage();
                    } else
                    {
                        s = ioexception.getMessage();
                    }
                    chatunavailablelistener.onChatUnavailableFailed(-1, s);
                }
                ioexception.printStackTrace();
            }

            public void success(JSONObject jsonobject)
            {
                if (chatUnavailableListener != null)
                {
                    chatUnavailableListener.onChatUnavailable(new UnavailableForm(jsonobject.optJSONObject("UnavailableForm")));
                }
            }

            
            {
                this$0 = Chat.this;
                chatUnavailableListener = chatunavailablelistener;
                super();
            }
        }, true);
    }

    public long getVisitorID()
    {
        return visitorID;
    }

    public boolean isConnected()
    {
        return oss != null && oss.isConnected() && !isTimedOut();
    }

    public boolean isEnded()
    {
        return getEnded() != null;
    }

    public boolean isTimedOut()
    {
        System.currentTimeMillis();
        return clientTimeout > 0 && System.currentTimeMillis() > lastHeartbeat + (long)(clientTimeout * 1000);
    }

    public void pingChat(boolean flag, final ChatRecaptureListener recaptureListener)
    {
        HashMap hashmap = getParamBase();
        hashmap.put("Closed", Boolean.toString(flag));
        callMethod("pingChat", hashmap, new ResultListener() {

            final Chat this$0;
            final ChatRecaptureListener val$recaptureListener;

            public void failure(int i, String s, JSONObject jsonobject)
            {
            }

            public void failure(IOException ioexception)
            {
                ioexception.printStackTrace();
            }

            public void success(JSONObject jsonobject)
            {
                if (jsonobject.optBoolean("Recapture", false) && recaptureListener != null)
                {
                    recaptureListener.onChatRecapture();
                }
            }

            
            {
                this$0 = Chat.this;
                recaptureListener = chatrecapturelistener;
                super();
            }
        });
    }

    public void removeChatListener(ChatListener chatlistener)
    {
        synchronized (chatListeners)
        {
            chatListeners.remove(chatlistener);
        }
        return;
        chatlistener;
        weakhashmap;
        JVM INSTR monitorexit ;
        throw chatlistener;
    }

    public void removeMessageListener(ChatMessageListener chatmessagelistener)
    {
        synchronized (chatMessageListeners)
        {
            chatMessageListeners.remove(chatmessagelistener);
        }
        return;
        chatmessagelistener;
        weakhashmap;
        JVM INSTR monitorexit ;
        throw chatmessagelistener;
    }

    public void removeQueueListener(ChatQueueListener chatqueuelistener)
    {
        synchronized (chatQueueListeners)
        {
            chatQueueListeners.remove(chatqueuelistener);
        }
        return;
        chatqueuelistener;
        weakhashmap;
        JVM INSTR monitorexit ;
        throw chatqueuelistener;
    }

    public void removeTyperListener(ChatTyperListener chattyperlistener)
    {
        synchronized (chatTyperListeners)
        {
            chatTyperListeners.remove(chattyperlistener);
        }
        return;
        chattyperlistener;
        weakhashmap;
        JVM INSTR monitorexit ;
        throw chattyperlistener;
    }

    public long sendMessage(String s)
    {
        long l = Math.abs(rand.nextLong() + 1L);
        sendMessage(s, l);
        return l;
    }

    public void sendMessage(String s, long l)
    {
        final HashMap params = getParamBase();
        params.put("ChatMessageID", Long.valueOf(l));
        params.put("Name", visitorName);
        params.put("Message", s);
        s = new Message(s, l, new Date(), PersonType.Visitor, visitorName);
        callMethod("sendMessage", params, new ResultListener() {

            final Chat this$0;
            final HashMap val$params;

            public void failure(int i, String s1, JSONObject jsonobject)
            {
                synchronized (retryQueue)
                {
                    retryQueue.add(new RPCMethod("sendMessage", params, this));
                    if (retryThread == null)
                    {
                        (new Thread(retryThread = new MethodRetry())).start();
                    }
                }
                return;
                jsonobject;
                s1;
                JVM INSTR monitorexit ;
                throw jsonobject;
            }

            public void failure(IOException ioexception)
            {
                if (ioexception.getLocalizedMessage() != null)
                {
                    ioexception = ioexception.getLocalizedMessage();
                } else
                {
                    ioexception = ioexception.getMessage();
                }
                failure(-1, ((String) (ioexception)), null);
            }

            public void success(JSONObject jsonobject)
            {
            }

            
            {
                this$0 = Chat.this;
                params = hashmap;
                super();
            }
        });
        WeakHashMap weakhashmap = chatMessageListeners;
        weakhashmap;
        JVM INSTR monitorenter ;
        for (Iterator iterator = (new HashSet(chatMessageListeners.keySet())).iterator(); iterator.hasNext(); ((ChatMessageListener)iterator.next()).onPreliminaryMessageAdded(s)) { }
        break MISSING_BLOCK_LABEL_148;
        s;
        weakhashmap;
        JVM INSTR monitorexit ;
        throw s;
        weakhashmap;
        JVM INSTR monitorexit ;
    }

    public void setVisitorTyping(boolean flag)
    {
        if (visitorTyping != flag)
        {
            visitorTyping = flag;
            HashMap hashmap = getParamBase();
            hashmap.put("IsTyping", Boolean.valueOf(flag));
            callMethod("visitorTyping", hashmap, null);
        }
    }

    public void startChat(ChatStartListener chatstartlistener)
    {
        if (clientID > 0L && webSocketURL != null)
        {
            (new Thread(new Runnable() {

                final Chat this$0;

                public void run()
                {
                    connectSockets();
                }

            
            {
                this$0 = Chat.this;
                super();
            }
            })).start();
            if (chatstartlistener != null)
            {
                chatstartlistener.onChatStarted();
            }
            return;
        } else
        {
            callMethod("startChat", getParamBase(), new StartChatResultListener(chatstartlistener));
            return;
        }
    }

    public void submitPostChat(final Form postChat, final PostChatSubmitListener submitListener)
    {
        HashMap hashmap = getParamBase();
        JSONObject jsonobject = new JSONObject();
        Iterator iterator = postChat.getFormFields().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FormField formfield = (FormField)iterator.next();
            String s = formfield.getKey();
            String s1 = formfield.getValue();
            if (s != null && s1 != null && s.length() > 0 && s1.length() > 0)
            {
                jsonobject.put(formfield.getKey(), formfield.getValue());
            }
        } while (true);
        hashmap.put("Data", jsonobject);
        callMethod("submitPostChat", hashmap, new ResultListener() {

            final Chat this$0;
            final Form val$postChat;
            final PostChatSubmitListener val$submitListener;

            public void failure(int i, String s2, JSONObject jsonobject1)
            {
                oss = null;
                System.err.println((new StringBuilder()).append("Failed to finish chat: ").append(i).append(": ").append(s2).toString());
                submitListener.onPostChatSubmitFailed(postChat, s2);
            }

            public void failure(IOException ioexception)
            {
                ioexception.printStackTrace();
                PostChatSubmitListener postchatsubmitlistener = submitListener;
                Form form = postChat;
                if (ioexception.getLocalizedMessage() != null)
                {
                    ioexception = ioexception.getLocalizedMessage();
                } else
                {
                    ioexception = ioexception.getMessage();
                }
                postchatsubmitlistener.onPostChatSubmitFailed(form, ioexception);
            }

            public void success(JSONObject jsonobject1)
            {
                submitListener.onPostChatSubmitted(postChat);
            }

            
            {
                this$0 = Chat.this;
                submitListener = postchatsubmitlistener;
                postChat = form;
                super();
            }
        });
    }

    public void submitPreChat(Form form, ChatStartListener chatstartlistener)
    {
        HashMap hashmap = getParamBase();
        JSONObject jsonobject = new JSONObject();
        form = form.getFormFields().iterator();
        do
        {
            if (!form.hasNext())
            {
                break;
            }
            FormField formfield = (FormField)form.next();
            String s = formfield.getKey();
            String s1 = formfield.getValue();
            if (s != null && s1 != null && s.length() > 0 && s1.length() > 0)
            {
                jsonobject.put(formfield.getKey(), formfield.getValue());
            }
        } while (true);
        hashmap.put("Data", jsonobject);
        callMethod("submitPreChat", hashmap, new StartChatResultListener(chatstartlistener));
    }

    public void submitUnavailableEmail(Form form)
    {
        HashMap hashmap = getParamBase();
        form = form.getFormFields().iterator();
        do
        {
            if (!form.hasNext())
            {
                break;
            }
            FormField formfield = (FormField)form.next();
            if ("email".equals(formfield.getKey()))
            {
                hashmap.put("From", formfield.getValue());
            } else
            if ("subject".equals(formfield.getKey()))
            {
                hashmap.put("Subject", formfield.getValue());
            } else
            if ("body".equals(formfield.getKey()))
            {
                hashmap.put("Body", formfield.getValue());
            }
        } while (true);
        callMethod("submitUnavailableEmail", hashmap, null);
    }






/*
    static VisitorWebSocket access$1202(Chat chat, VisitorWebSocket visitorwebsocket)
    {
        chat.webSocket = visitorwebsocket;
        return visitorwebsocket;
    }

*/


/*
    static String access$1302(Chat chat, String s)
    {
        chat.webSocketURL = s;
        return s;
    }

*/



/*
    static String access$1502(Chat chat, String s)
    {
        chat.longPollURL = s;
        return s;
    }

*/


/*
    static long access$1602(Chat chat, long l)
    {
        chat.clientID = l;
        return l;
    }

*/







/*
    static MethodRetry access$202(Chat chat, MethodRetry methodretry)
    {
        chat.retryThread = methodretry;
        return methodretry;
    }

*/






/*
    static Date access$2402(Chat chat, Date date)
    {
        chat.ended = date;
        return date;
    }

*/


/*
    static EndedReason access$2502(Chat chat, EndedReason endedreason)
    {
        chat.endedReason = endedreason;
        return endedreason;
    }

*/




/*
    static long access$2802(Chat chat, long l)
    {
        chat.lastHeartbeat = l;
        return l;
    }

*/



/*
    static long access$2902(Chat chat, long l)
    {
        chat.retrySleep = l;
        return l;
    }

*/


/*
    static long access$2908(Chat chat)
    {
        long l = chat.retrySleep;
        chat.retrySleep = 1L + l;
        return l;
    }

*/



/*
    static OSSListener access$402(Chat chat, OSSListener osslistener)
    {
        chat.oss = osslistener;
        return osslistener;
    }

*/



/*
    static Map access$602(Chat chat, Map map)
    {
        chat.brandings = map;
        return map;
    }

*/



/*
    static VisitorMessageProcessor access$702(Chat chat, VisitorMessageProcessor visitormessageprocessor)
    {
        chat.activeMessageProcessor = visitormessageprocessor;
        return visitormessageprocessor;
    }

*/




/*
    static VisitorLongPoll access$902(Chat chat, VisitorLongPoll visitorlongpoll)
    {
        chat.longPollSocket = visitorlongpoll;
        return visitorlongpoll;
    }

*/
}
