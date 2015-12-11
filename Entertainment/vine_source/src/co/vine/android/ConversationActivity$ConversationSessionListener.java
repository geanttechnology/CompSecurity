// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.support.v4.app.FragmentManager;
import android.view.Menu;
import co.vine.android.api.VineRTCConversation;
import co.vine.android.api.VineRTCParticipant;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import com.edisonwang.android.slog.SLog;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            ConversationActivity, VineWebSocketClient, ConversationFragment

private class <init> extends AppSessionListener
{

    final ConversationActivity this$0;

    private void showTypingIndicator(final boolean show, final long userId)
    {
        runOnUiThread(new Runnable() {

            final ConversationActivity.ConversationSessionListener this$1;
            final boolean val$show;
            final long val$userId;

            public void run()
            {
                android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentByTag("conversationFragment");
                if (fragment instanceof ConversationFragment)
                {
                    ((ConversationFragment)fragment).showTypingIndicator(show, userId);
                }
            }

            
            {
                this$1 = ConversationActivity.ConversationSessionListener.this;
                show = flag;
                userId = l;
                super();
            }
        });
    }

    public void onFollowComplete(String s, int i, String s1, long l)
    {
        if (i == 200 && ConversationActivity.access$1100(ConversationActivity.this) == l && mMenu != null)
        {
            mMenu.removeItem(0x7f0a0241);
        }
    }

    public void onGetConversationRemoteIdComplete(long l)
    {
        ConversationActivity.access$902(ConversationActivity.this, l);
        if (ConversationActivity.access$1000(ConversationActivity.this))
        {
            SLog.dWithTag("ConvActivity;RTC", (new StringBuilder()).append("Subscribing to conversation=").append(ConversationActivity.access$900(ConversationActivity.this)).toString());
            ConversationActivity.access$200(ConversationActivity.this).subscribeConversation(ConversationActivity.access$900(ConversationActivity.this));
        }
    }

    public void onReceiveRTCMessage(ArrayList arraylist)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            Object obj = (VineRTCConversation)arraylist.next();
            if (((VineRTCConversation) (obj)).conversationId == ConversationActivity.access$900(ConversationActivity.this))
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
                        if (l > ConversationActivity.access$1200(ConversationActivity.this))
                        {
                            mAppController.fetchConversation(1, false, 0L, ConversationActivity.access$1300(ConversationActivity.this), false);
                            android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentByTag("conversationFragment");
                            if (fragment instanceof ConversationFragment)
                            {
                                ((ConversationFragment)fragment).onNewMessage();
                            }
                        }
                        ConversationActivity.access$1202(ConversationActivity.this, l);
                    }
                }
            }
        }

    }

    public void onWebSocketConnectComplete()
    {
        if (ConversationActivity.access$900(ConversationActivity.this) > 0L)
        {
            SLog.dWithTag("ConvActivity;RTC", (new StringBuilder()).append("Subscribing to conversation=").append(ConversationActivity.access$900(ConversationActivity.this)).toString());
            ConversationActivity.access$200(ConversationActivity.this).subscribeConversation(ConversationActivity.access$900(ConversationActivity.this));
        }
    }

    public void onWebSocketDisconnected()
    {
        showTypingIndicator(false, -1L);
        ConversationActivity.access$600(ConversationActivity.this);
    }

    private _cls1.val.userId()
    {
        this$0 = ConversationActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
