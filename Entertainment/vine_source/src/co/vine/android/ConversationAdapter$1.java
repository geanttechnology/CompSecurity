// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import co.vine.android.api.VinePrivateMessage;

// Referenced classes of package co.vine.android:
//            ConversationAdapter, ConversationActivity

class 
    implements android.view.er
{

    final ConversationAdapter this$0;
    final VinePrivateMessage val$vpm;

    public boolean onLongClick(View view)
    {
        ConversationAdapter.access$000(ConversationAdapter.this).showDeleteMessageDialog(val$vpm.messageId);
        return true;
    }

    ()
    {
        this$0 = final_conversationadapter;
        val$vpm = VinePrivateMessage.this;
        super();
    }
}
