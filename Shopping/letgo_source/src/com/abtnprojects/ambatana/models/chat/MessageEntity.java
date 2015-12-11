// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.chat;

import com.abtnprojects.ambatana.models.user.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.models.chat:
//            DateFormatter, ApiMessage, Message

public class MessageEntity
{

    private final DateFormatter dateFormatter = new DateFormatter();

    public MessageEntity()
    {
    }

    public Message transform(ApiMessage apimessage, User user, User user1)
    {
        String s = null;
        if (apimessage == null || user == null || user1 == null)
        {
            return null;
        }
        java.util.Date date = dateFormatter.getFormattedDate(apimessage.getCreatedAt());
        if (apimessage.getUserId().equals(user.getId()))
        {
            s = user.getAvatarUrl();
            user1 = user.getName();
            user = s;
        } else
        if (apimessage.getUserId().equals(user1.getId()))
        {
            user = user1.getAvatarUrl();
            user1 = user1.getName();
        } else
        {
            user = null;
            user1 = s;
        }
        return new Message(apimessage.getId(), apimessage.getText(), apimessage.getType(), date, apimessage.getUserId(), user, user1);
    }

    public List transform(List list, User user, User user1)
    {
        if (list == null)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Message message = transform((ApiMessage)list.next(), user, user1);
            if (message != null)
            {
                arraylist.add(message);
            }
        } while (true);
        return arraylist;
    }
}
