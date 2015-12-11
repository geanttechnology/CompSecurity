// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.util.Log;
import com.boldchat.visitor.api.Chat;
import java.util.Date;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession, BoldChatState, BoldChatViewManager

private class mChat
    implements Runnable
{

    private Chat mChat;
    private long mLastPing;
    private boolean mRunning;
    final BoldChatSession this$0;

    public void run()
    {
_L3:
        long l;
        if (!mRunning || mChat == null || BoldChatSession.access$2200(BoldChatSession.this) != this || BoldChatSession.access$1500().ordinal() > BoldChatState.ChatActive.ordinal())
        {
            break MISSING_BLOCK_LABEL_311;
        }
        l = 5000L;
        if (mChat != null && mLastPing + 30000L > System.currentTimeMillis())
        {
            Log.d("BOLD", "Pinging Chat");
            mLastPing = System.currentTimeMillis();
            mChat.pingChat(false, null);
        }
        if (BoldChatSession.access$1500() == BoldChatState.ChatActive && mChat != null && mChat.getAnswerTimeout() > 0 && mChat.getStarted() != null && mChat.getAnswered() == null && System.currentTimeMillis() > mChat.getStarted().getTime() + (long)(mChat.getAnswerTimeout() * 1000))
        {
            stopRunning();
            BoldChatSession.access$500(BoldChatSession.this).setState(BoldChatState.ChatInactive);
            mChat.getUnavailableForm(BoldChatSession.access$1700(BoldChatSession.this));
        }
        if (mChat != null && mChat.getStarted() != null && mChat.getAnswered() != null && mChat.getEnded() == null && mChat.isTimedOut())
        {
            endChat(false);
            BoldChatSession.access$2500(BoldChatSession.this, BoldChatSession.access$600(BoldChatSession.this, "api#chat#disconnected"));
            stopRunning();
        }
        if (mChat.getAnswered() != null)
        {
            l = 30000L;
        }
        this;
        JVM INSTR monitorenter ;
        wait(l);
_L1:
        this;
        JVM INSTR monitorexit ;
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        ((InterruptedException) (obj)).printStackTrace();
          goto _L1
        Log.d("BOLD", "Chat pinger stopped");
        return;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public void stopRunning()
    {
        mRunning = false;
        this;
        JVM INSTR monitorenter ;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public (Chat chat)
    {
        this$0 = BoldChatSession.this;
        super();
        mRunning = true;
        mLastPing = 0L;
        mChat = chat;
    }
}
