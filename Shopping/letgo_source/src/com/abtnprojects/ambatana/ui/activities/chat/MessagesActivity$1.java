// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.abtnprojects.ambatana.models.chat.Conversation;
import com.abtnprojects.ambatana.models.chat.Message;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.user.User;
import com.parse.ParseUser;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.chat:
//            MessagesActivity

class a extends BroadcastReceiver
{

    final MessagesActivity a;

    public void onReceive(Context context, Intent intent)
    {
        String s;
        Object obj;
        context = null;
        obj = intent.getExtras();
        intent = (Message)((Bundle) (obj)).getParcelable("message_extra");
        s = ParseUser.getCurrentUser().getObjectId();
        obj = ((Bundle) (obj)).getString("product_id");
        break MISSING_BLOCK_LABEL_35;
        if (MessagesActivity.a(a) != null && MessagesActivity.a(a).getOwner() != null)
        {
            context = MessagesActivity.a(a).getOwner().getId();
        }
        if (MessagesActivity.a(a) != null && obj != null && ((String) (obj)).equals(MessagesActivity.a(a).getId()) && MessagesActivity.b(a) != null)
        {
            User user = MessagesActivity.b(a).getUserToDisplay();
            intent.setUserAvatarUrl(user.getAvatarUrl());
            intent.setUserName(user.getName());
            if (context == null || !context.equals(s) || intent.getUserId().equals(user.getId()))
            {
                intent.setUserId(user.getId());
                a.a(intent);
                return;
            }
        }
        return;
    }

    (MessagesActivity messagesactivity)
    {
        a = messagesactivity;
        super();
    }
}
