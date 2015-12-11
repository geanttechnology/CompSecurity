// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.os.Handler;
import android.os.Looper;
import com.inc247.errors.ChatSDKError;
import org.json.JSONObject;

// Referenced classes of package com.inc247:
//            ChatSDKEventsListener

public class ChatSDKEventsCallback
{

    private static ChatSDKEventsCallback self = null;
    private ChatSDKEventsListener listener;

    private ChatSDKEventsCallback()
    {
        listener = null;
    }

    public static ChatSDKEventsCallback getInstance()
    {
        if (self == null)
        {
            self = new ChatSDKEventsCallback();
        }
        return self;
    }

    public void sendOnChatStartedEvent(final JSONObject data)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final ChatSDKEventsCallback this$0;
            private final JSONObject val$data;

            public void run()
            {
                ChatSDKEventsCallback.self.listener.onChatStarted(data);
            }

            
            {
                this$0 = ChatSDKEventsCallback.this;
                data = jsonobject;
                super();
            }
        });
    }

    public void sendonAgentMessageEvent(final JSONObject data)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final ChatSDKEventsCallback this$0;
            private final JSONObject val$data;

            public void run()
            {
                ChatSDKEventsCallback.self.listener.onAgentMessage(data);
            }

            
            {
                this$0 = ChatSDKEventsCallback.this;
                data = jsonobject;
                super();
            }
        });
    }

    public void sendonChatAgentAvailabilityEvent(final boolean isAvailable)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final ChatSDKEventsCallback this$0;
            private final boolean val$isAvailable;

            public void run()
            {
                ChatSDKEventsCallback.self.listener.onChatAgentAvailability(isAvailable);
            }

            
            {
                this$0 = ChatSDKEventsCallback.this;
                isAvailable = flag;
                super();
            }
        });
    }

    public void sendonChatEndedEvent(final JSONObject data)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final ChatSDKEventsCallback this$0;
            private final JSONObject val$data;

            public void run()
            {
                ChatSDKEventsCallback.self.listener.onChatEnded(data);
            }

            
            {
                this$0 = ChatSDKEventsCallback.this;
                data = jsonobject;
                super();
            }
        });
    }

    public void sendonChatErrorEvent(final ChatSDKError data)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final ChatSDKEventsCallback this$0;
            private final ChatSDKError val$data;

            public void run()
            {
                ChatSDKEventsCallback.self.listener.onChatError(data);
            }

            
            {
                this$0 = ChatSDKEventsCallback.this;
                data = chatsdkerror;
                super();
            }
        });
    }

    public void sendonChatMaximizedEvent(final JSONObject data)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final ChatSDKEventsCallback this$0;
            private final JSONObject val$data;

            public void run()
            {
                ChatSDKEventsCallback.self.listener.onChatMaximized(data);
            }

            
            {
                this$0 = ChatSDKEventsCallback.this;
                data = jsonobject;
                super();
            }
        });
    }

    public void sendonChatMinimizedEvent(final JSONObject data)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final ChatSDKEventsCallback this$0;
            private final JSONObject val$data;

            public void run()
            {
                ChatSDKEventsCallback.self.listener.onChatMinimized(data);
            }

            
            {
                this$0 = ChatSDKEventsCallback.this;
                data = jsonobject;
                super();
            }
        });
    }

    public void sendonNavigationRequest(final JSONObject data)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final ChatSDKEventsCallback this$0;
            private final JSONObject val$data;

            public void run()
            {
                ChatSDKEventsCallback.self.listener.onNavigationRequest(data);
            }

            
            {
                this$0 = ChatSDKEventsCallback.this;
                data = jsonobject;
                super();
            }
        });
    }

    public void sendonQueueIdParamRetrievalFinished()
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final ChatSDKEventsCallback this$0;

            public void run()
            {
                ChatSDKEventsCallback.self.listener.onQueueIdParamRetrievalFinished();
            }

            
            {
                this$0 = ChatSDKEventsCallback.this;
                super();
            }
        });
    }

    public void sendonQueueIdParamRetrievalStarted()
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final ChatSDKEventsCallback this$0;

            public void run()
            {
                ChatSDKEventsCallback.self.listener.onQueueIdParamRetrievalStarted();
            }

            
            {
                this$0 = ChatSDKEventsCallback.this;
                super();
            }
        });
    }

    public void setChatEventsListener(ChatSDKEventsListener chatsdkeventslistener)
    {
        self.listener = chatsdkeventslistener;
    }



}
