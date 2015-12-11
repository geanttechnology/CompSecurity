// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.boldchat.visitor.api.ChatAvailabilityListener;
import com.boldchat.visitor.api.UnavailableReason;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.models.nst.LiveChatExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.livechat.LiveChatUtil;
import com.groupon.util.livechat.OnLiveChatSessionFinishListener;
import com.groupon.util.livechat.OnLiveChatUnreadMessageCountChangeListener;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class LiveChatView extends RelativeLayout
{
    private class ChatSessionClickListener
        implements android.view.View.OnClickListener
    {

        final LiveChatView this$0;

        public void onClick(View view)
        {
            getContext().startActivity(intentFactory.newLiveChatIntent());
            logger.logClick("", "live_chat_click", liveChatUtil.channel.toString(), new LiveChatExtraInfo(liveChatUtil.pageId, liveChatUtil.dealId), Logger.NULL_NST_FIELD);
        }

        private ChatSessionClickListener()
        {
            this$0 = LiveChatView.this;
            super();
        }

    }

    private class OnLiveChatViewSessionFinishListener
        implements OnLiveChatSessionFinishListener
    {

        final LiveChatView this$0;

        public void onLiveChatSessionFinish()
        {
            liveChatUtil.setupLiveChatSessionWithoutUI(setChatAvailabilityListenerOnChatNotActive());
        }

        private OnLiveChatViewSessionFinishListener()
        {
            this$0 = LiveChatView.this;
            super();
        }

    }

    private class OnUnreadMessageCountChangeListener
        implements OnLiveChatUnreadMessageCountChangeListener
    {

        final LiveChatView this$0;

        public void onUnreadMessageCountChange()
        {
            updateViewOnChatActive();
        }

        private OnUnreadMessageCountChangeListener()
        {
            this$0 = LiveChatView.this;
            super();
        }

    }


    private static final String CLICK_TYPE_LIVE_CHAT_LIVE_CHAT_CLICK = "live_chat_click";
    private TextView agentAvailableView;
    private final Drawable background;
    private RelativeLayout chatSection;
    private ChatSessionClickListener chatSessionClickListener;
    private final int icon;
    private final int iconPadding;
    private TextView inProgressView;
    private IntentFactory intentFactory;
    private LiveChatUtil liveChatUtil;
    private Logger logger;
    private final int marginTop;
    private final int sectionPaddingLeft;
    private final int sectionPaddingRight;
    private final int sectionPaddingTopBottom;
    private final int titleTextColor;
    private final int titleTextSize;
    private TextView unreadMessageCountView;

    public LiveChatView(Context context)
    {
        this(context, null, 0);
    }

    public LiveChatView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public LiveChatView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        chatSessionClickListener = new ChatSessionClickListener();
        attributeset = context.obtainStyledAttributes(attributeset, com.groupon.R.styleable.LiveChat, 0, 0);
        titleTextColor = attributeset.getColor(0, getResources().getColor(0x7f0e00ee));
        titleTextSize = attributeset.getDimensionPixelSize(1, (int)getResources().getDimension(0x7f0b0185));
        iconPadding = attributeset.getDimensionPixelOffset(2, (int)getResources().getDimension(0x7f0b017d));
        marginTop = attributeset.getDimensionPixelSize(3, (int)getResources().getDimension(0x7f0b0183));
        sectionPaddingLeft = attributeset.getDimensionPixelSize(4, (int)getResources().getDimension(0x7f0b017f));
        sectionPaddingTopBottom = attributeset.getDimensionPixelSize(5, (int)getResources().getDimension(0x7f0b017f));
        sectionPaddingRight = attributeset.getDimensionPixelSize(6, (int)getResources().getDimension(0x7f0b017f));
        icon = attributeset.getResourceId(7, 0x7f020221);
        background = attributeset.getDrawable(8);
        attributeset.recycle();
        LayoutInflater.from(getContext()).inflate(0x7f030151, this, true);
        if (!isInEditMode())
        {
            RoboGuice.getInjector(context).injectMembers(this);
            chatSection = (RelativeLayout)findViewById(0x7f1003d9);
            agentAvailableView = (TextView)findViewById(0x7f1003db);
            inProgressView = (TextView)findViewById(0x7f1003dd);
            unreadMessageCountView = (TextView)findViewById(0x7f1003de);
            context = (TextView)findViewById(0x7f1003da);
            context.setTextColor(titleTextColor);
            context.setTextSize(0, titleTextSize);
            context.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
            context.setCompoundDrawablePadding(iconPadding);
            chatSection.setBackground(background);
            context = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            context.setMargins(0, marginTop, 0, 0);
            chatSection.setLayoutParams(context);
            chatSection.setPadding(sectionPaddingLeft, sectionPaddingTopBottom, sectionPaddingRight, sectionPaddingTopBottom);
        }
    }

    private ChatAvailabilityListener setChatAvailabilityListenerOnChatNotActive()
    {
        return new ChatAvailabilityListener() {

            final LiveChatView this$0;

            public void onChatAvailabilityFailed(int i, String s)
            {
                setVisibility(8);
            }

            public void onChatAvailable()
            {
                agentAvailableView.setVisibility(0);
                inProgressView.setVisibility(8);
                unreadMessageCountView.setVisibility(8);
                setVisibility(0);
                chatSection.setOnClickListener(chatSessionClickListener);
            }

            public void onChatUnavailable(UnavailableReason unavailablereason)
            {
                setVisibility(8);
            }

            
            {
                this$0 = LiveChatView.this;
                super();
            }
        };
    }

    private void updateViewOnChatActive()
    {
        int i = liveChatUtil.getUnreadMessageCount();
        agentAvailableView.setVisibility(8);
        inProgressView.setVisibility(0);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)inProgressView.getLayoutParams();
        if (i == 0)
        {
            unreadMessageCountView.setVisibility(8);
            layoutparams.addRule(0, 0x7f1003dc);
        } else
        {
            layoutparams.addRule(0, 0x7f1003de);
            unreadMessageCountView.setVisibility(0);
            unreadMessageCountView.setText(Integer.toString(i));
        }
        setVisibility(0);
        chatSection.setOnClickListener(chatSessionClickListener);
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (!isInEditMode())
        {
            liveChatUtil.onUnreadMessageCountChangeListener = new OnUnreadMessageCountChangeListener();
            liveChatUtil.onLiveChatViewSessionEndOrCloseListener = new OnLiveChatViewSessionFinishListener();
        }
    }

    public void onDetachedFromWindow()
    {
        if (!isInEditMode())
        {
            liveChatUtil.onUnreadMessageCountChangeListener = null;
            liveChatUtil.onLiveChatViewSessionEndOrCloseListener = null;
        }
        super.onDetachedFromWindow();
    }

    public void updateLiveChatSection(boolean flag)
    {
        ChatAvailabilityListener chatavailabilitylistener = null;
        if (flag)
        {
            liveChatUtil.apiKey = "888454639756334259:880565403828478759:/DWRJNvE6LVkletA4GdIdxl8XqTcQ5tg";
        } else
        {
            liveChatUtil.apiKey = "888454639756334259:880411663045363240:Ztg93GpPSS5R/W0qFfYWISVEkg88q9WL";
        }
        if (liveChatUtil.liveChatSession != null && liveChatUtil.isChatActive())
        {
            updateViewOnChatActive();
        } else
        {
            chatavailabilitylistener = setChatAvailabilityListenerOnChatNotActive();
        }
        liveChatUtil.setupLiveChatSessionWithoutUI(chatavailabilitylistener);
    }










}
