// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.chat;

import android.content.Intent;
import android.support.v7.aqo;
import android.support.v7.hq;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.abtnprojects.ambatana.models.chat.Conversation;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.chat:
//            UserMessagesListActivity, MessagesActivity

class a
    implements android.widget.ener
{

    final UserMessagesListActivity a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (Conversation)UserMessagesListActivity.a(a).getItem(i);
        view = adapterview.getProduct();
        if (view != null)
        {
            Intent intent = new Intent(a.getApplicationContext(), com/abtnprojects/ambatana/ui/activities/chat/MessagesActivity);
            intent.putExtra("conversation_message", adapterview.getId());
            intent.putExtra("product", view);
            intent.putExtra("conversation", adapterview);
            intent.putExtra("origin_activity", 0);
            a.startActivity(intent);
            return;
        } else
        {
            Toast.makeText(a, a.getString(0x7f090148), 0).show();
            aqo.d("Product not found for conversation : %d", new Object[] {
                adapterview.getId()
            });
            return;
        }
    }

    (UserMessagesListActivity usermessageslistactivity)
    {
        a = usermessageslistactivity;
        super();
    }
}
