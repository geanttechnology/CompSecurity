// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util.livechat;

import android.app.Application;
import android.text.Html;
import com.boldchat.sdk.BoldChatSession;
import com.boldchat.sdk.BoldChatView;
import com.boldchat.sdk.utils.OnPreChatFormSubmitListener;
import com.boldchat.visitor.api.ChatAvailabilityListener;
import com.groupon.Channel;
import com.groupon.models.nst.LiveChatExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LoggingUtils;
import com.groupon.util.NotificationFactory;
import java.util.Date;
import roboguice.inject.ContextScopedProvider;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.util.livechat:
//            OnLiveChatSessionFinishListener, OnLiveChatUnreadMessageCountChangeListener, LiveChatPreFormListener

public class LiveChatUtil
    implements com.boldchat.sdk.BoldChatSession.BoldChatSessionListener
{
    private class OnLiveChatPreChatFormSubmitListener
        implements OnPreChatFormSubmitListener
    {

        final LiveChatUtil this$0;

        public void onPreChatFormSubmit()
        {
            logger.logClick("", "start_chat_click", channel.toString(), new LiveChatExtraInfo(pageId, dealId), Logger.NULL_NST_FIELD);
        }

        private OnLiveChatPreChatFormSubmitListener()
        {
            this$0 = LiveChatUtil.this;
            super();
        }

    }


    private static final String CLICK_TYPE_LIVE_CHAT_START_CHAT_CLICK = "start_chat_click";
    public String apiKey;
    private Application application;
    public Channel channel;
    public String dealId;
    public String dealUrl;
    public BoldChatSession liveChatSession;
    private Logger logger;
    private LoggingUtils loggingUtils;
    private ContextScopedProvider notificationFactoryProvider;
    public OnLiveChatSessionFinishListener onLiveChatActivitySessionCloseListener;
    public OnLiveChatSessionFinishListener onLiveChatActivitySessionEndListener;
    public OnLiveChatSessionFinishListener onLiveChatViewSessionEndOrCloseListener;
    public OnLiveChatUnreadMessageCountChangeListener onUnreadMessageCountChangeListener;
    public String pageId;
    private boolean sendChatNotifications;
    private int unreadMessageCount;

    public LiveChatUtil()
    {
        sendChatNotifications = false;
        unreadMessageCount = 0;
    }

    public void chatSessionClosed()
    {
        if (onLiveChatActivitySessionCloseListener != null)
        {
            onLiveChatActivitySessionCloseListener.onLiveChatSessionFinish();
        }
        if (onLiveChatViewSessionEndOrCloseListener != null)
        {
            onLiveChatViewSessionEndOrCloseListener.onLiveChatSessionFinish();
        }
    }

    public void chatSessionCreated()
    {
    }

    public void chatSessionEnded()
    {
        unreadMessageCount = 0;
        if (onUnreadMessageCountChangeListener != null)
        {
            onUnreadMessageCountChangeListener.onUnreadMessageCountChange();
        }
        if (onLiveChatActivitySessionEndListener != null)
        {
            onLiveChatActivitySessionEndListener.onLiveChatSessionFinish();
        }
        if (onLiveChatViewSessionEndOrCloseListener != null)
        {
            onLiveChatViewSessionEndOrCloseListener.onLiveChatSessionFinish();
        }
    }

    public void chatSessionStarted()
    {
    }

    public int getUnreadMessageCount()
    {
        return unreadMessageCount;
    }

    public boolean isChatActive()
    {
        return liveChatSession.isChatActive();
    }

    public void messageArrived(String s, String s1, Date date)
    {
        if (sendChatNotifications)
        {
            unreadMessageCount = unreadMessageCount + 1;
            if (onUnreadMessageCountChangeListener != null)
            {
                onUnreadMessageCountChangeListener.onUnreadMessageCountChange();
            }
            ((NotificationFactory)notificationFactoryProvider.get(application)).sendLiveChatNotification(application, Html.fromHtml(s).toString(), unreadMessageCount);
            return;
        } else
        {
            Ln.d("Live chat no notification", new Object[0]);
            return;
        }
    }

    public void operatorTyping()
    {
    }

    public void pauseLiveChatNotification()
    {
        sendChatNotifications = false;
    }

    public void setupLiveChatSessionWithUI(BoldChatView boldchatview, String s, String s1)
    {
        s = new LiveChatPreFormListener(application, loggingUtils, s, s1, pageId, dealId, dealUrl);
        liveChatSession = (new com.boldchat.sdk.BoldChatSession.Builder(boldchatview, apiKey)).setChatFormListener(s).setHideKeyboardOnSend(true).build();
        boldchatview = new OnLiveChatPreChatFormSubmitListener();
        liveChatSession.setOnPreChatFormSubmitListener(boldchatview).setListener(this);
    }

    public void setupLiveChatSessionWithoutUI(ChatAvailabilityListener chatavailabilitylistener)
    {
        liveChatSession = (new com.boldchat.sdk.BoldChatSession.Builder(application, apiKey)).build();
        if (chatavailabilitylistener != null)
        {
            liveChatSession.getChatAvailability(chatavailabilitylistener);
        }
        liveChatSession.setListener(this);
    }

    public void startLiveChatNotification()
    {
        sendChatNotifications = true;
        unreadMessageCount = 0;
        if (onUnreadMessageCountChangeListener != null)
        {
            onUnreadMessageCountChangeListener.onUnreadMessageCountChange();
        }
    }

}
